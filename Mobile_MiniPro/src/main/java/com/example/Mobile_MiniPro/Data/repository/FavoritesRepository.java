package com.example.Mobile_MiniPro.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.model.Users;

import java.util.List;
import java.util.Optional;


public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
	Favorites findById(long id);
	Favorites findByUsersId(long id);
	Favorites findByDatasId(long id);

	Optional<Favorites> findOptionalById(long id);
}
