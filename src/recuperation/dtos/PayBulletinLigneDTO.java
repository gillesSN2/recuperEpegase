package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class PayBulletinLigneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bulligId;


    /**
     * code rubrique
     */
    private String bulligRubrique;


    /**
     * libelle rubrique
     */
    private String bulligLibelle;


    /**
     * affiche colonne A
     */
    private Boolean bulligAffCola;


    /**
     * affiche colonne B
     */
    private Boolean bulligAffColb;


    /**
     * affiche colonne C
     */
    private Boolean bulligAffColc;


    /**
     * affiche colonne D
     */
    private Boolean bulligAffCold;


    /**
     * affiche colonne E
     */
    private Boolean bulligAffCole;


    /**
     * valeur colonne A
     */
    private Double bulligValCola;


    /**
     * valeur colonne B
     */
    private Double bulligValColb;


    /**
     * valeur colonne C
     */
    private Double bulligValColc;


    /**
     * valeur colonne D
     */
    private Double bulligValCold;


    /**
     * valeur colonne E
     */
    private Double bulligValCole;


    /**
     * code nature
     */
    private Integer bulligNature;


    /**
     * 0=+ 1=- 2=calcul 3=resultat
     */
    private Integer bulligSens;


    /**
     * id pret ligne
     */
    private Long bulligIdPretLigne;


    /**
     * numero de pret
     */
    private String bulligNumPret;

    private Long salId;

    private Long bulsalId;

    private Long exepayId;


    /**
     * observation
     */
    private String bulligObservation;

}
