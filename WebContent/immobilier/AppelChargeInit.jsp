<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier!=null}" var="appcha">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==31||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==41||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==51}" >
            <jsp:include flush="true" page="/immobilier/AppelChargeFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/immobilier/AppelChargeListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>