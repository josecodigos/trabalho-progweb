package br.com.camporeal.projetocrud.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camporeal.projetocrud.model.Tarefa;
import br.com.camporeal.projetocrud.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> getListaTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa getTarefa(Integer id) {
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);

        if(optTarefa.isPresent()) {
            return optTarefa.get();
        } else {
            return null;
        }
    }

    public Integer salvarTarefa(String titulo){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(titulo);
        tarefa.setDataCriacao(new Timestamp(System.currentTimeMillis()));

        tarefa = tarefaRepository.save(tarefa);

        return tarefa.getId();
    }
    public void excluirTarefa(Integer id){
            tarefaRepository.deleteById(id);
        }
}
