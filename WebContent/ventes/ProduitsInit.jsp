<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes!=null}" var="prdtvte">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action<=3}" >
            <jsp:include flush="true" page="/ventes/ProduitsFiche.jsp" />
        </c:when>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==4}" >
            <jsp:include flush="true" page="/ventes/ProduitsMvts.jsp" />
        </c:when>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==5}" >
            <jsp:include flush="true" page="/ventes/ProduitsEcommerce.jsp" />
        </c:when>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==6}" >
            <jsp:include flush="true" page="/ventes/ProduitsDepot.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/ventes/ProduitsListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>