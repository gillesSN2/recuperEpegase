package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_parc_consommation")
public class PrcParcConsommation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prccon_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcconId;

    /**
     * date de creation
     */
    @Column(name = "prccon_date_creat")
    private LocalDateTime prcconDateCreat;

    /**
     * date de modification
     */
    @Column(name = "prccon_date_modif")
    private LocalDateTime prcconDateModif;

    /**
     * id user createur
     */
    @Column(name = "prccon_id_createur")
    private Long prcconIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "prccon_nom_createur")
    private String prcconNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "prccon_id_modif")
    private Long prcconIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "prccon_nom_modif")
    private String prcconNomModif;

    /**
     * date consommation
     */
    @Column(name = "prccon_date")
    private LocalDateTime prcconDate;

    /**
     * numero bon
     */
    @Column(name = "prccon_num")
    private String prcconNum;

    /**
     * nom du pompiste
     */
    @Column(name = "prccon_nom_pompiste")
    private String prcconNomPompiste;

    /**
     * id du pompiste
     */
    @Column(name = "prccon_id_pompiste")
    private Long prcconIdPompiste = 0L;

    /**
     * nom du demandeur
     */
    @Column(name = "prccon_nom_demandeur")
    private String prcconNomDemandeur;

    /**
     * id du demandeur
     */
    @Column(name = "prccon_id_demandeur")
    private Long prcconIdDemandeur = 0L;

    /**
     * serie
     */
    @Column(name = "prccon_serie")
    private String prcconSerie;

    /**
     * 0=carburant 1=lubrifiant
     */
    @Column(name = "prccon_type")
    private Integer prcconType = 0;

    /**
     * depot inventorie
     */
    @Column(name = "prccon_depot")
    private String prcconDepot;

    /**
     * code produit
     */
    @Column(name = "prccon_code")
    private String prcconCode;

    /**
     * libelle produit
     */
    @Column(name = "prccon_libelle")
    private String prcconLibelle;

    /**
     * quantite consommee
     */
    @Column(name = "prccon_qte")
    private Float prcconQte = 0F;

    /**
     * prix unitaire
     */
    @Column(name = "prccon_pu")
    private Double prcconPu = 0D;

    /**
     * total ttc
     */
    @Column(name = "prccon_total")
    private Double prcconTotal = 0D;

    /**
     * code activite
     */
    @Column(name = "prccon_activite")
    private String prcconActivite;

    /**
     * code site
     */
    @Column(name = "prccon_site")
    private String prcconSite;

    /**
     * code departement
     */
    @Column(name = "prccon_departement")
    private String prcconDepartement;

    /**
     * code service
     */
    @Column(name = "prccon_service")
    private String prcconService;

    /**
     * code region
     */
    @Column(name = "prccon_region")
    private String prcconRegion;

    /**
     * code secteur
     */
    @Column(name = "prccon_secteur")
    private String prcconSecteur;

    /**
     * code point de vente
     */
    @Column(name = "prccon_pdv")
    private String prcconPdv;

    /**
     * code analytique 2
     */
    @Column(name = "prccon_anal2")
    private String prcconAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "prccon_anal4")
    private String prcconAnal4;

    /**
     * date impression
     */
    @Column(name = "prccon_date_imp")
    private LocalDate prcconDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "prccon_modele_imp")
    private String prcconModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "prccon_etat_val")
    private Integer prcconEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "prccon_gele")
    private Integer prcconGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    @Column(name = "prccon_etat")
    private Integer prcconEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "prccon_date_valide")
    private LocalDate prcconDateValide;

    /**
     * date annulation
     */
    @Column(name = "prccon_date_annule")
    private LocalDate prcconDateAnnule;

    /**
     * motif annulation
     */
    @Column(name = "prccon_motif_annule")
    private String prcconMotifAnnule;

    /**
     * releve du compteur
     */
    @Column(name = "prccon_compteur")
    private Long prcconCompteur = 0L;

    /**
     * 0=distance 1=kilometrique 2=horaire
     */
    @Column(name = "prccon_type_compteur")
    private Integer prcconTypeCompteur = 0;

    @Column(name = "exeprc_id", nullable = false)
    private Long exeprcId;

    @Column(name = "prc_id", nullable = false)
    private Long prcId;

    /**
     * poids net
     */
    @Column(name = "prccon_poidsNet")
    private Float prcconPoidsnet = 0F;

    /**
     * poids brut
     */
    @Column(name = "prccon_poidsBrut")
    private Float prcconPoidsbrut = 0F;

}
