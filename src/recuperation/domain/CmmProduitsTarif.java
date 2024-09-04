package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_produits_tarif")
public class CmmProduitsTarif implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "protar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long protarId;

    /**
     * coefficient de vente
     */
    @Column(name = "protar_coef")
    private Float protarCoef = 0F;

    /**
     * famille client
     */
    @Column(name = "protar_client")
    private String protarClient;

    /**
     * lettre
     */
    @Column(name = "protar_lettre")
    private String protarLettre;

    /**
     * nombre de lettre
     */
    @Column(name = "protar_nb")
    private Float protarNb = 0F;

    /**
     * valeur de lettre
     */
    @Column(name = "protar_valeur")
    private Double protarValeur = 0D;

    /**
     * prix vente
     */
    @Column(name = "protar_pv")
    private Double protarPv = 0D;

    /**
     * ordre = numero ligne xml
     */
    @Column(name = "protar_ordre")
    private Integer protarOrdre = 0;

    /**
     * conditionnement
     */
    @Column(name = "protar_condit")
    private String protarCondit;

    /**
     * unite
     */
    @Column(name = "protar_unite")
    private String protarUnite;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "protar_inactif")
    private Integer protarInactif = 0;

    /**
     * 1=exonere de tva
     */
    @Column(name = "protar_exo_tva")
    private Boolean protarExoTva = Boolean.FALSE;

    /**
     * 1=exonere de douane
     */
    @Column(name = "protar_exo_dd")
    private Boolean protarExoDd = Boolean.FALSE;

    /**
     * taux de tva
     */
    @Column(name = "protar_taux_tva")
    private Float protarTauxTva = 0F;

    /**
     * prix vente du marche
     */
    @Column(name = "protar_pv_marche")
    private Double protarPvMarche = 0D;

    /**
     * prix vente concurrent 1
     */
    @Column(name = "protar_pv_cc1")
    private Double protarPvCc1 = 0D;

    /**
     * prix vente concurrent 2
     */
    @Column(name = "protar_pv_cc2")
    private Double protarPvCc2 = 0D;

    /**
     * prix vente concurrent 3
     */
    @Column(name = "protar_pv_cc3")
    private Double protarPvCc3 = 0D;

    /**
     * date prix du marche
     */
    @Column(name = "protar_date_marche")
    private LocalDate protarDateMarche;

    /**
     * date prix vente concurrent 1
     */
    @Column(name = "protar_date_cc1")
    private LocalDate protarDateCc1;

    /**
     * date prix vente concurrent 2
     */
    @Column(name = "protar_date_cc2")
    private LocalDate protarDateCc2;

    /**
     * date prix vente concurrent 3
     */
    @Column(name = "protar_date_cc3")
    private LocalDate protarDateCc3;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    /**
     * nom concurrent 1
     */
    @Column(name = "protar_nom_cc1")
    private String protarNomCc1;

    /**
     * nom concurrent 2
     */
    @Column(name = "protar_nom_cc2")
    private String protarNomCc2;

    /**
     * nom concurrent 3
     */
    @Column(name = "protar_nom_cc3")
    private String protarNomCc3;

    /**
     * tarif par quantite
     */
    @Column(name = "protar_tarif_qte")
    private String protarTarifQte;

}
