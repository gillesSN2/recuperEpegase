<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="inventairefiche">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES INVENTAIRES" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Inventaire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.autorisationDocument}">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
                            <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos30g,clos5d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:panelGrid width="100%" columns="4">
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateStk==0}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers,link8Ajt,idEcheance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.controleSaisie}"/>
                                        </rich:calendar>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                                        </h:selectOneMenu>
                                        <h:column><h:outputText value=":"/></h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" style="width:45px">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                                        </h:selectOneMenu>
                                    </h:panelGrid>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idSerie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId!=0}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Dépôt:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" id="idDepot" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_depot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Dépôt" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.afficheValide}" reRender="panelPage,panelGlobal,tabDoc,panelDepot,idSerie,panelValide,panelBoutonLigne,panelLigne" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idResponsable" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action)==true}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesResponsablesItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelDepot" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Mode inventaire:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                            <f:selectItem itemLabel="Inventaire simple" itemValue="0"/>
                                            <f:selectItem itemLabel="Sur dépôt" itemValue="1"/>
                                            <f:selectItem itemLabel="Sur casier" itemValue="2"/>
                                            <f:selectItem itemLabel="Sur famille produit" itemValue="3"/>
                                            <f:selectItem itemLabel="Sur stock négatif" itemValue="4"/>
                                            <f:selectItem itemLabel="Sur Importation" itemValue="5"/>
                                            <f:selectItem itemLabel="Complément sur N° inventaire" itemValue="6"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.afficheFiltre}" reRender="panelPage,panelGlobal,tabDoc,panelDepot,idFiltre2,idFiltre3,idFiltre4,idFiltre5,idFiltre6,tableLigne,upload1,modAttente" onsubmit="javascript:Richfaces.showModalPanel('modAttente');"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column id="idFiltre2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==2}"><h:outputText value="Casier:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column id="idFiltre3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==3}"><h:outputText value="Code famille:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column id="idFiltre4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==6}"><h:outputText value="N° inventaire référence:" style="text-decoration:underline;width:100%"/></h:column>
                                    <h:column id="idFiltre5" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==5)}">
                                        <rich:fileUpload id="upload1" acceptedTypes="csv,CSV" ajaxSingle="false" progressLabel="true" addControlLabel="Ajouter fichier" uploadControlLabel="Importer" autoclear="true" noDuplicate="true" immediateUpload="false" maxFilesQuantity="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.uploadsAvailable}" listHeight="80px" listWidth="300px" fileUploadListener="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.listener}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==5}">
                                            <a4j:support event="onuploadcomplete" reRender="panelPage,panelGlobal,tabDoc,panelDepot,tableLigne,upload1,tableLigne,scrollTable"/>
                                        </rich:fileUpload>
                                    </h:column>
                                    <h:column id="idFiltre6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==6}">
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invModeSpecif}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId!=0}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==6}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.modeAjout}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPage,panelGlobal,tabDoc,panelPage,tableLigne,scrollTable" />
                                        </h:inputText>
                                        <h:commandButton style="width:100%" value="Vérif. produit/dépot" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.verifProduitDepot}" onclick="if (!confirm('Etes-vous sur de vouloir charger les produits concernés ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==1}"/>
                                    </h:column>
                                    <h:column><h:outputText value="Type inventaire:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                            <f:selectItem itemLabel="Prioritaire" itemValue="0"/>
                                            <f:selectItem itemLabel="Correctif" itemValue="1" itemDisabled="true"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid  id="panelTotal" width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Valorisation:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invTotPump}" style="text-align:right;width:100%"  readonly="true" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Nombre produits:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_nb_produit}" style="text-align:right;width:100%"  readonly="true" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid width="100%">
                            <h:panelGroup id="panelBoutonLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle ligne" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.addLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_ajt}" reRender="panelLigne,panelBoutonLigne"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton image="/images/supprimer.png" title="Supprimer la ligne en cours" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.deleteLigneSelect}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelTotal,panelLigne,tableLigne,panelBoutonLigne"/>
                            </h:panelGroup>
                            <h:panelGrid width="100%" id="panelLigne" style="border:1px solid green;background-color:#FFF8D4;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_mod}">
                                <h:panelGrid  columns="4" width="100%" id="panelLigne1" columnClasses="clos15g,clos5c,clos10g,clos70d">
                                    <h:column>
                                        <h:outputText value="Code:" style="text-decoration:underline"/>
                                        <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligCode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.griserchamps}">
                                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduits,formModalListeProduits,idDepot,inpCodDet,panelLigne"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column>
                                        <a4j:commandButton  tabindex="2" style="height:15px;width:15px" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.detailProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_detail_prod}" reRender="idSubView,formModalDetailProd,panelDetailProd"></a4j:commandButton>
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Référence:"/>
                                        <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligReference}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.griserchamps}" />
                                    </h:column>
                                    <h:column>
                                        <h:outputText value="Libellé:"/>
                                        <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLibelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.griserchamps}" style="width:100%" readonly="true"/>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="8" width="100%" id="panelLigne2">
                                    <h:column>
                                        <h:outputText value="Casier:"/>
                                        <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligCasier}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.griserchamps}" />
                                    </h:column>                                 
                                    <h:panelGroup id="panelUnite">
                                        <h:outputText value="Unité:" style="text-decoration:underline"/>
                                        <h:selectOneMenu tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligUnite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.griserchamps}" style="width:80px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.mesUnitesProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.extractCodeUnite}" reRender="panelUnite,panelLigne2"/>
                                        </h:selectOneMenu>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=100&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=199}">
                                            <br>
                                            <h:outputText value="(L."/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLong}" style="width:90px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=200&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=299}">
                                            <br>
                                            <h:outputText value="(L."/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLong}" style="width:70px;text-align:right;"/>
                                            <h:outputText value="l."/>
                                            <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLarg}" style="width:70px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=300&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=399}">
                                            <br>
                                            <h:outputText value="(L."/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLong}" style="width:60px;text-align:right;"/>
                                            <h:outputText value="l."/>
                                            <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLarg}" style="width:60px;text-align:right;"/>
                                            <h:outputText value="H."/>
                                            <h:inputText tabindex="9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligHaut}" style="width:60px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=400&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=499}">
                                            <br>
                                            <h:outputText value="(L."/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLong}" style="width:70px;text-align:right;"/>
                                            <h:outputText value="D."/>
                                            <h:inputText tabindex="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligLarg}" style="width:70px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=800&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=849}">
                                            <br>
                                            <h:outputText value="(Nb"/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligNb}" style="width:90px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite>=850&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_code_unite<=899}">
                                            <br>
                                            <h:outputText value="(P."/>
                                            <h:inputText tabindex="7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligNb}" style="width:90px;text-align:right;"/>
                                            <h:outputText value=")"/>
                                        </h:panelGroup>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_condit}">
                                        <h:outputText value="Cdt.:"/>
                                        <h:selectOneMenu tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligCondition}" style="width:100px;">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.mesConditionnementsProduits}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.calculPrix}" reRender="panelLigne2,panelPu,panelPt"/>
                                        </h:selectOneMenu>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="Qte:"/>
                                        <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligQte}" style="width:90px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligValide}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionAchats.nbDecQte}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.calculPrix}" reRender="panelPt"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.affichagePump}">
                                        <h:outputText value="PUMP:"/>
                                        <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligPump}" style="width:100px;text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.verrouPump}" >
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.calculPrix}" reRender="panelPt" />
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:panelGroup id="panelPt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.affichagePump}">
                                        <h:outputText value="Total PUMP:"/>
                                        <h:inputText tabindex="13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligTotal}" disabled="true" style="width:100px;text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:inputText>
                                    </h:panelGroup>
                                    <h:column>
                                        <h:outputText value="Observation:"/>
                                        <h:inputText tabindex="14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireLigne.invligObs}" maxlength="50"/>
                                    </h:column>
                                    <h:panelGroup>
                                        <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==0}" tabindex="15" image="/images/valider_big.png" id="idValLigne1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.saveOneLigne}" reRender="panelPage,panelTotal,panelLigne,panelLigne2,tableLigne,panelBoutonLigne"/>
                                        <rich:hotKey rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode==0}" key="return" handler="#{rich:element('idValLigne1')}.click()" />
                                        <a4j:commandButton rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode!=0}" tabindex="15" image="/images/valider_big.png" id="idValLigne2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.saveOneLigne}" reRender="panelTotal,panelLigne,panelLigne2,panelBoutonLigne,idS01,idS02,idS03,idS04,idS05,idS06,idS07,idS08,idS09,idS10"/>
                                        <rich:hotKey rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMode!=0}" key="return" handler="#{rich:element('idValLigne2')}.click()" />
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableLigne"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_nb_max}" id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.datamodelLigne}" var="doclig">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                    <rich:column id="idS01" sortable="true" width="9%" sortBy="#{doclig.invligFamille} #{doclig.invligCode}">
                                        <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                        <h:outputText  value="#{doclig.invligFamille}"/>
                                    </rich:column>
                                    <rich:column id="idS02" sortable="true" width="14%" sortBy="#{doclig.invligCode}">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{doclig.invligCode}"/>
                                    </rich:column>
                                    <rich:column id="idS03" sortable="true" width="27%" sortBy="#{doclig.invligLibelle}">
                                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                        <h:outputText value="#{doclig.invligLibelle}"/>
                                    </rich:column>
                                    <rich:column id="idS04" sortable="true" width="5%" sortBy="#{doclig.invligReference}">
                                        <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                        <h:outputText value="#{doclig.invligReference}"/>
                                    </rich:column>
                                    <rich:column id="idS05" sortable="true" width="5%" sortBy="#{doclig.invligCasier}">
                                        <f:facet name="header"><h:outputText  value="Casier"/></f:facet>
                                        <h:outputText value="#{doclig.invligCasier}"/>
                                    </rich:column>
                                    <rich:column id="idS06" sortable="true" style="text-align:right" width="10%" sortBy="#{doclig.invligQte}">
                                        <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                        <h:outputText value="#{doclig.invligQte}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionAchats.nbDecQte}"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="6%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionAchats.modeCalculDevis=='1'}">
                                        <f:facet name="header"><h:outputText  value="Lg"/></f:facet>
                                        <h:outputText value="#{doclig.invligLong}" rendered="#{doclig.invligLong!=0}"/>
                                    </rich:column>
                                    <rich:column id="idS07" sortable="true" width="10%" sortBy="#{doclig.invligUnite}">
                                        <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                        <h:outputText value="#{doclig.invligUnite}"/>
                                    </rich:column>
                                    <rich:column id="idS08" sortable="true" width="20%" sortBy="#{doclig.invligCondition}">
                                        <f:facet name="header"><h:outputText  value="Condit."/></f:facet>
                                        <h:outputText value="#{doclig.invligCondition}"/>
                                    </rich:column>
                                    <rich:column id="idS09" sortable="true" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.affichagePump}" sortBy="#{doclig.invligPump}">
                                        <f:facet name="header"><h:outputText value="PUMP"  /></f:facet>
                                        <h:outputText value="#{doclig.invligPump}" rendered="#{doclig.invligPump!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column id="idS10" sortable="true" style="text-align:right;" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.affichagePump}" sortBy="#{doclig.invligTotal}">
                                        <f:facet name="header"><h:outputText value="Total PUMP"  /></f:facet>
                                        <h:outputText value="#{doclig.invligTotal}" rendered="#{doclig.invligTotal!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Imputations" id="tabImput" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_imputation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.autorisationImputation}">
                        <jsp:include flush="true" page="/stock/InventaireCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Site:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invSite}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Département:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDepartement}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invService}" readonly="true"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Région:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invRegion}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Secteur:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invSecteur}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Point de vente:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invPdv}" readonly="true"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_anal_activite}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_anal_activite&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invActivite}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_anal_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="250px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="23%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="10%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.calculPourcentage}" reRender="idRepartitionAnal" focus="idRepartitionAnal"/>
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Montant"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                            <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Complément" id="tabComplement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_complement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.autorisationComplement}">
                        <jsp:include flush="true" page="/stock/InventaireCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.optionStocks.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%" >
                            <h:column><h:outputText value="Date impression:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateImp}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Modèle impression" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.documentImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Vérification" id="tabVerification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_verification}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.autorisationVerification}">
                        <jsp:include flush="true" page="/stock/InventaireCommun.jsp" />
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigneVerif" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.datamodelLigne}" var="doclig">
                                <rich:column sortable="false" width="8%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText  value="#{doclig.invligCode}"/>
                                </rich:column>
                                <rich:column sortable="false" width="27%">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{doclig.invligLibelle}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Référence"/></f:facet>
                                    <h:outputText value="#{doclig.invligReference}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Casier"/></f:facet>
                                    <h:outputText value="#{doclig.invligCasier}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:center" width="5%">
                                    <f:facet name="header"><h:outputText  value="Vérification"/></f:facet>
                                    <h:selectBooleanCheckbox value="#{doclig.invligValide}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Qté Saisie"/></f:facet>
                                    <h:outputText value="#{doclig.invligQte}" />
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                    <h:outputText value="#{doclig.var_lib_uni_condit}"/>
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Stk Av. Inv."/></f:facet>
                                    <h:outputText value="#{doclig.invligQteStock}" />
                                </rich:column>
                                <rich:column sortable="false" style="text-align:right" width="10%" >
                                    <f:facet name="header"><h:outputText  value="Ecart"/></f:facet>
                                    <h:outputText value="#{doclig.var_ecart}" />
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_habilitation}">
                        <jsp:include flush="true" page="/stock/InventaireCommun.jsp" />
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser1Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser2Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser3Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser5Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser6Nom!=null}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.utilParapheur.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.autorisationEtat}">
                        <jsp:include flush="true" page="/stock/InventaireCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID INVENTAIRE:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invEtat}" disabled="true">
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
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.inventaireEntete.invMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du dépôt sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formInventaire.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

</f:subview>
