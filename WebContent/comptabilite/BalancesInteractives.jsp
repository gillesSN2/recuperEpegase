<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressioninteractive">

    <a4j:form>

        <center> <h2><h:outputText value="IMPRESSIONS BALANCES INTERACTIVES" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" id="panGlob">
            <h:panelGrid width="100%" styleClass="fichefournisseur1" >
                <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Du:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreDateDebut}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                    <h:column><h:outputText value="Au:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreDateFin}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                </h:panelGrid>
                <h:panelGrid width="100%">
                    <rich:tabPanel switchType="client" immediate="true" style="width:100%;border:0px;">
                        <rich:tab label="Filtres balance (par comptes)">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modeBalance}" reRender="scrollTable,tableBalance,ducomptebalance,aucomptebalance"/>
                            <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="ducomptebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreCompteDebut}">
                                        <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,formModalListeComptes,ducomptebalance" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Au Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="aucomptebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreCompteFin}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.rechercheComptesFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,formModalListeComptes,aucomptebalance" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Type Ecriture:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.typeEcriture}">
                                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                        <f:selectItem itemLabel="Ecritures non lettrées et pointées" itemValue="5"/>
                                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection Journal:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.journal}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.touslesjournauxComptablesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Filtres balance (par racines)">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modeRacine}" reRender="scrollTable,tableBalance,deracinebalance,aracinebalance"/>
                            <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="De la Racine:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="deracinebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreCompteDebut}">
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="A la racine:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="aracinebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.filtreCompteFin}">
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Type Ecriture:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.typeEcriture}">
                                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                        <f:selectItem itemLabel="Ecritures non lettrées et pointées" itemValue="5"/>
                                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Sélection Journal:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.journal}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.touslesjournauxComptablesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Filtres Transitaire (par dossiers)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.moduleTransit}">
                            <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modeTransit}" reRender="scrollTable,tableBalance,idClasse"/>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Type Classe:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idClasse" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.typeClasse}">
                                        <f:selectItem itemLabel="Toutes les classes" itemValue="0"/>
                                        <f:selectItem itemLabel="Classe 7" itemValue="1"/>
                                        <f:selectItem itemLabel="Classe 6" itemValue="2"/>
                                        <f:selectItem itemLabel="Classes 47, 60" itemValue="3"/>
                                        <f:selectItem itemLabel="Classes 473" itemValue="4"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>
                    </rich:tabPanel>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.inclureJournauxS}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.inclureJournauxR}" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
            <h:panelGroup styleClass="startup">
                <center>
                    <a4j:commandButton title="Calculer la balance" value="Calculer la Balance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.calculerBalance}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panGlob,idBalance,tableBalance"/>
                </center>
            </h:panelGroup>
            <br>
            <h:panelGrid width="100%" id="idBalance">
                <h:panelGroup>
                    <center>
                        <a4j:commandButton title="Consulter le #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.code} sélectionné" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.consulterCompte}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelCompte"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/print.png" title="Imprimer la balance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.initImpressionBalanceInteractive}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" reRender="panelImp,formModalImp"/>
                    </center>
                </h:panelGroup>
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.pageIndex}" reRender="tableBalance" id="scrollTable" maxPages="20"align="left" for="tableBalance"/>
                <rich:extendedDataTable rows="500" id="tableBalance" footerClass="bard" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="450px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.dataModelBalance}" var="balance">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.selectionCompte}"/>
                    <rich:column label="N° Compte ou N° Dossier" sortable="false" width="100px">
                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.code}" /></f:facet>
                        <h:outputText value="#{balance.ecrBalCompte}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Libellé compte ou Libellé Dossier" sortable="false" width="350px">
                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.libelle}" /></f:facet>
                        <h:outputText value="#{balance.ecrBalLibelle}" style="#{balance.gras}"/>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitAN}" rendered="#{balance.ecrDebitAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit AN" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditAN}" rendered="#{balance.ecrCreditAN!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitMVTS}" rendered="#{balance.ecrDebitMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Mvts" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditMVTS}" rendered="#{balance.ecrCreditMVTS!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Débit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Débit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrDebitSOLDE}" rendered="#{balance.ecrDebitSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Crédit" sortable="false" width="100px" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Crédit Solde" /></f:facet>
                        <h:outputText value="#{balance.ecrCreditSOLDE}" rendered="#{balance.ecrCreditSOLDE!=0}" style="#{balance.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="idLgRevue" label="Revue comptable" sortable="false" width="250px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modeBalance==0&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==11}">
                        <f:facet name="header"><h:outputText  value="Revue comptable" /></f:facet>
                        <h:outputText value="#{balance.revueCompte}" style="#{balance.gras}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </h:panelGrid>
        </h:panelGrid>

    </a4j:form>

    <!-- modalPanel de selection des comptes -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeComptes" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelComptes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelComptes}" var="cpt">
            <f:facet name="header"><h:outputText value="Sélection du compte"/></f:facet>
            <a4j:form id="formModalListeComptes">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages"  id="scrollTableCompte" maxPages="20"align="left" for="tableCompte"/>
                <rich:extendedDataTable rows="100" id="tableCompte" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.datamodelComptes}" var="cpte">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.selectionligneCompte}"/>
                    <rich:column label="N° Compte" sortable="true" sortBy="#{cpte.plcCompte}" width="15%">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{cpte.plcCompte}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleCpteFR}"/>
                    </rich:column>
                    <rich:column label="Racine" sortable="true" sortBy="#{cpte.plcLibelleRacineFR}" width="30%">
                        <f:facet name="header"><h:outputText  value="Racine" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleRacineFR}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valcompte">
                    <center>
                        <h:commandButton id="idCanCompte" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.annuleCompte}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton id="idValCompte" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.calculeCompte}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanCompte')}.click()" />
                    <rich:hotKey key="return" handler="#{rich:element('idValCompte')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <!-- modalPanel extrait compte -->
    <rich:modalPanel id="panelCompte" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="600" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelBalanceCompte}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelBalanceCompte}" var="bcp">
            <f:facet name="header"><h:outputText value="Détail du #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.code} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerCompte}" image="/images/close.gif" styleClass="hidelink" reRender="panelCompte">
                        <rich:componentControl for="panelCompte" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalCompte">
                <center>
                    <h:panelGroup>
                        <h:column><h:outputText value="Sélection exercice:" style="color:red"/></h:column>&nbsp;&nbsp;
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.exerciceSelectionne}" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modeBalance=='0'}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.exercicesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.selectionExercice}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panTotalExtrait,panRevue,tableCompte"/>
                        </h:selectOneMenu>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton title="Consulter la pièce sélectionnée" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.consulterPiece}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPiece"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton title="Informations sur l'écriture sélectionnée" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.informationPiece}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelInformation"/>
                    </h:panelGroup>
                </center>
                <h:panelGrid id="panGlobal" width="100%">
                    <br>
                    <h:panelGrid id="panTotalExtrait" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Total débit:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte_debit}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total crédit:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte_credit}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte_solde}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="panRevue" width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==11}">
                        <a4j:commandButton value="Revue du compte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.saisirRevue}" reRender="panelRevue"/>
                        <h:inputTextarea rows="3" style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_revue}" readonly="true"/>
                    </h:panelGrid>
                    <br>
                </h:panelGrid>
                <rich:extendedDataTable id="tableCompte" footerClass="bard" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" noDataLabel=" " width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.dataModelCompte}" var="table">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.selectionPiece}"/>
                    <rich:column id="c0" width="10%" sortable="true" sortBy="#{table.ecrCompte}" label="Compte" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.moduleTransit}">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{table.ecrCompte}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c1" width="5%" sortable="true" sortBy="#{table.ecrCode}" label="Journal">
                        <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                        <h:outputText value="#{table.ecrCode}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c2" width="7%" sortable="true" sortBy="#{table.ecrDateSaisie}" label="Date de saisie" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{table.ecrDateSaisie}" style="#{table.gras}">
                            <f:convertDateTime pattern="dd/MM/yy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c4" width="9%" sortable="true" sortBy="#{table.ecrPiece}" label="N° Pièce">
                        <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                        <h:outputText value="#{table.ecrPiece}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c5" width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{table.ecrReference1}" label="Référence 1">
                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                        <h:outputText value="#{table.ecrReference1}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c6" width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.ecrReference2}" label="Référence 2">
                        <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                        <h:outputText value="#{table.ecrReference2}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c8" width="5%" sortable="true" sortBy="#{table.ecrLettrage}" label="Lettrage">
                        <f:facet name="header"><h:outputText  value="L."/></f:facet>
                        <h:outputText value="#{table.ecrLettrage}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column id="c9" width="4%" sortable="true" sortBy="#{table.ecrPointage}" label="Pointage">
                        <f:facet name="header"><h:outputText  value="P."/></f:facet>
                        <h:outputText value="#{table.erreurLettrage}" style="#{table.gras};color:red;"/>
                        <h:outputText value="#{table.ecrPointage}" style="#{table.gras}"/>
                    </rich:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==7}">
                        <rich:column id="c10" width="7%" sortable="true" sortBy="#{table.ecrDateEcheance}" label="Date d'échéance">
                            <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                            <h:outputText value="#{table.ecrDateEcheance}" style="#{table.gras}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==11}">
                        <rich:column id="c11" width="7%" sortable="true" sortBy="#{table.ecrDateValeurTheo}"label="Date de valeur">
                            <f:facet name="header"><h:outputText value="Valeur" /> </f:facet>
                            <h:outputText value="#{table.ecrDateValeurTheo}" style="#{table.gras}">
                                <f:convertDateTime pattern="dd/MM/yy"/>
                            </h:outputText>
                        </rich:column>
                    </c:if>
                    <rich:column id="c12" width="10%" style="text-align:right;" sortable="true" sortBy="#{table.ecrDebitPays}" label="Débit">
                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                        <h:outputText value="#{table.ecrDebitPays}" rendered="#{table.ecrDebitPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c13" width="10%"  style="text-align:right;" sortable="true" sortBy="#{table.ecrCreditPays}"label="Crédit">
                        <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                        <h:outputText value="#{table.ecrCreditPays}" rendered="#{table.ecrCreditPays!=0}" style="#{table.gras}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column id="c14" width="25%" sortable="true" sortBy="#{table.ecrLibelle}" label="Libellé">
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{table.ecrLibelle}" style="#{table.gras}"/>
                    </rich:column>
                    <rich:column width="9%" style="text-align:center;" rendered="#{table.ecrAnaActif==1}">
                        <a4j:commandButton image="/images/detail.png" style="width:14px;height:14px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ouvrirDetailsAnalytique}" reRender="idSubView,modalpanelAnalytique,formAnal,modalpanelAnalRecup,formAnalRecup" rendered="#{table.ecrAnaActif==1}" ></a4j:commandButton>
                    </rich:column>
                    <rich:column label="Lettrage/Pointage/Rapproc."  width="5%" style="text-align:center;">
                        <f:facet name="header"><h:outputText  value="LPR." /></f:facet>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Etat de la pièce" image="/images/cadenas_cl.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ouvrirLpr}" reRender="modalpanelLPR,formLpr" rendered="#{table.nbrEcrLettrage}"/>
                        <a4j:commandButton eventsQueue="maQueue" immediate="true" title="Visualisation pièce scannée" image="/images/mail_pj.png" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ouvrirPjConsultation}" reRender="panelPJ,formPJ" rendered="#{table.ecrPj}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <!-- modalPanel detail piece -->
    <rich:modalPanel id="panelPiece" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelBalancePiece}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelBalancePiece}" var="pic">
            <f:facet name="header"><h:outputText value="Détail de la piece #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_piece} du #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.code} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelPiece">
                        <rich:componentControl for="panelPiece" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalPiece">
                <h:panelGrid width="100%" style="text-align:left;">
                    <h:panelGrid id="panTotalExtrait" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" styleClass="fichefournisseur1">
                        <h:column><h:outputText value="Total débit:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_tot_debit}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total crédit:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_tot_credit}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_solde}" style="text-align:right;" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="pclisteId"  height="350px" width="100%" headerClass="headerTab" selectedClass="active-row" var="detEcr" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.dataModelDetailPiece}" >
                            <rich:column width="5%" sortable="true" sortBy="#{detEcr.ecrCode}" label="Journal">
                                <f:facet name="header"><h:outputText  value="Jr." /></f:facet>
                                <h:outputText value="#{detEcr.ecrCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateSaisie}" label="Date de saisie">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{detEcr.ecrDateSaisie}">
                                    <f:convertDateTime pattern="dd/MM/yy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="9%" sortable="true" sortBy="#{detEcr.ecrCompte}" label="N° compte">
                                <f:facet name="header"><h:outputText  value="Compte"  /></f:facet>
                                <h:outputText value="#{detEcr.ecrCompte}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column width="9%" sortable="true" sortBy="#{detEcr.ecrPiece}" label="N° Pièce">
                                <f:facet name="header"><h:outputText value="Pièce" /></f:facet>
                                <h:outputText value="#{detEcr.ecrPiece}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="9%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.optionComptabilite.testRef1Piece}" sortable="true" sortBy="#{detEcr.ecrReference1}" label="Référence 1">
                                <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                                <h:outputText value="#{detEcr.ecrReference1}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column width="6%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{detEcr.ecrReference2}" label="Référence 2">
                                <f:facet name="header"><h:outputText  value="Réf.2"/></f:facet>
                                <h:outputText value="#{detEcr.ecrReference2}">
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%"  sortable="true" sortBy="#{detEcr.ecrLettrage}" label="Lettrage">
                                <f:facet name="header"><h:outputText  value="L."/></f:facet>
                                <h:outputText value="#{detEcr.ecrLettrage}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column width="4%" sortable="true" sortBy="#{detEcr.ecrPointage}" label="Pointage">
                                <f:facet name="header"><h:outputText  value="P."/></f:facet>
                                <h:outputText value="#{detEcr.ecrPointage}" >
                                </h:outputText>
                            </rich:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==7}">
                                <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateEcheance}" label="Date d'échéance">
                                    <f:facet name="header"><h:outputText  value="Eché." /></f:facet>
                                    <h:outputText value="#{detEcr.ecrDateEcheance}">
                                        <f:convertDateTime pattern="dd/MM/yy"/>
                                    </h:outputText>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==10||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.planComptable.plcNature==11}">
                                <rich:column width="6%" sortable="true" sortBy="#{detEcr.ecrDateValeurTheo}"label="Date de valeur">
                                    <f:facet name="header"><h:outputText value="Valeur" /> </f:facet>
                                    <h:outputText value="#{detEcr.ecrDateValeurTheo}"  >
                                        <f:convertDateTime pattern="dd/MM/yy"/>
                                    </h:outputText>
                                </rich:column>
                            </c:if>
                            <rich:column width="10%" style="text-align:right;" sortable="true" sortBy="#{detEcr.ecrDebitPays}" label="Débit">
                                <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                                <h:outputText   value="#{detEcr.ecrDebitPays}" rendered="#{detEcr.ecrDebitPays!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="10%"  style="text-align:right;" sortable="true" sortBy="#{detEcr.ecrCreditPays}"label="Crédit">
                                <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                                <h:outputText value="#{detEcr.ecrCreditPays}" rendered="#{detEcr.ecrCreditPays!=0}" >
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="30%" sortable="true" sortBy="#{detEcr.ecrLibelle}" label="Libellé">
                                <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                                <h:outputText value="#{detEcr.ecrLibelle}" >
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_ctrl_imp}">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelImpressionInteractif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelImpressionInteractif}" var="prt">
            <f:facet name="header"><h:outputText value="Impression : Choisissez un modèle et un format d'Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerImpressionBalanceInteractive}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" id="idSelectionImpression">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.nomEtat}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.documentImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.imprimerInteractifXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelRevue" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelRevue}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelRevue}" var="rev">
            <f:facet name="header"><h:outputText value="Revue du #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.code} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_compte}"/></f:facet>
            <a4j:form id="formModalRevue">
                <h:panelGrid id="panRevue" width="100%">
                    <h:column><h:inputTextarea rows="10" style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.var_revue}"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="prgtpAjt">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerRevue}" reRender="panelRevue"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.validerRevue}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRevue,panGlobal,panRevue,idLgRevue"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="modalpanelLPR" width="300" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelLpr}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelLpr}" var="lpr">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE L.P.R."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerLpr}" image="/images/close.gif" styleClass="hidelink" reRender="modalpanelLPR"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Lettrage, pointage, rapprochement"/></f:facet>
                    <h:outputText value="Lettrage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrLettrage}" id="outLPRlett"/>
                    <h:outputText value="Pointage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrPointage}" id="outLPRpoint"/>
                    <h:outputText value="Rapprochement :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrRapprochement}" id="outLPRrapp"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Etat écriture"/></f:facet>
                    <h:outputText value="Statut :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.lib_etat}"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Information sur l'origine"/></f:facet>
                    <h:outputText value="Nature Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrTypeOrigine}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.libelleOrigine}" id="outImport1"/>
                    <h:outputText value="ID Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrIdOrigine}" id="outImport2"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelInformation" width="600" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR L'ECRITURE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Créée et/ou modifiée..."/></f:facet>
                    <h:outputText value="ID écriture:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecr_id}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrUserModif})"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Lettrage, pointage, rapprochement"/></f:facet>
                    <h:outputText value="Lettrage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrLettrage}" id="outLPRlett"/>
                    <h:outputText value="Pointage :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrPointage}" id="outLPRpoint"/>
                    <h:outputText value="Rapprochement :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrRapprochement}" id="outLPRrapp"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Etat écriture"/></f:facet>
                    <h:outputText value="Statut :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.lib_etat}"/>
                </h:panelGrid>
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos50,clos50" style="text-align:center;" headerClass="headerTab" >
                    <f:facet name="header"><h:outputText value="Information sur l'origine"/></f:facet>
                    <h:outputText value="Nature Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrTypeOrigine}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.libelleOrigine}" id="outImport1"/>
                    <h:outputText value="ID Origine :"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.ecritures.ecrIdOrigine}" id="outImport2"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel onbeforeshow="LoadControl();" onbeforehide="UnloadControl();" id="panelPJ" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelPJ}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.showModalPanelPJ}" var="pie">
            <f:facet name="header"><h:outputText value="Pièce jointe"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modePj==2}">
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fermerPj}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <h:form id="formPJ" enctype="multipart/form-data">
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modePj==1}" var="pjcreat">
                    <h:panelGrid width="100%">
                        <center>
                            <select size="1" id="source" style="position: relative; width: 220px;"/>
                            <input type="button" value="Scan" onclick="AcquireImage();"/>
                            <div id="dwtcontrolContainer"></div>
                            <h:inputHidden id="idValScan" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.valueScanPj}"  immediate="true"/>
                            <script type="text/javascript">
                                Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', Dynamsoft_OnReady);
                                var DWObject;
                                function LoadControl() {
                                    Dynamsoft.WebTwainEnv.Load();
                                }
                                function UnloadControl() {
                                    Dynamsoft.WebTwainEnv.Unload();
                                }
                                function Dynamsoft_OnReady() {
                                    DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer');
                                    if (DWObject) {
                                        var count = DWObject.SourceCount;
                                        if(count == 0 && Dynamsoft.Lib.env.bMac)
                                        {
                                            DWObject.CloseSourceManager();
                                            DWObject.ImageCaptureDriverType = 0;
                                            DWObject.OpenSourceManager();
                                            count = DWObject.SourceCount;
                                        }
                                        for (var i = 0; i < count; i++)
                                            document.getElementById("source").options.add(new Option(DWObject.GetSourceNameItems(i), i));
                                    }
                                }
                                function AcquireImage() {
                                    if (DWObject) {
                                        var OnAcquireImageSuccess, OnAcquireImageFailure;
                                        OnAcquireImageSuccess = OnAcquireImageFailure = function (){
                                            DWObject.CloseSource();
                                        };
                                        DWObject.SelectSourceByIndex(document.getElementById("source").selectedIndex);
                                        DWObject.OpenSource();
                                        DWObject.IfDisableSourceAfterAcquire = true;
                                        DWObject.AcquireImage(OnAcquireImageSuccess, OnAcquireImageFailure);
                                    }
                                }
                                function LireValeur(){
                                    var imagedata;
                                    DWObject.SelectedImagesCount = 1;
                                    DWObject.SetSelectedImageIndex(0,0);
                                    DWObject.GetSelectedImagesSize(EnumDWT_ImageType.IT_JPG);
                                    imagedata = DWObject.SaveSelectedImagesToBase64Binary();
                                    var newImage = document.createElement('img');
                                    newImage.onload = function () {
                                        document.getElementsByTagName('body')[0].appendChild(this);
                                    };
                                    newImage.src = "data:image/png;base64," + imagedata;
                                    document.getElementById("sm:formPJ:idValScan").value = newImage.src;
                                }
                            </script>
                        </center>
                    </h:panelGrid>
                    <br><br>
                    <center>
                        <h:panelGroup >
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.validerPj}" onclick="LireValeur();" image="/images/valider_big.png" styleClass="hidelink"/>
                        </h:panelGroup>
                    </center>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.modePj==2}" var="pjvisu">
                    <h:panelGrid width="100%">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.typeFichier==0}" var="sc1">
                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.urlphotoProd}" width="100%" height="800px"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.typeFichier==1}" var="sc2">
                            <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fichierMine}" width="100%" height="550">
                                <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionGenerale.fichierUrl}"></a>
                            </object>
                        </c:if>
                    </h:panelGrid>
                </c:if>
            </h:form>
        </c:if>
    </rich:modalPanel>


</f:subview>