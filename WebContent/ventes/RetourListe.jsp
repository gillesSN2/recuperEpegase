<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="retourliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES BONS DE RETOUR" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="Client"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpClient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="18" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search}">
                    <h:column><h:outputText value="N° BCC"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpNumBCC}" size="7"/></h:column>
                    <h:column><h:outputText value="N° Anal."/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpNumAnal}" size="7"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.contDest=='true'}">
                        <h:outputText value="Destinataire:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpDestinataire}" size="10" >
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeDestinataire,formModalListeDestinataire"/>
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.responsable=='1'}">
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpCommercial}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_parc}">
                        <h:outputText value="Parc:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpParc}" style="width:150px;"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_contener_parc}">
                        <h:outputText value="Contener:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpContener}" style="width:150px;"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_dossier}">
                        <h:outputText value="Dossier:" />&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <a4j:commandButton title="Recherche sur client sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                    <a4j:commandButton title="Recherche sur destinataire sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpNomDestinataire}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.executerRequeteDestinataire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.decrmtPrsChrStock=='2'}"/>
                </h:panelGrid>
                <h:panelGrid id="panDest2" columns="6" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_more_search}">
                    <h:column>
                        <h:selectOneMenu id="idRegion" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpRegion}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Régions" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesRegionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.chargerLesSecteurs}" reRender="panDest2,idSeceurRec,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idSeceurRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpSecteur}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Secteurs" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesSecteursItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.chargerLesPdv}" reRender="panDest2,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPdvRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpPdv}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Points de vente" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesPdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idSite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpSite}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Sites" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.chargerLesDepartements}" reRender="panDest2,idDepartementRec,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idDepartementRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpDepartement}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Départements" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesDepartementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.chargerLesServices}" reRender="panDest2,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesServicesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}">
                        <h:outputText value="Service:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrService}" style="width:300px;" readonly="true" disabled="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="11" width="450px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.initGrapheur}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° retour" sortable="true" sortBy="#{var.brtNum}">
                            <f:facet name="header"><h:outputText  value="N° RETOUR" /></f:facet>
                            <h:outputText value="#{var.brtNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.brtPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.brtPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="N° Affaire/Dossier" sortable="true" sortBy="#{var.brtAffaire} #{var.brtAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.accesAffaires}">
                            <f:facet name="header"><h:outputText  value="N° AFF." /></f:facet>
                            <h:outputText value="#{var.brtAffaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.axeDossier=='2'}"/>
                            <h:outputText value="#{var.brtAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.axeDossier!='2'}"/>
                        </rich:column>
                        <rich:column label="N° Analytique" sortable="true" sortBy="#{var.brtAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.accesAffaires&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.axeDossier=='2'}">
                            <f:facet name="header"><h:outputText  value="N° ANAL." /></f:facet>
                            <h:outputText value="#{var.brtAnal4}"/>
                        </rich:column>
                        <rich:column label="Date bon livraison" sortable="true" sortBy="#{var.brtDate} #{var.brtNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.brtDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.brtSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.brtSerie}"/>
                        </rich:column>
                        <rich:column label="Catégorie client" sortable="true" sortBy="#{var.brtCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                            <h:outputText value="#{var.brtCat}"/>
                        </rich:column>
                        <rich:column label="N° avoir" sortable="true" sortBy="#{var.brtNumAvoir}">
                            <f:facet name="header"><h:outputText  value="N° Avr." /></f:facet>
                            <h:outputText value="#{var.brtNumAvoir}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.brtEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.brtEtat==1||var.brtEtat==4)&&var.brtSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_libcondest}"/></f:facet>
                            <h:outputText  value="#{var.var_nomContact}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.brtTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.brtTotHt}" rendered="#{var.brtTotHt!=0}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant de la TVA" sortable="true" sortBy="#{var.brtTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="TVA"/></f:facet>
                            <h:outputText  value="#{var.brtTotTva}" rendered="#{var.brtTotTva!=0}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes complémentaires" sortable="true" sortBy="#{var.brtTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_tc_type!=0}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_tc_libelle}"/></f:facet>
                            <h:outputText  value="#{var.brtTotTc}" rendered="#{var.brtTotTc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.brtActivite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.accesAffaires}">
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.brtActivite}"/>
                        </rich:column>
                        <rich:column label="Source" sortable="true" sortBy="#{var.brtSource}" >
                            <f:facet name="header"><h:outputText value="Source"  /></f:facet>
                            <h:outputText  value="#{var.brtSource}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.brtAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Prc."  /></f:facet>
                            <h:outputText  value="#{var.brtAnal2}"/>
                        </rich:column>
                        <rich:column label="Objet du retour" sortable="true" sortBy="#{var.brtObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.brtObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.brtDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.brtDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.brtNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.brtNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.brtNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.brtNomCommercial}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="../commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <f:selectItem itemLabel="En quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par commercial" itemValue="2"/>
                                <f:selectItem itemLabel="par équipe" itemValue="3"/>
                                <f:selectItem itemLabel="par société" itemValue="4"/>
                                <f:selectItem itemLabel="par famille produit" itemValue="5"/>
                                <f:selectItem itemLabel="par produit" itemValue="6"/>
                                <f:selectItem itemLabel="par source" itemValue="7"/>
                                <f:selectItem itemLabel="par affaire" itemValue="8"/>
                                <f:selectItem itemLabel="par région" itemValue="9"/>
                                <f:selectItem itemLabel="par secteur" itemValue="10"/>
                                <f:selectItem itemLabel="par point de vente" itemValue="11"/>
                                <f:selectItem itemLabel="par site" itemValue="12"/>
                                <f:selectItem itemLabel="par département" itemValue="13"/>
                                <f:selectItem itemLabel="par service" itemValue="14"/>
                                <f:selectItem itemLabel="par série" itemValue="15"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModele}">
                            <jsp:include flush="true" page="../commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_choix==1}">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelTrf}" var="anl">
            <f:facet name="header"><h:outputText value="Transformation du retour en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf4,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="7" style="width:100%;background-color:#DAEECB;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_aff_trf}">
                        <h:column><h:outputText id="trf2" value="Date:"/></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_date_trf}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_heure}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_minute}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="trf4" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_mode_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_serie_trf}" style="width:80px;">
                                <f:selectItem itemLabel="Série Défaut" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_modele_trf}" style="width:120px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.qteTrfQteOrg}" reRender="tabletrf,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.razQteTrf}" reRender="tabletrf"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.datamodelTransfert}" var="trf">
                            <rich:column label="N° devis" sortable="false" sortBy="#{trf.retourEnteteVentes.brtNum}" sortOrder="ASCENDING" width="10%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.retourEnteteVentes.brtNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.retourEnteteVentes.brtDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.retourEnteteVentes.brtSerie}"/>
                            </rich:column>
                            <rich:column label="Client" sortable="false" width="14%">
                                <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                <h:outputText  value="#{trf.retourEnteteVentes.brtNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                <h:outputText  value="#{trf.brtligCode}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.brtligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="12%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.brtligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="12%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" width="12%">
                                <f:facet name="header"><h:outputText  value="Qte.Reste" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.var_aff_trf}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Retour"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.retourEnteteVentes.brtMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formRetourVentes.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
