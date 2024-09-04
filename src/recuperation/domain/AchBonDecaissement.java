package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_bon_decaissement")
public class AchBonDecaissement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bon_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bonId;

    /**
     * date de creation
     */
    @Column(name = "bont_date_creat")
    private LocalDateTime bontDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bont_date_modif")
    private LocalDateTime bontDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bon_user_creat")
    private Long bonUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "bon_user_modif")
    private Long bonUserModif = 0L;

    /**
     * nature du document origine 12=commande 15=facture 16=avoir 17=note debit 18=frais
     */
    @Column(name = "bon_nat_ref")
    private Integer bonNatRef = 0;

    /**
     * numero du document origine
     */
    @Column(name = "bon_ref")
    private String bonRef;

    /**
     * id du document origine
     */
    @Column(name = "bon_id_ref")
    private Long bonIdRef = 0L;

    /**
     * code de la caisse du bon
     */
    @Column(name = "bon_code_caisse")
    private String bonCodeCaisse;

    /**
     * libelle de la caisse du bon
     */
    @Column(name = "bon_lib_caisse")
    private String bonLibCaisse;

    /**
     * code banque du bon
     */
    @Column(name = "bon_code_banq")
    private String bonCodeBanq;

    /**
     * libelle banque du bon
     */
    @Column(name = "bon_lib_banq")
    private String bonLibBanq;

    /**
     * numero du bon
     */
    @Column(name = "bon_num")
    private String bonNum;

    /**
     * date
     */
    @Column(name = "bon_date")
    private LocalDateTime bonDate;

    /**
     * nom du responsable
     */
    @Column(name = "bon_nom_responsable")
    private String bonNomResponsable;

    /**
     * observation
     */
    @Column(name = "bon_observation")
    private String bonObservation;

    /**
     * nom du tiers
     */
    @Column(name = "bon_nom_tiers")
    private String bonNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "bon_id_tiers")
    private Long bonIdTiers = 0L;

    /**
     * 0=client 1=fournisseur 2=agent 3=plan comptable 4=patient 5=eleve
     */
    @Column(name = "bon_type_tiers")
    private Integer bonTypeTiers = 0;

    /**
     * serie
     */
    @Column(name = "bon_serie")
    private String bonSerie;

    /**
     * libelle
     */
    @Column(name = "bon_libelle")
    private String bonLibelle;

    /**
     * objet
     */
    @Column(name = "bon_object")
    private String bonObject;

    /**
     * devise
     */
    @Column(name = "bon_devise")
    private String bonDevise;

    /**
     * total ttc
     */
    @Column(name = "bon_tot_ttc")
    private Double bonTotTtc = 0D;

    /**
     * montant a payer
     */
    @Column(name = "bon_a_payer")
    private Double bonAPayer = 0D;

    /**
     * date echeance reglement
     */
    @Column(name = "bon_date_eche_Reg")
    private LocalDateTime bonDateEcheReg;

    /**
     * date de valeur
     */
    @Column(name = "bon_date_valeur")
    private LocalDateTime bonDateValeur;

    /**
     * tye de reglement type de reglement 0=espece 1=cheque 2=virement 3=traite 4=carte bancaire 5=transfert argent 6=epaiement 7=credoc 8=factor 9=compense
     */
    @Column(name = "bonTypeReg")
    private Integer bonTypeReg = 0;

    /**
     * activite
     */
    @Column(name = "bon_activite")
    private String bonActivite;

    /**
     * site
     */
    @Column(name = "bon_site")
    private String bonSite;

    /**
     * departement
     */
    @Column(name = "bon_departement")
    private String bonDepartement;

    /**
     * service
     */
    @Column(name = "bon_service")
    private String bonService;

    /**
     * region
     */
    @Column(name = "bon_region")
    private String bonRegion;

    /**
     * secteur
     */
    @Column(name = "bon_secteur")
    private String bonSecteur;

    /**
     * Pdv
     */
    @Column(name = "bon_pdv")
    private String bonPdv;

    /**
     * budget
     */
    @Column(name = "bon_budget")
    private String bonBudget;

    /**
     * 0=a payer 1=regle
     */
    @Column(name = "bonEtat")
    private Integer bonEtat = 0;

    /**
     * date de relance
     */
    @Column(name = "bon_date_relance")
    private LocalDateTime bonDateRelance;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "bon_actif")
    private Integer bonActif = 0;

    /**
     * numero cheque ou bordereau
     */
    @Column(name = "bon_num_chq_bdx")
    private String bonNumChqBdx;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    /**
     * modele impression recu
     */
    @Column(name = "bon_modele_imp")
    private String bonModeleImp;

    /**
     * code budget
     */
    @Column(name = "bon_code_budget_treso")
    private String bonCodeBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "bon_code_poste_treso")
    private String bonCodePosteTreso;

}
