package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_consultation_entete_gene")
public class MedConsultationEnteteGene implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "csg_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long csgId;

    /**
     * date de creation
     */
    @Column(name = "csg_date_creat")
    private LocalDateTime csgDateCreat;

    /**
     * date de modification
     */
    @Column(name = "csg_date_modif")
    private LocalDateTime csgDateModif;

    /**
     * id user createur
     */
    @Column(name = "csg_id_createur")
    private Long csgIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "csg_nom_createur")
    private String csgNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "csg_id_modif")
    private Long csgIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "csg_nom_modif")
    private String csgNomModif;

    /**
     * numero consult
     */
    @Column(name = "csg_num")
    private String csgNum;

    /**
     * date de consultation
     */
    @Column(name = "csg_date")
    private LocalDateTime csgDate;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "csg_serie")
    private String csgSerie;

    /**
     * date de modification
     */
    @Column(name = "csg_date_transfert")
    private LocalDate csgDateTransfert;

    /**
     * 0=non cloture 1=cloture
     */
    @Column(name = "csg_cloture")
    private Integer csgCloture = 0;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "csg_etat_val")
    private Integer csgEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "csg_etat")
    private Integer csgEtat = 0;

    /**
     * numero hospitalisation
     */
    @Column(name = "csg_num_hospit")
    private String csgNumHospit;

    /**
     * numero hospitalisation
     */
    @Column(name = "csg_num_rum")
    private String csgNumRum;

    /**
     * code serivce
     */
    @Column(name = "csg_service")
    private String csgService;

    /**
     * code protocole
     */
    @Column(name = "csg_protocole")
    private String csgProtocole;

    /**
     * code pathologie
     */
    @Column(name = "csg_pathologie")
    private String csgPathologie;

    /**
     * motif entree
     */
    @Column(name = "csg_entree")
    private String csgEntree;

    /**
     * nom prescripteur
     */
    @Column(name = "csg_prescripteur")
    private String csgPrescripteur;

    /**
     * id medecin
     */
    @Column(name = "csg_id_medecin")
    private Long csgIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "csg_medecin")
    private String csgMedecin;

    /**
     * numeo bon de commande
     */
    @Column(name = "csg_num_bc")
    private String csgNumBc;

    /**
     * id patient
     */
    @Column(name = "csg_id_patient")
    private Long csgIdPatient = 0L;

    /**
     * civilite
     */
    @Column(name = "csg_civilite")
    private String csgCivilite;

    /**
     * nom et prenom
     */
    @Column(name = "csg_nom_patient")
    private String csgNomPatient;

    /**
     * id societe
     */
    @Column(name = "csg_id_societe")
    private Long csgIdSociete = 0L;

    /**
     * nom societe
     */
    @Column(name = "csg_nom_societe")
    private String csgNomSociete;

    /**
     * matricule
     */
    @Column(name = "csg_matricule")
    private String csgMatricule;

    /**
     * id assurance
     */
    @Column(name = "csg_id_assurance")
    private Long csgIdAssurance = 0L;

    /**
     * nom assurance
     */
    @Column(name = "csg_nom_assurance")
    private String csgNomAssurance;

    /**
     * numero de contrat
     */
    @Column(name = "csg_contrat_assurance")
    private String csgContratAssurance;

    /**
     * id commplementaire
     */
    @Column(name = "csg_id_complementaire")
    private Long csgIdComplementaire = 0L;

    /**
     * nom complementaire
     */
    @Column(name = "csg_nom_complemtaire")
    private String csgNomComplemtaire;

    /**
     * numero de contrat
     */
    @Column(name = "csg_contrat_complementaire")
    private String csgContratComplementaire;

    /**
     * prise en charge du patient lie au fichier xml
     */
    @Column(name = "csg_pec")
    private String csgPec;

    /**
     * famille du patient lie au fichier xml
     */
    @Column(name = "csg_fam")
    private String csgFam;

    /**
     * part ht patient
     */
    @Column(name = "csg_tot_patient")
    private Double csgTotPatient = 0D;

    /**
     * part ht societe
     */
    @Column(name = "csg_tot_societe")
    private Double csgTotSociete = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "csg_tot_assurance")
    private Double csgTotAssurance = 0D;

    /**
     * part ht complementaire
     */
    @Column(name = "csg_tot_complmentaire")
    private Double csgTotComplmentaire = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "csg_tot_taxe_patient")
    private Double csgTotTaxePatient = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "csg_tot_taxe_societe")
    private Double csgTotTaxeSociete = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "csg_tot_taxe_assurance")
    private Double csgTotTaxeAssurance = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "csg_tot_taxe_complementaire")
    private Double csgTotTaxeComplementaire = 0D;

    /**
     * total general
     */
    @Column(name = "csg_tot_general")
    private Double csgTotGeneral = 0D;

    /**
     * reglement patient
     */
    @Column(name = "csg_reg_patient")
    private Double csgRegPatient = 0D;

    /**
     * 0= non solde 1=solde patient
     */
    @Column(name = "csg_solde_patient")
    private Integer csgSoldePatient = 0;

    /**
     * reglement tiers
     */
    @Column(name = "csg_reg_tiers")
    private Double csgRegTiers = 0D;

    /**
     * 0= non solde 1=solde tiers
     */
    @Column(name = "csg_solde_tiers")
    private Integer csgSoldeTiers = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "csg_banque")
    private String csgBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "csg_type_reg")
    private Integer csgTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "csg_mode_reg")
    private String csgModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "csg_nb_jour_reg")
    private Integer csgNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "csg_arrondi_reg")
    private Integer csgArrondiReg = 0;

    /**
     * date echeance de reglement
     */
    @Column(name = "csg_date_eche_reg")
    private LocalDate csgDateEcheReg;

    /**
     * code activite
     */
    @Column(name = "csg_activite")
    private String csgActivite;

    /**
     * code budget
     */
    @Column(name = "csg_budget")
    private String csgBudget;

    /**
     * code analytique 2
     */
    @Column(name = "csg_anal2")
    private String csgAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "csg_anal4")
    private String csgAnal4;

    /**
     * info 1
     */
    @Column(name = "csg_info1")
    private String csgInfo1;

    /**
     * info 2
     */
    @Column(name = "csg_info2")
    private String csgInfo2;

    /**
     * info 3
     */
    @Column(name = "csg_info3")
    private String csgInfo3;

    /**
     * info 4
     */
    @Column(name = "csg_info4")
    private String csgInfo4;

    /**
     * info 5
     */
    @Column(name = "csg_info5")
    private String csgInfo5;

    /**
     * info 6
     */
    @Column(name = "csg_info6")
    private String csgInfo6;

    /**
     * info 7
     */
    @Column(name = "csg_info7")
    private String csgInfo7;

    /**
     * info 8
     */
    @Column(name = "csg_info8")
    private String csgInfo8;

    /**
     * info 9
     */
    @Column(name = "csg_info9")
    private String csgInfo9;

    /**
     * info 10
     */
    @Column(name = "csg_info10")
    private String csgInfo10;

    /**
     * date impression
     */
    @Column(name = "csg_date_imp")
    private LocalDateTime csgDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "csg_modele_imp")
    private String csgModeleImp;

    /**
     * anamese
     */
    @Column(name = "csg_anamese")
    private String csgAnamese;

    /**
     * poids
     */
    @Column(name = "csg_poids")
    private Float csgPoids = 0F;

    /**
     * taille
     */
    @Column(name = "csg_taille")
    private Float csgTaille = 0F;

    /**
     * temperature
     */
    @Column(name = "csg_temperature")
    private Float csgTemperature = 0F;

    /**
     * tension
     */
    @Column(name = "csg_tension")
    private Float csgTension = 0F;

    /**
     * frequence cardiaque
     */
    @Column(name = "csg_fre_car")
    private Float csgFreCar = 0F;

    /**
     * frequence respiratoire
     */
    @Column(name = "csg_fre_res")
    private Float csgFreRes = 0F;

    /**
     * diurese
     */
    @Column(name = "csg_diurese")
    private Float csgDiurese = 0F;

    /**
     * vision oeil gauche
     */
    @Column(name = "csg_oeil_gauche")
    private Float csgOeilGauche = 0F;

    /**
     * vision oeil droit
     */
    @Column(name = "csg_oeil_droit")
    private Float csgOeilDroit = 0F;

    /**
     * examen clinique
     */
    @Column(name = "csg_exam_clinique")
    private String csgExamClinique;

    /**
     * discution
     */
    @Column(name = "csg_discution")
    private String csgDiscution;

    /**
     * evolution
     */
    @Column(name = "csg_evolution")
    private String csgEvolution;

    /**
     * pronostic
     */
    @Column(name = "csg_pronostic")
    private String csgPronostic;

    /**
     * code diagnostic hypothese
     */
    @Column(name = "csg_code_diag1")
    private String csgCodeDiag1;

    /**
     * code diagnostic hypothese
     */
    @Column(name = "csg_code_diag2")
    private String csgCodeDiag2;

    /**
     * code diagnostic hypothese
     */
    @Column(name = "csg_code_diag3")
    private String csgCodeDiag3;

    /**
     * code diagnostic hypothese
     */
    @Column(name = "csg_code_diag4")
    private String csgCodeDiag4;

    /**
     * code diagnostic hypothese
     */
    @Column(name = "csg_code_diag5")
    private String csgCodeDiag5;

    /**
     * code diagnostic positif
     */
    @Column(name = "csg_code_diag11")
    private String csgCodeDiag11;

    /**
     * code diagnostic retentissement
     */
    @Column(name = "csg_code_diag12")
    private String csgCodeDiag12;

    /**
     * hospitalisation souhaitee
     */
    @Column(name = "csg_choix_hospit")
    private Boolean csgChoixHospit = Boolean.FALSE;

    /**
     * mise en observation souhaitee
     */
    @Column(name = "csg_choix_obs")
    private Boolean csgChoixObs = Boolean.FALSE;

    /**
     * refere souhaitee
     */
    @Column(name = "csg_choix_refere")
    private Boolean csgChoixRefere = Boolean.FALSE;

    /**
     * visite pre anesthesique souhaitee
     */
    @Column(name = "csg_choix_visitepa")
    private Boolean csgChoixVisitepa = Boolean.FALSE;

    /**
     * date prochain rdv
     */
    @Column(name = "csg_rdv")
    private LocalDate csgRdv;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * date de paiement du relicat
     */
    @Column(name = "csg_echeance_reliquat")
    private LocalDate csgEcheanceReliquat;

    /**
     * total taxe
     */
    @Column(name = "csg_tot_taxe_general")
    private Double csgTotTaxeGeneral = 0D;

    @Column(name = "exevte_id")
    private Long exevteId;

}
