<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires!=null}" var="dsttie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action<=3}" >
            <jsp:include flush="true" page="/tiers/tiersDestinataireFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formDestinataires.var_action==7}" >
            <jsp:include flush="true" page="/tiers/tiersDocumentsDes.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/tiersDestinataireListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>