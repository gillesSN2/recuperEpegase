package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "imm_bien_gerance_ligne")
public class ImmBienGeranceLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "biegerlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biegerligId;

    /**
     * 0=mensuel 1=trimestriel 2=semestre 3=annuel
     */
    @Column(name = "biegerlig_mode")
    private Integer biegerligMode = 0;

    /**
     * 0=habitation 1=professionnel 2=idustriel 3=mixte
     */
    @Column(name = "biegerlig_usage")
    private Integer biegerligUsage = 0;

    /**
     * montant loyer brut
     */
    @Column(name = "biegerlig_loyer_brut")
    private Double biegerligLoyerBrut = 0D;

    /**
     * montant caution
     */
    @Column(name = "biegerlig_montant_caution")
    private Double biegerligMontantCaution = 0D;

    /**
     * taux tom
     */
    @Column(name = "biegerlig_taux_tom")
    private Float biegerligTauxTom = 0F;

    /**
     * montant tom
     */
    @Column(name = "biegerlig_tom")
    private Double biegerligTom = 0D;

    /**
     * 0=sans 1=enregistrement 2=tlv
     */
    @Column(name = "biegerlig_mode_tlv")
    private Integer biegerligModeTlv = 0;

    /**
     * taux tlv
     */
    @Column(name = "biegerlig_taux_tlv")
    private Float biegerligTauxTlv = 0F;

    /**
     * montant tlv
     */
    @Column(name = "biegerlig_tlv")
    private Double biegerligTlv = 0D;

    /**
     * taux tva
     */
    @Column(name = "biegerlig_taux_tva")
    private Float biegerligTauxTva = 0F;

    /**
     * montant tva
     */
    @Column(name = "biegerlig_tva")
    private Double biegerligTva = 0D;

    /**
     * montant loyer net
     */
    @Column(name = "biegerlig_loyer_net")
    private Double biegerligLoyerNet = 0D;

    /**
     * montant loyer professionnel si mixte
     */
    @Column(name = "biegerlig_loyer_professionel")
    private Double biegerligLoyerProfessionel = 0D;

    /**
     * montant des charges immeuble
     */
    @Column(name = "biegerlig_charges_immeuble")
    private Double biegerligChargesImmeuble = 0D;

    /**
     * taux des charges immeuble
     */
    @Column(name = "biegerlig_taux_charges")
    private Float biegerligTauxCharges = 0F;

    /**
     * eau
     */
    @Column(name = "biegerlig_eau")
    private Double biegerligEau = 0D;

    /**
     * electricite
     */
    @Column(name = "biegerlig_electricite")
    private Double biegerligElectricite = 0D;

    /**
     * parking
     */
    @Column(name = "biegerlig_parking")
    private Double biegerligParking = 0D;

    /**
     * gardiennage
     */
    @Column(name = "biegerlig_gardiennage")
    private Double biegerligGardiennage = 0D;

    /**
     * jardinnier
     */
    @Column(name = "biegerlig_jardinneir")
    private Double biegerligJardinneir = 0D;

    /**
     * groupe electrogene
     */
    @Column(name = "biegerlig_groupe_electro")
    private Double biegerligGroupeElectro = 0D;

    /**
     * divers frais
     */
    @Column(name = "biegerlig_divers_frais")
    private Double biegerligDiversFrais = 0D;

    /**
     * libelle frais
     */
    @Column(name = "biegerlig_libelle_frais")
    private String biegerligLibelleFrais;

    /**
     * frais complementaire
     */
    @Column(name = "biegerlig_frais_complement")
    private Double biegerligFraisComplement = 0D;

    /**
     * taux commission agence
     */
    @Column(name = "biegerlig_taux_commission")
    private Float biegerligTauxCommission = 0F;

    /**
     * total commission agence
     */
    @Column(name = "biegerlig_total_commission")
    private Double biegerligTotalCommission = 0D;

    /**
     * tva commission agence
     */
    @Column(name = "biegerlig_tva_commission")
    private Double biegerligTvaCommission = 0D;

    /**
     * net a payer au proprietaire
     */
    @Column(name = "biegerlig_net_payer")
    private Double biegerligNetPayer = 0D;

    /**
     * taux irpp
     */
    @Column(name = "biegerlig_taux_irpp")
    private Float biegerligTauxIrpp = 0F;

    /**
     * total irpp si proprietaire est assujetti irrp
     */
    @Column(name = "biegerlig_total_irpp")
    private Double biegerligTotalIrpp = 0D;

    /**
     * 0=pas de declaration 1=declaration
     */
    @Column(name = "biegerlig_declare")
    private Integer biegerligDeclare = 0;

    /**
     * montant frais de declaration
     */
    @Column(name = "biegerlig_frais_declaration")
    private Double biegerligFraisDeclaration = 0D;

    /**
     * montant frais etat compte
     */
    @Column(name = "biegerlig_frais_etat_compte")
    private Double biegerligFraisEtatCompte = 0D;

    @Column(name = "bie_id", nullable = false)
    private Long bieId;

    @Column(name = "biegerent_id", nullable = false)
    private Long biegerentId;

}
