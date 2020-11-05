<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="demandeliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center><h2><h:outputText value="GESTION DES DEMANDES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="Client"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpClient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Types" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesTypesDemandestems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="16" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search}">&nbsp;&nbsp;
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable=='1'}">
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpCommercial}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_anal_dossier}">
                        <h:outputText value="Dossier:"/>&nbsp;&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <a4j:commandButton title="Recherche sur client sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                    <a4j:commandButton title="Recherche sur destinataire sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpNomDestinataire}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.executerRequeteDestinataire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.decrmtPrsChrStock=='2'}"/>
                </h:panelGrid>
                <h:panelGrid id="panDest2" columns="6" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_more_search}">
                    <h:column>
                        <h:selectOneMenu id="idRegion" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpRegion}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Régions" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesRegionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerLesSecteurs}" reRender="panDest2,idSeceurRec,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idSeceurRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpSecteur}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Secteurs" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesSecteursItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerLesPdv}" reRender="panDest2,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPdvRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpPdv}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Points de vente" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesPdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idSite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpSite}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Sites" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerLesDepartements}" reRender="panDest2,idDepartementRec,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idDepartementRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpDepartement}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Départements" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesDepartementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.chargerLesServices}" reRender="panDest2,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesServicesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}">
                        <h:outputText value="Service:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrService}" style="width:300px;" readonly="true" disabled="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="15" width="500px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==6)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.supprimerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Geler le document sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.sup}" onclick="if (!confirm('Etes-vous sur de vouloir geler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.gelerDocument}" reRender="panelGeler,formGeler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.initGrapheur}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° devis" sortable="true" sortBy="#{var.fondemNum}">
                            <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                            <h:outputText value="#{var.fondemNum}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.fondemPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.fondemPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.habilitation.habNombre}" style="text-align:center;#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="N° Affaire" sortable="true" sortBy="#{var.fondemAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.accesAffaires}">
                            <f:facet name="header"><h:outputText  value="N° AFF." /></f:facet>
                            <h:outputText value="#{var.fondemAnal4}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Date demande" sortable="true" sortBy="#{var.fondemDate} #{var.fondemNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{var.fondemDate}" style="#{var.devisVip}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.fondemSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S."/></f:facet>
                            <h:outputText value="#{var.fondemSerie}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Catégorie demandeur" sortable="true" sortBy="#{var.fondemCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                            <h:outputText value="#{var.fondemCat}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.fondemEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{var.libelleEta}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menufondation.trf}">
                            <f:facet name="header"><h:outputText  value="Trf."/></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.fondemEtat==1||var.fondemEtat==4)&&var.fondemSerie!='X'}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Type de demande" sortable="true" sortBy="#{var.libelleType}" width="100px">
                            <f:facet name="header"><h:outputText  value="Type dem."/></f:facet>
                            <h:outputText  value="#{var.libelleType}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Demandeur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Demandeur"/></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Contact " sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                            <f:facet name="header"><h:outputText  value="Contact" style="#{var.devisVip}"/></f:facet>
                            <h:outputText  value="#{var.var_nomContact}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Montant Demandé" sortable="true" sortBy="#{var.fondemTotDemande}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="M.Demandé"/></f:facet>
                            <h:outputText  value="#{var.fondemTotDemande}" rendered="#{var.fondemTotDemande!=0}" style="#{var.devisVip}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant Accordé" sortable="true" sortBy="#{var.fondemTotAccorde}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="M.Accordé"/></f:facet>
                            <h:outputText  value="#{var.fondemTotAccorde}" rendered="#{var.fondemTotAccorde!=0}" style="#{var.devisVip}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.fondemActivite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.accesAffaires}">
                            <f:facet name="header"><h:outputText value="Act."/></f:facet>
                            <h:outputText  value="#{var.fondemActivite}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Source" sortable="true" sortBy="#{var.fondemSource}" >
                            <f:facet name="header"><h:outputText value="Source"/></f:facet>
                            <h:outputText  value="#{var.fondemSource}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Objet de la demande" sortable="true" sortBy="#{var.fondemObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.fondemObject}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Date de relance" sortable="true" sortBy="#{var.fondemDateRelance}" width="70px" >
                            <f:facet name="header"><h:outputText value="Rela."/></f:facet>
                            <h:outputText  value="#{var.fondemDateRelance}" style="#{var.devisVip}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.fondemNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.fondemNomResponsable}" style="#{var.devisVip}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.fondemNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                            <h:outputText  value="#{var.fondemNomCommercial}" style="#{var.devisVip}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <h:panelGroup>
                <center>
                    <br>
                    <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Suivi Standard" style="color:#000000;"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText value="Suivi V.I.P." style="color:#0000FF"/>&nbsp;&nbsp;&nbsp;
                </center>
            </h:panelGroup>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 0px black;background-color:white" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <rich:hotKey key="return" handler="return false;"/>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <f:selectItem itemLabel="En quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par commercial" itemValue="2"/>
                                <f:selectItem itemLabel="par équipe" itemValue="3"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par source" itemValue="7"/>
                                <f:selectItem itemLabel="par affaire" itemValue="8"/>
                                <f:selectItem itemLabel="par région" itemValue="9"/>
                                <f:selectItem itemLabel="par secteur" itemValue="10"/>
                                <f:selectItem itemLabel="par point de vente" itemValue="11"/>
                                <f:selectItem itemLabel="par site" itemValue="12"/>
                                <f:selectItem itemLabel="par département" itemValue="13"/>
                                <f:selectItem itemLabel="par service" itemValue="14"/>
                                <f:selectItem itemLabel="par série" itemValue="15"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelImput}" var="ser">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>
                

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 0px black;background-color:white" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Devis"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGeler" width="400" height="250" headerClass="headerPanel" style="border:solid 0px black;background-color:white" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelGele}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.showModalPanelGele}" var="gel">
            <f:facet name="header"><h:outputText value="Gèle le Devis"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.annuleGeler}" image="/images/close.gif" styleClass="hidelink" reRender="panelGeler"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formGeler">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date du gel:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif du gel:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.miseajourGeler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
