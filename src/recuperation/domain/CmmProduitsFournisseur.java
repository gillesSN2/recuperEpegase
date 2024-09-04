package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_produits_fournisseur")
public class CmmProduitsFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "profou_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profouId;

    /**
     * reference fournisseur
     */
    @Column(name = "profou_ref")
    private String profouRef;

    /**
     * libelle fournisseur
     */
    @Column(name = "profou_lib")
    private String profouLib;

    /**
     * prix achat
     */
    @Column(name = "profou_pa")
    private Double profouPa = 0D;

    /**
     * code devise
     */
    @Column(name = "profou_devise")
    private String profouDevise;

    /**
     * format devise 0=us 1=fr 2=afr
     */
    @Column(name = "profou_format")
    private Integer profouFormat = 0;

    /**
     * coefficient de conversion en euro
     */
    @Column(name = "profou_coef_euro")
    private Float profouCoefEuro = 0F;

    /**
     * coefficient de conversion en devise locale
     */
    @Column(name = "profou_coef_local")
    private Float profouCoefLocal = 0F;

    /**
     * prix achat local
     */
    @Column(name = "profou_pa_local")
    private Double profouPaLocal = 0D;

    /**
     * prix achat euro
     */
    @Column(name = "profou_pa_euro")
    private Double profouPaEuro = 0D;

    /**
     * date dernier achat
     */
    @Column(name = "profou_date")
    private LocalDate profouDate;

    /**
     * conditionnement 1
     */
    @Column(name = "profou_condition1")
    private String profouCondition1;

    /**
     * conditionnement 2
     */
    @Column(name = "profou_condition2")
    private String profouCondition2;

    /**
     * conditionnement 3
     */
    @Column(name = "profou_condition3")
    private String profouCondition3;

    /**
     * conditionnement 4
     */
    @Column(name = "profou_condition4")
    private String profouCondition4;

    /**
     * conditionnement 5
     */
    @Column(name = "profou_condition5")
    private String profouCondition5;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "profou_inactif")
    private Integer profouInactif = 0;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    /**
     * taux devise
     */
    @Column(name = "profou_taux_devise")
    private Float profouTauxDevise = 0F;

}
