package com.example.CriptoPracticaEx.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.CriptoPracticaEx.entity.EstudianteWeb;
import com.example.CriptoPracticaEx.Repository.EstudianteWebRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteWebService { // Ya no implementa nada

    @Autowired
    private EstudianteWebRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Se quitó @Override
    public List<EstudianteWeb> listar() {
        return repo.findAll();
    }

    // Se quitó @Override
    public EstudianteWeb buscarPorId(Integer id) {
        Optional<EstudianteWeb> opt = repo.findById(id);
        return opt.orElse(null);
    }
    public EstudianteWeb validarPorDniYPassword(String dni, String password) {
        EstudianteWeb estudiante = repo.findByNdniEstdWeb(dni);
        if (estudiante != null && passwordEncoder.matches(password, estudiante.getPassEstd())) {
            return estudiante; // Contraseña válida
        }
        return null; // DNI o contraseña incorrectos
    }

    public String cambiarClave(String dni, String passActual, String passNueva, String confirmarPass) {
        EstudianteWeb estudiante = repo.findByNdniEstdWeb(dni);

        if (estudiante == null) {
            return "No existe un estudiante con el DNI ingresado";
        }

        // Validar contraseña actual
        if (!passwordEncoder.matches(passActual, estudiante.getPassEstd())) {
            return "La contraseña actual es incorrecta";
        }

        // Validar coincidencia de nueva y confirmación
        if (!passNueva.equals(confirmarPass)) {
            return "La nueva contraseña y su confirmación no coinciden";
        }

        // Cifrar y guardar la nueva contraseña
        estudiante.setPassEstd(passwordEncoder.encode(passNueva));
        repo.save(estudiante);

        return "Contraseña actualizada correctamente";
    }

    // Se quitó @Override
    public EstudianteWeb registrar(EstudianteWeb e) {
        return repo.save(e);
    }

    // Se quitó @Override
    public EstudianteWeb actualizar(EstudianteWeb e) {
        return repo.save(e);
    }

    // Se quitó @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}