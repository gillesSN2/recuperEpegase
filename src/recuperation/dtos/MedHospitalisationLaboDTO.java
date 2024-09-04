package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedHospitalisationLaboDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long hoslabId;


    /**
     * id medecin
     */
    private Long hoslabIdMedecin;


    /**
     * nom medecin
     */
    private String hoslabMedecin;


    /**
     * service
     */
    private String hoslabService;


    /**
     * code produit
     */
    private String hoslabProduit;


    /**
     * libelle produit
     */
    private String hoslabLibelle;


    /**
     * code lettre
     */
    private String hoslabLettre;


    /**
     * nombre lettre
     */
    private Float hoslabNb;


    /**
     * valeur lettre
     */
    private Double hoslabValeur;


    /**
     * coefficient
     */
    private Float hoslabCoef;


    /**
     * prix unitaire
     */
    private Double hoslabPu;


    /**
     * code de tva
     */
    private String hoslabCodeTva;


    /**
     * taux de tva
     */
    private Float hoslabTauxTva;


    /**
     * %remise
     */
    private Float hoslabRemise;


    /**
     * prix apres remise
     */
    private Double hoslabPuRem;


    /**
     * quantite
     */
    private Float hoslabQte;


    /**
     * part ht patient
     */
    private Double hoslabPatientHt;


    /**
     * part taxe patient
     */
    private Double hoslabPatientTaxe;


    /**
     * part ht societe
     */
    private Double hoslabSocieteHt;


    /**
     * part taxe societe
     */
    private Double hoslabSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double hoslabAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double hoslabAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double hoslabComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double hoslabComplementaireTaxe;


    /**
     * total ht
     */
    private Double hoslabTotal;


    /**
     * total taxe
     */
    private Double hoslabTaxe;


    /**
     * id sejour
     */
    private Long hoslabIdSejour;

    private Long hosId;

}
