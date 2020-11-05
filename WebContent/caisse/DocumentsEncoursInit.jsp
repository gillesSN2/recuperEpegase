<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse!=null}" var="doccai">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action<=3}" >
            <jsp:include flush="true" page="/caisse/DocumentsEncoursFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==4}" >
            <jsp:include flush="true" page="/caisse/DocumentsRecettesFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==5}" >
            <jsp:include flush="true" page="/caisse/DocumentsDepensesFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==6}" >
            <jsp:include flush="true" page="/caisse/DocumentsTransfertsFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==7}" >
            <jsp:include flush="true" page="/caisse/DocumentsRegularisationsFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==10}" >
            <jsp:include flush="true" page="/commun/listeSalarie.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==11}" >
            <jsp:include flush="true" page="/commun/listePlanComptable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==12}" >
            <jsp:include flush="true" page="/commun/listeCheque.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==13}" >
            <jsp:include flush="true" page="/commun/listeResponsable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==14}" >
            <jsp:include flush="true" page="/commun/listePatients.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeEleves.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/caisse/DocumentsEncoursListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>