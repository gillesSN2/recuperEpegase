<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes!=null}" var="cmdvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action<=8}" >
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModuleVte=='1'}" var="ficC">
                <jsp:include flush="true" page="/ventes/CommandeFiche.jsp" />
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModuleVte=='2'}" var="ficL">
                <jsp:include flush="true" page="/ventes/CommandeFicheCMD.jsp" />
            </c:if>
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==10}" >
            <jsp:include flush="true" page="/commun/listeDestinataire.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==11}" >
            <jsp:include flush="true" page="/commun/listeResponsable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==12}" >
            <jsp:include flush="true" page="/commun/ficheTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==13}" >
            <jsp:include flush="true" page="/commun/ficheProduit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsVentes.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==16}" >
            <jsp:include flush="true" page="/commun/ajouterContactTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formCommandeVentes.var_action==17}" >
            <jsp:include flush="true" page="/ventes/CommandePlanning.jsp" />
        </c:when>

        <c:otherwise>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModuleVte=='1'}" var="vteC">
                <jsp:include flush="true" page="/ventes/CommandeListe.jsp" />
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModuleVte=='2'}" var="vteL">
                <jsp:include flush="true" page="/ventes/CommandeListeCMD.jsp" />
            </c:if>
        </c:otherwise>

    </c:choose>

</c:if>