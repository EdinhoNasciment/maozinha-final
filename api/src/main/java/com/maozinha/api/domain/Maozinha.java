package com.maozinha.api.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Table(name="maozinha")
@Entity

public class Maozinha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(name="descr")
	private String desc;
	@Column(name = "creationDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate creationDate;
	private String imgUrl;
	private String maozinhaUrl;
	private Double minValue;
	@Column(name="total_value")
	private Double maxValue;
	private Double upToDateValue;
	@Column(name="is_complete")
	private boolean isComplete;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getMaozinhaUrl() {
		return maozinhaUrl;
	}

	public void setMaozinhaUrl(String maozinhaUrl) {
		this.maozinhaUrl = maozinhaUrl;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getUpToDateValue() {
		return upToDateValue;
	}

	public void setUpToDateValue(Double upToDateValue) {
		this.upToDateValue = upToDateValue;
	}

	public boolean isIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
	
}