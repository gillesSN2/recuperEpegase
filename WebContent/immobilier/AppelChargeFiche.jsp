<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="appelchargefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="GENERATION D'UN APPEL DE CHARGE" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">
            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70d" id="idPanGlob">
                <h:column><h:outputText value="Mode appel de charge:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_mode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItem itemLabel="NORMAL" itemValue="0"/>
                        <f:selectItem itemLabel="EXCEPTIONNEL" itemValue="1"/>
                        <f:selectItem itemLabel="FONDS ROULEMENT" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.selectionMode}" reRender="idPanGlob,idLib1,idLib2,idBudget,tableAppartement,scrollTableAppartement,idTotMl,idTotBud1,idTotBud2,idTotBud3,idPeiode1,idPeiode2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Sélection Période:"/></h:column>
                <h:column id="idPeiode2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_mode=='0'}">
                    <h:selectOneMenu style="width:100%" id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.periode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column id="idPeiode1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_mode!='0'}">
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_date_periode}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_mode!='0'}"><h:outputText value="Objet facture:"/></h:column>
                <h:column id="idPeiode3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_mode!='0'}">
                    <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_lib_periode}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}"/>
                </h:column>
                <h:column><h:outputText value="Sélection Bien:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idBien" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_idImmeuble}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItem itemLabel="Sélection bien" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.mesBiensItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.calculBudget}" reRender="idBudget,tableAppartement,scrollTableAppartement,idTotMl"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Sélection Budget:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idBudget" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_idBudget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItem itemLabel="Sélection budget" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.mesBudgetsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.selectionBudget}" reRender="tableAppartement,scrollTableAppartement,idTotBud1,idTotBud2,idTotBud3"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Sélection Série:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_serie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.mesSerieUserItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Sélection Modèle facture:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idModele" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_modeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.mesImpressionsFacturesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Sélection Tva:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" id="idTva" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_codeTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action==21}">
                        <f:selectItem itemLabel="Sélection Tva" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesTaxesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.selectionTva}" reRender="tableAppartement,scrollTableAppartement"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Total Budget annuel:"/></h:column>
                <h:column>
                    <h:outputText id="idTotBud1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.totalBudget}" style="text-align:right;">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total Budget trimestriel:"/></h:column>
                <h:column>
                    <h:outputText id="idTotBud2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.totalBudgetTrim}" style="text-align:right;">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total Relquat A-1:"/></h:column>
                <h:column>
                    <h:outputText id="idTotBud3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.totalBudgetTrimReliquat}" style="text-align:right;">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Total millième:"/></h:column>
                <h:column>
                    <h:outputText id="idTotMl" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.totalMillieme}" style="text-align:right;">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                    </h:outputText>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.appelCharge.appchaMode==1}" id="idLib1"><h:outputText value="Libellé exceptionnel:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.appelCharge.appchaMode==1}" id="idLib2"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.appelCharge.appchaObject}"/></h:column>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.pageIndex}" reRender="tableAppartement" id="scrollTableAppartement" maxPages="20" align="left" for="tableAppartement"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAppartement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.dataModelAppartements}" var="app">
                    <rich:column label="Numéro appartement" sortable="true" sortBy="#{app.bieNum}">
                        <f:facet name="header"><h:outputText  value="N° Appartement" /></f:facet>
                        <h:outputText value="#{app.bieNum}"/>
                    </rich:column>
                    <rich:column label="Etage"  width="100px" sortable="true" sortBy="#{app.bieEtage}">
                        <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                        <h:outputText value="#{app.bieEtage}"/>
                    </rich:column>
                    <rich:column label="Nom Propriétaire" width="300px" sortable="true" sortBy="#{app.bieNomTiers}">
                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                        <h:outputText value="#{app.bieNomTiers}"/>
                    </rich:column>
                    <rich:column label="Millième" sortable="true" sortBy="#{app.bieMillieme}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Millième" /></f:facet>
                        <h:outputText value="#{app.bieMillieme}" style="text-align:right;"/>
                    </rich:column>
                    <rich:column label="Prix unitaire des millièmes" sortable="true"sortBy="#{app.pu}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="P.U." /></f:facet>
                        <h:outputText value="#{app.pu}" style="text-align:right;">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Prix total" sortable="true" sortBy="#{app.ptHt}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Total H.T." /></f:facet>
                        <h:outputText value="#{app.ptHt}" style="text-align:right;">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Prix Txa" sortable="true" sortBy="#{app.ptTaxe}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Total Taxe" /></f:facet>
                        <h:outputText value="#{app.ptTaxe}" style="text-align:right;">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Prix total TTC" sortable="true" sortBy="#{app.ptTtc}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Total T.T.C." /></f:facet>
                        <h:outputText value="#{app.ptTtc}" style="text-align:right;">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Prix total Reliquat A-1" sortable="true" sortBy="#{app.ptTtcReliquat}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Total Reliquat" /></f:facet>
                        <h:outputText value="#{app.ptTtcReliquat}" style="text-align:right;">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Liste des lots" sortable="true" sortBy="#{app.numlot}">
                        <f:facet name="header"><h:outputText  value="Liste des lots" /></f:facet>
                        <h:outputText value="#{app.numlot}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br/>  <br/>
        <center>
            <h:panelGroup id="valideFacture">
                <br><br>
                <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.annulerGeneAuto}" reRender="idSubView"/>&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.validerFacturation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_action!=21}"/>
            </h:panelGroup>
        </center>
    </a4j:form>


</f:subview>
