package net.javaguides.maven_web_project.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

	private int ordNo;
	private double purchase;
	private String ordDate;
	private int customerId;
	private int salesmanId;
	
	public Orders(int ordNo, double purchase, String ordDate, int customerId, int salesmanId) {
		this.ordNo = ordNo;
		this.purchase = purchase;
		this.ordDate = ordDate;
		this.customerId = customerId;
		this.salesmanId = salesmanId;
	}
	
	public Orders(double purchase, String ordDate, int customerId, int salesmanId) {
		this.purchase = purchase;
		this.ordDate = ordDate;
		this.customerId = customerId;
		this.salesmanId = salesmanId;
	}



	public Orders(int ordNo) {
		this.ordNo = ordNo;
	}



	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public double getPurchase() {
		return purchase;
	}
	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	
	
	
}
