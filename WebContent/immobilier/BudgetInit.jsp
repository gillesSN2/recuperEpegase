<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier!=null}" var="budimmo">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action==21}" >
            <jsp:include flush="true" page="/immobilier/BudgetFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/immobilier/BudgetListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>