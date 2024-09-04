package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_formules_ventes")
public class VteFormulesVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "forvte_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forvteId;

    /**
     * date de creation
     */
    @Column(name = "forvte_date_creation")
    private LocalDateTime forvteDateCreation;

    /**
     * date de modification
     */
    @Column(name = "forvte_date_modif")
    private LocalDateTime forvteDateModif;

    /**
     * user de creation
     */
    @Column(name = "forvte_user_creation")
    private Long forvteUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "forvte_user_modif")
    private Long forvteUserModif = 0L;

    /**
     * libelle de la formule FR
     */
    @Column(name = "forvte_libelle_FR")
    private String forvteLibelleFr;

    /**
     * libelle de la formule UK
     */
    @Column(name = "forvte_libelle_UK")
    private String forvteLibelleUk;

    /**
     * libelle de la formule SP
     */
    @Column(name = "forvte_libelle_SP")
    private String forvteLibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "forvte_inactif")
    private Integer forvteInactif = 0;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

}
