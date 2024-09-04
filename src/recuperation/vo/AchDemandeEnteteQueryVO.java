package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchDemandeEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long demId;


    /**
     * date de creation
     */
    private LocalDateTime demDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime demDateModif;


    /**
     * id user createur
     */
    private Long demIdCreateur;


    /**
     * nom du createur
     */
    private String demNomCreateur;


    /**
     * id user de modification
     */
    private Long demIdModif;


    /**
     * nom user de modification
     */
    private String demNomModif;


    /**
     * date du reception
     */
    private LocalDate demDate;


    /**
     * numero reception
     */
    private String demNum;


    /**
     * nom du commercial
     */
    private String demNomResponsable;


    /**
     * id du commercial
     */
    private Long demIdResponsable;


    /**
     * serie
     */
    private String demSerie;


    /**
     * objet
     */
    private String demObject;


    /**
     * observation
     */
    private String demObservation;


    /**
     * code budget
     */
    private String demBudget;


    /**
     * montant disponible sur budget
     */
    private Double demBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double demBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double demBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double demBudgetTresoMois;


    /**
     * total ht
     */
    private Double demTotHt;


    /**
     * ttal tva
     */
    private Double demTotTva;


    /**
     * total ttc
     */
    private Double demTotTtc;


    /**
     * code activite
     */
    private String demActivite;


    /**
     * code site
     */
    private String demSite;


    /**
     * code departement
     */
    private String demDepartement;


    /**
     * code service
     */
    private String demService;


    /**
     * code region
     */
    private String demRegion;


    /**
     * code secteur
     */
    private String demSecteur;


    /**
     * code point de vente
     */
    private String demPdv;


    /**
     * code analytique 2
     */
    private String demAnal2;


    /**
     * code analytique 4
     */
    private String demAnal4;


    /**
     * info 1
     */
    private String demInfo1;


    /**
     * info 2
     */
    private String demInfo2;


    /**
     * info 3
     */
    private String demInfo3;


    /**
     * info 4
     */
    private String demInfo4;


    /**
     * info 5
     */
    private String demInfo5;


    /**
     * info 6
     */
    private String demInfo6;


    /**
     * info 7
     */
    private String demInfo7;


    /**
     * info 8
     */
    private String demInfo8;


    /**
     * info 9
     */
    private String demInfo9;


    /**
     * info 10
     */
    private String demInfo10;


    /**
     * code formule 1
     */
    private String demFormule1;


    /**
     * code formule 2
     */
    private String demFormule2;


    /**
     * nom jasper anexe 1
     */
    private String demAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String demAnnexe2;


    /**
     * date impression
     */
    private LocalDate demDateImp;


    /**
     * nom jasper du modele
     */
    private String demModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer demEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer demGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer demEtat;


    /**
     * date de validite
     */
    private LocalDate demDateValidite;


    /**
     * date de relance
     */
    private LocalDate demDateRelance;


    /**
     * date de validation
     */
    private LocalDate demDateValide;


    /**
     * date de transformation
     */
    private LocalDate demDateTransforme;


    /**
     * type de transformation
     */
    private Integer demTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate demDateAnnule;


    /**
     * motif annulation
     */
    private String demMotifAnnule;

    private Long exeachId;

    private Long usrId;

}
