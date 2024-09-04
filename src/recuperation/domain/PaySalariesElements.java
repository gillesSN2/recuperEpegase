package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pay_salaries_elements")
public class PaySalariesElements implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salele_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleleId;

    /**
     * periode MM:AAAA ou JJ:MM:AAAA
     */
    @Column(name = "salele_periode")
    private String salelePeriode;

    /**
     * matricule
     */
    @Column(name = "salele_matricule")
    private String saleleMatricule;

    /**
     * voir nature salarie xml
     */
    @Column(name = "salele_nature")
    private String saleleNature;

    /**
     * 0=actif 1=en conges 2=licencie 3=demissionne 4=decede 5=retraite 6=fin de contrat 7=arret ou suspension
     */
    @Column(name = "salele_etat")
    private Integer saleleEtat = 0;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "salele_civilite")
    private String saleleCivilite;

    /**
     * fonction
     */
    @Column(name = "salele_fonction")
    private String saleleFonction;

    /**
     * imputation service
     */
    @Column(name = "salele_site")
    private String saleleSite;

    /**
     * imputation service
     */
    @Column(name = "salele_departement")
    private String saleleDepartement;

    /**
     * imputation service
     */
    @Column(name = "salele_service")
    private String saleleService;

    /**
     * imputation activite
     */
    @Column(name = "salele_acticvite")
    private String saleleActicvite;

    /**
     * imputation budget
     */
    @Column(name = "salele_budget")
    private String saleleBudget;

    /**
     * imputation parc
     */
    @Column(name = "salele_parc")
    private String saleleParc;

    /**
     * 0=femme 1=homme
     */
    @Column(name = "salele_genre")
    private Integer saleleGenre = 0;

    /**
     * 0=celibataire 1=marie 2=concubin 3=pacse 4=divorce 5=veuf
     */
    @Column(name = "salele_sit_famille")
    private Integer saleleSitFamille = 0;

    /**
     * nombre enfant
     */
    @Column(name = "salele_nb_enfant")
    private Integer saleleNbEnfant = 0;

    /**
     * nombre de parts fiscales
     */
    @Column(name = "salele_nb_part_fiscal")
    private Float saleleNbPartFiscal = 0F;

    /**
     * nombre de femme
     */
    @Column(name = "salele_nb_femme")
    private Integer saleleNbFemme = 0;

    /**
     * nombre de parts trimf
     */
    @Column(name = "salele_nb_part_trimf")
    private Float saleleNbPartTrimf = 0F;

    /**
     * regime de conges : nb jour de conges
     */
    @Column(name = "salele_nb_jour_cp")
    private Float saleleNbJourCp = 0F;

    /**
     * regime de conges : nb jour de travail
     */
    @Column(name = "salele_nb_jour_tr")
    private Float saleleNbJourTr = 0F;

    /**
     * date mariage
     */
    @Column(name = "salele_date_marie")
    private LocalDate saleleDateMarie;

    /**
     * date divorce
     */
    @Column(name = "salele_date_divorce")
    private LocalDate saleleDateDivorce;

    /**
     * date veuf
     */
    @Column(name = "salele_date_veuf")
    private LocalDate saleleDateVeuf;

    /**
     * date Concubinage
     */
    @Column(name = "salele_date_concubinage")
    private LocalDate saleleDateConcubinage;

    /**
     * date pacs
     */
    @Column(name = "salele_date_pacs")
    private LocalDate saleleDatePacs;

    /**
     * date de sortie
     */
    @Column(name = "salele_date_sortie")
    private LocalDate saleleDateSortie;

    /**
     * motif de sortie
     */
    @Column(name = "salele_motif_sortie")
    private String saleleMotifSortie;

    /**
     * code convention du salarie
     */
    @Column(name = "salele_convention")
    private String saleleConvention;

    /**
     * libelle convention du salarie
     */
    @Column(name = "salele_lib_convention")
    private String saleleLibConvention;

    /**
     * code centres impots xml
     */
    @Column(name = "salele_Cod_Centres_Impots")
    private String saleleCodCentresImpots;

    /**
     * libelle centres impots xml
     */
    @Column(name = "salele_Lib_Centres_Impots")
    private String saleleLibCentresImpots;

    /**
     * code classement xml
     */
    @Column(name = "salele_classement")
    private String saleleClassement;

    /**
     * libelle classement xml
     */
    @Column(name = "salele_lib_classement")
    private String saleleLibClassement;

    /**
     * code niveau emploi xml
     */
    @Column(name = "salele_niv_emploi")
    private String saleleNivEmploi;

    /**
     * libelle niveau emploi xml
     */
    @Column(name = "salele_lib_niv_emploi")
    private String saleleLibNivEmploi;

    /**
     * code grille convention xml
     */
    @Column(name = "salele_grille")
    private String saleleGrille;

    /**
     * libelle grille convention xml
     */
    @Column(name = "salele_lib_grille")
    private String saleleLibGrille;

    /**
     * numero de feuille de calcul
     */
    @Column(name = "salele_feuille")
    private String saleleFeuille;

    /**
     * cle de repartition 1
     */
    @Column(name = "salele_cle1_anal")
    private String saleleCle1Anal;

    /**
     * libelle cle de repartition 1
     */
    @Column(name = "salele_lib_cle1_anal")
    private String saleleLibCle1Anal;

    /**
     * cle de repartition 2
     */
    @Column(name = "salele_cle2_anal")
    private String saleleCle2Anal;

    /**
     * libelle cle de repartition 2
     */
    @Column(name = "salele_lib_cle2_anal")
    private String saleleLibCle2Anal;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * 0=espece 1=cheque 2=virement 3=bicitel 4=autre
     */
    @Column(name = "salele_mode_reglement")
    private Integer saleleModeReglement = 0;

    /**
     * code banque
     */
    @Column(name = "salele_num_banque")
    private String saleleNumBanque;

    /**
     * code guichet
     */
    @Column(name = "salele_guichet_banque")
    private String saleleGuichetBanque;

    /**
     * numero de compte
     */
    @Column(name = "salele_compte_banque")
    private String saleleCompteBanque;

    /**
     * cle rib
     */
    @Column(name = "salele_cle_banque")
    private String saleleCleBanque;

    /**
     * code iban
     */
    @Column(name = "salele_iban")
    private String saleleIban;

    /**
     * code swift
     */
    @Column(name = "salele_swift")
    private String saleleSwift;

    /**
     * numero contrat
     */
    @Column(name = "salele_contrat")
    private String saleleContrat;

    /**
     * date entree
     */
    @Column(name = "salele_date_entree")
    private LocalDate saleleDateEntree;

}
