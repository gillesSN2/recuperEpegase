package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "imm_bien")
public class ImmBien implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bieId;

    /**
     * date de creation
     */
    @Column(name = "bie_date_creat")
    private LocalDateTime bieDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bie_date_modif")
    private LocalDateTime bieDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bie_user_creat")
    private Long bieUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "bie_user_modif")
    private Long bieUserModif = 0L;

    /**
     * numero du bien
     */
    @Column(name = "bie_num")
    private String bieNum;

    /**
     * categorie du bien 0=location 1=syndic 2=negoce
     */
    @Column(name = "bie_categorie")
    private Integer bieCategorie = 0;

    /**
     * type du bien 0=villa 1=appartement 2=immeuble 3=bureau 4=commerce 5=garage 6=hangar 7=usine 8=box 9=parc
     */
    @Column(name = "bie_type")
    private Integer bieType = 0;

    /**
     * mode du bien 0=standard 1=moyen 2=grand standing
     */
    @Column(name = "bie_mode")
    private Integer bieMode = 0;

    /**
     * nom du bien
     */
    @Column(name = "bie_nom")
    private String bieNom;

    /**
     * modele t1 f1...
     */
    @Column(name = "bie_modele")
    private String bieModele;

    /**
     * adresse du bien
     */
    @Column(name = "bie_adresse")
    private String bieAdresse;

    /**
     * numero de rue
     */
    @Column(name = "bie_rue")
    private String bieRue;

    /**
     * no de lot
     */
    @Column(name = "bie_lot")
    private String bieLot;

    /**
     * numero ilot
     */
    @Column(name = "bie_ilot")
    private String bieIlot;

    /**
     * batiment
     */
    @Column(name = "bie_batiment")
    private String bieBatiment;

    /**
     * numero de porte
     */
    @Column(name = "bie_porte")
    private String biePorte;

    /**
     * etage
     */
    @Column(name = "bie_etage")
    private String bieEtage;

    /**
     * escalier
     */
    @Column(name = "bie_escalier")
    private String bieEscalier;

    /**
     * ascenseur
     */
    @Column(name = "bie_ascenseur")
    private String bieAscenseur;

    /**
     * quartier
     */
    @Column(name = "bie_quartier")
    private String bieQuartier;

    /**
     * commune
     */
    @Column(name = "bie_commune")
    private String bieCommune;

    /**
     * departement
     */
    @Column(name = "bie_depart")
    private String bieDepart;

    /**
     * zone
     */
    @Column(name = "bie_zone")
    private String bieZone;

    /**
     * ville
     */
    @Column(name = "bie_ville")
    private String bieVille;

    /**
     * nom pays
     */
    @Column(name = "bie_nom_pays")
    private String bieNomPays;

    /**
     * code du pays
     */
    @Column(name = "bie_code_pays")
    private String bieCodePays;

    /**
     * descriptif du bien
     */
    @Column(name = "bie_descriptif")
    private String bieDescriptif;

    /**
     * mode gestion du bien 0=location 1=vente 2=les deux
     */
    @Column(name = "bie_mode_gestion")
    private Integer bieModeGestion = 0;

    /**
     * 0=bien gere par agence 1=bien plus gere
     */
    @Column(name = "bie_gestion")
    private Integer bieGestion = 0;

    /**
     * id du groupe
     */
    @Column(name = "bie_id_groupe")
    private Long bieIdGroupe = 0L;

    /**
     * code du groupe
     */
    @Column(name = "bie_groupe")
    private String bieGroupe;

    /**
     * nom du groupe
     */
    @Column(name = "bie_nom_groupe")
    private String bieNomGroupe;

    /**
     * 0=bien libre 1=bien en copropriete
     */
    @Column(name = "bie_copropriete")
    private Boolean bieCopropriete = Boolean.FALSE;

    /**
     * nombre de millieme
     */
    @Column(name = "bie_millieme")
    private Integer bieMillieme = 0;

    /**
     * superficie en m2
     */
    @Column(name = "bie_superficie")
    private Float bieSuperficie = 0F;

    /**
     * nombre de piece
     */
    @Column(name = "bie_nb_piece")
    private Integer bieNbPiece = 0;

    /**
     * nombre de chambre
     */
    @Column(name = "bie_nb_chambre")
    private Integer bieNbChambre = 0;

    /**
     * nombre de salon
     */
    @Column(name = "bie_nb_salon")
    private Integer bieNbSalon = 0;

    /**
     * nombre de cuisine
     */
    @Column(name = "bie_nb_cuisine")
    private Integer bieNbCuisine = 0;

    /**
     * nombre de wc
     */
    @Column(name = "bie_nb_wc")
    private Integer bieNbWc = 0;

    /**
     * nombre de salle de bain
     */
    @Column(name = "bie_nb_salle_bain")
    private Integer bieNbSalleBain = 0;

    /**
     * nombre de salle d eau
     */
    @Column(name = "bie_nb_salle_eau")
    private Integer bieNbSalleEau = 0;

    /**
     * nombre de garage
     */
    @Column(name = "bie_nb_garage")
    private Integer bieNbGarage = 0;

    /**
     * nombre de vitrine
     */
    @Column(name = "bie_nb_vitrine")
    private Integer bieNbVitrine = 0;

    /**
     * nombre etage
     */
    @Column(name = "bie_nb_etage")
    private Integer bieNbEtage = 0;

    /**
     * nombre de batiment
     */
    @Column(name = "bie_nb_batiment")
    private Integer bieNbBatiment = 0;

    /**
     * nombre appartement
     */
    @Column(name = "bie_nb_appartement")
    private Integer bieNbAppartement = 0;

    /**
     * nombre ascenseur
     */
    @Column(name = "bie_nb_ascenseur")
    private Integer bieNbAscenseur = 0;

    /**
     * 0=sans jardin 1=jardin nu 2=jardin plante
     */
    @Column(name = "bie_jardin")
    private Integer bieJardin = 0;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "bie_piscine")
    private Integer biePiscine = 0;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "bie_parking")
    private Integer bieParking = 0;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "bie_groupe_electrogene")
    private Integer bieGroupeElectrogene = 0;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "bie_gardien")
    private Integer bieGardien = 0;

    /**
     * nuemro parcelle
     */
    @Column(name = "bie_parcelle")
    private String bieParcelle;

    /**
     * numero titre foncier
     */
    @Column(name = "bie_titre_foncier")
    private String bieTitreFoncier;

    /**
     * date achat
     */
    @Column(name = "bie_date_achat")
    private LocalDate bieDateAchat;

    /**
     * base du loyer
     */
    @Column(name = "bie_base_loyer")
    private Double bieBaseLoyer = 0D;

    /**
     * charges
     */
    @Column(name = "bie_charges")
    private Double bieCharges = 0D;

    /**
     * ref du tiers proprietaire
     */
    @Column(name = "bie_tiers")
    private String bieTiers;

    /**
     * nom du tiers proprietaire
     */
    @Column(name = "bie_nom_tiers")
    private String bieNomTiers;

    /**
     * civilite du tiers proprietaire
     */
    @Column(name = "bie_civil_tiers")
    private String bieCivilTiers;

    /**
     * 0=non 1=oui
     */
    @Column(name = "bie_viabilise")
    private Integer bieViabilise = 0;

    /**
     * 0=non 1=oui
     */
    @Column(name = "bie_cloture")
    private Integer bieCloture = 0;

    /**
     * compte de charge
     */
    @Column(name = "bie_compte_charge")
    private String bieCompteCharge;

    /**
     * libelle compte de charge
     */
    @Column(name = "bie_libelle_charge")
    private String bieLibelleCharge;

    /**
     * compte de gestion
     */
    @Column(name = "bie_compte_gestion")
    private String bieCompteGestion;

    /**
     * libelle compte de gestion
     */
    @Column(name = "bie_libelle_gestion")
    private String bieLibelleGestion;

    /**
     * nombre de locaux dans les immeubles
     */
    @Column(name = "bie_nb_locaux")
    private Integer bieNbLocaux = 0;

    /**
     * 0=sans publication 1=avec publication
     */
    @Column(name = "bie_publication")
    private Integer biePublication = 0;

    /**
     * 0=libre 1=occupe
     */
    @Column(name = "bie_occupe")
    private Integer bieOccupe = 0;

    @Column(name = "tie_id")
    private Long tieId;

}
