package com.example.CriptoPracticaEx.controller;


import com.example.CriptoPracticaEx.dto.CambioClaveDTO;
import com.example.CriptoPracticaEx.dto.CredencialDTO;
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
    @PostMapping("/validacion")
    public RespuestaDTO validarUsuario(@RequestBody CredencialDTO credencial) {
        try {
            EstudianteWeb estudiante = service.validarPorDniYPassword(
                    credencial.getDniEst(),
                    credencial.getPassEst()
            );
    String nombre=estudiante.getNombEstdWeb();
            if (estudiante != null) {
                // ✅ Usuario encontrado y contraseña correcta
                return new RespuestaDTO("ok",
                        "Usuario correcto. Bienvenido " +nombre ,
                        null);
            } else {
                // ❌ Usuario o contraseña incorrectos
                return new RespuestaDTO("error",
                        "DNI o contraseña incorrectos",
                        null);
            }
        } catch (Exception ex) {
            return new RespuestaDTO("error",
                    "Error al validar el usuario: " + ex.getMessage(),
                    null);
        }
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

    @PutMapping("/cambiarClave")
    public RespuestaDTO cambiarClave(@RequestBody CambioClaveDTO dto) {
        try {
            String mensaje = service.cambiarClave(
                    dto.getDniEst(),
                    dto.getPassActual(),
                    dto.getPassNueva(),
                    dto.getConfirmarPass()
            );

            if (mensaje.equals("Contraseña actualizada correctamente")) {
                return new RespuestaDTO("ok", mensaje, null);
            } else {
                return new RespuestaDTO("error", mensaje, null);
            }

        } catch (Exception ex) {
            return new RespuestaDTO("error", "Error al cambiar la contraseña: " + ex.getMessage(), null);
        }
    }

    @PutMapping("/actualizar")
    public RespuestaDTO actualizar(@RequestBody EstudianteDTO dto) {
        // Buscar estudiante actual por ID
        EstudianteWeb existente = service.buscarPorId(dto.getCodiEst());
        if (existente == null) {
            return new RespuestaDTO("error", "No se encontró el estudiante con ID: " + dto.getCodiEst(), null);
        }

        // Actualizar solo los datos permitidos
        existente.setNdniEstdWeb(dto.getDniEst());
        existente.setAppaEstdWeb(dto.getApaEst());
        existente.setApmaEstdWeb(dto.getAmaEst());
        existente.setNombEstdWeb(dto.getNombEst());
        existente.setFechNaciEstdWeb(dto.getFechaNaciEst());

        // Guardar los cambios
        service.actualizar(existente);

        return new RespuestaDTO("ok", "Datos del estudiante actualizados correctamente", null);
    }



    @DeleteMapping("/eliminar")
    public RespuestaDTO eliminar(@RequestBody EstudianteDTO dto) {
        int id = dto.getCodiEst();
        service.eliminar(id);
        return new RespuestaDTO("ok", "usuario eliminado", null);
    }


}