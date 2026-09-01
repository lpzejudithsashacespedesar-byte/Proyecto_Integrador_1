package com.unifranz.proyectointegrador.application.service.impl;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import com.unifranz.proyectointegrador.application.service.DispositivoService;
import com.unifranz.proyectointegrador.domain.Dispositivo;
import com.unifranz.proyectointegrador.infrastructure.persistence.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Override
    public DispositivoDto guardar(DispositivoDto dto) {
        Dispositivo entidad = new Dispositivo();
        entidad.setNombre(dto.getNombre());
        entidad.setMarca(dto.getMarca());
        entidad.setPrecio(dto.getPrecio());

        Dispositivo guardado = dispositivoRepository.save(entidad);
        return new DispositivoDto(guardado.getNombre(), guardado.getMarca(), guardado.getPrecio());
    }

    @Override
    public List<DispositivoDto> listarPorMarca(String marca) {
        List<Dispositivo> lista = (marca == null || marca.isEmpty())
                ? dispositivoRepository.findAll()
                : dispositivoRepository.findByMarcaIgnoreCase(marca);

        return lista.stream()
                .map(d -> new DispositivoDto(d.getNombre(), d.getMarca(), d.getPrecio()))
                .collect(Collectors.toList());
    }
}