<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="panelListePlanComptable">

    <a4j:form id="formModalListePlanComptable">
        <rich:hotKey key="return" handler="return false;"/>
        <h:panelGrid width="100%" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="SELECTION DU COMPTE #{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature}"/></f:facet>
        </h:panelGrid>
        <br>
        <h:panelGroup id="idAjout" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==532||bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==533}" style="height:35px">
            <center>
                <a4j:commandButton id="idAdd" title="Ajouter compte" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.ajouterCompte}" reRender="panelCreationCompte"/>
            </center>
        </h:panelGroup>
        <a4j:region renderRegionOnly="false">
            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="listeCompte"/>
            <rich:extendedDataTable rows="200" id="listeCompte" height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.datamodelPlanComptable}" var="cpte" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.simpleSelection}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.extDTable}">
                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectionPlanComptable}" reRender="idVal,idAjout"/>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="id60">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationPlanComptable}" reRender="idSubView,idPan1"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="id62">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationPlanComptable}" reRender="idSubView,idPan1"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==531}" var="id531">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==532}" var="id532">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==533}" var="id533">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==534}" var="id534">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.recuperationPlanComptable}" reRender="idSubView,compteId,idCompteCompens"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==535}" var="id535">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recuperationPlanComptable}" reRender="idSubView,panelLigne"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==536}" var="id536">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.formTransfertCtrl.recuperationPlanComptable}" reRender="idSubView,panelLigne"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==537}" var="id537">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.recuperationPlanComptable}" reRender="idSubView,compteId,nomcompteId"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==538}" var="id538">
                    <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.recuperationPlanComptable}" reRender="idSubView,compteId,nomcompteId"/>
                </c:if>
                <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcCompte}" >
                    <f:facet name="header"><h:outputText value="N° Compte" /></f:facet>
                    <h:outputText value="#{cpte.plcCompte}"/>
                </rich:column>
                <rich:column  width="60%" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" filterBy="#{cpte.plcLibelleCpteFR}">
                    <f:facet name="header"><h:outputText value="Libellé du compte" /></f:facet>
                    <h:outputText value="#{cpte.plcLibelleCpteFR}" />
                </rich:column>
                <rich:column  width="20%" sortable="true" sortBy="#{cpte.plcLibelleNatureFR}">
                    <f:facet name="header"><h:outputText value="Nature du compte" /></f:facet>
                    <h:outputText value="#{cpte.plcLibelleNatureFR}" />
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br>
        <h:panelGroup id="idVal">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==60}" var="id60">
                    <a4j:commandButton id="idCanObj60" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annulePlanComptable}" reRender="idSubView,idPan1"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj60" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recuperationPlanComptable}" reRender="idSubView,idPan1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==62}" var="id62">
                    <a4j:commandButton id="idCanObj62" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annulePlanComptable}" reRender="idSubView,idPan1"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj62" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recuperationPlanComptable}" reRender="idSubView,idPan1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==531}" var="id531">
                    <a4j:commandButton id="idCanObj531" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.annulePlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj531" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==532}" var="id532">
                    <a4j:commandButton id="idCanObj532" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.annulePlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj532" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBrouillardMois.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==533}" var="id533">
                    <a4j:commandButton id="idCanObj533" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.annulePlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj533" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.recuperationPlanComptable}" reRender="idSubView,compteId,cpId,libNumcpte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}" focus="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.var_nom_champ}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==534}" var="id534">
                    <a4j:commandButton id="idCanObj534" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.annulePlanComptable}" reRender="idSubView,compteId,idCompteCompens"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj534" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitCompte.recuperationPlanComptable}" reRender="idSubView,compteId,idCompteCompens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==535}" var="id535">
                    <a4j:commandButton id="idCanObj535" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.annulePlanComptable}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj535" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitAnalList.recuperationPlanComptable}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==536}" var="id536">
                    <a4j:commandButton id="idCanObj536" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.formTransfertCtrl.annulePlanComptable}" reRender="idSubView,panelLigne"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj536" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.formTransfertCtrl.recuperationPlanComptable}" reRender="idSubView,panelLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==537}" var="id537">
                    <a4j:commandButton id="idCanObj537" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.annulePlanComptable}" reRender="idSubView,compteId,nomcompteId"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj537" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlansTresorerie.recuperationPlanComptable}" reRender="idSubView,compteId,nomcompteId" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nature==538}" var="id538">
                    <a4j:commandButton id="idCanObj538" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.annulePlanComptable}" reRender="idSubView,compteId,idCompteCompens"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValObj538" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formExtraitClasse.recuperationPlanComptable}" reRender="idSubView,compteId,idCompteCompens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.selectPlanComptable}"/>
                </c:if>
            </center>
        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelCreationCompte" width="700" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelCreationCompte}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelCreationCompte}" var="crcpt">
            <f:facet name="header">
                <h:panelGroup><h:outputText value="CREATION D'UN COMPTE"></h:outputText></h:panelGroup>
            </f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.annuleCreationCompte}" image="/images/close.gif" styleClass="hidelink" reRender="panelCreationCompte"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelCompte" width="100%">
                    <h:panelGrid id="selectCompte" style="border:1px solid green;" width="100%">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.maNature}">
                            <f:selectItem itemLabel="Sélectionner une nature" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesNatureCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.chargeRacineCompte}" reRender="racItem1" />
                        </h:selectOneMenu>
                        <h:selectOneMenu id="racItem1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.maRacine}">
                            <f:selectItem itemLabel="Sélectionner une racine" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.mesRacineCompteItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.calculeCompte}" reRender="intRac,GrpMunCpt,pgNumCpt,buttCompte" />
                        </h:selectOneMenu>
                        <h:outputText value="Racine/Compte:"/>
                        <h:panelGroup id="intRac" >
                            <h:outputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.racinecle}" />
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.partieCompte}" maxlength="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.nbcarmax}">
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.valideCreationCompte}"/>
                            </h:inputText>
                        </h:panelGroup>
                        <h:outputText value="Numero compte:"/>
                        <h:panelGroup id="GrpMunCpt">
                            <h:inputText style="margin-left:25px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.planComptable.plcCompte}" readonly="true" required="true"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" reRender="buttCompte,GrpMunCpt,pgNumCpt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.valideCreationCompte}"/>
                        </h:panelGroup>
                        <h:outputText value="Intitulé Compte:"/>
                        <h:panelGroup id="pgNumCpt">
                            <h:inputText style="margin-left:25px;width:400px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.planComptable.plcLibelleCpteFR}"/>
                        </h:panelGroup>
                    </h:panelGrid>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttCompte">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.saveCompte}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.existeCopteDeja}" reRender="panelCreationCompte,listeCompte,scrollTable"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>