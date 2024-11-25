package com.Projeto.ProjetoFinal.controller;


import com.Projeto.ProjetoFinal.model.individuo.DadosAlteracaoIndividuo;
import com.Projeto.ProjetoFinal.model.individuo.DadosCadastroIndividuo;
import com.Projeto.ProjetoFinal.model.individuo.IndividuoRepository;
import com.Projeto.ProjetoFinal.model.individuo.Individuos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/individuos")
public class IndividuoController
{
    @Autowired
    private IndividuoRepository repository;

    @GetMapping("/formulario")
    public String carregaFormulario(Long idIndividuo, Model model)
    {
        if(idIndividuo != null)
        {
            Individuos i1 = repository.getReferenceById(idIndividuo);
            model.addAttribute("individuos", i1);
        }
        return "/individuos/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista", repository.findAll());
        return "/individuos/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraIndividuo(DadosCadastroIndividuo dados)
    {
      Individuos i1 = new Individuos(dados);
      repository.save(i1);
      return "redirect:/individuos/listagem";
    }

    @DeleteMapping
    @Transactional
    public String removeIndividuo(@RequestParam Long id)
    {
        repository.deleteById(id);
        return "redirect:/individuos/listagem";
    }

    @PutMapping("/formulario")
    @Transactional
    public String alteraIndividuo(DadosAlteracaoIndividuo dados)
    {
        Individuos i1 = repository.getReferenceById(dados.idIndividuo());
        i1.atualizaDados(dados);
        repository.save(i1);
        return "redirect:/individuos/listagem";
    }



}
