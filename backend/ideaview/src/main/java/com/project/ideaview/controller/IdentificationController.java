package com.project.ideaview.controller;

import com.project.ideaview.dto.IdentificationDto;
import com.project.ideaview.dto.RegisterDto;
import com.project.ideaview.manager.JwtTokenManager;
import com.project.ideaview.manager.Random;
import com.project.ideaview.manager.WsException;
import com.project.ideaview.model.Users;
import com.project.ideaview.service.RoleService;
import com.project.ideaview.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/open")
public class IdentificationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = Logger.getLogger(IdentificationController.class.getName());

    /**
     * La méthode elle permet de connecter un utilisateur
     * @return
     * <ul>
     *     <li><b>Exception</b> si l'email ou mdp n'existe pas</li>
     *     <li><b>token</b> si l'email et le mdp existent</li>
     * </ul>
     */
    @PostMapping("/login")
    public Map<String, String> identification(@RequestBody IdentificationDto identificationDto) {

        String msgError = "L'email ou le mot de passe est incorrect";

        // vérifier si l'email existe
        Users users = usersService.findByEmail(identificationDto.getEmail());
        if (users == null) {
            throw new WsException(HttpStatus.NOT_FOUND,msgError);
        }

        // vérifier si le mdp correspond
        if (!this.bCryptPasswordEncoder.matches(identificationDto.getPassword(), users.getPassword())) {
            throw new WsException(HttpStatus.NOT_FOUND,msgError);
        }

        // Crypter le token
        logger.info("L'utilisateur "+users.getEmail()+" s'est connecté");

        // Crypter le token
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));
    }

    /**
     * La méthode qui permet d'enregister un nouvel utilisateur
     * @param registerDto
     * @return
     * <ul>
     *     <li><b>Exception</b> si l'email existe ....</li>
     *     <li><b>token</b> si l'utilisateur et bien enregister</li>
     * </ul>
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody RegisterDto registerDto) {
        if (registerDto.getPassword().length() <= 8){
            throw new WsException(HttpStatus.BAD_REQUEST, "Le mot de passe doit contenir au moins 8 caractères");
        }

        // vérifier si l'email existe
        Users users = usersService.findByEmail(registerDto.getEmail());
        if (users != null) {
            throw new WsException(HttpStatus.BAD_REQUEST, "Cet email existe déja");
        }

        // Crypter le mot de passe
        users = registerDto.getUser();
        users.setPassword(this.bCryptPasswordEncoder.encode(registerDto.getPassword()));
        users.setRoles(List.of(roleService.save("USER")));

        // générer un token user
        do {
            users.setToken(Random.getRandomStr(50));
        }while (usersService.findByToken(users.getToken()) != null);


        usersService.save(users);

        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));

    }
}
