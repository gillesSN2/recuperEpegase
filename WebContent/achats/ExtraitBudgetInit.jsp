<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formExtraitBudget!=null}" var="extach">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formExtraitBudget.var_action==15}" >

        </c:when>

        <c:otherwise><jsp:include flush="true" page="/achats/ExtraitBudgetList.jsp" /></c:otherwise>

    </c:choose>

</c:if>