<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>



<h:panelGrid id="idRh" styleClass="fichefournisseur1" width="100%" >
    <!-- envoronnement -->
    <h:panelGrid id="idEnvironnement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature==0}" width="100%">
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <f:selectItem itemLabel="Sélectionnez le type" itemValue="0"/>
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTypeRhItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererEnvironnementtem}" reRender="idRh,idEnvironnement" />
            </h:selectOneMenu>
        </h:column>
        <!-- accident -->
        <h:panelGrid id="idAccident" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==1}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date accident (JJ/MM/AAAA):"/></h:column>
            <h:column>
                <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Heure accident:"/>&nbsp;
                <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhHeure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/>&nbsp;&nbsp;
                <h:outputText value="Minute accident:"/>&nbsp;
                <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMinute}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/>
            </h:column>
            <h:column><h:outputText value="Date déclaration (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateDeclaration}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu accident:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nature accident:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNatureAccident}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Circonstances accident:"/></h:column>
            <h:column><h:inputTextarea style="width:100%;" rows="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCirconstance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Causes accident:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCauseAccident}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nature des lésions:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNatureLesions}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Siège des lésions:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSiegeLesions}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Premiers soins donnés par:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMedecinAccident}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Suite probable:"/></h:column>
            <h:column>
                <h:selectOneRadio  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSuiteAccident}" >
                    <f:selectItem itemLabel="N.R." itemValue="0"/>
                    <f:selectItem itemLabel="Sans arrêt de travail" itemValue="1"/>
                    <f:selectItem itemLabel="Arrêt de travail supérieur à 24 h" itemValue="2"/>
                    <f:selectItem itemLabel="Décés immédiat" itemValue="3"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idAccident"/>
                </h:selectOneRadio>
            </h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSuiteAccident==2}"><h:outputText value="Temps indisponibilité:"/></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSuiteAccident==2}"><h:inputText style="width:100%;" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTempsIndisponibilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Témoins:"/></h:column>
            <h:column><h:inputTextarea style="width:100%;" rows="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTemoins}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Rapport médical:"/></h:column>
            <h:column><h:inputTextarea style="width:100%;" rows="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhRapportMedical}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom du déclarant:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNomDeclarant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Commentaires:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
        <!-- dotation equipement-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==11}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date dotation (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Type dotation d'équipement:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDotation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Sélectionnez le type d'équipement" itemValue="0" />
                    <f:selectItem itemLabel="casque/casquette" itemValue="21" />
                    <f:selectItem itemLabel="tenue complète" itemValue="22" />
                    <f:selectItem itemLabel="gants" itemValue="23" />
                    <f:selectItem itemLabel="botte" itemValue="24" />
                    <f:selectItem itemLabel="chemise/teashirt" itemValue="25" />
                    <f:selectItem itemLabel="blouse" itemValue="26" />
                    <f:selectItem itemLabel="pantalon" itemValue="27" />
                    <f:selectItem itemLabel="trousse à outils" itemValue="28" />
                    <f:selectItem itemLabel="outil" itemValue="29" />
                    <f:selectItem itemLabel="chaussure simple" itemValue="30" />
                    <f:selectItem itemLabel="chaussure de sécurité" itemValue="31" />
                    <f:selectItem itemLabel="autre type d'équipement" itemValue="99" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Description:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Taille:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTaille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Couleur:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCouleur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Quantité:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhQte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Référence:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date alerte (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateAlerte}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- dotation mobilier-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==12}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date dotation (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Type dotation de mobilier:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDotation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Sélectionnez le type de mobilier" itemValue="0" />
                    <f:selectItem itemLabel="matériel mobilier" itemValue="31" />
                    <f:selectItem itemLabel="materiel électroménager" itemValue="32" />
                    <f:selectItem itemLabel="matériel audio/vidéo" itemValue="33" />
                    <f:selectItem itemLabel="matériel froid" itemValue="34" />
                    <f:selectItem itemLabel="matériel informatique" itemValue="35" />
                    <f:selectItem itemLabel="materiel de transport" itemValue="36" />
                    <f:selectItem itemLabel="materiel de construction" itemValue="37" />
                    <f:selectItem itemLabel="materiel de jardinage" itemValue="38" />
                    <f:selectItem itemLabel="autre type de materiel" itemValue="39" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Description:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="N° série ou identification:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date alerte (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateAlerte}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- liste des enfants -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==15}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date naissance (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom et prénom:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Genre:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhGenre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Fille" itemValue="0" />
                    <f:selectItem itemLabel="Garçon" itemValue="1" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Nb de parts fiscales:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFiscal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Pris en compte dans le calcul" itemValue="0" />
                    <f:selectItem itemLabel="Pas pris en compte" itemValue="1" />
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
        <!-- liste des conjoints -->
        <h:panelGrid id="idConjoint" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==16}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date mariage (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom et prénom:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom de jeune fille:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNomJf}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Identification fiscale:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNumFiscal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Travaille:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Travaille" itemValue="0" />
                    <f:selectItem itemLabel="Ne travaille pas" itemValue="1" />
                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idConjoint,idCj1,idCj2,idCj3,idCj4,idCj5,idCj6,idCj7,idCj8,idCj9,idCj10,idCj11,idCj12"/>
                </h:selectOneMenu>
            </h:column>
            <h:column id="idCj1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Employeur:"/></h:column>
            <h:column id="idCj2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column id="idCj3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Téléhpne:"/></h:column>
            <h:column id="idCj4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurTel}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column id="idCj5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Adresse:"/></h:column>
            <h:column id="idCj6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column id="idCj7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Boite Postale:"/></h:column>
            <h:column id="idCj8" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurBp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column id="idCj9" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Ville:"/></h:column>
            <h:column id="idCj10" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurVille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column id="idCj11" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:outputText value="Fonction:"/></h:column>
            <h:column id="idCj12" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTravail==0}"><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEmployeurFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- missions -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==17}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date mission (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==14}"><h:outputText value="Type agence:"/></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==14}">
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMissionOrigine}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Agence UN-WOMEN" itemValue="0" />
                    <f:selectItem itemLabel="Autre agence des Nations-Unis" itemValue="1" />
                    <f:selectItem itemLabel="Agence hors Nations-Unis" itemValue="2" />
                    <f:selectItem itemLabel="Agence Gouvernementale" itemValue="3" />
                    <f:selectItem itemLabel="Société privée" itemValue="4" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Descriptif mission:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu/pays:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Coût mission:"/></h:column>
            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCout}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Durée totale:"/></h:column>
            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDuree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Appréciation:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhAppreciation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Problèmes rencontrés:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhProbleme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Description:"/></h:column>
            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <jsp:include flush="true" page="../css/tdt.jsp"/>
            </rich:editor>
        </h:panelGrid>
        <!-- personne à prevenir -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==18}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Nom et prénom:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Contact:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Qualité:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- renouvellement papier -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==25}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Valable du:"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Au:"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date alerte (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateAlerte}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Type document:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- visite medicale -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==28}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date visite (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Objet visite:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Médecin:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Groupe sanguin:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhGroupeSanguin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Aptitude:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMedical}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Apte sans restriction" itemValue="0" />
                    <f:selectItem itemLabel="Apte service restreint" itemValue="1" />
                    <f:selectItem itemLabel="Inapte temporaire" itemValue="2" />
                    <f:selectItem itemLabel="Inapte permanent" itemValue="3" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Date alerte (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateAlerte}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Commentaires:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
        <!-- centre interet -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==30}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Centre d'intéret 1:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Centre d'intéret 2:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Centre d'intéret 3:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Commentaires:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
        <!-- loisir -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==31}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Loisir 1:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Loisir 2:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Loisir 3:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Commentaires:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
    <!-- attestation -->
    <h:panelGrid id="idPanelAttestation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature==83}" width="100%" columns="2" columnClasses="clos30,clos70">
        <h:column><h:outputText value="Date attestation (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column><h:outputText value="Responsable:"/></h:column>
        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Type attestation:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTypeRhItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererAttestationItem}" reRender="idRh,idPanelAttestation,idAttestation" />
            </h:selectOneMenu>
        </h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Modèle attestation:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu id="idAttestation" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_code_modele}">
                <f:selectItem itemLabel="Sélectionnez modèle attestation" itemValue="100" />
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesModelesItems}" />
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheTexteModeleRh}" reRender="panRh,idRh,panelTexteRh,idTexteRh,idObjetAttestation"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Objet :"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="100" id="idObjetAttestation" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
    </h:panelGrid>
    <!-- cursus -->
    <h:panelGrid id="idCursus" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature==84}" width="100%">
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelRh&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <f:selectItem itemLabel="Sélectionner le type" itemValue="0" />
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTypeRhItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererCursusItem}" reRender="idRh,idCursus" />
            </h:selectOneMenu>
        </h:column>
        <!-- affectation -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8400}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date changement (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Ancienne feuille:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salFeuille}" readonly="true"/></h:column>
            <h:column><h:outputText value="Nouvelle feuille:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFeuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Fonction:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Motif:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMotif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Durée:"/></h:column>
            <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDuree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date prise en fonction (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateDeclaration}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- diplome -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8401}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date diplôme (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Type diplôme:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- definition poste -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8402}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date définition poste (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Objet :"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service :"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Fonction :"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Détail du poste:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
        <!-- notation -->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8403}" width="100%" >
            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                <h:column><h:outputText value="Date notation (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
                <h:column><h:outputText value="Remarque générale:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" style="border:solid 0px black" headerClass="headerTab" columnClasses="clos30,clos70">
                <f:facet name="header"><h:outputText value="Tableau des notations"/></f:facet>
                <h:column><h:outputText value="Ponctualité, Assiduité:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval1}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval1}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Application au travail:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval2}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval2}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Qualité du travail:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval3}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval3}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Rendement:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval4}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval4}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Initiative, Organisation:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval5}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval5}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Esprit d'équipe, Travail en équipe:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval6}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval6}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Connaissance des procédures:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval7}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval7}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Technique de communication:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval8}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval8}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Relation avec les partenaires:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval9}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval9}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Evaluation globale de la performance:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval10}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval10}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Respect du règlement intérieur:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval11}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval11}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Respect des consignes HSE:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhEval12}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ctrlEval12}" reRender="idCumul" />
                    </h:inputText>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
                <h:column><h:outputText value="Cumul:"/></h:column>
                <h:column><h:inputText id="idCumul" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTotEval}" style="text-align:right;width:100px" readonly="true"/>&nbsp;&nbsp;&nbsp;<h:outputText style="color:red" value="(2 = Très bon, 1 = Bon, 0 = Passable, -1 = Mauvais, -2 = Médiocre)"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                <h:column><h:outputText value="Décisions Direction:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhMotif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <!-- qualfication niveau scolaire-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8404}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Observation générale:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Niveau:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNiveauScolaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Non renseigné" itemValue="0" />
                    <f:selectItem itemLabel="PRIMAIRE" itemValue="1" />
                    <f:selectItem itemLabel="SECONDAIRE" itemValue="2" />
                    <f:selectItem itemLabel="SUPERIEUR" itemValue="3" />
                    <f:selectItem itemLabel="UNIVERSITAIRE" itemValue="4" />
                    <f:selectItem itemLabel="DOCTORAT" itemValue="5" />
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
        <!-- qualification professionelle-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8405}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date formation (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Objet Formation:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Durée (nb jours):"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDuree}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Coût:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCout}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- qualfication formation initiale-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8406}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Qualité:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhQualite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Stagiaire/Débutant" itemValue="0" />
                    <f:selectItem itemLabel="Junior" itemValue="1" />
                    <f:selectItem itemLabel="Junior Confirmé" itemValue="2" />
                    <f:selectItem itemLabel="Sénior" itemValue="3" />
                    <f:selectItem itemLabel="Sénior Expérimenté" itemValue="4" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Fonction:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Mission:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom société/organisme:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- qualfication formation securite-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8407}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date formation (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Objet:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Fonction:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom société:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Durée (nb jours):"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDuree}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Coût:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCout}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- qualfication langue maitrisee-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8408}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date apprentissage (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Langue:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLangue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Lecture:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLangueLu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Non" itemValue="0" />
                    <f:selectItem itemLabel="Passable" itemValue="1" />
                    <f:selectItem itemLabel="Correct" itemValue="2" />
                    <f:selectItem itemLabel="Excellent" itemValue="3" />
                    <f:selectItem itemLabel="Interprête" itemValue="4" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Ecriture:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLangueEcrit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Non" itemValue="0" />
                    <f:selectItem itemLabel="Passable" itemValue="1" />
                    <f:selectItem itemLabel="Correct" itemValue="2" />
                    <f:selectItem itemLabel="Excellent" itemValue="3" />
                    <f:selectItem itemLabel="Interprête" itemValue="4" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Dialogue:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLangueParle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <f:selectItem itemLabel="Non" itemValue="0" />
                    <f:selectItem itemLabel="Passable" itemValue="1" />
                    <f:selectItem itemLabel="Correct" itemValue="2" />
                    <f:selectItem itemLabel="Excellent" itemValue="3" />
                    <f:selectItem itemLabel="Interprête" itemValue="4" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Observation:"/></h:column>
            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- qualfication renforcement des capacites-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8409}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date formation (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Objet formation:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Nom société:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Service:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Durée (nb jours):"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDuree}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Coût:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhCout}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Responsable:"/></h:column>
            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        </h:panelGrid>
        <!-- cv-->
        <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType==8410}" width="100%" columns="2" columnClasses="clos30,clos70">
            <h:column><h:outputText value="Date CV (JJ/MM/AAAA):"/></h:column>
            <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
            <h:column><h:outputText value="Texte du CV:"/></h:column>
            <h:column>
                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                </rich:editor>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
    <!-- certificat -->
    <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature==85}" width="100%" columns="2" columnClasses="clos30,clos70">
        <h:column><h:outputText value="Date certificat (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column><h:outputText value="Responsable:"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Type certificat:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTypeRhItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererCertificatItem}" reRender="idRh,idCertificat" />
            </h:selectOneMenu>
        </h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Modèle certificat:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu id="idCertificat" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_code_modele}">
                <f:selectItem itemLabel="Sélectionnez modèle certificat" itemValue="100" />
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesModelesItems}" />
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheTexteModeleRh}" reRender="panRh,idRh,panelTexteRh,idTexteRh,idObjetCertificat"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Objet :"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="100" id="idObjetCertificat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
    </h:panelGrid>
    <!-- correspondance -->
    <h:panelGrid rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhNature==86}" width="100%" columns="2" columnClasses="clos30,clos70">
        <h:column><h:outputText value="Date correspondance (JJ/MM/AAAA):"/></h:column>
        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDate}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column><h:outputText value="Responsable:"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Type correspondance:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTypeRhItems}"/>
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererCorrespondanceItem}" reRender="idRh,idCorrespondance" />
            </h:selectOneMenu>
        </h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}"><h:outputText value="Modèle certificat:"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhId==0}">
            <h:selectOneMenu id="idCorrespondance" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_code_modele}">
                <f:selectItem itemLabel="Sélectionnez modèle certificat" itemValue="100" />
                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesModelesItems}" />
                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheTexteModeleRh}" reRender="panRh,idRh,panelTexteRh,idTexteRh,idObjetCertificat"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Objet :"/></h:column>
        <h:column><h:inputText style="width:100%;" maxlength="100" id="idObjetCorrespondance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/></h:column>
    </h:panelGrid>
    <!-- tdt -->
    <h:panelGrid width="100%" id="panelTexteRh" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affiche_tdt_rh}">
        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
            <jsp:include flush="true" page="../css/tdt.jsp"/>
        </rich:editor>
    </h:panelGrid>
</h:panelGrid>

<h:panelGrid id="panPdf" columns="2" styleClass="fichefournisseur1" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0}">
    <f:facet name="header"><h:outputText value="Document PDF"/></f:facet>
    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affFicPdfRh}">
        <t:inputFileUpload id="filePdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uploadedPDFFile}"/>
        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}">
            <a4j:support eventsQueue="maQueue"  immediate="true"/>
        </h:commandButton>
        <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
    </h:panelGroup>
    <br/>
    <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affFicPdfRh}">
        <h:outputText value="Nom document:"/>&nbsp;&nbsp;&nbsp;
        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesGrh.salgrhDocument}" />&nbsp;&nbsp;&nbsp;
        <h:commandButton image="/images/download.png" style="height:15px;width:15px;" title="Télécharger le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.downloadPdf}" />&nbsp;&nbsp;&nbsp;
        <h:commandButton image="/images/detail.png" style="height:15px;width:15px;" title="Lire le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.voirPdf}"/>&nbsp;&nbsp;&nbsp;
        <h:commandButton image="/images/annuler.gif" style="height:15px;width:15px;" title="Supprimer le document" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_rh==3}"/>
    </h:panelGroup>
</h:panelGrid>