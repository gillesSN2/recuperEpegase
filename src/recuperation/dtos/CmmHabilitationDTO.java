package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmHabilitationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long habId;


    /**
     * 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer habNature;


    /**
     * 0=mono signature 1=multi signature
     */
    private Integer habMode;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser1Cat;


    /**
     * id user
     */
    private Long habUser1Id;


    /**
     * nom et prenom user
     */
    private String habUser1Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser2Cat;


    /**
     * id user
     */
    private Long habUser2Id;


    /**
     * nom et prenom user
     */
    private String habUser2Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser3Cat;


    /**
     * id user
     */
    private Long habUser3Id;


    /**
     * nom et prenom user
     */
    private String habUser3Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser4Cat;


    /**
     * id user
     */
    private Long habUser4Id;


    /**
     * nom et prenom user
     */
    private String habUser4Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser5Cat;


    /**
     * id user
     */
    private Long habUser5Id;


    /**
     * nom et prenom user
     */
    private String habUser5Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer habUser6Cat;


    /**
     * id user
     */
    private Long habUser6Id;


    /**
     * nom et prenom user
     */
    private String habUser6Nom;


    /**
     * id remplacant
     */
    private Long habRemplace1Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace1Nom;


    /**
     * id remplacant
     */
    private Long habRemplace2Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace2Nom;


    /**
     * id remplacant
     */
    private Long habRemplace3Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace3Nom;


    /**
     * id remplacant
     */
    private Long habRemplace4Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace4Nom;


    /**
     * id remplacant
     */
    private Long habRemplace5Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace5Nom;


    /**
     * id remplacant
     */
    private Long habRemplace6Id;


    /**
     * nom et prenom remplacant
     */
    private String habRemplace6Nom;

}
