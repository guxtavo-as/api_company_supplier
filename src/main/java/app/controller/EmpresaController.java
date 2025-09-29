package app.controller;

import app.model.Empresa;
import app.service.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

  private final EmpresaService empresaService;

  public EmpresaController(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }

  @PostMapping
  public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
    return ResponseEntity.ok(empresaService.salvar(empresa));
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> listar() {
    return ResponseEntity.ok(empresaService.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> buscar(@PathVariable Long id) {
    return empresaService.buscarPorId(id)
            .map(empresa -> {
                Map<String, Object> response = new HashMap<>();
                response.put("company", empresa);
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
    return ResponseEntity.ok(empresaService.atualizar(id, empresa));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    empresaService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
