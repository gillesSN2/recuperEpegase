<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListeDossier">

    <a4j:form id="formModalListeDossier">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU DOSSIER"/></f:facet>
            <br>
            <h:panelGroup id="idAjout" style="height:35px">
                <center>
                    <a4j:commandButton id="idAddDos" title="Création nouveau Dossier" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.ajouterDossier}" reRender="panelDossier"/>
                </center>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableDossier"/>
                <rich:extendedDataTable rows="200" id="tableDossier" footerClass="bard" headerClass="headerTab" styleClass="bg" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelDossier}" var="dos" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionDossier}" reRender="idVal"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="ids11">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="ids12">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="ids13">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier,idListFrais"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="ids14">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="ids15">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="ids16">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="ids17">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="ids18">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="ids35">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==535}" var="ids535">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier"/>
                    </c:if>
                    <rich:column label="Code" sortable="true" sortBy="#{dos.anaCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{dos.anaTypeDossier}" rendered="#{dos.anaNature=='10'}"/>
                        <h:outputText value="#{dos.anaCode}"/>
                    </rich:column>
                    <rich:column label="Libellé du dossier" sortable="true" sortBy="#{dos.anaNomFr}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                        <h:outputText value="#{dos.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Type" sortable="true" sortBy="#{dos.lib_dossier}" width="10%">
                        <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                        <h:outputText value="#{dos.lib_dossier}"/>
                    </rich:column>
                    <rich:column label="Devise" sortable="true" sortBy="#{dos.anaTypeDevise}" width="10%">
                        <f:facet name="header"><h:outputText  value="Devise" /></f:facet>
                        <h:outputText value="#{dos.anaTypeDevise}"/>
                    </rich:column>
                    <rich:column label="Année" sortable="true" sortBy="#{dos.anaAnnee}" width="10%">
                        <f:facet name="header"><h:outputText  value="Année" /></f:facet>
                        <h:outputText value="#{dos.anaAnnee}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:panelGroup id="idVal">
                <center>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==11}" var="id11">
                        <a4j:commandButton id="idCanTiers11" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers11" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCotationAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==12}" var="id12">
                        <a4j:commandButton id="idCanTiers12" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers12" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==13}" var="id13">
                        <a4j:commandButton id="idCanTiers13" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier,idListFrais"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers13" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier,idListFrais" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==14}" var="id14">
                        <a4j:commandButton id="idCanTiers14" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers14" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formRetourAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==15}" var="id15">
                        <a4j:commandButton id="idCanTiers15" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers15" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFactureAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==16}" var="id16">
                        <a4j:commandButton id="idCanTiers16" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers16" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formAvoirAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==17}" var="id17">
                        <a4j:commandButton id="idCanTiers17" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.annuleDossier}" reRender="idSubView,idDossie,idLibDossierr"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers17" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==18}" var="id18">
                        <a4j:commandButton id="idCanTiers18" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers18" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formFraisAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==35}" var="id35">
                        <a4j:commandButton id="idCanTiers35" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers35" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formValorisationAchats.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==535}" var="id535">
                        <a4j:commandButton id="idCanTiers535" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.annuleDossier}" reRender="idSubView,idDossier,idLibDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers535" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recuperationDossier}" reRender="idSubView,idDossier,idLibDossier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectDossier}"/>
                    </c:if>
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelDossier" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelAddDossier}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelAddDossier}" var="addos">
            <f:facet name="header"><h:outputText value="Création nouveau dossier"/></f:facet>
            <a4j:form id="formModalAddDos">
                <h:panelGrid  width="100%" columns="2" columnClasses="clos30,clos70d" id="panelAddDos">
                    <h:column><h:outputText value="Code Dossier:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaCode}" maxlength="20" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.testUniciteDossier}" reRender="idpanval,idValDos"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libéllé Dossier:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaNomFr}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Type Dossier:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaTypeDossier}"  style="width:100%">
                            <f:selectItem itemLabel="Maritime" itemValue="0"/>
                            <f:selectItem itemLabel="Aérien" itemValue="1"/>
                            <f:selectItem itemLabel="Express" itemValue="2"/>
                            <f:selectItem itemLabel="Routier" itemValue="3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Année:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaAnnee}" size="4" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Devise:"/></h:column>
                    <h:column id="idDeviseGlobale">
                        <h:selectOneMenu style="width:30%" id="idDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaTypeDevise}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesdevisesItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculDevise}" reRender="panelAddDos,idDeviseGlobale,idCoefDev" />
                        </h:selectOneMenu>&nbsp;&nbsp;
                        <h:outputText value="Coef."/>&nbsp;
                        <h:inputText id="idCoefDev" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaTypeTauxDevise}" style="text-align:right;width:30%"/>
                    </h:column>
                    <h:column><h:outputText value="Exonération TVA:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaTypeExoTva}"/></h:column>
                    <h:column><h:outputText value="Exonération DOUANE:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossier.anaTypeExoDouane}"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="idpanval">
                    <center>
                        <a4j:commandButton id="idCanDos" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annulerDossier}" reRender="panelDossier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDos" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.validerDossier}" reRender="panelDossier,tableDossier" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.dossierExiste}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>