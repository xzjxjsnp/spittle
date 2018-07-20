package spittrtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import spittrtest.model.Spittle;
import spittrtest.service.SpittleRepositoryImpl;

import java.io.IOException;
import java.net.URI;

@Controller
public class AddSpittlesController {
    private SpittleRepositoryImpl spittleRepository;

    @Autowired
    public AddSpittlesController(SpittleRepositoryImpl spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping("add")
    public String addSpittles(){
        return "addSpittles";
    }

//    @RequestMapping(value = "addSpittle", method = RequestMethod.POST)
//    public String insertSpittle(Spittle spittle){
//        try{
//            spittleRepository.insertSpittle(spittle);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return "redirect:/add";
//    }

    @RequestMapping(value = "addSpittle", method = RequestMethod.POST)
    public ResponseEntity<Spittle> insertSpittle(Spittle spittle, UriComponentsBuilder ucb){
        try{
            Spittle spittle1 = spittleRepository.insertSpittle(spittle);
            HttpHeaders httpHeaders = new HttpHeaders();
            URI locationUri = ucb.path("/spittles/").path(String.valueOf(spittle.getId())).build().toUri();
            httpHeaders.setLocation(locationUri);

            return new ResponseEntity<Spittle>(spittle1, httpHeaders, HttpStatus.CREATED);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
