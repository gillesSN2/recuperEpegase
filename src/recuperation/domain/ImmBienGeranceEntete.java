package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "imm_bien_gerance_entete")
public class ImmBienGeranceEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "biegerent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long biegerentId;

    /**
     * date de creation
     */
    @Column(name = "biegerent_date_creat")
    private LocalDateTime biegerentDateCreat;

    /**
     * date de modification
     */
    @Column(name = "biegerent_date_modif")
    private LocalDateTime biegerentDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "biegerent_user_creat")
    private Long biegerentUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "biegerent_user_modif")
    private Long biegerentUserModif = 0L;

    /**
     * date de signature
     */
    @Column(name = "biegerent_date_signature")
    private LocalDate biegerentDateSignature;

    /**
     * numero gerance
     */
    @Column(name = "biegerent_num")
    private String biegerentNum;

    /**
     * date debut
     */
    @Column(name = "biegerent_date_debut")
    private LocalDate biegerentDateDebut;

    /**
     * date de fin
     */
    @Column(name = "biegerent_date_fin")
    private LocalDate biegerentDateFin;

    /**
     * duree
     */
    @Column(name = "biegerent_duree")
    private Integer biegerentDuree = 0;

    /**
     * 0=en cours 1=validee 2=annulee 3=gelee 4=terminee
     */
    @Column(name = "biegerent_etat")
    private Integer biegerentEtat = 0;

    /**
     * 0=mensuel 1=trimestriel 2=semestre 3=annuel
     */
    @Column(name = "biegerent_mode")
    private Integer biegerentMode = 0;

    /**
     * nom du tiers
     */
    @Column(name = "biegerent_nom_tiers")
    private String biegerentNomTiers;

    /**
     * nom du tiers
     */
    @Column(name = "biegerent_civil_tiers")
    private String biegerentCivilTiers;

    /**
     * assujettissement du tiers proprietaire 0=aucun 1=irpp 2=is
     */
    @Column(name = "biegerent_type_tiers")
    private Integer biegerentTypeTiers = 0;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "biegerent_serie")
    private String biegerentSerie;

    /**
     * 0=avec tva 1=sans tva
     */
    @Column(name = "biegerent_exo_tva")
    private Integer biegerentExoTva = 0;

    /**
     * nom du commercial
     */
    @Column(name = "biegerent_nom_responsable")
    private String biegerentNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "biegerent_id_responsable")
    private Long biegerentIdResponsable = 0L;

    /**
     * texte du contrat
     */
    @Column(name = "biegerent_contrat")
    private String biegerentContrat;

    /**
     * date impression
     */
    @Column(name = "biegerent_date_imp")
    private LocalDate biegerentDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "biegerent_modele_imp")
    private String biegerentModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "biegerent_etat_val")
    private Integer biegerentEtatVal = 0;

    /**
     * date de validite
     */
    @Column(name = "biegerent_date_validite")
    private LocalDate biegerentDateValidite;

    /**
     * date de validation
     */
    @Column(name = "biegerent_date_valide")
    private LocalDate biegerentDateValide;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

}
