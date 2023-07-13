package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Candidatos;


@Repository
public interface CandidatoRepository extends JpaRepository<Candidatos, Long>{
List <Candidatos> findByStatus(String status);
}
