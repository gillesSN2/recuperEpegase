<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="racineCpta">


    <a4j:form >

        <center>
            <h2>
                <h:outputText value="RACINES COMPTABLES #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strzonefiscale}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.choixRacine==0}" style="color:green;font-size:16px;"/>
                <h:outputText value="RACINES COMPTABLES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.selecFiscalite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.choixRacine!=0}" style="color:green;font-size:16px;"/>&nbsp;&nbsp;
                <h:commandButton title="Permutter la fiscalité des racines" image="/images/permutter.jpeg" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.chargerMesracines}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.choixRacine!=0}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
            </h2>
        </center>

        <center>
            <a4j:commandButton image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImp');" />&nbsp;&nbsp;
            <a4j:commandButton image="/images/exporter.png" title="Générer les Racines XML" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.exportXML}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente" rendered="false"/>
            <a4j:commandButton image="/images/transferer.png" title="Générer le plan comptable à partir des racines" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.generationPlanComptable}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente" rendered="false"/>
            <a4j:commandButton image="/images/actualiser.png" title="Recharger les Racines" style="text-decoration:none;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.rechargerRacines}" onclick="if (!confirm('Etes-vous sur de vouloir recharger les Racines?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
        </center>
        <br/>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="table"/>
            <rich:extendedDataTable rows="200" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.lesfiscalites}" var="fiscal" id="table" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" align="center" width="100%">
                <rich:column width="10%" sortable="false" sortBy="#{fiscal.racCode}" sortOrder="ASCENDING">
                    <f:facet name="header"><h:outputText value="Code" /></f:facet>
                    <h:outputText value="#{fiscal.racCode}" />
                </rich:column>
                <rich:column width="60%">
                    <f:facet name="header"><h:outputText value="Libellé"  /> </f:facet>
                    <h:inputText value="#{fiscal.aff_racine}" style="background:transparent;border:0px;width:100%;font-size:12px;" readonly="true"/>
                </rich:column>
                <rich:column width="20%">
                    <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                    <h:outputText value="#{fiscal.racnature}" />
                </rich:column>
                <rich:column width="10%">
                    <f:facet name="header"><h:outputText  value="Taux" style="background:transparent;text-align:right;font-size:10px;"/></f:facet>
                    <h:inputText  value="#{fiscal.ractaux}" style="width:100%" rendered="#{fiscal.griser}" >
                        <f:convertNumber type="number" maxIntegerDigits="3" minFractionDigits="3"/>
                    </h:inputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <center>
            <h:messages  showDetail="true" showSummary="true" /><br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />&nbsp; &nbsp;&nbsp;
            <h:commandButton value="VALIDER"styleClass="exp_lienmenu" id="linkcom"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formRacines.saveracine}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
