package br.com.camporeal.projetocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.camporeal.projetocrud.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{
    
}
