package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "med_laboratoire_resultat")
public class MedLaboratoireResultat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "labres_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labresId;

    /**
     * numero laboratoie
     */
    @Column(name = "labres_num")
    private String labresNum;

    /**
     * code du produit
     */
    @Column(name = "labres_code")
    private String labresCode;

    /**
     * libelle examen
     */
    @Column(name = "labres_libelle")
    private String labresLibelle;

    /**
     * type de reponse 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple 8=datail examen
     */
    @Column(name = "labres_type")
    private Integer labresType = 0;

    /**
     * ordre de la response
     */
    @Column(name = "labres_ordre")
    private Integer labresOrdre = 0;

    /**
     * reponse numerique
     */
    @Column(name = "labres_numerique")
    private Double labresNumerique = 0D;

    /**
     * reponse date
     */
    @Column(name = "labres_date")
    private LocalDate labresDate;

    /**
     * reponse image
     */
    @Column(name = "labres_image")
    private String labresImage;

    /**
     * reponse pdf
     */
    @Column(name = "labres_pdf")
    private String labresPdf;

    /**
     * reponse texte
     */
    @Column(name = "labres_texte")
    private String labresTexte;

    /**
     * reponse unique
     */
    @Column(name = "labres_reponse_unique")
    private String labresReponseUnique;

    /**
     * action
     */
    @Column(name = "labres_action")
    private String labresAction;

    /**
     * reponse multiple
     */
    @Column(name = "labres_reponse_multiple")
    private String labresReponseMultiple;

    /**
     * unite reponse
     */
    @Column(name = "labres_unite")
    private String labresUnite;

    /**
     * coefficient de conversion
     */
    @Column(name = "labres_coef")
    private Float labresCoef = 0F;

    /**
     * unite reponse convertie
     */
    @Column(name = "labres_unite_convertie")
    private String labresUniteConvertie;

    /**
     * fourchette
     */
    @Column(name = "labres_fourchette")
    private String labresFourchette;

    /**
     * fourchette mini
     */
    @Column(name = "labres_fourchette_min")
    private Double labresFourchetteMin = 0D;

    /**
     * fourchette maxi
     */
    @Column(name = "labres_fourchette_max")
    private Double labresFourchetteMax = 0D;

    /**
     * commentaire
     */
    @Column(name = "labres_commentaire")
    private String labresCommentaire;

    /**
     * technique utilisee
     */
    @Column(name = "labres_technique")
    private String labresTechnique;

    /**
     * norme statique
     */
    @Column(name = "labres_norme")
    private String labresNorme;

    /**
     * id de la consultation laboratoire
     */
    @Column(name = "labres_id_lab")
    private Long labresIdLab = 0L;

    /**
     * id du patient
     */
    @Column(name = "labres_id_patient")
    private Long labresIdPatient = 0L;

    @Column(name = "lablig_id", nullable = false)
    private Long labligId;

}
