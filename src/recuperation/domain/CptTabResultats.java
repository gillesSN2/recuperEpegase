package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cpt_tab_resultats")
public class CptTabResultats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tabres_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tabresId;

    /**
     * code du tableau
     */
    @Column(name = "tabres_code")
    private String tabresCode;

    /**
     * libelle tableau en fr
     */
    @Column(name = "tabres_nom_FR")
    private String tabresNomFr;

    /**
     * libelle tableau en uk
     */
    @Column(name = "tabres_nom_UK")
    private String tabresNomUk;

    /**
     * libelle tableau en sp
     */
    @Column(name = "tabres_nom_SP")
    private String tabresNomSp;

    /**
     * annee
     */
    @Column(name = "tabres_annee")
    private Long tabresAnnee = 0L;

    /**
     * date debut de calcul
     */
    @Column(name = "tabres_date_deb")
    private LocalDate tabresDateDeb;

    /**
     * date fin de calcul
     */
    @Column(name = "tabres_date_fin")
    private LocalDate tabresDateFin;

    /**
     * id element du tableau
     */
    @Column(name = "tabres_id_element")
    private Long tabresIdElement = 0L;

    /**
     * nb mois de la periode
     */
    @Column(name = "tabres_nb_mois")
    private Integer tabresNbMois = 0;

    /**
     * 0=sans situation 1=avec situation
     */
    @Column(name = "tabres_jr_sit")
    private Integer tabresJrSit = 0;

    /**
     * 0=sans reserve 1=avec reserve
     */
    @Column(name = "tabres_jr_rv")
    private Integer tabresJrRv = 0;

    /**
     * reference ligne
     */
    @Column(name = "tabres_reference")
    private String tabresReference;

    /**
     * libelle ligne en fr
     */
    @Column(name = "tabres_lib_FR")
    private String tabresLibFr;

    /**
     * libelle ligne en uk
     */
    @Column(name = "tabres_lib_UK")
    private String tabresLibUk;

    /**
     * libelle ligne en sp
     */
    @Column(name = "tabres_lib_SP")
    private String tabresLibSp;

    /**
     * numero ligne
     */
    @Column(name = "tabres_num")
    private Integer tabresNum = 0;

    /**
     * 0=titre principal 1=titre secondaire 2=sous titre 3=calcul 4=saisie 5=total sous titre 6=total secondaire 7=total principal
     */
    @Column(name = "tabres_type")
    private Integer tabresType = 0;

    /**
     * 0=resultat normal 1=resultat intermediaire
     */
    @Column(name = "tabres_mode")
    private Integer tabresMode = 0;

    /**
     * 0=imprimable 1=non imprimable
     */
    @Column(name = "tabres_print")
    private Integer tabresPrint = 0;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_01")
    private Double tabresCol01 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_02")
    private Double tabresCol02 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_03")
    private Double tabresCol03 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_04")
    private Double tabresCol04 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_05")
    private Double tabresCol05 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_06")
    private Double tabresCol06 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_07")
    private Double tabresCol07 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_08")
    private Double tabresCol08 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_09")
    private Double tabresCol09 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_10")
    private Double tabresCol10 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_11")
    private Double tabresCol11 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_12")
    private Double tabresCol12 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_13")
    private Double tabresCol13 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_14")
    private Double tabresCol14 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_15")
    private Double tabresCol15 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_16")
    private Double tabresCol16 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_17")
    private Double tabresCol17 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_18")
    private Double tabresCol18 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_19")
    private Double tabresCol19 = 0D;

    /**
     * resultat numerique
     */
    @Column(name = "tabres_col_20")
    private Double tabresCol20 = 0D;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_01")
    private String tabresCon01;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_02")
    private String tabresCon02;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_03")
    private String tabresCon03;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_04")
    private String tabresCon04;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_05")
    private String tabresCon05;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_06")
    private String tabresCon06;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_07")
    private String tabresCon07;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_08")
    private String tabresCon08;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_09")
    private String tabresCon09;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_10")
    private String tabresCon10;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_11")
    private String tabresCon11;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_12")
    private String tabresCon12;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_13")
    private String tabresCon13;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_14")
    private String tabresCon14;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_15")
    private String tabresCon15;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_16")
    private String tabresCon16;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_17")
    private String tabresCon17;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_18")
    private String tabresCon18;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_19")
    private String tabresCon19;

    /**
     * resultat texte
     */
    @Column(name = "tabres_con_20")
    private String tabresCon20;

    /**
     * type de la colonne 01
     */
    @Column(name = "tabres_type_col01")
    private Integer tabresTypeCol01 = 0;

    /**
     * type de la colonne 02
     */
    @Column(name = "tabres_type_col02")
    private Integer tabresTypeCol02 = 0;

    /**
     * type de la colonne 03
     */
    @Column(name = "tabres_type_col03")
    private Integer tabresTypeCol03 = 0;

    /**
     * type de la colonne 04
     */
    @Column(name = "tabres_type_col04")
    private Integer tabresTypeCol04 = 0;

    /**
     * type de la colonne 05
     */
    @Column(name = "tabres_type_col05")
    private Integer tabresTypeCol05 = 0;

    /**
     * type de la colonne 06
     */
    @Column(name = "tabres_type_col06")
    private Integer tabresTypeCol06 = 0;

    /**
     * type de la colonne 07
     */
    @Column(name = "tabres_type_col07")
    private Integer tabresTypeCol07 = 0;

    /**
     * type de la colonne 08
     */
    @Column(name = "tabres_type_col08")
    private Integer tabresTypeCol08 = 0;

    /**
     * type de la colonne 09
     */
    @Column(name = "tabres_type_col09")
    private Integer tabresTypeCol09 = 0;

    /**
     * type de la colonne 10
     */
    @Column(name = "tabres_type_col10")
    private Integer tabresTypeCol10 = 0;

    /**
     * type de la colonne 11
     */
    @Column(name = "tabres_type_col11")
    private Integer tabresTypeCol11 = 0;

    /**
     * type de la colonne 12
     */
    @Column(name = "tabres_type_col12")
    private Integer tabresTypeCol12 = 0;

    /**
     * type de la colonne 13
     */
    @Column(name = "tabres_type_col13")
    private Integer tabresTypeCol13 = 0;

    /**
     * type de la colonne 14
     */
    @Column(name = "tabres_type_col14")
    private Integer tabresTypeCol14 = 0;

    /**
     * type de la colonne 15
     */
    @Column(name = "tabres_type_col15")
    private Integer tabresTypeCol15 = 0;

    /**
     * type de la colonne 16
     */
    @Column(name = "tabres_type_col16")
    private Integer tabresTypeCol16 = 0;

    /**
     * type de la colonne 17
     */
    @Column(name = "tabres_type_col17")
    private Integer tabresTypeCol17 = 0;

    /**
     * type de la colonne 18
     */
    @Column(name = "tabres_type_col18")
    private Integer tabresTypeCol18 = 0;

    /**
     * type de la colonne 19
     */
    @Column(name = "tabres_type_col19")
    private Integer tabresTypeCol19 = 0;

    /**
     * type de la colonne 20
     */
    @Column(name = "tabres_type_col20")
    private Integer tabresTypeCol20 = 0;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

    /**
     * format de la colonne 01
     */
    @Column(name = "tabres_format_col01")
    private Integer tabresFormatCol01 = 0;

    /**
     * format de la colonne 02
     */
    @Column(name = "tabres_format_col02")
    private Integer tabresFormatCol02 = 0;

    /**
     * format de la colonne 03
     */
    @Column(name = "tabres_format_col03")
    private Integer tabresFormatCol03 = 0;

    /**
     * format de la colonne 04
     */
    @Column(name = "tabres_format_col04")
    private Integer tabresFormatCol04 = 0;

    /**
     * format de la colonne 05
     */
    @Column(name = "tabres_format_col05")
    private Integer tabresFormatCol05 = 0;

    /**
     * format de la colonne 06
     */
    @Column(name = "tabres_format_col06")
    private Integer tabresFormatCol06 = 0;

    /**
     * format de la colonne 07
     */
    @Column(name = "tabres_format_col07")
    private Integer tabresFormatCol07 = 0;

    /**
     * format de la colonne 08
     */
    @Column(name = "tabres_format_col08")
    private Integer tabresFormatCol08 = 0;

    /**
     * format de la colonne 09
     */
    @Column(name = "tabres_format_col09")
    private Integer tabresFormatCol09 = 0;

    /**
     * format de la colonne 10
     */
    @Column(name = "tabres_format_col10")
    private Integer tabresFormatCol10 = 0;

    /**
     * format de la colonne 11
     */
    @Column(name = "tabres_format_col11")
    private Integer tabresFormatCol11 = 0;

    /**
     * format de la colonne 12
     */
    @Column(name = "tabres_format_col12")
    private Integer tabresFormatCol12 = 0;

    /**
     * format de la colonne 13
     */
    @Column(name = "tabres_format_col13")
    private Integer tabresFormatCol13 = 0;

    /**
     * format de la colonne 14
     */
    @Column(name = "tabres_format_col14")
    private Integer tabresFormatCol14 = 0;

    /**
     * format de la colonne 15
     */
    @Column(name = "tabres_format_col15")
    private Integer tabresFormatCol15 = 0;

    /**
     * format de la colonne 16
     */
    @Column(name = "tabres_format_col16")
    private Integer tabresFormatCol16 = 0;

    /**
     * format de la colonne 17
     */
    @Column(name = "tabres_format_col17")
    private Integer tabresFormatCol17 = 0;

    /**
     * format de la colonne 18
     */
    @Column(name = "tabres_format_col18")
    private Integer tabresFormatCol18 = 0;

    /**
     * format de la colonne 19
     */
    @Column(name = "tabres_format_col19")
    private Integer tabresFormatCol19 = 0;

    /**
     * format de la colonne 20
     */
    @Column(name = "tabres_format_col20")
    private Integer tabresFormatCol20 = 0;

    /**
     * 0=resultat en instance affectation 1=resultat affecte
     */
    @Column(name = "tabres_resultat_affecte")
    private Integer tabresResultatAffecte = 0;

}
