<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficprix">

    <a4j:form id="produitprixformvte" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="FICHE TARIF DU PRODUIT (VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">
            <rich:tabPanel switchType="client" immediate="true" id="tabProduit"  style="border:0px;">

                <rich:tab label="Tarif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_descriptif}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationDescription}" reRender="panTarif"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <h:panelGrid id="panTarif" width="100%">
                        <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif1}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv1Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif2}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv2Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif3}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv3Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif4}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv4}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv4Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif5}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv5}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv5Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif6}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv6}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv6Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif7}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv7}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv7Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif8}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv8}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv8Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif9}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv9}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv9Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif10}:" style="font-weight:bold;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv10}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}"><h:outputText value="Prix marché:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.pv10Marche}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Concurrent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_descriptif}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationDescription}" reRender="panConcurrent"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <h:panelGrid id="panConcurrent" width="100%">
                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif1}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif1}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n1CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d1CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p1CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n1CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d1CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p1CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n1CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d1CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p1CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif2}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif2}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n2CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d2CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p2CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n2CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d2CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p2CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n3CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d3CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p3CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif3}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif3}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n3CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d3CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p3CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n3CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d3CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p3CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n3CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d3CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p3CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif4}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif4}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n4CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d4CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p4CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n4CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d4CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p4CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n4CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d4CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p4CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif5}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif5}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n5CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d5CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p5CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n5CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d5CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p5CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n5CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d5CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p5CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif6}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif6}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n6CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d6CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p6CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n6CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d6CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p6CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n6CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d6CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p6CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif7}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif7}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n7CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d7CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p7CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n7CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d7CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p7CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n7CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d7CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p7CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif8}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif8}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n8CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d8CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p8CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n8CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d8CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p8CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n8CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d8CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p8CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif9}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif9}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n9CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d9CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p9CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n9CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d9CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p9CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n9CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d9CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p9CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid columns="7" width="100%" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_aff_tarif10}">
                            <h:column ><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_tarif10}:" style="font-weight:bold;"/></h:column>
                            <h:column><h:outputText value="Concurrent1:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n10CC1}"/></h:column>
                            <h:column><h:outputText value="Date maj1:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d10CC1}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="prix1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p10CC1}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent2:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n10CC2}"/></h:column>
                            <h:column><h:outputText value="Date maj2:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d10CC2}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p10CC2}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Concurrent3:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_n10CC3}"/></h:column>
                            <h:column><h:outputText value="Date maj3:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_d10CC3}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Prix3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_p10CC3}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>

                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Promotions" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_PromoFind==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_tarification}">
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGrid id="idBtnPromo" width="200px" columns="3">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle promotion" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajouterTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" reRender="panelTarifPromotion,idBtnPromo"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la promotion sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modifierTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarifPromotion&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mod}" reRender="panelTarifPromotion,idBtnPromo"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la promotion sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.supprimerTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarifPromotion&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}" reRender="idBtnPromo,tableTarifPromotion"/>
                        </h:panelGrid>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauPromotion" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelTarifPromotion}" var="tdp">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionTarifPromotion}" reRender="idBtnPromo"/>
                            <rich:column label="Date début promotion" sortable="false" width="20%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Du"/></f:facet>
                                <h:outputText value="#{tdp.barDateDebut}"  style="text-align:right;">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date fin promotion" sortable="false" width="20%"  style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Au"/></f:facet>
                                <h:outputText  value="#{tdp.barDateFin}"  style="text-align:right;">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Prix remisé" sortable="false" width="30%"  style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Prix"/></f:facet>
                                <h:outputText  value="#{tdp.barPrix}"  style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="% remise" sortable="false" width="20%"  style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%"/></f:facet>
                                <h:outputText  value="#{tdp.barRemise}"  style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Tarifs Spéciaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_PromoFind==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_tarification}">
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <center>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauSpecial" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelTarifClients}" var="bar">
                            <rich:column  width="20%" sortBy="#{bar.barCategorieTiers}">
                                <f:facet name="header"><h:outputText  value="Famille tiers"/></f:facet>
                                <h:outputText value="#{bar.barCategorieTiers}"/>
                            </rich:column>
                            <rich:column  width="30%" sortBy="#{bar.barNomTiers}">
                                <f:facet name="header"><h:outputText  value="Nom tiers"/></f:facet>
                                <h:outputText value="#{bar.barNomTiers}"/>
                            </rich:column>
                            <rich:column  width="15%"  style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Remise" /></f:facet>
                                <h:outputText value="#{bar.barRemise}" rendered="#{bar.barRemise!=0}" style="text-align:right"/>
                            </rich:column>
                            <rich:column  width="15%"  style="text-align:right">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.libelleRabRis}" /></f:facet>
                                <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ristourne}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                                <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ristourne}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="20%"  style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Prix" /></f:facet>
                                <h:outputText value="#{bar.barPrix}" rendered="#{bar.barPrix!=0}" style="text-align:right">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annulerTarifProduit}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.validerTarifProduit}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelTarifPromotion" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifPromotion}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifPromotion}" var="tdp">
            <f:facet name="header"><h:outputText value="TARIF PROMOTIONNEL"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.fermerTarifPromotion}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifPromotion"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%">
                    <h:column><h:outputText value="Date début promo.:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    <h:column><h:outputText value="Date fin promo:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    <h:column><h:outputText value="Prix remisé:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barPrix}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="% promotion:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barRemise}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttTarPromo">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.validerTarifPromotion}" reRender="panelTarifPromotion,tableTarifPromotion,idBtnPromo"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
