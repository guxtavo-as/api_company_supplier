package app.repository;

import app.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
  Optional<Fornecedor> findByCpfCnpj(String cpfCnpj);

  Optional<Fornecedor> findById(Long id);

  Optional<Fornecedor> findByNome(String nome);

  boolean existsByCpfCnpj(String cpfCnpj);

  List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
}
