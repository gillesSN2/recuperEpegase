package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchBonDecaissementQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long bonId;


    /**
     * date de creation
     */
    private LocalDateTime bontDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bontDateModif;


    /**
     * utilisateur de creation
     */
    private Long bonUserCreat;


    /**
     * utilisateur de creation
     */
    private Long bonUserModif;


    /**
     * nature du document origine 12=commande 15=facture 16=avoir 17=note debit 18=frais
     */
    private Integer bonNatRef;


    /**
     * numero du document origine
     */
    private String bonRef;


    /**
     * id du document origine
     */
    private Long bonIdRef;


    /**
     * code de la caisse du bon
     */
    private String bonCodeCaisse;


    /**
     * libelle de la caisse du bon
     */
    private String bonLibCaisse;


    /**
     * code banque du bon
     */
    private String bonCodeBanq;


    /**
     * libelle banque du bon
     */
    private String bonLibBanq;


    /**
     * numero du bon
     */
    private String bonNum;


    /**
     * date
     */
    private LocalDateTime bonDate;


    /**
     * nom du responsable
     */
    private String bonNomResponsable;


    /**
     * observation
     */
    private String bonObservation;


    /**
     * nom du tiers
     */
    private String bonNomTiers;


    /**
     * id du tiers
     */
    private Long bonIdTiers;


    /**
     * 0=client 1=fournisseur 2=agent 3=plan comptable 4=patient 5=eleve
     */
    private Integer bonTypeTiers;


    /**
     * serie
     */
    private String bonSerie;


    /**
     * libelle
     */
    private String bonLibelle;


    /**
     * objet
     */
    private String bonObject;


    /**
     * devise
     */
    private String bonDevise;


    /**
     * total ttc
     */
    private Double bonTotTtc;


    /**
     * montant a payer
     */
    private Double bonAPayer;


    /**
     * date echeance reglement
     */
    private LocalDateTime bonDateEcheReg;


    /**
     * date de valeur
     */
    private LocalDateTime bonDateValeur;


    /**
     * tye de reglement type de reglement 0=espece 1=cheque 2=virement 3=traite 4=carte bancaire 5=transfert argent 6=epaiement 7=credoc 8=factor 9=compense
     */
    private Integer bonTypeReg;


    /**
     * activite
     */
    private String bonActivite;


    /**
     * site
     */
    private String bonSite;


    /**
     * departement
     */
    private String bonDepartement;


    /**
     * service
     */
    private String bonService;


    /**
     * region
     */
    private String bonRegion;


    /**
     * secteur
     */
    private String bonSecteur;


    /**
     * Pdv
     */
    private String bonPdv;


    /**
     * budget
     */
    private String bonBudget;


    /**
     * 0=a payer 1=regle
     */
    private Integer bonEtat;


    /**
     * date de relance
     */
    private LocalDateTime bonDateRelance;


    /**
     * 0=actif 1=inactif
     */
    private Integer bonActif;


    /**
     * numero cheque ou bordereau
     */
    private String bonNumChqBdx;

    private Long exeachId;


    /**
     * modele impression recu
     */
    private String bonModeleImp;


    /**
     * code budget
     */
    private String bonCodeBudgetTreso;


    /**
     * code poste
     */
    private String bonCodePosteTreso;

}
