<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier!=null}" var="pv">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formPvImmobilier.var_action==3}" >
            <jsp:include flush="true" page="/immobilier/PvFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/immobilier/PvListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>