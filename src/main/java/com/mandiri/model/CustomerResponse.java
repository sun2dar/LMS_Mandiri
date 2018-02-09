package com.mandiri.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the customer_response database table.
 * 
 */
@Entity
@Table(name="customer_response")
@NamedQuery(name="CustomerResponse.findAll", query="SELECT c FROM CustomerResponse c")
public class CustomerResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long cif;

	private String createdby;

	private Timestamp createdon;

	@Column(name="customer_campaignid")
	private Long customerCampaignid;

	private String email;

	private String nohp;

	private Timestamp reminderon;

	private Integer status;

	private String tanggapan;

	public CustomerResponse() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCif() {
		return this.cif;
	}

	public void setCif(Long cif) {
		this.cif = cif;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Timestamp getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Long getCustomerCampaignid() {
		return this.customerCampaignid;
	}

	public void setCustomerCampaignid(Long customerCampaignid) {
		this.customerCampaignid = customerCampaignid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNohp() {
		return this.nohp;
	}

	public void setNohp(String nohp) {
		this.nohp = nohp;
	}

	public Timestamp getReminderon() {
		return this.reminderon;
	}

	public void setReminderon(Timestamp reminderon) {
		this.reminderon = reminderon;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTanggapan() {
		return this.tanggapan;
	}

	public void setTanggapan(String tanggapan) {
		this.tanggapan = tanggapan;
	}

}