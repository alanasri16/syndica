package org.sandicat.DTO;


import org.sandicat.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjetRepository  extends JpaRepository<Projet, Long>{
	 @Query("select c from Projet c where c.title like :x")
		public Page<Projet> chercher(@Param("x")String mc,Pageable pageable);
}
