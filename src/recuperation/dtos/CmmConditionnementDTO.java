package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmConditionnementDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cdtId;


    /**
     * date de creation
     */
    private LocalDateTime cdtDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime cdtDateModif;


    /**
     * user de creation
     */
    private Long cdtUserCreation;


    /**
     * user de modification
     */
    private Long cdtUserModif;


    /**
     * libelle conditionnement
     */
    private String cdtLibelle;


    /**
     * description du conditionnement
     */
    private String cdtDescription;


    /**
     * quantite 1n
     */
    private Float cdtCoef1;


    /**
     * unite
     */
    private String cdtUnite1;


    /**
     * code unite
     */
    private String cdtCodeUnite1;


    /**
     * quantite 2
     */
    private Float cdtCoef2;


    /**
     * unite
     */
    private String cdtUnite2;


    /**
     * code unite
     */
    private String cdtCodeUnite2;


    /**
     * longueur 2
     */
    private Float cdtLong2;


    /**
     * largeur 2
     */
    private Float cdtLarg2;


    /**
     * hauteur 2
     */
    private Float cdtHaut2;


    /**
     * diametre 2
     */
    private Float cdtDiam2;


    /**
     * nombre 2
     */
    private Float cdtNb2;


    /**
     * libelle prochain conditionnement
     */
    private String cdtSuite;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer cdtInactif;

}
