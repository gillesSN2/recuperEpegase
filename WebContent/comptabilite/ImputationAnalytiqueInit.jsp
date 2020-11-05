<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables!=null}" var="impana">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action<=3}" >
            <jsp:include flush="true" page="/comptabilite/ImputationAnalytiqueFiche.jsp"/>
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/ImputationAnalytiqueList.jsp" /></c:otherwise>

    </c:choose>

</c:if>