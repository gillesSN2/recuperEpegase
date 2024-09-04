package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pay_salaries_missions_frais")
public class PaySalariesMissionsFrais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salmisfra_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salmisfraId;

    /**
     * date du frais
     */
    @Column(name = "salmisfra_date")
    private LocalDate salmisfraDate;

    /**
     * objet du frais
     */
    @Column(name = "salmisfra_objet")
    private String salmisfraObjet;

    /**
     * 0=preparation mission 1=retour mission
     */
    @Column(name = "salmisfra_mode")
    private Integer salmisfraMode = 0;

    /**
     * 0=transport 1=hebergement 2=restauration 3=divers
     */
    @Column(name = "salmisfra_type")
    private Integer salmisfraType = 0;

    /**
     * reference du frais
     */
    @Column(name = "salmisfra_reference")
    private String salmisfraReference;

    /**
     * fourisseur origine
     */
    @Column(name = "salmisfra_fournisseur")
    private String salmisfraFournisseur;

    /**
     * cout du frais
     */
    @Column(name = "salmisfra_cout")
    private Double salmisfraCout = 0D;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "mis_id", nullable = false)
    private Long misId;

}
