package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_produits_dci")
public class MedProduitsDci implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prodci_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodciId;

    /**
     * date de creation
     */
    @Column(name = "prodci_date_creation")
    private LocalDateTime prodciDateCreation;

    /**
     * date de modification
     */
    @Column(name = "prodci_date_modif")
    private LocalDateTime prodciDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "prodci_user_creation")
    private Long prodciUserCreation = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "prodci_user_modif")
    private Long prodciUserModif = 0L;

    /**
     * code dci
     */
    @Column(name = "prodci_code")
    private String prodciCode;

    /**
     * forme
     */
    @Column(name = "prodci_forme")
    private String prodciForme;

    /**
     * indication
     */
    @Column(name = "prodci_indication")
    private String prodciIndication;

    /**
     * posologie
     */
    @Column(name = "prodci_posologie")
    private String prodciPosologie;

    /**
     * contre indication
     */
    @Column(name = "prodci_contre_indic")
    private String prodciContreIndic;

    /**
     * effet secondaire
     */
    @Column(name = "prodci_effet_second")
    private String prodciEffetSecond;

    /**
     * 0=medicamment 1= a base de plante 2=veterinaire 3=hydratant cutanee 4=parapharmacie
     */
    @Column(name = "prodci_type")
    private Integer prodciType = 0;

    /**
     * ???
     */
    @Column(name = "prodci_cat")
    private Integer prodciCat = 0;

}
