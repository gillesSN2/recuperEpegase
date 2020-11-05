<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bonentree">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="DETAIL BON D'ENTREE" style="color:green;"/></h2></center>

            <h:panelGrid id="firstGrid" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Date opération:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                <h:column><h:outputText value="N° bon:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrNum}" disabled="true"/></h:column>
                <h:column><h:outputText value="Série:"/></h:column>
                <h:column>
                    <h:panelGroup id="group">
                        <h:selectOneMenu style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSeriesUsersItem}"/>
                        </h:selectOneMenu>&nbsp;
                        <h:outputText value="Devise:"/>&nbsp;
                        <h:selectOneMenu style="width:30%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesdevisesItem}"/>
                        </h:selectOneMenu>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Caisse exécutrice:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.inpCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                        <f:selectItem itemLabel="Sélection Caisse" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesCaissesRecettesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Type de Tiers:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrTiersCai=='0'}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrTiersCai=='0'}">
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrTypeTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                        <f:selectItem itemLabel="Sélection type" itemValue="100"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesTypeTiers}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.choixTypeTiers}" reRender="firstGrid,idBene1,idBene2,imp" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText id="idBene1" value="Payeur:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_beneficiaire}"/></h:column>
                <h:column>
                    <h:inputText id="idBene2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_beneficiaire}">
                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les éléments" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Campagne:" style="text-decoration:underline;" /></h:column>
                <h:column>
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                        <f:selectItem itemLabel="" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSourceItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>

            <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab label="Montant">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.choisirMontant}" reRender="prgtpAjt"/>
                    <h:panelGrid width="100%" id="idPanReg">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Libellé opération:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrLibelle}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrLibelleCai=='1'}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idReg" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:outputText value="Type règlement:" style="text-decoration:underline;"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_modeReglement}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesTypeReglementsItem}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.choixTypeReglement}" reRender="idPanReg,firstGrid,idImp1,idImp2,idReg,idEncais2"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value="Banque:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_banque}"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.inputBanq}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_banque}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesBanquesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.choixBanq}" reRender="firstGrid"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_banque}">
                            <h:column><h:outputText value="Banque émettrice:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBanqueTireur}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}"/></h:column>
                            <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrNumChqBdx}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="imp" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Montant opération:"/></h:column>
                            <h:column>
                                <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrMontant}" style="width:100%;text-align:center;font-weight:bold;font-size:50px"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMontantCai=='1'}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.choisirMontant}" reRender="prgtpAjt,imp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date valeur:"/></h:column>
                            <h:column>
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDateValeur}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Déposit d'argent ?" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_depot}"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_depot}" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_depot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}"/>
                            </h:column>
                            <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.nomRepMod})" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesModesleRecus}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.var_nom_createur}" disabled="true"/></h:column>
                            <h:column><h:outputText value="Responsable signataire:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.userResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRespCaissier==1}">
                                    <f:selectItem itemLabel="Sélectionnez responsable" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesResponsablesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="idImput" label="Imputations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_imputation}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.calculeMontantImputation}" reRender="idImputGlobal"/>
                    <h:panelGrid id="idImputGlobal" width="100%">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib1ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib2ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib3ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib4ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib5ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib6ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib7ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib8ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib9ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib10ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.optionCaisses.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}" maxlength="100"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idImputation">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_site}"><h:outputText value="Site:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_site}">
                                <h:selectOneMenu id="idSite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrSite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectonnez site" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_departement}"><h:outputText value="Département:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_departement}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDepartement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez département" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_service}"><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez service" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_region}"><h:outputText value="Région:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_region}">
                                <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrRegion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez région" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesRegionsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_secteur}"><h:outputText value="Secteur:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_secteur}">
                                <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrSecteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez secteur" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesSecteursItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.chargerPdv}" reRender="panFiltre,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_pdv}"><h:outputText value="Point de vente:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_pdv}">
                                <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrPdv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez point de vente" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.mesPdvItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez activité" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_dossier}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_codeDossier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez dossier" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesDossiersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_cle}"><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_cle}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrCle1Repartition}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_cle}"><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_cle}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrCle2Repartition}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_parc}"><h:outputText value="Parc:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_parc}">
                                <h:panelGrid id="idPanAnal" width="100%">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="idTable07" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.dataModelAxe07}" var="axe7" width="100%" height="300px" style="border: solid 1px" >
                                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.selctionAxe07}"/>
                                            <rich:column label="Parc"  width="20%">
                                                <f:facet name="header"><h:outputText value="Parc"/></f:facet>
                                                <h:inputText id="idParc1" value="#{axe7.ecranaAnal2}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.modeConsultation}">
                                                    <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.rechercherParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Libelle"  width="20%">
                                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                                <h:outputText id="idParc2" value="#{axe7.ecranaAnal2Lib}"/>
                                            </rich:column>
                                            <rich:column label="Pourcentage"  width="20%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                <h:inputText value="#{axe7.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.modeConsultation}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.calculLigne07}" reRender="idMontant07,idEcar07,idPanAnal,idPanValAnal,prgtpAjt"/>
                                                </h:inputText>
                                            </rich:column>
                                            <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                                <h:inputText id="idMontant07" value="#{axe7.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.modeConsultation}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.calculNouvelleLigne07}" reRender="idEcar07,idPanAnal,idPanValAnal,prgtpAjt"/>
                                                </h:inputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                    <h:panelGrid columns="2" id="idEcar07" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.util_axe07==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.modeConsultation}">
                                        <h:outputText value="Ecart Axe:"/>
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.ecart07}" style="text-align:right;width:90%;height:19px">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.projetActif}"><h:outputText value="Poste/Budget:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.projetActif}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_posteTreso}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez poste" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.lesPostesBudgetaires}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:outputText value="Budget:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBudget}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:outputText value="Disponibilité budget cumulé:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBudgetDispo}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:outputText value="Disponibilité budget mensuel:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBudgetDispoMois}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:outputText value="Disponibilité trésorerie cumulé:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBudgetTreso}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}"><h:outputText value="Disponibilité trésorerie mensuel:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_budget}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrBudgetTresoMois}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="idImputActivite" label="Activités" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_activite}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="300px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.dataModelDecoupageActivtes}" var="saisieAnal">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.selectionAnalytique}"/>
                            <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.laColonne1Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.valideColonne1}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.laColonne2Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.valideColonne2}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.laColonne3Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.valideColonne3}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="pourcentage"  width="8%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.calculPourcentage}" reRender="idRepartitionAnal,idTableAnal,prgtpAjt" focus="idRepartitionAnal"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant"  width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.controleEcartAnalytique}" reRender="idTableAnal,prgtpAjt" />
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="idHabilitation" label="Habiltation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrId!=0}">
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser1Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 1:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser1Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser1Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser2Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 2:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser2Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser2Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser3Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 3:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser3Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser3Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser4Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 4:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser4Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser4Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser5Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 5:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser5Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser5Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser6Id!=0}">
                        <h:column>
                            <h:outputText value="Signataire N° 6:"/>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser6Nom}" />
                        </h:column>
                        <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser6Etat}" disabled="true">
                                    <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="idEtat" label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrId!=0}">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                        <h:column><h:outputText value="ID du bon:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrId}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.nomCreateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID créateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrUserCreat}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de création:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDateCreat}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.nomModificateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID modificateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrUserModif}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de modification:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDateModif}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Validateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.nomValidateur}" size="100" readonly="true"/></h:column>
                        <h:column><h:outputText value="ID validateur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrUserValidation}" size="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date de validation:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDateValidation}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date d'impression:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrDateImpression}" readonly="true">
                                <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Habilitation:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrEtatVal}" disabled="true">
                                <f:selectItem itemLabel="Sans habilitation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec habilitation" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.bonEntreeCaiss.entrEtat}" disabled="true">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Validé" itemValue="1"/>
                                <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                <f:selectItem itemLabel="Correction" itemValue="6"/>
                                <f:selectItem itemLabel="Rejeté" itemValue="7"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.saveBonEntree}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>

    <rich:modalPanel headerClass="headerPanel" id="panelRecherche" width="900" height="550"style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="LISTE DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.libelleRecherche}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.annulerRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRecherche"  height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.dataModelRecherche}" var="rec">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.selectionRecherche}" reRender="idValSelectObjet"/>
                        <rich:column  width="20%" >
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{rec.code}"/>
                        </rich:column>
                        <rich:column  width="80%"  >
                            <f:facet name="header"><h:outputText  value="Libellé" /></f:facet>
                            <h:outputText value="#{rec.nom_FR}" />
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br><br>
                <center>
                    <h:panelGroup id="idValSelectObjet">
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.valideRecherche}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelRecherche,idTable07,idParc1,idParc2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonEntreeCaiss.formAnalytique.selectObjet}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
