<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="blliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES BONS DE LIVRAISON" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search}"/>
                    <h:column><h:outputText value="N°"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="Client"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpClient}" size="10"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpCat}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesEtatsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelBouton,idAllSelect"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="18" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search}">
                    <h:column><h:outputText value="N° BCC"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpNumBCC}" size="7"/></h:column>
                    <h:column><h:outputText value="N° Anal."/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpNumAnal}" size="7"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.contDest=='true'}">
                        <h:outputText value="Destinataire:" style="text-decoration:underline;" />&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpDestinataire}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les destinataires" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheDestinataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeDestinataire,formModalListeDestinataire"/>
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable=='1'}">
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpCommercial}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_parc}">
                        <h:outputText value="Parc:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpParc}" style="width:150px;"/>
                    </h:column>
                     <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_contener_parc}">
                        <h:outputText value="Contener:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpContener}" style="width:150px;"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_dossier}">
                        <h:outputText value="Dossier:" />&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <a4j:commandButton title="Recherche sur client sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpNomTiersEnCours}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.executerRequeteTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                    <a4j:commandButton title="Recherche sur destinataire sélectionné" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpNomDestinataire}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.executerRequeteDestinataire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.decrmtPrsChrStock=='2'}"/>
                </h:panelGrid>
                <h:panelGrid id="panDest2" columns="6" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_more_search}">
                    <h:column>
                        <h:selectOneMenu id="idRegion" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpRegion}" style="width:150px;">
                            <f:selectItem itemLabel="Toutes Régions" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesRegionsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerLesSecteurs}" reRender="panDest2,idSeceurRec,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idSeceurRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpSecteur}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Secteurs" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesSecteursItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerLesPdv}" reRender="panDest2,idPdvRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idPdvRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpPdv}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Points de vente" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesPdvItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idSite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpSite}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Sites" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerLesDepartements}" reRender="panDest2,idDepartementRec,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idDepartementRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpDepartement}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Départements" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesDepartementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerLesServices}" reRender="panDest2,idServiceRec"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesServicesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}">
                        <h:outputText value="Service:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrService}" style="width:300px;" readonly="true" disabled="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="18" width="600px" style="height:34px">
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.initGrapheur}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Dupliquer le document sélectionné" image="/images/duplicate.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.dup}" onclick="if (!confirm('Etes-vous sur de vouloir dupliquer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.duppliquerDocument}" reRender="modAttente,table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.transformerDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Bon d'encaissement du/des document(s) sélectionné(s)" image="/images/bonCaisse.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_be}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.payeDocumentBonEncaissement}" reRender="panelPaye,panelBouton" />
            <a4j:commandButton title="Règlement direct du/des document(s) sélectionné(s)" image="/images/dollar.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_dollar}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.payeXDocumentRecu}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPayeXDoc,panelBouton" />
            <a4j:commandButton title="Historique des règlements du document sélectionné" image="/images/histoPaiement.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.histoReglement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistoReglement" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf,idLivreeEtat"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf,idLivreeEtat"/>
            <a4j:commandButton title="Livrer le document sélectionné" image="/images/livrerDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_gestion_livreur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEtat==5)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.preperationLivraison}" onclick="if (!confirm('Etes-vous sur de vouloir livrer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLiv,formLiv,table"/>
            <a4j:commandButton title="Tout Sélectionner/Rien Sélectionner" image="/images/allSelect.png" id="idAllSelect" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.allSelect}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,table" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.inpEtat==33}"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.pageIndex}" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visualisationLigne}" reRender="idSubView,panelBouton,panCtrl,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° bon livraison" sortable="true" sortBy="#{var.blvNum}">
                            <f:facet name="header"><h:outputText  value="N° B.L." /></f:facet>
                            <h:outputText value="#{var.blvNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.blvPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.blvPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="N° Affaire/Dossier" sortable="true" sortBy="#{var.blvAffaire} #{var.blvAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesAffaires}">
                            <f:facet name="header"><h:outputText  value="N° AFF." /></f:facet>
                            <h:outputText value="#{var.blvAffaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.axeDossier=='2'}"/>
                            <h:outputText value="#{var.blvAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.axeDossier!='2'}"/>
                        </rich:column>
                        <rich:column label="N° Analytique" sortable="true" sortBy="#{var.blvAnal4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesAffaires&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.axeDossier=='2'}">
                            <f:facet name="header"><h:outputText  value="N° ANAL." /></f:facet>
                            <h:outputText value="#{var.blvAnal4}"/>
                        </rich:column>
                        <rich:column label="Date bon livraison" sortable="true" sortBy="#{var.blvDate} #{var.blvNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.blvDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.blvSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.blvSerie}"/>
                        </rich:column>
                        <rich:column label="Pièces jointes" sortable="true" sortBy="#{var.pj}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                            <h:graphicImage value="#{var.pj}" height="20px" width="20px" rendered="#{var.pj!=null}"/>
                        </rich:column>
                        <rich:column label="Catégorie client" sortable="true" sortBy="#{var.blvCat}" width="70px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                            <h:outputText value="#{var.blvCat}"/>
                        </rich:column>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.blvNumFacture}">
                            <f:facet name="header"><h:outputText  value="N° Fac." /></f:facet>
                            <h:outputText value="#{var.blvNumFacture}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.blvEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idLivreeEtat" label="Livrée" sortable="true" sortBy="#{var.libelleLivreeEta}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Liv." /></f:facet>
                            <h:outputText value="#{var.libelleLivreeEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Livraison" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.blvEtat==1||var.blvEtat==4||var.blvEtat==5)&&var.blvSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{var.var_nomContact}" width="200px">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_libcondest}"/></f:facet>
                            <h:outputText  value="#{var.var_nomContact}"/>
                        </rich:column>
                        <rich:column label="Montant H.T." sortable="true" sortBy="#{var.blvTotHt}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T."  /></f:facet>
                            <h:outputText  value="#{var.blvTotHt}" rendered="#{var.blvTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant de la TVA" sortable="true" sortBy="#{var.blvTotTva}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="TVA"/></f:facet>
                            <h:outputText  value="#{var.blvTotTva}" rendered="#{var.blvTotTva!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant des taxes complémentaires" sortable="true" sortBy="#{var.blvTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_type!=0}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_tc_libelle}"/></f:facet>
                            <h:outputText  value="#{var.blvTotTc}" rendered="#{var.blvTotTc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                            <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Règlements" sortable="true" sortBy="#{var.blvTotReglement}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise}">
                            <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                            <h:outputText  value="#{var.blvTotReglement}" rendered="#{var.blvTotReglement!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquatListe}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise}">
                            <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                            <h:outputText  value="#{var.var_reliquatListe}" rendered="#{var.var_reliquatListe!=0}" style="color:red;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.blvActivite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.accesAffaires}">
                            <f:facet name="header"><h:outputText value="Act."  /></f:facet>
                            <h:outputText  value="#{var.blvActivite}"/>
                        </rich:column>
                        <rich:column label="Source" sortable="true" sortBy="#{var.blvSource}" >
                            <f:facet name="header"><h:outputText value="Source"  /></f:facet>
                            <h:outputText  value="#{var.blvSource}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.blvAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Prc."  /></f:facet>
                            <h:outputText  value="#{var.blvAnal2}"/>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.blvObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                            <h:outputText  value="#{var.blvObject}"/>
                        </rich:column>
                        <rich:column label="Echéance" sortable="true" sortBy="#{var.blvDateEcheReg}" width="70px" >
                            <f:facet name="header"><h:outputText value="Eché."  /></f:facet>
                            <h:outputText  value="#{var.blvDateEcheReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.blvNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                            <h:outputText  value="#{var.blvNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Commercial" sortable="true" sortBy="#{var.blvNomCommercial}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.optionsVentes.responsable=='1'}">
                            <f:facet name="header"><h:outputText  value="Commercial"  /></f:facet>
                            <h:outputText  value="#{var.blvNomCommercial}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total TTC" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpTTCE" value="Total TTC" />
                    <h:inputText id="intpTTCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise}">
                    <h:outputText id="outpRGLMTL" value="Total Réglements" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpRGLMTE" value="Total Réglements" />
                    <h:inputText id="intpRGLMTE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalSOLD" columns="2" cellspacing="3"  cellpadding="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.reglementAutorise}">
                    <h:outputText id="outpSOLDL" value="Solde" />
                    <h:inputText id="intpSOLDL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText id="outpSOLDE" value="Solde" />
                    <h:inputText id="intpSOLDE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <f:selectItem itemLabel="En quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modeGraph}">
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
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelImput}" var="ser">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="idChangement">
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_choix}" >
                            <f:selectItem itemLabel="Changement Numéro" itemValue="0"/>
                            <f:selectItem itemLabel="Changement Série" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idChangement"/>
                        </h:selectOneMenu>
                    </h:column>
                    <br><br><br>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_choix==0}">
                        <h:column><h:outputText value="Ancien Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum}" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Nouveau Numéro:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_num}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.controleNumero}" reRender="idChangement"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_choix==1}">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <br>
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelTrf}" var="trf">
            <f:facet name="header"><h:outputText value="Transformation bon de livraison en ..."></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:column>
                        <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_trf}" id="idSerieTrf">
                            <f:selectItem itemLabel="*** Sélectionnez type"  itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.documentTrfItems}" />
                            <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf40,trf41,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.serieSelectTrf}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="7" style="width:100%;background-color:#DAEECB;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_trf}">
                        <h:column><h:outputText id="trf2" value="Date:" /></h:column>
                        <h:column>
                            <rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_trf}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;">
                            </rich:calendar>&nbsp;&nbsp;
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_heure}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_minute}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_trf==24}" id="trf41" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_mode_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                            <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_trf==25}" id="trf40" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_mode_trf}">
                                <f:selectItem itemLabel="Sélectionnez le mode de transfert"  itemValue="100"/>
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                                <f:selectItem itemLabel="X documents => 1 document (produits séparés)" itemValue="1"/>
                                <f:selectItem itemLabel="X documents => 1 document (produits fusionnés)" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" reRender="panGlobal,panelTrf,serieSel,modeleSel,valtrf,trf2,trf3,trf40,trf41,trf5,trf6" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modeSelectTrf}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_serie_trf}" style="width:80px;">
                                <f:selectItem itemLabel="Série Défaut" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_modele_trf}" style="width:120px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><a4j:commandButton id="trf5" value="Reste=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.qteTrfQteOrg}" reRender="tabletrf,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/></h:column>
                        <h:column><a4j:commandButton id="trf6" value="Raz Qte Reste" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.razQteTrf}" reRender="tabletrf"/></h:column>
                    </h:panelGrid>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_trf}"><h:outputText value="(Si la date est vide, alors le document généré prendra la date du document d'origine, si non, le document généré prendra la date spécifiée.)" style="color:red"/></h:column>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelTransfert}" var="trf">
                            <rich:column label="N° BL" sortable="false" sortBy="#{trf.livraisonEnteteVentes.blvNum}" sortOrder="ASCENDING" width="10%">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{trf.livraisonEnteteVentes.blvNum}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="false" width="5%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{trf.livraisonEnteteVentes.blvDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="5%">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{trf.livraisonEnteteVentes.blvSerie}"/>
                            </rich:column>
                            <rich:column label="Client" sortable="false" width="14%">
                                <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                <h:outputText  value="#{trf.livraisonEnteteVentes.blvNomTiers}"/>
                            </rich:column>
                            <rich:column label="Produit" sortable="false" width="26%">
                                <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                <h:outputText  value="#{trf.blvligCode}"/>
                                <h:outputText  value=" - "/>
                                <h:outputText  value="#{trf.blvligLibelle}"/>
                            </rich:column>
                            <rich:column label="Dépôt" sortable="false" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_trf==24}">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:selectOneMenu id="iddepoligne" value="#{trf.var_depotLigne}" style="width:120px;">
                                    <f:selectItems value="#{trf.var_listDepotItem}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                <h:outputText  value="#{trf.blvligQte}"/>
                            </rich:column>
                            <rich:column label="Quantité déjà transférée" sortable="false" style="text-align:right" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.trf." /></f:facet>
                                <h:outputText  value="#{trf.var_qteDejaTrf}"/>
                            </rich:column>
                            <rich:column label="Quantité restante" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText  value="Qte.Reste" /></f:facet>
                                <h:inputText  value="#{trf.var_qteReliquat}" style="text-align:right;width:90%"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.transformerMaj}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_aff_trf&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_mode_trf!='100'}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelLiv" width="1200" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelLivraison}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelLivraison}" var="blv">
            <f:facet name="header"><h:outputText value="Livraison du BL N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleValide}" image="/images/close.gif" styleClass="hidelink" reRender="panelLiv"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formLiv">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="8" style="width:100%;background-color:#DAEECB;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livreeModif}">
                    <h:column><h:outputText value="Préparateur"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_preparateur}"/></h:column>
                    <h:column><h:outputText value="Chauffeur"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_chauffeur}"/></h:column>
                    <h:column><h:outputText value="Véhicule"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_vehicule}"/></h:column>
                    <h:column><a4j:commandButton id="liv5" value="Livreé=Reliquat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.qteLivQteOrg}" reRender="formLiv,tabletrf,valliv,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/></h:column>
                    <h:column><a4j:commandButton id="liv6" value="Raz Qte Livrée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.razQteLiv}" reRender="formLiv,tabletrf,valliv"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="8" style="width:100%;background-color:#DAEECB;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateLivre==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livreeModif}">
                    <h:column><h:outputText value="Date livraison:"/></h:column>
                    <h:column>
                        <rich:calendar id="idDateLivree" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_livree}" inputSize="15" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" >
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mefDateLivree}" reRender="idDateLivree"/>
                        </rich:calendar>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livreeModif}">
                    <center>
                        <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}" reRender="printReliquat,formModalImp" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.initImpressionLivree}"/>
                    </center>
                </h:panelGroup>
                <br>
                <rich:panel  style="width:100%;" id="panGlobalLiv">
                    <h:panelGrid columns="2" columnClasses="clos70,clos30" style="width:100%;">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableliv" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelLivraison}" var="liv">
                                <a4j:support eventsQueue="maQueue1" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.selectionLivree}"reRender="tablelivHisto"/>
                                <rich:column label="Produit" sortable="false" width="35%">
                                    <f:facet name="header"><h:outputText  value="Produit"  /></f:facet>
                                    <h:outputText  value="#{liv.livraisonLigneVentes.blvligCode}"/>
                                    <h:outputText  value=" - "/>
                                    <h:outputText  value="#{liv.livraisonLigneVentes.blvligLibelle}"/>
                                </rich:column>
                                <rich:column label="Dépôt" sortable="false" width="15%">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText  value="#{liv.livraisonLigneVentes.blvligDepot}"/>
                                </rich:column>
                                <rich:column label="Quantité origine" sortable="false" style="text-align:right" width="15%">
                                    <f:facet name="header"><h:outputText  value="Qte.Origine" /></f:facet>
                                    <h:outputText  value="#{liv.livraisonLigneVentes.blvligQte}"/>
                                </rich:column>
                                <rich:column label="Quantité déjà livrée" sortable="false" style="text-align:right" width="15%">
                                    <f:facet name="header"><h:outputText  value="Qte.déjà livrée" /></f:facet>
                                    <h:outputText  value="#{liv.var_qteDejaLiv}"/>
                                </rich:column>
                                <rich:column label="Quantité à livrée" sortable="false" width="15%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livreeModif}">
                                    <f:facet name="header"><h:outputText  value="Qte.à Liv" /></f:facet>
                                    <h:inputText value="#{liv.blvlivQteLivree}" style="text-align:right;width:90%">
                                        <a4j:support eventsQueue="maQueue2" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verifRelcat}" reRender="panGlobalLiv,valliv"/>
                                    </h:inputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tablelivHisto" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.dataModelLivraisonHisto}" var="his">
                                <rich:column label="Date de livraison" sortable="false" width="20%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{his.blvlivDate}" title="#{his.blvlivDate} - #{his.blvlivId}">
                                        <f:convertDateTime pattern="dd/MM/yy HH:MM" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Quantité livrée" sortable="false" style="text-align:right" width="20%">
                                    <f:facet name="header"><h:outputText  value="Qte.Livrée" /></f:facet>
                                    <h:outputText  value="#{his.blvlivQteUtilLivree}"/>
                                </rich:column>
                                <rich:column label="Chauffeur" sortable="false" style="text-align:right" width="30%">
                                    <f:facet name="header"><h:outputText  value="Chauffeur" /></f:facet>
                                    <h:outputText  value="#{his.blvlivChauffeur}"/>
                                </rich:column>
                                <rich:column label="Véhicule" sortable="false" width="30%">
                                    <f:facet name="header"><h:outputText  value="Véhicule" /></f:facet>
                                    <h:outputText value="#{his.blvlivVehicule}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livreeModif}">
                        <center>
                            <h:commandButton id="valliv" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.valide_livreur}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </center>
                    </h:panelGroup>
                </rich:panel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="printReliquat" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrintLivree}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrintLivree}" var="prl">
            <f:facet name="header"><h:outputText value="Impression des reliquats"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerImpressionLivree}" image="/images/close.gif" styleClass="hidelink" reRender="printReliquat"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 0px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.nomModeleDocument}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.lesDocumentsReliquatItem}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Livraison"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPaye" width="800" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPaye}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPaye}" var="pay">
            <f:facet name="header"><h:outputText value="Bon d'encaissement du document"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.annulePaye}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaye"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Date:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                    <h:column><h:outputText value="N°:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNum}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:panelGroup>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvSerie}" size="2" readonly="true"/>
                            <h:outputText value="Devise:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvDevise}" size="3" readonly="true"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Client:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomTiers}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Responsable:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomResponsable}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Commercial:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomCommercial}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Equipe:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvNomEquipe}" readonly="true"/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column> <h:outputText value="Mode de règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_verouxModReg}">
                            <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                            <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                            <f:selectItem itemLabel="Demande autorisation crédit" itemValue="5"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerModReg}" reRender="firstgridd,colMontInput"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_inputCaisse}">
                            <f:selectItem  itemValue="0" itemLabel="Sélectionnez une caisse"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesCaissesSeriesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.choixCaisseXReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:outputText value="Montant du bon:"/>
                    <h:column id="colMontInput">
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affichMontant}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPaye" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verifBonEncaissement}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Net à payer:"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_netAPayer}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Type règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idTypeRegBe" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_reg}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesTypeReglementsCaisse}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.choixTypeReglementBencaissement}" reRender="firstgridd,idBnq1,idBnq2,idChq1,idChq2,idChq3,idChq4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}">
                            <f:selectItem itemLabel="Inconnue" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesBanquesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idChq1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><h:outputText value="Banque du tireur:"/></h:column>
                    <h:column id="idChq2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                    <h:column id="idChq3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column id="idChq4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_num_cheque}" maxlength="50"/></h:column>
                    <h:column id="idChq5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><h:outputText value="Date remise en banque:"/></h:column>
                    <h:column id="idChq6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_remise}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value="Echéance reliquat:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvEcheanceReliquat}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_verouxModReg}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==4||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value="Observation parapheur:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvMotifRejetCredit}" readonly="true"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg==5}"><h:outputText value=""/></h:column>
                </h:panelGrid>
                <h:panelGroup id="ppgrp">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.miseajourPaye}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPaye,panelBouton,modMessageCommun"/>
                        <br>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_valide}" style="margin-left:50px;">
                            <h:graphicImage url="../images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPayeXDoc" width="1100" height="550" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelReglement}" var="pay">
            <f:facet name="header"><h:outputText value="Règlement direct de plusieurs documents"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerXReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelPayeXDoc"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formPayeXDoc">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid id="panelGlobal" width="100%">
                    <h:panelGrid id="firstgridd"  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_trf}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateVte==0}"/></h:column>
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="bnqajt" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_inputCaisse}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesCaissesSeriesItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.choixCaisseXReglement}" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_type_reg}" style="width:100%;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesTypeReglementsCaisse}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.choixTypeReglement}" reRender="firstgridd,panelGlobal,bnqajt,idEncais2,idImp1,idImp2,tablePaye,idBnq1,idBnq2,idEcart3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.nomRepMod})" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_modele_trf}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesModesleRecus}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText id="idBnq1" value="Banque destination:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idBnq2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_banque_destination}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.mesBanquesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date de remise en banque:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_date_remise}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque_destination}"/></h:column>
                        <h:column><h:outputText value="Mode de règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.livraisonEnteteVentes.blvTypeReg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_verouxModReg}">
                                <f:selectItem itemLabel="Paiement total" itemValue="0"/>
                                <f:selectItem itemLabel="Paiement partiel" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.chargerModReg}" reRender="firstgridd"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:outputText value=""/>
                        <h:outputText value=""/>
                        <h:outputText value="Montant règlement:"/>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.montantElmTotBonEnc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affichMontant}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.verifValide}" reRender="panelGlobal,ppgrp,idEcart0,idEcart1,idEcart2,idEcart3"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Net à payer:"/></h:column>
                        <h:column>
                            <h:inputText id="idNetPayer" style="width:100%;text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_netAPayer}" disabled="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_objet}" maxlength="50" style="width:50%;"/>&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.repartitionManuelle}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelTransfert.rowCount>=2}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.controleEcartRepartitionManuelle}" reRender="ppgrp,tablePaye,firstgridd,idEcart1,idEcart2"/>
                            </h:selectBooleanCheckbox>&nbsp;
                            <h:outputText value="Répartition manuelle" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelTransfert.rowCount>=2}"/>
                        </h:column>
                        <h:column><h:outputText value="Ecart:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.repartitionManuelle}">
                            <h:inputText id="idEcart0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_ecart_reglement}" readonly="true" style="width:100%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.repartitionManuelle}">
                            <h:inputText id="idEcart1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_ecart_reglement}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;&nbsp;
                            <h:inputText id="idEcart2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.ecartManuel}" readonly="true" style="width:45%;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_banque}">
                        <h:column><h:outputText value="Banque du tireur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_banque_tireur}" maxlength="50" style="text-transform:uppercase"/></h:column>
                        <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_num_cheque}" maxlength="50"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idEcart3" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.varTypeReg==0}">
                        <h:column><h:outputText value="Montant timbre:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.val_timbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total dû (réglement + timbre)"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.totalPayerTimbre}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" id="tablePaye" rowClasses="rows1,rows2,rowsd" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelTransfert}" var="var">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.calulNetPayer}" reRender="idNetPayer,panelGalobal"/>
                            <rich:column label="N° facture" sortable="false">
                                <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                <h:outputText value="#{var.blvNum}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.blvDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="false" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.blvSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="false" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.blvCat}"/>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant Timbre" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.varTypeReg==0}">
                                <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                                <h:outputText  value="#{var.var_blv_timbre}" rendered="#{var.var_blv_timbre!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.blvTotReglement}" rendered="#{var.blvTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="false" style="text-align:right;color:red">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Répartition manuelle" sortable="false" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.repartitionManuelle}">
                                <f:facet name="header"> <h:outputText value="Règlement"/></f:facet>
                                <h:inputText  value="#{var.montantReglementManuel}" style="text-align:right;width:90%;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.controleEcartRepartitionManuelle}" reRender="ppgrp,idEcart1,idEcart2"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Tiers" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Tiers"  /></f:facet>
                                <h:outputText  value="#{var.var_nom_tiers}"/>
                            </rich:column>
                            <rich:column label="Objet de la facture" sortable="false" width="200px">
                                <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                                <h:outputText  value="#{var.blvObject}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:panelGroup id="ppgrp">
                            <center>
                                <br><br>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.validerXreglement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <br>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.var_affiche_valide}" style="margin-left:50px;">
                                    <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                    <h:outputText value="Le montant du bon est supérieur au solde du document" style="color:red;" />
                                </h:panelGroup>
                            </center>
                        </h:panelGroup>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImpRecu" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrintRecu}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelPrintRecu}" var="prtrec">
            <f:facet name="header"><h:outputText value="Impression du reçu d'encaissement"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerImpressionRecu}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpRecu"/>
                </a4j:form>
            </f:facet>
            <a4j:form target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                                    <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.imprimerRecuXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menuvente.imp}"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelHistoReglement" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelHistoReglement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.showModalPanelHistoReglement}" var="his">
            <f:facet name="header"><h:outputText value="Historique des règlements"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.fermerHistoReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoReglement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;">
                    <jsp:include flush="true" page="/ventes/LivraisonCommun.jsp"/>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable height="350px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formLivraisonVentes.datamodelRecu}"  var="recu"  sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeReglementDocument.jsp"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
