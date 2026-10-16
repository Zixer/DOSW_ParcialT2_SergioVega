package edu.eci.dosw.oficioya.controller;

import edu.eci.dosw.oficioya.model.usuarios;
import edu.eci.dosw.oficioya.service.usuariosService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usurarios",description = "Operaciones relacionadas con la gestión de usuarios")
public class usuariosController {

    private final UsuarioService UsuarioService;

    public usuariosController(usuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    @Operation(summary = "Listar usuarios",description = "Devuelve la lista de usuarios registrados")
    public ResponseEntity<List<usuarios>> listar() {
        return ResponseEntity.ok(usuariosService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuarios por ID",description = "Busca y devuelve un usuarios utilizando su identificador")
    public ResponseEntity<usuario> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear usuarios",description = "Registra un nuevo usuarios en el sistema")
    public ResponseEntity<usuario> crear( @RequestBody usuarios usuarios) {

        usuarios creado =usuariosService.crear(usuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar usuarios",description = "Modifica la información de un usuario existente")
    public ResponseEntity<usuario> actualizar(@PathVariable Long id, @RequestBody usuarios usuarios) {
        return ResponseEntity.ok(usuariosService.actualizar(id, usuarios));
    }

    @PatchMapping("/{id}/inactivar")
    @Operation( summary = "Inactivar usuarios", description = "Inactiva un usuario sin eliminarlo del sistema")
    public ResponseEntity<usuario> inactivar(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.desactivar(id));
    }
}