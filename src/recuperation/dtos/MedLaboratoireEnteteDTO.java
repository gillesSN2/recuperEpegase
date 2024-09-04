package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedLaboratoireEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long labId;


    /**
     * numero
     */
    private String labNum;


    /**
     * date de creation
     */
    private LocalDate labDateCreation;


    /**
     * date de transfert
     */
    private LocalDate labDateTransfert;


    /**
     * 0=non cloture 1=cloture
     */
    private Integer labCloture;


    /**
     * numero hospitalisation
     */
    private String labNumHospit;


    /**
     * numero rum
     */
    private String labNumRum;


    /**
     * code service
     */
    private String labService;


    /**
     * code protocole
     */
    private String labProtocole;


    /**
     * motif entree
     */
    private String labEntree;


    /**
     * nom prescripteur
     */
    private String labPrescripteur;


    /**
     * nom medecin
     */
    private String labMedecin;


    /**
     * numero de bon de commande
     */
    private String labNumBc;


    /**
     * numero de paillasse
     */
    private Long labNumPaillasse;


    /**
     * date des resultats
     */
    private LocalDate labDateResultat;


    /**
     * date du peÃƒÆ’Ã‚Â©levement
     */
    private LocalDate labDatePrelevement;


    /**
     * 0=non renseigne 1=domicile 2=laboratoire
     */
    private Integer labLieuPrelevement;


    /**
     * 0=non renseigne 1=acec partenaire 2=sans partenaire
     */
    private Integer labPartenaire;


    /**
     * date des derniere regles
     */
    private LocalDate labDateRegles;


    /**
     * id societe
     */
    private Long labIdSociete;


    /**
     * nom societe
     */
    private String labNomSociete;


    /**
     * matricule
     */
    private String labMatricule;


    /**
     * id assurance
     */
    private Long labIdAssurance;


    /**
     * nom assurance
     */
    private String labNomAssurance;


    /**
     * numeo de contrat
     */
    private String labContratAssurance;


    /**
     * id complementaires
     */
    private Long labIdComplementaire;


    /**
     * nom complementaires
     */
    private String labNomComplemtaire;


    /**
     * numero de contrat
     */
    private String labContratComplementaire;


    /**
     * 0=prive 1=pec 2=special 3=cas social
     */
    private Integer labCategorie;


    /**
     * part ht patient
     */
    private Double labTotPatient;


    /**
     * part ht societe
     */
    private Double labTotSociete;


    /**
     * part ht assurance
     */
    private Double labTotAssurance;


    /**
     * part ht complementaire
     */
    private Double labTotComplmentaire;


    /**
     * part taxe patient
     */
    private Double labTotTaxePatient;


    /**
     * part taxe societe
     */
    private Double labTotTaxeSociete;


    /**
     * part taxe assurance
     */
    private Double labTotTaxeAssurance;


    /**
     * part taxe complementaire
     */
    private Double labTotTaxeComplementaire;


    /**
     * total general
     */
    private Double labTotGeneral;


    /**
     * reglement patient
     */
    private Double labRegPatient;


    /**
     * solde patient
     */
    private Double labSoldePatient;


    /**
     * regelemtnt iers
     */
    private Double labRegTiers;


    /**
     * solde tiers
     */
    private Double labSoldeTiers;

    private Long exemedId;

    private Long patId;


    /**
     * date de creation
     */
    private LocalDateTime labDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime labDateModif;


    /**
     * id user createur
     */
    private Long labIdCreateur;


    /**
     * nom du createur
     */
    private String labNomCreateur;


    /**
     * id user de modification
     */
    private Long labIdModif;


    /**
     * nom user de modification
     */
    private String labNomModif;


    /**
     * date
     */
    private LocalDateTime labDate;


    /**
     * serie A, B, C, D ou X
     */
    private String labSerie;


    /**
     * date de paiement du relicat
     */
    private LocalDate labEcheanceReliquat;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer labEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer labEtat;


    /**
     * laboratoire
     */
    private String labLaboratoire;


    /**
     * code pathologie
     */
    private String labPathologie;


    /**
     * id medecin
     */
    private Long labIdMedecin;


    /**
     * id patient
     */
    private Long labIdPatient;


    /**
     * civilite
     */
    private String labCivilite;


    /**
     * nom et prenom
     */
    private String labNomPatient;


    /**
     * avec ou sans
     */
    private String labPec;


    /**
     * famille du patient lie au fichier xml
     */
    private String labFam;


    /**
     * total taxe
     */
    private Double labTotTaxeGeneral;


    /**
     * nom de la banque + numero de compte
     */
    private String labBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer labTypeReg;


    /**
     * mode de reglement xml
     */
    private String labModeReg;


    /**
     * nombre de jour
     */
    private Integer labNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer labArrondiReg;


    /**
     * date echeance de reglement
     */
    private LocalDate labDateEcheReg;


    /**
     * code activite
     */
    private String labActivite;


    /**
     * info 1
     */
    private String labInfo1;


    /**
     * info 2
     */
    private String labInfo2;


    /**
     * info 3
     */
    private String labInfo3;


    /**
     * info 4
     */
    private String labInfo4;


    /**
     * info 5
     */
    private String labInfo5;


    /**
     * info 6
     */
    private String labInfo6;


    /**
     * info 7
     */
    private String labInfo7;


    /**
     * info 8
     */
    private String labInfo8;


    /**
     * info 9
     */
    private String labInfo9;


    /**
     * info 10
     */
    private String labInfo10;


    /**
     * date impression
     */
    private LocalDateTime labDateImp;


    /**
     * nom jasper du modele
     */
    private String labModeleImp;


    /**
     * si true alors anonyme
     */
    private Boolean labAnomyme;

    private Long exevteId;

}
