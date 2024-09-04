package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmReunionPresenceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long reupreId;


    /**
     * numero de reunion
     */
    private String reupreNum;


    /**
     * id du user
     */
    private Long reupreIdUser;


    /**
     * nom du user
     */
    private String reupreNomUser;


    /**
     * prenom du user
     */
    private String reuprePrenomUser;


    /**
     * civilite du user
     */
    private String reupreCiviliteUser;


    /**
     * 0=non statue 1=present 2=absence autorisee 3=absence non autorisee
     */
    private Integer reupreEtat;


    /**
     * motif absence
     */
    private String reupreMotif;

    private Long reuId;


    /**
     * sans statut
     */
    private Boolean reupreSansStatut;


    /**
     * convocation
     */
    private Boolean reupreConvoquer;


    /**
     * present
     */
    private Boolean reuprePresent;


    /**
     * absence autorisee
     */
    private Boolean reupreAbsentAutorise;


    /**
     * absence interdite
     */
    private Boolean reupreAbsentInterdit;


    /**
     * ca sur devis
     */
    private Double reupreCaDevis;


    /**
     * nb document sur devis
     */
    private Integer reupreNbdocDevis;


    /**
     * ca transforme sur devis
     */
    private Double reupreCatrfDevis;


    /**
     * nb document transforme sur devis
     */
    private Integer reupreNbtrfDevis;


    /**
     * nb de jour sur devis
     */
    private Integer reupreNbjourDevis;


    /**
     * ca par jour sur devis
     */
    private Double reupreCajourDevis;


    /**
     * nb de client sur devis
     */
    private Integer reupreNbclientDevis;


    /**
     * ca par client sur devis
     */
    private Double reupreCaclientDevis;


    /**
     * ca sur cmd
     */
    private Double reupreCaBc;


    /**
     * nb document sur cmd
     */
    private Integer reupreNbdocBc;


    /**
     * ca transforme sur cmd
     */
    private Double reupreCatrfBc;


    /**
     * nb document transforme sur cmd
     */
    private Integer reupreNbtrfBc;


    /**
     * nb de jour sur cmd
     */
    private Integer reupreNbjourBc;


    /**
     * ca par jour sur cmd
     */
    private Double reupreCajourBc;


    /**
     * nb de client sur cmd
     */
    private Integer reupreNbclientBc;


    /**
     * ca par client sur cmd
     */
    private Double reupreCaclientBc;


    /**
     * ca sur bl
     */
    private Double reupreCaBl;


    /**
     * nb document sur bl
     */
    private Integer reupreNbdocBl;


    /**
     * ca transforme sur bl
     */
    private Double reupreCatrfBl;


    /**
     * nb document transforme sur bl
     */
    private Integer reupreNbtrfBl;


    /**
     * nb de jour sur bl
     */
    private Integer reupreNbjourBl;


    /**
     * ca par jour sur bl
     */
    private Double reupreCajourBl;


    /**
     * nb de client sur bl
     */
    private Integer reupreNbclientBl;


    /**
     * ca par client sur bl
     */
    private Double reupreCaclientBl;


    /**
     * ca sur br
     */
    private Double reupreCaBr;


    /**
     * nb document sur br
     */
    private Integer reupreNbdocBr;


    /**
     * ca transforme sur br
     */
    private Double reupreCatrfBr;


    /**
     * nb document transforme sur br
     */
    private Integer reupreNbtrfBr;


    /**
     * nb de jour sur br
     */
    private Integer reupreNbjourBr;


    /**
     * ca par jour sur br
     */
    private Double reupreCajourBr;


    /**
     * nb de client sur br
     */
    private Integer reupreNbclientBr;


    /**
     * ca par client sur br
     */
    private Double reupreCaclientBr;


    /**
     * ca sur facture
     */
    private Double reupreCaFa;


    /**
     * nb document sur facture
     */
    private Integer reupreNbdocFa;


    /**
     * ca transforme sur facture
     */
    private Double reupreCatrfFa;


    /**
     * nb document transforme sur facture
     */
    private Integer reupreNbtrfFa;


    /**
     * nb de jour sur facture
     */
    private Integer reupreNbjourFa;


    /**
     * ca par jour sur facture
     */
    private Double reupreCajourFa;


    /**
     * nb de client sur facture
     */
    private Integer reupreNbclientFa;


    /**
     * ca par client sur facture
     */
    private Double reupreCaclientFa;


    /**
     * ca sur note debit
     */
    private Double reupreCaNd;


    /**
     * nb document sur note debit
     */
    private Integer reupreNbdocNd;


    /**
     * ca transforme sur note debit
     */
    private Double reupreCatrfNd;


    /**
     * nb document transforme sur note debit
     */
    private Integer reupreNbtrfNd;


    /**
     * nb de jour sur note debit
     */
    private Integer reupreNbjourNd;


    /**
     * ca par jour sur note debit
     */
    private Double reupreCajourNd;


    /**
     * nb de client sur note debit
     */
    private Integer reupreNbclientNd;


    /**
     * ca par client sur note debit
     */
    private Double reupreCaclientNd;


    /**
     * ca sur avoir
     */
    private Double reupreCaAv;


    /**
     * nb document sur avoir
     */
    private Integer reupreNbdocAv;


    /**
     * ca transforme sur avoir
     */
    private Double reupreCatrfAv;


    /**
     * nb document transforme sur avoir
     */
    private Integer reupreNbtrfAv;


    /**
     * nb de jour sur avoir
     */
    private Integer reupreNbjourAv;


    /**
     * ca par jour sur avoir
     */
    private Double reupreCajourAv;


    /**
     * nb de client sur avoir
     */
    private Integer reupreNbclientAv;


    /**
     * ca par client sur avoir
     */
    private Double reupreCaclientAv;


    /**
     * nb de rdv
     */
    private Integer reupreNbRdv;


    /**
     * nb de rdv fait
     */
    private Integer reupreNbRdvFait;


    /**
     * nb de rdv non fait
     */
    private Integer reupreNbRdvNonFait;


    /**
     * nb de rdv reporte
     */
    private Integer reupreNbRdvReporte;


    /**
     * nb de rdv annule
     */
    private Integer reupreNbRdvAnnule;


    /**
     * objectif sur devis
     */
    private Double reupreObjectifDevis;


    /**
     * objectif sur cmd
     */
    private Double reupreObjectifBc;


    /**
     * objectif sur bl
     */
    private Double reupreObjectifBl;


    /**
     * objectif sur br
     */
    private Double reupreObjectifBr;


    /**
     * objectif sur facture
     */
    private Double reupreObjectifFa;


    /**
     * objectif sur note debit
     */
    private Double reupreObjectifNd;


    /**
     * objectif sur avoir
     */
    private Double reupreObjectifAv;


    /**
     * objectif de rdv
     */
    private Integer reupreObjectifRdv;

}
