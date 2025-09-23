package app.repository;

import app.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
  Optional<Empresa> findById(Long id);

  boolean existsByCnpj(String cnpj);
}
