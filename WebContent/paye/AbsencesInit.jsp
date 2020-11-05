<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges!=null}" var="abspay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action<=8}" >
            <jsp:include flush="true" page="/paye/AbsencesFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeSalaries.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/paye/AbsencesList.jsp" /></c:otherwise>

    </c:choose>

</c:if>