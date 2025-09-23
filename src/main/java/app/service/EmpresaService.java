package app.service;

import app.model.Empresa;
import app.repository.EmpresaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

  private final EmpresaRepository empresaRepository;

  public EmpresaService(EmpresaRepository empresaRepository) {
    this.empresaRepository = empresaRepository;
  }

  public Empresa salvar(Empresa empresa) {
    if (empresaRepository.existsByCnpj(empresa.getCnpj())) {
      //throw new IllegalArgumentException("CNPJ já cadastrado");
      return "CNPJ já cadastrado";
    }

    return empresaRepository.save(empresa);
  }

  public Optional<Empresa> buscarPorId(Long id) {
    return empresaRepository.findById(id);
  }

  public List<Empresa> listar() {
    return empresaRepository.findAll();
  }

  public Empresa atualizar(Long id, Empresa newEmpresa) {
    return empresaRepository.findById(id)
            .map(empresa -> {
              empresa.setCnpj(newEmpresa.getCnpj());
              empresa.setNomeFantasia(newEmpresa.getNomeFantasia());
              empresa.setCep(newEmpresa.getCep());
              return empresaRepository.save(empresa);
            })
            .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
  }

  public void deletar(Long id) {
    empresaRepository.deleteById(id);
  }
}
