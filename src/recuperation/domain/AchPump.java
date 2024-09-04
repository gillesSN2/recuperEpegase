package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_pump")
public class AchPump implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pum_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pumId;

    /**
     * date de creation
     */
    @Column(name = "pum_date_creat")
    private LocalDateTime pumDateCreat;

    /**
     * id user createur
     */
    @Column(name = "pum_id_createur")
    private Long pumIdCreateur = 0L;

    /**
     * id du document origine
     */
    @Column(name = "pum_id_doc_origine")
    private Long pumIdDocOrigine = 0L;

    /**
     * numero du document origine
     */
    @Column(name = "pum_num_doc_origine")
    private String pumNumDocOrigine;

    /**
     * nature du document origine
     */
    @Column(name = "pum_nature_origine")
    private Integer pumNatureOrigine = 0;

    /**
     * id ligne origine
     */
    @Column(name = "pum_id_ligne_origine")
    private Long pumIdLigneOrigine = 0L;

    /**
     * date
     */
    @Column(name = "pum_date")
    private LocalDateTime pumDate;

    /**
     * code depot
     */
    @Column(name = "pum_depot")
    private String pumDepot;

    /**
     * code produit
     */
    @Column(name = "pum_produit")
    private String pumProduit;

    /**
     * prix achat
     */
    @Column(name = "pum_pa")
    private Double pumPa = 0D;

    /**
     * prix revient
     */
    @Column(name = "pum_pr")
    private Double pumPr = 0D;

    /**
     * pump
     */
    @Column(name = "pum_pump")
    private Double pumPump = 0D;

    /**
     * qte operation
     */
    @Column(name = "pum_qte_operation")
    private Float pumQteOperation = 0F;

    /**
     * qte stock avant operation
     */
    @Column(name = "pum_qte_stock")
    private Float pumQteStock = 0F;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    /**
     * prix revient au kilo
     */
    @Column(name = "pum_pr_kg")
    private Double pumPrKg = 0D;

    /**
     * code dossier
     */
    @Column(name = "pum_dossier")
    private String pumDossier;

}
