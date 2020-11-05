<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="chantiers">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES LIEUX (ORIGINES/DESTINATIONS)" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="200px">
                <a4j:commandButton title="Ajouter une nouveau lieu" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.ajouterChantier}" reRender="panelChantier"/>
                <a4j:commandButton title="Modifier le lieu sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.modifierChantier}" reRender="panelChantier"/>
                <a4j:commandButton title="Supprimer le lieu sélectionné" image="/images/supprimer.png" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.supprimerChantier}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer les lieux" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.dataModelChantier}"  var="cht">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.selectionChantier}" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{cht.anaCode}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{cht.anaCode}">
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{cht.anaNomFr}" width="60%">
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText  value="#{cht.anaNomFr}">
                        </h:outputText>
                    </rich:column>

                    <rich:column sortable="true" sortBy="#{cht.anaInactif}" width="5%">
                        <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                        <h:commandButton image="#{cht.anaInactif}"  id="inactif"  rendered="#{cht.afficheImag}"  onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.reactiverCompte}">
                            <a4j:support eventsQueue="maQueue" reRender="table"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelChantier" width="700" height="550" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES LIEUX"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelChantier"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Type:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaType}" style="width:100%">
                            <f:selectItem itemLabel="Chantier" itemValue="0"/>
                            <f:selectItem itemLabel="Rupture" itemValue="1"/>
                            <f:selectItem itemLabel="Gare" itemValue="2"/>
                            <f:selectItem itemLabel="Beach" itemValue="3"/>
                            <f:selectItem itemLabel="Usine" itemValue="4"/>
                            <f:selectItem itemLabel="Port" itemValue="5"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText id="inptcodAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaCode}" size="5" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.doublonCode}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaNomFr}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaMode}" style="width:100%">
                            <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="ATIBT" itemValue="1"/>
                            <f:selectItem itemLabel="OCTRA" itemValue="2"/>
                            <f:selectItem itemLabel="EXPORT" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Utilisé dans:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaUtilisation}" style="width:100%">
                            <f:selectItem itemLabel="Bordereau de rupture" itemValue="0"/>
                            <f:selectItem itemLabel="Bordreau de route" itemValue="1"/>
                            <f:selectItem itemLabel="Bordereau expédition" itemValue="2"/>
                            <f:selectItem itemLabel="Spécification" itemValue="3"/>
                            <f:selectItem itemLabel="Usine" itemValue="4"/>
                            <f:selectItem itemLabel="Tous les bordereaux" itemValue="5"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Marteau:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaMarteau}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="10"/></h:column>
                    <h:column><h:outputText value="Région:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaRegion}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Zone permis:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaPermis}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Propriétaire:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaProprietaire}" size="30" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Taux fermage OKM/OZG:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaTauxFermageOkm}" style="text-align:right">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prix m3 OKM/OZG:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaPrixOkm}" style="text-align:right">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Taux fermagz B.D.:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaTauxFermageBd}" style="text-align:right">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prix m3 B.D.:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaPrixBd}" style="text-align:right">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Taux précompte:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaTauxPrecompte}" style="text-align:right">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Taux redevance:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaTauxRedevance}" style="text-align:right">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prix pied:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.plansAnalytiques.anaPrixPied}" style="text-align:right">
                            <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="ppgrp">
                <center>
                    <br><br>
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.saveChantier}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.doublon}" reRender="panelChantier,table"/>
                </center>
                <center>
                    <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChantiersForet.doublon}"/>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
