package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_parapheur")
public class CmmParapheur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phrId;

    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "phr_nature")
    private Integer phrNature = 0;

    /**
     * 10=da 11=cotation 12=commande 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "phr_nature_origine")
    private Integer phrNatureOrigine = 0;

    /**
     * montant du bon encaissement
     */
    @Column(name = "phr_montant")
    private Double phrMontant = 0D;

    /**
     * 0=mono signature 1=multi signature
     */
    @Column(name = "phr_mode")
    private Integer phrMode = 0;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user1_cat")
    private Integer phrUser1Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user1_id")
    private Long phrUser1Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user1_nom")
    private String phrUser1Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user2_cat")
    private Integer phrUser2Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user2_id")
    private Long phrUser2Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user2_nom")
    private String phrUser2Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user3_cat")
    private Integer phrUser3Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user3_id")
    private Long phrUser3Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user3_nom")
    private String phrUser3Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user4_cat")
    private Integer phrUser4Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user4_id")
    private Long phrUser4Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user4_nom")
    private String phrUser4Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user5_cat")
    private Integer phrUser5Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user5_id")
    private Long phrUser5Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user5_nom")
    private String phrUser5Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user6_cat")
    private Integer phrUser6Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user6_id")
    private Long phrUser6Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user6_nom")
    private String phrUser6Nom;

    /**
     * id du document
     */
    @Column(name = "phr_doc_id")
    private Long phrDocId = 0L;

    /**
     * numero du document
     */
    @Column(name = "phr_num")
    private String phrNum;

    /**
     * date du document
     */
    @Column(name = "phr_date")
    private LocalDate phrDate;

    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user1_etat")
    private Integer phrUser1Etat = 0;

    /**
     * date reponse du user 1
     */
    @Column(name = "phr_user1_dte_rep")
    private LocalDate phrUser1DteRep;

    /**
     * explications du user 1
     */
    @Column(name = "phr_user1_explication")
    private String phrUser1Explication;

    /**
     * reponse user 2 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user2_etat")
    private Integer phrUser2Etat = 0;

    /**
     * date reponse du user 2
     */
    @Column(name = "phr_user2_dte_rep")
    private LocalDate phrUser2DteRep;

    /**
     * explications du user 2
     */
    @Column(name = "phr_user2_explication")
    private String phrUser2Explication;

    /**
     * reponse user 3 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user3_etat")
    private Integer phrUser3Etat = 0;

    /**
     * date reponse du user 3
     */
    @Column(name = "phr_user3_dte_rep")
    private LocalDate phrUser3DteRep;

    /**
     * explications du user 3
     */
    @Column(name = "phr_user3_explication")
    private String phrUser3Explication;

    /**
     * reponse user 4 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user4_etat")
    private Integer phrUser4Etat = 0;

    /**
     * date reponse du user 4
     */
    @Column(name = "phr_user4_dte_rep")
    private LocalDate phrUser4DteRep;

    /**
     * explications du user 4
     */
    @Column(name = "phr_user4_explication")
    private String phrUser4Explication;

    /**
     * reponse user 5 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user5_etat")
    private Integer phrUser5Etat = 0;

    /**
     * date reponse du user 5
     */
    @Column(name = "phr_user5_dte_rep")
    private LocalDate phrUser5DteRep;

    /**
     * explications du user 5
     */
    @Column(name = "phr_user5_explication")
    private String phrUser5Explication;

    /**
     * reponse user 6 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user6_etat")
    private Integer phrUser6Etat = 0;

    /**
     * date reponse du user 6
     */
    @Column(name = "phr_user6_dte_rep")
    private LocalDate phrUser6DteRep;

    /**
     * explications du user 6
     */
    @Column(name = "phr_user6_explication")
    private String phrUser6Explication;

    /**
     * final 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_etat")
    private Integer phrEtat = 0;

    /**
     * date du changement d etat final
     */
    @Column(name = "phr_date_etat")
    private LocalDate phrDateEtat;

    /**
     * explications finales du gel ou de annulation
     */
    @Column(name = "phr_explication")
    private String phrExplication;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace1_id")
    private Long phrRemplace1Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace1_nom")
    private String phrRemplace1Nom;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace2_id")
    private Long phrRemplace2Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace2_nom")
    private String phrRemplace2Nom;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace3_id")
    private Long phrRemplace3Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace3_nom")
    private String phrRemplace3Nom;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace4_id")
    private Long phrRemplace4Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace4_nom")
    private String phrRemplace4Nom;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace5_id")
    private Long phrRemplace5Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace5_nom")
    private String phrRemplace5Nom;

    /**
     * id remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace6_id")
    private Long phrRemplace6Id = 0L;

    /**
     * nom et prenom remplaÃƒÂ§ant
     */
    @Column(name = "phr_remplace6_nom")
    private String phrRemplace6Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire1_id")
    private Long phrProprietaire1Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire1_nom")
    private String phrPropritaire1Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire2_id")
    private Long phrProprietaire2Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire2_nom")
    private String phrPropritaire2Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire3_id")
    private Long phrProprietaire3Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire3_nom")
    private String phrPropritaire3Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire4_id")
    private Long phrProprietaire4Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire4_nom")
    private String phrPropritaire4Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire5_id")
    private Long phrProprietaire5Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire5_nom")
    private String phrPropritaire5Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire6_id")
    private Long phrProprietaire6Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire6_nom")
    private String phrPropritaire6Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace1_id")
    private Long phrCopieRemplace1Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace1_nom")
    private String phrCopieRemplace1Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace2_id")
    private Long phrCopieRemplace2Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace2_nom")
    private String phrCopieRemplace2Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace3_id")
    private Long phrCopieRemplace3Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace3_nom")
    private String phrCopieRemplace3Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace4_id")
    private Long phrCopieRemplace4Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace4_nom")
    private String phrCopieRemplace4Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace5_id")
    private Long phrCopieRemplace5Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace5_nom")
    private String phrCopieRemplace5Nom;

    /**
     * copie id du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace6_id")
    private Long phrCopieRemplace6Id = 0L;

    /**
     * copie nom et prenom du remplaÃƒÂ§ant
     */
    @Column(name = "phr_copie_remplace6_nom")
    private String phrCopieRemplace6Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user7_cat")
    private Integer phrUser7Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user7_id")
    private Long phrUser7Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user7_nom")
    private String phrUser7Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user8_cat")
    private Integer phrUser8Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user8_id")
    private Long phrUser8Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user8_nom")
    private String phrUser8Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user9_cat")
    private Integer phrUser9Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user9_id")
    private Long phrUser9Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user9_nom")
    private String phrUser9Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "phr_user10_cat")
    private Integer phrUser10Cat = 0;

    /**
     * id user
     */
    @Column(name = "phr_user10_id")
    private Long phrUser10Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "phr_user10_nom")
    private String phrUser10Nom;

    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user7_etat")
    private Integer phrUser7Etat = 0;

    /**
     * date reponse du user 1
     */
    @Column(name = "phr_user7_dte_rep")
    private LocalDate phrUser7DteRep;

    /**
     * explications du user 1
     */
    @Column(name = "phr_user7_explication")
    private String phrUser7Explication;

    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user8_etat")
    private Integer phrUser8Etat = 0;

    /**
     * date reponse du user 1
     */
    @Column(name = "phr_user8_dte_rep")
    private LocalDate phrUser8DteRep;

    /**
     * explications du user 1
     */
    @Column(name = "phr_user8_explication")
    private String phrUser8Explication;

    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user9_etat")
    private Integer phrUser9Etat = 0;

    /**
     * date reponse du user 1
     */
    @Column(name = "phr_user9_dte_rep")
    private LocalDate phrUser9DteRep;

    /**
     * explications du user 1
     */
    @Column(name = "phr_user9_explication")
    private String phrUser9Explication;

    /**
     * reponse user 1 0=en cours 1=valide 2=gele 3=annule
     */
    @Column(name = "phr_user10_etat")
    private Integer phrUser10Etat = 0;

    /**
     * date reponse du user 1
     */
    @Column(name = "phr_user10_dte_rep")
    private LocalDate phrUser10DteRep;

    /**
     * explications du user 1
     */
    @Column(name = "phr_user10_explication")
    private String phrUser10Explication;

    /**
     * id remplaçant
     */
    @Column(name = "phr_remplace7_id")
    private Long phrRemplace7Id = 0L;

    /**
     * nom et prenom remplaçant
     */
    @Column(name = "phr_remplace7_nom")
    private String phrRemplace7Nom;

    /**
     * id remplaçant
     */
    @Column(name = "phr_remplace8_id")
    private Long phrRemplace8Id = 0L;

    /**
     * nom et prenom remplaçant
     */
    @Column(name = "phr_remplace8_nom")
    private String phrRemplace8Nom;

    /**
     * id remplaçant
     */
    @Column(name = "phr_remplace9_id")
    private Long phrRemplace9Id = 0L;

    /**
     * nom et prenom remplaçant
     */
    @Column(name = "phr_remplace9_nom")
    private String phrRemplace9Nom;

    /**
     * id remplaçant
     */
    @Column(name = "phr_remplace10_id")
    private Long phrRemplace10Id = 0L;

    /**
     * nom et prenom remplaçant
     */
    @Column(name = "phr_remplace10_nom")
    private String phrRemplace10Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire7_id")
    private Long phrProprietaire7Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire7_nom")
    private String phrPropritaire7Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire8_id")
    private Long phrProprietaire8Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire8_nom")
    private String phrPropritaire8Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire9_id")
    private Long phrProprietaire9Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire9_nom")
    private String phrPropritaire9Nom;

    /**
     * id user proprietaire
     */
    @Column(name = "phr_proprietaire10_id")
    private Long phrProprietaire10Id = 0L;

    /**
     * nom et prenom propritaire
     */
    @Column(name = "phr_propritaire10_nom")
    private String phrPropritaire10Nom;

    /**
     * copie id du remplaçant
     */
    @Column(name = "phr_copie_remplace7_id")
    private Long phrCopieRemplace7Id = 0L;

    /**
     * copie nom et prenom du remplaçant
     */
    @Column(name = "phr_copie_remplace7_nom")
    private String phrCopieRemplace7Nom;

    /**
     * copie id du remplaçant
     */
    @Column(name = "phr_copie_remplace8_id")
    private Long phrCopieRemplace8Id = 0L;

    /**
     * copie nom et prenom du remplaçant
     */
    @Column(name = "phr_copie_remplace8_nom")
    private String phrCopieRemplace8Nom;

    /**
     * copie id du remplaçant
     */
    @Column(name = "phr_copie_remplace9_id")
    private Long phrCopieRemplace9Id = 0L;

    /**
     * copie nom et prenom du remplaçant
     */
    @Column(name = "phr_copie_remplace9_nom")
    private String phrCopieRemplace9Nom;

    /**
     * copie id du remplaçant
     */
    @Column(name = "phr_copie_remplace10_id")
    private Long phrCopieRemplace10Id = 0L;

    /**
     * copie nom et prenom du remplaçant
     */
    @Column(name = "phr_copie_remplace10_nom")
    private String phrCopieRemplace10Nom;

}
