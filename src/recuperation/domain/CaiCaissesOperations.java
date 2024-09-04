package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_caisses_operations")
public class CaiCaissesOperations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "caiope_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caiopeId;

    /**
     * date de creation
     */
    @Column(name = "caiope_date_creat")
    private LocalDateTime caiopeDateCreat;

    /**
     * date de modification
     */
    @Column(name = "caiope_date_modif")
    private LocalDateTime caiopeDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "caiope_user_creat")
    private Long caiopeUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "caiope_user_modif")
    private Long caiopeUserModif = 0L;

    /**
     * code caisse
     */
    @Column(name = "caiope_code")
    private String caiopeCode;

    /**
     * nom de la caisse
     */
    @Column(name = "caiope_nom")
    private String caiopeNom;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "caiope_inactif")
    private Integer caiopeInactif = 0;

    /**
     * 0=entrees 1=sorties
     */
    @Column(name = "caiope_type")
    private Integer caiopeType = 0;

    /**
     * 0=transferable 1=non transferable
     */
    @Column(name = "caiope_transfert")
    private Integer caiopeTransfert = 0;

    /**
     * 0=client 1=fournisseur 2=personnel 3=mouvement
     */
    @Column(name = "caiope_categorie")
    private Integer caiopeCategorie = 0;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

}
