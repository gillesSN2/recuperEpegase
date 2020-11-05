<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="codageMd5">

    <a4j:form id="formcodageMd5">

        <center> <h2><h:outputText value="CODAGE MD5" style="color:green;"/></h2></center>

        <h:panelGrid width="100%" columns="2">

            <h:column><h:outputText value="Chaine à convertir:"/></h:column>
            <h:column>
                <h:inputText size="40" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.chaineAConvertir}">
                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.calculCodage}" reRender="idResultat"/>
                </h:inputText>
            </h:column>

            <h:column><h:outputText value="Chaine convertie:"/></h:column>
            <h:column><h:inputText size="40" id="idResultat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formTiersTechnique.chaineConvertie}" readonly="true"/></h:column>

        </h:panelGrid>

    </a4j:form>

</f:subview>