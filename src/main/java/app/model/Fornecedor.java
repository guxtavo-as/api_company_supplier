package app.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "fornecedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String cpfCnpj;

  @Column(nullable = false)
  private String nome;

  private String email;

  @Column(nullable = false)
  private String cep;

  @Column
  private String rg;

  @Column
  private LocalDate dataNascimento;

  @ManyToMany(mappedBy = "fornecedores")
  private Set<Empresa> empresas;
}
