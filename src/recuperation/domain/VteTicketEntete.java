package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_ticket_entete")
public class VteTicketEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tic_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticId;

    /**
     * date du factue
     */
    @Column(name = "tic_date")
    private LocalDateTime ticDate;

    /**
     * numero facture
     */
    @Column(name = "tic_num")
    private String ticNum;

    /**
     * nom du responsable
     */
    @Column(name = "tic_nom_responsable")
    private String ticNomResponsable;

    /**
     * id du responsable
     */
    @Column(name = "tic_id_responsable")
    private Long ticIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "tic_nom_commercial")
    private String ticNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "tic_id_commercial")
    private Long ticIdCommercial = 0L;

    /**
     * nom du client
     */
    @Column(name = "tic_nom_tiers")
    private String ticNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "tic_civil_tiers")
    private String ticCivilTiers;

    /**
     * code site
     */
    @Column(name = "tic_site")
    private String ticSite;

    /**
     * code adepartement
     */
    @Column(name = "tic_departement")
    private String ticDepartement;

    /**
     * code service
     */
    @Column(name = "tic_service")
    private String ticService;

    /**
     * prix total ht
     */
    @Column(name = "tic_total_ht")
    private Double ticTotalHt = 0D;

    /**
     * total taxe
     */
    @Column(name = "tic_total_tva")
    private Double ticTotalTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "tic_total_tc")
    private Double ticTotalTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "tic_total_ttc")
    private Double ticTotalTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "tic_total_reglement")
    private Double ticTotalReglement = 0D;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "tic_type_reg")
    private Integer ticTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "tic_mode_reg")
    private String ticModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "tic_nb_jour_reg")
    private Integer ticNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "tic_arrondi_reg")
    private Integer ticArrondiReg = 0;

    /**
     * date echeance de reglement
     */
    @Column(name = "tic_date_eche_reg")
    private LocalDate ticDateEcheReg;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * taux taxe complementaire
     */
    @Column(name = "tic_taux_tc")
    private Float ticTauxTc = 0F;

    /**
     * nom equipe
     */
    @Column(name = "tic_nom_equipe")
    private String ticNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "tic_id_equipe")
    private Long ticIdEquipe = 0L;

    /**
     * date transfert en compta
     */
    @Column(name = "tic_date_transfert")
    private LocalDate ticDateTransfert;

    /**
     * numero de transfert
     */
    @Column(name = "tic_num_trf")
    private String ticNumTrf;

    /**
     * etat
     */
    @Column(name = "tic_etat")
    private Integer ticEtat = 0;

    /**
     * code devise
     */
    @Column(name = "tic_devise")
    private String ticDevise;

}
