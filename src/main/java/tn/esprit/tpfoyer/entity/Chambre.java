package tn.esprit.tpfoyer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre  implements Serializable {
    @Id
    private Long idChambre;
    private Long numeroChambre;
    private TypeChambre typeChambre;



}
