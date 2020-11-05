<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation!=null}" var="prepay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==2}">
            <jsp:include flush="true" page="/paye/PreparationFiche.jsp" />
        </c:when>
         <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.var_action==3}">
            <jsp:include flush="true" page="/paye/PreparationJournalier.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/paye/PreparationList.jsp" />
        </c:otherwise>

    </c:choose>
</c:if>
