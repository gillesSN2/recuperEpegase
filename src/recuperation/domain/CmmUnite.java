package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_unite")
public class CmmUnite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uni_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniId;

    /**
     * date de creation
     */
    @Column(name = "uni_date_creation")
    private LocalDateTime uniDateCreation;

    /**
     * date de modification
     */
    @Column(name = "uni_date_modif")
    private LocalDateTime uniDateModif;

    /**
     * user de creation
     */
    @Column(name = "uni_user_creation")
    private Long uniUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "uni_user_modif")
    private Long uniUserModif = 0L;

    /**
     * libelle unite
     */
    @Column(name = "uni_libelle")
    private String uniLibelle;

    @Column(name = "uni_echelle")
    private Integer uniEchelle = 0;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "uni_inactif")
    private Integer uniInactif = 0;

}
