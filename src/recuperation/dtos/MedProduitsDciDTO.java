package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedProduitsDciDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prodciId;


    /**
     * date de creation
     */
    private LocalDateTime prodciDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime prodciDateModif;


    /**
     * utilisateur de creation
     */
    private Long prodciUserCreation;


    /**
     * utilisateur de modification
     */
    private Long prodciUserModif;


    /**
     * code dci
     */
    private String prodciCode;


    /**
     * forme
     */
    private String prodciForme;


    /**
     * indication
     */
    private String prodciIndication;


    /**
     * posologie
     */
    private String prodciPosologie;


    /**
     * contre indication
     */
    private String prodciContreIndic;


    /**
     * effet secondaire
     */
    private String prodciEffetSecond;


    /**
     * 0=medicamment 1= a base de plante 2=veterinaire 3=hydratant cutanee 4=parapharmacie
     */
    private Integer prodciType;


    /**
     * ???
     */
    private Integer prodciCat;

}
