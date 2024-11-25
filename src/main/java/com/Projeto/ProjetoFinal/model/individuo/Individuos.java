package com.Projeto.ProjetoFinal.model.individuo;

import com.Projeto.ProjetoFinal.model.ficha.Fichas;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name="individuos")
public class Individuos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndividuo;
    private String nome;
    private String telefone;
    private String CPF;

    @OneToMany(mappedBy = "individuo")
    private List<Fichas> listaFichas = new ArrayList<>();

    public Individuos(){}

    public Individuos(DadosCadastroIndividuo dados)
    {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.CPF = dados.CPF();
    }

    public Long getIdIndividuo() {return idIndividuo; }
    public String getNome() {return nome; }
    public String getTelefone() {return telefone; }
    public String getCPF() {return CPF; }

    public void atualizaDados(DadosAlteracaoIndividuo dados)
    {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.CPF = dados.CPF();
    }

}
