package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_simulation_entete")
public class VteSimulationEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "simcrt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simcrtId;

    /**
     * date de creation
     */
    @Column(name = "simcrt_date_creat")
    private LocalDateTime simcrtDateCreat;

    /**
     * date de modification
     */
    @Column(name = "simcrt_date_modif")
    private LocalDateTime simcrtDateModif;

    /**
     * id user createur
     */
    @Column(name = "simcrt_id_createur")
    private Long simcrtIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "simcrt_nom_createur")
    private String simcrtNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "simcrt_id_modif")
    private Long simcrtIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "simcrt_nom_modif")
    private String simcrtNomModif;

    /**
     * date du devis
     */
    @Column(name = "simcrt_date")
    private LocalDateTime simcrtDate;

    /**
     * numero devis
     */
    @Column(name = "simcrt_num")
    private String simcrtNum;

    /**
     * nom du commercial
     */
    @Column(name = "simcrt_nom_responsable")
    private String simcrtNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "simcrt_id_responsable")
    private Long simcrtIdResponsable = 0L;

    /**
     * nom du client
     */
    @Column(name = "simcrt_nom_tiers")
    private String simcrtNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "simcrt_civil_tiers")
    private String simcrtCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "simcrt_id_contact")
    private Long simcrtIdContact = 0L;

    /**
     * nom du contact ou destinataire
     */
    @Column(name = "simcrt_nom_contact")
    private String simcrtNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "simcrt_civil_contact")
    private String simcrtCivilContact;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "simcrt_serie")
    private String simcrtSerie;

    /**
     * 0=avec tva 1=sans tva
     */
    @Column(name = "simcrt_exo_tva")
    private Integer simcrtExoTva = 0;

    /**
     * 0=avec douane 1=sans douane
     */
    @Column(name = "simcrt_exo_douane")
    private Integer simcrtExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "simcrt_cat")
    private String simcrtCat;

    /**
     * code devise
     */
    @Column(name = "simcrt_devise")
    private String simcrtDevise;

    /**
     * objet
     */
    @Column(name = "simcrt_object")
    private String simcrtObject;

    /**
     * observation
     */
    @Column(name = "simcrt_observation")
    private String simcrtObservation;

    /**
     * total ht
     */
    @Column(name = "simcrt_tot_ht")
    private Double simcrtTotHt = 0D;

    /**
     * ttal tva
     */
    @Column(name = "simcrt_tot_tva")
    private Double simcrtTotTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "simcrt_tot_tc")
    private Double simcrtTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "simcrt_tot_ttc")
    private Double simcrtTotTtc = 0D;

    /**
     * code activite
     */
    @Column(name = "simcrt_activite")
    private String simcrtActivite;

    /**
     * code site
     */
    @Column(name = "simcrt_site")
    private String simcrtSite;

    /**
     * code departement
     */
    @Column(name = "simcrt_departement")
    private String simcrtDepartement;

    /**
     * code service
     */
    @Column(name = "simcrt_service")
    private String simcrtService;

    /**
     * code region
     */
    @Column(name = "simcrt_region")
    private String simcrtRegion;

    /**
     * code secteur
     */
    @Column(name = "simcrt_secteur")
    private String simcrtSecteur;

    /**
     * code point de vente
     */
    @Column(name = "simcrt_pdv")
    private String simcrtPdv;

    /**
     * code analytique 2 (parc)
     */
    @Column(name = "simcrt_anal2")
    private String simcrtAnal2;

    /**
     * code analytique 4 (dossier)
     */
    @Column(name = "simcrt_anal4")
    private String simcrtAnal4;

    /**
     * info 1
     */
    @Column(name = "simcrt_info1")
    private String simcrtInfo1;

    /**
     * info 2
     */
    @Column(name = "simcrt_info2")
    private String simcrtInfo2;

    /**
     * info 3
     */
    @Column(name = "simcrt_info3")
    private String simcrtInfo3;

    /**
     * info 4
     */
    @Column(name = "simcrt_info4")
    private String simcrtInfo4;

    /**
     * info 5
     */
    @Column(name = "simcrt_info5")
    private String simcrtInfo5;

    /**
     * info 6
     */
    @Column(name = "simcrt_info6")
    private String simcrtInfo6;

    /**
     * info 7
     */
    @Column(name = "simcrt_info7")
    private String simcrtInfo7;

    /**
     * info 8
     */
    @Column(name = "simcrt_info8")
    private String simcrtInfo8;

    /**
     * info 9
     */
    @Column(name = "simcrt_info9")
    private String simcrtInfo9;

    /**
     * info 10
     */
    @Column(name = "simcrt_info10")
    private String simcrtInfo10;

    /**
     * code formule 1
     */
    @Column(name = "simcrt_formule1")
    private String simcrtFormule1;

    /**
     * code formule 2
     */
    @Column(name = "simcrt_formule2")
    private String simcrtFormule2;

    /**
     * nom jasper du modele annexe 1
     */
    @Column(name = "simcrt_annexe1")
    private String simcrtAnnexe1;

    /**
     * nom jasper du modele annexe 2
     */
    @Column(name = "simcrt_annexe2")
    private String simcrtAnnexe2;

    /**
     * code incoterm
     */
    @Column(name = "simcrt_incoterm")
    private String simcrtIncoterm;

    /**
     * lieu de livraison
     */
    @Column(name = "simcrt_lieu_livraison")
    private String simcrtLieuLivraison;

    /**
     * date de livraison
     */
    @Column(name = "simcrt_date_livraison")
    private LocalDate simcrtDateLivraison;

    /**
     * info sur la livraison
     */
    @Column(name = "simcrt_info_livraison")
    private String simcrtInfoLivraison;

    /**
     * date impression
     */
    @Column(name = "simcrt_date_imp")
    private LocalDateTime simcrtDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "simcrt_modele_imp")
    private String simcrtModeleImp;

    /**
     * nom jasper du modele page de garde
     */
    @Column(name = "simcrt_garde")
    private String simcrtGarde;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "simcrt_etat_val")
    private Integer simcrtEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "simcrt_gele")
    private Integer simcrtGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "simcrt_etat")
    private Integer simcrtEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "simcrt_date_validite")
    private LocalDate simcrtDateValidite;

    /**
     * date de relance
     */
    @Column(name = "simcrt_date_relance")
    private LocalDate simcrtDateRelance;

    /**
     * date de validation
     */
    @Column(name = "simcrt_date_valide")
    private LocalDateTime simcrtDateValide;

    /**
     * date de transformation
     */
    @Column(name = "simcrt_date_transforme")
    private LocalDateTime simcrtDateTransforme;

    /**
     * type de transformation
     */
    @Column(name = "simcrt_type_transforme")
    private Integer simcrtTypeTransforme = 0;

    /**
     * date annulation
     */
    @Column(name = "simcrt_date_annule")
    private LocalDateTime simcrtDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "simcrt_motif_annule")
    private String simcrtMotifAnnule;

    /**
     * type de contrat
     */
    @Column(name = "simcrt_type_contrat")
    private String simcrtTypeContrat;

    /**
     * code du produit
     */
    @Column(name = "simcrt_code")
    private String simcrtCode;

    /**
     * marque
     */
    @Column(name = "simcrt_marque")
    private String simcrtMarque;

    /**
     * gamme
     */
    @Column(name = "simcrt_gamme")
    private String simcrtGamme;

    /**
     * modele
     */
    @Column(name = "simcrt_modele")
    private String simcrtModele;

    /**
     * code taxe
     */
    @Column(name = "simcrt_taxe")
    private String simcrtTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "simcrt_taux_taxe")
    private Float simcrtTauxTaxe = 0F;

    /**
     * base prc
     */
    @Column(name = "simcrt_prc")
    private Double simcrtPrc = 0D;

    /**
     * % de remise
     */
    @Column(name = "simcrt_taux_remise")
    private Float simcrtTauxRemise = 0F;

    /**
     * montant remise
     */
    @Column(name = "simcrt_remise")
    private Double simcrtRemise = 0D;

    /**
     * base prg
     */
    @Column(name = "simcrt_prg")
    private Double simcrtPrg = 0D;

    /**
     * prix des accessoires
     */
    @Column(name = "simcrt_accessoire")
    private Double simcrtAccessoire = 0D;

    /**
     * acompte
     */
    @Column(name = "simcrt_acompte")
    private Double simcrtAcompte = 0D;

    /**
     * base de calcul
     */
    @Column(name = "simcrt_base")
    private Double simcrtBase = 0D;

    /**
     * amortissement
     */
    @Column(name = "simcrt_amortissement")
    private Double simcrtAmortissement = 0D;

    /**
     * frais financier
     */
    @Column(name = "simcrt_frais_financier")
    private Double simcrtFraisFinancier = 0D;

    /**
     * contrat entretien
     */
    @Column(name = "simcrt_entretien")
    private Double simcrtEntretien = 0D;

    /**
     * assurance
     */
    @Column(name = "simcrt_assurance")
    private Double simcrtAssurance = 0D;

    /**
     * franchise
     */
    @Column(name = "simcrt_franchise")
    private Double simcrtFranchise = 0D;

    /**
     * frais structure
     */
    @Column(name = "simcrt_fraisStructure")
    private Double simcrtFraisstructure = 0D;

    /**
     * remplacement
     */
    @Column(name = "simcrt_remplacement")
    private Double simcrtRemplacement = 0D;

    /**
     * remplissage
     */
    @Column(name = "simcrt_remplissage")
    private Double simcrtRemplissage = 0D;

    /**
     * valeur de rachat
     */
    @Column(name = "simcrt_valeur_rachat")
    private Double simcrtValeurRachat = 0D;

    /**
     * prix de revient
     */
    @Column(name = "simcrt_pr")
    private Double simcrtPr = 0D;

    /**
     * valeur residuelle theorique
     */
    @Column(name = "simcrt_valeur_residuelle_theo")
    private Double simcrtValeurResiduelleTheo = 0D;

    /**
     * valeur residuelle rellee
     */
    @Column(name = "simcrt_valeur_residuelle_reelle")
    private Double simcrtValeurResiduelleReelle = 0D;

    /**
     * nombre de mois minimum
     */
    @Column(name = "simcrt_duree_moin")
    private Integer simcrtDureeMoin = 0;

    /**
     * nombre de mois maximum
     */
    @Column(name = "simcrt_duree_max")
    private Integer simcrtDureeMax = 0;

    /**
     * nombre de mois
     */
    @Column(name = "simcrt_nb_mois")
    private Integer simcrtNbMois = 0;

    /**
     * total mensuel ht
     */
    @Column(name = "simcrt_th_mois")
    private Double simcrtThMois = 0D;

    /**
     * total mensuel taxe
     */
    @Column(name = "simcrt_tx_mois")
    private Double simcrtTxMois = 0D;

    /**
     * total mensuel ttc
     */
    @Column(name = "simcrt_tt_mois")
    private Double simcrtTtMois = 0D;

    /**
     * cumule echeance
     */
    @Column(name = "simcrt_cumul_echeance")
    private Double simcrtCumulEcheance = 0D;

    /**
     * taux valeur residuelle
     */
    @Column(name = "simcrt_taux_valeur_residuelle")
    private Float simcrtTauxValeurResiduelle = 0F;

    /**
     * taux amortissement
     */
    @Column(name = "simcrt_taux_amortissement")
    private Float simcrtTauxAmortissement = 0F;

    /**
     * taux frais financier
     */
    @Column(name = "simcrt_taux_frais_financier")
    private Float simcrtTauxFraisFinancier = 0F;

    /**
     * taux cout entretien
     */
    @Column(name = "simcrt_taux_entretien")
    private Float simcrtTauxEntretien = 0F;

    /**
     * taux assurance
     */
    @Column(name = "simcrt_taux_assurance")
    private Float simcrtTauxAssurance = 0F;

    /**
     * taux franchise
     */
    @Column(name = "simcrt_taux_franchise")
    private Float simcrtTauxFranchise = 0F;

    /**
     * taux frais structure
     */
    @Column(name = "simcrt_taux_frais_structure")
    private Float simcrtTauxFraisStructure = 0F;

    /**
     * taux vehicule de remplacement
     */
    @Column(name = "simcrt_taux_remplacement")
    private Float simcrtTauxRemplacement = 0F;

    /**
     * taux remplissage
     */
    @Column(name = "simcrt_taux_remplissage")
    private Float simcrtTauxRemplissage = 0F;

    /**
     * taux marge
     */
    @Column(name = "simcrt_taux_marge")
    private Float simcrtTauxMarge = 0F;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "simcrt_divers_tiers")
    private Integer simcrtDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "simcrt_divers_nom")
    private String simcrtDiversNom;

    /**
     * adresse du tiers divers
     */
    @Column(name = "simcrt_divers_adresse")
    private String simcrtDiversAdresse;

    /**
     * ville du tiers divers
     */
    @Column(name = "simcrt_divers_ville")
    private String simcrtDiversVille;

    /**
     * telephone du tiers divers
     */
    @Column(name = "simcrt_divers_tel")
    private String simcrtDiversTel;

    /**
     * mail du tiers divers
     */
    @Column(name = "simcrt_divers_mail")
    private String simcrtDiversMail;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du commercial
     */
    @Column(name = "simcrt_nom_commercial")
    private String simcrtNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "simcrt_id_commercial")
    private Long simcrtIdCommercial = 0L;

    /**
     * nom equipe
     */
    @Column(name = "simcrt_nom_equipe")
    private String simcrtNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "simcrt_id_equipe")
    private Long simcrtIdEquipe = 0L;

}
