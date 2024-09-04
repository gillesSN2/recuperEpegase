package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_produits")
public class CmmProduits implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pro_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proId;

    /**
     * date de creation
     */
    @Column(name = "pro_date_creat")
    private LocalDateTime proDateCreat;

    /**
     * date de modification
     */
    @Column(name = "pro_date_modif")
    private LocalDateTime proDateModif;

    /**
     * id user createur
     */
    @Column(name = "pro_user_creat")
    private Long proUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "pro_user_modif")
    private Long proUserModif = 0L;

    /**
     * code produit
     */
    @Column(name = "pro_code")
    private String proCode;

    /**
     * code option
     */
    @Column(name = "pro_code_option")
    private String proCodeOption;

    /**
     * libelle client
     */
    @Column(name = "pro_lib_client")
    private String proLibClient;

    /**
     * libelle technique
     */
    @Column(name = "pro_lib_tech")
    private String proLibTech;

    /**
     * description du produit
     */
    @Column(name = "pro_descrip")
    private String proDescrip;

    /**
     * 0=verrouillage de la zone libelle 1=deverrouillage de la zone libelle
     */
    @Column(name = "pro_imp_desciption")
    private Integer proImpDesciption = 0;

    /**
     * code barre
     */
    @Column(name = "pro_barre")
    private String proBarre;

    /**
     * code famille achat
     */
    @Column(name = "pro_ach_code")
    private String proAchCode;

    /**
     * libelle famille achat
     */
    @Column(name = "pro_ach_lib")
    private String proAchLib;

    /**
     * code douane achat
     */
    @Column(name = "pro_ach_douane")
    private String proAchDouane;

    /**
     * code tva achat
     */
    @Column(name = "pro_ach_tva")
    private String proAchTva;

    /**
     * compte achat local
     */
    @Column(name = "pro_ach_cpte_loc")
    private String proAchCpteLoc;

    /**
     * compte achat zone
     */
    @Column(name = "pro_ach_cpte_z")
    private String proAchCpteZ;

    /**
     * compte achat hors zone
     */
    @Column(name = "pro_ach_cpte_hz")
    private String proAchCpteHz;

    /**
     * compte achat charges
     */
    @Column(name = "pro_ach_cpte_ch")
    private String proAchCpteCh;

    /**
     * compte achat stock
     */
    @Column(name = "pro_ach_cpte_st")
    private String proAchCpteSt;

    /**
     * nature famille achat
     */
    @Column(name = "pro_ach_nat")
    private String proAchNat;

    /**
     * code depot par defaut pour les achats
     */
    @Column(name = "pro_depot_ach")
    private String proDepotAch;

    /**
     * code depot par defaut pour la production
     */
    @Column(name = "pro_depot_prd")
    private String proDepotPrd;

    /**
     * code famille de vente
     */
    @Column(name = "pro_vte_code")
    private String proVteCode;

    /**
     * libelle famille de vente
     */
    @Column(name = "pro_vte_lib")
    private String proVteLib;

    /**
     * code douane de vente
     */
    @Column(name = "pro_vte_douane")
    private String proVteDouane;

    /**
     * code tva de vente
     */
    @Column(name = "pro_vte_tva")
    private String proVteTva;

    /**
     * compte vente en local
     */
    @Column(name = "pro_vte_cpte_loc")
    private String proVteCpteLoc;

    /**
     * compte vente dans la zone
     */
    @Column(name = "pro_vte_cpte_z")
    private String proVteCpteZ;

    /**
     * compte vente hors zone
     */
    @Column(name = "pro_vte_cpte_hz")
    private String proVteCpteHz;

    /**
     * compte vente produit
     */
    @Column(name = "pro_vte_cpte_pr")
    private String proVteCptePr;

    /**
     * compte vente stock
     */
    @Column(name = "pro_vte_cpte_st")
    private String proVteCpteSt;

    /**
     * nature famille de vente
     */
    @Column(name = "pro_vte_nat")
    private String proVteNat;

    /**
     * code depot par defaut pour les ventes
     */
    @Column(name = "pro_depot_vte")
    private String proDepotVte;

    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    @Column(name = "pro_stock")
    private Integer proStock = 0;

    /**
     * conditionnement 1
     */
    @Column(name = "pro_condition1")
    private String proCondition1;

    /**
     * conditionnement 2
     */
    @Column(name = "pro_condition2")
    private String proCondition2;

    /**
     * conditionnement 3
     */
    @Column(name = "pro_condition3")
    private String proCondition3;

    /**
     * conditionnement 4
     */
    @Column(name = "pro_condition4")
    private String proCondition4;

    /**
     * conditionnement 5
     */
    @Column(name = "pro_condition5")
    private String proCondition5;

    /**
     * code acitivite commerciale
     */
    @Column(name = "pro_activite")
    private String proActivite;

    /**
     * code cle 1 repartition
     */
    @Column(name = "pro_cle1")
    private String proCle1;

    /**
     * code cle 2 repartition
     */
    @Column(name = "pro_cle2")
    private String proCle2;

    /**
     * code promotion
     */
    @Column(name = "pro_promo")
    private String proPromo;

    /**
     * code lettre de facturation
     */
    @Column(name = "pro_lettre")
    private String proLettre;

    /**
     * longueur
     */
    @Column(name = "pro_longueur")
    private Float proLongueur = 0F;

    /**
     * largeur
     */
    @Column(name = "pro_largeur")
    private Float proLargeur = 0F;

    /**
     * epaisseur
     */
    @Column(name = "pro_epaisseur")
    private Float proEpaisseur = 0F;

    /**
     * volume
     */
    @Column(name = "pro_volume")
    private Float proVolume = 0F;

    /**
     * poids brut
     */
    @Column(name = "pro_poids_brut")
    private Float proPoidsBrut = 0F;

    /**
     * poids net
     */
    @Column(name = "pro_poids_net")
    private Float proPoidsNet = 0F;

    /**
     * tare
     */
    @Column(name = "pro_poids_tare")
    private Float proPoidsTare = 0F;

    /**
     * diametre interne
     */
    @Column(name = "pro_diam_int")
    private Float proDiamInt = 0F;

    /**
     * diametre externe
     */
    @Column(name = "pro_diam_ext")
    private Float proDiamExt = 0F;

    /**
     * densite
     */
    @Column(name = "pro_densite")
    private Float proDensite = 0F;

    /**
     * pression
     */
    @Column(name = "pro_pression")
    private Float proPression = 0F;

    /**
     * etat du produit
     */
    @Column(name = "pro_etat")
    private String proEtat;

    /**
     * nombre d unite ou nombre de lettre
     */
    @Column(name = "pro_nb_unite")
    private Float proNbUnite = 0F;

    /**
     * valeur du pump par defaut
     */
    @Column(name = "pro_def_pump")
    private Double proDefPump = 0D;

    /**
     * date valeur du pump par defaut
     */
    @Column(name = "pro_def_dte_pump")
    private LocalDate proDefDtePump;

    /**
     * code du groupe d inventaire
     */
    @Column(name = "pro_grp_inv")
    private String proGrpInv;

    /**
     * 0=produit simple 1=groupe visible 2=groupe invisible 3=forfait 4=calcul auto.
     */
    @Column(name = "pro_mode")
    private Integer proMode = 0;

    /**
     * marque du produit
     */
    @Column(name = "pro_marque")
    private String proMarque;

    /**
     * couleur du produit
     */
    @Column(name = "pro_couleur")
    private String proCouleur;

    /**
     * constructeur du produit
     */
    @Column(name = "pro_constructeur")
    private String proConstructeur;

    /**
     * code du produit lie
     */
    @Column(name = "pro_code_lie")
    private String proCodeLie;

    /**
     * quantite produit lie
     */
    @Column(name = "pro_qte_lie")
    private Float proQteLie = 0F;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "pro_inactif")
    private Integer proInactif = 0;

    /**
     * photos du produits
     */
    @Column(name = "pro_photo")
    private String proPhoto;

    /**
     * fichier pdf
     */
    @Column(name = "pro_pdf")
    private String proPdf;

    /**
     * formule
     */
    @Column(name = "pro_formule")
    private String proFormule;

    /**
     * 0=prive 1=public
     */
    @Column(name = "pro_public")
    private Integer proPublic = 0;

    /**
     * date de publication
     */
    @Column(name = "pro_date_public")
    private LocalDateTime proDatePublic;

    /**
     * energie
     */
    @Column(name = "pro_energie")
    private String proEnergie;

    /**
     * nb de porte
     */
    @Column(name = "pro_nb_porte")
    private Integer proNbPorte = 0;

    /**
     * boite de vitesse
     */
    @Column(name = "pro_boite_vitesse")
    private Integer proBoiteVitesse = 0;

    /**
     * puissance
     */
    @Column(name = "pro_puissance")
    private Integer proPuissance = 0;

    /**
     * cylindree
     */
    @Column(name = "pro_cylindree")
    private Integer proCylindree = 0;

    /**
     * genre
     */
    @Column(name = "pro_genre")
    private String proGenre;

    /**
     * carrosserie
     */
    @Column(name = "pro_carrosserie")
    private String proCarrosserie;

    /**
     * nb place
     */
    @Column(name = "pro_nb_place")
    private Integer proNbPlace = 0;

    /**
     * puissance din
     */
    @Column(name = "pro_puissance_din")
    private Integer proPuissanceDin = 0;

    /**
     * remise max
     */
    @Column(name = "pro_remise")
    private Integer proRemise = 0;

    /**
     * prc ht
     */
    @Column(name = "pro_prc_ht")
    private Double proPrcHt = 0D;

    /**
     * prc exo partiel
     */
    @Column(name = "pro_prc_exop")
    private Double proPrcExop = 0D;

    /**
     * prc exo total
     */
    @Column(name = "pro_prc_exot")
    private Double proPrcExot = 0D;

    /**
     * prc ht
     */
    @Column(name = "pro_prg_ht")
    private Double proPrgHt = 0D;

    /**
     * prc exo partiel
     */
    @Column(name = "pro_prg_exop")
    private Double proPrgExop = 0D;

    /**
     * prc exo total
     */
    @Column(name = "pro_prg_exot")
    private Double proPrgExot = 0D;

    /**
     * prix achat en devise
     */
    @Column(name = "pro_pa")
    private Double proPa = 0D;

    /**
     * fret en devise
     */
    @Column(name = "pro_fret")
    private Double proFret = 0D;

    /**
     * assurance locale
     */
    @Column(name = "pro_assurance")
    private Double proAssurance = 0D;

    /**
     * devise
     */
    @Column(name = "pro_devise")
    private String proDevise;

    /**
     * coefficient devise
     */
    @Column(name = "pro_coef_devise")
    private Float proCoefDevise = 0F;

    /**
     * total caf
     */
    @Column(name = "pro_caf")
    private Double proCaf = 0D;

    /**
     * quantite en stock
     */
    @Column(name = "pro_qte_stock")
    private Float proQteStock = 0F;

    /**
     * quantite en commande fournisseur
     */
    @Column(name = "pro_qte_cmd_fournisseur")
    private Float proQteCmdFournisseur = 0F;

    /**
     * quantite en commande client
     */
    @Column(name = "pro_qte_cmd_client")
    private Float proQteCmdClient = 0F;

    /**
     * compte vente en local non taxable
     */
    @Column(name = "pro_vte_cpte_n_tx")
    private String proVteCpteNTx;

    /**
     * compte achat en cours
     */
    @Column(name = "pro_ach_cpte_ec")
    private String proAchCpteEc;

    /**
     * commission unitaire
     */
    @Column(name = "pro_com_unite")
    private Double proComUnite = 0D;

    /**
     * commission en pourcentage sur le ca
     */
    @Column(name = "pro_com_pourcentage")
    private Float proComPourcentage = 0F;

    /**
     * 0=petite photo 1=grande photo
     */
    @Column(name = "pro_photo_taille")
    private Integer proPhotoTaille = 0;

}
