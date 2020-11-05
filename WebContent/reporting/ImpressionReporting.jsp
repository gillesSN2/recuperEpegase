<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="etatFinancierExploitation">

    <a4j:form id="tabBordExp">

        <center> <h2><h:outputText value="TABLEAUX DE BORD ET REPORTING (EXPLOITATION) : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.libelleReporting}" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGeneral" width="100%">
            <h:panelGrid columns="2" id="panelBoutonEf">
                <h:panelGrid columns="3" styleClass="recherche">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_tableau_selectionne}" style="width:300px;">
                        <f:selectItem itemLabel="Sélectionnez tableau" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.lesTableauxItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.selectionTableau}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="etatFinExpPG,tabBordExp,panelGeneral,panelBoutonEf,entete,resultatDiv,tableResultat,resultatTab,modAttente"/>
                    </h:selectOneMenu>
                    <a4j:commandButton title="Exécuter le calcul" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisType==1)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.calculTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter le calcul du tableau sélectionné?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.initImpressionTableaux}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                </h:panelGrid>
                <h:panelGrid columns="4" styleClass="recherche">
                    <h:commandButton image="/images/actualiser.png" title="Actualiser le tableau en cours" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.selectionEtatFinancier}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer le tableau sélectionné" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisType==0)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.supprimeTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/detail.png" title="Détail des formules du tableau en cours" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer)==true}" oncomplete="javascript:Richfaces.showModalPanel('panelFormule');" reRender="panelFormule"/>
                    <a4j:commandButton image="/images/configuration.png" style="height:28px;width:28px" title="Mise à jour des formules de tous les tableaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisType==0)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.majFormules}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les formules des tableaux?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="etatFinExpPG" border="0" width="100%" style="max-height:100%;border:0px solid green;"  columns="2" columnClasses="col,col">
                <h:panelGrid  width="100%" style="max-height:100%;border:1px solid black" id="entete">
                    <h:panelGrid columns="5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisType==1}" style="border:0px solid green;margin-top:1px;height:50px;width:800px" styleClass="col">
                        <h:outputText value="Date de Début"/>
                        <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.dateDebCalcul}"  style="background-color:white;" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" />
                        <h:outputText value="Date de Fin"/>
                        <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.dateFinCalcul}" style="background-color:white;" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" />
                        <h:panelGroup>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_jrxsit}"/> <h:outputText value="Inclure journaux de situation"/><br>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_jrxrsv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"/><h:outputText value="Inclure journaux privés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"/>
                        </h:panelGroup>
                    </h:panelGrid>

                    <t:div id="resultatDiv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablis_id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisType==1}" style="overflow-x:scroll;width:100%;max-height:100%;" >
                        <h:panelGrid  id="resultatTab" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_tableau}">
                            <rich:dataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.dataModelResultat}" id="tableResultat" border="0" footerClass="bard"  headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" var="element" style="max-height:100%;">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.selectionFormule}" reRender="listeTableau"/>
                                <rich:column width="40" sortable="true" sortBy="#{element.tabresNum}" sortOrder="ASCENDING">
                                    <f:facet name="header" ><h:outputText value="L."/></f:facet>
                                    <h:outputText value="#{element.tabresNum}" style="#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="100">
                                    <f:facet name="header" ><h:outputText value="Réf."/></f:facet>
                                    <h:outputText value="#{element.tabresReference}" style="#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="360">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{element.tabresLibFr}" style="#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col1}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col01}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom01}"/>
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==0&&element.tabresCol01!=0&&(element.tabresTypeCol01<=5||element.tabresTypeCol01>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==1&&element.tabresCol01!=0&&(element.tabresTypeCol01<=5||element.tabresTypeCol01>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==2&&element.tabresCol01!=0&&(element.tabresTypeCol01<=5||element.tabresTypeCol01>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol01}" rendered="#{element.tabresFormatCol01==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon01}" rendered="#{element.tabresFormatCol01==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon01}" rendered="#{element.tabresFormatCol01==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col2}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col02}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom02}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==0&&element.tabresCol02!=0&&(element.tabresTypeCol02<=5||element.tabresTypeCol02>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==1&&element.tabresCol02!=0&&(element.tabresTypeCol02<=5||element.tabresTypeCol02>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==2&&element.tabresCol02!=0&&(element.tabresTypeCol02<=5||element.tabresTypeCol02>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol02}" rendered="#{element.tabresFormatCol02==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon02}" rendered="#{element.tabresFormatCol02==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon02}" rendered="#{element.tabresFormatCol02==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col3}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col03}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom03}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==0&&element.tabresCol03!=0&&(element.tabresTypeCol03<=5||element.tabresTypeCol03>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==1&&element.tabresCol03!=0&&(element.tabresTypeCol03<=5||element.tabresTypeCol03>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==2&&element.tabresCol03!=0&&(element.tabresTypeCol03<=5||element.tabresTypeCol03>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol03}" rendered="#{element.tabresFormatCol03==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon03}" rendered="#{element.tabresFormatCol03==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon03}" rendered="#{element.tabresFormatCol03==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col4}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col04}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom04}"/>
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==0&&element.tabresCol04!=0&&(element.tabresTypeCol04<=5||element.tabresTypeCol04>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==1&&element.tabresCol04!=0&&(element.tabresTypeCol04<=5||element.tabresTypeCol04>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==2&&element.tabresCol04!=0&&(element.tabresTypeCol04<=5||element.tabresTypeCol04>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol04}" rendered="#{element.tabresFormatCol04==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon04}" rendered="#{element.tabresFormatCol04==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon04}" rendered="#{element.tabresFormatCol04==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column>
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col5}"  style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col05}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom05}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==0&&element.tabresCol05!=0&&(element.tabresTypeCol05<=5||element.tabresTypeCol05>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==1&&element.tabresCol05!=0&&(element.tabresTypeCol05<=5||element.tabresTypeCol05>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==2&&element.tabresCol05!=0&&(element.tabresTypeCol05<=5||element.tabresTypeCol05>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol05}" rendered="#{element.tabresFormatCol05==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon05}" rendered="#{element.tabresFormatCol05==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon05}" rendered="#{element.tabresFormatCol05==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col6}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col06}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom06}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==0&&element.tabresCol06!=0&&(element.tabresTypeCol06<=5||element.tabresTypeCol06>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==1&&element.tabresCol06!=0&&(element.tabresTypeCol06<=5||element.tabresTypeCol06>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==2&&element.tabresCol06!=0&&(element.tabresTypeCol06<=5||element.tabresTypeCol06>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol06}" rendered="#{element.tabresFormatCol06==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon06}" rendered="#{element.tabresFormatCol06==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon06}" rendered="#{element.tabresFormatCol06==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col7}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col07}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom07}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==0&&element.tabresCol07!=0&&(element.tabresTypeCol07<=5||element.tabresTypeCol07>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==1&&element.tabresCol07!=0&&(element.tabresTypeCol07<=5||element.tabresTypeCol07>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==2&&element.tabresCol07!=0&&(element.tabresTypeCol07<=5||element.tabresTypeCol07>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol07}" rendered="#{element.tabresFormatCol07==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon07}" rendered="#{element.tabresFormatCol07==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon07}" rendered="#{element.tabresFormatCol07==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col8}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col08}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom08}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==0&&element.tabresCol08!=0&&(element.tabresTypeCol08<=5||element.tabresTypeCol08>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==1&&element.tabresCol08!=0&&(element.tabresTypeCol08<=5||element.tabresTypeCol08>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==2&&element.tabresCol08!=0&&(element.tabresTypeCol08<=5||element.tabresTypeCol08>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol08}" rendered="#{element.tabresFormatCol08==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon08}" rendered="#{element.tabresFormatCol08==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon08}" rendered="#{element.tabresFormatCol08==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col9}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col08}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom09}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==0&&element.tabresCol09!=0&&(element.tabresTypeCol09<=5||element.tabresTypeCol09>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==1&&element.tabresCol09!=0&&(element.tabresTypeCol09<=5||element.tabresTypeCol09>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==2&&element.tabresCol09!=0&&(element.tabresTypeCol09<=5||element.tabresTypeCol09>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol09}" rendered="#{element.tabresFormatCol09==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon09}" rendered="#{element.tabresFormatCol09==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon09}" rendered="#{element.tabresFormatCol09==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col10}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col10}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom10}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==0&&element.tabresCol10!=0&&(element.tabresTypeCol10<=5||element.tabresTypeCol10>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==1&&element.tabresCol10!=0&&(element.tabresTypeCol10<=5||element.tabresTypeCol10>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==2&&element.tabresCol10!=0&&(element.tabresTypeCol10<=5||element.tabresTypeCol10>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol10}" rendered="#{element.tabresFormatCol10==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon10}" rendered="#{element.tabresFormatCol10==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon10}" rendered="#{element.tabresFormatCol10==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column>
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col11}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col11}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom11}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==0&&element.tabresCol11!=0&&(element.tabresTypeCol11<=5||element.tabresTypeCol11>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==1&&element.tabresCol11!=0&&(element.tabresTypeCol11<=5||element.tabresTypeCol11>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==2&&element.tabresCol11!=0&&(element.tabresTypeCol11<=5||element.tabresTypeCol11>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol11}" rendered="#{element.tabresFormatCol11==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon11}" rendered="#{element.tabresFormatCol11==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon11}" rendered="#{element.tabresFormatCol11==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col12}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col12}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom12}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==0&&element.tabresCol12!=0&&(element.tabresTypeCol12<=5||element.tabresTypeCol12>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==1&&element.tabresCol12!=0&&(element.tabresTypeCol12<=5||element.tabresTypeCol12>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==2&&element.tabresCol12!=0&&(element.tabresTypeCol12<=5||element.tabresTypeCol12>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol12}" rendered="#{element.tabresFormatCol12==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon12}" rendered="#{element.tabresFormatCol12==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon12}" rendered="#{element.tabresFormatCol12==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col13}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col13}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom13}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==0&&element.tabresCol13!=0&&(element.tabresTypeCol13<=5||element.tabresTypeCol13>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==1&&element.tabresCol13!=0&&(element.tabresTypeCol13<=5||element.tabresTypeCol13>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==2&&element.tabresCol13!=0&&(element.tabresTypeCol13<=5||element.tabresTypeCol13>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol13}" rendered="#{element.tabresFormatCol13==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon13}" rendered="#{element.tabresFormatCol13==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon13}" rendered="#{element.tabresFormatCol13==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col14}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col14}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom14}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==0&&element.tabresCol14!=0&&(element.tabresTypeCol14<=5||element.tabresTypeCol14>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==1&&element.tabresCol14!=0&&(element.tabresTypeCol14<=5||element.tabresTypeCol14>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==2&&element.tabresCol14!=0&&(element.tabresTypeCol14<=5||element.tabresTypeCol14>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol14}" rendered="#{element.tabresFormatCol14==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon14}" rendered="#{element.tabresFormatCol14==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon14}" rendered="#{element.tabresFormatCol14==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col15}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col15}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom15}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==0&&element.tabresCol15!=0&&(element.tabresTypeCol15<=5||element.tabresTypeCol15>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==1&&element.tabresCol15!=0&&(element.tabresTypeCol15<=5||element.tabresTypeCol15>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==2&&element.tabresCol15!=0&&(element.tabresTypeCol15<=5||element.tabresTypeCol15>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol15}" rendered="#{element.tabresFormatCol15==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon15}" rendered="#{element.tabresFormatCol15==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon15}" rendered="#{element.tabresFormatCol15==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col16}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col16}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom16}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==0&&element.tabresCol16!=0&&(element.tabresTypeCol16<=5||element.tabresTypeCol16>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==1&&element.tabresCol16!=0&&(element.tabresTypeCol16<=5||element.tabresTypeCol16>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==2&&element.tabresCol16!=0&&(element.tabresTypeCol16<=5||element.tabresTypeCol16>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol16}" rendered="#{element.tabresFormatCol16==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon16}" rendered="#{element.tabresFormatCol16==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon16}" rendered="#{element.tabresFormatCol16==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col17}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col17}" >
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom17}"/>
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==0&&element.tabresCol17!=0&&(element.tabresTypeCol17<=5||element.tabresTypeCol17>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==1&&element.tabresCol17!=0&&(element.tabresTypeCol17<=5||element.tabresTypeCol17>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==2&&element.tabresCol17!=0&&(element.tabresTypeCol17<=5||element.tabresTypeCol17>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol17}" rendered="#{element.tabresFormatCol17==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon17}" rendered="#{element.tabresFormatCol17==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon17}" rendered="#{element.tabresFormatCol17==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col18}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col18}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom18}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==0&&element.tabresCol18!=0&&(element.tabresTypeCol18<=5||element.tabresTypeCol18>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==1&&element.tabresCol18!=0&&(element.tabresTypeCol18<=5||element.tabresTypeCol18>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==2&&element.tabresCol18!=0&&(element.tabresTypeCol18<=5||element.tabresTypeCol18>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol18}" rendered="#{element.tabresFormatCol18==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon18}" rendered="#{element.tabresFormatCol18==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon18}" rendered="#{element.tabresFormatCol18==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col19}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col19}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom19}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==0&&element.tabresCol19!=0&&(element.tabresTypeCol19<=5||element.tabresTypeCol19>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==1&&element.tabresCol19!=0&&(element.tabresTypeCol19<=5||element.tabresTypeCol19>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==2&&element.tabresCol19!=0&&(element.tabresTypeCol19<=5||element.tabresTypeCol19>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol19}" rendered="#{element.tabresFormatCol19==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon19}" rendered="#{element.tabresFormatCol19==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon19}" rendered="#{element.tabresFormatCol19==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                                <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_largeur_col20}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_aff_col20}">
                                    <f:facet name="header" >
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.cptTabNom.tablisNom20}" />
                                    </f:facet>
                                    <h:outputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==0&&element.tabresCol20!=0&&(element.tabresTypeCol20<=5||element.tabresTypeCol20>=10)}" style="#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==1&&element.tabresCol20!=0&&(element.tabresTypeCol20<=5||element.tabresTypeCol20>=10)}" style="#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                    <h:outputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==2&&element.tabresCol20!=0&&(element.tabresTypeCol20<=5||element.tabresTypeCol20>=10)}" style="#{element.espaceFamille}">
                                    </h:outputText>
                                    <h:inputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==10}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==11}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                        <f:convertNumber type="percent" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCol20}" rendered="#{element.tabresFormatCol20==12}" style="text-align:right;width:95%;#{element.espaceFamille}">
                                    </h:inputText>
                                    <h:inputText value="#{element.tabresCon20}" rendered="#{element.tabresFormatCol20==13}" style="width:95%;#{element.espaceFamille}"/>
                                    <h:inputTextarea value="#{element.tabresCon20}" rendered="#{element.tabresFormatCol20==14}" rows="10" style="width:95%;#{element.espaceFamille}"/>
                                </rich:column >
                            </rich:dataTable>
                        </h:panelGrid>
                    </t:div>

                </h:panelGrid>

            </h:panelGrid>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Calcul du tableau en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.tabResultats.tabresNomFr} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.tabResultats.tabresReference}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.colonneEnCours} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.elementEnCours}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.var_currentValue} % "/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFormule" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="300">
        <center>
            <f:facet name="header"><h:outputText value="Détail des formules du tableau"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hidelink1For"/>
                    <rich:componentControl for="panelFormule" attachTo="hidelink1For" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalFor" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 0px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerForXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp" id="hideImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.nomRapport}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.lesModelsimpression}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menureporting.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.formEtatFinancierExploitation.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
