<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="manifestliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}s" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="10" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search}"/>
                    <h:column><h:outputText value="N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpNum}" size="7"/></h:column>
                    <h:column><h:outputText value="N° Conteneur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpContener}" style="width:100px;"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.decoupageActivite=='false'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="16" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_colonne1}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.laColonne1Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_colonne2}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.laColonne2Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_anal_activite}">
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_colonne3}" >
                            <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.laColonne3Items}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.rechercheResponsable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Commercial:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpCommercial}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.rechercheCommercial}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_anal_parc}">
                        <h:outputText value="Parc:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpParc}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==0}">
                        <h:selectOneMenu id="idServiceRec" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.inpService}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Services" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesServicesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdService==1}">
                        <h:outputText value="Service:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrService}" style="width:300px;" readonly="true" disabled="true"/>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="12" width="450px" style="height:34px">
            <a4j:commandButton title="Mise en forme importation" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.ajoutMANIFESTE=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" onclick="if (!confirm('Etes-vous sur de vouloir mettre à jour les données importées ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.chargerImportation}" reRender="panelImportation"/>
            <a4j:commandButton title="Ajouter nouveau document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.ajoutMANIFESTE=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.ajoutDocument}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer le manifest" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.initGrapheur}"/>
            <a4j:commandButton title="Changer N°/série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Transformer le(s) document(s) sélectionné(s)" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==1)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.trf}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.transformerDocument}" reRender="panelTrf,formTrf,idSerieTrf"/>
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanDateTransforme==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanTotalReglement==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce document ?')) return false" reRender="panelBouton,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.datamodelEntete}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,panelBouton,pnlgrttotal,idEtat"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visualisationLigne}" reRender="idSubView,panCtrl,panelBouton,pnlgrttotal,idEtat"/>
                        <rich:column label="N° manifeste/Dossier" sortable="true" sortBy="#{var.vtemanNum}">
                            <f:facet name="header"><h:outputText  value="N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}" /></f:facet>
                            <h:outputText value="#{var.vtemanNum}"/>
                        </rich:column>
                        <rich:column label="Etat signature" sortable="true" sortBy="#{var.vtemanPosSignature}" width="70px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.habilitation!=null}">
                            <f:facet name="header"><h:outputText  value="Sign." /></f:facet>
                            <h:outputText  value="#{var.vtemanPosSignature}/#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.habilitation.habNombre}" style="text-align:center;"/>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.vtemanSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.vtemanSerie}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.libelleEta}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column label="Nature transport" sortable="true" sortBy="#{var.libelleNAture}" width="70px">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{var.libelleNAture}"/>
                        </rich:column>
                        <rich:column label="Organe (Navire, Avion, Camion, Train)" sortable="true" sortBy="#{var.vtemanRefNavire}" width="70px">
                            <f:facet name="header"><h:outputText  value="Organe" /></f:facet>
                            <h:outputText value="#{var.vtemanRefNavire}"/>
                        </rich:column>
                        <rich:column label="Date départ" sortable="true" sortBy="#{var.vtemanDateDep} #{var.vtemanNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date dep." /></f:facet>
                            <h:outputText value="#{var.vtemanDateDep}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Port de départ" sortable="true" sortBy="#{var.vtemanLibPortDep}" style="text-align:left"  width="150px">
                            <f:facet name="header"><h:outputText  value="Départ" /></f:facet>
                            <h:outputText value="#{var.vtemanLibPortDep}"/>
                        </rich:column>
                        <rich:column label="Date arrivée" sortable="true" sortBy="#{var.vtemanDateArr} #{var.vtemanNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date arr." /></f:facet>
                            <h:outputText value="#{var.vtemanDateArr}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Port d'arrivée" sortable="true" sortBy="#{var.vtemanLibPortArr}" style="text-align:left" width="150px">
                            <f:facet name="header"><h:outputText  value="Arrivée" /></f:facet>
                            <h:outputText value="#{var.vtemanLibPortArr}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.vtemanEtat==1||var.vtemanEtat==4)&&var.vtemanSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="N° BL" sortable="true" sortBy="#{var.vtemanNumBl}" width="100px">
                            <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                            <h:outputText value="#{var.vtemanNumBl}"/>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.vtemanNomResponsable}" width="200px">
                            <f:facet name="header"><h:outputText  value="Responsable" /></f:facet>
                            <h:outputText value="#{var.vtemanNomResponsable}"/>
                        </rich:column>
                        <rich:column sortable="false" width="7%" style="text-align:right">
                            <f:facet name="header"><h:outputText value="H.T."/></f:facet>
                            <h:outputText value="#{var.vtemanTotalHt}" rendered="#{var.vtemanTotalHt!=0}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="7%" style="text-align:right">
                            <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                            <h:outputText value="#{var.vtemanTotalTva}" rendered="#{var.vtemanTotalTva!=0}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="7%" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="TTC"/></f:facet>
                            <h:outputText value="#{var.vtemanTotalTtc}" rendered="#{var.vtemanTotalTtc!=0}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column sortable="false" width="7%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}"/></f:facet>
                            <h:outputText value="#{var.vtemanTc}" rendered="#{var.vtemanTc!=0}" style="text-align:right">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total TTC" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total TTC" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantTtcElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Total Réglements" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total Réglements" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantReglementElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText value="Solde" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantSolde}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Solde" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.montantSoldeElmt}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nb_ligne})" />
                    <h:outputText value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.valQteGraph}" >
                                <f:selectItem itemLabel="En valeur" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <f:selectItem itemLabel="En quantité" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.modeGraph}">
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
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImput}" var="ser">
            <f:facet name="header"><h:outputText value="Imputation N°/Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Catégorie:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="catimput" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_imput_cat}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesFamilleClientsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation Manifest"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImportation" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImportation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImportation}" var="bty">
            <f:facet name="header"><h:outputText value="Importation BETTER YARD"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annuleImportation}" image="/images/close.gif" styleClass="hidelink" reRender="panelImportation"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.pageIndex}" reRender="table" id="scrollTableImport" maxPages="20" align="left" for="tableImport"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nb_max}" styleClass="bg" id="tableImport" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.dataModelImportation}" var="varImp">
                            <rich:column label="N° manifeste" sortable="true" sortBy="#{varImp.vtemanNum}">
                                <f:facet name="header"><h:outputText  value="N° MANIFESTE" /></f:facet>
                                <h:outputText value="#{varImp.vtemanNum}"/>
                            </rich:column>
                            <rich:column label="Organe (Navire, Avion, Camion, Train)" sortable="true" sortBy="#{varImp.vtemanRefNavire}" width="70px">
                                <f:facet name="header"><h:outputText  value="Organe" /></f:facet>
                                <h:outputText value="#{varImp.vtemanRefNavire}"/>
                            </rich:column>
                            <rich:column label="Date départ" sortable="true" sortBy="#{varImp.vtemanDateDep} #{varImp.vtemanNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date dep." /></f:facet>
                                <h:outputText value="#{varImp.vtemanDateDep}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Port de départ" sortable="true" sortBy="#{varImp.vtemanLibPortDep}" style="text-align:left"  width="150px">
                                <f:facet name="header"><h:outputText  value="Départ" /></f:facet>
                                <h:outputText value="#{varImp.vtemanLibPortDep}"/>
                            </rich:column>
                            <rich:column label="Date arrivée" sortable="true" sortBy="#{varImp.vtemanDateArr} #{varImp.vtemanNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date arr." /></f:facet>
                                <h:outputText value="#{varImp.vtemanDateArr}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Port d'arrivée" sortable="true" sortBy="#{varImp.vtemanLibPortArr}" style="text-align:left" width="150px">
                                <f:facet name="header"><h:outputText  value="Arrivée" /></f:facet>
                                <h:outputText value="#{varImp.vtemanLibPortArr}"/>
                            </rich:column>
                            <rich:column label="N° BL" sortable="true" sortBy="#{varImp.vtemanNumBl}" width="100px">
                                <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                                <h:outputText value="#{varImp.vtemanNumBl}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.majImportation}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelImportationErreur" width="900" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImportationErreur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelImportationErreur}" var="bty">
            <f:facet name="header"><h:outputText value="ERREUR BETTER YARD"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annuleImportationErreur}" image="/images/close.gif" styleClass="hidelink" reRender="panelImportation"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.pageIndex}" reRender="table" id="scrollTableImport" maxPages="20" align="left" for="tableImport"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nb_max}" styleClass="bg" id="tableImport" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.dataModelImportationErreur}" var="varErr">
                            <rich:column label="N° manifeste" sortable="true" sortBy="#{varErr.vtelvNumManifest}" style="text-align:left" width="150px">
                                <f:facet name="header"><h:outputText  value="N° MANIFESTE"/></f:facet>
                                <h:outputText value="#{varErr.vtelvNumManifest}"/>
                            </rich:column>
                            <rich:column label="N° LV" sortable="true" sortBy="#{varErr.vtelvNum}" style="text-align:left" width="150px">
                                <f:facet name="header"><h:outputText  value="N° LV" /></f:facet>
                                <h:outputText value="#{varErr.vtelvNum}"/>
                            </rich:column>
                            <rich:column label="Erreur" sortable="true" sortBy="#{varErr.vtelvAdresseDest}" width="400px">
                                <f:facet name="header"><h:outputText  value="Erreur" /></f:facet>
                                <h:outputText value="#{varErr.vtelvAdresseDest}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.suppressionImportationErreur}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTrf" width="1150" height="550" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelTrf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelTrf}" var="anl">
            <f:facet name="header"><h:outputText value="Transformation manifeste en facture"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annuleTrf}" image="/images/close.gif" styleClass="hidelink" reRender="panelTrf"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formTrf">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;" id="panGlobal">
                    <h:panelGrid  columns="5" style="width:100%;background-color:#DAEECB;">
                        <h:column><h:outputText id="trf2" value="Date:"/></h:column>
                        <h:column><rich:calendar id="trf3" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_date_trf}"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"></rich:calendar>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="trf4" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_mode_trf}">
                                <f:selectItem itemLabel="1 document => 1 document"  itemValue="0"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="serieSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_serie_trf}" style="width:80px;">
                                <f:selectItem itemLabel="Série Défaut" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesSeriesTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column>
                            <h:selectOneMenu id="modeleSel" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_modele_trf}" style="width:120px;">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.modeleTrfItems}" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tabletrf" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.datamodelTransfert}" var="doclig">
                            <rich:column label="N° manifeste" sortable="true" sortBy="#{doclig.vtelvNumManifest}">
                                <f:facet name="header"><h:outputText  value="N° MANIFESTE" /></f:facet>
                                <h:outputText value="#{doclig.vtelvNumManifest}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="N° LV"/></f:facet>
                                <h:outputText  value="#{doclig.vtelvNum}" title="#{doclig.vtelvNum}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Immat."/></f:facet>
                                <h:outputText  value="#{doclig.vtelvImmaCamion}" title="#{doclig.vtelvImmaCamion}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Chauffeur"/></f:facet>
                                <h:outputText  value="#{doclig.vtelvMatChauffeurExp}" title="#{doclig.vtelvMatChauffeurExp}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Client Dép."/></f:facet>
                                <h:outputText  value="#{doclig.vtelvIntituleClientExp}" title="#{doclig.vtelvIntituleClientExp}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Client Dest.."/></f:facet>
                                <h:outputText  value="#{doclig.vtelvIntituleClientDest}" title="#{doclig.vtelvIntituleClientDest}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Colis"/></f:facet>
                                <h:outputText  value="#{doclig.nomProduit}" title="#{doclig.nomProduit}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%" style="text-align:right">
                                <f:facet name="header"><h:outputText value="H.T."/></f:facet>
                                <h:outputText value="#{doclig.vtelvTotalHt}" rendered="#{doclig.vtelvTotalHt!=0}" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="8%" style="text-align:right">
                                <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                <h:outputText value="#{doclig.vtelvTotalTva}" rendered="#{doclig.vtelvTotalTva!=0}" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="8%" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="TTC"/></f:facet>
                                <h:outputText value="#{doclig.vtelvTotalTtc}" rendered="#{doclig.vtelvTotalTtc!=0}" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="8%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}"/></f:facet>
                                <h:outputText value="#{doclig.vtelvTc}" rendered="#{doclig.vtelvTc!=0}" style="text-align:right">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Facture"/></f:facet>
                                <h:outputText  value="#{doclig.vtelvNumFacture}" title="#{doclig.vtelvNumFacture}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
                <h:panelGroup>
                    <br>
                    <center>
                        <h:commandButton id="valtrf" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.transformerMaj}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
