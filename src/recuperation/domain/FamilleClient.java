package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "famille_client")
public class FamilleClient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "exonaration_douane", nullable = false)
    private Boolean exonarationDouane;

    @Column(name = "exonaration_taxe", nullable = false)
    private Boolean exonarationTaxe;

    @Column(name = "libelle")
    private String libelle;

}
