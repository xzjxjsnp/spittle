package spittrtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittrtest.model.Spitter;
import spittrtest.service.SpitterRepositoryImpl;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class RegisterController {
    private SpitterRepositoryImpl spitterRepository;

    @Autowired
    public RegisterController(SpitterRepositoryImpl spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        Spitter spitter1 = new Spitter();
        model.addAttribute("spitter", spitter1);
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registration(@RequestPart("profilePicture")MultipartFile profilePicture, @Valid Spitter spitter, BindingResult result, RedirectAttributes model) throws IOException {

        if(result.hasErrors()){
            return "register";
        }else {
            spitterRepository.saveSpitter(spitter);
            profilePicture.transferTo(new File("D:\\xzj\\work\\project\\spittrtest\\1.png"));
            model.addAttribute("username", spitter.getUsername());
            model.addFlashAttribute("spitter", spitter);
            return "redirect:/spitter/{username}";
        }
    }

    @RequestMapping(value = "spitter/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model) throws IOException{
        if(!model.containsAttribute("spitter")){
            Spitter spitter = spitterRepository.findUser(username);
            model.addAttribute("spitter", spitter);
        }
        return "profile";
    }
}
