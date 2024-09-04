package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_chrono")
public class CmmChrono implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "chr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chrId;

    /**
     * 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=valorisation 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "chr_nature")
    private Integer chrNature = 0;

    /**
     * code serie ou nature salarie
     */
    @Column(name = "chr_serie")
    private String chrSerie;

    /**
     * nom de la serie
     */
    @Column(name = "chr_nom")
    private String chrNom;

    /**
     * 0=public 1=prive
     */
    @Column(name = "chr_prive")
    private Integer chrPrive = 0;

    /**
     * code du service
     */
    @Column(name = "chr_service")
    private String chrService;

    /**
     * nombre de caractere
     */
    @Column(name = "chr_nb_car")
    private Integer chrNbCar = 5;

    /**
     * mode 0=chrono annuel 1=chrono mensuel 2=chrono continu
     */
    @Column(name = "chr_mode")
    private Integer chrMode = 0;

    /**
     * format 0=chrono simple 1=MM+chrono 2=MM+AA+chrono 3=chrono/AA 4=chrono/MMAA
     */
    @Column(name = "chr_format")
    private Integer chrFormat = 0;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe")
    private String chrPrefixe;

    /**
     * numero normal
     */
    @Column(name = "chr_num")
    private Long chrNum = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an")
    private Long chrNumAn = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01")
    private Long chrNum01 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02")
    private Long chrNum02 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03")
    private Long chrNum03 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04")
    private Long chrNum04 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05")
    private Long chrNum05 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06")
    private Long chrNum06 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07")
    private Long chrNum07 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08")
    private Long chrNum08 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09")
    private Long chrNum09 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10")
    private Long chrNum10 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11")
    private Long chrNum11 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12")
    private Long chrNum12 = 0L;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe")
    private String chrSufixe;

    /**
     * code journal comptable
     */
    @Column(name = "chr_journal")
    private String chrJournal;

    /**
     * Periode
     */
    @Column(name = "chr_periode")
    private String chrPeriode;

    /**
     * numero continue
     */
    @Column(name = "chr_num_1")
    private Long chrNum1 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_1")
    private Long chrNumAn1 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_1")
    private Long chrNum011 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_1")
    private Long chrNum021 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_1")
    private Long chrNum031 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_1")
    private Long chrNum041 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_1")
    private Long chrNum051 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_1")
    private Long chrNum061 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_1")
    private Long chrNum071 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_1")
    private Long chrNum081 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_1")
    private Long chrNum091 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_1")
    private Long chrNum101 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_1")
    private Long chrNum111 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_1")
    private Long chrNum121 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_1")
    private String chrPrefixe1;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_1")
    private String chrSufixe1;

    /**
     * numero continue
     */
    @Column(name = "chr_num_2")
    private Long chrNum2 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_2")
    private Long chrNumAn2 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_2")
    private Long chrNum012 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_2")
    private Long chrNum022 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_2")
    private Long chrNum032 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_2")
    private Long chrNum042 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_2")
    private Long chrNum052 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_2")
    private Long chrNum062 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_2")
    private Long chrNum072 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_2")
    private Long chrNum082 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_2")
    private Long chrNum092 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_2")
    private Long chrNum102 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_2")
    private Long chrNum112 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_2")
    private Long chrNum122 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_2")
    private String chrPrefixe2;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_2")
    private String chrSufixe2;

    /**
     * numero continue
     */
    @Column(name = "chr_num_3")
    private Long chrNum3 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_3")
    private Long chrNumAn3 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_3")
    private Long chrNum013 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_3")
    private Long chrNum023 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_3")
    private Long chrNum033 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_3")
    private Long chrNum043 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_3")
    private Long chrNum053 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_3")
    private Long chrNum063 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_3")
    private Long chrNum073 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_3")
    private Long chrNum083 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_3")
    private Long chrNum093 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_3")
    private Long chrNum103 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_3")
    private Long chrNum113 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_3")
    private Long chrNum123 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_3")
    private String chrPrefixe3;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_3")
    private String chrSufixe3;

    /**
     * numero continue
     */
    @Column(name = "chr_num_4")
    private Long chrNum4 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_4")
    private Long chrNumAn4 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_4")
    private Long chrNum014 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_4")
    private Long chrNum024 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_4")
    private Long chrNum034 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_4")
    private Long chrNum044 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_4")
    private Long chrNum054 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_4")
    private Long chrNum064 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_4")
    private Long chrNum074 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_4")
    private Long chrNum084 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_4")
    private Long chrNum094 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_4")
    private Long chrNum104 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_4")
    private Long chrNum114 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_4")
    private Long chrNum124 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_4")
    private String chrPrefixe4;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_4")
    private String chrSufixe4;

    /**
     * numero continue
     */
    @Column(name = "chr_num_5")
    private Long chrNum5 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_5")
    private Long chrNumAn5 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_5")
    private Long chrNum015 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_5")
    private Long chrNum025 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_5")
    private Long chrNum035 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_5")
    private Long chrNum045 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_5")
    private Long chrNum055 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_5")
    private Long chrNum065 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_5")
    private Long chrNum075 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_5")
    private Long chrNum085 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_5")
    private Long chrNum095 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_5")
    private Long chrNum105 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_5")
    private Long chrNum115 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_5")
    private Long chrNum125 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_5")
    private String chrPrefixe5;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_5")
    private String chrSufixe5;

    /**
     * numero continue
     */
    @Column(name = "chr_num_6")
    private Long chrNum6 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_6")
    private Long chrNumAn6 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_6")
    private Long chrNum016 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_6")
    private Long chrNum026 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_6")
    private Long chrNum036 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_6")
    private Long chrNum046 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_6")
    private Long chrNum056 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_6")
    private Long chrNum066 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_6")
    private Long chrNum076 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_6")
    private Long chrNum086 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_6")
    private Long chrNum096 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_6")
    private Long chrNum106 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_6")
    private Long chrNum116 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_6")
    private Long chrNum126 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_6")
    private String chrPrefixe6;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_6")
    private String chrSufixe6;

    /**
     * numero continue
     */
    @Column(name = "chr_num_7")
    private Long chrNum7 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_7")
    private Long chrNumAn7 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_7")
    private Long chrNum017 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_7")
    private Long chrNum027 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_7")
    private Long chrNum037 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_7")
    private Long chrNum047 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_7")
    private Long chrNum057 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_7")
    private Long chrNum067 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_7")
    private Long chrNum077 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_7")
    private Long chrNum087 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_7")
    private Long chrNum097 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_7")
    private Long chrNum107 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_7")
    private Long chrNum117 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_7")
    private Long chrNum127 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_7")
    private String chrPrefixe7;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_7")
    private String chrSufixe7;

    /**
     * numero continue
     */
    @Column(name = "chr_num_8")
    private Long chrNum8 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_8")
    private Long chrNumAn8 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_8")
    private Long chrNum018 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_8")
    private Long chrNum028 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_8")
    private Long chrNum038 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_8")
    private Long chrNum048 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_8")
    private Long chrNum058 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_8")
    private Long chrNum068 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_8")
    private Long chrNum078 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_8")
    private Long chrNum088 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_8")
    private Long chrNum098 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_8")
    private Long chrNum108 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_8")
    private Long chrNum118 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_8")
    private Long chrNum128 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_8")
    private String chrPrefixe8;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_8")
    private String chrSufixe8;

    /**
     * numero continue
     */
    @Column(name = "chr_num_9")
    private Long chrNum9 = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_9")
    private Long chrNumAn9 = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_9")
    private Long chrNum019 = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_9")
    private Long chrNum029 = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_9")
    private Long chrNum039 = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_9")
    private Long chrNum049 = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_9")
    private Long chrNum059 = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_9")
    private Long chrNum069 = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_9")
    private Long chrNum079 = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_9")
    private Long chrNum089 = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_9")
    private Long chrNum099 = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_9")
    private Long chrNum109 = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_9")
    private Long chrNum119 = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_9")
    private Long chrNum129 = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_9")
    private String chrPrefixe9;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_9")
    private String chrSufixe9;

    /**
     * numero continue
     */
    @Column(name = "chr_num_a")
    private Long chrNumA = 0L;

    /**
     * numero annuel
     */
    @Column(name = "chr_num_an_a")
    private Long chrNumAnA = 0L;

    /**
     * numero janvier
     */
    @Column(name = "chr_num_01_a")
    private Long chrNum01A = 0L;

    /**
     * numero fevrier
     */
    @Column(name = "chr_num_02_a")
    private Long chrNum02A = 0L;

    /**
     * numero mars
     */
    @Column(name = "chr_num_03_a")
    private Long chrNum03A = 0L;

    /**
     * numero avril
     */
    @Column(name = "chr_num_04_a")
    private Long chrNum04A = 0L;

    /**
     * numero mai
     */
    @Column(name = "chr_num_05_a")
    private Long chrNum05A = 0L;

    /**
     * numero juin
     */
    @Column(name = "chr_num_06_a")
    private Long chrNum06A = 0L;

    /**
     * numero juillet
     */
    @Column(name = "chr_num_07_a")
    private Long chrNum07A = 0L;

    /**
     * numero aout
     */
    @Column(name = "chr_num_08_a")
    private Long chrNum08A = 0L;

    /**
     * numero septembre
     */
    @Column(name = "chr_num_09_a")
    private Long chrNum09A = 0L;

    /**
     * numero octobre
     */
    @Column(name = "chr_num_10_a")
    private Long chrNum10A = 0L;

    /**
     * numero novembre
     */
    @Column(name = "chr_num_11_a")
    private Long chrNum11A = 0L;

    /**
     * numero decembre
     */
    @Column(name = "chr_num_12_a")
    private Long chrNum12A = 0L;

    /**
     * prefixe
     */
    @Column(name = "chr_prefixe_a")
    private String chrPrefixeA;

    /**
     * sufixe
     */
    @Column(name = "chr_sufixe_a")
    private String chrSufixeA;

    /**
     * code journal comptable od
     */
    @Column(name = "chr_journal_od")
    private String chrJournalOd;

}
