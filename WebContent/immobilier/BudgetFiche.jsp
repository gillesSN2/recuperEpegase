<%@page language="java" contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheBudget">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DETAIL DU BUDGET" style="color:green;"/></h2></center>

        <h:panelGrid id="panelPage" width="100%">

            <h:panelGrid id="idBien" width="100%" styleClass="fichefournisseur">

                <h:panelGrid columns="6" width="100%">
                    <h:column><h:outputText value="Identification du bien:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_bienSyndic}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                            <f:selectItem itemLabel="Sélection du bien" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.mesBiensSyndics}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.calculBien}" reRender="idPoste,panelValide,panelBoutonPoste"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Numéro Budget:"/></h:column>
                    <h:column><h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentNum}" readonly="true" disabled="true"/></h:column>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                            <f:selectItem itemLabel="NORMAL" itemValue="0"/>
                            <f:selectItem itemLabel="EXCEPTIONNEL" itemValue="1"/>
                            <f:selectItem itemLabel="FONDS ROULEMENT" itemValue="2"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPoste,panelValide,panelBoutonPoste"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="6" width="100%">
                    <h:column><h:outputText value="Année:"/></h:column>
                    <h:column><h:inputText size="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentAnnee}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}"/></h:column>
                    <h:column><h:outputText value="Date début:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}"/></h:column>
                    <h:column><h:outputText value="Date de fin:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}"/></h:column>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGrid id="idPoste" width="100%">

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">
                    <rich:tab id="tabPoste" label="Postes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode==2}">
                        <h:panelGrid id="panelBoutonPoste" width="200px" columns="3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_bienSyndic!=0}">
                            <a4j:commandButton title="Ajouter nouveau poste" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.ajouterPoste}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPoste"/>
                            <a4j:commandButton title="Modifier le poste sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibilitePoste&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.modifierPoste}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPoste"/>
                            <a4j:commandButton title="Supprimer le poste sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.visibilitePoste&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bail sélectionné ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.supprimerPoste}" reRender="tablePoste,scrollTablePoste,panelBoutonPoste,panelTotal"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.pageIndex}" reRender="tablePoste" id="scrollTablePoste" maxPages="20" align="left" for="tablePoste" />
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tablePoste" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.datamodelPoste}" var="pos">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.selectionPoste}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPoste"/>
                                <rich:column label="Code du poste" sortable="true" width="100px" sortBy="#{pos.biebudligCode}">
                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                    <h:outputText value="#{pos.biebudligCode}"/>
                                </rich:column>
                                <rich:column label="Libellé du poste" sortable="true" width="300px" sortBy="#{pos.biebudligLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                                    <h:outputText value="#{pos.biebudligLibelle}"/>
                                </rich:column>
                                <rich:column label="Type du poste" sortable="true" width="100px" sortBy="#{pos.libelleType}">
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText value="#{pos.libelleType}"/>
                                </rich:column>
                                <rich:column label="Montant Antérieur" sortable="true" width="120px" sortBy="#{pos.biebudligResteAnterieur}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Reliquat N-1" /></f:facet>
                                    <h:outputText value="#{pos.biebudligResteAnterieur}" rendered="#{pos.biebudligResteAnterieur!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Budget poste" sortable="true" width="120px" sortBy="#{pos.biebudligMontant}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Budget" /></f:facet>
                                    <h:outputText value="#{pos.biebudligMontant}" rendered="#{pos.biebudligMontant!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant Dépenses" sortable="true" width="120px" sortBy="#{pos.biebudligDepenses}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Dépenses" /></f:facet>
                                    <h:outputText value="#{pos.biebudligDepenses}" rendered="#{pos.biebudligDepenses!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant Dépenses non imputées" sortable="true" width="120px" sortBy="#{pos.biebudligDepensesNonImpute}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Non Imputées" /></f:facet>
                                    <h:outputText value="#{pos.biebudligDepensesNonImpute}" rendered="#{pos.biebudligDepensesNonImpute!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Montant Disponible" sortable="true" width="120px" sortBy="#{pos.biebudligEcart}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Disponibles" /></f:facet>
                                    <h:outputText value="#{pos.biebudligEcart}" rendered="#{pos.biebudligEcart!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="% d'exécution" sortable="true" width="100px" sortBy="#{pos.biebudligRealisation}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:outputText value="#{pos.biebudligRealisation}" rendered="#{pos.biebudligRealisation!=0}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>

                        <h:panelGrid id="panelTotal" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Reliquat N-1:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentResteAnterieur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total budget:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_budget}" readonly="true" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total dépenses:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_depenses}" readonly="true" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Montant disponible:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_ecart}" readonly="true" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="% exécution:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_pourcentage}" readonly="true" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Montant honoraires:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentHonoraire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Copropriété:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentIdCoproprietaire}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                                    <f:selectItem itemLabel="Sélectionnez copropriété" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.mesCoproprietaireItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabPosteExcep" label="Budget Exceptionnel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode==1}">
                        <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Objet du budget:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}"/></h:column>
                            <h:column><h:outputText value="Total budget:"/></h:column>
                            <h:column>
                                <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentTotal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action>=20}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabFactures" label="Appels de charges" >
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.pageIndex}" reRender="tableFacture" id="scrollTableFacture" maxPages="20"align="left" for="tableFacture"/>
                            <rich:extendedDataTable groupingColumn="idProprietaire" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formAppelChargeImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableFacture" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.datamodelAppelCharges}" var="var">
                                <rich:column label="Numéro de facture" sortable="true" width="100px" sortBy="#{var.appchaNum}">
                                    <f:facet name="header"><h:outputText  value="N° Facture" /></f:facet>
                                    <h:outputText value="#{var.appchaNum}"/>
                                </rich:column>
                                <rich:column id="idEtat" label="Etat de l'appel de charge" sortable="true" width="70px" sortBy="#{var.libelleEta}">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:outputText value="#{var.libelleEta}"/>
                                </rich:column>
                                <rich:column label="Mode de l'appel de charge" sortable="true" width="70px" sortBy="#{var.libelleMode}">
                                    <f:facet name="header"><h:outputText  value="Mode" /></f:facet>
                                    <h:outputText value="#{var.libelleMode}"/>
                                </rich:column>
                                <rich:column label="Date facture" sortable="true" width="100px" sortBy="#{var.appchaDate}">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{var.appchaDate}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column id="idProprietaire" label="Nom du propriétaire" sortable="true" width="200px" sortBy="#{var.appchaNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                    <h:outputText value="#{var.appchaNomTiers}"/>
                                </rich:column>
                                <rich:column label="Objet" sortable="true" width="150px" sortBy="#{var.appchaObject}">
                                    <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                    <h:outputText value="#{var.appchaObject}"/>
                                </rich:column>
                                <rich:column label="Bien" sortable="true" width="90px" sortBy="#{var.appchaBien}">
                                    <f:facet name="header"><h:outputText  value="Bien" /></f:facet>
                                    <h:outputText value="#{var.appchaBien}"/>
                                </rich:column>
                                <rich:column label="Total T.T.C." sortable="true" width="100px" sortBy="#{var.appchaTotTtc}"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="T.T.C." /></f:facet>
                                    <h:outputText value="#{var.appchaTotTtc}" rendered="#{var.appchaTotTtc!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Reglement" sortable="true" width="100px" sortBy="#{var.appchaTotReglement}"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Réglement" /></f:facet>
                                    <h:outputText value="#{var.appchaTotReglement}" rendered="#{var.appchaTotReglement!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Solde" sortable="true" width="100px" sortBy="#{var.var_reliquat}"  style="text-align:right;color:red">
                                    <f:facet name="header"><h:outputText  value="Solde" /></f:facet>
                                    <h:outputText value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabTravaux" label="Travaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.pageIndex}" reRender="tableOt" id="scrollTableOt" maxPages="20"align="left" for="tableOt"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableOt" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.datamodelTravaux}" var="trv">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,intpSOLDE,intpTTCE,intpRGLMTE"/>
                                <rich:column label="Numéro de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentNum}">
                                    <f:facet name="header"><h:outputText  value="N° OT" /></f:facet>
                                    <h:outputText value="#{trv.bietraentNum}"/>
                                </rich:column>
                                <rich:column label="Date début de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentDateDebut}">
                                    <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                                    <h:outputText value="#{trv.bietraentDateDebut}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Objet des travaux" sortable="true" width="300px" sortBy="#{trv.bietraentObjet}">
                                    <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                    <h:outputText value="#{trv.bietraentObjet}"/>
                                </rich:column>
                                <rich:column label="Date fin de l'OT" sortable="true" width="100px" sortBy="#{trv.bietraentDateFin}">
                                    <f:facet name="header"><h:outputText  value="Fin" /></f:facet>
                                    <h:outputText value="#{trv.bietraentDateFin}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date controle" sortable="true" width="100px" sortBy="#{trv.bietraentDateCtrl}">
                                    <f:facet name="header"><h:outputText  value="Date Ctrl" /></f:facet>
                                    <h:outputText value="#{trv.bietraentDateCtrl}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Rapport controle" sortable="true" width="150px" sortBy="#{trv.bietraentRapportCtrl}">
                                    <f:facet name="header"><h:outputText  value="Controle" /></f:facet>
                                    <h:outputText value="#{trv.bietraentRapportCtrl}"/>
                                </rich:column>
                                <rich:column label="Nom du controleur" sortable="true" width="200px" sortBy="#{trv.bietraentNomCtrl}">
                                    <f:facet name="header"><h:outputText  value="Controleur" /></f:facet>
                                    <h:outputText value="#{trv.bietraentNomCtrl}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabDepenses" label="Dépenses" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetEntete.biebudentMode==0}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formTravauxImmobilier.pageIndex}" reRender="tableDepenses" id="scrollTableDepenses" maxPages="20"align="left" for="tableDepenses"/>
                            <rich:extendedDataTable border="0" enableContextMenu="false" id="tableDepenses" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.datamodelFactureTravaux}" var="dep">
                                <rich:column label="Numéro facture" sortable="true" width="80px" sortBy="#{dep.bietraligNumFacture}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{dep.bietraligNumFacture}"/>
                                </rich:column>
                                <rich:column label="Date facture" sortable="true" width="80px" sortBy="#{dep.bietraligDateFacture}">
                                    <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                    <h:outputText value="#{dep.bietraligDateFacture}">
                                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Fournisseur" sortable="true" width="200px" sortBy="#{dep.bietraligNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Fournisseur" /></f:facet>
                                    <h:outputText value="#{dep.bietraligNomTiers}"/>
                                </rich:column>
                                <rich:column label="Poste" sortable="true" width="100px" sortBy="#{dep.bietraligPoste}">
                                    <f:facet name="header"><h:outputText  value="Poste" /></f:facet>
                                    <h:outputText value="#{dep.bietraligPoste}"/>
                                </rich:column>
                                <rich:column label="H.T." sortable="true" width="100px" sortBy="#{dep.bietraligHt}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="H.T." /></f:facet>
                                    <h:outputText value="#{dep.bietraligHt}" rendered="#{dep.bietraligHt!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Tva" sortable="true" width="100px" sortBy="#{dep.bietraligTva}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                                    <h:outputText value="#{dep.bietraligTva}" rendered="#{dep.bietraligTva!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="TTC" sortable="true" width="100px" sortBy="#{dep.bietraligTtc}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="TTC" /></f:facet>
                                    <h:outputText value="#{dep.bietraligTtc}" rendered="#{dep.bietraligTtc!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Objet" sortable="true" width="200px" sortBy="#{dep.bietraligObjetFacture}">
                                    <f:facet name="header"><h:outputText  value="Objet" /></f:facet>
                                    <h:outputText value="#{dep.bietraligObjetFacture}"/>
                                </rich:column>
                                <rich:column label="Pièces jointes" sortable="true" width="80px" sortBy="#{dep.pj}" style="text-align:center;">
                                    <f:facet name="header"><h:outputText value="PJ"/></f:facet>
                                    <h:graphicImage value="#{dep.pj}" height="20px" width="20px" rendered="#{dep.pj!=null}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>

            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.annulerBudget}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.validerBudget}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_bienSyndic!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.var_action<=20}"onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                </center>
            </h:panelGroup>

        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelPoste" headerClass="headerPanel" width="700" height="330" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.showModalPanelPoste}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.showModalPanelPoste}" var="pst">
            <f:facet name="header"><h:outputText value="DESCRIPTION DU POSTE BUDGETAIRE"></h:outputText></f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur" id="idCalcul">
                    <h:column><h:outputText value="Code du poste:"/></h:column>
                    <h:column><h:inputText size="8" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligCode}" /></h:column>
                    <h:column><h:outputText value="Libellé poste"/></h:column>
                    <h:column><h:inputText style="width:95%" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligLibelle}"/></h:column>
                    <h:column><h:outputText value="Type de facture:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligType}" style="width:95%;">
                            <f:selectItem itemLabel="Facture via travaux" itemValue="0"/>
                            <f:selectItem itemLabel="Facture directe" itemValue="1"/>
                            <f:selectItem itemLabel="Paye" itemValue="2"/>
                            <f:selectItem itemLabel="Mixte" itemValue="9"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Reliquat N-1:"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligResteAnterieur}" readonly="true" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Montant budget:"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligMontant}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.calculTotalBudgetPoste}" reRender="idCalcul"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Total dépenses"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligDepenses}" readonly="true" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Total disponble"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligEcart}" readonly="true" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="% exécution"/></h:column>
                    <h:column>
                        <h:inputText style="text-align:right" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.bienBudgetLigne.biebudligRealisation}" readonly="true" disabled="true">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGroup id="panelValidePoste">
                    <center>
                        <br><br>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.annulerPoste}" reRender="panelPoste,panelTotal,tablePoste,scrollTablePoste"/>&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBudgetImmobilier.validerPoste}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelPoste,panelTotal,tablePoste,scrollTablePoste"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
