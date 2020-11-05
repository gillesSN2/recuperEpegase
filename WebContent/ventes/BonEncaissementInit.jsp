<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBonEncaissementVente!=null}" var="bcvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBonEncaissementVente.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBonEncaissementVente.var_action<=9}" >
            <jsp:include flush="true" page="/ventes/BonEncaissementFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBonEncaissementVente.var_action>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formBonEncaissementVente.var_action<=19}" >
            <jsp:include flush="true" page="/ventes/BonEncaissementFicheMultiple.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/ventes/BonEncaissementList.jsp" /></c:otherwise>

    </c:choose>

</c:if>
