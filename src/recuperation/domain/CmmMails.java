package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_mails")
public class CmmMails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mai_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maiId;

    /**
     * date de creation
     */
    @Column(name = "mai_date_creation")
    private LocalDateTime maiDateCreation;

    /**
     * user de creation
     */
    @Column(name = "mai_user_creation")
    private Long maiUserCreation = 0L;

    /**
     * date de modification
     */
    @Column(name = "mai_date_modif")
    private LocalDateTime maiDateModif;

    /**
     * user de modification
     */
    @Column(name = "mai_user_modif")
    private Long maiUserModif = 0L;

    /**
     * numero chrono du mail
     */
    @Column(name = "mai_num")
    private String maiNum;

    /**
     * type 0=mail 1=courrier
     */
    @Column(name = "mai_type")
    private Integer maiType = 0;

    /**
     * sens du mail 0=envoie 1=reception 2=brouillon 3=corbeille
     */
    @Column(name = "mai_sens")
    private Integer maiSens = 0;

    /**
     * id structure
     */
    @Column(name = "mai_str")
    private Long maiStr = 0L;

    /**
     * code groupe
     */
    @Column(name = "mai_grp")
    private String maiGrp;

    /**
     * id user
     */
    @Column(name = "mai_usr")
    private Long maiUsr = 0L;

    /**
     * nos references
     */
    @Column(name = "mai_nos_ref")
    private String maiNosRef;

    /**
     * vos references
     */
    @Column(name = "mai_vos_ref")
    private String maiVosRef;

    /**
     * type 0=standard 1=important 2=prioritaire 3=projet 4=reunion
     */
    @Column(name = "mai_priorite")
    private Integer maiPriorite = 0;

    /**
     * modele
     */
    @Column(name = "mai_modele")
    private String maiModele;

    /**
     * objet
     */
    @Column(name = "mai_objet")
    private String maiObjet;

    /**
     * emetteur
     */
    @Column(name = "mai_emetteur")
    private String maiEmetteur;

    /**
     * id du tiers
     */
    @Column(name = "mai_tiers_id")
    private Long maiTiersId = 0L;

    /**
     * raison sociale ou nom et prenom du tiers
     */
    @Column(name = "mai_tiers_rs")
    private String maiTiersRs;

    /**
     * id du patient
     */
    @Column(name = "mai_patient_id")
    private Long maiPatientId = 0L;

    /**
     * nom prenom patient
     */
    @Column(name = "mai_patient_nom")
    private String maiPatientNom;

    /**
     * id agent
     */
    @Column(name = "mai_agent_id")
    private Long maiAgentId = 0L;

    /**
     * nom prenom agent
     */
    @Column(name = "mai_agent_nom")
    private String maiAgentNom;

    /**
     * destinataire
     */
    @Column(name = "mai_destinataire")
    private String maiDestinataire;

    /**
     * copie a
     */
    @Column(name = "mai_cc")
    private String maiCc;

    /**
     * copie cachee a
     */
    @Column(name = "mai_cci")
    private String maiCci;

    /**
     * activite commerciale
     */
    @Column(name = "mai_activite")
    private String maiActivite;

    /**
     * service
     */
    @Column(name = "mai_service")
    private String maiService;

    /**
     * 0=sans pj 1=avec pj
     */
    @Column(name = "mai_pj")
    private Integer maiPj = 0;

    /**
     * corps du mail
     */
    @Column(name = "mai_corps")
    private String maiCorps;

    /**
     * sens du mail avant suppression
     */
    @Column(name = "mai_sens_old")
    private Integer maiSensOld = 0;

    /**
     * si vide envoi ok sinon message erreur
     */
    @Column(name = "mai_statut")
    private String maiStatut;

    /**
     * true si envoie en erreur
     */
    @Column(name = "mai_erreur")
    private Boolean maiErreur = Boolean.FALSE;

    /**
     * taille
     */
    @Column(name = "mai_taille")
    private Integer maiTaille = 0;

}
