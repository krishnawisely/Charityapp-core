package com.revature.charity.model;

import java.time.LocalDate;

public class Transaction {
	private Integer id;
	private Integer fundRequestId;
	private Integer donorId;
	private Double amount;
	private LocalDate date;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((donorId == null) ? 0 : donorId.hashCode());
		result = prime * result + ((fundRequestId == null) ? 0 : fundRequestId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (donorId == null) {
			if (other.donorId != null)
				return false;
		} else if (!donorId.equals(other.donorId))
			return false;
		if (fundRequestId == null) {
			if (other.fundRequestId != null)
				return false;
		} else if (!fundRequestId.equals(other.fundRequestId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fundRequestId=" + fundRequestId + ", donorId=" + donorId + ", amount="
				+ amount + ", date=" + date + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getfundRequestId() {
		return fundRequestId;
	}
	public void setfundRequestId(Integer fundRequestId) {
		this.fundRequestId = fundRequestId;
	}
	public Integer getDonorId() {
		return donorId;
	}
	public void setDonorId(Integer admin_id) {
		this.donorId = admin_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
