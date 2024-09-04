package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_produits_depot")
public class CmmProduitsDepot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prodep_id", nullable = false)
    private Long prodepId;

    /**
     * unite de stockage
     */
    @Column(name = "prodep_unite")
    private String prodepUnite;

    /**
     * valeur unite de stockage
     */
    @Column(name = "prodep_echelle")
    private Integer prodepEchelle = 0;

    /**
     * quantite minimale
     */
    @Column(name = "prodep_qte_mini")
    private Float prodepQteMini = 0F;

    /**
     * quantite maximale
     */
    @Column(name = "prodep_qte_maxi")
    private Float prodepQteMaxi = 0F;

    /**
     * quantite consommation theorique
     */
    @Column(name = "prodep_qte_conso")
    private Float prodepQteConso = 0F;

    /**
     * dernier coef pr
     */
    @Column(name = "prodep_coef_pr")
    private Float prodepCoefPr = 0F;

    /**
     * dernier PA
     */
    @Column(name = "prodep_pa")
    private Double prodepPa = 0D;

    /**
     * dernier PR
     */
    @Column(name = "prodep_pr")
    private Double prodepPr = 0D;

    /**
     * dernier PR au kilo
     */
    @Column(name = "prodep_pr_kg")
    private Double prodepPrKg = 0D;

    /**
     * dernier PUMP
     */
    @Column(name = "prodep_pump")
    private Double prodepPump = 0D;

    /**
     * date dernier inventaire
     */
    @Column(name = "prodep_date_inv")
    private LocalDate prodepDateInv;

    /**
     * date derniere entree
     */
    @Column(name = "prodep_date_entree")
    private LocalDate prodepDateEntree;

    /**
     * date derniere sortie
     */
    @Column(name = "prodep_date_sortie")
    private LocalDate prodepDateSortie;

    /**
     * date derniere production
     */
    @Column(name = "prodep_date_prod")
    private LocalDate prodepDateProd;

    /**
     * quantite commande fournisseur en cours
     */
    @Column(name = "prodep_qte_cmd_ach")
    private Float prodepQteCmdAch = 0F;

    /**
     * quantite commande client en cours
     */
    @Column(name = "prodep_qte_cmd_vte")
    private Float prodepQteCmdVte = 0F;

    /**
     * quantite en attente en achat
     */
    @Column(name = "prodep_qte_att_ach")
    private Float prodepQteAttAch = 0F;

    /**
     * quantite en attente en vente
     */
    @Column(name = "prodep_qte_att_vte")
    private Float prodepQteAttVte = 0F;

    /**
     * quantite en stock
     */
    @Column(name = "prodep_qte_stk")
    private Float prodepQteStk = 0F;

    /**
     * quantite inventoriee
     */
    @Column(name = "prodep_qte_inv")
    private Float prodepQteInv = 0F;

    /**
     * localisation
     */
    @Column(name = "prodep_localisation")
    private String prodepLocalisation;

    /**
     * casier de rangement
     */
    @Column(name = "prodep_casier")
    private String prodepCasier;

    /**
     * groupage de depot
     */
    @Column(name = "prodep_groupe")
    private String prodepGroupe;

    /**
     * cle acces code depot code produit
     */
    @Column(name = "prodep_cle")
    private String prodepCle;

    /**
     * cle acces code groupe code produit
     */
    @Column(name = "prodep_cle2")
    private String prodepCle2;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "prodep_inactif")
    private Integer prodepInactif = 0;

    @Column(name = "dpo_id", nullable = false)
    private Long dpoId;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @Column(name = "uni_id")
    private Long uniId;

}
