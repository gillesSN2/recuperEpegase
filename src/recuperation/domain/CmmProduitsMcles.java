package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_mcles")
public class CmmProduitsMcles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "promcl_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promclId;

    /**
     * mot cle
     */
    @Column(name = "promcl_mot")
    private String promclMot;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

}
