package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_blivraison_livree")
public class VteBlivraisonLivree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "blvliv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blvlivId;

    /**
     * id du bl
     */
    @Column(name = "blvliv_id_bl")
    private Long blvlivIdBl = 0L;

    /**
     * code produit
     */
    @Column(name = "blvliv_code")
    private String blvlivCode;

    /**
     * code depot
     */
    @Column(name = "blvliv_depot")
    private String blvlivDepot;

    /**
     * quantite livree
     */
    @Column(name = "blvliv_qte_livree")
    private Float blvlivQteLivree = 0F;

    /**
     * quantite utilisee (valable pour le stock)
     */
    @Column(name = "blvliv_qte_util_livree")
    private Float blvlivQteUtilLivree = 0F;

    /**
     * date livraison
     */
    @Column(name = "blvliv_date")
    private LocalDateTime blvlivDate;

    /**
     * nom du chauffeur
     */
    @Column(name = "blvliv_chauffeur")
    private String blvlivChauffeur;

    /**
     * immatricule du vehicule
     */
    @Column(name = "blvliv_vehicule")
    private String blvlivVehicule;

    /**
     * preparateur
     */
    @Column(name = "blvliv_preparateur")
    private String blvlivPreparateur;

    @Column(name = "blvlig_id", nullable = false)
    private Long blvligId;

}
