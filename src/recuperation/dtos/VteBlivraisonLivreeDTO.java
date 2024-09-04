package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteBlivraisonLivreeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long blvlivId;


    /**
     * id du bl
     */
    private Long blvlivIdBl;


    /**
     * code produit
     */
    private String blvlivCode;


    /**
     * code depot
     */
    private String blvlivDepot;


    /**
     * quantite livree
     */
    private Float blvlivQteLivree;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float blvlivQteUtilLivree;


    /**
     * date livraison
     */
    private LocalDateTime blvlivDate;


    /**
     * nom du chauffeur
     */
    private String blvlivChauffeur;


    /**
     * immatricule du vehicule
     */
    private String blvlivVehicule;


    /**
     * preparateur
     */
    private String blvlivPreparateur;

    private Long blvligId;

}
