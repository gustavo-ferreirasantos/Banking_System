//package br.com.bankingsystem.controller;
//
//
//import br.com.bankingsystem.model.Task;
//import br.com.bankingsystem.repository.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@Controller
//public class TaskController {
//
//  @Autowired
//  private TaskRepository repository;
//
//  @GetMapping("/")
//  public ModelAndView login() {
//    return new ModelAndView("login");
//  }
//
//  @GetMapping("/register")
//  public ModelAndView registerForm() {
//    ModelAndView mv = new ModelAndView("register");
//    mv.addObject("task", new Task());
//    return mv;
//  }
//
//  @PostMapping("/register")
//  public String register(Task task) {
//    repository.save(task);
//    return "redirect:/list";
//  }
//
//  @GetMapping("/list")
//  public ModelAndView list() {
//    ModelAndView mv = new ModelAndView("list");
//    mv.addObject("tasks", repository.findAll());
//    return mv;
//  }
//
//  @GetMapping("/edit/{id}")
//  public ModelAndView edit(@PathVariable("id") Long id) {
//    ModelAndView mv = new ModelAndView("register");
//    Optional<Task> taskFind = repository.findById(id);
//    taskFind.ifPresent(task -> mv.addObject("task", task));
//    return mv;
//  }
//
//  @GetMapping("/delete/{id}")
//  public String delete(@PathVariable("id") Long id) {
//    repository.deleteById(id);
//    return "redirect:/list";
//  }
//}
