<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes!=null}" var="faclistvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_action<=8}" >
            <jsp:include flush="true" page="/ventes/FactureFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/ventes/LissageFactureListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>
