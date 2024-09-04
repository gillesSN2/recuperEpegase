package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptBudgetLigneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long budligId;


    /**
     * code budget
     */
    private String budligCode;


    /**
     * defini le dernier budget utilise de 1 aÃ‚Â  4
     */
    private Integer budligUtil;


    /**
     * code activite
     */
    private String budligActivite;


    /**
     * code site
     */
    private String budligSite;


    /**
     * code departement
     */
    private String budligDepartement;


    /**
     * code service
     */
    private String budligService;


    /**
     * code region
     */
    private String budligRegion;


    /**
     * code secteur
     */
    private String budligSecteur;


    /**
     * code pdv
     */
    private String budligPdv;


    /**
     * valeur initiale
     */
    private Double budlig01TotVal;


    /**
     * valeur reamenagement 2
     */
    private Double budlig02TotVal;


    /**
     * valeur reamenagement 3
     */
    private Double budlig03TotVal;


    /**
     * valeur reamenagement 4
     */
    private Double budlig04TotVal;


    /**
     * janvier reamenagement 1
     */
    private Double budlig01R1Val;


    /**
     * fevrier reamenagement 1
     */
    private Double budlig02R1Val;


    /**
     * mars reamenagement 1
     */
    private Double budlig03R1Val;


    /**
     * avril reamenagement 1
     */
    private Double budlig04R1Val;


    /**
     * mai reamenagement 1
     */
    private Double budlig05R1Val;


    /**
     * juin reamenagement 1
     */
    private Double budlig06R1Val;


    /**
     * juillet reamenagement 1
     */
    private Double budlig07R1Val;


    /**
     * aout reamenagement 1
     */
    private Double budlig08R1Val;


    /**
     * septembre reamenagement 1
     */
    private Double budlig09R1Val;


    /**
     * octobre reamenagement 1
     */
    private Double budlig10R1Val;


    /**
     * novembre reamenagement 1
     */
    private Double budlig11R1Val;


    /**
     * decembre reamenagement 1
     */
    private Double budlig12R1Val;


    /**
     * janvier reamenagement 2
     */
    private Double budlig01R2Val;


    /**
     * fevrier reamenagement 2
     */
    private Double budlig02R2Val;


    /**
     * mars reamenagement 2
     */
    private Double budlig03R2Val;


    /**
     * avril reamenagement 2
     */
    private Double budlig04R2Val;


    /**
     * mai reamenagement 2
     */
    private Double budlig05R2Val;


    /**
     * juin reamenagement 2
     */
    private Double budlig06R2Val;


    /**
     * juillet reamenagement 2
     */
    private Double budlig07R2Val;


    /**
     * aout reamenagement 2
     */
    private Double budlig08R2Val;


    /**
     * septembre reamenagement v
     */
    private Double budlig09R2Val;


    /**
     * octobre reamenagement 2
     */
    private Double budlig10R2Val;


    /**
     * novembre reamenagement 2
     */
    private Double budlig11R2Val;


    /**
     * decembre reamenagement 2
     */
    private Double budlig12R2Val;


    /**
     * janvier reamenagement 3
     */
    private Double budlig01R3Val;


    /**
     * fevrier reamenagement 3
     */
    private Double budlig02R3Val;


    /**
     * mars reamenagement 3
     */
    private Double budlig03R3Val;


    /**
     * avril reamenagement 3
     */
    private Double budlig04R3Val;


    /**
     * mai reamenagement 3
     */
    private Double budlig05R3Val;


    /**
     * juin reamenagement 3
     */
    private Double budlig06R3Val;


    /**
     * juillet reamenagement 3
     */
    private Double budlig07R3Val;


    /**
     * aout reamenagement 3
     */
    private Double budlig08R3Val;


    /**
     * septembre reamenagement 3
     */
    private Double budlig09R3Val;


    /**
     * octobre reamenagement 3
     */
    private Double budlig10R3Val;


    /**
     * novembre reamenagement 3
     */
    private Double budlig11R3Val;


    /**
     * decembre reamenagement 3
     */
    private Double budlig12R3Val;


    /**
     * janvier reamenagement 4
     */
    private Double budlig01R4Val;


    /**
     * fevrier reamenagement 4
     */
    private Double budlig02R4Val;


    /**
     * mars reamenagement 4
     */
    private Double budlig03R4Val;


    /**
     * avril reamenagement 4
     */
    private Double budlig04R4Val;


    /**
     * mai reamenagement 4
     */
    private Double budlig05R4Val;


    /**
     * juin reamenagement 4
     */
    private Double budlig06R4Val;


    /**
     * juillet reamenagement 4
     */
    private Double budlig07R4Val;


    /**
     * aout reamenagement 4
     */
    private Double budlig08R4Val;


    /**
     * septembre reamenagement 4
     */
    private Double budlig09R4Val;


    /**
     * octobre reamenagement 4
     */
    private Double budlig10R4Val;


    /**
     * novembre reamenagement 4
     */
    private Double budlig11R4Val;


    /**
     * decembre reamenagement 4
     */
    private Double budlig12R4Val;


    /**
     * quantite initiale
     */
    private Float budlig01TotQte;


    /**
     * quantite reamenagement 2
     */
    private Float budlig02TotQte;


    /**
     * quantite reamenagement 3
     */
    private Float budlig03TotQte;


    /**
     * quantite reamenagement 4
     */
    private Float budlig04TotQte;


    /**
     * janvier reamenagement 1
     */
    private Float budlig01R1Qte;


    /**
     * fevrier reamenagement 1
     */
    private Float budlig02R1Qte;


    /**
     * mars reamenagement 1
     */
    private Float budlig03R1Qte;


    /**
     * avril reamenagement 1
     */
    private Float budlig04R1Qte;


    /**
     * mai reamenagement 1
     */
    private Float budlig05R1Qte;


    /**
     * juin reamenagement 1
     */
    private Float budlig06R1Qte;


    /**
     * juillet reamenagement 1
     */
    private Float budlig07R1Qte;


    /**
     * aout reamenagement 1
     */
    private Float budlig08R1Qte;


    /**
     * septembre reamenagement 1
     */
    private Float budlig09R1Qte;


    /**
     * octobre reamenagement 1
     */
    private Float budlig10R1Qte;


    /**
     * novembre reamenagement 1
     */
    private Float budlig11R1Qte;


    /**
     * decembre reamenagement 1
     */
    private Float budlig12R1Qte;


    /**
     * janvier reamenagement 2
     */
    private Float budlig01R2Qte;


    /**
     * fevrier reamenagement 2
     */
    private Float budlig02R2Qte;


    /**
     * mars reamenagement 2
     */
    private Float budlig03R2Qte;


    /**
     * avril reamenagement 2
     */
    private Float budlig04R2Qte;


    /**
     * mai reamenagement 2
     */
    private Float budlig05R2Qte;


    /**
     * juin reamenagement 2
     */
    private Float budlig06R2Qte;


    /**
     * juillet reamenagement 2
     */
    private Float budlig07R2Qte;


    /**
     * aout reamenagement 2
     */
    private Float budlig08R2Qte;


    /**
     * septembre reamenagement 2
     */
    private Float budlig09R2Qte;


    /**
     * octobre reamenagement 2
     */
    private Float budlig10R2Qte;


    /**
     * novembre reamenagement 2
     */
    private Float budlig11R2Qte;


    /**
     * decembre reamenagement 2
     */
    private Float budlig12R2Qte;


    /**
     * janvier reamenagement 3
     */
    private Float budlig01R3Qte;


    /**
     * fevrier reamenagement 3
     */
    private Float budlig02R3Qte;


    /**
     * mars reamenagement 3
     */
    private Float budlig03R3Qte;


    /**
     * avril reamenagement 3
     */
    private Float budlig04R3Qte;


    /**
     * mai reamenagement 3
     */
    private Float budlig05R3Qte;


    /**
     * juin reamenagement 3
     */
    private Float budlig06R3Qte;


    /**
     * juillet reamenagement 3
     */
    private Float budlig07R3Qte;


    /**
     * aout reamenagement 3
     */
    private Float budlig08R3Qte;


    /**
     * septembre reamenagement 3
     */
    private Float budlig09R3Qte;


    /**
     * octobre reamenagement 3
     */
    private Float budlig10R3Qte;


    /**
     * novembre reamenagement 3
     */
    private Float budlig11R3Qte;


    /**
     * decembre reamenagement 3
     */
    private Float budlig12R3Qte;


    /**
     * janvier reamenagement 4
     */
    private Float budlig01R4Qte;


    /**
     * fevrier reamenagement 4
     */
    private Float budlig02R4Qte;


    /**
     * mars reamenagement 4
     */
    private Float budlig03R4Qte;


    /**
     * avril reamenagement 4
     */
    private Float budlig04R4Qte;


    /**
     * mai reamenagement 4
     */
    private Float budlig05R4Qte;


    /**
     * juin reamenagement 4
     */
    private Float budlig06R4Qte;


    /**
     * juillet reamenagement 4
     */
    private Float budlig07R4Qte;


    /**
     * aout reamenagement 4
     */
    private Float budlig08R4Qte;


    /**
     * septembre reamenagement 4
     */
    private Float budlig09R4Qte;


    /**
     * octobre reamenagement 4
     */
    private Float budlig10R4Qte;


    /**
     * novembre reamenagement 4
     */
    private Float budlig11R4Qte;


    /**
     * decembre reamenagement 4
     */
    private Float budlig12R4Qte;

    private Long budId;


    /**
     * lib activite
     */
    private String budligLibActivite;


    /**
     * code anal1
     */
    private String budligAnal1;


    /**
     * lib anal1
     */
    private String budligLibAnal1;


    /**
     * code anal3
     */
    private String budligAnal3;


    /**
     * lib anal3
     */
    private String budligLibAnal3;

}
