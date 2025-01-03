package com.springbootmvc.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
@NotBlank(message="name should not be empty")
private String name;
@NotBlank(message="name should not be empty")
private String brand;
@NotBlank(message="name should not be empty")
private String madein;
@Positive(message="price must be greater than the zero")
private double price;
@Min(value = 1,message ="quantity greater than 1")
private int quantity;
@DecimalMax(value = "100" ,message="discount rate cannot exceed 100")
private double discountrate;

}
