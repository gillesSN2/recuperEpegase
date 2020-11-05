<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

    <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUsers.var_action>=1}" >
        <jsp:include flush="true" page="/administration/utilisateurFiche.jsp" />
    </c:when>

    <c:otherwise><jsp:include flush="true" page="/administration/utilisateurListe.jsp" /></c:otherwise>

</c:choose>

