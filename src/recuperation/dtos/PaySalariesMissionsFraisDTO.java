package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PaySalariesMissionsFraisDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long salmisfraId;


    /**
     * date du frais
     */
    private LocalDate salmisfraDate;


    /**
     * objet du frais
     */
    private String salmisfraObjet;


    /**
     * 0=preparation mission 1=retour mission
     */
    private Integer salmisfraMode;


    /**
     * 0=transport 1=hebergement 2=restauration 3=divers
     */
    private Integer salmisfraType;


    /**
     * reference du frais
     */
    private String salmisfraReference;


    /**
     * fourisseur origine
     */
    private String salmisfraFournisseur;


    /**
     * cout du frais
     */
    private Double salmisfraCout;

    private Long salId;

    private Long misId;

}
