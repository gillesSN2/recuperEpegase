<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="vgroupe" >

    <a4j:form id="groupe">
        <h:column >
            <center> <h2><h:outputText value="GESTION DES GROUPES" style="color:green;"/></h2></center>
        </h:column>
        <h:panelGrid width="100%" columnClasses="closEntete,closEntete" columns="2">
            <h:column>
                <h:panelGrid id="grppan" >
                    <h:panelGrid id="pngBouton"  columns="6" width="300px" style="height:35px">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajouterGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9}" reRender="panelGroupe,tableGroupe"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifierGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe}" reRender="panelGroupe,tableGroupe" />
                        <a4j:commandButton image="/images/detail.png" title="Modifier propriété du groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifierPropriete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe}" reRender="panelPropriete" />
                        <a4j:commandButton image="/images/print.png" title="Accès aux modèles d`imression du groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifierModele}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe}" reRender="panelModele" />
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerGroupe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode!='ADM'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelGroupe,tableGroupe" />
                        <a4j:commandButton image="/images/mail.png" title="B.A.L. du groupe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesMessageriesGroupes}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.afficheGroupe&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="idSubView"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableGroupe" style="border:1px solid green" activeClass="active-row" noDataLabel=" " styleClass="bg" headerClass="headerTab" height="290px" width="300px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelGroupes}"  var="groupe">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionGroupe}" reRender="pngBouton,optionpan,idModule"/>
                            <rich:column  width="25%" sortable="true" sortBy="#{groupe.grpCode}" sortOrder="ASCENDING">
                                <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{groupe.grpCode}"/>
                            </rich:column >
                            <rich:column  width="55%" sortable="true" sortBy="#{groupe.grpLibelle}">
                                <f:facet name="header"> <h:outputText value="Nom des Groupes"/></f:facet>
                                <h:outputText value="#{groupe.grpLibelle}"/>
                            </rich:column >
                            <rich:column  width="20%" sortable="true" sortBy="#{groupe.grpLie}">
                                <f:facet name="header"> <h:outputText value="Lié"/></f:facet>
                                <h:outputText value="#{groupe.grpLie}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idModule" style="border:1px solid green;margin-top:5px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModules}" activeClass="active-row" noDataLabel=" " styleClass="bg" headerClass="headerTab" height="250px" width="300px" rowClasses="rows1,rows2,rowsd" var="module">
                            <a4j:support eventsQueue="maQueue" reRender="optionpan" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionModules}" />
                            <rich:column  width="25%" sortable="true" sortBy="#{module.code1}" sortOrder="ASCENDING">
                                <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{module.code1}"/>
                            </rich:column >
                            <rich:column  width="75%" sortable="true" sortBy="#{module.libelle1FR}">
                                <f:facet name="header"> <h:outputText value="Modules installés"/></f:facet>
                                <h:outputText value="#{module.libelle1FR}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </h:column>

            <h:column>
                <h:panelGrid  id="optionpan"  width="100%">
                    <br/><br/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idtableFonction" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelFonctions}" styleClass="bg" style="margin-top:5px;border:1px solid green" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="750px"  var="optionmodule">
                            <rich:column width="280px" sortable="false" >
                                <f:facet name="header" ><h:outputText value="Fonctions" style="border:0px"/></f:facet>
                                <h:outputText  value="#{optionmodule.libelle_FR}"/>
                            </rich:column>
                            <rich:column width="50px" sortable="false" >
                                <f:facet name="header" ><h:outputText value="Accès"/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.acc}"  />
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Ajt."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.add}"/>
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Dup."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.dup}"/>
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Mod."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.maj}"/>
                            </rich:column >
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Sup."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.sup}" />
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Imp."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.imp}" />
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Trf."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.trf}"/>
                            </rich:column>
                            <rich:column width="50px" sortable="false">
                                <f:facet name="header" ><h:outputText value="Clo/Ser."/></f:facet>
                                <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.clo}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:column>
                        <center>
                            <h:panelGrid columns="4">
                                <a4j:commandButton value="Mode Consultation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionConsultationFonction}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idtableFonction"/>
                                <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionAllFonction}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idtableFonction"/>
                                <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionNothingFonction}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idtableFonction"/>
                                <a4j:commandButton value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerFonction}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idtableFonction"/>
                            </h:panelGrid>
                        </center>
                    </h:column>
                    <br/><br/>
                    <h:panelGrid id="pngoption" width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableOnglet" style="margin-top:-14px;border:1px solid green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelOnglets}" activeClass="active-row" noDataLabel=" " styleClass="bg" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="750px" var="optiononglet">
                                <rich:column width="50%" sortable="false" >
                                    <f:facet name="header" ><h:outputText value="Onglets"/></f:facet>
                                    <h:outputText value="#{optiononglet.libelle}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Acc."/></f:facet>
                                    <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.acc}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Ajt."/></f:facet>
                                    <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.add}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Mod."/></f:facet>
                                    <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.maj}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false" >
                                    <f:facet name="header" ><h:outputText value="Sup."/></f:facet>
                                    <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.sup}"/>
                                </rich:column>
                                <rich:column width="10%" sortable="false" >
                                    <f:facet name="header" ><h:outputText value="Imp."/></f:facet>
                                    <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.imp}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <h:column>
                            <center>
                                <h:panelGrid columns="4">
                                    <a4j:commandButton value="Mode Consultation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionConsultationOnglet}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idTableOnglet"/>
                                    <a4j:commandButton value="Tout sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionAllOnglet}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idTableOnglet"/>
                                    <a4j:commandButton value="Rien sélectionner" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionNothingOngletn}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idTableOnglet"/>
                                    <a4j:commandButton value="VALIDER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerOnglet}" style="color:white;background-color:green;margin:3px 3px 3px 3px;" reRender="idTableOnglet"/>
                                </h:panelGrid>
                            </center>
                        </h:column>
                    </h:panelGrid>

                </h:panelGrid>
            </h:column>

        </h:panelGrid>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdminstrationGenerale}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelGroupe" width="500" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelGroupe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelGroupe}" var="grp">
            <f:facet name="header"><h:outputText value="GESTION DES GROUPES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleGroupe}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpId!=0}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCode}" size="20" maxlength="10">
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifCodeExist}" reRender="panelGroupe" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLibelle}" size="35" maxlength="50"/></h:column>
                    <h:column><h:outputText value="Groupe lié:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLie}" size="20" maxlength="10"/></h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_office}">
                    <h:column><h:outputText value="Module Office:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleOff}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_tiers}">
                    <h:column><h:outputText value="Module Tiers:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleTie}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_achats}">
                    <h:column><h:outputText value="Module Achat:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleAch}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_stock}">
                    <h:column><h:outputText value="Module Stock:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleStk}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Production"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_ventes}">
                    <h:column><h:outputText value="Module Vente:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleVte}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Commande"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_caisse}">
                    <h:column><h:outputText value="Module Trésorerie:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Limité"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_parc}">
                    <h:column><h:outputText value="Module Parc:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePrc}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_paye}">
                    <h:column><h:outputText value="Module Paye:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePay}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                            <f:selectItem itemValue="2" itemLabel="Limité"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_compta}">
                    <h:column><h:outputText value="Module Comptabilité:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCpt}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_medical}">
                    <h:column><h:outputText value="Module Médical:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleMed}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_mod_rep}">
                    <h:column><h:outputText value="Module Reporting:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleRep}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column><h:outputText value="Module FREE:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleFree}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column><h:outputText value="Module GUEST:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleGuest}">
                            <f:selectItem itemValue="0" itemLabel="Sans"/>
                            <f:selectItem itemValue="1" itemLabel="Avec"/>
                        </h:selectOneRadio>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br>
                        <h:commandButton rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.existeCode}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.saveGroupe}"  image="/images/valider_big.png" id="btvaldAjt" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.existeCode}"  id="existcodeGroupe" style="color:red;" value="Le code existe déjà !!! veuillez en saisir un autre" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPropriete" width="1000" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelPropriete}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelPropriete}" var="prop">
            <f:facet name="header"><h:outputText value="GESTION DES PROPRIETES DES GROUPES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annulePropriete}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="p1" columns="2" style="width:100%;" columnClasses="clos30,clos70">
                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab name="Utilisateurs" label="Utilisateurs">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" /> 
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableUser"/>
                                <rich:extendedDataTable id="tableUser" styleClass="bg" style="border:1px solid green" border="0" activeClass="active-row" noDataLabel=" " headerClass="headerTab" width="100%" height="350px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUser}"  var="utilisateur">
                                    <rich:column width="5%" sortable="true" sortBy="#{utilisateur.usrSysteme}" style="text-align:center;">
                                        <f:facet name="header"> <h:outputText value="Adm."/></f:facet>
                                        <h:graphicImage value="/images/co-chef.png" rendered="#{utilisateur.usrSysteme==1}"/>
                                        <h:graphicImage value="/images/chef.png" rendered="#{utilisateur.usrSysteme==2}"/>
                                        <h:graphicImage value="/images/configuration.png" rendered="#{utilisateur.usrSysteme==3}"/>
                                    </rich:column >
                                    <rich:column width="5%" sortable="true" sortBy="#{utilisateur.usrEtat}" style="text-align:center;">
                                        <f:facet name="header"> <h:outputText value="Etat"/></f:facet>
                                        <h:graphicImage value="/images/desactiver.png" rendered="#{utilisateur.usrEtat==0}"/>
                                    </rich:column >
                                    <rich:column  width="5%" sortBy="#{utilisateur.selectUser}" sortable="true" style="text-align:center;">
                                        <f:facet name="header"> <h:outputText value="Sel."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{utilisateur.selectUser}"/>
                                    </rich:column >
                                    <rich:column  width="10%" sortBy="#{utilisateur.usrCollaboration}" sortable="true" style="text-align:left;">
                                        <f:facet name="header"> <h:outputText value="Grp."/></f:facet>
                                        <h:outputText value="#{utilisateur.usrCollaboration}"/>
                                    </rich:column >
                                    <rich:column width="55%" sortBy="#{utilisateur.usrNom}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                        <f:facet name="header"> <h:outputText value="Nom et prénom"/></f:facet>
                                        <h:outputText value="#{utilisateur.usrNom}  #{utilisateur.usrPrenom}"/>
                                    </rich:column >
                                    <rich:column width="10%" sortBy="#{utilisateur.usrService}" sortable="true" style="text-align:left;">
                                        <f:facet name="header"> <h:outputText value="Service"/></f:facet>
                                        <h:outputText value="#{utilisateur.usrService}"/>
                                    </rich:column >
                                </rich:extendedDataTable>
                            </a4j:region>
                            <br>
                            <h:panelGroup>
                                <center>
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.toutSelectionner}" value="Tout Sélectionner" reRender="tableUser"/>&nbsp;&nbsp;&nbsp;
                                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.rienSelectionner}" value="Rien Sélectionner" reRender="tableUser"/>&nbsp;&nbsp;&nbsp;
                                    <a4j:commandButton onclick="if (!confirm('Etes vous sur de vouloir mettre à jour les utilisateurs avec les propriétés du groupe?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.miseAJourUsers}" value="Mise à jour des propriétés des utilisateurs" reRender="modAttente,panelPropriete"/>
                                </center>
                            </h:panelGroup>
                        </rich:tab>

                        <rich:tab name="office" label="Office" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleOff=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid id="pngoffice" columns="2" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux mails:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAccesMail}" >
                                        <f:selectItem itemLabel="Tous les mails" itemValue="0"/>
                                        <f:selectItem itemLabel="Les mails collaboratifs" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Copie mail sur document:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpMailCopie}" >
                                        <f:selectItem itemLabel="Copie automatique" itemValue="0"/>
                                        <f:selectItem itemLabel="Sans copie" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Copie mail sur parapheur:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpMailParapheur}" >
                                        <f:selectItem itemLabel="Copie automatique" itemValue="0"/>
                                        <f:selectItem itemLabel="Sans copie" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureOffice}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupOff">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserOff" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoOff}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoOff');" reRender="panelChronoOff,serieoffice"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoOff}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieoffice"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoOff}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoOff');" reRender="panelChronoOff,serieoffice"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserOff" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoOff}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonOff}" reRender="grpuserajtsupOff,serieoffice"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieoffice" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoOff}" var="office">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesOffice}" reRender="grpuserajtsupOff,supserOff"/>
                                            <rich:column width="10%" sortable="true" sortBy="#{office.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{office.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{office.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{office.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{office.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{office.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{office.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="comptabilite" label="Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCpt=='1'}" >
                            <jsp:include flush="true" page="/administration/utilisateurCommun.jsp" />
                            <h:panelGrid  columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText value="Comptes interdits:"/></h:column>
                                <h:column><h:inputTextarea  rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCptInterdit}"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="(Inscrire les comptes comme suit : 'C1','C2','CX')" style="color:red"/></h:column>
                                <h:column><h:outputText value="Journaux interdits:"/></h:column>
                                <h:column><h:inputTextarea  rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpJrxInterdit}"/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="(Inscrire les journaux comme suit : 'J1','J2','JX')" style="color:red"/></h:column>
                                <h:column><h:outputText value="Outils de correction des journaux:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAccesCorrection}" >
                                        <f:selectItem itemLabel="Autorisé" itemValue="1"/>
                                        <f:selectItem itemLabel="Interdit" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifier un exercice cloturé" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Liasses fiscales:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModifLiasse}" >
                                        <f:selectItem itemLabel="Modification Autorisée" itemValue="1"/>
                                        <f:selectItem itemLabel="Mofication Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement consultation" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux brouillards:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAccesBrouillard}" >
                                        <f:selectItem itemLabel="Pas d'accès aux brouillards" itemValue="0"/>
                                        <f:selectItem itemLabel="Accès à tous les brouillards" itemValue="1"/>
                                        <f:selectItem itemLabel="Accès uniquement mes brouillards" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureCompta}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="caisse" label="Caisse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid  columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText style="text-decoration:underline;" value="Caissier:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissier}" >
                                        <f:selectItem itemLabel="Sans accès à la caisse" itemValue="0"/>
                                        <f:selectItem itemLabel="Accès à la caisse" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux documents:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="selSerPre" style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierService}" >
                                        <f:selectItem itemLabel="Tous les services" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mon service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService})" itemValue="1"  itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService==''}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux éléments:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpRecus}" >
                                        <f:selectItem itemLabel="Tous les éléments" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mes éléments (créateur)" itemValue="1"/>
                                        <f:selectItem itemLabel="Uniquement les éléments de mon groupe associé (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpLie})" itemValue="2"/>
                                        <f:selectItem itemLabel="Eléments liés à ma caisse reçu par défaut" itemValue="3"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureCaisse}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupCaiss">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoCaisse}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoCaisse');" reRender="panelChronoCaisse,serieCaisse"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoCaisse}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieCaisse"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoCaisse}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoCaisse');" reRender="panelChronoCaisse,serieCaisse"/>&nbsp;&nbsp;&nbsp;
                                            <h:commandButton image="/images/supprimer.png" title="Suppression Série"  id="supserCaiss" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoCaisse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonCaiss}"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieCaisse" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoCaiss}" var="caisse">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesCaisses}" reRender="grpuserajtsupVte,supserVte"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{caisse.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{caisse.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="5%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{caisse.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{caisse.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{caisse.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{caisse.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{caisse.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{caisse.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                                <h:column><h:outputText value="Accès aux Dates:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDateCai}" >
                                        <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux imputations:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpImputCai}" >
                                        <f:selectItem itemLabel="Visibles" itemValue="0"/>
                                        <f:selectItem itemLabel="Masquées" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux tiers:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpTiersCai}" >
                                        <f:selectItem itemLabel="Visibles" itemValue="0"/>
                                        <f:selectItem itemLabel="Masquées" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux montants:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpMontantCai}" >
                                        <f:selectItem itemLabel="Modifiables" itemValue="0"/>
                                        <f:selectItem itemLabel="Non modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRecette=='true'}"><h:outputText value="Recettes directes:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRecette=='true'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierRecette}">
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieDepense=='true'}"><h:outputText value="Dépenses directes:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieDepense=='true'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierDepense}">
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieTransfert=='true'}"><h:outputText value="Transferts directes:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieTransfert=='true'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierTransfert}">
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRegularisation=='true'}"><h:outputText value="Modifications pièces:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieRegularisation=='true'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierModif}">
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieSuppression=='true'}"><h:outputText value="Suppressions pièces:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionCaisses.saisieSuppression=='true'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCaissierDelete}">
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="achat" label="Achats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleAch=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux achats:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAchats}" >
                                        <f:selectItem itemLabel="Toutes les achats" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mes achats (créateur)" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Dépôt par défaut:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDepotSel}" >
                                        <f:selectItem itemLabel="" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesDepotsItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Choix Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommAchats}" >
                                        <f:selectItem itemLabel="Le user peut choisir le responsable" itemValue="0"/>
                                        <f:selectItem itemLabel="Le user peut choisir le responsable du client" itemValue="1"/>
                                        <f:selectItem itemLabel="Le responsable = user en cours" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Liste commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAcheteur}" >
                                        <f:selectItem itemLabel="Ne peut pas faire d'achat" itemValue="0"/>
                                        <f:selectItem itemLabel="Peut faire des achats (Acheteur)" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureAchats}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupAch">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoAch}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoAch');" reRender="panelChronoAch,serieachat"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoAch}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieachat"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoAch}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoAch');" reRender="panelChronoAch,serieachat"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoAch}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonAch}" reRender="grpuserajtsupAch,serieachat"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieachat" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoAch}" var="achat">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesAchats}" reRender="grpuserajtsupAch"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{achat.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{achat.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="5%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{achat.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{achat.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{achat.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{achat.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{achat.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{achat.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Libellés des produits:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAchLibelle}" >
                                        <f:selectItem itemLabel="Modification interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Modification autorisée si le produit l'autorise" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux Pump:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAchPump}" >
                                        <f:selectItem itemLabel="Pump masqué" itemValue="0"/>
                                        <f:selectItem itemLabel="Pump visible" itemValue="2"/>
                                        <f:selectItem itemLabel="Pump modifiable" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux Dates achats:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDateAch}" >
                                        <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux Dates stocks:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDateStk}" >
                                        <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Remise:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerRemiseAch}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Invisible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Rabais:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerRabaisAch}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Invisible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Prix d'achat:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerPaAch}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès produits:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpProdServiceAch}" >
                                        <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                        <f:selectItem itemLabel="Les produits du service" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpJrxReserve==0}"><h:outputText value="Modiciation Série:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpJrxReserve==0}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModifSerieAch}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab  name="vente" label="Ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleVte=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux ventes:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVentes}" >
                                        <f:selectItem itemLabel="Toutes les ventes" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mes ventes" itemValue="1"/>
                                        <f:selectItem itemLabel="Uniquement mes ventes mais tous les devis (créateur)" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Choix Commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommVentes}" >
                                        <f:selectItem itemLabel="Le user peut choisir le responsable" itemValue="0"/>
                                        <f:selectItem itemLabel="Le user peut choisir le responsable du client" itemValue="1"/>
                                        <f:selectItem itemLabel="Le responsable = user en cours" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Liste commercial:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVendeur}" >
                                        <f:selectItem itemLabel="Ne peut pas faire de vente" itemValue="0"/>
                                        <f:selectItem itemLabel="Peut faire des ventes (Commercial)" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Cumul de fonction:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpFactureCaisse}" >
                                        <f:selectItem itemLabel="Fonctions normales" itemValue="0"/>
                                        <f:selectItem itemLabel="Le user est fait des bons d`encaissements" itemValue="1"/>
                                        <f:selectItem itemLabel="Le user est fait des encaissements directs" itemValue="2"/>
                                        <f:selectItem itemLabel="Le user est fait tous types d`encaissements" itemValue="3"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureVentes}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionsVentes.modeCommission=='3'}"><h:outputText value="Calcul de commission:"/></h:column>
                                <h:column id="idComm0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.optionsVentes.modeCommission=='3'}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommType}" >
                                        <f:selectItem itemLabel="Sans calcul de commission" itemValue="0"/>
                                        <f:selectItem itemLabel="Sans calcul de commission, mais pris en compte pour d'autres users" itemValue="1"/>
                                        <f:selectItem itemLabel="Calcul % sur le CA encaissé du user" itemValue="3"/>
                                        <f:selectItem itemLabel="Calcul % sur le CA encaissé global" itemValue="5"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanelVte,idComm0,idComm1,idComm2"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                    <h:outputText id="idComm1" value="%:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommType>=3}"/>&nbsp;
                                    <h:inputText id="idComm2" style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommPourcentage}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpCommType>=3}"/>
                                </h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupVte">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserVte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoVte}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoVte');" reRender="panelChronoVte,serievente"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoVte}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serievente"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoVte}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoVte');" reRender="panelChronoVte,serievente"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserVte" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoVte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonVte}" reRender="grpuserajtsupVte,serievente"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serievente" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoVte}" var="vente">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesVentes}" reRender="grpuserajtsupVte,supserVte"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{vente.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{vente.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="5%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{vente.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{vente.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{vente.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{vente.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{vente.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{vente.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Libellés des produits:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVteLibelle}" >
                                        <f:selectItem itemLabel="Modification interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Modification autorisée si le produit l'autorise" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Affichage PUMP/Marge:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAffPump}" >
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Affichage Prix Plancher:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAffPlancher}" >
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible bloquant" itemValue="1"/>
                                        <f:selectItem itemLabel="Visible non bloquant" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Affichage Prix Marché et Concurrent:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAffPvMarche}" >
                                        <f:selectItem itemLabel="Invisible" itemValue="0"/>
                                        <f:selectItem itemLabel="Visible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux Dates:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDateVte}" >
                                        <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Remise:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerRemise}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Invisible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Rabais:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerRabais}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Invisible" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Prix de vente:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerPv}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès produits:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpProdService}" >
                                        <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                        <f:selectItem itemLabel="Les produits du service" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpJrxReserve==0}"><h:outputText value="Modiciation Série:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpJrxReserve==0}">
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModifSerieVte}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="medic" label="Médical" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleMed=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid  columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux services:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpMedicalService}" >
                                        <f:selectItem itemLabel="Tous les services" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mon service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService})" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService==''}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès au médical:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpMedical}" >
                                        <f:selectItem itemLabel="Tout le médical" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mon médical (créateur)" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Mode consultations générales:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVendeur}" >
                                        <f:selectItem itemLabel="Mode facturation + médical" itemValue="0"/>
                                        <f:selectItem itemLabel="Mode facturation" itemValue="1"/>
                                        <f:selectItem itemLabel="Mode médical" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Cumul de fonction:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpFactureCaisse}" >
                                        <f:selectItem itemLabel="Fonctions normales" itemValue="0"/>
                                        <f:selectItem itemLabel="Le user est fait des bons d`encaissements" itemValue="1"/>
                                        <f:selectItem itemLabel="Le user est fait des encaissements directs" itemValue="2"/>
                                        <f:selectItem itemLabel="Le user est fait tous types d`encaissements" itemValue="3"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignatureMedical}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupMed">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Série" id="adserMed" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoMed}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoMed');" reRender="panelChronoMed,seriemedical"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoMedical}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,seriemedical"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoMed}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoMed');" reRender="panelChronoMed,seriemedical"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" id="supserMed" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoVte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonVte}" reRender="grpuserajtsupMed,seriemedical"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="seriemedical" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoMed}" var="medical">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesMedical}" reRender="grpuserajtsupMed,supserMed"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{medical.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{medical.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="5%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{medical.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{medical.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{medical.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{medical.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{medical.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{medical.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                                <h:column><h:outputText value=" Accès aux Dates:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpDateMed}" >
                                        <f:selectItem itemLabel="Verrouillées" itemValue="0"/>
                                        <f:selectItem itemLabel="Modifiables" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Remise et rabais:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerRemise}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Prix de vente:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpVerPv}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Prix assurance:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpAffPvMarche}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès produits:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpProdService}" >
                                        <f:selectItem itemLabel="Tous les produits" itemValue="0"/>
                                        <f:selectItem itemLabel="Les produits du service" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="paye" label="Paye et R.H." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePay=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid  columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès agents:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPaye}" >
                                        <f:selectItem itemLabel="Accès à tous les agents" itemValue="0"/>
                                        <f:selectItem itemLabel="Accès aux agents non protégés + RH des protégés" itemValue="1"/>
                                        <f:selectItem itemLabel="Accès aux agents non protégés + RH et Prêts des protégés" itemValue="2"/>
                                        <f:selectItem itemLabel="Accès uniquement aux agents non protégés + RH, Prêts et Contrats des protégés" itemValue="3"/>
                                        <f:selectItem itemLabel="Accès uniquement aux agents non protégés" itemValue="4"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Accès aux services:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPayeService}" >
                                        <f:selectItem itemLabel="Tous les services" itemValue="0"/>
                                        <f:selectItem itemLabel="Uniquement mon service (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService})" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpService==''}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Responsable/Signature:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpSignaturePaye}" >
                                        <f:selectItem itemLabel="Interdite" itemValue="0"/>
                                        <f:selectItem itemLabel="Autorisée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès aux natures agents:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupPaye">
                                            <a4j:commandButton image="/images/ajouter.png" title="Ajout Nature"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye,seriePaye"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/ajouterAuto.png" title="Ajout de toutes les natures"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutAutoChronoPaye}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,seriePaye"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/modifier.png" title="Modifier Nature" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye,seriePaye"/>&nbsp;&nbsp;&nbsp;
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Nature" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.visibiliteBtonPaye}" reRender="grpuserajtsupPaye,seriePaye"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="seriePaye" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoPaye}" var="paye">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesPaye}" reRender="grpuserajtsupPaye"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{paye.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{paye.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="15%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{paye.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="40%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{paye.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{paye.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{paye.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{paye.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{paye.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                                <h:column><h:outputText value="Bulletin salaire:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPayeBulletin}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="0"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Contrat dans fiche de préparation:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPayeContrat}" >
                                        <f:selectItem itemLabel="Modifiable" itemValue="1"/>
                                        <f:selectItem itemLabel="Verrouillée" itemValue="0"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Accès pointage:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPayPointage}" >
                                        <f:selectItem itemLabel="Pointage individuel" itemValue="0"/>
                                        <f:selectItem itemLabel="Accès à tous les pointages" itemValue="1"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Alertes automatiques:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:350px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpPayeAlerte}" >
                                        <f:selectItem itemLabel="Aucune alerte" itemValue="0"/>
                                        <f:selectItem itemLabel="Alerte des fins de contrats" itemValue="1"/>
                                        <f:selectItem itemLabel="Alerte nouvelles demandes" itemValue="2"/>
                                        <f:selectItem itemLabel="Toutes les Alertes" itemValue="99"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab name="free" label="FREE" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleFree=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid id="idFree" columns="2" width="100%" columnClasses="clos30,clos70">
                                <h:column><h:outputText value="Module Achat:"/></h:column>
                                <h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajout Série"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoAch}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoAch');" reRender="panelChronoAch"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoAch}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoAch');" reRender="panelChronoAch"/>
                                    </h:panelGroup>
                                </h:column>   
                                <h:column><h:outputText value="Module Vente:"/></h:column>
                                <h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajout Série"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoVte}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoVte');" reRender="panelChronoVte"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronVte}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoVte');" reRender="panelChronoVte"/>
                                    </h:panelGroup>
                                </h:column>
                                <h:column><h:outputText value="Module Trésorerie:"/></h:column>
                                <h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajout Série"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoCaisse}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoCaisse');" reRender="panelChronoCaisse"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoCaisse}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoCaisse');" reRender="panelChronoCaisse"/>
                                    </h:panelGroup>
                                </h:column>
                                <h:column><h:outputText value="Module Paye:"/></h:column>
                                <h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajout Série"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.ajoutChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/modifier.png" title="Modifier Série" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.modifChronoPaye}" oncomplete="javascript:Richfaces.showModalPanel('panelChronoPaye');" reRender="panelChronoPaye"/>
                                    </h:panelGroup>
                                </h:column>
                                <h:column><h:outputText value="Accès aux séries:"/></h:column>
                                <h:column>
                                    <h:column>
                                        <h:panelGroup id="grpuserajtsupFree">
                                            <a4j:commandButton image="/images/supprimer.png" title="Suppression Série" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.supprimerChronoFree}" reRender="grpuserajtsupFree,idFree"/>
                                        </h:panelGroup>
                                    </h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieFree" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelUsersChronoFree}" var="free">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLesGroupesFree}" reRender="grpuserajtsupFree"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{free.grpchrNature}" sortOrder="ASCENDING">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{free.grpchrNature}"/>
                                            </rich:column>
                                            <rich:column width="5%" >
                                                <f:facet name="header" ><h:outputText value="Série"/></f:facet>
                                                <h:outputText value="#{free.grpchrSerie}"/>
                                            </rich:column>
                                            <rich:column width="50%" >
                                                <f:facet name="header" ><h:outputText value="Libellé Série"/></f:facet>
                                                <h:outputText value="#{free.grpchrLib}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="M.A.J"/></f:facet>
                                                <h:outputText value="#{free.lib_update}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Validation"/></f:facet>
                                                <h:outputText value="#{free.lib_validation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Dévalidation"/></f:facet>
                                                <h:outputText value="#{free.lib_devalidation}"/>
                                            </rich:column>
                                            <rich:column width="10%" >
                                                <f:facet name="header" ><h:outputText value="Duplicata"/></f:facet>
                                                <h:outputText value="#{free.lib_dupplication}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.savePropriete}"  image="/images/valider_big.png" id="btvaldAjt" reRender="panelPropriete"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelModele" width="1000" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelModele}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelModele}" var="mod">
            <f:facet name="header"><h:outputText value="GESTION DES MODELES D`IMPRESSION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleModele}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70">
                    <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;">
                        <rich:tab name="office" label="Office" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleOff=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableOffice" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelOffice}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneOffice}" reRender="tableOffice,tableOfficeUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableOfficeUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelOfficeUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneOffice}" reRender="tableOffice,tableOfficeUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab name="comptabilite" label="Comptabilité" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCpt=='1'}" >
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableCompta" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelCompta}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneCompta}" reRender="tableCompta,tableComptaUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableComptaUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelComptaUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneCompta}" reRender="tableCompta,tableCmptaUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab name="caisse" label="Caisse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleCai=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableCaisse" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelCaisses}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneCaisses}" reRender="tableCaisse,tableCaisseUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableCaisseUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelCaissesUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneCaisses}" reRender="tableCaisse,tableCaisseUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab name="achat" label="Achats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleAch=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableAchats" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelAchats}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneAchats}" reRender="tableAchats,tableAchatsUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableAchatsUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelAchatsUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneAchats}" reRender="tableAchats,tableAchatsUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab  name="vente" label="Ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleVte=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableVentes" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelVentes}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneVentes}" reRender="tableVentes,tableVentesUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableVentesUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelVentesUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneVentes}" reRender="tableVentes,tableVentesUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab name="medic" label="Médical" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModuleMed=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableMedical" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelMedical}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLigneMedical}" reRender="tableMedical,tableMedicalUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableMedicalUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelMedicalUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLigneMedical}" reRender="tableMedical,tableMedicalUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab name="paye" label="Paye et R.H." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupe.grpModulePay=='1'}">
                            <jsp:include flush="true" page="/administration/groupeCommun.jsp" />
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos50,clos50">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tablePaye" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelPaye}" var="rapport">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.selectionLignePaye}" reRender="tablePaye,tablePayeUtil"/>
                                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Tous les modèles" /></f:facet>
                                            <h:outputText value="#{rapport}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tablePayeUtil" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;" activeClass="active-row" noDataLabel=" " width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.datamodelModelPayeUtil}" var="util">
                                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.deSelectionLignePaye}" reRender="tablePaye,tablePayeUtil"/>
                                        <rich:column  width="100%" sortBy="#{util}" sortable="true" sortOrder="ASCENDING" style="text-align:left;">
                                            <f:facet name="header" ><h:outputText value="Modèles autorisés" /></f:facet>
                                            <h:outputText value="#{util}" style="text-align:left;"/>
                                        </rich:column >
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </rich:tab>
                    </rich:tabPanel>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoOff" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelOffice}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelOffice}" var="off">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS OFFICE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleOffice}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoOff"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoOffice" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoOff!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoOff!=2}">
                        <h:selectOneMenu id="seriAjtOff" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoOff}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoOfficeItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoOff}" reRender="seriAjtOff,inptlibeAjtOff,inptNatuAjtOff,btnChronoOff"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtOff" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtOff" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoOff">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoOff}" image="/images/valider_big.png" id="btvaldOff" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoOff}" reRender="panelChronoOff,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode6" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoAch" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelAchat}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelAchat}" var="ach">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS ACHATS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleAchat}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoAch"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoAchat" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoAch!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoAch!=2}">
                        <h:selectOneMenu id="seriAjtAch" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoAch}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoAchatsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoAch}" reRender="seriAjtAch,inptlibeAjtAch,inptNatuAjtAch,inptserieAjtAch,btnChronoAch"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoAchat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoAch">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoAch}" image="/images/valider_big.png" id="btvaldAjt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoAch}" reRender="panelChronoAch,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode2" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoVte" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelVente}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelVente}" var="vte">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS VENTES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleVente}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoVte"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoVentes" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoVte!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoVte!=2}">
                        <h:selectOneMenu id="seriAjtVte" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoVte}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoVentesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoVte}" reRender="seriAjtVte,inptlibeAjtVte,inptNatuAjtVte,inptserieAjtVte,btnChronoVte"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoVentes" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column >
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoVte">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoVte}" image="/images/valider_big.png" id="btvaldVte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoVte}" reRender="panelChronoVte,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode3" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoCaisse" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelCaisse}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelCaisse}" var="cai">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS CAISSES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleCaisse}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoCaisse"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoCaisse"  columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoCaisse!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoCaisse!=2}">
                        <h:selectOneMenu id="seriAjtCaisse" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoCaisse}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoCaisseItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoCaisse}" reRender="gridModalCaiss,inptserieAjtCaisse,inptlibeAjtCaisse,inptNatuAjtCaisse,btnChronoCaisse"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoCaisse">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoCaisse}" image="/images/valider_big.png" id="btvaldCaisse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoCaisse}" reRender="panelChronoCaisse,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode4" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoPaye" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS PAYES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoPaye"  columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoPaye!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoPaye!=2}">
                        <h:selectOneMenu id="seriAjtPaye" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoPaye}" >
                            <f:selectItem itemLabel="Sélectionnez une nature" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoPayeItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoPaye}" reRender="panChronoPaye,inptserieAjtPaye,inptlibeAjtPaye,inptNatuAjtPaye,btnChronoPaye"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtPaye" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoPaye">
                    <center>
                        <br><br>
                        <a4j:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoPaye}" image="/images/valider_big.png" id="btvaldPaye" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoPaye}" reRender="panelChronoPaye,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode5" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoMed" width="550" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelMedical}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.showModalPanelMedical}" var="med">
            <f:facet name="header"><h:outputText value="GESTION DES CHRONOS MEDICAUX"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.annuleMedical}" image="/images/close.gif" styleClass="hidelink" reRender="panelChronoMed"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="panChronoMedical" columns="2" cellspacing="3"  cellpadding="3" style="width:100%;" columnClasses="clos30,clos70">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoMed!=2}"><h:outputText value="Sélection:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_action_chronoMed!=2}">
                        <h:selectOneMenu id="seriAjtMed" style="width:185px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.inputChronoMed}" >
                            <f:selectItem itemLabel="Sélectionnez une série" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.mesChronoMedicalItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.verifChronoMed}" reRender="seriAjtMed,inptlibeAjtMed,inptNatuAjtMed,inptserieAjtMed,btnChronoMed"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptserieAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrSerie}" size="10"/></h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText readonly="true"  id="inptlibeAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrLib}" size="40"/></h:column>
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column><h:inputText readonly="true" id="inptNatuAjtMed" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrNature}" size="10"/></h:column>
                    <h:column><h:outputText value="Mise à jour:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate}">
                            <f:selectItem itemLabel="Mise à jour autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Mise à jour interdite" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panChronoVentes" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.affichageOption}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Validation:"/></h:column>
                    <h:column >
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Validation après enregistrement" itemValue="0"/>
                            <f:selectItem itemLabel="Validation après impression" itemValue="1"/>
                            <f:selectItem itemLabel="Validation après click bouton" itemValue="2"/>
                            <f:selectItem itemLabel="Validation interdite" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Dé-validation:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDeValidation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Dé-validation interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Dé-validation autorisée si non transformée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Duplicata:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrDupplication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.groupeChrono.grpchrUpdate==1}">
                            <f:selectItem itemLabel="Impression duplicata interdite" itemValue="0"/>
                            <f:selectItem itemLabel="Impression duplicata autorisée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="btnChronoMed">
                    <center>
                        <br><br>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.validerChronoMed}" image="/images/valider_big.png" id="btvaldMed" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formGroupe.var_aff_val_chronoMed}" reRender="panelChronoMed,p1"/>
                    </center>
                    <center>
                        <h:outputText  id="outptcode7" style="color:red;" value="la série est obligatoire et unique" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>