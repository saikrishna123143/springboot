package com.employee.service;

import org.springframework.stereotype.Service;

@Service
public class EmployerService {
public boolean saveemployer(String name,String password)
{
	if(name.equals("saikrishna")&&password.equals("gnapika1"))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}
