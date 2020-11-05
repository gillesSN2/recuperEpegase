<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical!=null}" var="prdmed">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action<=3}" >
            <jsp:include flush="true" page="/medical/ProduitsFiche.jsp" />
        </c:when>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==4}" >
            <jsp:include flush="true" page="/medical/ProduitsMvts.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==6}" >
            <jsp:include flush="true" page="/medical/ProduitsDepot.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formProduitsMedical.var_action==8}" >
            <jsp:include flush="true" page="/medical/ProduitsChangeCode.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/ProduitsListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>

