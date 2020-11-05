<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="classementMedia">

    <a4j:form id="clamed">

        <center> <h2><h:outputText value="CLASSEMENT DES DOCUMENTS (METHODE DEWEY)" style="color:green;"/></h2></center>
        <center>
            <h:panelGrid  id="panelBouton" width="200px" columns="4">
                <a4j:commandButton title="Ajouter un classement" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ajouterClassement}" reRender="panelClassement"/>
                <a4j:commandButton title="Modifier le classement sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.modifierClassement}" reRender="panelClassement"/>
                <a4j:commandButton title="Supprimer le classement sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.var_affiche_bouton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.supprimerClassement}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableSujet,tableType,tableSupport,tableContenant,panelBouton"/>
                <a4j:commandButton title="Imprimer les classements" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">
                <rich:tab id="tabSujet" label="Sujet">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.sujetSelectionne}" reRender="idSujet"/>
                    <h:panelGrid width="100%" id="idSujet">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableSujet" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.datamodelSujet}" var="cla"  >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.selectionSujet}"/>
                                <rich:column sortable="true" sortBy="#{cla.clamedCode}" width="10%" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{cla.clamedCode}"/>
                                </rich:column >
                                <rich:column sortable="true" sortBy="#{cla.clamedSujet}" width="40%">
                                    <f:facet name="header"><h:outputText value="Classe"/></f:facet>
                                    <h:outputText  value="#{cla.clamedSujet}"/>
                                </rich:column >
                                <rich:column sortable="true" sortBy="#{cla.clamedTheme}" width="40%">
                                    <f:facet name="header"><h:outputText value="Division"/></f:facet>
                                    <h:outputText  value="#{cla.clamedTheme}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>
                <rich:tab id="tabType" label="Type">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.typeSelectionne}" reRender="idType"/>
                    <h:panelGrid width="100%" id="idType">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableType" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.datamodelType}" var="cla"  >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.selectionType}"/>
                                <rich:column sortable="true" sortBy="#{cla.clamedCode}" width="10%" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{cla.clamedCode}"/>
                                </rich:column >
                                <rich:column sortable="true" sortBy="#{cla.clamedSujet}" width="90%">
                                    <f:facet name="header"><h:outputText value="Sujet"/></f:facet>
                                    <h:outputText  value="#{cla.clamedSujet}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>
                <rich:tab id="tabSupport" label="Support">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.supportSelectionne}" reRender="idSupport"/>
                    <h:panelGrid width="100%" id="idSupport">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableSupport" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.datamodelSupport}" var="cla"  >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.selectionSupport}"/>
                                <rich:column sortable="true" sortBy="#{cla.clamedCode}" width="10%" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{cla.clamedCode}"/>
                                </rich:column >
                                <rich:column sortable="true" sortBy="#{cla.clamedSujet}" width="90%">
                                    <f:facet name="header"><h:outputText value="Sujet"/></f:facet>
                                    <h:outputText  value="#{cla.clamedSujet}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>
                <rich:tab id="tabConteant" label="Contenant">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.contenantSelectionne}" reRender="idContenant"/>
                    <h:panelGrid width="100%" id="idContenant">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableContenant" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" border="0" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.datamodelContenant}" var="cla"  >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick"  reRender="panelBouton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.selectionContenant}"/>
                                <rich:column sortable="true" sortBy="#{cla.clamedCode}" width="10%" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText value="Code"/></f:facet>
                                    <h:outputText  value="#{cla.clamedCode}"/>
                                </rich:column >
                                <rich:column sortable="true" sortBy="#{cla.clamedSujet}" width="90%">
                                    <f:facet name="header"><h:outputText value="Sujet"/></f:facet>
                                    <h:outputText  value="#{cla.clamedSujet}"/>
                                </rich:column >
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>
            </rich:tabPanel>
        </center>
        <br>
        <center>
            <h:column>
                Cliquez  <A target="_blank" HREF="https://fr.wikipedia.org/wiki/Classification_d%C3%A9cimale_de_Dewey" TITLE="description" style="color:blue;"> ici </A>  pour avoir des informations sur la méthode de classement DEWEY.
            </h:column>
            <br><br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelClassement" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.showmodelPanel}" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="350">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.showmodelPanel}" var="act">
            <f:facet name="header"><h:outputText value="GESTION D'UN #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.libelleOnglet}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCancel" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.annulerClassement}" styleClass="hidelink" reRender="panelClassement,panelBouton"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid  id="pgrdAjtAct" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Code:" /></h:column>
                        <h:column id="clnAjtAct">
                            <h:inputText id="AdActCode"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.classementMediatheque.clamedCode}" size="7" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.classementMediatheque.clamedId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.verifielesSaisieCodeAct}" reRender="pgrdAjtAct,prgoutpAjtAct"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText  id="outexistCodeAct" style="color:red;" value="Le code est vide ou existe déjà!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.existeCode}"/>
                        </h:column>
                        <h:column>
                            <h:outputText value="Classe:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"/>
                            <h:outputText value="Libellé:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne!=0}"/>
                        </h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.classementMediatheque.clamedSujet}" onkeypress="return scanToucheLettre(event)" style="width:100%;" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"><h:outputText value="Division:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.classementMediatheque.clamedTheme}" onkeypress="return scanToucheLettre(event)" style="width:100%;" maxlength="100"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"><h:outputText value="Domaine:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.classementMediatheque.clamedDomaine}" onkeypress="return scanToucheLettre(event)" style="width:100%;" maxlength="100"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.ongletSelectionne==0}"><h:outputText value="Inactif:" /></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.var_inactif}"/></h:column>
                    </h:panelGrid>

                    <h:panelGroup id="prgoutpAjtAct">
                        <br>
                        <center>
                            <a4j:commandButton id="idValide" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.saveClassement}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.existeCode}" reRender="panelClassement,panelBouton,tableSujet,tableType,tableSupport,tableContenant"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValide')}.click()" />
                        </center>
                        <br>
                        <center>
                            <h:outputText  id="outpAjtCodLibAct" style="color:red;" value="La saisie du code et du libellé sont obligatoires!" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formClassementMediatheque.codelibVide==false}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>