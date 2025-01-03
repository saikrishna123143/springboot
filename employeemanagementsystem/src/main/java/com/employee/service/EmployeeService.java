package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
EmployeeRepository employeeRepository;
public void store(EmployeeModel employeeModel)
{
	EmployeeEntity employeeEntity=new EmployeeEntity();
	employeeEntity.setName(employeeModel.getName());
	employeeEntity.setRole(employeeModel.getRole());
	employeeEntity.setSalary(employeeModel.getSalary());
	employeeEntity.setLocation(employeeModel.getLocation());
	employeeEntity.setShift(employeeModel.getShift());
	employeeEntity.setDaPer(employeeModel.getDaPer());
	employeeEntity.setPfPer(employeeModel.getPfPer());
	employeeEntity.setDa(employeeEntity.getSalary()*employeeEntity.getDaPer()/100);
	employeeEntity.setPf(employeeEntity.getSalary()*employeeEntity.getPfPer()/100);
	employeeEntity.setNetsal(employeeEntity.getSalary()-employeeEntity.getPf()-employeeEntity.getDa());
	employeeRepository.save(employeeEntity);
	
}
public List<EmployeeEntity> getdet()
{
	List<EmployeeEntity> emp=employeeRepository.findAll();
	return emp;
}
public EmployeeEntity search(int id)
{
	Optional<EmployeeEntity>emp=employeeRepository.findById(id);
	if(emp.isPresent())
	{
		return emp.get();
	}else
	{
		return null;
	}
}
public void delete(int id)
{
	employeeRepository.deleteById(id);
}
}
