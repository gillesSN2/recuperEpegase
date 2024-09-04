package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_suivi_commande_achats")
public class AchSuiviCommandeAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "suiach_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suiachId;

    /**
     * date de creation
     */
    @Column(name = "suiach_date_creation")
    private LocalDateTime suiachDateCreation;

    /**
     * date de modification
     */
    @Column(name = "suiach_date_modif")
    private LocalDateTime suiachDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "suiach_user_creation")
    private Long suiachUserCreation = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "suiach_user_modif")
    private Long suiachUserModif = 0L;

    /**
     * code suivi
     */
    @Column(name = "suiach_code")
    private String suiachCode;

    /**
     * nom du suivi en FR
     */
    @Column(name = "suiach_libelle_fr")
    private String suiachLibelleFr;

    /**
     * nom du suivi en UK
     */
    @Column(name = "suiach_libelle_uk")
    private String suiachLibelleUk;

    /**
     * nom du suivi en SP
     */
    @Column(name = "suiach_libelle_sp")
    private String suiachLibelleSp;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suiach_aerien")
    private Boolean suiachAerien = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suiach_maritime")
    private Boolean suiachMaritime = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suiach_express")
    private Boolean suiachExpress = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suiach_route")
    private Boolean suiachRoute = Boolean.FALSE;

    /**
     * 0=inactif 1=actif
     */
    @Column(name = "suiach_autre_transit")
    private Boolean suiachAutreTransit = Boolean.FALSE;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "suiach_inactif")
    private Integer suiachInactif = 0;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

}
