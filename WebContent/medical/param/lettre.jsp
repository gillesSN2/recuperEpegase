<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">
    <a4j:form>

        <center><h2><h:outputText value="LISTE DES LETTRES MEDICALES" style="color:green;"/></h2></center>

        <h:panelGroup id="panelBouton">
            <a4j:commandButton title="Ajouter lettre" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.chargerPanAdd}"  oncomplete="javascript:Richfaces.showModalPanel('panelAddFormAchats');" reRender="panelAddFormAchats,formulaireajt"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton title="Modifier lettre" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.afficheButtModif}" oncomplete="javascript:Richfaces.showModalPanel('panelModifFormAchats');" reRender="panelModifFormAchats,formulairemod"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton title="Supprimer lettre" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.afficheButtModif}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.deleteLettreMedical}" reRender="panelBouton,mytableau"></a4j:commandButton> &nbsp; &nbsp;&nbsp;
            <a4j:commandButton title="Imprimer lettres" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
        </h:panelGroup>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.madatamodel}"  var="let">
                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.confirmer}" reRender="panelBouton,panelModifFormAchats"/>
                <rich:column  width="15%">
                    <f:facet name="header"><h:outputText  value="Lettre"  /></f:facet>
                    <h:outputText  value="#{let.letLettre}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="60%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{let.letLibelleFr}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="10%" style="text-align:right;">
                    <f:facet name="header"><h:outputText  value="Valeur" /></f:facet>
                    <h:outputText  value="#{let.letValeur}" rendered="#{let.letValeur!=0}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="10%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.optionMedical.cnamgs=='1'}">
                    <f:facet name="header"><h:outputText  value="Cnamgs" /></f:facet>
                    <h:outputText  value="#{let.letValeurCnamgs}" rendered="#{let.letValeurCnamgs!=0}">
                    </h:outputText>
                </rich:column>
                <rich:column width="5%">
                    <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                    <h:commandButton image="#{let.etat}" rendered="#{let.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.reactiverLettreMedical}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="panelBouton,mytableau" event="onclick"/>
                    </h:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br/>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="530" height="250"  headerClass="headerPanel" style="border:solid 0px black;background-color:white">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="AJOUT D'UNE LETTRE" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulaireajt">
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Lettre:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letLettre}" maxlength="4" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letLibelleFr}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Valeur:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letValeur}" style="width:100px;" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.optionMedical.cnamgs=='1'}"><h:outputText value="Valeur Cnamgs:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.optionMedical.cnamgs=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letValeurCnamgs}" style="width:100px;" /></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.saveLettreMedical}"  >
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <!--**********************   Modal panel pour la modification **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelModifFormAchats"  width="530" height="250"   headerClass="headerPanel" style="border:solid 0px black;background-color:white">

        <f:facet name="header">
            <h:panelGroup><h:outputText value="MODIFICATION D'UNE LETTRE"/></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink21"/>
                <rich:componentControl for="panelModifFormAchats" attachTo="hidelink21" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>

        <a4j:form id="formulairemod">
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Lettre:"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letLettre}" maxlength="4" readonly="true"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText size="45" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letLibelleFr}"  maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                <h:column><h:outputText value="Valeur:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letValeur}" style="width:100px;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.optionMedical.cnamgs=='1'}"><h:outputText value="Valeur Cnamgs:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.optionMedical.cnamgs=='1'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.lettreMedical.letValeurCnamgs}" style="width:100px;" /></h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.inactifModif}"/></h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formLettreMedical.upDateLettreMedical}">
                        <a4j:support eventsQueue="maQueue" event="onclick"  reRender="mytableau"/>
                    </h:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
