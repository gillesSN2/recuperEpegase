package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_depot")
public class AchDepot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dpo_id", nullable = false)
    private Long dpoId;

    /**
     * date de creation
     */
    @Column(name = "dpo_date_creation")
    private LocalDateTime dpoDateCreation;

    /**
     * date de modification
     */
    @Column(name = "dpo_date_modif")
    private LocalDateTime dpoDateModif;

    /**
     * user de creation
     */
    @Column(name = "dpo_user_creation")
    private Long dpoUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "dpo_user_modif")
    private Long dpoUserModif = 0L;

    /**
     * code du depot
     */
    @Column(name = "dpo_code")
    private String dpoCode;

    /**
     * libelle du depot
     */
    @Column(name = "dpo_libelle")
    private String dpoLibelle;

    /**
     * 0=standard fixe 1=standard mobile 2=fictif
     */
    @Column(name = "dpo_type")
    private Integer dpoType = 0;

    /**
     * quantite minimale
     */
    @Column(name = "dpo_qte_min")
    private Float dpoQteMin = 0F;

    /**
     * quantite maximale
     */
    @Column(name = "dpo_qte_max")
    private Float dpoQteMax = 0F;

    /**
     * 1=defaut en entree
     */
    @Column(name = "dpo_defaut_in")
    private Integer dpoDefautIn = 0;

    /**
     * 1=defaut en sortie
     */
    @Column(name = "dpo_defaut_out")
    private Integer dpoDefautOut = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "dpo_inactif")
    private Integer dpoInactif = 0;

    /**
     * 0=sans reception 1=avec reception
     */
    @Column(name = "dpo_reception")
    private Integer dpoReception = 0;

    /**
     * 0=sans retout achat 1=avec retour achat
     */
    @Column(name = "dpo_retour_ach")
    private Integer dpoRetourAch = 0;

    /**
     * 0=sans bon livraison 1=avec bon livraison
     */
    @Column(name = "dpo_livraison")
    private Integer dpoLivraison = 0;

    /**
     * 0=sans retour 1=avec retour
     */
    @Column(name = "dpo_retour_vent")
    private Integer dpoRetourVent = 0;

    /**
     * 0=sans reacheminement 1=avec reacheminement
     */
    @Column(name = "dpo_reachmin")
    private Integer dpoReachmin = 0;

    /**
     * 0=sans production 1=avec production
     */
    @Column(name = "dpo_fabrication")
    private Integer dpoFabrication = 0;

    /**
     * 0=sans cession 1=avec cession
     */
    @Column(name = "dpo_cession")
    private Integer dpoCession = 0;

    /**
     * 0=sans bon de sortie 1=avec bon de sortie
     */
    @Column(name = "dpo_bon_sortie")
    private Integer dpoBonSortie = 0;

    /**
     * 0=sans bon entree 1=avec bon entree
     */
    @Column(name = "dpo_bon_entree")
    private Integer dpoBonEntree = 0;

    /**
     * 0=sans inventaire 1=avec inventaire
     */
    @Column(name = "dpo_inventaire")
    private Integer dpoInventaire = 0;

    /**
     * 0=sans depot mobile 1=avec depot mobile
     */
    @Column(name = "dpo_mobile_vent")
    private Integer dpoMobileVent = 0;

    /**
     * 0=sans collecte 1=avec collecte
     */
    @Column(name = "dpo_collecte_ach")
    private Integer dpoCollecteAch = 0;

    /**
     * 0=sans pharmacie 1=avec pharmacie
     */
    @Column(name = "dpo_pharmacie")
    private Integer dpoPharmacie = 0;

    /**
     * 0=sans carburant 1=avec carburant
     */
    @Column(name = "dpo_carburant")
    private Integer dpoCarburant = 0;

}
