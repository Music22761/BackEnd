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
@Entity(name="Creators")
@Table(
		name = "creators"
)


public class Creators {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	
	public Creators() {
		;
		// TODO Auto-generated constructor stub
	}



	public Creators(String name) {
		super();
		this.name = name;
	}
	
	


	

}
