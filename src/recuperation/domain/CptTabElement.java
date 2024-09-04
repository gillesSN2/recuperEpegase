package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_tab_element")
public class CptTabElement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tabele_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tabeleId;

    /**
     * zone fiscale du tableau
     */
    @Column(name = "tabele_zone")
    private String tabeleZone;

    /**
     * reference de la ligne
     */
    @Column(name = "tabele_reference")
    private String tabeleReference;

    /**
     * nom element en fr
     */
    @Column(name = "tabele_lib_FR")
    private String tabeleLibFr;

    /**
     * nom element en uk
     */
    @Column(name = "tabele_lib_UK")
    private String tabeleLibUk;

    /**
     * nom element en sp
     */
    @Column(name = "tabele_lib_SP")
    private String tabeleLibSp;

    /**
     * numero de la ligne
     */
    @Column(name = "tabele_num")
    private Integer tabeleNum = 0;

    /**
     * 0=titre principal 1=titre secondaire 2=sous titre 3=calcul/saisie 4=total sous titre 5=total secondaire 6=total principal
     */
    @Column(name = "tabele_type")
    private Integer tabeleType = 0;

    /**
     * 0=resultat normal 1=resultat intermediaire
     */
    @Column(name = "tabele_mode")
    private Integer tabeleMode = 0;

    /**
     * 0=imprimable 1=non imprimable
     */
    @Column(name = "tabele_print")
    private Integer tabelePrint = 0;

    /**
     * 0=defaut 1=monnaie 2=% 3=quantite
     */
    @Column(name = "tabele_nature")
    private Integer tabeleNature = 0;

    /**
     * l ancien cle etrangere de pegTabNom
     */
    @Column(name = "tablis_old_id")
    private Long tablisOldId = 0L;

    /**
     * l ancien id de l element
     */
    @Column(name = "tabele_old_id")
    private Long tabeleOldId = 0L;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "tabele_inactif")
    private Boolean tabeleInactif = Boolean.FALSE;

    /**
     * type de la colonne 01
     */
    @Column(name = "tabele_type_col01")
    private Integer tabeleTypeCol01 = 0;

    /**
     * type de la colonne 02
     */
    @Column(name = "tabele_type_col02")
    private Integer tabeleTypeCol02 = 0;

    /**
     * type de la colonne 03
     */
    @Column(name = "tabele_type_col03")
    private Integer tabeleTypeCol03 = 0;

    /**
     * type de la colonne 04
     */
    @Column(name = "tabele_type_col04")
    private Integer tabeleTypeCol04 = 0;

    /**
     * type de la colonne 05
     */
    @Column(name = "tabele_type_col05")
    private Integer tabeleTypeCol05 = 0;

    /**
     * type de la colonne 06
     */
    @Column(name = "tabele_type_col06")
    private Integer tabeleTypeCol06 = 0;

    /**
     * type de la colonne 07
     */
    @Column(name = "tabele_type_col07")
    private Integer tabeleTypeCol07 = 0;

    /**
     * type de la colonne 08
     */
    @Column(name = "tabele_type_col08")
    private Integer tabeleTypeCol08 = 0;

    /**
     * type de la colonne 09
     */
    @Column(name = "tabele_type_col09")
    private Integer tabeleTypeCol09 = 0;

    /**
     * type de la colonne 10
     */
    @Column(name = "tabele_type_col10")
    private Integer tabeleTypeCol10 = 0;

    /**
     * type de la colonne 11
     */
    @Column(name = "tabele_type_col11")
    private Integer tabeleTypeCol11 = 0;

    /**
     * type de la colonne 12
     */
    @Column(name = "tabele_type_col12")
    private Integer tabeleTypeCol12 = 0;

    /**
     * type de la colonne 13
     */
    @Column(name = "tabele_type_col13")
    private Integer tabeleTypeCol13 = 0;

    /**
     * type de la colonne 14
     */
    @Column(name = "tabele_type_col14")
    private Integer tabeleTypeCol14 = 0;

    /**
     * type de la colonne 15
     */
    @Column(name = "tabele_type_col15")
    private Integer tabeleTypeCol15 = 0;

    /**
     * type de la colonne 16
     */
    @Column(name = "tabele_type_col16")
    private Integer tabeleTypeCol16 = 0;

    /**
     * type de la colonne 17
     */
    @Column(name = "tabele_type_col17")
    private Integer tabeleTypeCol17 = 0;

    /**
     * type de la colonne 18
     */
    @Column(name = "tabele_type_col18")
    private Integer tabeleTypeCol18 = 0;

    /**
     * type de la colonne 19
     */
    @Column(name = "tabele_type_col19")
    private Integer tabeleTypeCol19 = 0;

    /**
     * type de la colonne 20
     */
    @Column(name = "tabele_type_col20")
    private Integer tabeleTypeCol20 = 0;

    @Column(name = "tablis_id", nullable = false)
    private Long tablisId;

    /**
     * format 0=monnaie 1=% 2=quantite
     */
    @Column(name = "tabele_format_cel01")
    private Integer tabeleFormatCel01 = 0;

    /**
     * format 0=monnaie 1=% 2=quantite
     */
    @Column(name = "tabele_format_cel02")
    private Integer tabeleFormatCel02 = 0;

    /**
     * format 0=monnaie 1=% 2=quantite
     */
    @Column(name = "tabele_format_cel03")
    private Integer tabeleFormatCel03 = 0;

    /**
     * format de la colonne 04
     */
    @Column(name = "tabele_format_cel04")
    private Integer tabeleFormatCel04 = 0;

    /**
     * format de la colonne 05
     */
    @Column(name = "tabele_format_cel05")
    private Integer tabeleFormatCel05 = 0;

    /**
     * format de la colonne 06
     */
    @Column(name = "tabele_format_cel06")
    private Integer tabeleFormatCel06 = 0;

    /**
     * format de la colonne 07
     */
    @Column(name = "tabele_format_cel07")
    private Integer tabeleFormatCel07 = 0;

    /**
     * format de la colonne 08
     */
    @Column(name = "tabele_format_cel08")
    private Integer tabeleFormatCel08 = 0;

    /**
     * format de la colonne 09
     */
    @Column(name = "tabele_format_cel09")
    private Integer tabeleFormatCel09 = 0;

    /**
     * format de la colonne 10
     */
    @Column(name = "tabele_format_cel10")
    private Integer tabeleFormatCel10 = 0;

    /**
     * format de la colonne 11
     */
    @Column(name = "tabele_format_cel11")
    private Integer tabeleFormatCel11 = 0;

    /**
     * format de la colonne 12
     */
    @Column(name = "tabele_format_cel12")
    private Integer tabeleFormatCel12 = 0;

    /**
     * format de la colonne 13
     */
    @Column(name = "tabele_format_cel13")
    private Integer tabeleFormatCel13 = 0;

    /**
     * format de la colonne 14
     */
    @Column(name = "tabele_format_cel14")
    private Integer tabeleFormatCel14 = 0;

    /**
     * format de la colonne 15
     */
    @Column(name = "tabele_format_cel15")
    private Integer tabeleFormatCel15 = 0;

    /**
     * format de la colonne 16
     */
    @Column(name = "tabele_format_cel16")
    private Integer tabeleFormatCel16 = 0;

    /**
     * format de la colonne 17
     */
    @Column(name = "tabele_format_cel17")
    private Integer tabeleFormatCel17 = 0;

    /**
     * format de la colonne 18
     */
    @Column(name = "tabele_format_cel18")
    private Integer tabeleFormatCel18 = 0;

    /**
     * format de la colonne 19
     */
    @Column(name = "tabele_format_cel19")
    private Integer tabeleFormatCel19 = 0;

    /**
     * format de la colonne 20
     */
    @Column(name = "tabele_format_cel20")
    private Integer tabeleFormatCel20 = 0;

}
