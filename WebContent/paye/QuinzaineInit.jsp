<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation!=null}" var="quipay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==2}">
            <jsp:include flush="true" page="/paye/QuinzaineFiche.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/paye/QuinzaineList.jsp" />
        </c:otherwise>

    </c:choose>
    
</c:if>
