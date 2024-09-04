package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedConsultationEnteteGeneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long csgId;


    /**
     * date de creation
     */
    private LocalDateTime csgDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime csgDateModif;


    /**
     * id user createur
     */
    private Long csgIdCreateur;


    /**
     * nom du createur
     */
    private String csgNomCreateur;


    /**
     * id user de modification
     */
    private Long csgIdModif;


    /**
     * nom user de modification
     */
    private String csgNomModif;


    /**
     * numero consult
     */
    private String csgNum;


    /**
     * date de consultation
     */
    private LocalDateTime csgDate;


    /**
     * serie A, B, C, D ou X
     */
    private String csgSerie;


    /**
     * date de modification
     */
    private LocalDate csgDateTransfert;


    /**
     * 0=non cloture 1=cloture
     */
    private Integer csgCloture;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer csgEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer csgEtat;


    /**
     * numero hospitalisation
     */
    private String csgNumHospit;


    /**
     * numero hospitalisation
     */
    private String csgNumRum;


    /**
     * code serivce
     */
    private String csgService;


    /**
     * code protocole
     */
    private String csgProtocole;


    /**
     * code pathologie
     */
    private String csgPathologie;


    /**
     * motif entree
     */
    private String csgEntree;


    /**
     * nom prescripteur
     */
    private String csgPrescripteur;


    /**
     * id medecin
     */
    private Long csgIdMedecin;


    /**
     * nom medecin
     */
    private String csgMedecin;


    /**
     * numeo bon de commande
     */
    private String csgNumBc;


    /**
     * id patient
     */
    private Long csgIdPatient;


    /**
     * civilite
     */
    private String csgCivilite;


    /**
     * nom et prenom
     */
    private String csgNomPatient;


    /**
     * id societe
     */
    private Long csgIdSociete;


    /**
     * nom societe
     */
    private String csgNomSociete;


    /**
     * matricule
     */
    private String csgMatricule;


    /**
     * id assurance
     */
    private Long csgIdAssurance;


    /**
     * nom assurance
     */
    private String csgNomAssurance;


    /**
     * numero de contrat
     */
    private String csgContratAssurance;


    /**
     * id commplementaire
     */
    private Long csgIdComplementaire;


    /**
     * nom complementaire
     */
    private String csgNomComplemtaire;


    /**
     * numero de contrat
     */
    private String csgContratComplementaire;


    /**
     * prise en charge du patient lie au fichier xml
     */
    private String csgPec;


    /**
     * famille du patient lie au fichier xml
     */
    private String csgFam;


    /**
     * part ht patient
     */
    private Double csgTotPatient;


    /**
     * part ht societe
     */
    private Double csgTotSociete;


    /**
     * part ht assurance
     */
    private Double csgTotAssurance;


    /**
     * part ht complementaire
     */
    private Double csgTotComplmentaire;


    /**
     * part taxe patient
     */
    private Double csgTotTaxePatient;


    /**
     * part taxe societe
     */
    private Double csgTotTaxeSociete;


    /**
     * part taxe assurance
     */
    private Double csgTotTaxeAssurance;


    /**
     * part taxe complementaire
     */
    private Double csgTotTaxeComplementaire;


    /**
     * total general
     */
    private Double csgTotGeneral;


    /**
     * reglement patient
     */
    private Double csgRegPatient;


    /**
     * 0= non solde 1=solde patient
     */
    private Integer csgSoldePatient;


    /**
     * reglement tiers
     */
    private Double csgRegTiers;


    /**
     * 0= non solde 1=solde tiers
     */
    private Integer csgSoldeTiers;


    /**
     * nom de la banque + numero de compte
     */
    private String csgBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer csgTypeReg;


    /**
     * mode de reglement xml
     */
    private String csgModeReg;


    /**
     * nombre de jour
     */
    private Integer csgNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer csgArrondiReg;


    /**
     * date echeance de reglement
     */
    private LocalDate csgDateEcheReg;


    /**
     * code activite
     */
    private String csgActivite;


    /**
     * code budget
     */
    private String csgBudget;


    /**
     * code analytique 2
     */
    private String csgAnal2;


    /**
     * code analytique 4
     */
    private String csgAnal4;


    /**
     * info 1
     */
    private String csgInfo1;


    /**
     * info 2
     */
    private String csgInfo2;


    /**
     * info 3
     */
    private String csgInfo3;


    /**
     * info 4
     */
    private String csgInfo4;


    /**
     * info 5
     */
    private String csgInfo5;


    /**
     * info 6
     */
    private String csgInfo6;


    /**
     * info 7
     */
    private String csgInfo7;


    /**
     * info 8
     */
    private String csgInfo8;


    /**
     * info 9
     */
    private String csgInfo9;


    /**
     * info 10
     */
    private String csgInfo10;


    /**
     * date impression
     */
    private LocalDateTime csgDateImp;


    /**
     * nom jasper du modele
     */
    private String csgModeleImp;


    /**
     * anamese
     */
    private String csgAnamese;


    /**
     * poids
     */
    private Float csgPoids;


    /**
     * taille
     */
    private Float csgTaille;


    /**
     * temperature
     */
    private Float csgTemperature;


    /**
     * tension
     */
    private Float csgTension;


    /**
     * frequence cardiaque
     */
    private Float csgFreCar;


    /**
     * frequence respiratoire
     */
    private Float csgFreRes;


    /**
     * diurese
     */
    private Float csgDiurese;


    /**
     * vision oeil gauche
     */
    private Float csgOeilGauche;


    /**
     * vision oeil droit
     */
    private Float csgOeilDroit;


    /**
     * examen clinique
     */
    private String csgExamClinique;


    /**
     * discution
     */
    private String csgDiscution;


    /**
     * evolution
     */
    private String csgEvolution;


    /**
     * pronostic
     */
    private String csgPronostic;


    /**
     * code diagnostic hypothese
     */
    private String csgCodeDiag1;


    /**
     * code diagnostic hypothese
     */
    private String csgCodeDiag2;


    /**
     * code diagnostic hypothese
     */
    private String csgCodeDiag3;


    /**
     * code diagnostic hypothese
     */
    private String csgCodeDiag4;


    /**
     * code diagnostic hypothese
     */
    private String csgCodeDiag5;


    /**
     * code diagnostic positif
     */
    private String csgCodeDiag11;


    /**
     * code diagnostic retentissement
     */
    private String csgCodeDiag12;


    /**
     * hospitalisation souhaitee
     */
    private Boolean csgChoixHospit;


    /**
     * mise en observation souhaitee
     */
    private Boolean csgChoixObs;


    /**
     * refere souhaitee
     */
    private Boolean csgChoixRefere;


    /**
     * visite pre anesthesique souhaitee
     */
    private Boolean csgChoixVisitepa;


    /**
     * date prochain rdv
     */
    private LocalDate csgRdv;

    private Long exemedId;

    private Long patId;

    private Long usrId;


    /**
     * date de paiement du relicat
     */
    private LocalDate csgEcheanceReliquat;


    /**
     * total taxe
     */
    private Double csgTotTaxeGeneral;

    private Long exevteId;

}
