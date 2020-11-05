<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation!=null}" var="lotstk">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_action<=8}" >
            <jsp:include flush="true" page="/stock/LotsFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/stock/LotsList.jsp" /></c:otherwise>

    </c:choose>

</c:if>