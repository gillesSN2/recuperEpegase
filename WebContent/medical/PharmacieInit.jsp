<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie!=null}" var="pha">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_action<=3}" >
            <jsp:include flush="true" page="/medical/PharmacieFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_action==4}" >
            <jsp:include flush="true" page="/medical/RecherchePatient.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.var_action==5}" >
            <jsp:include flush="true" page="/medical/tiersPatientFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/PharmacieListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>

