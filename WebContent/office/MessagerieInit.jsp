<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie!=null}" var="msm">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formMessagerie.var_action<=3}" >
            <jsp:include flush="true" page="/office/MessagerieFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/office/MessagerieListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>
