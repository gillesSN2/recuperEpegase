package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MedHospitalisationSejourDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long hossejId;


    /**
     * id medecin
     */
    private Long hossejIdMedecin;


    /**
     * nom medecin
     */
    private String hossejMedecin;


    /**
     * service
     */
    private String hossejService;


    /**
     * code lit
     */
    private String hossejLit;


    /**
     * libelle produit
     */
    private String hossejLibelle;


    /**
     * date entree
     */
    private LocalDate hossejDateEntree;


    /**
     * date sortie
     */
    private LocalDate hossejDateSortie;


    /**
     * nombre de jour
     */
    private Integer hossejNbJour;


    /**
     * motid entree fichier xml
     */
    private String hossejMotifEntree;


    /**
     * provenance
     */
    private String hossejProvenance;


    /**
     * motid sortie fichier xml
     */
    private String hossejMotifSortie;


    /**
     * destination
     */
    private String hossejDestination;


    /**
     * prix unitaire
     */
    private Double hossejPu;


    /**
     * code de tva
     */
    private String hossejCodeTva;


    /**
     * taux de tva
     */
    private Float hossejTauxTva;


    /**
     * %remise
     */
    private Float hossejRemise;


    /**
     * prix apres remise
     */
    private Double hossejPuRem;


    /**
     * quantite
     */
    private Float hossejQte;


    /**
     * part ht patient
     */
    private Double hossejPatientHt;


    /**
     * part taxe patient
     */
    private Double hossejPatientTaxe;


    /**
     * part ht societe
     */
    private Double hossejSocieteHt;


    /**
     * part taxe societe
     */
    private Double hossejSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double hossejAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double hossejAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double hossejComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double hossejComplementaireTaxe;


    /**
     * total ht
     */
    private Double hossejTotal;


    /**
     * total taxe
     */
    private Double hossejTaxe;


    /**
     * code diagnostic principal
     */
    private String hossejCodeDiag1;


    /**
     * code diagnostic relie
     */
    private String hossejCodeDiag2;


    /**
     * code diagnostic associe 1
     */
    private String hossejCodeDiag11;


    /**
     * code diagnostic associe 2
     */
    private String hossejCodeDiag12;


    /**
     * code diagnostic associe 3
     */
    private String hossejCodeDiag13;


    /**
     * code diagnostic associe 4
     */
    private String hossejCodeDiag14;


    /**
     * code diagnostic associe 5
     */
    private String hossejCodeDiag15;


    /**
     * poids entree pour les nourissons en gramme
     */
    private Integer hossejPoidsEntree;


    /**
     * indice de gravite isg
     */
    private Integer hossejIndiceIgs;


    /**
     * nombre de seances
     */
    private Integer hossejNbSeances;


    /**
     * true si hospit30 jours avant
     */
    private Boolean hossejHospitAvant;


    /**
     * true si duree moins de 48 heures
     */
    private Boolean hossejHospit48;


    /**
     * evolution
     */
    private String hossejEvolution;


    /**
     * observation
     */
    private String hossejObservation;

    private Long hosId;

}
