package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_plan_comptable")
public class CptPlanComptable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plc_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plcId;

    /**
     * date de creation
     */
    @Column(name = "plc_date_creat")
    private LocalDateTime plcDateCreat;

    /**
     * date de modification
     */
    @Column(name = "plc_date_modif")
    private LocalDateTime plcDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "plc_user_creat")
    private Long plcUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "plc_user_modif")
    private Long plcUserModif = 0L;

    /**
     * numero de compte
     */
    @Column(name = "plc_compte")
    private String plcCompte;

    /**
     * numero libre
     */
    @Column(name = "plc_libre")
    private String plcLibre;

    /**
     * libelle du compte en FR
     */
    @Column(name = "plc_libelle_cpte_FR")
    private String plcLibelleCpteFr;

    /**
     * libelle du compte en UK
     */
    @Column(name = "plc_libelle_cpte_UK")
    private String plcLibelleCpteUk;

    /**
     * libelle du compte en SP
     */
    @Column(name = "plc_libelle_cpte_SP")
    private String plcLibelleCpteSp;

    /**
     * code racine
     */
    @Column(name = "plc_code_racine")
    private String plcCodeRacine;

    /**
     * libelle racine en FR
     */
    @Column(name = "plc_libelle_racine_FR")
    private String plcLibelleRacineFr;

    /**
     * libelle racine en UK
     */
    @Column(name = "plc_libelle_racine_UK")
    private String plcLibelleRacineUk;

    /**
     * libelle racine en SP
     */
    @Column(name = "plc_libelle_racine_SP")
    private String plcLibelleRacineSp;

    /**
     * 0=rien 1=capital 2=resultat 3=immobilisation 4=amortissement et provision 5=stock 6=fournisseur 7=client 8=personnel 9=autre tiers 10=banques 11=caisses 12=autrers tresorerie 13=tva 14=brs 15=autres etats 16=charges 17=produits 18=aucune nature
     */
    @Column(name = "plc_nature")
    private Integer plcNature = 0;

    /**
     * 0=ran cumule 1=ran detaille
     */
    @Column(name = "plc_ran_detaille")
    private Boolean plcRanDetaille = Boolean.FALSE;

    /**
     * taux de taxe
     */
    @Column(name = "plc_taux_taxe")
    private Float plcTauxTaxe = 0F;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "plc_inactif")
    private Integer plcInactif = 0;

    /**
     * libelle nature du compte en FR
     */
    @Column(name = "plc_libelle_nature_FR")
    private String plcLibelleNatureFr;

    /**
     * libelle nature du compte en UK
     */
    @Column(name = "plc_libelle_nature_UK")
    private String plcLibelleNatureUk;

    /**
     * libelle nature du compte en SP
     */
    @Column(name = "plc_libelle_nature_SP")
    private String plcLibelleNatureSp;

    /**
     * 0=debit 1=credit
     */
    @Column(name = "plc_sens")
    private Integer plcSens = 0;

    /**
     * prochaine lettre du compte
     */
    @Column(name = "plc_lettre")
    private String plcLettre;

    /**
     * cle analytique 1
     */
    @Column(name = "plc_anal_cle1")
    private String plcAnalCle1;

    /**
     * cle analytique 2
     */
    @Column(name = "plc_anal_cle2")
    private String plcAnalCle2;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
