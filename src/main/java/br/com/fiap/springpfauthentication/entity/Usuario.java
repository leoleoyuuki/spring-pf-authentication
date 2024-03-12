package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_PF_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(
            name = "SQ_USUARIO",
            sequenceName = "SQ_USUARIO",
            initialValue = 1,
            allocationSize = 1

    )
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "SENHA_USUARIO")
    private String senha;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "Pessoa",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PESSOA_USUARIO")
    )
    private Pessoa pessoa;
}
