<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="meteo">

    <center><h2><h:outputText value="Météo: (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.nomPays}) #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.nomVille}, #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strisopays}" style="color:green;"/></h2></center>

    <a4j:form id="formMeteo">

        <h:panelGroup id="panMeteo">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='https'}"var="ac1">
                <a href="https://www.accuweather.com/en/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.codeIso}/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.nomVille}/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMeteoCodeVille}/current-weather/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMeteoCodeVille}" class="aw-widget-legal">
                </a><div id="awtd1407416230173" class="aw-widget-36hour"  data-locationkey="" data-unit="c" data-language="fr" data-useip="true" data-uid="awtd1407416230173" data-editlocation="true"></div><script type="text/javascript" src="https://oap.accuweather.com/launch.js"></script>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='http'}"var="ac2">
                <a href="http://www.accuweather.com/en/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.codeIso}/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.nomVille}/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMeteoCodeVille}/current-weather/${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strMeteoCodeVille}" class="aw-widget-legal">
                </a><div id="awtd1407416230173" class="aw-widget-36hour"  data-locationkey="" data-unit="c" data-language="fr" data-useip="true" data-uid="awtd1407416230173" data-editlocation="true"></div><script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>
            </c:if>

        </h:panelGroup>

    </a4j:form>

</f:subview>
