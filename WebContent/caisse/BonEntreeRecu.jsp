<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="recuentree">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="RECU BON D'ENTREE" style="color:green;"/></h2></center>

            <h:panelGrid id="idPanGlobal"  width="100%">
                <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date :"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                    <h:column><h:outputText value="N° document :"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrNum}" disabled="true"/></h:column>
                    <h:column><h:outputText value="N° reçu:"/></h:column>
                    <h:column><h:inputText  style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNum}"  disabled="true"/></h:column>
                    <h:column><h:outputText value="Devise:"/></h:column>
                    <h:column>
                        <h:panelGroup id="groupVevise">
                            <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrDevise}" disabled="true" style="width:15%;"/>
                            &nbsp;&nbsp; <h:outputText value="Série:"/>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrSerie}" disabled="true" style="width:20%;"/>
                        </h:panelGroup>
                    </h:column>
                    <h:column><h:outputText value="Type:" /></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrTypeTiers}" disabled="true">
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
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrMontant}" style="width:100%;text-align:center;font-weight:bold;font-size:50px" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Caisse:" /> </h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_caisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.existCaiss}">
                            <f:selectItem itemLabel="Selectionner une caisse" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesRecetteItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixCaissePiece}" reRender="idPanGlobal,prgtpAjt,panCaisse,idTypeReg"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Payeur:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrNomTiers}" disabled="true"/></h:column>
                    <h:outputText value="Type règlement:"/>
                    <h:column>
                        <h:selectOneMenu id="idTypeReg" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_modeReglement}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesModesReglementsItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixTypeReglementPiece}" reRender="idPanGlobal,panCaisse"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Banque :" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrCodeBanq}"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrCodeBanq}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrLibBanq}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affichBanq}" disabled="true"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}">
                    <h:column><h:outputText value="Banque tireur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrBanqueTireur}" maxlength="50"/></h:column>
                    <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrNumChqBdx}" maxlength="50"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="imp" style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText style="width:100%" id="lib" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrLibelle}" disabled="true"/></h:column>
                    <h:column><h:outputText value="Date valeur:"/></h:column>
                    <h:column>
                        <rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrDateValeur}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="true"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="Dépôt d'argent ?" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_depot}"/>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_depot}" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_depot}" readonly="true"/>
                    </h:column>
                    <h:column><h:outputText value="Responsable:"/></h:column>
                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEntreCaiss.entrNomResponsable}" disabled="true"/></h:column>
                    <h:column><h:outputText value="Impression : (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomRepMod})" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglModele}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup id="prgtpAjt">
                    <br>
                    <center>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annulerSaisie}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validationExecution}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </center>


</f:subview>
