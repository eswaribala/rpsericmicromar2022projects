package com.eric.inventoryapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescription {
    @Column(name="Product_Name",nullable = false,length = 100)
	private String productName;
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="Expiry_Date")
	private LocalDate expiryDate;
    @Column(name="Qty")
	private long qty;
	
}
