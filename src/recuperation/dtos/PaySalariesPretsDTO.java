package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaySalariesPretsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long salpreId;


    /**
     * date de creation
     */
    private LocalDateTime salpreDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salpreDateModif;


    /**
     * utilisateur de creation
     */
    private Long salpreUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salpreUserModif;


    /**
     * 0=interne 1=externe 2=manuel
     */
    private Integer salpreType;


    /**
     * 0=nr 1=avance exceptionnelle 2=soins medicaux 3=cession/traite
     */
    private Integer salpreNature;


    /**
     * date de souscription
     */
    private LocalDate salpreDateSouscription;


    /**
     * numero du pret
     */
    private String salpreNum;


    /**
     * montant du pret
     */
    private Double salpreMontant;


    /**
     * montant rembourse
     */
    private Double salpreRmb;


    /**
     * date debut remboursement
     */
    private LocalDate salpreDateDebut;


    /**
     * nombre echeances
     */
    private Integer salpreEcheance;


    /**
     * objet du pret
     */
    private String salpreObjet;


    /**
     * reference
     */
    private String salpreReference;


    /**
     * responsable
     */
    private String salpreResponsable;


    /**
     * service
     */
    private String salpreService;


    /**
     * code journal
     */
    private String salpreJournal;


    /**
     * 0= sans habilitation 1=avec habilitation
     */
    private Integer salpreEtatVal;


    /**
     * 0=non valide 1=valide
     */
    private Integer salpreEtat;


    /**
     * date de validation
     */
    private LocalDateTime salpreDateValide;


    /**
     * date impression
     */
    private LocalDateTime salpreDateImp;

    private Long salId;


    /**
     * descriptif du pret
     */
    private String salpreDescriptif;

}
