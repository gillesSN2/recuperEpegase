package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_laboratoire")
public class CmmProduitsLaboratoire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prolab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prolabId;

    /**
     * nom item en FR
     */
    @Column(name = "prolab_libelle_FR")
    private String prolabLibelleFr;

    /**
     * nom item en UK
     */
    @Column(name = "prolab_libelle_UK")
    private String prolabLibelleUk;

    /**
     * nom item en SP
     */
    @Column(name = "prolab_libelle_SP")
    private String prolabLibelleSp;

    /**
     * 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple 8=datail examen
     */
    @Column(name = "prolab_type")
    private Integer prolabType = 0;

    /**
     * unite usuelle
     */
    @Column(name = "prolab_unite")
    private String prolabUnite;

    /**
     * coefficient de convertion
     */
    @Column(name = "prolab_coef")
    private Float prolabCoef = 0F;

    /**
     * unite convertie
     */
    @Column(name = "prolab_unite_conv")
    private String prolabUniteConv;

    /**
     * ordre
     */
    @Column(name = "prolab_ordre")
    private Integer prolabOrdre = 0;

    /**
     * technique utilisee
     */
    @Column(name = "prolab_technique")
    private String prolabTechnique;

    /**
     * norme statique
     */
    @Column(name = "prolab_norme")
    private String prolabNorme;

    /**
     * 1=anonyme
     */
    @Column(name = "prolab_anonyme")
    private Integer prolabAnonyme = 0;

    /**
     * 1=impression etiquette
     */
    @Column(name = "prolab_etiquette")
    private Integer prolabEtiquette = 0;

    /**
     * 0=libre 1=conclusion unique 2=conclusion mulipte
     */
    @Column(name = "prolab_conclusion")
    private Integer prolabConclusion = 0;

    /**
     * conclusion par defaut
     */
    @Column(name = "prolab_conclusion_def")
    private String prolabConclusionDef;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
