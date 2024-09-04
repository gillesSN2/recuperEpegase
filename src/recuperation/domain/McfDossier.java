package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "mcf_dossier")
public class McfDossier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dos_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dosId;

    @Column(name = "dos_date_demande")
    private LocalDate dosDateDemande;

    @Column(name = "dos_date_reception")
    private LocalDate dosDateReception;

    @Column(name = "dos_date_acceptation")
    private LocalDate dosDateAcceptation;

    @Column(name = "dos_date_refus")
    private LocalDate dosDateRefus;

    @Column(name = "dos_motif_refus")
    private String dosMotifRefus;

    @Column(name = "dos_type")
    private Integer dosType;

    @Column(name = "dos_date_cloture")
    private LocalDate dosDateCloture;

    @Column(name = "dos_motif_cloture")
    private String dosMotifCloture;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

}
