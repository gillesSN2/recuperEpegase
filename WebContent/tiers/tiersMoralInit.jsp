<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers!=null}" var="mortie">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action<=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers==1}" >
            <jsp:include flush="true" page="/tiers/tiersSuspectMoralFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action<=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers==2}" >
            <jsp:include flush="true" page="/tiers/tiersProspectMoralFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action<=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!=2}">
            <jsp:include flush="true" page="/tiers/tiersMoralFiche.jsp" />
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
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==11}" >
            <jsp:include flush="true" page="/tiers/tiersMessagerieFiche.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==15}" >
            <jsp:include flush="true" page="/commun/listeProduitsVentes.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==16}" >
            <jsp:include flush="true" page="/tiers/tiersCampagne.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==17}" >
            <jsp:include flush="true" page="/tiers/tiersCadeaux.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==18}" >
            <jsp:include flush="true" page="/tiers/tiersPatientPec.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==19}" >
            <jsp:include flush="true" page="/tiers/tiersPatientConventions.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==20}" >
            <jsp:include flush="true" page="/tiers/tiersAdherent.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==21}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>

        <c:otherwise>
            <jsp:include flush="true" page="/tiers/tiersMoralListe.jsp" />
        </c:otherwise>

    </c:choose>

</c:if>