package com.Projeto.ProjetoFinal.controller;


import com.Projeto.ProjetoFinal.model.ficha.DadosAlteracaoFicha;
import com.Projeto.ProjetoFinal.model.ficha.DadosCadastroFicha;
import com.Projeto.ProjetoFinal.model.ficha.FichaRepsository;
import com.Projeto.ProjetoFinal.model.ficha.Fichas;
import com.Projeto.ProjetoFinal.model.individuo.IndividuoRepository;
import com.Projeto.ProjetoFinal.model.individuo.Individuos;
import com.Projeto.ProjetoFinal.model.produto.ProdutoRepository;
import com.Projeto.ProjetoFinal.model.produto.Produtos;
import jakarta.transaction.Transactional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fichas")
public class FichaController {

    @Autowired
    private FichaRepsository repsository;
    @Autowired
    private IndividuoRepository repositoryIndividuo;
    @Autowired
    private ProdutoRepository repositoryProduto;




    @GetMapping("/formulario")
    public String carregaFormulario(Long idFicha, Model model){

        if(idFicha != null)
        {
            Fichas f1 = repsository.getReferenceById(idFicha);
            model.addAttribute("fichas",f1);
        }
        model.addAttribute("listaIndividuo", repositoryIndividuo.findAll());
        model.addAttribute("listaProduto", repositoryProduto.findAll());
        return  "/fichas/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model){

        model.addAttribute("lista", repsository.findAll());
        return "/fichas/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraListagem(DadosCadastroFicha dados){

        Fichas f1 = new Fichas(dados);
        repsository.save(f1);
        return "redirect:/fichas/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removeFicha(@RequestParam Long id){

        repsository.deleteById(id);
        return "redirect:/fichas/listagem";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraFicha(DadosAlteracaoFicha dados){

        Fichas f1 = repsository.getReferenceById(dados.idFicha());
        f1.atualizaDados(dados);
        repsository.save(f1);
        return "redirect:/fichas/listagem";
    }

    @GetMapping("/porIndividuo")
    public String buscarFichasPorIndividuo (Long idIndividuo, Model model) {

        if (idIndividuo != null)
        {
            Individuos i1 = repositoryIndividuo.findById(idIndividuo).orElse(null);
            if (i1 != null)
            {
                List<Fichas> fichas = repsository.findByIndividuoNome(i1.getNome());
                model.addAttribute("fichas", fichas);
                model.addAttribute("nome",i1.getNome());
            }
        }
        model.addAttribute("listaIndividuo", repositoryIndividuo.findAll());
        return "/fichas/porIndividuo";
    }

    @GetMapping("/porProduto")
    public String buscarFichasPorProduto (Long idProduto, Model model) {

        if (idProduto != null)
        {
           Produtos p1 = repositoryProduto.findById(idProduto).orElse(null);
            if (p1 != null)
            {
                List<Fichas> fichas = repsository.findByProdutoNome(p1.getNome());
                model.addAttribute("fichas", fichas);
                model.addAttribute("nome",p1.getNome());
            }
        }
        model.addAttribute("listaProduto", repositoryProduto.findAll());
        return "/fichas/porProduto";
    }

    @GetMapping("/porMaisProduto")
    public String buscarProtudoUsadoDigestorio( Model model)
    {
        List<Produtos> produtos = repsository.findProdutosWithMostFichas();
        Produtos p1 = produtos.get(0);
        if (p1 != null)
        {
            List<Fichas> fichas = repsository.findByProdutoNome(p1.getNome());
            model.addAttribute("fichas", fichas);
            model.addAttribute("nome", p1.getNome());
        }
        model.addAttribute("listaProduto", repositoryProduto.findAll());
        return "/fichas/porMaisProduto";
    }

    @GetMapping("/porMaisIndividuo")
    public String buscarIndividuoComMaisFichas(Model model)
    {
        List<Individuos> individuosList = repsository.findIndividuoWithMostFichas();
        Individuos i1 = individuosList.get(0);
        if (i1 != null)
        {
            List<Fichas> fichas = repsository.findByIndividuoNome(i1.getNome());
            model.addAttribute("fichas", fichas);
            model.addAttribute("nome", i1.getNome());
        }
        model.addAttribute("listaIndividuo", repositoryIndividuo.findAll());
        return "/fichas/porMaisIndividuo";

    }

    @GetMapping("/maiorProduto")
    public String buscarProdutoEmMaisFichas(Model model)
    {

        String nomeProduto = repsository.findTopProduto();

        if (nomeProduto != null)
        {
            List<Fichas> fichas = repsository.findByProdutoNome(nomeProduto);
            model.addAttribute("fichas", fichas);
            model.addAttribute("nomeProduto", nomeProduto);
        }
        model.addAttribute("listaProduto", repositoryProduto.findAll());
        return "/fichas/maiorProduto";  // O nome da view que exibirá a lista de filmes
    }

}
