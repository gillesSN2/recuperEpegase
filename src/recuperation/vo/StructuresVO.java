package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class StructuresVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "createdBy can not null")
    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String activiteEntreprise;

    private String adresse;

    private String batiment;

    private BigDecimal capitale;

    private String cedex;

    private String codeIso;

    private String codePostal;

    private String commune;

    private LocalDateTime dateFiscale;

    private String departement;

    private String description;

    private String devise;

    private String escalier;

    private String fax;

    private String fax1;

    private String fax2;

    private String formeJuridique;

    private String ilotNumber;

    private String impm01;

    private String impm02;

    private String impm03;

    private String impm04;

    private String impm05;

    private String impm06;

    private String impm07;

    private String impm08;

    private String impm09;

    private String impm10;

    private String impm11;

    private String impm12;

    private String impm13;

    private String impm14;

    private String impm15;

    private String impm16;

    private String impm17;

    private String impm18;

    private String impm19;

    private String impm20;

    private String langue;

    private String lotNumber;

    private Integer numRetraiteMultiple;

    private String pays;

    private String porteNumber;

    private String quartier;

    private String raisonSociale;

    private String responsable;

    private String rueNumber;

    private String sigle;

    private String telephone;

    private String telephone1;

    private String telephone2;

    private String telephone3;

    private String telephone4;

    private String typeEntreprise;

    private String ville;

    private String zone;

    private String zoneCommerciale;

    private String zoneFiscalPrincipale;

    private String zoneFiscalSecondaire;

}
