package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.model.UserModel;
import com.employee.repository.UserRepository;
import com.employee.service.EmployeeService;
import com.employee.service.EmployerService;
import com.employee.service.UserService;

@Controller
public class EmployeeController {
    @GetMapping("/employeeform")
	public String generateform()
	{
    	return "empform";
	}
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employeedetails")
    public String employeeDetails(EmployeeModel employeeModel,Model model)
    {
    	model.addAttribute("users",employeeModel);
    	employeeService.store(employeeModel);
    	return "/employersuccess";
    }
    @GetMapping("")
    public String home()
    {
      return "home";	
    }
    @GetMapping("/contact")
    public String contact()
    {
      return "contact";	
    }
    @GetMapping("/register")
    public String register()
    {
      return "register";	
    }
    @Autowired
    UserRepository userRepository;
    @PostMapping("/reg")
    public String reg(UserModel userModel)
    {
    	userRepository.save(userModel);
    	return "success1";
    }
    @GetMapping("/login")
    public String login()
    {
      return "login";	
    }
    @GetMapping("/loginpage")
    public String loginpage()
    {
    	return "loginpage";
    }
    @GetMapping("/employerlogin")
    public String employer()
    {
    	return "employerlogin";
    }
    @Autowired
    EmployerService employerService;
    @PostMapping("/employerdetails")
    public String employerdetails(String name,String password)
    {
    	boolean emp=employerService.saveemployer(name,password);
    	if(emp==true)
    	{
    	return "employersuccess";
    	}
    	else
    	{
    		return "success3";
    	}
    }
    @Autowired
    UserService userService;
    @PostMapping("/log")
    public String log(String name,String password,Model model)
    {
      boolean a=userService.loginService(name,password);
      
      if(a)
      {
    	  UserModel user=userService.getsolo(name);
    	  model.addAttribute("balayya", user);
    	return "employee";
      }
      else
      {
    	  return "success3";
      }
    }
    @GetMapping("/employeedetails")
    public String employeedetails(Model model)
    {
      
      List<EmployeeEntity>emp=employeeService.getdet();
      model.addAttribute("employees",emp);
    	return "delete";
    }
    @GetMapping("/search")
    public String search()
    {
    	return "search";
    }
    @PostMapping("/searchbyid")
    public String searchbyid(Integer id,Model model)
    {
    EmployeeEntity employeeEntity=employeeService.search(id);
    model.addAttribute("balayya", employeeEntity);
    return "search";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
    	employeeService.delete(id);
    	return "redirect:/employeedetails";
    }
  
    @GetMapping("/userdetails")
    public String userdetails(Model model)
    {
    	List<UserModel>emp=userService.getdet();
    	model.addAttribute("balayya", emp);
    	return "userdetails";
    }
}
