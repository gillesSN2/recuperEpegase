<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<h:panelGrid  id="resultatTab" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_tableau}">
    <rich:dataTable rows="200" style="max-height:100%" styleClass="bg" id="tableResultat" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.dataModelResultat}" var="element">
        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectionFormule}" reRender="listeTableau"/>
        <rich:column width="40" sortable="true" sortBy="#{element.tabresNum}" sortOrder="ASCENDING">
            <f:facet name="header" ><h:outputText value="L."/></f:facet>
            <h:outputText value="#{element.tabresNum}" style="#{element.espaceFamille}"/>
        </rich:column >
        <rich:column width="100">
            <f:facet name="header" ><h:outputText value="Réf."/></f:facet>
            <h:outputText value="#{element.tabresReference}" style="#{element.espaceFamille}"/>
        </rich:column >
        <rich:column width="360">
            <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
            <h:outputText value="#{element.tabresLibFr}" style="#{element.espaceFamille}"/>
        </rich:column >
        <rich:column id="idCol01" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col1}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col01}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom01}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color01};" rendered="#{element.tabresTypeCol01==6}" value="#{element.tabresCol01}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif01}" reRender="idCol01"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol01==7}" value="#{element.tabresCon01}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol01==8}" value="#{element.tabresCon01}"/>
            <h:outputText value="#{element.tabresCol01}" style="#{element.espaceFamille};#{element.color01};" rendered="#{element.tabresCol01!=0&&(element.tabresTypeCol01<=5||element.tabresTypeCol01>=10)}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne01}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol02" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col2}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col02}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom02}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color02};" rendered="#{element.tabresTypeCol02==6}" value="#{element.tabresCol02}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif02}" reRender="idCol02"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol02==7}" value="#{element.tabresCon02}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol02==8}" value="#{element.tabresCon02}"/>
            <h:outputText value="#{element.tabresCol02}" style="#{element.espaceFamille};#{element.color02};" rendered="#{element.tabresCol02!=0&&(element.tabresTypeCol02<=5||element.tabresTypeCol02>=10)}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c02" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne02}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol03" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col3}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col03}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom03}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color03};" rendered="#{element.tabresTypeCol03==6}" value="#{element.tabresCol03}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif03}" reRender="idCol03"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol03==7}" value="#{element.tabresCon03}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol03==8}" value="#{element.tabresCon03}"/>
            <h:outputText value="#{element.tabresCol03}" style="#{element.espaceFamille};#{element.color03};" rendered="#{element.tabresCol03!=0&&(element.tabresTypeCol03<=5||element.tabresTypeCol03>=10)}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne03}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol04" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col4}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col04}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom04}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color04};" rendered="#{element.tabresTypeCol04==6}" value="#{element.tabresCol04}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif04}" reRender="idCol04"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol04==7}" value="#{element.tabresCon04}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol04==8}" value="#{element.tabresCon04}"/>
            <h:outputText value="#{element.tabresCol04}" style="#{element.espaceFamille};#{element.color04};" rendered="#{element.tabresCol04!=0&&(element.tabresTypeCol04<=5||element.tabresTypeCol04>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne04}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol05" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col5}"  style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col05}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom05}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color05};" rendered="#{element.tabresTypeCol05==6}" value="#{element.tabresCol05}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif05}" reRender="idCol05"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol05==7}" value="#{element.tabresCon05}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol05==8}" value="#{element.tabresCon05}"/>
            <h:outputText value="#{element.tabresCol05}" style="#{element.espaceFamille};#{element.color05};" rendered="#{element.tabresCol05!=0&&(element.tabresTypeCol05<=5||element.tabresTypeCol05>=10)}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne05}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol06" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col6}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col06}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom06}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color06};" rendered="#{element.tabresTypeCol06==6}" value="#{element.tabresCol06}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif06}" reRender="idCol06"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol06==7}" value="#{element.tabresCon06}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol06==8}" value="#{element.tabresCon06}"/>
            <h:outputText value="#{element.tabresCol06}" style="#{element.espaceFamille};#{element.color06};" rendered="#{element.tabresCol06!=0&&(element.tabresTypeCol06<=5||element.tabresTypeCol06>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne06}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol07" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col7}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col07}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom07}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color07};" rendered="#{element.tabresTypeCol07==6}" value="#{element.tabresCol07}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif07}" reRender="idCol07"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol07==7}" value="#{element.tabresCon07}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol07==8}" value="#{element.tabresCon07}"/>
            <h:outputText value="#{element.tabresCol07}" style="#{element.espaceFamille};#{element.color07};" rendered="#{element.tabresCol07!=0&&(element.tabresTypeCol07<=5||element.tabresTypeCol07>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne07}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol08" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col8}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col08}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom08}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color08};" rendered="#{element.tabresTypeCol08==6}" value="#{element.tabresCol08}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif08}" reRender="idCol08"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol08==7}" value="#{element.tabresCon08}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol08==8}" value="#{element.tabresCon08}"/>
            <h:outputText value="#{element.tabresCol08}" style="#{element.espaceFamille};#{element.color08};" rendered="#{element.tabresCol08!=0&&(element.tabresTypeCol08<=5||element.tabresTypeCol08>=10)}" >
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne08}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol09" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col9}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col08}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom09}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color09};" rendered="#{element.tabresTypeCol09==6}" value="#{element.tabresCol09}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif09}" reRender="idCol09"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol09==7}" value="#{element.tabresCon09}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol09==8}" value="#{element.tabresCon09}"/>
            <h:outputText value="#{element.tabresCol09}" style="#{element.espaceFamille};#{element.color09};" rendered="#{element.tabresCol09!=0&&(element.tabresTypeCol09<=5||element.tabresTypeCol09>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne09}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol10" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col10}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col10}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom10}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color10};" rendered="#{element.tabresTypeCol10==6}" value="#{element.tabresCol10}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif10}" reRender="idCol10"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==7}" value="#{element.tabresCon10}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==8}" value="#{element.tabresCon10}"/>
            <h:outputText value="#{element.tabresCol10}" style="#{element.espaceFamille};#{element.color10};" rendered="#{element.tabresCol10!=0&&(element.tabresTypeCol10<=5||element.tabresTypeCol10>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne10}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column>
        <rich:column id="idCol11" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col11}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col11}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom11}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color11};" rendered="#{element.tabresTypeCol11==6}" value="#{element.tabresCol11}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif11}" reRender="idCol11"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol11==7}" value="#{element.tabresCon11}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol11==8}" value="#{element.tabresCon11}"/>
            <h:outputText value="#{element.tabresCol11}" style="#{element.espaceFamille};#{element.color11};"  rendered="#{element.tabresCol11!=0&&(element.tabresTypeCol11<=5||element.tabresTypeCol11>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne11}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol12" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col12}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col12}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom12}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color12};" rendered="#{element.tabresTypeCol12==6}" value="#{element.tabresCol12}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif12}" reRender="idCol12"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol12==7}" value="#{element.tabresCon12}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol12==8}" value="#{element.tabresCon12}"/>
            <h:outputText value="#{element.tabresCol12}" style="#{element.espaceFamille};#{element.color12};" rendered="#{element.tabresCol12!=0&&(element.tabresTypeCol12<=5||element.tabresTypeCol12>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne12}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol13" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col13}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col13}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom13}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color13};" rendered="#{element.tabresTypeCol13==6}" value="#{element.tabresCol13}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif13}" reRender="idCol13"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol13==7}" value="#{element.tabresCon13}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol13==8}" value="#{element.tabresCon13}"/>
            <h:outputText value="#{element.tabresCol13}" style="#{element.espaceFamille};#{element.color13};" rendered="#{element.tabresCol13!=0&&(element.tabresTypeCol13<=5||element.tabresTypeCol13>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne13}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol14" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col14}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col14}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom14}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color14};" rendered="#{element.tabresTypeCol14==6}" value="#{element.tabresCol14}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif14}" reRender="idCol14"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol14==7}" value="#{element.tabresCon14}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol14==8}" value="#{element.tabresCon14}"/>
            <h:outputText value="#{element.tabresCol14}" style="#{element.espaceFamille};#{element.color14};" rendered="#{element.tabresCol14!=0&&(element.tabresTypeCol14<=5||element.tabresTypeCol14>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne14}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol15" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col15}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col15}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom15}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color15};" rendered="#{element.tabresTypeCol15==6}" value="#{element.tabresCol15}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif15}" reRender="idCol15"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol15==7}" value="#{element.tabresCon15}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol15==8}" value="#{element.tabresCon15}"/>
            <h:outputText value="#{element.tabresCol15}" style="#{element.espaceFamille};#{element.color15};" rendered="#{element.tabresCol15!=0&&(element.tabresTypeCol15<=5||element.tabresTypeCol15>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne15}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol16" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col16}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col16}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom16}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color16};" rendered="#{element.tabresTypeCol10==6}" value="#{element.tabresCol16}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif16}" reRender="idCol16"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol16==7}" value="#{element.tabresCon16}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol16==8}" value="#{element.tabresCon16}"/>
            <h:outputText value="#{element.tabresCol16}" style="#{element.espaceFamille};#{element.color16};" rendered="#{element.tabresCol16!=0&&(element.tabresTypeCol16<=5||element.tabresTypeCol16>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne16}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol17" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col17}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col17}" >
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom17}"/>
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color17};" rendered="#{element.tabresTypeCol17==6}" value="#{element.tabresCol17}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif17}" reRender="idCol17"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol17==7}" value="#{element.tabresCon17}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol17==8}" value="#{element.tabresCon17}"/>
            <h:outputText value="#{element.tabresCol17}" style="#{element.espaceFamille};#{element.color17};" rendered="#{element.tabresCol17!=0&&(element.tabresTypeCol17<=5||element.tabresTypeCol17>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne17}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol18" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col18}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col18}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom18}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color18};" rendered="#{element.tabresTypeCol18==6}" value="#{element.tabresCol18}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif18}" reRender="idCol18"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol18==7}" value="#{element.tabresCon18}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol18==8}" value="#{element.tabresCon18}"/>
            <h:outputText value="#{element.tabresCol18}" style="#{element.espaceFamille};#{element.color18};" rendered="#{element.tabresCol18!=0&&(element.tabresTypeCol18<=5||element.tabresTypeCol18>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne18}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol19" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col19}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col19}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom19}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color19};" rendered="#{element.tabresTypeCol19==6}" value="#{element.tabresCol19}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif19}" reRender="idCol19"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol19==7}" value="#{element.tabresCon19}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol19==8}" value="#{element.tabresCon19}"/>
            <h:outputText value="#{element.tabresCol19}" style="#{element.espaceFamille};#{element.color19};" rendered="#{element.tabresCol19!=0&&(element.tabresTypeCol19<=5||element.tabresTypeCol19>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne19}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
        <rich:column id="idCol20" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_largeur_col20}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.var_aff_col20}">
            <f:facet name="header" >
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.cptTabNom.tablisNom20}" />
            </f:facet>
            <h:inputText style="text-align:right;width:95%;#{element.espaceFamille};#{element.color20};" rendered="#{element.tabresTypeCol20==6}" value="#{element.tabresCol20}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.verifModif20}" reRender="idCol20"/>
            </h:inputText>
            <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol20==7}" value="#{element.tabresCon20}"/>
            <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol20==8}" value="#{element.tabresCon20}"/>
            <h:outputText value="#{element.tabresCol20}" style="#{element.espaceFamille};#{element.color20};" rendered="#{element.tabresCol20!=0&&(element.tabresTypeCol20<=5||element.tabresTypeCol20>=10)}">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.detailColonne20}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
            </h:outputText>
        </rich:column >
    </rich:dataTable>
</h:panelGrid>