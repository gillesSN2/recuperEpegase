<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="projet">

    <a4j:form id="formprojet">

        <center> <h2><h:outputText value="GESTION DES PROJETS" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelmaniact" width="200px" columns="4">
                <h:commandButton title="Ajouter un projet" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.ajouterProjets}"/>
                <h:commandButton title="Modifier le projet sélectioné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.modifierProjets}"  />
                <h:commandButton title="Supprimer le projet" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.supprimerProjets}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" />
                <a4j:commandButton title="Imprimer les projets" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.datamodelProjets}" var="pjt"  >
                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.selectionProjets}" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelmaniact"/>
                    <rich:column sortable="true" sortBy="#{pjt.proCode}" width="15%" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                        <h:outputText value="#{pjt.proCode}"/>
                    </rich:column >
                    <rich:column sortable="true" sortBy="#{pjt.proNomFR}" width="30%">
                        <f:facet name="header"><h:outputText value="Nom du projet"/></f:facet>
                        <h:outputText value="#{pjt.proNomFR}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{pjt.proDateDebut}" width="10%">
                        <f:facet name="header"><h:outputText value="Début"/></f:facet>
                        <h:outputText value="#{pjt.proDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{pjt.proDateFin}" width="10%">
                        <f:facet name="header"><h:outputText value="Fin"/></f:facet>
                        <h:outputText value="#{pjt.proDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{pjt.proDuree}" width="5%">
                        <f:facet name="header"><h:outputText value="Durée"/></f:facet>
                        <h:outputText value="#{pjt.proDuree}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{pjt.proNomResponsable}" width="15%">
                        <f:facet name="header"><h:outputText value="Responsable"/></f:facet>
                        <h:outputText value="#{pjt.proNomResponsable}"/>
                    </rich:column>
                    <rich:column sortable="true" sortBy="#{pjt.proMontantPays}" width="15%" style="text-align:right">
                        <f:facet name="header"><h:outputText value="Montant"/></f:facet>
                        <h:outputText value="#{pjt.proMontantPays}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelProjets" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.showmodelPanel}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="900" height="500">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.showmodelPanel}" var="pan">
            <f:facet name="header"><h:outputText value="GESTION DES PROJETS"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.annulerProjets}" styleClass="hidelink" />
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabProjet" label="Projet">
                        <h:panelGrid columns="2" id="pgrdAjtAct" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Code:" /></h:column>
                            <h:column id="clnAjtAct">
                                <h:inputText id="AdActCode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proCode}" size="10" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proId!=0}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.verifielesSaisieCodeAct}" reRender="pgrdAjtAct,prgoutpAjtAct"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:outputText id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.existeCode}"/>
                            </h:column>
                            <h:column><h:outputText value="Libellé:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proNomFR}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Source:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proSource}" style="width:100%" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Organe responsable:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proInitiateur}" style="width:100%" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Date début théorique:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proDateDebut}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Date fin théorique:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proDateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Date début convention:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proDateDebutConvention}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Date fin convention:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proDateFinConvention}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Agent Responsable:" /></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proIdResponsable}" style="width:100%;">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.mesResponsable}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Montant:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proMontantPays}" style="width:200px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                            </h:column>
                            <h:column><h:outputText value="Nb Tranches:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proNbTranche}" style="width:50px"/></h:column>
                            <h:column><h:outputText value="Inactif:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.var_inactif}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabTranches" label="Tranches">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.calculeTranches}" reRender="idTranches"/>
                        <h:panelGrid id="idTranches" width="100%">
                            <h:panelGrid  width="100%" style="border:0px solid green" columns="4">
                                <h:column><h:outputText value="Montant:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proMontantPays}" style="width:200px;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                                </h:column>
                                <h:column><h:outputText value="Nb Tranches:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proNbTranche}" style="width:50px" readonly="true"/></h:column>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:300px;border:solid 0px green;cursor:pointer;" border="0" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelTranches}" var="tch"  >
                                    <rich:column sortable="false" width="180px">
                                        <f:facet name="header"><h:outputText value="Début"/></f:facet>
                                        <rich:calendar value="#{tch.dateDeb}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                                    </rich:column>
                                    <rich:column sortable="false" width="180px">
                                        <f:facet name="header"><h:outputText value="Fin"/></f:facet>
                                        <rich:calendar value="#{tch.dateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                                    </rich:column>
                                    <rich:column sortable="false" width="180px" style="text-align:right;">
                                        <f:facet name="header"><h:outputText value="Montant"/></f:facet>
                                        <h:inputText value="#{tch.montant}" style="text-align:right;width:95%;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.cumulEcheance}" reRender="idTotal"/>
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="200px">
                                        <f:facet name="header"><h:outputText value="Observations"/></f:facet>
                                        <h:inputText value="#{tch.libelle}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                            <h:panelGrid id="idTotal" width="100%" style="border:0px solid green" columns="4">
                                <h:column><h:outputText value="Total échéances:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.total_echeance}" style="width:200px;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Ecart:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.ecart}" style="width:200px;text-align:right;" readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabUsers" label="Utilisateurs habilités">
                        <h:panelGrid style="width:100%;">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieCaisse" width="100%" height="300px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelUsersHabilites}" var="agt">
                                    <rich:column width="10%" sortable="true">
                                        <f:facet name="header" ><h:outputText value="Sel."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{agt.selectUser}"/>
                                    </rich:column>
                                    <rich:column width="90%" >
                                        <f:facet name="header" ><h:outputText value="Membre de l'équipe"/></f:facet>
                                        <h:outputText value="#{agt.usrPatronyme}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabDescription" label="Description">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proDescription}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab id="tabContexte" label="Contexte">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proContexte}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab id="tabObjectif" label="Objectifs">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.projets.proObjectif}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab id="tabPoste" label="Postes">
                        <h:panelGrid width="100%" style="border:0px solid green" >
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:300px;border:solid 0px green;cursor:pointer;" border="0" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelPostes}" var="pos">
                                    <rich:column sortable="false" width="20%">
                                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                        <h:outputText value="#{pos.budCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="80%">
                                        <f:facet name="header"><h:outputText value="Poste"/></f:facet>
                                        <h:outputText value="#{pos.budLibelleFr}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabTreso" label="Trésorerie">
                        <h:panelGrid width="100%" style="border:0px solid green">
                            <h:commandButton title="Changer le code" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.changerCode}"  />
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:300px;border:solid 0px green;cursor:pointer;" border="0" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelTresorerie}" var="tre">
                                    <a4j:support eventsQueue="maQueue"  event="onRowClick"  onsubmit="javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.selectionPoste}" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                        <h:outputText value="#{tre.treCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText value="Poste"/></f:facet>
                                        <h:outputText value="#{tre.treLibelleFr}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                        <h:outputText value="#{tre.treCompte}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText value="Libellé compte"/></f:facet>
                                        <h:outputText value="#{tre.treLibelleCompte}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabJournaux" label="Journaux comptables">
                        <h:panelGrid width="100%" style="border:0px solid green" >
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:300px;border:solid 0px green;cursor:pointer;" border="0" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelJrx}" var="jrx">
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                        <h:outputText value="#{jrx.pljCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText value="Poste"/></f:facet>
                                        <h:outputText value="#{jrx.pljLibelleFr}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="20%">
                                        <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                                        <h:outputText value="#{jrx.pljCompteTreso}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabContrats" label="Contrats">
                        <h:panelGrid width="100%" style="border:0px solid green" >
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable  activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:300px;border:solid 0px green;cursor:pointer;" border="0" enableContextMenu="false" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.dataModelContrat}" var="crt">
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="Matricule"/></f:facet>
                                        <h:outputText value="#{crt.salaries.salMatricule}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="40%">
                                        <f:facet name="header"><h:outputText value="Nom et Prénom"/></f:facet>
                                        <h:outputText value="#{crt.salaries.salNom}"/>&nbsp;&nbsp;
                                        <h:outputText value="#{crt.salaries.salPrenom}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="20%">
                                        <f:facet name="header"><h:outputText value="Fonction"/></f:facet>
                                        <h:outputText value="#{crt.salconFonction}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="prgoutpAjtAct">
                    <br>
                    <center>
                        <h:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.saveProjets}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.existeCode}"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                    </center>
                    <br>
                    <center>
                        <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.codelibVide==false}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelChangeCode" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.showModalPanelChangeCode}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.showModalPanelChangeCode}" var="chg">
            <f:facet name="header"><h:outputText value="CHANGE CODE"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.fermerChangerCode}" styleClass="hidelink" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="2" columnClasses="clos20,clos80">
                    <h:column><h:outputText value="Ancien Code:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.ancienCode}" size="10" maxlength="20" disabled="true"/></h:column>
                    <h:column><h:outputText value="Nouveau Code:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.nouveauCode}" size="10" maxlength="20" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png"  onclick="javascript:Richfaces.showModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanProjets.validerChangerCode}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>