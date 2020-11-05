<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin!=null}" var="bulpay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==2}">
            <jsp:include flush="true" page="/paye/GenerationFiche.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCalculBulletin.var_action==3}">
            <jsp:include flush="true" page="/paye/GenerationJournalier.jsp"/>
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/paye/GenerationList.jsp"/>
        </c:otherwise>

    </c:choose>
</c:if>
