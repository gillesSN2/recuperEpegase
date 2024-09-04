package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class CmmRdvVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "rdvId can not null")
    private Long rdvId;


    /**
     * 0=rappel 1=rdv 2=todo 3=emploi du temps 4=visite 5=intervention 6=appel 7=pointage 8=reunion 9=message
     */
    private Integer rdvNature;


    /**
     * date de creation
     */
    private LocalDate rdvDateCreation;


    /**
     * id user destinataire
     */
    private Long rdvUsrDe;


    /**
     * nom users destinataire
     */
    private String rdvNomUsers;


    /**
     * id tiers destinataire
     */
    private Long rdvTieIdDe;


    /**
     * nom Tiers destinataire
     */
    private String rdvNomTiers;


    /**
     * id patient destinataire
     */
    private Long rdvPatIdDe;


    /**
     * nom patient destinataire
     */
    private String rdvNomPat;


    /**
     * id salarie destinataire
     */
    private Long rdvSalIdDe;


    /**
     * nom salarie destinataire
     */
    private String rdvNomSal;


    /**
     * date de debut
     */
    private LocalDate rdvDteDe;


    /**
     * heure de debut
     */
    private String rdvHrDe;


    /**
     * minute de debut
     */
    private String rdvMnDe;


    /**
     * heure duree
     */
    private String rdvHrDuree;


    /**
     * minute duree
     */
    private String rdvMnDuree;


    /**
     * date de fin
     */
    private LocalDate rdvDteFi;


    /**
     * heure de fin
     */
    private String rdvHrFi;


    /**
     * minute de fin
     */
    private String rdvMnFi;


    /**
     * sujet du rdv
     */
    private String rdvSujet;


    /**
     * description du rdv
     */
    private String rdvDescript;


    /**
     * code tache du rdv
     */
    private String rdvTache;


    /**
     * pr du rdv
     */
    private Float rdvTachePr;


    /**
     * pv du rdv
     */
    private Float rdvTachePv;


    /**
     * lieu du rdv
     */
    private String rdvLieu;


    /**
     * mode du rdv exemple telephon
     */
    private String rdvMode;


    /**
     * 0=en cours 1=traite 2=annule
     */
    private Integer rdvEtat;


    /**
     * date execution
     */
    private LocalDate rdvDteExec;


    /**
     * compte rendu
     */
    private String rdvCr;


    /**
     * 0=normal 99= divers
     */
    private Integer rdvDiversTiers;


    /**
     * nom du tiers divers
     */
    private String rdvDiversNom;

    private Long usrId;


    /**
     * liste des mails du contact invites
     */
    private String rdvMailContact;


    /**
     * liste des collaborateurs invites
     */
    private String rdvCollaborateur;


    /**
     * id du rdv principal
     */
    private Long rdvIdPrincipal;


    /**
     * si vide envoi ok sinon message erreur
     */
    private String rdvStatut;


    /**
     * true si erreur
     */
    private Boolean rdvErreur;


    /**
     * code service
     */
    private String rdvService;

}
