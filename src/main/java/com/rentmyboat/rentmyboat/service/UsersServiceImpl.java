package com.rentmyboat.rentmyboat.service;

import com.rentmyboat.rentmyboat.dto.UsersDto;
import com.rentmyboat.rentmyboat.mappers.UsersMapper;
import com.rentmyboat.rentmyboat.model.Users;
import com.rentmyboat.rentmyboat.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {
    private final UsersRepository repository;
    private final UsersMapper usersMapper;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.repository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public UsersDto getInfoById(Long id) {
        Optional<Users> user = repository.findById(id);
        if (user.isPresent()){
            log.info("User: {}" + user);
            return usersMapper.toDto(user.get());
        }else {
            log.info("This user doesn't exist");
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public Users deleteUserById(Long id) {
        Optional<Users> users = repository.findById(id);
        Users userDeactivation = null;
        if (users.isPresent()) {
            log.info("User: {} " + users);
            userDeactivation = Users.builder()
                    .isActive(false)
                    .build();
            return userDeactivation;
        } else {
            log.info("This user doesn't exist");
            throw new NoSuchElementException("No value present");
        }
    }

    /* TODO: эндпоинты для удаления резюме и лодки (?)
     */
    @Override
    public void deleteResumeById(Long id) {
        repository.deleteById(id);
    }
    @Override
    public void deleteBoatById(Long id) {
        repository.deleteById(id);
    }
}
