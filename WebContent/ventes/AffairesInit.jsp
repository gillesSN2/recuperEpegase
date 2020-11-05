<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires!=null}" var="affvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_action<=8}" >
            <jsp:include flush="true" page="../ventes/AffairesFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_action==12}" >
            <jsp:include flush="true" page="/commun/ficheTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_action==16}" >
            <jsp:include flush="true" page="/commun/ajouterContactTiers.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="../ventes/AffairesListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>



