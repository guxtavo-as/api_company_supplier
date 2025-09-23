package app.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String cnpj;

  @Column(nullable = false)
  private String nomeFantasia;

  @Column(nullable = false)
  private String cep;

  @ManyToMany
  @JoinTable(
    name = "empresa_fornecedor",
    joinColumns = @JoinColumn(name = "empresa_id"),
    inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
  )
  private Set<Fornecedor> fornecedores;
}
