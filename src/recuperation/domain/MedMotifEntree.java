package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_motif_entree")
public class MedMotifEntree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mte_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mteId;

    /**
     * user de creation
     */
    @Column(name = "mte_user_creat")
    private Long mteUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "mte_user_modif")
    private Long mteUserModif = 0L;

    /**
     * dat de ceration
     */
    @Column(name = "mte_date_creat")
    private LocalDateTime mteDateCreat;

    /**
     * date de modification
     */
    @Column(name = "mte_date_modif")
    private LocalDateTime mteDateModif;

    /**
     * code du protocole
     */
    @Column(name = "mte_code")
    private String mteCode;

    /**
     * libelle du protocole
     */
    @Column(name = "mte_libelle")
    private String mteLibelle;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "mte_inactif")
    private Integer mteInactif = 0;

    /**
     * 0=non 1=actif dans les consult gene
     */
    @Column(name = "mte_con_gene")
    private Integer mteConGene = 0;

    /**
     * 0=non 1=actif dans les consult spe
     */
    @Column(name = "mte_con_spe")
    private Integer mteConSpe = 0;

    /**
     * 0=non 1=actif dans les labo
     */
    @Column(name = "mte_lab")
    private Integer mteLab = 0;

    /**
     * 0=non 1=actif dans les pharmacies
     */
    @Column(name = "mte_pha")
    private Integer mtePha = 0;

    /**
     * 0=non 1=actif dans les consult gene
     */
    @Column(name = "mte_hosp")
    private Integer mteHosp = 0;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
