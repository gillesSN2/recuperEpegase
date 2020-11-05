<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="productionfiche">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES PRODUCTIONS PAPIERS" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.nomOnglet}" switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Production" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_document}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletProduit}" reRender="idPanProduction"/>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20" id="idPanProduction">
                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateStk==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Quart production:"/></h:column>
                                    <h:column><h:inputText style="width:100%" id="idQuart" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabQuart}" disabled="true"/>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesResponsablesItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                <h:column><h:outputText value="Valorisation:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabTotPump}" style="text-align:right;width:100%"  readonly="true">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>

                        <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;">
                            <rich:tab id="tabDocIntrant" label="Produits utilisés">
                                <h:panelGrid width="100%" id="idPanIntrant">
                                    <h:panelGroup id="panelBoutonIntrant" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_ajt}" reRender="panelLigneIntrant,panelBoutonIntrant"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.deleteLigneIntrant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigneIntrant,tableLigneIntrant,panelBoutonIntrant"/>
                                    </h:panelGroup>
                                    <h:panelGrid width="100%" id="panelLigne1" style="border:1px solid green;background-color:#FFF8D4;height:70px" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_mod}">
                                        <h:panelGrid  columns="8" width="100%" id="panelLigneIntrant">
                                            <h:column>
                                                <h:outputText value="Code:"/><br/>
                                                <h:inputText tabindex="1" id="inpCodDetIntrant" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.griserchamps}" size="6">
                                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,inpCodDetIntrant,panelLigneIntrant"/>
                                                </h:inputText>&nbsp;
                                                <a4j:commandButton  tabindex="2" style="height:15px;width:15px" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.detailProduitIntrant}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Libellé:"/><br/>
                                                <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligLibelle}" disabled="true" style="width:100%"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Mode" /><br>
                                                <h:selectOneMenu tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier}" disabled="true" style="width:90px;">
                                                    <f:selectItem itemLabel="Format" itemValue="0"/>
                                                    <f:selectItem itemLabel="Largeur (laize)" itemValue="1"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Grs(cm):"/><br/>
                                                <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligGr}" disabled="true" style="width:90px"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Laize (cm)" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier==1}"/><br>
                                                <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligLarg}" disabled="true" style="width:70px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier==1}"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Couleur:"/><br/>
                                                <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligCouleur}" disabled="true" style="width:100px"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Haut.(cm):"/><br/>
                                                <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligHaut}" disabled="true" style="width:90px"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Long.(cm):"/><br/>
                                                <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligLong}" disabled="true" style="width:90px"/>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Dépôt:"/><br/>
                                                <h:selectOneMenu id="idDepotIntrant" tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligDepot}" style="width:90px">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.mesDepotsProduitsItems}" />
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculeQteDispo}" reRender="panelLigneIntrant,idQteDispo"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Qte dispo.:"/><br/>
                                                <h:inputText tabindex="11" id="idQteDispo" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligQteStock}" disabled="true" style="color:red;text-align:right;width:100px">
                                                </h:inputText>
                                            </h:column>
                                            <h:panelGroup>
                                                <h:outputText value="Poids net(kg):"/><br/>
                                                <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligPoidsNet}" style="width:90px;text-align:right;">
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculQtePapierIntrant}" reRender="panelLigneIntrant,panelPt"/>
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:panelGroup>
                                                <h:outputText value="Qte/Feuilles:"/><br/>
                                                <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligQte}" style="width:90px;text-align:right;">
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculQtePapierIntrant}" reRender="panelLigneIntrant,panelPt"/>
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                                <h:outputText value="PUMP:"/><br/>
                                                <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.verrouPump}" >
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPrixIntrants}" reRender="panelPt" />
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:column>
                                                <h:outputText value="Observation:"/><br/>
                                                <h:inputText tabindex="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligObs}" maxlength="50"/>
                                            </h:column>
                                            <h:panelGroup>
                                                <a4j:commandButton  tabindex="16" image="/images/valider_big.png" id="idValLigneIntrant" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.saveOneLigneIntrant}" reRender="panelPage,panelTotal,idPanIntrant" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.validationLigne<=1}"/>
                                            </h:panelGroup>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" id="tableLigneIntrant" enableContextMenu="false" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelIntrants}" var="doclig">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLigneIntrant}" reRender="panelLigneIntrant,panelBoutonIntrant,idLotFab"/>
                                            <rich:column label="Code produit" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{doclig.fabligCode}"/>
                                            </rich:column>
                                            <rich:column label="Famille produit" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                                <h:outputText value="#{doclig.codeFamille}"/>
                                            </rich:column>
                                            <rich:column label="Position tarifaire" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Douane"/></f:facet>
                                                <h:outputText value="#{doclig.fabligDouane}"/>
                                            </rich:column>
                                            <rich:column label="Libellé produit" sortable="false" width="17%" >
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{doclig.fabligLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Grammage" sortable="false" width="5%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Grs"/></f:facet>
                                                <h:outputText value="#{doclig.fabligGr}" rendered="#{doclig.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Couleur" sortable="false" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Coul."/></f:facet>
                                                <h:outputText value="#{doclig.fabligCouleur}" rendered="#{doclig.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Format" sortable="false" width="7%" >
                                                <f:facet name="header"><h:outputText  value="Format"/></f:facet>
                                                <h:outputText value="#{doclig.format}" rendered="#{doclig.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Code dépôt" sortable="false" width="5%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText value="#{doclig.fabligDepot}"/>
                                            </rich:column>
                                            <rich:column label="Poids net (Kgr)" sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Poids net"/></f:facet>
                                                <h:outputText value="#{doclig.fabligPoidsNet}" />
                                            </rich:column>
                                            <rich:column label="Quantité" sortable="false" style="text-align:right" width="7%" >
                                                <f:facet name="header"><h:outputText  value="Qté/F"/></f:facet>
                                                <h:outputText value="#{doclig.fabligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Pump" sortable="false" style="text-align:right" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                                <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                                <h:outputText value="#{doclig.fabligPump}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab id="tabDocGenere" label="Produits fabriqués">
                                <h:panelGrid width="100%" id="idPanProduit">
                                    <h:panelGroup id="panelBoutonFabrique" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_ajt}" reRender="panelLignePapier,panelBoutonFabrique"/>&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.deleteLigneGeneres}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsIntrants.fabligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLignePapier,tableLigneFabrique,panelBoutonFabrique"/>
                                    </h:panelGroup>
                                    <h:panelGrid width="100%" id="panelLignePapier" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_mod}">
                                        <h:panelGrid  columns="10" width="100%" id="panelLigne0">
                                            <h:column>
                                                <h:outputText value="Famille" style="text-decoration:underline;"/><br>
                                                <h:inputText tabindex="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligFamille} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligCode}" style="width:200px;" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligCode!=null}">
                                                </h:inputText>
                                                <h:selectOneMenu tabindex="2" id="idFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligFamille}" style="width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligCode==null}">
                                                    <f:selectItem itemLabel="Sélectionnez une famille" itemValue="0"/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamillesAchatsUtilItems}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculFamille}" reRender="panelLignePapier,panelLignePapier2,idLibelle,idDouane,idTaxe,idDepot"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Pos. Douane" style="text-decoration:underline;"/><br>
                                                <h:inputText tabindex="3" id="idDouane" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligDouane}" maxlength="20" style="width:100px;">
                                                    <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / * = Recherche toutes les positions tarifaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.rechercheDouane}" reRender="panelDouane,panelListeDouane,formModalListeDouane,idDouane"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Mode" /><br>
                                                <h:selectOneMenu tabindex="4" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier}" style="width:90px;">
                                                    <f:selectItem itemLabel="Format" itemValue="0"/>
                                                    <f:selectItem itemLabel="Largeur (laize)" itemValue="1"/>
                                                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculMode}" reRender="panelLigne0"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier<=1}">
                                                <h:outputText value="Grs (cm)"/><br>
                                                <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligGr}" style="width:70px;text-align:right;">
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculLibelle}" reRender="idLibelle"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier<=1}">
                                                <h:outputText value="Couleur" /><br>
                                                <h:selectOneMenu tabindex="6" id="idCouleur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligCouleur}" style="width:90px;">
                                                    <f:selectItem itemLabel="Blanc" itemValue="Blanc"/>
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCouleursItems}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculLibelle}" reRender="idLibelle"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier==1}">
                                                <h:outputText value="Laize (cm)"/><br>
                                                <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligLarg}" style="width:70px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculLibelle}" reRender="idLibelle"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier==0}">
                                                <h:outputText value="Haut.(cm)"/><br>
                                                <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligHaut}" style="width:70px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculLibelle}" reRender="idLibelle"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligModePapier==0}">
                                                <h:outputText value="Long.(cm)"/><br>
                                                <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligLong}" style="width:70px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculLibelle}" reRender="idLibelle"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column>
                                                <h:outputText value="Libellé"/><br>
                                                <h:inputText id="idLibelle" tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligLibelle}" disabled="true" style="width:100%"/>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid columns="8" width="100%" id="panelLignePapier2">
                                            <h:panelGroup>
                                                <h:outputText value="Stock" />
                                                <h:selectOneMenu id="idDepot" tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligDepot}" style="width:150px;">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotPrdCodeItems}"/>
                                                </h:selectOneMenu>
                                            </h:panelGroup>
                                            <h:panelGroup>
                                                <h:outputText value="Poids net (kg)"/>
                                                <h:inputText tabindex="12" id="idPoids" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligPoidsNet}" style="width:100px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculQtePapier}" reRender="idQte"/>
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:panelGroup>
                                                <h:outputText value="Qte/Feuilles"/>
                                                <h:inputText tabindex="13" id="idQte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligQte}" style="width:90px;text-align:right;" onkeypress="return scanToucheChiffre(event)">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionAchats.nbDecQte}"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculQtePapier}" reRender="idPoids"/>
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:panelGroup id="panelPump" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                                <h:outputText value="PUMP"/>
                                                <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsGeneres.fabligPump}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.verrouPump}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:inputText>
                                            </h:panelGroup>
                                            <h:panelGroup>
                                                <a4j:commandButton  tabindex="15" image="/images/valider_big.png" id="idValLigneFabrique" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.saveOneLigneGeneres}" reRender="panelPage,panelTotal,idPanProduit" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.validationLigne<=1}"/>
                                            </h:panelGroup>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" id="tableLigneFabrique" enableContextMenu="false" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelGeneres}" var="gene">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLigneGeneres}" reRender="panelLignePapier"/>
                                            <rich:column label="Code produit" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{gene.fabligCode}"/>
                                            </rich:column>
                                            <rich:column label="Famille produit" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                                <h:outputText value="#{gene.codeFamille}"/>
                                            </rich:column>
                                            <rich:column label="Position tarifaire" sortable="false" width="8%" >
                                                <f:facet name="header"><h:outputText  value="Douane"/></f:facet>
                                                <h:outputText value="#{gene.fabligDouane}"/>
                                            </rich:column>
                                            <rich:column label="Libellé produit" sortable="false" width="17%" >
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{gene.fabligLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Grammage" sortable="false" width="5%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Grs"/></f:facet>
                                                <h:outputText value="#{gene.fabligGr}" rendered="#{gene.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Couleur" sortable="false" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Coul."/></f:facet>
                                                <h:outputText value="#{gene.fabligCouleur}" rendered="#{gene.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Format" sortable="false" width="7%" >
                                                <f:facet name="header"><h:outputText  value="Format"/></f:facet>
                                                <h:outputText value="#{gene.format}" rendered="#{gene.fabligModePapier<=1}"/>
                                            </rich:column>
                                            <rich:column label="Code dépôt" sortable="false" width="5%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText value="#{gene.fabligDepot}"/>
                                            </rich:column>
                                            <rich:column label="Poids net (Kgr)" sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Poids net"/></f:facet>
                                                <h:outputText value="#{gene.fabligPoidsNet}" />
                                            </rich:column>
                                            <rich:column label="Quantité" sortable="false" style="text-align:right" width="7%" >
                                                <f:facet name="header"><h:outputText  value="Qté/F"/></f:facet>
                                                <h:outputText value="#{gene.fabligQte}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formReceptionAchats.optionAchats.nbDecQte}"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Pump" sortable="false" style="text-align:right" width="7%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                                <f:facet name="header"><h:outputText  value="Pump"/></f:facet>
                                                <h:outputText value="#{gene.fabligPump}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>
                        </rich:tabPanel>

                    </rich:tab>

                    <rich:tab label="Déchets" id="tabDechet" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_document}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletDechet}" reRender="idPanDechets"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid width="100%" id="idPanDechets">
                            <h:panelGrid width="100%" id="panelLigne3" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_mod}">
                                <h:panelGrid  columns="8" width="100%" id="panelLigneDechets">
                                    <h:column>
                                        <h:outputText value="Code"/><br/>
                                        <h:inputText tabindex="1" id="inpCodDetDechets" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligCode}" disabled="true"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/><br/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligLibelle}" disabled="true" style="width:100%"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Qte réf.:"/><br/>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligQteReference}" disabled="true" style="text-align:right;width:100px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.nbDecQteProd}"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup>
                                        <h:outputText value="Qte.déchet.:"/><br/>
                                        <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligQte}" style="width:90px;text-align:right;">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPrixDechets}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                        <h:outputText value="PUMP:"/><br/>
                                        <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.verrouPump}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPrixDechets}" reRender="panelPt" />
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column>
                                        <h:outputText value="Observation"/><br/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsDechets.fabligObs}" maxlength="50"/>
                                    </h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="10" image="/images/valider_big.png" id="idValLigneDechets" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.saveOneLigneDechet}" reRender="panelPage,panelTotal,panelLigneDechets,tableLigneDechets,panelBoutonDechets"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableDechets" maxPages="20"align="left" for="tableLigneDechets"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" id="tableLigneDechets" enableContextMenu="false" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelDechets}" var="Dechets">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLigneDechet}" reRender="panelLigneDechets,panelBoutonDechets"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{Dechets.fabligCode}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="25%">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligLibelle}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligDepot}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligQteReference}" rendered="#{Dechets.fabligQteReference!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.nbDecQteProd}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.nbDecQteProd}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right" width="10%" >
                                        <f:facet name="header"><h:outputText  value="Quantité"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligQte}" rendered="#{Dechets.fabligQte!=0}">
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="5%">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligUnite}"/>
                                    </rich:column>
                                    <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                        <f:facet name="header"><h:outputText value="Total PUMP"  /></f:facet>
                                        <h:outputText value="#{Dechets.fabligTotal}" rendered="#{Dechets.fabligTotal!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="Observation"/></f:facet>
                                        <h:outputText value="#{Dechets.fabligObs}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Taches" id="tabTache" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_document}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletTache}" reRender="idPanTaches"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid width="100%" id="idPanTaches">
                            <h:panelGroup id="panelBoutonTaches" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabMode==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle tache" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_ajt}" reRender="panelLigneTaches,panelBoutonTaches"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la tache en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.deleteLigneTache}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigneTaches,tableLigneTaches,panelBoutonTaches"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne4" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_mod}">
                                <h:panelGrid  columns="9" width="100%" id="panelLigneTaches">
                                    <h:column>
                                        <h:outputText value="Code"/><br/>
                                        <h:inputText tabindex="1" id="inpCodDetTaches" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.griserchamps}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.rechercheTaches}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTaches,formModalListeTaches,inpCodDetTaches,panelLigneTaches"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé"/><br/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligLibelle}" disabled="true" style="width:100%"/>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Nb Jour(s)"/><br/>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligQteReference}" disabled="true" style="text-align:right;width:100px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Nb Heure(s)"/><br/>
                                        <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligQteStock}" disabled="true" style="color:red;text-align:right;width:100px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup>
                                        <h:outputText value="Nb Minute(s)"/><br/>
                                        <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligQte}" style="width:90px;text-align:right;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column>
                                        <h:outputText value="Nb Seconde(s)"/><br/>
                                        <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligQteStock}" disabled="true" style="color:red;text-align:right;width:100px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPrixTaches}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
                                        <h:outputText value="PUMP"/><br/>
                                        <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.verrouPump}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPrix}" reRender="panelPt" />
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column>
                                        <h:outputText value="Observation"/><br/>
                                        <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationLigneAchatsTaches.fabligObs}" maxlength="50"/>
                                    </h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton  tabindex="10" image="/images/valider_big.png" id="idValLigneTaches" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.saveOneLigneTache}" reRender="panelPage,panelTotal,panelLigneTaches,tableLigneTaches,panelBoutonTaches"/>
                                        <rich:hotKey key="return" handler="#{rich:element('idValLigne')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableTaches" maxPages="20"align="left" for="tableLigneTaches"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" id="tableLigneTaches" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelTaches}" var="ta">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLigneDechets}" reRender="panelLigneTaches,panelBoutonTaches"/>
                                    <rich:column style="text-align:left;" width="10%">
                                        <f:facet name="header"><h:outputText  value="Code tache"/></f:facet>
                                        <h:outputText  value="#{ta.fabligCode}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="40%">
                                        <f:facet name="header"><h:outputText  value="Libellé tache"/></f:facet>
                                        <h:outputText  value="#{ta.fabligLibelle}"/>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="10%">
                                        <f:facet name="header"><h:outputText  value="P.R. HT"/></f:facet>
                                        <h:outputText  value="#{ta.fabligPump}" rendered="#{ta.fabligPump!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText  value="JJ"/></f:facet>
                                        <h:outputText  value="#{ta.fabligJj}" rendered="#{ta.fabligJj!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText  value="HH"/></f:facet>
                                        <h:outputText  value="#{ta.fabligHh}" rendered="#{ta.fabligHh!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText  value="MM"/></f:facet>
                                        <h:outputText  value="#{ta.fabligMm}" rendered="#{ta.fabligMm!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="5%">
                                        <f:facet name="header"><h:outputText  value="SS"/></f:facet>
                                        <h:outputText  value="#{ta.fabligSs}" rendered="#{ta.fabligSs!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Equipe" id="tabEquipe" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_complement}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletEquipe}" reRender="idPanEquipes"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                    </rich:tab>

                    <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_imputation}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletImputation}" reRender="idPanImputation"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" id="idPanImputation">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabSite}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Ligne:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabLigne}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Atelier:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabAtelier}" readonly="true"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_activite&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_complement}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletComplement}" reRender="idPanComplement"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%" id="idPanComplement">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.optionStocks.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Date impression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateImp}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Commande" id="tabCommande" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_commande}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.typeOngletCommande}" reRender="idPanCommande"/>
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <a4j:region renderRegionOnly="false" id="idPanCommande">
                            <rich:extendedDataTable height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelLigneCommande}" var="doclig">
                                <rich:column sortable="false" width="15%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.bcmligCode}" style="#{doclig.styleLigne}"/>&nbsp;&nbsp;
                                    <h:outputText value="PROCESS" style="color:red;#{doclig.styleLigne}" rendered="#{doclig.bcmligProcess==1}"/>
                                </rich:column>
                                <rich:column sortable="false" width="60%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.bcmligLibelle}" style="#{doclig.styleLigne}"/><br>
                                    <h:outputText value="#{doclig.bcmligComplement}" rendered="#{doclig.bcmligComplement!=null}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="5%" >
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText value="#{doclig.bcmligDepot}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                    <h:outputText value="#{doclig.bcmligQte}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_habilitation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.autorisationHabilitation}">
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser1Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser2Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser3Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser5Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser6Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.utilParapheur.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.autorisationEtat}">
                        <jsp:include flush="true" page="/stock/ProductionCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID FABRICATION:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                    <f:selectItem itemLabel="Correction" itemValue="6"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du dépôt sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

</f:subview>
