package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.UserModel;
import com.employee.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
   public boolean loginService(String name,String password)
   {
	  UserModel model=userRepository.findByName(name) ;
	  if((model!=null)&&(model.getName().equals(name))&&(model.getPassword().equals(password)))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
   }
 
   
   public List<UserModel> getdet()
   {
	   List<UserModel>user=userRepository.findAll();
	   return user;
   }
   public UserModel getsolo(String name)
   {
	   UserModel emp=userRepository.findByName(name);
	   return emp;
   }
}
