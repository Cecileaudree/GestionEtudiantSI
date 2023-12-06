package com.example.gestion.des.etudiants.Repository;

import com.example.gestion.des.etudiants.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

}
