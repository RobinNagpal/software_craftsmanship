package com.cleanCode.domain;

public class Product {

	private static final long serialVersionUID = 6176173555122648448L;

	private Long productId;

    private ProgramType programType;

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
    return "Product{" +
            "productId=" + productId +
            ", programType=" + programType +
            ", category=" + category +
            '}';
  }
}
