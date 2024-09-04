package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmActivitesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long actId;


    /**
     * date de creation
     */
    private LocalDateTime actDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime actDateModif;


    /**
     * utilisateur de creation
     */
    private Long actUserCreat;


    /**
     * utilisateur de modification
     */
    private Long actUserModif;


    /**
     * code activite
     */
    private String actCode;


    /**
     * nom activite en FR
     */
    private String actNomFr;


    /**
     * nom activite en UK
     */
    private String actNomUk;


    /**
     * nom activite en SP
     */
    private String actNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer actInactif;


    /**
     * annee de debut de validite
     */
    private Integer actAnneeDebut;


    /**
     * annee de fin de validite
     */
    private Integer actAnneeFin;


    /**
     * 1=autorise dans les ventes
     */
    private Boolean actVte;


    /**
     * 1=autorise dans les achats
     */
    private Boolean actAch;


    /**
     * 1=autorise dans la production
     */
    private Boolean actPrd;


    /**
     * 1=autorise dans les frais generaux
     */
    private Boolean actFrg;


    /**
     * 1=autorise dans les investissements
     */
    private Boolean actInv;


    /**
     * 1=autorise dans la tva
     */
    private Boolean actTva;


    /**
     * 1=autorise dans les impots et taxes
     */
    private Boolean actTax;


    /**
     * 1=autorise dans les salaries
     */
    private Boolean actSal;


    /**
     * 0=sans option 1=num contrat 2=num dossier 3=num or
     */
    private Integer actOptions;


    /**
     * id responsable
     */
    private Long actIdResponsable;


    /**
     * nom responsable
     */
    private String actNomResponsable;


    /**
     * code de regroupement
     */
    private String actRegroupement;


    /**
     * code colonne
     */
    private String actColonne;

}
