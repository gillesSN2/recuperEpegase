package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_tab_nom")
public class CptTabNom implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tablis_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tablisId;

    /**
     * zone fiscale du tableau
     */
    @Column(name = "tablis_zone")
    private String tablisZone;

    /**
     * numero ordre
     */
    @Column(name = "tablis_num")
    private Integer tablisNum = 0;

    /**
     * code du tableau
     */
    @Column(name = "tablis_code")
    private String tablisCode;

    /**
     * nom du tableau en fr
     */
    @Column(name = "tablis_lib_FR")
    private String tablisLibFr;

    /**
     * nom du tableau en uk
     */
    @Column(name = "tablis_lib_UK")
    private String tablisLibUk;

    /**
     * nom du tableau en sp
     */
    @Column(name = "tablis_lib_SP")
    private String tablisLibSp;

    /**
     * modele impression
     */
    @Column(name = "tablis_modele")
    private String tablisModele;

    /**
     * filtre analytique
     */
    @Column(name = "tablis_analytique")
    private String tablisAnalytique;

    /**
     * sauf analytique
     */
    @Column(name = "tablis_sauf")
    private String tablisSauf;

    /**
     * nombre de colonne du tableau max 20
     */
    @Column(name = "tablis_nb_col")
    private Integer tablisNbCol = 0;

    /**
     * 0=etats financiers 1=rapport de synthese 2=fiche societe 3=activite societe 4=actionnaires
     */
    @Column(name = "tablis_type")
    private Integer tablisType = 0;

    /**
     * 0=modifiable par le client 1=non modifiable par le client
     */
    @Column(name = "tablis_modif")
    private Integer tablisModif = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "tablis_inactif")
    private Integer tablisInactif = 0;

    /**
     * annee de la colonne 1 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_01")
    private Integer tablisAnn01 = 0;

    /**
     * annee de la colonne 2 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_02")
    private Integer tablisAnn02 = 0;

    /**
     * annee de la colonne 3 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_03")
    private Integer tablisAnn03 = 0;

    /**
     * annee de la colonne 4 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_04")
    private Integer tablisAnn04 = 0;

    /**
     * annee de la colonne 5 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_05")
    private Integer tablisAnn05 = 0;

    /**
     * annee de la colonne 6 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_06")
    private Integer tablisAnn06 = 0;

    /**
     * annee de la colonne 7 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_07")
    private Integer tablisAnn07 = 0;

    /**
     * annee de la colonne 8 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_08")
    private Integer tablisAnn08 = 0;

    /**
     * annee de la colonne 9 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_09")
    private Integer tablisAnn09 = 0;

    /**
     * annee de la colonne 10 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_10")
    private Integer tablisAnn10 = 0;

    /**
     * annee de la colonne 11 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_11")
    private Integer tablisAnn11 = 0;

    /**
     * annee de la colonne 12 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_12")
    private Integer tablisAnn12 = 0;

    /**
     * annee de la colonne 13 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_13")
    private Integer tablisAnn13 = 0;

    /**
     * annee de la colonne 14 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_14")
    private Integer tablisAnn14 = 0;

    /**
     * annee de la colonne 15 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_15")
    private Integer tablisAnn15 = 0;

    /**
     * annee de la colonne 16 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_16")
    private Integer tablisAnn16 = 0;

    /**
     * annee de la colonne 17 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_17")
    private Integer tablisAnn17 = 0;

    /**
     * annee de la colonne 18 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_18")
    private Integer tablisAnn18 = 0;

    /**
     * annee de la colonne 19 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_19")
    private Integer tablisAnn19 = 0;

    /**
     * annee de la colonne 20 0=N 1=N-1 2=N-2 3=N-3 4=N-4
     */
    @Column(name = "tablis_ann_20")
    private Integer tablisAnn20 = 0;

    /**
     * nom de la colonne 1
     */
    @Column(name = "tablis_nom_01")
    private String tablisNom01;

    /**
     * nom de la colonne 2
     */
    @Column(name = "tablis_nom_02")
    private String tablisNom02;

    /**
     * nom de la colonne 3
     */
    @Column(name = "tablis_nom_03")
    private String tablisNom03;

    /**
     * nom de la colonne 4
     */
    @Column(name = "tablis_nom_04")
    private String tablisNom04;

    /**
     * nom de la colonne 5
     */
    @Column(name = "tablis_nom_05")
    private String tablisNom05;

    /**
     * nom de la colonne 6
     */
    @Column(name = "tablis_nom_06")
    private String tablisNom06;

    /**
     * nom de la colonne 7
     */
    @Column(name = "tablis_nom_07")
    private String tablisNom07;

    /**
     * nom de la colonne 8
     */
    @Column(name = "tablis_nom_08")
    private String tablisNom08;

    /**
     * nom de la colonne 9
     */
    @Column(name = "tablis_nom_09")
    private String tablisNom09;

    /**
     * nom de la colonne 10
     */
    @Column(name = "tablis_nom_10")
    private String tablisNom10;

    /**
     * nom de la colonne 11
     */
    @Column(name = "tablis_nom_11")
    private String tablisNom11;

    /**
     * nom de la colonne 12
     */
    @Column(name = "tablis_nom_12")
    private String tablisNom12;

    /**
     * nom de la colonne 13
     */
    @Column(name = "tablis_nom_13")
    private String tablisNom13;

    /**
     * nom de la colonne 14
     */
    @Column(name = "tablis_nom_14")
    private String tablisNom14;

    /**
     * nom de la colonne 15
     */
    @Column(name = "tablis_nom_15")
    private String tablisNom15;

    /**
     * nom de la colonne 16
     */
    @Column(name = "tablis_nom_16")
    private String tablisNom16;

    /**
     * nom de la colonne 17
     */
    @Column(name = "tablis_nom_17")
    private String tablisNom17;

    /**
     * nom de la colonne 18
     */
    @Column(name = "tablis_nom_18")
    private String tablisNom18;

    /**
     * nom de la colonne 19
     */
    @Column(name = "tablis_nom_19")
    private String tablisNom19;

    /**
     * nom de la colonne 20
     */
    @Column(name = "tablis_nom_20")
    private String tablisNom20;

    /**
     * l ancien id de tabnom
     */
    @Column(name = "tablis_old_id")
    private Long tablisOldId = 0L;

    /**
     * type de la colonne 01
     */
    @Column(name = "tablis_type_col01")
    private Integer tablisTypeCol01 = 0;

    /**
     * type de la colonne 02
     */
    @Column(name = "tablis_type_col02")
    private Integer tablisTypeCol02 = 0;

    /**
     * type de la colonne 03
     */
    @Column(name = "tablis_type_col03")
    private Integer tablisTypeCol03 = 0;

    /**
     * type de la colonne 04
     */
    @Column(name = "tablis_type_col04")
    private Integer tablisTypeCol04 = 0;

    /**
     * type de la colonne 05
     */
    @Column(name = "tablis_type_col05")
    private Integer tablisTypeCol05 = 0;

    /**
     * type de la colonne 06
     */
    @Column(name = "tablis_type_col06")
    private Integer tablisTypeCol06 = 0;

    /**
     * type de la colonne 07
     */
    @Column(name = "tablis_type_col07")
    private Integer tablisTypeCol07 = 0;

    /**
     * type de la colonne 08
     */
    @Column(name = "tablis_type_col08")
    private Integer tablisTypeCol08 = 0;

    /**
     * type de la colonne 09
     */
    @Column(name = "tablis_type_col09")
    private Integer tablisTypeCol09 = 0;

    /**
     * type de la colonne 10
     */
    @Column(name = "tablis_type_col10")
    private Integer tablisTypeCol10 = 0;

    /**
     * type de la colonne 11
     */
    @Column(name = "tablis_type_col11")
    private Integer tablisTypeCol11 = 0;

    /**
     * type de la colonne 12
     */
    @Column(name = "tablis_type_col12")
    private Integer tablisTypeCol12 = 0;

    /**
     * type de la colonne 13
     */
    @Column(name = "tablis_type_col13")
    private Integer tablisTypeCol13 = 0;

    /**
     * type de la colonne 14
     */
    @Column(name = "tablis_type_col14")
    private Integer tablisTypeCol14 = 0;

    /**
     * type de la colonne 15
     */
    @Column(name = "tablis_type_col15")
    private Integer tablisTypeCol15 = 0;

    /**
     * type de la colonne 16
     */
    @Column(name = "tablis_type_col16")
    private Integer tablisTypeCol16 = 0;

    /**
     * type de la colonne 17
     */
    @Column(name = "tablis_type_col17")
    private Integer tablisTypeCol17 = 0;

    /**
     * type de la colonne 18
     */
    @Column(name = "tablis_type_col18")
    private Integer tablisTypeCol18 = 0;

    /**
     * type de la colonne 19
     */
    @Column(name = "tablis_type_col19")
    private Integer tablisTypeCol19 = 0;

    /**
     * type de la colonne 20
     */
    @Column(name = "tablis_type_col20")
    private Integer tablisTypeCol20 = 0;

    /**
     * format 0=monnaie 1=% 2=quantite de la colonne 01
     */
    @Column(name = "tablis_format_col01")
    private Integer tablisFormatCol01 = 0;

    /**
     * format de la colonne 02
     */
    @Column(name = "tablis_format_col02")
    private Integer tablisFormatCol02 = 0;

    /**
     * format de la colonne 03
     */
    @Column(name = "tablis_format_col03")
    private Integer tablisFormatCol03 = 0;

    /**
     * format de la colonne 04
     */
    @Column(name = "tablis_format_col04")
    private Integer tablisFormatCol04 = 0;

    /**
     * format de la colonne 05
     */
    @Column(name = "tablis_format_col05")
    private Integer tablisFormatCol05 = 0;

    /**
     * format de la colonne 06
     */
    @Column(name = "tablis_format_col06")
    private Integer tablisFormatCol06 = 0;

    /**
     * format de la colonne 07
     */
    @Column(name = "tablis_format_col07")
    private Integer tablisFormatCol07 = 0;

    /**
     * format de la colonne 08
     */
    @Column(name = "tablis_format_col08")
    private Integer tablisFormatCol08 = 0;

    /**
     * format de la colonne 09
     */
    @Column(name = "tablis_format_col09")
    private Integer tablisFormatCol09 = 0;

    /**
     * format de la colonne 10
     */
    @Column(name = "tablis_format_col10")
    private Integer tablisFormatCol10 = 0;

    /**
     * format de la colonne 11
     */
    @Column(name = "tablis_format_col11")
    private Integer tablisFormatCol11 = 0;

    /**
     * format de la colonne 12
     */
    @Column(name = "tablis_format_col12")
    private Integer tablisFormatCol12 = 0;

    /**
     * format de la colonne 13
     */
    @Column(name = "tablis_format_col13")
    private Integer tablisFormatCol13 = 0;

    /**
     * format de la colonne 14
     */
    @Column(name = "tablis_format_col14")
    private Integer tablisFormatCol14 = 0;

    /**
     * format de la colonne 15
     */
    @Column(name = "tablis_format_col15")
    private Integer tablisFormatCol15 = 0;

    /**
     * format de la colonne 16
     */
    @Column(name = "tablis_format_col16")
    private Integer tablisFormatCol16 = 0;

    /**
     * format de la colonne 17
     */
    @Column(name = "tablis_format_col17")
    private Integer tablisFormatCol17 = 0;

    /**
     * format de la colonne 18
     */
    @Column(name = "tablis_format_col18")
    private Integer tablisFormatCol18 = 0;

    /**
     * format de la colonne 19
     */
    @Column(name = "tablis_format_col19")
    private Integer tablisFormatCol19 = 0;

    /**
     * format de la colonne 20
     */
    @Column(name = "tablis_format_col20")
    private Integer tablisFormatCol20 = 0;

}
