package com.example.Mobile_MiniPro.Data.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity(name="Datas")
@Table(
		name = "datas"
)
public class Datas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "detail",columnDefinition = "text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin", nullable = false)
	private String detail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id", referencedColumnName = "id",nullable = false) //FK
	@Fetch(FetchMode.JOIN)
	private Creators creatorsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "types_id",referencedColumnName = "id", nullable = false) //FK
	@Fetch(FetchMode.JOIN)
	private Types typesId;
	
	public Datas() {
		super();
	}

	public Datas(String name, String detail, Creators creatorsId, Types typesId) {
		super();
		this.name = name;
		this.detail = detail;
		this.creatorsId = creatorsId;
		this.typesId = typesId;
	}



	

	
	

	
}
