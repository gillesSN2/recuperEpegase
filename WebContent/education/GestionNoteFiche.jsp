<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="notesfiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DES NOTES (APPRECIATIONS/NOTES/UNITES DE VALEUR)" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                    <h:panelGrid columns="11" width="100%">
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
                            <h:selectOneMenu id="idType" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpType}" style="width:150px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}">
                                <f:selectItem itemLabel="Sélection Type" itemValue="0"/>
                                <f:selectItem itemLabel="Controle" itemValue="1"/>
                                <f:selectItem itemLabel="Devoir" itemValue="2"/>
                                <f:selectItem itemLabel="T.P." itemValue="3"/>
                                <f:selectItem itemLabel="Leçon" itemValue="4"/>
                                <f:selectItem itemLabel="Autre" itemValue="5"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode!=0}"><h:outputText value="Coefficient:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpCoef}" size="3" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode!=0}"><h:outputText value="Valeur Maximale:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMax}" size="3" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}"/></h:column>
                        <h:column>
                            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.requeteElevesNote}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSaisieAppels,panelPage,panelValide" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_aff_action}"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="idSaisieAppels" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.afficheListeEleve}">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.pageIndex}" reRender="tableAppels" id="scrollTableAppels" maxPages="20"align="left" for="tableAppels"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_nb_max}" style="max-height:100%" styleClass="bg" id="tableAppels" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.datamodelNote}" var="note">
                            <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{note.eleves.eleDossier}" width="10%">
                                <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                                <h:outputText value="#{note.eleves.eleDossier}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{note.eleves.eleCivilite}" width="10%">
                                <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                <h:outputText value="#{note.eleves.eleCivilite}"/>
                            </rich:column>
                            <rich:column label="Famille" sortable="true" sortBy="#{note.eleves.eleNomFamille}" width="10%">
                                <f:facet name="header" ><h:outputText value="Famille"/></f:facet>
                                <h:outputText value="#{note.eleves.eleNomFamille}"/>
                            </rich:column>
                            <rich:column label="Nom et prénom" sortable="true" sortBy="#{note.eleves.eleNom} #{note.eleves.elePrenom}" width="25%" sortOrder="ASCENDING">
                                <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                                <h:outputText value="#{note.eleves.eleNom} #{note.eleves.elePrenom}"/>
                            </rich:column>
                            <rich:column label="Appréciation/Note/Unité de valeur" sortable="true" sortBy="#{note.elenotValAppreciation} #{note.elenotValNote} #{note.elenotValUv}" width="9%"  style="text-align:right">
                                <f:facet name="header" ><h:outputText value="Note"/></f:facet>
                                <h:inputText value="#{note.elenotValAppreciation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}"/>
                                <h:inputText value="#{note.elenotValNote}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode==1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}" style="text-align:right;width:90%"/>
                                <h:inputText value="#{note.elenotValUv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.inpMode==2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}"  style="text-align:right;width:90%"/>
                            </rich:column>
                            <rich:column label="Observations" sortable="true" sortBy="#{note.elenotObservation}" width="15%">
                                <f:facet name="header"><h:outputText value="Observations"/></f:facet>
                                <h:inputText value="#{note.elenotObservation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_action==3}"/>
                            </rich:column>
                            <rich:column  width="5%" sortable="true" sortBy="#{note.scanner}" label="Scan du courrier" style="text-align:center;">
                                <f:facet name="header"><h:outputText value="Scan"/></f:facet>
                                <h:graphicImage value="#{note.scanner}" height="20px" width="20px" rendered="#{note.scanner!=null}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.annuleNote}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.saveNote}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_valide_doc}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix de la classe/filière sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formGestionEleves.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

</f:subview>
