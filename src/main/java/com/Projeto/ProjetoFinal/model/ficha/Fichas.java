package com.Projeto.ProjetoFinal.model.ficha;

import com.Projeto.ProjetoFinal.model.individuo.Individuos;
import com.Projeto.ProjetoFinal.model.produto.Produtos;
import jakarta.persistence.*;

@Entity
@Table(name="fichas")
public class Fichas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFicha;
    @ManyToOne
    @JoinColumn(name = "idIndividuo")
    private Individuos individuo;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produtos produto;
    private Boolean aparelhoDigestorio;
    private Boolean adColicasDorBarriga;
    private Boolean adDorEstomago;
    private Boolean adAziaQueimacao;
    private Boolean adNauseasEnjoo;
    private Boolean adVomito;
    private Boolean adDiarreia;
    private Boolean aparelhoRespiratorio;
    private Boolean arFaltaAr;
    private Boolean arIrritacaoNasal;
    private Boolean arCatarro;
    private Boolean arTosse;

    public Fichas(){}

    public Fichas (DadosCadastroFicha dados){

        this.individuo = dados.individuo();
        this.produto = dados.produto();
        this.aparelhoDigestorio = dados.aparelhoDigestorio();
        this.adColicasDorBarriga = dados.adColicasDorBarriga();
        this.adDorEstomago = dados.adDorEstomago();
        this.adAziaQueimacao = dados.adAziaQueimacao();
        this.adNauseasEnjoo = dados.adNauseasEnjoo();
        this.adVomito = dados.adVomito();
        this.adDiarreia = dados.adDiarreia();
        this.aparelhoRespiratorio = dados.aparelhoRespiratorio();
        this.arFaltaAr = dados.arFaltaAr();
        this.arIrritacaoNasal = dados.arIrritacaoNasal();
        this.arCatarro = dados.arCatarro();
        this.arTosse = dados.arTosse();
    }

    public Long getIdFicha() {
        return idFicha;
    }

    public Individuos getIndividuo() {
        return individuo;
    }

    public Produtos getProduto() {
        return produto;
    }

    public Boolean getAparelhoDigestorio() {
        return aparelhoDigestorio;
    }

    public Boolean getAdDorEstomago() {
        return adDorEstomago;
    }

    public Boolean getAdColicasDorBarriga() {
        return adColicasDorBarriga;
    }

    public Boolean getAdAziaQueimacao() {
        return adAziaQueimacao;
    }

    public Boolean getAdNauseasEnjoo() {
        return adNauseasEnjoo;
    }

    public Boolean getAdVomito() {
        return adVomito;
    }

    public Boolean getAdDiarreia() {
        return adDiarreia;
    }

    public Boolean getArFaltaAr() {
        return arFaltaAr;
    }

    public Boolean getAparelhoRespiratorio() {
        return aparelhoRespiratorio;
    }

    public Boolean getArIrritacaoNasal() {
        return arIrritacaoNasal;
    }

    public Boolean getArCatarro() {
        return arCatarro;
    }

    public Boolean getArTosse() {
        return arTosse;
    }


    public void atualizaDados(DadosAlteracaoFicha dados){
        this.individuo = dados.individuo();
        this.produto = dados.produto();
        this.aparelhoDigestorio = dados.aparelhoDigestorio();
        this.adColicasDorBarriga = dados.adColicasDorBarriga();
        this.adDorEstomago = dados.adDorEstomago();
        this.adAziaQueimacao = dados.adAziaQueimacao();
        this.adNauseasEnjoo = dados.adNauseasEnjoo();
        this.adVomito = dados.adVomito();
        this.adDiarreia = dados.adDiarreia();
        this.aparelhoRespiratorio = dados.aparelhoRespiratorio();
        this.arFaltaAr = dados.arFaltaAr();
        this.arIrritacaoNasal = dados.arIrritacaoNasal();
        this.arCatarro = dados.arCatarro();
        this.arTosse = dados.arTosse();
    }



}
