package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_activites")
public class CmmActivites implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "act_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actId;

    /**
     * date de creation
     */
    @Column(name = "act_date_creat")
    private LocalDateTime actDateCreat;

    /**
     * date de modification
     */
    @Column(name = "act_date_modif")
    private LocalDateTime actDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "act_user_creat")
    private Long actUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "act_user_modif")
    private Long actUserModif = 0L;

    /**
     * code activite
     */
    @Column(name = "act_code")
    private String actCode;

    /**
     * nom activite en FR
     */
    @Column(name = "act_nom_FR")
    private String actNomFr;

    /**
     * nom activite en UK
     */
    @Column(name = "act_nom_UK")
    private String actNomUk;

    /**
     * nom activite en SP
     */
    @Column(name = "act_nom_SP")
    private String actNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "act_inactif")
    private Integer actInactif = 0;

    /**
     * annee de debut de validite
     */
    @Column(name = "act_annee_debut")
    private Integer actAnneeDebut = 0;

    /**
     * annee de fin de validite
     */
    @Column(name = "act_annee_fin")
    private Integer actAnneeFin = 0;

    /**
     * 1=autorise dans les ventes
     */
    @Column(name = "act_vte")
    private Boolean actVte = Boolean.FALSE;

    /**
     * 1=autorise dans les achats
     */
    @Column(name = "act_ach")
    private Boolean actAch = Boolean.FALSE;

    /**
     * 1=autorise dans la production
     */
    @Column(name = "act_prd")
    private Boolean actPrd = Boolean.FALSE;

    /**
     * 1=autorise dans les frais generaux
     */
    @Column(name = "act_frg")
    private Boolean actFrg = Boolean.FALSE;

    /**
     * 1=autorise dans les investissements
     */
    @Column(name = "act_inv")
    private Boolean actInv = Boolean.FALSE;

    /**
     * 1=autorise dans la tva
     */
    @Column(name = "act_tva")
    private Boolean actTva = Boolean.FALSE;

    /**
     * 1=autorise dans les impots et taxes
     */
    @Column(name = "act_tax")
    private Boolean actTax = Boolean.FALSE;

    /**
     * 1=autorise dans les salaries
     */
    @Column(name = "act_sal")
    private Boolean actSal = Boolean.FALSE;

    /**
     * 0=sans option 1=num contrat 2=num dossier 3=num or
     */
    @Column(name = "act_options")
    private Integer actOptions = 0;

    /**
     * id responsable
     */
    @Column(name = "act_id_responsable")
    private Long actIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "act_nom_responsable")
    private String actNomResponsable;

    /**
     * code de regroupement
     */
    @Column(name = "act_regroupement")
    private String actRegroupement;

    /**
     * code colonne
     */
    @Column(name = "act_colonne")
    private String actColonne;

}
