package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ImmBienBailQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long biebaiId;


    /**
     * date de creation
     */
    private LocalDateTime biebaiDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime biebaiDateModif;


    /**
     * utilisateur de creation
     */
    private Long biebaiUserCreat;


    /**
     * utilisateur de modification
     */
    private Long biebaiUserModif;


    /**
     * date etablissement
     */
    private LocalDate biebaiDate;


    /**
     * annee date
     */
    private Integer biebaiAnnee;


    /**
     * date de signature
     */
    private LocalDate biebaiDateSignature;


    /**
     * date etat des lieux entree
     */
    private LocalDate biebaiDateIn;


    /**
     * date etat des lieux sortie
     */
    private LocalDate biebaiDateOut;


    /**
     * date depot enregistrement bail
     */
    private LocalDate biebaiDateDepot;


    /**
     * date a depose le bail
     */
    private LocalDate biebaiDateADeposer;


    /**
     * nom prsonne depot du bail
     */
    private String biebaiNomDepot;


    /**
     * date enregistrement bail
     */
    private LocalDate biebaiDateEnregistrement;


    /**
     * numero du bail
     */
    private String biebaiNum;


    /**
     * code du local ou du bien
     */
    private String biebaiLocal;


    /**
     * date debut
     */
    private LocalDate biebaiDateDebut;


    /**
     * date de fin
     */
    private LocalDate biebaiDateFin;


    /**
     * duree
     */
    private Integer biebaiDuree;


    /**
     * 0=en cours 1=validee 2=annulee 3=gelee 4=terminee
     */
    private Integer biebaiEtat;


    /**
     * 0=duree indeterminee 1=3-6-9
     */
    private Integer biebaiType;


    /**
     * 0=jour 1=semaine 2=mois 3=trimestriel 4=semestre 5=annuel
     */
    private Integer biebaiMode;


    /**
     * 0=habitation 1=professionnel 2=idustriel 3=mixte
     */
    private Integer biebaiUsage;


    /**
     * montant loyer brut professionnel si mixte
     */
    private Double biebaiLoyerProf;


    /**
     * montant loyer brut
     */
    private Double biebaiLoyerBrut;


    /**
     * 0=non exo 1= exonere tom
     */
    private Integer biebaiExoTom;


    /**
     * taux tom
     */
    private Float biebaiTauxTom;


    /**
     * montant tom
     */
    private Double biebaiTom;


    /**
     * 0=sans 1=avec enregistrement 2=avec tlv
     */
    private Integer biebaiModeTlv;


    /**
     * taux tlv
     */
    private Float biebaiTauxTlv;


    /**
     * montant tlv
     */
    private Double biebaiTlv;


    /**
     * 0=non exo 1= exonere tva
     */
    private Integer biebaiExoTva;


    /**
     * taux tva
     */
    private Float biebaiTauxTva;


    /**
     * montant tva
     */
    private Double biebaiTva;


    /**
     * montant loyer net
     */
    private Double biebaiLoyerNet;


    /**
     * taux agence
     */
    private Float biebaiTauxAgence;


    /**
     * montant agence
     */
    private Double biebaiAgence;


    /**
     * montant tva agence
     */
    private Double biebaiTvaAgence;


    /**
     * taux irpp
     */
    private Float biebaiTauxIrpp;


    /**
     * montant irpp
     */
    private Double biebaiIrpp;


    /**
     * montant des charges
     */
    private Double biebaiCharges;


    /**
     * taux des charges
     */
    private Float biebaiTauxCharges;


    /**
     * eau
     */
    private Double biebaiEau;


    /**
     * electricite
     */
    private Double biebaiElectricite;


    /**
     * parking
     */
    private Double biebaiParking;


    /**
     * gardiennage
     */
    private Double biebaiGardiennage;


    /**
     * jadinnier
     */
    private Double biebaiJardinnier;


    /**
     * groupe electrogene
     */
    private Double biebaiGroupeElectro;


    /**
     * divers frais
     */
    private Double biebaiDiversFrais;


    /**
     * libelle complementaire du frais
     */
    private String biebaiLibelleFrais;


    /**
     * frais complementaire
     */
    private Double biebaiFraisComplement;


    /**
     * ref du tiers locataire
     */
    private String biebaiLocataire;


    /**
     * nom du tiers locataire
     */
    private String biebaiNomTiers;


    /**
     * nom du tiers locataire
     */
    private String biebaiCivilTiers;


    /**
     * id du tiers proprietaire
     */
    private Long biebaiIdProprietaire;


    /**
     * ref du tiers proprietaire
     */
    private String biebaiProprietaire;


    /**
     * nom du tiers proprietaire
     */
    private String biebaiNomProprietaire;


    /**
     * nom du tiers proprietaire
     */
    private String biebaiCivilProprietaire;


    /**
     * assujettissement du tiers proprietaire 0=aucun 1=irpp 2=is
     */
    private Integer biebaiTypeProprietaire;


    /**
     * serie A, B, C, D ou X
     */
    private String biebaiSerie;


    /**
     * nom du commercial
     */
    private String biebaiNomResponsable;


    /**
     * id du commercial
     */
    private Long biebaiIdResponsable;


    /**
     * texte du contrat
     */
    private String biebaiContrat;


    /**
     * etat des lieux entree
     */
    private String biebaiEtatIn;


    /**
     * etat des lieux sortie
     */
    private String biebaiEtatOut;


    /**
     * date derniere revision
     */
    private LocalDate biebaiDerniereRevision;


    /**
     * date prochaine revision
     */
    private LocalDate biebaiProchaineRevision;


    /**
     * date derniere facture
     */
    private LocalDate biebaiDerniereFacture;


    /**
     * montant caution
     */
    private Double biebaiMontantCaution;


    /**
     * date paiement caution
     */
    private LocalDate biebaiDateCaution;


    /**
     * remboursement caution
     */
    private Double biebaiRmbCaution;


    /**
     * date remboursement caution
     */
    private LocalDate biebaiDateRmbCaution;


    /**
     * index electricite entree
     */
    private Long biebaiIndexElectriciteIn;


    /**
     * index electricite sortie
     */
    private Long biebaiIndexElectriciteOut;


    /**
     * index eau entree
     */
    private Long biebaiIndexEauIn;


    /**
     * index eau sortie
     */
    private Long biebaiIndexEauOut;


    /**
     * index gaz entree
     */
    private Long biebaiIndexGazIn;


    /**
     * index gaz sortie
     */
    private Long biebaiIndexGazOut;


    /**
     * police electricite
     */
    private String biebaiPoliceElectricite;


    /**
     * police eau
     */
    private String biebaiPoliceEau;


    /**
     * police gaz
     */
    private String biebaiPoliceGaz;


    /**
     * nom assureur
     */
    private String biebaiNomAssureur;


    /**
     * contrat assurance
     */
    private String biebaiContratAssurance;


    /**
     * numero de facture initiale
     */
    private String biebaiNumFacInit;


    /**
     * date facture intiale
     */
    private LocalDate biebaiDateFacInit;


    /**
     * date impression
     */
    private LocalDate biebaiDateImp;


    /**
     * nom jasper du modele
     */
    private String biebaiModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer biebaiEtatVal;


    /**
     * date de validite
     */
    private LocalDate biebaiDateValidite;


    /**
     * date de validation
     */
    private LocalDate biebaiDateValide;


    /**
     * base gerance
     */
    private Double biebaiBaseGerance;


    /**
     * taux gerance
     */
    private Float biebaiTauxGerance;


    /**
     * commission gerance
     */
    private Double biebaiComGerance;


    /**
     * tva sur commission gerance
     */
    private Double biabaiTvaGerance;

    private Long bieId;

    private Long tieId;

}
