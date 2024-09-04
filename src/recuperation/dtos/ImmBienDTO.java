package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ImmBienDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bieId;


    /**
     * date de creation
     */
    private LocalDateTime bieDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bieDateModif;


    /**
     * utilisateur de creation
     */
    private Long bieUserCreat;


    /**
     * utilisateur de modification
     */
    private Long bieUserModif;


    /**
     * numero du bien
     */
    private String bieNum;


    /**
     * categorie du bien 0=location 1=syndic 2=negoce
     */
    private Integer bieCategorie;


    /**
     * type du bien 0=villa 1=appartement 2=immeuble 3=bureau 4=commerce 5=garage 6=hangar 7=usine 8=box 9=parc
     */
    private Integer bieType;


    /**
     * mode du bien 0=standard 1=moyen 2=grand standing
     */
    private Integer bieMode;


    /**
     * nom du bien
     */
    private String bieNom;


    /**
     * modele t1 f1...
     */
    private String bieModele;


    /**
     * adresse du bien
     */
    private String bieAdresse;


    /**
     * numero de rue
     */
    private String bieRue;


    /**
     * no de lot
     */
    private String bieLot;


    /**
     * numero ilot
     */
    private String bieIlot;


    /**
     * batiment
     */
    private String bieBatiment;


    /**
     * numero de porte
     */
    private String biePorte;


    /**
     * etage
     */
    private String bieEtage;


    /**
     * escalier
     */
    private String bieEscalier;


    /**
     * ascenseur
     */
    private String bieAscenseur;


    /**
     * quartier
     */
    private String bieQuartier;


    /**
     * commune
     */
    private String bieCommune;


    /**
     * departement
     */
    private String bieDepart;


    /**
     * zone
     */
    private String bieZone;


    /**
     * ville
     */
    private String bieVille;


    /**
     * nom pays
     */
    private String bieNomPays;


    /**
     * code du pays
     */
    private String bieCodePays;


    /**
     * descriptif du bien
     */
    private String bieDescriptif;


    /**
     * mode gestion du bien 0=location 1=vente 2=les deux
     */
    private Integer bieModeGestion;


    /**
     * 0=bien gere par agence 1=bien plus gere
     */
    private Integer bieGestion;


    /**
     * id du groupe
     */
    private Long bieIdGroupe;


    /**
     * code du groupe
     */
    private String bieGroupe;


    /**
     * nom du groupe
     */
    private String bieNomGroupe;


    /**
     * 0=bien libre 1=bien en copropriete
     */
    private Boolean bieCopropriete;


    /**
     * nombre de millieme
     */
    private Integer bieMillieme;


    /**
     * superficie en m2
     */
    private Float bieSuperficie;


    /**
     * nombre de piece
     */
    private Integer bieNbPiece;


    /**
     * nombre de chambre
     */
    private Integer bieNbChambre;


    /**
     * nombre de salon
     */
    private Integer bieNbSalon;


    /**
     * nombre de cuisine
     */
    private Integer bieNbCuisine;


    /**
     * nombre de wc
     */
    private Integer bieNbWc;


    /**
     * nombre de salle de bain
     */
    private Integer bieNbSalleBain;


    /**
     * nombre de salle d eau
     */
    private Integer bieNbSalleEau;


    /**
     * nombre de garage
     */
    private Integer bieNbGarage;


    /**
     * nombre de vitrine
     */
    private Integer bieNbVitrine;


    /**
     * nombre etage
     */
    private Integer bieNbEtage;


    /**
     * nombre de batiment
     */
    private Integer bieNbBatiment;


    /**
     * nombre appartement
     */
    private Integer bieNbAppartement;


    /**
     * nombre ascenseur
     */
    private Integer bieNbAscenseur;


    /**
     * 0=sans jardin 1=jardin nu 2=jardin plante
     */
    private Integer bieJardin;


    /**
     * 0=sans 1=avec
     */
    private Integer biePiscine;


    /**
     * 0=sans 1=avec
     */
    private Integer bieParking;


    /**
     * 0=sans 1=avec
     */
    private Integer bieGroupeElectrogene;


    /**
     * 0=sans 1=avec
     */
    private Integer bieGardien;


    /**
     * nuemro parcelle
     */
    private String bieParcelle;


    /**
     * numero titre foncier
     */
    private String bieTitreFoncier;


    /**
     * date achat
     */
    private LocalDate bieDateAchat;


    /**
     * base du loyer
     */
    private Double bieBaseLoyer;


    /**
     * charges
     */
    private Double bieCharges;


    /**
     * ref du tiers proprietaire
     */
    private String bieTiers;


    /**
     * nom du tiers proprietaire
     */
    private String bieNomTiers;


    /**
     * civilite du tiers proprietaire
     */
    private String bieCivilTiers;


    /**
     * 0=non 1=oui
     */
    private Integer bieViabilise;


    /**
     * 0=non 1=oui
     */
    private Integer bieCloture;


    /**
     * compte de charge
     */
    private String bieCompteCharge;


    /**
     * libelle compte de charge
     */
    private String bieLibelleCharge;


    /**
     * compte de gestion
     */
    private String bieCompteGestion;


    /**
     * libelle compte de gestion
     */
    private String bieLibelleGestion;


    /**
     * nombre de locaux dans les immeubles
     */
    private Integer bieNbLocaux;


    /**
     * 0=sans publication 1=avec publication
     */
    private Integer biePublication;


    /**
     * 0=libre 1=occupe
     */
    private Integer bieOccupe;

    private Long tieId;

}
