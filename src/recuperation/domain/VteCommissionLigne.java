package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_commission_ligne")
public class VteCommissionLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "comlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comligId;

    /**
     * date du document
     */
    @Column(name = "comlig_date")
    private LocalDateTime comligDate;

    /**
     * date du dernier reglement
     */
    @Column(name = "comlig_date_last_reg")
    private LocalDateTime comligDateLastReg;

    /**
     * nb jour
     */
    @Column(name = "comlig_nb_jour")
    private Long comligNbJour;

    /**
     * numero document
     */
    @Column(name = "comlig_num")
    private String comligNum;

    /**
     * nature document
     */
    @Column(name = "comlig_nature")
    private Integer comligNature = 0;

    /**
     * nom du commercial
     */
    @Column(name = "comlig_nom_responsable")
    private String comligNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "comlig_id_responsable")
    private Long comligIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "comlig_nom_commercial")
    private String comligNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "comlig_id_commercial")
    private Long comligIdCommercial = 0L;

    /**
     * nom du client
     */
    @Column(name = "comlig_nom_tiers")
    private String comligNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "comlig_id_tiers")
    private Long comligIdTiers = 0L;

    /**
     * civilite du tiers
     */
    @Column(name = "comlig_civil_tiers")
    private String comligCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "comlig_id_contact")
    private Long comligIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "comlig_nom_contact")
    private String comligNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "comlig_civil_contact")
    private String comligCivilContact;

    /**
     * serie
     */
    @Column(name = "comlig_serie")
    private String comligSerie;

    /**
     * categorie du client
     */
    @Column(name = "comlig_cat")
    private String comligCat;

    /**
     * code devise
     */
    @Column(name = "comlig_devise")
    private String comligDevise;

    /**
     * id ligne de document
     */
    @Column(name = "comlig_id_ligne")
    private Long comligIdLigne = 0L;

    /**
     * code produit
     */
    @Column(name = "comlig_code")
    private String comligCode;

    /**
     * libelle produit
     */
    @Column(name = "comlig_libelle")
    private String comligLibelle;

    /**
     * total qte produit
     */
    @Column(name = "comlig_qte")
    private Float comligQte = 0F;

    /**
     * total ht
     */
    @Column(name = "comlig_tot_ht")
    private Double comligTotHt = 0D;

    /**
     * commission unitaire
     */
    @Column(name = "comlig_com_unite")
    private Double comligComUnite = 0D;

    /**
     * % de commission
     */
    @Column(name = "comlig_com_pourcentage")
    private Float comligComPourcentage = 0F;

    /**
     * total commission
     */
    @Column(name = "comlig_tot_commission")
    private Double comligTotCommission = 0D;

    @Column(name = "com_id", nullable = false)
    private Long comId;

    /**
     * nom du equipe
     */
    @Column(name = "comlig_nom_equipe")
    private String comligNomEquipe;

    /**
     * id du equipe
     */
    @Column(name = "comlig_id_equipe")
    private Long comligIdEquipe = 0L;

}
