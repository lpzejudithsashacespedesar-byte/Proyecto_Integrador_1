package com.unifranz.proyectointegrador.infrastructure.web.controller;

import com.unifranz.proyectointegrador.application.dto.DispositivoDto;
import com.unifranz.proyectointegrador.application.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/celulares")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    // 1. GUARDAR
    @PostMapping
    public ResponseEntity<DispositivoDto> guardar(@RequestBody DispositivoDto dto) {
        return ResponseEntity.ok(dispositivoService.guardar(dto));
    }

    // 2. LISTAR TODOS (Como en la foto de tu compañero)
    @GetMapping
    public ResponseEntity<List<DispositivoDto>> listarTodos() {
        return ResponseEntity.ok(dispositivoService.listarPorMarca(null));
    }

    // 3. BUSCAR POR MARCA
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<DispositivoDto>> buscarPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(dispositivoService.listarPorMarca(marca));
    }
}