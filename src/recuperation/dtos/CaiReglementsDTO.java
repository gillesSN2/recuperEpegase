package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiReglementsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long rglId;


    /**
     * concatenation rgl_caisse:rgl_periode
     */
    private String rglCle1;


    /**
     * concatenation rgl_caisse:rgl_dateReg
     */
    private String rglCle2;


    /**
     * MM:AAAA par rapport a la date de saisie
     */
    private String rglPeriode;


    /**
     * date de creation
     */
    private LocalDateTime rglDateCreation;


    /**
     * utilisateur de creation
     */
    private Long rglUserCreat;


    /**
     * date de modification
     */
    private LocalDateTime rglDateModif;


    /**
     * user de modification
     */
    private Long rglUserModif;


    /**
     * date du reglement
     */
    private LocalDate rglDateReg;


    /**
     * date de valeur du reglement
     */
    private LocalDate rglDateValeur;


    /**
     * numero du bon origine
     */
    private String rglBon;


    /**
     * id du bon origine
     */
    private Long rglIdBon;


    /**
     * id du document origine
     */
    private Long rglIdDocument;


    /**
     * numero du document origine
     */
    private String rglDocument;


    /**
     * nature du document origine 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer rglNatureDoc;


    /**
     * serie du document
     */
    private String rglSerie;


    /**
     * numero piece du reglement
     */
    private String rglNum;


    /**
     * code de la caisse execution
     */
    private String rglCodeCaisse;


    /**
     * libelle de la caisse execution
     */
    private String rglCaisse;


    /**
     * code caisse emetrice
     */
    private String rglCodeEmetrice;


    /**
     * libelle caisse emetrice
     */
    private String rglLibEmetrice;


    /**
     * code caisse receptrice
     */
    private String rglCodeReceptrice;


    /**
     * libelle caisse receptrice
     */
    private String rglLibReceptrice;


    /**
     * libelle du reglement
     */
    private String rglLibelle;


    /**
     * objet du document
     */
    private String rglObjet;


    /**
     * 10=fournisseurs 20=clients 62=bons de sortie 63=bons entree 64=virement interne
     */
    private Integer rglCategorie;


    /**
     * type du regelement
     */
    private Integer rglTypeReg;


    /**
     * mode du reglement fichier typeReglement.xml
     */
    private String rglMode;


    /**
     * montant de la depense
     */
    private Double rglDepense;


    /**
     * montant de la recette
     */
    private Double rglRecette;


    /**
     * devise utilisee
     */
    private String rglDevise;


    /**
     * format devise utilisee
     */
    private Integer rglFormatDevise;


    /**
     * nom du tiers (fournisseur, client, agent, patient)
     */
    private String rglNomTiers;


    /**
     * id tiers
     */
    private Long rglIdTiers;


    /**
     * type tiers 0=client 1=fournisseur 2=agent 3=plan comptble 4=patient 5=eleve
     */
    private Integer rglTypeTiers;


    /**
     * 0=entree normal 1=depot dans compte tiers
     */
    private Integer rglDepotTiers;


    /**
     * id du caissier
     */
    private Long rglIdCaissier;


    /**
     * nom du caissier
     */
    private String rglNomCaissier;


    /**
     * code du budget
     */
    private String rglBudget;


    /**
     * code activite
     */
    private String rglActivite;


    /**
     * code du site
     */
    private String rglSite;


    /**
     * code du depatement
     */
    private String rglDepartement;


    /**
     * code du service
     */
    private String rglService;


    /**
     * code region
     */
    private String rglRegion;


    /**
     * code secteur
     */
    private String rglSecteur;


    /**
     * code point de vente
     */
    private String rglPdv;


    /**
     * modele impression
     */
    private String rglModele;


    /**
     * date impression
     */
    private LocalDateTime rglDateImp;


    /**
     * 0=transferable 1=non transferable
     */
    private Integer rglTrf;


    /**
     * date de transfert en compta
     */
    private LocalDateTime rglDateTransfert;

    private Long execaiId;


    /**
     * montant du timbre
     */
    private Double rglTimbre;


    /**
     * id tiers
     */
    private Long rglIdContact;


    /**
     * nom du contact ou destinataire
     */
    private String rglNomContact;


    /**
     * code dossier
     */
    private String rglDossier;


    /**
     * code parc
     */
    private String rglParc;


    /**
     * cle 1 de repartition
     */
    private String rglCle1Repartition;


    /**
     * cle 2 de repartition
     */
    private String rglCle2Repartition;


    /**
     * 0=imprimable 1=non imprimable
     */
    private Integer rglImp;


    /**
     * banque du tireur
     */
    private String rglBanqueTireur;


    /**
     * numero cheque ou bordereau
     */
    private String rglNumChqBdx;


    /**
     * date de cloture en compta
     */
    private LocalDateTime rglDateCloture;


    /**
     * code operation
     */
    private String rglOperation;


    /**
     * date mouvement 1 caisse/caisse
     */
    private LocalDate rglDateMvt1;


    /**
     * numero mouvement 1 caisse/caisse
     */
    private String rglNumMvt1;


    /**
     * date mouvement 2 caisse/banque
     */
    private LocalDate rglDateMvt2;


    /**
     * numero mouvement 2 caisse/banque
     */
    private String rglNumMvt2;


    /**
     * nombre billet
     */
    private Integer rglB1;


    /**
     * nombre billet
     */
    private Integer rglB2;


    /**
     * nombre billet
     */
    private Integer rglB3;


    /**
     * nombre billet
     */
    private Integer rglB4;


    /**
     * nombre billet
     */
    private Integer rglB5;


    /**
     * nombre billet
     */
    private Integer rglB6;


    /**
     * nombre billet
     */
    private Integer rglB7;


    /**
     * nombre billet
     */
    private Integer rglB8;


    /**
     * nombre billet
     */
    private Integer rglB9;


    /**
     * nombre billet
     */
    private Integer rglB10;


    /**
     * nombre billet
     */
    private Integer rglP1;


    /**
     * nombre billet
     */
    private Integer rglP2;


    /**
     * nombre billet
     */
    private Integer rglP3;


    /**
     * nombre billet
     */
    private Integer rglP4;


    /**
     * nombre billet
     */
    private Integer rglP5;


    /**
     * nombre billet
     */
    private Integer rglP6;


    /**
     * nombre billet
     */
    private Integer rglP7;


    /**
     * nombre billet
     */
    private Integer rglP8;


    /**
     * nombre billet
     */
    private Integer rglP9;


    /**
     * nombre billet
     */
    private Integer rglP10;


    /**
     * code caisse de transfert caisse/caisse
     */
    private String rglCaisseMvt1;


    /**
     * code banque de transfert caisse/banque
     */
    private String rglBanqueMvt2;


    /**
     * numero de transfert
     */
    private String rglNumTrf;


    /**
     * date execution bon caisse
     */
    private LocalDate rglDateExecBc;


    /**
     * montant des frais
     */
    private Double rglFrais;


    /**
     * code budget
     */
    private String rglCodeBudgetTreso;


    /**
     * code poste
     */
    private String rglCodePosteTreso;


    /**
     * montant rendu
     */
    private Double rglRendu;


    /**
     * id du responsable origine
     */
    private Long rglIdResponsable;


    /**
     * nom du responsable origine
     */
    private String rglNomResponsable;


    /**
     * id du commercial origine
     */
    private Long rglIdCommercial;


    /**
     * nom du commercial origine
     */
    private String rglNomCommercial;


    /**
     * id equipe origine
     */
    private Long rglIdEquipe;


    /**
     * nom equipe origine
     */
    private String rglNomEquipe;


    /**
     * montant de la commission
     */
    private Double rglCommission;


    /**
     * concatenation rgl_code_receptrice:rgl_periode caisse destination
     */
    private String rglCle3;


    /**
     * concatenation rgl_code_receptrice:rgl_dateReg caisse destination
     */
    private String rglCle4;


    /**
     * date encaissement
     */
    private LocalDate rglDateEncaissement;


    /**
     * date rejet
     */
    private LocalDate rglDateRejet;

}
