<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes!=null}" var="epxvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action<=8}" >
            <jsp:include flush="true" page="/ventes/EtudePrixFiche.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/ventes/EtudePrixListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>
