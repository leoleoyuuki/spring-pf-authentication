package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_PF_SISTEMA")
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(
            name = "SQ_SISTEMA",
            sequenceName = "SQ_SISTEMA",
            initialValue = 1,
            allocationSize = 1

    )
    @Column(name = "ID_SISTEMA")
    private Long id;

    @Column(name = "NM_SISTEMA")
    private String nome;

    @Column(name= "SG_SISTEMA")
    private String sigla;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_PF_USUARIO",
            joinColumns = {
                    @JoinColumn(
                            name = "SISTEMA",
                            referencedColumnName = "ID_SISTEMA",
                            foreignKey = @ForeignKey(
                                    name = "FK_RESPONSAVEIS_SISTEMA"
                            )
                    )
            },
            inverseJoinColumns = {
                @JoinColumn(
                        name = "USUARIO",
                        referencedColumnName = "ID_USUARIO",
                        foreignKey = @ForeignKey(
                                name = "FK_SISEMA_RESPONSAVEIS"

                        )

                )
            }

    )
    private Set<Usuario> responsaveis = new LinkedHashSet<>();
}
