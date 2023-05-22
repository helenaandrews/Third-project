package com.rentmyboat.rentmyboat.repository;

import com.rentmyboat.rentmyboat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findInfoById(Long id);
}
