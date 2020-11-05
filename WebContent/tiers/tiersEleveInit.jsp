<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves!=null}" var="eletie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action<=3}" >
            <jsp:include flush="true" page="/tiers/tiersEleveFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formEleves.var_action==4}" >
            <jsp:include flush="true" page="/tiers/tiersEleveSituation.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/tiersEleveListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>
