package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AchFraisLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fsfligId;


    /**
     * code produit
     */
    private String fsfligCode;


    /**
     * famille vente
     */
    private String fsfligFamille;


    /**
     * libelle produit
     */
    private String fsfligLibelle;


    /**
     * mode produit 0=divers 1=fret 2=assurance 3=douane 4=transit 5=debours
     */
    private Integer fsfligMode;


    /**
     * code taxe
     */
    private String fsfligTaxe;


    /**
     * taux de taxe
     */
    private Float fsfligTauxTaxe;


    /**
     * unite produit
     */
    private String fsfligUnite;


    /**
     * quantite
     */
    private Float fsfligQte;


    /**
     * code devise
     */
    private String fsfligDevise;


    /**
     * prix unitaire
     */
    private Double fsfligPu;


    /**
     * taux de remise
     */
    private Float fsfligTauxRemise;


    /**
     * valeur du rabais
     */
    private Double fsfligRabais;


    /**
     * prix unitaire apres remise
     */
    private Double fsfligPuRem;


    /**
     * prix total ht
     */
    private Double fsfligPt;


    /**
     * total taxe
     */
    private Double fsfligTva;


    /**
     * total taxe complementaire
     */
    private Double fsfligTc;


    /**
     * total ttc
     */
    private Double fsfligTtc;


    /**
     * prix total ht local
     */
    private Double fsfligPtLocal;


    /**
     * prix de revient
     */
    private Double fsfligPr;


    /**
     * prix unitaire moyen pondere
     */
    private Double fsfligPump;


    /**
     * id fournisseur secondaire
     */
    private Long fsfligIdFournisseur2;


    /**
     * nom fournisseur secondaire
     */
    private String fsfligNomFournisseur2;


    /**
     * numero de facture du prestataire
     */
    private String fsfligNumFactureFour2;

    private Long fsfId;


    /**
     * description conditionnement produit
     */
    private String fsfligDescription;


    /**
     * quantite
     */
    private Float fsfligQteUtil;


    /**
     * poids brut
     */
    private Float fsfligPoidsbrut;

}
