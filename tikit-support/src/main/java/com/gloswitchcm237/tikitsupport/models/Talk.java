package com.gloswitchcm237.tikitsupport.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Talk implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String text;
	private LocalDateTime send_at;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tikit_id")
	@JsonIgnore
	private Tikit tikit;
	
	public Talk() {}
	
	public Talk(int userId, String text) {
		this.userId = userId;
		this.text = text;
		this.send_at = LocalDateTime.now();
	}
	
	public void setTikit(Tikit tikit) {
		this.tikit = tikit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getSend_at() {
		return send_at;
	}

	public void setSend_at(LocalDateTime send_at) {
		this.send_at = send_at;
	}

	public Tikit getTikit() {
		return tikit;
	}
	
	
}
