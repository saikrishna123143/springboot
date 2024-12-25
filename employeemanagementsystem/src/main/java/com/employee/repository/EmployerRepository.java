package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployerModel;
@Repository
public interface EmployerRepository extends JpaRepository<EmployerModel,String>{
	
}
