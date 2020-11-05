<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="inventaireliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES INVENTAIRES EN FORET" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
                <h:panelGrid columns="9" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_more_search}"/>
                    <h:column>
                        <h:outputText value="N°:"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpNum}" size="10"></h:inputText>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu id="idLieu" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpLieu}" style="width:150px;">
                            <f:selectItem itemLabel="Tous Chantiers" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesLieuxItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:selectOneMenu id="idPeriode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_more_search}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                    <h:column>
                        <h:selectOneMenu id="idEtat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.mesEtatsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Responsable:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpResponsable}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les responsables" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.rechercheResponsable}" reRender="idSubView,panCtrl,panDest,panelListeResponsable,formModalListeResponsable" />
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <h:outputText value="Equipe:" style="text-decoration:underline;"/>&nbsp;
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpEquipe}" size="10">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les équipes" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.rechercheEquipe}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panCtrl,panDest,panelListeCommercial,formModalListeCommercial"/>
                        </h:inputText>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,table,scrollTable,pnlgrttotal"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="5" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_more_search}">
                    <h:column>
                        <h:outputText value="Série:"/>&nbsp;
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesSerieUserItem}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="11" width="400px" style="height:34px">
            <a4j:commandButton title="Ajouter nouvelle inventaire" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.ajoutDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le document sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.modifDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.consultDocument}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le document sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le(s) document(s) ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.supprimerDocument}" reRender="table,panelBouton,intpTTCL,intpRGLMTL,intpSOLDL"/>
            <a4j:commandButton title="Annuler le document sélectionné" image="/images/annuler_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.sup}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.annulerDocument}" reRender="panelAnnuler"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.initGrapheur}"/>
            <a4j:commandButton title="Changer la série" image="/images/imputer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrModifSerieVte==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat<=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.accesImputSerie}" reRender="panelimpSerie" />
            <a4j:commandButton title="Valider le document sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.valideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir valider le(s) document(s) ?')) return false" reRender="panelBouton,table,idEtat,idTrf"/>
            <a4j:commandButton title="Dé-Valider le document sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvEtat!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menuforet.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.deValideDocument}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider le(s) document(s) ?')) return false" reRender="panelBouton,table,idEtat,idTrf"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_nb_max}" style="max-height:100%;" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.datamodelDocument}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.visualisationLigne}" reRender="idSubView,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° Campagne" sortable="true" sortBy="#{var.forinvNum}" width="90px">
                            <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                            <h:outputText value="#{var.forinvNum}"/>
                        </rich:column>
                        <rich:column label="Date Inventaire" sortable="true" sortBy="#{var.forinvDate} #{var.forinvNum}" width="80px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.forinvDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Chantier" sortable="true" sortBy="#{var.forinvChantier}" width="70px">
                            <f:facet name="header"><h:outputText  value="Chantier"/></f:facet>
                            <h:outputText value="#{var.forinvChantier}"/>
                        </rich:column>
                        <rich:column label="Marteau" sortable="true" sortBy="#{var.forinvMarteau}" width="70px">
                            <f:facet name="header"><h:outputText  value="Marteau"/></f:facet>
                            <h:outputText value="#{var.forinvMarteau}"/>
                        </rich:column>
                        <rich:column id="idEtat" label="Etat" sortable="true" sortBy="#{var.forinvEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf" label="Sélection" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}"/>
                        </rich:column>
                        <rich:column label="Responsable" sortable="true" sortBy="#{var.forinvNomResponsable}" width="180px">
                            <f:facet name="header"><h:outputText  value="Responsable"/></f:facet>
                            <h:outputText  value="#{var.forinvNomResponsable}"/>
                        </rich:column>
                        <rich:column label="Equipe" sortable="true" sortBy="#{var.forinvNomEquipe}" width="180px">
                            <f:facet name="header"><h:outputText  value="Equipe"/></f:facet>
                            <h:outputText  value="#{var.forinvNomEquipe}"/>
                        </rich:column>
                        <rich:column label="Total nb arbre" sortable="true" sortBy="#{var.forinvTotArbre}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Nb arbre"/></f:facet>
                            <h:outputText  value="#{var.forinvTotArbre}" rendered="#{var.forinvTotArbre!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Total cubage" sortable="true" sortBy="#{var.forinvTotCub}" style="text-align:right">
                            <f:facet name="header"><h:outputText  value="Cubage"/></f:facet>
                            <h:outputText  value="#{var.forinvTotCub}" rendered="#{var.forinvTotCub!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="3" cellspacing="1" styleClass="recherche"  width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrVteTotaux==0}">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total Arbre" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.totalArbre}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalRGLMT" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpRGLMTL" value="Total Cubage" />
                    <h:inputText id="intpRGLMTL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.totalCubage}" style="width:100%;text-align:right;" readonly="true">
                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="3" maxFractionDigits="3"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_nb_ligne})" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelAnnuler" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelAnnuler}" var="ser">
            <f:facet name="header"><h:outputText value="Annulation inventaire"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.annuleAnnulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelAnnuler"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Date annulation:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvDateAnnule}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Motif annulation:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.foretInventaire.forinvMotifAnnule}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.miseajourAnnuler}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelGraph" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="300" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelGraph}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelGraph}" var="grp">
            <f:facet name="header"><h:outputText value="Paramêtre du graphique"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.fermerGrapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelGraph"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalGraph">
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Type valeur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.valQteGraph}" >
                                <f:selectItem itemLabel="En nombre" itemValue="0"/>
                                <f:selectItem itemLabel="En nombre de document" itemValue="1"/>
                                <f:selectItem itemLabel="En cubage" itemValue="2"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Analyse:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.modeGraph}">
                                <f:selectItem itemLabel="en global" itemValue="0"/>
                                <f:selectItem itemLabel="par responsable" itemValue="1"/>
                                <f:selectItem itemLabel="par équipe" itemValue="2"/>
                                <f:selectItem itemLabel="par commercial" itemValue="3"/>
                                <f:selectItem itemLabel="par série" itemValue="4"/>
                                <f:selectItem itemLabel="par chantier" itemValue="5"/>
                                <f:selectItem itemLabel="par marteau" itemValue="6"/>
                                <f:selectItem itemLabel="par essence" itemValue="20"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Regroupement par:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.timeDecoupage}">
                                <f:selectItem itemLabel="jour" itemValue="0"/>
                                <f:selectItem itemLabel="mois" itemValue="1"/>
                                <f:selectItem itemLabel="trimestre" itemValue="2"/>
                                <f:selectItem itemLabel="semestre" itemValue="3"/>
                                <f:selectItem itemLabel="année" itemValue="4"/>
                                <f:selectItem itemLabel="tranche horaire" itemValue="5"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.hideModele}" reRender="idResultat"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <br/>
                <h:panelGroup id="idResultat">
                    <center>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.grapher}" value="Calcul graphique"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idResultat"/>
                        <br/><br/>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModele}">
                            <jsp:include flush="true" page="/commun/impressionGraphiqueModele.jsp"/>
                        </h:panelGroup>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelimpSerie" width="400" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelImput}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.showModalPanelImput}" var="imp">
            <f:facet name="header"><h:outputText value="Imputation Série"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.annuleImputSerie}" image="/images/close.gif" styleClass="hidelink" reRender="panelimpSerie"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:panel  style="width:100%;">
                    <h:panelGrid  columns="2" style="width:100%;">
                        <h:column><h:outputText value="Série imputée:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" id="serieimput"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.var_imput_serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.mesSerieUserItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:panel>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.formForetInventaire.miseajourImput}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
