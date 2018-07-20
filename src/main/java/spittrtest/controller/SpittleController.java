package spittrtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittrtest.error.Error;
import spittrtest.exception.SpitterNotFoundException;
import spittrtest.exception.SpittleNotFoundException;
import spittrtest.model.Spittle;
import spittrtest.service.SpittleRepositoryImpl;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "spittles")
public class SpittleController {
    private SpittleRepositoryImpl spittleRepository;

    @Autowired
    public SpittleController(SpittleRepositoryImpl spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        try{
            model.addAttribute("spittleList", spittleRepository.findSpittle(5));
        }catch (IOException e){
            e.printStackTrace();
        }
        return "spittles";
    }

//    public @ResponseBody
//    List<Spittle> spittles(Model model){
//        try{
//            model.addAttribute("spittleList", spittleRepository.findSpittle(5));
//            return spittleRepository.findSpittle(5);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    @RequestMapping(value = "split",method = RequestMethod.GET)
    public String splitSpittles(@RequestParam(value = "max",defaultValue = "10")long max, @RequestParam(value = "count",defaultValue = "5")int count, Model model){
        try{
            model.addAttribute("spittleList", spittleRepository.splitSpittle(max, count));
        }catch (IOException e){
            e.printStackTrace();
        }
        return "splitSpittles";
    }

//    @RequestMapping(value = "{spittleId}",method = RequestMethod.GET)
//    public String findOneSpittles(@PathVariable("spittleId") int id, Model model){
//        try{
//            Spittle spittle = spittleRepository.findOneSpittle(id);
//            model.addAttribute("spittle", spittle);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return "findOneSpittles";
//    }

    @RequestMapping(value = "{spittleId}",method = RequestMethod.GET)
    public @ResponseBody Spittle findOneSpittles(@PathVariable("spittleId") int id){
        try{
            Spittle spittle = spittleRepository.findOneSpittle(id);
            if(spittle == null){
                throw new SpittleNotFoundException(id);
            }
            return spittle;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
