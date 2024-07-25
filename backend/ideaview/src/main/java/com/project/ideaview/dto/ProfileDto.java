package com.project.ideaview.dto;

import com.project.ideaview.model.Profile;
import lombok.Data;


@Data
public class ProfileDto {

    private String number;
    private String job;
    private String profile_picture;

    public Profile getProfile() {
        Profile profile = new Profile();
        profile.setNumber(this.number);
        profile.setJob(this.job);
        profile.setProfile_picture(this.profile_picture);
        return profile;
    }
}
