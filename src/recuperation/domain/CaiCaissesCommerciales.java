package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_caisses_commerciales")
public class CaiCaissesCommerciales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cai_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caiId;

    /**
     * date de creation
     */
    @Column(name = "cai_date_creat")
    private LocalDateTime caiDateCreat;

    /**
     * date de modification
     */
    @Column(name = "cai_date_modif")
    private LocalDateTime caiDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "cai_user_creat")
    private Long caiUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "cai_user_modif")
    private Long caiUserModif = 0L;

    /**
     * code caisse
     */
    @Column(name = "cai_code")
    private String caiCode;

    /**
     * nom de la caisse
     */
    @Column(name = "cai_nom")
    private String caiNom;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "cai_inactif")
    private Integer caiInactif = 0;

    /**
     * code du chrono
     */
    @Column(name = "cai_chrono")
    private String caiChrono;

    /**
     * id du caissier
     */
    @Column(name = "cai_caissier_id")
    private Long caiCaissierId = 0L;

    /**
     * nom du caissier
     */
    @Column(name = "cai_caissier_nom")
    private String caiCaissierNom;

    /**
     * date initalisation de la caisse
     */
    @Column(name = "cai_date_init")
    private LocalDate caiDateInit;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init")
    private Double caiMontantInit = 0D;

    /**
     * code journal caisse comptable
     */
    @Column(name = "cai_jr")
    private String caiJr;

    /**
     * nom du journal de caisse
     */
    @Column(name = "cai_nom_jr")
    private String caiNomJr;

    /**
     * compte de virement interne
     */
    @Column(name = "cai_compte_vrt")
    private String caiCompteVrt;

    /**
     * libelle compte de virement interne
     */
    @Column(name = "cai_lib_compte_vrt")
    private String caiLibCompteVrt;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * 0=public 1=prive
     */
    @Column(name = "cai_prive")
    private Integer caiPrive = 0;

    /**
     * code du chrono
     */
    @Column(name = "cai_chrono_recu")
    private String caiChronoRecu;

    /**
     * montant plafond de la caisse
     */
    @Column(name = "cai_montant_plafond")
    private Double caiMontantPlafond = 0D;

    /**
     * compte des effets a encaisser
     */
    @Column(name = "cai_compte_eff")
    private String caiCompteEff;

    /**
     * libelle compte des effets a encaisser
     */
    @Column(name = "cai_lib_compte_eff")
    private String caiLibCompteEff;

    /**
     * code journal espece caisse comptable
     */
    @Column(name = "cai_jr_espece")
    private String caiJrEspece;

    /**
     * nom du journal espece de caisse
     */
    @Column(name = "cai_nom_jr_espece")
    private String caiNomJrEspece;

    /**
     * code journal cheque caisse comptable
     */
    @Column(name = "cai_jr_cheque")
    private String caiJrCheque;

    /**
     * code journal virement caisse comptable
     */
    @Column(name = "cai_jr_virement")
    private String caiJrVirement;

    /**
     * code journal traite caisse comptable
     */
    @Column(name = "cai_jr_traite")
    private String caiJrTraite;

    /**
     * code journal carte bancaire (tpe) caisse comptable
     */
    @Column(name = "cai_jr_tpe")
    private String caiJrTpe;

    /**
     * code journal transfert argent caisse comptable
     */
    @Column(name = "cai_jr_transfert")
    private String caiJrTransfert;

    /**
     * code journal epaiement caisse comptable
     */
    @Column(name = "cai_jr_epaiement")
    private String caiJrEpaiement;

    /**
     * code journal credoc caisse comptable
     */
    @Column(name = "cai_jr_credoc")
    private String caiJrCredoc;

    /**
     * code journal factor caisse comptable
     */
    @Column(name = "cai_jr_factor")
    private String caiJrFactor;

    /**
     * code journal compense caisse comptable
     */
    @Column(name = "cai_jr_compense")
    private String caiJrCompense;

    /**
     * code journal terme caisse comptable
     */
    @Column(name = "cai_jr_terme")
    private String caiJrTerme;

    /**
     * nom du journal cheque de caisse
     */
    @Column(name = "cai_nom_jr_cheque")
    private String caiNomJrCheque;

    /**
     * nom du journal virement de caisse
     */
    @Column(name = "cai_nom_jr_virement")
    private String caiNomJrVirement;

    /**
     * nom du journal traite de caisse
     */
    @Column(name = "cai_nom_jr_traite")
    private String caiNomJrTraite;

    /**
     * nom du journal tpe de caisse
     */
    @Column(name = "cai_nom_jr_tpe")
    private String caiNomJrTpe;

    /**
     * nom du journal transfert de caisse
     */
    @Column(name = "cai_nom_jr_transfert")
    private String caiNomJrTransfert;

    /**
     * nom du journal epaiement de caisse
     */
    @Column(name = "cai_nom_jr_epaiement")
    private String caiNomJrEpaiement;

    /**
     * nom du journal credoc de caisse
     */
    @Column(name = "cai_nom_jr_credoc")
    private String caiNomJrCredoc;

    /**
     * nom du journal factor de caisse
     */
    @Column(name = "cai_nom_jr_factor")
    private String caiNomJrFactor;

    /**
     * nom du journal compense de caisse
     */
    @Column(name = "cai_nom_jr_compense")
    private String caiNomJrCompense;

    /**
     * nom du journal terme de caisse
     */
    @Column(name = "cai_nom_jr_terme")
    private String caiNomJrTerme;

    /**
     * 0=mixte 1=depense 2=recette
     */
    @Column(name = "cai_mode")
    private Integer caiMode = 0;

    /**
     * code banque par defaut
     */
    @Column(name = "cai_code_banque_defaut")
    private String caiCodeBanqueDefaut;

    /**
     * nom de la banque par defaut
     */
    @Column(name = "cai_nom_banque_defaut")
    private String caiNomBanqueDefaut;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_espece")
    private Double caiMontantInitEspece = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_cheque")
    private Double caiMontantInitCheque = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_virement")
    private Double caiMontantInitVirement = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_traite")
    private Double caiMontantInitTraite = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_tpe")
    private Double caiMontantInitTpe = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_epaiement")
    private Double caiMontantInitEpaiement = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_transfert")
    private Double caiMontantInitTransfert = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_credoc")
    private Double caiMontantInitCredoc = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_factor")
    private Double caiMontantInitFactor = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_compense")
    private Double caiMontantInitCompense = 0D;

    /**
     * montant initial de la caisse
     */
    @Column(name = "cai_montant_init_terme")
    private Double caiMontantInitTerme = 0D;

    /**
     * montant fond de caisse
     */
    @Column(name = "cai_montant_fond_caisse")
    private Double caiMontantFondCaisse = 0D;

    /**
     * montant max depenses directe
     */
    @Column(name = "cai_montant_max_depense")
    private Double caiMontantMaxDepense = 0D;

    /**
     * montant fond de caisse maximum
     */
    @Column(name = "cai_montant_fond_caisse_max")
    private Double caiMontantFondCaisseMax = 0D;

    /**
     * operations autorisee
     */
    @Column(name = "cai_operation")
    private String caiOperation;

    /**
     * code journal espece sans timbre caisse comptable
     */
    @Column(name = "cai_jr_espece_st")
    private String caiJrEspeceSt;

    /**
     * nom du journal espece sans timbre de caisse
     */
    @Column(name = "cai_nom_jr_espece_st")
    private String caiNomJrEspeceSt;

    /**
     * 0=interdit 1=autorise
     */
    @Column(name = "cai_mvt_chq_bnq")
    private Integer caiMvtChqBnq = 0;

    /**
     * export espece
     */
    @Column(name = "cai_export_jr_espece")
    private Boolean caiExportJrEspece = Boolean.FALSE;

    /**
     * export cheque
     */
    @Column(name = "cai_export_jr_cheque")
    private Boolean caiExportJrCheque = Boolean.FALSE;

    /**
     * export virement
     */
    @Column(name = "cai_export_jr_virement")
    private Boolean caiExportJrVirement = Boolean.FALSE;

    /**
     * export traite
     */
    @Column(name = "cai_export_jr_traite")
    private Boolean caiExportJrTraite = Boolean.FALSE;

    /**
     * export tpe
     */
    @Column(name = "cai_export_jr_tpe")
    private Boolean caiExportJrTpe = Boolean.FALSE;

    /**
     * export transfert
     */
    @Column(name = "cai_export_jr_trf")
    private Boolean caiExportJrTrf = Boolean.FALSE;

    /**
     * export epeaiement
     */
    @Column(name = "cai_export_jr_epaiement")
    private Boolean caiExportJrEpaiement = Boolean.FALSE;

    /**
     * export credoc
     */
    @Column(name = "cai_export_jr_credoc")
    private Boolean caiExportJrCredoc = Boolean.FALSE;

    /**
     * export virement
     */
    @Column(name = "cai_export_jr_factor")
    private Boolean caiExportJrFactor = Boolean.FALSE;

    /**
     * export compense
     */
    @Column(name = "cai_export_jr_compense")
    private Boolean caiExportJrCompense = Boolean.FALSE;

    /**
     * export terme
     */
    @Column(name = "cai_export_jr_terme")
    private Boolean caiExportJrTerme = Boolean.FALSE;

}
