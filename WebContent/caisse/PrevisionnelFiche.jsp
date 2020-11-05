<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="previsionnel">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="DETAIL DE LA PREVISION" style="color:green;"/></h2></center>

            <h:panelGrid id="idPanGlobal" width="100%">
                <h:panelGrid id="idPan0" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date début:" style="text-decoration:underline;"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDateDebut}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Date fin:" style="text-decoration:underline;"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDateFin}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}"/></h:column>
                </h:panelGrid>
                <h:panelGrid styleClass="fichefournisseur1" width="100%" columns="2" columnClasses="clos15,clos85">
                    <h:column><h:outputText value="Observations:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreObservations}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="width:90%"/></h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50">
                    <h:panelGrid id="idPan1" styleClass="fichefournisseur" headerClass="headerTab" width="100%" columns="2" columnClasses="clos30,clos70d">
                        <f:facet name="header"><h:outputText value="RECETTES"/></f:facet>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_espece}"><h:outputText value="Montant espèces:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_espece}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteEspece}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_cheque}"><h:outputText value="Montant chèque:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_cheque}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteCheque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_virement}"><h:outputText value="Montant virement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_virement}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteVirement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_traite}"><h:outputText value="Montant traite:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_traite}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteTraite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_tpe}"><h:outputText value="Montant TPE:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_tpe}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteTpe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_transfert}"><h:outputText value="Montant transfert:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_transfert}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteTransfert}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_epaiement}"><h:outputText value="Montant ePaiement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_epaiement}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteePaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_credoc}"><h:outputText value="Montant CREDOC:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_credoc}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteCredoc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_factor}"><h:outputText value="Montant FACTOR:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_factor}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteFactor}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_compense}"><h:outputText value="Montant compense:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_compense}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteCompense}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_terme}"><h:outputText value="Montant terme:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_terme}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreRecetteTerme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan1"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="TOTAL RECETTES:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreTotalRecette}" disabled="true" readonly="true" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid id="idPan2" styleClass="fichefournisseur" headerClass="headerTab" width="100%" columns="2" columnClasses="clos30,clos70d">
                        <f:facet name="header"><h:outputText value="DEPENSES"/></f:facet>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_espece}"><h:outputText value="Montant espèces:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_espece}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseEspece}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_cheque}"><h:outputText value="Montant chèque:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_cheque}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseCheque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_virement}"><h:outputText value="Montant virement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_virement}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseVirement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_traite}"><h:outputText value="Montant traite:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_traite}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseTraite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_tpe}"><h:outputText value="Montant TPE:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_tpe}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseTpe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_transfert}"><h:outputText value="Montant transfert:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_transfert}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseTransfert}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_epaiement}"><h:outputText value="Montant ePaiement:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_epaiement}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseePaiement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_credoc}"><h:outputText value="Montant CREDOC:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_credoc}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseCredoc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_factor}"><h:outputText value="Montant FACTOR:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_factor}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseFactor}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_compense}"><h:outputText value="Montant compense:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_compense}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseCompense}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_terme}"><h:outputText value="Montant terme:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_terme}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreDepenseTerme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_action==3}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idPan2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="TOTAL DEPENSES:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.caissesPrevision.caipreTotalDepense}" disabled="true" readonly="true" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.annulePrevision}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.savePrevision}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formCaissesPrevision.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


</f:subview>
