<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier!=null}" var="trvimmo">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==21||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==31||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==41||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==51}" >
            <jsp:include flush="true" page="/immobilier/FactureChargeFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==16}" >
            <jsp:include flush="true" page="/commun/ficheTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==17}" >
            <jsp:include flush="true" page="/commun/listeBiens.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==18}" >
            <jsp:include flush="true" page="/commun/ficheBiens.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_action==19}" >
            <jsp:include flush="true" page="/commun/listeTravaux.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/immobilier/FactureChargeListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>