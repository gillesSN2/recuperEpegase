package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_baremes")
public class CmmBaremes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barId;

    /**
     * date de creation
     */
    @Column(name = "bar_date_creat")
    private LocalDateTime barDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bar_date_modif")
    private LocalDateTime barDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bar_user_creat")
    private Long barUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "bar_user_modif")
    private Long barUserModif = 0L;

    /**
     * code bareme
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * nom bareme en FR
     */
    @Column(name = "bar_nom_FR")
    private String barNomFr;

    /**
     * nom bareme en UK
     */
    @Column(name = "bar_nom_UK")
    private String barNomUk;

    /**
     * nom bareme en SP
     */
    @Column(name = "bar_nom_SP")
    private String barNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "bar_inactif")
    private Integer barInactif = 0;

    /**
     * 0=remise tiers 1=remise produit
     */
    @Column(name = "bar_options")
    private Integer barOptions = 0;

    /**
     * 0=tiers 1=famille tiers 2=produit 3=famille produit
     */
    @Column(name = "bar_type")
    private Integer barType = 0;

    /**
     * id du tiers
     */
    @Column(name = "bar_id_tiers")
    private Long barIdTiers = 0L;

    /**
     * nom du tiers
     */
    @Column(name = "bar_nom_tiers")
    private String barNomTiers;

    /**
     * code produit
     */
    @Column(name = "bar_code_produit")
    private String barCodeProduit;

    /**
     * nom produit
     */
    @Column(name = "bar_libelle_produit")
    private String barLibelleProduit;

    /**
     * code famille vente
     */
    @Column(name = "bar_code_vte")
    private String barCodeVte;

    /**
     * libelle famille vente
     */
    @Column(name = "bar_libelle_vte")
    private String barLibelleVte;

    /**
     * date de debut de validite
     */
    @Column(name = "bar_date_debut")
    private LocalDate barDateDebut;

    /**
     * annee de fin de validite
     */
    @Column(name = "bar_date_fin")
    private LocalDate barDateFin;

    /**
     * remise
     */
    @Column(name = "bar_remise")
    private Float barRemise = 0F;

    /**
     * rabais
     */
    @Column(name = "bar_rabais")
    private Double barRabais = 0D;

    /**
     * prix force
     */
    @Column(name = "bar_prix")
    private Double barPrix = 0D;

}
