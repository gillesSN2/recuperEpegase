<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions!=null}" var="mispay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formMissions.var_action<=8}" >
            <jsp:include flush="true" page="/paye/MissionsFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/paye/MissionsList.jsp" /></c:otherwise>

    </c:choose>

</c:if>
