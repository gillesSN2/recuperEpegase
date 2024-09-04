package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
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
public class CmmMailsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "maiId can not null")
    private Long maiId;


    /**
     * date de creation
     */
    private LocalDateTime maiDateCreation;


    /**
     * user de creation
     */
    private Long maiUserCreation;


    /**
     * date de modification
     */
    private LocalDateTime maiDateModif;


    /**
     * user de modification
     */
    private Long maiUserModif;


    /**
     * numero chrono du mail
     */
    private String maiNum;


    /**
     * type 0=mail 1=courrier
     */
    private Integer maiType;


    /**
     * sens du mail 0=envoie 1=reception 2=brouillon 3=corbeille
     */
    private Integer maiSens;


    /**
     * id structure
     */
    private Long maiStr;


    /**
     * code groupe
     */
    private String maiGrp;


    /**
     * id user
     */
    private Long maiUsr;


    /**
     * nos references
     */
    private String maiNosRef;


    /**
     * vos references
     */
    private String maiVosRef;


    /**
     * type 0=standard 1=important 2=prioritaire 3=projet 4=reunion
     */
    private Integer maiPriorite;


    /**
     * modele
     */
    private String maiModele;


    /**
     * objet
     */
    private String maiObjet;


    /**
     * emetteur
     */
    private String maiEmetteur;


    /**
     * id du tiers
     */
    private Long maiTiersId;


    /**
     * raison sociale ou nom et prenom du tiers
     */
    private String maiTiersRs;


    /**
     * id du patient
     */
    private Long maiPatientId;


    /**
     * nom prenom patient
     */
    private String maiPatientNom;


    /**
     * id agent
     */
    private Long maiAgentId;


    /**
     * nom prenom agent
     */
    private String maiAgentNom;


    /**
     * destinataire
     */
    private String maiDestinataire;


    /**
     * copie a
     */
    private String maiCc;


    /**
     * copie cachee a
     */
    private String maiCci;


    /**
     * activite commerciale
     */
    private String maiActivite;


    /**
     * service
     */
    private String maiService;


    /**
     * 0=sans pj 1=avec pj
     */
    private Integer maiPj;


    /**
     * corps du mail
     */
    private String maiCorps;


    /**
     * sens du mail avant suppression
     */
    private Integer maiSensOld;


    /**
     * si vide envoi ok sinon message erreur
     */
    private String maiStatut;


    /**
     * true si envoie en erreur
     */
    private Boolean maiErreur;


    /**
     * taille
     */
    private Integer maiTaille;

}
