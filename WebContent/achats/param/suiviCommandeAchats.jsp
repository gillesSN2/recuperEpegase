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

        <center><h2><h:outputText value="LISTE DES SUIVIS COMMANDES SUR ACHAT" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="4" width="200px">
            <a4j:commandButton title="Ajouter un nouveau poste de suivi" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.chargerPanAdd}" reRender="panelAddSuiviCmd"/>
            <a4j:commandButton title="Modifier le poste de suivi sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.afficheButtModif}"  reRender="panelAddSuiviCmd" />
            <a4j:commandButton  title="supprimer" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.afficheButtModif}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.deleteSuiviCom}" reRender="panelBouton,mytableauSuiviCmd" />
            <a4j:commandButton title="imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
        </h:panelGrid>
        <br>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableauSuiviCmd" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.madatamodel}"  var="suiviCmd">
                <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.selectionSuivi}" reRender="panelBouton" />
                <f:facet name="header">
                </f:facet>
                <rich:column style="heigth:20px;" sortable="true"  width="10%">
                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                    <h:outputText style="size:5px;"value="#{suiviCmd.suiachCode}">
                    </h:outputText>
                </rich:column>
                <rich:column style="heigth:20px;" width="80%">
                    <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                    <h:outputText  value="#{suiviCmd.suiachLibelleFr}">
                    </h:outputText>
                </rich:column>
                <rich:column >
                    <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                    <h:commandButton image="#{suiviCmd.etat}" rendered="#{suiviCmd.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.reactiverCompte}" title="Supprimer" style="text-align:right;">
                        <a4j:support eventsQueue="maQueue" reRender="mytableauSuiviCmd" event="onclick"/>
                    </h:commandButton>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAddSuiviCmd" width="530" height="300"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.showPannel}">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="GESTION DE SUIVI COMMANDE SUR ACHAT" />
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelBouton,panelAddSuiviCmd"/>
            </a4j:form>
        </f:facet>

        <a4j:form>
            <h:panelGrid columns="2" width="100%">
                <h:outputText value="Code:"/>
                <h:panelGroup id="panyas">
                    <h:inputText onkeyup ="javascript:this.value=this.value.toUpperCase();" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.suiviCommandeAchats.suiachCode}"  style="width:50px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.suiviCommandeAchats.suiachId!=0}">
                        <a4j:support eventsQueue="maQueue" event="onchange"  reRender="panyas,buttGrp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.verifCode}"/>
                    </h:inputText>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.existCod}" style="margin-left:20px;">
                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                        <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;size:100;" />
                    </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Libellé:"/>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.suiviCommandeAchats.suiachLibelleFr}" style="width:250px;"/>
                <h:outputText value="Utilisation:"/>
                <h:panelGrid columns="2">
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.inAerAdd}">
                    </h:selectBooleanCheckbox>
                    <h:outputText value="Aérien"/>
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.inMarAdd}">
                    </h:selectBooleanCheckbox>
                    <h:outputText value="Maritime"/>
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.inExprAdd}">
                    </h:selectBooleanCheckbox>
                    <h:outputText value="Express"/>
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.inRoutAdd}">
                    </h:selectBooleanCheckbox>
                    <h:outputText value="Route"/>
                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.inAutrAdd}">
                    </h:selectBooleanCheckbox>
                    <h:outputText value="Autre transit"/>
                </h:panelGrid>
            </h:panelGrid>

            <center>
                <h:panelGroup  id="buttGrp">
                    <br>
                    <a4j:commandButton  id="bbbbbSaveSuiv" image="/images/valider_big.png"   rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.existCod}">
                        <rich:componentControl for="panelAddSuiviCmd" attachTo="bbbbbSaveSuiv" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick"reRender="panelAddSuiviCmd,mytableauSuiviCmd" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formSuiviCommandeAchats.saveSuiviCom}"/>
                    </a4j:commandButton >
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
