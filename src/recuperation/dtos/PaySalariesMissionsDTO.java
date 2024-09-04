package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class PaySalariesMissionsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long salmisId;


    /**
     * code devise
     */
    private String salmisDevise;


    /**
     * montant du visa
     */
    private Double salmisVisa;


    /**
     * total titre de transport
     */
    private Double salmisTitreTransport;


    /**
     * 0=route 1=train 2=avion 3=bateau
     */
    private Integer salmisTypeTransport;


    /**
     * deplacement domicile = aeroport, port, gare
     */
    private Double salmisDeplacement1;


    /**
     * deplacement aeroport, port, gare = domicile
     */
    private Double salmisDeplacement2;


    /**
     * reservation hotel
     */
    private Boolean salmisResaHotel;


    /**
     * nom hotel
     */
    private String salmisNomHotel;


    /**
     * mail hotel
     */
    private String salmisMailHotel;


    /**
     * telephone hotel
     */
    private String salmisTelHotel;


    /**
     * chambre hotel
     */
    private String salmisChambreHotel;


    /**
     * observations
     */
    private String salmisObs;


    /**
     * total perdiem theorique
     */
    private Double salmisPerdiemTheo;


    /**
     * total perdiem reel
     */
    private Double salmisPerdiemReel;


    /**
     * total restauration
     */
    private Double salmisRestauration;


    /**
     * total hebergement
     */
    private Double salmisHebergement;


    /**
     * total autres frais
     */
    private Double salmisAutresFrais;


    /**
     * acompte
     */
    private Double salmisAcompte;


    /**
     * liste des accompagnants
     */
    private String salmisAccompagnant;

    private Long salId;

    private Long misId;

}
