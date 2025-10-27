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


    // Se quitó @Override
    public List<EstudianteWeb> listar() {
        return repo.findAll();
    }

    // Se quitó @Override
    public EstudianteWeb buscarPorId(Integer id) {
        Optional<EstudianteWeb> opt = repo.findById(id);
        return opt.orElse(null);
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