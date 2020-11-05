<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="lcr">

    <center><h2><h:outputText value="LISTE DES CLES DE REPARTITION DU GROUPE #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" style="color:green;font-size:16px;"/></h2></center>

    <a4j:form>

        <h:panelGrid width="100%">

            <h:panelGrid id="btnAnal" width="200px" columns="4">
                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle clée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.ajouterCle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}" reRender="panelPlanAnalytique,formModalPlan,panelPlanActivite,formModalActivite"></a4j:commandButton>
                <a4j:commandButton image="/images/modifier.png" title="Modifier une clée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.modifierCle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.showButtonModif}" reRender="panelPlanAnalytique,formModalPlan,panelPlanActivite,formModalActivite"/>
                <a4j:commandButton image="/images/supprimer.png" title="Supprimer une clée"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.showButtonSupp}"reRender="panellist,scrollTable" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.supprimerCle}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément ?')) return false"  />
                <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" rendered="false"/>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="panellist"/>
                <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="panellist" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.dataModelLesPlansAnalytiques}" var="planAnal">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" reRender="btnAnal" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.selectionCle}"/>
                    <rich:column  sortable="false" width="20%" >
                        <f:facet name="header"><h:outputText  value="CODE" /></f:facet>
                        <h:outputText value="#{planAnal.anaCode}" id="cod"/>
                    </rich:column>
                    <rich:column  width="70%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="LIBELLE" /></f:facet>
                        <h:outputText value="#{planAnal.anaNomFr}"/>
                    </rich:column>
                    <rich:column  width="10%" sortable="false" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="ETAT" /></f:facet>
                        <h:commandButton disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.inactifPlb}"  image="#{planAnal.etat}" id="etat" rendered="#{planAnal.afficheImag}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

        </h:panelGrid>
        <br>
        <center>
            <h:panelGroup>
                <a4j:commandButton value="Mise à jour des structures du groupe" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:250px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.majClesStructure}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les structures du groupe ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente}"/>
            </h:panelGroup>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPlanAnalytique" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.showModalPanelActivite}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.showModalPanelActivite}" var="clr">
            <f:facet name="header"><h:outputText value="GESTION DE LA CLE DE REPARTITION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.annulerSaisie}" image="/images/close.gif" styleClass="hidelink" reRender="panelPlanAnalytique"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid width="100%" id="panGlobal">
                    <h:panelGrid columns="2" id="mod" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="Code clé:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.plansAnalytiques.anaCode}" onkeypress="return scanToucheLettre(event)" size="10" maxlength="20" style="text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.plansAnalytiques.anaId!=0}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.verifCle}" reRender="panGlobal,panyas,buttGrp"/>
                            </h:inputText>
                            <h:panelGroup id="panyas">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.existCod}">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                                </h:panelGroup>
                            </h:panelGroup>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.plansAnalytiques.anaId!=0}"><h:outputText value="Inactif:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.plansAnalytiques.anaId!=0}"><h:selectBooleanCheckbox  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.inactifPlb}"/></h:column>
                        </h:column>
                        <h:column><h:outputText value="Libellé clé:"/></h:column>
                        <h:column><h:inputText style="width:100%" maxlength="100" onkeypress="return scanToucheLettre(event)" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.plansAnalytiques.anaNomFr}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable enableContextMenu="true" id="tableCompte" border="0" headerClass="headerTab" noDataLabel=" " activeClass="active-row" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.dataModelRepartition}" var="repAna" >
                            <rich:column id="idAct" label="ID structure" width="10%" sortable="false" sortBy="#{repAna.cleCodeActivite}" >
                                <f:facet name="header"><h:outputText  value="ID STR" /></f:facet>
                                <h:outputText value="#{repAna.cleIdStr}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Sigle" /></f:facet>
                                <h:outputText value="#{repAna.cleSigleStr}"/>
                            </rich:column>
                            <rich:column  width="50%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Nom structure" /></f:facet>
                                <h:outputText value="#{repAna.cleNomStr}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{repAna.cleRepStr}" style="width:90%;text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.calculTotal}" reRender="idTotal"/>
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <center>
                        <h:panelGrid id="idTotal" styleClass="fichefournisseur" style="width:100%;text-align;right;" columns="2">
                            <h:column><h:outputText value="Total clé:"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.totRepartition}" style="text-align:right;"/></h:column>
                        </h:panelGrid>
                    </center>
                </h:panelGrid>
                <br><br>
                <center>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.existCod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formPlansAnalytiques.validerCle}" style="margin-top:5px;" reRender="panelPlanAnalytique,panellist"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
