package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_habilitation")
public class CmmHabilitation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "hab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habId;

    /**
     * 10=da 11=cotation 12=bc 13=reception 14=retour 15=facture 16=avoir 17=note debit 18=frais 19=collecte 20=besoin 21=devis 22=BC 23=BL 24=retour 25=facture 26=avoir 27=note debit 28=chargement
     */
    @Column(name = "hab_nature")
    private Integer habNature = 0;

    /**
     * 0=mono signature 1=multi signature
     */
    @Column(name = "hab_mode")
    private Integer habMode = 0;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user1_cat")
    private Integer habUser1Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user1_id")
    private Long habUser1Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user1_nom")
    private String habUser1Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user2_cat")
    private Integer habUser2Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user2_id")
    private Long habUser2Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user2_nom")
    private String habUser2Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user3_cat")
    private Integer habUser3Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user3_id")
    private Long habUser3Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user3_nom")
    private String habUser3Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user4_cat")
    private Integer habUser4Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user4_id")
    private Long habUser4Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user4_nom")
    private String habUser4Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user5_cat")
    private Integer habUser5Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user5_id")
    private Long habUser5Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user5_nom")
    private String habUser5Nom;

    /**
     * categorie 0=non actif 1=actif non obligatoire 2=actif obligatoire 3=remplacant
     */
    @Column(name = "hab_user6_cat")
    private Integer habUser6Cat = 0;

    /**
     * id user
     */
    @Column(name = "hab_user6_id")
    private Long habUser6Id = 0L;

    /**
     * nom et prenom user
     */
    @Column(name = "hab_user6_nom")
    private String habUser6Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace1_id")
    private Long habRemplace1Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace1_nom")
    private String habRemplace1Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace2_id")
    private Long habRemplace2Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace2_nom")
    private String habRemplace2Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace3_id")
    private Long habRemplace3Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace3_nom")
    private String habRemplace3Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace4_id")
    private Long habRemplace4Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace4_nom")
    private String habRemplace4Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace5_id")
    private Long habRemplace5Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace5_nom")
    private String habRemplace5Nom;

    /**
     * id remplacant
     */
    @Column(name = "hab_remplace6_id")
    private Long habRemplace6Id = 0L;

    /**
     * nom et prenom remplacant
     */
    @Column(name = "hab_remplace6_nom")
    private String habRemplace6Nom;

}
