package com.crud.app;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<StudentEntity,Long> {

	@Query("select s from StudentEntity s where s.branch = :branch")
	List<StudentEntity> findByBranch(@Param("branch") String branch);
 
}