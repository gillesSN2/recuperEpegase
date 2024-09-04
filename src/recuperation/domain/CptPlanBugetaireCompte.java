package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_plan_bugetaire_compte")
public class CptPlanBugetaireCompte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "plbcpt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plbcptId;

    /**
     * code budgetaire
     */
    @Column(name = "plbcpt_code")
    private String plbcptCode;

    /**
     * 1=vente 2=achat 3=production 4=frais generaux 5=investissement 6=tva 7=frais personnel
     */
    @Column(name = "plbcpt_nature")
    private String plbcptNature;

    /**
     * 0=plan comptable 1=produit
     */
    @Column(name = "plbcpt_type")
    private Integer plbcptType = 0;

    /**
     * numero de compte
     */
    @Column(name = "plbcpt_compte")
    private String plbcptCompte;

    /**
     * libelle compte
     */
    @Column(name = "plbcpt_libelle_FR")
    private String plbcptLibelleFr;

    /**
     * libelle compte
     */
    @Column(name = "plbcpt_libelle_UK")
    private String plbcptLibelleUk;

    /**
     * libelle compte
     */
    @Column(name = "plbcpt_libelle_SP")
    private String plbcptLibelleSp;

    @Column(name = "plb_id", nullable = false)
    private Long plbId;

}
