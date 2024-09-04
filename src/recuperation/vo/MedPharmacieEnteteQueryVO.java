package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedPharmacieEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long phaId;


    /**
     * numero pharmacie
     */
    private String phaNumPharm;


    /**
     * date de creation
     */
    private LocalDate phaDateCreation;


    /**
     * date de transfert
     */
    private LocalDate phaDateTransfert;


    /**
     * 0=non cloture 1=cloture
     */
    private Integer phaCloture;


    /**
     * numero hospitalisation
     */
    private String phaNumHospit;


    /**
     * numero run
     */
    private String phaNumRum;


    /**
     * code serivce
     */
    private String phaService;


    /**
     * code protocole
     */
    private String phaProtocole;


    /**
     * motif entree
     */
    private String phaEntree;


    /**
     * nom prescripteur
     */
    private String phaPrescripteur;


    /**
     * nom medecin
     */
    private String phaMedecin;


    /**
     * numeo bon de commande
     */
    private String phaNumBc;


    /**
     * id societe
     */
    private Long phaIdSociete;


    /**
     * nom societe
     */
    private String phaNomSociete;


    /**
     * matricule
     */
    private String phaMatricule;


    /**
     * id assurance
     */
    private Long phaIdAssurance;


    /**
     * nom assurance
     */
    private String phaNomAssurance;


    /**
     * numero de contrat
     */
    private String phaContratAssurance;


    /**
     * id commplementaire
     */
    private Long phaIdComplementaire;


    /**
     * nom complementaire
     */
    private String phaNomComplemtaire;


    /**
     * numero de contrat
     */
    private String phaContratComplementaire;


    /**
     * 0=prive 1=pec 2=special 3=cas social
     */
    private Integer phaCategorie;


    /**
     * part ht patient
     */
    private Double phaTotPatient;


    /**
     * part ht societe
     */
    private Double phaTotSociete;


    /**
     * part ht assurance
     */
    private Double phaTotAssurance;


    /**
     * part ht complementaire
     */
    private Double phaTotComplmentaire;


    /**
     * part taxe patient
     */
    private Double phaTotTaxePatient;


    /**
     * part taxe societe
     */
    private Double phaTotTaxeSociete;


    /**
     * part taxe assurance
     */
    private Double phaTotTaxeAssurance;


    /**
     * part taxe complementaire
     */
    private Double phaTotTaxeComplementaire;


    /**
     * total general
     */
    private Double phaTotGeneral;


    /**
     * reglemen t patient
     */
    private Double phaRegPatient;


    /**
     * solde patient
     */
    private Double phaSoldePatient;


    /**
     * reglement tiers
     */
    private Double phaRegTiers;


    /**
     * solde tiers
     */
    private Double phaSoldeTiers;

    private Long exemedId;

    private Long patId;


    /**
     * date de creation
     */
    private LocalDateTime phaDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime phaDateModif;


    /**
     * id user createur
     */
    private Long phaIdCreateur;


    /**
     * nom du createur
     */
    private String phaNomCreateur;


    /**
     * id user de modification
     */
    private Long phaIdModif;


    /**
     * nom user de modification
     */
    private String phaNomModif;


    /**
     * numero
     */
    private String phaNum;


    /**
     * date
     */
    private LocalDateTime phaDate;


    /**
     * serie A, B, C, D ou X
     */
    private String phaSerie;


    /**
     * date de paiement du relicat
     */
    private LocalDate phaEcheanceReliquat;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer phaEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer phaEtat;


    /**
     * pharmacie
     */
    private String phaPharmacie;


    /**
     * code pathologie
     */
    private String phaPathologie;


    /**
     * id medecin
     */
    private Long phaIdMedecin;


    /**
     * id patient
     */
    private Long phaIdPatient;


    /**
     * civilite
     */
    private String phaCivilite;


    /**
     * nom et prenom
     */
    private String phaNomPatient;


    /**
     * avec ou sans
     */
    private String phaPec;


    /**
     * famille du patient lie au fichier xml
     */
    private String phaFam;


    /**
     * total taxe
     */
    private Double phaTotTaxeGeneral;


    /**
     * nom de la banque + numero de compte
     */
    private String phaBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer phaTypeReg;


    /**
     * mode de reglement xml
     */
    private String phaModeReg;


    /**
     * nombre de jour
     */
    private Integer phaNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer phaArrondiReg;


    /**
     * date echeance de reglement
     */
    private LocalDate phaDateEcheReg;


    /**
     * code activite
     */
    private String phaActivite;


    /**
     * info 1
     */
    private String phaInfo1;


    /**
     * info 2
     */
    private String phaInfo2;


    /**
     * info 3
     */
    private String phaInfo3;


    /**
     * info 4
     */
    private String phaInfo4;


    /**
     * info 5
     */
    private String phaInfo5;


    /**
     * info 6
     */
    private String phaInfo6;


    /**
     * info 7
     */
    private String phaInfo7;


    /**
     * info 8
     */
    private String phaInfo8;


    /**
     * info 9
     */
    private String phaInfo9;


    /**
     * info 10
     */
    private String phaInfo10;


    /**
     * date impression
     */
    private LocalDateTime phaDateImp;


    /**
     * nom jasper du modele
     */
    private String phaModeleImp;

    private Long exevteId;

}
