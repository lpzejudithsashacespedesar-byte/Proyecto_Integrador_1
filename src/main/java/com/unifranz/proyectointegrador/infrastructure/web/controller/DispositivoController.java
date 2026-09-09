package com.unifranz.proyectointegrador.infrastructure.web.controller;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import com.unifranz.proyectointegrador.application.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/celulares")
public class DispositivoController {

    @Autowired
    private DispositivoService servicio;

    // BUSCAR POR MARCA
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<DispositivoDto>> buscarPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(servicio.listarPorMarca(marca));
    }

    // CREAR
    @PostMapping
    public ResponseEntity<DispositivoDto> crear(@RequestBody DispositivoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.guardar(dto));
    }

    // EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<DispositivoDto> editar(@PathVariable Long id, @RequestBody DispositivoDto dto) {
        return ResponseEntity.ok(servicio.editar(id, dto));
    }

    // ELIMINADO LÓGICO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        servicio.eliminarLogico(id);
        return ResponseEntity.noContent().build();
    }
}