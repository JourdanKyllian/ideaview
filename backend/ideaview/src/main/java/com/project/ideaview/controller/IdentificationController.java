package com.project.ideaview.controller;

import com.project.ideaview.dto.IdentificationDto;
import com.project.ideaview.dto.UserDto;
import com.project.ideaview.manager.JwtTokenManager;
import com.project.ideaview.manager.Random;
import com.project.ideaview.manager.WsException;
import com.project.ideaview.model.Users;
import com.project.ideaview.service.RoleService;
import com.project.ideaview.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/open")
//@CrossOrigin(origins = "http://localhost:4200")
public class IdentificationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * La méthode elle permet de récupérer l'email et le mdp de l'utilisateur
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
        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));
    }

    /**
     * La méthode qui permet d'enregister un nouvel utilisateur
     * @param userDto
     * @return
     * <ul>
     *     <li><b>Exception</b> si l'email existe ....</li>
     *     <li><b>token</b> si l'utilisateur et bien enregister</li>
     * </ul>
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserDto userDto) {
        if (userDto.getPassword().length() <= 8){
            throw new WsException(HttpStatus.BAD_REQUEST, "Le mot de passe doit contenir au moins 8 caractères");
        }

        Users users = usersService.findByEmail(userDto.getEmail());
        if (users != null) {
            throw new WsException(HttpStatus.BAD_REQUEST, "Cet email existe déja");
        }

        users = userDto.getUser();
        users.setPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));
        users.setRoles(List.of(roleService.save("USER")));

        // générer un token user
        do {
            users.setToken(Random.getRandomStr(50));
        }while (usersService.findByToken(users.getToken()) != null);


        usersService.save(users);

        return Map.of("token", JwtTokenManager.generateToken(users.getToken()));

    }
}
