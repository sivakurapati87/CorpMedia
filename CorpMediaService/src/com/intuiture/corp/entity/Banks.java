package com.intuiture.corp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banks")
//@NamedQueries({ @NamedQuery(name = "Banks.findAll", query = "select b from Banks b") })
public class Banks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankId;
	private String bankName;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
