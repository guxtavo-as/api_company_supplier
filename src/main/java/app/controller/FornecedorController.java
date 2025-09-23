package app.controller;

import app.model.Fornecedor;
import app.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

  private final FornecedorService fornecedorService;

  public FornecedorController(FornecedorService fornecedorService) {
    this.fornecedorService = fornecedorService;
  }

  @PostMapping
  public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor) {
    return ResponseEntity.ok(fornecedorService.salvar(fornecedor));
  }

  @GetMapping
  public ResponseEntity<List<Fornecedor>> listar(
    @RequestParam(required = false) String nome,
    @RequestParam(required = false) String documento
  ) {
    return ResponseEntity.ok(fornecedorService.listar(nome, documento));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Fornecedor> buscar(@PathVariable Long id) {
    return fornecedorService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
    return ResponseEntity.ok(fornecedorService.atualizar(id, fornecedor));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    fornecedorService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
