<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersAdherents">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Adhérents de : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idAdherent">
                <h:panelGrid  id="btnAdherent" columns="2" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton image="/images/ajouter.png" title="Ajouter adhérent" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterAherent}" reRender="panelAdherent,btnAdherent"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer adhérent" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerAdherent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtAdherent}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnAdherent,tableAdherent"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="border:solid 0px green;" id="tableAdherent" border="0" height="350px" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelAdherent}" var="cvn" >
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionAdherent}" reRender="btnAdherent"/>
                        <rich:column label="Société adhérente" sortable="true" sortBy="#{cvn.tieadhRaisonSociale}" width="100%">
                            <f:facet name="header" ><h:outputText value="Société adhérente"/></f:facet>
                            <h:outputText value="#{cvn.tieadhRaisonSociale}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourAdhesion}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   id="panelAdherent" headerClass="headerPanel" width="450" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAdherent}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelAdherent}" var="cvn">
            <f:facet name="header"><h:outputText value="GESTION DES ADHERENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerAdherent}" image="/images/close.gif" styleClass="hidelink" reRender="panelAdherent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  width="100%" columns="2" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Nom société:" style="width:100%"/></h:column>
                        <h:column><h:inputText style="width:90%;text-transform:uppercase" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.tiersAdherent.tieadhRaisonSociale}" maxlength="100" /></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valAdherent">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanConv" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.validerAdherent}" reRender="panelAdherent,idAdherent"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
