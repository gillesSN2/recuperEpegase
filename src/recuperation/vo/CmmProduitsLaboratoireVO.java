package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class CmmProduitsLaboratoireVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prolabId can not null")
    private Long prolabId;


    /**
     * nom item en FR
     */
    private String prolabLibelleFr;


    /**
     * nom item en UK
     */
    private String prolabLibelleUk;


    /**
     * nom item en SP
     */
    private String prolabLibelleSp;


    /**
     * 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple 8=datail examen
     */
    private Integer prolabType;


    /**
     * unite usuelle
     */
    private String prolabUnite;


    /**
     * coefficient de convertion
     */
    private Float prolabCoef;


    /**
     * unite convertie
     */
    private String prolabUniteConv;


    /**
     * ordre
     */
    private Integer prolabOrdre;


    /**
     * technique utilisee
     */
    private String prolabTechnique;


    /**
     * norme statique
     */
    private String prolabNorme;


    /**
     * 1=anonyme
     */
    private Integer prolabAnonyme;


    /**
     * 1=impression etiquette
     */
    private Integer prolabEtiquette;


    /**
     * 0=libre 1=conclusion unique 2=conclusion mulipte
     */
    private Integer prolabConclusion;


    /**
     * conclusion par defaut
     */
    private String prolabConclusionDef;

    @NotNull(message = "proId can not null")
    private Long proId;

}
