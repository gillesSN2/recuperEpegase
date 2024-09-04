package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vte_chargement_frais")
public class VteChargementFrais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "chafra_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chafraId;

    /**
     * code produit
     */
    @Column(name = "chafra_code")
    private String chafraCode;

    /**
     * famille vente
     */
    @Column(name = "chafra_famille")
    private String chafraFamille;

    /**
     * libelle produit
     */
    @Column(name = "chafra_libelle")
    private String chafraLibelle;

    /**
     * num de piece
     */
    @Column(name = "chafra_piece")
    private String chafraPiece;

    /**
     * description du frais
     */
    @Column(name = "chafra_description")
    private String chafraDescription;

    /**
     * montant du frais
     */
    @Column(name = "chafra_montant")
    private Double chafraMontant = 0D;

    /**
     * date du frais
     */
    @Column(name = "chafra_date")
    private LocalDate chafraDate;

    @Column(name = "chamob_id", nullable = false)
    private Long chamobId;

}
