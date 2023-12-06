package com.example.gestion.des.etudiants.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtudiantReponse {
    private Long Matricule;
    private String Nom;
    private  String Prenom;
    private String date_naissance;
    private String email;
    private String Classe;
    //private Number note;
}
