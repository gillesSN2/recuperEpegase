package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_detail")
public class CmmProduitsDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prodet_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodetId;

    /**
     * ordre des reponses
     */
    @Column(name = "prodet_ordre")
    private Integer prodetOrdre = 0;

    /**
     * nom item en FR
     */
    @Column(name = "prodet_libelle")
    private String prodetLibelle;

    /**
     * 0=titre 1=numerique 2=date 3=image 4=texte 5=reponse unique 6=reponse unique + action 7=reponse multiple
     */
    @Column(name = "prodet_type")
    private Integer prodetType = 0;

    /**
     * unite usuelle
     */
    @Column(name = "prodet_unite")
    private String prodetUnite;

    /**
     * coefficient de convertion
     */
    @Column(name = "prodet_coef")
    private Float prodetCoef = 0F;

    /**
     * unite convertie
     */
    @Column(name = "prodet_unite_conv")
    private String prodetUniteConv;

    /**
     * norme statique
     */
    @Column(name = "prodet_norme")
    private String prodetNorme;

    @Column(name = "prolab_id", nullable = false)
    private Long prolabId;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    /**
     * code produit
     */
    @Column(name = "prodet_code")
    private String prodetCode;

}
