<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="conditionnement">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="LISTE DES CONDITIONNEMENTS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter un nouveau conditionnement" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.chargerPanAdd}"  reRender="panelAddFormAchats,formulaireajt"/>
                <a4j:commandButton title="Modifier le conditionnement sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.afficheButtModif}" reRender="panelAddFormAchats,formulaireajt"/>
                <a4j:commandButton title="Supprimer le conditionnement sélectionné" image="/images/supprimer.png"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.afficheButtModif}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.deleteUnite}" reRender="panelBouton,mytableau"/>
                <a4j:commandButton title="Imprimer les conditionnements" image="/images/print.png"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
                <br>
            </h:panelGrid>

            <br>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.madatamodel}"  var="cdt">
                    <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.selectionContitionnement}" reRender="panelBouton"/>
                    <rich:column  width="10%">
                        <f:facet name="header"><h:outputText  value="Conditionnement"/></f:facet>
                        <h:outputText  value="#{cdt.cdtLibelle}">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="20%">
                        <f:facet name="header"><h:outputText  value="Descriptif"/></f:facet>
                        <h:outputText  value="#{cdt.cdtDescription}">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="10%" style="text-align:right" rendered="#{cdt.cdtCoef1!=0}">
                        <f:facet name="header"><h:outputText  value="Qte.1"  /></f:facet>
                        <h:outputText  value="#{cdt.cdtCoef1}">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="20%">
                        <f:facet name="header"><h:outputText  value="Unité 1"  /></f:facet>
                        <h:outputText  value="#{cdt.cdtCodeUnite1} #{cdt.cdtUnite1} ">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="10%" style="text-align:right" rendered="#{cdt.cdtCoef2!=0}">
                        <f:facet name="header"><h:outputText  value="Qte.2"  /></f:facet>
                        <h:outputText  value="#{cdt.cdtCoef2}" >
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="20%">
                        <f:facet name="header"><h:outputText  value="Unité 2"  /></f:facet>
                        <h:outputText  value="#{cdt.cdtCodeUnite2} #{cdt.cdtUnite2}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="10%">
                        <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                        <h:commandButton image="#{cdt.etat}" rendered="#{cdt.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.reactiverUnite}" title="Supprimer" style="text-align:right;">
                            <a4j:support eventsQueue="maQueue" reRender="panelBouton,mytableau" event="onclick"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br/>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="530" height="350"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.showModalPanel}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="GESTION DES CONDITIONNEMENTS" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAddFormAchats"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>

        <a4j:form id="formulaireajt">
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid columns="2" columnClasses="clos25,clos75" id="panelGlobal">
                <h:column><h:outputText value="Conditionnement:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLibelle}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:150px;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Descriptif:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtDescription}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value="Quantité 1:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtCoef1}" onkeypress="return scanToucheLettre(event)" style="width:50px;text-align:right;"/></h:column>
                <h:column><h:outputText value="Unité 1:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_unite1}" style="width:300px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.mesUnites}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column><h:outputText value="Quantité 2:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtCoef2}" onkeypress="return scanToucheLettre(event)" style="width:50px;text-align:right;"/></h:column>
                <h:column><h:outputText value="Unité 2:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_unite2}" style="width:300px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.mesUnites}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.controleUnite}" reRender="panelGlobal" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=199}"><h:outputText value="Longueur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=199}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLong2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=299}"><h:outputText value="Longueur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=299}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLong2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=299}"><h:outputText value="Largeur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=299}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLarg2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:outputText value="Longueur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLong2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:outputText value="Largeur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLarg2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:outputText value="Hauteur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=399}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtHaut2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=499}"><h:outputText value="Longueur:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=499}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtLong2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=499}"><h:outputText value="Diamêtre:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=499}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtDiam2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=849}"><h:outputText value="Nombre:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=849}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtNb2}" style="text-align:right;" size="8"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=899}"><h:outputText value="Pression:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.var_code_unite<=899}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.conditionnement.cdtNb2}" style="text-align:right;" size="8"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formConditionnement.saveUnite}"  >
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
