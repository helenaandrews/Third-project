package com.rentmyboat.rentmyboat.controller;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.dto.UsersLoginDto;
import com.rentmyboat.rentmyboat.model.Users;
import com.rentmyboat.rentmyboat.repository.UsersRepository;
import com.rentmyboat.rentmyboat.service.SecurityUsersService;
import com.rentmyboat.rentmyboat.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "Users", description = "Users API")
public class UsersController {

    private final UsersService usersService;
    private final SecurityUsersService securityUsersService;
    private final UsersRepository usersRepository;
    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUserById(id);
    }
    @GetMapping("/user/id")
    UsersDto getInfoById(@PathVariable("id") Long id) {
        return usersService.getInfoById(id);
    }

    //TODO добавить возврат на домашнюю страницу с фронта
    @PostMapping("/registration")
    @Operation(summary = "Регистрация нового пользователя")
    String createUser(@RequestBody Users user) {
        String username = user.getUsername();
        String password = user.getPassword();
        usersService.save(user);
        securityUsersService.autoLogin(username, password);
        return "user successfully created";
    }

    //TODO добавить возврат на домашнюю страницу с фронта
    @GetMapping("/registration")
    @Operation(summary = "Аутентификация пользователя")
    String getUser(@RequestBody UsersLoginDto usersLoginDto) throws NoSuchElementException {
        Optional<Users> user = usersRepository.findByUsername(usersLoginDto.getUsername());
        return "hello user";
    }


    //TODO добавить страницу  аккаунта арендодателя с фронта
    @GetMapping("/account/boat_owner")
    @Operation(summary = "Получение странички аккаунта пользователя с ролью арендодатель")
    String getBoatOwnerAccount(){
        return "you are at boat owner account page";
    }

    //TODO добавить страницу аккаунта арендующего лодку с фронта
    @GetMapping("/account/boat_renter")
    @Operation(summary = "Получение странички аккаунта пользователя с ролью арендатор")
    String getBoatRenterAccount(){
        return "you are at boat renter account page";
    }

    //TODO добавить домашнюю страницу с фронта
    @GetMapping("/")
    @Operation(summary = "Получение домашней страницы")
    String getHomepage(){
        return "you are at home page";
    }
}
