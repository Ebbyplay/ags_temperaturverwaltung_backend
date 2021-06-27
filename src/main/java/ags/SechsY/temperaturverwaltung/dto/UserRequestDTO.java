package ags.SechsY.temperaturverwaltung.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String name;
    private String nickname;
    private String phonenumber;
    private boolean admin;

}
