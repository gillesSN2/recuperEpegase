<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<a4j:form id="formAnal">
    <rich:hotKey key="return" handler="return false;"/>
    <h:panelGrid columns="6" columnClasses="clos12d,clos12d,clos12d,clos12d,clos12d,clos40" width="100%" headerClass="headerTab">
        <h:column><h:outputText value="Année:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_annee}" readonly="true" disabled="true"/></h:column>
        <h:column><h:outputText value="Réaménagement:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.lib_reamenagement}" readonly="true" disabled="true"/></h:column>
        <h:column><h:outputText value="Libellé poste:"/></h:column>
        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.budCode} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.budget.budLibelleFr}" readonly="true" disabled="true" style="width:100%"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.afficheEntite}"><h:outputText value="Recopie valeur:" style="color:red"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.afficheEntite}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.recopieValeurposte}" style="color:red"/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.afficheEntite}"><h:outputText value=""/></h:column>
        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.afficheEntite}"><h:outputText value="(Dans même poste, toutes entités)" style="color:red"/></h:column>
    </h:panelGrid>
    <br>
    <h:panelGrid id="idPanAnal" width="100%" >
        <rich:tabPanel switchType="client"  immediate="true" style="border:0px;" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletActif}">

            <rich:tab id="idAxe00" label="Budget Global" >
                <h:panelGrid id="calcul" width="100%">
                    <h:panelGrid columns="2" width="100%" id="init">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Définition du montant annuel"/></f:facet>
                            <h:column><h:outputText value="Montant"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal}" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeRepartitionMontant}" reRender="calcul,repartitionMontant,idPanAnal"/>
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Définition des quantités annuelles"/></f:facet>
                            <h:column><h:outputText value="Quantité"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qteTotal}" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeRepartitionQte}" reRender="calcul,repartitionQte,idPanAnal"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.moduleImmobilier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_nature=='9'}">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" id="constructeurMontant">
                            <f:facet name="header"><h:outputText value="Ventilation du montant"/></f:facet>
                            <h:column><h:outputText value="Terrassement"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val01}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Fondation"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val02}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Gros oeuvre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val03}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Finition"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val04}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" id="constructeurQte">
                            <f:facet name="header"><h:outputText value="Ventilation des quantités"/></f:facet>
                            <h:column><h:outputText value="Terrassement"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte01}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Fondation"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte02}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Gros oeuvre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte03}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Finition"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte04}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos50,clos50" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.var_nature!='9'}">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" id="repartitionMontant">
                            <f:facet name="header"><h:outputText value="Ventilation du montant"/></f:facet>
                            <h:column><h:outputText value="Janvier"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val01}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Février"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val02}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Mars"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val03}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Avril"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val04}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Mai"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val05}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Juin"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val06}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Juillet"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val07}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Aout"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val08}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Septembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val09}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Octobre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val10}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Novembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val11}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Décembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.val12}" size="10" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulMontant}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" headerClass="headerTab" width="100%" id="repartitionQte">
                            <f:facet name="header"><h:outputText value="Ventilation des quantités"/></f:facet>
                            <h:column><h:outputText value="Janvier"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte01}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Février"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte02}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Mars"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte03}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Avril"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte04}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Mai"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte05}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Juin"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte06}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Juillet"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte07}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Aout"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte08}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Septembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte09}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Octobre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte10}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Novembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte11}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Décembre"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.qte12}" size="10" style="text-align:right">
                                    <a4j:support eventsQueue="maQueue"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.calculeCumulQte}" event="onchange" reRender="calcul,init" />
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe01" label="Site/Département/Service" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_site&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe01}"/>
                <h:panelGrid id="idPanAnalAxe1" width="100%">
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe01}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe01}" reRender="idPanAnalAxe1,idTable01,idEcar01,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable01" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe01}" var="axe1" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe01}" reRender="idDepartement1,idDepartement2,idService1,idService2"/>
                            <rich:column label="Site"  width="20%" >
                                <f:facet name="header"><h:outputText value="Site"/></f:facet>
                                <h:selectOneMenu style="width:100%" value="#{axe1.zoneSite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez Site" itemValue=""/>
                                    <f:selectItems value="#{axe1.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerDepartementsItems}" reRender="idTable01,idDepartement1,idDepartement2,idService1,idService2"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Département"  width="20%">
                                <f:facet name="header"><h:outputText value="Département"/></f:facet>
                                <h:selectOneMenu id="idDepartement1" style="width:100%" value="#{axe1.zoneDepartement}" rendered="#{!axe1.depVide}">
                                    <f:selectItem itemLabel="Sélectionnez Département" itemValue=""/>
                                    <f:selectItems value="#{axe1.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerServicesItems}" reRender="idTable01,idService1,idService2"/>
                                </h:selectOneMenu>
                                <h:outputText id="idDepartement2" value="#{axe1.ecranaDepartement}:#{axe1.ecranaDepartementLib}" rendered="#{axe1.depVide}"/>
                            </rich:column>
                            <rich:column label="Service"  width="20%">
                                <f:facet name="header"><h:outputText value="Service"/></f:facet>
                                <h:selectOneMenu id="idService1" style="width:100%" value="#{axe1.zoneService}" rendered="#{!axe1.serVide}">
                                    <f:selectItem itemLabel="Sélectionnez Service" itemValue=""/>
                                    <f:selectItems value="#{axe1.mesServicesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculerServicesItems}"/>
                                </h:selectOneMenu>
                                <h:outputText id="idService2" value="#{axe1.ecranaService}:#{axe1.ecranaServiceLib}" rendered="#{axe1.serVide}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe1.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne01}" reRender="idMontant01,idEcar01,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant01" value="#{axe1.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne01}" reRender="idTable01,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte01" value="#{axe1.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar01" style="text-align:right;color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe01==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart01}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe02" label="Région/Secteur/PDV" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_region&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe02}"/>
                <h:panelGrid id="idPanAnalAxe2" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe02}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe02}" reRender="idPanAnalAxe2,idTable02,idEcar02,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable02" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe02}" var="axe2" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe02}"/>
                            <rich:column label="Région"  width="20%" >
                                <f:facet name="header"><h:outputText value="Région"/></f:facet>
                                <h:selectOneMenu style="width:100%" value="#{axe2.zoneRegion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez Région" itemValue=""/>
                                    <f:selectItems value="#{axe2.mesRegionsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerSecteursItems}" reRender="idTable02,idSecteur1,idSecteur2,idPdv1,idPdv2"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Secteur"  width="20%">
                                <f:facet name="header"><h:outputText value="Secteur"/></f:facet>
                                <h:selectOneMenu id="idSecteur1" style="width:100%" value="#{axe2.zoneSecteur}" rendered="#{!axe2.secVide}">
                                    <f:selectItem itemLabel="Sélectionnez Secteur" itemValue=""/>
                                    <f:selectItems value="#{axe2.mesSecteursItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerPdvItems}" reRender="idTable02,idPdv1,idPdv2"/>
                                </h:selectOneMenu>
                                <h:outputText id="idSecteur2" value="#{axe2.ecranaSecteur}:#{axe2.ecranaSecteurLib}" rendered="#{axe2.secVide}"/>
                            </rich:column>
                            <rich:column label="Point de vente"  width="20%">
                                <f:facet name="header"><h:outputText value="P.D.V."/></f:facet>
                                <h:selectOneMenu id="idPdv1" style="width:100%" value="#{axe2.zonePdv}" rendered="#{!axe2.pdvVide}">
                                    <f:selectItem itemLabel="Sélectionnez Pdv" itemValue=""/>
                                    <f:selectItems value="#{axe2.mesPdvItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculerPdvItems}"/>
                                </h:selectOneMenu>
                                <h:outputText id="idPdv2" value="#{axe2.ecranaPdv}:#{axe2.ecranaPdvLib}" rendered="#{axe2.pdvVide}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe2.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne02}" reRender="idMontant02,idEcar02,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant02" value="#{axe2.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne02}" reRender="idTable02,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte02" value="#{axe2.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar02" style="text-align:right;color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe02==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart02}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe03" label="Site/Atelier/Ligne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_sitePrdv&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe03}"/>
                <h:panelGrid id="idPanAnalAxe3" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe03}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe03}" reRender="idPanAnalAxe3,idTable03,idEcar03,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable03" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe03}" var="axe3" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe03}"/>
                            <rich:column label="Site"  width="20%" >
                                <f:facet name="header"><h:outputText value="Site"/></f:facet>
                                <h:selectOneMenu style="width:100%" value="#{axe3.zoneSitePrd}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:selectItem itemLabel="Sélectionnez Site" itemValue=""/>
                                    <f:selectItems value="#{axe3.mesSitesPrdItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerLignesItems}" reRender="idTable03,idLigne1,idLigne2,idAtelier1,idAtelier2"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Ligne"  width="20%">
                                <f:facet name="header"><h:outputText value="Ligne"/></f:facet>
                                <h:selectOneMenu id="idLigne1" style="width:100%" value="#{axe3.zoneLigne}" rendered="#{!axe3.ligVide}">
                                    <f:selectItem itemLabel="Sélectionnez Ligne" itemValue=""/>
                                    <f:selectItems value="#{axe3.mesLignesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerAteliersItems}" reRender="idTable03,idAtelier1,idAtelier2"/>
                                </h:selectOneMenu>
                                <h:outputText id="idLigne2" value="#{axe3.ecranaLigne}:#{axe3.ecranaLigneLib}" rendered="#{axe3.ligVide}"/>
                            </rich:column>
                            <rich:column label="Atelier"  width="20%">
                                <f:facet name="header"><h:outputText value="Atelier"/></f:facet>
                                <h:selectOneMenu id="idAtelier1" style="width:100%" value="#{axe3.zoneAtelier}" rendered="#{!axe3.ateVide}">
                                    <f:selectItem itemLabel="Sélectionnez Atelier" itemValue=""/>
                                    <f:selectItems value="#{axe3.mesAteliersItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculerAteliersItems}"/>
                                </h:selectOneMenu>
                                <h:outputText id="idAtelier2" value="#{axe3.ecranaAtelier}:#{axe3.ecranaAtelierLib}" rendered="#{axe3.ateVide}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe1.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne03}" reRender="idMontant03,idEcar03,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant03" value="#{axe3.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne03}" reRender="idTable03,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte03" value="#{axe3.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar03" style="text-align:right;color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe03==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart03}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe04" label="Activités" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe04}"/>
                <h:panelGrid id="idPanAnalAxe4" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe04}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe04}" reRender="idPanAnalAxe4,idTable04,idEcar04,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable04" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe04}" var="axe4" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe04}"/>
                            <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.decoupageActivite}" var="dec">
                                <rich:column label="Activités"  width="20%">
                                    <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                                    <h:selectOneMenu style="width:100%" value="#{axe4.zoneActivite}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                        <f:selectItem itemLabel="Sélectionnez Activité" itemValue=""/>
                                        <f:selectItems value="#{axe4.mesColonnes1Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerActiviteCol0Items}"/>
                                    </h:selectOneMenu>
                                    <h:outputText value="#{axe4.ecranaActivite}:#{axe4.ecranaActiviteLib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.decoupageActivite}" var="dec">
                                <rich:column label="Activités1"  width="20%">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}"/></f:facet>
                                    <h:selectOneMenu style="width:100%" value="#{axe4.zoneCol1}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                        <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue=""/>
                                        <f:selectItems value="#{axe4.mesColonnes1Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerActiviteCol1Items}"/>
                                    </h:selectOneMenu>
                                    <h:outputText value="#{axe4.ecranaActivite}:#{axe4.ecranaActiviteLib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}"/>
                                </rich:column>
                                <rich:column label="Activités2"  width="20%">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}"/></f:facet>
                                    <h:selectOneMenu style="width:100%" value="#{axe4.zoneCol2}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                        <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue=""/>
                                        <f:selectItems value="#{axe4.mesColonnes2Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerActiviteCol2Items}"/>
                                    </h:selectOneMenu>
                                    <h:outputText value="#{axe4.ecranaAnal1}:#{axe4.ecranaAnal1Lib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}"/>
                                </rich:column>
                                <rich:column label="Activités3"  width="20%">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}"/></f:facet>
                                    <h:selectOneMenu style="width:100%" value="#{axe4.zoneCol3}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                        <f:selectItem itemLabel="Sélectionnez #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue=""/>
                                        <f:selectItems value="#{axe4.mesColonnes3Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.chargerActiviteCol3Items}"/>
                                    </h:selectOneMenu>
                                    <h:outputText value="#{axe4.ecranaAnal3}:#{axe4.ecranaAnal3Lib}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}"/>
                                </rich:column>
                            </c:if>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe4.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne04}" reRender="idMontant04,idEcar04,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant04" value="#{axe4.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne04}" reRender="idEcar04,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte04" value="#{axe4.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar04" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe04==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart04}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe05" label="Agents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_agent&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe05}"/>
                <h:panelGrid id="idPanAnalAxe5" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe05}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe05}" reRender="idPanAnalAxe5,idTable05,idEcar05,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable05" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe05}" var="axe5" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe05}"/>
                            <rich:column label="Agent"  width="20%">
                                <f:facet name="header"><h:outputText value="Agent"/></f:facet>
                                <h:inputText id="idAgent1" value="#{axe5.ecranaAgent}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.rechercherAgent}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Libelle"  width="20%">
                                <f:facet name="header"><h:outputText value="Nom et Prénom"/></f:facet>
                                <h:outputText id="idAgent2" value="#{axe5.ecranaAgentLib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe5.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne05}" reRender="idMontant05,idEcar05,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant05" value="#{axe5.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne05}" reRender="idEcar05,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte05" value="#{axe5.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar05" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe05==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart05}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe06" label="Chantiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_anal1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe06}"/>
                <h:panelGrid id="idPanAnalAxe6" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe06}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe06}" reRender="idPanAnalAxe6,idTable06,idEcar06,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable06" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe06}" var="axe6" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe06}"/>
                            <rich:column label="Chantier"  width="20%">
                                <f:facet name="header"><h:outputText value="Chantier"/></f:facet>
                                <h:inputText id="idChantier1" value="#{axe6.ecranaAnal1}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.rechercherChantier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Libelle"  width="20%">
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText id="idChantier2" value="#{axe6.ecranaAnal1Lib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe6.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne06}" reRender="idMontant06,idEcar06,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant06" value="#{axe6.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne06}" reRender="idEcar06,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte06" value="#{axe6.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar06" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe06==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart06}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe07" label="Parcs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_anal2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe07}"/>
                <h:panelGrid id="idPanAnalAxe7" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe07}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe07}" reRender="idPanAnalAxe7,idTable07,idEcar07,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable07" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe07}" var="axe7" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe07}"/>
                            <rich:column label="Parc"  width="20%">
                                <f:facet name="header"><h:outputText value="Parc"/></f:facet>
                                <h:inputText id="idParc1" value="#{axe7.ecranaAnal2}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.rechercherParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Libelle"  width="20%">
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText id="idParc2" value="#{axe7.ecranaAnal2Lib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe7.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne07}" reRender="idMontant07,idEcar07,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant07" value="#{axe7.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne07}" reRender="idEcar07,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte07" value="#{axe7.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar07" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe07==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart07}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe08" label="Missions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_anal3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe08}"/>
                <h:panelGrid id="idPanAnalAxe8" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe08}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe08}" reRender="idPanAnalAxe8,idTable08,idEcar08,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable08" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe08}" var="axe8" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe08}"/>
                            <rich:column label="Mission"  width="20%">
                                <f:facet name="header"><h:outputText value="Chantier"/></f:facet>
                                <h:inputText id="idMission1" value="#{axe8.ecranaAnal3}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.rechercherMission}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Libelle"  width="20%">
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText id="idMisison2" value="#{axe8.ecranaAnal3Lib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe8.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne08}" reRender="idMontant08,idEcar08,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant08" value="#{axe8.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne08}" reRender="idEcar08,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte08" value="#{axe8.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar08" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe08==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart08}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe09" label="Dossiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_anal4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe09}"/>
                <h:panelGrid id="idPanAnalAxe9" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe09}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe09}" reRender="idPanAnalAxe9,idTable09,idEcar09,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable09" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe09}" var="axe9" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe09}"/>
                            <rich:column label="Dossier"  width="20%">
                                <f:facet name="header"><h:outputText value="Dossier"/></f:facet>
                                <h:inputText id="idDossier1" value="#{axe9.ecranaAnal4}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.rechercherDossier}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Libelle"  width="20%">
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText id="idDossier2" value="#{axe9.ecranaAnal4Lib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe9.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne09}" reRender="idMontant09,idEcar09,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant09" value="#{axe9.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculNouvelleLigne09}" reRender="idEcar09,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte09" value="#{axe9.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar09" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe09==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart09}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe11" label="Clés répartition" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_cles&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe11}"/>
                <h:panelGrid id="idPanAnalAxe11" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe11}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe11}" reRender="idPanAnalAxe11,idTable11,idEcar11,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                    <h:selectOneMenu id="idChoixCleRep" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.cleStandard}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe11==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Sélectionnez Clé standard"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.lesClesStandardsItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculCleStandard}" reRender="idEcar11,idTable11,idPanAnal,idPanValAnal"/>
                    </h:selectOneMenu>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable11" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe11}" var="axe11" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe11}"/>
                            <rich:column label="Clé"  width="10%">
                                <f:facet name="header"><h:outputText value="Clé"/></f:facet>
                                <h:outputText value="#{axe11.ecranaRepCle}"/>
                            </rich:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==100}" var="cle1">
                                <rich:column label="Site"  width="20%">
                                    <f:facet name="header"><h:outputText value="Site"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaSite} : #{axe11.ecranaSiteLib}"/>
                                </rich:column>
                                <rich:column label="Département"  width="20%">
                                    <f:facet name="header"><h:outputText value="Département"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaDepartement} : #{axe11.ecranaDepartementLib}"/>
                                </rich:column>
                                <rich:column label="Service"  width="20%">
                                    <f:facet name="header"><h:outputText value="Service"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaService} : #{axe11.ecranaServiceLib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==101}" var="cle2">
                                <rich:column label="Région"  width="20%">
                                    <f:facet name="header"><h:outputText value="Région"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaRegion} : #{axe11.ecranaRegionLib}"/>
                                </rich:column>
                                <rich:column label="Secteur"  width="20%">
                                    <f:facet name="header"><h:outputText value="Secteur"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaSecteur} : #{axe11.ecranaSecteurLib}"/>
                                </rich:column>
                                <rich:column label="Service"  width="20%">
                                    <f:facet name="header"><h:outputText value="Service"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaService} : #{axe11.ecranaServiceLib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==102}" var="cle3">
                                <rich:column label="Site"  width="20%">
                                    <f:facet name="header"><h:outputText value="Site"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaSite} : #{axe11.ecranaSiteLib}"/>
                                </rich:column>
                                <rich:column label="Ligne"  width="20%">
                                    <f:facet name="header"><h:outputText value="Ligne"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaLigne} : #{axe11.ecranaLigneLib}"/>
                                </rich:column>
                                <rich:column label="Atelier"  width="20%">
                                    <f:facet name="header"><h:outputText value="Atelier"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAtelier} : #{axe11.ecranaAtelierLib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==110}" var="cle4">
                                <rich:column label="Activité"  width="20%">
                                    <f:facet name="header"><h:outputText value="Activité"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaActivite} : #{axe11.ecranaActiviteLib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==122}" var="cle5">
                                <rich:column label="Agent"  width="20%">
                                    <f:facet name="header"><h:outputText value="Agent"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAgent} : #{axe11.ecranaAgentLib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==6}" var="cle6">
                                <rich:column label="Chantier"  width="20%">
                                    <f:facet name="header"><h:outputText value="Chantier"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAnal1} : #{axe11.ecranaAnal1Lib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==120}" var="cle7">
                                <rich:column label="Parc"  width="20%">
                                    <f:facet name="header"><h:outputText value="Parc"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAnal2} : #{axe11.ecranaAnal2Lib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==8}" var="cle8">
                                <rich:column label="Mission"  width="20%">
                                    <f:facet name="header"><h:outputText value="Mission"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAnal3} : #{axe11.ecranaAnal3Lib}"/>
                                </rich:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.natureCleRepartition==6}" var="cle9">
                                <rich:column label="Dossier"  width="20%">
                                    <f:facet name="header"><h:outputText value="Dossier"/></f:facet>
                                    <h:outputText value="#{axe11.ecranaAnal4} : #{axe11.ecranaAnal4Lib}"/>
                                </rich:column>
                            </c:if>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe11.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculLigne11}" reRender="idMontant11,idEcar11,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="10%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant11" value="#{axe11.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculEcart11}" reRender="idEcar11,idPanAnal,idPanValAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte11" value="#{axe11.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar11" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe11==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart11}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe12" label="Structure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_str&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe12}"/>
                <h:panelGrid id="idPanAnalAxe12" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe12}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe12}" reRender="idPanAnalAxe12,idTable12,idEcar12,idChoixCleStr,idPanValAnal,idPanAnal"/>
                    </h:selectOneRadio>
                    <h:selectOneMenu id="idChoixCleStr" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.cleStructure}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe12==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Sélectionnez Clé structure"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.lesClesStructureItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.calculCleStructure}" reRender="idEcar12,idTable12,idPanAnal,idPanValAnal"/>
                    </h:selectOneMenu>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTable12" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.dataModelAxe12}" var="axe12" width="100%" height="300px" style="border: solid 1px" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.selctionAxe12}"/>
                            <rich:column label="Clé"  width="20%">
                                <f:facet name="header"><h:outputText value="Clé"/></f:facet>
                                <h:outputText value="#{axe12.ecranaStrCle}"/>
                            </rich:column>
                            <rich:column label="Structure"  width="20%">
                                <f:facet name="header"><h:outputText value="Structure"/></f:facet>
                                <h:outputText value="#{axe12.ecranaStr} : #{axe12.ecranaStrLib}"/>
                            </rich:column>
                            <rich:column label="Pourcentage"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{axe12.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="true" readonly="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idMontant12" value="#{axe12.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Quantité"  width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Quantité" /></f:facet>
                                <h:inputText id="idQte12" value="#{axe12.ecranaQteSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <h:panelGrid columns="2" id="idEcar12" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe12==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <h:outputText value="Ecart Axe:"/>
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ecart12}" style="text-align:right;width:90%;height:19px">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>
            <rich:tab id="idAxe13" label="Autre" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.affiche_autre&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.montantTotal!=0}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.ongletAxe13}"/>
                <h:panelGrid id="idPanAnalAxe13" width="100%" >
                    <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.util_axe13}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation}">
                        <f:selectItem itemLabel="Axe utilisé" itemValue="0"/>
                        <f:selectItem itemLabel="Je ne veux pas utiliser cet axe" itemValue="1"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.utilisationAxe13}" reRender="idPanAnalAxe13,idTable13,idEcar13,idPanAnal,idPanValAnal"/>
                    </h:selectOneRadio>
                </h:panelGrid>
            </rich:tab>
        </rich:tabPanel>
        <center>
            <h:panelGroup id="idPanValAnal" >
                <center>
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.validerBudget}" reRender="panelSaisieLigne,table" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.modeConsultation&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formBudget.formAnalytique.var_valide_analytique}"/>
                </center>
            </h:panelGroup>
        </center>
    </h:panelGrid>

</a4j:form>
