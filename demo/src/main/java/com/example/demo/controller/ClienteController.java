package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @PostMapping // [cite: 86]
    public Cliente criar(@RequestBody Cliente c) { return repository.save(c); }

    @GetMapping // [cite: 88]
    public List<Cliente> listar() { return repository.findAll(); }

    @GetMapping("/{id}") // [cite: 87]
    public Cliente buscar(@PathVariable Long id) { return repository.findById(id).orElse(null); }

    @DeleteMapping("/{id}") // [cite: 89]
    public void deletar(@PathVariable Long id) { repository.deleteById(id); }
}