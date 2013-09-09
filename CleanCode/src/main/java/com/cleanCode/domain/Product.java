package com.cleanCode.domain;

import com.beachbody.cert.domain.base.BaseActiveEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="TBB_CERT_Product")
@XmlRootElement
public class Product extends BaseActiveEntity<Long> {

	private static final long serialVersionUID = 6176173555122648448L;

	@Column
	private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgramType programType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
	private ProductCategory category;


    public ProgramType getProgramType() {
        return programType;
    }

    public void setProgramType(ProgramType programType) {
        this.programType = programType;
    }

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", programType=" + programType + ", category=" + category
                + ", getCreatedDate()=" + getCreatedDate() + ", getModifiedDate()=" + getModifiedDate()
                + ", getActive()=" + getActive() + ", getId()=" + getId() + "]";
    }
	
}
