package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp createdon;

	private String detail;

	private String group;

	private Timestamp modifiedon;

	private String name;

	private Long producttypeid;

	private Long subproductid;

	private String subproductname;

	//bi-directional many-to-one association to CustomerCampaign
	@OneToMany(mappedBy="product")
	private List<CustomerCampaign> customerCampaigns;

	//bi-directional many-to-one association to CustomerProduct
	@OneToMany(mappedBy="product")
	private List<CustomerProduct> customerProducts;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProducttypeid() {
		return this.producttypeid;
	}

	public void setProducttypeid(Long producttypeid) {
		this.producttypeid = producttypeid;
	}

	public Long getSubproductid() {
		return this.subproductid;
	}

	public void setSubproductid(Long subproductid) {
		this.subproductid = subproductid;
	}

	public String getSubproductname() {
		return this.subproductname;
	}

	public void setSubproductname(String subproductname) {
		this.subproductname = subproductname;
	}

	public List<CustomerCampaign> getCustomerCampaigns() {
		return this.customerCampaigns;
	}

	public void setCustomerCampaigns(List<CustomerCampaign> customerCampaigns) {
		this.customerCampaigns = customerCampaigns;
	}

	public CustomerCampaign addCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().add(customerCampaign);
		customerCampaign.setProduct(this);

		return customerCampaign;
	}

	public CustomerCampaign removeCustomerCampaign(CustomerCampaign customerCampaign) {
		getCustomerCampaigns().remove(customerCampaign);
		customerCampaign.setProduct(null);

		return customerCampaign;
	}

	public List<CustomerProduct> getCustomerProducts() {
		return this.customerProducts;
	}

	public void setCustomerProducts(List<CustomerProduct> customerProducts) {
		this.customerProducts = customerProducts;
	}

	public CustomerProduct addCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().add(customerProduct);
		customerProduct.setProduct(this);

		return customerProduct;
	}

	public CustomerProduct removeCustomerProduct(CustomerProduct customerProduct) {
		getCustomerProducts().remove(customerProduct);
		customerProduct.setProduct(null);

		return customerProduct;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}