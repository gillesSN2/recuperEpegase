package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "activated", nullable = false)
    private Boolean activated;

    @Column(name = "activation_key")
    private String activationKey;

    @Column(name = "civilite")
    private String civilite;

    @Column(name = "email")
    private String email;

    @Column(name = "fonction")
    private String fonction;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "lang_key")
    private String langKey;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "nom")
    private String nom;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "reset_date")
    private LocalDateTime resetDate;

    @Column(name = "reset_key")
    private String resetKey;

    @Column(name = "structure_id")
    private Long structureId;

    @Column(name = "groupes_id")
    private Long groupesId;

}
