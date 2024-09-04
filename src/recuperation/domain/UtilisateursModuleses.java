package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "utilisateurs_moduleses")
public class UtilisateursModuleses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "utilisateur_id", nullable = false)
    private Long utilisateurId;

    @Id
    @Column(name = "moduleses_code", nullable = false)
    private String modulesesCode;

}
