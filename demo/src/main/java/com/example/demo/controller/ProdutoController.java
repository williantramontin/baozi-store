package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos") // Rota para produtos [cite: 85]
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping // Criar Produto [cite: 86, 95]
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping // Listar todos [cite: 88, 97]
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}") // Consultar por ID [cite: 87, 104]
    public Produto buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}") // Apagar Produto [cite: 89, 140]
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}