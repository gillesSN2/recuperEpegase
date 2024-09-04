package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_formules_achats")
public class AchFormulesAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "forach_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forachId;

    /**
     * date de creation
     */
    @Column(name = "forach_date_creation")
    private LocalDateTime forachDateCreation;

    /**
     * date de modification
     */
    @Column(name = "forach_date_modif")
    private LocalDateTime forachDateModif;

    /**
     * user de creation
     */
    @Column(name = "forach_user_creation")
    private Long forachUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "forach_user_modif")
    private Long forachUserModif = 0L;

    /**
     * libelle FR
     */
    @Column(name = "forach_libelle_fr")
    private String forachLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "forach_libelle_uk")
    private String forachLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "forach_libelle_sp")
    private String forachLibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "forach_inactif")
    private Integer forachInactif = 0;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

}
