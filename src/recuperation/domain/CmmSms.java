package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_sms")
public class CmmSms implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sms_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long smsId;

    /**
     * date envoi sms
     */
    @Column(name = "sms_date")
    private LocalDateTime smsDate;

    /**
     * numero campagne sms
     */
    @Column(name = "sms_num")
    private String smsNum;

    /**
     * texte du sms
     */
    @Column(name = "sms_texte")
    private String smsTexte;

    /**
     * status du sms
     */
    @Column(name = "sms_status")
    private String smsStatus;

    /**
     * mobile du contact
     */
    @Column(name = "sms_mobile")
    private String smsMobile;

    /**
     * nom du contact
     */
    @Column(name = "sms_nom_contact")
    private String smsNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "sms_civilite_contzct")
    private String smsCiviliteContzct;

    /**
     * id du contact
     */
    @Column(name = "sms_id_contact")
    private Long smsIdContact = 0L;

    /**
     * type du tiers 0=tiers 1=agents 2=salaries 4=patients 5=eleves 90=achats sms 99=sms initial
     */
    @Column(name = "sms_type_tiers")
    private Integer smsTypeTiers = 0;

    /**
     * nom du tiers
     */
    @Column(name = "sms_nom_tiers")
    private String smsNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "sms_id_tiers")
    private Long smsIdTiers = 0L;

    /**
     * qte operation
     */
    @Column(name = "sms_qte")
    private Integer smsQte = 0;

    @Column(name = "usr_id")
    private Long usrId;

}
