<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire!=null}" var="pai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action<=3}">
            <jsp:include flush="true" page="/medical/PaillasseFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==5}" >
            <jsp:include flush="true" page="/medical/tiersPatientFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==6}" >
            <jsp:include flush="true" page="/medical/PaillassePrelevement.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/PaillasseListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>

