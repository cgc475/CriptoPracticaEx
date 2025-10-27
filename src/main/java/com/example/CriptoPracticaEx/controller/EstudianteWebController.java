package com.example.CriptoPracticaEx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.CriptoPracticaEx.entity.EstudianteWeb;
import com.example.CriptoPracticaEx.Service.EstudianteWebService;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*") // Permite peticiones desde el front
public class EstudianteWebController {

    @Autowired
    private EstudianteWebService service;

    @GetMapping("/listar")
    public List<EstudianteWeb> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public EstudianteWeb buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/registrar")
    public EstudianteWeb registrar(@RequestBody EstudianteWeb e) {
        return service.registrar(e);
    }

    @PutMapping("/actualizar")
    public EstudianteWeb actualizar(@RequestBody EstudianteWeb e) {
        return service.actualizar(e);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}