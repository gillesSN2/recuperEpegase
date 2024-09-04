package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "structures")
public class Structures implements Serializable {

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

    @Column(name = "activite_entreprise")
    private String activiteEntreprise;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "batiment")
    private String batiment;

    @Column(name = "capitale")
    private BigDecimal capitale;

    @Column(name = "cedex")
    private String cedex;

    @Column(name = "code_iso")
    private String codeIso;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "commune")
    private String commune;

    @Column(name = "date_fiscale")
    private LocalDateTime dateFiscale;

    @Column(name = "departement")
    private String departement;

    @Column(name = "description")
    private String description;

    @Column(name = "devise")
    private String devise;

    @Column(name = "escalier")
    private String escalier;

    @Column(name = "fax")
    private String fax;

    @Column(name = "fax1")
    private String fax1;

    @Column(name = "fax2")
    private String fax2;

    @Column(name = "forme_juridique")
    private String formeJuridique;

    @Column(name = "ilot_number")
    private String ilotNumber;

    @Column(name = "impm01")
    private String impm01;

    @Column(name = "impm02")
    private String impm02;

    @Column(name = "impm03")
    private String impm03;

    @Column(name = "impm04")
    private String impm04;

    @Column(name = "impm05")
    private String impm05;

    @Column(name = "impm06")
    private String impm06;

    @Column(name = "impm07")
    private String impm07;

    @Column(name = "impm08")
    private String impm08;

    @Column(name = "impm09")
    private String impm09;

    @Column(name = "impm10")
    private String impm10;

    @Column(name = "impm11")
    private String impm11;

    @Column(name = "impm12")
    private String impm12;

    @Column(name = "impm13")
    private String impm13;

    @Column(name = "impm14")
    private String impm14;

    @Column(name = "impm15")
    private String impm15;

    @Column(name = "impm16")
    private String impm16;

    @Column(name = "impm17")
    private String impm17;

    @Column(name = "impm18")
    private String impm18;

    @Column(name = "impm19")
    private String impm19;

    @Column(name = "impm20")
    private String impm20;

    @Column(name = "langue")
    private String langue;

    @Column(name = "lot_number")
    private String lotNumber;

    @Column(name = "num_retraite_multiple")
    private Integer numRetraiteMultiple;

    @Column(name = "pays")
    private String pays;

    @Column(name = "porte_number")
    private String porteNumber;

    @Column(name = "quartier")
    private String quartier;

    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "rue_number")
    private String rueNumber;

    @Column(name = "sigle")
    private String sigle;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "telephone1")
    private String telephone1;

    @Column(name = "telephone2")
    private String telephone2;

    @Column(name = "telephone3")
    private String telephone3;

    @Column(name = "telephone4")
    private String telephone4;

    @Column(name = "type_entreprise")
    private String typeEntreprise;

    @Column(name = "ville")
    private String ville;

    @Column(name = "zone")
    private String zone;

    @Column(name = "zone_commerciale")
    private String zoneCommerciale;

    @Column(name = "zone_fiscal_principale")
    private String zoneFiscalPrincipale;

    @Column(name = "zone_fiscal_secondaire")
    private String zoneFiscalSecondaire;

}
