package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ConsultationInfirmerie implements Serializable {
   private long cslaccId;
   private Date cslaccDateCreat;
   private Date cslaccDateModif;
   private long cslaccIdCreateur;
   private long cslaccIdModif;
   private int cslaccType;
   private int cslaccNbSalaries;
   private String cslaccAnciennete;
   private String cslaccHoraireDebut;
   private String cslaccHoraireFin;
   private Date cslaccDateDocument;
   private String cslaccSignataire;
   private Date cslaccDateAccident;
   private String cslaccLieuAccident;
   private String cslaccNatureLesion;
   private String cslaccSiegeLesion;
   private String cslaccCirconstance;
   private String cslaccCause;
   private String cslaccMateriel;
   private int cslaccSecurite;
   private String cslaccMedecin;
   private int cslaccSecours;
   private int cslaccSuite;
   private String cslaccTemoin;
   private String cslaccAdresseTemoin;
   private int cslaccRapportPolice;
   private String cslaccNomPolice;
   private String cslaccNomTiers;
   private String cslaccAdresseTiers;
   private String cslaccAssuranceTiers;
   private String cslaccNumTiers;
   private Date cslaccDatePaye;
   private String cslaccPeriodePaye;
   private double cslaccBrut;
   private double cslaccHSup;
   private double cslaccPrimes;
   private double cslaccRation;
   private double cslaccLogement;
   private double cslaccDivers;
   private double cslaccTotal;
   private boolean cslaccV1Dem;
   private boolean cslaccV2Dem;
   private boolean cslaccV3Dem;
   private boolean cslaccV4Dem;
   private boolean cslaccV5Dem;
   private boolean cslaccV6Dem;
   private boolean cslaccV7Dem;
   private boolean cslaccV8Dem;
   private boolean cslaccV9Dem;
   private boolean cslaccV10Dem;
   private boolean cslaccV1Rea;
   private boolean cslaccV2Rea;
   private boolean cslaccV3Rea;
   private boolean cslaccV4Rea;
   private boolean cslaccV5Rea;
   private boolean cslaccV6Rea;
   private boolean cslaccV7Rea;
   private boolean cslaccV8Rea;
   private boolean cslaccV9Rea;
   private boolean cslaccV10Rea;
   private String cslaccLot1;
   private String cslaccLot2;
   private String cslaccLot3;
   private String cslaccLot4;
   private String cslaccLot5;
   private String cslaccLot6;
   private String cslaccLot7;
   private String cslaccLot8;
   private String cslaccLot9;
   private String cslaccLot10;
   private Date cslaccDateRdv;
   private Date cslaccLotDte1;
   private Date cslaccLotDte2;
   private Date cslaccLotDte3;
   private Date cslaccLotDte4;
   private Date cslaccLotDte5;
   private Date cslaccLotDte6;
   private Date cslaccLotDte7;
   private Date cslaccLotDte8;
   private Date cslaccLotDte9;
   private Date cslaccLotDte10;
   private int cslaccApte;
   private int cslaccPositif;
   private int cslaccCertificat;
   private Date cslaccDateDu;
   private Date cslaccDateAu;
   private int cslaccNbJourRepos;
   private String cslaccMotifRepos;
   private ConsultationEnteteGene consultationEnteteGene;
   private String patSecu;
   private String patNom;
   private int patSexe;
   private String patAdresse;
   private String patTel1;
   private String patTel2;
   private String patMail;
   private String patNationnalite;
   private Date patDateEmbauche;
   private String patProfession;
   private String patPoste;
   private int patAnciennete;
   private String patConjoint;
   private String patConjointTel1;
   private String patConjointTel2;
   private String patNature;
   private String patCivilite;
   private String patMatricule;
   private Date patDateNaissance;
   private String patLieuNaissance;
   private String patService;
   private String patMedecin;

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public String getCslaccAdresseTemoin() {
      return this.cslaccAdresseTemoin;
   }

   public void setCslaccAdresseTemoin(String var1) {
      this.cslaccAdresseTemoin = var1;
   }

   public String getCslaccAdresseTiers() {
      return this.cslaccAdresseTiers;
   }

   public void setCslaccAdresseTiers(String var1) {
      this.cslaccAdresseTiers = var1;
   }

   public String getCslaccAssuranceTiers() {
      return this.cslaccAssuranceTiers;
   }

   public void setCslaccAssuranceTiers(String var1) {
      this.cslaccAssuranceTiers = var1;
   }

   public double getCslaccBrut() {
      return this.cslaccBrut;
   }

   public void setCslaccBrut(double var1) {
      this.cslaccBrut = var1;
   }

   public String getCslaccCause() {
      return this.cslaccCause;
   }

   public void setCslaccCause(String var1) {
      this.cslaccCause = var1;
   }

   public String getCslaccCirconstance() {
      return this.cslaccCirconstance;
   }

   public void setCslaccCirconstance(String var1) {
      this.cslaccCirconstance = var1;
   }

   public Date getCslaccDateAccident() {
      return this.cslaccDateAccident;
   }

   public void setCslaccDateAccident(Date var1) {
      this.cslaccDateAccident = var1;
   }

   public Date getCslaccDateDocument() {
      return this.cslaccDateDocument;
   }

   public void setCslaccDateDocument(Date var1) {
      this.cslaccDateDocument = var1;
   }

   public Date getCslaccDatePaye() {
      return this.cslaccDatePaye;
   }

   public void setCslaccDatePaye(Date var1) {
      this.cslaccDatePaye = var1;
   }

   public double getCslaccDivers() {
      return this.cslaccDivers;
   }

   public void setCslaccDivers(double var1) {
      this.cslaccDivers = var1;
   }

   public double getCslaccHSup() {
      return this.cslaccHSup;
   }

   public void setCslaccHSup(double var1) {
      this.cslaccHSup = var1;
   }

   public long getCslaccId() {
      return this.cslaccId;
   }

   public void setCslaccId(long var1) {
      this.cslaccId = var1;
   }

   public String getCslaccLieuAccident() {
      return this.cslaccLieuAccident;
   }

   public void setCslaccLieuAccident(String var1) {
      this.cslaccLieuAccident = var1;
   }

   public double getCslaccLogement() {
      return this.cslaccLogement;
   }

   public void setCslaccLogement(double var1) {
      this.cslaccLogement = var1;
   }

   public String getCslaccMateriel() {
      return this.cslaccMateriel;
   }

   public void setCslaccMateriel(String var1) {
      this.cslaccMateriel = var1;
   }

   public String getCslaccMedecin() {
      return this.cslaccMedecin;
   }

   public void setCslaccMedecin(String var1) {
      this.cslaccMedecin = var1;
   }

   public String getCslaccNatureLesion() {
      return this.cslaccNatureLesion;
   }

   public void setCslaccNatureLesion(String var1) {
      this.cslaccNatureLesion = var1;
   }

   public String getCslaccNomPolice() {
      return this.cslaccNomPolice;
   }

   public void setCslaccNomPolice(String var1) {
      this.cslaccNomPolice = var1;
   }

   public String getCslaccNomTiers() {
      return this.cslaccNomTiers;
   }

   public void setCslaccNomTiers(String var1) {
      this.cslaccNomTiers = var1;
   }

   public String getCslaccPeriodePaye() {
      return this.cslaccPeriodePaye;
   }

   public void setCslaccPeriodePaye(String var1) {
      this.cslaccPeriodePaye = var1;
   }

   public double getCslaccPrimes() {
      return this.cslaccPrimes;
   }

   public void setCslaccPrimes(double var1) {
      this.cslaccPrimes = var1;
   }

   public int getCslaccRapportPolice() {
      return this.cslaccRapportPolice;
   }

   public void setCslaccRapportPolice(int var1) {
      this.cslaccRapportPolice = var1;
   }

   public double getCslaccRation() {
      return this.cslaccRation;
   }

   public void setCslaccRation(double var1) {
      this.cslaccRation = var1;
   }

   public int getCslaccSecours() {
      return this.cslaccSecours;
   }

   public void setCslaccSecours(int var1) {
      this.cslaccSecours = var1;
   }

   public int getCslaccSecurite() {
      return this.cslaccSecurite;
   }

   public void setCslaccSecurite(int var1) {
      this.cslaccSecurite = var1;
   }

   public String getCslaccSiegeLesion() {
      return this.cslaccSiegeLesion;
   }

   public void setCslaccSiegeLesion(String var1) {
      this.cslaccSiegeLesion = var1;
   }

   public String getCslaccSignataire() {
      return this.cslaccSignataire;
   }

   public void setCslaccSignataire(String var1) {
      this.cslaccSignataire = var1;
   }

   public int getCslaccSuite() {
      return this.cslaccSuite;
   }

   public void setCslaccSuite(int var1) {
      this.cslaccSuite = var1;
   }

   public String getCslaccTemoin() {
      return this.cslaccTemoin;
   }

   public void setCslaccTemoin(String var1) {
      this.cslaccTemoin = var1;
   }

   public double getCslaccTotal() {
      return this.cslaccTotal;
   }

   public void setCslaccTotal(double var1) {
      this.cslaccTotal = var1;
   }

   public Date getCslaccDateCreat() {
      return this.cslaccDateCreat;
   }

   public void setCslaccDateCreat(Date var1) {
      this.cslaccDateCreat = var1;
   }

   public Date getCslaccDateModif() {
      return this.cslaccDateModif;
   }

   public void setCslaccDateModif(Date var1) {
      this.cslaccDateModif = var1;
   }

   public long getCslaccIdCreateur() {
      return this.cslaccIdCreateur;
   }

   public void setCslaccIdCreateur(long var1) {
      this.cslaccIdCreateur = var1;
   }

   public long getCslaccIdModif() {
      return this.cslaccIdModif;
   }

   public void setCslaccIdModif(long var1) {
      this.cslaccIdModif = var1;
   }

   public String getCslaccNumTiers() {
      return this.cslaccNumTiers;
   }

   public void setCslaccNumTiers(String var1) {
      this.cslaccNumTiers = var1;
   }

   public int getCslaccType() {
      return this.cslaccType;
   }

   public void setCslaccType(int var1) {
      this.cslaccType = var1;
   }

   public boolean isCslaccV10Dem() {
      return this.cslaccV10Dem;
   }

   public void setCslaccV10Dem(boolean var1) {
      this.cslaccV10Dem = var1;
   }

   public boolean isCslaccV10Rea() {
      return this.cslaccV10Rea;
   }

   public void setCslaccV10Rea(boolean var1) {
      this.cslaccV10Rea = var1;
   }

   public boolean isCslaccV1Dem() {
      return this.cslaccV1Dem;
   }

   public void setCslaccV1Dem(boolean var1) {
      this.cslaccV1Dem = var1;
   }

   public boolean isCslaccV1Rea() {
      return this.cslaccV1Rea;
   }

   public void setCslaccV1Rea(boolean var1) {
      this.cslaccV1Rea = var1;
   }

   public boolean isCslaccV2Dem() {
      return this.cslaccV2Dem;
   }

   public void setCslaccV2Dem(boolean var1) {
      this.cslaccV2Dem = var1;
   }

   public boolean isCslaccV2Rea() {
      return this.cslaccV2Rea;
   }

   public void setCslaccV2Rea(boolean var1) {
      this.cslaccV2Rea = var1;
   }

   public boolean isCslaccV3Dem() {
      return this.cslaccV3Dem;
   }

   public void setCslaccV3Dem(boolean var1) {
      this.cslaccV3Dem = var1;
   }

   public boolean isCslaccV3Rea() {
      return this.cslaccV3Rea;
   }

   public void setCslaccV3Rea(boolean var1) {
      this.cslaccV3Rea = var1;
   }

   public boolean isCslaccV4Dem() {
      return this.cslaccV4Dem;
   }

   public void setCslaccV4Dem(boolean var1) {
      this.cslaccV4Dem = var1;
   }

   public boolean isCslaccV4Rea() {
      return this.cslaccV4Rea;
   }

   public void setCslaccV4Rea(boolean var1) {
      this.cslaccV4Rea = var1;
   }

   public boolean isCslaccV5Dem() {
      return this.cslaccV5Dem;
   }

   public void setCslaccV5Dem(boolean var1) {
      this.cslaccV5Dem = var1;
   }

   public boolean isCslaccV5Rea() {
      return this.cslaccV5Rea;
   }

   public void setCslaccV5Rea(boolean var1) {
      this.cslaccV5Rea = var1;
   }

   public boolean isCslaccV6Dem() {
      return this.cslaccV6Dem;
   }

   public void setCslaccV6Dem(boolean var1) {
      this.cslaccV6Dem = var1;
   }

   public boolean isCslaccV6Rea() {
      return this.cslaccV6Rea;
   }

   public void setCslaccV6Rea(boolean var1) {
      this.cslaccV6Rea = var1;
   }

   public boolean isCslaccV7Dem() {
      return this.cslaccV7Dem;
   }

   public void setCslaccV7Dem(boolean var1) {
      this.cslaccV7Dem = var1;
   }

   public boolean isCslaccV7Rea() {
      return this.cslaccV7Rea;
   }

   public void setCslaccV7Rea(boolean var1) {
      this.cslaccV7Rea = var1;
   }

   public boolean isCslaccV8Dem() {
      return this.cslaccV8Dem;
   }

   public void setCslaccV8Dem(boolean var1) {
      this.cslaccV8Dem = var1;
   }

   public boolean isCslaccV8Rea() {
      return this.cslaccV8Rea;
   }

   public void setCslaccV8Rea(boolean var1) {
      this.cslaccV8Rea = var1;
   }

   public boolean isCslaccV9Dem() {
      return this.cslaccV9Dem;
   }

   public void setCslaccV9Dem(boolean var1) {
      this.cslaccV9Dem = var1;
   }

   public boolean isCslaccV9Rea() {
      return this.cslaccV9Rea;
   }

   public void setCslaccV9Rea(boolean var1) {
      this.cslaccV9Rea = var1;
   }

   public String getCslaccLot1() {
      return this.cslaccLot1;
   }

   public void setCslaccLot1(String var1) {
      this.cslaccLot1 = var1;
   }

   public String getCslaccLot10() {
      return this.cslaccLot10;
   }

   public void setCslaccLot10(String var1) {
      this.cslaccLot10 = var1;
   }

   public String getCslaccLot2() {
      return this.cslaccLot2;
   }

   public void setCslaccLot2(String var1) {
      this.cslaccLot2 = var1;
   }

   public String getCslaccLot3() {
      return this.cslaccLot3;
   }

   public void setCslaccLot3(String var1) {
      this.cslaccLot3 = var1;
   }

   public String getCslaccLot4() {
      return this.cslaccLot4;
   }

   public void setCslaccLot4(String var1) {
      this.cslaccLot4 = var1;
   }

   public String getCslaccLot5() {
      return this.cslaccLot5;
   }

   public void setCslaccLot5(String var1) {
      this.cslaccLot5 = var1;
   }

   public String getCslaccLot6() {
      return this.cslaccLot6;
   }

   public void setCslaccLot6(String var1) {
      this.cslaccLot6 = var1;
   }

   public String getCslaccLot7() {
      return this.cslaccLot7;
   }

   public void setCslaccLot7(String var1) {
      this.cslaccLot7 = var1;
   }

   public String getCslaccLot8() {
      return this.cslaccLot8;
   }

   public void setCslaccLot8(String var1) {
      this.cslaccLot8 = var1;
   }

   public String getCslaccLot9() {
      return this.cslaccLot9;
   }

   public void setCslaccLot9(String var1) {
      this.cslaccLot9 = var1;
   }

   public Date getCslaccDateRdv() {
      return this.cslaccDateRdv;
   }

   public void setCslaccDateRdv(Date var1) {
      this.cslaccDateRdv = var1;
   }

   public Date getCslaccLotDte1() {
      return this.cslaccLotDte1;
   }

   public void setCslaccLotDte1(Date var1) {
      this.cslaccLotDte1 = var1;
   }

   public Date getCslaccLotDte10() {
      return this.cslaccLotDte10;
   }

   public void setCslaccLotDte10(Date var1) {
      this.cslaccLotDte10 = var1;
   }

   public Date getCslaccLotDte2() {
      return this.cslaccLotDte2;
   }

   public void setCslaccLotDte2(Date var1) {
      this.cslaccLotDte2 = var1;
   }

   public Date getCslaccLotDte3() {
      return this.cslaccLotDte3;
   }

   public void setCslaccLotDte3(Date var1) {
      this.cslaccLotDte3 = var1;
   }

   public Date getCslaccLotDte4() {
      return this.cslaccLotDte4;
   }

   public void setCslaccLotDte4(Date var1) {
      this.cslaccLotDte4 = var1;
   }

   public Date getCslaccLotDte5() {
      return this.cslaccLotDte5;
   }

   public void setCslaccLotDte5(Date var1) {
      this.cslaccLotDte5 = var1;
   }

   public Date getCslaccLotDte6() {
      return this.cslaccLotDte6;
   }

   public void setCslaccLotDte6(Date var1) {
      this.cslaccLotDte6 = var1;
   }

   public Date getCslaccLotDte7() {
      return this.cslaccLotDte7;
   }

   public void setCslaccLotDte7(Date var1) {
      this.cslaccLotDte7 = var1;
   }

   public Date getCslaccLotDte8() {
      return this.cslaccLotDte8;
   }

   public void setCslaccLotDte8(Date var1) {
      this.cslaccLotDte8 = var1;
   }

   public Date getCslaccLotDte9() {
      return this.cslaccLotDte9;
   }

   public void setCslaccLotDte9(Date var1) {
      this.cslaccLotDte9 = var1;
   }

   public int getCslaccApte() {
      return this.cslaccApte;
   }

   public void setCslaccApte(int var1) {
      this.cslaccApte = var1;
   }

   public int getCslaccPositif() {
      return this.cslaccPositif;
   }

   public void setCslaccPositif(int var1) {
      this.cslaccPositif = var1;
   }

   public String getPatAdresse() {
      return this.patAdresse;
   }

   public void setPatAdresse(String var1) {
      this.patAdresse = var1;
   }

   public int getPatAnciennete() {
      return this.patAnciennete;
   }

   public void setPatAnciennete(int var1) {
      this.patAnciennete = var1;
   }

   public String getPatConjoint() {
      return this.patConjoint;
   }

   public void setPatConjoint(String var1) {
      this.patConjoint = var1;
   }

   public String getPatConjointTel1() {
      return this.patConjointTel1;
   }

   public void setPatConjointTel1(String var1) {
      this.patConjointTel1 = var1;
   }

   public String getPatConjointTel2() {
      return this.patConjointTel2;
   }

   public void setPatConjointTel2(String var1) {
      this.patConjointTel2 = var1;
   }

   public String getPatMail() {
      return this.patMail;
   }

   public void setPatMail(String var1) {
      this.patMail = var1;
   }

   public String getPatNom() {
      return this.patNom;
   }

   public void setPatNom(String var1) {
      this.patNom = var1;
   }

   public String getPatPoste() {
      return this.patPoste;
   }

   public void setPatPoste(String var1) {
      this.patPoste = var1;
   }

   public String getPatProfession() {
      return this.patProfession;
   }

   public void setPatProfession(String var1) {
      this.patProfession = var1;
   }

   public String getPatSecu() {
      return this.patSecu;
   }

   public void setPatSecu(String var1) {
      this.patSecu = var1;
   }

   public int getPatSexe() {
      return this.patSexe;
   }

   public void setPatSexe(int var1) {
      this.patSexe = var1;
   }

   public String getPatTel1() {
      return this.patTel1;
   }

   public void setPatTel1(String var1) {
      this.patTel1 = var1;
   }

   public String getPatTel2() {
      return this.patTel2;
   }

   public void setPatTel2(String var1) {
      this.patTel2 = var1;
   }

   public Date getPatDateEmbauche() {
      return this.patDateEmbauche;
   }

   public void setPatDateEmbauche(Date var1) {
      this.patDateEmbauche = var1;
   }

   public String getPatNationnalite() {
      return this.patNationnalite;
   }

   public void setPatNationnalite(String var1) {
      this.patNationnalite = var1;
   }

   public String getPatNature() {
      return this.patNature;
   }

   public void setPatNature(String var1) {
      this.patNature = var1;
   }

   public int getCslaccCertificat() {
      return this.cslaccCertificat;
   }

   public void setCslaccCertificat(int var1) {
      this.cslaccCertificat = var1;
   }

   public Date getCslaccDateAu() {
      return this.cslaccDateAu;
   }

   public void setCslaccDateAu(Date var1) {
      this.cslaccDateAu = var1;
   }

   public Date getCslaccDateDu() {
      return this.cslaccDateDu;
   }

   public void setCslaccDateDu(Date var1) {
      this.cslaccDateDu = var1;
   }

   public int getCslaccNbJourRepos() {
      return this.cslaccNbJourRepos;
   }

   public void setCslaccNbJourRepos(int var1) {
      this.cslaccNbJourRepos = var1;
   }

   public String getCslaccMotifRepos() {
      return this.cslaccMotifRepos;
   }

   public void setCslaccMotifRepos(String var1) {
      this.cslaccMotifRepos = var1;
   }

   public String getPatCivilite() {
      return this.patCivilite;
   }

   public void setPatCivilite(String var1) {
      this.patCivilite = var1;
   }

   public Date getPatDateNaissance() {
      return this.patDateNaissance;
   }

   public void setPatDateNaissance(Date var1) {
      this.patDateNaissance = var1;
   }

   public String getPatLieuNaissance() {
      return this.patLieuNaissance;
   }

   public void setPatLieuNaissance(String var1) {
      this.patLieuNaissance = var1;
   }

   public String getPatMatricule() {
      return this.patMatricule;
   }

   public void setPatMatricule(String var1) {
      this.patMatricule = var1;
   }

   public String getPatMedecin() {
      return this.patMedecin;
   }

   public void setPatMedecin(String var1) {
      this.patMedecin = var1;
   }

   public String getPatService() {
      return this.patService;
   }

   public void setPatService(String var1) {
      this.patService = var1;
   }

   public int getCslaccNbSalaries() {
      return this.cslaccNbSalaries;
   }

   public void setCslaccNbSalaries(int var1) {
      this.cslaccNbSalaries = var1;
   }

   public String getCslaccHoraireDebut() {
      return this.cslaccHoraireDebut;
   }

   public void setCslaccHoraireDebut(String var1) {
      this.cslaccHoraireDebut = var1;
   }

   public String getCslaccHoraireFin() {
      return this.cslaccHoraireFin;
   }

   public void setCslaccHoraireFin(String var1) {
      this.cslaccHoraireFin = var1;
   }

   public String getCslaccAnciennete() {
      return this.cslaccAnciennete;
   }

   public void setCslaccAnciennete(String var1) {
      this.cslaccAnciennete = var1;
   }
}
