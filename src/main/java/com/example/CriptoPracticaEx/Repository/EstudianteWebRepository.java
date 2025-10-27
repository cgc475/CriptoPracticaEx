package com.example.CriptoPracticaEx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CriptoPracticaEx.entity.EstudianteWeb;

@Repository
public interface EstudianteWebRepository extends JpaRepository<EstudianteWeb, Integer> {

    // Buscar por login
    EstudianteWeb findByLogiEstd(String logiEstd);

    // Buscar por DNI
    EstudianteWeb findByNdniEstdWeb(String ndniEstdWeb);
}
