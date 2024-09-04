package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PaySalariesElementsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long saleleId;


    /**
     * periode MM:AAAA ou JJ:MM:AAAA
     */
    private String salelePeriode;


    /**
     * matricule
     */
    private String saleleMatricule;


    /**
     * voir nature salarie xml
     */
    private String saleleNature;


    /**
     * 0=actif 1=en conges 2=licencie 3=demissionne 4=decede 5=retraite 6=fin de contrat 7=arret ou suspension
     */
    private Integer saleleEtat;


    /**
     * civilite (suivant fichier xml)
     */
    private String saleleCivilite;


    /**
     * fonction
     */
    private String saleleFonction;


    /**
     * imputation service
     */
    private String saleleSite;


    /**
     * imputation service
     */
    private String saleleDepartement;


    /**
     * imputation service
     */
    private String saleleService;


    /**
     * imputation activite
     */
    private String saleleActicvite;


    /**
     * imputation budget
     */
    private String saleleBudget;


    /**
     * imputation parc
     */
    private String saleleParc;


    /**
     * 0=femme 1=homme
     */
    private Integer saleleGenre;


    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    private Integer saleleSitFamille;


    /**
     * nombre enfant
     */
    private Integer saleleNbEnfant;


    /**
     * nombre de parts fiscales
     */
    private Float saleleNbPartFiscal;


    /**
     * nombre de femme
     */
    private Integer saleleNbFemme;


    /**
     * nombre de parts trimf
     */
    private Float saleleNbPartTrimf;


    /**
     * regime de conges : nb jour de conges
     */
    private Float saleleNbJourCp;


    /**
     * regime de conges : nb jour de travail
     */
    private Float saleleNbJourTr;


    /**
     * date mariage
     */
    private LocalDate saleleDateMarie;


    /**
     * date divorce
     */
    private LocalDate saleleDateDivorce;


    /**
     * date veuf
     */
    private LocalDate saleleDateVeuf;


    /**
     * date Concubinage
     */
    private LocalDate saleleDateConcubinage;


    /**
     * date pacs
     */
    private LocalDate saleleDatePacs;


    /**
     * date de sortie
     */
    private LocalDate saleleDateSortie;


    /**
     * motif de sortie
     */
    private String saleleMotifSortie;


    /**
     * code convention du salarie
     */
    private String saleleConvention;


    /**
     * libelle convention du salarie
     */
    private String saleleLibConvention;


    /**
     * code centres impots xml
     */
    private String saleleCodCentresImpots;


    /**
     * libelle centres impots xml
     */
    private String saleleLibCentresImpots;


    /**
     * code classement xml
     */
    private String saleleClassement;


    /**
     * libelle classement xml
     */
    private String saleleLibClassement;


    /**
     * code niveau emploi xml
     */
    private String saleleNivEmploi;


    /**
     * libelle niveau emploi xml
     */
    private String saleleLibNivEmploi;


    /**
     * code grille convention xml
     */
    private String saleleGrille;


    /**
     * libelle grille convention xml
     */
    private String saleleLibGrille;


    /**
     * numero de feuille de calcul
     */
    private String saleleFeuille;


    /**
     * cle de repartition 1
     */
    private String saleleCle1Anal;


    /**
     * libelle cle de repartition 1
     */
    private String saleleLibCle1Anal;


    /**
     * cle de repartition 2
     */
    private String saleleCle2Anal;


    /**
     * libelle cle de repartition 2
     */
    private String saleleLibCle2Anal;

    private Long salId;


    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    private Integer saleleModeReglement;


    /**
     * code banque
     */
    private String saleleNumBanque;


    /**
     * code guichet
     */
    private String saleleGuichetBanque;


    /**
     * numero de compte
     */
    private String saleleCompteBanque;


    /**
     * cle rib
     */
    private String saleleCleBanque;


    /**
     * code iban
     */
    private String saleleIban;


    /**
     * code swift
     */
    private String saleleSwift;


    /**
     * numero contrat
     */
    private String saleleContrat;


    /**
     * date entree
     */
    private LocalDate saleleDateEntree;

}
