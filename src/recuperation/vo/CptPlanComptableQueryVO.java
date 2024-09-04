package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CptPlanComptableQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long plcId;


    /**
     * date de creation
     */
    private LocalDateTime plcDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime plcDateModif;


    /**
     * utilisateur de creation
     */
    private Long plcUserCreat;


    /**
     * utilisateur de modification
     */
    private Long plcUserModif;


    /**
     * numero de compte
     */
    private String plcCompte;


    /**
     * numero libre
     */
    private String plcLibre;


    /**
     * libelle du compte en FR
     */
    private String plcLibelleCpteFr;


    /**
     * libelle du compte en UK
     */
    private String plcLibelleCpteUk;


    /**
     * libelle du compte en SP
     */
    private String plcLibelleCpteSp;


    /**
     * code racine
     */
    private String plcCodeRacine;


    /**
     * libelle racine en FR
     */
    private String plcLibelleRacineFr;


    /**
     * libelle racine en UK
     */
    private String plcLibelleRacineUk;


    /**
     * libelle racine en SP
     */
    private String plcLibelleRacineSp;


    /**
     * 0=rien 1=capital 2=resultat 3=immobilisation 4=amortissement et provision 5=stock 6=fournisseur 7=client 8=personnel 9=autre tiers 10=banques 11=caisses 12=autrers tresorerie 13=tva 14=brs 15=autres etats 16=charges 17=produits 18=aucune nature
     */
    private Integer plcNature;


    /**
     * 0=ran cumule 1=ran detaille
     */
    private Boolean plcRanDetaille;


    /**
     * taux de taxe
     */
    private Float plcTauxTaxe;


    /**
     * 0=actif 1=inactif
     */
    private Integer plcInactif;


    /**
     * libelle nature du compte en FR
     */
    private String plcLibelleNatureFr;


    /**
     * libelle nature du compte en UK
     */
    private String plcLibelleNatureUk;


    /**
     * libelle nature du compte en SP
     */
    private String plcLibelleNatureSp;


    /**
     * 0=debit 1=credit
     */
    private Integer plcSens;


    /**
     * prochaine lettre du compte
     */
    private String plcLettre;


    /**
     * cle analytique 1
     */
    private String plcAnalCle1;


    /**
     * cle analytique 2
     */
    private String plcAnalCle2;

    private Long execptId;

}
