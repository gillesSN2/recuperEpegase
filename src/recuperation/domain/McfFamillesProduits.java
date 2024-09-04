package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "mcf_familles_produits")
public class McfFamillesProduits implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fammcf_i", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fammcfI;

    @Column(name = "fammcf_date_creation")
    private LocalDate fammcfDateCreation;

    @Column(name = "fammcf_date_modif")
    private LocalDate fammcfDateModif;

    @Column(name = "fammcf_user_creation")
    private Long fammcfUserCreation;

    @Column(name = "fammcf_user_modif")
    private Long fammcfUserModif;

    @Column(name = "fammcf_code")
    private String fammcfCode;

    @Column(name = "fammcf_libelle_fr")
    private String fammcfLibelleFr;

    @Column(name = "fammcf_libelle_uk")
    private String fammcfLibelleUk;

    @Column(name = "fammcf_libelle_sp")
    private String fammcfLibelleSp;

    @Column(name = "fammcf_taxe")
    private String fammcfTaxe;

    @Column(name = "fammcf_compte_local")
    private String fammcfCompteLocal;

    @Column(name = "fammcf_compte_zone")
    private String fammcfCompteZone;

    @Column(name = "fammcf_compte_exterieur")
    private String fammcfCompteExterieur;

    @Column(name = "fammcf_nature")
    private Integer fammcfNature;

    @Column(name = "fammcf_lib_nature")
    private String fammcfLibNature;

    @Column(name = "fammcf_inactif")
    private Integer fammcfInactif;

    @Column(name = "exemcf_id", nullable = false)
    private Long exemcfId;

}
