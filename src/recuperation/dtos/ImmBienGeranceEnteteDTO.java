package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ImmBienGeranceEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long biegerentId;


    /**
     * date de creation
     */
    private LocalDateTime biegerentDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime biegerentDateModif;


    /**
     * utilisateur de creation
     */
    private Long biegerentUserCreat;


    /**
     * utilisateur de modification
     */
    private Long biegerentUserModif;


    /**
     * date de signature
     */
    private LocalDate biegerentDateSignature;


    /**
     * numero gerance
     */
    private String biegerentNum;


    /**
     * date debut
     */
    private LocalDate biegerentDateDebut;


    /**
     * date de fin
     */
    private LocalDate biegerentDateFin;


    /**
     * duree
     */
    private Integer biegerentDuree;


    /**
     * 0=en cours 1=validee 2=annulee 3=gelee 4=terminee
     */
    private Integer biegerentEtat;


    /**
     * 0=mensuel 1=trimestriel 2=semestre 3=annuel
     */
    private Integer biegerentMode;


    /**
     * nom du tiers
     */
    private String biegerentNomTiers;


    /**
     * nom du tiers
     */
    private String biegerentCivilTiers;


    /**
     * assujettissement du tiers proprietaire 0=aucun 1=irpp 2=is
     */
    private Integer biegerentTypeTiers;


    /**
     * serie A, B, C, D ou X
     */
    private String biegerentSerie;


    /**
     * 0=avec tva 1=sans tva
     */
    private Integer biegerentExoTva;


    /**
     * nom du commercial
     */
    private String biegerentNomResponsable;


    /**
     * id du commercial
     */
    private Long biegerentIdResponsable;


    /**
     * texte du contrat
     */
    private String biegerentContrat;


    /**
     * date impression
     */
    private LocalDate biegerentDateImp;


    /**
     * nom jasper du modele
     */
    private String biegerentModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer biegerentEtatVal;


    /**
     * date de validite
     */
    private LocalDate biegerentDateValidite;


    /**
     * date de validation
     */
    private LocalDate biegerentDateValide;

    private Long tieId;

}
