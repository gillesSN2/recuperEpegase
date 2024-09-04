package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_suivi_livraison_ventes")
public class VteSuiviLivraisonVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "suivte_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suivteId;

    /**
     * date de creation
     */
    @Column(name = "suivte_date_creation")
    private LocalDateTime suivteDateCreation;

    /**
     * date de modification
     */
    @Column(name = "suivte_date_modif")
    private LocalDateTime suivteDateModif;

    /**
     * user de creation
     */
    @Column(name = "suivte_user_creation")
    private Long suivteUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "suivte_user_modif")
    private Long suivteUserModif = 0L;

    /**
     * code du suivi de livraison
     */
    @Column(name = "suivte_code")
    private String suivteCode;

    /**
     * libelle du suivi de livraison FR
     */
    @Column(name = "suivte_libelle_FR")
    private String suivteLibelleFr;

    /**
     * libelle du suivi de livraison UK
     */
    @Column(name = "suivte_libelle_UK")
    private String suivteLibelleUk;

    /**
     * libelle du suivi de livraisison SP
     */
    @Column(name = "suivte_libelle_SP")
    private String suivteLibelleSp;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suivte_aerien")
    private Boolean suivteAerien = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suivte_maritime")
    private Boolean suivteMaritime = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suivte_express")
    private Boolean suivteExpress = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suivte_route")
    private Boolean suivteRoute = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suivte_autre_transit")
    private Boolean suivteAutreTransit = Boolean.FALSE;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "suivte_inactif")
    private Integer suivteInactif = 0;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

}
