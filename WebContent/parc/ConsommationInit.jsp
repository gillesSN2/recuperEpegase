<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation!=null}" var="conso">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_action<=8}">
            <jsp:include flush="true" page="/parc/ConsommationFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_action==10}">
            <jsp:include flush="true" page="/commun/listeParc.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/parc/ConsommationList.jsp" /></c:otherwise>

    </c:choose>

</c:if>