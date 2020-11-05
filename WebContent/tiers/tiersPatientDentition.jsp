<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tiersPatientDentition">

    <jsp:include flush="true" page="/tiers/tiersPatientCommun.jsp" />

    <h:panelGrid width="1000px" style="border:1px solid black;height:580px;background-image:url('http://localhost:8080/epegase/images/schemaDentFdi.png')">

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable style="border:solid 0px green;" id="tableDentition" border="0" height="550px" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelDentition}" var="den" >
                <rich:column label="N° dent" sortable="true" sortBy="#{den.cslactDent}" width="10%">
                    <f:facet name="header" ><h:outputText value="Dent"/></f:facet>
                    <h:outputText value="#{den.cslactDent}"/>
                </rich:column>
                <rich:column label="Date consultation" sortable="true" sortBy="#{den.consultationEnteteGene.csgDate}" width="10%">
                    <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                    <h:outputText value="#{den.consultationEnteteGene.csgDate}"/>
                </rich:column>
                <rich:column label="Numéro consultation" sortable="true" sortBy="#{den.consultationEnteteGene.csgNum}" width="10%">
                    <f:facet name="header" ><h:outputText value="N° Csg."/></f:facet>
                    <h:outputText value="#{den.consultationEnteteGene.csgNum}"/>
                </rich:column>
                <rich:column label="Code acte" sortable="true" sortBy="#{den.cslactProduit}" width="10%">
                    <f:facet name="header" ><h:outputText value="Acte"/></f:facet>
                    <h:outputText value="#{den.cslactProduit}"/>
                </rich:column>
                <rich:column label="Libellé acte" sortable="true" sortBy="#{den.cslactLibelle}" width="30%">
                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                    <h:outputText value="#{den.cslactLibelle}"/>
                </rich:column>
                <rich:column label="Lettre" sortable="true" sortBy="#{den.cslactLettre}" width="10%">
                    <f:facet name="header" ><h:outputText value="Lettre"/></f:facet>
                    <h:outputText value="#{den.cslactNb} #{den.cslactLettre}"/>
                </rich:column>
                <rich:column label="Valeur acte" sortable="true" sortBy="#{den.cslactTotal}" width="20%" style="text-align:right">
                    <f:facet name="header" ><h:outputText value="Valeur"/></f:facet>
                    <h:outputText value="#{den.cslactTotal}">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>

    </h:panelGrid>

</f:subview>