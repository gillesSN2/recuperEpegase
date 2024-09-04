package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_tab_formule")
public class CptTabFormule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tabfor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tabforId;

    /**
     * numero de colonne
     */
    @Column(name = "tabfor_col")
    private Integer tabforCol;

    /**
     * nom de la zone
     */
    @Column(name = "tabfor_zone")
    private String tabforZone;

    /**
     * contenu de la formule
     */
    @Column(name = "tabfor_formule")
    private String tabforFormule;

    /**
     * filtre analytique
     */
    @Column(name = "tabfor_analytique")
    private String tabforAnalytique;

    /**
     * filtre budget
     */
    @Column(name = "tabfor_budget")
    private String tabforBudget;

    /**
     * 0=tout solde 1=solde crediteur 2=solde debiteur 3=mvts debiteur 4=mvts crediteur 5=saisie numerique 6=saisie texte 7=saisie liste
     */
    @Column(name = "tabfor_solde")
    private Integer tabforSolde = 0;

    /**
     * periode prioritaire par rapport ÃƒÂ  la periode de la colonne
     */
    @Column(name = "tabfor_periode")
    private Integer tabforPeriode = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "tabfor_inactif")
    private Integer tabforInactif = 0;

    /**
     * l ancien id cle etrangere
     */
    @Column(name = "tabfor_old_id")
    private Long tabforOldId = 0L;

    @Column(name = "tabele_id", nullable = false)
    private Long tabeleId;

    /**
     * filtre site
     */
    @Column(name = "tabfor_site")
    private String tabforSite;

    /**
     * filtre departement
     */
    @Column(name = "tabfor_departement")
    private String tabforDepartement;

    /**
     * filtre service
     */
    @Column(name = "tabfor_service")
    private String tabforService;

    /**
     * filtre region
     */
    @Column(name = "tabfor_region")
    private String tabforRegion;

    /**
     * filtre secteur
     */
    @Column(name = "tabfor_secteur")
    private String tabforSecteur;

    /**
     * filtre pdv
     */
    @Column(name = "tabfor_pdv")
    private String tabforPdv;

    /**
     * filtre activite
     */
    @Column(name = "tabfor_activite")
    private String tabforActivite;

    /**
     * filtre dossier
     */
    @Column(name = "tabfor_dossier")
    private String tabforDossier;

    /**
     * filtre parc
     */
    @Column(name = "tabfor_parc")
    private String tabforParc;

}
