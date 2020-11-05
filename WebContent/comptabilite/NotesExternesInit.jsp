<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes!=null}" var="nex">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formNotesExternes.var_action>=1}" >
            <jsp:include flush="true" page="/comptabilite/NoesExternesFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/comptabilite/NotesExternesListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>
