package com.example.CriptoPracticaEx.controller;


import com.example.CriptoPracticaEx.dto.EstudianteDTO;
import com.example.CriptoPracticaEx.dto.RespuestaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/listar")
    public List<EstudianteWeb> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public EstudianteWeb buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/registrar")
    public RespuestaDTO registrar(@RequestBody EstudianteDTO e) {
        try {
            EstudianteWeb es = new EstudianteWeb();
            es.setNdniEstdWeb(e.getDniEst());
            es.setAppaEstdWeb(e.getApaEst());
            es.setApmaEstdWeb(e.getAmaEst());
            es.setNombEstdWeb(e.getNombEst());
            es.setFechNaciEstdWeb(e.getFechaNaciEst());
            es.setLogiEstd(e.getLoginEst());

            // 🔐 Cifrar la contraseña correctamente
            String hashedPassword = passwordEncoder.encode(e.getPassEst());
            es.setPassEstd(hashedPassword);

            // Guardar en la base de datos
            EstudianteWeb guardado = service.registrar(es);

            // ✅ Respuesta exitosa
            return new RespuestaDTO("ok", "Estudiante registrado correctamente", guardado);

        } catch (Exception ex) {
            // ⚠️ En caso de error
            return new RespuestaDTO("error", "Error al registrar estudiante: " + ex.getMessage(), null);
        }
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