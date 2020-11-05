<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients!=null}" var="pattie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action<=3}" >
            <jsp:include flush="true" page="/tiers/tiersPatientFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==4}" >
            <jsp:include flush="true" page="/tiers/tiersRDV.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==7}" >
            <jsp:include flush="true" page="/tiers/tiersDocumentsPat.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_action==8}" >
            <jsp:include flush="true" page="/tiers/tiersPatientLettresGaranties.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/tiersPatientListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>