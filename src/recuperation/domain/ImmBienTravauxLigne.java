package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "imm_bien_travaux_ligne")
public class ImmBienTravauxLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bietralig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bietraligId;

    /**
     * id du tiers fournisseur
     */
    @Column(name = "bietralig_id_tiers")
    private Long bietraligIdTiers = 0L;

    /**
     * civilite du fournisseur
     */
    @Column(name = "bietralig_civil_tiers")
    private String bietraligCivilTiers;

    /**
     * type du fournisseur
     */
    @Column(name = "bietralig_type_tiers")
    private Integer bietraligTypeTiers = 0;

    /**
     * nom ou raison social du fournisseur
     */
    @Column(name = "bietralig_nom_tiers")
    private String bietraligNomTiers;

    /**
     * numero de facture fournisseur
     */
    @Column(name = "bietralig_num_facture")
    private String bietraligNumFacture = "0";

    /**
     * date de facture fournisseur
     */
    @Column(name = "bietralig_date_facture")
    private LocalDate bietraligDateFacture;

    /**
     * objet de la facture
     */
    @Column(name = "bietralig_objet_facture")
    private String bietraligObjetFacture;

    /**
     * total ht facture
     */
    @Column(name = "bietralig_ht")
    private Double bietraligHt = 0D;

    /**
     * total tva
     */
    @Column(name = "bietralig_tva")
    private Double bietraligTva = 0D;

    /**
     * total ttc
     */
    @Column(name = "bietralig_ttc")
    private Double bietraligTtc = 0D;

    /**
     * scan de la facture
     */
    @Column(name = "bietralig_scan_facture")
    private String bietraligScanFacture;

    @Column(name = "bietraent_id", nullable = false)
    private Long bietraentId;

}
