package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class AchDepotVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "dpoId can not null")
    private Long dpoId;


    /**
     * date de creation
     */
    private LocalDateTime dpoDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime dpoDateModif;


    /**
     * user de creation
     */
    private Long dpoUserCreation;


    /**
     * user de modification
     */
    private Long dpoUserModif;


    /**
     * code du depot
     */
    private String dpoCode;


    /**
     * libelle du depot
     */
    private String dpoLibelle;


    /**
     * 0=standard fixe 1=standard mobile 2=fictif
     */
    private Integer dpoType;


    /**
     * quantite minimale
     */
    private Float dpoQteMin;


    /**
     * quantite maximale
     */
    private Float dpoQteMax;


    /**
     * 1=defaut en entree
     */
    private Integer dpoDefautIn;


    /**
     * 1=defaut en sortie
     */
    private Integer dpoDefautOut;


    /**
     * 0=actif 1=inactif
     */
    private Integer dpoInactif;


    /**
     * 0=sans reception 1=avec reception
     */
    private Integer dpoReception;


    /**
     * 0=sans retout achat 1=avec retour achat
     */
    private Integer dpoRetourAch;


    /**
     * 0=sans bon livraison 1=avec bon livraison
     */
    private Integer dpoLivraison;


    /**
     * 0=sans retour 1=avec retour
     */
    private Integer dpoRetourVent;


    /**
     * 0=sans reacheminement 1=avec reacheminement
     */
    private Integer dpoReachmin;


    /**
     * 0=sans production 1=avec production
     */
    private Integer dpoFabrication;


    /**
     * 0=sans cession 1=avec cession
     */
    private Integer dpoCession;


    /**
     * 0=sans bon de sortie 1=avec bon de sortie
     */
    private Integer dpoBonSortie;


    /**
     * 0=sans bon entree 1=avec bon entree
     */
    private Integer dpoBonEntree;


    /**
     * 0=sans inventaire 1=avec inventaire
     */
    private Integer dpoInventaire;


    /**
     * 0=sans depot mobile 1=avec depot mobile
     */
    private Integer dpoMobileVent;


    /**
     * 0=sans collecte 1=avec collecte
     */
    private Integer dpoCollecteAch;


    /**
     * 0=sans pharmacie 1=avec pharmacie
     */
    private Integer dpoPharmacie;


    /**
     * 0=sans carburant 1=avec carburant
     */
    private Integer dpoCarburant;

}
