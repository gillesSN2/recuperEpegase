package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedConsultationActesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cslactId;


    /**
     * code produit
     */
    private String cslactProduit;


    /**
     * libelle produit
     */
    private String cslactLibelle;


    /**
     * code lettre
     */
    private String cslactLettre;


    /**
     * nombre lettre
     */
    private Float cslactNb;


    /**
     * valeur lettre
     */
    private Double cslactValeur;


    /**
     * prix unitaire
     */
    private Double cslactPu;


    /**
     * code de tva
     */
    private String cslactCodeTva;


    /**
     * taux de tva
     */
    private Float cslactTauxTva;


    /**
     * %remise
     */
    private Float cslactRemise;


    /**
     * prix apres remise
     */
    private Double cslactPuRem;


    /**
     * quantite
     */
    private Float cslactQte;


    /**
     * part ht patient
     */
    private Double cslactPatientHt;


    /**
     * part taxe patient
     */
    private Double cslactPatientTaxe;


    /**
     * part ht societe
     */
    private Double cslactSocieteHt;


    /**
     * part taxe societe
     */
    private Double cslactSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double cslactAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double cslactAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double cslactComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double cslactComplementaireTaxe;


    /**
     * total ht
     */
    private Double cslactTotal;

    private Long csgId;


    /**
     * coefficient
     */
    private Float cslactCoef;


    /**
     * total taxe
     */
    private Double cslactTaxe;

}
