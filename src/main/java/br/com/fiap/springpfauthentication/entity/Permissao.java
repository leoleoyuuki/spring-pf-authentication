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

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PF_SISTEMA",
            joinColumns = {
                    @JoinColumn(
                            name = "PERMISSAO",
                            referencedColumnName = "ID_PERMISSAO",
                            foreignKey = @ForeignKey(
                                    name = "FK_PESSOA_PERMISSAO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "SISTEMA",
                            referencedColumnName = "ID_SISTEMA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PERMISSAO_SISTEMA"

                            )

                    )
            }

    )
    private Sistema sistema;

}
