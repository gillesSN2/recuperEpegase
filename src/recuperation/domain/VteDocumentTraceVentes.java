package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_document_trace_ventes")
public class VteDocumentTraceVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "doctra_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctraId;

    /**
     * date de creation
     */
    @Column(name = "doctra_date_creat")
    private LocalDateTime doctraDateCreat;

    /**
     * utilisateur de creation
     */
    @Column(name = "doctra_user_id")
    private Long doctraUserId = 0L;

    /**
     * nom utilisateur de creation
     */
    @Column(name = "doctra_user_nom")
    private String doctraUserNom;

    /**
     * type origine
     */
    @Column(name = "doctra_org_type")
    private Integer doctraOrgType = 0;

    /**
     * numero origine
     */
    @Column(name = "doctra_org_num")
    private String doctraOrgNum;

    /**
     * date origine
     */
    @Column(name = "doctra_org_date")
    private LocalDateTime doctraOrgDate;

    /**
     * serie origine
     */
    @Column(name = "doctra_org_serie")
    private String doctraOrgSerie;

    /**
     * id origine
     */
    @Column(name = "doctra_org_id")
    private Long doctraOrgId = 0L;

    /**
     * type destination
     */
    @Column(name = "doctra_dst_type")
    private Integer doctraDstType = 0;

    /**
     * numero destination
     */
    @Column(name = "doctra_dst_num")
    private String doctraDstNum;

    /**
     * date destination
     */
    @Column(name = "doctra_dst_date")
    private LocalDateTime doctraDstDate;

    /**
     * serie destination
     */
    @Column(name = "doctra_dst_serie")
    private String doctraDstSerie;

    /**
     * id destination
     */
    @Column(name = "doctra_dst_id")
    private Long doctraDstId = 0L;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

}
