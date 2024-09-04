package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_feuille_calcul")
public class PayFeuilleCalcul implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "feu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feuId;

    /**
     * date de creation
     */
    @Column(name = "feu_date_creat")
    private LocalDateTime feuDateCreat;

    /**
     * date de modification
     */
    @Column(name = "feu_date_modif")
    private LocalDateTime feuDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "feu_user_creat")
    private Long feuUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "feu_user_modif")
    private Long feuUserModif = 0L;

    /**
     * voir nature salarie xml
     */
    @Column(name = "feu_nature")
    private String feuNature;

    /**
     * code feuille
     */
    @Column(name = "feu_code")
    private String feuCode;

    /**
     * libelle feuille en FR
     */
    @Column(name = "feu_libelle_FR")
    private String feuLibelleFr;

    /**
     * libelle feuille en UK
     */
    @Column(name = "feu_libelle_UK")
    private String feuLibelleUk;

    /**
     * libelle feuille en SP
     */
    @Column(name = "feu_libelle_SP")
    private String feuLibelleSp;

    /**
     * modele
     */
    @Column(name = "feu_modele")
    private String feuModele;

    /**
     * code journal
     */
    @Column(name = "feu_journal")
    private String feuJournal;

    /**
     * compte od
     */
    @Column(name = "feu_compte")
    private String feuCompte;

    /**
     * 0=calendrier si non nb jour de decalage
     */
    @Column(name = "feu_decale")
    private Integer feuDecale = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "feu_inactif")
    private Integer feuInactif = 0;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

}
