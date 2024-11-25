package com.Projeto.ProjetoFinal.model.produto;


import com.Projeto.ProjetoFinal.model.ficha.Fichas;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nome;
    private String classificacao;

    @OneToMany(mappedBy = "produto")
    private List<Fichas> listaProdutos = new ArrayList<>();

    public Produtos () {};

    public Produtos (DadosCadastroProduto dados){
        this.nome = dados.nome();
        this.classificacao = dados.classificacao();
    }

    public Long getIdProduto() {return idProduto;}
    public String getNome() {return nome;}
    public String getClassificacao() { return classificacao;}

    public void atualizaDados(DadosAlteracaoProduto dados) {
        this.nome = dados.nome();
        this.classificacao = dados.classificacao();
    }

}
