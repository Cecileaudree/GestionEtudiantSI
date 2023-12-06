package com.example.gestion.des.etudiants.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtudiantRequete {
    private String Nom;
    private  String Prenom;
    private String date_naissance;
    private String email;
    private String Classe;
}
