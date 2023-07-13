package com.example.demo.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.model.Candidatos;
import com.example.demo.repository.CandidatoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/v1/hiring")
public class CandidatesController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	
	@GetMapping
	public List <Candidatos> listar() {
		return candidatoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Candidatos adicionar(@RequestBody Candidatos candidato) {
		return candidatoRepository.save(candidato);
	}
	
	@PostMapping("/start")
	@ResponseStatus(HttpStatus.CREATED)
	public Candidatos iniciarProcesso(@RequestBody Candidatos candidato) {
		candidato.setStatus("recebido");
		return candidatoRepository.save(candidato);
	}
	
	@PostMapping("/schedule")
	@ResponseStatus(HttpStatus.OK)
	public void agendarEntrevista(@RequestBody Map<String, Integer> requestBody) {
		Integer codCandidato = requestBody.get("codCandidato");
	    Long codCandidatoLong = Long.valueOf(codCandidato);
		Optional<Candidatos> candidatoOptional = candidatoRepository.findById(codCandidatoLong);
		
		if(candidatoOptional.isPresent()) {
			Candidatos candidato = candidatoOptional.get();
			candidato.setStatus("qualificado");
			candidatoRepository.save(candidato);
		} else {
			throw new IllegalArgumentException("Candidato não encontrado");
		}
	}
	
	@PostMapping("/disqualify")
	@ResponseStatus(HttpStatus.OK)
	public void desqualificarCandidato(@RequestBody Map<String, Integer> requestBody) {
	Integer codCandidato = requestBody.get("codCandidato");
	Long codCandidatoLong = Long.valueOf(codCandidato);
	Optional<Candidatos> candidatoOptional = candidatoRepository.findById(codCandidatoLong);
	
	if(candidatoOptional.isPresent()) {
		Candidatos candidato = candidatoOptional.get();
		candidatoRepository.delete(candidato);
	}else {
		throw new IllegalArgumentException("Candidato não encontrado!");
	}
	}
	
	@PostMapping("/approve")
	@ResponseStatus(HttpStatus.OK)
	public void aprovarCandidato(@RequestBody Map<String, Integer> requestBody) {
		Integer codCandidato = requestBody.get("codCandidato");
		Long codCandidatoLong = Long.valueOf(codCandidato);
		Optional<Candidatos> candidatoOptional = candidatoRepository.findById(codCandidatoLong);
		
		if (candidatoOptional.isPresent()) {
			Candidatos candidato = candidatoOptional.get();
			candidato.setStatus("aprovado");
			candidatoRepository.save(candidato);
		} else {
			throw new IllegalArgumentException("Candidato não encontrado!");		}
	}
	
	@GetMapping("/status/candidate/{codCandidato}")
	public String statusCandidato(@PathVariable("codCandidato") Long codCandidato) {
		Optional<Candidatos> candidatoOptional = candidatoRepository.findById(codCandidato);
		
		if(candidatoOptional.isPresent()) {
			Candidatos candidato = candidatoOptional.get();
			return candidato.getStatus();
		}else {
			throw new IllegalArgumentException("Candidato não encontrado!");		
		}
	}
	
	@GetMapping("/approved")
	public List<Candidatos> candidatosAprovado(){
		return candidatoRepository.findByStatus("aprovado");
	}
	
	
}
