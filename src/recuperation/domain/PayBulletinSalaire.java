package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pay_bulletin_salaire")
public class PayBulletinSalaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bulsal_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulsalId;

    /**
     * numero feuille
     */
    @Column(name = "bulsal_feuille")
    private String bulsalFeuille;

    /**
     * numero contrat
     */
    @Column(name = "bulsal_contrat")
    private String bulsalContrat;

    /**
     * periode MMAAAA
     */
    @Column(name = "bulsal_periode")
    private String bulsalPeriode;

    /**
     * date debut
     */
    @Column(name = "bulsal_date_debut")
    private LocalDate bulsalDateDebut;

    /**
     * date fin
     */
    @Column(name = "bulsal_date_fin")
    private LocalDate bulsalDateFin;

    /**
     * matricule
     */
    @Column(name = "bulsal_matricule")
    private String bulsalMatricule;

    /**
     * voir nature salarie xml
     */
    @Column(name = "bulsal_nature")
    private String bulsalNature;

    /**
     * 0=actif 1=en conges 2=licencie 3=demissionne 4=decede 5=retraite 6=fin de contrat 7=arret ou suspension
     */
    @Column(name = "bulsal_etat")
    private Integer bulsalEtat = 0;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "bulsal_civilite")
    private String bulsalCivilite;

    /**
     * fonction
     */
    @Column(name = "bulsal_fonction")
    private String bulsalFonction;

    /**
     * imputation service
     */
    @Column(name = "bulsal_site")
    private String bulsalSite;

    /**
     * imputation service
     */
    @Column(name = "bulsal_departement")
    private String bulsalDepartement;

    /**
     * imputation service
     */
    @Column(name = "bulsal_service")
    private String bulsalService;

    /**
     * imputation activite
     */
    @Column(name = "bulsal_acticvite")
    private String bulsalActicvite;

    /**
     * imputation budget
     */
    @Column(name = "bulsal_budget")
    private String bulsalBudget;

    /**
     * imputation parc
     */
    @Column(name = "bulsal_parc")
    private String bulsalParc;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "bulsal_genre")
    private Integer bulsalGenre = 0;

    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    @Column(name = "bulsal_sit_famille")
    private Integer bulsalSitFamille = 0;

    /**
     * nombre enfant
     */
    @Column(name = "bulsal_nb_enfant")
    private Integer bulsalNbEnfant = 0;

    /**
     * nombre de parts fiscales
     */
    @Column(name = "bulsal_nb_part_fiscal")
    private Float bulsalNbPartFiscal = 0F;

    /**
     * nombre de femme
     */
    @Column(name = "bulsal_nb_femme")
    private Integer bulsalNbFemme = 0;

    /**
     * nombre de parts trimf
     */
    @Column(name = "bulsal_nb_part_trimf")
    private Float bulsalNbPartTrimf = 0F;

    /**
     * regime de conges : nb jour de conges
     */
    @Column(name = "bulsal_nb_jour_cp")
    private Float bulsalNbJourCp = 0F;

    /**
     * regime de conges : nb jour de travail
     */
    @Column(name = "bulsal_nb_jour_tr")
    private Float bulsalNbJourTr = 0F;

    /**
     * date de sortie
     */
    @Column(name = "bulsal_date_sortie")
    private LocalDate bulsalDateSortie;

    /**
     * motif de sortie
     */
    @Column(name = "bulsal_motif_sortie")
    private String bulsalMotifSortie;

    /**
     * code convention du salarie
     */
    @Column(name = "bulsal_convention")
    private String bulsalConvention;

    /**
     * libelle convention du salarie
     */
    @Column(name = "bulsal_lib_convention")
    private String bulsalLibConvention;

    /**
     * code centres impots xml
     */
    @Column(name = "bulsal_Cod_Centres_Impots")
    private String bulsalCodCentresImpots;

    /**
     * libelle centres impots xml
     */
    @Column(name = "bulsal_Lib_Centres_Impots")
    private String bulsalLibCentresImpots;

    /**
     * code classement xml
     */
    @Column(name = "bulsal_classement")
    private String bulsalClassement;

    /**
     * libelle classement xml
     */
    @Column(name = "bulsal_lib_classement")
    private String bulsalLibClassement;

    /**
     * code niveau emploi xml
     */
    @Column(name = "bulsal_niv_emploi")
    private String bulsalNivEmploi;

    /**
     * libelle niveau emploi xml
     */
    @Column(name = "bulsal_lib_niv_emploi")
    private String bulsalLibNivEmploi;

    /**
     * code grille convention xml
     */
    @Column(name = "bulsal_grille")
    private String bulsalGrille;

    /**
     * libelle grille convention xml
     */
    @Column(name = "bulsal_lib_grille")
    private String bulsalLibGrille;

    /**
     * avantage en nature
     */
    @Column(name = "bulsal_av_nat")
    private Double bulsalAvNat = 0D;

    /**
     * salaire brut
     */
    @Column(name = "bulsal_brut")
    private Double bulsalBrut = 0D;

    /**
     * conges payes
     */
    @Column(name = "bulsal_cp")
    private Double bulsalCp = 0D;

    /**
     * nombre de jours e conges pris
     */
    @Column(name = "bulsal_nb_cp_pris")
    private Float bulsalNbCpPris = 0F;

    /**
     * nombre de jours e conges pris
     */
    @Column(name = "bulsal_nb_cp_acquis")
    private Float bulsalNbCpAcquis = 0F;

    /**
     * base imposable fiscale
     */
    @Column(name = "bulsal_base_imposable_fiscale")
    private Double bulsalBaseImposableFiscale = 0D;

    /**
     * base imposable sociale
     */
    @Column(name = "bulsal_base_imposable_sociale")
    private Double bulsalBaseImposableSociale = 0D;

    /**
     * salaire net à payer
     */
    @Column(name = "bulsal_net_payer")
    private Double bulsalNetPayer = 0D;

    /**
     * cumul impot 1
     */
    @Column(name = "bulsal_impot1")
    private Double bulsalImpot1 = 0D;

    /**
     * cumul impot 2
     */
    @Column(name = "bulsal_impot2")
    private Double bulsalImpot2 = 0D;

    /**
     * cumul impot 3
     */
    @Column(name = "bulsal_impot3")
    private Double bulsalImpot3 = 0D;

    /**
     * cumul impot 4
     */
    @Column(name = "bulsal_impot4")
    private Double bulsalImpot4 = 0D;

    /**
     * cumul impot 5
     */
    @Column(name = "bulsal_impot5")
    private Double bulsalImpot5 = 0D;

    /**
     * cumul impot 6
     */
    @Column(name = "bulsal_impot6")
    private Double bulsalImpot6 = 0D;

    /**
     * cumul impot 7
     */
    @Column(name = "bulsal_impot7")
    private Double bulsalImpot7 = 0D;

    /**
     * cumul impot 8
     */
    @Column(name = "bulsal_impot8")
    private Double bulsalImpot8 = 0D;

    /**
     * cumul impot 9
     */
    @Column(name = "bulsal_impot9")
    private Double bulsalImpot9 = 0D;

    /**
     * cumul impot 10
     */
    @Column(name = "bulsal_impot10")
    private Double bulsalImpot10 = 0D;

    /**
     * date de transfert en compta
     */
    @Column(name = "bulsal_date_transfert")
    private LocalDate bulsalDateTransfert;

    /**
     * cle de repartition 1
     */
    @Column(name = "bulsal_cle1_anal")
    private String bulsalCle1Anal;

    /**
     * cle de repartition 2
     */
    @Column(name = "bulsal_cle2_anal")
    private String bulsalCle2Anal;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

    /**
     * nombre de jours de conges feries
     */
    @Column(name = "bulsal_nb_cp_feries")
    private Float bulsalNbCpFeries = 0F;

    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    @Column(name = "bulsal_mode_reglement")
    private Integer bulsalModeReglement = 0;

    /**
     * code banque
     */
    @Column(name = "bulsal_num_banque")
    private String bulsalNumBanque;

    /**
     * code guichet
     */
    @Column(name = "bulsal_guichet_banque")
    private String bulsalGuichetBanque;

    /**
     * numero de compte
     */
    @Column(name = "bulsal_compte_banque")
    private String bulsalCompteBanque;

    /**
     * cle rib
     */
    @Column(name = "bulsal_cle_banque")
    private String bulsalCleBanque;

    /**
     * code iban
     */
    @Column(name = "bulsal_iban")
    private String bulsalIban;

    /**
     * code swift
     */
    @Column(name = "bulsal_swift")
    private String bulsalSwift;

    /**
     * 0=automatique 1=manuel
     */
    @Column(name = "bulsal_manuel")
    private Integer bulsalManuel = 0;

    /**
     * id tiers impute interim
     */
    @Column(name = "bulsal_id_tiers")
    private Long bulsalIdTiers = 0L;

    /**
     * code projet
     */
    @Column(name = "bulsal_projet")
    private String bulsalProjet;

    /**
     * date entree
     */
    @Column(name = "bulsal_date_entree")
    private LocalDate bulsalDateEntree;

    /**
     * type conges payes 0 ou 1=normal 2=bulletin de cp 3=cp travailles 4=cp immediat 5=cp maternite
     */
    @Column(name = "bulsal_type_cp")
    private Integer bulsalTypeCp = 0;

    /**
     * nombre de jours disponible
     */
    @Column(name = "bulsal_nb_dispo")
    private Float bulsalNbDispo = 0F;

}
