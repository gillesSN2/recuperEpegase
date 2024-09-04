package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "med_cim")
public class MedCim implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cim_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cimId;

    /**
     * code cmd
     */
    @Column(name = "cim_code_cmd")
    private String cimCodeCmd;

    /**
     * libelle cmd
     */
    @Column(name = "cim_lib_cmd")
    private String cimLibCmd;

    /**
     * code cim
     */
    @Column(name = "cim_code")
    private String cimCode;

    /**
     * libelle cim FR
     */
    @Column(name = "cim_libelle_FR")
    private String cimLibelleFr;

    /**
     * libelle cim UK
     */
    @Column(name = "cim_libelle_UK")
    private String cimLibelleUk;

    /**
     * libelle cim SP
     */
    @Column(name = "cim_libelle_SP")
    private String cimLibelleSp;

}
