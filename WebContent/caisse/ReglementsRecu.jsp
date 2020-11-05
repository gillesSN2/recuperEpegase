<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="csrecu">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_titre_recu}" style="color:green;"/></h2></center>

            <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" id="idEncais2">
                <h:column><h:outputText value="Date :"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisDate}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                <h:column><h:outputText value="N° document :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDocument}" disabled="true"/></h:column>
                <h:column><h:outputText value="N° reçu:"/></h:column>
                <h:column><h:inputText  style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNum}"  disabled="true"/></h:column>
                <h:column><h:outputText value="Devise:"/></h:column>
                <h:column>
                    <h:panelGroup id="groupVevise">
                        <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDevise}" disabled="true" style="width:15%;"/>
                        &nbsp;&nbsp; <h:outputText value="Série:"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglSerie}" disabled="true" style="width:20%;"/>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Type:" /></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglTypeTiers}" disabled="true">
                        <f:selectItem itemLabel="Sélectionnez un type" itemValue="100"/>
                        <f:selectItem itemLabel="Client" itemValue="0"/>
                        <f:selectItem itemLabel="Fournisseur" itemValue="1"/>
                        <f:selectItem itemLabel="Agent" itemValue="2"/>
                        <f:selectItem itemLabel="Plan Comptable" itemValue="3"/>
                        <f:selectItem itemLabel="Patient" itemValue="4"/>
                        <f:selectItem itemLabel="Elève" itemValue="5"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Montant:" /></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisMontant}" style="width:100%;text-align:center;font-weight:bold;font-size:50px" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText><br>
                    <h:inputText value="(dont timbre : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_timbre})" style="width:100%;text-align:center;"  disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_timbre!=0}"/>
                </h:column>
                <h:column><h:outputText value="Caisse:" /> </h:column>
                <h:column>
                    <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_caisse}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}">
                        <f:selectItem itemLabel="Sélectionner une caisse" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesItems}"/>
                    </h:selectOneMenu>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_caisse}" disabled="true" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}"/></h:column>
                </h:column>
                <h:column><h:outputText value="Bénéficiaire :"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNomTiers}" disabled="true"/></h:column>
                <h:outputText value="Type règlement:"/>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_modeReglement}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesTypeReglementsItem}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixTypeReglement}" reRender="imp,idEncais2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:outputText value=""/>
                <h:outputText value=""/>
                <h:column><h:outputText value="Numéro Chèque:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisNumChqBdx}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}"/></h:column>
                <h:column><h:outputText value="Banque :" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisBanqueTirreur}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}"/></h:column>
            </h:panelGrid>

            <h:panelGrid id="imp" style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:100%" id="lib" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisLibelle}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul}"/></h:column>
                <h:column><h:outputText value="Date valeur:"/></h:column>
                <h:column><rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDateValeur}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" inputSize="8" disabled="true"/></h:column>
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNomResponsable}" disabled="true"/></h:column>
                <h:column><h:outputText value="Impression : (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomRepMod})" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisModeleImp}" >
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annulerSaisie}"/>&nbsp;&nbsp;                   
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validerRegularisation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.regul&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>
        </a4j:form>
    </center>

</f:subview>
