package br.com.projeto.api_atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.api_atividades.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    
}
