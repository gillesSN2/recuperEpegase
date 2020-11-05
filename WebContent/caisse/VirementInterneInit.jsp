<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formVirementInterne!=null}" var="vrtcai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formVirementInterne.var_action>=1}" >
            <jsp:include flush="true" page="/caisse/VirementInterneFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/VirementInterneListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>