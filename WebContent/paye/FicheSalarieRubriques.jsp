<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid style="width:100%;" id="panBulletin">

    <a4j:form>

        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MES BULLETINS" style="color:green;" /></h2></center>
        </h:column>

         <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
             Cliquez  <A target="_blank" HREF="https://www.impots-et-taxes.com/formulaire.php" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site de calclul des taxes et impôts du Gabon.<br><br>
        </h:column>

        <a4j:region renderRegionOnly="false" id="panListeRubrique">
            <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.dataModelListeRubriques}" enableContextMenu="false" var="lstrub" id="listeRubrique" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                <rich:column width="60px" sortable="false">
                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                    <h:outputText value="#{lstrub.bulligRubrique}" style="#{lstrub.espaceFamille}"/>
                </rich:column>
                <rich:column width="200px" sortable="false" >
                    <f:facet name="header"><h:outputText value="Libelle"/></f:facet>
                    <h:outputText value="#{lstrub.bulligLibelle}" style="#{lstrub.espaceFamille}"/>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Janvier"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam01}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts01}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts01!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants01}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants01!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf01}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf01!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v01}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v01!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Février"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam02}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts02}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts02!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants02}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants02!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf02}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf02!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v02}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v02!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Mars"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam03}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts03}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts03!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants03}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants03!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf03}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf03!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v03}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v03!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Avril"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam04}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts04}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts04!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants04}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants04!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf04}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf04!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v04}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v04!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Mai"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam05}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts05}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts05!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants05}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants05!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf05}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf05!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v05}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v05!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Juin"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam06}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts06}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts06!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants06}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants06!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf06}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf06!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v06}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v06!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Juillet"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam07}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts07}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts07!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants07}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants07!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf07}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf07!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v07}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v07!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Aout"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam08}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts08}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts08!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants08}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants08!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf08}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf08!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v08}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v08!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Septembre"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam09}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts09}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts09!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants09}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants09!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf09}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf09!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v09}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v09!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Octobre"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam10}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts10}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts10!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants10}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants10!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf10}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf10!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v10}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v10!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Novembre"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam11}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts11}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts11!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants11}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants11!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf11}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf11!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v11}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v11!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="80px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="Décembre"/></f:facet>
                    <h:outputText value="#{lstrub.vlibSitFam12}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.bulligRubrique=='1'}"/>
                    <h:outputText value="#{lstrub.vnbParts12}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbParts12!=0&&lstrub.bulligRubrique=='2'}"/>
                    <h:outputText value="#{lstrub.vnbEnfants12}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbEnfants12!=0&&lstrub.bulligRubrique=='3'}"/>
                    <h:outputText value="#{lstrub.vnbTrimf12}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.vnbTrimf12!=0&&lstrub.bulligRubrique=='4'}"/>
                    <h:outputText value="#{lstrub.v12}" style="text-align:right;#{lstrub.espaceFamille};" rendered="#{lstrub.v12!=0&&lstrub.bulligRubrique>='100000'}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
                <rich:column width="90px" sortable="false" style="text-align:right;">
                    <f:facet name="header"><h:outputText value="TOTAL"/></f:facet>
                    <h:outputText value="#{lstrub.vTotal}" rendered="#{lstrub.vTotal!=0}" style="text-align:right;#{lstrub.espaceFamille};">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
    </a4j:form>

</h:panelGrid>

