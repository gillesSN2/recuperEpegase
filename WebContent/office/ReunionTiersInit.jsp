<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion!=null}" var="reu3">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_action<=3}" >
            <jsp:include flush="true" page="/office/ReunionTiersFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/office/ReunionTiersListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>