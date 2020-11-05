<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse!=null}" var="extc">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==4}" >
            <jsp:include flush="true" page="/comptabilite/ExtraitClasseOutils.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==10}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==15}" >
            <jsp:include flush="true" page="/comptabilite/ExtraitClassePiece.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==16}" >
            <jsp:include flush="true" page="/comptabilite/ExtraitClasseAnalytique.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==17}" >
            <jsp:include flush="true" page="/comptabilite/JournauxComptablesFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.var_action==18}" >
            <jsp:include flush="true" page="/comptabilite/ExtraitErreurAcces.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/ExtraitClasseList.jsp" /></c:otherwise>

    </c:choose>

</c:if>

