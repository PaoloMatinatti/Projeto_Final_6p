package com.Projeto.ProjetoFinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class MenuController {
    @GetMapping("/principal")
    public String carregaFormulario(){return "/menus/principal";}
}
