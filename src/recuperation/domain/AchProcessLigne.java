package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_process_ligne")
public class AchProcessLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "proceslig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procesligId;

    /**
     * 1=intrant 2=sous produits 3=dechets 4=taches
     */
    @Column(name = "proceslig_type")
    private Integer procesligType = 0;

    /**
     * code produit
     */
    @Column(name = "proceslig_code")
    private String procesligCode;

    /**
     * libelle client
     */
    @Column(name = "proceslig_lib_client")
    private String procesligLibClient;

    /**
     * libelle technique
     */
    @Column(name = "proceslig_lib_tech")
    private String procesligLibTech;

    /**
     * depot de stockage
     */
    @Column(name = "proceslig_depot")
    private String procesligDepot;

    /**
     * unite
     */
    @Column(name = "proceslig_unite")
    private String procesligUnite;

    /**
     * quantite
     */
    @Column(name = "proceslig_qte")
    private Float procesligQte = 0F;

    /**
     * cout horaire agent
     */
    @Column(name = "proceslig_prht")
    private Double procesligPrht = 0D;

    /**
     * prix vente horaire agent
     */
    @Column(name = "proceslig_pvht")
    private Double procesligPvht = 0D;

    /**
     * nombre de jour
     */
    @Column(name = "proceslig_jj")
    private Integer procesligJj = 0;

    /**
     * nombre heures
     */
    @Column(name = "proceslig_hh")
    private Integer procesligHh = 0;

    /**
     * nombre de minutes
     */
    @Column(name = "proceslig_mm")
    private Integer procesligMm = 0;

    /**
     * nombre de seconde
     */
    @Column(name = "proceslig_ss")
    private Integer procesligSs = 0;

    /**
     * flase = utilisee true = interchangeable
     */
    @Column(name = "proceslig_inter_change")
    private Boolean procesligInterChange = Boolean.FALSE;

    /**
     * type de metier concerne
     */
    @Column(name = "proceslig_metier")
    private String procesligMetier;

    /**
     * type de materiel concerne
     */
    @Column(name = "proceslig_materiel")
    private String procesligMateriel;

    @Column(name = "proces_id", nullable = false)
    private Long procesId;

}
