package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Livro;
import application.model.LivroRepository;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepo;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("livros", livroRepo.findAll());
        return "/livro/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "/livro/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);



        livroRepo.save(livro);
        return "redirect:/livro/list";
    }
    @RequestMapping("/update")
    public String update(Model model,
     @RequestParam("id") int id){
        Optional<Livro> livro = livroRepo.findById(id);
        if(livro.isPresent()){
           model.addAttribute("livro", livro.get());
            return "/livro/update";
    }
    return "redirect:/livro/list";


}
@RequestMapping("/delete")
public String update(Model model, @RequestParam("id") int id){
    Optional<Livro> livro = livroRepo.findById(id);
    if(livro.isPresent()){
       model.addAttribute("livro", livro.get());
        return "/livro/delete";

}
return "redirect:/livro/list";
}
