package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    TodoListRepository todoListRepository;

    @RequestMapping("/")
    public String todoListHomepage(Model model){
        model.addAttribute("todoList", todoListRepository.findAll());
        return "todoListHome";
    }
    @GetMapping("/add")
    public String todoList(Model model) {
        model.addAttribute("todoList", new TodoList());
        return "todoList";}

        @PostMapping("/process")
        public String processTodoList(@Valid TodoList todoList, BindingResult result){
            if (result.hasErrors()) {
                return "todoList";
            }
            todoListRepository.save(todoList);
            return "redirect:/";
        }
    @RequestMapping("/detail/{id}")
    public String showTodo(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("todo", todoListRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") long id, Model model){
        model.addAttribute("todoList",todoListRepository.findById(id).get());
        return "todoList";
    }
    @RequestMapping("/delete/{id}")
    public String delTodo(@PathVariable("id") long id) {
        todoListRepository.deleteById(id);
        return "redirect:/";
    }
    }