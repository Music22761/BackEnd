package com.example.Mobile_MiniPro.Data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.model.Datas;
//import com.example.Mobile_MiniPro.Data.model.Favorites;
//import com.example.Mobile_MiniPro.Data.model.Types;
//
//import java.util.List;
import java.util.Optional;

public interface DatasRepository extends JpaRepository<Datas, Long> {
	Datas findById(long id);
//	Datas findByCreatorsId(long id);
//	Datas findByTypesId(long id);

	Optional<Datas> findOptionalById(long id);
}
