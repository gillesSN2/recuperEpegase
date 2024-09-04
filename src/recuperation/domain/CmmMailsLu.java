package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_mails_lu")
public class CmmMailsLu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mailu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mailuId;

    /**
     * date de lecture
     */
    @Column(name = "mallu_date_lecture")
    private LocalDateTime malluDateLecture;

    /**
     * anotation user
     */
    @Column(name = "mallu_note")
    private String malluNote;

    /**
     * nom et prenom user
     */
    @Column(name = "mallu_user")
    private String malluUser;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

    @Column(name = "mai_id", nullable = false)
    private Long maiId;

}
