package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_rdv")
public class CmmRdv implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rdv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rdvId;

    /**
     * 0=rappel 1=rdv 2=todo 3=emploi du temps 4=visite 5=intervention 6=appel 7=pointage 8=reunion 9=message
     */
    @Column(name = "rdv_nature")
    private Integer rdvNature = 0;

    /**
     * date de creation
     */
    @Column(name = "rdv_date_creation")
    private LocalDate rdvDateCreation;

    /**
     * id user destinataire
     */
    @Column(name = "rdv_usr_de")
    private Long rdvUsrDe = 0L;

    /**
     * nom users destinataire
     */
    @Column(name = "rdv_nom_users")
    private String rdvNomUsers;

    /**
     * id tiers destinataire
     */
    @Column(name = "rdv_tie_id_de")
    private Long rdvTieIdDe = 0L;

    /**
     * nom Tiers destinataire
     */
    @Column(name = "rdv_nom_tiers")
    private String rdvNomTiers;

    /**
     * id patient destinataire
     */
    @Column(name = "rdv_pat_id_de")
    private Long rdvPatIdDe = 0L;

    /**
     * nom patient destinataire
     */
    @Column(name = "rdv_nom_pat")
    private String rdvNomPat;

    /**
     * id salarie destinataire
     */
    @Column(name = "rdv_sal_id_de")
    private Long rdvSalIdDe = 0L;

    /**
     * nom salarie destinataire
     */
    @Column(name = "rdv_nom_sal")
    private String rdvNomSal;

    /**
     * date de debut
     */
    @Column(name = "rdv_dte_de")
    private LocalDate rdvDteDe;

    /**
     * heure de debut
     */
    @Column(name = "rdv_hr_de")
    private String rdvHrDe = "0";

    /**
     * minute de debut
     */
    @Column(name = "rdv_mn_de")
    private String rdvMnDe = "0";

    /**
     * heure duree
     */
    @Column(name = "rdv_hr_duree")
    private String rdvHrDuree = "0";

    /**
     * minute duree
     */
    @Column(name = "rdv_mn_duree")
    private String rdvMnDuree = "0";

    /**
     * date de fin
     */
    @Column(name = "rdv_dte_fi")
    private LocalDate rdvDteFi;

    /**
     * heure de fin
     */
    @Column(name = "rdv_hr_fi")
    private String rdvHrFi = "0";

    /**
     * minute de fin
     */
    @Column(name = "rdv_mn_fi")
    private String rdvMnFi = "0";

    /**
     * sujet du rdv
     */
    @Column(name = "rdv_sujet")
    private String rdvSujet;

    /**
     * description du rdv
     */
    @Column(name = "rdv_descript")
    private String rdvDescript;

    /**
     * code tache du rdv
     */
    @Column(name = "rdv_tache")
    private String rdvTache;

    /**
     * pr du rdv
     */
    @Column(name = "rdv_tache_pr")
    private Float rdvTachePr = 0F;

    /**
     * pv du rdv
     */
    @Column(name = "rdv_tache_pv")
    private Float rdvTachePv = 0F;

    /**
     * lieu du rdv
     */
    @Column(name = "rdv_lieu")
    private String rdvLieu;

    /**
     * mode du rdv exemple telephon
     */
    @Column(name = "rdv_mode")
    private String rdvMode;

    /**
     * 0=en cours 1=traite 2=annule
     */
    @Column(name = "rdv_etat")
    private Integer rdvEtat = 0;

    /**
     * date execution
     */
    @Column(name = "rdv_dte_exec")
    private LocalDate rdvDteExec;

    /**
     * compte rendu
     */
    @Column(name = "rdv_cr")
    private String rdvCr;

    /**
     * 0=normal 99= divers
     */
    @Column(name = "rdv_divers_tiers")
    private Integer rdvDiversTiers = 0;

    /**
     * nom du tiers divers
     */
    @Column(name = "rdv_divers_nom")
    private String rdvDiversNom;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * liste des mails du contact invites
     */
    @Column(name = "rdv_mail_contact")
    private String rdvMailContact;

    /**
     * liste des collaborateurs invites
     */
    @Column(name = "rdv_collaborateur")
    private String rdvCollaborateur;

    /**
     * id du rdv principal
     */
    @Column(name = "rdv_id_principal")
    private Long rdvIdPrincipal = 0L;

    /**
     * si vide envoi ok sinon message erreur
     */
    @Column(name = "rdv_statut")
    private String rdvStatut;

    /**
     * true si erreur
     */
    @Column(name = "rdv_erreur")
    private Boolean rdvErreur = Boolean.FALSE;

    /**
     * code service
     */
    @Column(name = "rdv_service")
    private String rdvService;

}
