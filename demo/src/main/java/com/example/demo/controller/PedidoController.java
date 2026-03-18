package com.example.demo.controller;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos") // Rota para pedidos [cite: 85]
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping // Criar Pedido [cite: 86, 96]
    public Pedido criar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }

    @GetMapping // Listar todos [cite: 88, 97]
    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}") // Consultar por ID [cite: 87, 104]
    public Pedido buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}") // Apagar Pedido [cite: 89, 140]
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}