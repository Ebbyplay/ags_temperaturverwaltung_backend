package ags.SechsY.temperaturverwaltung.mapper;

import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.UserRequestDTO;
import ags.SechsY.temperaturverwaltung.model.User;

@Component
public class UserMapper implements BaseMapper<User, UserRequestDTO> {

    @Override
    public UserRequestDTO mapEntity(User user) {
        UserRequestDTO userDto = new UserRequestDTO();
        userDto.setName(user.getName());
        userDto.setNickname(user.getNickname());
        userDto.setPhonenumber(user.getPhonenumber());
        userDto.setAdmin(user.isAdmin());
        return userDto;
    }

    @Override
    public User mapDTO(UserRequestDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setNickname(userDto.getNickname());
        user.setPhonenumber(userDto.getPhonenumber());
        user.setAdmin(userDto.isAdmin());
        return user;
    }

}
