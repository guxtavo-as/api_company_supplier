package app.service;

import app.model.Fornecedor;
import app.repository.FornecedorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

  private final FornecedorRepository fornecedorRepository;

  public FornecedorService(FornecedorRepository fornecedorRepository) {
    this.fornecedorRepository = fornecedorRepository;
  }

  public Fornecedor salvar(Fornecedor fornecedor) {
    if (fornecedorRepository.existsByCpfCnpj(fornecedor.getCpfCnpj())) {
      throw new IllegalArgumentException("CPF/CNPJ já cadastrado");
    }

    return fornecedorRepository.save(fornecedor);
  }

  public List<Fornecedor> listar(String nome, String cpfCnpj) {
    if (cpfCnpj != null) {
      return fornecedorRepository.findByCpfCnpj(cpfCnpj)
              .map(List::of)
              .orElse(List.of());
    }
    if (nome != null){
      return fornecedorRepository.findByNomeContainingIgnoreCase(nome);
    }
    return fornecedorRepository.findAll();
  }

  public Optional<Fornecedor> buscarPorId(Long id) {
    return fornecedorRepository.findById(id);
  }

  public Fornecedor atualizar(Long id, Fornecedor newFornecedor) {
    return fornecedorRepository.findById(id)
            .map(fornecedor -> {
              fornecedor.setNome(newFornecedor.getNome());
              fornecedor.setCpfCnpj(newFornecedor.getCpfCnpj());
              fornecedor.setEmail(newFornecedor.getEmail());
              fornecedor.setCep(newFornecedor.getCep());
              fornecedor.setRg(newFornecedor.getRg());
              fornecedor.setDataNascimento(newFornecedor.getDataNascimento());
              return fornecedorRepository.save(fornecedor);
            })
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
  }

  public void deletar(Long id) {
    fornecedorRepository.deleteById(id);
  }
}
