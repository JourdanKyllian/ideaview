package com.project.ideaview.dto;

import com.project.ideaview.model.Users;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    // contenu du formulaire

    private String firstname;
    private String lastname;
    private String entreprise;
    private String email;
    private String password;

    /**
     * Convert
     * @return
     */
    public Users getUser() {
        Users users = new Users();
        users.setFirstname(this.firstname);
        users.setLastname(this.lastname);
        users.setEmail(this.email);
        users.setPassword(this.password);
        users.setDateCreation(new Date());
        users.setActive(true);
        return users;
    }

}
