package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProjetBailleurQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long probaiId;

    private String probaiNomBailleur;

    private Double probaiMontantOrigine;

    private String probaiDevise;

    private Float probaiCoefEuro;

    private Double parbaiMontantEuro;

    private Float probaiCoefPays;

    private Double probaiMontantPays;

    private Float probaiRepart;

    private Long proId;

    private Long strId;

}
