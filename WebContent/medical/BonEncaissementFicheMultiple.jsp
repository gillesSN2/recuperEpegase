<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bonimmmodif">

    <center> <h2><h:outputText value="DETAIL DE L'ENCAISSEMENT" style="color:green;"/></h2></center>

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <h:panelGrid width="100%" id="glob">
            <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Nature:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.var_lib_nat} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonSerie})" readonly="true"/></h:column>
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonDateEcheReg}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                <h:column><h:outputText value="N° du bon:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Nom client:" /></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonNomTiers}" readonly="true"/></h:column>
                <h:column><h:outputText value="Devise:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonDevise}" readonly="true"/></h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid style="background-color:white;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Objet Document:"/></h:column>
                <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonObject}" readonly="true"/></h:column>
                <h:column><h:outputText value="Libellé Recette:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonLibelle}" readonly="true"/></h:column>
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonNomResponsable}" readonly="true"/></h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="imp" style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                <h:column><h:outputText value="Montant recette:"/></h:column>
                <h:column>
                    <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.montantAPayer}" style="text-align:right;width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_action>=3}" >
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.controleMontant}" reRender="glob,prgtpAjt"/>
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Date valeur:"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.bonEncaissementVente.bonDateValeur}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="false"/></h:column>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.datamodelTransfert}" var="var">
                    <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}">
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{var.facNum}"/>
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
                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                        <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Règlements" sortable="true" sortBy="#{var.facTotReglement}" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                        <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                        <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                        <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Objet de la facture" sortable="true" sortBy="#{var.facObject}" width="200px">
                        <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                        <h:outputText  value="#{var.facObject}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_affiche_valide}" />
                    <br>
                    <h:column><h:outputText value="Le montant saisi ne peut pas excéder le montant du document..." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formBonEncaissementMedical.var_affiche_valide}"/></h:column>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>


</f:subview>
