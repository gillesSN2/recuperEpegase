package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ImmBienTravauxLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bietraligId;


    /**
     * id du tiers fournisseur
     */
    private Long bietraligIdTiers;


    /**
     * civilite du fournisseur
     */
    private String bietraligCivilTiers;


    /**
     * type du fournisseur
     */
    private Integer bietraligTypeTiers;


    /**
     * nom ou raison social du fournisseur
     */
    private String bietraligNomTiers;


    /**
     * numero de facture fournisseur
     */
    private String bietraligNumFacture;


    /**
     * date de facture fournisseur
     */
    private LocalDate bietraligDateFacture;


    /**
     * objet de la facture
     */
    private String bietraligObjetFacture;


    /**
     * total ht facture
     */
    private Double bietraligHt;


    /**
     * total tva
     */
    private Double bietraligTva;


    /**
     * total ttc
     */
    private Double bietraligTtc;


    /**
     * scan de la facture
     */
    private String bietraligScanFacture;

    private Long bietraentId;

}
