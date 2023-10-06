package com.gloswitchcm237.tikitsupport.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tikit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tikit_id")
	private int id;
	private int userId;
	private String subject;
	private String attach;
	private String body;
	private String status;
	private LocalDateTime created_at;
	
	@OneToMany(mappedBy = "tikit", fetch = FetchType.EAGER)
	private List<Talk> talks = new ArrayList<>();
	
	public Tikit() {}
	
	public Tikit(int userId, String subject, String attach, String body) {
		this.userId = userId;
		this.subject = subject;
		this.attach = attach;
		this.body = body;
		this.status = "pending";
		this.created_at = LocalDateTime.now();
	}
	
	public void addTalk(Talk talk) {
		talks.add(talk);
		talk.setTikit(this);
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<Talk> getTalks() {
		return talks;
	}
	
	
}
