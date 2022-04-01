package com.eric.inventoryapi.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Category_Id")
	@ApiModelProperty(hidden = true)
	private long categoryId;
	@Column(name="Category_Name",nullable = false,length = 100)

    private String categoryName;
	/*
	 * @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 * 
	 * @JsonIgnore private List<Product> productList;
	 */
}
