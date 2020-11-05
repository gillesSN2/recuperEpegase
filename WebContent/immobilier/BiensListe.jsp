<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="biensliste">

    <a4j:form>

        <center> <h2>
                <h:panelGroup>
                    <h:outputText value="LISTE DES BIENS (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.libelleCategorie})" style="color:green;"></h:outputText>&nbsp;&nbsp;
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.categorieModule!=3}" var="etat1">
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.etat}">
                            <f:selectItem itemLabel="Sélectionnez le type de biens" itemValue="9"/>
                            <f:selectItem itemLabel="Biens gérés par l'agence (Biens libres)" itemValue="0"/>
                            <f:selectItem itemLabel="Biens gérés par l'agence (Biens occupés)" itemValue="1"/>
                            <f:selectItem itemLabel="Biens gérés par l'agence (Tous les Biens)" itemValue="2"/>
                            <f:selectItem itemLabel="Biens plus gérés par l'agence" itemValue="8"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.chargerBiens}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,scrollTableVilla,tableVilla,scrollTableImmeuble,tableImmeuble,scrollTableAppartement,tableAppartement,scrollTableBureau,tableBureau,scrollTableCommerce,tableCommerce,scrollTableGarage,tableGarage,scrollTableHangar,tableHangar,scrollTableUsine,tableUsine,scrollTableBox,tableBox,scrollTableTerrain,tableTerrain"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.categorieModule==3}" var="etat2">
                        <h:selectOneMenu style="width:300px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.etat}">
                            <f:selectItem itemLabel="Sélectionnez le type de biens" itemValue="9"/>
                            <f:selectItem itemLabel="Biens en construction" itemValue="3"/>
                            <f:selectItem itemLabel="Biens disponibles" itemValue="4"/>
                            <f:selectItem itemLabel="Biens vendus" itemValue="5"/>
                            <f:selectItem itemLabel="Biens litiges" itemValue="6"/>
                            <f:selectItem itemLabel="Biens détruits" itemValue="7"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.chargerBiens}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,scrollTableVilla,tableVilla,scrollTableImmeuble,tableImmeuble,scrollTableAppartement,tableAppartement,scrollTableBureau,tableBureau,scrollTableCommerce,tableCommerce,scrollTableGarage,tableGarage,scrollTableHangar,tableHangar,scrollTableUsine,tableUsine,scrollTableBox,tableBox,scrollTableTerrain,tableTerrain"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:panelGroup>
            </h2></center>

        <h:panelGrid id="panelGeneral" width="100%">
            <h:panelGrid id="panelBouton" columns="7" width="300px" style="height:34px">
                <a4j:commandButton title="Ajouter nouveau bien" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterBien}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Modifier le bien sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifierBien}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Consulter le bien sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.consulterBien}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Supprimer le bien sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bien ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerBien}" reRender="panelBouton,scrollTableVilla,tableVilla,scrollTableImmeuble,tableImmeuble,scrollTableAppartement,tableAppartement,scrollTableBureau,tableBureau,scrollTableCommerce,tableCommerce,scrollTableGarage,tableGarage,scrollTableHangar,tableHangar,scrollTableUsine,tableUsine,scrollTableBox,tableBox,scrollTableTerrain,tableTerrain,modMessage"/>
                <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
                <a4j:commandButton title="Transférer un bien" image="/images/parametre.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.transfertBien}" onclick="if (!confirm('Etes-vous sur de vouloir transférer ce bien?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTransfert"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>

            <center>
                <rich:tabPanel switchType="client" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_activeTab}" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabVilla" label="Villa" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_villa}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickVilla}" reRender="panVilla"/>
                        <h:panelGrid width="100%" id="panVilla">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableVilla" id="scrollTableVilla" maxPages="20"align="left" for="tableVilla"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableVilla" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelVilla}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}" title="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}" title="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}" title="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}" title="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabImmeuble" label="Immeuble" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_immeuble}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickImmeuble}" reRender="panImmeuble"/>
                        <h:panelGrid width="100%" id="panImmeuble">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableImmeuble" id="scrollTableImmeuble" maxPages="20"align="left" for="tableImmeuble"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableImmeuble" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelImmeuble}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Nombre d'étage" sortable="true" width="80px" sortBy="#{var.bieNbEtage}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Etage" /></f:facet>
                                        <h:outputText value="#{var.bieNbEtage}" rendered="#{var.bieNbEtage!=0}" />
                                    </rich:column>
                                    <rich:column label="Nombre d'appartements" sortable="true" width="80px" sortBy="#{var.bieNbAppartement}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Appart." /></f:facet>
                                        <h:outputText value="#{var.bieNbAppartement}" rendered="#{var.bieNbAppartement!=0}" />
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabAppartement" label="Appartement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_appartement}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickAppartement}"/>
                        <h:panelGrid width="100%" id="panAppartement">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableAppartement" id="scrollTableAppartement" maxPages="20"align="left" for="tableAppartement"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableAppartement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelAppartement}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Immeuble" sortable="true" width="100px" sortBy="#{var.bieGroupe}">
                                        <f:facet name="header"><h:outputText  value="Immeuble" /></f:facet>
                                        <h:outputText value="#{var.bieGroupe}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etage" sortable="true" width="80px" sortBy="#{var.bieEtage}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                                        <h:outputText value="#{var.bieEtage}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabChambre" label="Chambres" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_chambre}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickChambre}" reRender="panChambre"/>
                        <h:panelGrid width="100%" id="panChambre">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableChambre" id="scrollTableChambre" maxPages="20"align="left" for="tableChambre"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableChambre" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelChambre}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Immeuble" sortable="true" width="100px" sortBy="#{var.bieGroupe}">
                                        <f:facet name="header"><h:outputText  value="Immeuble" /></f:facet>
                                        <h:outputText value="#{var.bieGroupe}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etage" sortable="true" width="80px" sortBy="#{var.bieEtage}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                                        <h:outputText value="#{var.bieEtage}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabBureau" label="Bureau" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_bureau}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickBureau}" reRender="panBureau"/>
                        <h:panelGrid width="100%" id="panBureau">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableBureau" id="scrollTableBureau" maxPages="20"align="left" for="tableBureau"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBureau" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelBureau}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Immeuble" sortable="true" width="100px" sortBy="#{var.bieGroupe}">
                                        <f:facet name="header"><h:outputText  value="Immeuble" /></f:facet>
                                        <h:outputText value="#{var.bieGroupe}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etage" sortable="true" width="80px" sortBy="#{var.bieEtage}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                                        <h:outputText value="#{var.bieEtage}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabCommerce" label="Commerce" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_commerce}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickCommerce}" reRender="panCommerce"/>
                        <h:panelGrid width="100%" id="panCommerce">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableCommerce" id="scrollTableCommerce" maxPages="20"align="left" for="tableCommerce"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableCommerce" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelCommerce}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{var.bieNbPiece}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                        <h:outputText value="#{var.bieNbPiece}" rendered="#{var.bieNbPiece!=0}" />
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabGarage" label="Garage" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_garage}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickGarage}" reRender="panGarage"/>
                        <h:panelGrid width="100%" id="panGarage">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableGarage" id="scrollTableGarage" maxPages="20"align="left" for="tableGarage"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableGarage" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelGarage}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabHangar" label="Hangar" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_hanger}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickHangar}" reRender="panHangar"/>
                        <h:panelGrid width="100%" id="panHangar">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableHangar" id="scrollTableHangar" maxPages="20"align="left" for="tableHangar"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableHangar" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelHangar}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabUsine" label="Usine" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_usine}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickUsine}" reRender="panUsine"/>
                        <h:panelGrid width="100%" id="panUsine">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableUsine" id="scrollTableUsine" maxPages="20"align="left" for="tableUsine"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableUsine" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelUsine}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Modèle" sortable="true" width="80px" sortBy="#{var.bieModele}">
                                        <f:facet name="header"><h:outputText  value="Modèle" /></f:facet>
                                        <h:outputText value="#{var.bieModele}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{var.bieNbPiece}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                        <h:outputText value="#{var.bieNbPiece}" rendered="#{var.bieNbPiece!=0}" />
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabBox" label="Box" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_box}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickBox}" reRender="panBox"/>
                        <h:panelGrid width="100%" id="panBox">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableBox" id="scrollTableBox" maxPages="20"align="left" for="tableBox"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableBox" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelBox}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabTerrain" label="Terrain" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_acc_terrain}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.clickTerrain}" reRender="panTerrain"/>
                        <h:panelGrid width="100%" id="panTerrain">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableTerrain" id="scrollTableTerrain" maxPages="20"align="left" for="tableTerrain"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableTerrain" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelTerrain}" var="var" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.configListeEntete}">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                    <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{var.bieNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{var.bieNum}"/>
                                    </rich:column>
                                    <rich:column label="Publication" sortable="true" width="30px" sortBy="#{var.biePublication}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Pub."/></f:facet>
                                        <h:graphicImage value="/images/partage.png" width="20px" height="20px" alt="pub" rendered="#{var.biePublication==1}"/>
                                    </rich:column>
                                    <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{var.bieOccupe}" style="text-align:center">
                                        <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                        <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{var.bieOccupe==1}"/>
                                    </rich:column>
                                    <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{var.bieNom}">
                                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                        <h:outputText value="#{var.bieNom}"/>
                                    </rich:column>
                                    <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{var.bieNomTiers}">
                                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                        <h:outputText value="#{var.bieNomTiers}"/>
                                    </rich:column>
                                    <rich:column label="Adresse du bien" sortable="true" width="200px" sortBy="#{var.bieAdresse}">
                                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                                        <h:outputText value="#{var.bieAdresse}"/>
                                    </rich:column>
                                    <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{var.bieSurperficie}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                        <h:outputText value="#{var.bieSurperficie}" rendered="#{var.bieSurperficie!=0}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{var.bieBaseLoyer}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                        <h:outputText value="#{var.bieBaseLoyer}" rendered="#{var.bieBaseLoyer!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Comptes de Gestion" sortable="true" width="100px" sortBy="#{var.bieCompteGestion}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Gestion" /></f:facet>
                                        <h:outputText value="#{var.bieCompteGestion}"/>
                                    </rich:column>
                                    <rich:column label="Comptes de Charges" sortable="true" width="100px" sortBy="#{var.bieCompteCharge}" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Cpt. Charges" /></f:facet>
                                        <h:outputText value="#{var.bieCompteCharge}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

            </center>
        </h:panelGrid>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTransfert" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelTransfert}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelTransfert}" var="trf">
            <f:facet name="header"><h:outputText value="Transfert d'un bien"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fermerTransfert}" image="/images/close.gif" styleClass="hidelink" reRender="panelTransfert"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Catégorie actuelle:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCategorie}" readonly="true" disabled="true">
                                <f:selectItem itemLabel="Location" itemValue="0"/>
                                <f:selectItem itemLabel="Syndic" itemValue="1"/>
                                <f:selectItem itemLabel="Négoce" itemValue="2"/>
                                <f:selectItem itemLabel="Location/Syndic" itemValue="3"/>
                                <f:selectItem itemLabel="Location/Négoce" itemValue="4"/>
                                <f:selectItem itemLabel="Syndic/Négoce" itemValue="5"/>
                                <f:selectItem itemLabel="Location/Syndic/Négoce" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nouvelle catégorie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_imput_cat}">
                                <f:selectItem itemLabel="Location" itemValue="0"/>
                                <f:selectItem itemLabel="Syndic" itemValue="1"/>
                                <f:selectItem itemLabel="Négoce" itemValue="2"/>
                                <f:selectItem itemLabel="Location/Syndic" itemValue="3"/>
                                <f:selectItem itemLabel="Location/Négoce" itemValue="4"/>
                                <f:selectItem itemLabel="Syndic/Négoce" itemValue="5"/>
                                <f:selectItem itemLabel="Location/Syndic/Négoce" itemValue="6"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.validerTransfert}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="modMessage" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelMessage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelMessage}" var="msg">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanMessage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fermerMessage}" styleClass="hidelink" reRender="modMessage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessage')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form >
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.texteMessage}" style="width:100%" readonly="true"/>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>



</f:subview>
