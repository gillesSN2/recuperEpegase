<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss!=null}" var="bscai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action<=8}" >
            <jsp:include flush="true" page="/caisse/BonSortieFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==10}" >
            <jsp:include flush="true" page="/commun/listeSalaries.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==11}" >
            <jsp:include flush="true" page="/commun/listeBudgetTresorerie.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==12}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==13}" >
            <jsp:include flush="true" page="/commun/listeParc.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/BonSortieListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>