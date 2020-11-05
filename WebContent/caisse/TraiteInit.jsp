<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite!=null}" var="trtcai">

    <c:choose>

        <c:when test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.nature==65||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.nature==67)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action<=4}" >
            <jsp:include flush="true" page="/caisse/TraiteFiche.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.nature==66&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action<=4}" >
            <jsp:include flush="true" page="/caisse/TraiteSimple.jsp"/>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==5}" >
            <jsp:include flush="true" page="/caisse/TraiteDepot.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==6}" >
            <jsp:include flush="true" page="/caisse/TraiteRetour.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/TraiteListe.jsp"/></c:otherwise>

    </c:choose>

</c:if>