package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class PayBulletinMoisDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bulmenId;


    /**
     * numero feuille
     */
    private String bulmenFeuille;


    /**
     * periode MMAAAA
     */
    private String bulmenPeriode;


    /**
     * = concatenation bulmen_feuille : bulmen_periode
     */
    private String bulmenCle1;


    /**
     * 0=en cours 1=saisie mensuelle 2=generation 3=cloture 4=transfert
     */
    private Integer bulmenEtat;


    /**
     * user utilisation journal
     */
    private Long bulmenUserIdJournal;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer bulmenOpenJournal;


    /**
     * nom utilisateur en cours
     */
    private String bulmenOpenUserJournal;


    /**
     * user utilisation journal
     */
    private Long bulmenUserIdGeneration;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer bulmenOpenGeneration;


    /**
     * nom utilisateur en cours
     */
    private String bulmenOpenUserGeneration;

    private Long exepayId;

}
