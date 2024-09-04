package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_marques")
public class CmmMarques implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marId;

    /**
     * date de creation
     */
    @Column(name = "mar_date_creation")
    private LocalDateTime marDateCreation;

    /**
     * date de modification
     */
    @Column(name = "mar_date_modif")
    private LocalDateTime marDateModif;

    /**
     * user de creation
     */
    @Column(name = "mar_user_creation")
    private Long marUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "mar_user_modif")
    private Long marUserModif = 0L;

    /**
     * libelle FR
     */
    @Column(name = "mar_libelle_fr")
    private String marLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "mar_libelle_uk")
    private String marLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "mar_libelle_sp")
    private String marLibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "mar_inactif")
    private Integer marInactif = 0;

    /**
     * photos du produits
     */
    @Column(name = "mar_photo")
    private String marPhoto;

    /**
     * fichier pdf
     */
    @Column(name = "mar_pdf")
    private String marPdf;

}
