<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetCarnet!=null}" var="carvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetCarnet.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetCarnet.var_action<=8}" >
            <jsp:include flush="true" page="../foret/ForetCarnetFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="../foret/ForetCarnetListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>
