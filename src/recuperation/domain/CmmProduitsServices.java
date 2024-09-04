package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_services")
public class CmmProduitsServices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "proser_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proserId;

    /**
     * code de service
     */
    @Column(name = "proser_code")
    private String proserCode;

    /**
     * nom du service en FR
     */
    @Column(name = "proser_nom_FR")
    private String proserNomFr;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @Column(name = "ser_id", nullable = false)
    private Long serId;

}
