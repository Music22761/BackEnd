package com.example.Mobile_MiniPro.Data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name="Users")
@Table(
		name = "users",
		uniqueConstraints = {
				@UniqueConstraint(name = "user_email_unique",columnNames = "email")
		}
)


public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email",unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "image", nullable = false)
	private String image;

	
	public Users() {
		;
		// TODO Auto-generated constructor stub
	}


	public Users(String name, String email, String password, String image) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.image = image;
	}


	

	

	

}
