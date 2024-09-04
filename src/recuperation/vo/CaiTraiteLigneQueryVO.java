package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CaiTraiteLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long trtligId;


    /**
     * numero ordre
     */
    private Integer trtligOrdre;


    /**
     * date theorique
     */
    private LocalDate trtligDateTheorique;


    /**
     * montant traite
     */
    private Double trtligMontant;


    /**
     * date depot
     */
    private LocalDate trtligDateDepot;


    /**
     * date report
     */
    private LocalDate trtligDateReport;


    /**
     * 0=a encaisser 1=a escompter
     */
    private Integer trtligType;


    /**
     * numero borderau
     */
    private String trtligBordereau;


    /**
     * 0=en cours 1=valider 2=rejeter
     */
    private Integer trtligEtat;


    /**
     * motif rejet
     */
    private String trtligMotif;


    /**
     * date retour
     */
    private LocalDate trtligDateRetour;

    private Long trtId;

}
