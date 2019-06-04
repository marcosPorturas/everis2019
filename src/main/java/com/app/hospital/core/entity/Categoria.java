package com.app.hospital.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcategoria;
	private String nomcategoria;
	
	@OneToMany(mappedBy="categoria")
	private List<Bungalow> bungalows;
	
}
