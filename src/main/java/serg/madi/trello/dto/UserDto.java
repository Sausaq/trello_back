package serg.madi.trello.dto;

import lombok.Value;
import serg.madi.trello.entity.User;

@Value
public class UserDto {
    Integer id;
    String name;
    String login;
    String password;
    Double balance;

    public static UserDto fromEntity(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getBalance()
        );
    }
}
