package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class MedLaboratoireLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "labligId can not null")
    private Long labligId;


    /**
     * code produit
     */
    private String labligProduit;


    /**
     * libelle produit
     */
    private String labligLibelle;


    /**
     * code lettre
     */
    private String labligLettre;


    /**
     * nombre de lettre
     */
    private Float labligNb;


    /**
     * valeur de la lettre
     */
    private Double labligValeur;


    /**
     * prix unitaire
     */
    private Double labligPu;


    /**
     * code de la tva
     */
    private String labligCodeTva;


    /**
     * taux de la tva
     */
    private Float labligTauxTva;


    /**
     * %remise
     */
    private Float labligRemise;


    /**
     * prix apres remise
     */
    private Double labligPuRem;


    /**
     * quantite
     */
    private Float labligQte;


    /**
     * part ht patient
     */
    private Double labligPatientHt;


    /**
     * part taxe patient
     */
    private Double labligPatientTaxe;


    /**
     * part ht societe
     */
    private Double labligSocieteHt;


    /**
     * part taxe societe
     */
    private Double labligSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double labligAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double labligAssuranceTaxe;


    /**
     * part ht complementaire
     */
    private Double labligComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double labligComplementaireTaxe;


    /**
     * total ht
     */
    private Double labligTotal;


    /**
     * nom prescripteur
     */
    private String labligPrescipteur;

    @NotNull(message = "labId can not null")
    private Long labId;


    /**
     * famille produit
     */
    private String labligFamille;


    /**
     * coefficient
     */
    private Float labligCoef;


    /**
     * total taxe
     */
    private Double labligTaxe;


    /**
     * etat examen 0=en cours 1=effectue 2=gele 3=annule 4=cloture
     */
    private Integer labligEtat;


    /**
     * identification appareil analyse
     */
    private String labligAppareil;


    /**
     * date de realisation
     */
    private LocalDateTime labligDateRealisee;

}
