package com.example.board_api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class AuthorController {
    AuthorController(){
        Author.authors.add(new Author("김선국1", "kim1@naver.com", "password1"));
        Author.authors.add(new Author("김선국2", "kim2@naver.com", "password1"));
        Author.authors.add(new Author("김선국3", "kim3@naver.com", "password1"));
    }


    @PostMapping("/author/register1")
    public void authorRegister1(@RequestBody Author body){
        Author.authors.add(new Author(body.getName(), body.getEmail(), body.getEmail()));
    }

    @PostMapping("/author/register2")
    public void authorRegister2(Author body){
        Author.authors.add(new Author(body.getName(), body.getEmail(), body.getEmail()));
    }
    @GetMapping("/author/list")
    @ResponseBody
    public List<Author> authorList(){
        return Author.authors;
    }

    @GetMapping("/author/detail/{id}")
    @ResponseBody
    public Author authorDetail(@PathVariable Long id) {
        for(Author a : Author.authors){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
    @GetMapping("/author/detailparam")
    @ResponseBody
    public Author authorDetailParam(@RequestParam Long id) {
        for(Author a : Author.authors){
            if(a.getId()==id){
                return a;
            }
        }
        return null;
    }
}
