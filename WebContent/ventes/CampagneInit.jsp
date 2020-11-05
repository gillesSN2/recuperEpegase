<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes!=null}" var="camvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_action<=8}" >
            <jsp:include flush="true" page="../ventes/CampagneFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCampagneVentes.var_action==20}" >
            <jsp:include flush="true" page="../commun/listeContact.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="../ventes/CampagneListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>
