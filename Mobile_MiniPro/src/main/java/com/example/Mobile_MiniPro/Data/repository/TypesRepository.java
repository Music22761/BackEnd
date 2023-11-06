package com.example.Mobile_MiniPro.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mobile_MiniPro.Data.model.Types;

import java.util.Optional;

public interface TypesRepository extends JpaRepository<Types, Long> {
	Types findById(long id);
	Optional<Types> findOptionalById(long id);
}
