package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "edu_eleves")
public class EduEleves implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ele_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eleId;

    /**
     * date de creation
     */
    @Column(name = "ele_date_creat")
    private LocalDateTime eleDateCreat;

    /**
     * date de modification
     */
    @Column(name = "ele_date_modif")
    private LocalDateTime eleDateModif;

    /**
     * user de creation
     */
    @Column(name = "ele_user_creat")
    private Long eleUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "ele_user_modif")
    private Long eleUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprime
     */
    @Column(name = "ele_etat")
    private Integer eleEtat = 0;

    /**
     * numero dossier
     */
    @Column(name = "ele_dossier")
    private String eleDossier;

    /**
     * nom du patient
     */
    @Column(name = "ele_nom")
    private String eleNom;

    /**
     * prenom
     */
    @Column(name = "ele_prenom")
    private String elePrenom;

    /**
     * photo
     */
    @Column(name = "ele_photo")
    private String elePhoto;

    /**
     * nom de jeune fille
     */
    @Column(name = "ele_nom_jf")
    private String eleNomJf;

    /**
     * numero de cate d identite
     */
    @Column(name = "ele_ci")
    private String eleCi;

    /**
     * numero de securite sociale
     */
    @Column(name = "ele_secu")
    private String eleSecu;

    /**
     * couvert par
     */
    @Column(name = "ele_couvert")
    private String eleCouvert;

    /**
     * civilite
     */
    @Column(name = "ele_civilite")
    private String eleCivilite;

    /**
     * telephone domicile
     */
    @Column(name = "ele_tel_dom")
    private String eleTelDom;

    /**
     * cellulaire 1
     */
    @Column(name = "ele_cel1")
    private String eleCel1;

    /**
     * cellulaire 2
     */
    @Column(name = "ele_cel2")
    private String eleCel2;

    /**
     * cellulaire 3
     */
    @Column(name = "ele_cel3")
    private String eleCel3;

    /**
     * telephone voiture
     */
    @Column(name = "ele_tel_voiture")
    private String eleTelVoiture;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "ele_sexe")
    private Integer eleSexe = 0;

    /**
     * date de naissance
     */
    @Column(name = "ele_date_naissance")
    private LocalDate eleDateNaissance;

    /**
     * lieu de naissance
     */
    @Column(name = "ele_lieu_naissance")
    private String eleLieuNaissance;

    /**
     * pays de naissance
     */
    @Column(name = "ele_pays_naissance")
    private String elePaysNaissance;

    /**
     * observations
     */
    @Column(name = "ele_observations")
    private String eleObservations;

    /**
     * adresse actuelle
     */
    @Column(name = "ele_adresse")
    private String eleAdresse;

    /**
     * numero rue
     */
    @Column(name = "ele_rue")
    private String eleRue;

    /**
     * numero lot
     */
    @Column(name = "ele_lot")
    private String eleLot;

    /**
     * numero illot
     */
    @Column(name = "ele_ilot")
    private String eleIlot;

    /**
     * numero batiment
     */
    @Column(name = "ele_batiment")
    private String eleBatiment;

    /**
     * numero porte
     */
    @Column(name = "ele_porte")
    private String elePorte;

    /**
     * numero etage
     */
    @Column(name = "ele_etage")
    private String eleEtage;

    /**
     * ascenseur
     */
    @Column(name = "ele_ascensseur")
    private String eleAscensseur;

    /**
     * quartier
     */
    @Column(name = "ele_quartier")
    private String eleQuartier;

    /**
     * commune
     */
    @Column(name = "ele_commune")
    private String eleCommune;

    /**
     * departement
     */
    @Column(name = "ele_depart")
    private String eleDepart;

    /**
     * zone
     */
    @Column(name = "ele_zone")
    private String eleZone;

    /**
     * boite poste
     */
    @Column(name = "ele_bp")
    private String eleBp;

    /**
     * cedex
     */
    @Column(name = "ele_cedex")
    private String eleCedex;

    /**
     * ville
     */
    @Column(name = "ele_ville")
    private String eleVille;

    /**
     * pays
     */
    @Column(name = "ele_pays")
    private String elePays;

    /**
     * adresse yahoo
     */
    @Column(name = "ele_yahoo")
    private String eleYahoo;

    /**
     * adresse msn
     */
    @Column(name = "ele_msn")
    private String eleMsn;

    /**
     * adresse skype
     */
    @Column(name = "ele_skype")
    private String eleSkype;

    /**
     * mail 1
     */
    @Column(name = "ele_mail1")
    private String eleMail1;

    /**
     * famille patient
     */
    @Column(name = "ele_nom_famille")
    private String eleNomFamille;

    /**
     * serie
     */
    @Column(name = "ele_serie")
    private String eleSerie;

    /**
     * nom banque
     */
    @Column(name = "ele_nom_banque")
    private String eleNomBanque;

    /**
     * adresse banque
     */
    @Column(name = "ele_adresse_banque")
    private String eleAdresseBanque;

    /**
     * numero banque
     */
    @Column(name = "ele_num_banque")
    private String eleNumBanque;

    /**
     * numero guichet
     */
    @Column(name = "ele_guichet_banque")
    private String eleGuichetBanque;

    /**
     * numero compte
     */
    @Column(name = "ele_compte_banque")
    private String eleCompteBanque;

    /**
     * rib
     */
    @Column(name = "ele_cle_banque")
    private String eleCleBanque;

    /**
     * iban
     */
    @Column(name = "ele_iban")
    private String eleIban;

    /**
     * swift
     */
    @Column(name = "ele_swift")
    private String eleSwift;

    /**
     * compte comptable
     */
    @Column(name = "ele_compte")
    private String eleCompte;

    /**
     * situation de famille
     */
    @Column(name = "ele_sit_fam")
    private Integer eleSitFam = 0;

    /**
     * nom du pere
     */
    @Column(name = "ele_nom_pere")
    private String eleNomPere;

    /**
     * nom de la mere
     */
    @Column(name = "ele_nom_mere")
    private String eleNomMere;

    /**
     * mode de reglement
     */
    @Column(name = "ele_mode_reg")
    private String eleModeReg;

    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    @Column(name = "ele_type_reg")
    private Integer eleTypeReg = 0;

    /**
     * nombre de jours d echeance
     */
    @Column(name = "ele_nb_echeance")
    private Integer eleNbEcheance = 0;

    /**
     * nombre de jours d arrondi
     */
    @Column(name = "ele_nb_arrondi")
    private Integer eleNbArrondi = 0;

    /**
     * conditions de reglements
     */
    @Column(name = "ele_condition_reg")
    private String eleConditionReg;

}
