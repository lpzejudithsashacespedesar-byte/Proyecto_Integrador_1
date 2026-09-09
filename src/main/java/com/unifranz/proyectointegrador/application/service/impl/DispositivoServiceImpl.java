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
        entidad.setActivo(true);

        Dispositivo guardado = dispositivoRepository.save(entidad);
        return convertirADto(guardado);
    }

    @Override
    public List<DispositivoDto> listarPorMarca(String marca) {
        List<Dispositivo> lista = (marca == null || marca.isEmpty())
                ? dispositivoRepository.findAll()
                : dispositivoRepository.findByMarcaIgnoreCase(marca);

        return lista.stream()
                .filter(Dispositivo::isActivo)
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    @Override
    public DispositivoDto editar(Long id, DispositivoDto dto) {
        Dispositivo entidad = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado con id: " + id));

        entidad.setNombre(dto.getNombre());
        entidad.setMarca(dto.getMarca());
        entidad.setPrecio(dto.getPrecio());

        Dispositivo actualizado = dispositivoRepository.save(entidad);
        return convertirADto(actualizado);
    }

    @Override
    public void eliminarLogico(Long id) {
        Dispositivo entidad = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado con id: " + id));

        entidad.setActivo(false);
        dispositivoRepository.save(entidad);
    }

    private DispositivoDto convertirADto(Dispositivo d) {
        DispositivoDto dto = new DispositivoDto();
        dto.setId(d.getId());
        dto.setNombre(d.getNombre());
        dto.setMarca(d.getMarca());
        dto.setPrecio(d.getPrecio());
        dto.setActivo(d.isActivo());
        return dto;
    }
}
