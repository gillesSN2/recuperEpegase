package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ImmBienTravauxEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bietraentId;


    /**
     * date de creation
     */
    private LocalDateTime bietraentDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bietraentDateModif;


    /**
     * utilisateur de creation
     */
    private Long bietraentUserCreat;


    /**
     * utilisateur de modification
     */
    private Long bietraentUserModif;


    /**
     * numero travaux
     */
    private String bietraentNum;


    /**
     * code bien
     */
    private String bietraentCodeBien;


    /**
     * date debut
     */
    private LocalDate bietraentDateDebut;


    /**
     * date de fin
     */
    private LocalDate bietraentDateFin;


    /**
     * duree
     */
    private Integer bietraentDuree;


    /**
     * 0=en cours 1=valide 2=annule 3=gele 4=termine
     */
    private Integer bietraentEtat;


    /**
     * serie A, B, C, D ou X
     */
    private String bietraentSerie;


    /**
     * nom du commercial
     */
    private String bietraentNomResponsable;


    /**
     * id du commercial
     */
    private Long bietraentIdResponsable;


    /**
     * commentaire
     */
    private String bietraentObjet;


    /**
     * descriptif
     */
    private String bietraentDescriptif;


    /**
     * cout theorique
     */
    private Double bietraentCoutTheorique;


    /**
     * cout reel
     */
    private Double bietraentCoutReel;


    /**
     * date de controle
     */
    private LocalDate bietraentDateCrtl;


    /**
     * observation de controle
     */
    private String bietraentObsCrtl;


    /**
     * rapport sur le controle
     */
    private String bietraentRapportCtrl;


    /**
     * nom du controleur
     */
    private String bietraentNomCtrl;


    /**
     * id du controleur
     */
    private Long bietraentIdCtrl;


    /**
     * date impression
     */
    private LocalDate bietraentDateImp;


    /**
     * nom jasper du modele
     */
    private String bietraentModeleImp;

    private Long bieId;

}
