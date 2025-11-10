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
//A funções com @GetMapping retornam um ModelAndView

@Controller
public class ApplicationController {
    //O Spring cria uma instância de PacienteRepository
    @Autowired
    private PacienteRepository repository;
    //GetMapping serve para pedir dados ou carregar uma página, é o que acontece
    //ao clicar num link ou digitar uma URL
    @GetMapping("/")
    public ModelAndView home() {
        //viewName é o nome da página html
        return new ModelAndView("home");
    }

    @GetMapping("/login/paciente")
    public ModelAndView login_paciente() {
        ModelAndView mv = new ModelAndView("login_paciente");
        //adiciona um objeto para ser colocado na página, no html ele terá
        //o nome de attributeName é como o objeto será chamado na página html
        mv.addObject("autenticacao", new Autenticacao());
        return mv;
    }

    @GetMapping("/login/admin")
    public ModelAndView login_admin() {
        //Nome da página
        ModelAndView mv = new ModelAndView("login_admin");
        //Objeto da classe Autenticacao que no html terá
        //o nome "autenticacao"
        mv.addObject("autenticacao", new Autenticacao());
        return mv;
    }
    //Essa anotação serve para enviar dados ao servidor
    @PostMapping("/login/paciente")
    public String login_paciente(@ModelAttribute Autenticacao autenticacao) {
        Paciente service = new Paciente();
        if(service.autenticar(autenticacao.getEmail(), autenticacao.getPassword(), repository)) {
        //A concatenação garante que o ID do paciente seja adicionado ao final da URL
            return "redirect:/dashboard/" + repository.findByEmail(autenticacao.getEmail()).get().getId();
        }else{
            return "redirect:/login/paciente?error";
        }
    }

    @PostMapping("/login/admin")
    //@ModelAttribute transforma objetos html em java, e permite obtê-los com métodos
    public String login_admin(@ModelAttribute Autenticacao autenticacao) {
        //Ainda não implementado, não sei por que estava com paciente em vez de admin
        //Paciente service = new Paciente();
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
    //@PathVariable pega o valor do Id da URL e o transforma em Long
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("register");
        //Optional serve pra nos lembrar que pode não achar o cliente,
        //por isso usa o ifPresente logo em seguida
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

        mv.addObject("paciente", repository.findById(id).get());
        return mv;
    }

    @GetMapping("/painel")
    public ModelAndView painel() {
        ModelAndView mv = new ModelAndView("painelMedico");
        //findAll retorna uma lista
        mv.addObject("paciente", repository.findAll());
        return mv;
    }



}
