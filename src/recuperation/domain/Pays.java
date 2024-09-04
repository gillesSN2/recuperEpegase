package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pays")
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code", nullable = false)
    private String code;

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

    @Column(name = "devise")
    private String devise;

    @Column(name = "drapeau")
    private String drapeau;

    @Column(name = "fiscalite")
    private String fiscalite;

    @Column(name = "gestion", nullable = false)
    private Integer gestion;

    @Column(name = "indicatif")
    private String indicatif;

    @Column(name = "iso")
    private String iso;

    @Column(name = "langue")
    private String langue;

    @Column(name = "nationnalite")
    private String nationnalite;

    @Column(name = "nom")
    private String nom;

    @Column(name = "zone")
    private String zone;

}
