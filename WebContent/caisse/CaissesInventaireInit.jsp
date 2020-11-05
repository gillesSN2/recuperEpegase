<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire!=null}" var="invcai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_action<=8}" >
            <jsp:include flush="true" page="/caisse/CaissesInventaireFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/CaissesInventaireListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>