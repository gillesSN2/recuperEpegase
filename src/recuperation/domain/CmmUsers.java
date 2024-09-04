package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_users")
public class CmmUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;

    /**
     * date de creation
     */
    @Column(name = "usr_date_creat")
    private LocalDateTime usrDateCreat;

    /**
     * date de modification
     */
    @Column(name = "usr_date_modif")
    private LocalDateTime usrDateModif;

    /**
     * user de creation
     */
    @Column(name = "usr_user_creat")
    private Long usrUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "usr_user_modif")
    private Long usrUserModif = 0L;

    /**
     * 0=interdit 1=autorise
     */
    @Column(name = "usr_etat")
    private Integer usrEtat = 0;

    /**
     * civilite suivant fichier xml
     */
    @Column(name = "usr_civilite")
    private String usrCivilite;

    /**
     * nom du compte
     */
    @Column(name = "usr_nom")
    private String usrNom;

    /**
     * prenom du compte
     */
    @Column(name = "usr_prenom")
    private String usrPrenom;

    /**
     * nom et prenom
     */
    @Column(name = "usr_patronyme")
    private String usrPatronyme;

    /**
     * login
     */
    @Column(name = "usr_login")
    private String usrLogin;

    /**
     * mot de passe
     */
    @Column(name = "usr_pw")
    private String usrPw;

    /**
     * 0=pas de changement du mot de passe 1=changement tous les mois
     */
    @Column(name = "usr_change")
    private Integer usrChange = 0;

    /**
     * code secret
     */
    @Column(name = "usr_code_secret")
    private String usrCodeSecret;

    /**
     * 0 hors connexion 1 conecte
     */
    @Column(name = "usr_connexion")
    private Integer usrConnexion = 0;

    /**
     * 0=user standard 1=co-administrateur 2=administrateur principal 3=maintenance 4=maintenance special
     */
    @Column(name = "usr_systeme")
    private Integer usrSysteme = 0;

    /**
     * date de naissance
     */
    @Column(name = "usr_date_naissance")
    private LocalDate usrDateNaissance;

    /**
     * periode anniversaire JJ MM par rapport aÃ‚Â  la date anniversaire
     */
    @Column(name = "usr_anniversaire")
    private String usrAnniversaire;

    /**
     * langue du user
     */
    @Column(name = "usr_langue")
    private String usrLangue;

    /**
     * template du user
     */
    @Column(name = "usr_templates")
    private String usrTemplates;

    /**
     * themes du user
     */
    @Column(name = "usr_themes")
    private String usrThemes;

    /**
     * code du groupe
     */
    @Column(name = "usr_collaboration")
    private String usrCollaboration;

    /**
     * fonction du user
     */
    @Column(name = "usr_fonction")
    private String usrFonction;

    /**
     * adresse
     */
    @Column(name = "usr_adresse")
    private String usrAdresse;

    /**
     * boite postale
     */
    @Column(name = "usr_bp")
    private String usrBp;

    /**
     * ville
     */
    @Column(name = "usr_ville")
    private String usrVille;

    /**
     * nom du pays
     */
    @Column(name = "usr_nom_pays")
    private String usrNomPays;

    /**
     * telephone bureau
     */
    @Column(name = "usr_tel_bureau")
    private String usrTelBureau;

    /**
     * telehone domicile
     */
    @Column(name = "usr_tel_domicile")
    private String usrTelDomicile;

    /**
     * mobile 1
     */
    @Column(name = "usr_cel1")
    private String usrCel1;

    /**
     * mobile 2
     */
    @Column(name = "usr_cel2")
    private String usrCel2;

    /**
     * mobile 3
     */
    @Column(name = "usr_cel3")
    private String usrCel3;

    /**
     * 0=acces collaboratif 1=acces total
     */
    @Column(name = "usr_acces_mail")
    private Integer usrAccesMail = 0;

    /**
     * mail du compte
     */
    @Column(name = "usr_mail")
    private String usrMail;

    /**
     * compte yahoo
     */
    @Column(name = "usr_yahoo")
    private String usrYahoo;

    /**
     * compte msn
     */
    @Column(name = "usr_msn")
    private String usrMsn;

    /**
     * compte skype
     */
    @Column(name = "usr_skype")
    private String usrSkype;

    /**
     * compte aol
     */
    @Column(name = "usr_aol")
    private String usrAol;

    /**
     * date derniere connexion
     */
    @Column(name = "usr_last_log")
    private LocalDateTime usrLastLog;

    /**
     * date premiere connexion
     */
    @Column(name = "usr_first_log")
    private LocalDateTime usrFirstLog;

    /**
     * nombre de connexion
     */
    @Column(name = "usr_nb_log")
    private Double usrNbLog = 0D;

    /**
     * acces photo
     */
    @Column(name = "usr_photo")
    private String usrPhoto;

    /**
     * acces signature
     */
    @Column(name = "usr_signature")
    private String usrSignature;

    /**
     * depot par defaut
     */
    @Column(name = "usr_depot")
    private String usrDepot;

    /**
     * code service
     */
    @Column(name = "usr_service")
    private String usrService;

    /**
     * code departement
     */
    @Column(name = "usr_departement")
    private String usrDepartement;

    /**
     * code site
     */
    @Column(name = "usr_site")
    private String usrSite;

    /**
     * page startup
     */
    @Column(name = "usr_startup")
    private String usrStartup;

    /**
     * cout du prix de revient
     */
    @Column(name = "usr_pr")
    private Double usrPr = 0D;

    /**
     * prix de vente
     */
    @Column(name = "usr_pv")
    private Double usrPv = 0D;

    /**
     * 0 non caissier 1 caissier simple 2 chef caissier
     */
    @Column(name = "usr_caissier")
    private Integer usrCaissier = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usr_caissier_service")
    private Integer usrCaissierService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_recus")
    private Integer usrRecus = 0;

    /**
     * 0 acces a tous les agents 1 acces uniquement aux agents non proteges
     */
    @Column(name = "usr_paye")
    private Integer usrPaye = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usr_paye_service")
    private Integer usrPayeService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_tiers")
    private Integer usrTiers = 0;

    /**
     * 0 acces prive 1 acces total inutilise
     */
    @Column(name = "usr_planning")
    private Integer usrPlanning = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usr_planning_service")
    private String usrPlanningService;

    /**
     * 0 copie mail 1 sans copie mail
     */
    @Column(name = "usr_mail_copie")
    private Integer usrMailCopie = 0;

    /**
     * 0 copie mail 1 sans copie mail
     */
    @Column(name = "usr_mail_parapheur")
    private Integer usrMailParapheur = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usr_achats_service")
    private Integer usrAchatsService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_achats")
    private Integer usrAchats = 0;

    /**
     * 0 responsable libre 1 responsable = user
     */
    @Column(name = "usr_resp_achats")
    private Integer usrRespAchats = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usr_ventes_service")
    private Integer usrVentesService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_ventes")
    private Integer usrVentes = 0;

    /**
     * 0=sans 1=facturation + caissier
     */
    @Column(name = "usr_facture_caisse")
    private Integer usrFactureCaisse = 0;

    /**
     * 0=commercial libre 1=responsable du client 2=user en cours
     */
    @Column(name = "usr_comm_ventes")
    private Integer usrCommVentes = 0;

    /**
     * 0=commercial libre 1=responsable du fournisseur 2=user en cours
     */
    @Column(name = "usr_comm_achats")
    private Integer usrCommAchats = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_mf")
    private Integer usrMf = 0;

    /**
     * 0=tous les services 1=service du user
     */
    @Column(name = "usrMedical_service")
    private Integer usrmedicalService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "usr_medical")
    private Integer usrMedical = 0;

    /**
     * journaux interdits
     */
    @Column(name = "usr_jrx_interdit")
    private String usrJrxInterdit;

    /**
     * comptes interdits
     */
    @Column(name = "usr_cpt_interdit")
    private String usrCptInterdit;

    /**
     * 0=journaux reserves autorises 1=journaux reserves interdits
     */
    @Column(name = "usr_jrx_reserve")
    private Integer usrJrxReserve = 0;

    /**
     * 0=tous les brouillard 1=mes brouillards
     */
    @Column(name = "usr_acces_brouillard")
    private Integer usrAccesBrouillard = 0;

    /**
     * 0=sans correction 1=acces correction
     */
    @Column(name = "usr_acces_correction")
    private Integer usrAccesCorrection = 0;

    /**
     * achat DA 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_da")
    private Integer usrAchTrfDa = 0;

    /**
     * achat cotation 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_cot")
    private Integer usrAchTrfCot = 0;

    /**
     * achat commande 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_cmd")
    private Integer usrAchTrfCmd = 0;

    /**
     * achat reception 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_rec")
    private Integer usrAchTrfRec = 0;

    /**
     * achat retour 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_ret")
    private Integer usrAchTrfRet = 0;

    /**
     * achat facture 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_fac")
    private Integer usrAchTrfFac = 0;

    /**
     * achat avoir 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_avr")
    private Integer usrAchTrfAvr = 0;

    /**
     * achat note de debit 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_ndd")
    private Integer usrAchTrfNdd = 0;

    /**
     * achat facture de frais 0 autorise 1 interdit
     */
    @Column(name = "usr_ach_trf_fra")
    private Integer usrAchTrfFra = 0;

    /**
     * 0=pump invisible 1=pump non modifiable 2=pump modifiable
     */
    @Column(name = "usr_ach_pump")
    private Integer usrAchPump = 0;

    /**
     * vente besoin 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_bes")
    private Integer usrVteTrfBes = 0;

    /**
     * vente devis 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_dev")
    private Integer usrVteTrfDev = 0;

    /**
     * vente commande 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_bc")
    private Integer usrVteTrfBc = 0;

    /**
     * vente livraison 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_bl")
    private Integer usrVteTrfBl = 0;

    /**
     * vente facture 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_fac")
    private Integer usrVteTrfFac = 0;

    /**
     * vente retour 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_ret")
    private Integer usrVteTrfRet = 0;

    /**
     * vente avoir 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_avr")
    private Integer usrVteTrfAvr = 0;

    /**
     * vente note de debit 0 autorise 1 interdit
     */
    @Column(name = "usr_vte_trf_ndd")
    private Integer usrVteTrfNdd = 0;

    /**
     * 0 sans affichage pump 1 pump affiche sur les documents
     */
    @Column(name = "usr_aff_pump")
    private Integer usrAffPump = 0;

    /**
     * 0=sans affichage prix marche et concurent free 1=acces affichage prix marche
     */
    @Column(name = "usr_aff_pv_marche")
    private Integer usrAffPvMarche = 0;

    /**
     * 0 sans affichage prix plancher 1 prix plancher affiche sur les documents
     */
    @Column(name = "usr_aff_plancher")
    private Integer usrAffPlancher = 0;

    /**
     * 0 remise et rabais libre 1 remise et rabais verrouille
     */
    @Column(name = "usr_ver_remise")
    private Integer usrVerRemise = 0;

    /**
     * 0 pv libre 1 pv verrouille
     */
    @Column(name = "usr_ver_pv")
    private Integer usrVerPv = 0;

    /**
     * 0 serie libre 1 serie verrouille
     */
    @Column(name = "usr_ver_serie")
    private Integer usrVerSerie = 0;

    /**
     * 0 tous les produits 1 les produits du service du user
     */
    @Column(name = "usr_prod_service")
    private Integer usrProdService = 0;

    /**
     * 0 remise et rabais libre 1 remise et rabais verrouille
     */
    @Column(name = "usr_ver_remise_ach")
    private Integer usrVerRemiseAch = 0;

    /**
     * 0 pv libre 1 pv verrouille
     */
    @Column(name = "usr_ver_pa_ach")
    private Integer usrVerPaAch = 0;

    /**
     * 0 serie libre 1 serie verrouille
     */
    @Column(name = "usr_ver_serie_ach")
    private Integer usrVerSerieAch = 0;

    /**
     * 0 tous les produits 1 les produits du service du user
     */
    @Column(name = "usr_prod_service_ach")
    private Integer usrProdServiceAch = 0;

    /**
     * date debut indisponibilite
     */
    @Column(name = "usr_date_debut_indisponibilite")
    private LocalDate usrDateDebutIndisponibilite;

    /**
     * date fin indisponibilite
     */
    @Column(name = "usr_date_fin_indisponibilite")
    private LocalDate usrDateFinIndisponibilite;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_ach")
    private Integer usrDateAch = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_stk")
    private Integer usrDateStk = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_vte")
    private Integer usrDateVte = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_cai")
    private Integer usrDateCai = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_med")
    private Integer usrDateMed = 0;

    /**
     * 0=imputation et tiers visible 1=imputation et tiers masque
     */
    @Column(name = "usr_imput_cai")
    private Integer usrImputCai = 0;

    /**
     * 0=montant modifiable 1=montant verrouille
     */
    @Column(name = "usr_montant_cai")
    private Integer usrMontantCai = 0;

    /**
     * 0=liasse non modifiable 1=liasse modifiable
     */
    @Column(name = "usr_modif_liasse")
    private Integer usrModifLiasse = 0;

    @Column(name = "grp_id", nullable = false)
    private Long grpId;

    /**
     * 0=rabais libre 1=rabais invisible
     */
    @Column(name = "usr_ver_rabais")
    private Integer usrVerRabais = 0;

    /**
     * 0 rabais libre 1 rabais invisible
     */
    @Column(name = "usr_ver_rabais_ach")
    private Integer usrVerRabaisAch = 0;

    /**
     * 0=tiers visible 1=tiers masque
     */
    @Column(name = "usr_tiers_cai")
    private Integer usrTiersCai = 0;

    /**
     * 0=mibelle modifiable 1=livelle verrouille
     */
    @Column(name = "usr_libelle_cai")
    private Integer usrLibelleCai = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_office")
    private Integer usrSignatureOffice = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_compta")
    private Integer usrSignatureCompta = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_paye")
    private Integer usrSignaturePaye = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_parc")
    private Integer usrSignatureParc = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_achats")
    private Integer usrSignatureAchats = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_ventes")
    private Integer usrSignatureVentes = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_caisse")
    private Integer usrSignatureCaisse = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_medical")
    private Integer usrSignatureMedical = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_microfinance")
    private Integer usrSignatureMicrofinance = 0;

    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    @Column(name = "usr_signature_education")
    private Integer usrSignatureEducation = 0;

    /**
     * 0=pas autorise a vendre 1=autorise a vendre
     */
    @Column(name = "usr_vendeur")
    private Integer usrVendeur = 0;

    /**
     * id du responsable du non signataire
     */
    @Column(name = "usr_responsablr_ventes")
    private Long usrResponsablrVentes = 0L;

    /**
     * 0=sans depense directe 1=depense directe
     */
    @Column(name = "usr_depense")
    private Integer usrDepense = 0;

    /**
     * 0=sans recette directe 1=recette directe
     */
    @Column(name = "usr_recette")
    private Integer usrRecette = 0;

    /**
     * 0=sans modif 1=modification piece
     */
    @Column(name = "usr_modif")
    private Integer usrModif = 0;

    /**
     * id du responsable
     */
    @Column(name = "usr_id_resposnable")
    private Long usrIdResposnable = 0L;

    /**
     * nom du responsable
     */
    @Column(name = "usr_nom_resposnable")
    private String usrNomResposnable;

    /**
     * 0=sans transfert directe 1=transfert directe
     */
    @Column(name = "usr_transfert")
    private Integer usrTransfert = 0;

    /**
     * id equipe
     */
    @Column(name = "usr_id_equipe")
    private Long usrIdEquipe = 0L;

    /**
     * nom equipe
     */
    @Column(name = "usr_nom_equipe")
    private String usrNomEquipe;

    /**
     * 0=sans modif 1=suppression piece
     */
    @Column(name = "usr_caissier_delete")
    private Integer usrCaissierDelete = 0;

    /**
     * feuilles de calcule des bulletis interdites
     */
    @Column(name = "usr_feuille_interdite")
    private String usrFeuilleInterdite;

    /**
     * mot de passe espace client
     */
    @Column(name = "usr_pw_espace_client")
    private String usrPwEspaceClient;

    /**
     * 0=modification du bulletin 1=interdiction modification bulletin
     */
    @Column(name = "usr_paye_bulletin")
    private Integer usrPayeBulletin = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_livre")
    private Integer usrDateLivre = 0;

    /**
     * 0=date non modifiable 1=date modifiable
     */
    @Column(name = "usr_date_prc")
    private Integer usrDatePrc = 0;

    /**
     * % de commission du user
     */
    @Column(name = "usr_comm_pourcentage")
    private Float usrCommPourcentage = 0F;

    /**
     * 1=calcul sur le ca du user 2=calcul sur le ca de l equipe 3=calcul sur le ca global
     */
    @Column(name = "usr_comm_type")
    private Integer usrCommType = 0;

    /**
     * 0= sans lissage 1=lissage autorise
     */
    @Column(name = "usr_lissage")
    private Integer usrLissage = 0;

    /**
     * 0= ne peut pas changer de dossier 1=peut changer les dossiers achats
     */
    @Column(name = "usr_chg_dos_achat")
    private Integer usrChgDosAchat = 0;

    /**
     * 0=peut creer societe en cabinet 1=ne peut pas creer de societe en cabinet
     */
    @Column(name = "usr_creation_societe")
    private Integer usrCreationSociete = 0;

    /**
     * 0=sans alerte paye 1=avec alerte paye
     */
    @Column(name = "usr_paye_alerte")
    private Integer usrPayeAlerte = 0;

    /**
     * 0=modification du contrat 1=interdiction modification du contrat
     */
    @Column(name = "usr_paye_contrat")
    private Integer usrPayeContrat = 0;

    /**
     * 0=pointage prive 1=acces a tous les pointages
     */
    @Column(name = "usr_pay_pointage")
    private Integer usrPayPointage = 0;

    /**
     * id du tiers pour acces compte guest
     */
    @Column(name = "usr_id_tiers_guest")
    private Long usrIdTiersGuest = 0L;

    /**
     * nom du tiers pour acces compte guest
     */
    @Column(name = "usr_nom_tiers_guest")
    private String usrNomTiersGuest;

    /**
     * 0=pas de modification de serie 1=avec modification de serie
     */
    @Column(name = "usr_modif_serie_vte")
    private Integer usrModifSerieVte = 0;

    /**
     * 0=pas de modification de serie 1=avec modification de serie
     */
    @Column(name = "usr_modif_serie_ach")
    private Integer usrModifSerieAch = 0;

    /**
     * 0=pas alerte sur parc 1=avec alerte parc
     */
    @Column(name = "usr_parc_alerte")
    private Integer usrParcAlerte = 0;

    /**
     * numero de compte pour trf en compta
     */
    @Column(name = "usr_compte")
    private String usrCompte;

}
