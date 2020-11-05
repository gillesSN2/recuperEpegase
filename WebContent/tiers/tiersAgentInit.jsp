<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents!=null}" var="agttie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_action==4}" >
            <jsp:include flush="true" page="/tiers/tiersRDVUser.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_action==5}" >
            <jsp:include flush="true" page="/tiers/tiersMessagerieUser.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAgents.var_action==6}" >
            <jsp:include flush="true" page="/tiers/tiersDocumentsUser.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/tiersAgentListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>