package com.payment_terms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("payment_terms user details")
@Entity
@Table(name="user")
public class User {

	@ApiModelProperty(notes="auto generated")
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ApiModelProperty(notes="enter code")
	private String code;
	
	@ApiModelProperty(notes="enter description")
	private String description;
	
	@ApiModelProperty(notes="enter creation date")
	private String creationDate;
	
	@ApiModelProperty(notes="enter days")
	private int days;
	
	@ApiModelProperty(notes="enter reminder days")
	private int remindBeforeDays;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long id, String code, String description, String creationDate, int days, int remindBeforeDays) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.creationDate = creationDate;
		this.days = days;
		this.remindBeforeDays = remindBeforeDays;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getRemindBeforeDays() {
		return remindBeforeDays;
	}
	public void setRemindBeforeDays(int remindBeforeDays) {
		this.remindBeforeDays = remindBeforeDays;
	}
	
	

}
