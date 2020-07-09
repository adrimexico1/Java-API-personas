/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adrian
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestControllerCrud {
    
    @Autowired
    private RepositoryPersona repo;
    
    @GetMapping(path ="/personarest")
    public List<ModelPersonas>listar(){
    return repo.findAll();
    }
    
      @GetMapping(path = "/personas/{clave}")
    public Optional<ModelPersonas> getPersonaById(@PathVariable String clave) {
          
        return repo.findById(clave);
    }
   
    @PostMapping(path ="/personarest")
    public void insertar(@RequestBody ModelPersonas per){
    repo.save(per);
    }
   
//    @PutMapping(path="/personarest")
//    public void modificar(@RequestBody ModelPersonas per){
//    repo.save(per);
//    }
//    @PutMapping(path="/personarest/{clave}")
//    public ModelPersonas modificar(@RequestBody ModelPersonas per, @PathVariable("clave") String clave){
//    per.setClave(clave);
//    return repo.save(per);
//    }
    @PutMapping(path="/personarest")
    public void updatePersona(@RequestBody ModelPersonas per){
        repo.save(per);
       }
   
    @DeleteMapping(value ="personarest/{clave}")
    public void eleminar(@PathVariable("clave") String clave){
    repo.deleteById(clave);
    }
    
}
