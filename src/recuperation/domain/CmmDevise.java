package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_devise")
public class CmmDevise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dev_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer devId;

    /**
     * code devise
     */
    @Column(name = "dev_code")
    private String devCode;

    /**
     * libelle devise
     */
    @Column(name = "dev_libelle")
    private String devLibelle;

    /**
     * format devise
     */
    @Column(name = "dev_format")
    private String devFormat;

    /**
     * taux 1
     */
    @Column(name = "dev_taux1")
    private Float devTaux1 = 0F;

    /**
     * taux 2
     */
    @Column(name = "dev_taux2")
    private Float devTaux2 = 0F;

    @Column(name = "str_id")
    private Long strId;

}
