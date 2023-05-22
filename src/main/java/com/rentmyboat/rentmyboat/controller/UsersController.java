package com.rentmyboat.rentmyboat.controller;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;
    @DeleteMapping("/user/delete/{id}")
    void deleteUser(@PathVariable("id") Long id) {
        usersService.deleteUserById(id);
    }
    @GetMapping("/user/id")
    UsersDto getInfoById(@PathVariable("id") Long id) {
        return usersService.getInfoById(id);
    }
}
