<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bauxliste">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES BAUX" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%" id="idRecherchePanel">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="Locataire"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpClient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idPremption">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesEtatsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.calculeDatePeremption}" reRender="idRecherchePanel,idPremption,idDatePer,idAnnee"/>
                        </h:selectOneMenu>&nbsp;
                        <rich:calendar id="idDatePer" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.datePeremption}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.affaicheDatePermption}"/>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idAnnee" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.periode}" style="width:100px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_more_search}">
                            <f:selectItem itemLabel="Toutes Années" itemValue="0"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.lesPeriodes}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableBail1,scrollTableBail1,tableBail2,scrollTableBail2,tableBail3,scrollTableBail3"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="10" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_more_search}">
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="10" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau bail" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.ajouterBail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le bail sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.modifierBail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le bail sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.consulterBail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le bail sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.supprimerBail}" reRender="tableBail1,scrollTableBail1,tableBail2,scrollTableBail2,tableBail3,scrollTableBail3,panelBouton"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Historique du bail sélectionné" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.historiqueBail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Valider le bail sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce bail ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Dé-Valider le bail sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce bail ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panelBouton,idEtat"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>

            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;" >

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabVisionGlobale" label="Liste des baux">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.option1}"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.pageIndex}" reRender="tableBail1" id="scrollTableBail1" maxPages="20" align="left" for="tableBail1" />
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBail1" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.datamodelBail1}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.simpleSelectionEntete1}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.extDTable1}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.selectionLigne1}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visualisationLigne1}" reRender="idSubView,panelBouton"/>
                                <rich:column label="Numéro du bail" sortable="true" width="70px" sortBy="#{var.biebaiNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{var.biebaiNum}"/>
                                </rich:column>
                                <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.libelleEtat}" width="50px" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{var.libelleEtat}"/>
                                </rich:column>
                                <rich:column label="Nom du locataire" sortable="true" width="200px" sortBy="#{var.biebaiNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Locataire" /></f:facet>
                                    <h:outputText value="#{var.biebaiNomTiers}"/>
                                </rich:column>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bien.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N° Bien" /></f:facet>
                                    <h:outputText value="#{var.bien.bieNum}"/>
                                </rich:column>
                                <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bien.bieNom}">
                                    <f:facet name="header"><h:outputText  value="Nom Bien" /></f:facet>
                                    <h:outputText value="#{var.bien.bieNom}"/>
                                </rich:column>
                                <rich:column label="Date début bail" sortable="true" width="70px" sortBy="#{var.biebaiDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date fin du bail" sortable="true" width="70px" sortBy="#{var.biebaiDateFin}">
                                    <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date fin defacturation" sortable="true" width="70px" sortBy="#{var.biebaiDateFinFacture}">
                                    <f:facet name="header"><h:outputText  value="Fin Facture" style="color:red"/></f:facet>
                                    <h:outputText value="#{var.biebaiDateFinFacture}" style="color:red">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Mode de facturation" sortable="true" width="80px" sortBy="#{var.libelleMode}">
                                    <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                                    <h:outputText value="#{var.libelleMode}"/>
                                </rich:column>
                                <rich:column label="Usage" sortable="true" width="80px" sortBy="#{var.libelleUsage}">
                                    <f:facet name="header"><h:outputText  value="Usage" /></f:facet>
                                    <h:outputText value="#{var.libelleUsage}"/>
                                </rich:column>
                                <rich:column label="Montant Loyer" sortable="true" width="100px" sortBy="#{var.biebaiLoyerNet}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                    <h:outputText value="#{var.biebaiLoyerNet}" rendered="#{var.biebaiLoyerNet!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant Charges" sortable="true" width="100px" sortBy="#{var.biebaiCharges}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                                    <h:outputText value="#{var.biebaiCharges}" rendered="#{var.biebaiCharges!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="TLV" sortable="true" width="50px" sortBy="#{var.libelleTlv}">
                                    <f:facet name="header"><h:outputText  value="TLV" /></f:facet>
                                    <h:outputText value="#{var.libelleTlv}"/>
                                </rich:column>
                                <rich:column label="TVA" sortable="true" width="50px" sortBy="#{var.libelleTva}">
                                    <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                                    <h:outputText value="#{var.libelleTva}"/>
                                </rich:column>
                                <rich:column label="IRPP" sortable="true" width="50px" sortBy="#{var.libelleIrpp}">
                                    <f:facet name="header"><h:outputText  value="IRPP" /></f:facet>
                                    <h:outputText value="#{var.libelleIrpp}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabOption" label="Option bail">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.option2}"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.pageIndex}" reRender="tableBail2" id="scrollTableBail2" maxPages="20" align="left" for="tableBail2" />
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBail2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.datamodelBail2}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.simpleSelectionEntete2}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.extDTable2}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.selectionLigne2}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visualisationLigne2}" reRender="idSubView,panelBouton"/>
                                <rich:column label="Numéro du bail" sortable="true" width="70px" sortBy="#{var.biebaiNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{var.biebaiNum}"/>
                                </rich:column>
                                <rich:column label="Nom du locataire" sortable="true" width="200px" sortBy="#{var.biebaiNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Locataire" /></f:facet>
                                    <h:outputText value="#{var.biebaiNomTiers}"/>
                                </rich:column>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bien.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N° Bien" /></f:facet>
                                    <h:outputText value="#{var.bien.bieNum}"/>
                                </rich:column>
                                <rich:column label="TOM" sortable="true" width="100px" sortBy="#{var.libelleTom}">
                                    <f:facet name="header"><h:outputText  value="TOM" /></f:facet>
                                    <h:outputText value="#{var.libelleTom}"/>
                                </rich:column>
                                <rich:column label="TVA" sortable="true" width="100px" sortBy="#{var.libelleTva}">
                                    <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                                    <h:outputText value="#{var.libelleTva}"/>
                                </rich:column>
                                <rich:column label="TLV" sortable="true" width="100px" sortBy="#{var.libelleTlv}">
                                    <f:facet name="header"><h:outputText  value="TLV" /></f:facet>
                                    <h:outputText value="#{var.libelleTlv}"/>
                                </rich:column>
                                <rich:column label="IRPP" sortable="true" width="100px" sortBy="#{var.libelleIrpp}">
                                    <f:facet name="header"><h:outputText  value="IRPP" /></f:facet>
                                    <h:outputText value="#{var.libelleIrpp}"/>
                                </rich:column>
                                <rich:column label="% Commission agence" sortable="true" width="100px" sortBy="#{var.biebaiTauxGerance}" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Com. Agence" style="text-align:right;"/></f:facet>
                                    <h:outputText value="#{var.biebaiTauxGerance}" rendered="#{var.biebaiTauxGerance!=0}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabSuivi" label="Suivi bail">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.option3}"/>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.pageIndex}" reRender="tableBail3" id="scrollTableBail3" maxPages="20" align="left" for="tableBail3" />
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBail3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.datamodelBail3}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.simpleSelectionEntete3}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.extDTable3}">
                                <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.selectionLigne3}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton"/>
                                <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.visualisationLigne3}" reRender="idSubView,panelBouton"/>
                                <rich:column label="Numéro du bail" sortable="true" width="70px" sortBy="#{var.biebaiNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{var.biebaiNum}"/>
                                </rich:column>
                                <rich:column label="Nom du locataire" sortable="true" width="200px" sortBy="#{var.biebaiNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Locataire" /></f:facet>
                                    <h:outputText value="#{var.biebaiNomTiers}"/>
                                </rich:column>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bien.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N° Bien" /></f:facet>
                                    <h:outputText value="#{var.bien.bieNum}"/>
                                </rich:column>
                                <rich:column label="Date début établissement" sortable="true" width="70px" sortBy="#{var.biebaiDate}">
                                    <f:facet name="header"><h:outputText  value="Etabli" /></f:facet>
                                    <h:outputText value="#{var.biebaiDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date début bail" sortable="true" width="70px" sortBy="#{var.biebaiDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date fin du bail" sortable="true" width="70px" sortBy="#{var.biebaiDateFin}">
                                    <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date signature du bail" sortable="true" width="70px" sortBy="#{var.biebaiDateSignature}">
                                    <f:facet name="header"><h:outputText  value="Signature" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateSignature}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date dépôt Domaines" sortable="true" width="70px" sortBy="#{var.biebaiDateDepot}">
                                    <f:facet name="header"><h:outputText  value="Dép. Dom." /></f:facet>
                                    <h:outputText value="#{var.biebaiDateDepot}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date retour Domaines" sortable="true" width="70px" sortBy="#{var.biebaiDateEnregistrement}">
                                    <f:facet name="header"><h:outputText  value="Ret. Dom." /></f:facet>
                                    <h:outputText value="#{var.biebaiDateEnregistrement}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date remise locataire" sortable="true" width="70px" sortBy="#{var.biebaiDateADeposer}">
                                    <f:facet name="header"><h:outputText  value="Rem. Loc." /></f:facet>
                                    <h:outputText value="#{var.biebaiDateADeposer}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date dernière révision" sortable="true" width="70px" sortBy="#{var.biebaiDerniereRevision}">
                                    <f:facet name="header"><h:outputText  value="Der. Rév." /></f:facet>
                                    <h:outputText value="#{var.biebaiDerniereRevision}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date procahaine révision" sortable="true" width="70px" sortBy="#{var.biebaiProchaineRevision}">
                                    <f:facet name="header"><h:outputText  value="Pro. Rév." /></f:facet>
                                    <h:outputText value="#{var.biebaiProchaineRevision}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date état des lieux entrée" sortable="true" width="70px" sortBy="#{var.biebaiDateEtatIn}">
                                    <f:facet name="header"><h:outputText  value="Etat IN" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateEtatIn}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date état des lieux sortie" sortable="true" width="70px" sortBy="#{var.biebaiDateEtatOut}">
                                    <f:facet name="header"><h:outputText  value="Etat OUT" /></f:facet>
                                    <h:outputText value="#{var.biebaiDateEtatOut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>

            </div>

        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Facturation Location"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Choix annulation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiEtat}" style="width:100px;">
                                <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                <f:selectItem itemLabel="Terminé" itemValue="4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.bienBail.biebaiMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



</f:subview>
