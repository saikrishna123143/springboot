package com.employee.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
private String name;
private String role;
private Double salary;
private String location;
private String shift;
private double daPer;
private double pfPer;
}
