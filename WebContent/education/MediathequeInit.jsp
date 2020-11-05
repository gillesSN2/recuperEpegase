<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque!=null}" var="mededu">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action<=8}" >
            <jsp:include flush="true" page="/education/MediathequeFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==11}" >
            <jsp:include flush="true" page="/commun/listeResponsable.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==17}" >
            <jsp:include flush="true" page="/commun/listeCommercial.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/education/MediathequeListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>