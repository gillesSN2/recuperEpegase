<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="SelEXOVte">

    <a4j:form id="formSelExo" >
        <center>

            <center> <h2><h:outputText value="SELECTION DES EXERCICES MEDICAL" styleClass="titre"/></h2></center>

            <h:panelGrid style="border:solid 1px black;height:30px;text-align:center;" border="0"  columns="2" width="350"  styleClass="headerTab">
                <h:column><h:outputText value="Date de Début"/></h:column>
                <h:column><h:outputText value="Date de Fin"/></h:column>
            </h:panelGrid>

            <h:panelGrid style="max-height:100%;border:solid 0px green;cursor:pointer;overflow-y:auto;" border="0"  columns="2" width="350" columnClasses="cols,cols">
                <h:panelGrid style="margin-top:15px">
                    <center>
                        <h:selectOneRadio layout="pageDirection" style="margin-left:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.leIdExo}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formExercicesMedical.listExo}"/>
                            <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.recupererLeIdExo}" reRender="pboard" event="onchange"  />
                        </h:selectOneRadio>
                    </center>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

</f:subview>