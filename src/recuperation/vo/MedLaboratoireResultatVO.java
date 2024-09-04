package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class MedLaboratoireResultatVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "labresId can not null")
    private Long labresId;


    /**
     * numero laboratoie
     */
    private String labresNum;


    /**
     * code du produit
     */
    private String labresCode;


    /**
     * libelle examen
     */
    private String labresLibelle;


    /**
     * type de reponse 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple 8=datail examen
     */
    private Integer labresType;


    /**
     * ordre de la response
     */
    private Integer labresOrdre;


    /**
     * reponse numerique
     */
    private Double labresNumerique;


    /**
     * reponse date
     */
    private LocalDate labresDate;


    /**
     * reponse image
     */
    private String labresImage;


    /**
     * reponse pdf
     */
    private String labresPdf;


    /**
     * reponse texte
     */
    private String labresTexte;


    /**
     * reponse unique
     */
    private String labresReponseUnique;


    /**
     * action
     */
    private String labresAction;


    /**
     * reponse multiple
     */
    private String labresReponseMultiple;


    /**
     * unite reponse
     */
    private String labresUnite;


    /**
     * coefficient de conversion
     */
    private Float labresCoef;


    /**
     * unite reponse convertie
     */
    private String labresUniteConvertie;


    /**
     * fourchette
     */
    private String labresFourchette;


    /**
     * fourchette mini
     */
    private Double labresFourchetteMin;


    /**
     * fourchette maxi
     */
    private Double labresFourchetteMax;


    /**
     * commentaire
     */
    private String labresCommentaire;


    /**
     * technique utilisee
     */
    private String labresTechnique;


    /**
     * norme statique
     */
    private String labresNorme;


    /**
     * id de la consultation laboratoire
     */
    private Long labresIdLab;


    /**
     * id du patient
     */
    private Long labresIdPatient;

    @NotNull(message = "labligId can not null")
    private Long labligId;

}
