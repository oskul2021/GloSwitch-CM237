package com.gloswitchcm237.tikitsupport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gloswitchcm237.tikitsupport.models.Tikit;

@Repository
public interface TikitRepository extends JpaRepository<Tikit, Integer> {
	@Query("select t from Tikit t where t.userId = :id")
    List<Tikit> TikitByUserId(@Param("id") int id);

    @Query("select t from Tikit t where t.status = :status")
    List<Tikit> TikitByUserStatus(@Param("status") String status);
}
