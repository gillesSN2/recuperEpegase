package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedProduitsMedicammentQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long promdcId;


    /**
     * user de creation
     */
    private Long promdcUserCreation;


    /**
     * user de modification
     */
    private Long promdcUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime promdcDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime promdcDateModif;


    /**
     * code cip
     */
    private String promdcCodeCip;


    /**
     * dci du medicamment
     */
    private String promdcCodeDci;


    /**
     * dosage du medicamment
     */
    private String promdcDosage;


    /**
     * nom du medicamment
     */
    private String promdcSpecialite;


    /**
     * forme galenique du medicamment
     */
    private String promdcForme;


    /**
     * classe therapeutique du medicamment
     */
    private String promdcClasse;


    /**
     * prix du medicamment
     */
    private Double promdcPrix;


    /**
     * liste du medicamment
     */
    private String promdcListe;


    /**
     * laboratoire du medicamment
     */
    private String promdcLaboratoire;


    /**
     * 0=medicamment 1=complement alimentaire 2=plante 3=hydratant cutane 4=homeopathie 5=veterinaire 6=parapharmacie
     */
    private Integer promdcType;


    /**
     * code cophase
     */
    private String promdcCodeCophase;

}
