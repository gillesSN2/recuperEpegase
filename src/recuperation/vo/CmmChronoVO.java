package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class CmmChronoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "chrId can not null")
    private Long chrId;


    /**
     * 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=valorisation 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer chrNature;


    /**
     * code serie ou nature salarie
     */
    private String chrSerie;


    /**
     * nom de la serie
     */
    private String chrNom;


    /**
     * 0=public 1=prive
     */
    private Integer chrPrive;


    /**
     * code du service
     */
    private String chrService;


    /**
     * nombre de caractere
     */
    private Integer chrNbCar;


    /**
     * mode 0=chrono annuel 1=chrono mensuel 2=chrono continu
     */
    private Integer chrMode;


    /**
     * format 0=chrono simple 1=MM+chrono 2=MM+AA+chrono 3=chrono/AA 4=chrono/MMAA
     */
    private Integer chrFormat;


    /**
     * prefixe
     */
    private String chrPrefixe;


    /**
     * numero normal
     */
    private Long chrNum;


    /**
     * numero annuel
     */
    private Long chrNumAn;


    /**
     * numero janvier
     */
    private Long chrNum01;


    /**
     * numero fevrier
     */
    private Long chrNum02;


    /**
     * numero mars
     */
    private Long chrNum03;


    /**
     * numero avril
     */
    private Long chrNum04;


    /**
     * numero mai
     */
    private Long chrNum05;


    /**
     * numero juin
     */
    private Long chrNum06;


    /**
     * numero juillet
     */
    private Long chrNum07;


    /**
     * numero aout
     */
    private Long chrNum08;


    /**
     * numero septembre
     */
    private Long chrNum09;


    /**
     * numero octobre
     */
    private Long chrNum10;


    /**
     * numero novembre
     */
    private Long chrNum11;


    /**
     * numero decembre
     */
    private Long chrNum12;


    /**
     * sufixe
     */
    private String chrSufixe;


    /**
     * code journal comptable
     */
    private String chrJournal;


    /**
     * Periode
     */
    private String chrPeriode;


    /**
     * numero continue
     */
    private Long chrNum1;


    /**
     * numero annuel
     */
    private Long chrNumAn1;


    /**
     * numero janvier
     */
    private Long chrNum011;


    /**
     * numero fevrier
     */
    private Long chrNum021;


    /**
     * numero mars
     */
    private Long chrNum031;


    /**
     * numero avril
     */
    private Long chrNum041;


    /**
     * numero mai
     */
    private Long chrNum051;


    /**
     * numero juin
     */
    private Long chrNum061;


    /**
     * numero juillet
     */
    private Long chrNum071;


    /**
     * numero aout
     */
    private Long chrNum081;


    /**
     * numero septembre
     */
    private Long chrNum091;


    /**
     * numero octobre
     */
    private Long chrNum101;


    /**
     * numero novembre
     */
    private Long chrNum111;


    /**
     * numero decembre
     */
    private Long chrNum121;


    /**
     * prefixe
     */
    private String chrPrefixe1;


    /**
     * sufixe
     */
    private String chrSufixe1;


    /**
     * numero continue
     */
    private Long chrNum2;


    /**
     * numero annuel
     */
    private Long chrNumAn2;


    /**
     * numero janvier
     */
    private Long chrNum012;


    /**
     * numero fevrier
     */
    private Long chrNum022;


    /**
     * numero mars
     */
    private Long chrNum032;


    /**
     * numero avril
     */
    private Long chrNum042;


    /**
     * numero mai
     */
    private Long chrNum052;


    /**
     * numero juin
     */
    private Long chrNum062;


    /**
     * numero juillet
     */
    private Long chrNum072;


    /**
     * numero aout
     */
    private Long chrNum082;


    /**
     * numero septembre
     */
    private Long chrNum092;


    /**
     * numero octobre
     */
    private Long chrNum102;


    /**
     * numero novembre
     */
    private Long chrNum112;


    /**
     * numero decembre
     */
    private Long chrNum122;


    /**
     * prefixe
     */
    private String chrPrefixe2;


    /**
     * sufixe
     */
    private String chrSufixe2;


    /**
     * numero continue
     */
    private Long chrNum3;


    /**
     * numero annuel
     */
    private Long chrNumAn3;


    /**
     * numero janvier
     */
    private Long chrNum013;


    /**
     * numero fevrier
     */
    private Long chrNum023;


    /**
     * numero mars
     */
    private Long chrNum033;


    /**
     * numero avril
     */
    private Long chrNum043;


    /**
     * numero mai
     */
    private Long chrNum053;


    /**
     * numero juin
     */
    private Long chrNum063;


    /**
     * numero juillet
     */
    private Long chrNum073;


    /**
     * numero aout
     */
    private Long chrNum083;


    /**
     * numero septembre
     */
    private Long chrNum093;


    /**
     * numero octobre
     */
    private Long chrNum103;


    /**
     * numero novembre
     */
    private Long chrNum113;


    /**
     * numero decembre
     */
    private Long chrNum123;


    /**
     * prefixe
     */
    private String chrPrefixe3;


    /**
     * sufixe
     */
    private String chrSufixe3;


    /**
     * numero continue
     */
    private Long chrNum4;


    /**
     * numero annuel
     */
    private Long chrNumAn4;


    /**
     * numero janvier
     */
    private Long chrNum014;


    /**
     * numero fevrier
     */
    private Long chrNum024;


    /**
     * numero mars
     */
    private Long chrNum034;


    /**
     * numero avril
     */
    private Long chrNum044;


    /**
     * numero mai
     */
    private Long chrNum054;


    /**
     * numero juin
     */
    private Long chrNum064;


    /**
     * numero juillet
     */
    private Long chrNum074;


    /**
     * numero aout
     */
    private Long chrNum084;


    /**
     * numero septembre
     */
    private Long chrNum094;


    /**
     * numero octobre
     */
    private Long chrNum104;


    /**
     * numero novembre
     */
    private Long chrNum114;


    /**
     * numero decembre
     */
    private Long chrNum124;


    /**
     * prefixe
     */
    private String chrPrefixe4;


    /**
     * sufixe
     */
    private String chrSufixe4;


    /**
     * numero continue
     */
    private Long chrNum5;


    /**
     * numero annuel
     */
    private Long chrNumAn5;


    /**
     * numero janvier
     */
    private Long chrNum015;


    /**
     * numero fevrier
     */
    private Long chrNum025;


    /**
     * numero mars
     */
    private Long chrNum035;


    /**
     * numero avril
     */
    private Long chrNum045;


    /**
     * numero mai
     */
    private Long chrNum055;


    /**
     * numero juin
     */
    private Long chrNum065;


    /**
     * numero juillet
     */
    private Long chrNum075;


    /**
     * numero aout
     */
    private Long chrNum085;


    /**
     * numero septembre
     */
    private Long chrNum095;


    /**
     * numero octobre
     */
    private Long chrNum105;


    /**
     * numero novembre
     */
    private Long chrNum115;


    /**
     * numero decembre
     */
    private Long chrNum125;


    /**
     * prefixe
     */
    private String chrPrefixe5;


    /**
     * sufixe
     */
    private String chrSufixe5;


    /**
     * numero continue
     */
    private Long chrNum6;


    /**
     * numero annuel
     */
    private Long chrNumAn6;


    /**
     * numero janvier
     */
    private Long chrNum016;


    /**
     * numero fevrier
     */
    private Long chrNum026;


    /**
     * numero mars
     */
    private Long chrNum036;


    /**
     * numero avril
     */
    private Long chrNum046;


    /**
     * numero mai
     */
    private Long chrNum056;


    /**
     * numero juin
     */
    private Long chrNum066;


    /**
     * numero juillet
     */
    private Long chrNum076;


    /**
     * numero aout
     */
    private Long chrNum086;


    /**
     * numero septembre
     */
    private Long chrNum096;


    /**
     * numero octobre
     */
    private Long chrNum106;


    /**
     * numero novembre
     */
    private Long chrNum116;


    /**
     * numero decembre
     */
    private Long chrNum126;


    /**
     * prefixe
     */
    private String chrPrefixe6;


    /**
     * sufixe
     */
    private String chrSufixe6;


    /**
     * numero continue
     */
    private Long chrNum7;


    /**
     * numero annuel
     */
    private Long chrNumAn7;


    /**
     * numero janvier
     */
    private Long chrNum017;


    /**
     * numero fevrier
     */
    private Long chrNum027;


    /**
     * numero mars
     */
    private Long chrNum037;


    /**
     * numero avril
     */
    private Long chrNum047;


    /**
     * numero mai
     */
    private Long chrNum057;


    /**
     * numero juin
     */
    private Long chrNum067;


    /**
     * numero juillet
     */
    private Long chrNum077;


    /**
     * numero aout
     */
    private Long chrNum087;


    /**
     * numero septembre
     */
    private Long chrNum097;


    /**
     * numero octobre
     */
    private Long chrNum107;


    /**
     * numero novembre
     */
    private Long chrNum117;


    /**
     * numero decembre
     */
    private Long chrNum127;


    /**
     * prefixe
     */
    private String chrPrefixe7;


    /**
     * sufixe
     */
    private String chrSufixe7;


    /**
     * numero continue
     */
    private Long chrNum8;


    /**
     * numero annuel
     */
    private Long chrNumAn8;


    /**
     * numero janvier
     */
    private Long chrNum018;


    /**
     * numero fevrier
     */
    private Long chrNum028;


    /**
     * numero mars
     */
    private Long chrNum038;


    /**
     * numero avril
     */
    private Long chrNum048;


    /**
     * numero mai
     */
    private Long chrNum058;


    /**
     * numero juin
     */
    private Long chrNum068;


    /**
     * numero juillet
     */
    private Long chrNum078;


    /**
     * numero aout
     */
    private Long chrNum088;


    /**
     * numero septembre
     */
    private Long chrNum098;


    /**
     * numero octobre
     */
    private Long chrNum108;


    /**
     * numero novembre
     */
    private Long chrNum118;


    /**
     * numero decembre
     */
    private Long chrNum128;


    /**
     * prefixe
     */
    private String chrPrefixe8;


    /**
     * sufixe
     */
    private String chrSufixe8;


    /**
     * numero continue
     */
    private Long chrNum9;


    /**
     * numero annuel
     */
    private Long chrNumAn9;


    /**
     * numero janvier
     */
    private Long chrNum019;


    /**
     * numero fevrier
     */
    private Long chrNum029;


    /**
     * numero mars
     */
    private Long chrNum039;


    /**
     * numero avril
     */
    private Long chrNum049;


    /**
     * numero mai
     */
    private Long chrNum059;


    /**
     * numero juin
     */
    private Long chrNum069;


    /**
     * numero juillet
     */
    private Long chrNum079;


    /**
     * numero aout
     */
    private Long chrNum089;


    /**
     * numero septembre
     */
    private Long chrNum099;


    /**
     * numero octobre
     */
    private Long chrNum109;


    /**
     * numero novembre
     */
    private Long chrNum119;


    /**
     * numero decembre
     */
    private Long chrNum129;


    /**
     * prefixe
     */
    private String chrPrefixe9;


    /**
     * sufixe
     */
    private String chrSufixe9;


    /**
     * numero continue
     */
    private Long chrNumA;


    /**
     * numero annuel
     */
    private Long chrNumAnA;


    /**
     * numero janvier
     */
    private Long chrNum01A;


    /**
     * numero fevrier
     */
    private Long chrNum02A;


    /**
     * numero mars
     */
    private Long chrNum03A;


    /**
     * numero avril
     */
    private Long chrNum04A;


    /**
     * numero mai
     */
    private Long chrNum05A;


    /**
     * numero juin
     */
    private Long chrNum06A;


    /**
     * numero juillet
     */
    private Long chrNum07A;


    /**
     * numero aout
     */
    private Long chrNum08A;


    /**
     * numero septembre
     */
    private Long chrNum09A;


    /**
     * numero octobre
     */
    private Long chrNum10A;


    /**
     * numero novembre
     */
    private Long chrNum11A;


    /**
     * numero decembre
     */
    private Long chrNum12A;


    /**
     * prefixe
     */
    private String chrPrefixeA;


    /**
     * sufixe
     */
    private String chrSufixeA;


    /**
     * code journal comptable od
     */
    private String chrJournalOd;

}
