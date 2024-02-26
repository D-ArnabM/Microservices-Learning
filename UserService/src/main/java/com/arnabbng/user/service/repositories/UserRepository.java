package com.arnabbng.user.service.repositories;

import com.arnabbng.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}