package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CptTabNomDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long tablisId;


    /**
     * zone fiscale du tableau
     */
    private String tablisZone;


    /**
     * numero ordre
     */
    private Integer tablisNum;


    /**
     * code du tableau
     */
    private String tablisCode;


    /**
     * nom du tableau en fr
     */
    private String tablisLibFr;


    /**
     * nom du tableau en uk
     */
    private String tablisLibUk;


    /**
     * nom du tableau en sp
     */
    private String tablisLibSp;


    /**
     * modele impression
     */
    private String tablisModele;


    /**
     * filtre analytique
     */
    private String tablisAnalytique;


    /**
     * sauf analytique
     */
    private String tablisSauf;


    /**
     * nombre de colonne du tableau max 20
     */
    private Integer tablisNbCol;


    /**
     * 0=etats financiers 1=rapport de synthese 2=fiche societe 3=activite societe 4=actionnaires
     */
    private Integer tablisType;


    /**
     * 0=modifiable par le client 1=non modifiable par le client
     */
    private Integer tablisModif;


    /**
     * 0=actif 1=inactif
     */
    private Integer tablisInactif;


    /**
     * annee de la colonne 1 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn01;


    /**
     * annee de la colonne 2 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn02;


    /**
     * annee de la colonne 3 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn03;


    /**
     * annee de la colonne 4 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn04;


    /**
     * annee de la colonne 5 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn05;


    /**
     * annee de la colonne 6 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn06;


    /**
     * annee de la colonne 7 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn07;


    /**
     * annee de la colonne 8 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn08;


    /**
     * annee de la colonne 9 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn09;


    /**
     * annee de la colonne 10 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn10;


    /**
     * annee de la colonne 11 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn11;


    /**
     * annee de la colonne 12 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn12;


    /**
     * annee de la colonne 13 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn13;


    /**
     * annee de la colonne 14 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn14;


    /**
     * annee de la colonne 15 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn15;


    /**
     * annee de la colonne 16 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn16;


    /**
     * annee de la colonne 17 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn17;


    /**
     * annee de la colonne 18 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn18;


    /**
     * annee de la colonne 19 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn19;


    /**
     * annee de la colonne 20 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    private Integer tablisAnn20;


    /**
     * nom de la colonne 1
     */
    private String tablisNom01;


    /**
     * nom de la colonne 2
     */
    private String tablisNom02;


    /**
     * nom de la colonne 3
     */
    private String tablisNom03;


    /**
     * nom de la colonne 4
     */
    private String tablisNom04;


    /**
     * nom de la colonne 5
     */
    private String tablisNom05;


    /**
     * nom de la colonne 6
     */
    private String tablisNom06;


    /**
     * nom de la colonne 7
     */
    private String tablisNom07;


    /**
     * nom de la colonne 8
     */
    private String tablisNom08;


    /**
     * nom de la colonne 9
     */
    private String tablisNom09;


    /**
     * nom de la colonne 10
     */
    private String tablisNom10;


    /**
     * nom de la colonne 11
     */
    private String tablisNom11;


    /**
     * nom de la colonne 12
     */
    private String tablisNom12;


    /**
     * nom de la colonne 13
     */
    private String tablisNom13;


    /**
     * nom de la colonne 14
     */
    private String tablisNom14;


    /**
     * nom de la colonne 15
     */
    private String tablisNom15;


    /**
     * nom de la colonne 16
     */
    private String tablisNom16;


    /**
     * nom de la colonne 17
     */
    private String tablisNom17;


    /**
     * nom de la colonne 18
     */
    private String tablisNom18;


    /**
     * nom de la colonne 19
     */
    private String tablisNom19;


    /**
     * nom de la colonne 20
     */
    private String tablisNom20;


    /**
     * l ancien id de tabnom
     */
    private Long tablisOldId;


    /**
     * type de la colonne 01
     */
    private Integer tablisTypeCol01;


    /**
     * type de la colonne 02
     */
    private Integer tablisTypeCol02;


    /**
     * type de la colonne 03
     */
    private Integer tablisTypeCol03;


    /**
     * type de la colonne 04
     */
    private Integer tablisTypeCol04;


    /**
     * type de la colonne 05
     */
    private Integer tablisTypeCol05;


    /**
     * type de la colonne 06
     */
    private Integer tablisTypeCol06;


    /**
     * type de la colonne 07
     */
    private Integer tablisTypeCol07;


    /**
     * type de la colonne 08
     */
    private Integer tablisTypeCol08;


    /**
     * type de la colonne 09
     */
    private Integer tablisTypeCol09;


    /**
     * type de la colonne 10
     */
    private Integer tablisTypeCol10;


    /**
     * type de la colonne 11
     */
    private Integer tablisTypeCol11;


    /**
     * type de la colonne 12
     */
    private Integer tablisTypeCol12;


    /**
     * type de la colonne 13
     */
    private Integer tablisTypeCol13;


    /**
     * type de la colonne 14
     */
    private Integer tablisTypeCol14;


    /**
     * type de la colonne 15
     */
    private Integer tablisTypeCol15;


    /**
     * type de la colonne 16
     */
    private Integer tablisTypeCol16;


    /**
     * type de la colonne 17
     */
    private Integer tablisTypeCol17;


    /**
     * type de la colonne 18
     */
    private Integer tablisTypeCol18;


    /**
     * type de la colonne 19
     */
    private Integer tablisTypeCol19;


    /**
     * type de la colonne 20
     */
    private Integer tablisTypeCol20;


    /**
     * format 0=monnaie 1=% 2=quantite de la colonne 01
     */
    private Integer tablisFormatCol01;


    /**
     * format de la colonne 02
     */
    private Integer tablisFormatCol02;


    /**
     * format de la colonne 03
     */
    private Integer tablisFormatCol03;


    /**
     * format de la colonne 04
     */
    private Integer tablisFormatCol04;


    /**
     * format de la colonne 05
     */
    private Integer tablisFormatCol05;


    /**
     * format de la colonne 06
     */
    private Integer tablisFormatCol06;


    /**
     * format de la colonne 07
     */
    private Integer tablisFormatCol07;


    /**
     * format de la colonne 08
     */
    private Integer tablisFormatCol08;


    /**
     * format de la colonne 09
     */
    private Integer tablisFormatCol09;


    /**
     * format de la colonne 10
     */
    private Integer tablisFormatCol10;


    /**
     * format de la colonne 11
     */
    private Integer tablisFormatCol11;


    /**
     * format de la colonne 12
     */
    private Integer tablisFormatCol12;


    /**
     * format de la colonne 13
     */
    private Integer tablisFormatCol13;


    /**
     * format de la colonne 14
     */
    private Integer tablisFormatCol14;


    /**
     * format de la colonne 15
     */
    private Integer tablisFormatCol15;


    /**
     * format de la colonne 16
     */
    private Integer tablisFormatCol16;


    /**
     * format de la colonne 17
     */
    private Integer tablisFormatCol17;


    /**
     * format de la colonne 18
     */
    private Integer tablisFormatCol18;


    /**
     * format de la colonne 19
     */
    private Integer tablisFormatCol19;


    /**
     * format de la colonne 20
     */
    private Integer tablisFormatCol20;

}
