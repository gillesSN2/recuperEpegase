package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_reglements")
public class CaiReglements implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rgl_id", nullable = false)
    private Long rglId;

    /**
     * concatenation rgl_caisse:rgl_periode
     */
    @Column(name = "rgl_cle1")
    private String rglCle1;

    /**
     * concatenation rgl_caisse:rgl_dateReg
     */
    @Column(name = "rgl_cle2")
    private String rglCle2;

    /**
     * MM:AAAA par rapport a la date de saisie
     */
    @Column(name = "rgl_periode")
    private String rglPeriode;

    /**
     * date de creation
     */
    @Column(name = "rgl_date_creation")
    private LocalDateTime rglDateCreation;

    /**
     * utilisateur de creation
     */
    @Column(name = "rgl_user_creat")
    private Long rglUserCreat = 0L;

    /**
     * date de modification
     */
    @Column(name = "rgl_date_modif")
    private LocalDateTime rglDateModif;

    /**
     * user de modification
     */
    @Column(name = "rgl_user_modif")
    private Long rglUserModif = 0L;

    /**
     * date du reglement
     */
    @Column(name = "rgl_date_reg")
    private LocalDate rglDateReg;

    /**
     * date de valeur du reglement
     */
    @Column(name = "rgl_date_valeur")
    private LocalDate rglDateValeur;

    /**
     * numero du bon origine
     */
    @Column(name = "rgl_bon")
    private String rglBon;

    /**
     * id du bon origine
     */
    @Column(name = "rgl_id_bon")
    private Long rglIdBon = 0L;

    /**
     * id du document origine
     */
    @Column(name = "rgl_id_document")
    private Long rglIdDocument = 0L;

    /**
     * numero du document origine
     */
    @Column(name = "rgl_document")
    private String rglDocument;

    /**
     * nature du document origine 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "rgl_nature_doc")
    private Integer rglNatureDoc = 0;

    /**
     * serie du document
     */
    @Column(name = "rgl_serie")
    private String rglSerie;

    /**
     * numero piece du reglement
     */
    @Column(name = "rgl_num")
    private String rglNum;

    /**
     * code de la caisse execution
     */
    @Column(name = "rgl_code_caisse")
    private String rglCodeCaisse;

    /**
     * libelle de la caisse execution
     */
    @Column(name = "rgl_caisse")
    private String rglCaisse;

    /**
     * code caisse emetrice
     */
    @Column(name = "rgl_code_emetrice")
    private String rglCodeEmetrice;

    /**
     * libelle caisse emetrice
     */
    @Column(name = "rgl_lib_emetrice")
    private String rglLibEmetrice;

    /**
     * code caisse receptrice
     */
    @Column(name = "rgl_code_receptrice")
    private String rglCodeReceptrice;

    /**
     * libelle caisse receptrice
     */
    @Column(name = "rgl_lib_receptrice")
    private String rglLibReceptrice;

    /**
     * libelle du reglement
     */
    @Column(name = "rgl_libelle")
    private String rglLibelle;

    /**
     * objet du document
     */
    @Column(name = "rgl_objet")
    private String rglObjet;

    /**
     * 10=fournisseurs 20=clients 62=bons de sortie 63=bons entree 64=virement interne
     */
    @Column(name = "rgl_categorie")
    private Integer rglCategorie;

    /**
     * type du regelement
     */
    @Column(name = "rgl_type_reg")
    private Integer rglTypeReg = 0;

    /**
     * mode du reglement fichier typeReglement.xml
     */
    @Column(name = "rgl_mode")
    private String rglMode;

    /**
     * montant de la depense
     */
    @Column(name = "rgl_depense")
    private Double rglDepense = 0D;

    /**
     * montant de la recette
     */
    @Column(name = "rgl_recette")
    private Double rglRecette = 0D;

    /**
     * devise utilisee
     */
    @Column(name = "rgl_devise")
    private String rglDevise;

    /**
     * format devise utilisee
     */
    @Column(name = "rgl_format_devise")
    private Integer rglFormatDevise = 0;

    /**
     * nom du tiers (fournisseur, client, agent, patient)
     */
    @Column(name = "rgl_nom_tiers")
    private String rglNomTiers;

    /**
     * id tiers
     */
    @Column(name = "rgl_id_tiers")
    private Long rglIdTiers = 0L;

    /**
     * type tiers 0=client 1=fournisseur 2=agent 3=plan comptble 4=patient 5=eleve
     */
    @Column(name = "rgl_type_tiers")
    private Integer rglTypeTiers = 0;

    /**
     * 0=entree normal 1=depot dans compte tiers
     */
    @Column(name = "rgl_depot_tiers")
    private Integer rglDepotTiers = 0;

    /**
     * id du caissier
     */
    @Column(name = "rgl_id_caissier")
    private Long rglIdCaissier = 0L;

    /**
     * nom du caissier
     */
    @Column(name = "rgl_nom_caissier")
    private String rglNomCaissier;

    /**
     * code du budget
     */
    @Column(name = "rgl_budget")
    private String rglBudget;

    /**
     * code activite
     */
    @Column(name = "rgl_activite")
    private String rglActivite;

    /**
     * code du site
     */
    @Column(name = "rgl_site")
    private String rglSite;

    /**
     * code du depatement
     */
    @Column(name = "rgl_departement")
    private String rglDepartement;

    /**
     * code du service
     */
    @Column(name = "rgl_service")
    private String rglService;

    /**
     * code region
     */
    @Column(name = "rgl_region")
    private String rglRegion;

    /**
     * code secteur
     */
    @Column(name = "rgl_secteur")
    private String rglSecteur;

    /**
     * code point de vente
     */
    @Column(name = "rgl_pdv")
    private String rglPdv;

    /**
     * modele impression
     */
    @Column(name = "rgl_modele")
    private String rglModele;

    /**
     * date impression
     */
    @Column(name = "rgl_date_imp")
    private LocalDateTime rglDateImp;

    /**
     * 0=transferable 1=non transferable
     */
    @Column(name = "rgl_trf")
    private Integer rglTrf = 0;

    /**
     * date de transfert en compta
     */
    @Column(name = "rgl_date_transfert")
    private LocalDateTime rglDateTransfert;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * montant du timbre
     */
    @Column(name = "rgl_timbre")
    private Double rglTimbre = 0D;

    /**
     * id tiers
     */
    @Column(name = "rgl_id_contact")
    private Long rglIdContact = 0L;

    /**
     * nom du contact ou destinataire
     */
    @Column(name = "rgl_nom_contact")
    private String rglNomContact;

    /**
     * code dossier
     */
    @Column(name = "rgl_dossier")
    private String rglDossier;

    /**
     * code parc
     */
    @Column(name = "rgl_parc")
    private String rglParc;

    /**
     * cle 1 de repartition
     */
    @Column(name = "rgl_cle1_repartition")
    private String rglCle1Repartition;

    /**
     * cle 2 de repartition
     */
    @Column(name = "rgl_cle2_repartition")
    private String rglCle2Repartition;

    /**
     * 0=imprimable 1=non imprimable
     */
    @Column(name = "rgl_imp")
    private Integer rglImp = 0;

    /**
     * banque du tireur
     */
    @Column(name = "rgl_banque_tireur")
    private String rglBanqueTireur;

    /**
     * numero cheque ou bordereau
     */
    @Column(name = "rgl_num_chq_bdx")
    private String rglNumChqBdx;

    /**
     * date de cloture en compta
     */
    @Column(name = "rgl_date_cloture")
    private LocalDateTime rglDateCloture;

    /**
     * code operation
     */
    @Column(name = "rgl_operation")
    private String rglOperation;

    /**
     * date mouvement 1 caisse/caisse
     */
    @Column(name = "rgl_date_mvt1")
    private LocalDate rglDateMvt1;

    /**
     * numero mouvement 1 caisse/caisse
     */
    @Column(name = "rgl_num_mvt1")
    private String rglNumMvt1;

    /**
     * date mouvement 2 caisse/banque
     */
    @Column(name = "rgl_date_mvt2")
    private LocalDate rglDateMvt2;

    /**
     * numero mouvement 2 caisse/banque
     */
    @Column(name = "rgl_num_mvt2")
    private String rglNumMvt2;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b1")
    private Integer rglB1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b2")
    private Integer rglB2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b3")
    private Integer rglB3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b4")
    private Integer rglB4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b5")
    private Integer rglB5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b6")
    private Integer rglB6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b7")
    private Integer rglB7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b8")
    private Integer rglB8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b9")
    private Integer rglB9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_b10")
    private Integer rglB10 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p1")
    private Integer rglP1 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p2")
    private Integer rglP2 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p3")
    private Integer rglP3 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p4")
    private Integer rglP4 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p5")
    private Integer rglP5 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p6")
    private Integer rglP6 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p7")
    private Integer rglP7 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p8")
    private Integer rglP8 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p9")
    private Integer rglP9 = 0;

    /**
     * nombre billet
     */
    @Column(name = "rgl_p10")
    private Integer rglP10 = 0;

    /**
     * code caisse de transfert caisse/caisse
     */
    @Column(name = "rgl_caisse_mvt1")
    private String rglCaisseMvt1;

    /**
     * code banque de transfert caisse/banque
     */
    @Column(name = "rgl_banque_mvt2")
    private String rglBanqueMvt2;

    /**
     * numero de transfert
     */
    @Column(name = "rgl_num_trf")
    private String rglNumTrf;

    /**
     * date execution bon caisse
     */
    @Column(name = "rgl_date_exec_bc")
    private LocalDate rglDateExecBc;

    /**
     * montant des frais
     */
    @Column(name = "rgl_frais")
    private Double rglFrais = 0D;

    /**
     * code budget
     */
    @Column(name = "rgl_code_budget_treso")
    private String rglCodeBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "rgl_code_poste_treso")
    private String rglCodePosteTreso;

    /**
     * montant rendu
     */
    @Column(name = "rgl_rendu")
    private Double rglRendu = 0D;

    /**
     * id du responsable origine
     */
    @Column(name = "rgl_id_responsable")
    private Long rglIdResponsable = 0L;

    /**
     * nom du responsable origine
     */
    @Column(name = "rgl_nom_responsable")
    private String rglNomResponsable;

    /**
     * id du commercial origine
     */
    @Column(name = "rgl_id_commercial")
    private Long rglIdCommercial = 0L;

    /**
     * nom du commercial origine
     */
    @Column(name = "rgl_nom_commercial")
    private String rglNomCommercial;

    /**
     * id equipe origine
     */
    @Column(name = "rgl_id_equipe")
    private Long rglIdEquipe = 0L;

    /**
     * nom equipe origine
     */
    @Column(name = "rgl_nom_equipe")
    private String rglNomEquipe;

    /**
     * montant de la commission
     */
    @Column(name = "rgl_commission")
    private Double rglCommission = 0D;

    /**
     * concatenation rgl_code_receptrice:rgl_periode caisse destination
     */
    @Column(name = "rgl_cle3")
    private String rglCle3;

    /**
     * concatenation rgl_code_receptrice:rgl_dateReg caisse destination
     */
    @Column(name = "rgl_cle4")
    private String rglCle4;

    /**
     * date encaissement
     */
    @Column(name = "rgl_date_encaissement")
    private LocalDate rglDateEncaissement;

    /**
     * date rejet
     */
    @Column(name = "rgl_date_rejet")
    private LocalDate rglDateRejet;

}
