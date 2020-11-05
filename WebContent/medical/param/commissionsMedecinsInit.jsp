<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>

    <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.var_action==15}" >
        <jsp:include flush="true" page="/commun/listeProduitsVentes.jsp" />
    </c:when>
    
    <c:otherwise>
        <jsp:include flush="true" page="/medical/param/commissionsMedecinsList.jsp" />
    </c:otherwise>

</c:choose>

