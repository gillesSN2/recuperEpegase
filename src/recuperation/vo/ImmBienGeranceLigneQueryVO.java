package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class ImmBienGeranceLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long biegerligId;


    /**
     * 0=mensuel 1=trimestriel 2=semestre 3=annuel
     */
    private Integer biegerligMode;


    /**
     * 0=habitation 1=professionnel 2=idustriel 3=mixte
     */
    private Integer biegerligUsage;


    /**
     * montant loyer brut
     */
    private Double biegerligLoyerBrut;


    /**
     * montant caution
     */
    private Double biegerligMontantCaution;


    /**
     * taux tom
     */
    private Float biegerligTauxTom;


    /**
     * montant tom
     */
    private Double biegerligTom;


    /**
     * 0=sans 1=enregistrement 2=tlv
     */
    private Integer biegerligModeTlv;


    /**
     * taux tlv
     */
    private Float biegerligTauxTlv;


    /**
     * montant tlv
     */
    private Double biegerligTlv;


    /**
     * taux tva
     */
    private Float biegerligTauxTva;


    /**
     * montant tva
     */
    private Double biegerligTva;


    /**
     * montant loyer net
     */
    private Double biegerligLoyerNet;


    /**
     * montant loyer professionnel si mixte
     */
    private Double biegerligLoyerProfessionel;


    /**
     * montant des charges immeuble
     */
    private Double biegerligChargesImmeuble;


    /**
     * taux des charges immeuble
     */
    private Float biegerligTauxCharges;


    /**
     * eau
     */
    private Double biegerligEau;


    /**
     * electricite
     */
    private Double biegerligElectricite;


    /**
     * parking
     */
    private Double biegerligParking;


    /**
     * gardiennage
     */
    private Double biegerligGardiennage;


    /**
     * jardinnier
     */
    private Double biegerligJardinneir;


    /**
     * groupe electrogene
     */
    private Double biegerligGroupeElectro;


    /**
     * divers frais
     */
    private Double biegerligDiversFrais;


    /**
     * libelle frais
     */
    private String biegerligLibelleFrais;


    /**
     * frais complementaire
     */
    private Double biegerligFraisComplement;


    /**
     * taux commission agence
     */
    private Float biegerligTauxCommission;


    /**
     * total commission agence
     */
    private Double biegerligTotalCommission;


    /**
     * tva commission agence
     */
    private Double biegerligTvaCommission;


    /**
     * net a payer au proprietaire
     */
    private Double biegerligNetPayer;


    /**
     * taux irpp
     */
    private Float biegerligTauxIrpp;


    /**
     * total irpp si proprietaire est assujetti irrp
     */
    private Double biegerligTotalIrpp;


    /**
     * 0=pas de declaration 1=declaration
     */
    private Integer biegerligDeclare;


    /**
     * montant frais de declaration
     */
    private Double biegerligFraisDeclaration;


    /**
     * montant frais etat compte
     */
    private Double biegerligFraisEtatCompte;

    private Long bieId;

    private Long biegerentId;

}
