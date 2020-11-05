<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Date création entreprise:"/></h:column>
    <h:column><rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDateCreationEntreprise}" popup="true"/></h:column>
    <h:column><h:outputText value="1er année activité dans le pays:"/></h:column>
    <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAnneeActivitePays}"/></h:column>
    <h:column><h:outputText value="Nb établissement dans le pays:"/></h:column>
    <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNbEtablissementPays}"/></h:column>
    <h:column><h:outputText value="Nb établissement hors du pays:"/></h:column>
    <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNbEtablissementHors}"/></h:column>
    <h:column><h:outputText value="Entreprise sous le contrôle public:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCtrlPublique}"/></h:column>
    <h:column><h:outputText value="Entreprise sous le contrôle privé local:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCtrlPriveLoc}"/></h:column>
    <h:column><h:outputText value="Entreprise sous le contrôle privé étranger:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCtrlPriveEtr}"/></h:column>
    <h:column><h:outputText value="Type d'entreprise:"/></h:column>
    <h:column>
        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptTypeEntreprise}">
            <f:selectItem itemLabel="Entreprise privée" itemValue="0"/>
            <f:selectItem itemLabel="Entreprise publique" itemValue="1"/>
            <f:selectItem itemLabel="Entreprise étrangère" itemValue="2"/>
        </h:selectOneMenu>
    </h:column>
    <h:column><h:outputText value="Régime d'entreprise:"/></h:column>
    <h:column>
        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptRegime}">
            <f:selectItem itemLabel="Régime normal" itemValue="1"/>
            <f:selectItem itemLabel="Régime simplfié" itemValue="2"/>
            <f:selectItem itemLabel="Régime Synthétique" itemValue="3"/>
            <f:selectItem itemLabel="Régime au forfait" itemValue="4"/>
        </h:selectOneMenu>
    </h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" style="background-color:#DAEECB;" width="100%">
    <h:column><h:outputText value="Centre d'Impôt:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCentreImpot}"/></h:column>
    <h:column><h:outputText value="Inscription:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptInscription}"/></h:column>
    <h:column><h:outputText value="Nom de l'agrément:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAgrement}"/></h:column>
    <h:column><h:outputText value="Date agrément:"/></h:column>
    <h:column><rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDateAgrement}" popup="true"/></h:column>
    <h:column><h:outputText value="Durée agrément:"/></h:column>
    <h:column><h:inputText maxlength="200" size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDureeAgrement}"/></h:column>
    <h:column><h:outputText value="Nom de la convention:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptConvention}"/></h:column>
    <h:column><h:outputText value="Gestion analytique:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAnalytique}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Date clôture précédente:"/></h:column>
    <h:column><rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDateClotPrec}" popup="true"/></h:column>
    <h:column><h:outputText value="Durée exercice précédent:"/></h:column>
    <h:column><h:inputText  size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDureePrec}"/></h:column>
    <h:column><h:outputText value="Date arrêtée des comptes:"/></h:column>
    <h:column><rich:calendar   enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptDateArretCompte}" popup="true"/></h:column>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheCodesEmplois==false}" var="empl2">
        <h:column><h:outputText value="Code activité principale:"/></h:column>
        <h:column><h:inputText maxlength="200" size="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCodeActivite}"/></h:column>
        <h:column><h:outputText value="Libellé activité principale:"/></h:column>
        <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptLibActivite}"/></h:column>
    </c:if>
    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheCodesEmplois==true}" var="empl2">
        <h:column><h:outputText value="Code activité principale:"/></h:column>
        <h:column>
            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCodeActivite}">
                <f:selectItem itemLabel="Sélection activité principale" itemValue="0"/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.mesCodesEmploisItems}"/>
            </h:selectOneMenu>
        </h:column>
    </c:if>
    <h:column><h:outputText value="% capacité de prod. util.:"/></h:column>
    <h:column><h:inputText  size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptCapProduction}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" style="background-color:#DAEECB;" width="100%">
    <h:column><h:outputText value="Nom contact:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNomContact}"/></h:column>
    <h:column><h:outputText value="Adresse contact:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAdresseContact}"/></h:column>
    <h:column><h:outputText value="Ville contact:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptVilleContact}"/></h:column>
    <h:column><h:outputText value="Qualité contact:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptQuaContact}"/></h:column>
    <h:column><h:outputText value="Téléphone contact:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptTelephoneContact}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Nom comptable:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNomComptable}"/></h:column>
    <h:column><h:outputText value="Adresse comptable:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAdresseComptable}"/></h:column>
    <h:column><h:outputText value="Ville comptable:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptVilleComptable}"/></h:column>
    <h:column><h:outputText value="Téléphone comptable:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptTelephoneComptable}"/></h:column>
    <h:column><h:outputText value="Est-il salarié ?:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSalarieComptable}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" style="background-color:#DAEECB;" width="100%">
    <h:column><h:outputText value="Nom cabinet:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNomCabinet}"/></h:column>
    <h:column><h:outputText value="Adresse cabinet:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAdresseCabinet}"/></h:column>
    <h:column><h:outputText value="Ville cabinet:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptVilleCabinet}"/></h:column>
    <h:column><h:outputText value="Téléphone cabinet:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptTelephoneCabinet}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Nom commissaire aux comptes:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNomCommissaire}"/></h:column>
    <h:column><h:outputText value="Adresse commissaire aux comptes:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptAdresseCommissaire}"/></h:column>
    <h:column><h:outputText value="Ville commissaire aux comptes:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptVilleCommissaire}"/></h:column>
    <h:column><h:outputText value="Téléphone commissaire aux comptes:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptTelephoneCommissaire}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" style="background-color:#DAEECB;" width="100%">
    <h:column><h:outputText value="Nom signataire:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptNomSignataire}"/></h:column>
    <h:column><h:outputText value="Qualité signataire:"/></h:column>
    <h:column><h:inputText maxlength="200" size="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptQuaSignataire}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Etats financiers certifiés"/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="Non assujettie:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFCNA}"/></h:column>
    <h:column><h:outputText value="Non (refus):"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFCR}"/></h:column>
    <h:column><h:outputText value="Oui avec réserve:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFCAR}"/></h:column>
    <h:column><h:outputText value="Oui sans réserve:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFASR}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" style="background-color:#DAEECB;" width="100%">
    <h:column><h:outputText value="Etats financiers approuvés par l'Assemblée Générale"/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="Non assujettie:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFANA}"/></h:column>
    <h:column><h:outputText value="Non approuvé:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFANA}"/></h:column>
    <h:column><h:outputText value="Oui (approuvé):"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptEFAAP}"/></h:column>
</h:panelGrid>
<h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
    <h:column><h:outputText value="Informations sur page 1"/></h:column>
    <h:column><h:outputText value=""/></h:column>
    <h:column><h:outputText value="Fiche d'identification et renseignements divers:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie1}"/></h:column>
    <h:column><h:outputText value="Bilan:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie2}"/></h:column>
    <h:column><h:outputText value="Compte de résultat:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie3}"/></h:column>
    <h:column><h:outputText value="Tableaux des flux de trésorerie:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie4}"/></h:column>
    <h:column><h:outputText value="Notes annexes:"/></h:column>
    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie5}"/></h:column>
    <h:column><h:outputText value="Nb de pages déposées par exemplaires:"/></h:column>
    <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie6}"/></h:column>
    <h:column><h:outputText value="Nb d'exemplaires déposés:"/></h:column>
    <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.selectedExo.execptSaisie7}"/></h:column>
</h:panelGrid>
<h:panelGrid  width="100%">
    <br> <br>
    <center>
        <h:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.afficheValider}" value="Valider" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formEtatFinancierExploitation.majExercice}"/>
    </center>
</h:panelGrid>

