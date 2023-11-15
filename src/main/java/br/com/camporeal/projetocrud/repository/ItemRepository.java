package br.com.camporeal.projetocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.camporeal.projetocrud.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
