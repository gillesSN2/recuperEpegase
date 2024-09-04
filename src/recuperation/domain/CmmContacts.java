package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_contacts")
public class CmmContacts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "con_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conId;

    /**
     * date de creation
     */
    @Column(name = "con_date_creat")
    private LocalDateTime conDateCreat;

    /**
     * date de modification
     */
    @Column(name = "con_date_modif")
    private LocalDateTime conDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "con_user_creat")
    private Long conUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "con_user_modif")
    private Long conUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "con_etat")
    private Integer conEtat = 0;

    /**
     * nom
     */
    @Column(name = "con_nom")
    private String conNom;

    /**
     * prenom
     */
    @Column(name = "con_prenom")
    private String conPrenom;

    /**
     * nom prenom
     */
    @Column(name = "con_patronyme")
    private String conPatronyme;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "con_civilite")
    private String conCivilite;

    /**
     * pays
     */
    @Column(name = "con_nom_pays")
    private String conNomPays;

    /**
     * code de la langue
     */
    @Column(name = "con_langue")
    private String conLangue;

    /**
     * fonction du contact
     */
    @Column(name = "con_fonction")
    private String conFonction;

    /**
     * imputation service
     */
    @Column(name = "con_service")
    private String conService;

    /**
     * date de naissance
     */
    @Column(name = "con_date_naissance")
    private LocalDate conDateNaissance;

    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date d anniversaire
     */
    @Column(name = "con_anniversaire")
    private String conAnniversaire;

    /**
     * telephone domicile
     */
    @Column(name = "con_tel_bur")
    private String conTelBur;

    /**
     * telephone domicile
     */
    @Column(name = "con_tel_dom")
    private String conTelDom;

    /**
     * mobile 1
     */
    @Column(name = "con_cel1")
    private String conCel1;

    /**
     * mobile 2
     */
    @Column(name = "con_cel2")
    private String conCel2;

    /**
     * mobile 3
     */
    @Column(name = "con_cel3")
    private String conCel3;

    /**
     * fax
     */
    @Column(name = "con_fax")
    private String conFax;

    /**
     * adresse
     */
    @Column(name = "con_adresse")
    private String conAdresse;

    /**
     * no rue
     */
    @Column(name = "con_rue")
    private String conRue;

    /**
     * no de lot
     */
    @Column(name = "con_lot")
    private String conLot;

    /**
     * no ilot
     */
    @Column(name = "con_ilot")
    private String conIlot;

    /**
     * batiment
     */
    @Column(name = "con_batiment")
    private String conBatiment;

    /**
     * no porte
     */
    @Column(name = "con_porte")
    private String conPorte;

    /**
     * escalier
     */
    @Column(name = "con_escalier")
    private String conEscalier;

    /**
     * ascenseur
     */
    @Column(name = "con_ascensseur")
    private String conAscensseur;

    /**
     * quantier
     */
    @Column(name = "con_quartier")
    private String conQuartier;

    /**
     * commune
     */
    @Column(name = "con_commune")
    private String conCommune;

    /**
     * departement
     */
    @Column(name = "con_departe")
    private String conDeparte;

    /**
     * zone
     */
    @Column(name = "con_zone")
    private String conZone;

    /**
     * boite postale
     */
    @Column(name = "con_bp")
    private String conBp;

    /**
     * cedex
     */
    @Column(name = "con_cedex")
    private String conCedex;

    /**
     * ville
     */
    @Column(name = "con_ville")
    private String conVille;

    /**
     * adresse yahoo
     */
    @Column(name = "con_yahoo")
    private String conYahoo;

    /**
     * adresse msn
     */
    @Column(name = "con_msn")
    private String conMsn;

    /**
     * adresse skype
     */
    @Column(name = "con_skype")
    private String conSkype;

    /**
     * adresse aol
     */
    @Column(name = "con_aol")
    private String conAol;

    /**
     * mail 1
     */
    @Column(name = "con_mail1")
    private String conMail1;

    /**
     * mail 2
     */
    @Column(name = "con_mail2")
    private String conMail2;

    /**
     * mail 3
     */
    @Column(name = "con_mail3")
    private String conMail3;

    /**
     * mail 4
     */
    @Column(name = "con_mail4")
    private String conMail4;

    /**
     * mail 5
     */
    @Column(name = "con_mail5")
    private String conMail5;

    /**
     * blog
     */
    @Column(name = "con_blog")
    private String conBlog;

    /**
     * adresse web
     */
    @Column(name = "con_web")
    private String conWeb;

    /**
     * observation
     */
    @Column(name = "con_observation")
    private String conObservation;

    /**
     * appreciation
     */
    @Column(name = "con_appreciation")
    private String conAppreciation;

    /**
     * code banque
     */
    @Column(name = "con_num_banque")
    private String conNumBanque;

    /**
     * code guichet
     */
    @Column(name = "con_guichet_banque")
    private String conGuichetBanque;

    /**
     * numero de compte
     */
    @Column(name = "con_compte_banque")
    private String conCompteBanque;

    /**
     * cle rib
     */
    @Column(name = "con_cle_banque")
    private String conCleBanque;

    /**
     * code iban
     */
    @Column(name = "con_iban")
    private String conIban;

    /**
     * code swift
     */
    @Column(name = "con_swift")
    private String conSwift;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    /**
     * code journal de la banque
     */
    @Column(name = "con_journal")
    private String conJournal;

    /**
     * mot de passe espace client
     */
    @Column(name = "con_pw_espace_client")
    private String conPwEspaceClient;

}
