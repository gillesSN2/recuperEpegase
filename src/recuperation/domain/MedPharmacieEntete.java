package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_pharmacie_entete")
public class MedPharmacieEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pha_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phaId;

    /**
     * numero pharmacie
     */
    @Column(name = "pha_num_pharm")
    private String phaNumPharm;

    /**
     * date de creation
     */
    @Column(name = "pha_date_creation")
    private LocalDate phaDateCreation;

    /**
     * date de transfert
     */
    @Column(name = "pha_date_transfert")
    private LocalDate phaDateTransfert;

    /**
     * 0=non cloture 1=cloture
     */
    @Column(name = "pha_cloture")
    private Integer phaCloture = 0;

    /**
     * numero hospitalisation
     */
    @Column(name = "pha_num_hospit")
    private String phaNumHospit;

    /**
     * numero run
     */
    @Column(name = "pha_num_rum")
    private String phaNumRum;

    /**
     * code serivce
     */
    @Column(name = "pha_service")
    private String phaService;

    /**
     * code protocole
     */
    @Column(name = "pha_protocole")
    private String phaProtocole;

    /**
     * motif entree
     */
    @Column(name = "pha_entree")
    private String phaEntree;

    /**
     * nom prescripteur
     */
    @Column(name = "pha_prescripteur")
    private String phaPrescripteur;

    /**
     * nom medecin
     */
    @Column(name = "pha_medecin")
    private String phaMedecin;

    /**
     * numeo bon de commande
     */
    @Column(name = "pha_num_bc")
    private String phaNumBc;

    /**
     * id societe
     */
    @Column(name = "pha_id_societe")
    private Long phaIdSociete = 0L;

    /**
     * nom societe
     */
    @Column(name = "pha_nom_societe")
    private String phaNomSociete;

    /**
     * matricule
     */
    @Column(name = "pha_matricule")
    private String phaMatricule;

    /**
     * id assurance
     */
    @Column(name = "pha_id_assurance")
    private Long phaIdAssurance = 0L;

    /**
     * nom assurance
     */
    @Column(name = "pha_nom_assurance")
    private String phaNomAssurance;

    /**
     * numero de contrat
     */
    @Column(name = "pha_contrat_assurance")
    private String phaContratAssurance;

    /**
     * id commplementaire
     */
    @Column(name = "pha_id_complementaire")
    private Long phaIdComplementaire = 0L;

    /**
     * nom complementaire
     */
    @Column(name = "pha_nom_complemtaire")
    private String phaNomComplemtaire;

    /**
     * numero de contrat
     */
    @Column(name = "pha_contrat_complementaire")
    private String phaContratComplementaire;

    /**
     * 0=prive 1=pec 2=special 3=cas social
     */
    @Column(name = "pha_categorie")
    private Integer phaCategorie = 0;

    /**
     * part ht patient
     */
    @Column(name = "pha_tot_patient")
    private Double phaTotPatient = 0D;

    /**
     * part ht societe
     */
    @Column(name = "pha_tot_societe")
    private Double phaTotSociete = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "pha_tot_assurance")
    private Double phaTotAssurance = 0D;

    /**
     * part ht complementaire
     */
    @Column(name = "pha_tot_complmentaire")
    private Double phaTotComplmentaire = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "pha_tot_taxe_patient")
    private Double phaTotTaxePatient = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "pha_tot_taxe_societe")
    private Double phaTotTaxeSociete = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "pha_tot_taxe_assurance")
    private Double phaTotTaxeAssurance = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "pha_tot_taxe_complementaire")
    private Double phaTotTaxeComplementaire = 0D;

    /**
     * total general
     */
    @Column(name = "pha_tot_general")
    private Double phaTotGeneral = 0D;

    /**
     * reglemen t patient
     */
    @Column(name = "pha_reg_patient")
    private Double phaRegPatient = 0D;

    /**
     * solde patient
     */
    @Column(name = "pha_solde_patient")
    private Double phaSoldePatient = 0D;

    /**
     * reglement tiers
     */
    @Column(name = "pha_reg_tiers")
    private Double phaRegTiers = 0D;

    /**
     * solde tiers
     */
    @Column(name = "pha_solde_tiers")
    private Double phaSoldeTiers = 0D;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

    /**
     * date de creation
     */
    @Column(name = "pha_date_creat")
    private LocalDateTime phaDateCreat;

    /**
     * date de modification
     */
    @Column(name = "pha_date_modif")
    private LocalDateTime phaDateModif;

    /**
     * id user createur
     */
    @Column(name = "pha_id_createur")
    private Long phaIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "pha_nom_createur")
    private String phaNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "pha_id_modif")
    private Long phaIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "pha_nom_modif")
    private String phaNomModif;

    /**
     * numero
     */
    @Column(name = "pha_num")
    private String phaNum;

    /**
     * date
     */
    @Column(name = "pha_date")
    private LocalDateTime phaDate;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "pha_serie")
    private String phaSerie;

    /**
     * date de paiement du relicat
     */
    @Column(name = "pha_echeance_reliquat")
    private LocalDate phaEcheanceReliquat;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "pha_etat_val")
    private Integer phaEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "pha_etat")
    private Integer phaEtat = 0;

    /**
     * pharmacie
     */
    @Column(name = "pha_pharmacie")
    private String phaPharmacie;

    /**
     * code pathologie
     */
    @Column(name = "pha_pathologie")
    private String phaPathologie;

    /**
     * id medecin
     */
    @Column(name = "pha_id_medecin")
    private Long phaIdMedecin = 0L;

    /**
     * id patient
     */
    @Column(name = "pha_id_patient")
    private Long phaIdPatient = 0L;

    /**
     * civilite
     */
    @Column(name = "pha_civilite")
    private String phaCivilite;

    /**
     * nom et prenom
     */
    @Column(name = "pha_nom_patient")
    private String phaNomPatient;

    /**
     * avec ou sans
     */
    @Column(name = "pha_pec")
    private String phaPec;

    /**
     * famille du patient lie au fichier xml
     */
    @Column(name = "pha_fam")
    private String phaFam;

    /**
     * total taxe
     */
    @Column(name = "pha_tot_taxe_general")
    private Double phaTotTaxeGeneral = 0D;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "pha_banque")
    private String phaBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "pha_type_reg")
    private Integer phaTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "pha_mode_reg")
    private String phaModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "pha_nb_jour_reg")
    private Integer phaNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "pha_arrondi_reg")
    private Integer phaArrondiReg = 0;

    /**
     * date echeance de reglement
     */
    @Column(name = "pha_date_eche_reg")
    private LocalDate phaDateEcheReg;

    /**
     * code activite
     */
    @Column(name = "pha_activite")
    private String phaActivite;

    /**
     * info 1
     */
    @Column(name = "pha_info1")
    private String phaInfo1;

    /**
     * info 2
     */
    @Column(name = "pha_info2")
    private String phaInfo2;

    /**
     * info 3
     */
    @Column(name = "pha_info3")
    private String phaInfo3;

    /**
     * info 4
     */
    @Column(name = "pha_info4")
    private String phaInfo4;

    /**
     * info 5
     */
    @Column(name = "pha_info5")
    private String phaInfo5;

    /**
     * info 6
     */
    @Column(name = "pha_info6")
    private String phaInfo6;

    /**
     * info 7
     */
    @Column(name = "pha_info7")
    private String phaInfo7;

    /**
     * info 8
     */
    @Column(name = "pha_info8")
    private String phaInfo8;

    /**
     * info 9
     */
    @Column(name = "pha_info9")
    private String phaInfo9;

    /**
     * info 10
     */
    @Column(name = "pha_info10")
    private String phaInfo10;

    /**
     * date impression
     */
    @Column(name = "pha_date_imp")
    private LocalDateTime phaDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "pha_modele_imp")
    private String phaModeleImp;

    @Column(name = "exevte_id")
    private Long exevteId;

}
