package com.example.gestion.des.etudiants.Service;

import com.example.gestion.des.etudiants.Dto.EtudiantReponse;
import com.example.gestion.des.etudiants.Dto.EtudiantRequete;
import com.example.gestion.des.etudiants.Entity.Etudiant;
import com.example.gestion.des.etudiants.Repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EtudiantService {

    private  final EtudiantRepository etudiantRepository;
    private Field etudiantRequete;

    public  Etudiant  create_Etudiant(EtudiantRequete etudiantRequete){
       //Etudiant etudiant = new Etudiant();
       //etudiant.setNom(etudiantRequete.getNom());
       //etudiant.setPrenom(etudiantRequete.getPrenom());
        Etudiant etudiant = Etudiant.builder()
                .Nom(etudiantRequete.getNom())
                .Prenom(etudiantRequete.getPrenom())
                .date_naissance(etudiantRequete.getDate_naissance())
                .Classe(etudiantRequete.getClasse())
                .email(etudiantRequete.getEmail())
                .build();


        return  etudiantRepository.save(etudiant);
    }

    public List<EtudiantReponse> getAllEtudiant(){
        List<Etudiant> etudiantList= etudiantRepository.findAll();
        return etudiantList.stream().map(this::mapToresponse).toList();
    }

    private EtudiantReponse mapToresponse(Etudiant etudiant){
        return EtudiantReponse.builder()
                .Matricule(etudiant.getMatricule())
                .Nom(etudiant.getNom())
                .Prenom(etudiant.getPrenom())
                .date_naissance(etudiant.getDate_naissance())
                .email(etudiant.getEmail())
                .Classe(etudiant.getClasse())
                .build();
    }

    public Optional<Etudiant> existe(Long id){
        Optional <Etudiant> etudiant_existe= etudiantRepository.findById(id);
        return  etudiant_existe;
    }

    public String Supp_Etud(Long id){
        etudiantRepository.deleteById(id);
        return "l'etudiant"+id+"a été supprimer";
    }

   // public String Modifier(Long id, String champ, String valeur)  {
       // etudiantRepository.deleteById(id).isPresent(entite ->{
           // Field field= EtudiantRequete.
       // })


    //}
}
