<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="configCompta">

    <script type="text/javascript">
        function getFile(){
            fileInput.click();
            var fileName = fileInput.value;
            return fileName ;
        }
        alert(filename);
    </script>

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="OPTIONS DE LA COMPTABILITE" style="color:green;font-size:16px;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  style="border:0px;">

            <rich:tab label="Général">
                <h:panelGrid width="100%" id="idGeneral">
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText  value = "Nombre de caractères des numéros de compte:" /></h:column>
                        <h:column>
                            <h:selectOneMenu  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.griserNbrCarNumCpte}" value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbcr}" style="width:300px;" >
                                <f:selectItem  itemLabel="6 c" itemValue="6" itemDisabled="true"/>
                                <f:selectItem itemLabel="7 c" itemValue="7"  itemDisabled="true"/>
                                <f:selectItem itemLabel="8 c" itemValue="8"  itemDisabled="true"/>
                                <f:selectItem itemLabel="9 c" itemValue="9"  itemDisabled="true"/>
                                <f:selectItem itemLabel="10 c" itemValue="10"/>
                                <f:selectItem itemLabel="11 c" itemValue="11"  itemDisabled="true"/>
                                <f:selectItem itemLabel="12 c" itemValue="12"  itemDisabled="true"/>
                                <f:selectItem itemLabel="13 c" itemValue="13"  itemDisabled="true"/>
                                <f:selectItem itemLabel="14 c" itemValue="14"  itemDisabled="true"/>
                                <f:selectItem itemLabel="15 c" itemValue="15"  itemDisabled="true"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText  value = "Calcul numéro de compte:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.calculCompte}" style="width:300px;">
                                <f:selectItem itemLabel="Compte le nombre de comptes de la racine + 1" itemValue="0"/>
                                <f:selectItem itemLabel="Charge le dernier compte + 1" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText  value = "Libellé des plans comptables et analytiques:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.typelib}" style="width:300px;">
                                <f:selectItem itemLabel="Libre" itemValue="libre"/>
                                <f:selectItem itemLabel="Miniscule" itemValue="miniscule"/>
                                <f:selectItem itemLabel="Capital" itemValue="capital"/>
                                <f:selectItem itemLabel="Majuscule" itemValue="majuscule"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM"width="60%">
                        <h:column><h:outputText  value = "Tri des écritures dans les extraits de comptes:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.tri_extrait}" style="width:300px;">
                                <f:selectItem itemLabel="Tri sur pièce et date" itemValue="0"/>
                                <f:selectItem itemLabel="Tri sur date" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM"width="60%" rendered="false">
                        <h:column><h:outputText  value ="Tri des écritures dans les journaux de saisie:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value = "#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.tri_jrx}" style="width:300px;">
                                <f:selectItem itemLabel="Tri sur ordre de saisie" itemValue="0"/>
                                <f:selectItem itemLabel="Tri sur date et pièce" itemValue="1"/>
                                <f:selectItem itemLabel="Tri sur compte et date" itemValue="2"/>
                                <f:selectItem itemLabel="Tri sur montant croissant" itemValue="3"/>
                                <f:selectItem itemLabel="Tri sur pièce" itemValue="4"/>
                                <f:selectItem itemLabel="Tri sur code analytique" itemValue="5"/>
                                <f:selectItem itemLabel="Tri sur date, pièce et n°compte" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText value="Saisie dans les journaux:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_brl}" style="width:300px;">
                                <f:selectItem itemLabel="Saisie directe autorisée" itemValue="0"/>
                                <f:selectItem itemLabel="Saisie directe interdite" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText value="Saisie des rapprochements:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_rapprochement}" style="width:300px;">
                                <f:selectItem itemLabel="Sur tous les comptes hors trésorerie" itemValue="0"/>
                                <f:selectItem itemLabel="Sur les comptes de trésorerie" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode des rapprochements:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_rapprochementMode}" style="width:300px;">
                                <f:selectItem itemLabel="Rapprochements mensuels" itemValue="0"/>
                                <f:selectItem itemLabel="Rapprochements journaliers" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM"width="60%">
                        <h:column><h:outputText value="Gestion Centralisation Achats:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cpteAchats}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal, libellé, référence, activité)" itemValue="1"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, département)" itemValue="2"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, activité)" itemValue="8"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion Centralisation Ventes:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cpteVentes}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal, libellé, référence, activité)" itemValue="1"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, département)" itemValue="2"/>
                                <f:selectItem itemLabel="Centralisation optimisée (patient comptant, compte, date, journal, piece)" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion Centralisation Paye:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cptePaye}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal, libellé, référence, activité)" itemValue="1"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, département)" itemValue="2"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, activité et retenues)" itemValue="8"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, activité et retenues et 4478)" itemValue="9"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion Centralisation Immobilisations:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cpteImmo}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (bien et année)" itemValue="3"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte et mois)" itemValue="4"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte et année)" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion Centralisation Trésorerie:"   /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cpteTreso}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal)" itemValue="7"/>
                                <f:selectItem itemLabel="Centralisation optimisée (patient comptant, compte, date, journal)" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Gestion Centralisation Autres:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.trf_cpte}"style="width:300px;" >
                                <f:selectItem itemLabel="Pas de centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, date, journal, libellé, référence, activité)" itemValue="1"/>
                                <f:selectItem itemLabel="Centralisation optimisée (compte, journal, département)" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Exportation des OD (modules):"/></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.exportOd}"style="width:300px;" >
                                <f:selectItem itemLabel="Export modèle epegase" itemValue="0"/>
                                <f:selectItem itemLabel="Export modèle autre logiciel" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idGeneral,idExport1,idExport2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idExport1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.exportOd=='1'}"><h:outputText value="Longueurs des comptes Exportés:"/></h:column>
                        <h:column id="idExport2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.exportOd=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbcrExport}" style="width:300px;"/></h:column>
                        <h:column><h:outputText value="Verrouillage des écritures importées:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.verrouImport}"style="width:300px;" >
                                <f:selectItem itemLabel="Les écritures sont verrouillées" itemValue="0"/>
                                <f:selectItem itemLabel="Les écritures sont modifiables" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Brouillards sur importation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.brouillardImport}"style="width:300px;" >
                                <f:selectItem itemLabel="Sans mise à jour des brouillards" itemValue="0"/>
                                <f:selectItem itemLabel="Avec mise à jour des brouillards" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM"width="60%">
                        <h:column><h:outputText value="Compte Ecart règlement débit:"   /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.ecartDebit}" style="width:300px;"/></h:column>
                        <h:column><h:outputText value="Compte Ecart règlement crédit:"   /></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.ecartCredit}" style="width:300px;"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Analytique" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.griserAnalytique}">
                <h:panelGroup>
                    <h2>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.analytique}" >
                            <f:selectItem itemLabel="Gestion de l'analytique" />
                        </h:selectBooleanCheckbox>
                        <h:outputText value = "Gestion de l'analytique"  styleClass = "panelOption" style = "width:100%;text-align:left"/>
                    </h2>
                    <h:panelGrid columns="2" columnClasses="closEnteteM,closEnteteM" width="60%">
                        <h:column><h:outputText  value = "Mode saisie analytique:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.saisieAnalytique}" style="width:300px;">
                                <f:selectItem itemLabel="Analytique dans les journaux et les imputations" itemValue="0"/>
                                <f:selectItem itemLabel="Analytique dans les journaux" itemValue="1"/>
                                <f:selectItem itemLabel="Analytique dans les imputations" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText  value = "Analyse erreur imputation (journal et extrait):" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.analytiqueErreur}" style="width:300px;">
                                <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText  value = "Transfert des Analytiques en comptabilité:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.analytiqueTransfert}" style="width:300px;">
                                <f:selectItem itemLabel="Activité optionnelle" itemValue="0"/>
                                <f:selectItem itemLabel="Activité Obligatoire" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <br>
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;text-align:left;" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.mesClassesAnalytiques}" var="natureanal" id="table4" width="90%" align="center" height="350px;">
                            <rich:column>
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{natureanal.code}" />
                            </rich:column>
                            <rich:column width="70%">
                                <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                                <h:outputText value="#{natureanal.nom_FR}" style="width:40px;" />
                            </rich:column>
                            <rich:column>
                                <f:facet name="header"> <h:outputText  value="Activer" /></f:facet>
                                <h:selectBooleanCheckbox value="#{natureanal.valide}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>

                </center>
            </rich:tab>

            <rich:tab label="Trésorerie" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.griserAnalytique}">
                <h:panelGroup>
                    <h2>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.tresorerie}" />
                        <h:outputText value = "Autoriser la gestion de trésorerie dans les journaux"/>
                    </h2>
                </h:panelGroup>
            </rich:tab>

            <rich:tab label="Budget" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.griserAnalytique}">
                <h:panelGroup >
                    <h2>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.budget}" />
                        <h:outputText value = "Autoriser la gestion du budget dans les journaux"/>
                    </h2>
                </h:panelGroup>
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;text-align:left;"cellpadding="0" cellspacing="0"headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.mesClassesBudgets}" var="naturebudget" id="table2" width="90%" align="center" height="350px;">
                            <rich:column> <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{naturebudget.code}" />
                            </rich:column>
                            <rich:column width="70%"><f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                                <h:outputText value="#{naturebudget.nom_FR}" style="width:40px;" />
                            </rich:column>
                            <rich:column><f:facet name="header"><h:outputText  value="Activer" /></f:facet>
                                <h:selectBooleanCheckbox value="#{naturebudget.valide}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </center>
            </rich:tab>

            <rich:tab label="Centralisation Comptes">
                <h:column><h:outputText  value = "Permet de centraliser les comptes des classes qui sont cochées dans les balances générales et les grands livres généraux" /></h:column>
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;text-align:left;"cellpadding="0" cellspacing="0"headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.mesCentralisations}" var="centre" id="table3" width="90%" align="center" height="350px;">
                            <rich:column> <f:facet name="header"><h:outputText  value="Classe" /></f:facet>
                                <h:outputText value="#{centre.code}" />
                            </rich:column>
                            <rich:column width="70%"><f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                                <h:outputText value="#{centre.nom_FR}" style="width:40px;" />
                            </rich:column>
                            <rich:column><f:facet name="header"><h:outputText  value="Activer" /></f:facet>
                                <h:selectBooleanCheckbox value="#{centre.valide}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </center>
            </rich:tab>

            <rich:tab label="Affichages">
                <h:panelGrid   columns="2">
                    <h:outputText  value="Colonne de contrepartie:"/>
                    <h:selectOneMenu  value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.colContrePartie}"  id="aff1" >
                        <f:selectItem itemLabel="Masquée" itemValue="masquée"/>
                        <f:selectItem itemLabel="Visible" itemValue="visible"/>
                    </h:selectOneMenu>
                    <h:outputText  value="Colonne de Numéro de référence 1:"/>
                    <h:selectOneMenu  value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.colNumReference1}"  id="aff2" >
                        <f:selectItem itemLabel="Masquée" itemValue="masquée"/>
                        <f:selectItem itemLabel="Visible" itemValue="visible"/>
                    </h:selectOneMenu>
                    <h:outputText  value="Colonne de Numéro de référence 2:"/>
                    <h:selectOneMenu  value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.colNumReference2}"  id="aff3" >
                        <f:selectItem itemLabel="Masquée" itemValue="masquée"/>
                        <f:selectItem itemLabel="Visible" itemValue="visible"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des brouillards:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxBr}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des journaux:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxJr}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des extraits:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxEx}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des amortissements:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxAm}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des loyers:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxLo}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                    <h:outputText value = "Nombre ligne maximum des budgets:"/>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.nbLigneMaxBu}" style="width:300px;">
                        <f:selectItem itemLabel="18 lignes" itemValue="18" />
                        <f:selectItem itemLabel="25 lignes" itemValue="25" />
                        <f:selectItem itemLabel="50 lignes" itemValue="50" />
                        <f:selectItem itemLabel="100 lignes" itemValue="100"/>
                        <f:selectItem itemLabel="200 lignes" itemValue="200"/>
                        <f:selectItem itemLabel="300 lignes" itemValue="300"/>
                        <f:selectItem itemLabel="400 lignes" itemValue="400"/>
                        <f:selectItem itemLabel="500 lignes" itemValue="500"/>
                        <f:selectItem itemLabel="1000 lignes" itemValue="1000"/>
                        <f:selectItem itemLabel="5000 lignes" itemValue="5000"/>
                        <f:selectItem itemLabel="10000 lignes" itemValue="10000"/>
                    </h:selectOneMenu>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Contrôle Mail">
                <h:panelGrid  columns="2" columnClasses="clos30,clos70" width="100%">
                    <h:outputText value="Envoie mail sur cloture rapprochement:"/>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.mailClotureRappro}"/></h:column>
                    <h:outputText value="Envoie mail sur cloture journal:"/>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.mailClotureJournal}"/></h:column>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Immobilisations">
                <h:panelGrid  columns="2">
                    <h:outputText value="Mode de calcul:"/>
                    <h:selectOneMenu  value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.calculImmobilisation}">
                        <f:selectItem itemLabel="sur le nombre de jours réel" itemValue="0"/>
                        <f:selectItem itemLabel="au trentième" itemValue="1"/>
                    </h:selectOneMenu>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Liasses">
                <h:panelGrid  columns="2">
                    <h:outputText value="Plan comptable:"/>
                    <h:selectOneMenu  value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.planCpteLiasse}">
                        <f:selectItem itemLabel="Recherche comptes dans plan comptable" itemValue="0"/>
                        <f:selectItem itemLabel="Recherche comptes dans écritures" itemValue="1"/>
                    </h:selectOneMenu>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Cloture">
                <h:panelGrid columns="2">
                    <h:column rendered="false"><h:outputText  value = "Controles lors de la cloture annuelle:" /></h:column>
                    <h:column rendered="false">
                        <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.clotureSansControle}" style="width:300px;">
                            <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                            <f:selectItem itemLabel="Activé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText  value = "Calcul rapprochements lors de la cloture annuelle:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.clotureSansRappro}" style="width:300px;">
                            <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                            <f:selectItem itemLabel="Activé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText  value = "Efface Lettrage inutile lors de la cloture annuelle:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.clotureLettrageInutile}" style="width:300px;">
                            <f:selectItem itemLabel="Activé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="false"><h:outputText  value = "Lettrage auto. lors de la cloture annuelle:" /></h:column>
                    <h:column rendered="false">
                        <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.clotureLettrage}" style="width:300px;">
                            <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                            <f:selectItem itemLabel="Activé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText  value = "Backup avant cloture:" /></h:column>
                    <h:column>
                        <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.clotureBackup}" style="width:300px;">
                            <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                            <f:selectItem itemLabel="Activé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </rich:tab>

            <rich:tab id="fpt" label="Liaison externe">
                <h:panelGrid  columns="2" columnClasses="clos30,clos70d" width="100%" id="idpanExt">
                    <h:column><h:outputText  value="Adresse du serveur:"/></h:column>
                    <h:column><h:inputText style="width:100%" value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.adresseFtp}" /></h:column>
                    <h:column><h:outputText value="Port utilisé:"/></h:column>
                    <h:column><h:inputText value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.portFtp}" /></h:column>
                    <h:column><h:outputText value="Nom d'utilisateur:"/></h:column>
                    <h:column><h:inputText style="width:100%" value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.loginFtp}" /></h:column>
                    <h:column><h:outputText value="Mot de passe:"/></h:column>
                    <h:column><h:inputSecret value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.passwdFtp}" /></h:column>
                    <h:column><h:outputText value="Fichier d'export écritures:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.optionComptabilite.dossierExport}"/></h:column>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>
        <br>
        <center>
            <h:commandButton id="idCancel" styleClass="exp_lienmenu"  value="RETOUR" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp;&nbsp;&nbsp;
            <h:commandButton styleClass="exp_lienmenu" value="VALIDEZ" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formOptionComptabilite.creerOptioncompta}"  onclick="if (!confirm('Voulez-vous enregistrer les modifications ?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>

</f:subview>