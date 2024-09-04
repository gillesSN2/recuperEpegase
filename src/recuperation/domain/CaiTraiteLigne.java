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
@Table(name = "cai_traite_ligne")
public class CaiTraiteLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trtlig_id", nullable = false)
    private Long trtligId;

    /**
     * numero ordre
     */
    @Column(name = "trtlig_ordre")
    private Integer trtligOrdre = 0;

    /**
     * date theorique
     */
    @Column(name = "trtlig_date_theorique")
    private LocalDate trtligDateTheorique;

    /**
     * montant traite
     */
    @Column(name = "trtlig_montant")
    private Double trtligMontant = 0D;

    /**
     * date depot
     */
    @Column(name = "trtlig_date_depot")
    private LocalDate trtligDateDepot;

    /**
     * date report
     */
    @Column(name = "trtlig_date_report")
    private LocalDate trtligDateReport;

    /**
     * 0=a encaisser 1=a escompter
     */
    @Column(name = "trtlig_type")
    private Integer trtligType = 0;

    /**
     * numero borderau
     */
    @Column(name = "trtlig_bordereau")
    private String trtligBordereau;

    /**
     * 0=en cours 1=valider 2=rejeter
     */
    @Column(name = "trtlig_etat")
    private Integer trtligEtat = 0;

    /**
     * motif rejet
     */
    @Column(name = "trtlig_motif")
    private String trtligMotif;

    /**
     * date retour
     */
    @Column(name = "trtlig_date_retour")
    private LocalDate trtligDateRetour;

    @Column(name = "trt_id", nullable = false)
    private Long trtId;

}
