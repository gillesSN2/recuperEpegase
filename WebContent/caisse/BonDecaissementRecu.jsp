<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bondecaisse">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="RECU BON DE DECAISSEMENT" style="color:green;"/></h2></center>

            <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Nature:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.var_lib_nat} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonSerie})" disabled="true"/></h:column>
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                <h:column> <h:outputText value="N° reçu:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonNum}" disabled="true" style="width:40%"/></h:column>
                <h:column><h:outputText value="Devise:"/></h:column>
                <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonDevise}" disabled="true" size="3"/></h:column>
            </h:panelGrid>

            <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Nom client:" /></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonNomTiers}" disabled="true"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonLibelle}" disabled="true"/></h:column>
            </h:panelGrid>

            <h:panelGrid id="idReg" style="background-color:white;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Montant:"/></h:column>
                <h:column>
                    <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonAPayer}" style="text-align:right;width:100%"  disabled="true" >
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Caisse:" /></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_caisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_verrou_caisse}">
                        <f:selectItem itemLabel="Selectionner une caisse" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixCaisse}" reRender="prgtpAjt,idReg,idTypeReg"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Type de Règlement:"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idTypeReg" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_modeReglement}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesModesReglementsItem}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixTypeReglement}" reRender="idReg,imp"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column><h:outputText value="Banque:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inputBanq}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}" style="width:100%;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesBanquesCaissesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixBanq}" reRender="idReg"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="N° chèque ou bordereau:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonNumChqBdx}" maxlength="50" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
            </h:panelGrid>

            <h:panelGrid id="imp" style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column><h:inputText id="idUser" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonNomResponsable}" disabled="true"/></h:column>
                <h:column id="imp1"><h:outputText value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomRepMod})" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonDecaissementAchat.bonModeleImp}" >
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validationExecution}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


</f:subview>
