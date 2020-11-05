<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse!=null}" var="jrjcai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.var_action<=3}">
            <jsp:include flush="true" page="/caisse/JournauxJournaliersFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/JournauxJournaliersList.jsp" /></c:otherwise>

    </c:choose>

</c:if>

