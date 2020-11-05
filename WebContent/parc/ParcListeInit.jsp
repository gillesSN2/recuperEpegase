<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe!=null}" var="prclst">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formParcListe.var_action>=1}" >
            <jsp:include flush="true" page="/parc/ParcFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/parc/ParcList.jsp" /></c:otherwise>

    </c:choose>

</c:if>