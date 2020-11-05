<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBonEncaissementImmobilier!=null}" var="bcimmo">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBonEncaissementImmobilier.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBonEncaissementImmobilier.var_action<=9}" >
            <jsp:include flush="true" page="/immobilier/BonEncaissementFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBonEncaissementImmobilier.var_action>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBonEncaissementImmobilier.var_action<=19}" >
            <jsp:include flush="true" page="/immobilier/BonEncaissementFicheMultiple.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/immobilier/BonEncaissementList.jsp" /></c:otherwise>

    </c:choose>

</c:if>