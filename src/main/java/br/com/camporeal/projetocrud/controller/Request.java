package br.com.camporeal.projetocrud.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {

    private String nome;

    private int quantidade;

    private String descricao;
}
