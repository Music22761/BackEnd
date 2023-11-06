package com.example.Mobile_MiniPro.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Mobile_MiniPro.Data.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Users findById(long id);
	Users findByEmail(String email);
	Optional<Users> findOptionalById(long id);
}
