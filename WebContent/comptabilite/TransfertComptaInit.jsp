<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta!=null}" var="trfcpt">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_action==10}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.formTransfertCtrl.var_action==10}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/TransfertCompta.jsp" /></c:otherwise>

    </c:choose>

</c:if>
