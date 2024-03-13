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
@Table(name = "TB_PF_PERMISSAO")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
    @SequenceGenerator(
            name = "SQ_PERMISSAO",
            sequenceName = "SQ_PERMISSAO",
            initialValue = 1,
            allocationSize = 1

    )
    @Column(name = "ID_PERMISSAO")
    private Long id;

    @Column(name = "NM_PERMISSAO")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "SISTEMA",
            referencedColumnName = "ID_SISTEMA",
            foreignKey = @ForeignKey(name = "FK_SISTEMA_PERMISSAO")
    )
    private Sistema sistema;


}
