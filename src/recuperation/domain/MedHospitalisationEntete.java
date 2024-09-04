package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_hospitalisation_entete")
public class MedHospitalisationEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hos_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hosId;

    /**
     * date de creation
     */
    @Column(name = "hos_date_creat")
    private LocalDateTime hosDateCreat;

    /**
     * date de modification
     */
    @Column(name = "hos_date_modif")
    private LocalDateTime hosDateModif;

    /**
     * id user createur
     */
    @Column(name = "hos_id_createur")
    private Long hosIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "hos_nom_createur")
    private String hosNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "hos_id_modif")
    private Long hosIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "hos_nom_modif")
    private String hosNomModif;

    /**
     * numero consult
     */
    @Column(name = "hos_num")
    private String hosNum;

    /**
     * date entree
     */
    @Column(name = "hos_date_entree")
    private LocalDate hosDateEntree;

    /**
     * date sortie
     */
    @Column(name = "hos_date_sortie")
    private LocalDate hosDateSortie;

    /**
     * nombre de jours
     */
    @Column(name = "hos_nb_jour")
    private Integer hosNbJour = 0;

    /**
     * motid entree fichier xml
     */
    @Column(name = "hos_motif_entree")
    private String hosMotifEntree;

    /**
     * motid sortie fichier xml
     */
    @Column(name = "hos_motif_sortie")
    private String hosMotifSortie;

    /**
     * 0=ns 1=accident domestique 2=accident route 3=accident travail 4=maladie 5=autre
     */
    @Column(name = "hos_categorie")
    private Integer hosCategorie = 0;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "hos_serie")
    private String hosSerie;

    /**
     * date de modification
     */
    @Column(name = "hos_date_transfert")
    private LocalDate hosDateTransfert;

    /**
     * date de paiement du relicat
     */
    @Column(name = "hos_echeance_reliquat")
    private LocalDate hosEcheanceReliquat;

    /**
     * 0=non cloture 1=cloture
     */
    @Column(name = "hos_cloture")
    private Integer hosCloture = 0;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "hos_etat_val")
    private Integer hosEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "hos_etat")
    private Integer hosEtat = 0;

    /**
     * numero rss
     */
    @Column(name = "hos_num_rss")
    private String hosNumRss;

    /**
     * numero rum
     */
    @Column(name = "hos_num_rum")
    private String hosNumRum;

    /**
     * liste des serivces
     */
    @Column(name = "hos_service")
    private String hosService;

    /**
     * code protocole
     */
    @Column(name = "hos_protocole")
    private String hosProtocole;

    /**
     * code pathologie
     */
    @Column(name = "hos_pathologie")
    private String hosPathologie;

    /**
     * nom prescripteur
     */
    @Column(name = "hos_prescripteur")
    private String hosPrescripteur;

    /**
     * id medecin
     */
    @Column(name = "hos_id_medecin")
    private Long hosIdMedecin = 0L;

    /**
     * nom medecin
     */
    @Column(name = "hos_medecin")
    private String hosMedecin;

    /**
     * numeo bon de commande
     */
    @Column(name = "hos_num_bc")
    private String hosNumBc;

    /**
     * id patient
     */
    @Column(name = "hos_id_patient")
    private Long hosIdPatient = 0L;

    /**
     * civilite
     */
    @Column(name = "hos_civilite")
    private String hosCivilite;

    /**
     * nom et prenom
     */
    @Column(name = "hos_nom_patient")
    private String hosNomPatient;

    /**
     * id societe
     */
    @Column(name = "hos_id_societe")
    private Long hosIdSociete = 0L;

    /**
     * nom societe
     */
    @Column(name = "hos_nom_societe")
    private String hosNomSociete;

    /**
     * matricule
     */
    @Column(name = "hos_matricule")
    private String hosMatricule;

    /**
     * id assurance
     */
    @Column(name = "hos_id_assurance")
    private Long hosIdAssurance = 0L;

    /**
     * nom assurance
     */
    @Column(name = "hos_nom_assurance")
    private String hosNomAssurance;

    /**
     * numero de contrat
     */
    @Column(name = "hos_contrat_assurance")
    private String hosContratAssurance;

    /**
     * id commplementaire
     */
    @Column(name = "hos_id_complementaire")
    private Long hosIdComplementaire = 0L;

    /**
     * nom complementaire
     */
    @Column(name = "hos_nom_complemtaire")
    private String hosNomComplemtaire;

    /**
     * numero de contrat
     */
    @Column(name = "hos_contrat_complementaire")
    private String hosContratComplementaire;

    /**
     * avec ou sans
     */
    @Column(name = "hos_pec")
    private String hosPec;

    /**
     * famille du patient lie au fichier xml
     */
    @Column(name = "hos_fam")
    private String hosFam;

    /**
     * part ht patient
     */
    @Column(name = "hos_tot_patient")
    private Double hosTotPatient = 0D;

    /**
     * part ht societe
     */
    @Column(name = "hos_tot_societe")
    private Double hosTotSociete = 0D;

    /**
     * part ht assurance
     */
    @Column(name = "hos_tot_assurance")
    private Double hosTotAssurance = 0D;

    /**
     * part ht complementaire
     */
    @Column(name = "hos_tot_complmentaire")
    private Double hosTotComplmentaire = 0D;

    /**
     * part taxe patient
     */
    @Column(name = "hos_tot_taxe_patient")
    private Double hosTotTaxePatient = 0D;

    /**
     * part taxe societe
     */
    @Column(name = "hos_tot_taxe_societe")
    private Double hosTotTaxeSociete = 0D;

    /**
     * part taxe assurance
     */
    @Column(name = "hos_tot_taxe_assurance")
    private Double hosTotTaxeAssurance = 0D;

    /**
     * part taxe complementaire
     */
    @Column(name = "hos_tot_taxe_complementaire")
    private Double hosTotTaxeComplementaire = 0D;

    /**
     * total general
     */
    @Column(name = "hos_tot_general")
    private Double hosTotGeneral = 0D;

    /**
     * total taxe
     */
    @Column(name = "hos_tot_taxe_general")
    private Double hosTotTaxeGeneral = 0D;

    /**
     * reglement patient
     */
    @Column(name = "hos_reg_patient")
    private Double hosRegPatient = 0D;

    /**
     * 0= non solde 1=solde patient
     */
    @Column(name = "hos_solde_patient")
    private Integer hosSoldePatient = 0;

    /**
     * reglement tiers
     */
    @Column(name = "hos_reg_tiers")
    private Double hosRegTiers = 0D;

    /**
     * 0= non solde 1=solde tiers
     */
    @Column(name = "hos_solde_tiers")
    private Integer hosSoldeTiers = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "hos_banque")
    private String hosBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "hos_type_reg")
    private Integer hosTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "hos_mode_reg")
    private String hosModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "hos_nb_jour_reg")
    private Integer hosNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "hos_arrondi_reg")
    private Integer hosArrondiReg = 0;

    /**
     * date echeance de reglement
     */
    @Column(name = "hos_date_eche_reg")
    private LocalDate hosDateEcheReg;

    /**
     * code activite
     */
    @Column(name = "hos_activite")
    private String hosActivite;

    /**
     * info 1
     */
    @Column(name = "hos_info1")
    private String hosInfo1;

    /**
     * info 2
     */
    @Column(name = "hos_info2")
    private String hosInfo2;

    /**
     * info 3
     */
    @Column(name = "hos_info3")
    private String hosInfo3;

    /**
     * info 4
     */
    @Column(name = "hos_info4")
    private String hosInfo4;

    /**
     * info 5
     */
    @Column(name = "hos_info5")
    private String hosInfo5;

    /**
     * info 6
     */
    @Column(name = "hos_info6")
    private String hosInfo6;

    /**
     * info 7
     */
    @Column(name = "hos_info7")
    private String hosInfo7;

    /**
     * info 8
     */
    @Column(name = "hos_info8")
    private String hosInfo8;

    /**
     * info 9
     */
    @Column(name = "hos_info9")
    private String hosInfo9;

    /**
     * info 10
     */
    @Column(name = "hos_info10")
    private String hosInfo10;

    /**
     * date impression
     */
    @Column(name = "hos_date_imp")
    private LocalDateTime hosDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "hos_modele_imp")
    private String hosModeleImp;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "pat_id", nullable = false)
    private Long patId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
