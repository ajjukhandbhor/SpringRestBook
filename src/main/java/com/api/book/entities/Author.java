package com.api.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	private String aName;
	private String aAddress;
	
	public Author() {}

	public Author(int aId, String aName, String aAddress) {
		this.aId = aId;
		this.aName = aName;
		this.aAddress = aAddress;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}

	@Override
	public String toString() {
		return "Author [aId=" + aId + ", aName=" + aName + ", aAddress=" + aAddress + "]";
	}
		
}
