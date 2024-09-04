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
public class CmmTiersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "tieId can not null")
    private Long tieId;


    /**
     * date de creation
     */
    private LocalDateTime tieDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime tieDateModif;


    /**
     * utilisateur de creation
     */
    private Long tieUserCreat;


    /**
     * utilisateur de modification
     */
    private Long tieUserModif;


    /**
     * 0=actif 1=inactif 2=supprime
     */
    private Integer tieEtat;


    /**
     * raison social ou nom
     */
    private String tieRaisonSocialeNom;


    /**
     * sigle
     */
    private String tieSigle;


    /**
     * 0=fournisseur 1=suspect 2=prospect 3=client 6=paroissien 99=divers
     */
    private String tieType;


    /**
     * lie au fichier xml tiers
     */
    private String tieGenre;


    /**
     * categorie du tiers lie au fichier xml
     */
    private String tieCategorie;


    /**
     * civilite lie au fichier xml civilite
     */
    private String tieCivilite;


    /**
     * nom pays
     */
    private String tieNomPays;


    /**
     * code du pays
     */
    private String tieCodePays;


    /**
     * code devise
     */
    private String tieDevise;


    /**
     * format devise
     */
    private Integer tieFormatDevise;


    /**
     * code langue
     */
    private String tieLangue;


    /**
     * 0=adresse simplifie 1=adresse complete
     */
    private Integer tieTypeAdresse;


    /**
     * telephone domicile
     */
    private String tieTelDom;


    /**
     * mobile 1
     */
    private String tieCel1;


    /**
     * mobile 2
     */
    private String tieCel2;


    /**
     * mobile 3
     */
    private String tieCel3;


    /**
     * telephone voiture
     */
    private String tieTelVoiture;


    /**
     * prenom
     */
    private String tiePrenom;


    /**
     * nom de jeune fille
     */
    private String tieNomJf;


    /**
     * surnom
     */
    private String tieSurnom;


    /**
     * 0=femme 1=homme
     */
    private Integer tieSexe;


    /**
     * date de naissance
     */
    private LocalDate tieDateNaissance;


    /**
     * lieu de naissance
     */
    private String tieLieuNaissance;


    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date de naissance
     */
    private String tieAnniversaire;


    /**
     * date du mariage
     */
    private LocalDate tieDateMariage;


    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date du mariage
     */
    private String tieAnniversaireMariage;


    /**
     * date du mariage
     */
    private LocalDate tieDateDeces;


    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date du deces
     */
    private String tieAnniversaireDeces;


    /**
     * observations
     */
    private String tieObservations;


    /**
     * activite principale
     */
    private String tieActivite1;


    /**
     * activite livre
     */
    private String tieActivite2;


    /**
     * source du tiers
     */
    private String tieSource;


    /**
     * 0=public 1=collaborateur 2=prive
     */
    private Integer tieVisibilite;


    /**
     * si collaborateur alors code groupe
     */
    private String tieVisibiliteGrp;


    /**
     * si prive alors code user createur
     */
    private Long tieVisibiliteUser;


    /**
     * adresse
     */
    private String tieAdresse;


    /**
     * no de rue
     */
    private String tieRue;


    /**
     * no de lot
     */
    private String tieLot;


    /**
     * no illot
     */
    private String tieIlot;


    /**
     * batiment
     */
    private String tieBatiment;


    /**
     * no de porte
     */
    private String tiePorte;


    /**
     * etage
     */
    private String tieEtage;


    /**
     * ascenseur
     */
    private String tieAscensseur;


    /**
     * quartier
     */
    private String tieQuartier;


    /**
     * commune
     */
    private String tieCommune;


    /**
     * departement
     */
    private String tieDepart;


    /**
     * zone
     */
    private String tieZone;


    /**
     * boite postale
     */
    private String tieBp;


    /**
     * cedex
     */
    private String tieCedex;


    /**
     * ville
     */
    private String tieVille;


    /**
     * telephone bureau 1
     */
    private String tieBurTel1;


    /**
     * telephone bureau 2
     */
    private String tieBurTel2;


    /**
     * telephone bureau 3
     */
    private String tieBurTel3;


    /**
     * fax du bureau
     */
    private String tieBurFax;


    /**
     * telex
     */
    private String tieTelex;


    /**
     * adresse yahoo
     */
    private String tieYahoo;


    /**
     * adresse msn
     */
    private String tieMsn;


    /**
     * adresse skype
     */
    private String tieSkype;


    /**
     * adresse aol
     */
    private String tieAol;


    /**
     * mail 1
     */
    private String tieMail1;


    /**
     * mail 2
     */
    private String tieMail2;


    /**
     * mail 3
     */
    private String tieMail3;


    /**
     * mail 4
     */
    private String tieMail4;


    /**
     * mail 5
     */
    private String tieMail5;


    /**
     * adresse web
     */
    private String tieWeb;


    /**
     * mode de reglement
     */
    private String tieModeReg;


    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    private Integer tieTypeReg;


    /**
     * nombre de jours d echeance
     */
    private Integer tieNbEcheance;


    /**
     * nombre de jours d arrondi
     */
    private Integer tieNbArrondi;


    /**
     * code journal des reglements
     */
    private String tieJournalReg;


    /**
     * conditions de reglements
     */
    private String tieConditionReg;


    /**
     * plafond de facturation
     */
    private Double tiePlafond;


    /**
     * compte depot argent
     */
    private Double tieDepotavance;


    /**
     * ca de la patente
     */
    private Double tieCapatente;


    /**
     * plafond de la patente
     */
    private Double tiePlafPatente;


    /**
     * 0=compte fonctionnel 1=compte bloque
     */
    private Integer tieCompteBloque;


    /**
     * nom de la famille du tiers
     */
    private String tieNomFamille;


    /**
     * code serie
     */
    private String tieSerie;


    /**
     * 0=avec douane 1=exonere de douane
     */
    private Integer tieExoDouane;


    /**
     * 0=avec tva 1=exonere de tva 2=non assujetti aÃ‚Â  la tva
     */
    private Integer tieExoTva;


    /**
     * code depot par defaut
     */
    private String tieDepot;


    /**
     * taux d escompte
     */
    private Float tieEscompte;


    /**
     * 0=facturation au PV 1=facturation au PR
     */
    private Integer tieFacPr;


    /**
     * nom de la banque
     */
    private String tieNomBanque;


    /**
     * adresse de la banque
     */
    private String tieAdresseBanque;


    /**
     * code banque
     */
    private String tieNumBanque;


    /**
     * code guichet
     */
    private String tieGuichetBanque;


    /**
     * numero de compte
     */
    private String tieCompteBanque;


    /**
     * cle rib
     */
    private String tieCleBanque;


    /**
     * code iban
     */
    private String tieIban;


    /**
     * code swift
     */
    private String tieSwift;


    /**
     * compte principal
     */
    private String tieCompte0;


    /**
     * compte associe 1 (en attente)
     */
    private String tieCompte1;


    /**
     * compte associe 2 (avance ou acompte)
     */
    private String tieCompte2;


    /**
     * compte asocie 3 (douteux ou litige)
     */
    private String tieCompte3;


    /**
     * compte rattache
     */
    private String tieCompte4;


    /**
     * note d appreciation automatique /20
     */
    private Integer tieNoteAuto;


    /**
     * appreciation manuelle
     */
    private String tieNoteMan;


    /**
     * inutilise 1
     */
    private String tieNoUse1;


    /**
     * inutilise 2
     */
    private String tieNoUse2;


    /**
     * nom de l epouse ou de l epoux
     */
    private String tieEpoux;


    /**
     * nom du pere
     */
    private String tieNomPere;


    /**
     * nom de la mere
     */
    private String tieNomMere;


    /**
     * N carte d identite
     */
    private String tieCiNum;


    /**
     * date de delivrance de la carte d identite
     */
    private String tieCiDate;


    /**
     * lieu de delivrance de la carte d identite
     */
    private String tieCiLieu;


    /**
     * profession
     */
    private String tieProfession;


    /**
     * niveau d etude
     */
    private String tieNiveauEtude;


    /**
     * nom de l employeur
     */
    private String tieEmployeur;


    /**
     * adresse de l employeur
     */
    private String tieAdresseEmployeur;


    /**
     * bp de l employeur
     */
    private String tieBpEmployeur;


    /**
     * ville de l employeur
     */
    private String tieVilleEmployeur;


    /**
     * telephone de l employeur
     */
    private String tieTelEmployeur;


    /**
     * situation de famille 0=nr 1=celibataire 2=marie 3=concubin 4=divorce 5=veuf
     */
    private Integer tieSitFam;


    /**
     * nombre de personnes aÃ‚Â  charge
     */
    private Integer tieNbCharge;


    /**
     * nombre d enfants
     */
    private Integer tieNbEnf;


    /**
     * 0=locataire 1=proprietaire
     */
    private Integer tieHabitation;

    private String tieNum1;

    private String tieNum2;

    private String tieNum3;

    private String tieNum4;

    private String tieNum5;

    private String tieNum6;

    private String tieNum7;

    private String tieNum8;

    private String tieNum9;

    private String tieNum10;

    private String tieNum11;

    private String tieNum12;

    private String tieNum13;

    private String tieNum14;

    private String tieNum15;

    private String tieNum16;

    private String tieNum17;

    private String tieNum18;

    private String tieNum19;

    private String tieNum20;

    private String tiePdv;

    private String tieSecteur;

    private String tieRegion;

    private Float tieAssurt1;

    private Double tieAssurt2;

    private Float tieAssurt3;

    private Double tieBnq1;

    private Float tieBnq2;

    private Double tieBnq3;

    private Float tieBnq4;

    private Double tieBnq5;

    private Float tieBnq6;

    private Float tieBnq7;


    /**
     * id structure pour espace client
     */
    private Long tieIdStructure;


    /**
     * 0=transfert en compta 1=non transfere en compta
     */
    private Integer tieTransfertCpte;


    /**
     * compte SAGE
     */
    private String tieCompteSage;


    /**
     * acces photo ou logo
     */
    private String tiePhoto;


    /**
     * 0=sans assujettissement 1=assujeti irpp 2=assujetti is
     */
    private Integer tieAssujettissement;


    /**
     * zone de declaration fiscale
     */
    private String tieFiscal;


    /**
     * taux de commission pour la facturation
     */
    private Float tieTauxCom;


    /**
     * mode de commission 0=rien 1=calul sur brut 2=calul sur net 3=camlcul sur net à payer
     */
    private Integer tieModeCom;

}
