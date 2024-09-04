package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_modele_courriers")
public class CmmModeleCourriers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mod_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modId;

    /**
     * date de creation
     */
    @Column(name = "mod_date_creat")
    private LocalDateTime modDateCreat;

    /**
     * date de modification
     */
    @Column(name = "mod_date_modif")
    private LocalDateTime modDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "mod_user_creat")
    private Long modUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "mod_user_modif")
    private Long modUserModif = 0L;

    /**
     * code modele
     */
    @Column(name = "mod_code")
    private String modCode;

    /**
     * nom modele en FR
     */
    @Column(name = "mod_nom_FR")
    private String modNomFr;

    /**
     * nom modele en UK
     */
    @Column(name = "mod_nom_UK")
    private String modNomUk;

    /**
     * nom modele en SP
     */
    @Column(name = "mod_nom_SP")
    private String modNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "mod_inactif")
    private Integer modInactif = 0;

    /**
     * commercial(10= mail 20=lettre 21=annexe 22=correspondance 25=contrat) paye(82=contrat 83=attestation 84=avertissement 85=certificat 86=correspondance)
     */
    @Column(name = "mod_nature")
    private Integer modNature = 0;

    /**
     * vente(0=vte 1=leasing 2=assistance 3=garantie 4=sav 5=autre) paye(0=stage 1=cdd 2=cdi 3=prestataire)
     */
    @Column(name = "mod_type")
    private Integer modType = 0;

    /**
     * texte
     */
    @Column(name = "mod_texte")
    private String modTexte;

    /**
     * texte sur option
     */
    @Column(name = "mod_Option")
    private String modOption;

    /**
     * texte sur condition de paiement
     */
    @Column(name = "mod_condition_paiement")
    private String modConditionPaiement;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_accessoire")
    private Integer modAccessoire = 0;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_acompte")
    private Integer modAcompte = 0;

    /**
     * plancher taux acompte
     */
    @Column(name = "mod_taux_acompte")
    private Float modTauxAcompte = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_amortissement")
    private Integer modAmortissement = 0;

    /**
     * taux amortissement
     */
    @Column(name = "mod_taux_amortissement")
    private Float modTauxAmortissement = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_frais_financier")
    private Integer modFraisFinancier = 0;

    /**
     * taux frais financiers
     */
    @Column(name = "mod_taux_frais_financier")
    private Float modTauxFraisFinancier = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_contrat_entretien")
    private Integer modContratEntretien = 0;

    /**
     * taux contrat entretien
     */
    @Column(name = "mod_taux_contrat_entretien")
    private Float modTauxContratEntretien = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_assurance")
    private Integer modAssurance = 0;

    /**
     * taux assurance
     */
    @Column(name = "mod_taux_assurance")
    private Float modTauxAssurance = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_franchise")
    private Integer modFranchise = 0;

    /**
     * taux franchise
     */
    @Column(name = "mod_taux_franchise")
    private Float modTauxFranchise = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_frais_structure")
    private Integer modFraisStructure = 0;

    /**
     * taux frais structure
     */
    @Column(name = "mod_taux_frais_structure")
    private Float modTauxFraisStructure = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_remplacement")
    private Integer modRemplacement = 0;

    /**
     * taux vehicule de remplacement
     */
    @Column(name = "mod_taux_remplacement")
    private Float modTauxRemplacement = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_remplissage")
    private Integer modRemplissage = 0;

    /**
     * taux ponderation de remplissage
     */
    @Column(name = "mod_taux_remplissage")
    private Float modTauxRemplissage = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_marge")
    private Integer modMarge = 0;

    /**
     * taux marge
     */
    @Column(name = "mod_taux_marge")
    private Float modTauxMarge = 0F;

    /**
     * 0=sans 1=avec
     */
    @Column(name = "mod_valeur_residuelle")
    private Integer modValeurResiduelle = 0;

    /**
     * taux valeur residuelle
     */
    @Column(name = "mod_taux_valeur_residuelle")
    private Float modTauxValeurResiduelle = 0F;

    /**
     * duree minimale en nb mois
     */
    @Column(name = "mod_duree_min")
    private Integer modDureeMin = 0;

    /**
     * duree maximale en nb mois
     */
    @Column(name = "mod_duree_max")
    private Integer modDureeMax = 0;

}
