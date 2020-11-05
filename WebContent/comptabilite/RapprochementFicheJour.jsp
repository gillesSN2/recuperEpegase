<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Rppsm">

    <a4j:form id="form1">

        <center> <h2><h:outputText value="SAISIE DES RAPPROCHEMENTS BANCAIRES (JOURNALIER)" styleClass="titre"/></h2></center>

        <h:panelGrid  columns="2"  width="100%" id="idGlobal" >
            <h:panelGrid  columns="2"  width="100%" id="pngGlob" >
                <h:panelGrid id="pnlgrdfrm" styleClass="fichefournisseur1" style="width:100%;height:95px;" >
                    <h:panelGroup>
                        <h:outputText value="Journal: " style="font-weight:bold;"/><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.journauxActif.pljCode} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.journauxActif.pljLibelleFr} _ (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.devise})" style = "margin-left:20;"/>
                    </h:panelGroup>
                    <h:panelGroup>
                        <h:outputText value="Jour: " style="font-weight:bold;"/><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.journauxJour.joujrDate}" style = "margin-left:20;" datePattern="dd-MM-yyyy" disabled="true" readonly="true"/>
                    </h:panelGroup>
                    <h:panelGrid columns="7" id="pngButton" width="100%">
                        <h:commandButton value="FERMER"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.fermerLeJournalJourEncours}" tabindex="0" styleClass="fermer" id="hidelink9"/>
                        <a4j:commandButton title="Pointer tout le rapprochement" image="/images/allSelect.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.pointeRapprochementJour}" onclick="if (!confirm('Etes vous sur de vouloir pointer toutes les lignes non pointées du journal?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pgrsld,richpanlisteECR,scrollTable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}"/>
                        <a4j:commandButton title="Effacer tout le rapprochement" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.effaceRapprochementJour}" onclick="if (!confirm('Etes vous sur de vouloir supprimer tous les pointages du journal?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pgrsld,richpanlisteECR,scrollTable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}"/>
                        <a4j:commandButton title="Imprimer le rapprochement" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp,panelMail"/>
                        <a4j:commandButton title="Nouvelle écriture extra comptable" image="/images/ajouter.png"  oncomplete="javascript:Richfaces.showModalPanel('panelExtra');" reRender="panelExtra" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ajouterExtra}"/>
                        <a4j:commandButton title="Supprimer la ligne sélectionnée (extra cpte)" image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.suprimeEcritureExtra}" onclick="if (!confirm('Etes vous sur de vouloir supprimer la ligne sélectionnée?')) return false" reRender="pgrsld,richpanlisteECR,scrollTable,panelMessage,pngButton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecritures.ecr_id==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecritures.ecrIdOrigine!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}"/>
                        <h:commandButton title="Clôturer le rapprochement" image="/images/lock.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.clotureRapprochementJour}" onclick="if (!confirm('Etes vous sur de vouloir clôturer le rapprochement bancaire?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.clo&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}"/>
                    </h:panelGrid>
                </h:panelGrid>
                <h:panelGrid  id="pgrsld" styleClass="fichefournisseur1" columns="2" style="width:100%;height:95px;">
                    <h:column id="sAnt" rendered="false">
                        <h:column><h:outputText value="Solde Relevé Antérieur:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.soldeAnterieur}"  style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:column>
                    <h:column id="sCompte">
                        <h:column><h:outputText value="Solde journal:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.soldeComptaAnterieur}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:column>
                    <h:column  id="sAutre">
                        <h:column><h:outputText value="Ecritures sélectionnées:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.calculette}" style = "text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:column>
                    <h:column id="sReleve" rendered="false">
                        <h:column><h:outputText value="Solde Relevé En Cours:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.soldeReleve}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action!=1}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.calcultotaux}" reRender="rapflag,pgrsld,rapbac,sFinal,sEcart,sReleve,sCompte,pngButton" />
                            </h:inputText>
                        </h:column>
                    </h:column>
                    <h:column id="sEcart">
                        <h:column><h:outputText value="Solde rapproché:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecart}" style = "color:red;text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:column>
                    <h:column id="sFinal">
                        <h:column rendered="false"><h:outputText value="Controle final:" style="font-weight:bold;"/></h:column><br>
                        <h:column>
                            <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_final}" style = "color:red;text-align:right;" readonly="true" rendered="false">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <a4j:commandButton title="Actualiser le contrôle final" image="/images/actualiser.png" style="width:20px;height:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.actualiserCtrlJour}" onclick="if (!confirm('Etes vous sur de vouloir actualier le contrôle final?')) return false" reRender="pgrsld,sFinal,paneTotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1}"/>
                        </h:column>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
            <br>
            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.pageIndex}" reRender="richpanlisteECR" id="scrollTable" maxPages="20"align="left" for="richpanlisteECR"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_nb_max}" border="0" width="100%" noDataLabel=" " headerClass="headerTab" style="max-height:100%;border:solid 0px green;" id="richpanlisteECR" selectedClass="active-row" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.datamodelEcritures}" var="table" rowClasses="rows1,rows2,rowsd" sortMode="multi" selectionMode="Multi" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selection}" >
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionEcriture}" reRender="pngButton,pnlgrdfrm,rapbac,sAutre,pgrsld"/>
                        <rich:column sortable="true" sortBy="#{table.ecrDateSaisie}">
                            <f:facet name="header"><h:outputText value="Date"/></f:facet>
                            <h:outputText value="#{table.ecrDateSaisie}" style="color:#{table.couleur}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrCompte}">
                            <f:facet name="header"><h:outputText value="N° de compte"/></f:facet>
                            <h:outputText value="#{table.ecrCompte}" style="color:#{table.couleur}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrPiece}">
                            <f:facet name="header"><h:outputText value="N° de pièce"/></f:facet>
                            <h:outputText value="#{table.ecrPiece}" style="color:#{table.couleur}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrReference1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef1Piece}">
                            <f:facet name="header"><h:outputText  value="Référence1"/></f:facet>
                            <h:outputText value="#{table.ecrReference1}" style="color:#{table.couleur}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrReference2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef2Piece}">
                            <f:facet name="header"><h:outputText value="Référence2"/></f:facet>
                            <h:outputText value="#{table.ecrReference2}" style="color:#{table.couleur}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrDebitSaisie}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Débit"/></f:facet>
                            <h:outputText value="#{table.ecrDebitSaisie}" rendered="#{table.ecrDebitSaisie!=0}" style="color:#{table.couleur}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrCreditSaisie}" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                            <h:outputText value="#{table.ecrCreditSaisie}" rendered="#{table.ecrCreditSaisie!=0}" style="color:#{table.couleur}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrDteRapprochement}" width="120px" id="rapflag" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <f:facet name="header"> <h:outputText  value="Rap. bancaire"  /></f:facet>
                            <h:outputText id="rapbac" value="#{table.ecrDteRapprochement}" style="width:70px;color:#{table.couleur};">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                            <a4j:commandButton eventsQueue="maQueue" onclick="true" id="boutrapp" value="R" style="width:30px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.saveRapprochementJour}" reRender="rapflag,rapbac,pgrsld,pngButton,paneTotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_action==1&&table.ecrAnaActif!='9'}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{table.ecrLibelle}" width="340px" style="text-align:left;">
                            <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                            <h:outputText value="#{table.ecrLibelle}" style="color:#{table.couleur}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <h:panelGrid  id="paneTotal" style="width:100%;">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.trf_rapprochement=='0'}" var="tot1">
                        <h:panelGrid styleClass="fichefournisseur1" columns="4" style="width:100%;">
                            <h:column><h:outputText value="Total débit non pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_np}"  style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit non pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_np}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total débit pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_p}" style = "text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_p}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total débit extra comptable antérieur:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_eca}" style = "text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit extra comptable antérieur:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_eca}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.trf_rapprochement=='1'}" var="tot2">
                        <h:panelGrid styleClass="fichefournisseur1" columns="4" style="width:100%;">
                            <h:column><h:outputText value="Total débit non pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_np}"  style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit non pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_np}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total débit pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_p}" style = "text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit pointé:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_p}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total débit extra comptable antérieur:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_debit_eca}" style = "text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total crédit extra comptable antérieur:" style="font-weight:bold;"/></h:column>
                            <h:column>
                                <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_tot_credit_eca}" style="text-align:right;" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </c:if>
                </h:panelGrid>
            </h:column>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationComptabilite.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelExtra"  width="600" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.showModalPanelExtra}">
        <f:facet name="header"><h:outputText value="Ecriture extra comptable"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.annulerExtra}" reRender="panelExtra" style="text-decoration:none;" id="idCancel"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" width="100%" styleClass="fichefournisseur1">
                <h:column><h:outputText value="Jour:" styleClass="textAligneOutTable"/></h:column>
                <h:selectOneMenu  tabindex="1" id="jourId" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_jour}"  style="width:50px;">
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.lesjoursItems}"  />
                </h:selectOneMenu>
                <h:column><h:outputText value="N° de pièce:"/></h:column>
                <h:column><h:inputText tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantPiece}" size="14" id="ecrPieceid" maxlength="20"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef1Piece}"><h:outputText value="Référence1:"  /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef1Piece}"><h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantReference1}" size="13" maxlength="30"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef2Piece}"><h:outputText value="Référence2:"  /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.optionComptabilite.testRef2Piece}"><h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantReference2}" size="13" maxlength="30"/></h:column>
                <h:column><h:outputText value="Débit:"/></h:column>
                <h:column>
                    <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantDebitSaisie}" style="text-align:right" size="13" onkeypress="return scanToucheChiffre(event)">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Crédit:"/></h:column>
                <h:column>
                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantCreditSaisie}"  style="text-align:right" size="14" onkeypress="return scanToucheChiffre(event)">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantLibelle}" size="40" /></h:column>
            </h:panelGrid>
            <br><br>
            <center>
                <h:panelGroup>
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.valideExtra}" reRender="richpanlisteECR,scrollTable,rapflag,pgrsld,rapbac,sFinal,sEcart,sReleve,sCompte,pngButton" style="text-decoration:none;" id="idVal">
                        <rich:componentControl for="panelExtra" attachTo="idVal" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelMessage" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.showModalPanelMessage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.showModalPanelMessage}" var="err">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton id="idCanMessage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.fermerMessage}" styleClass="hidelink" reRender="panelMessage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessage')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form>
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.message}" style="width:100%" readonly="true"/>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>

