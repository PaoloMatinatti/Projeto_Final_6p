package com.Projeto.ProjetoFinal.model.ficha;

import com.Projeto.ProjetoFinal.model.individuo.Individuos;
import com.Projeto.ProjetoFinal.model.produto.Produtos;

public record DadosCadastroFicha(Individuos individuo, Produtos produto, Boolean aparelhoDigestorio, Boolean adColicasDorBarriga,
                                 Boolean adDorEstomago, Boolean adAziaQueimacao, Boolean adNauseasEnjoo, Boolean adVomito,
                                 Boolean adDiarreia, Boolean aparelhoRespiratorio, Boolean arFaltaAr, Boolean arIrritacaoNasal,
                                 Boolean arCatarro, Boolean arTosse) {
}
