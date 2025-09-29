package app.controller;

import app.model.Fornecedor;
import app.service.FornecedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
  public ResponseEntity<Map<String, Object>> listar() {
    return ResponseEntity.ok(fornecedorService.listar());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> buscar(@PathVariable Long id) {
    return fornecedorService.buscarPorId(id)
            .map(fornecedor -> {
                Map<String, Object> response = new HashMap<>();
                response.put("supplier", fornecedor);
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/nome/{nome}")
  public ResponseEntity<Map<String, Object>> buscarNome(@PathVariable String nome) {
    return fornecedorService.buscarPorNome(nome)
            .map(fornecedor -> {
                Map<String, Object> response = new HashMap<>();
                response.put("supplier", fornecedor);
                return ResponseEntity.ok(response);
            })
            .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/cpf_cnpj/{cpf_cnpj}")
  public ResponseEntity<Map<String, Object>> buscarCpfCnpj(@PathVariable String cpf_cnpj) {
    return fornecedorService.buscarPorCpfCnpj(cpf_cnpj)
            .map(fornecedor -> {
                Map<String, Object> response = new HashMap<>();
                response.put("supplier", fornecedor);
                return ResponseEntity.ok(response);
            })
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
