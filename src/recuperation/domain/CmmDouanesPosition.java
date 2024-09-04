package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_douanes_position")
public class CmmDouanesPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "doupos_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long douposId;

    /**
     * code zone commerciale
     */
    @Column(name = "doupos_zone")
    private String douposZone;

    /**
     * code douane
     */
    @Column(name = "doupos_code")
    private String douposCode;

    /**
     * nom activite en FR
     */
    @Column(name = "doupos_lib_FR")
    private String douposLibFr;

    /**
     * nom activite en UK
     */
    @Column(name = "doupos_lib_UK")
    private String douposLibUk;

    /**
     * nom activite en SP
     */
    @Column(name = "doupos_lib_SP")
    private String douposLibSp;

    /**
     * unite
     */
    @Column(name = "doupos_unite")
    private String douposUnite;

    /**
     * droit de douane
     */
    @Column(name = "doupos_dd")
    private Float douposDd = 0F;

    /**
     * risque de solidarite
     */
    @Column(name = "doupos_rs")
    private Float douposRs = 0F;

    /**
     * taux ??
     */
    @Column(name = "doupos_pcs")
    private Float douposPcs = 0F;

    /**
     * droit accise
     */
    @Column(name = "doupos_da")
    private Float douposDa = 0F;

    /**
     * autre droit
     */
    @Column(name = "doupos_ad")
    private Float douposAd = 0F;

    /**
     * tva
     */
    @Column(name = "doupos_tva")
    private Float douposTva = 0F;

    /**
     * taux cumule
     */
    @Column(name = "doupos_cumul")
    private Float douposCumul = 0F;

    /**
     * chapitre
     */
    @Column(name = "doupos_chapitre")
    private String douposChapitre;

    /**
     * code chapitre
     */
    @Column(name = "doupos_code_chapitre")
    private String douposCodeChapitre;

    /**
     * section
     */
    @Column(name = "doupos_section")
    private String douposSection;

    /**
     * code section
     */
    @Column(name = "doupos_code_section")
    private String douposCodeSection;

    /**
     * 0=non utilise 1=utilise
     */
    @Column(name = "doupos_util")
    private Integer douposUtil = 0;

}
