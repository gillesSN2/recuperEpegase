<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="manifestefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="GESTION DU #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationDocument}">
                    <h:panelGrid width="100%" id="idPanelGlobal">
                        <h:panelGrid width="100%" columns="6" columnClasses="clos15,clos15g,clos15,clos15g,clos15,clos15g" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Descriptif"/></f:facet>
                            <h:column><h:outputText value="N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.libelleMANIFEST}:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanId!=0}" style="width:70%"/>&nbsp;
                                <h:selectOneMenu style="width:20%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesSerieUserItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:outputText value="Nature:"/>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanTypeTransport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                <f:selectItem itemLabel="Sélectionnez une nature" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesNaturesManifestItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculeLibelle}" reRender="panelPage,idPanelGlobal,panelValide"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libelleNatureTransport}:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanTypeTransport!='4'}"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanRefNavire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanTypeTransport!='4'}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libelleNatureTransport}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesNaviresItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Responsable:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nom_responsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez un responsable" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesUsersItem}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculeLibelle}" reRender="panelPage,idPanelGlobal,panelValide"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Commercial:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_nom_commercial}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez un commercial" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesCommercialItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Objet:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanObjet}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}" style="width:100%"/></h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez une activité" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez un service" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.mesServiceItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="N° BL:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanNumBl}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}" style="width:100%"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="6" columnClasses="clos15,clos15g,clos15,clos15g,clos15,clos15g" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Départ"/></f:facet>
                            <h:column><h:outputText value="Date chargement:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanDateDep}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libellePortTransport} chargement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanRefPortDep}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libellePortTransport}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesPortsItemsDep}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculeLieuDep}" reRender="idLieuDep"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Lieu chargement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idLieuDep" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanRefLieuDep}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez lieu" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesLieuxItemsDep}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="6" columnClasses="clos15,clos15g,clos15,clos15g,clos15,clos15g" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Arrivée"/></f:facet>
                            <h:column><h:outputText value="Date déchargement:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanDateArr}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libellePortTransport} déchargement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanRefPortArr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.libellePortTransport}" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesPortsItemsArr}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculeLieuArr}" reRender="idLieuArr"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Lieu déchargement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idLieuArr" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanRefLieuArr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action!=1}">
                                    <f:selectItem itemLabel="Sélectionnez lieu" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesLieuxItemsArr}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabLv" label="Lettres de voitures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_document}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationDocument}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid width="200px" columns="4" id="BoutonLigne" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_action<=1}">
                            <a4j:commandButton title="Ajouter nouvelle lettre de voiture" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.ajoutMANIFESTE=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.ajoutLettreVoiture}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreVoiture"/>
                            <a4j:commandButton title="Modifier la lettre sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.modifLettreVoiture}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreVoiture"/>
                            <a4j:commandButton title="Consulter la lettre sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonlig}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.consultLettreVoiture}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreVoiture"/>
                            <a4j:commandButton title="Supprimer la lettre sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonlig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.supprimerLettreVoiture}" reRender="tableLigne,BoutonLigne"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableLigne" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="max-height:100%;margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.datamodelLigne}" var="doclig">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.selectionLigneDetail}" reRender="BoutonLigne"/>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="N° LV"/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvNum}" title="#{doclig.vtelvNum}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Immat."/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvImmaCamion}" title="#{doclig.vtelvImmaCamion}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Chauffeur"/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvMatChauffeurDest}" title="#{doclig.vtelvMatChauffeurDest}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvIntituleClient}" title="#{doclig.vtelvIntituleClient}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right">
                                    <f:facet name="header"><h:outputText value="H.T."/></f:facet>
                                    <h:outputText value="#{doclig.vtelvTotalHt}" rendered="#{doclig.vtelvTotalHt!=0}" style="#{doclig.styleLigne};text-align:right">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right">
                                    <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                    <h:outputText value="#{doclig.vtelvTotalTva}" rendered="#{doclig.vtelvTotalTva!=0}" style="#{doclig.styleLigne};text-align:right">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="TTC"/></f:facet>
                                    <h:outputText value="#{doclig.vtelvTotalTtc}" rendered="#{doclig.vtelvTotalTtc!=0}" style="#{doclig.styleLigne};text-align:right">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}"/></f:facet>
                                    <h:outputText value="#{doclig.vtelvTc}" rendered="#{doclig.vtelvTc!=0}" style="#{doclig.styleLigne};text-align:right">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Devis"/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvNumDevis}" title="#{doclig.vtelvNumDevis}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header"><h:outputText  value="Facture"/></f:facet>
                                    <h:outputText  value="#{doclig.vtelvNumFacture}" title="#{doclig.vtelvNumFacture}" style="#{doclig.styleLigne}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Habilitations" id="tabHabilitation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_habilitation}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText size="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_etat}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationEtat}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />

                </rich:tab>

                <rich:tab label="Factures Clients" id="tabFacturesClients" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationEtat}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="max-height:100%;" styleClass="bg" id="tableFactureTiers" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.dataModelFactures}" var="var">
                            <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}">
                                <f:facet name="header"><h:outputText  value="N° FACTURE" /></f:facet>
                                <h:outputText value="#{var.facNum}"/>
                            </rich:column>
                            <rich:column label="N° Manifeste" sortable="true" sortBy="#{var.facAnal4}">
                                <f:facet name="header"><h:outputText  value="N° Manif." /></f:facet>
                                <h:outputText value="#{var.facAnal4}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{var.facDate} #{var.facNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.facDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.facSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{var.facCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.facCat}"/>
                            </rich:column>
                            <rich:column label="N° bon de livraison" sortable="true" sortBy="#{var.facNumBl}">
                                <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                                <h:outputText value="#{var.facNumBl}"/>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.facEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                                <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                <h:outputText  value="#{var.var_nom_tiers}"/>
                            </rich:column>
                            <rich:column label="Acompte" sortable="true" sortBy="#{var.facTauxAcompte}" style="text-align:right;" width="50px">
                                <f:facet name="header"><h:outputText  value="Acp."  /></f:facet>
                                <h:outputText  value="#{var.facTauxAcompte}" rendered="#{var.facTauxAcompte!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant des taxes complémentaires" sortable="true" sortBy="#{var.facTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_type!=0}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_libelle}"/></f:facet>
                                <h:outputText  value="#{var.facTotTc}" rendered="#{var.facTotTc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{var.facTotReglement}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.reglementAutorise}">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquatListe}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.reglementAutorise}">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquatListe}" rendered="#{var.var_reliquatListe!=0}" style="color:red;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Factures Groupe" id="tabFacturesGroupe" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationEtat}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="max-height:100%;" styleClass="bg" id="tableFactureGroupe" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.dataModelFacturesGroupe}" var="var">
                            <rich:column label="N° facture" sortable="true" sortBy="#{var.fitNum}">
                                <f:facet name="header"><h:outputText  value="N° FACTURE" /></f:facet>
                                <h:outputText value="#{var.fitNum}"/>
                            </rich:column>
                            <rich:column label="N° Manifeste" sortable="true" sortBy="#{var.fitAnal4}">
                                <f:facet name="header"><h:outputText  value="N° Manif." /></f:facet>
                                <h:outputText value="#{var.fitAnal4}"/>
                            </rich:column>
                            <rich:column label="Date facture" sortable="true" sortBy="#{var.fitDate} #{var.fitNum}" width="70px">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{var.fitDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Série" sortable="true" sortBy="#{var.fitSerie}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="S." /></f:facet>
                                <h:outputText value="#{var.fitSerie}"/>
                            </rich:column>
                            <rich:column label="Catégorie client" sortable="true" sortBy="#{var.fitCat}" width="70px">
                                <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                                <h:outputText value="#{var.fitCat}"/>
                            </rich:column>
                            <rich:column label="N° bon de livraison" sortable="true" sortBy="#{var.fitNumBl}">
                                <f:facet name="header"><h:outputText  value="N° BL" /></f:facet>
                                <h:outputText value="#{var.fitNumBl}"/>
                            </rich:column>
                            <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.fitEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{var.libelleEta}"/>
                            </rich:column>
                            <rich:column label="Client" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                                <f:facet name="header"><h:outputText  value="Client"  /></f:facet>
                                <h:outputText  value="#{var.var_nom_tiers}"/>
                            </rich:column>
                            <rich:column label="Montant des taxes complémentaires" sortable="true" sortBy="#{var.fitTotTc}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_type!=0}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.var_tc_libelle}"/></f:facet>
                                <h:outputText  value="#{var.fitTotTc}" rendered="#{var.fitTotTc!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Règlements" sortable="true" sortBy="#{var.fitTotReglement}" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.reglementAutorise}">
                                <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                                <h:outputText  value="#{var.fitTotReglement}" rendered="#{var.fitTotReglement!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquatListe}" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formFactureVentes.reglementAutorise}">
                                <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                                <h:outputText  value="#{var.var_reliquatListe}" rendered="#{var.var_reliquatListe!=0}" style="color:red;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Ecritures" id="tabEcritures" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibleOnglet&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_acc_reglement}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.autorisationEtat}">
                    <jsp:include flush="true" page="/parc/ManifestCommun.jsp" />
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.chargerEcritures}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panEcritures,ligneEcriture"/>
                    <h:panelGrid id="panEcritures" width="100%">
                        <rich:extendedDataTable id="ligneEcriture" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="max-height:100%;margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.dataModelEcriture}" var="ecr" sortMode="multi">
                            <jsp:include flush="true" page="/commun/listeEcritureDocument.jsp"/>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.preSave}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action}"/>
                </center>
                <center>
                    <h:outputText  id="outptpanelTiers" style="color:red;" value="La nature de transport et le responsable sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel id="panelLettreVoiture" width="900" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelLettre}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelLettre}" var="plv">
            <f:facet name="header"><h:outputText value="Gestion lettres de voiture"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.fermerLettreVoiture}" image="/images/close.gif" styleClass="hidelink" reRender="panelLettreVoiture"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;" id="idPanGlobal">
                    <h:panelGrid width="100%" id="idClient" columns="4" columnClasses="clos25,clos25g,clos25,clos25g" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Descriptif"/></f:facet>
                        <h:column><h:outputText value="N° lettre voiture:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvNum}" style="width:100%" disabled="true"/></h:column>
                        <h:column><h:outputText value="Camion/tracteur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sélectionnez un camion/tracteur" itemValue="..."/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesVehiculesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculeCamion}" reRender="idPanGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"><h:outputText value="Remorque 1:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaRemorque1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sélectionnez une remorque" itemValue="..."/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesRemorquesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"><h:outputText value="Remorque 2:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaRemorque2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sélectionnez une remorque" itemValue="..."/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesRemorquesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPanGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Chauffeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/></h:column>
                        <h:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.chauffeurMANIFEST=='0'}" var="chf01">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvNomPrenomChauffeurExp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.chauffeurMANIFEST=='1'}" var="chf11">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvMatChauffeurExp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                                    <f:selectItem itemLabel="Sélectionnez un chauffeur" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesChauffeursItemsExp}"/>
                                </h:selectOneMenu>
                            </c:if>
                        </h:column>
                        <h:column><h:outputText value="Aide Chauffeur:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/></h:column>
                        <h:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.chauffeurMANIFEST=='0'}" var="chf02">
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvNomPrenomChauffeurExp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.chauffeurMANIFEST=='1'}" var="chf12">
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvMatChauffeurDest}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                                    <f:selectItem itemLabel="Sélectionnez un aide chauffeur" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesChauffeursItemsDest}"/>
                                </h:selectOneMenu>
                            </c:if>
                        </h:column>
                        <h:column><h:outputText value="Client à facturer:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvIntituleClient}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sélectionnez un client" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesClientsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculTiers}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvObservation}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                        <h:column><h:outputText value="Assurance:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeAssuree}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Aucune assurance" itemValue="0"/>
                                <f:selectItem itemLabel="Perte ou vol" itemValue="1"/>
                                <f:selectItem itemLabel="Tous risques" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valeur assurée:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvValeurAssuree}" style="width:100%;text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                        <h:column><h:outputText value="Mode facturation LV:" style="color:red"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeFacture}" style="width:100%;color:red;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Facture les produits de la LV" itemValue="0"/>
                                <f:selectItem itemLabel="Facture spéciale sur devis" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculListeProduit}" reRender="idPanGlobal,idProduit,idClient,idDevis"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Facturation groupe:" style="color:red"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeGroupe}" style="width:100%;color:red;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Facturation Tiers" itemValue="0"/>
                                <f:selectItem itemLabel="Facturation Groupe" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Mode paiement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeClient}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sélectionnez mode de facturation" itemValue="0"/>
                                <f:selectItem itemLabel="Port Payé (facturé à l'expéditeur)" itemValue="1"/>
                                <f:selectItem itemLabel="Port Du (facturé au destinataire)" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="TVA:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvExoTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Avec TVA" itemValue="0"/>
                                <f:selectItem itemLabel="Sans TVA" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculListeProduit}" reRender="idProduit"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvExoTc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                <f:selectItem itemLabel="Sans #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}" itemValue="0"/>
                                <f:selectItem itemLabel="Avec #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}" itemValue="1"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculListeProduit}" reRender="idProduit"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Distance théorique (kms):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanDistance}" style="width:100%;text-align:right" disabled="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                        <h:panelGrid width="100%" columns="4" columnClasses="clos25,clos25g,clos25,clos25g" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Départ: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanLibPortDep}"/></f:facet>
                            <h:column><h:outputText value="Expéditeur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvIntituleClientExp}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Contact:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvContactExp}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvAdresseExp}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Responsable:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvMatRespExp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <f:selectItem itemLabel="Sélectionnez un responsable" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesResponsablesItemsExp}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compteur kilométrique:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvKmsExp}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="4" columnClasses="clos25,clos25g,clos25,clos25g" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Arrivée:  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanLibPortArr}"/></f:facet>
                            <h:column><h:outputText value="Destinataire:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvIntituleClientDest}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Contact:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvContactDest}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvAdresseDest}" style="width:100%" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Responsable:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvMatRespDest}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <f:selectItem itemLabel="Sélectionnez un responsable" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesResponsablesItemsDest}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compteur kilométrique:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvKmsDest}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvImmaCamion!='...'}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idProduit" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeFacture==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeFacture==0}">
                        <f:facet name="header"><h:outputText value="Produits transportés"/></f:facet>
                        <h:panelGrid width="100%">
                            <h:panelGrid width="250px" columns="5" id="BoutonDetailLigne" style="height:34px">
                                <a4j:commandButton title="Ajouter nouveau produit" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.ajoutMANIFESTE=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.ajouterProduit}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelProduit"/>
                                <a4j:commandButton title="Modifier le produit sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonDetaillig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.modifierProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelProduit"/>
                                <a4j:commandButton title="Consulter le produit sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonDetaillig}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.consulterProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelProduit"/>
                                <a4j:commandButton title="Supprimer le produit sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.visibiliteBtonDetaillig&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestEntete.vtemanEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menuparc.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.supprimerProduit}" reRender="tableDetailLigne,BoutonDetailLigne"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableDetailLigne" height="150px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.datamodelProduit}" var="docdet">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.selectionLigneSousDetail}" reRender="BoutonDetailLigne"/>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText  value="N° LV"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdNum}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="Produit"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdRefTypeColis}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%">
                                        <f:facet name="header"><h:outputText value="N° TC"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdImmaTc1}"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="Nb Colis"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdNbreColis}" style="text-align:right"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="Poids"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdPoids}" rendered="#{docdet.vteprdPoids!=0}" style="text-align:right"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="Vol."/></f:facet>
                                        <h:outputText value="#{docdet.vteprdVolume}" rendered="#{docdet.vteprdVolume!=0}" style="text-align:right"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="H.T."/></f:facet>
                                        <h:outputText value="#{docdet.vteprdTotalHt}" rendered="#{docdet.vteprdTotalHt!=0}" style="text-align:right">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="TVA"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdTotalTva}" rendered="#{docdet.vteprdTotalTva!=0}" style="text-align:right">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right">
                                        <f:facet name="header"><h:outputText  value="TTC"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdTotalTtc}" rendered="#{docdet.vteprdTotalTtc!=0}" style="text-align:right">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}"/></f:facet>
                                        <h:outputText value="#{docdet.vteprdTc}" rendered="#{docdet.vteprdTc!=0}" style="text-align:right">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idDevis" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeFacture==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvModeFacture==1}">
                        <f:facet name="header"><h:outputText value="Devis"/></f:facet>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                            <h:column><h:outputText value="Numéro devis:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvNumDevis}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <f:selectItem itemLabel="Sélectionnez un devis" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesDevisItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.valideDevis}" reRender="idPanGlobal,ppgrp"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGroup id="ppgrp">
                        <center>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.validerListeProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelLettreVoiture,tableLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_valide_lv&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelProduit" width="800" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelProduit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.showModalPanelProduit}" var="prd">
            <f:facet name="header"><h:outputText value="Gestion des produits de la LV N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestLigne.vtelvNum}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.fermerProduit}" image="/images/close.gif" styleClass="hidelink" reRender="panelProduit"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  style="width:100%;" id="idPanelProduit">
                    <rich:panel  style="width:100%;" id="idProduit">
                        <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" id="idProdTc">
                            <h:column><h:outputText value="Produit:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdRefTypeColis}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <f:selectItem itemLabel="Sélectionnez un produit" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesProduitsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculProduit}" reRender="idPanelProduit,idProduit,valProd,idPrix"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Mode facturation produit:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <f:selectItem itemLabel="Non facturé" itemValue="0"/>
                                    <f:selectItem itemLabel="Facture Groupage" itemValue="1"/>
                                    <f:selectItem itemLabel="Facture Colis" itemValue="2"/>
                                    <f:selectItem itemLabel="Facture TC" itemValue="3"/>
                                    <f:selectItem itemLabel="Facture Traction" itemValue="4"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculProduit}" reRender="idProduit,idPrix,idProdTc"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:outputText value="N° Conteneur 1:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.contenerMANIFEST=='0'}" var="tcman">
                                    <h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdImmaTc1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.contenerMANIFEST=='1'}" var="tcprc">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdImmaTc1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                        <f:selectItem itemLabel="Sélectionnez un Conteneur 1" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesContenerItems}"/>
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:outputText value="N° Plomb 1:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdPlombTc1}" style="width:100%" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:outputText value="N° Conteneur 2:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.contenerMANIFEST=='0'}" var="tc1man">
                                    <h:inputText style="width:100%" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdImmaTc2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.optionParcs.contenerMANIFEST=='1'}" var="tc1prc">
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdImmaTc2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                        <f:selectItem itemLabel="Sélectionnez un Conteneur 2" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.mesContener1Items}"/>
                                    </h:selectOneMenu>
                                </c:if>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:outputText value="N° Plomb 2:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdModeFactureDetail==3}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdPlombTc2}" style="width:100%" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Observation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdDescription}" style="width:100%" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="6" styleClass="fichefournisseur1" columnClasses="clos15,clos15g,clos15,clos15g,clos15,clos15g">
                            <h:column><h:outputText value="Nb colis/TC/traction:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdNbreColis}" style="width:100%;text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Poids (kgr):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdPoids}" style="width:100%;text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                            <h:column><h:outputText value="Volume (m3):"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdVolume}" style="width:100%;text-align:right"disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/></h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid width="100%" id="idPrix" columns="6" styleClass="fichefournisseur" columnClasses="clos15,clos15g,clos15,clos15g,clos15,clos15g">
                            <h:column><h:outputText value="Prix unitaire:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdPu}" style="width:100%;text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculPrix}" reRender="idPrix"/>
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Remise:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdRemise}" style="width:100%;text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.calculPrix}" reRender="idPrix"/>
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Prix remisé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdPuRem}" style="width:100%;text-align:right" disabled="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total HT:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdTotalHt}" style="width:100%;text-align:right" disabled="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="TVA:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdCodeTva}" style="width:100%;text-align:center" disabled="true"/></h:column>
                            <h:column><h:outputText value="Total TVA:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdTotalTva}" style="width:100%;text-align:right" disabled="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total TTC:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdTotalTtc}" style="width:100%;text-align:right" disabled="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_libelle}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_tc_type!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.manifestProduit.vteprdTc}" style="width:100%;text-align:right" disabled="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:panel>
                    <h:panelGroup id="valProd">
                        <center>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.validerProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelProduit,tableDetailLigne,ppgrp" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_valide_prd&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formManifestePrc.var_aff_action_lv}"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
