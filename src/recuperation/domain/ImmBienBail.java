package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "imm_bien_bail")
public class ImmBienBail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "biebai_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biebaiId;

    /**
     * date de creation
     */
    @Column(name = "biebai_date_creat")
    private LocalDateTime biebaiDateCreat;

    /**
     * date de modification
     */
    @Column(name = "biebai_date_modif")
    private LocalDateTime biebaiDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "biebai_user_creat")
    private Long biebaiUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "biebai_user_modif")
    private Long biebaiUserModif = 0L;

    /**
     * date etablissement
     */
    @Column(name = "biebai_date")
    private LocalDate biebaiDate;

    /**
     * annee date
     */
    @Column(name = "biebai_annee")
    private Integer biebaiAnnee = 0;

    /**
     * date de signature
     */
    @Column(name = "biebai_date_signature")
    private LocalDate biebaiDateSignature;

    /**
     * date etat des lieux entree
     */
    @Column(name = "biebai_date_in")
    private LocalDate biebaiDateIn;

    /**
     * date etat des lieux sortie
     */
    @Column(name = "biebai_date_out")
    private LocalDate biebaiDateOut;

    /**
     * date depot enregistrement bail
     */
    @Column(name = "biebai_date_depot")
    private LocalDate biebaiDateDepot;

    /**
     * date a depose le bail
     */
    @Column(name = "biebai_date_a_deposer")
    private LocalDate biebaiDateADeposer;

    /**
     * nom prsonne depot du bail
     */
    @Column(name = "biebai_nom_depot")
    private String biebaiNomDepot;

    /**
     * date enregistrement bail
     */
    @Column(name = "biebai_date_enregistrement")
    private LocalDate biebaiDateEnregistrement;

    /**
     * numero du bail
     */
    @Column(name = "biebai_num")
    private String biebaiNum;

    /**
     * code du local ou du bien
     */
    @Column(name = "biebai_local")
    private String biebaiLocal;

    /**
     * date debut
     */
    @Column(name = "biebai_date_debut")
    private LocalDate biebaiDateDebut;

    /**
     * date de fin
     */
    @Column(name = "biebai_date_fin")
    private LocalDate biebaiDateFin;

    /**
     * duree
     */
    @Column(name = "biebai_duree")
    private Integer biebaiDuree = 0;

    /**
     * 0=en cours 1=validee 2=annulee 3=gelee 4=terminee
     */
    @Column(name = "biebai_etat")
    private Integer biebaiEtat = 0;

    /**
     * 0=duree indeterminee 1=3-6-9
     */
    @Column(name = "biebai_type")
    private Integer biebaiType = 0;

    /**
     * 0=jour 1=semaine 2=mois 3=trimestriel 4=semestre 5=annuel
     */
    @Column(name = "biebai_mode")
    private Integer biebaiMode = 0;

    /**
     * 0=habitation 1=professionnel 2=idustriel 3=mixte
     */
    @Column(name = "biebai_usage")
    private Integer biebaiUsage = 0;

    /**
     * montant loyer brut professionnel si mixte
     */
    @Column(name = "biebai_loyer_prof")
    private Double biebaiLoyerProf = 0D;

    /**
     * montant loyer brut
     */
    @Column(name = "biebai_loyer_brut")
    private Double biebaiLoyerBrut = 0D;

    /**
     * 0=non exo 1= exonere tom
     */
    @Column(name = "biebai_exo_tom")
    private Integer biebaiExoTom = 0;

    /**
     * taux tom
     */
    @Column(name = "biebai_taux_tom")
    private Float biebaiTauxTom = 0F;

    /**
     * montant tom
     */
    @Column(name = "biebai_tom")
    private Double biebaiTom = 0D;

    /**
     * 0=sans 1=avec enregistrement 2=avec tlv
     */
    @Column(name = "biebai_mode_tlv")
    private Integer biebaiModeTlv = 0;

    /**
     * taux tlv
     */
    @Column(name = "biebai_taux_tlv")
    private Float biebaiTauxTlv = 0F;

    /**
     * montant tlv
     */
    @Column(name = "biebai_tlv")
    private Double biebaiTlv = 0D;

    /**
     * 0=non exo 1= exonere tva
     */
    @Column(name = "biebai_exo_tva")
    private Integer biebaiExoTva = 0;

    /**
     * taux tva
     */
    @Column(name = "biebai_taux_tva")
    private Float biebaiTauxTva = 0F;

    /**
     * montant tva
     */
    @Column(name = "biebai_tva")
    private Double biebaiTva = 0D;

    /**
     * montant loyer net
     */
    @Column(name = "biebai_loyer_net")
    private Double biebaiLoyerNet = 0D;

    /**
     * taux agence
     */
    @Column(name = "biebai_taux_agence")
    private Float biebaiTauxAgence = 0F;

    /**
     * montant agence
     */
    @Column(name = "biebai_agence")
    private Double biebaiAgence = 0D;

    /**
     * montant tva agence
     */
    @Column(name = "biebai_tva_agence")
    private Double biebaiTvaAgence = 0D;

    /**
     * taux irpp
     */
    @Column(name = "biebai_taux_irpp")
    private Float biebaiTauxIrpp = 0F;

    /**
     * montant irpp
     */
    @Column(name = "biebai_irpp")
    private Double biebaiIrpp = 0D;

    /**
     * montant des charges
     */
    @Column(name = "biebai_charges")
    private Double biebaiCharges = 0D;

    /**
     * taux des charges
     */
    @Column(name = "biebai_taux_charges")
    private Float biebaiTauxCharges = 0F;

    /**
     * eau
     */
    @Column(name = "biebai_eau")
    private Double biebaiEau = 0D;

    /**
     * electricite
     */
    @Column(name = "biebai_electricite")
    private Double biebaiElectricite = 0D;

    /**
     * parking
     */
    @Column(name = "biebai_parking")
    private Double biebaiParking = 0D;

    /**
     * gardiennage
     */
    @Column(name = "biebai_gardiennage")
    private Double biebaiGardiennage = 0D;

    /**
     * jadinnier
     */
    @Column(name = "biebai_jardinnier")
    private Double biebaiJardinnier = 0D;

    /**
     * groupe electrogene
     */
    @Column(name = "biebai_groupe_electro")
    private Double biebaiGroupeElectro = 0D;

    /**
     * divers frais
     */
    @Column(name = "biebai_divers_frais")
    private Double biebaiDiversFrais = 0D;

    /**
     * libelle complementaire du frais
     */
    @Column(name = "biebai_libelle_frais")
    private String biebaiLibelleFrais;

    /**
     * frais complementaire
     */
    @Column(name = "biebai_frais_complement")
    private Double biebaiFraisComplement = 0D;

    /**
     * ref du tiers locataire
     */
    @Column(name = "biebai_locataire")
    private String biebaiLocataire;

    /**
     * nom du tiers locataire
     */
    @Column(name = "biebai_nom_tiers")
    private String biebaiNomTiers;

    /**
     * nom du tiers locataire
     */
    @Column(name = "biebai_civil_tiers")
    private String biebaiCivilTiers;

    /**
     * id du tiers proprietaire
     */
    @Column(name = "biebai_id_proprietaire")
    private Long biebaiIdProprietaire = 0L;

    /**
     * ref du tiers proprietaire
     */
    @Column(name = "biebai_proprietaire")
    private String biebaiProprietaire;

    /**
     * nom du tiers proprietaire
     */
    @Column(name = "biebai_nom_proprietaire")
    private String biebaiNomProprietaire;

    /**
     * nom du tiers proprietaire
     */
    @Column(name = "biebai_civil_proprietaire")
    private String biebaiCivilProprietaire;

    /**
     * assujettissement du tiers proprietaire 0=aucun 1=irpp 2=is
     */
    @Column(name = "biebai_type_proprietaire")
    private Integer biebaiTypeProprietaire = 0;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "biebai_serie")
    private String biebaiSerie;

    /**
     * nom du commercial
     */
    @Column(name = "biebai_nom_responsable")
    private String biebaiNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "biebai_id_responsable")
    private Long biebaiIdResponsable = 0L;

    /**
     * texte du contrat
     */
    @Column(name = "biebai_contrat")
    private String biebaiContrat;

    /**
     * etat des lieux entree
     */
    @Column(name = "biebai_etat_in")
    private String biebaiEtatIn;

    /**
     * etat des lieux sortie
     */
    @Column(name = "biebai_etat_out")
    private String biebaiEtatOut;

    /**
     * date derniere revision
     */
    @Column(name = "biebai_derniere_revision")
    private LocalDate biebaiDerniereRevision;

    /**
     * date prochaine revision
     */
    @Column(name = "biebai_prochaine_revision")
    private LocalDate biebaiProchaineRevision;

    /**
     * date derniere facture
     */
    @Column(name = "biebai_derniere_facture")
    private LocalDate biebaiDerniereFacture;

    /**
     * montant caution
     */
    @Column(name = "biebai_montant_caution")
    private Double biebaiMontantCaution = 0D;

    /**
     * date paiement caution
     */
    @Column(name = "biebai_date_caution")
    private LocalDate biebaiDateCaution;

    /**
     * remboursement caution
     */
    @Column(name = "biebai_rmb_caution")
    private Double biebaiRmbCaution = 0D;

    /**
     * date remboursement caution
     */
    @Column(name = "biebai_date_rmb_caution")
    private LocalDate biebaiDateRmbCaution;

    /**
     * index electricite entree
     */
    @Column(name = "biebai_index_electricite_in")
    private Long biebaiIndexElectriciteIn = 0L;

    /**
     * index electricite sortie
     */
    @Column(name = "biebai_index_electricite_out")
    private Long biebaiIndexElectriciteOut = 0L;

    /**
     * index eau entree
     */
    @Column(name = "biebai_index_eau_in")
    private Long biebaiIndexEauIn = 0L;

    /**
     * index eau sortie
     */
    @Column(name = "biebai_index_eau_out")
    private Long biebaiIndexEauOut = 0L;

    /**
     * index gaz entree
     */
    @Column(name = "biebai_index_gaz_in")
    private Long biebaiIndexGazIn = 0L;

    /**
     * index gaz sortie
     */
    @Column(name = "biebai_index_gaz_out")
    private Long biebaiIndexGazOut = 0L;

    /**
     * police electricite
     */
    @Column(name = "biebai_police_electricite")
    private String biebaiPoliceElectricite;

    /**
     * police eau
     */
    @Column(name = "biebai_police_eau")
    private String biebaiPoliceEau;

    /**
     * police gaz
     */
    @Column(name = "biebai_police_gaz")
    private String biebaiPoliceGaz;

    /**
     * nom assureur
     */
    @Column(name = "biebai_nom_assureur")
    private String biebaiNomAssureur;

    /**
     * contrat assurance
     */
    @Column(name = "biebai_contrat_assurance")
    private String biebaiContratAssurance;

    /**
     * numero de facture initiale
     */
    @Column(name = "biebai_num_fac_init")
    private String biebaiNumFacInit;

    /**
     * date facture intiale
     */
    @Column(name = "biebai_date_fac_init")
    private LocalDate biebaiDateFacInit;

    /**
     * date impression
     */
    @Column(name = "biebai_date_imp")
    private LocalDate biebaiDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "biebai_modele_imp")
    private String biebaiModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "biebai_etat_val")
    private Integer biebaiEtatVal = 0;

    /**
     * date de validite
     */
    @Column(name = "biebai_date_validite")
    private LocalDate biebaiDateValidite;

    /**
     * date de validation
     */
    @Column(name = "biebai_date_valide")
    private LocalDate biebaiDateValide;

    /**
     * base gerance
     */
    @Column(name = "biebai_base_gerance")
    private Double biebaiBaseGerance = 0D;

    /**
     * taux gerance
     */
    @Column(name = "biebai_taux_gerance")
    private Float biebaiTauxGerance = 0F;

    /**
     * commission gerance
     */
    @Column(name = "biebai_com_gerance")
    private Double biebaiComGerance = 0D;

    /**
     * tva sur commission gerance
     */
    @Column(name = "biabai_tva_gerance")
    private Double biabaiTvaGerance = 0D;

    @Column(name = "bie_id")
    private Long bieId;

    @Column(name = "tie_id")
    private Long tieId;

}
