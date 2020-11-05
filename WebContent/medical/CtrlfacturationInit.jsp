<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation!=null}" var="crtlfac">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action<=3}" >
            <jsp:include flush="true" page="/medical/CtrlfacturationFiche.jsp" />
        </c:when>
         <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/CtrlfacturationListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>



