package serg.madi.trello.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serg.madi.trello.dto.LoginRequest;
import serg.madi.trello.dto.UserDto;
import serg.madi.trello.service.UserService;

/**
 * Контроллер для обработки операций, связанных с пользователями:
 * регистрация и авторизация.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Регистрирует нового пользователя.
     *
     * @param dto DTO с данными пользователя (имя, логин, пароль, баланс)
     * @return UserDto с сохранёнными данными нового пользователя
     */
    @PostMapping("/register")
    @Operation(summary = "Регистрация нового пользователя", description = "Создаёт нового пользователя в системе.")
    @ApiResponse(responseCode = "200", description = "Пользователь успешно зарегистрирован")
    public UserDto register(@RequestBody UserDto dto) {
        return userService.register(dto);
    }

    /**
     * Авторизует пользователя по логину и паролю.
     *
     * @param request объект с логином и паролем
     * @return UserDto при успешной авторизации или 400 Bad Request при ошибке
     */
    @PostMapping("/login")
    @Operation(summary = "Авторизация пользователя", description = "Проверяет логин и пароль и возвращает данные пользователя.")
    @ApiResponse(responseCode = "200", description = "Успешная авторизация")
    @ApiResponse(responseCode = "400", description = "Неверный логин или пароль")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequest request) {
        UserDto userDto;
        try {
            userDto = userService.login(request.getLogin(), request.getPassword());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userDto);
    }
}
