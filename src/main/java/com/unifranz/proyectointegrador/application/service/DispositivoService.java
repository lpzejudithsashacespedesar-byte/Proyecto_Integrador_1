package com.unifranz.proyectointegrador.application.service;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import java.util.List;

public interface DispositivoService {
    DispositivoDto guardar(DispositivoDto dispositivoDto);
    List<DispositivoDto> listarPorMarca(String marca);
}