package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProjetRubriqueQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long prorubId;

    private String prorubCode;

    private String prorubLibelleFr;

    private String prorubLibelleUk;

    private String prorubLibelleSp;

    private Double prorubMontantOrigine;

    private String prorubDevise;

    private Float prorubCoefEuro;

    private Double prorubMontantEuro;

    private Float prorubCoefPays;

    private Double prorubMontantPays;

    private Double prorubTotalOrigine;

    private Double prorubTotalEuro;

    private Double prorubTotalPays;

    private Double prorubSoldeOrigine;

    private Double prorubSoldeEuro;

    private Double prorubSoldePays;

    private Integer prorubType;

    private Long proposId;

}
