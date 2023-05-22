package com.rentmyboat.rentmyboat.service;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.model.Users;

import java.util.List;

public interface UsersService {
    Users deleteUserById(Long id);
    void deleteResumeById(Long id);
    void deleteBoatById(Long id);
    UsersDto getInfoById(Long id);
}
