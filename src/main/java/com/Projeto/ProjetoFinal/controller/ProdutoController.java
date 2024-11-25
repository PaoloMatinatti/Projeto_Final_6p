package com.Projeto.ProjetoFinal.controller;


import com.Projeto.ProjetoFinal.model.ficha.FichaRepsository;
import com.Projeto.ProjetoFinal.model.ficha.Fichas;
import com.Projeto.ProjetoFinal.model.produto.DadosAlteracaoProduto;
import com.Projeto.ProjetoFinal.model.produto.DadosCadastroProduto;
import com.Projeto.ProjetoFinal.model.produto.ProdutoRepository;
import com.Projeto.ProjetoFinal.model.produto.Produtos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController
{
    @Autowired
    private ProdutoRepository repository;
    private FichaRepsository fichaRepsository;

    @GetMapping("/formulario")
    public String carregaFormulario(Long idProduto, Model model)
    {
        if(idProduto != null)
        {
            Produtos p1 = repository.getReferenceById(idProduto);
            model.addAttribute("produtos", p1);
        }
        return "/produtos/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista", repository.findAll());
        return "/produtos/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraProduto(DadosCadastroProduto dados)
    {
        Produtos p1 = new Produtos(dados);
        repository.save(p1);
        return"redirect:/produtos/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removeProduto(@RequestParam Long id)
    {
        repository.deleteById(id);
        return "redirect:/produtos/listagem";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraProduto(DadosAlteracaoProduto dados)
    {
        Produtos p1 = repository.getReferenceById(dados.idProduto());
        p1.atualizaDados(dados);
        repository.save(p1);
        return "redirect:/produtos/listagem";
    }


}
