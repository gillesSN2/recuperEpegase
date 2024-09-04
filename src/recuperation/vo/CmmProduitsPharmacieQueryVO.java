package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsPharmacieQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long prophaId;


    /**
     * forme therapeutique
     */
    private String prophaTherapeutique;


    /**
     * forme gelenique
     */
    private String prophaGalenique;


    /**
     * formule chimique ou dci
     */
    private String prophaFormule;


    /**
     * position
     */
    private String prophaPosition;


    /**
     * tableau
     */
    private String prophaTableau;


    /**
     * shp
     */
    private String prophaShp;


    /**
     * specialite mere
     */
    private String prophaSpecialite;


    /**
     * dosage
     */
    private String prophaDosage;


    /**
     * nom unite
     */
    private String prophaUnite;


    /**
     * nb unites de prise
     */
    private String prophaPrise;


    /**
     * marche
     */
    private String prophaMarche;


    /**
     * origine
     */
    private String prophaOrigine;


    /**
     * posologie
     */
    private String prophaPosologie;


    /**
     * observation
     */
    private String prophaObservations;


    /**
     * laboratoire
     */
    private String prophaLaboratoire;

    private Long proId;

}
