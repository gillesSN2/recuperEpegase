package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PrcCaracteristiqueDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long carId;


    /**
     * date creation
     */
    private LocalDateTime carDateCreat;


    /**
     * date modification
     */
    private LocalDateTime carDateModif;


    /**
     * id user de creation
     */
    private Long carUserCreat;


    /**
     * id user de modification
     */
    private Long carUserModif;


    /**
     * code nature
     */
    private Integer carNature;


    /**
     * libelle nature
     */
    private String carLibNature;


    /**
     * code famille
     */
    private String carFamille;


    /**
     * libelle famille
     */
    private String carLibFamille;


    /**
     * code famille
     */
    private String carSousFamille;


    /**
     * libelle famille
     */
    private String carLibSousFamille;


    /**
     * 0=actif 1=inactif
     */
    private Integer carInactif;


    /**
     * 0=nr 1=mecanique 2=hydraulique 3=elctrique 4=pneumatique 5=equipement 9=autre
     */
    private Integer carOrgane;


    /**
     * 0=document administratif 1=document technique 2=outils 3=consommable 4=piece 5=accessoire 9=autre
     */
    private Integer carInventaire;


    /**
     * 0=caracteristique 1=inventaire
     */
    private Integer carType;


    /**
     * libelle caracteristique
     */
    private String carLibelle;

    private Long famprc1Id;

}
