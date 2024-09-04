package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_complement_informations")
public class CptComplementInformations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cplmen_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cplmenId;

    /**
     * type 0=activites 1=dirigeants 2=actionnaires 3=mca 4=filiales
     */
    @Column(name = "cplmen_type")
    private Integer cplmenType = 0;

    /**
     * nom
     */
    @Column(name = "cplmen_nom")
    private String cplmenNom;

    /**
     * prenom
     */
    @Column(name = "cplmen_prenom")
    private String cplmenPrenom;

    /**
     * nationnamlite
     */
    @Column(name = "cplmen_nation")
    private String cplmenNation;

    /**
     * qualite
     */
    @Column(name = "cplmen_qualite")
    private String cplmenQualite;

    /**
     * identification fiscale
     */
    @Column(name = "cplmen_fiscal")
    private String cplmenFiscal;

    /**
     * designation
     */
    @Column(name = "cplmen_designation")
    private String cplmenDesignation;

    /**
     * adresse
     */
    @Column(name = "cplmen_adresse")
    private String cplmenAdresse;

    /**
     * code
     */
    @Column(name = "cplmen_code")
    private String cplmenCode;

    /**
     * libelle
     */
    @Column(name = "cplmen_libelle")
    private String cplmenLibelle;

    /**
     * total
     */
    @Column(name = "cplmen_total")
    private Double cplmenTotal = 0D;

    /**
     * % de repartition
     */
    @Column(name = "cplmen_pourcentage")
    private Float cplmenPourcentage = 0F;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
