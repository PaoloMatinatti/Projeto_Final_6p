package com.Projeto.ProjetoFinal.model.ficha;

import com.Projeto.ProjetoFinal.model.individuo.Individuos;
import com.Projeto.ProjetoFinal.model.produto.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FichaRepsository extends JpaRepository<Fichas, Long> {
    //Derived Query
    List<Fichas> findByIndividuoNome(String nome);
    List<Fichas> findByProdutoNome (String nome) ;

    //JPQL
    @Query("SELECT f.produto FROM Fichas f GROUP BY f.produto ORDER BY COUNT(f) DESC")
    List<Produtos> findProdutosWithMostFichas();

    @Query("SELECT f.individuo FROM Fichas f GROUP BY f.individuo ORDER BY COUNT(f) DESC")
    List<Individuos> findIndividuoWithMostFichas();

    //NativeQuerry = true
    @Query(value = "SELECT p.nome FROM produtos p " +
            "JOIN fichas f on f.id_produto = p.id_produto " +
            "GROUP BY p.id_produto " +
            "ORDER BY COUNT(f.id_ficha) DESC " +
            "LIMIT 1                                                                                                                                                                                                                                                                                                                                                                          ",
            nativeQuery = true)
    String findTopProduto();
}
