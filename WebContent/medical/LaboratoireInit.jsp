<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire!=null}" var="lab">

    <c:choose>

        <c:when test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==11||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==21)}" >
            <jsp:include flush="true" page="/medical/LaboratoireFicheGlobale.jsp" />
        </c:when>
        <c:when test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==12||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==22)}" >
            <jsp:include flush="true" page="/medical/LaboratoireFicheFacture.jsp" />
        </c:when>
        <c:when test="${(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==13||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==23)}" >
            <jsp:include flush="true" page="/medical/LaboratoireFicheMedecin.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==4}" >
            <jsp:include flush="true" page="/medical/RecherchePatient.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==5}" >
            <jsp:include flush="true" page="/medical/tiersPatientFiche.jsp" />
        </c:when>

        <c:otherwise><jsp:include flush="true" page="/medical/LaboratoireListe.jsp" /></c:otherwise>

    </c:choose>

</c:if>

