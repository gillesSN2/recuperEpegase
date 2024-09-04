package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_tiers")
public class CmmTiers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tieId;

    /**
     * date de creation
     */
    @Column(name = "tie_date_creat")
    private LocalDateTime tieDateCreat;

    /**
     * date de modification
     */
    @Column(name = "tie_date_modif")
    private LocalDateTime tieDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "tie_user_creat")
    private Long tieUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "tie_user_modif")
    private Long tieUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprime
     */
    @Column(name = "tie_etat")
    private Integer tieEtat = 0;

    /**
     * raison social ou nom
     */
    @Column(name = "tie_raison_sociale_nom")
    private String tieRaisonSocialeNom;

    /**
     * sigle
     */
    @Column(name = "tie_sigle")
    private String tieSigle;

    /**
     * 0=fournisseur 1=suspect 2=prospect 3=client 6=paroissien 99=divers
     */
    @Column(name = "tie_type")
    private String tieType;

    /**
     * lie au fichier xml tiers
     */
    @Column(name = "tie_genre")
    private String tieGenre;

    /**
     * categorie du tiers lie au fichier xml
     */
    @Column(name = "tie_categorie")
    private String tieCategorie;

    /**
     * civilite lie au fichier xml civilite
     */
    @Column(name = "tie_civilite")
    private String tieCivilite;

    /**
     * nom pays
     */
    @Column(name = "tie_nom_pays")
    private String tieNomPays;

    /**
     * code du pays
     */
    @Column(name = "tie_code_pays")
    private String tieCodePays;

    /**
     * code devise
     */
    @Column(name = "tie_devise")
    private String tieDevise;

    /**
     * format devise
     */
    @Column(name = "tie_format_devise")
    private Integer tieFormatDevise = 0;

    /**
     * code langue
     */
    @Column(name = "tie_langue")
    private String tieLangue;

    /**
     * 0=adresse simplifie 1=adresse complete
     */
    @Column(name = "tie_type_adresse")
    private Integer tieTypeAdresse;

    /**
     * telephone domicile
     */
    @Column(name = "tie_tel_dom")
    private String tieTelDom;

    /**
     * mobile 1
     */
    @Column(name = "tie_cel1")
    private String tieCel1;

    /**
     * mobile 2
     */
    @Column(name = "tie_cel2")
    private String tieCel2;

    /**
     * mobile 3
     */
    @Column(name = "tie_cel3")
    private String tieCel3;

    /**
     * telephone voiture
     */
    @Column(name = "tie_tel_voiture")
    private String tieTelVoiture;

    /**
     * prenom
     */
    @Column(name = "tie_prenom")
    private String tiePrenom;

    /**
     * nom de jeune fille
     */
    @Column(name = "tie_nom_jf")
    private String tieNomJf;

    /**
     * surnom
     */
    @Column(name = "tie_surnom")
    private String tieSurnom;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "tie_sexe")
    private Integer tieSexe = 0;

    /**
     * date de naissance
     */
    @Column(name = "tie_date_naissance")
    private LocalDate tieDateNaissance;

    /**
     * lieu de naissance
     */
    @Column(name = "tie_lieu_naissance")
    private String tieLieuNaissance;

    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date de naissance
     */
    @Column(name = "tie_anniversaire")
    private String tieAnniversaire;

    /**
     * date du mariage
     */
    @Column(name = "tie_date_mariage")
    private LocalDate tieDateMariage;

    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date du mariage
     */
    @Column(name = "tie_anniversaire_mariage")
    private String tieAnniversaireMariage;

    /**
     * date du mariage
     */
    @Column(name = "tie_date_deces")
    private LocalDate tieDateDeces;

    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date du deces
     */
    @Column(name = "tie_anniversaire_deces")
    private String tieAnniversaireDeces;

    /**
     * observations
     */
    @Column(name = "tie_observations")
    private String tieObservations;

    /**
     * activite principale
     */
    @Column(name = "tie_activite1")
    private String tieActivite1;

    /**
     * activite livre
     */
    @Column(name = "tie_activite2")
    private String tieActivite2;

    /**
     * source du tiers
     */
    @Column(name = "tie_source")
    private String tieSource;

    /**
     * 0=public 1=collaborateur 2=prive
     */
    @Column(name = "tie_visibilite")
    private Integer tieVisibilite = 0;

    /**
     * si collaborateur alors code groupe
     */
    @Column(name = "tie_visibilite_grp")
    private String tieVisibiliteGrp;

    /**
     * si prive alors code user createur
     */
    @Column(name = "tie_visibilite_user")
    private Long tieVisibiliteUser = 0L;

    /**
     * adresse
     */
    @Column(name = "tie_adresse")
    private String tieAdresse;

    /**
     * no de rue
     */
    @Column(name = "tie_rue")
    private String tieRue;

    /**
     * no de lot
     */
    @Column(name = "tie_lot")
    private String tieLot;

    /**
     * no illot
     */
    @Column(name = "tie_ilot")
    private String tieIlot;

    /**
     * batiment
     */
    @Column(name = "tie_batiment")
    private String tieBatiment;

    /**
     * no de porte
     */
    @Column(name = "tie_porte")
    private String tiePorte;

    /**
     * etage
     */
    @Column(name = "tie_etage")
    private String tieEtage;

    /**
     * ascenseur
     */
    @Column(name = "tie_ascensseur")
    private String tieAscensseur;

    /**
     * quartier
     */
    @Column(name = "tie_quartier")
    private String tieQuartier;

    /**
     * commune
     */
    @Column(name = "tie_commune")
    private String tieCommune;

    /**
     * departement
     */
    @Column(name = "tie_depart")
    private String tieDepart;

    /**
     * zone
     */
    @Column(name = "tie_zone")
    private String tieZone;

    /**
     * boite postale
     */
    @Column(name = "tie_bp")
    private String tieBp;

    /**
     * cedex
     */
    @Column(name = "tie_cedex")
    private String tieCedex;

    /**
     * ville
     */
    @Column(name = "tie_ville")
    private String tieVille;

    /**
     * telephone bureau 1
     */
    @Column(name = "tie_bur_tel1")
    private String tieBurTel1;

    /**
     * telephone bureau 2
     */
    @Column(name = "tie_bur_tel2")
    private String tieBurTel2;

    /**
     * telephone bureau 3
     */
    @Column(name = "tie_bur_tel3")
    private String tieBurTel3;

    /**
     * fax du bureau
     */
    @Column(name = "tie_bur_fax")
    private String tieBurFax;

    /**
     * telex
     */
    @Column(name = "tie_telex")
    private String tieTelex;

    /**
     * adresse yahoo
     */
    @Column(name = "tie_yahoo")
    private String tieYahoo;

    /**
     * adresse msn
     */
    @Column(name = "tie_msn")
    private String tieMsn;

    /**
     * adresse skype
     */
    @Column(name = "tie_skype")
    private String tieSkype;

    /**
     * adresse aol
     */
    @Column(name = "tie_aol")
    private String tieAol;

    /**
     * mail 1
     */
    @Column(name = "tie_mail1")
    private String tieMail1;

    /**
     * mail 2
     */
    @Column(name = "tie_mail2")
    private String tieMail2;

    /**
     * mail 3
     */
    @Column(name = "tie_mail3")
    private String tieMail3;

    /**
     * mail 4
     */
    @Column(name = "tie_mail4")
    private String tieMail4;

    /**
     * mail 5
     */
    @Column(name = "tie_mail5")
    private String tieMail5;

    /**
     * adresse web
     */
    @Column(name = "tie_web")
    private String tieWeb;

    /**
     * mode de reglement
     */
    @Column(name = "tie_mode_reg")
    private String tieModeReg;

    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    @Column(name = "tie_type_reg")
    private Integer tieTypeReg;

    /**
     * nombre de jours d echeance
     */
    @Column(name = "tie_nb_echeance")
    private Integer tieNbEcheance = 0;

    /**
     * nombre de jours d arrondi
     */
    @Column(name = "tie_nb_arrondi")
    private Integer tieNbArrondi = 0;

    /**
     * code journal des reglements
     */
    @Column(name = "tie_journal_reg")
    private String tieJournalReg;

    /**
     * conditions de reglements
     */
    @Column(name = "tie_condition_reg")
    private String tieConditionReg;

    /**
     * plafond de facturation
     */
    @Column(name = "tie_plafond")
    private Double tiePlafond = 0D;

    /**
     * compte depot argent
     */
    @Column(name = "tie_depotavance")
    private Double tieDepotavance = 0D;

    /**
     * ca de la patente
     */
    @Column(name = "tie_capatente")
    private Double tieCapatente = 0D;

    /**
     * plafond de la patente
     */
    @Column(name = "tie_plaf_patente")
    private Double tiePlafPatente = 0D;

    /**
     * 0=compte fonctionnel 1=compte bloque
     */
    @Column(name = "tie_compte_bloque")
    private Integer tieCompteBloque = 0;

    /**
     * nom de la famille du tiers
     */
    @Column(name = "tie_nom_famille")
    private String tieNomFamille;

    /**
     * code serie
     */
    @Column(name = "tie_serie")
    private String tieSerie;

    /**
     * 0=avec douane 1=exonere de douane
     */
    @Column(name = "tie_exo_douane")
    private Integer tieExoDouane = 0;

    /**
     * 0=avec tva 1=exonere de tva 2=non assujetti aÃ‚Â  la tva
     */
    @Column(name = "tie_exo_tva")
    private Integer tieExoTva = 0;

    /**
     * code depot par defaut
     */
    @Column(name = "tie_depot")
    private String tieDepot;

    /**
     * taux d escompte
     */
    @Column(name = "tie_escompte")
    private Float tieEscompte;

    /**
     * 0=facturation au PV 1=facturation au PR
     */
    @Column(name = "tie_fac_pr")
    private Integer tieFacPr = 0;

    /**
     * nom de la banque
     */
    @Column(name = "tie_nom_banque")
    private String tieNomBanque;

    /**
     * adresse de la banque
     */
    @Column(name = "tie_adresse_banque")
    private String tieAdresseBanque;

    /**
     * code banque
     */
    @Column(name = "tie_num_banque")
    private String tieNumBanque;

    /**
     * code guichet
     */
    @Column(name = "tie_guichet_banque")
    private String tieGuichetBanque;

    /**
     * numero de compte
     */
    @Column(name = "tie_compte_banque")
    private String tieCompteBanque;

    /**
     * cle rib
     */
    @Column(name = "tie_cle_banque")
    private String tieCleBanque;

    /**
     * code iban
     */
    @Column(name = "tie_iban")
    private String tieIban;

    /**
     * code swift
     */
    @Column(name = "tie_swift")
    private String tieSwift;

    /**
     * compte principal
     */
    @Column(name = "tie_compte_0")
    private String tieCompte0;

    /**
     * compte associe 1 (en attente)
     */
    @Column(name = "tie_compte_1")
    private String tieCompte1;

    /**
     * compte associe 2 (avance ou acompte)
     */
    @Column(name = "tie_compte_2")
    private String tieCompte2;

    /**
     * compte asocie 3 (douteux ou litige)
     */
    @Column(name = "tie_compte_3")
    private String tieCompte3;

    /**
     * compte rattache
     */
    @Column(name = "tie_compte_4")
    private String tieCompte4;

    /**
     * note d appreciation automatique /20
     */
    @Column(name = "tie_note_auto")
    private Integer tieNoteAuto;

    /**
     * appreciation manuelle
     */
    @Column(name = "tie_note_man")
    private String tieNoteMan;

    /**
     * inutilise 1
     */
    @Column(name = "tie_no_use_1")
    private String tieNoUse1;

    /**
     * inutilise 2
     */
    @Column(name = "tie_no_use_2")
    private String tieNoUse2;

    /**
     * nom de l epouse ou de l epoux
     */
    @Column(name = "tie_epoux")
    private String tieEpoux;

    /**
     * nom du pere
     */
    @Column(name = "tie_nom_pere")
    private String tieNomPere;

    /**
     * nom de la mere
     */
    @Column(name = "tie_nom_mere")
    private String tieNomMere;

    /**
     * N carte d identite
     */
    @Column(name = "tie_ci_num")
    private String tieCiNum;

    /**
     * date de delivrance de la carte d identite
     */
    @Column(name = "tie_ci_date")
    private String tieCiDate;

    /**
     * lieu de delivrance de la carte d identite
     */
    @Column(name = "tie_ci_lieu")
    private String tieCiLieu;

    /**
     * profession
     */
    @Column(name = "tie_profession")
    private String tieProfession;

    /**
     * niveau d etude
     */
    @Column(name = "tie_niveau_etude")
    private String tieNiveauEtude;

    /**
     * nom de l employeur
     */
    @Column(name = "tie_employeur")
    private String tieEmployeur;

    /**
     * adresse de l employeur
     */
    @Column(name = "tie_adresse_employeur")
    private String tieAdresseEmployeur;

    /**
     * bp de l employeur
     */
    @Column(name = "tie_bp_employeur")
    private String tieBpEmployeur;

    /**
     * ville de l employeur
     */
    @Column(name = "tie_ville_employeur")
    private String tieVilleEmployeur;

    /**
     * telephone de l employeur
     */
    @Column(name = "tie_tel_employeur")
    private String tieTelEmployeur;

    /**
     * situation de famille 0=nr 1=celibataire 2=marie 3=concubin 4=divorce 5=veuf
     */
    @Column(name = "tie_sit_fam")
    private Integer tieSitFam;

    /**
     * nombre de personnes aÃ‚Â  charge
     */
    @Column(name = "tie_nb_charge")
    private Integer tieNbCharge;

    /**
     * nombre d enfants
     */
    @Column(name = "tie_nb_enf")
    private Integer tieNbEnf;

    /**
     * 0=locataire 1=proprietaire
     */
    @Column(name = "tie_habitation")
    private Integer tieHabitation;

    @Column(name = "tie_num1")
    private String tieNum1;

    @Column(name = "tie_num2")
    private String tieNum2;

    @Column(name = "tie_num3")
    private String tieNum3;

    @Column(name = "tie_num4")
    private String tieNum4;

    @Column(name = "tie_num5")
    private String tieNum5;

    @Column(name = "tie_num6")
    private String tieNum6;

    @Column(name = "tie_num7")
    private String tieNum7;

    @Column(name = "tie_num8")
    private String tieNum8;

    @Column(name = "tie_num9")
    private String tieNum9;

    @Column(name = "tie_num10")
    private String tieNum10;

    @Column(name = "tie_num11")
    private String tieNum11;

    @Column(name = "tie_num12")
    private String tieNum12;

    @Column(name = "tie_num13")
    private String tieNum13;

    @Column(name = "tie_num14")
    private String tieNum14;

    @Column(name = "tie_num15")
    private String tieNum15;

    @Column(name = "tie_num16")
    private String tieNum16;

    @Column(name = "tie_num17")
    private String tieNum17;

    @Column(name = "tie_num18")
    private String tieNum18;

    @Column(name = "tie_num19")
    private String tieNum19;

    @Column(name = "tie_num20")
    private String tieNum20;

    @Column(name = "tie_pdv")
    private String tiePdv;

    @Column(name = "tie_secteur")
    private String tieSecteur;

    @Column(name = "tie_region")
    private String tieRegion;

    @Column(name = "tie_assurt1")
    private Float tieAssurt1 = 0F;

    @Column(name = "tie_assurt2")
    private Double tieAssurt2 = 0D;

    @Column(name = "tie_assurt3")
    private Float tieAssurt3 = 0F;

    @Column(name = "tie_bnq1")
    private Double tieBnq1 = 0D;

    @Column(name = "tie_bnq2")
    private Float tieBnq2 = 0F;

    @Column(name = "tie_bnq3")
    private Double tieBnq3 = 0D;

    @Column(name = "tie_bnq4")
    private Float tieBnq4 = 0F;

    @Column(name = "tie_bnq5")
    private Double tieBnq5 = 0D;

    @Column(name = "tie_bnq6")
    private Float tieBnq6 = 0F;

    @Column(name = "tie_bnq7")
    private Float tieBnq7 = 0F;

    /**
     * id structure pour espace client
     */
    @Column(name = "tie_id_structure")
    private Long tieIdStructure = 0L;

    /**
     * 0=transfert en compta 1=non transfere en compta
     */
    @Column(name = "tie_transfert_cpte")
    private Integer tieTransfertCpte = 0;

    /**
     * compte SAGE
     */
    @Column(name = "tie_compte_sage")
    private String tieCompteSage;

    /**
     * acces photo ou logo
     */
    @Column(name = "tie_photo")
    private String tiePhoto;

    /**
     * 0=sans assujettissement 1=assujeti irpp 2=assujetti is
     */
    @Column(name = "tie_assujettissement")
    private Integer tieAssujettissement = 0;

    /**
     * zone de declaration fiscale
     */
    @Column(name = "tie_fiscal")
    private String tieFiscal;

    /**
     * taux de commission pour la facturation
     */
    @Column(name = "tie_taux_com")
    private Float tieTauxCom = 0F;

    /**
     * mode de commission 0=rien 1=calul sur brut 2=calul sur net 3=camlcul sur net à payer
     */
    @Column(name = "tie_mode_com")
    private Integer tieModeCom = 0;

}
