<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="douane">

    <center><h2><h:outputText value="Positions tarifaires (TARIC)" style="color:green;"/></h2></center>

    <a4j:form id="formDouane">

        <h:panelGrid width="100%" border="0">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='https'}"var="ac1">
                <iframe width="100%" height="600px" src="https://www.tarifdouanier.eu/" frameborder="0"></iframe>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='http'}"var="ac2">
                <iframe width="100%" height="600px" src="https://www.tarifdouanier.eu/" frameborder="0"></iframe>
            </c:if>

        </h:panelGrid>

    </a4j:form>

</f:subview>
