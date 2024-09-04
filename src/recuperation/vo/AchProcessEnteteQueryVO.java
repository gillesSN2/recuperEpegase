package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchProcessEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long procesId;


    /**
     * date de creation
     */
    private LocalDateTime procesDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime procesDateModif;


    /**
     * id user createur
     */
    private Long procesUserCreat;


    /**
     * id user de modification
     */
    private Long procesUserModif;


    /**
     * code produit
     */
    private String procesCode;


    /**
     * libelle client
     */
    private String procesLibClient;


    /**
     * libelle technique
     */
    private String procesLibTech;


    /**
     * depot de stockage
     */
    private String procesDepot;


    /**
     * unite
     */
    private String procesUnite;


    /**
     * coefficient
     */
    private Float procesCoef;


    /**
     * site
     */
    private String procesSite;


    /**
     * ligne
     */
    private String procesLigne;


    /**
     * atelier
     */
    private String procesAtelier;


    /**
     * code acitivite commerciale
     */
    private String procesActivite;


    /**
     * total pump
     */
    private Double procesTotPump;


    /**
     * 0=actif 1=inactif
     */
    private Integer procesInactif;

}
