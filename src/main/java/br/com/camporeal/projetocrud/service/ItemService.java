package br.com.camporeal.projetocrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camporeal.projetocrud.controller.Request;
import br.com.camporeal.projetocrud.model.Item;
import br.com.camporeal.projetocrud.repository.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getListaTodosItens() {
        return itemRepository.findAll();
    }

    public Item getItem(Integer id) {
        Optional<Item> optItem = itemRepository.findById(id);

        if(optItem.isPresent()) {
            return optItem.get();
        } else {
            return null;
        }
    }

    public Integer salvarItem(Request request){
        Item item = new Item();
        item.setNome(request.getNome());
        item.setQuantidade(request.getQuantidade());
        item.setDescricao(request.getDescricao());

        item = itemRepository.save(item);

        return item.getId();
    }

    public Item alterarItem(Request request, int id){
        Item item = itemRepository.findById(id).orElse(null);

        if (item == null) {
            return item;
        }else{
            item.setNome(request.getNome());
            item.setQuantidade(request.getQuantidade());
            item.setDescricao(request.getDescricao());

            item = itemRepository.save(item);
            
            return item;
        }
    }

    public boolean excluirItem(Integer id){
        if (itemRepository.findById(id).orElse(null) == null) {
            return false;
        }else{
            itemRepository.deleteById(id);
            return true;
            } 
        }
}
