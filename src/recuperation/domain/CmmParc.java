package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_parc")
public class CmmParc implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prc_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcId;

    /**
     * date creation
     */
    @Column(name = "prc_date_creat")
    private LocalDateTime prcDateCreat;

    /**
     * date modification
     */
    @Column(name = "prc_date_modif")
    private LocalDateTime prcDateModif;

    /**
     * id user de creation
     */
    @Column(name = "prc_user_creat")
    private Long prcUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "prc_user_modif")
    private Long prcUserModif = 0L;

    /**
     * immatriculation
     */
    @Column(name = "prc_immatriculation")
    private String prcImmatriculation;

    /**
     * libelle du parc en francais
     */
    @Column(name = "prc_nom_FR")
    private String prcNomFr;

    /**
     * libelle du parc en anglais
     */
    @Column(name = "prc_nom_UK")
    private String prcNomUk;

    /**
     * libelle du parc en espagnol
     */
    @Column(name = "prc_nom_SP")
    private String prcNomSp;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "prc_inactif")
    private Integer prcInactif = 0;

    /**
     * code immobilisation comptable
     */
    @Column(name = "prc_immobilisation")
    private Integer prcImmobilisation;

    /**
     * id immobilisation comptable
     */
    @Column(name = "prc_id_immobilisation")
    private Long prcIdImmobilisation = 0L;

    /**
     * nom de la photo
     */
    @Column(name = "prc_photo")
    private String prcPhoto;

    /**
     * voir fichier xml
     */
    @Column(name = "prc_nature")
    private Integer prcNature = 0;

    /**
     * libelle nature
     */
    @Column(name = "prc_lib_nature")
    private String prcLibNature;

    /**
     * code famille
     */
    @Column(name = "prc_famille")
    private String prcFamille;

    /**
     * libelle famille
     */
    @Column(name = "prc_lib_famille")
    private String prcLibFamille;

    /**
     * code sous famille
     */
    @Column(name = "prc_sous_famille")
    private String prcSousFamille;

    /**
     * libelle sous famille
     */
    @Column(name = "prc_lib_sous_famille")
    private String prcLibSousFamille;

    /**
     * marque
     */
    @Column(name = "prc_marque")
    private String prcMarque;

    /**
     * numero chassis ou de serie
     */
    @Column(name = "prc_chassis")
    private String prcChassis;

    /**
     * numero moteur
     */
    @Column(name = "prc_moteur")
    private String prcMoteur;

    /**
     * numero arrangement
     */
    @Column(name = "prc_arrangement")
    private String prcArrangement;

    /**
     * date achat
     */
    @Column(name = "prc_date_achat")
    private LocalDate prcDateAchat;

    /**
     * periode anniversaire JJ:MM par rapport a la date achat
     */
    @Column(name = "prc_anniversaire")
    private String prcAnniversaire;

    /**
     * annee fabrication
     */
    @Column(name = "prc_annee_fab")
    private Integer prcAnneeFab = 0;

    /**
     * prix achat
     */
    @Column(name = "prc_prix_achat")
    private Double prcPrixAchat = 0D;

    /**
     * prix revient
     */
    @Column(name = "prc_prix_revient")
    private Double prcPrixRevient = 0D;

    /**
     * prix vente ou location
     */
    @Column(name = "prc_prix_vente")
    private Double prcPrixVente = 0D;

    /**
     * date mise en service
     */
    @Column(name = "prc_date_mes")
    private LocalDate prcDateMes;

    /**
     * prix argus
     */
    @Column(name = "prc_prix_argus")
    private Double prcPrixArgus = 0D;

    /**
     * date de sortie
     */
    @Column(name = "prc_date_sortie")
    private LocalDate prcDateSortie;

    /**
     * prix cession
     */
    @Column(name = "prc_prix_cession")
    private Double prcPrixCession = 0D;

    /**
     * 0=en cours 1=cession 2=rebut
     */
    @Column(name = "prc_etat")
    private Integer prcEtat = 0;

    /**
     * 0=en arret 1=en fonction 2=en panne
     */
    @Column(name = "prc_fonction")
    private Integer prcFonction = 0;

    /**
     * nom lieu actuel (mission ou garage)
     */
    @Column(name = "prc_lieu")
    private String prcLieu;

    /**
     * description panne (si panne)
     */
    @Column(name = "prc_panne")
    private String prcPanne;

    /**
     * 0=interne 1=externe 2=fabrique
     */
    @Column(name = "prc_origine")
    private Integer prcOrigine = 0;

    /**
     * puissance fiscale
     */
    @Column(name = "prc_puis_fiscale")
    private Float prcPuisFiscale = 0F;

    /**
     * puissance en chevaux
     */
    @Column(name = "prc_puis_chev")
    private Float prcPuisChev = 0F;

    /**
     * consommation moyenne au 100 km
     */
    @Column(name = "prc_consommation")
    private Float prcConsommation = 0F;

    /**
     * consommation litre par km
     */
    @Column(name = "prc_cote")
    private Float prcCote = 0F;

    /**
     * 0=distance 1=kilometrique 2=horaire
     */
    @Column(name = "prc_compteur")
    private Integer prcCompteur = 0;

    /**
     * 0=essence 1=gazoil 2=gpl 3=electique 4=hybride 5=kerosene 6=solaire
     */
    @Column(name = "prc_alimentation")
    private Integer prcAlimentation = 0;

    /**
     * amperage
     */
    @Column(name = "prc_ampere")
    private Float prcAmpere = 0F;

    /**
     * voltage
     */
    @Column(name = "prc_volt")
    private Float prcVolt = 0F;

    /**
     * 0=ordinaire 1=super 98 2=super 99 3=jet a1
     */
    @Column(name = "prc_essence")
    private Integer prcEssence = 0;

    /**
     * matricule salarie
     */
    @Column(name = "prc_mat_salarie")
    private String prcMatSalarie;

    /**
     * nom salarie
     */
    @Column(name = "prc_nom_salarie")
    private String prcNomSalarie;

    /**
     * prenom salarie
     */
    @Column(name = "prc_prenom_salarie")
    private String prcPrenomSalarie;

    /**
     * code service
     */
    @Column(name = "prc_service")
    private String prcService;

    /**
     * libelle service
     */
    @Column(name = "prc_lib_service")
    private String prcLibService;

    /**
     * 0=sans alerte 1=alerte par mail
     */
    @Column(name = "prc_alerte")
    private Integer prcAlerte = 0;

    /**
     * mail pour alerte
     */
    @Column(name = "prc_mail_alerte")
    private String prcMailAlerte;

    /**
     * id tiers si garage
     */
    @Column(name = "prc_id_tiers")
    private Long prcIdTiers = 0L;

    /**
     * raison sociale tiers si garage
     */
    @Column(name = "prc_nom_tiers")
    private String prcNomTiers;

    /**
     * adresse du tiers
     */
    @Column(name = "prc_adresse")
    private String prcAdresse;

    /**
     * telephone du tiers
     */
    @Column(name = "prc_tel")
    private String prcTel;

    /**
     * ville du tiers
     */
    @Column(name = "prc_ville")
    private String prcVille;

    /**
     * contact du tiers
     */
    @Column(name = "prc_contact")
    private String prcContact;

}
