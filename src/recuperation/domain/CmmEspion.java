package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_espion")
public class CmmEspion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "esp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long espId;

    /**
     * date de creation
     */
    @Column(name = "esp_dte_creat")
    private LocalDateTime espDteCreat;

    /**
     * action realisee
     */
    @Column(name = "esp_action")
    private String espAction;

    /**
     * 0=espion 1=log
     */
    @Column(name = "esp_type")
    private Integer espType = 0;

    @Column(name = "usr_id", nullable = false)
    private Long usrId;

}
