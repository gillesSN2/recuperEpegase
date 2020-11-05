<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin!=null}" var="simpay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==10}" >
            <jsp:include flush="true" page="/commun/listeSalariesContrats.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/paye/SimulationFiche.jsp"/></c:otherwise>

    </c:choose>

</c:if>