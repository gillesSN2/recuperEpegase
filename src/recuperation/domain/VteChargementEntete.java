package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_chargement_entete")
public class VteChargementEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "chamob_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chamobId;

    /**
     * date de creation
     */
    @Column(name = "chamob_date_creat")
    private LocalDateTime chamobDateCreat;

    /**
     * date de modification
     */
    @Column(name = "chamob_date_modif")
    private LocalDateTime chamobDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "chamob_user_creat")
    private Long chamobUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "chamob_user_modif")
    private Long chamobUserModif = 0L;

    /**
     * date de chargement
     */
    @Column(name = "chamob_date")
    private LocalDateTime chamobDate;

    /**
     * serie
     */
    @Column(name = "chamob_serie")
    private String chamobSerie;

    /**
     * numero de chargement
     */
    @Column(name = "chamob_num")
    private String chamobNum;

    /**
     * nom du chauffeur
     */
    @Column(name = "chamob_nom_chauffeur")
    private String chamobNomChauffeur;

    /**
     * id du chauffeur
     */
    @Column(name = "chamob_id_chauffeur")
    private Long chamobIdChauffeur = 0L;

    /**
     * code du parc
     */
    @Column(name = "chamob_parc")
    private String chamobParc;

    /**
     * code depot de chargement
     */
    @Column(name = "chamob_depot_charg")
    private String chamobDepotCharg;

    /**
     * observations
     */
    @Column(name = "chamob_obs")
    private String chamobObs;

    /**
     * categorie de client
     */
    @Column(name = "chamob_cat_client")
    private String chamobCatClient;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "chamob_etat_val")
    private Integer chamobEtatVal = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "chamob_etat")
    private Integer chamobEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "chamob_date_valide")
    private LocalDate chamobDateValide;

    /**
     * date de transformation
     */
    @Column(name = "chamob_date_transforme")
    private LocalDate chamobDateTransforme;

    /**
     * date annulation
     */
    @Column(name = "chamob_date_annule")
    private LocalDate chamobDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "chamob_motif_annule")
    private String chamobMotifAnnule;

    /**
     * code budget
     */
    @Column(name = "chamob_budget")
    private String chamobBudget;

    /**
     * code activite
     */
    @Column(name = "chamob_activite")
    private String chamobActivite;

    /**
     * code site
     */
    @Column(name = "chamob_site")
    private String chamobSite;

    /**
     * code departement
     */
    @Column(name = "chamob_departement")
    private String chamobDepartement;

    /**
     * code service
     */
    @Column(name = "chamob_service")
    private String chamobService;

    /**
     * code region
     */
    @Column(name = "chamob_region")
    private String chamobRegion;

    /**
     * code secteur
     */
    @Column(name = "chamob_secteur")
    private String chamobSecteur;

    /**
     * code point de vente
     */
    @Column(name = "chamob_pdv")
    private String chamobPdv;

    /**
     * code analytique 1
     */
    @Column(name = "chamob_anal1")
    private String chamobAnal1;

    /**
     * code analytique 2
     */
    @Column(name = "chamob_anal2")
    private String chamobAnal2;

    /**
     * code analytique 3
     */
    @Column(name = "chamob_anal3")
    private String chamobAnal3;

    /**
     * code analytique 4
     */
    @Column(name = "chamob_anal4")
    private String chamobAnal4;

    /**
     * nom utilisateur de creation
     */
    @Column(name = "chamob_nom_user_creat")
    private String chamobNomUserCreat;

    /**
     * nom utilisateur de modification
     */
    @Column(name = "chamob_nom_user_modif")
    private String chamobNomUserModif;

    /**
     * nom du responsable
     */
    @Column(name = "chamob_nom_responsable")
    private String chamobNomResponsable;

    /**
     * id du responsable
     */
    @Column(name = "chamob_id_responsable")
    private Long chamobIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "chamob_nom_commercial")
    private String chamobNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "chamob_id_commercial")
    private Long chamobIdCommercial = 0L;

    /**
     * categorie du client
     */
    @Column(name = "chamob_cat")
    private String chamobCat;

    /**
     * observations
     */
    @Column(name = "chamob_observation")
    private String chamobObservation;

    /**
     * total ht
     */
    @Column(name = "chamob_tot_ht")
    private Double chamobTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "chamob_tot_remise")
    private Double chamobTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "chamob_tot_rabais")
    private Double chamobTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "chamob_tot_tva")
    private Double chamobTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "chamob_taux_tc")
    private Float chamobTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "chamob_tot_tc")
    private Double chamobTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "chamob_tot_ttc")
    private Double chamobTotTtc = 0D;

    /**
     * total reglement
     */
    @Column(name = "chamob_tot_reglement")
    private Double chamobTotReglement = 0D;

    /**
     * 0=non solde 1=solde
     */
    @Column(name = "chamob_solde")
    private Integer chamobSolde = 0;

    /**
     * date impression
     */
    @Column(name = "chamob_date_imp")
    private LocalDate chamobDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "chamob_modele_imp")
    private String chamobModeleImp;

    @Column(name = "exevte_id")
    private Long exevteId;

    @Column(name = "usr_id")
    private Long usrId;

    /**
     * objet
     */
    @Column(name = "chamob_objet")
    private String chamobObjet;

    /**
     * total facture
     */
    @Column(name = "chamob_tot_facture")
    private Double chamobTotFacture = 0D;

    /**
     * date derniere facture
     */
    @Column(name = "chamob_date_facture")
    private LocalDateTime chamobDateFacture;

    /**
     * date dernier reglement
     */
    @Column(name = "chamob_date_reglement")
    private LocalDateTime chamobDateReglement;

    /**
     * nom equipe
     */
    @Column(name = "chamob_nom_equipe")
    private String chamobNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "chamob_id_equipe")
    private Long chamobIdEquipe = 0L;

}
