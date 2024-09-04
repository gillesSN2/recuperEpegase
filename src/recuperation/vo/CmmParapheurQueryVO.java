package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CmmParapheurQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long phrId;


    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer phrNature;


    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    private Integer phrNatureOrigine;


    /**
     * montant du bon encaissement
     */
    private Double phrMontant;


    /**
     * 0=mono signature 1=multi signature
     */
    private Integer phrMode;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser1Cat;


    /**
     * id user
     */
    private Long phrUser1Id;


    /**
     * nom et prenom user
     */
    private String phrUser1Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser2Cat;


    /**
     * id user
     */
    private Long phrUser2Id;


    /**
     * nom et prenom user
     */
    private String phrUser2Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser3Cat;


    /**
     * id user
     */
    private Long phrUser3Id;


    /**
     * nom et prenom user
     */
    private String phrUser3Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser4Cat;


    /**
     * id user
     */
    private Long phrUser4Id;


    /**
     * nom et prenom user
     */
    private String phrUser4Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser5Cat;


    /**
     * id user
     */
    private Long phrUser5Id;


    /**
     * nom et prenom user
     */
    private String phrUser5Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser6Cat;


    /**
     * id user
     */
    private Long phrUser6Id;


    /**
     * nom et prenom user
     */
    private String phrUser6Nom;


    /**
     * id du document
     */
    private Long phrDocId;


    /**
     * numero du document
     */
    private String phrNum;


    /**
     * date du document
     */
    private LocalDate phrDate;


    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser1Etat;


    /**
     * date reponse du user 1
     */
    private LocalDate phrUser1DteRep;


    /**
     * explications du user 1
     */
    private String phrUser1Explication;


    /**
     * reponse user 2 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser2Etat;


    /**
     * date reponse du user 2
     */
    private LocalDate phrUser2DteRep;


    /**
     * explications du user 2
     */
    private String phrUser2Explication;


    /**
     * reponse user 3 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser3Etat;


    /**
     * date reponse du user 3
     */
    private LocalDate phrUser3DteRep;


    /**
     * explications du user 3
     */
    private String phrUser3Explication;


    /**
     * reponse user 4 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser4Etat;


    /**
     * date reponse du user 4
     */
    private LocalDate phrUser4DteRep;


    /**
     * explications du user 4
     */
    private String phrUser4Explication;


    /**
     * reponse user 5 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser5Etat;


    /**
     * date reponse du user 5
     */
    private LocalDate phrUser5DteRep;


    /**
     * explications du user 5
     */
    private String phrUser5Explication;


    /**
     * reponse user 6 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser6Etat;


    /**
     * date reponse du user 6
     */
    private LocalDate phrUser6DteRep;


    /**
     * explications du user 6
     */
    private String phrUser6Explication;


    /**
     * final 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrEtat;


    /**
     * date du changement d etat final
     */
    private LocalDate phrDateEtat;


    /**
     * explications finales du gel ou de annulation
     */
    private String phrExplication;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace1Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace1Nom;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace2Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace2Nom;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace3Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace3Nom;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace4Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace4Nom;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace5Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace5Nom;


    /**
     * id remplaÃƒÂ§ant
     */
    private Long phrRemplace6Id;


    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    private String phrRemplace6Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire1Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire1Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire2Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire2Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire3Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire3Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire4Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire4Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire5Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire5Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire6Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire6Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace1Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace1Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace2Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace2Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace3Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace3Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace4Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace4Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace5Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace5Nom;


    /**
     * copie id du remplaÃƒÂ§ant
     */
    private Long phrCopieRemplace6Id;


    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    private String phrCopieRemplace6Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser7Cat;


    /**
     * id user
     */
    private Long phrUser7Id;


    /**
     * nom et prenom user
     */
    private String phrUser7Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser8Cat;


    /**
     * id user
     */
    private Long phrUser8Id;


    /**
     * nom et prenom user
     */
    private String phrUser8Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser9Cat;


    /**
     * id user
     */
    private Long phrUser9Id;


    /**
     * nom et prenom user
     */
    private String phrUser9Nom;


    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    private Integer phrUser10Cat;


    /**
     * id user
     */
    private Long phrUser10Id;


    /**
     * nom et prenom user
     */
    private String phrUser10Nom;


    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser7Etat;


    /**
     * date reponse du user 1
     */
    private LocalDate phrUser7DteRep;


    /**
     * explications du user 1
     */
    private String phrUser7Explication;


    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser8Etat;


    /**
     * date reponse du user 1
     */
    private LocalDate phrUser8DteRep;


    /**
     * explications du user 1
     */
    private String phrUser8Explication;


    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser9Etat;


    /**
     * date reponse du user 1
     */
    private LocalDate phrUser9DteRep;


    /**
     * explications du user 1
     */
    private String phrUser9Explication;


    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    private Integer phrUser10Etat;


    /**
     * date reponse du user 1
     */
    private LocalDate phrUser10DteRep;


    /**
     * explications du user 1
     */
    private String phrUser10Explication;


    /**
     * id remplaçant
     */
    private Long phrRemplace7Id;


    /**
     * nom et prenom remplaçant
     */
    private String phrRemplace7Nom;


    /**
     * id remplaçant
     */
    private Long phrRemplace8Id;


    /**
     * nom et prenom remplaçant
     */
    private String phrRemplace8Nom;


    /**
     * id remplaçant
     */
    private Long phrRemplace9Id;


    /**
     * nom et prenom remplaçant
     */
    private String phrRemplace9Nom;


    /**
     * id remplaçant
     */
    private Long phrRemplace10Id;


    /**
     * nom et prenom remplaçant
     */
    private String phrRemplace10Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire7Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire7Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire8Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire8Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire9Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire9Nom;


    /**
     * id user proprietaire
     */
    private Long phrProprietaire10Id;


    /**
     * nom et prenom propritaire
     */
    private String phrPropritaire10Nom;


    /**
     * copie id du remplaçant
     */
    private Long phrCopieRemplace7Id;


    /**
     * copie nom et prenom du remplaçant
     */
    private String phrCopieRemplace7Nom;


    /**
     * copie id du remplaçant
     */
    private Long phrCopieRemplace8Id;


    /**
     * copie nom et prenom du remplaçant
     */
    private String phrCopieRemplace8Nom;


    /**
     * copie id du remplaçant
     */
    private Long phrCopieRemplace9Id;


    /**
     * copie nom et prenom du remplaçant
     */
    private String phrCopieRemplace9Nom;


    /**
     * copie id du remplaçant
     */
    private Long phrCopieRemplace10Id;


    /**
     * copie nom et prenom du remplaçant
     */
    private String phrCopieRemplace10Nom;

}
