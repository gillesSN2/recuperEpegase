package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedPatientsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long patId;


    /**
     * date de creation
     */
    private LocalDateTime patDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime patDateModif;


    /**
     * user de creation
     */
    private Long patUserCreat;


    /**
     * user de modification
     */
    private Long patUserModif;


    /**
     * 0=actif 1=inactif 2=supprime
     */
    private Integer patEtat;


    /**
     * pourcentage du cas social
     */
    private Float patPourcentCasSocial;


    /**
     * numero de contrat
     */
    private String patNumContrat;


    /**
     * numero dossier
     */
    private String patDossier;


    /**
     * nom du patient
     */
    private String patNom;


    /**
     * prenom
     */
    private String patPrenom;


    /**
     * nom de jeune fille
     */
    private String patNomJf;


    /**
     * surnom
     */
    private String patSurnom;


    /**
     * prise en charge du patient lie au fichier xml (1= assure 2= non assure 3=cas social)
     */
    private String patPec;


    /**
     * societe prise en charge
     */
    private String patSociete;


    /**
     * id societe prise en charge
     */
    private Long patIdSociete;


    /**
     * assurance prise en charge
     */
    private String patAssurance;


    /**
     * id assurance prise en charge
     */
    private Long patIdAssurance;


    /**
     * complementaire prise en charge
     */
    private String patComplementaire;


    /**
     * id complementaire prise en charge
     */
    private Long patIdComplementaire;


    /**
     * numero de cate d identite
     */
    private String patCi;


    /**
     * numero de securite sociale
     */
    private String patSecu;


    /**
     * couvert par
     */
    private String patCouvert;


    /**
     * civilite
     */
    private String patCivilite;


    /**
     * langue parlee
     */
    private String patLangueParle;


    /**
     * telephone domicile
     */
    private String patTelDom;


    /**
     * cellulaire 1
     */
    private String patCel1;


    /**
     * cellulaire 2
     */
    private String patCel2;


    /**
     * cellulaire 3
     */
    private String patCel3;


    /**
     * telephone voiture
     */
    private String patTelVoiture;


    /**
     * 0=femme 1=homme
     */
    private Integer patSexe;


    /**
     * date de naissance
     */
    private LocalDate patDateNaissance;


    /**
     * lieu de naissance
     */
    private String patLieuNaissance;


    /**
     * pays de naissance
     */
    private String patPaysNaissance;


    /**
     * observations
     */
    private String patObservations;


    /**
     * adresse actuelle
     */
    private String patAdresse;


    /**
     * numero rue
     */
    private String patRue;


    /**
     * numero lot
     */
    private String patLot;


    /**
     * numero illot
     */
    private String patIlot;


    /**
     * numero batiment
     */
    private String patBatiment;


    /**
     * numero porte
     */
    private String patPorte;


    /**
     * numero etage
     */
    private String patEtage;


    /**
     * ascenseur
     */
    private String patAscensseur;


    /**
     * quartier
     */
    private String patQuartier;


    /**
     * commune
     */
    private String patCommune;


    /**
     * departement
     */
    private String patDepart;


    /**
     * zone
     */
    private String patZone;


    /**
     * boite poste
     */
    private String patBp;


    /**
     * cedex
     */
    private String patCedex;


    /**
     * ville
     */
    private String patVille;


    /**
     * pays
     */
    private String patPays;


    /**
     * telephne bureau
     */
    private String patBurTel1;


    /**
     * telephne bureau
     */
    private String patBurTel2;


    /**
     * fax
     */
    private String patBurFax;


    /**
     * adresse yahoo
     */
    private String patYahoo;


    /**
     * adresse msn
     */
    private String patMsn;


    /**
     * adresse skype
     */
    private String patSkype;


    /**
     * mail 1
     */
    private String patMail1;


    /**
     * famille patient
     */
    private String patNomFamille;


    /**
     * serie
     */
    private String patSerie;


    /**
     * nom banque
     */
    private String patNomBanque;


    /**
     * adresse banque
     */
    private String patAdresseBanque;


    /**
     * numero banque
     */
    private String patNumBanque;


    /**
     * numero guichet
     */
    private String patGuichetBanque;


    /**
     * numero compte
     */
    private String patCompteBanque;


    /**
     * rib
     */
    private String patCleBanque;


    /**
     * iban
     */
    private String patIban;


    /**
     * swift
     */
    private String patSwift;


    /**
     * compte comptable
     */
    private String patCompte;


    /**
     * date prelevement 1
     */
    private LocalDate patDatePrelev1;


    /**
     * groupe
     */
    private String patGroupe1;


    /**
     * rhesus
     */
    private String patRhesus1;


    /**
     * d
     */
    private Integer patD1;


    /**
     * c
     */
    private Integer patC1;


    /**
     * cc
     */
    private Integer patCc1;


    /**
     * e
     */
    private Integer patE1;


    /**
     * ee
     */
    private Integer patEe1;


    /**
     * cde
     */
    private Integer patCde1;


    /**
     * k
     */
    private Integer patK1;


    /**
     * date prelevement
     */
    private LocalDate patDatePrelev2;


    /**
     * groupe 2
     */
    private String patGroupe2;


    /**
     * rhesus
     */
    private String patRhesus2;


    /**
     * d
     */
    private Integer patD2;


    /**
     * c
     */
    private Integer patC2;


    /**
     * cc
     */
    private Integer patCc2;


    /**
     * e
     */
    private Integer patE2;


    /**
     * ee
     */
    private Integer patEe2;


    /**
     * cde
     */
    private Integer patCde2;


    /**
     * k
     */
    private Integer patK2;


    /**
     * situation de famille
     */
    private Integer patSitFam;


    /**
     * habitat
     */
    private Integer patHabitat;


    /**
     * nombre enfants
     */
    private Integer patNbEnfant;


    /**
     * secteur activite
     */
    private String patSecteurActivite;


    /**
     * profession
     */
    private String patProfession;


    /**
     * observation sur la profession
     */
    private String patProfObs;


    /**
     * nom du pere
     */
    private String patNomPere;


    /**
     * nom de la mere
     */
    private String patNomMere;


    /**
     * mode de reglement
     */
    private String patModeReg;


    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    private Integer patTypeReg;


    /**
     * nombre de jours d echeance
     */
    private Integer patNbEcheance;


    /**
     * nombre de jours d arrondi
     */
    private Integer patNbArrondi;


    /**
     * conditions de reglements
     */
    private String patConditionReg;


    /**
     * acces photo ou logo
     */
    private String patPhoto;

}
