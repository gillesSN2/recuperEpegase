<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="reunioncommercialeliste">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES REUNIONS COMMERCIALES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="10" width="100%">
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpNum}" size="5"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="Compte rendu" itemValue="1"/>
                            <f:selectItem itemLabel="Cloturé" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpType}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Types" itemValue="100"/>
                            <f:selectItem itemLabel="Compte rendu Commercial" itemValue="10"/>
                            <f:selectItem itemLabel="Réunion Production" itemValue="11"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpService}" style="width:150px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesServicesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="table,panelBouton,modAttente"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="10" width="350px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.ajoutDocumentCommercial}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.modifDocumentCommercial}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.consultDocumentCommercial}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" />
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.supprimerDocumentCommercial}" reRender="table,panelBouton"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Envoyer convocation par mail" image="/images/mail_envoie.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" onclick="if (!confirm('Voulez-vous envoyer les convocations par mail ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.envoieConvocation}" reRender="modAttente"/>
            <a4j:commandButton title="Envoyer compte rendu par mail" image="/images/mail_envoie.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.imp}" onclick="if (!confirm('Voulez-vous envoyer les comptes rendus par mail ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.envoieCompteRenduCommercial}" reRender="modAttente"/>
            <a4j:commandButton title="Cloturer le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,idEtat"/>
            <a4j:commandButton title="Dé-Cloturer le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menuoffice.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.pageIndex}" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                    <rich:extendedDataTable style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelReunion}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectionLigneCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.visualisationLigneCommercial}" reRender="idSubView,panelBouton"/>
                        <rich:column label="N° réunion" sortable="true" sortBy="#{var.reuNum}">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.reuNum}"/>
                        </rich:column>
                        <rich:column label="Date réunion" sortable="true" sortBy="#{var.reuDate}" width="70px" sortOrder="DESCENDING">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.reuDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.reuEtat}" width="100px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Type" sortable="true" sortBy="#{var.reuType}" width="80px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                            <h:outputText value="#{var.libelleType}"/>
                        </rich:column>
                        <rich:column label="Objet de la réunion" sortable="true" sortBy="#{var.reuObject}" width="300px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.reuObject}"/>
                        </rich:column>
                        <rich:column label="Date début analyse" sortable="true" sortBy="#{var.reuDateDebut}" width="70px">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{var.reuDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin analyse" sortable="true" sortBy="#{var.reuDateFin}" width="70px">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{var.reuDateFin}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.reuNomPresident}" width="200px">
                            <f:facet name="header"><h:outputText  value="Responsable"  /></f:facet>
                            <h:outputText  value="#{var.reuNomPresident}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{var.libelle_service}" >
                            <f:facet name="header"><h:outputText value="Service"  /></f:facet>
                            <h:outputText  value="#{var.libelle_service}"/>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.reuActivite}" >
                            <f:facet name="header"><h:outputText value="Activité"  /></f:facet>
                            <h:outputText  value="#{var.reuActivite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panelListeResponsable" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450">
        <center>
            <f:facet name="header"><h:outputText value="Sélection du responsable"/></f:facet>
            <a4j:form id="formModalListeResponsable">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableResp" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.datamodelResponsable}"  var="resp">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectionResponsable}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Nom et prénom" sortable="true" sortBy="#{resp.usrPatronyme}" width="50%">
                            <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                            <h:outputText value="#{resp.usrPatronyme}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{resp.usrFonction}" width="20%">
                            <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                            <h:outputText value="#{resp.usrFonction}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{resp.usrService}" width="20%">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{resp.usrService}"/>
                        </rich:column>
                        <rich:column label="Groupe ou Collaboration" sortable="true" sortBy="#{resp.usrCollaboration}" width="10%">
                            <f:facet name="header"><h:outputText  value="Groupe" /></f:facet>
                            <h:outputText value="#{resp.usrCollaboration}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valdest">
                    <center>
                        <h:commandButton id="idCanResp" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.annuleResponsable}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton id="idValResp" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.calculeResponsable}"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanResp')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValResp')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>



</f:subview>
