<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage!=null}" var="tmppay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action<=8}" >
            <jsp:include flush="true" page="/paye/TempsFiche0.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action<=8}" >
            <jsp:include flush="true" page="/paye/TempsFiche1.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/paye/TempsList.jsp" /></c:otherwise>

    </c:choose>

</c:if>