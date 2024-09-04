package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_valorisation_entete")
public class AchValorisationEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "val_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valId;

    /**
     * date de creation
     */
    @Column(name = "val_date_creat")
    private LocalDateTime valDateCreat;

    /**
     * date de modification
     */
    @Column(name = "val_date_modif")
    private LocalDateTime valDateModif;

    /**
     * id user createur
     */
    @Column(name = "val_id_createur")
    private Long valIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "val_nom_createur")
    private String valNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "val_id_modif")
    private Long valIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "val_nom_modif")
    private String valNomModif;

    /**
     * date valorisation
     */
    @Column(name = "val_date")
    private LocalDateTime valDate;

    /**
     * numero valorisation
     */
    @Column(name = "val_num")
    private String valNum;

    /**
     * serie
     */
    @Column(name = "val_serie")
    private String valSerie;

    /**
     * site
     */
    @Column(name = "val_site")
    private String valSite;

    /**
     * departement
     */
    @Column(name = "val_departement")
    private String valDepartement;

    /**
     * service
     */
    @Column(name = "val_service")
    private String valService;

    /**
     * region
     */
    @Column(name = "val_region")
    private String valRegion;

    /**
     * secteur
     */
    @Column(name = "val_secteur")
    private String valSecteur;

    /**
     * point de vente
     */
    @Column(name = "val_pdv")
    private String valPdv;

    /**
     * nature (12=commande, 13=reception)
     */
    @Column(name = "val_nature1")
    private Integer valNature1 = 0;

    /**
     * nature (47=reexpedition)
     */
    @Column(name = "val_nature2")
    private Integer valNature2 = 0;

    /**
     * nom du commercial
     */
    @Column(name = "val_nom_responsable")
    private String valNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "val_id_responsable")
    private Long valIdResponsable = 0L;

    /**
     * total commande
     */
    @Column(name = "val_total_commande")
    private Double valTotalCommande = 0D;

    /**
     * total reception
     */
    @Column(name = "val_total_reception")
    private Double valTotalReception = 0D;

    /**
     * total retour
     */
    @Column(name = "val_total_retour")
    private Double valTotalRetour = 0D;

    /**
     * total note de debit
     */
    @Column(name = "val_total_note_debit")
    private Double valTotalNoteDebit = 0D;

    /**
     * total rexpedition
     */
    @Column(name = "val_total_rexpedition")
    private Double valTotalRexpedition = 0D;

    /**
     * total frais 1
     */
    @Column(name = "val_total_frais1")
    private Double valTotalFrais1 = 0D;

    /**
     * total frais 2
     */
    @Column(name = "val_total_frais2")
    private Double valTotalFrais2 = 0D;

    /**
     * prix de revient 1
     */
    @Column(name = "val_pr1")
    private Double valPr1 = 0D;

    /**
     * prix de revient 2
     */
    @Column(name = "val_pr2")
    private Double valPr2 = 0D;

    /**
     * coefficient 1
     */
    @Column(name = "val_coef1")
    private Float valCoef1 = 0F;

    /**
     * coefficient 2
     */
    @Column(name = "val_coef2")
    private Float valCoef2 = 0F;

    /**
     * 0=calcul valeur 1=calcul poids
     */
    @Column(name = "val_calcul")
    private Integer valCalcul = 0;

    /**
     * objet de la valorisation
     */
    @Column(name = "val_objet")
    private String valObjet;

    /**
     * numero dossier transit
     */
    @Column(name = "val_dossier_transit")
    private String valDossierTransit;

    /**
     * date intention
     */
    @Column(name = "val_date_intention")
    private LocalDate valDateIntention;

    /**
     * date peremption intention
     */
    @Column(name = "val_date_intention_fin")
    private LocalDate valDateIntentionFin;

    /**
     * reference credoc
     */
    @Column(name = "val_ref_credoc")
    private String valRefCredoc;

    /**
     * nom du bateau
     */
    @Column(name = "val_nom_bateau")
    private String valNomBateau;

    /**
     * port de chargement
     */
    @Column(name = "val_port_chargement")
    private String valPortChargement;

    /**
     * date de chargement
     */
    @Column(name = "val_date_chargement")
    private LocalDate valDateChargement;

    /**
     * port de dechargement
     */
    @Column(name = "val_port_dechargement")
    private String valPortDechargement;

    /**
     * date de dechargement
     */
    @Column(name = "val_date_dechargement")
    private LocalDate valDateDechargement;

    /**
     * bureau de douane
     */
    @Column(name = "val_bureau_douane")
    private String valBureauDouane;

    /**
     * date arrivee
     */
    @Column(name = "val_date_arrivee")
    private LocalDate valDateArrivee;

    /**
     * numero manifeste
     */
    @Column(name = "val_manifeste")
    private String valManifeste;

    /**
     * total frais expert
     */
    @Column(name = "val_total_expert")
    private Double valTotalExpert = 0D;

    /**
     * total valeur de reference
     */
    @Column(name = "val_total_reference")
    private Double valTotalReference = 0D;

    /**
     * nom banque
     */
    @Column(name = "val_banque")
    private String valBanque;

    /**
     * poids brut
     */
    @Column(name = "val_poids_brut")
    private Float valPoidsBrut = 0F;

    /**
     * poids net
     */
    @Column(name = "val_poids_net")
    private Float valPoidsNet = 0F;

    /**
     * unite de conversion
     */
    @Column(name = "val_poids_unite")
    private Integer valPoidsUnite = 0;

    /**
     * nombre unite
     */
    @Column(name = "val_nb_colis")
    private Integer valNbColis = 0;

    /**
     * nombre contener
     */
    @Column(name = "val_nb_contener")
    private Integer valNbContener = 0;

    /**
     * nombre camion
     */
    @Column(name = "val_nb_camion")
    private Integer valNbCamion = 0;

    /**
     * nombre wagon
     */
    @Column(name = "val_nb_wagon")
    private Integer valNbWagon = 0;

    /**
     * date impression
     */
    @Column(name = "val_date_imp")
    private LocalDate valDateImp;

    /**
     * modele impression
     */
    @Column(name = "val_modele_imp")
    private String valModeleImp;

    /**
     * 0=sans validation 1=avecc validation
     */
    @Column(name = "val_etat_val")
    private Integer valEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "val_etat")
    private Integer valEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "val_date_valide")
    private LocalDate valDateValide;

    /**
     * total fob
     */
    @Column(name = "val_total_fob")
    private Double valTotalFob = 0D;

    /**
     * total divers
     */
    @Column(name = "val_total_divers")
    private Double valTotalDivers = 0D;

    /**
     * total fret
     */
    @Column(name = "val_total_fret")
    private Double valTotalFret = 0D;

    /**
     * total assurance theorique
     */
    @Column(name = "val_total_assurance_theo")
    private Double valTotalAssuranceTheo = 0D;

    /**
     * total assurance reelle
     */
    @Column(name = "val_total_assurance_reelle")
    private Double valTotalAssuranceReelle = 0D;

    /**
     * total douane theorique
     */
    @Column(name = "val_total_douane_theo")
    private Double valTotalDouaneTheo = 0D;

    /**
     * total douane relle
     */
    @Column(name = "val_total_douane_reelle")
    private Double valTotalDouaneReelle = 0D;

    /**
     * total tva douane theorique
     */
    @Column(name = "val_total_tva_douane_theo")
    private Double valTotalTvaDouaneTheo = 0D;

    /**
     * total tva douane reelle
     */
    @Column(name = "val_total_tva_douane_reelle")
    private Double valTotalTvaDouaneReelle = 0D;

    /**
     * total douane theorique
     */
    @Column(name = "val_total_transit")
    private Double valTotalTransit = 0D;

    /**
     * total debours
     */
    @Column(name = "val_total_debours")
    private Double valTotalDebours = 0D;

    /**
     * 0=normal 1=fictif
     */
    @Column(name = "val_fictif")
    private Integer valFictif = 0;

    /**
     * 0=pr au poids 1=pr au prix achat
     */
    @Column(name = "val_calcul_pr")
    private Integer valCalculPr = 0;

    /**
     * true = exonere de tva
     */
    @Column(name = "val_exo_tva")
    private Boolean valExoTva = Boolean.FALSE;

    /**
     * true = exonere de douane
     */
    @Column(name = "val_exo_douane")
    private Boolean valExoDouane = Boolean.FALSE;

    /**
     * id assureur
     */
    @Column(name = "val_id_assureur")
    private Long valIdAssureur = 0L;

    /**
     * nom assureur
     */
    @Column(name = "val_nom_assureur")
    private String valNomAssureur;

    /**
     * id transitaire
     */
    @Column(name = "val_id_transitaire")
    private Long valIdTransitaire = 0L;

    /**
     * nom transitaire
     */
    @Column(name = "val_nom_transitaire")
    private String valNomTransitaire;

    /**
     * id transporteur
     */
    @Column(name = "val_id_transporteur")
    private Long valIdTransporteur = 0L;

    /**
     * nom transporteur
     */
    @Column(name = "val_nom_transporteur")
    private String valNomTransporteur;

    /**
     * coefficient utilise par la douane
     */
    @Column(name = "val_coef_devise_douane")
    private Float valCoefDeviseDouane = 0F;

    /**
     * lta
     */
    @Column(name = "val_lta")
    private String valLta;

    /**
     * 0=maritime 1=avion 2=express 3=route
     */
    @Column(name = "val_mode")
    private Integer valMode = 0;

    /**
     * dpi
     */
    @Column(name = "val_dpi")
    private String valDpi;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * devise
     */
    @Column(name = "val_devise")
    private String valDevise;

    /**
     * id banque
     */
    @Column(name = "val_id_banque")
    private Long valIdBanque = 0L;

    /**
     * nb virement
     */
    @Column(name = "val_nb_virement")
    private Integer valNbVirement = 0;

    /**
     * total frais financier theorique
     */
    @Column(name = "val_total_financier_theo")
    private Double valTotalFinancierTheo = 0D;

    /**
     * total frais financier reelle
     */
    @Column(name = "val_total_financier_reelle")
    private Double valTotalFinancierReelle = 0D;

    /**
     * date transfert en compta
     */
    @Column(name = "val_date_transfert")
    private LocalDate valDateTransfert;

    /**
     * coefficient du forfait transport utile que pour le mali
     */
    @Column(name = "val_coef_forfait_transport")
    private Float valCoefForfaitTransport = 0F;

    /**
     * forfait transport utile que pour le mali
     */
    @Column(name = "val_forfait_transport")
    private Double valForfaitTransport = 0D;

    /**
     * numero de transfert
     */
    @Column(name = "val_num_trf")
    private String valNumTrf;

    /**
     * prix de revient 1 ttc
     */
    @Column(name = "val_pr1_ttc")
    private Double valPr1Ttc = 0D;

    /**
     * numero declaration
     */
    @Column(name = "val_declaration")
    private String valDeclaration;

    /**
     * valeur declaration en douane
     */
    @Column(name = "val_valeur_douane")
    private Double valValeurDouane = 0D;

}
