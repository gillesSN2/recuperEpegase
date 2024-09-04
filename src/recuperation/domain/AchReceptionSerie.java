package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ach_reception_serie")
public class AchReceptionSerie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "recser_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recserId;

    /**
     * id ligne de reception
     */
    @Column(name = "recser_id_ligne")
    private Long recserIdLigne = 0L;

    /**
     * numero de reception
     */
    @Column(name = "recser_num")
    private String recserNum;

    /**
     * date de reception
     */
    @Column(name = "recser_date_in")
    private LocalDate recserDateIn;

    /**
     * code produit
     */
    @Column(name = "recser_code")
    private String recserCode;

    /**
     * code depot
     */
    @Column(name = "recser_depot")
    private String recserDepot;

    /**
     * numero de palette
     */
    @Column(name = "recser_palette")
    private String recserPalette;

    /**
     * numero de carton
     */
    @Column(name = "recser_carton")
    private String recserCarton;

    /**
     * numero de serie
     */
    @Column(name = "recser_serie")
    private String recserSerie;

    /**
     * prix de revient
     */
    @Column(name = "recser_pr")
    private Double recserPr = 0D;

    /**
     * 0=disponible 1=non disponible
     */
    @Column(name = "recser_etat")
    private Integer recserEtat = 0;

    /**
     * id ligne du bl
     */
    @Column(name = "recser_id_ligne_bl")
    private Long recserIdLigneBl = 0L;

    /**
     * date de sortie
     */
    @Column(name = "recser_date_out")
    private LocalDate recserDateOut;

    /**
     * NÃ‚Â° de bl
     */
    @Column(name = "recser_num_bl")
    private String recserNumBl;

    /**
     * id tiers
     */
    @Column(name = "recser_id_tiers")
    private Long recserIdTiers = 0L;

    /**
     * nom tiers
     */
    @Column(name = "recser_nom_tiers")
    private String recserNomTiers;

    /**
     * prix de vente
     */
    @Column(name = "recser_pv")
    private Double recserPv = 0D;

    /**
     * numero de production
     */
    @Column(name = "recser_production")
    private String recserProduction;

    /**
     * numero de lot
     */
    @Column(name = "recser_lot")
    private String recserLot;

    /**
     * id ligne du chargement
     */
    @Column(name = "recser_id_ligne_chargement")
    private Long recserIdLigneChargement = 0L;

    /**
     * NÂ° de chargement
     */
    @Column(name = "recser_num_chargement")
    private String recserNumChargement;

    /**
     * champ 1
     */
    @Column(name = "recser_champ1")
    private String recserChamp1;

    /**
     * champ 2
     */
    @Column(name = "recser_champ2")
    private String recserChamp2;

    /**
     * champ 3
     */
    @Column(name = "recser_champ3")
    private String recserChamp3;

    /**
     * champ 4
     */
    @Column(name = "recser_champ4")
    private String recserChamp4;

    /**
     * champ 5
     */
    @Column(name = "recser_Champ5")
    private String recserChamp5;

    /**
     * champ 6
     */
    @Column(name = "recser_Champ6")
    private String recserChamp6;

    /**
     * champ 7
     */
    @Column(name = "recser_Champ7")
    private String recserChamp7;

    /**
     * champ 8
     */
    @Column(name = "recser_Champ8")
    private String recserChamp8;

    /**
     * champ 9
     */
    @Column(name = "recser_Champ9")
    private String recserChamp9;

    /**
     * champ 10
     */
    @Column(name = "recser_Champ10")
    private String recserChamp10;

    /**
     * champ 11
     */
    @Column(name = "recser_champ11")
    private String recserChamp11;

    /**
     * champ 12
     */
    @Column(name = "recser_champ12")
    private String recserChamp12;

    /**
     * champ 13
     */
    @Column(name = "recser_champ13")
    private String recserChamp13;

    /**
     * champ 14
     */
    @Column(name = "recser_champ14")
    private String recserChamp14;

    /**
     * champ 15
     */
    @Column(name = "recser_Champ15")
    private String recserChamp15;

    /**
     * champ 16
     */
    @Column(name = "recser_Champ16")
    private String recserChamp16;

    /**
     * champ 17
     */
    @Column(name = "recser_Champ17")
    private String recserChamp17;

    /**
     * champ 18
     */
    @Column(name = "recser_Champ18")
    private String recserChamp18;

    /**
     * champ 19
     */
    @Column(name = "recser_Champ19")
    private String recserChamp19;

    /**
     * champ 20
     */
    @Column(name = "recser_Champ20")
    private String recserChamp20;

}
