package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tiers")
public class Tiers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "tieid", nullable = false)
    private Long tieid;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tietec_adresse")
    private String tietecAdresse;

    @Column(name = "tietec_etat")
    private Integer tietecEtat = 0;

    @Column(name = "tietec_login")
    private String tietecLogin;

    @Column(name = "tietec_ps")
    private String tietecPs;

    @Column(name = "tietec_service")
    private String tietecService;

    @Column(name = "tietec_type")
    private Integer tietecType = 0;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

}
