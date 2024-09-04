package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_grp")
public class CmmProduitsGrp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "progrp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progrpId;

    /**
     * code produit constituant
     */
    @Column(name = "progrp_code")
    private String progrpCode;

    /**
     * libelle produit constituant
     */
    @Column(name = "progrp_libelle")
    private String progrpLibelle;

    /**
     * depot du produit constituant
     */
    @Column(name = "progrp_depot")
    private String progrpDepot;

    /**
     * quantite concernee
     */
    @Column(name = "progrp_qte")
    private Float progrpQte = 0F;

    /**
     * unite
     */
    @Column(name = "progrp_unite")
    private String progrpUnite;

    /**
     * pump du produit constrituant
     */
    @Column(name = "progrp_pump")
    private Double progrpPump = 0D;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "progrp_inactif")
    private Integer progrpInactif = 0;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
