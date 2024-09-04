package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_reunion_presence")
public class CmmReunionPresence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reupre_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reupreId;

    /**
     * numero de reunion
     */
    @Column(name = "reupre_num")
    private String reupreNum;

    /**
     * id du user
     */
    @Column(name = "reupre_id_user")
    private Long reupreIdUser = 0L;

    /**
     * nom du user
     */
    @Column(name = "reupre_nom_user")
    private String reupreNomUser;

    /**
     * prenom du user
     */
    @Column(name = "reupre_prenom_user")
    private String reuprePrenomUser;

    /**
     * civilite du user
     */
    @Column(name = "reupre_civilite_user")
    private String reupreCiviliteUser;

    /**
     * 0=non statue 1=present 2=absence autorisee 3=absence non autorisee
     */
    @Column(name = "reupre_etat")
    private Integer reupreEtat = 0;

    /**
     * motif absence
     */
    @Column(name = "reupre_motif")
    private String reupreMotif;

    @Column(name = "reu_id", nullable = false)
    private Long reuId;

    /**
     * sans statut
     */
    @Column(name = "reupre_sans_statut")
    private Boolean reupreSansStatut = Boolean.FALSE;

    /**
     * convocation
     */
    @Column(name = "reupre_convoquer")
    private Boolean reupreConvoquer = Boolean.FALSE;

    /**
     * present
     */
    @Column(name = "reupre_present")
    private Boolean reuprePresent = Boolean.FALSE;

    /**
     * absence autorisee
     */
    @Column(name = "reupre_absent_autorise")
    private Boolean reupreAbsentAutorise = Boolean.FALSE;

    /**
     * absence interdite
     */
    @Column(name = "reupre_absent_interdit")
    private Boolean reupreAbsentInterdit = Boolean.FALSE;

    /**
     * ca sur devis
     */
    @Column(name = "reupre_ca_devis")
    private Double reupreCaDevis = 0D;

    /**
     * nb document sur devis
     */
    @Column(name = "reupre_nbdoc_devis")
    private Integer reupreNbdocDevis = 0;

    /**
     * ca transforme sur devis
     */
    @Column(name = "reupre_catrf_devis")
    private Double reupreCatrfDevis = 0D;

    /**
     * nb document transforme sur devis
     */
    @Column(name = "reupre_nbtrf_devis")
    private Integer reupreNbtrfDevis = 0;

    /**
     * nb de jour sur devis
     */
    @Column(name = "reupre_nbjour_devis")
    private Integer reupreNbjourDevis = 0;

    /**
     * ca par jour sur devis
     */
    @Column(name = "reupre_cajour_devis")
    private Double reupreCajourDevis = 0D;

    /**
     * nb de client sur devis
     */
    @Column(name = "reupre_nbclient_devis")
    private Integer reupreNbclientDevis = 0;

    /**
     * ca par client sur devis
     */
    @Column(name = "reupre_caclient_devis")
    private Double reupreCaclientDevis = 0D;

    /**
     * ca sur cmd
     */
    @Column(name = "reupre_ca_bc")
    private Double reupreCaBc = 0D;

    /**
     * nb document sur cmd
     */
    @Column(name = "reupre_nbdoc_bc")
    private Integer reupreNbdocBc = 0;

    /**
     * ca transforme sur cmd
     */
    @Column(name = "reupre_catrf_bc")
    private Double reupreCatrfBc = 0D;

    /**
     * nb document transforme sur cmd
     */
    @Column(name = "reupre_nbtrf_bc")
    private Integer reupreNbtrfBc = 0;

    /**
     * nb de jour sur cmd
     */
    @Column(name = "reupre_nbjour_bc")
    private Integer reupreNbjourBc = 0;

    /**
     * ca par jour sur cmd
     */
    @Column(name = "reupre_cajour_bc")
    private Double reupreCajourBc = 0D;

    /**
     * nb de client sur cmd
     */
    @Column(name = "reupre_nbclient_bc")
    private Integer reupreNbclientBc = 0;

    /**
     * ca par client sur cmd
     */
    @Column(name = "reupre_caclient_bc")
    private Double reupreCaclientBc = 0D;

    /**
     * ca sur bl
     */
    @Column(name = "reupre_ca_bl")
    private Double reupreCaBl = 0D;

    /**
     * nb document sur bl
     */
    @Column(name = "reupre_nbdoc_bl")
    private Integer reupreNbdocBl = 0;

    /**
     * ca transforme sur bl
     */
    @Column(name = "reupre_catrf_bl")
    private Double reupreCatrfBl = 0D;

    /**
     * nb document transforme sur bl
     */
    @Column(name = "reupre_nbtrf_bl")
    private Integer reupreNbtrfBl = 0;

    /**
     * nb de jour sur bl
     */
    @Column(name = "reupre_nbjour_bl")
    private Integer reupreNbjourBl = 0;

    /**
     * ca par jour sur bl
     */
    @Column(name = "reupre_cajour_bl")
    private Double reupreCajourBl = 0D;

    /**
     * nb de client sur bl
     */
    @Column(name = "reupre_nbclient_bl")
    private Integer reupreNbclientBl = 0;

    /**
     * ca par client sur bl
     */
    @Column(name = "reupre_caclient_bl")
    private Double reupreCaclientBl = 0D;

    /**
     * ca sur br
     */
    @Column(name = "reupre_ca_br")
    private Double reupreCaBr = 0D;

    /**
     * nb document sur br
     */
    @Column(name = "reupre_nbdoc_br")
    private Integer reupreNbdocBr = 0;

    /**
     * ca transforme sur br
     */
    @Column(name = "reupre_catrf_br")
    private Double reupreCatrfBr = 0D;

    /**
     * nb document transforme sur br
     */
    @Column(name = "reupre_nbtrf_br")
    private Integer reupreNbtrfBr = 0;

    /**
     * nb de jour sur br
     */
    @Column(name = "reupre_nbjour_br")
    private Integer reupreNbjourBr = 0;

    /**
     * ca par jour sur br
     */
    @Column(name = "reupre_cajour_br")
    private Double reupreCajourBr = 0D;

    /**
     * nb de client sur br
     */
    @Column(name = "reupre_nbclient_br")
    private Integer reupreNbclientBr = 0;

    /**
     * ca par client sur br
     */
    @Column(name = "reupre_caclient_br")
    private Double reupreCaclientBr = 0D;

    /**
     * ca sur facture
     */
    @Column(name = "reupre_ca_fa")
    private Double reupreCaFa = 0D;

    /**
     * nb document sur facture
     */
    @Column(name = "reupre_nbdoc_fa")
    private Integer reupreNbdocFa = 0;

    /**
     * ca transforme sur facture
     */
    @Column(name = "reupre_catrf_fa")
    private Double reupreCatrfFa = 0D;

    /**
     * nb document transforme sur facture
     */
    @Column(name = "reupre_nbtrf_fa")
    private Integer reupreNbtrfFa = 0;

    /**
     * nb de jour sur facture
     */
    @Column(name = "reupre_nbjour_fa")
    private Integer reupreNbjourFa = 0;

    /**
     * ca par jour sur facture
     */
    @Column(name = "reupre_cajour_fa")
    private Double reupreCajourFa = 0D;

    /**
     * nb de client sur facture
     */
    @Column(name = "reupre_nbclient_fa")
    private Integer reupreNbclientFa = 0;

    /**
     * ca par client sur facture
     */
    @Column(name = "reupre_caclient_fa")
    private Double reupreCaclientFa = 0D;

    /**
     * ca sur note debit
     */
    @Column(name = "reupre_ca_nd")
    private Double reupreCaNd = 0D;

    /**
     * nb document sur note debit
     */
    @Column(name = "reupre_nbdoc_nd")
    private Integer reupreNbdocNd = 0;

    /**
     * ca transforme sur note debit
     */
    @Column(name = "reupre_catrf_nd")
    private Double reupreCatrfNd = 0D;

    /**
     * nb document transforme sur note debit
     */
    @Column(name = "reupre_nbtrf_nd")
    private Integer reupreNbtrfNd = 0;

    /**
     * nb de jour sur note debit
     */
    @Column(name = "reupre_nbjour_nd")
    private Integer reupreNbjourNd = 0;

    /**
     * ca par jour sur note debit
     */
    @Column(name = "reupre_cajour_nd")
    private Double reupreCajourNd = 0D;

    /**
     * nb de client sur note debit
     */
    @Column(name = "reupre_nbclient_nd")
    private Integer reupreNbclientNd = 0;

    /**
     * ca par client sur note debit
     */
    @Column(name = "reupre_caclient_nd")
    private Double reupreCaclientNd = 0D;

    /**
     * ca sur avoir
     */
    @Column(name = "reupre_ca_av")
    private Double reupreCaAv = 0D;

    /**
     * nb document sur avoir
     */
    @Column(name = "reupre_nbdoc_av")
    private Integer reupreNbdocAv = 0;

    /**
     * ca transforme sur avoir
     */
    @Column(name = "reupre_catrf_av")
    private Double reupreCatrfAv = 0D;

    /**
     * nb document transforme sur avoir
     */
    @Column(name = "reupre_nbtrf_av")
    private Integer reupreNbtrfAv = 0;

    /**
     * nb de jour sur avoir
     */
    @Column(name = "reupre_nbjour_av")
    private Integer reupreNbjourAv = 0;

    /**
     * ca par jour sur avoir
     */
    @Column(name = "reupre_cajour_av")
    private Double reupreCajourAv = 0D;

    /**
     * nb de client sur avoir
     */
    @Column(name = "reupre_nbclient_av")
    private Integer reupreNbclientAv = 0;

    /**
     * ca par client sur avoir
     */
    @Column(name = "reupre_caclient_av")
    private Double reupreCaclientAv = 0D;

    /**
     * nb de rdv
     */
    @Column(name = "reupre_nb_rdv")
    private Integer reupreNbRdv = 0;

    /**
     * nb de rdv fait
     */
    @Column(name = "reupre_nb_rdv_fait")
    private Integer reupreNbRdvFait = 0;

    /**
     * nb de rdv non fait
     */
    @Column(name = "reupre_nb_rdv_non_fait")
    private Integer reupreNbRdvNonFait = 0;

    /**
     * nb de rdv reporte
     */
    @Column(name = "reupre_nb_rdv_reporte")
    private Integer reupreNbRdvReporte = 0;

    /**
     * nb de rdv annule
     */
    @Column(name = "reupre_nb_rdv_annule")
    private Integer reupreNbRdvAnnule = 0;

    /**
     * objectif sur devis
     */
    @Column(name = "reupre_objectif_devis")
    private Double reupreObjectifDevis = 0D;

    /**
     * objectif sur cmd
     */
    @Column(name = "reupre_objectif_bc")
    private Double reupreObjectifBc = 0D;

    /**
     * objectif sur bl
     */
    @Column(name = "reupre_objectif_bl")
    private Double reupreObjectifBl = 0D;

    /**
     * objectif sur br
     */
    @Column(name = "reupre_objectif_br")
    private Double reupreObjectifBr = 0D;

    /**
     * objectif sur facture
     */
    @Column(name = "reupre_objectif_fa")
    private Double reupreObjectifFa = 0D;

    /**
     * objectif sur note debit
     */
    @Column(name = "reupre_objectif_nd")
    private Double reupreObjectifNd = 0D;

    /**
     * objectif sur avoir
     */
    @Column(name = "reupre_objectif_av")
    private Double reupreObjectifAv = 0D;

    /**
     * objectif de rdv
     */
    @Column(name = "reupre_objectif_rdv")
    private Integer reupreObjectifRdv = 0;

}
