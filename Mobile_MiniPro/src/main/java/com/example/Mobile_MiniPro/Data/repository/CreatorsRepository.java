package com.example.Mobile_MiniPro.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mobile_MiniPro.Data.model.Creators;

import java.util.Optional;

public interface CreatorsRepository extends JpaRepository<Creators, Long> {
	Creators findById(long id);
	Optional<Creators> findOptionalById(long id);
}
