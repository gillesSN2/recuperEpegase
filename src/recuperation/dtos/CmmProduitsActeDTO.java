package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsActeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long proactId;


    /**
     * hierarchie
     */
    private String proactHierarchie;


    /**
     * rang
     */
    private String proactRang;


    /**
     * position
     */
    private String proactPosition;


    /**
     * y
     */
    private String proactY;


    /**
     * icr
     */
    private String proactIcr;


    /**
     * para
     */
    private String proactPara;


    /**
     * A
     */
    private String proactA;


    /**
     * B
     */
    private String proactB;


    /**
     * CC
     */
    private String proactCc;


    /**
     * score
     */
    private String proactScrore;


    /**
     * observation
     */
    private String proactObservations;

    private Long proId;

}
