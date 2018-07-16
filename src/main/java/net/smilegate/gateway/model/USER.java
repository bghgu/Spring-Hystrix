package net.smilegate.gateway.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class USER implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int user_idx;
	private String name;
	private String email;
	
	public USER() {}
	
	public USER(int user_idx, String name, String email) {
		this.user_idx = user_idx;
		this.name = name;
		this.email = email;
	}
	
	public USER(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
