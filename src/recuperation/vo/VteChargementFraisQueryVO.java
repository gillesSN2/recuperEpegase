package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VteChargementFraisQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long chafraId;


    /**
     * code produit
     */
    private String chafraCode;


    /**
     * famille vente
     */
    private String chafraFamille;


    /**
     * libelle produit
     */
    private String chafraLibelle;


    /**
     * num de piece
     */
    private String chafraPiece;


    /**
     * description du frais
     */
    private String chafraDescription;


    /**
     * montant du frais
     */
    private Double chafraMontant;


    /**
     * date du frais
     */
    private LocalDate chafraDate;

    private Long chamobId;

}
