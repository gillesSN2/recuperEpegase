package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptTabElementQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tabeleId;


    /**
     * zone fiscale du tableau
     */
    private String tabeleZone;


    /**
     * reference de la ligne
     */
    private String tabeleReference;


    /**
     * nom element en fr
     */
    private String tabeleLibFr;


    /**
     * nom element en uk
     */
    private String tabeleLibUk;


    /**
     * nom element en sp
     */
    private String tabeleLibSp;


    /**
     * numero de la ligne
     */
    private Integer tabeleNum;


    /**
     * 0=titre principal 1=titre secondaire 2=sous titre 3=calcul/saisie 4=total sous titre 5=total secondaire 6=total principal
     */
    private Integer tabeleType;


    /**
     * 0=resultat normal 1=resultat intermediaire
     */
    private Integer tabeleMode;


    /**
     * 0=imprimable 1=non imprimable
     */
    private Integer tabelePrint;


    /**
     * 0=defaut 1=monnaie 2=% 3=quantite
     */
    private Integer tabeleNature;


    /**
     * l ancien cle etrangere de pegTabNom
     */
    private Long tablisOldId;


    /**
     * l ancien id de l element
     */
    private Long tabeleOldId;


    /**
     * 0=actif 1=inactif
     */
    private Boolean tabeleInactif;


    /**
     * type de la colonne 01
     */
    private Integer tabeleTypeCol01;


    /**
     * type de la colonne 02
     */
    private Integer tabeleTypeCol02;


    /**
     * type de la colonne 03
     */
    private Integer tabeleTypeCol03;


    /**
     * type de la colonne 04
     */
    private Integer tabeleTypeCol04;


    /**
     * type de la colonne 05
     */
    private Integer tabeleTypeCol05;


    /**
     * type de la colonne 06
     */
    private Integer tabeleTypeCol06;


    /**
     * type de la colonne 07
     */
    private Integer tabeleTypeCol07;


    /**
     * type de la colonne 08
     */
    private Integer tabeleTypeCol08;


    /**
     * type de la colonne 09
     */
    private Integer tabeleTypeCol09;


    /**
     * type de la colonne 10
     */
    private Integer tabeleTypeCol10;


    /**
     * type de la colonne 11
     */
    private Integer tabeleTypeCol11;


    /**
     * type de la colonne 12
     */
    private Integer tabeleTypeCol12;


    /**
     * type de la colonne 13
     */
    private Integer tabeleTypeCol13;


    /**
     * type de la colonne 14
     */
    private Integer tabeleTypeCol14;


    /**
     * type de la colonne 15
     */
    private Integer tabeleTypeCol15;


    /**
     * type de la colonne 16
     */
    private Integer tabeleTypeCol16;


    /**
     * type de la colonne 17
     */
    private Integer tabeleTypeCol17;


    /**
     * type de la colonne 18
     */
    private Integer tabeleTypeCol18;


    /**
     * type de la colonne 19
     */
    private Integer tabeleTypeCol19;


    /**
     * type de la colonne 20
     */
    private Integer tabeleTypeCol20;

    private Long tablisId;


    /**
     * format 0=monnaie 1=% 2=quantite
     */
    private Integer tabeleFormatCel01;


    /**
     * format 0=monnaie 1=% 2=quantite
     */
    private Integer tabeleFormatCel02;


    /**
     * format 0=monnaie 1=% 2=quantite
     */
    private Integer tabeleFormatCel03;


    /**
     * format de la colonne 04
     */
    private Integer tabeleFormatCel04;


    /**
     * format de la colonne 05
     */
    private Integer tabeleFormatCel05;


    /**
     * format de la colonne 06
     */
    private Integer tabeleFormatCel06;


    /**
     * format de la colonne 07
     */
    private Integer tabeleFormatCel07;


    /**
     * format de la colonne 08
     */
    private Integer tabeleFormatCel08;


    /**
     * format de la colonne 09
     */
    private Integer tabeleFormatCel09;


    /**
     * format de la colonne 10
     */
    private Integer tabeleFormatCel10;


    /**
     * format de la colonne 11
     */
    private Integer tabeleFormatCel11;


    /**
     * format de la colonne 12
     */
    private Integer tabeleFormatCel12;


    /**
     * format de la colonne 13
     */
    private Integer tabeleFormatCel13;


    /**
     * format de la colonne 14
     */
    private Integer tabeleFormatCel14;


    /**
     * format de la colonne 15
     */
    private Integer tabeleFormatCel15;


    /**
     * format de la colonne 16
     */
    private Integer tabeleFormatCel16;


    /**
     * format de la colonne 17
     */
    private Integer tabeleFormatCel17;


    /**
     * format de la colonne 18
     */
    private Integer tabeleFormatCel18;


    /**
     * format de la colonne 19
     */
    private Integer tabeleFormatCel19;


    /**
     * format de la colonne 20
     */
    private Integer tabeleFormatCel20;

}
