package ags.SechsY.temperaturverwaltung.mapper;

import ags.SechsY.temperaturverwaltung.dto.UserDTO;
import ags.SechsY.temperaturverwaltung.model.User;

public class UserMapper implements BaseMapper<User, UserDTO> {

    @Override
    public UserDTO mapEntity(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setName(user.getName());
        userDto.setNickname(user.getNickname());
        userDto.setPhonenumber(user.getPhonenumber());
        userDto.setAdmin(user.isAdmin());
        return userDto;
    }

    @Override
    public User mapDTO(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setNickname(userDto.getNickname());
        user.setPhonenumber(userDto.getPhonenumber());
        user.setAdmin(userDto.isAdmin());
        return user;
    }

}
