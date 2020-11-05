<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="appelsfiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DES APPELS (PRESENCES/ABSCENCES)" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                    <h:panelGrid columns="6" width="100%">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpDate}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpClasse}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Filières/Classes" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.mesClasseItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.chargerMatieres}" reRender="panCtrl,idMatiere,idProfesseur"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="idMatiere" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMatiere}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Matière" itemValue="0"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesMatiereresItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.selectionMatiere}" reRender="panCtrl,idProfesseur"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="idProfesseur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpProfesseur}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Professeur" itemValue="0"/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.mesProfesseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.requeteElevesAppels}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSaisieAppels,panelPage,panelValide" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="idSaisieAppels" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.afficheListeEleve}">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.pageIndex}" reRender="tableAppels" id="scrollTableAppels" maxPages="20"align="left" for="tableAppels"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_nb_max}" style="max-height:100%" styleClass="bg" id="tableAppels" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelAppels}" var="app">
                            <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{app.eleves.eleDossier}" width="10%">
                                <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                                <h:outputText value="#{app.eleves.eleDossier}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{app.eleves.eleCivilite}" width="10%">
                                <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                <h:outputText value="#{app.eleves.eleCivilite}"/>
                            </rich:column>
                            <rich:column label="Famille" sortable="true" sortBy="#{app.eleves.eleNomFamille}" width="10%">
                                <f:facet name="header" ><h:outputText value="Famille"/></f:facet>
                                <h:outputText value="#{app.eleves.eleNomFamille}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="true" sortBy="#{app.eleves.eleNom} #{app.eleves.elePrenom}" width="30%" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                                <h:outputText value="#{app.eleves.eleNom} #{app.eleves.elePrenom}"/>
                            </rich:column>
                            <rich:column label="Filière/Classe" sortable="true" sortBy="#{app.eleappType}" width="20%">
                                <f:facet name="header" ><h:outputText value="Présent/Abesence/Retard"/></f:facet>
                                <h:selectOneMenu style="width:90%;border:0px;color:red" value="#{app.eleappType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}">
                                    <f:selectItem itemLabel="Présent(e)" itemValue="0"/>
                                    <f:selectItem itemLabel="Ne fait pas parti(e) du groupe" itemValue="1"/>
                                    <f:selectItem itemLabel="Retard justifié" itemValue="2"/>
                                    <f:selectItem itemLabel="Retard non justifié" itemValue="3"/>
                                    <f:selectItem itemLabel="Absence jusifiée" itemValue="4"/>
                                    <f:selectItem itemLabel="Absence non jusifiée" itemValue="5"/>
                                    <f:selectItem itemLabel="Absence pour exclusion" itemValue="6"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="idMotif,idMotif1"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column id="idMotif" label="Motif absences" sortable="true" sortBy="#{app.eleappObservation}" width="20%">
                                <f:facet name="header"><h:outputText value="Motif"/></f:facet>
                                <h:inputText value="#{app.eleappObservation}" id="idMotif1" rendered="#{app.eleappType>=2&&app.eleappType<=5}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.annuleApels}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.saveAppels}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_valide_doc}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix de la classe/filière sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>


</f:subview>
