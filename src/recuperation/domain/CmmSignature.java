package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_signature")
public class CmmSignature implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sgr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sgrId;

    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "sgr_nature")
    private Integer sgrNature = 0;

    /**
     * 0=mono signature 1=multi signature
     */
    @Column(name = "sgr_mode")
    private Integer sgrMode = 0;

    /**
     * numero du document
     */
    @Column(name = "sgr_num")
    private String sgrNum;

    /**
     * numero du document
     */
    @Column(name = "sgr_id_doc")
    private Long sgrIdDoc = 0L;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire1")
    private Integer sgrObligatoire1 = 0;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire2")
    private Integer sgrObligatoire2 = 0;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire3")
    private Integer sgrObligatoire3 = 0;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire4")
    private Integer sgrObligatoire4 = 0;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire5")
    private Integer sgrObligatoire5 = 0;

    /**
     * 1=obligatoire
     */
    @Column(name = "sgr_obligatoire6")
    private Integer sgrObligatoire6 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire1")
    private Integer sgrNonObligatoire1 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire2")
    private Integer sgrNonObligatoire2 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire3")
    private Integer sgrNonObligatoire3 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire4")
    private Integer sgrNonObligatoire4 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire5")
    private Integer sgrNonObligatoire5 = 0;

    /**
     * 1=non obligatoire
     */
    @Column(name = "sgr_non_obligatoire6")
    private Integer sgrNonObligatoire6 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider1")
    private Integer sgrValider1 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider2")
    private Integer sgrValider2 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider3")
    private Integer sgrValider3 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider4")
    private Integer sgrValider4 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider5")
    private Integer sgrValider5 = 0;

    /**
     * 1=valider
     */
    @Column(name = "sgr_valider6")
    private Integer sgrValider6 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler1")
    private Integer sgrGeler1 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler2")
    private Integer sgrGeler2 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler3")
    private Integer sgrGeler3 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler4")
    private Integer sgrGeler4 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler5")
    private Integer sgrGeler5 = 0;

    /**
     * 1=geler
     */
    @Column(name = "sgr_geler6")
    private Integer sgrGeler6 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter1")
    private Integer sgrRejeter1 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter2")
    private Integer sgrRejeter2 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter3")
    private Integer sgrRejeter3 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter4")
    private Integer sgrRejeter4 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter5")
    private Integer sgrRejeter5 = 0;

    /**
     * 1=rejeter
     */
    @Column(name = "sgr_rejeter6")
    private Integer sgrRejeter6 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours1")
    private Integer sgrEncours1 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours2")
    private Integer sgrEncours2 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours3")
    private Integer sgrEncours3 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours4")
    private Integer sgrEncours4 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours5")
    private Integer sgrEncours5 = 0;

    /**
     * 1=encours
     */
    @Column(name = "sgr_encours6")
    private Integer sgrEncours6 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger1")
    private Integer sgrCorriger1 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger2")
    private Integer sgrCorriger2 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger3")
    private Integer sgrCorriger3 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger4")
    private Integer sgrCorriger4 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger5")
    private Integer sgrCorriger5 = 0;

    /**
     * 1=corriger
     */
    @Column(name = "sgr_corriger6")
    private Integer sgrCorriger6 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users1")
    private Integer sgrUsers1 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users2")
    private Integer sgrUsers2 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users3")
    private Integer sgrUsers3 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users4")
    private Integer sgrUsers4 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users5")
    private Integer sgrUsers5 = 0;

    /**
     * 1=users
     */
    @Column(name = "sgr_users6")
    private Integer sgrUsers6 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace1")
    private Integer sgrRemplace1 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace2")
    private Integer sgrRemplace2 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace3")
    private Integer sgrRemplace3 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace4")
    private Integer sgrRemplace4 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace5")
    private Integer sgrRemplace5 = 0;

    /**
     * 1=remplace
     */
    @Column(name = "sgr_remplace6")
    private Integer sgrRemplace6 = 0;

    @Column(name = "phr_id", nullable = false)
    private Long phrId;

}
