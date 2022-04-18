package com.spring.boot.cache.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONFIG_PARAMS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigParams implements Serializable {

	private static final long serialVersionUID = 325893530735865897L;

	@Column(name = "PARAM_KEY", nullable = false)
	@Id
	private String paramKey;

	@Column(name = "PARAM_VALUE", nullable = false)
	private String paramValue;

	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createDate;

	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@Column(name = "VERSION")
	private Integer version;

}
