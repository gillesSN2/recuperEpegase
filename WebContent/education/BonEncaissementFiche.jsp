<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bonensmodif">

    <center> <h2><h:outputText value="DETAIL DE L'ENCAISSEMENT" style="color:green;"/></h2></center>

    <a4j:form>

        <h:panelGrid width="100%" id="glob">
            <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Nature :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.var_lib_nat} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonSerie})" readonly="true"/></h:column>
                <h:column><h:outputText value="Date :"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonDateEcheReg}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                <h:column><h:outputText value="N° du bon :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Nom client :" /></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonNomTiers}" readonly="true"/></h:column>
                <h:column><h:outputText value="Devise :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonDevise}" readonly="true"/></h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid style="background-color:white;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Objet Document :"/></h:column>
                <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonObject}" readonly="true"/></h:column>
                <h:column><h:outputText value="Libellé Recette :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonLibelle}" readonly="true"/></h:column>
                <h:column><h:outputText value="Responsable :" style="text-decoration:underline;"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonNomResponsable}" readonly="true"/></h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="imp" style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                <h:column><h:outputText value="Montant recette :"/></h:column>
                <h:column>
                    <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.montantAPayer}" style="text-align:right;width:100%"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_action>=3}" >
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.controleMontant}" reRender="glob,prgtpAjt"/>
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Date valeur:"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.bonEncaissementVente.bonDateValeur}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="false"/></h:column>
            </h:panelGrid>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_affiche_valide}" />
                    <br>
                    <h:column><h:outputText value="Le montant saisi ne peut pas excéder le montant du document..." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formBonEncaissementEducation.var_affiche_valide}"/></h:column>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>


</f:subview>
