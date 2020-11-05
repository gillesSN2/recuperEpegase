<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables!=null}" var="jrcp">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action<=3}" >
            <jsp:include flush="true" page="/comptabilite/JournauxComptablesFiche.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action==4}" >
            <jsp:include flush="true" page="/comptabilite/JournauxComptablesOutils.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action==10}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action==11}" >
            <jsp:include flush="true" page="/commun/listeBudgetTresorerie.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action==12}" >
            <jsp:include flush="true" page="/commun/ficheTiers.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_action==13}" >
            <jsp:include flush="true" page="/comptabilite/JournauxComptablesExtraitCompte.jsp"/>
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/JournauxComptablesList.jsp" /></c:otherwise>

    </c:choose>

</c:if>