package com.unifranz.proyectointegrador.infrastructure.persistence;

import com.unifranz.proyectointegrador.domain.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByMarcaIgnoreCase(String marca);
    List<Dispositivo> findByActivoTrue();
    List<Dispositivo> findByMarcaAndActivoTrue(String marca);
}