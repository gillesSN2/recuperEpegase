package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_prets")
public class PaySalariesPrets implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salpre_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salpreId;

    /**
     * date de creation
     */
    @Column(name = "salpre_date_creat")
    private LocalDateTime salpreDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salpre_date_modif")
    private LocalDateTime salpreDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salpre_user_creat")
    private Long salpreUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salpre_user_modif")
    private Long salpreUserModif = 0L;

    /**
     * 0=interne 1=externe 2=manuel
     */
    @Column(name = "salpre_type")
    private Integer salpreType = 0;

    /**
     * 0=nr 1=avance exceptionnelle 2=soins medicaux 3=cession/traite
     */
    @Column(name = "salpre_nature")
    private Integer salpreNature = 0;

    /**
     * date de souscription
     */
    @Column(name = "salpre_date_souscription")
    private LocalDate salpreDateSouscription;

    /**
     * numero du pret
     */
    @Column(name = "salpre_num")
    private String salpreNum;

    /**
     * montant du pret
     */
    @Column(name = "salpre_montant")
    private Double salpreMontant = 0D;

    /**
     * montant rembourse
     */
    @Column(name = "salpre_rmb")
    private Double salpreRmb = 0D;

    /**
     * date debut remboursement
     */
    @Column(name = "salpre_date_debut")
    private LocalDate salpreDateDebut;

    /**
     * nombre echeances
     */
    @Column(name = "salpre_echeance")
    private Integer salpreEcheance;

    /**
     * objet du pret
     */
    @Column(name = "salpre_objet")
    private String salpreObjet;

    /**
     * reference
     */
    @Column(name = "salpre_reference")
    private String salpreReference;

    /**
     * responsable
     */
    @Column(name = "salpre_responsable")
    private String salpreResponsable;

    /**
     * service
     */
    @Column(name = "salpre_service")
    private String salpreService;

    /**
     * code journal
     */
    @Column(name = "salpre_journal")
    private String salpreJournal;

    /**
     * 0= sans habilitation 1=avec habilitation
     */
    @Column(name = "salpre_etat_val")
    private Integer salpreEtatVal = 0;

    /**
     * 0=non valide 1=valide
     */
    @Column(name = "salpre_etat")
    private Integer salpreEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "salpre_date_valide")
    private LocalDateTime salpreDateValide;

    /**
     * date impression
     */
    @Column(name = "salpre_date_imp")
    private LocalDateTime salpreDateImp;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * descriptif du pret
     */
    @Column(name = "salpre_descriptif")
    private String salpreDescriptif;

}
