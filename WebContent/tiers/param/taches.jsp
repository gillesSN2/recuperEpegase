<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tache">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES TACHES" style="color:green;"/></h2></center>

        <center>
            <h:panelGroup id="pangrpVisbt">
                <a4j:commandButton value="Ajout par Défaut" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.defaultAdd}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.afficheAjDefaut}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;" onclick="if (!confirm('Voulez-vous charger le plan comptable par défaut?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt,table"/>
                <br>
                <a4j:commandButton title="Ajouter une nouvelle tâche" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.ajouterTache}" reRender="panelAjt"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Modifier la tâche sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.modifierTache}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.showButtonModif}"  reRender="panelAjt"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Supprimer la tâche sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.showButtonSupp}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table,pangrpVisbt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.supprimerTache}" />&nbsp;&nbsp;&nbsp;
                <a4j:commandButton title="Imprimer la liste des tâches" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>&nbsp;&nbsp;&nbsp;
                <a4j:commandButton image="/images/exporter.png" title="Générer les Taches XML" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.exportXML}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente" rendered="false"/>
            </h:panelGroup>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" align="center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.datamodelTache}" var="tache">
                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.selectionTaches}" event="onRowClick" reRender="pangrpVisbt"/>
                    <rich:column sortable="true" sortBy="#{tache.tacMission}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Mission" /></f:facet>
                        <h:outputText value="#{tache.tacMission}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacCode}" width="10%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{tache.tacCode}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacNomFr}" width="30%">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText  value="#{tache.tacNomFr}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValPr}" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="P.R."/></f:facet>
                        <h:outputText  value="#{tache.tacValPr}" rendered="#{tache.tacValPr!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValPv}"  width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="P.V."/></f:facet>
                        <h:outputText  value="#{tache.tacValPv}" rendered="#{tache.tacValPv!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValJj}"  width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="JJ"/></f:facet>
                        <h:outputText  value="#{tache.tacValJj}" rendered="#{tache.tacValJj!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValHh}"  width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="HH"/></f:facet>
                        <h:outputText  value="#{tache.tacValHh}" rendered="#{tache.tacValHh!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValMm}"  width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="MM"/></f:facet>
                        <h:outputText  value="#{tache.tacValMm}" rendered="#{tache.tacValMm!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.tacValSs}"  width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="SS"/></f:facet>
                        <h:outputText  value="#{tache.tacValSs}" rendered="#{tache.tacValSs!=0}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{tache.etat}" width="10%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:commandButton   image="#{tache.etat}" id="etat" rendered="#{tache.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.reactiverTache}">
                            <a4j:support eventsQueue="maQueue" reRender="grpTable" event="onclick"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="700" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.showModalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.showModalPanel}" var="tac">
            <f:facet name="header"><h:outputText value="GESTION DES TACHES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton  image="/images/close.gif" styleClass="hidelink" id="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.annule}"/>
                    <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2"  style="width:100%;" columnClasses="clos35d,clos65">
                    <h:column><h:outputText value="Mission:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacMission}"  style="color:red">
                            <f:selectItem itemLabel="Sélection mission" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.mesMissionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacCode}" size="10" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.ajoutModif==1}">
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.verifCode}" reRender="panyas,ppgrp,btvaldAjt" />
                        </h:inputText>
                        <h:panelGroup id="panyas" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.ajoutModif==0}">
                            <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.existCod}">
                                <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;" />
                            </h:panelGroup>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacNomFr}" size="40" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="P.R.:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValPr}" size="10" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="P.V.:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValPv}" size="10" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Durée en nb jours:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValJj}" size="5" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Durée en nb heures:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValHh}" size="5" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Durée en nb minutes:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValMm}" size="5" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Durée en nb secondes:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.taches.tacValSs}" size="5" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <h:commandButton rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.existCod&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.ajoutModif==0)||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.ajoutModif==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTache.enregistrerTache}" image="/images/valider_big.png" id="btvaldAjt"/>
                    </center>
                    <center>
                        <br>
                        <h:outputText style="color:red;" value="Le code est obligatoire et doit être unique." />
                        <br>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
