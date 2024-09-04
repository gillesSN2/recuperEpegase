package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class CaiCaissesCommercialesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "caiId can not null")
    private Long caiId;


    /**
     * date de creation
     */
    private LocalDateTime caiDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime caiDateModif;


    /**
     * utilisateur de creation
     */
    private Long caiUserCreat;


    /**
     * utilisateur de modification
     */
    private Long caiUserModif;


    /**
     * code caisse
     */
    private String caiCode;


    /**
     * nom de la caisse
     */
    private String caiNom;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer caiInactif;


    /**
     * code du chrono
     */
    private String caiChrono;


    /**
     * id du caissier
     */
    private Long caiCaissierId;


    /**
     * nom du caissier
     */
    private String caiCaissierNom;


    /**
     * date initalisation de la caisse
     */
    private LocalDate caiDateInit;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInit;


    /**
     * code journal caisse comptable
     */
    private String caiJr;


    /**
     * nom du journal de caisse
     */
    private String caiNomJr;


    /**
     * compte de virement interne
     */
    private String caiCompteVrt;


    /**
     * libelle compte de virement interne
     */
    private String caiLibCompteVrt;

    @NotNull(message = "execaiId can not null")
    private Long execaiId;


    /**
     * 0=public 1=prive
     */
    private Integer caiPrive;


    /**
     * code du chrono
     */
    private String caiChronoRecu;


    /**
     * montant plafond de la caisse
     */
    private Double caiMontantPlafond;


    /**
     * compte des effets a encaisser
     */
    private String caiCompteEff;


    /**
     * libelle compte des effets a encaisser
     */
    private String caiLibCompteEff;


    /**
     * code journal espece caisse comptable
     */
    private String caiJrEspece;


    /**
     * nom du journal espece de caisse
     */
    private String caiNomJrEspece;


    /**
     * code journal cheque caisse comptable
     */
    private String caiJrCheque;


    /**
     * code journal virement caisse comptable
     */
    private String caiJrVirement;


    /**
     * code journal traite caisse comptable
     */
    private String caiJrTraite;


    /**
     * code journal carte bancaire (tpe) caisse comptable
     */
    private String caiJrTpe;


    /**
     * code journal transfert argent caisse comptable
     */
    private String caiJrTransfert;


    /**
     * code journal epaiement caisse comptable
     */
    private String caiJrEpaiement;


    /**
     * code journal credoc caisse comptable
     */
    private String caiJrCredoc;


    /**
     * code journal factor caisse comptable
     */
    private String caiJrFactor;


    /**
     * code journal compense caisse comptable
     */
    private String caiJrCompense;


    /**
     * code journal terme caisse comptable
     */
    private String caiJrTerme;


    /**
     * nom du journal cheque de caisse
     */
    private String caiNomJrCheque;


    /**
     * nom du journal virement de caisse
     */
    private String caiNomJrVirement;


    /**
     * nom du journal traite de caisse
     */
    private String caiNomJrTraite;


    /**
     * nom du journal tpe de caisse
     */
    private String caiNomJrTpe;


    /**
     * nom du journal transfert de caisse
     */
    private String caiNomJrTransfert;


    /**
     * nom du journal epaiement de caisse
     */
    private String caiNomJrEpaiement;


    /**
     * nom du journal credoc de caisse
     */
    private String caiNomJrCredoc;


    /**
     * nom du journal factor de caisse
     */
    private String caiNomJrFactor;


    /**
     * nom du journal compense de caisse
     */
    private String caiNomJrCompense;


    /**
     * nom du journal terme de caisse
     */
    private String caiNomJrTerme;


    /**
     * 0=mixte 1=depense 2=recette
     */
    private Integer caiMode;


    /**
     * code banque par defaut
     */
    private String caiCodeBanqueDefaut;


    /**
     * nom de la banque par defaut
     */
    private String caiNomBanqueDefaut;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitEspece;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitCheque;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitVirement;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitTraite;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitTpe;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitEpaiement;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitTransfert;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitCredoc;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitFactor;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitCompense;


    /**
     * montant initial de la caisse
     */
    private Double caiMontantInitTerme;


    /**
     * montant fond de caisse
     */
    private Double caiMontantFondCaisse;


    /**
     * montant max depenses directe
     */
    private Double caiMontantMaxDepense;


    /**
     * montant fond de caisse maximum
     */
    private Double caiMontantFondCaisseMax;


    /**
     * operations autorisee
     */
    private String caiOperation;


    /**
     * code journal espece sans timbre caisse comptable
     */
    private String caiJrEspeceSt;


    /**
     * nom du journal espece sans timbre de caisse
     */
    private String caiNomJrEspeceSt;


    /**
     * 0=interdit 1=autorise
     */
    private Integer caiMvtChqBnq;


    /**
     * export espece
     */
    private Boolean caiExportJrEspece;


    /**
     * export cheque
     */
    private Boolean caiExportJrCheque;


    /**
     * export virement
     */
    private Boolean caiExportJrVirement;


    /**
     * export traite
     */
    private Boolean caiExportJrTraite;


    /**
     * export tpe
     */
    private Boolean caiExportJrTpe;


    /**
     * export transfert
     */
    private Boolean caiExportJrTrf;


    /**
     * export epeaiement
     */
    private Boolean caiExportJrEpaiement;


    /**
     * export credoc
     */
    private Boolean caiExportJrCredoc;


    /**
     * export virement
     */
    private Boolean caiExportJrFactor;


    /**
     * export compense
     */
    private Boolean caiExportJrCompense;


    /**
     * export terme
     */
    private Boolean caiExportJrTerme;

}
