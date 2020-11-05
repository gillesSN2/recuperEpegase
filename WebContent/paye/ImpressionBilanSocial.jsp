<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="bilansocial">

    <a4j:form id="etatbilansocial">

        <center> <h2><h:outputText value="BILAN SOCIAL (EXPLOITATION) - EXERCICE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.selectedExo.exepayId} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.structureLog.strbilansocial}" styleClass="titre"/></h2></center>

        <h:panelGrid id="panelGeneral" width="100%">
            <h:panelGrid columns="2" id="panelBoutonEf">
                <h:panelGrid columns="4" styleClass="recherche">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_tableau_selectionne}" style="width:250px;">
                        <f:selectItem itemLabel="Sélectionnez tableau" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.lesTableauxItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.selectionBilanSocial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="etatFinExpPG,etatFinExp,panelGeneral,panelBoutonEf,entete,resultatDiv,tableResultat,resultatTab,modAttente"/>
                    </h:selectOneMenu>
                    <h:panelGrid styleClass="recherche" columns="2">
                        <a4j:commandButton value="Calcul tableau sélectionné" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.calculTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer le tableau en cours" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.initImpressionTableauEnCours}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                    <h:panelGrid styleClass="recherche" columns="2">
                        <a4j:commandButton value="Calcul Bilan social complet" style="width:100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.calculerBilan}" onclick="if (!confirm('Etes-vous sur de vouloir exécuter/enregistrer les tableaux sélectionnés?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" oncomplete="javascript:Richfaces.hideModalPanel('panelBarProg');" reRender="modAttente,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                        <a4j:commandButton title="Imprimer bilan social complet" image="/images/print.png" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.initImpressionBilanComplet}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid columns="6" styleClass="recherche">
                    <a4j:commandButton image="/images/actualiser.png" title="Actualiser le tableau en cours" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.selectionEtatFinancierSuite}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/modifier.png" title="Modifier le tableau sélectionné" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.modifieTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir modifier le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/supprimer.png" title="Supprimer le tableau sélectionné" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.supprimeTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le tableau en cours?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/duplicate.png" title="Dupliquer le tableau sélectionné à partir de N-1" style="height:28px;width:28px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifLiasse<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.dup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.duppliqueTableaux}" onclick="if (!confirm('Etes-vous sur de vouloir Dupliquer le tableau en cours à partir de N-1?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelGeneral,panelBarProg,etatFinExpPG,progressPanel,barprg,resultatDiv"/>
                    <a4j:commandButton image="/images/detail.png" title="Détail des formules du tableau en cours" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.testAffImprimer)==true}" oncomplete="javascript:Richfaces.showModalPanel('panelFormule');" reRender="panelFormule"/>
                    <h:commandButton image="/images/configuration.png" title="Mise à jour des formules de tous les tableaux" style="height:28px;width:28px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.majFormules}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les formules des tableaux?')) return false;javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid  width="100%" style="max-height:100%;border:1px solid black" id="entete">
                <h:panelGrid columns="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.afficheValider}" style="border:0px solid green;margin-top:1px;height:50px;width:100%" styleClass="col">
                    <h:outputText value="Date de Début"/>
                    <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.dateDebCalcul}"  style="background-color:white;" locale="FR"  enableManualInput="true" datePattern="dd/MM/yyyy"  />
                    <h:outputText value="Date de Fin"/>
                    <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.dateFinCalcul}" style="background-color:white;" locale="FR"  enableManualInput="true" datePattern="dd/MM/yyyy" />
                </h:panelGrid>

                <t:div id="resultatDiv" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablis_id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisType==10}" style="overflow-x:scroll;width:100%;max-height:100%;" >
                    <h:panelGrid  id="resultatTab" width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_tableau}">
                        <rich:dataTable value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.dataModelResultat}" id="tableResultat" border="0" footerClass="bard"  headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" var="element" style="max-height:100%;">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.selectionFormule}" reRender="listeTableau"/>
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
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col1}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col01}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom01}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol01==6}" value="#{element.tabresCol01}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol01==7}" value="#{element.tabresCon01}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol01==8}" value="#{element.tabresCon01}"/>
                                <h:outputText value="#{element.tabresCol01}" style="#{element.espaceFamille}" rendered="#{element.tabresCol01!=0&&(element.tabresTypeCol01<=5||element.tabresTypeCol01>=10)}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne01}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col2}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col02}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom02}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol02==6}" value="#{element.tabresCol02}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol02==7}" value="#{element.tabresCon02}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol02==8}" value="#{element.tabresCon02}"/>
                                <h:outputText value="#{element.tabresCol02}" style="#{element.espaceFamille}" rendered="#{element.tabresCol02!=0&&(element.tabresTypeCol02<=5||element.tabresTypeCol02>=10)}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c02" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne02}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col3}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col03}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom03}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol03==6}" value="#{element.tabresCol03}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol03==7}" value="#{element.tabresCon03}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol03==8}" value="#{element.tabresCon03}"/>
                                <h:outputText value="#{element.tabresCol03}" style="#{element.espaceFamille}" rendered="#{element.tabresCol03!=0&&(element.tabresTypeCol03<=5||element.tabresTypeCol03>=10)}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne03}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col4}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col04}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom04}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol04==6}" value="#{element.tabresCol04}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol04==7}" value="#{element.tabresCon04}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol04==8}" value="#{element.tabresCon04}"/>
                                <h:outputText value="#{element.tabresCol04}" style="#{element.espaceFamille}" rendered="#{element.tabresCol04!=0&&(element.tabresTypeCol04<=5||element.tabresTypeCol04>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne04}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col5}"  style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col05}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom05}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol05==6}" value="#{element.tabresCol05}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol05==7}" value="#{element.tabresCon05}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol05==8}" value="#{element.tabresCon05}"/>
                                <h:outputText value="#{element.tabresCol05}" style="#{element.espaceFamille}" rendered="#{element.tabresCol05!=0&&(element.tabresTypeCol05<=5||element.tabresTypeCol05>=10)}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne05}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col6}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col06}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom06}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol06==6}" value="#{element.tabresCol06}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol06==7}" value="#{element.tabresCon06}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol06==8}" value="#{element.tabresCon06}"/>
                                <h:outputText value="#{element.tabresCol06}" style="#{element.espaceFamille}" rendered="#{element.tabresCol06!=0&&(element.tabresTypeCol06<=5||element.tabresTypeCol06>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne06}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col7}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col07}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom07}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol07==6}" value="#{element.tabresCol07}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol07==7}" value="#{element.tabresCon07}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol07==8}" value="#{element.tabresCon07}"/>
                                <h:outputText value="#{element.tabresCol07}" style="#{element.espaceFamille}" rendered="#{element.tabresCol07!=0&&(element.tabresTypeCol07<=5||element.tabresTypeCol07>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne07}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col8}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col08}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom08}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol08==6}" value="#{element.tabresCol08}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol08==7}" value="#{element.tabresCon08}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol08==8}" value="#{element.tabresCon08}"/>
                                <h:outputText value="#{element.tabresCol08}" style="#{element.espaceFamille}" rendered="#{element.tabresCol08!=0&&(element.tabresTypeCol08<=5||element.tabresTypeCol08>=10)}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne08}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col9}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col08}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom09}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol09==6}" value="#{element.tabresCol09}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol09==7}" value="#{element.tabresCon09}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol09==8}" value="#{element.tabresCon09}"/>
                                <h:outputText value="#{element.tabresCol09}" style="#{element.espaceFamille}" rendered="#{element.tabresCol09!=0&&(element.tabresTypeCol09<=5||element.tabresTypeCol09>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne09}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col10}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col10}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom10}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==6}" value="#{element.tabresCol10}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==7}" value="#{element.tabresCon10}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==8}" value="#{element.tabresCon10}"/>
                                <h:outputText value="#{element.tabresCol10}" style="#{element.espaceFamille}" rendered="#{element.tabresCol10!=0&&(element.tabresTypeCol10<=5||element.tabresTypeCol10>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne10}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column>
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col11}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col11}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom11}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol11==6}" value="#{element.tabresCol11}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol11==7}" value="#{element.tabresCon11}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol11==8}" value="#{element.tabresCon11}"/>
                                <h:outputText value="#{element.tabresCol11}" style="#{element.espaceFamille}"  rendered="#{element.tabresCol11!=0&&(element.tabresTypeCol11<=5||element.tabresTypeCol11>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne11}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col12}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col12}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom12}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%" rendered="#{element.tabresTypeCol12==6}" value="#{element.tabresCol12}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol12==7}" value="#{element.tabresCon12}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol12==8}" value="#{element.tabresCon12}"/>
                                <h:outputText value="#{element.tabresCol12}" style="#{element.espaceFamille}" rendered="#{element.tabresCol12!=0&&(element.tabresTypeCol12<=5||element.tabresTypeCol12>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne12}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col13}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col13}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom13}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol13==6}" value="#{element.tabresCol13}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol13==7}" value="#{element.tabresCon13}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol13==8}" value="#{element.tabresCon13}"/>
                                <h:outputText value="#{element.tabresCol13}" style="#{element.espaceFamille}" rendered="#{element.tabresCol13!=0&&(element.tabresTypeCol13<=5||element.tabresTypeCol13>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne13}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col14}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col14}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom14}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol14==6}" value="#{element.tabresCol14}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol14==7}" value="#{element.tabresCon14}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol14==8}" value="#{element.tabresCon14}"/>
                                <h:outputText value="#{element.tabresCol14}" style="#{element.espaceFamille}" rendered="#{element.tabresCol14!=0&&(element.tabresTypeCol14<=5||element.tabresTypeCol14>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne14}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col15}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col15}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom15}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol15==6}" value="#{element.tabresCol15}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol15==7}" value="#{element.tabresCon15}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol15==8}" value="#{element.tabresCon15}"/>
                                <h:outputText value="#{element.tabresCol15}" style="#{element.espaceFamille}" rendered="#{element.tabresCol15!=0&&(element.tabresTypeCol15<=5||element.tabresTypeCol15>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne15}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col16}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col16}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom16}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol10==6}" value="#{element.tabresCol16}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol16==7}" value="#{element.tabresCon16}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol16==8}" value="#{element.tabresCon16}"/>
                                <h:outputText value="#{element.tabresCol16}" style="#{element.espaceFamille}" rendered="#{element.tabresCol16!=0&&(element.tabresTypeCol16<=5||element.tabresTypeCol16>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne16}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col17}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col17}" >
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom17}"/>
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol17==6}" value="#{element.tabresCol17}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol17==7}" value="#{element.tabresCon17}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol17==8}" value="#{element.tabresCon17}"/>
                                <h:outputText value="#{element.tabresCol17}" style="#{element.espaceFamille}" rendered="#{element.tabresCol17!=0&&(element.tabresTypeCol17<=5||element.tabresTypeCol17>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne17}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col18}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col18}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom18}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol18==6}" value="#{element.tabresCol18}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol18==7}" value="#{element.tabresCon18}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol18==8}" value="#{element.tabresCon18}"/>
                                <h:outputText value="#{element.tabresCol18}" style="#{element.espaceFamille}" rendered="#{element.tabresCol18!=0&&(element.tabresTypeCol18<=5||element.tabresTypeCol18>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne18}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col19}" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col19}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom19}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol19==6}" value="#{element.tabresCol19}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol19==7}" value="#{element.tabresCon19}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol19==8}" value="#{element.tabresCon19}"/>
                                <h:outputText value="#{element.tabresCol19}" style="#{element.espaceFamille}" rendered="#{element.tabresCol19!=0&&(element.tabresTypeCol19<=5||element.tabresTypeCol19>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne19}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                            <rich:column width="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_largeur_col20}" style="text-align:right"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_aff_col20}">
                                <f:facet name="header" >
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.cptTabNom.tablisNom20}" />
                                </f:facet>
                                <h:inputText style="text-align:right;width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol20==6}" value="#{element.tabresCol20}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                                <h:inputText style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol20==7}" value="#{element.tabresCon20}"/>
                                <h:inputTextarea rows="10" style="width:95%;#{element.espaceFamille}" rendered="#{element.tabresTypeCol20==8}" value="#{element.tabresCon20}"/>
                                <h:outputText value="#{element.tabresCol20}" style="#{element.espaceFamille}" rendered="#{element.tabresCol20!=0&&(element.tabresTypeCol20<=5||element.tabresTypeCol20>=10)}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:commandButton image="/images/detail.png" alt="c01" style="width:15px;height:15px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.detailColonne20}" rendered="#{element.tabresType==3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelEcritureDetail"/>&nbsp;&nbsp;
                                </h:outputText>
                            </rich:column >
                        </rich:dataTable>
                    </h:panelGrid>
                </t:div>

            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Calcul du tableau en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.tabResultats.tabresNomFr} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.tabResultats.tabresReference}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.colonneEnCours} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.elementEnCours}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.var_currentValue} % "/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFormule" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="600" height="300">
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
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerForXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp" id="hideImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <h:panelGrid  width="100%" >
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerPRT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerJRV}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerPDF}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelEcritureDetail" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="650" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.showModalPanelDetailCalcul}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.showModalPanelDetailCalcul}" var="bcp">
            <f:facet name="header"><h:outputText value="Détail du poste #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.tabResultats.tabresLibFr} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.tabResultats.tabresReference}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.fermerDetailLigne}" image="/images/close.gif" styleClass="hidelink" reRender="panelEcritureDetail">
                        <rich:componentControl for="panelEcritureDetail" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <h:panelGrid width="100%">
                <rich:extendedDataTable id="tabletabformule" height="90px"  activeClass="active-row" noDataLabel=" "  footerClass="bard"headerClass="headerTab" styleClass="bg"  width="100%" border="0"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.lesFormules}" var="formule">
                    <rich:column width="20%" sortable="false" sortBy="#{formule.tabfor_id}" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                        <h:outputText value="#{formule.var_sens}" />
                    </rich:column >
                    <rich:column width="80%" sortable="false">
                        <f:facet name="header" ><h:outputText value="FORMULE"/></f:facet>
                        <h:outputText value="#{formule.tabforFormule}" />
                    </rich:column >
                </rich:extendedDataTable>
            </h:panelGrid>
            <br>
            <a4j:form id="formModalEcritureDetail">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableCompte"/>
                <rich:extendedDataTable rows="100" id="tableCompte" footerClass="bard" headerClass="headerTab" enableContextMenu="true" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="450px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formBilanSocial.dataModelEcrituresDetail}" var="balance">
                    <rich:column label="N° Compte" sortable="false" width="100px">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{balance.ecrBalCompte}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="false" width="350px">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{balance.ecrBalLibelle}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitAN}" rendered="#{balance.ecrDebitAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditAN}" rendered="#{balance.ecrCreditAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitMVTS}" rendered="#{balance.ecrDebitMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditMVTS}" rendered="#{balance.ecrCreditMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitSOLDE}" rendered="#{balance.ecrDebitSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="120px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditSOLDE}" rendered="#{balance.ecrCreditSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
