package com.ankuran.wages.model.response;

import java.util.List;

import com.ankuran.wages.enums.EmployeeActivityEnum;

public class DueDetails extends ActivityMoneyMovementDetails {
	private EmployeeActivityEnum.DueDistributionType distributionType;
	private Long quantity;
	private Double duePerItem;
	private ItemDetails item;
	private List<EmployeeShare> distribution;
	public EmployeeActivityEnum.DueDistributionType getDistributionType() {
		return distributionType;
	}
	public void setDistributionType(EmployeeActivityEnum.DueDistributionType distributionType) {
		this.distributionType = distributionType;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Double getDuePerItem() {
		return duePerItem;
	}
	public void setDuePerItem(Double duePerItem) {
		this.duePerItem = duePerItem;
	}
	public ItemDetails getItem() {
		return item;
	}
	public void setItem(ItemDetails item) {
		this.item = item;
	}
	public List<EmployeeShare> getDistribution() {
		return distribution;
	}
	public void setDistribution(List<EmployeeShare> distribution) {
		this.distribution = distribution;
	}
}
