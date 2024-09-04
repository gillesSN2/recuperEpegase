package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AchReceptionSerieDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long recserId;


    /**
     * id ligne de reception
     */
    private Long recserIdLigne;


    /**
     * numero de reception
     */
    private String recserNum;


    /**
     * date de reception
     */
    private LocalDate recserDateIn;


    /**
     * code produit
     */
    private String recserCode;


    /**
     * code depot
     */
    private String recserDepot;


    /**
     * numero de palette
     */
    private String recserPalette;


    /**
     * numero de carton
     */
    private String recserCarton;


    /**
     * numero de serie
     */
    private String recserSerie;


    /**
     * prix de revient
     */
    private Double recserPr;


    /**
     * 0=disponible 1=non disponible
     */
    private Integer recserEtat;


    /**
     * id ligne du bl
     */
    private Long recserIdLigneBl;


    /**
     * date de sortie
     */
    private LocalDate recserDateOut;


    /**
     * NÃ‚Â° de bl
     */
    private String recserNumBl;


    /**
     * id tiers
     */
    private Long recserIdTiers;


    /**
     * nom tiers
     */
    private String recserNomTiers;


    /**
     * prix de vente
     */
    private Double recserPv;


    /**
     * numero de production
     */
    private String recserProduction;


    /**
     * numero de lot
     */
    private String recserLot;


    /**
     * id ligne du chargement
     */
    private Long recserIdLigneChargement;


    /**
     * NÂ° de chargement
     */
    private String recserNumChargement;


    /**
     * champ 1
     */
    private String recserChamp1;


    /**
     * champ 2
     */
    private String recserChamp2;


    /**
     * champ 3
     */
    private String recserChamp3;


    /**
     * champ 4
     */
    private String recserChamp4;


    /**
     * champ 5
     */
    private String recserChamp5;


    /**
     * champ 6
     */
    private String recserChamp6;


    /**
     * champ 7
     */
    private String recserChamp7;


    /**
     * champ 8
     */
    private String recserChamp8;


    /**
     * champ 9
     */
    private String recserChamp9;


    /**
     * champ 10
     */
    private String recserChamp10;


    /**
     * champ 11
     */
    private String recserChamp11;


    /**
     * champ 12
     */
    private String recserChamp12;


    /**
     * champ 13
     */
    private String recserChamp13;


    /**
     * champ 14
     */
    private String recserChamp14;


    /**
     * champ 15
     */
    private String recserChamp15;


    /**
     * champ 16
     */
    private String recserChamp16;


    /**
     * champ 17
     */
    private String recserChamp17;


    /**
     * champ 18
     */
    private String recserChamp18;


    /**
     * champ 19
     */
    private String recserChamp19;


    /**
     * champ 20
     */
    private String recserChamp20;

}
