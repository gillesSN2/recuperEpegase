<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid id="pboardAf" width="100%" styleClass="subviewb">
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='accueil'}" var="accueil">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='office'}" var="office">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='tiers'}" var="tiers">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='compta'}" var="compta">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='achats'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='stock'}" var="achats">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventes'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesTicket'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesInterim'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesRestaurant'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesHotelerie'}" var="ventes">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='caisse'}" var="caisse">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='parcs'}" var="parcs">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='paye'}" var="paye">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='medical'}" var="medical">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='education'}" var="education">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierLocation'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierSyndic'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierNegoce'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierPromoteur'}" var="immobilier">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='fondation'}" var="fondation">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='foret'}" var="foret">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='reporting'}" var="reporting">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='guest'}" var="guest">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='admin'||bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='coadmin'}" var="admin">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='systeme'}" var="systeme">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.affichePage}"/>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='espaceClient'}" var="espaceClient">
        <jsp:include flush="true" page="${bakingbeanepegase.menuModuleHorizontalCtrl.affichePage}"/>
    </c:if>
</h:panelGrid>

