<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="productionlistepoulet">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES PRODUCTIONS AVICULTURES" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="6" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}"/>
                    <h:column>
                        <h:selectOneMenu id="serie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpSerie}" style="width:100px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}" />
                            <a4j:support eventsQueue="maQueue" reRender="test,btImputSerie,panelBouton" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibleImputSerie}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpEtat}" style="width:100px;">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesEtatsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpActivite}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_activite}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,table,scrollTable,pnlgrttotalLE"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panDest" columns="7" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_more_search}">
                    <h:column>
                        <h:selectOneMenu id="parc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpParc}" style="width:150px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_parc}">
                            <f:selectItem itemLabel="Tous Parcs" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesParcsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:outputText value="Dossier:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_dossier}"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpDossier}" style="width:150px;"/>
                    </h:column>
                    <h:column><h:outputText value="Du"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Au"/></h:column>
                    <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="panelBouton" columns="4" width="200px" style="height:34px">
            <a4j:commandButton title="Modifier le planning" image="/images/calendrier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.modifierPoulet}" reRender="panelPlanning"/>
            <a4j:commandButton title="Consulter la production sélectionnée" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.consulterPoulet}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}"/>
            <a4j:commandButton title="Grapher" image="/images/grapheur.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}" reRender="panelGraph,formModalGraph,container" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.initGrapheur}"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="180%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelEntete}" var="var">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.selectionLignePoulet}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                        <rich:column label="N° réception" sortable="true" sortBy="#{var.recNum}">
                            <f:facet name="header"><h:outputText  value="N° REC" /></f:facet>
                            <h:outputText value="#{var.recNum}"/>
                        </rich:column>
                        <rich:column label="N° dossier" sortable="true" sortBy="#{var.recAnal4}">
                            <f:facet name="header"><h:outputText  value="N° DOS." /></f:facet>
                            <h:outputText value="#{var.recAnal4}"/>
                        </rich:column>
                        <rich:column label="N° lot" sortable="true" sortBy="#{var.recProduction}">
                            <f:facet name="header"><h:outputText  value="N° LOT" /></f:facet>
                            <h:outputText value="#{var.recProduction}"/>
                        </rich:column>
                        <rich:column label="Date réception" sortable="true" sortBy="#{var.recDate} #{var.recNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.recDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column id="idEtat"  label="Etat" sortable="true" sortBy="#{var.recEtat}" width="50px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{var.libelleEta}"/>
                        </rich:column>
                        <rich:column id="idTrf"  label="Transfert" sortable="true" sortBy="#{var.var_select_ligne}" width="50px" style="text-align:center;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.trf}">
                            <f:facet name="header"><h:outputText  value="Trf." /></f:facet>
                            <h:selectBooleanCheckbox value="#{var.var_select_ligne}" rendered="#{(var.recEtat==1||var.recEtat==4)&&var.recSerie!='X'}"/>
                        </rich:column>
                        <rich:column label="Fournisseur" sortable="true" sortBy="#{var.var_nom_tiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="Fournisseur"  /></f:facet>
                            <h:outputText  value="#{var.var_nom_tiers}"/>
                        </rich:column>
                        <rich:column label="Quantité reçue" sortable="true" sortBy="#{var.recTotQte}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Qte" /></f:facet>
                            <h:outputText value="#{var.recTotQte}" rendered="#{var.recTotQte!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Objet" sortable="true" sortBy="#{var.recObject}" width="200px">
                            <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                            <h:outputText  value="#{var.recObject}"/>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.recSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.recSerie}"/>
                        </rich:column>
                        <rich:column label="Activité commerciale" sortable="true" sortBy="#{var.recActivite}" >
                            <f:facet name="header"><h:outputText value="Activité"  /></f:facet>
                            <h:outputText  value="#{var.recActivite}"/>
                        </rich:column>
                        <rich:column label="Parc" sortable="true" sortBy="#{var.recAnal2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_anal_parc}">
                            <f:facet name="header"><h:outputText value="Parc"  /></f:facet>
                            <h:outputText  value="#{var.recAnal2}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="2" cellspacing="1" styleClass="recherche"  width="100%">
                <h:panelGrid id="pnlgrttotalTTC" columns="2" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpTTCL" value="Total Valorisation" />
                    <h:inputText id="intpTTCL" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.montantPump}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>                   
                </h:panelGrid>
                <h:panelGrid id="pnlgrttotalLE" columns="1" cellspacing="3"  cellpadding="3">
                    <h:outputText id="outpLIST" value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_nb_ligne})" />
                    <h:outputText id="outpELMT" value="(Eléments sélectionnés)" />
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelPlanning" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="520" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPlanning}" var="plg">
            <f:facet name="header"><h:outputText value="Gestion du planning"/></f:facet>
            <a4j:form id="formModalPlanning">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" id="idPanGlobal">
                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Jour sélectionné:"/></h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.dateJour}" style="width:90%">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.lesDatesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.chargerJour}" reRender="idPanGlobal"/>
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Nombre individus J-1:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.nbIndividusAnte}" size="5" style="text-align:right;" disabled="true" readonly="true">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Nombre mortalité du jour:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviNbMortaliteReel}" size="5" style="text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.calculReste}" reRender="idPanGlobal,idReste"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nombre restant:"/></h:column>
                        <h:column>
                            <h:inputText id="idReste" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.nbIndividusReste}" size="5" style="text-align:right;" disabled="true" readonly="true">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>

                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabMesure" label="Mesure">
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50">
                                <h:panelGrid columns="2" width="100%" columnClasses="clos70,clos30" styleClass="fichefournisseur" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="INFORMATIONS THEORIQUES"/></f:facet>
                                    <h:column><h:outputText value="Nombre mortalité:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviNbMortalite}" size="5" style="text-align:right;" disabled="true" readonly="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Poids (gr):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviPoids}" size="5" style="text-align:right;" disabled="true" readonly="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Température (C°):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTemperature}" size="5" style="text-align:right;" disabled="true" readonly="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Quantité d'eau (ml):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteEau}" size="5" style="text-align:right;" disabled="true" readonly="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Quantité d'aliment (gr):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteAliment}" size="5" style="text-align:right;" disabled="true" readonly="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" columnClasses="clos70,clos30" styleClass="fichefournisseur" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="INFORMATIONS REELLES"/></f:facet>
                                    <h:column><h:outputText value="Nombre mortalité du jour:"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviNbMortaliteReel}" size="5" style="text-align:right;" disabled="true" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Poids (gr):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviPoidsReel}" size="5" style="text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Température (C°):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTemperatureReel}" size="5" style="text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Quantité d'eau (ml):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteEauReel}" size="5" style="text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Quantité d'aliment (gr):"/></h:column>
                                    <h:column>
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteAlimentReel}" size="5" style="text-align:right;" onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabAction" label="Actions">
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50">
                                <h:panelGrid columns="2" width="100%" columnClasses="clos30,clos70" styleClass="fichefournisseur" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="INFORMATIONS THEORIQUES"/></f:facet>
                                    <h:column><h:outputText value="Action 1:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction1}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Action 2:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction2}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Action 3:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction3}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Traitement 1:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement1}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Traitement 2:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement2}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Traitement 3:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement3}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Vaccin 1:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin1}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Vaccin 2:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin2}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Vaccin 3:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin3}" style="width:100%" disabled="true" readonly="true"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid columns="2" width="100%" columnClasses="clos30,clos70" styleClass="fichefournisseur" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="INFORMATIONS REELLES"/></f:facet>
                                    <h:column><h:outputText value="Action 1:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepAction1}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction1==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Action 2:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepAction2}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction2==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Action 3:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepAction3}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviAction3==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Traitement 1:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepTraitement1}" style="width:50%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement1==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteTraitement1}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement1==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Traitement 2:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepTraitement2}" style="width:50%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement2==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteTraitement2}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement2==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Traitement 3:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepTraitement3}" style="width:50%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement3==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteTraitement3}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviTraitement3==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Vaccin 1:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepVaccin1}" style="width:50%"disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin1==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteVaccin1}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin1==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Vaccin 2:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepVaccin2}" style="width:50%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin2==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteVaccin2}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin2==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Vaccin 3:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviRepVaccin3}" style="width:50%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin3==null}">
                                            <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                            <f:selectItem itemLabel="Pas Fait" itemValue="1"/>
                                            <f:selectItem itemLabel="Fait" itemValue="2"/>
                                            <f:selectItem itemLabel="Autre" itemValue="3"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:outputText value="Qte:"/>&nbsp;
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviQteVaccin3}" style="width:20%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionAvicultureAchats.recaviVaccin3==null}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:inputText>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanSerie" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fermerPlanning}" reRender="panelPlanning"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValSerie" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.validePlanning}" reRender="panelPlanning"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitation.jsp"/>
        </c:if>
    </rich:modalPanel>

</f:subview>
