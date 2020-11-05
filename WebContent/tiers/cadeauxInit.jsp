<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux!=null}" var="cadtie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_action<=3}" >
            <jsp:include flush="true" page="/tiers/cadeauxFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formCadeaux.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsVentes.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/cadeauxListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>