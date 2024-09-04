package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_fourchette")
public class CmmProduitsFourchette implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "profch_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profchId;

    /**
     * 0=femme 1=homme 2=tout
     */
    @Column(name = "profch_sexe")
    private Integer profchSexe = 0;

    /**
     * 0=sans filtre 1=age en annee 2=age en mois 3=age en jour
     */
    @Column(name = "profch_age")
    private Integer profchAge = 0;

    /**
     * fourchette age debut
     */
    @Column(name = "profch_age_debut")
    private Float profchAgeDebut = 0F;

    /**
     * fourchette age fin
     */
    @Column(name = "profch_age_fin")
    private Float profchAgeFin = 0F;

    /**
     * fourchette minimale
     */
    @Column(name = "profch_fmini")
    private Float profchFmini = 0F;

    /**
     * fourchette maximale
     */
    @Column(name = "profch_fmaxi")
    private Float profchFmaxi = 0F;

    /**
     * limite minimale
     */
    @Column(name = "profch_lmini")
    private Float profchLmini = 0F;

    /**
     * limite maximale
     */
    @Column(name = "profch_lmaxi")
    private Float profchLmaxi = 0F;

    /**
     * normes dynamiques
     */
    @Column(name = "profch_norme")
    private String profchNorme;

    @Column(name = "prolab_id")
    private Long prolabId;

    @Column(name = "prodet_id")
    private Long prodetId;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    /**
     * code produit
     */
    @Column(name = "profch_code")
    private String profchCode;

}
