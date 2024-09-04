package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_produits_frais")
public class CmmProduitsFrais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "profrs_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profrsId;

    /**
     * ordre des reponses
     */
    @Column(name = "profrs_ordre")
    private Integer profrsOrdre = 0;

    /**
     * nom feuille
     */
    @Column(name = "profrs_feuille")
    private String profrsFeuille;

    /**
     * numero de calcul
     */
    @Column(name = "profrs_num")
    private String profrsNum;

    /**
     * type de la feuille
     */
    @Column(name = "profrs_type")
    private Integer profrsType = 0;

    /**
     * date de creation
     */
    @Column(name = "profrs_date")
    private LocalDate profrsDate;

    /**
     * code
     */
    @Column(name = "profrs_code")
    private String profrsCode;

    /**
     * nom item en FR
     */
    @Column(name = "profrs_libelle")
    private String profrsLibelle;

    /**
     * taux
     */
    @Column(name = "profrs_taux")
    private Float profrsTaux = 0F;

    /**
     * formule
     */
    @Column(name = "profrs_formule")
    private String profrsFormule;

    /**
     * valeur HT
     */
    @Column(name = "profrs_ht")
    private Double profrsHt = 0D;

    /**
     * valeur exoneration partielle
     */
    @Column(name = "profrs_exo_partielle")
    private Double profrsExoPartielle = 0D;

    /**
     * valeur exoneration complete
     */
    @Column(name = "profrs_exo_complete")
    private Double profrsExoComplete = 0D;

    /**
     * autorise dans la colonne ht
     */
    @Column(name = "profrs_col_ht")
    private Boolean profrsColHt = Boolean.FALSE;

    /**
     * autorise dans la colonne exo partielle
     */
    @Column(name = "profrs_col_exop")
    private Boolean profrsColExop = Boolean.FALSE;

    /**
     * autorise dans la colonne exo totale
     */
    @Column(name = "profrs_col_exot")
    private Boolean profrsColExot = Boolean.FALSE;

    /**
     * 0=standard 1=prc 2=prg
     */
    @Column(name = "profrs_col_type")
    private Integer profrsColType = 0;

    /**
     * prix achat en devise
     */
    @Column(name = "profrs_pa")
    private Double profrsPa = 0D;

    /**
     * fret en devise
     */
    @Column(name = "profrs_fret")
    private Double profrsFret = 0D;

    /**
     * assurance locale
     */
    @Column(name = "profrs_assurance")
    private Double profrsAssurance = 0D;

    /**
     * devise
     */
    @Column(name = "profrs_devise")
    private String profrsDevise;

    /**
     * coefficient devise
     */
    @Column(name = "profrs_coef_devise")
    private Float profrsCoefDevise = 0F;

    /**
     * total caf
     */
    @Column(name = "profrs_caf")
    private Double profrsCaf = 0D;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
