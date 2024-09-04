package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vte_chargement_ligne")
public class VteChargementLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "chalig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chaligId;

    /**
     * code produit
     */
    @Column(name = "chalig_code")
    private String chaligCode;

    /**
     * famille vente
     */
    @Column(name = "chalig_famille")
    private String chaligFamille;

    /**
     * libelle produit
     */
    @Column(name = "chalig_libelle")
    private String chaligLibelle;

    /**
     * reference produit
     */
    @Column(name = "chalig_reference")
    private String chaligReference;

    /**
     * code taxe
     */
    @Column(name = "chalig_taxe")
    private String chaligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "chalig_taux_taxe")
    private Float chaligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "chalig_unite")
    private String chaligUnite;

    /**
     * casier rangement
     */
    @Column(name = "chalig_casier")
    private String chaligCasier;

    /**
     * depot chargement
     */
    @Column(name = "chalig_depot_charg")
    private String chaligDepotCharg;

    /**
     * quantite de chargement
     */
    @Column(name = "chalig_qte_charg")
    private Float chaligQteCharg = 0F;

    /**
     * prix de revient
     */
    @Column(name = "chalig_pr")
    private Double chaligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "chalig_pump")
    private Double chaligPump = 0D;

    /**
     * quantite don
     */
    @Column(name = "chalig_qte_don")
    private Float chaligQteDon = 0F;

    /**
     * quantite avoir
     */
    @Column(name = "chalig_qte_avoir")
    private Float chaligQteAvoir = 0F;

    /**
     * depot non conforme
     */
    @Column(name = "chalig_depot_nconforme")
    private String chaligDepotNconforme;

    /**
     * quantite non conforme
     */
    @Column(name = "chalig_qte_nconforme")
    private Float chaligQteNconforme = 0F;

    /**
     * depot perce, casse
     */
    @Column(name = "chalig_depot_perce")
    private String chaligDepotPerce;

    /**
     * quantite percee, cassee
     */
    @Column(name = "chalig_qte_percee")
    private Float chaligQtePercee = 0F;

    /**
     * depot perime
     */
    @Column(name = "chalig_depot_perime")
    private String chaligDepotPerime;

    /**
     * quantite perimee
     */
    @Column(name = "chalig_qte_perime")
    private Float chaligQtePerime = 0F;

    /**
     * depot manquant
     */
    @Column(name = "chalig_depot_manquant")
    private String chaligDepotManquant;

    /**
     * quantite manquant usine
     */
    @Column(name = "chalig_qte_manquant")
    private Float chaligQteManquant = 0F;

    /**
     * depot ecart
     */
    @Column(name = "chalig_depot_ecart")
    private String chaligDepotEcart;

    /**
     * quantite ecart commerciaux
     */
    @Column(name = "chalig_qte_ecart")
    private Float chaligQteEcart = 0F;

    @Column(name = "chamob_id", nullable = false)
    private Long chamobId;

    /**
     * id de la ligne du besoin
     */
    @Column(name = "chalig_id_bes")
    private Long chaligIdBes = 0L;

    /**
     * id de la ligne de la commande
     */
    @Column(name = "chalig_id_bcm")
    private Long chaligIdBcm = 0L;

    /**
     * numero ordre
     */
    @Column(name = "chalig_ordre")
    private Integer chaligOrdre = 0;

    /**
     * generique
     */
    @Column(name = "chalig_generique")
    private Integer chaligGenerique = 0;

    /**
     * conditionnement produit
     */
    @Column(name = "chalig_condition")
    private String chaligCondition;

    /**
     * description conditionnement produit
     */
    @Column(name = "chalig_description")
    private String chaligDescription;

    /**
     * mode gestion stock
     */
    @Column(name = "chalig_stock")
    private Integer chaligStock = 0;

    /**
     * quantite demandee
     */
    @Column(name = "chalig_qte_dem")
    private Float chaligQteDem = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "chalig_pu")
    private Double chaligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "chalig_taux_remise")
    private Float chaligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "chalig_rabais")
    private Double chaligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "chalig_pu_rem")
    private Double chaligPuRem = 0D;

    /**
     * prix unitaire Ttc avant remise
     */
    @Column(name = "chalig_pu_ttc")
    private Double chaligPuTtc = 0D;

    /**
     * prix unitaire Ttc apres remise
     */
    @Column(name = "chalig_pu_rem_ttc")
    private Double chaligPuRemTtc = 0D;

    /**
     * prix total ht
     */
    @Column(name = "chalig_pt")
    private Double chaligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "chalig_tva")
    private Double chaligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "chalig_tc")
    private Double chaligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "chalig_ttc")
    private Double chaligTtc = 0D;

    /**
     * echelle de la ligne
     */
    @Column(name = "chalig_echelle")
    private Integer chaligEchelle = 0;

    /**
     * quantite facture
     */
    @Column(name = "chalig_qte_facture")
    private Float chaligQteFacture = 0F;

    /**
     * quantite percee, cassee
     */
    @Column(name = "chalig_qte_defectueux")
    private Float chaligQteDefectueux = 0F;

    /**
     * quantite reprise
     */
    @Column(name = "chalig_qte_reprise")
    private Float chaligQteReprise = 0F;

    /**
     * quantite retour
     */
    @Column(name = "chalig_qte_retour")
    private Float chaligQteRetour = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "chalig_qte_util")
    private Float chaligQteUtil = 0F;

    /**
     * longueur
     */
    @Column(name = "chalig_long")
    private Float chaligLong = 0F;

    /**
     * largeur
     */
    @Column(name = "chalig_larg")
    private Float chaligLarg = 0F;

    /**
     * hauteur
     */
    @Column(name = "chalig_haut")
    private Float chaligHaut = 0F;

    /**
     * diametre
     */
    @Column(name = "chalig_diam")
    private Float chaligDiam = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "chalig_nb")
    private Float chaligNb = 0F;

    /**
     * poids net
     */
    @Column(name = "chalig_poidsNet")
    private Float chaligPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "chalig_poidsBrut")
    private Float chaligPoidsbrut = 0F;

    /**
     * volume
     */
    @Column(name = "chalig_volume")
    private Float chaligVolume = 0F;

    /**
     * date chargement ou rechargement
     */
    @Column(name = "chalig_date_chargement")
    private LocalDate chaligDateChargement;

    /**
     * 0=chargement 1=rechargement
     */
    @Column(name = "chalig_rechargement")
    private Integer chaligRechargement = 0;

    /**
     * quantite ramenee par le commercial
     */
    @Column(name = "chalig_qte_ramene")
    private Float chaligQteRamene = 0F;

    /**
     * nmbre de rechargement
     */
    @Column(name = "chalig_nombre_rechargement")
    private Integer chaligNombreRechargement = 0;

}
