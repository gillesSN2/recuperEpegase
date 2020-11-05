<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats!=null}" var="cotach">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action<=6}" >
            <jsp:include flush="true" page="/achats/CotationFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==7}" >
            <jsp:include flush="true" page="/achats/CotationSimulation.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==10}" >
            <jsp:include flush="true" page="/commun/listeDestinataire.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==11}" >
            <jsp:include flush="true" page="/commun/listeResponsable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==12}" >
            <jsp:include flush="true" page="/commun/ficheTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==13}" >
            <jsp:include flush="true" page="/commun/ficheProduit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==14}" >
            <jsp:include flush="true" page="/commun/listeDossierTransit.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsAchats.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.var_action==16}" >
            <jsp:include flush="true" page="/commun/ajouterContactTiers.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/achats/CotationList.jsp" /></c:otherwise>

    </c:choose>

</c:if>
