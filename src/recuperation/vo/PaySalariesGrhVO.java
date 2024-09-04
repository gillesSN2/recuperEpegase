package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class PaySalariesGrhVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salgrhId can not null")
    private Long salgrhId;


    /**
     * date de creation
     */
    private LocalDateTime salgrhDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salgrhDateModif;


    /**
     * utilisateur de creation
     */
    private Long salgrhUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salgrhUserModif;


    /**
     * numero rh
     */
    private String salgrhNum;


    /**
     * 0=accident 1=affectation 2=attestation 3=avertissement...
     */
    private Integer salgrhNature;


    /**
     * date evenement
     */
    private LocalDate salgrhDate;


    /**
     * objet evenement
     */
    private String salgrhObjet;


    /**
     * texte evenement
     */
    private String salgrhTexte;


    /**
     * responsable
     */
    private String salgrhResponsable;


    /**
     * lieu
     */
    private String salgrhLieu;


    /**
     * service
     */
    private String salgrhService;


    /**
     * type
     */
    private Integer salgrhType;


    /**
     * date de fin
     */
    private LocalDate salgrhDateFin;


    /**
     * fonction
     */
    private String salgrhFonction;


    /**
     * categorie
     */
    private String salgrhCategorie;


    /**
     * activite
     */
    private String salgrhActivite;


    /**
     * evaluation 1
     */
    private Integer salgrhEval1;


    /**
     * evaluation 2
     */
    private Integer salgrhEval2;


    /**
     * evaluation 3
     */
    private Integer salgrhEval3;


    /**
     * evaluation 4
     */
    private Integer salgrhEval4;


    /**
     * evaluation 5
     */
    private Integer salgrhEval5;


    /**
     * evaluation 6
     */
    private Integer salgrhEval6;


    /**
     * evaluation 7
     */
    private Integer salgrhEval7;


    /**
     * evaluation 8
     */
    private Integer salgrhEval8;


    /**
     * evaluation 9
     */
    private Integer salgrhEval9;


    /**
     * evaluation 10
     */
    private Integer salgrhEval10;


    /**
     * total evaluation
     */
    private Integer salgrhTotEval;


    /**
     * 0=travaille 1=ne travaille pas
     */
    private Integer salgrhTravail;


    /**
     * 0=fille 1=garcon
     */
    private Integer salgrhGenre;


    /**
     * 0=nr 1=primaire 2=secondaire 3=superieur 4=universitaire
     */
    private Integer salgrhNiveauScolaire;


    /**
     * duree en nombre de mois
     */
    private Integer salgrhDuree;


    /**
     * cout
     */
    private Double salgrhCout;


    /**
     * 0=nr 1=ecart 2=perte 3=vol ou fraude 4=retard 5=autre
     */
    private Integer salgrhSuspension;


    /**
     * 0=nr 1=apte sans restriction 2=apte service restrient 3=inacpte temporaire 4=inapte definitif
     */
    private Integer salgrhMedical;


    /**
     * groupe sanguin
     */
    private String salgrhGroupeSanguin;


    /**
     * feuille
     */
    private Integer salgrhFeuille;


    /**
     * serie ou identification
     */
    private String salgrhSerie;


    /**
     * taille
     */
    private String salgrhTaille;


    /**
     * couleur
     */
    private String salgrhCouleur;


    /**
     * quantite
     */
    private Integer salgrhQte;


    /**
     * 0= sans habilitation 1=avec habilitation
     */
    private Integer salgrhEtatVal;


    /**
     * 0=non valide 1=valide
     */
    private Integer salgrhEtat;


    /**
     * date de validation
     */
    private LocalDateTime salgrhDateValide;


    /**
     * date impression
     */
    private LocalDateTime salgrhDateImp;

    @NotNull(message = "salId can not null")
    private Long salId;


    /**
     * qualite experience 0=statgiaire 1=junior 2=junior confirme 3=senior 4=senior experimente
     */
    private Integer salgrhQualite;


    /**
     * langue
     */
    private String salgrhLangue;


    /**
     * langue lue 0=non 1=passable 2=correct 3=excellent
     */
    private Integer salgrhLangueLu;


    /**
     * langue parlee 0=non 1=passable 2=correct 3=excellent
     */
    private Integer salgrhLangueParle;


    /**
     * langue ecrit 0=non 1=passable 2=correct 3=excellent
     */
    private Integer salgrhLangueEcrit;


    /**
     * domaine de competence 1
     */
    private Boolean salgrhDomAct1;


    /**
     * domaine de competence 2
     */
    private Boolean salgrhDomAct2;


    /**
     * domaine de competence 3
     */
    private Boolean salgrhDomAct3;


    /**
     * domaine de competence 4
     */
    private Boolean salgrhDomAct4;


    /**
     * domaine de competence 5
     */
    private Boolean salgrhDomAct5;


    /**
     * domaine de competence 6
     */
    private Boolean salgrhDomAct6;


    /**
     * domaine de competence 1
     */
    private Boolean salgrhCompetence1;


    /**
     * domaine de competence 2
     */
    private Boolean salgrhCompetence2;


    /**
     * domaine de competence 3
     */
    private Boolean salgrhCompetence3;


    /**
     * domaine de competence 4
     */
    private Boolean salgrhCompetence4;


    /**
     * domaine de competence 5
     */
    private Boolean salgrhCompetence5;


    /**
     * domaine de competence 6
     */
    private Boolean salgrhCompetence6;


    /**
     * domaine de competence 7
     */
    private Boolean salgrhCompetence7;


    /**
     * domaine de competence 8
     */
    private Boolean salgrhCompetence8;


    /**
     * appreciation mission
     */
    private String salgrhAppreciation;


    /**
     * probleme rencontree
     */
    private String salgrhProblemme;


    /**
     * mission 0=mission pour unwomen 1=mission autre agence
     */
    private Integer salgrhMissionOrigine;


    /**
     * document rh
     */
    private String salgrhDocument;


    /**
     * evaluation 11
     */
    private Integer salgrhEval11;


    /**
     * evaluation 12
     */
    private Integer salgrhEval12;


    /**
     * feuille
     */
    private String salgrhFeuilleOld;


    /**
     * heure
     */
    private Integer salgrhHeure;


    /**
     * minute
     */
    private Integer salgrhMinute;


    /**
     * date declaration
     */
    private LocalDate salgrhDateDeclaration;


    /**
     * circonstance
     */
    private String salgrhCirconstance;


    /**
     * temoins
     */
    private String salgrhTemoins;


    /**
     * rapport medical
     */
    private String salgrhRapportMedical;


    /**
     * temps indisponibilite
     */
    private String salgrhTempsIndisponibilite;


    /**
     * nature accident
     */
    private String salgrhNatureAccident;


    /**
     * motif
     */
    private String salgrhMotif;

}
