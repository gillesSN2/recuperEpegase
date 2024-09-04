package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_groupe")
public class CmmGroupe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "grp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long grpId;

    /**
     * code du groupe
     */
    @Column(name = "grp_code")
    private String grpCode;

    /**
     * nom du groupe
     */
    @Column(name = "grp_libelle")
    private String grpLibelle;

    /**
     * 0=sans acces module tiers 1=acces module tiers
     */
    @Column(name = "grp_module_tie")
    private Integer grpModuleTie = 0;

    /**
     * 0=sans acces module office 1=acces module office
     */
    @Column(name = "grp_module_off")
    private Integer grpModuleOff = 0;

    /**
     * 0=sans acces module achats 1=acces module achats
     */
    @Column(name = "grp_module_ach")
    private Integer grpModuleAch = 0;

    /**
     * 0=sans acces module stock 1=acces module stock
     */
    @Column(name = "grp_module_stk")
    private Integer grpModuleStk = 0;

    /**
     * 0=sans acces module ventes 1=acces module ventes
     */
    @Column(name = "grp_module_vte")
    private Integer grpModuleVte = 0;

    /**
     * 0=sans acces module compta 1=acces module compta
     */
    @Column(name = "grp_module_cpt")
    private Integer grpModuleCpt = 0;

    /**
     * 0=sans acces module parc 1=acces module parc
     */
    @Column(name = "grp_module_prc")
    private Integer grpModulePrc = 0;

    /**
     * 0=sans acces module caisse 1=acces module caisse
     */
    @Column(name = "grp_module_Cai")
    private Integer grpModuleCai = 0;

    /**
     * 0=sans acces module paye 1=acces module paye
     */
    @Column(name = "grp_module_pay")
    private Integer grpModulePay = 0;

    /**
     * 0=sans acces module medical 1=acces module medical
     */
    @Column(name = "grp_module_med")
    private Integer grpModuleMed = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_module_free")
    private Integer grpModuleFree = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_acces_mail")
    private Integer grpAccesMail = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_acces_copie")
    private Integer grpAccesCopie = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_acces_parapheur")
    private Integer grpAccesParapheur = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_caissier")
    private Integer grpCaissier = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_caissier_service")
    private Integer grpCaissierService = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_service")
    private Integer grpService = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_recus")
    private Integer grpRecus = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_date_cai")
    private Integer grpDateCai = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_imput_cai")
    private Integer grpImputCai = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_montant_cai")
    private Integer grpMontantCai = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_achats_aervice")
    private Integer grpAchatsAervice = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_achats")
    private Integer grpAchats = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_comm_achats")
    private Integer grpCommAchats = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_pump")
    private Integer grpAchPump = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_date_ach")
    private Integer grpDateAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_date_stk")
    private Integer grpDateStk = 0;

    /**
     * depot par defaut
     */
    @Column(name = "grp_depot")
    private String grpDepot;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_remise_ach")
    private Integer grpVerRemiseAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_pa_ach")
    private Integer grpVerPaAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_serie_ach")
    private Integer grpVerSerieAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_prod_service_ach")
    private Integer grpProdServiceAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_da")
    private Integer grpAchTrfDa = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_cot")
    private Integer grpAchTrfCot = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_cmd")
    private Integer grpAchTrfCmd = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_rec")
    private Integer grpAchTrfRec = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_ret")
    private Integer grpAchTrfRet = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_fac")
    private Integer grpAchTrfFac = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_fra")
    private Integer grpAchTrfFra = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_avr")
    private Integer grpAchTrfAvr = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ach_trf_ndd")
    private Integer grpAchTrfNdd = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ventes_service")
    private Integer grpVentesService = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ventes")
    private Integer grpVentes = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_comm_ventes")
    private Integer grpCommVentes = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_facture_caisse")
    private Integer grpFactureCaisse = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_aff_pump")
    private Integer grpAffPump = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_aff_pv_marche")
    private Integer grpAffPvMarche = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_aff_plancher")
    private Integer grpAffPlancher = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_date_vte")
    private Integer grpDateVte = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_remise")
    private Integer grpVerRemise = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_pv")
    private Integer grpVerPv = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_serie")
    private Integer grpVerSerie = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_prod_service")
    private Integer grpProdService = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_bes")
    private Integer grpVteTrfBes = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_dev")
    private Integer grpVteTrfDev = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_bc")
    private Integer grpVteTrfBc = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_bl")
    private Integer grpVteTrfBl = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_ret")
    private Integer grpVteTrfRet = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_fac")
    private Integer grpVteTrfFac = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_avr")
    private Integer grpVteTrfAvr = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_vte_trf_ndd")
    private Integer grpVteTrfNdd = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_medical_service")
    private Integer grpMedicalService = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_medical")
    private Integer grpMedical = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_date_med")
    private Integer grpDateMed = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_paye")
    private Integer grpPaye = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_paye_service")
    private Integer grpPayeService = 0;

    /**
     * 0 acces total 1 acces prive
     */
    @Column(name = "grp_mf")
    private Integer grpMf = 0;

    /**
     * journaux interdits
     */
    @Column(name = "grp_jrx_interdit")
    private String grpJrxInterdit;

    /**
     * 0=journaux reserves autorises 1=journaux reserves interdits
     */
    @Column(name = "grp_jrx_reserve")
    private Integer grpJrxReserve = 0;

    /**
     * 0=tous les brouillard 1=mes brouillards
     */
    @Column(name = "grp_acces_brouillard")
    private Integer grpAccesBrouillard = 0;

    /**
     * 0=sans correction 1=acces correction
     */
    @Column(name = "grp_acces_correction")
    private Integer grpAccesCorrection = 0;

    /**
     * 0=liasse non modifiable 1=liasse modifiable
     */
    @Column(name = "grp_modif_liasse")
    private Integer grpModifLiasse = 0;

    /**
     * 0 acces prive 1 acces total inutilise
     */
    @Column(name = "grp_planning")
    private Integer grpPlanning = 0;

    /**
     * 0 acces prive 1 acces total inutilise
     */
    @Column(name = "grp_planning_service")
    private String grpPlanningService;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_rabais_ach")
    private Integer grpVerRabaisAch = 0;

    /**
     * 0=sans acces module free 1=acces module free
     */
    @Column(name = "grp_ver_rabais")
    private Integer grpVerRabais = 0;

    /**
     * 0=sans acces module education 1=acces module education
     */
    @Column(name = "grp_module_edu")
    private Integer grpModuleEdu = 0;

    /**
     * 0=sans acces module guest 1=acces module guest
     */
    @Column(name = "grp_module_guest")
    private Integer grpModuleGuest = 0;

}
