package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmResponsableDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long rpbId;


    /**
     * date de creation
     */
    private LocalDateTime rpbDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime rpbDateModif;


    /**
     * utilisateur de creation
     */
    private Long rpbUserCreat;


    /**
     * utilisateur de modification
     */
    private Long rpbUserModif;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer rpbEtat;


    /**
     * id du responsable
     */
    private Long rpbUserId;


    /**
     * nom responsable
     */
    private String rpbNom;


    /**
     * prenom
     */
    private String rpbPrenom;


    /**
     * fonction
     */
    private String rpbCategorie;


    /**
     * civilite (suivant fichier xml)
     */
    private String rpbCivilite;


    /**
     * date de debut
     */
    private LocalDateTime rpbDateDebut;


    /**
     * date de fin
     */
    private LocalDateTime rpbDateFin;


    /**
     * 1= defaut
     */
    private Integer rpbDefaut;

    private Long tieId;

}
