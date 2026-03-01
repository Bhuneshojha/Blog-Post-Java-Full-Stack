package com.blog.BlogingProject.Controller;
import com.blog.BlogingProject.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.blog.BlogingProject.repository.blogrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    blogrepo repo;

    @GetMapping("/")
    public String ViewHome(Model model){
        model.addAttribute("listPosts",repo.findAll());
        return "index";

    }

    @GetMapping("/new")
    public String newPost(Model model){
        model.addAttribute("post",new Post());
        return "new_post";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";
    }

    @GetMapping("/editById")
    public String editPost(@RequestParam int id, Model model){
        Post post = repo.findById(id).orElse(null);
         if(post==null){
             return "redirect:/";
         }
        model.addAttribute("post",post);
        return "edit_post";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post){
        repo.save(post);
        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/";
    }






}
