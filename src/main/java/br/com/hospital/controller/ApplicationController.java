package br.com.hospital.controller;


import br.com.hospital.DTO.Autenticacao;
import br.com.hospital.model.Paciente;
import br.com.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/login/paciente")
    public ModelAndView login_paciente() {
        ModelAndView mv = new ModelAndView("login_paciente");
        mv.addObject("autenticacao", new Autenticacao());
        return mv;
    }

    @GetMapping("/login/admin")
    public ModelAndView login_admin() {
        ModelAndView mv = new ModelAndView("login_admin");
        mv.addObject("autenticacao", new Autenticacao());
        return mv;
    }

    @PostMapping("/login/paciente")
    public String login_paciente(@ModelAttribute Autenticacao autenticacao) {
        Paciente service = new Paciente();
        if(service.autenticar(autenticacao.getEmail(), autenticacao.getPassword(), repository)) {
            return "redirect:/dashboard/" + repository.findByEmail(autenticacao.getEmail()).get().getId();
        }else{
            return "redirect:/login/paciente?error";
        }
    }

    @PostMapping("/login/admin")
    public String login_admin(@ModelAttribute Autenticacao autenticacao) {
        Paciente service = new Paciente();
        if(autenticacao.getEmail().equals("admin@gmail.com")) {
            return "redirect:/list";
        }else {
            return "redirect:/login/admin?error";
        }
    }



    @GetMapping("/register")
    public ModelAndView registerForm() {
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("paciente", new Paciente());
        return mv;
    }

    @PostMapping("/register")
    public String register(Paciente client) {
        repository.save(client);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("pacientes", repository.findAll());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("register");
        Optional<Paciente> clientFind = repository.findById(id);
        clientFind.ifPresent(client -> mv.addObject("paciente", client));
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/dashboard/{id}")
    public ModelAndView dashboard(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("dashboard");

        mv.addObject( "paciente", repository.findById(id).get());
        return mv;
    }

    @GetMapping("/painel")
    public ModelAndView painel() {
        ModelAndView mv = new ModelAndView("painelMedico");
        mv.addObject("paciente", repository.findAll());
        return mv;
    }



}
