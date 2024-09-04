package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_grh")
public class PaySalariesGrh implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salgrh_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salgrhId;

    /**
     * date de creation
     */
    @Column(name = "salgrh_date_creat")
    private LocalDateTime salgrhDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salgrh_date_modif")
    private LocalDateTime salgrhDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salgrh_user_creat")
    private Long salgrhUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salgrh_user_modif")
    private Long salgrhUserModif = 0L;

    /**
     * numero rh
     */
    @Column(name = "salgrh_num")
    private String salgrhNum;

    /**
     * 0=accident 1=affectation 2=attestation 3=avertissement...
     */
    @Column(name = "salgrh_nature")
    private Integer salgrhNature = 0;

    /**
     * date evenement
     */
    @Column(name = "salgrh_date")
    private LocalDate salgrhDate;

    /**
     * objet evenement
     */
    @Column(name = "salgrh_objet")
    private String salgrhObjet;

    /**
     * texte evenement
     */
    @Column(name = "salgrh_texte")
    private String salgrhTexte;

    /**
     * responsable
     */
    @Column(name = "salgrh_responsable")
    private String salgrhResponsable;

    /**
     * lieu
     */
    @Column(name = "salgrh_lieu")
    private String salgrhLieu;

    /**
     * service
     */
    @Column(name = "salgrh_service")
    private String salgrhService;

    /**
     * type
     */
    @Column(name = "salgrh_type")
    private Integer salgrhType = 0;

    /**
     * date de fin
     */
    @Column(name = "salgrh_date_fin")
    private LocalDate salgrhDateFin;

    /**
     * fonction
     */
    @Column(name = "salgrh_fonction")
    private String salgrhFonction;

    /**
     * categorie
     */
    @Column(name = "salgrh_categorie")
    private String salgrhCategorie;

    /**
     * activite
     */
    @Column(name = "salgrh_activite")
    private String salgrhActivite;

    /**
     * evaluation 1
     */
    @Column(name = "salgrh_eval1")
    private Integer salgrhEval1 = 0;

    /**
     * evaluation 2
     */
    @Column(name = "salgrh_eval2")
    private Integer salgrhEval2 = 0;

    /**
     * evaluation 3
     */
    @Column(name = "salgrh_eval3")
    private Integer salgrhEval3 = 0;

    /**
     * evaluation 4
     */
    @Column(name = "salgrh_eval4")
    private Integer salgrhEval4 = 0;

    /**
     * evaluation 5
     */
    @Column(name = "salgrh_eval5")
    private Integer salgrhEval5 = 0;

    /**
     * evaluation 6
     */
    @Column(name = "salgrh_eval6")
    private Integer salgrhEval6 = 0;

    /**
     * evaluation 7
     */
    @Column(name = "salgrh_eval7")
    private Integer salgrhEval7 = 0;

    /**
     * evaluation 8
     */
    @Column(name = "salgrh_eval8")
    private Integer salgrhEval8 = 0;

    /**
     * evaluation 9
     */
    @Column(name = "salgrh_eval9")
    private Integer salgrhEval9 = 0;

    /**
     * evaluation 10
     */
    @Column(name = "salgrh_eval10")
    private Integer salgrhEval10 = 0;

    /**
     * total evaluation
     */
    @Column(name = "salgrh_tot_eval")
    private Integer salgrhTotEval = 0;

    /**
     * 0=travaille 1=ne travaille pas
     */
    @Column(name = "salgrh_travail")
    private Integer salgrhTravail = 0;

    /**
     * 0=fille 1=garcon
     */
    @Column(name = "salgrh_genre")
    private Integer salgrhGenre = 0;

    /**
     * 0=nr 1=primaire 2=secondaire 3=superieur 4=universitaire
     */
    @Column(name = "salgrh_niveau_scolaire")
    private Integer salgrhNiveauScolaire = 0;

    /**
     * duree en nombre de mois
     */
    @Column(name = "salgrh_duree")
    private Integer salgrhDuree = 0;

    /**
     * cout
     */
    @Column(name = "salgrh_cout")
    private Double salgrhCout = 0D;

    /**
     * 0=nr 1=ecart 2=perte 3=vol ou fraude 4=retard 5=autre
     */
    @Column(name = "salgrh_suspension")
    private Integer salgrhSuspension = 0;

    /**
     * 0=nr 1=apte sans restriction 2=apte service restrient 3=inacpte temporaire 4=inapte definitif
     */
    @Column(name = "salgrh_medical")
    private Integer salgrhMedical = 0;

    /**
     * groupe sanguin
     */
    @Column(name = "salgrh_groupe_sanguin")
    private String salgrhGroupeSanguin;

    /**
     * feuille
     */
    @Column(name = "salgrh_feuille")
    private Integer salgrhFeuille = 0;

    /**
     * serie ou identification
     */
    @Column(name = "salgrh_serie")
    private String salgrhSerie;

    /**
     * taille
     */
    @Column(name = "salgrh_taille")
    private String salgrhTaille;

    /**
     * couleur
     */
    @Column(name = "salgrh_couleur")
    private String salgrhCouleur;

    /**
     * quantite
     */
    @Column(name = "salgrh_qte")
    private Integer salgrhQte = 0;

    /**
     * 0= sans habilitation 1=avec habilitation
     */
    @Column(name = "salgrh_etat_val")
    private Integer salgrhEtatVal = 0;

    /**
     * 0=non valide 1=valide
     */
    @Column(name = "salgrh_etat")
    private Integer salgrhEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "salgrh_date_valide")
    private LocalDateTime salgrhDateValide;

    /**
     * date impression
     */
    @Column(name = "salgrh_date_imp")
    private LocalDateTime salgrhDateImp;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * qualite experience 0=statgiaire 1=junior 2=junior confirme 3=senior 4=senior experimente
     */
    @Column(name = "salgrh_qualite")
    private Integer salgrhQualite = 0;

    /**
     * langue
     */
    @Column(name = "salgrh_langue")
    private String salgrhLangue;

    /**
     * langue lue 0=non 1=passable 2=correct 3=excellent
     */
    @Column(name = "salgrh_langue_lu")
    private Integer salgrhLangueLu = 0;

    /**
     * langue parlee 0=non 1=passable 2=correct 3=excellent
     */
    @Column(name = "salgrh_langue_parle")
    private Integer salgrhLangueParle = 0;

    /**
     * langue ecrit 0=non 1=passable 2=correct 3=excellent
     */
    @Column(name = "salgrh_langue_ecrit")
    private Integer salgrhLangueEcrit = 0;

    /**
     * domaine de competence 1
     */
    @Column(name = "salgrh_dom_act1")
    private Boolean salgrhDomAct1 = Boolean.FALSE;

    /**
     * domaine de competence 2
     */
    @Column(name = "salgrh_dom_act2")
    private Boolean salgrhDomAct2 = Boolean.FALSE;

    /**
     * domaine de competence 3
     */
    @Column(name = "salgrh_dom_act3")
    private Boolean salgrhDomAct3 = Boolean.FALSE;

    /**
     * domaine de competence 4
     */
    @Column(name = "salgrh_dom_act4")
    private Boolean salgrhDomAct4 = Boolean.FALSE;

    /**
     * domaine de competence 5
     */
    @Column(name = "salgrh_dom_act5")
    private Boolean salgrhDomAct5 = Boolean.FALSE;

    /**
     * domaine de competence 6
     */
    @Column(name = "salgrh_dom_act6")
    private Boolean salgrhDomAct6 = Boolean.FALSE;

    /**
     * domaine de competence 1
     */
    @Column(name = "salgrh_competence1")
    private Boolean salgrhCompetence1 = Boolean.FALSE;

    /**
     * domaine de competence 2
     */
    @Column(name = "salgrh_competence2")
    private Boolean salgrhCompetence2 = Boolean.FALSE;

    /**
     * domaine de competence 3
     */
    @Column(name = "salgrh_competence3")
    private Boolean salgrhCompetence3 = Boolean.FALSE;

    /**
     * domaine de competence 4
     */
    @Column(name = "salgrh_competence4")
    private Boolean salgrhCompetence4 = Boolean.FALSE;

    /**
     * domaine de competence 5
     */
    @Column(name = "salgrh_competence5")
    private Boolean salgrhCompetence5 = Boolean.FALSE;

    /**
     * domaine de competence 6
     */
    @Column(name = "salgrh_competence6")
    private Boolean salgrhCompetence6 = Boolean.FALSE;

    /**
     * domaine de competence 7
     */
    @Column(name = "salgrh_competence7")
    private Boolean salgrhCompetence7 = Boolean.FALSE;

    /**
     * domaine de competence 8
     */
    @Column(name = "salgrh_competence8")
    private Boolean salgrhCompetence8 = Boolean.FALSE;

    /**
     * appreciation mission
     */
    @Column(name = "salgrh_appreciation")
    private String salgrhAppreciation;

    /**
     * probleme rencontree
     */
    @Column(name = "salgrh_problemme")
    private String salgrhProblemme;

    /**
     * mission 0=mission pour unwomen 1=mission autre agence
     */
    @Column(name = "salgrh_mission_origine")
    private Integer salgrhMissionOrigine = 0;

    /**
     * document rh
     */
    @Column(name = "salgrh_document")
    private String salgrhDocument;

    /**
     * evaluation 11
     */
    @Column(name = "salgrh_eval11")
    private Integer salgrhEval11 = 0;

    /**
     * evaluation 12
     */
    @Column(name = "salgrh_eval12")
    private Integer salgrhEval12 = 0;

    /**
     * feuille
     */
    @Column(name = "salgrh_feuille_old")
    private String salgrhFeuilleOld;

    /**
     * heure
     */
    @Column(name = "salgrh_heure")
    private Integer salgrhHeure = 0;

    /**
     * minute
     */
    @Column(name = "salgrh_minute")
    private Integer salgrhMinute = 0;

    /**
     * date declaration
     */
    @Column(name = "salgrh_date_declaration")
    private LocalDate salgrhDateDeclaration;

    /**
     * circonstance
     */
    @Column(name = "salgrh_circonstance")
    private String salgrhCirconstance;

    /**
     * temoins
     */
    @Column(name = "salgrh_temoins")
    private String salgrhTemoins;

    /**
     * rapport medical
     */
    @Column(name = "salgrh_rapport_medical")
    private String salgrhRapportMedical;

    /**
     * temps indisponibilite
     */
    @Column(name = "salgrh_temps_indisponibilite")
    private String salgrhTempsIndisponibilite;

    /**
     * nature accident
     */
    @Column(name = "salgrh_nature_accident")
    private String salgrhNatureAccident;

    /**
     * motif
     */
    @Column(name = "salgrh_motif")
    private String salgrhMotif;

}
