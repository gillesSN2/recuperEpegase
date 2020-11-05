<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="inventaireFiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DES INVENTAIRES DES CAISSES" style="color:green;"/></h2></center>

            <h:panelGrid id="idPanGlobal" width="100%">
                <h:panelGrid style="background-color:#DAEECB;" id="panCaisse" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date :"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                    <h:column><h:outputText value="N° document :"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvNum}" disabled="true"/></h:column>
                    <h:column><h:outputText value="Caisse:"/> </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_caisse}">
                            <f:selectItem itemLabel="Selectionner une caisse" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.mesCaissesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.choixCaisse}" reRender="idPanGlobal,prgtpAjt,idControle"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date controle :"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvId==0}">
                        <h:selectOneMenu id="idControle" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvCaisseIdCtrl}">
                            <f:selectItem itemLabel="Selectionner une date" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.mesCaisseControlItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.choisirDateControle}" reRender="idPanGlobal,prgtpAjt,panelGlobal"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvId!=0}">
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDateCtrl}" readonly="true"/></h:column>
                    </h:column>
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_valide}">

                    <rich:tab id="tabCtrl" label="Saisie controle">
                        <h:panelGrid width="100%" columns="3" columnClasses="top,top,top" id="idPanSaisie">
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Billets"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB1}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b1}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB2}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b2}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB3}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b3}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB4}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b4}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB5}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b5}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB6}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b6}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB7}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b7}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB8}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b8}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB9}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b9}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB10}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b10}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL BILLETS" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalBillet}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Pièces"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP1}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p1}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP2}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p2}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP3}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p3}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP4}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p4}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP5}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p5}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP6}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p6}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP7}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p7}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP8}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p8}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP9}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p9}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP10}" size = "6">
                                        <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.calculBilletageJournalier}" reRender="idPanSaisie,panelGlobal,idPanEcart"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p10}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL PIECES" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalPiece}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="300px" columns="2" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des devises et autres"/></f:facet>
                                <h:column><h:outputText value="Total des bons"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvBon}" size = "10" readonly="true" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des espèces"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvEspece}" size = "10" readonly="true" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des timbres"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvTimbre}" size = "10" readonly="true" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total autres"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvAutre}" size = "10" readonly="true" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise1}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise2}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise3}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise4}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise5}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="ECART" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.ecart}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabCaisse" label="Etat caisse">
                        <h:panelGrid width="100%" columns="3" columnClasses="top,top,top">
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Billets"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB1Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b1_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB2Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b2_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB3Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b3_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB4Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b4_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB5Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b5_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB6Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b6_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB7Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b7_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB8Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b8_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB9Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b9_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB10Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b10_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL BILLETS" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalBillet_reel}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Pièces"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP1Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p1_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP2Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p2_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP3Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p3_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP4Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p4_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP5Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p5_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP6Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p6_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP7Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p7_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP8Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p8_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP9Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p9_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP10Reel}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p10_reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL PIECES" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalPiece_reel}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="300px" columns="2" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des devises et autres"/></f:facet>
                                <h:column><h:outputText value="Total des bons"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvBonReel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des espèces"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvEspeceReel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des timbres"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvTimbreReel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total autres"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvAutreReel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise1Reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise2Reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise3Reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise4Reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise5Reel}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="ECART" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.ecart_reel}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabEcart" label="Ecart">
                        <h:panelGrid width="100%" columns="3" columnClasses="top,top,top" id="idPanEcart">
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Billets"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB1Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b1_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB2Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b2_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB3Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b3_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB4Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b4_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB5Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b5_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB6Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b6_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB7Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b7_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB8Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b8_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB9Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b9_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvB10Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_b10_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL BILLETS" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalBillet_ecart}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="350px" columns="3" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des Pièces"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP1Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p1!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p1_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP2Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p2!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p2_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP3Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p3!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p3_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP4Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p4!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p4_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP5Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p5!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p5_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP6Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p6!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p6_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP7Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p7!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p7_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP8Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p8!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p8_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP9Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p9!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p9_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_b10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvP10Ecart}" size = "6"/>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.val_p10!=0}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.tot_p10_ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="TOTAL PIECES" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.totalPiece_ecart}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="300px" columns="2" headerClass="headerTab" style="text-align:right">
                                <f:facet name="header"><h:outputText value="Total des devises et autres"/></f:facet>
                                <h:column><h:outputText value="Total des bons"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvBonEcart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des espèces"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvEspeceEcart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total des timbres"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvTimbreEcart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Total autres"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvAutreEcart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise1!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise1Ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise2!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise2Ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise3!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise3Ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise4!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise4Ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}"><h:outputText value="(Dont #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5})"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.devise5!='*'}">
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvDevise5Ecart}" size = "10" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="ECART" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.ecart_ecart}" size = "10" style="text-align:right;color:red">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabObs" label="Observations">
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.caissesInventaire.caiinvObservation}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="prgtpAjt">
                    <br>
                    <center>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.annuleSaisie}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.saveInventaire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesInventaire.var_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </h:panelGrid>

        </a4j:form>
    </center>


</f:subview>
