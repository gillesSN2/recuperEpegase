<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois!=null}" var="brm">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action<=3}">
            <jsp:include flush="true" page="/comptabilite/BrouillardsMoisFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==10}">
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==12}">
            <jsp:include flush="true" page="/commun/ficheTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==15}">
            <jsp:include flush="true" page="/commun/listeDossierTransit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.var_action==16}">
            <jsp:include flush="true" page="/commun/listeParcDossier.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/BrouillardsMoisList.jsp" /></c:otherwise>

    </c:choose>

</c:if>