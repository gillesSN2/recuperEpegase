<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation!=null}" var="refac">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action==1}" >
            <jsp:include flush="true" page="/medical/RecapitulatifFicheAjout.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action<=3}" >
            <jsp:include flush="true" page="/medical/RecapitulatifFicheModif.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/RecapitulatifListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>

