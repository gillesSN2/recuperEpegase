package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ach_frais_ligne")
public class AchFraisLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fsflig_id", nullable = false)
    private Long fsfligId;

    /**
     * code produit
     */
    @Column(name = "fsflig_code")
    private String fsfligCode;

    /**
     * famille vente
     */
    @Column(name = "fsflig_famille")
    private String fsfligFamille;

    /**
     * libelle produit
     */
    @Column(name = "fsflig_libelle")
    private String fsfligLibelle;

    /**
     * mode produit 0=divers 1=fret 2=assurance 3=douane 4=transit 5=debours
     */
    @Column(name = "fsflig_mode")
    private Integer fsfligMode = 0;

    /**
     * code taxe
     */
    @Column(name = "fsflig_taxe")
    private String fsfligTaxe;

    /**
     * taux de taxe
     */
    @Column(name = "fsflig_taux_taxe")
    private Float fsfligTauxTaxe = 0F;

    /**
     * unite produit
     */
    @Column(name = "fsflig_unite")
    private String fsfligUnite;

    /**
     * quantite
     */
    @Column(name = "fsflig_qte")
    private Float fsfligQte = 0F;

    /**
     * code devise
     */
    @Column(name = "fsflig_devise")
    private String fsfligDevise;

    /**
     * prix unitaire
     */
    @Column(name = "fsflig_pu")
    private Double fsfligPu = 0D;

    /**
     * taux de remise
     */
    @Column(name = "fsflig_taux_remise")
    private Float fsfligTauxRemise = 0F;

    /**
     * valeur du rabais
     */
    @Column(name = "fsflig_rabais")
    private Double fsfligRabais = 0D;

    /**
     * prix unitaire apres remise
     */
    @Column(name = "fsflig_pu_rem")
    private Double fsfligPuRem = 0D;

    /**
     * prix total ht
     */
    @Column(name = "fsflig_pt")
    private Double fsfligPt = 0D;

    /**
     * total taxe
     */
    @Column(name = "fsflig_tva")
    private Double fsfligTva = 0D;

    /**
     * total taxe complementaire
     */
    @Column(name = "fsflig_tc")
    private Double fsfligTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "fsflig_ttc")
    private Double fsfligTtc = 0D;

    /**
     * prix total ht local
     */
    @Column(name = "fsflig_pt_local")
    private Double fsfligPtLocal = 0D;

    /**
     * prix de revient
     */
    @Column(name = "fsflig_pr")
    private Double fsfligPr = 0D;

    /**
     * prix unitaire moyen pondere
     */
    @Column(name = "fsflig_pump")
    private Double fsfligPump = 0D;

    /**
     * id fournisseur secondaire
     */
    @Column(name = "fsflig_Id_fournisseur2")
    private Long fsfligIdFournisseur2 = 0L;

    /**
     * nom fournisseur secondaire
     */
    @Column(name = "fsflig_nom_fournisseur2")
    private String fsfligNomFournisseur2 = "0";

    /**
     * numero de facture du prestataire
     */
    @Column(name = "fsflig_num_facture_four2")
    private String fsfligNumFactureFour2;

    @Column(name = "fsf_id", nullable = false)
    private Long fsfId;

    /**
     * description conditionnement produit
     */
    @Column(name = "fsflig_description")
    private String fsfligDescription;

    /**
     * quantite
     */
    @Column(name = "fsflig_qte_util")
    private Float fsfligQteUtil = 0F;

    /**
     * poids brut
     */
    @Column(name = "fsflig_poidsBrut")
    private Float fsfligPoidsbrut = 0F;

}
