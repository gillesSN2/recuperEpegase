package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_laboratoire_entete")
public class MedLaboratoireEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labId;

    /**
     * numero
     */
    @Column(name = "lab_num")
    private String labNum = "0";

    /**
     * date de creation
     */
    @Column(name = "lab_date_creation")
    private LocalDate labDateCreation;

    /**
     * date de transfert
     */
    @Column(name = "lab_date_transfert")
    private LocalDate labDateTransfert;

    /**
     * 0=non cloture 1=cloture
     */
    @Column(name = "lab_cloture")
    private Integer labCloture = 0;

    /**
     * numero hospitalisation
     */
    @Column(name = "lab_num_hospit")
    private String labNumHospit = "0";

    /**
     * numero rum
     */
    @Column(name = "lab_num_rum")
    private String labNumRum = "0";

    /**
     * code service
     */
    @Column(name = "lab_service")
    private String labService = "0";

    /**
     * code protocole
     */
    @Column(name = "lab_protocole")
    private String labProtocole = "0";

    /**
     * motif entree
     */
    @Column(name = "lab_entree")
    private String labEntree = "0";

    /**
     * nom prescripteur
     */
    @Column(name = "lab_prescripteur")
    private String labPrescripteur = "0";

    /**
     * nom medecin
     */
    @Column(name = "lab_medecin")
    private String labMedecin = "0";

    /**
     * numero de bon de commande
     */
    @Column(name = "lab_num_bc")
    private String labNumBc = "0";

    /**
     * numero de paillasse
     */
    @Column(name = "lab_num_paillasse")
    private Long labNumPaillasse = 0L;

    /**
     * date des resultats
     */
    @Column(name = "lab_date_resultat")
    private LocalDate labDateResultat;

    /**
     * date du peÃƒÆ’Ã‚Â©levement
     */
    @Column(name = "lab_date_prelevement")
    private LocalDate labDatePrelevement;

    /**
     * 0=non renseigne 1=domicile 2=laboratoire
     */
    @Column(name = "lab_lieu_prelevement")
    private Integer labLieuPrelevement = 0;

    /**
     * 0=non renseigne 1=acec partenaire 2=sans partenaire
     */
    @Column(name = "lab_partenaire")
    private Integer labPartenaire = 0;

    /**
     * date des derniere regles
     */
    @Column(name = "lab_date_regles")
    private LocalDate labDateRegles;

    /**
     * id societe
     */
    @Column(name = "lab_id_societe")
    private Long labIdSociete = 0L;

    /**
     * nom societe
     */
    @Column(name = "lab_nom_societe")
    private String labNomSociete = "0";

    /**
     * matricule
     */
    @Column(name = "lab_matricule")
    private String labMatricule = "0";

    /**
     * id assurance
     */
    @Column(name = "lab_id_assurance")
    private Long labIdAssurance = 0L;

    /**
     * nom assurance
     */
    @Column(name = "lab_nom_assurance")
    private String labNomAssurance = "0";

    /**
     * numeo de contrat
     */
    @Column(name = "lab_contrat_assurance")
    private String labContratAssurance = "0";

    /**
     * id complementaires
     */
    @Column(name = "lab_id_complementaire")
    private Long labIdComplementaire = 0L;

    /**
     * nom complementaires
     */
    @Column(name = "lab_nom_complemtaire")
    private String labNomComplemtaire = "0";

    /**
     * numero de contrat
     */
    @Column(name = "lab_contrat_complementaire")
    private String labContratComplementaire = "0";

    /**
     * 0=prive 1=pec 2=special 3=cas social
     */
    @Column(name = "lab_categorie")
    private Integer labCategorie = 0;

    /**
     * part ht patient
     */
    @Column(name = "lab_tot_patient")
    private Double labTotPatient = 0D;

    /**
     * part ht societe
     */
    @Column(name = "lab_tot_societe")
    private Double labTotSociete = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "lab_tot_assurance")
    private Double labTotAssurance = 0D;

    /**
     * part ht complementaire
     */
    @Column(name = "lab_tot_complmentaire")
    private Double labTotComplmentaire = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "lab_tot_taxe_patient")
    private Double labTotTaxePatient = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "lab_tot_taxe_societe")
    private Double labTotTaxeSociete = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "lab_tot_taxe_assurance")
    private Double labTotTaxeAssurance = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "lab_tot_taxe_complementaire")
    private Double labTotTaxeComplementaire = 0D;

    /**
     * total general
     */
    @Column(name = "lab_tot_general")
    private Double labTotGeneral = 0D;

    /**
     * reglement patient
     */
    @Column(name = "lab_reg_patient")
    private Double labRegPatient = 0D;

    /**
     * solde patient
     */
    @Column(name = "lab_solde_patient")
    private Double labSoldePatient = 0D;

    /**
     * regelemtnt iers
     */
    @Column(name = "lab_reg_tiers")
    private Double labRegTiers = 0D;

    /**
     * solde tiers
     */
    @Column(name = "lab_solde_tiers")
    private Double labSoldeTiers = 0D;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

    /**
     * date de creation
     */
    @Column(name = "lab_date_creat")
    private LocalDateTime labDateCreat;

    /**
     * date de modification
     */
    @Column(name = "lab_date_modif")
    private LocalDateTime labDateModif;

    /**
     * id user createur
     */
    @Column(name = "lab_id_createur")
    private Long labIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "lab_nom_createur")
    private String labNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "lab_id_modif")
    private Long labIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "lab_nom_modif")
    private String labNomModif;

    /**
     * date
     */
    @Column(name = "lab_date")
    private LocalDateTime labDate;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "lab_serie")
    private String labSerie;

    /**
     * date de paiement du relicat
     */
    @Column(name = "lab_echeance_reliquat")
    private LocalDate labEcheanceReliquat;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "lab_etat_val")
    private Integer labEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "lab_etat")
    private Integer labEtat = 0;

    /**
     * laboratoire
     */
    @Column(name = "lab_laboratoire")
    private String labLaboratoire;

    /**
     * code pathologie
     */
    @Column(name = "lab_pathologie")
    private String labPathologie;

    /**
     * id medecin
     */
    @Column(name = "lab_id_medecin")
    private Long labIdMedecin = 0L;

    /**
     * id patient
     */
    @Column(name = "lab_id_patient")
    private Long labIdPatient = 0L;

    /**
     * civilite
     */
    @Column(name = "lab_civilite")
    private String labCivilite;

    /**
     * nom et prenom
     */
    @Column(name = "lab_nom_patient")
    private String labNomPatient;

    /**
     * avec ou sans
     */
    @Column(name = "lab_pec")
    private String labPec;

    /**
     * famille du patient lie au fichier xml
     */
    @Column(name = "lab_fam")
    private String labFam;

    /**
     * total taxe
     */
    @Column(name = "lab_tot_taxe_general")
    private Double labTotTaxeGeneral = 0D;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "lab_banque")
    private String labBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "lab_type_reg")
    private Integer labTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "lab_mode_reg")
    private String labModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "lab_nb_jour_reg")
    private Integer labNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "lab_arrondi_reg")
    private Integer labArrondiReg = 0;

    /**
     * date echeance de reglement
     */
    @Column(name = "lab_date_eche_reg")
    private LocalDate labDateEcheReg;

    /**
     * code activite
     */
    @Column(name = "lab_activite")
    private String labActivite;

    /**
     * info 1
     */
    @Column(name = "lab_info1")
    private String labInfo1;

    /**
     * info 2
     */
    @Column(name = "lab_info2")
    private String labInfo2;

    /**
     * info 3
     */
    @Column(name = "lab_info3")
    private String labInfo3;

    /**
     * info 4
     */
    @Column(name = "lab_info4")
    private String labInfo4;

    /**
     * info 5
     */
    @Column(name = "lab_info5")
    private String labInfo5;

    /**
     * info 6
     */
    @Column(name = "lab_info6")
    private String labInfo6;

    /**
     * info 7
     */
    @Column(name = "lab_info7")
    private String labInfo7;

    /**
     * info 8
     */
    @Column(name = "lab_info8")
    private String labInfo8;

    /**
     * info 9
     */
    @Column(name = "lab_info9")
    private String labInfo9;

    /**
     * info 10
     */
    @Column(name = "lab_info10")
    private String labInfo10;

    /**
     * date impression
     */
    @Column(name = "lab_date_imp")
    private LocalDateTime labDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "lab_modele_imp")
    private String labModeleImp;

    /**
     * si true alors anonyme
     */
    @Column(name = "lab_anomyme")
    private Boolean labAnomyme = Boolean.FALSE;

    @Column(name = "exevte_id")
    private Long exevteId;

}
