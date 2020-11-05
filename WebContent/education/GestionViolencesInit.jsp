<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves!=null}" var="violdu">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action<=8}" >
            <jsp:include flush="true" page="/education/GestionViolencesFiche.jsp"/>
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/education/GestionViolencesList.jsp" /></c:otherwise>

    </c:choose>

</c:if>