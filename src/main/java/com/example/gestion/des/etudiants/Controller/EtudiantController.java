package com.example.gestion.des.etudiants.Controller;

import com.example.gestion.des.etudiants.Dto.EtudiantReponse;
import com.example.gestion.des.etudiants.Dto.EtudiantRequete;
import com.example.gestion.des.etudiants.Entity.Etudiant;
import com.example.gestion.des.etudiants.Service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/etudiant")
public class EtudiantController {
    @Autowired
    private  EtudiantService etudiantService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/controle/{id}")
    public boolean verification(@PathVariable Long id){

        //String str= restTemplate.getForObject("http://localhost:8091/api/inscrit/controle",String.class);
        //return str + "=>je suis là";
       // return etudiantService.existe(Long.valueOf(1)).isPresent();
        return etudiantService.existe(id).isPresent();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String  Create_Etudiant(@RequestBody EtudiantRequete etudiantRequete){
        //System.out.println(etudiantRequete.getNom());
        etudiantService.create_Etudiant(etudiantRequete);
        return "ok";
    }

    @GetMapping("/listEtud")
    @ResponseStatus(HttpStatus.OK)
    public List<EtudiantReponse> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }

    @DeleteMapping("/delt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delt(@PathVariable Long id){
        String reponse= etudiantService.Supp_Etud(id);
        return reponse;
    }

    @PutMapping("/modifier/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String Modifier(@PathVariable Long id){
        return "ok";
    }

}
