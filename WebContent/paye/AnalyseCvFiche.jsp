<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichescv">

    <a4j:form>

        <center> <h2><h:outputText value="ANALYSE CV" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">

            <h:panelGrid id="tabPanelAnalyse" width="100%">

                <rich:tabPanel switchType="client" immediate="true"  id="tabPanelsalaries" style="border:0px;">

                    <rich:tab name="analyse" label="Analyse">
                        <h:panelGrid columns="2" width="100%" columnClasses="clos30,clos70">
                            <h:outputText value="N° analyse:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsCode}" readonly="true" disabled="true"/>
                            <h:outputText value="Date début analyse:"/>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsDateDebut}" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                            <h:outputText value="Date fin analyse:"/>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsDateFin}" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" inputSize="20"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                            <h:outputText value="Responsable:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsNomResponsable}" style="width:100%" readonly="true" disabled="true"/>
                            <h:outputText value="Organisme demandeur:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsOrganisme}" style="width:100%" maxlength="100"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                            <h:outputText value="Référence Organisme:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsReference}" style="width:100%" maxlength="50"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                            <h:outputText value="Langue analyse:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsLangue}" style="width:100%" maxlength="50"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                            <h:outputText value="Objet:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsObjet}" style="width:100%" maxlength="100"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_aff_action}"/>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab name="criteres" label="Critères" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsId!=0}">
                        <h:panelGrid columns="3" width="200px" id="idButonCritere">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau critère" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.ajouterCritere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelCritere"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier le critère sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.modifierCritere}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_critere)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelCritere"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer le critère sélectionné" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_critere)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.supprimerCritere}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce critère?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableCritere,idButonCritere"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableCritere" width="100%" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.dataModelCriteres}" var="cvc">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.selectionnerCritere}" reRender="idButonCritere"/>
                                    <rich:column  width="80%" sortable="false" sortBy="#{cvc.cvcCritere}" >
                                        <f:facet name="header"><h:outputText value="Critères"/></f:facet>
                                        <h:outputText value="#{cvc.cvcCritere}"/>
                                    </rich:column>
                                    <rich:column  width="20%" sortable="false" sortBy="#{cvc.cvcPoints}" >
                                        <f:facet name="header"><h:outputText value="Points"/></f:facet>
                                        <h:outputText value="#{cvc.cvcPoints}"/>
                                    </rich:column >
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab name="listecv" label="Liste Candidats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvSession.cvsId!=0}">
                        <h:panelGrid columns="4" width="200px" id="idButonAgent">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouvel agent" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.ajouterAgent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAgents"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier l`agent sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.modifierAgent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_agents)==true}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAgents"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer l`agent sélectionné" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.var_affiche_agents)==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.supprimerAgent}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce agent?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="tableAgent,idButonAgent"/>
                            <a4j:commandButton image="/images/tableau.png" title="Importer le fichier excel" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.importerAgent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelImportation"/>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableAgent" width="100%" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="max-height:100%;border:solid 0px green;cursor:pointer;" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.dataModelAgents}" var="cva">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.selectionnerAgent}" reRender="idButonAgent"/>
                                    <rich:column  width="30%" sortable="false" sortBy="#{cva.cvaAgent}" >
                                        <f:facet name="header"><h:outputText value="Nom et prénom"/></f:facet>
                                        <h:outputText value="#{cva.cvaAgent}"/>
                                    </rich:column>
                                    <rich:column  width="5%" sortable="false" sortBy="#{cva.cvaAge}" >
                                        <f:facet name="header"><h:outputText value="Age"/></f:facet>
                                        <h:outputText value="#{cva.cvaAge}"/>
                                    </rich:column>
                                    <rich:column  width="5%" sortable="false" sortBy="#{cva.cvaGenre}" >
                                        <f:facet name="header"><h:outputText value="Genre"/></f:facet>
                                        <h:outputText value="#{cva.cvaGenre}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false" sortBy="#{cva.cvaNationalite}" >
                                        <f:facet name="header"><h:outputText value="Nationalité"/></f:facet>
                                        <h:outputText value="#{cva.cvaNationalite}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false" sortBy="#{cva.cvaResidence}" >
                                        <f:facet name="header"><h:outputText value="Résidence"/></f:facet>
                                        <h:outputText value="#{cva.cvaResidence}"/>
                                    </rich:column>
                                    <rich:column  width="10%" sortable="false" sortBy="#{cva.cvaDiplomeMax}" >
                                        <f:facet name="header"><h:outputText value="Diplôme"/></f:facet>
                                        <h:outputText value="#{cva.cvaDiplomeMax}"/>
                                    </rich:column>
                                    <rich:column  width="8%" sortable="false" sortBy="#{cva.cvaNote}" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="Note"/></f:facet>
                                        <h:outputText id="idNote" value="#{cva.cvaNote}" style="text-align:right"/>
                                    </rich:column>
                                    <rich:column  width="22%" sortable="false" sortBy="#{cva.cvaCommentaires}" >
                                        <f:facet name="header"><h:outputText value="Commentaire"/></f:facet>
                                        <h:outputText value="#{cva.cvaCommentaires}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.annuleranalyseCv}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.saveAnalyseCv}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelCritere" headerClass="headerPanel" width="900" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelCritere}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelCritere}" var="sms">
            <f:facet name="header"><h:outputText value="CRITERES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.annulerCritere}" image="/images/close.gif" styleClass="hidelink" reRender="panelCritere,idButonCritere"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Critères:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvCriteres.cvcCritere}" maxlength="200" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Nb points:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvCriteres.cvcPoints}"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.validerCritere}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelCritere,tableCritere,idButonCritere"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelAgents" headerClass="headerPanel" width="900" height="600" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelAgents}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelAgents}" var="agt">
            <f:facet name="header"><h:outputText value="CANDIDATS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.annulerAgent}" image="/images/close.gif" styleClass="hidelink" reRender="panelAgents,idButonAgent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Nom et prénom candidat:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaAgent}" maxlength="200" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Age:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaAge}"/></h:column>
                    <h:column><h:outputText value="Genre:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaGenre}">
                            <f:selectItem itemLabel="FEMME" itemValue="F" />
                            <f:selectItem itemLabel="Homme" itemValue="H" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Nationalité:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaNationalite}" maxlength="50" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Résidence:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaResidence}" maxlength="50" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Diplôme:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaDiplomeMax}" maxlength="50" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Note obtenue:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaNote}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Commentaire:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.cvAgents.cvaCommentaires}" maxlength="200" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                </h:panelGrid>
                <h:panelGrid width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableCritereAgent" width="100%" height="300px" styleClass="bg" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="border:solid 0px green;cursor:pointer;" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.dataModelAgentsCriteres}" var="cvac">
                            <rich:column  width="10%" sortable="false" sortBy="#{cvac.cvacSelect}" >
                                <f:facet name="header"><h:outputText value="Sel."/></f:facet>
                                <h:selectBooleanCheckbox value="#{cvac.cvacSelect}"/>
                            </rich:column>
                            <rich:column  width="70%" sortable="false" sortBy="#{cvac.cvacCritere}" >
                                <f:facet name="header"><h:outputText value="Critères"/></f:facet>
                                <h:outputText value="#{cvac.cvacCritere}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="false" sortBy="#{cvac.cvacPoints}" >
                                <f:facet name="header"><h:outputText value="Points"/></f:facet>
                                <h:outputText value="#{cvac.cvacPoints}"/>
                            </rich:column >
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.validerAgent}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelAgents,idNote"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelImportation" headerClass="headerPanel" width="400" height="220" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelImportation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.showModalPanelImportation}" var="imp">
            <f:facet name="header"><h:outputText value="IMPORTATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.annulerImporterAgent}" image="/images/close.gif" styleClass="hidelink" reRender="panelImportation,idButonAgent,tableAgent"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:column id="idFiltre5">
                    <rich:fileUpload id="upload1" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.uploadsAvailable}" listHeight="120px" listWidth="300px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formCvAnalyse.listener}">
                        <a4j:support event="onuploadcomplete" reRender="panelImportation,tableAgent,idButonAgent"/>
                    </rich:fileUpload>
                </h:column>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
