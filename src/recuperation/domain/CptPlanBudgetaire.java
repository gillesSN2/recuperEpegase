package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_plan_budgetaire")
public class CptPlanBudgetaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plb_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plbId;

    /**
     * date de creation
     */
    @Column(name = "plb_date_creat")
    private LocalDateTime plbDateCreat;

    /**
     * date de modification
     */
    @Column(name = "plb_date_modif")
    private LocalDateTime plbDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "plb_user_creat")
    private Long plbUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "plb_user_modif")
    private Long plbUserModif = 0L;

    /**
     * Annee du budget
     */
    @Column(name = "plb_annee")
    private String plbAnnee;

    /**
     * 1=vente 2=achat 3=production 4=frais generaux 5=investissement 6=tva 7=frais personnel
     */
    @Column(name = "plb_nature")
    private String plbNature;

    /**
     * code du budget
     */
    @Column(name = "plb_code")
    private String plbCode;

    /**
     * libelle du budget en FR
     */
    @Column(name = "plb_libelle_FR")
    private String plbLibelleFr;

    /**
     * libelle du budget en UK
     */
    @Column(name = "plb_libelle_UK")
    private String plbLibelleUk;

    /**
     * libelle du budget en SP
     */
    @Column(name = "plb_libelle_SP")
    private String plbLibelleSp;

    /**
     * activite
     */
    @Column(name = "plb_activite")
    private String plbActivite;

    /**
     * odre des elements
     */
    @Column(name = "plb_ordre")
    private Integer plbOrdre = 0;

    /**
     * 0=budget bloquant 1=budget non bloquant
     */
    @Column(name = "plb_bloque")
    private Integer plbBloque = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "plb_inactif")
    private Integer plbInactif = 0;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
