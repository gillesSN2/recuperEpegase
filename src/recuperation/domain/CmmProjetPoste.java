package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_projet_poste")
public class CmmProjetPoste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "propos_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proposId;

    @Column(name = "propos_code")
    private String proposCode;

    @Column(name = "propos_libelle_FR")
    private String proposLibelleFr;

    @Column(name = "propos_libelle_UK")
    private String proposLibelleUk;

    @Column(name = "propos_libelle_SP")
    private String proposLibelleSp;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
