<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse!=null}" var="poipay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_action<=8}" >
            <jsp:include flush="true" page="/paye/AnalyseCvFiche.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/paye/AnalyseCvList.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>
