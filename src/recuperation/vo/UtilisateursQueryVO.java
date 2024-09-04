package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UtilisateursQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private Boolean activated;

    private String activationKey;

    private String civilite;

    private String email;

    private String fonction;

    private String imageUrl;

    private String langKey;

    private String login;

    private String nom;

    private String passwordHash;

    private String prenom;

    private LocalDateTime resetDate;

    private String resetKey;

    private Long structureId;

    private Long groupesId;

}
