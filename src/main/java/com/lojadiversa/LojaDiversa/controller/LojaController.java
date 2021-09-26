package com.lojadiversa.LojaDiversa.controller;

import com.lojadiversa.LojaDiversa.model.LojaModel;
import com.lojadiversa.LojaDiversa.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import javax.websocket.server.PathParam;

@RestController
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @GetMapping(path = "/loja/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping(path = "/loja/salvar")
    public LojaModel salvar(@RequestBody LojaModel loja) {
        return repository.save(loja);
    }

    @PutMapping (path = "/loja/atualizar")
    public LojaModel atualizar(@RequestBody LojaModel loja) {
        return repository.save(loja);
    }

    @DeleteMapping(path = "/loja/{codigo}")
    public ResponseEntity <?> delete(@PathVariable Integer codigo) {
        return repository.findById(codigo)
                .map(record -> {
                    repository.deleteById(codigo);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
