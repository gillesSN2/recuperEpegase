<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession!=null}" var="cesstk">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.var_action<=8}" >
            <jsp:include flush="true" page="/stock/CessionFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.var_action==13}" >
            <jsp:include flush="true" page="/commun/ficheProduit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.var_action==14}" >
            <jsp:include flush="true" page="/commun/listeSommiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCession.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsAchats.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/stock/CessionList.jsp" /></c:otherwise>

    </c:choose>

</c:if>