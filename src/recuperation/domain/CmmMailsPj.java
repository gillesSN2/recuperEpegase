package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_mails_pj")
public class CmmMailsPj implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "maipj_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maipjId;

    /**
     * chemin acces a la pj
     */
    @Column(name = "malpj_acces")
    private String malpjAcces;

    @Column(name = "mai_id", nullable = false)
    private Long maiId;

}
