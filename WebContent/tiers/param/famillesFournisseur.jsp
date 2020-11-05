<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tfm">

    <center>
        <a4j:form>
            <center> <h2><h:outputText value="FAMILLE DES FOURNISSEURS" style="color:green;"/></h2></center>

            <h:panelGrid id="panelBtnCtiers" width="200px" columns="4">
                <h:commandButton image="/images/ajouter.png" title="Ajout famille tiers"id="AdfmtC" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.lanceAjouter}" />
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.btnModFournisseur}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.lanceModif}" title="Modification Famille"image="/images/modifier.png"/>
                <h:commandButton  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.btnModFournisseur}" title="Suppression famille" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.supprimer}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                <a4j:commandButton title="Imprimer les familles de fournisseurs" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <h:panelGroup >
                <center>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="fmtClt" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.dataModelFournisseur}" var="fmttiersxml">
                            <a4j:support eventsQueue="maQueue" reRender="panelBtnCtiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.selectionLigne}" event="onRowClick" />
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="N."/> </f:facet>
                                <h:outputText value="#{fmttiersxml.indice}"></h:outputText>
                            </rich:column>
                            <rich:column width="50%" sortable="false">
                                <f:facet name="header"><h:outputText value="Libellé"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.libelle}"></h:outputText>
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"> <h:outputText value="TVA"/></f:facet>
                                <h:outputText value="#{fmttiersxml.libTva}"/>
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"><h:outputText value="Douanes"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.libDou}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false">
                                <f:facet name="header"><h:outputText value="Journal"/> </f:facet>
                                <h:outputText value="#{fmttiersxml.serie}"></h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </center>
            </h:panelGroup>
            <br>
            <center>
                <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
                <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
            </center>
        </a4j:form>
    </center>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtFournisseurs" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.afficheModePanelAjt}" width="600" height="300">
        <f:facet name="header">
            <h:panelGroup><h:outputText style="font-weight:bold;font-size:12px;"value="AJOUT DE FAMILLE DE FOURNISSEUS"></h:outputText></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelfmtclients"/>
                <rich:componentControl for="panelfmtFournisseurs" attachTo="bpanelfmtclients" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formfmtAFournisseurs" style="width:100%;">
                <h:panelGrid columns="2">
                    <h:column><h:outputText value="Libellé"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.lib}"/></h:column>
                    <h:column><h:outputText value="TVA"/></h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.exoT}">
                        <f:selectItem itemLabel="AVEC TVA" itemValue="0"/>
                        <f:selectItem itemLabel="EXONERE TVA" itemValue="1"/>
                        <f:selectItem itemLabel="PRECOMPTE" itemValue="2"/>
                    </h:selectOneRadio>
                    <h:column><h:outputText value="DOUANES"/></h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.exoD}">
                        <f:selectItem itemLabel="AVEC DOUANES" itemValue="0"/>
                        <f:selectItem itemLabel="EXONERE DE DOUANES" itemValue="1"/>
                    </h:selectOneRadio>
                    <h:column><h:outputText value="Journal"/></h:column>
                    <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.ser}"/></h:column>
                </h:panelGrid>
                <center>
                    <br>
                    <h:column>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.majAjout}"/>
                    </h:column>
                </center>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.afficheModePanel}" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" id="panelfmtFournisseursModif" width="600" height="300">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText style="font-weight:bold;font-size:12px;"value="MODIFICATION DE FAMILLE DE FOURNISSEURS"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.closeModif}"  image="/images/close.gif" styleClass="hidelink" id="bpanelmodclients"/>
                <rich:componentControl for="panelfmtFournisseursModif" attachTo="bpanelmodclients" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form id="formfmtAFournisseursModif"style="width:100%;">
                <h:panelGrid columns="2">
                    <h:column><h:outputText value="Libellé"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.lib}"/></h:column>
                    <h:column><h:outputText value="TVA"/></h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.exoT}">
                        <f:selectItem itemLabel="AVEC TVA" itemValue="0"/>
                        <f:selectItem itemLabel="EXONERE TVA" itemValue="1"/>
                        <f:selectItem itemLabel="BRS/TPS (PRESTATIONS)" itemValue="2"/>
                    </h:selectOneRadio>
                    <h:column><h:outputText value="DOUANES"/></h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.exoD}">
                        <f:selectItem itemLabel="AVEC DOUANES" itemValue="0"/>
                        <f:selectItem itemLabel="EXONERE DE DOUANES" itemValue="1"/>
                    </h:selectOneRadio>
                    <h:column><h:outputText value="Journal"/></h:column>
                    <h:column><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.ser}"/></h:column>
                </h:panelGrid>
                <center>
                    <br>
                    <h:column>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleFournisseur.majModif}"/>
                    </h:column>
                </center>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>