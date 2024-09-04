package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedHospitalisationActesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long hosactId;


    /**
     * id medecin
     */
    private Long hosactIdMedecin;


    /**
     * nom medecin
     */
    private String hosactMedecin;


    /**
     * service
     */
    private String hosactService;


    /**
     * code produit
     */
    private String hosactProduit;


    /**
     * libelle produit
     */
    private String hosactLibelle;


    /**
     * code lettre
     */
    private String hosactLettre;


    /**
     * nombre lettre
     */
    private Float hosactNb;


    /**
     * valeur lettre
     */
    private Double hosactValeur;


    /**
     * coefficient
     */
    private Float hosactCoef;


    /**
     * prix unitaire
     */
    private Double hosactPu;


    /**
     * code de tva
     */
    private String hosactCodeTva;


    /**
     * taux de tva
     */
    private Float hosactTauxTva;


    /**
     * %remise
     */
    private Float hosactRemise;


    /**
     * prix apres remise
     */
    private Double hosactPuRem;


    /**
     * quantite
     */
    private Float hosactQte;


    /**
     * part ht patient
     */
    private Double hosactPatientHt;


    /**
     * part taxe patient
     */
    private Double hosactPatientTaxe;


    /**
     * part ht societe
     */
    private Double hosactSocieteHt;


    /**
     * part taxe societe
     */
    private Double hosactSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double hosactAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double hosactAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double hosactComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double hosactComplementaireTaxe;


    /**
     * total ht
     */
    private Double hosactTotal;


    /**
     * total taxe
     */
    private Double hosactTaxe;


    /**
     * id sejour
     */
    private Long hosactIdSejour;

    private Long hosId;

}
