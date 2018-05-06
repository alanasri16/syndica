package org.sandicat.DTO;


import org.sandicat.entities.Habitant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HabitantRepository extends JpaRepository<Habitant,Long> {
   @Query("select c from Habitant c where c.nom like :x")
	public Page<Habitant> chercher(@Param("x")String mc,Pageable pageable);
}
