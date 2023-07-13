//imports
package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//---------entidade candidato-------
//candidatos é uma entidade
@Entity
public class Candidatos {

	@Id
	//gerar o incremento de id automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//nao pode ser nulo esse campo
	@Column(nullable = false)
	private String nome;

	private String status;

	public Long getCodCandidato() {
		return id;
	}

	public void setCodCandidato(Long codCandidato) {
	    this.id = codCandidato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
		
}
