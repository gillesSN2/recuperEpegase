<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersPatentPec">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>
        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Patients pris en charge par : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableParticipant" maxPages="20" align="left" for="tableParticipant"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" styleClass="bg" id="tableParticipant" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" height="300px"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelParticipants}" var="par">
                        <rich:column label="Dossier du patient" sortable="true" sortBy="#{par.patient.patDossier}" width="20%">
                            <f:facet name="header"><h:outputText  value="Dossier"/></f:facet>
                            <h:outputText value="#{par.patient.patDossier}"/>
                        </rich:column>
                        <rich:column label="Civilité du patient" sortable="true" sortBy="#{par.patient.patCivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité"/></f:facet>
                            <h:outputText value="#{par.patient.patCivilite}"/>
                        </rich:column>
                        <rich:column label="Nom du patient" sortable="true" sortBy="#{par.patient.patNom}" width="30%">
                            <f:facet name="header"><h:outputText  value="Nom"/></f:facet>
                            <h:outputText value="#{par.patient.patNom}"/>
                        </rich:column>
                        <rich:column label="Prénom du patient" sortable="true" sortBy="#{par.patient.patPrenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom"/></f:facet>
                            <h:outputText value="#{par.patient.patPrenom}"/>
                        </rich:column>
                        <rich:column label="N° CNSS" sortable="true" sortBy="#{par.patient.patSecu}" width="20%">
                            <f:facet name="header"><h:outputText  value="CNSS"/></f:facet>
                            <h:outputText value="#{par.patient.patSecu}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourPatientsPec}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
