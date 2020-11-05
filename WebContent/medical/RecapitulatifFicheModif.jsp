<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ficheRecapModif">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="DETAIL D'UN RECAP DE REFACTURATION" style="color:green;"/></h2></center>
        <h:panelGrid  id="panGlobal" width="100%">
            <h:panelGrid  id="panCtrlRecap" styleClass="recherche" width="100%">
                <h:panelGroup>
                    <h:column><h:outputText value="N° Récap.:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecNum}" disabled="true" readonly="true"/></h:column>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Date Récap.:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecDate}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action=='3'}"/></h:column>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Période du:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecDateDebut}" disabled="true" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Au:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecDateFin}" disabled="true" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:column><h:outputText value="Objet:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecNomAdherent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecIdAdherent!=0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action=='3'}"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecSecteurAgent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecSecteurAgent!=null}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action=='3'}"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.libelleFonds}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.recapitulatifMedical.facrecFondCnamgs!=0}"/>
                    </h:column>
                </h:panelGroup>
            </h:panelGrid>

            <h:panelGrid  id="panBouton" columns="2" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action=='2'}">
                <a4j:commandButton title="Ajouter nouvelle facture" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.ajouterFacture}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelAjoutFacture"/>
                <a4j:commandButton title="Supprimer la facture sélectionnée" image="/images/supprimer.png"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.supprimerFacture}" reRender="modAttente,table,pnlgrttotal,scrollTable,panBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.afficheBoutonFacture&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.sup}"/>
            </h:panelGrid>

            <center>
                <a4j:region id="idTable" renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelEntetesCtrl}"  var="var" activeRowKey="true" rowKeyVar="rkv" sortMode="multi" selectionMode="single">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionFacture}" reRender="panBouton"/>
                        <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.facNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.facDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.facDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début période" sortable="true" sortBy="#{var.facDateDebut}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{var.facDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin période" sortable="true" sortBy="#{var.facDateFin}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{var.facDateFin}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.facSerie}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{var.facCat}" width="100px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{var.facCat}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{var.facNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="tiers"  /></f:facet>
                            <h:outputText  value="#{var.facNomTiers}" />
                        </rich:column>
                        <rich:column label="Adhérent" sortable="true" sortBy="#{var.facNomAdherent}" width="200px">
                            <f:facet name="header"><h:outputText  value="Adhérent/localisation"  /></f:facet>
                            <h:outputText  value="#{var.facNomAdherent}" rendered="#{var.facIdAdherent!=0}"/>
                            <h:outputText  value="#{var.facSecteurAgent}" rendered="#{var.facSecteurAgent!=null}"/>
                            <h:outputText  value="#{var.libelleFonds}" rendered="#{var.facFondCnamgs!=0}"/>
                        </rich:column>
                        <rich:column label="Total T.T.C." sortable="true" sortBy="#{var.facTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                            <h:outputText  value="#{var.facTotTtc}" rendered="#{var.facTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </center>
            <br/>
            <h:panelGrid id="pnlgrttotal" columns="4" styleClass="recherche" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.tiersChargee}">
                <h:panelGrid columns="2" >
                    <h:outputText value="Total HT" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantTtc}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" >
                    <h:outputText  value="Total TVA" />
                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantReglement}" style="width:100%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="2" >
                    <h:outputText value="Total TTC" />
                    <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.montantSolde}" style="width:100%;text-align:right;color:red" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
                <h:panelGrid columns="1">
                    <h:outputText value="(Total liste : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_nb_ligne})" />
                </h:panelGrid>
            </h:panelGrid>
            <br/>
            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulerRecap}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.saveRecap}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.var_action=='2'}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelAjoutFacture" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAjoutFacture}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.showModalPanelAjoutFacture}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection de la facture"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableLigne" height="300px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.dataModelNouvelleFactures}" var="newFac">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.selectionNouvelleFacture}" />
                        <rich:column label="N° facture" sortable="true" sortBy="#{newFac.facNum}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{newFac.facNum}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{newFac.facDate}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{newFac.facDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début période" sortable="true" sortBy="#{newFac.facDateDebut}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{newFac.facDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date fin période" sortable="true" sortBy="#{newFac.facDateFin}" width="70px" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                            <h:outputText value="#{newFac.facDateFin}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{newFac.facSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{newFac.facSerie}"/>
                        </rich:column>
                        <rich:column label="Famille tarification" sortable="true" sortBy="#{newFac.facCat}" width="100px" style="text-align:center;">
                            <f:facet name="header"><h:outputText  value="Tar." /></f:facet>
                            <h:outputText value="#{newFac.facCat}"/>
                        </rich:column>
                        <rich:column label="Tiers" sortable="true" sortBy="#{newFac.facNomTiers}" width="200px">
                            <f:facet name="header"><h:outputText  value="tiers"  /></f:facet>
                            <h:outputText  value="#{newFac.facNomTiers}" />
                        </rich:column>
                        <rich:column label="Adhérent" sortable="true" sortBy="#{newFac.facNomAdherent}" width="200px">
                            <f:facet name="header"><h:outputText  value="Adhérent/localisation"  /></f:facet>
                            <h:outputText  value="#{newFac.facNomAdherent}" rendered="#{newFac.facIdAdherent!=0}"/>
                            <h:outputText  value="#{newFac.facSecteurAgent}" rendered="#{newFac.facSecteurAgent!=null}"/>
                            <h:outputText  value="#{newFac.libelleFonds}" rendered="#{newFac.facFondCnamgs!=0}"/>
                        </rich:column>
                        <rich:column label="Total T.T.C." sortable="true" sortBy="#{newFac.facTotTtc}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C."/></f:facet>
                            <h:outputText  value="#{newFac.facTotTtc}" rendered="#{newFac.facTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.annulerAjoutFacture}" reRender="panelAjoutFacture"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formRefacturation.validerAjoutFacture}" reRender="panelAjoutFacture,table,scrollTable,pnlgrttotal"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
