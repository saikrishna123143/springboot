package com.springbootmvc.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="balayya")
public class ProductEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String brand;
private String madein;
private double price;
private int quantity;
@Column(name="dr")
private double discountrate;
private double discountamount;
private double offerprice;
private double taxrate;
private double finalprice;
private double stockvalue;
}
