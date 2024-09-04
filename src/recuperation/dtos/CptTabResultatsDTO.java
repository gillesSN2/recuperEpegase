package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CptTabResultatsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long tabresId;


    /**
     * code du tableau
     */
    private String tabresCode;


    /**
     * libelle tableau en fr
     */
    private String tabresNomFr;


    /**
     * libelle tableau en uk
     */
    private String tabresNomUk;


    /**
     * libelle tableau en sp
     */
    private String tabresNomSp;


    /**
     * annee
     */
    private Long tabresAnnee;


    /**
     * date debut de calcul
     */
    private LocalDate tabresDateDeb;


    /**
     * date fin de calcul
     */
    private LocalDate tabresDateFin;


    /**
     * id element du tableau
     */
    private Long tabresIdElement;


    /**
     * nb mois de la periode
     */
    private Integer tabresNbMois;


    /**
     * 0=sans situation 1=avec situation
     */
    private Integer tabresJrSit;


    /**
     * 0=sans reserve 1=avec reserve
     */
    private Integer tabresJrRv;


    /**
     * reference ligne
     */
    private String tabresReference;


    /**
     * libelle ligne en fr
     */
    private String tabresLibFr;


    /**
     * libelle ligne en uk
     */
    private String tabresLibUk;


    /**
     * libelle ligne en sp
     */
    private String tabresLibSp;


    /**
     * numero ligne
     */
    private Integer tabresNum;


    /**
     * 0=titre principal 1=titre secondaire 2=sous titre 3=calcul 4=saisie 5=total sous titre 6=total secondaire 7=total principal
     */
    private Integer tabresType;


    /**
     * 0=resultat normal 1=resultat intermediaire
     */
    private Integer tabresMode;


    /**
     * 0=imprimable 1=non imprimable
     */
    private Integer tabresPrint;


    /**
     * resultat numerique
     */
    private Double tabresCol01;


    /**
     * resultat numerique
     */
    private Double tabresCol02;


    /**
     * resultat numerique
     */
    private Double tabresCol03;


    /**
     * resultat numerique
     */
    private Double tabresCol04;


    /**
     * resultat numerique
     */
    private Double tabresCol05;


    /**
     * resultat numerique
     */
    private Double tabresCol06;


    /**
     * resultat numerique
     */
    private Double tabresCol07;


    /**
     * resultat numerique
     */
    private Double tabresCol08;


    /**
     * resultat numerique
     */
    private Double tabresCol09;


    /**
     * resultat numerique
     */
    private Double tabresCol10;


    /**
     * resultat numerique
     */
    private Double tabresCol11;


    /**
     * resultat numerique
     */
    private Double tabresCol12;


    /**
     * resultat numerique
     */
    private Double tabresCol13;


    /**
     * resultat numerique
     */
    private Double tabresCol14;


    /**
     * resultat numerique
     */
    private Double tabresCol15;


    /**
     * resultat numerique
     */
    private Double tabresCol16;


    /**
     * resultat numerique
     */
    private Double tabresCol17;


    /**
     * resultat numerique
     */
    private Double tabresCol18;


    /**
     * resultat numerique
     */
    private Double tabresCol19;


    /**
     * resultat numerique
     */
    private Double tabresCol20;


    /**
     * resultat texte
     */
    private String tabresCon01;


    /**
     * resultat texte
     */
    private String tabresCon02;


    /**
     * resultat texte
     */
    private String tabresCon03;


    /**
     * resultat texte
     */
    private String tabresCon04;


    /**
     * resultat texte
     */
    private String tabresCon05;


    /**
     * resultat texte
     */
    private String tabresCon06;


    /**
     * resultat texte
     */
    private String tabresCon07;


    /**
     * resultat texte
     */
    private String tabresCon08;


    /**
     * resultat texte
     */
    private String tabresCon09;


    /**
     * resultat texte
     */
    private String tabresCon10;


    /**
     * resultat texte
     */
    private String tabresCon11;


    /**
     * resultat texte
     */
    private String tabresCon12;


    /**
     * resultat texte
     */
    private String tabresCon13;


    /**
     * resultat texte
     */
    private String tabresCon14;


    /**
     * resultat texte
     */
    private String tabresCon15;


    /**
     * resultat texte
     */
    private String tabresCon16;


    /**
     * resultat texte
     */
    private String tabresCon17;


    /**
     * resultat texte
     */
    private String tabresCon18;


    /**
     * resultat texte
     */
    private String tabresCon19;


    /**
     * resultat texte
     */
    private String tabresCon20;


    /**
     * type de la colonne 01
     */
    private Integer tabresTypeCol01;


    /**
     * type de la colonne 02
     */
    private Integer tabresTypeCol02;


    /**
     * type de la colonne 03
     */
    private Integer tabresTypeCol03;


    /**
     * type de la colonne 04
     */
    private Integer tabresTypeCol04;


    /**
     * type de la colonne 05
     */
    private Integer tabresTypeCol05;


    /**
     * type de la colonne 06
     */
    private Integer tabresTypeCol06;


    /**
     * type de la colonne 07
     */
    private Integer tabresTypeCol07;


    /**
     * type de la colonne 08
     */
    private Integer tabresTypeCol08;


    /**
     * type de la colonne 09
     */
    private Integer tabresTypeCol09;


    /**
     * type de la colonne 10
     */
    private Integer tabresTypeCol10;


    /**
     * type de la colonne 11
     */
    private Integer tabresTypeCol11;


    /**
     * type de la colonne 12
     */
    private Integer tabresTypeCol12;


    /**
     * type de la colonne 13
     */
    private Integer tabresTypeCol13;


    /**
     * type de la colonne 14
     */
    private Integer tabresTypeCol14;


    /**
     * type de la colonne 15
     */
    private Integer tabresTypeCol15;


    /**
     * type de la colonne 16
     */
    private Integer tabresTypeCol16;


    /**
     * type de la colonne 17
     */
    private Integer tabresTypeCol17;


    /**
     * type de la colonne 18
     */
    private Integer tabresTypeCol18;


    /**
     * type de la colonne 19
     */
    private Integer tabresTypeCol19;


    /**
     * type de la colonne 20
     */
    private Integer tabresTypeCol20;

    private Long execptId;


    /**
     * format de la colonne 01
     */
    private Integer tabresFormatCol01;


    /**
     * format de la colonne 02
     */
    private Integer tabresFormatCol02;


    /**
     * format de la colonne 03
     */
    private Integer tabresFormatCol03;


    /**
     * format de la colonne 04
     */
    private Integer tabresFormatCol04;


    /**
     * format de la colonne 05
     */
    private Integer tabresFormatCol05;


    /**
     * format de la colonne 06
     */
    private Integer tabresFormatCol06;


    /**
     * format de la colonne 07
     */
    private Integer tabresFormatCol07;


    /**
     * format de la colonne 08
     */
    private Integer tabresFormatCol08;


    /**
     * format de la colonne 09
     */
    private Integer tabresFormatCol09;


    /**
     * format de la colonne 10
     */
    private Integer tabresFormatCol10;


    /**
     * format de la colonne 11
     */
    private Integer tabresFormatCol11;


    /**
     * format de la colonne 12
     */
    private Integer tabresFormatCol12;


    /**
     * format de la colonne 13
     */
    private Integer tabresFormatCol13;


    /**
     * format de la colonne 14
     */
    private Integer tabresFormatCol14;


    /**
     * format de la colonne 15
     */
    private Integer tabresFormatCol15;


    /**
     * format de la colonne 16
     */
    private Integer tabresFormatCol16;


    /**
     * format de la colonne 17
     */
    private Integer tabresFormatCol17;


    /**
     * format de la colonne 18
     */
    private Integer tabresFormatCol18;


    /**
     * format de la colonne 19
     */
    private Integer tabresFormatCol19;


    /**
     * format de la colonne 20
     */
    private Integer tabresFormatCol20;


    /**
     * 0=resultat en instance affectation 1=resultat affecte
     */
    private Integer tabresResultatAffecte;

}
