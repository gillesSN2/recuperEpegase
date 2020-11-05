<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="tfm">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES DEVISES (norme ISO 4217)" style="color:green;"/></h2></center>

        <h:panelGrid columns="2" id="dtdevises" columnClasses="cols,cols" width="100%">
            <h:column>
                <h:panelGrid columns="2"  id="dtdevisespan" columnClasses="cols,coldevise">
                    <h:column>
                        <h:column>
                            <a4j:commandButton title="Imprimer les devises" id="btpanelImp" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                            <br>
                        </h:column>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="310px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.dataModelDevises}" var="devises">
                                <a4j:support eventsQueue="maQueue" reRender="first,sousDvs,extsousDvs,btnAjouter,ctrl" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.selectionDevise}"/>
                                <rich:column width="15%"  sortable="true" sortBy="#{devises.code}">
                                    <f:facet name="header" ><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value=" #{devises.code}"/>
                                </rich:column>
                                <rich:column width="85%" sortable="true" sortBy="#{devises.libelle}">
                                    <f:facet name="header" ><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{devises.libelle}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                    <h:panelGrid id="ctrl">
                        <a4j:commandButton value=" > " title="Ajouter à vos devises" id="btnAjouter" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.var_aff_ajouter}" reRender="btnAjouter,first,extaddDvs"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.ajouterDevises}"/><br/><br/><br/><br/>
                        <a4j:commandButton value=" < " title="Supprimer de vos devises" id="btnSupprimer" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.var_aff_supprimer}" reRender="pboardAf,first,extaddDvs,btnSupprimer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.supprimerDevises}"/><br/><br/>
                        <a4j:commandButton value=" M " title="Modifier Valeur défaut" id="btnModifier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.var_aff_modifier}" reRender="panelModif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.modifierDevises}"/><br/><br/>
                    </h:panelGrid>
                </h:panelGrid>
            </h:column>
            <h:column>
                <h:panelGrid id="first" style="margin-top:40px;">
                    <h:panelGrid id="sousDvs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.dataModelDevisesDetail!=null}">
                        <h:column id="timp" rendered="false">
                            <h:outputText  style="background-color:green;color:white;font-weight:bold;width:200px;" value="Evolution du cours de la devise:"/>&nbsp;&nbsp;
                            <a4j:commandButton image="/images/print.png"  style="text-decoration:none;"  oncomplete="javascript:Richfaces.showModalPanel('panelImpDevDet');"/>
                        </h:column>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="extsousDvs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.dataModelDevisesDetail!=null}" width="560px" height="210px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.dataModelDevisesDetail}" var="detailsDevises">
                                <rich:column width="150" sortable="true" sortBy="#{detailsDevises.madate}" sortOrder="DESCENDING">
                                    <f:facet name="header"><h:outputText  value="Jour"/></f:facet>
                                    <h:outputText value=" #{detailsDevises.madate}">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column width="150" sortable="true" sortBy="#{detailsDevises.taux1}">
                                    <f:facet name="header" ><h:outputText  value="Unité / Devise"/></f:facet>
                                    <h:outputText value="#{detailsDevises.taux1}"  />
                                </rich:column>
                                <rich:column width="150" sortable="true" sortBy="#{detailsDevises.taux2}">
                                    <f:facet name="header" ><h:outputText  value="Devise / Unité"/></f:facet>
                                    <h:outputText value="#{detailsDevises.taux2}"  />
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="suite">
                        <h:column>
                            <h:outputText  style="background-color:green;color:white;font-weight:bold;width:200px;" value="Devises utilisées par l'entreprise."  />
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="extaddDvs" width="560px" height="150px" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd"  style="border:solid 0px green;cursor:pointer;" styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.dataModelDevisesChoisies}" var="devisesChoix">
                                    <a4j:support eventsQueue="maQueue" reRender="btnSupprimer,ctrl" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.selectionDeviseChoisie}"/>
                                    <rich:column width="15%">
                                        <f:facet name="header" ><h:outputText  value="Code"/></f:facet>
                                        <h:outputText value=" #{devisesChoix.devCode}"/>
                                    </rich:column>
                                    <rich:column width="45%">
                                        <f:facet name="header" ><h:outputText  value="Libellé"  /></f:facet>
                                        <h:outputText value="#{devisesChoix.devLibelle}"/>
                                    </rich:column>
                                    <rich:column width="20%" sortable="true" sortBy="#{detailsDevises.taux1}">
                                        <f:facet name="header" ><h:outputText  value="Unité / Devise"/></f:facet>
                                        <h:outputText value="#{devisesChoix.devTaux1}" rendered="#{devisesChoix.devTaux1!=0}"/>
                                    </rich:column>
                                    <rich:column width="20%" sortable="true" sortBy="#{detailsDevises.taux2}">
                                        <f:facet name="header" ><h:outputText  value="Devise / Unité"/></f:facet>
                                        <h:outputText value="#{devisesChoix.devTaux2}" rendered="#{devisesChoix.devTaux2!=0}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:column>      
        </h:panelGrid>
        <br>
        <center>
            <br>
            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.majStructureSite0}" value="Site XE.COM"/>&nbsp;&nbsp;&nbsp;
            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.majStructureSite1}" value="Site OANDA.COM"/>
            <br><br>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strsitedevise==0}">
                Cliquez  <A target="_blank" HREF="http://www.xe.com/ucc/fr/" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site de XE.COM (site de référence de gestion des devises).
            </h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strsitedevise==1}">
                Cliquez  <A target="_blank" HREF="http://www.oanda.com/" TITLE="description" style="color:blue;"> ici </A>  pour accéder au site de OANDA.COM (site de référence de gestion des devises).
            </h:column>
            <br><br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelModif" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.showModalPanelModif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.showModalPanelModif}" var="mod">
            <f:facet name="header"><h:outputText value="Valeurs par défaut"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.annulerDevises}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelModif"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalModif" >
                <h:panelGrid  width="100%" columns="2">
                    <h:column><h:outputText value="Unité / Devise"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.devise.devTaux1}"/></h:column>
                    <h:column><h:outputText value="Devise / Unité"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.devise.devTaux2}"/></h:column>
                </h:panelGrid>
                <center>
                    <br><br>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formDevises.validerDevises}"/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>