<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="viewmarques" >

    <a4j:form enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="LISTE DES MARQUES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="200px">
                <h:commandButton title="Ajouter une nouvelle marque" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.visibleAjt}"/>
                <h:commandButton title="Modifier la marque sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.visibleMod}"/>
                <a4j:commandButton title="Supprimer la marque sélectionnée" image="/images/supprimer.png" reRender="table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.removeCompte}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                <a4j:commandButton title="Imprimer les marques" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
                <rich:extendedDataTable rows="200" footerClass="bard" headerClass="headerTab" border="0" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" id="table" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.datamodel}"  var="mark">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.selectionFormule}" reRender="panelBouton"/>
                    <rich:column sortable="true" sortBy="#{mark.marLibelleFr}" width="80%" >
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{mark.marLibelleFr}"/>
                    </rich:column>
                    <rich:column width="20%">
                        <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                        <h:commandButton image="#{mark.etat}" id="inactif" rendered="#{mark.afficheImag}" onclick="if (!confirm('Voulez-vous reactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.reactiverCompte}">
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



    <rich:modalPanel domElementAttachment="parent"  id="panelAjt" width="800" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES MARQUES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAjt"/>
                <rich:componentControl for="panelAjt" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGroup  style="width:100%;">
                <h:panelGrid  columns="2" style="width:100%;">
                    <h:outputText value="Libellé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.marques.marLibelleFr}" style="width:90%;" maxlength="50"/>
                    <h:outputLabel for="file" value="Photo:"/>
                    <h:panelGroup>
                        <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.uploadedFile}"/>
                        <h:commandButton styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.ajoutPhoto}">
                            <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                        </h:commandButton>
                        <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                    </h:panelGroup>
                    <br/>
                    <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.marques.marPhoto!=null}">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.urlphotoProd}" width="100px" height="100px"/>&nbsp;
                            <h:commandButton image="/images/annuler.gif"title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.reInitPhoto}"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.marques.marPhoto==null}">
                            <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                        </c:if>
                    </h:panelGroup>
                </h:panelGrid>
            </h:panelGroup>
            <center>
                <br><br>
                <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formMarques.saveFormules}"/>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
