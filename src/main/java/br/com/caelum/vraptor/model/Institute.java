package br.com.caelum.vraptor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Institute {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(unique = true)
	private String code;
	
	private String name;
	
	

}
