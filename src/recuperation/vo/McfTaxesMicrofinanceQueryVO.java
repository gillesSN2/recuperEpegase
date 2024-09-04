package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class McfTaxesMicrofinanceQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long taxmcfId;

    private LocalDate taxmcfDateCreation;

    private LocalDate taxmcfDateModif;

    private Long taxmcfUserCreation;

    private Long taxmcfUserModif;

    private String tacmcfCode;

    private String taxmcfLibelleFr;

    private String taxmcfLibelleUk;

    private String taxmcfLibelleSp;

    private Float taxmcfTaux;

    private String taxmcfCompte;

    private Integer taxmcfType;

    private Integer taxmcfTimbre;

    private Integer taxmcfTc;

    private Integer taxmcfInactif;

    private Long exemcfId;

}
