<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

    <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.var_action==10}">
        <jsp:include flush="true" page="/../commun/listePlanComptable.jsp"/>
    </c:when>

    <c:otherwise><jsp:include flush="true" page="../param/plansTresorerieList.jsp"/></c:otherwise>

</c:choose>

