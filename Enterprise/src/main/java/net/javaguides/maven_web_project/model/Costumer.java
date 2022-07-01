package net.javaguides.maven_web_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Costumer {

	private int id;
	private String custName;
	private String city;
	private int grade;
	private int salesmanId;
	
	public Costumer(int id, String custName, String city, int grade, int salesmanId) {
		this.id = id;
		this.custName = custName;
		this.city = city;
		this.grade = grade;
		this.salesmanId = salesmanId;
	}
	
	public Costumer(String custName, String city, int grade, int salesmanId) {
		this.custName = custName;
		this.city = city;
		this.grade = grade;
		this.salesmanId = salesmanId;
	}
	
	public Costumer(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	
	
	
}
