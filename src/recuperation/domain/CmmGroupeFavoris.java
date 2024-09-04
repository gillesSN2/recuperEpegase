package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_groupe_favoris")
public class CmmGroupeFavoris implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "grpfav_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grpfavId;

    /**
     * 0=repertoire
     */
    @Column(name = "grpfav_nature")
    private Integer grpfavNature = 0;

    /**
     * nom du repertoire
     */
    @Column(name = "grpfav_repertoire")
    private String grpfavRepertoire;

    /**
     * 0=sans acces 1=avec acces
     */
    @Column(name = "grpfav_acces")
    private Boolean grpfavAcces = Boolean.FALSE;

    /**
     * 0=sans ajout 1=avec ajout
     */
    @Column(name = "grpfav_ajout")
    private Boolean grpfavAjout = Boolean.FALSE;

    /**
     * 0=sans modif 1=avec modif
     */
    @Column(name = "grpfav_modif")
    private Boolean grpfavModif = Boolean.FALSE;

    /**
     * 0=sans suppression 1=avec suupression
     */
    @Column(name = "grpfac_supp")
    private Boolean grpfacSupp = Boolean.FALSE;

    @Column(name = "grp_id", nullable = false)
    private Long grpId;

}
