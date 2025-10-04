package br.ifsul.filme.crud;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 1200)
    private String titulo;

    @Column(name = "diretor", length = 1200)
    private String diretor;

    @Column(name = "ano_lancamento")
    private int anoLancamento;
}
