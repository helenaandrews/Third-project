package com.rentmyboat.rentmyboat.repository;

import com.rentmyboat.rentmyboat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findInfoById(Long id);
    Optional<Users> findByUsername(String username);
}
