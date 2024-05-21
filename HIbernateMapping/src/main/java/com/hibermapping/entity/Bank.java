package com.hibermapping.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	
	@Id
	private int bankId;
	
	private String bankName;

}
