package com.mortgagedemo.app.model;

public class Mortgage {

	private String mortgageId;
	private int version;
	private String offerID;
	private String productid;
	private String offerDate;
	private String createdDate;
	private String offerExpired;

	public Mortgage() {
	};

	public Mortgage(String mortgageId, int version, String offerID, String productid, String offerDate,
			String createdDate, String offerExpired) {
		super();
		this.mortgageId = mortgageId;
		this.version = version;
		this.offerID = offerID;
		this.productid = productid;
		this.offerDate = offerDate;
		this.createdDate = createdDate;
		this.offerExpired = offerExpired;
	}

	public String getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(String mortgageId) {
		this.mortgageId = mortgageId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOfferID() {
		return offerID;
	}

	public void setOfferID(String offerID) {
		this.offerID = offerID;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(String offerDate) {
		this.offerDate = offerDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getOfferExpired() {
		return offerExpired;
	}

	public void setOfferExpired(String offerExpired) {
		this.offerExpired = offerExpired;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((mortgageId == null) ? 0 : mortgageId.hashCode());
		result = prime * result + ((offerDate == null) ? 0 : offerDate.hashCode());
		result = prime * result + ((offerExpired == null) ? 0 : offerExpired.hashCode());
		result = prime * result + ((offerID == null) ? 0 : offerID.hashCode());
		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
		result = prime * result + version;
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
		Mortgage other = (Mortgage) obj;
		/*
		 * if (createdDate == null) { if (other.createdDate != null) return false; }
		 * else if (!createdDate.equals(other.createdDate)) return false;
		 */
		if (mortgageId == null) {
			if (other.mortgageId != null)
				return false;
		} else if (!mortgageId.equals(other.mortgageId))
			return false;
		if (offerDate == null) {
			if (other.offerDate != null)
				return false;
		} else if (!offerDate.equals(other.offerDate))
			return false;
		if (offerExpired == null) {
			if (other.offerExpired != null)
				return false;
		} else if (!offerExpired.equals(other.offerExpired))
			return false;
		if (offerID == null) {
			if (other.offerID != null)
				return false;
		} else if (!offerID.equals(other.offerID))
			return false;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mortgage [mortgageId=" + mortgageId + ", version=" + version + ", offerID=" + offerID + ", productid="
				+ productid + ", offerDate=" + offerDate + ", createdDate=" + createdDate + ", offerExpired="
				+ offerExpired + "]";
	}

}
