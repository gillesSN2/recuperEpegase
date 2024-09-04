package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_commission_entete")
public class VteCommissionEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "com_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId;

    /**
     * date de creation
     */
    @Column(name = "com_date_creat")
    private LocalDateTime comDateCreat;

    /**
     * date de modification
     */
    @Column(name = "com_date_modif")
    private LocalDateTime comDateModif;

    /**
     * id user createur
     */
    @Column(name = "com_id_createur")
    private Long comIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "com_nom_createur")
    private String comNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "com_id_modif")
    private Long comIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "com_nom_modif")
    private String comNomModif;

    /**
     * date debut du calcul
     */
    @Column(name = "com_date_debut")
    private LocalDateTime comDateDebut;

    /**
     * date fin du calcul
     */
    @Column(name = "com_date_Fin")
    private LocalDateTime comDateFin;

    /**
     * numero commissions
     */
    @Column(name = "com_num")
    private String comNum;

    /**
     * date commissions
     */
    @Column(name = "com_date")
    private LocalDateTime comDate;

    /**
     * nom du commercial
     */
    @Column(name = "com_nom_responsable")
    private String comNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "com_id_responsable")
    private Long comIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "com_nom_commercial")
    private String comNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "com_id_commercial")
    private Long comIdCommercial = 0L;

    /**
     * total commission
     */
    @Column(name = "com_tot_commission")
    private Double comTotCommission = 0D;

    /**
     * total reglement
     */
    @Column(name = "com_tot_reglement")
    private Double comTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "com_solde")
    private Integer comSolde = 0;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "com_type_reg")
    private Integer comTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "com_mode_reg")
    private String comModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "com_nb_jour_reg")
    private Integer comNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "com_arrondi_reg")
    private Integer comArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "com_condition_reg")
    private String comConditionReg;

    /**
     * date echeance de reglement
     */
    @Column(name = "com_date_eche_reg")
    private LocalDate comDateEcheReg;

    /**
     * date dernier reglement
     */
    @Column(name = "com_date_last_reg")
    private LocalDate comDateLastReg;

    /**
     * code activite
     */
    @Column(name = "com_activite")
    private String comActivite;

    /**
     * code site
     */
    @Column(name = "com_site")
    private String comSite;

    /**
     * code departement
     */
    @Column(name = "com_departement")
    private String comDepartement;

    /**
     * code service
     */
    @Column(name = "com_service")
    private String comService;

    /**
     * code analytique 2
     */
    @Column(name = "com_anal2")
    private String comAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "com_anal4")
    private String comAnal4;

    /**
     * date impression
     */
    @Column(name = "com_date_imp")
    private LocalDate comDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "com_modele_imp")
    private String comModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "com_etat_val")
    private Integer comEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "com_gele")
    private Integer comGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "com_etat")
    private Integer comEtat = 0;

    /**
     * date de validite
     */
    @Column(name = "com_date_validite")
    private LocalDate comDateValidite;

    /**
     * date de validation
     */
    @Column(name = "com_date_valide")
    private LocalDate comDateValide;

    /**
     * date annulation
     */
    @Column(name = "com_date_annule")
    private LocalDate comDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "com_motif_annule")
    private String comMotifAnnule;

    /**
     * date transfert en compta
     */
    @Column(name = "com_date_transfert")
    private LocalDate comDateTransfert;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * nom du equipe
     */
    @Column(name = "com_nom_equipe")
    private String comNomEquipe;

    /**
     * id du equipe
     */
    @Column(name = "com_id_equipe")
    private Long comIdEquipe = 0L;

}
