package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries")
public class PaySalaries implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salId;

    /**
     * date de creation
     */
    @Column(name = "sal_date_creat")
    private LocalDateTime salDateCreat;

    /**
     * date de modification
     */
    @Column(name = "sal_date_modif")
    private LocalDateTime salDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "sal_user_creat")
    private Long salUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "sal_user_modif")
    private Long salUserModif = 0L;

    /**
     * matricule
     */
    @Column(name = "sal_matricule")
    private String salMatricule;

    /**
     * photo
     */
    @Column(name = "sal_photo")
    private String salPhoto;

    /**
     * voir nature salarie xml
     */
    @Column(name = "sal_nature")
    private String salNature;

    /**
     * 0=non protege 1=protege
     */
    @Column(name = "sal_protege")
    private Integer salProtege = 0;

    /**
     * 0=actif 1=licencie 2=demissionne 3=decede 4=retraite 5=fin de contrat 6=arret ou suspension
     */
    @Column(name = "sal_etat")
    private Integer salEtat = 0;

    /**
     * 0=stage 1=cdd 2=cdi 3=prestataire
     */
    @Column(name = "sal_type")
    private Integer salType = 0;

    /**
     * nom
     */
    @Column(name = "sal_nom")
    private String salNom;

    /**
     * nom de jeune fille
     */
    @Column(name = "sal_nom_jf")
    private String salNomJf;

    /**
     * prenom
     */
    @Column(name = "sal_prenom")
    private String salPrenom;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "sal_civilite")
    private String salCivilite;

    /**
     * pays
     */
    @Column(name = "sal_nom_pays")
    private String salNomPays;

    /**
     * code de la langue
     */
    @Column(name = "sal_langue")
    private String salLangue;

    /**
     * fonction
     */
    @Column(name = "sal_fonction")
    private String salFonction;

    /**
     * imputation service
     */
    @Column(name = "sal_site")
    private String salSite;

    /**
     * imputation service
     */
    @Column(name = "sal_departement")
    private String salDepartement;

    /**
     * imputation service
     */
    @Column(name = "sal_service")
    private String salService;

    /**
     * imputation activite
     */
    @Column(name = "sal_acticvite")
    private String salActicvite;

    /**
     * imputation budget
     */
    @Column(name = "sal_budget")
    private String salBudget;

    /**
     * imputation parc
     */
    @Column(name = "sal_parc")
    private String salParc;

    /**
     * date de naissance
     */
    @Column(name = "sal_date_naissance")
    private LocalDate salDateNaissance;

    /**
     * lieu de naissance
     */
    @Column(name = "sal_lieu_naissance")
    private String salLieuNaissance;

    /**
     * pays de naissance
     */
    @Column(name = "sal_pays_naissance")
    private String salPaysNaissance;

    /**
     * code pays de naissance
     */
    @Column(name = "sal_code_naissance")
    private String salCodeNaissance;

    /**
     * nationnalite
     */
    @Column(name = "sal_nationnalite")
    private String salNationnalite;

    /**
     * ethnie
     */
    @Column(name = "sal_ethnie")
    private String salEthnie;

    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date d anniversaire
     */
    @Column(name = "sal_anniversaire")
    private String salAnniversaire;

    /**
     * telephone domicile
     */
    @Column(name = "sal_tel_bur")
    private String salTelBur;

    /**
     * telephone domicile
     */
    @Column(name = "sal_tel_dom")
    private String salTelDom;

    /**
     * mobile 1
     */
    @Column(name = "sal_cel1")
    private String salCel1;

    /**
     * mobile 2
     */
    @Column(name = "sal_cel2")
    private String salCel2;

    /**
     * mobile 3
     */
    @Column(name = "sal_cel3")
    private String salCel3;

    /**
     * adresse
     */
    @Column(name = "sal_adresse")
    private String salAdresse;

    /**
     * no rue
     */
    @Column(name = "sal_rue")
    private String salRue;

    /**
     * no de lot
     */
    @Column(name = "sal_lot")
    private String salLot;

    /**
     * no ilot
     */
    @Column(name = "sal_ilot")
    private String salIlot;

    /**
     * batiment
     */
    @Column(name = "sal_batiment")
    private String salBatiment;

    /**
     * no porte
     */
    @Column(name = "sal_porte")
    private String salPorte;

    /**
     * escalier
     */
    @Column(name = "sal_escalier")
    private String salEscalier;

    /**
     * ascenseur
     */
    @Column(name = "sal_ascensseur")
    private String salAscensseur;

    /**
     * etage
     */
    @Column(name = "sal_etage")
    private String salEtage;

    /**
     * quantier
     */
    @Column(name = "sal_quartier")
    private String salQuartier;

    /**
     * commune
     */
    @Column(name = "sal_commune")
    private String salCommune;

    /**
     * departement
     */
    @Column(name = "sal_departe")
    private String salDeparte;

    /**
     * zone
     */
    @Column(name = "sal_zone")
    private String salZone;

    /**
     * boite postale
     */
    @Column(name = "sal_bp")
    private String salBp;

    /**
     * ville
     */
    @Column(name = "sal_ville")
    private String salVille;

    /**
     * adresse yahoo
     */
    @Column(name = "sal_yahoo")
    private String salYahoo;

    /**
     * adresse msn
     */
    @Column(name = "sal_msn")
    private String salMsn;

    /**
     * adresse skype
     */
    @Column(name = "sal_skype")
    private String salSkype;

    /**
     * adresse aol
     */
    @Column(name = "sal_aol")
    private String salAol;

    /**
     * mail 1
     */
    @Column(name = "sal_mail1")
    private String salMail1;

    /**
     * observation
     */
    @Column(name = "sal_observation")
    private String salObservation;

    /**
     * code banque
     */
    @Column(name = "sal_num_banque")
    private String salNumBanque;

    /**
     * code guichet
     */
    @Column(name = "sal_guichet_banque")
    private String salGuichetBanque;

    /**
     * numero de compte
     */
    @Column(name = "sal_compte_banque")
    private String salCompteBanque;

    /**
     * cle rib
     */
    @Column(name = "sal_cle_banque")
    private String salCleBanque;

    /**
     * code iban
     */
    @Column(name = "sal_iban")
    private String salIban;

    /**
     * code swift
     */
    @Column(name = "sal_swift")
    private String salSwift;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "sal_genre")
    private Integer salGenre = 0;

    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    @Column(name = "sal_sit_famille")
    private Integer salSitFamille = 0;

    /**
     * nombre enfant
     */
    @Column(name = "sal_nb_enfant")
    private Integer salNbEnfant = 0;

    /**
     * nombre de parts fiscales
     */
    @Column(name = "sal_nb_part_fiscal")
    private Float salNbPartFiscal = 0F;

    /**
     * nombre de femme
     */
    @Column(name = "sal_nb_femme")
    private Integer salNbFemme = 0;

    /**
     * nombre de parts trimf
     */
    @Column(name = "sal_nb_part_trimf")
    private Float salNbPartTrimf = 0F;

    /**
     * regime de conges : nb jour de conges
     */
    @Column(name = "sal_nb_jour_cp")
    private Float salNbJourCp = 0F;

    /**
     * regime de conges : nb jour de travail
     */
    @Column(name = "sal_nb_jour_tr")
    private Float salNbJourTr = 0F;

    /**
     * date mariage
     */
    @Column(name = "sal_date_marie")
    private LocalDate salDateMarie;

    /**
     * date divorce
     */
    @Column(name = "sal_date_divorce")
    private LocalDate salDateDivorce;

    /**
     * date veuf
     */
    @Column(name = "sal_date_veuf")
    private LocalDate salDateVeuf;

    /**
     * date Concubinage
     */
    @Column(name = "sal_date_concubinage")
    private LocalDate salDateConcubinage;

    /**
     * date pacs
     */
    @Column(name = "sal_date_pacs")
    private LocalDate salDatePacs;

    /**
     * code convention du salarie
     */
    @Column(name = "sal_convention")
    private String salConvention;

    /**
     * libelle convention du salarie
     */
    @Column(name = "sal_lib_convention")
    private String salLibConvention;

    /**
     * code centres impots xml
     */
    @Column(name = "sal_Cod_Centres_Impots")
    private String salCodCentresImpots;

    /**
     * libelle centres impots xml
     */
    @Column(name = "sal_Lib_Centres_Impots")
    private String salLibCentresImpots;

    /**
     * code classement xml
     */
    @Column(name = "sal_classement")
    private String salClassement;

    /**
     * libelle classement xml
     */
    @Column(name = "sal_lib_classement")
    private String salLibClassement;

    /**
     * code niveau emploi xml
     */
    @Column(name = "sal_niv_emploi")
    private String salNivEmploi;

    /**
     * libelle niveau emploi xml
     */
    @Column(name = "sal_lib_niv_emploi")
    private String salLibNivEmploi;

    /**
     * code grille convention xml
     */
    @Column(name = "sal_grille")
    private String salGrille;

    /**
     * libelle grille convention xml
     */
    @Column(name = "sal_lib_grille")
    private String salLibGrille;

    /**
     * date entree
     */
    @Column(name = "sal_date_entree")
    private LocalDate salDateEntree;

    /**
     * date sortie
     */
    @Column(name = "sal_date_sortie")
    private LocalDate salDateSortie;

    /**
     * motif de sortie
     */
    @Column(name = "sal_motif_sortie")
    private String salMotifSortie;

    /**
     * date debut impot
     */
    @Column(name = "sal_date_impot")
    private LocalDate salDateImpot;

    /**
     * numero de feuille de calcul
     */
    @Column(name = "sal_feuille")
    private Integer salFeuille = 0;

    /**
     * numero carte identite
     */
    @Column(name = "sal_num_ci")
    private String salNumCi;

    /**
     * date delivrance carte identite
     */
    @Column(name = "sal_date_ci")
    private LocalDate salDateCi;

    /**
     * carte identite delivree par
     */
    @Column(name = "sal_delivre_ci")
    private String salDelivreCi;

    /**
     * lieu de delivrance
     */
    @Column(name = "sal_lieu_ci")
    private String salLieuCi;

    /**
     * numero securite sociale
     */
    @Column(name = "sal_num_secu")
    private String salNumSecu;

    /**
     * date inscritpion a la securite sociale
     */
    @Column(name = "sal_date_secu")
    private LocalDate salDateSecu;

    /**
     * numero securite sociale
     */
    @Column(name = "sal_num_retraite")
    private String salNumRetraite;

    /**
     * date inscritpion a la retaite
     */
    @Column(name = "sal_date_retraite")
    private LocalDate salDateRetraite;

    /**
     * approbation inspection
     */
    @Column(name = "sal_approb_insp")
    private String salApprobInsp;

    /**
     * visa enregistrement
     */
    @Column(name = "sal_visa_enreg")
    private String salVisaEnreg;

    /**
     * classe de recrutement
     */
    @Column(name = "sal_classe_recrut")
    private String salClasseRecrut;

    /**
     * service militaire effectue
     */
    @Column(name = "sal_service_mil")
    private Boolean salServiceMil = Boolean.FALSE;

    /**
     * corps appartenance
     */
    @Column(name = "sal_corps_app")
    private String salCorpsApp;

    /**
     * grade
     */
    @Column(name = "sal_grade")
    private String salGrade;

    /**
     * date entree dans le pays
     */
    @Column(name = "sal_date_entree_pays")
    private LocalDate salDateEntreePays;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    @Column(name = "sal_mode_reglement")
    private Integer salModeReglement = 0;

    /**
     * nom du pere
     */
    @Column(name = "sal_pere")
    private String salPere;

    /**
     * nom de la mere
     */
    @Column(name = "sal_mere")
    private String salMere;

    /**
     * compte du net
     */
    @Column(name = "sal_compte_net")
    private String salCompteNet;

    /**
     * compte des acomptes
     */
    @Column(name = "sal_compte_acompte")
    private String salCompteAcompte;

    /**
     * compte des avances
     */
    @Column(name = "sal_compte_avance")
    private String salCompteAvance;

    /**
     * cle analytique 1
     */
    @Column(name = "sal_cle_anal1")
    private String salCleAnal1;

    /**
     * libelle cle analytique 1
     */
    @Column(name = "sal_lib_cle_anal1")
    private String salLibCleAnal1;

    /**
     * cle analytique 2
     */
    @Column(name = "sal_cle_anal2")
    private String salCleAnal2;

    /**
     * libelle cle analytique 2
     */
    @Column(name = "sal_lib_cle_anal2")
    private String salLibCleAnal2;

    /**
     * profession de formation
     */
    @Column(name = "sal_profession")
    private String salProfession;

    /**
     * imputation activite
     */
    @Column(name = "sal_activite")
    private String salActivite;

    /**
     * numero cnamgs
     */
    @Column(name = "sal_num_cnamgs")
    private String salNumCnamgs;

    /**
     * date inscritpion a la cnamgs
     */
    @Column(name = "sal_date_cnamgs")
    private LocalDate salDateCnamgs;

    /**
     * si vrai alors participe mise en relation des celibataires
     */
    @Column(name = "sal_mise_relation")
    private Boolean salMiseRelation = Boolean.FALSE;

    /**
     * 0=disponible 1=indisponible
     */
    @Column(name = "sal_disponible")
    private Integer salDisponible = 0;

    /**
     * disponible a partir du
     */
    @Column(name = "sal_dispo_du")
    private LocalDate salDispoDu;

    /**
     * disponible jusqu au
     */
    @Column(name = "sal_dispo_Au")
    private LocalDate salDispoAu;

    /**
     * 0=mobile 1=mobile sauf 2=entierement mobile
     */
    @Column(name = "sal_mobile")
    private Integer salMobile = 0;

    /**
     * exception a la mobilite
     */
    @Column(name = "sal_mobile_sauf")
    private String salMobileSauf;

    /**
     * domaine de competence 1
     */
    @Column(name = "sal_dom_act1")
    private Boolean salDomAct1 = Boolean.FALSE;

    /**
     * domaine de competence 2
     */
    @Column(name = "sal_dom_act2")
    private Boolean salDomAct2 = Boolean.FALSE;

    /**
     * domaine de competence 3
     */
    @Column(name = "sal_dom_act3")
    private Boolean salDomAct3 = Boolean.FALSE;

    /**
     * domaine de competence 4
     */
    @Column(name = "sal_dom_act4")
    private Boolean salDomAct4 = Boolean.FALSE;

    /**
     * domaine de competence 5
     */
    @Column(name = "sal_dom_act5")
    private Boolean salDomAct5 = Boolean.FALSE;

    /**
     * domaine de competence 6
     */
    @Column(name = "sal_dom_act6")
    private Boolean salDomAct6 = Boolean.FALSE;

    /**
     * domaine de competence 7
     */
    @Column(name = "sal_dom_act7")
    private Boolean salDomAct7 = Boolean.FALSE;

    /**
     * domaine de competence 8
     */
    @Column(name = "sal_dom_act8")
    private Boolean salDomAct8 = Boolean.FALSE;

    /**
     * domaine de competence 9
     */
    @Column(name = "sal_dom_act9")
    private Boolean salDomAct9 = Boolean.FALSE;

    /**
     * domaine de competence 1
     */
    @Column(name = "sal_competence1")
    private Boolean salCompetence1 = Boolean.FALSE;

    /**
     * domaine de competence 2
     */
    @Column(name = "sal_competence2")
    private Boolean salCompetence2 = Boolean.FALSE;

    /**
     * domaine de competence 3
     */
    @Column(name = "sal_competence3")
    private Boolean salCompetence3 = Boolean.FALSE;

    /**
     * domaine de competence 4
     */
    @Column(name = "sal_competence4")
    private Boolean salCompetence4 = Boolean.FALSE;

    /**
     * domaine de competence 5
     */
    @Column(name = "sal_competence5")
    private Boolean salCompetence5 = Boolean.FALSE;

    /**
     * domaine de competence 6
     */
    @Column(name = "sal_competence6")
    private Boolean salCompetence6 = Boolean.FALSE;

    /**
     * domaine de competence 7
     */
    @Column(name = "sal_competence7")
    private Boolean salCompetence7 = Boolean.FALSE;

    /**
     * domaine de competence 8
     */
    @Column(name = "sal_competence8")
    private Boolean salCompetence8 = Boolean.FALSE;

    /**
     * document CV
     */
    @Column(name = "sal_document")
    private String salDocument;

    /**
     * numero amo
     */
    @Column(name = "sal_num_amo")
    private String salNumAmo;

    /**
     * date inscritpion a amo
     */
    @Column(name = "sal_date_amo")
    private LocalDate salDateAmo;

    /**
     * numero allocataire
     */
    @Column(name = "sal_num_allocataire")
    private String salNumAllocataire;

    /**
     * date inscritpion a allocataire
     */
    @Column(name = "sal_date_allocataire")
    private LocalDate salDateAllocataire;

    /**
     * domaine de competence 9
     */
    @Column(name = "sal_competence9")
    private Boolean salCompetence9 = Boolean.FALSE;

    /**
     * domaine de competence 10
     */
    @Column(name = "sal_competence10")
    private Boolean salCompetence10 = Boolean.FALSE;

    /**
     * domaine de competence 11
     */
    @Column(name = "sal_competence11")
    private Boolean salCompetence11 = Boolean.FALSE;

    /**
     * nombre annee experience
     */
    @Column(name = "sal_nb_annee")
    private Integer salNbAnnee = 0;

    /**
     * lecture francais
     */
    @Column(name = "sal_fr_lire")
    private Integer salFrLire = 0;

    /**
     * ecriture francais
     */
    @Column(name = "sal_fr_ecrire")
    private Integer salFrEcrire = 0;

    /**
     * dialogue francais
     */
    @Column(name = "sal_fr_parler")
    private Integer salFrParler = 0;

    /**
     * lecture anglais
     */
    @Column(name = "sal_us_lire")
    private Integer salUsLire = 0;

    /**
     * ecriture anglais
     */
    @Column(name = "sal_us_ecrire")
    private Integer salUsEcrire = 0;

    /**
     * dialogue anglais
     */
    @Column(name = "sal_us_parler")
    private Integer salUsParler = 0;

    /**
     * lecture local
     */
    @Column(name = "sal_loc_lire")
    private Integer salLocLire = 0;

    /**
     * ecriture local
     */
    @Column(name = "sal_loc_ecrire")
    private Integer salLocEcrire = 0;

    /**
     * dialogue local
     */
    @Column(name = "sal_loc_parler")
    private Integer salLocParler = 0;

}
