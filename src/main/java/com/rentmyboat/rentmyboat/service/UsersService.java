package com.rentmyboat.rentmyboat.service;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users deleteUserById(Long id);

    void save(Users user);

    Optional<Users> findByUsername(String username);

    void deleteResumeById(Long id);
    void deleteBoatById(Long id);
    UsersDto getInfoById(Long id);

}
