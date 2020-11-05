<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersPatentlga">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>
        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Lettres de garantie de : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patNom} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patients.patPrenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <h:panelGrid id="panelBouton" columns="7" width="350px" style="height:34px">
                    <a4j:commandButton title="Ajouter nouvelle lettre de garantie" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterLettreGarantie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreGarantie"/>
                    <a4j:commandButton title="Modifier la lettre de garantie sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.modifierLettreGarantie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreGarantie"/>
                    <a4j:commandButton title="Consulter la lettre de garantie sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.consulterLettreGarantie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreGarantie"/>
                    <a4j:commandButton title="Supprimer la lettre de garantie sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerLettreGarantie}" reRender="panelBouton,tablelettreGarantie"/>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                    <a4j:commandButton title="Historique des règlements de la lettre sélectionnée" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.chargerReglementGarantie}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
                    <a4j:commandButton title="Valider la lettre de garantie sélectionnée" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.validerLettreGarantie}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat"/>
                    <a4j:commandButton title="Dé-Valider la lettre de garantie sélectionnée" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dvaliderLettreGarantie}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat"/>
                </h:panelGrid>

                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableLettreGarantie" maxPages="20" align="left" for="tablelettreGarantie"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_nb_max}" styleClass="bg" id="tablelettreGarantie" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" height="300px"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelLettreGarantie}" var="lga">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.selectionnerLettreGarantie}" reRender="panelBouton"/>
                        <rich:column label="Numéro de la lettre de garantie" sortable="true" sortBy="#{lga.patlgaNum}" width="10%">
                            <f:facet name="header"><h:outputText  value="N° Lettre"/></f:facet>
                            <h:outputText value="#{lga.patlgaNum}"/>
                        </rich:column>
                        <rich:column label="Référence de la lettre de garantie" sortable="true" sortBy="#{lga.patlgaReference}" width="10%">
                            <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                            <h:outputText value="#{lga.patlgaReference}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat de la lettre" sortable="true" sortBy="#{lga.libelleEtat}" width="5%">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{lga.libelleEtat}"/>
                        </rich:column>
                        <rich:column label="Date de la lettre" sortable="true" sortBy="#{lga.patlgaDate}" width="10%">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{lga.patlgaDate}"/>
                        </rich:column>
                        <rich:column label="Tiers emetteur" sortable="true" sortBy="#{lga.tiers.tieraisonsocialenom}" width="25%">
                            <f:facet name="header"><h:outputText  value="Tiers"/></f:facet>
                            <h:outputText value="#{lga.tiers.tieraisonsocialenom}"/>
                        </rich:column>
                        <rich:column label="Montnt accordé" sortable="true" sortBy="#{lga.patlgaMontant}" width="10%" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                            <h:outputText value="#{lga.patlgaMontant}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant consommé" sortable="true" sortBy="#{lga.patlgaConsomme}" width="10%" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Consommé"/></f:facet>
                            <h:outputText value="#{lga.patlgaConsomme}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{lga.patlgaSolde}" width="10%" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Solde"/></f:facet>
                            <h:outputText value="#{lga.patlgaSolde}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Scan de la lettre" sortable="false" width="10%" style="text-align:center">
                            <f:facet name="header"><h:outputText  value="Scan"/></f:facet>
                            <a4j:commandButton title="Afficher Scan" image="#{lga.pj}" style="height:20px;width:20px" rendered="#{lga.pj!=null}" reRender="panelScan" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.afficherScan}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.retourLettreGarantie}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelLettreGarantie" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelLettreGarantie}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelLettreGarantie}" var="lga">
            <f:facet name="header"><h:outputText value="Description lettre de garantie" style="color:white;"/></f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">

                    <rich:tabPanel switchType="client" immediate="true" id="tabPanelLettre" style="border:0px;">

                        <rich:tab label="Description">
                            <h:panelGrid  width="100%" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Numéro lettre:"/></h:column>
                                <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaNum}" disabled="true" readonly="true"/></h:column>
                                <h:column><h:outputText value="Référence lettre:"/></h:column>
                                <h:column><h:inputText maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaReference}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}"/></h:column>
                                <h:column><h:outputText value="Date lettre:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}"/></h:column>
                                <h:column><h:outputText value="Tiers émetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.idTiersPec}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}">
                                        <f:selectItem  itemLabel="Sélectionnez tiers" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.mesTiersPEC}" />
                                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idValide"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Objet:"/></h:column>
                                <h:column><h:inputText style="width:100%"  maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}"/></h:column>
                                <h:column><h:outputText value="Montant accordé:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaMontant}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Montant consommé:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaConsomme}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Solde:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaSolde}" style="text-align:right" readonly="true" disabled="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab label="Scan lettre">
                            <h:panelGrid style="width:100%;">
                                <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top">
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto==null}">
                                        <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.uploadedFile}" accept="image/*"/>
                                        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.ajouterPhotoLettreGarantie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}">
                                            <a4j:support eventsQueue="maQueue" immediate="true" reRender="grp3"/>
                                        </h:commandButton>
                                        <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                    </h:panelGroup>
                                    <br/>
                                    <h:panelGroup  id="grp3" style="tex-align:center">
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto!=null}">
                                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100%" height="800px"/>&nbsp;
                                            <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.supprimerPhotoLettreGarantie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.patientLettreGarantie.patlgaPhoto==null}">
                                            <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                        </c:if>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                    <br>
                    <h:panelGroup id="idValide">
                        <center>
                            <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerReglementGarantie}" reRender="panelLettreGarantie"/>&nbsp;&nbsp;
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.saveLettreGarantie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.idTiersPec!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.var_actionLettre}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreGarantie,tablelettreGarantie"/>
                        </center>
                    </h:panelGroup>
                    <br>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelScan" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="900" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelScan}" var="trf">
            <f:facet name="header"><h:outputText value="Scan facture"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerScan}" image="/images/close.gif" styleClass="hidelink" reRender="panelScan"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <img alt="scan" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.urlphoto}" width="100%" height="800px"/>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelLesReglements}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.showModalPanelLesReglements}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.fermerReglementGarantie}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/tiers/LettreGarantieCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formPatients.dataModelReglements}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocumentLettreGarantie.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
