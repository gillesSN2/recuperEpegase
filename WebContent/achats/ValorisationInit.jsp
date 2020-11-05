<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats!=null}" var="valach">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.var_action>=1}" >
            <jsp:include flush="true" page="/achats/ValorisationFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/achats/ValorisationList.jsp" /></c:otherwise>

    </c:choose>

</c:if>