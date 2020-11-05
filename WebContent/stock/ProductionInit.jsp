<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction!=null}" var="prdstk">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action<=8}" >
            <jsp:include flush="true" page="/stock/ProductionFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action<=8}" >
            <jsp:include flush="true" page="/stock/ProductionFichePapeterie.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action<=8}" >
            <jsp:include flush="true" page="/stock/ProductionFichePoulet.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action==13}" >
            <jsp:include flush="true" page="/commun/ficheProduit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsAchats.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action==16}" >
            <jsp:include flush="true" page="/commun/listeTaches.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action==17}" >
            <jsp:include flush="true" page="/commun/listeActivites.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_action==18}" >
            <jsp:include flush="true" page="/commun/listeChantiers.jsp" />
        </c:when>

        <c:otherwise>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='0'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='1'}">
                <jsp:include flush="true" page="/stock/ProductionList.jsp" />
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modeReception=='2'}">
                <jsp:include flush="true" page="/stock/ProductionListPoulet.jsp" />
            </c:if>
        </c:otherwise>

    </c:choose>

</c:if>