package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_blivraison_entete")
public class VteBlivraisonEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "blv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blvId;

    /**
     * date de creation
     */
    @Column(name = "blv_date_creat")
    private LocalDateTime blvDateCreat;

    /**
     * date de modification
     */
    @Column(name = "blv_date_modif")
    private LocalDateTime blvDateModif;

    /**
     * id user createur
     */
    @Column(name = "blv_id_createur")
    private Long blvIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "blv_nom_createur")
    private String blvNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "blv_id_modif")
    private Long blvIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "blv_nom_modif")
    private String blvNomModif;

    /**
     * 0=fermer 1=ouvert
     */
    @Column(name = "blv_maj")
    private Integer blvMaj = 0;

    /**
     * date du bon de livraison
     */
    @Column(name = "blv_date")
    private LocalDateTime blvDate;

    /**
     * numero du bon de livraison
     */
    @Column(name = "blv_num")
    private String blvNum;

    /**
     * nom du commercial
     */
    @Column(name = "blv_nom_responsable")
    private String blvNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "blv_id_responsable")
    private Long blvIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "blv_nom_tiers")
    private String blvNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "blv_civil_tiers")
    private String blvCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "blv_id_contact")
    private Long blvIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "blv_nom_contact")
    private String blvNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "blv_civil_contact")
    private String blvCivilContact;

    /**
     * serie
     */
    @Column(name = "blv_serie")
    private String blvSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "blv_exo_tva")
    private Integer blvExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "blv_exo_douane")
    private Integer blvExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "blv_cat")
    private String blvCat;

    /**
     * code devise
     */
    @Column(name = "blv_devise")
    private String blvDevise;

    /**
     * objet
     */
    @Column(name = "blv_object")
    private String blvObject;

    /**
     * observation
     */
    @Column(name = "blv_observation")
    private String blvObservation;

    /**
     * code budget
     */
    @Column(name = "blv_budget")
    private String blvBudget;

    /**
     * total ht
     */
    @Column(name = "blv_tot_ht")
    private Double blvTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "blv_tot_remise")
    private Double blvTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "blv_tot_rabais")
    private Double blvTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "blv_tot_tva")
    private Double blvTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "blv_taux_tc")
    private Float blvTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "blv_tot_tc")
    private Double blvTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "blv_tot_ttc")
    private Double blvTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "blv_tot_reglement")
    private Double blvTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "blv_solde")
    private Integer blvSolde = 0;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "blv_banque")
    private String blvBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    @Column(name = "blv_type_reg")
    private Integer blvTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "blv_mode_reg")
    private String blvModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "blv_nb_jour_reg")
    private Integer blvNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "blv_arrondi_reg")
    private Integer blvArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "blv_condition_reg")
    private String blvConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "blv_date_eche_reg")
    private LocalDate blvDateEcheReg;

    /**
     * code journal des reglements
     */
    @Column(name = "blv_journal_reg")
    private String blvJournalReg;

    /**
     * code activite
     */
    @Column(name = "blv_activite")
    private String blvActivite;

    /**
     * code site
     */
    @Column(name = "blv_site")
    private String blvSite;

    /**
     * code departement
     */
    @Column(name = "blv_departement")
    private String blvDepartement;

    /**
     * code service
     */
    @Column(name = "blv_service")
    private String blvService;

    /**
     * code region
     */
    @Column(name = "blv_region")
    private String blvRegion;

    /**
     * code secteur
     */
    @Column(name = "blv_secteur")
    private String blvSecteur;

    /**
     * code point de vente
     */
    @Column(name = "blv_pdv")
    private String blvPdv;

    /**
     * code analytique 2
     */
    @Column(name = "blv_anal2")
    private String blvAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "blv_anal4")
    private String blvAnal4;

    /**
     * info 1
     */
    @Column(name = "blv_info1")
    private String blvInfo1;

    /**
     * info 2
     */
    @Column(name = "blv_info2")
    private String blvInfo2;

    /**
     * info 3
     */
    @Column(name = "blv_info3")
    private String blvInfo3;

    /**
     * info 4
     */
    @Column(name = "blv_info4")
    private String blvInfo4;

    /**
     * info 5
     */
    @Column(name = "blv_info5")
    private String blvInfo5;

    /**
     * info 6
     */
    @Column(name = "blv_info6")
    private String blvInfo6;

    /**
     * info 7
     */
    @Column(name = "blv_info7")
    private String blvInfo7;

    /**
     * info 8
     */
    @Column(name = "blv_info8")
    private String blvInfo8;

    /**
     * info 9
     */
    @Column(name = "blv_info9")
    private String blvInfo9;

    /**
     * info 10
     */
    @Column(name = "blv_info10")
    private String blvInfo10;

    /**
     * code formule 1
     */
    @Column(name = "blv_formule1")
    private String blvFormule1;

    /**
     * code formule 2
     */
    @Column(name = "blv_formule2")
    private String blvFormule2;

    /**
     * nom jasper de l annexe 1
     */
    @Column(name = "blv_annexe1")
    private String blvAnnexe1;

    /**
     * nom jasper de l annexe 2
     */
    @Column(name = "blv_annexe2")
    private String blvAnnexe2;

    /**
     * code contrat
     */
    @Column(name = "blv_contrat")
    private String blvContrat;

    /**
     * code incoterm
     */
    @Column(name = "blv_incoterm")
    private String blvIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "blv_lieu_livraison")
    private String blvLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "blv_date_livraison")
    private LocalDate blvDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "blv_info_livraison")
    private String blvInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "blv_date_imp")
    private LocalDate blvDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "blv_modele_imp")
    private String blvModeleImp;

    /**
     * nom jasper page de garde
     */
    @Column(name = "blv_garde")
    private String blvGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "blv_etat_val")
    private Integer blvEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "blv_gele")
    private Integer blvGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "blv_etat")
    private Integer blvEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "blv_date_validite")
    private LocalDate blvDateValidite;

    /**
     * date de relance
     */
    @Column(name = "blv_date_relance")
    private LocalDate blvDateRelance;

    /**
     * date de validation
     */
    @Column(name = "blv_date_valide")
    private LocalDate blvDateValide;

    /**
     * date de transformation
     */
    @Column(name = "blv_date_transforme")
    private LocalDate blvDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "blv_type_transforme")
    private Integer blvTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "blv_date_annule")
    private LocalDate blvDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "blv_motif_annule")
    private String blvMotifAnnule;

    /**
     * date de facturation
     */
    @Column(name = "blv_date_facture")
    private LocalDate blvDateFacture;

    /**
     * nom du factor
     */
    @Column(name = "blv_factor_nom")
    private String blvFactorNom;

    /**
     * id du factor
     */
    @Column(name = "blv_factor_id")
    private Long blvFactorId = 0L;

    /**
     * 0=en cours 1=accepter 2=refuser
     */
    @Column(name = "blv_factor_etat")
    private Integer blvFactorEtat = 0;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "blv_divers_tiers")
    private Integer blvDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "blv_divers_nom")
    private String blvDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "blv_divers_adresse")
    private String blvDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "blv_divers_ville")
    private String blvDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "blv_divers_tel")
    private String blvDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "blv_divers_mail")
    private String blvDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "blv_nom_commercial")
    private String blvNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "blv_id_commercial")
    private Long blvIdCommercial = 0L;

    /**
     * memorisation numero facture
     */
    @Column(name = "blv_memo_num_facture")
    private String blvMemoNumFacture;

    /**
     * nom equipe
     */
    @Column(name = "blv_nom_equipe")
    private String blvNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "blv_id_equipe")
    private Long blvIdEquipe = 0L;

    /**
     * numero facture
     */
    @Column(name = "blvo_num_facture")
    private String blvoNumFacture;

    /**
     * 0=En cours 1=livree partiel 2=livree total
     */
    @Column(name = "blv_livree_etat")
    private Integer blvLivreeEtat = 0;

    /**
     * 0=sans livreur 1=avec livreur
     */
    @Column(name = "blv_livreur")
    private Integer blvLivreur = 0;

    /**
     * taux remise globale
     */
    @Column(name = "blv_taux_remise")
    private Float blvTauxRemise = 0F;

    /**
     * source du document
     */
    @Column(name = "blv_source")
    private String blvSource;

}
