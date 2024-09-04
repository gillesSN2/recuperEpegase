package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CmmUsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long usrId;


    /**
     * date de creation
     */
    private LocalDateTime usrDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime usrDateModif;


    /**
     * user de creation
     */
    private Long usrUserCreat;


    /**
     * user de modification
     */
    private Long usrUserModif;


    /**
     * 0=interdit 1=autorise
     */
    private Integer usrEtat;


    /**
     * civilite suivant fichier xml
     */
    private String usrCivilite;


    /**
     * nom du compte
     */
    private String usrNom;


    /**
     * prenom du compte
     */
    private String usrPrenom;


    /**
     * nom et prenom
     */
    private String usrPatronyme;


    /**
     * login
     */
    private String usrLogin;


    /**
     * mot de passe
     */
    private String usrPw;


    /**
     * 0=pas de changement du mot de passe 1=changement tous les mois
     */
    private Integer usrChange;


    /**
     * code secret
     */
    private String usrCodeSecret;


    /**
     * 0 hors connexion 1 conecte
     */
    private Integer usrConnexion;


    /**
     * 0=user standard 1=co-administrateur 2=administrateur principal 3=maintenance 4=maintenance special
     */
    private Integer usrSysteme;


    /**
     * date de naissance
     */
    private LocalDate usrDateNaissance;


    /**
     * periode anniversaire JJ MM par rapport aÃ‚Â  la date anniversaire
     */
    private String usrAnniversaire;


    /**
     * langue du user
     */
    private String usrLangue;


    /**
     * template du user
     */
    private String usrTemplates;


    /**
     * themes du user
     */
    private String usrThemes;


    /**
     * code du groupe
     */
    private String usrCollaboration;


    /**
     * fonction du user
     */
    private String usrFonction;


    /**
     * adresse
     */
    private String usrAdresse;


    /**
     * boite postale
     */
    private String usrBp;


    /**
     * ville
     */
    private String usrVille;


    /**
     * nom du pays
     */
    private String usrNomPays;


    /**
     * telephone bureau
     */
    private String usrTelBureau;


    /**
     * telehone domicile
     */
    private String usrTelDomicile;


    /**
     * mobile 1
     */
    private String usrCel1;


    /**
     * mobile 2
     */
    private String usrCel2;


    /**
     * mobile 3
     */
    private String usrCel3;


    /**
     * 0=acces collaboratif 1=acces total
     */
    private Integer usrAccesMail;


    /**
     * mail du compte
     */
    private String usrMail;


    /**
     * compte yahoo
     */
    private String usrYahoo;


    /**
     * compte msn
     */
    private String usrMsn;


    /**
     * compte skype
     */
    private String usrSkype;


    /**
     * compte aol
     */
    private String usrAol;


    /**
     * date derniere connexion
     */
    private LocalDateTime usrLastLog;


    /**
     * date premiere connexion
     */
    private LocalDateTime usrFirstLog;


    /**
     * nombre de connexion
     */
    private Double usrNbLog;


    /**
     * acces photo
     */
    private String usrPhoto;


    /**
     * acces signature
     */
    private String usrSignature;


    /**
     * depot par defaut
     */
    private String usrDepot;


    /**
     * code service
     */
    private String usrService;


    /**
     * code departement
     */
    private String usrDepartement;


    /**
     * code site
     */
    private String usrSite;


    /**
     * page startup
     */
    private String usrStartup;


    /**
     * cout du prix de revient
     */
    private Double usrPr;


    /**
     * prix de vente
     */
    private Double usrPv;


    /**
     * 0 non caissier 1 caissier simple 2 chef caissier
     */
    private Integer usrCaissier;


    /**
     * 0=tous les services 1=service du user
     */
    private Integer usrCaissierService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrRecus;


    /**
     * 0 acces a tous les agents 1 acces uniquement aux agents non proteges
     */
    private Integer usrPaye;


    /**
     * 0=tous les services 1=service du user
     */
    private Integer usrPayeService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrTiers;


    /**
     * 0 acces prive 1 acces total inutilise
     */
    private Integer usrPlanning;


    /**
     * 0=tous les services 1=service du user
     */
    private String usrPlanningService;


    /**
     * 0 copie mail 1 sans copie mail
     */
    private Integer usrMailCopie;


    /**
     * 0 copie mail 1 sans copie mail
     */
    private Integer usrMailParapheur;


    /**
     * 0=tous les services 1=service du user
     */
    private Integer usrAchatsService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrAchats;


    /**
     * 0 responsable libre 1 responsable = user
     */
    private Integer usrRespAchats;


    /**
     * 0=tous les services 1=service du user
     */
    private Integer usrVentesService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrVentes;


    /**
     * 0=sans 1=facturation + caissier
     */
    private Integer usrFactureCaisse;


    /**
     * 0=commercial libre 1=responsable du client 2=user en cours
     */
    private Integer usrCommVentes;


    /**
     * 0=commercial libre 1=responsable du fournisseur 2=user en cours
     */
    private Integer usrCommAchats;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrMf;


    /**
     * 0=tous les services 1=service du user
     */
    private Integer usrmedicalService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer usrMedical;


    /**
     * journaux interdits
     */
    private String usrJrxInterdit;


    /**
     * comptes interdits
     */
    private String usrCptInterdit;


    /**
     * 0=journaux reserves autorises 1=journaux reserves interdits
     */
    private Integer usrJrxReserve;


    /**
     * 0=tous les brouillard 1=mes brouillards
     */
    private Integer usrAccesBrouillard;


    /**
     * 0=sans correction 1=acces correction
     */
    private Integer usrAccesCorrection;


    /**
     * achat DA 0 autorise 1 interdit
     */
    private Integer usrAchTrfDa;


    /**
     * achat cotation 0 autorise 1 interdit
     */
    private Integer usrAchTrfCot;


    /**
     * achat commande 0 autorise 1 interdit
     */
    private Integer usrAchTrfCmd;


    /**
     * achat reception 0 autorise 1 interdit
     */
    private Integer usrAchTrfRec;


    /**
     * achat retour 0 autorise 1 interdit
     */
    private Integer usrAchTrfRet;


    /**
     * achat facture 0 autorise 1 interdit
     */
    private Integer usrAchTrfFac;


    /**
     * achat avoir 0 autorise 1 interdit
     */
    private Integer usrAchTrfAvr;


    /**
     * achat note de debit 0 autorise 1 interdit
     */
    private Integer usrAchTrfNdd;


    /**
     * achat facture de frais 0 autorise 1 interdit
     */
    private Integer usrAchTrfFra;


    /**
     * 0=pump invisible 1=pump non modifiable 2=pump modifiable
     */
    private Integer usrAchPump;


    /**
     * vente besoin 0 autorise 1 interdit
     */
    private Integer usrVteTrfBes;


    /**
     * vente devis 0 autorise 1 interdit
     */
    private Integer usrVteTrfDev;


    /**
     * vente commande 0 autorise 1 interdit
     */
    private Integer usrVteTrfBc;


    /**
     * vente livraison 0 autorise 1 interdit
     */
    private Integer usrVteTrfBl;


    /**
     * vente facture 0 autorise 1 interdit
     */
    private Integer usrVteTrfFac;


    /**
     * vente retour 0 autorise 1 interdit
     */
    private Integer usrVteTrfRet;


    /**
     * vente avoir 0 autorise 1 interdit
     */
    private Integer usrVteTrfAvr;


    /**
     * vente note de debit 0 autorise 1 interdit
     */
    private Integer usrVteTrfNdd;


    /**
     * 0 sans affichage pump 1 pump affiche sur les documents
     */
    private Integer usrAffPump;


    /**
     * 0=sans affichage prix marche et concurent free 1=acces affichage prix marche
     */
    private Integer usrAffPvMarche;


    /**
     * 0 sans affichage prix plancher 1 prix plancher affiche sur les documents
     */
    private Integer usrAffPlancher;


    /**
     * 0 remise et rabais libre 1 remise et rabais verrouille
     */
    private Integer usrVerRemise;


    /**
     * 0 pv libre 1 pv verrouille
     */
    private Integer usrVerPv;


    /**
     * 0 serie libre 1 serie verrouille
     */
    private Integer usrVerSerie;


    /**
     * 0 tous les produits 1 les produits du service du user
     */
    private Integer usrProdService;


    /**
     * 0 remise et rabais libre 1 remise et rabais verrouille
     */
    private Integer usrVerRemiseAch;


    /**
     * 0 pv libre 1 pv verrouille
     */
    private Integer usrVerPaAch;


    /**
     * 0 serie libre 1 serie verrouille
     */
    private Integer usrVerSerieAch;


    /**
     * 0 tous les produits 1 les produits du service du user
     */
    private Integer usrProdServiceAch;


    /**
     * date debut indisponibilite
     */
    private LocalDate usrDateDebutIndisponibilite;


    /**
     * date fin indisponibilite
     */
    private LocalDate usrDateFinIndisponibilite;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateAch;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateStk;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateVte;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateCai;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateMed;


    /**
     * 0=imputation et tiers visible 1=imputation et tiers masque
     */
    private Integer usrImputCai;


    /**
     * 0=montant modifiable 1=montant verrouille
     */
    private Integer usrMontantCai;


    /**
     * 0=liasse non modifiable 1=liasse modifiable
     */
    private Integer usrModifLiasse;

    private Long grpId;


    /**
     * 0=rabais libre 1=rabais invisible
     */
    private Integer usrVerRabais;


    /**
     * 0 rabais libre 1 rabais invisible
     */
    private Integer usrVerRabaisAch;


    /**
     * 0=tiers visible 1=tiers masque
     */
    private Integer usrTiersCai;


    /**
     * 0=mibelle modifiable 1=livelle verrouille
     */
    private Integer usrLibelleCai;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureOffice;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureCompta;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignaturePaye;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureParc;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureAchats;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureVentes;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureCaisse;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureMedical;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureMicrofinance;


    /**
     * 0=pas autorise a signe 1=autorise a signer
     */
    private Integer usrSignatureEducation;


    /**
     * 0=pas autorise a vendre 1=autorise a vendre
     */
    private Integer usrVendeur;


    /**
     * id du responsable du non signataire
     */
    private Long usrResponsablrVentes;


    /**
     * 0=sans depense directe 1=depense directe
     */
    private Integer usrDepense;


    /**
     * 0=sans recette directe 1=recette directe
     */
    private Integer usrRecette;


    /**
     * 0=sans modif 1=modification piece
     */
    private Integer usrModif;


    /**
     * id du responsable
     */
    private Long usrIdResposnable;


    /**
     * nom du responsable
     */
    private String usrNomResposnable;


    /**
     * 0=sans transfert directe 1=transfert directe
     */
    private Integer usrTransfert;


    /**
     * id equipe
     */
    private Long usrIdEquipe;


    /**
     * nom equipe
     */
    private String usrNomEquipe;


    /**
     * 0=sans modif 1=suppression piece
     */
    private Integer usrCaissierDelete;


    /**
     * feuilles de calcule des bulletis interdites
     */
    private String usrFeuilleInterdite;


    /**
     * mot de passe espace client
     */
    private String usrPwEspaceClient;


    /**
     * 0=modification du bulletin 1=interdiction modification bulletin
     */
    private Integer usrPayeBulletin;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDateLivre;


    /**
     * 0=date non modifiable 1=date modifiable
     */
    private Integer usrDatePrc;


    /**
     * % de commission du user
     */
    private Float usrCommPourcentage;


    /**
     * 1=calcul sur le ca du user 2=calcul sur le ca de l equipe 3=calcul sur le ca global
     */
    private Integer usrCommType;


    /**
     * 0= sans lissage 1=lissage autorise
     */
    private Integer usrLissage;


    /**
     * 0= ne peut pas changer de dossier 1=peut changer les dossiers achats
     */
    private Integer usrChgDosAchat;


    /**
     * 0=peut creer societe en cabinet 1=ne peut pas creer de societe en cabinet
     */
    private Integer usrCreationSociete;


    /**
     * 0=sans alerte paye 1=avec alerte paye
     */
    private Integer usrPayeAlerte;


    /**
     * 0=modification du contrat 1=interdiction modification du contrat
     */
    private Integer usrPayeContrat;


    /**
     * 0=pointage prive 1=acces a tous les pointages
     */
    private Integer usrPayPointage;


    /**
     * id du tiers pour acces compte guest
     */
    private Long usrIdTiersGuest;


    /**
     * nom du tiers pour acces compte guest
     */
    private String usrNomTiersGuest;


    /**
     * 0=pas de modification de serie 1=avec modification de serie
     */
    private Integer usrModifSerieVte;


    /**
     * 0=pas de modification de serie 1=avec modification de serie
     */
    private Integer usrModifSerieAch;


    /**
     * 0=pas alerte sur parc 1=avec alerte parc
     */
    private Integer usrParcAlerte;


    /**
     * numero de compte pour trf en compta
     */
    private String usrCompte;

}
