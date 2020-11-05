<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical!=null}" var="bcmed">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_action<=9}" >
            <jsp:include flush="true" page="/medical/BonEncaissementFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_action>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_action<=19}" >
            <jsp:include flush="true" page="/medical/BonEncaissementFicheMultiple.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/BonEncaissementList.jsp" /></c:otherwise>

    </c:choose>

</c:if>

