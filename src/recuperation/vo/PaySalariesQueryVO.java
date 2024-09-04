package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaySalariesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long salId;


    /**
     * date de creation
     */
    private LocalDateTime salDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salDateModif;


    /**
     * utilisateur de creation
     */
    private Long salUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salUserModif;


    /**
     * matricule
     */
    private String salMatricule;


    /**
     * photo
     */
    private String salPhoto;


    /**
     * voir nature salarie xml
     */
    private String salNature;


    /**
     * 0=non protege 1=protege
     */
    private Integer salProtege;


    /**
     * 0=actif 1=licencie 2=demissionne 3=decede 4=retraite 5=fin de contrat 6=arret ou suspension
     */
    private Integer salEtat;


    /**
     * 0=stage 1=cdd 2=cdi 3=prestataire
     */
    private Integer salType;


    /**
     * nom
     */
    private String salNom;


    /**
     * nom de jeune fille
     */
    private String salNomJf;


    /**
     * prenom
     */
    private String salPrenom;


    /**
     * civilite (suivant fichier xml)
     */
    private String salCivilite;


    /**
     * pays
     */
    private String salNomPays;


    /**
     * code de la langue
     */
    private String salLangue;


    /**
     * fonction
     */
    private String salFonction;


    /**
     * imputation service
     */
    private String salSite;


    /**
     * imputation service
     */
    private String salDepartement;


    /**
     * imputation service
     */
    private String salService;


    /**
     * imputation activite
     */
    private String salActicvite;


    /**
     * imputation budget
     */
    private String salBudget;


    /**
     * imputation parc
     */
    private String salParc;


    /**
     * date de naissance
     */
    private LocalDate salDateNaissance;


    /**
     * lieu de naissance
     */
    private String salLieuNaissance;


    /**
     * pays de naissance
     */
    private String salPaysNaissance;


    /**
     * code pays de naissance
     */
    private String salCodeNaissance;


    /**
     * nationnalite
     */
    private String salNationnalite;


    /**
     * ethnie
     */
    private String salEthnie;


    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date d anniversaire
     */
    private String salAnniversaire;


    /**
     * telephone domicile
     */
    private String salTelBur;


    /**
     * telephone domicile
     */
    private String salTelDom;


    /**
     * mobile 1
     */
    private String salCel1;


    /**
     * mobile 2
     */
    private String salCel2;


    /**
     * mobile 3
     */
    private String salCel3;


    /**
     * adresse
     */
    private String salAdresse;


    /**
     * no rue
     */
    private String salRue;


    /**
     * no de lot
     */
    private String salLot;


    /**
     * no ilot
     */
    private String salIlot;


    /**
     * batiment
     */
    private String salBatiment;


    /**
     * no porte
     */
    private String salPorte;


    /**
     * escalier
     */
    private String salEscalier;


    /**
     * ascenseur
     */
    private String salAscensseur;


    /**
     * etage
     */
    private String salEtage;


    /**
     * quantier
     */
    private String salQuartier;


    /**
     * commune
     */
    private String salCommune;


    /**
     * departement
     */
    private String salDeparte;


    /**
     * zone
     */
    private String salZone;


    /**
     * boite postale
     */
    private String salBp;


    /**
     * ville
     */
    private String salVille;


    /**
     * adresse yahoo
     */
    private String salYahoo;


    /**
     * adresse msn
     */
    private String salMsn;


    /**
     * adresse skype
     */
    private String salSkype;


    /**
     * adresse aol
     */
    private String salAol;


    /**
     * mail 1
     */
    private String salMail1;


    /**
     * observation
     */
    private String salObservation;


    /**
     * code banque
     */
    private String salNumBanque;


    /**
     * code guichet
     */
    private String salGuichetBanque;


    /**
     * numero de compte
     */
    private String salCompteBanque;


    /**
     * cle rib
     */
    private String salCleBanque;


    /**
     * code iban
     */
    private String salIban;


    /**
     * code swift
     */
    private String salSwift;


    /**
     * 0=femme 1=homme
     */
    private Integer salGenre;


    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    private Integer salSitFamille;


    /**
     * nombre enfant
     */
    private Integer salNbEnfant;


    /**
     * nombre de parts fiscales
     */
    private Float salNbPartFiscal;


    /**
     * nombre de femme
     */
    private Integer salNbFemme;


    /**
     * nombre de parts trimf
     */
    private Float salNbPartTrimf;


    /**
     * regime de conges : nb jour de conges
     */
    private Float salNbJourCp;


    /**
     * regime de conges : nb jour de travail
     */
    private Float salNbJourTr;


    /**
     * date mariage
     */
    private LocalDate salDateMarie;


    /**
     * date divorce
     */
    private LocalDate salDateDivorce;


    /**
     * date veuf
     */
    private LocalDate salDateVeuf;


    /**
     * date Concubinage
     */
    private LocalDate salDateConcubinage;


    /**
     * date pacs
     */
    private LocalDate salDatePacs;


    /**
     * code convention du salarie
     */
    private String salConvention;


    /**
     * libelle convention du salarie
     */
    private String salLibConvention;


    /**
     * code centres impots xml
     */
    private String salCodCentresImpots;


    /**
     * libelle centres impots xml
     */
    private String salLibCentresImpots;


    /**
     * code classement xml
     */
    private String salClassement;


    /**
     * libelle classement xml
     */
    private String salLibClassement;


    /**
     * code niveau emploi xml
     */
    private String salNivEmploi;


    /**
     * libelle niveau emploi xml
     */
    private String salLibNivEmploi;


    /**
     * code grille convention xml
     */
    private String salGrille;


    /**
     * libelle grille convention xml
     */
    private String salLibGrille;


    /**
     * date entree
     */
    private LocalDate salDateEntree;


    /**
     * date sortie
     */
    private LocalDate salDateSortie;


    /**
     * motif de sortie
     */
    private String salMotifSortie;


    /**
     * date debut impot
     */
    private LocalDate salDateImpot;


    /**
     * numero de feuille de calcul
     */
    private Integer salFeuille;


    /**
     * numero carte identite
     */
    private String salNumCi;


    /**
     * date delivrance carte identite
     */
    private LocalDate salDateCi;


    /**
     * carte identite delivree par
     */
    private String salDelivreCi;


    /**
     * lieu de delivrance
     */
    private String salLieuCi;


    /**
     * numero securite sociale
     */
    private String salNumSecu;


    /**
     * date inscritpion a la securite sociale
     */
    private LocalDate salDateSecu;


    /**
     * numero securite sociale
     */
    private String salNumRetraite;


    /**
     * date inscritpion a la retaite
     */
    private LocalDate salDateRetraite;


    /**
     * approbation inspection
     */
    private String salApprobInsp;


    /**
     * visa enregistrement
     */
    private String salVisaEnreg;


    /**
     * classe de recrutement
     */
    private String salClasseRecrut;


    /**
     * service militaire effectue
     */
    private Boolean salServiceMil;


    /**
     * corps appartenance
     */
    private String salCorpsApp;


    /**
     * grade
     */
    private String salGrade;


    /**
     * date entree dans le pays
     */
    private LocalDate salDateEntreePays;

    private Long exepayId;


    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    private Integer salModeReglement;


    /**
     * nom du pere
     */
    private String salPere;


    /**
     * nom de la mere
     */
    private String salMere;


    /**
     * compte du net
     */
    private String salCompteNet;


    /**
     * compte des acomptes
     */
    private String salCompteAcompte;


    /**
     * compte des avances
     */
    private String salCompteAvance;


    /**
     * cle analytique 1
     */
    private String salCleAnal1;


    /**
     * libelle cle analytique 1
     */
    private String salLibCleAnal1;


    /**
     * cle analytique 2
     */
    private String salCleAnal2;


    /**
     * libelle cle analytique 2
     */
    private String salLibCleAnal2;


    /**
     * profession de formation
     */
    private String salProfession;


    /**
     * imputation activite
     */
    private String salActivite;


    /**
     * numero cnamgs
     */
    private String salNumCnamgs;


    /**
     * date inscritpion a la cnamgs
     */
    private LocalDate salDateCnamgs;


    /**
     * si vrai alors participe mise en relation des celibataires
     */
    private Boolean salMiseRelation;


    /**
     * 0=disponible 1=indisponible
     */
    private Integer salDisponible;


    /**
     * disponible a partir du
     */
    private LocalDate salDispoDu;


    /**
     * disponible jusqu au
     */
    private LocalDate salDispoAu;


    /**
     * 0=mobile 1=mobile sauf 2=entierement mobile
     */
    private Integer salMobile;


    /**
     * exception a la mobilite
     */
    private String salMobileSauf;


    /**
     * domaine de competence 1
     */
    private Boolean salDomAct1;


    /**
     * domaine de competence 2
     */
    private Boolean salDomAct2;


    /**
     * domaine de competence 3
     */
    private Boolean salDomAct3;


    /**
     * domaine de competence 4
     */
    private Boolean salDomAct4;


    /**
     * domaine de competence 5
     */
    private Boolean salDomAct5;


    /**
     * domaine de competence 6
     */
    private Boolean salDomAct6;


    /**
     * domaine de competence 7
     */
    private Boolean salDomAct7;


    /**
     * domaine de competence 8
     */
    private Boolean salDomAct8;


    /**
     * domaine de competence 9
     */
    private Boolean salDomAct9;


    /**
     * domaine de competence 1
     */
    private Boolean salCompetence1;


    /**
     * domaine de competence 2
     */
    private Boolean salCompetence2;


    /**
     * domaine de competence 3
     */
    private Boolean salCompetence3;


    /**
     * domaine de competence 4
     */
    private Boolean salCompetence4;


    /**
     * domaine de competence 5
     */
    private Boolean salCompetence5;


    /**
     * domaine de competence 6
     */
    private Boolean salCompetence6;


    /**
     * domaine de competence 7
     */
    private Boolean salCompetence7;


    /**
     * domaine de competence 8
     */
    private Boolean salCompetence8;


    /**
     * document CV
     */
    private String salDocument;


    /**
     * numero amo
     */
    private String salNumAmo;


    /**
     * date inscritpion a amo
     */
    private LocalDate salDateAmo;


    /**
     * numero allocataire
     */
    private String salNumAllocataire;


    /**
     * date inscritpion a allocataire
     */
    private LocalDate salDateAllocataire;


    /**
     * domaine de competence 9
     */
    private Boolean salCompetence9;


    /**
     * domaine de competence 10
     */
    private Boolean salCompetence10;


    /**
     * domaine de competence 11
     */
    private Boolean salCompetence11;


    /**
     * nombre annee experience
     */
    private Integer salNbAnnee;


    /**
     * lecture francais
     */
    private Integer salFrLire;


    /**
     * ecriture francais
     */
    private Integer salFrEcrire;


    /**
     * dialogue francais
     */
    private Integer salFrParler;


    /**
     * lecture anglais
     */
    private Integer salUsLire;


    /**
     * ecriture anglais
     */
    private Integer salUsEcrire;


    /**
     * dialogue anglais
     */
    private Integer salUsParler;


    /**
     * lecture local
     */
    private Integer salLocLire;


    /**
     * ecriture local
     */
    private Integer salLocEcrire;


    /**
     * dialogue local
     */
    private Integer salLocParler;

}
