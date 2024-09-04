package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "imm_bien_travaux_entete")
public class ImmBienTravauxEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bietraent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bietraentId;

    /**
     * date de creation
     */
    @Column(name = "bietraent_date_creat")
    private LocalDateTime bietraentDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bietraent_date_modif")
    private LocalDateTime bietraentDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bietraent_user_creat")
    private Long bietraentUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "bietraent_user_modif")
    private Long bietraentUserModif = 0L;

    /**
     * numero travaux
     */
    @Column(name = "bietraent_num")
    private String bietraentNum;

    /**
     * code bien
     */
    @Column(name = "bietraent_code_bien")
    private String bietraentCodeBien;

    /**
     * date debut
     */
    @Column(name = "bietraent_date_debut")
    private LocalDate bietraentDateDebut;

    /**
     * date de fin
     */
    @Column(name = "bietraent_date_fin")
    private LocalDate bietraentDateFin;

    /**
     * duree
     */
    @Column(name = "bietraent_duree")
    private Integer bietraentDuree = 0;

    /**
     * 0=en cours 1=valide 2=annule 3=gele 4=termine
     */
    @Column(name = "bietraent_etat")
    private Integer bietraentEtat = 0;

    /**
     * serie A, B, C, D ou X
     */
    @Column(name = "bietraent_serie")
    private String bietraentSerie;

    /**
     * nom du commercial
     */
    @Column(name = "bietraent_nom_responsable")
    private String bietraentNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "bietraent_id_responsable")
    private Long bietraentIdResponsable = 0L;

    /**
     * commentaire
     */
    @Column(name = "bietraent_objet")
    private String bietraentObjet;

    /**
     * descriptif
     */
    @Column(name = "bietraent_descriptif")
    private String bietraentDescriptif;

    /**
     * cout theorique
     */
    @Column(name = "bietraent_cout_theorique")
    private Double bietraentCoutTheorique = 0D;

    /**
     * cout reel
     */
    @Column(name = "bietraent_cout_reel")
    private Double bietraentCoutReel = 0D;

    /**
     * date de controle
     */
    @Column(name = "bietraent_date_crtl")
    private LocalDate bietraentDateCrtl;

    /**
     * observation de controle
     */
    @Column(name = "bietraent_obs_crtl")
    private String bietraentObsCrtl;

    /**
     * rapport sur le controle
     */
    @Column(name = "bietraent_rapport_ctrl")
    private String bietraentRapportCtrl;

    /**
     * nom du controleur
     */
    @Column(name = "bietraent_nom_ctrl")
    private String bietraentNomCtrl;

    /**
     * id du controleur
     */
    @Column(name = "bietraent_id_ctrl")
    private Long bietraentIdCtrl = 0L;

    /**
     * date impression
     */
    @Column(name = "bietraent_date_imp")
    private LocalDate bietraentDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "bietraent_modele_imp")
    private String bietraentModeleImp;

    @Column(name = "bie_id")
    private Long bieId;

}
