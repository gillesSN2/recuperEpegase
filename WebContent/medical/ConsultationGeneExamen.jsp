<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.medecinSpecialite==0}" var="exaGeneraliste">
    <h:panelGrid width="100%">
        <h:panelGrid id="idExaCli" style="background-color:#DAEECB;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Poids (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.var_lib_poids}):" /></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPoids}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculIcm}" reRender="idExaCli,idIcm"/>
                </h:inputText>
            </h:column>
            <h:column><h:outputText value="Taille (cm):" /></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTaille}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.calculIcm}" reRender="idExaCli,idIcm"/>
                </h:inputText>
            </h:column>
            <h:column><h:outputText value="IMC (P/T²):" /></h:column>
            <h:column>
                <h:inputText id="idIcm" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgImc}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)">
                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                </h:inputText>
            </h:column>
            <h:column><h:outputText value="Température (°c):" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTemperature}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Fréquence cardiaque:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgFreCar}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Fréquence respiratoire:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgFreRes}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Diurèse (ml/H):" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDiurese}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Tension bras gauche:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTension}" style="text-align:right;"/></h:column>
            <h:column><h:outputText value="Tension bras droit:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgTensionDroit}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Oeil gauche:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgOeilGauche}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="Oeil droit:" /></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgOeilDroit}" style="text-align:right;" onkeypress="return scanToucheChiffre(event)"/></h:column>
            <h:column><h:outputText value="" /></h:column>
            <h:column><h:outputText value="" /></h:column>
        </h:panelGrid>
        <h:panelGrid width="100%">
            <h:outputText value="Résumé syndromique:" />
            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgExamClinique}" rows="5" style="width:100%"/>
        </h:panelGrid>
        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag">
            <h:column><h:outputText value="Hypothèse diagnostic 1:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag1}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag1}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Hypothèse diagnostic 2:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag2}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag2}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Hypothèse diagnostic 3:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag3}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag3}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Hypothèse diagnostic 4:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag4}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic4}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag4}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Hypothèse diagnostic 5:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag5}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic5}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag5}" style="width:80%" readonly="true"/>
            </h:column>
        </h:panelGrid>
        <h:panelGrid width="100%">
            <h:outputText value="Discussion:" />
            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgDiscution}" rows="2" style="width:100%"/>
        </h:panelGrid>
        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag2" style="border:1px solid green;background-color:#FFF8D4;">
            <h:column><h:outputText value="Diagnostic positif:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag11}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic11}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag11}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Diagnostic retentissement:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgCodeDiag12}" style="width:100px">
                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les diagnostics" style="background-color:#FFF8D4;"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.rechercheDiagnostic12}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelDiagnostic,formModalpanelDiagnostic"/>
                </h:inputText>&nbsp;&nbsp;
                <h:inputText id="lib12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.lib_diag12}" style="width:80%" readonly="true"/>
            </h:column>
            <h:column><h:outputText value="Hospitalisation:" /></h:column>
            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixHospit}"/></h:column>
            <h:column><h:outputText value="Mise en observation:" /></h:column>
            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixObs}"/></h:column>
            <h:column><h:outputText value="Référé:" /></h:column>
            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixRefere}"/></h:column>
            <h:column><h:outputText value="Demande de visite pré-anesthésique:" /></h:column>
            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgChoixVisitepa}"/></h:column>
            <h:column><h:outputText value="Date prochain rendez-vous:" /></h:column>
            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
        </h:panelGrid>
        <h:panelGrid width="100%">
            <h:outputText value="Evolution:" />
            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgEvolution}" rows="2" style="width:100%"/>
        </h:panelGrid>
        <h:panelGrid width="100%">
            <h:outputText value="Pronostic:" />
            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consultationEnteteGene.csgPronostic}" rows="2" style="width:100%"/>
        </h:panelGrid>
    </h:panelGrid>
</c:if>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.medecinSpecialite==1}" var="exaDentiste">
    <h:panelGrid width="100%">

    </h:panelGrid>
</c:if>