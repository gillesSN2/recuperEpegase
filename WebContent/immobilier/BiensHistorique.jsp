<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bienhistoriqueliste">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="HISTORIQUE DU BIEN (Propriétaires et ventes)" style="color:green;"/></h2></center>

        <center>
            <jsp:include flush="true" page="BiensCommunHistorique.jsp"/>
            <h:panelGrid width="100%">
                <h:panelGrid id="panelBoutonHistorique" columns="3" width="250px" style="height:34px">
                    <a4j:commandButton title="Ajouter nouvelle vente" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterHistorique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistorique"/>
                    <a4j:commandButton title="Modifier la vente sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibleHistorique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifierHistorique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistorique"/>
                    <a4j:commandButton title="Supprimer la vente sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibleHistorique&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bien ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerHistorique}" reRender="scrollHistorique,tableHistorique,panelBoutonHistorique,idVente"/>
                </h:panelGrid>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.pageIndex}" reRender="table" id="scrollHistorique" maxPages="20"align="left" for="tableHistorique"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBailImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableHistorique" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelHistorique}" var="var">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionnerHistorique}" reRender="panelBoutonHistorique"/>
                        <rich:column label="Ancien Propriétaire" sortable="true" sortBy="#{var.biehisNomOldProprietaire}" width="20%">
                            <f:facet name="header"><h:outputText value="Ancien Propriétaire"/></f:facet>
                            <h:outputText value="#{var.biehisCivilOldProprietaire} #{var.biehisNomOldProprietaire}"/>
                        </rich:column>
                        <rich:column label="Nouveau Propriétaire" sortable="true" sortBy="#{var.biehisNomNewProprietaire}" width="20%">
                            <f:facet name="header"><h:outputText value="Nouveau Propriétaire"/></f:facet>
                            <h:outputText value="#{var.biehisCivilNewProprietaire} #{var.biehisNomNewProprietaire}"/>
                        </rich:column>
                        <rich:column label="Date vente" sortable="true" sortBy="#{var.biehisDateVente}" width="10%">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.biehisDateVente}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant vente" sortable="true" sortBy="#{var.biehisMontant}" style="text-align:right;" width="10%">
                            <f:facet name="header"><h:outputText  value="Montant vente"  /></f:facet>
                            <h:outputText  value="#{var.biehisMontant}" rendered="#{var.biehisMontant!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Etude" sortable="true" sortBy="#{var.biehisEtude}" width="20%">
                            <f:facet name="header"><h:outputText value="Etude"/></f:facet>
                            <h:outputText  value="#{var.biehisEtude}"/>
                        </rich:column>
                        <rich:column label="Notaire" sortable="true" sortBy="#{var.biehisNomNotaire}" width="20%">
                            <f:facet name="header"><h:outputText value="Notaire"/></f:facet>
                            <h:outputText  value="#{var.biehisNomNotaire}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </center>

        <h:panelGroup id="panelValide">
            <center>
                <br><br>
                <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.retourHistorique}"/>
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelHistorique" headerClass="headerPanel" width="700" height="330" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelHistorique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelHistorique}" var="his">
            <f:facet name="header"><h:outputText value="DESCRIPTION D'UN HISTORIQUE DE VENTE"></h:outputText></f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur" id="idCalcul">
                    <h:column><h:outputText value="Propriétaire actuel:"/></h:column>
                    <h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart}" var="happ2">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienAppartement.bieNomTiers}" disabled="true" readonly="true" style="width:95%"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau}" var="hbur2">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienBureau.bieNomTiers}" disabled="true" readonly="true" style="width:95%"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking}" var="hprk2">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienParking.bieNomTiers}" disabled="true" readonly="true" style="width:95%"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking==false}" var="hbien2">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNomTiers}" disabled="true" readonly="true" style="width:95%"/>
                        </c:if>
                    </h:column>
                    <h:column><h:outputText value="Date vente:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienHistorique.biehisDateVente}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    <h:column><h:outputText value="Montant vente:"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienHistorique.biehisMontant}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nouveau propriétaire:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienHistorique.biehisIdNewProprietaire}" style="width:95%;">
                            <f:selectItem itemLabel="Sélectionner un propriétaire" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.mesProprietaires}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Etude notariale:"/></h:column>
                    <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienHistorique.biehisEtude}" style="width:95%"/></h:column>
                    <h:column><h:outputText value="Nom notaire:"/></h:column>
                    <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bienHistorique.biehisNomNotaire}" style="width:95%"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="panelValideHistorique">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fermerHsitorique}" reRender="panelHistorique,panelTotal,tablePoste,scrollTablePoste"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.validerHsitorique}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelHistorique,scrollHistorique,tableHistorique,panelBoutonHistorique,idVente"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
