package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;
    @ManyToOne
    private Chambre chambre;
    @ManyToMany(mappedBy = "reservations")
    private List<Etudiant> etudiants;



    public long  getIdReservation() {
        return idReservation;

    }


    public void setNumReservation(String s) {
    }

    public void setEtudiant(Etudiant etudiant) {
        
    }
}
