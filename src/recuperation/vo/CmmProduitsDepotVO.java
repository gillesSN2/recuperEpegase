package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class CmmProduitsDepotVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prodepId can not null")
    private Long prodepId;


    /**
     * unite de stockage
     */
    private String prodepUnite;


    /**
     * valeur unite de stockage
     */
    private Integer prodepEchelle;


    /**
     * quantite minimale
     */
    private Float prodepQteMini;


    /**
     * quantite maximale
     */
    private Float prodepQteMaxi;


    /**
     * quantite consommation theorique
     */
    private Float prodepQteConso;


    /**
     * dernier coef pr
     */
    private Float prodepCoefPr;


    /**
     * dernier PA
     */
    private Double prodepPa;


    /**
     * dernier PR
     */
    private Double prodepPr;


    /**
     * dernier PR au kilo
     */
    private Double prodepPrKg;


    /**
     * dernier PUMP
     */
    private Double prodepPump;


    /**
     * date dernier inventaire
     */
    private LocalDate prodepDateInv;


    /**
     * date derniere entree
     */
    private LocalDate prodepDateEntree;


    /**
     * date derniere sortie
     */
    private LocalDate prodepDateSortie;


    /**
     * date derniere production
     */
    private LocalDate prodepDateProd;


    /**
     * quantite commande fournisseur en cours
     */
    private Float prodepQteCmdAch;


    /**
     * quantite commande client en cours
     */
    private Float prodepQteCmdVte;


    /**
     * quantite en attente en achat
     */
    private Float prodepQteAttAch;


    /**
     * quantite en attente en vente
     */
    private Float prodepQteAttVte;


    /**
     * quantite en stock
     */
    private Float prodepQteStk;


    /**
     * quantite inventoriee
     */
    private Float prodepQteInv;


    /**
     * localisation
     */
    private String prodepLocalisation;


    /**
     * casier de rangement
     */
    private String prodepCasier;


    /**
     * groupage de depot
     */
    private String prodepGroupe;


    /**
     * cle acces code depot code produit
     */
    private String prodepCle;


    /**
     * cle acces code groupe code produit
     */
    private String prodepCle2;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer prodepInactif;

    @NotNull(message = "dpoId can not null")
    private Long dpoId;

    @NotNull(message = "proId can not null")
    private Long proId;

    private Long uniId;

}
