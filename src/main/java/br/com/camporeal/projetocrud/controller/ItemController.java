package br.com.camporeal.projetocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camporeal.projetocrud.model.Item;
import br.com.camporeal.projetocrud.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> retornaListaItens() {

        if(itemService.getListaTodosItens().isEmpty()){
            return new ResponseEntity<>(itemService.getListaTodosItens(), HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(itemService.getListaTodosItens(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> retornaItem(@PathVariable Integer id) {
        Item item = itemService.getItem(id);

        if(item == null){
            return new ResponseEntity<Item>(item, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }
    }

    @PostMapping
    public String salvarItem(@RequestBody Request request){
        Integer idItem = itemService.salvarItem(request);
        return "Item de ID: " + idItem + " foi salvo";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarItem(@PathVariable int id, @RequestBody Request request){
        Item item = itemService.alterarItem(request, id);

        if (item != null) {
            return new ResponseEntity<>("Registro de ID: " + id + " alterado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registro de Id: " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirTarefa(@PathVariable Integer id){
        if (itemService.excluirItem(id) == false) {
            return new ResponseEntity<>("Registro de Id: " + id + " não encontrado", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Registro de ID: " + id + " excluído com sucesso!", HttpStatus.OK);
            }
        }
}
