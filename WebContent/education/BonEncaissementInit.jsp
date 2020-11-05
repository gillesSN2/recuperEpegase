<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation!=null}" var="bcedu">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_action<=9}" >
            <jsp:include flush="true" page="/education/BonEncaissementFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_action>=10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_action<=19}" >
            <jsp:include flush="true" page="/education/BonEncaissementFicheMultiple.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/education/BonEncaissementList.jsp" /></c:otherwise>

    </c:choose>

</c:if>
