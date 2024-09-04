package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_salaries_missions")
public class PaySalariesMissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salmis_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salmisId;

    /**
     * code devise
     */
    @Column(name = "salmis_devise")
    private String salmisDevise;

    /**
     * montant du visa
     */
    @Column(name = "salmis_visa")
    private Double salmisVisa = 0D;

    /**
     * total titre de transport
     */
    @Column(name = "salmis_titre_transport")
    private Double salmisTitreTransport = 0D;

    /**
     * 0=route 1=train 2=avion 3=bateau
     */
    @Column(name = "salmis_type_transport")
    private Integer salmisTypeTransport = 0;

    /**
     * deplacement domicile = aeroport, port, gare
     */
    @Column(name = "salmis_deplacement1")
    private Double salmisDeplacement1 = 0D;

    /**
     * deplacement aeroport, port, gare = domicile
     */
    @Column(name = "salmis_deplacement2")
    private Double salmisDeplacement2 = 0D;

    /**
     * reservation hotel
     */
    @Column(name = "salmis_resa_hotel")
    private Boolean salmisResaHotel = Boolean.FALSE;

    /**
     * nom hotel
     */
    @Column(name = "salmis_nom_hotel")
    private String salmisNomHotel;

    /**
     * mail hotel
     */
    @Column(name = "salmis_mail_hotel")
    private String salmisMailHotel;

    /**
     * telephone hotel
     */
    @Column(name = "salmis_tel_hotel")
    private String salmisTelHotel;

    /**
     * chambre hotel
     */
    @Column(name = "salmis_chambre_hotel")
    private String salmisChambreHotel;

    /**
     * observations
     */
    @Column(name = "salmis_obs")
    private String salmisObs;

    /**
     * total perdiem theorique
     */
    @Column(name = "salmis_perdiem_theo")
    private Double salmisPerdiemTheo = 0D;

    /**
     * total perdiem reel
     */
    @Column(name = "salmis_perdiem_reel")
    private Double salmisPerdiemReel = 0D;

    /**
     * total restauration
     */
    @Column(name = "salmis_restauration")
    private Double salmisRestauration = 0D;

    /**
     * total hebergement
     */
    @Column(name = "salmis_hebergement")
    private Double salmisHebergement = 0D;

    /**
     * total autres frais
     */
    @Column(name = "salmis_autres_frais")
    private Double salmisAutresFrais = 0D;

    /**
     * acompte
     */
    @Column(name = "salmis_acompte")
    private Double salmisAcompte = 0D;

    /**
     * liste des accompagnants
     */
    @Column(name = "salmis_accompagnant")
    private String salmisAccompagnant;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "mis_id", nullable = false)
    private Long misId;

}
