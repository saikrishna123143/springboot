package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.UserModel;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String>{
UserModel findByName(String name);
}
