<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList!=null}" var="exta">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_action==10}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeActivites.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_action==16}" >
            <jsp:include flush="true" page="/commun/listeDossierTransit.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.var_action==17}" >
            <jsp:include flush="true" page="/comptabilite/ExtraitAnalAnalytique.jsp"/>
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/ExtraitAnalList.jsp"/></c:otherwise>

    </c:choose>

</c:if>