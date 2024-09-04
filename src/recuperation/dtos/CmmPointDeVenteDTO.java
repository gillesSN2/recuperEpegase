package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmPointDeVenteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long pdvId;


    /**
     * date de creation
     */
    private LocalDateTime pdvDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime pdvDateModif;


    /**
     * utilisateur de modification
     */
    private Long pdvUserCreat;


    /**
     * utilisateur de creation
     */
    private Long pdvUserModif;


    /**
     * code de pdv
     */
    private String pdvCode;


    /**
     * nom du pdv en FR
     */
    private String pdvNomFr;


    /**
     * nom du pdv en UK
     */
    private String pdvNomUk;


    /**
     * nom du pdv en SP
     */
    private String pdvNomSp;


    /**
     * 0=actif 1=inactif
     */
    private Integer pdvInactif;


    /**
     * % de repartition par rapport au secteur
     */
    private Float pdvPourcentage;

    private Long regId;

    private Long secId;


    /**
     * id responsable
     */
    private Long pdvIdResponsable;


    /**
     * nom responsable
     */
    private String pdvNomResponsable;

}
