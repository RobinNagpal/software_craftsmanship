package com.cleanCode.dto;

import java.io.Serializable;
import java.lang.Boolean;import java.lang.Override;import java.lang.String;import java.math.BigDecimal;

public class ShippingMethodDTO implements Serializable {

	private static final long serialVersionUID = -1300667450800909646L;
	
	private int id;
	
	private String name;
	
	private BigDecimal price = BigDecimal.ZERO.setScale(2);
	
	private BigDecimal tax = BigDecimal.ZERO.setScale(2);
	
	private int sortOrder;
	
	private String displayName;
	
	private Boolean freeShippingOption = false;

	public Boolean isFreeShippingOption() {
        return freeShippingOption;
    }

    public void setFreeShippingOption(Boolean freeShippingOption) {
        this.freeShippingOption = freeShippingOption;
    }

    public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public String toString() {
		return "ShippingMethodDTO [id=" + id + ", name=" + name + ", price="
				+ price + ", tax=" + tax + "]";
	}

	public ShippingMethodDTO(int id, String name, BigDecimal price,
			BigDecimal tax) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.tax = tax;
	}
	
	public ShippingMethodDTO() {
	}
}
