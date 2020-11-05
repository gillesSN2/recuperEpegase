<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement!=null}" var="rap">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action<=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.trf_rapprochementMode=='0'}" >
            <jsp:include flush="true" page="/comptabilite/RapprochementFicheMois.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action<=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.trf_rapprochementMode=='1'}" >
            <jsp:include flush="true" page="/comptabilite/RapprochementFicheJour.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==4}" >
            <jsp:include flush="true" page="/comptabilite/RapprochementAnte.jsp" />
        </c:when>

        <c:otherwise>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.trf_rapprochementMode=='0'}" var="rapMois">
                <jsp:include flush="true" page="/comptabilite/RapprochementListMensuel.jsp" />
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.trf_rapprochementMode=='1'}" var="rapJour">
                <jsp:include flush="true" page="/comptabilite/RapprochementListJournalier.jsp" />
            </c:if>
        </c:otherwise>

    </c:choose>

</c:if>
