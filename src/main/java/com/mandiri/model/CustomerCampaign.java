package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the customer_campaign database table.
 * 
 */
@Entity
@Table(name="customer_campaign")
@NamedQuery(name="CustomerCampaign.findAll", query="SELECT c FROM CustomerCampaign c")
public class CustomerCampaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp createdon;

	private String email;

	private Timestamp modifiedon;

	private String nohp;

	@DateTimeFormat(pattern = "dd-MM-yy HH:mm")
	@Column(nullable = false, columnDefinition= "TIMESTAMP WITHOUT TIME ZONE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date reminderon;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cif")
	private Customer customer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	//bi-directional many-to-one association to Reason
	@ManyToOne
	@JoinColumn(name="reasonid")
	private Reason reason;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="statusid")
	private Status status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modifiedby")
	private User user2;

	public CustomerCampaign() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getModifiedon() {
		return this.modifiedon;
	}

	public void setModifiedon(Timestamp modifiedon) {
		this.modifiedon = modifiedon;
	}

	public String getNohp() {
		return this.nohp;
	}

	public void setNohp(String nohp) {
		this.nohp = nohp;
	}

	public Date getReminderon() {
		return this.reminderon;
	}

	public void setReminderon(Date reminderon) {
		this.reminderon = reminderon;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Reason getReason() {
		return this.reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
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