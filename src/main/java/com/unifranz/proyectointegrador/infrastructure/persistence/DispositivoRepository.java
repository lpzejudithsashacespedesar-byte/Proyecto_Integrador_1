package com.unifranz.proyectointegrador.application.service;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import java.util.List;

feature/servicio-logica
public interface DispositivoService {
    DispositivoDto guardar(DispositivoDto dispositivoDto);
    List<DispositivoDto> listarPorMarca(String marca);
    DispositivoDto editar(Long id, DispositivoDto dispositivoDto);
    void eliminarLogico(Long id);

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    List<Dispositivo> findByMarcaIgnoreCase(String marca);
    List<Dispositivo> findByActivoTrue();
    List<Dispositivo> findByMarcaAndActivoTrue(String marca);
completar_crud_editar_eliminar
}