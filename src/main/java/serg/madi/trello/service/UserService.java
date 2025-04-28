package serg.madi.trello.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import serg.madi.trello.dto.UserDto;
import serg.madi.trello.entity.User;
import serg.madi.trello.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto register(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setBalance(dto.getBalance() != null ? dto.getBalance() : 0.0);
        return UserDto.fromEntity(userRepository.save(user));
    }

    public UserDto login(String login, String password) {
        return userRepository.findByLogin(login)
                .filter(user -> user.getPassword().equals(password))
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Invalid login or password"));
    }
}
