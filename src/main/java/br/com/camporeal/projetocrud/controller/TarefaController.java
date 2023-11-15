package br.com.camporeal.projetocrud.controller;

import java.util.List;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.camporeal.projetocrud.model.Tarefa;
import br.com.camporeal.projetocrud.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> retornaListaTarefas() {
        return tarefaService.getListaTodasTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> retornaTarefa(@PathVariable Integer id) {
        Tarefa tarefa = tarefaService.getTarefa(id);

        if(tarefa == null){
            return new ResponseEntity<Tarefa>(tarefa, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
        }
    }

    @PostMapping
    public String salvarTarefa(@RequestBody Request request){
        Integer idTarefa = tarefaService.salvarTarefa(request.getTitulo());
        return "Tarefa ID " + idTarefa + " foi salva";
    }

    @DeleteMapping("/{id}")
    public String excluirTarefa(@PathVariable Integer id){
        tarefaService.excluirTarefa(id);
            return "Tarefa excluída";
        }
}
