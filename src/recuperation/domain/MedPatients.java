package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_patients")
public class MedPatients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pat_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patId;

    /**
     * date de creation
     */
    @Column(name = "pat_date_creat")
    private LocalDateTime patDateCreat;

    /**
     * date de modification
     */
    @Column(name = "pat_date_modif")
    private LocalDateTime patDateModif;

    /**
     * user de creation
     */
    @Column(name = "pat_user_creat")
    private Long patUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "pat_user_modif")
    private Long patUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprime
     */
    @Column(name = "pat_etat")
    private Integer patEtat = 0;

    /**
     * pourcentage du cas social
     */
    @Column(name = "pat_pourcent_cas_social")
    private Float patPourcentCasSocial = 0F;

    /**
     * numero de contrat
     */
    @Column(name = "pat_num_contrat")
    private String patNumContrat;

    /**
     * numero dossier
     */
    @Column(name = "pat_dossier")
    private String patDossier;

    /**
     * nom du patient
     */
    @Column(name = "pat_nom")
    private String patNom;

    /**
     * prenom
     */
    @Column(name = "pat_prenom")
    private String patPrenom;

    /**
     * nom de jeune fille
     */
    @Column(name = "pat_nom_jf")
    private String patNomJf;

    /**
     * surnom
     */
    @Column(name = "pat_surnom")
    private String patSurnom;

    /**
     * prise en charge du patient lie au fichier xml (1= assure 2= non assure 3=cas social)
     */
    @Column(name = "pat_pec")
    private String patPec;

    /**
     * societe prise en charge
     */
    @Column(name = "pat_societe")
    private String patSociete;

    /**
     * id societe prise en charge
     */
    @Column(name = "pat_id_societe")
    private Long patIdSociete = 0L;

    /**
     * assurance prise en charge
     */
    @Column(name = "pat_assurance")
    private String patAssurance;

    /**
     * id assurance prise en charge
     */
    @Column(name = "pat_id_assurance")
    private Long patIdAssurance = 0L;

    /**
     * complementaire prise en charge
     */
    @Column(name = "pat_complementaire")
    private String patComplementaire;

    /**
     * id complementaire prise en charge
     */
    @Column(name = "pat_id_complementaire")
    private Long patIdComplementaire = 0L;

    /**
     * numero de cate d identite
     */
    @Column(name = "pat_ci")
    private String patCi;

    /**
     * numero de securite sociale
     */
    @Column(name = "pat_secu")
    private String patSecu;

    /**
     * couvert par
     */
    @Column(name = "pat_couvert")
    private String patCouvert;

    /**
     * civilite
     */
    @Column(name = "pat_civilite")
    private String patCivilite;

    /**
     * langue parlee
     */
    @Column(name = "pat_langue_parle")
    private String patLangueParle;

    /**
     * telephone domicile
     */
    @Column(name = "pat_tel_dom")
    private String patTelDom;

    /**
     * cellulaire 1
     */
    @Column(name = "pat_cel1")
    private String patCel1;

    /**
     * cellulaire 2
     */
    @Column(name = "pat_cel2")
    private String patCel2;

    /**
     * cellulaire 3
     */
    @Column(name = "pat_cel3")
    private String patCel3;

    /**
     * telephone voiture
     */
    @Column(name = "pat_tel_voiture")
    private String patTelVoiture;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "pat_sexe")
    private Integer patSexe = 0;

    /**
     * date de naissance
     */
    @Column(name = "pat_date_naissance")
    private LocalDate patDateNaissance;

    /**
     * lieu de naissance
     */
    @Column(name = "pat_lieu_naissance")
    private String patLieuNaissance;

    /**
     * pays de naissance
     */
    @Column(name = "pat_pays_naissance")
    private String patPaysNaissance;

    /**
     * observations
     */
    @Column(name = "pat_observations")
    private String patObservations;

    /**
     * adresse actuelle
     */
    @Column(name = "pat_adresse")
    private String patAdresse;

    /**
     * numero rue
     */
    @Column(name = "pat_rue")
    private String patRue;

    /**
     * numero lot
     */
    @Column(name = "pat_lot")
    private String patLot;

    /**
     * numero illot
     */
    @Column(name = "pat_ilot")
    private String patIlot;

    /**
     * numero batiment
     */
    @Column(name = "pat_batiment")
    private String patBatiment;

    /**
     * numero porte
     */
    @Column(name = "pat_porte")
    private String patPorte;

    /**
     * numero etage
     */
    @Column(name = "pat_etage")
    private String patEtage;

    /**
     * ascenseur
     */
    @Column(name = "pat_ascensseur")
    private String patAscensseur;

    /**
     * quartier
     */
    @Column(name = "pat_quartier")
    private String patQuartier;

    /**
     * commune
     */
    @Column(name = "pat_commune")
    private String patCommune;

    /**
     * departement
     */
    @Column(name = "pat_depart")
    private String patDepart;

    /**
     * zone
     */
    @Column(name = "pat_zone")
    private String patZone;

    /**
     * boite poste
     */
    @Column(name = "pat_bp")
    private String patBp;

    /**
     * cedex
     */
    @Column(name = "pat_cedex")
    private String patCedex;

    /**
     * ville
     */
    @Column(name = "pat_ville")
    private String patVille;

    /**
     * pays
     */
    @Column(name = "pat_pays")
    private String patPays;

    /**
     * telephne bureau
     */
    @Column(name = "pat_bur_tel1")
    private String patBurTel1;

    /**
     * telephne bureau
     */
    @Column(name = "pat_bur_tel2")
    private String patBurTel2;

    /**
     * fax
     */
    @Column(name = "pat_bur_fax")
    private String patBurFax;

    /**
     * adresse yahoo
     */
    @Column(name = "pat_yahoo")
    private String patYahoo;

    /**
     * adresse msn
     */
    @Column(name = "pat_msn")
    private String patMsn;

    /**
     * adresse skype
     */
    @Column(name = "pat_skype")
    private String patSkype;

    /**
     * mail 1
     */
    @Column(name = "pat_mail1")
    private String patMail1;

    /**
     * famille patient
     */
    @Column(name = "pat_nom_famille")
    private String patNomFamille;

    /**
     * serie
     */
    @Column(name = "pat_serie")
    private String patSerie;

    /**
     * nom banque
     */
    @Column(name = "pat_nom_banque")
    private String patNomBanque;

    /**
     * adresse banque
     */
    @Column(name = "pat_adresse_banque")
    private String patAdresseBanque;

    /**
     * numero banque
     */
    @Column(name = "pat_num_banque")
    private String patNumBanque;

    /**
     * numero guichet
     */
    @Column(name = "pat_guichet_banque")
    private String patGuichetBanque;

    /**
     * numero compte
     */
    @Column(name = "pat_compte_banque")
    private String patCompteBanque;

    /**
     * rib
     */
    @Column(name = "pat_cle_banque")
    private String patCleBanque;

    /**
     * iban
     */
    @Column(name = "pat_iban")
    private String patIban;

    /**
     * swift
     */
    @Column(name = "pat_swift")
    private String patSwift;

    /**
     * compte comptable
     */
    @Column(name = "pat_compte")
    private String patCompte;

    /**
     * date prelevement 1
     */
    @Column(name = "pat_date_prelev_1")
    private LocalDate patDatePrelev1;

    /**
     * groupe
     */
    @Column(name = "pat_groupe_1")
    private String patGroupe1;

    /**
     * rhesus
     */
    @Column(name = "pat_rhesus_1")
    private String patRhesus1;

    /**
     * d
     */
    @Column(name = "pat_d_1")
    private Integer patD1 = 0;

    /**
     * c
     */
    @Column(name = "pat_c_1")
    private Integer patC1 = 0;

    /**
     * cc
     */
    @Column(name = "pat_cc_1")
    private Integer patCc1 = 0;

    /**
     * e
     */
    @Column(name = "pat_e_1")
    private Integer patE1 = 0;

    /**
     * ee
     */
    @Column(name = "pat_ee_1")
    private Integer patEe1 = 0;

    /**
     * cde
     */
    @Column(name = "pat_cde_1")
    private Integer patCde1 = 0;

    /**
     * k
     */
    @Column(name = "pat_k_1")
    private Integer patK1 = 0;

    /**
     * date prelevement
     */
    @Column(name = "pat_date_prelev_2")
    private LocalDate patDatePrelev2;

    /**
     * groupe 2
     */
    @Column(name = "pat_groupe_2")
    private String patGroupe2;

    /**
     * rhesus
     */
    @Column(name = "pat_rhesus_2")
    private String patRhesus2;

    /**
     * d
     */
    @Column(name = "pat_d_2")
    private Integer patD2 = 0;

    /**
     * c
     */
    @Column(name = "pat_c_2")
    private Integer patC2 = 0;

    /**
     * cc
     */
    @Column(name = "pat_cc_2")
    private Integer patCc2 = 0;

    /**
     * e
     */
    @Column(name = "pat_e_2")
    private Integer patE2 = 0;

    /**
     * ee
     */
    @Column(name = "pat_ee_2")
    private Integer patEe2 = 0;

    /**
     * cde
     */
    @Column(name = "pat_cde_2")
    private Integer patCde2 = 0;

    /**
     * k
     */
    @Column(name = "pat_k_2")
    private Integer patK2 = 0;

    /**
     * situation de famille
     */
    @Column(name = "pat_sit_fam")
    private Integer patSitFam = 0;

    /**
     * habitat
     */
    @Column(name = "pat_habitat")
    private Integer patHabitat = 0;

    /**
     * nombre enfants
     */
    @Column(name = "pat_nb_enfant")
    private Integer patNbEnfant = 0;

    /**
     * secteur activite
     */
    @Column(name = "pat_secteur_activite")
    private String patSecteurActivite;

    /**
     * profession
     */
    @Column(name = "pat_profession")
    private String patProfession;

    /**
     * observation sur la profession
     */
    @Column(name = "pat_prof_obs")
    private String patProfObs;

    /**
     * nom du pere
     */
    @Column(name = "pat_nom_pere")
    private String patNomPere;

    /**
     * nom de la mere
     */
    @Column(name = "pat_nom_mere")
    private String patNomMere;

    /**
     * mode de reglement
     */
    @Column(name = "pat_mode_reg")
    private String patModeReg;

    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    @Column(name = "pat_type_reg")
    private Integer patTypeReg = 0;

    /**
     * nombre de jours d echeance
     */
    @Column(name = "pat_nb_echeance")
    private Integer patNbEcheance = 0;

    /**
     * nombre de jours d arrondi
     */
    @Column(name = "pat_nb_arrondi")
    private Integer patNbArrondi = 0;

    /**
     * conditions de reglements
     */
    @Column(name = "pat_condition_reg")
    private String patConditionReg;

    /**
     * acces photo ou logo
     */
    @Column(name = "pat_photo")
    private String patPhoto;

}
