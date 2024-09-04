package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteCampagneEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long camId;


    /**
     * date de creation
     */
    private LocalDateTime camDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime camDateModif;


    /**
     * id user createur
     */
    private Long camIdCreateur;


    /**
     * nom du createur
     */
    private String camNomCreateur;


    /**
     * id user de modification
     */
    private Long camIdModif;


    /**
     * nom user de modification
     */
    private String camNomModif;


    /**
     * date debut de campagne
     */
    private LocalDate camDateDebut;


    /**
     * date fin de campagne
     */
    private LocalDate camDateFin;


    /**
     * numero campagne
     */
    private String camNum;


    /**
     * serie campagne
     */
    private String camSerie;


    /**
     * date campagne
     */
    private LocalDateTime camDate;


    /**
     * objet campagne
     */
    private String camObjet;


    /**
     * descriptif campagne
     */
    private String camDescriptif;


    /**
     * nom du commercial
     */
    private String camNomResponsable;


    /**
     * id du commercial
     */
    private Long camIdResponsable;


    /**
     * nom du commercial
     */
    private String camNomCommercial;


    /**
     * id du commercial
     */
    private Long camIdCommercial;


    /**
     * nom du equipe
     */
    private String camNomEquipe;


    /**
     * id du equipe
     */
    private Long camIdEquipe;


    /**
     * total budget
     */
    private Double camTotBudget;


    /**
     * total depense
     */
    private Double camTotDepense;


    /**
     * total recette
     */
    private Double camTotRecette;


    /**
     * depense - recette
     */
    private Double camMarge;


    /**
     * code activite
     */
    private String camActivite;


    /**
     * code site
     */
    private String camSite;


    /**
     * code departement
     */
    private String camDepartement;


    /**
     * code service
     */
    private String camService;


    /**
     * code analytique 2
     */
    private String camAnal2;


    /**
     * code analytique 4
     */
    private String camAnal4;


    /**
     * date impression
     */
    private LocalDate camDateImp;


    /**
     * nom jasper du modele
     */
    private String camModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer camEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer camGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=cloture
     */
    private Integer camEtat;


    /**
     * date de validite
     */
    private LocalDate camDateValidite;


    /**
     * date de validation
     */
    private LocalDate camDateValide;


    /**
     * date annulation
     */
    private LocalDate camDateAnnule;


    /**
     * motif annulation
     */
    private String camMotifAnnule;


    /**
     * date transfert en compta
     */
    private LocalDate camDateTransfert;

    private Long exevteId;

    private Long usrId;

}
