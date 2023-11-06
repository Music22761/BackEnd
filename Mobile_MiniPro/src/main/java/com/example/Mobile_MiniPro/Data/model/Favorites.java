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
@Entity(name="Favorites")
@Table(
		name = "favorites"
)
public class Favorites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_id", referencedColumnName = "id",nullable = false) //FK
	@Fetch(FetchMode.JOIN)
	private Datas datas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false) //FK
	@Fetch(FetchMode.JOIN)
	private Users users;
	
	
	public Favorites() {
		;
	}


	public Favorites(Datas data_id, Users user_id) {
		super();
		this.datas = data_id;
		this.users = user_id;
	}

	
	

	
}
