package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "user_fonctionnalite_droit")
public class UserFonctionnaliteDroit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "creation")
    private Boolean creation;

    @Column(name = "edition")
    private Boolean edition;

    @Column(name = "impression")
    private Boolean impression;

    @Column(name = "lecture")
    private Boolean lecture;

    @Column(name = "structure_id")
    private Long structureId;

    @Column(name = "suppression")
    private Boolean suppression;

    @Column(name = "transfert_comptabilite")
    private Boolean transfertComptabilite;

    @Id
    @Column(name = "fonctionnalite_code", nullable = false)
    private String fonctionnaliteCode;

    @Id
    @Column(name = "utilisateur_id", nullable = false)
    private Long utilisateurId;

}
