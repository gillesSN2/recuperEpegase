package com.epegase.systeme.util;

import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilTrie implements Serializable {
   private List listOrigine = new ArrayList();

   public List triListeDate(List var1) throws ParseException {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new Stock();
         new Stock();
         long var5 = 0L;
         long var7 = 0L;

         for(int var9 = 0; var9 < var1.size(); ++var9) {
            Stock var3 = (Stock)var1.get(var9);
            var5 = var3.getStk_date_mvt().getTime();
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var10 = false;

               for(int var11 = 0; var11 < var2.size(); ++var11) {
                  Stock var4 = (Stock)var2.get(var11);
                  var7 = var4.getStk_date_mvt().getTime();
                  if (var5 < var7) {
                     var2.add(var11, var3);
                     var10 = true;
                     break;
                  }
               }

               if (!var10) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeMois(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new Stock();
         new Stock();
         boolean var5 = false;
         boolean var6 = false;

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            Stock var3 = (Stock)var1.get(var7);
            int var10 = var3.getStk_mois();
            var6 = false;
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  Stock var4 = (Stock)var2.get(var9);
                  int var11 = var4.getStk_mois();
                  if (var10 < var11) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeChaine(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new Stock();
         new Stock();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            Stock var3 = (Stock)var1.get(var7);
            var5 = var3.getStkLibelle();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  Stock var4 = (Stock)var2.get(var9);
                  var6 = var4.getStkLibelle();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeCompte(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new PlanComptable();
         new PlanComptable();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            PlanComptable var3 = (PlanComptable)var1.get(var7);
            var5 = var3.getPlcCompte();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  PlanComptable var4 = (PlanComptable)var2.get(var9);
                  var6 = var4.getPlcCompte();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeTrfCompta(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new TransfertCompta();
         new TransfertCompta();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            TransfertCompta var3 = (TransfertCompta)var1.get(var7);
            var5 = var3.getTrfCompte();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  TransfertCompta var4 = (TransfertCompta)var2.get(var9);
                  var6 = var4.getTrfCompte();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeJournaux(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new JournauxMois();
         new JournauxMois();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            JournauxMois var3 = (JournauxMois)var1.get(var7);
            var5 = var3.getTrie();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  JournauxMois var4 = (JournauxMois)var2.get(var9);
                  var6 = var4.getTrie();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeTransfertComptaRef1(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new TransfertCompta();
         new TransfertCompta();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            TransfertCompta var3 = (TransfertCompta)var1.get(var7);
            if (var3.getTrfReference1() != null && !var3.getTrfReference1().isEmpty()) {
               var5 = var3.getTrfReference1();
               var6 = "";
               if (var2.size() == 0) {
                  var2.add(var3);
               } else {
                  boolean var8 = false;

                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     TransfertCompta var4 = (TransfertCompta)var2.get(var9);
                     var6 = var4.getTrfReference1();
                     if (var6 != null && !var6.isEmpty() && var5.compareTo(var6) < 0) {
                        var2.add(var9, var3);
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var2.add(var3);
                  }
               }
            } else {
               var2.add(var3);
            }
         }
      }

      return var2;
   }

   public List triListeTransfertRubrique(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new FeuilleCalculRubrique();
         new FeuilleCalculRubrique();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            FeuilleCalculRubrique var3 = (FeuilleCalculRubrique)var1.get(var7);
            if (var3.getFeurubCode() != null && !var3.getFeurubCode().isEmpty()) {
               var5 = var3.getFeurubCode();
               var6 = "";
               if (var2.size() == 0) {
                  var2.add(var3);
               } else {
                  boolean var8 = false;

                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     FeuilleCalculRubrique var4 = (FeuilleCalculRubrique)var2.get(var9);
                     var6 = var4.getFeurubCode();
                     if (var6 != null && !var6.isEmpty() && var5.compareTo(var6) < 0) {
                        var2.add(var9, var3);
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var2.add(var3);
                  }
               }
            } else {
               var2.add(var3);
            }
         }
      }

      return var2;
   }

   public List triListeTransfertMatricule(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new SalariesVariables();
         new SalariesVariables();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            SalariesVariables var3 = (SalariesVariables)var1.get(var7);
            if (var3.getSalaries().getSalMatricule() != null && !var3.getSalaries().getSalMatricule().isEmpty()) {
               var5 = var3.getSalaries().getSalMatricule();
               var6 = "";
               if (var2.size() == 0) {
                  var2.add(var3);
               } else {
                  boolean var8 = false;

                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     SalariesVariables var4 = (SalariesVariables)var2.get(var9);
                     var6 = var4.getSalaries().getSalMatricule();
                     if (var6 != null && !var6.isEmpty() && var5.compareTo(var6) < 0) {
                        var2.add(var9, var3);
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var2.add(var3);
                  }
               }
            } else {
               var2.add(var3);
            }
         }
      }

      return var2;
   }

   public List triListeTransfertPatronyme(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new SalariesVariables();
         new SalariesVariables();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            SalariesVariables var3 = (SalariesVariables)var1.get(var7);
            if (var3.getSalaries().getPatronyme() != null && !var3.getSalaries().getPatronyme().isEmpty()) {
               var5 = var3.getSalaries().getPatronyme();
               var6 = "";
               if (var2.size() == 0) {
                  var2.add(var3);
               } else {
                  boolean var8 = false;

                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     SalariesVariables var4 = (SalariesVariables)var2.get(var9);
                     var6 = var4.getSalaries().getPatronyme();
                     if (var6 != null && !var6.isEmpty() && var5.compareTo(var6) < 0) {
                        var2.add(var9, var3);
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var2.add(var3);
                  }
               }
            } else {
               var2.add(var3);
            }
         }
      }

      return var2;
   }

   public List triListeProduit(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new Produits();
         new Produits();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            Produits var3 = (Produits)var1.get(var7);
            var5 = var3.getProCode();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  Produits var4 = (Produits)var2.get(var9);
                  var6 = var4.getProCode();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeNatureRH(List var1) {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new ObjetCompte();
         new ObjetCompte();
         String var5 = "";
         String var6 = "";

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            ObjetCompte var3 = (ObjetCompte)var1.get(var7);
            var5 = var3.getNom_FR();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  ObjetCompte var4 = (ObjetCompte)var2.get(var9);
                  var6 = var4.getNom_FR();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var9, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeEcritureDate(List var1) throws ParseException {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new Ecritures();
         new Ecritures();
         long var5 = 0L;
         long var7 = 0L;

         for(int var9 = 0; var9 < var1.size(); ++var9) {
            Ecritures var3 = (Ecritures)var1.get(var9);
            var5 = var3.getEcrDateSaisie().getTime();
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var10 = false;

               for(int var11 = 0; var11 < var2.size(); ++var11) {
                  Ecritures var4 = (Ecritures)var2.get(var11);
                  var7 = var4.getEcrDateSaisie().getTime();
                  if (var5 < var7) {
                     var2.add(var11, var3);
                     var10 = true;
                     break;
                  }
               }

               if (!var10) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeAmortissementDate(List var1) throws ParseException {
      ArrayList var2 = new ArrayList();
      if (var1.size() != 0) {
         new AmortissementTab();
         new AmortissementTab();
         long var5 = 0L;
         long var7 = 0L;

         for(int var9 = 0; var9 < var1.size(); ++var9) {
            AmortissementTab var3 = (AmortissementTab)var1.get(var9);
            var5 = var3.getAmotabDateDeb().getTime();
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var10 = false;

               for(int var11 = 0; var11 < var2.size(); ++var11) {
                  AmortissementTab var4 = (AmortissementTab)var2.get(var11);
                  var7 = var4.getAmotabDateDeb().getTime();
                  if (var5 < var7) {
                     var2.add(var11, var3);
                     var10 = true;
                     break;
                  }
               }

               if (!var10) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List getListOrigine() {
      return this.listOrigine;
   }

   public void setListOrigine(List var1) {
      this.listOrigine = var1;
   }
}
