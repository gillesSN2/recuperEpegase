<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers!=null}" var="prmtie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action<=3}" >
            <jsp:include flush="true" page="/tiers/proprietaireMoralFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==4}" >
            <jsp:include flush="true" page="/tiers/tiersRDV.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==5}" >
            <jsp:include flush="true" page="/tiers/tiersMessagerie.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==6}" >
            <jsp:include flush="true" page="/tiers/tiersDocumentsAch.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==7}" >
            <jsp:include flush="true" page="/tiers/tiersDocumentsVte.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==8}" >
            <jsp:include flush="true" page="/tiers/tiersExtraitCompte.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==9}" >
            <jsp:include flush="true" page="/tiers/tiersCatalogue.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsVentes.jsp" />
        </c:when>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==11}" >
            <jsp:include flush="true" page="/tiers/tiersMessagerieFiche.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/proprietaireMoralListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>