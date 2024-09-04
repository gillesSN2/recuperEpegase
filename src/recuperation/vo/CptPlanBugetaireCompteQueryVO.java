package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptPlanBugetaireCompteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long plbcptId;


    /**
     * code budgetaire
     */
    private String plbcptCode;


    /**
     * 1=vente 2=achat 3=production 4=frais generaux 5=investissement 6=tva 7=frais personnel
     */
    private String plbcptNature;


    /**
     * 0=plan comptable 1=produit
     */
    private Integer plbcptType;


    /**
     * numero de compte
     */
    private String plbcptCompte;


    /**
     * libelle compte
     */
    private String plbcptLibelleFr;


    /**
     * libelle compte
     */
    private String plbcptLibelleUk;


    /**
     * libelle compte
     */
    private String plbcptLibelleSp;

    private Long plbId;

}
