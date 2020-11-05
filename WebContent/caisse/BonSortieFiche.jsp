<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="bonsortie">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="DETAIL BON DE SORTIE" style="color:green;"/></h2></center>

            <h:panelGrid id="idPanGlobal" width="100%">
                <h:panelGrid id="idPan0" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Caisse exécutrice:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSelCaisse" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.inpCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_verrou_caisse&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesCaissesDepenseItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.selectionCaisse}" reRender="idPan0,idSelOperation,idImputation"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Nature opération:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idSelOperation" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.natureOperation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <f:selectItem itemLabel="Choisissez une nature" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesOperationsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.selectionOperation}" reRender="idPanGlobal,idPan1,idPan11,idPan2,prgtpAjt"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date opération:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                    <h:column> <h:outputText value="N° reçu:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortNum}" disabled="true" style="width:30%"/>&nbsp;&nbsp;
                        <h:outputText value="Série:"/>&nbsp;
                        <h:selectOneMenu  style="width:20%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSeriesUsersItem}"/>
                        </h:selectOneMenu>&nbsp;
                        <h:outputText value="Devise:"/>&nbsp;
                        <h:selectOneMenu style="width:20%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDevise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesdevisesItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="idPan1" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrTiersCai=='0'&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==4)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.visibleSuite}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==1}"><h:outputText value="Nom fournisseur:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==1}">
                        <h:inputText style="width:100%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les fournisseurs (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idTiers"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==4}"><h:outputText value="Plan comptable:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==4}">
                        <h:inputText style="width:100%" id="idPlc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les comptes (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.recherchePlanComptable}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListePlanComptable,formModalListePlanComptable,idPlc"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Description/Destinataire:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortLibelle}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                    <h:column><h:outputText value="N° Facture:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDocument}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Objet:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortObjet}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_codeActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <f:selectItem itemLabel="Aucune une activité" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesActivitesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.choixActivite}" reRender="idPan1,idAct1,idAct2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Campagne:" style="text-decoration:underline;" /></h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortSource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSourceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}"><h:outputText id="idAct1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.libActivite}:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.affActivite}"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}"><h:inputText id="idAct2" style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_codeDossier}" maxlength="20" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.affActivite}"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="idPan11" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrTiersCai=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.caissesOperations.caiopeCategorie==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.visibleSuite}">
                    <h:column><h:outputText value="Nom salarié:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText style="width:100%" id="idSalarie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                            <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les agents (puis tabuler)" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeSalaries,formModalListeSalaries,idSalarie"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Description:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortLibelle}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                    <h:column><h:outputText value="N° Bulletin:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDocument}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                    <h:column><h:outputText value="Objet:"/></h:column>
                    <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortObjet}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                </h:panelGrid>

                <rich:tabPanel switchType="client" immediate="true" id="idPan2" style="border:0px;background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.visibleSuite}">
                    <rich:tab label="Montant">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.choisirMontant}" reRender="prgtpAjt"/>
                        <h:panelGrid width="100%" id="idPanReg">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                                <h:column><h:outputText value="Libellé opération:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortLibelle}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrLibelleCai=='1'}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idReg" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                <h:outputText value="Type règlement:" style="text-decoration:underline;"/>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_modeReglement}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesTypeReglementsItem}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.choixTypeReglement}" reRender="idPanReg,firstGrid,imp,idImp1,idImp2,idReg,idEncais2"/>
                                </h:selectOneMenu>
                                <h:column><h:outputText value="Banque:" style="text-decoration:underline;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_banque}"/></h:column>
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.inputBanq}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_banque}" style="width:100%;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez banque" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesBanquesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.choixBanq}" reRender="firstGrid"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_banque}">
                                <h:column><h:outputText value="Banque tireur:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBanqueTireur}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                                <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortNumChqBdx}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid id="imp" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                                <h:column><h:outputText value="Montant opération:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortMontant}" style="width:100%;text-align:center;font-weight:bold;font-size:50px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMontantCai=='1'}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.choisirMontant}" reRender="prgtpAjt,imp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Date valeur:"/></h:column>
                                <h:column>
                                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDateValeur}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Retrait déposit ?" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_depot}"/>
                                    <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_depot}" style="color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_depot}"/>
                                </h:column>
                                <h:column><h:outputText id="idImp1" value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.nomRepMod})" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idImp2" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesModesleRecus}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value=""/></h:column>
                                <h:column><h:outputText value="Créateur:"/></h:column>
                                <h:column><h:inputText style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.var_nom_createur}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Responsable signataire:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.userResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRespCaissier==1}">
                                        <f:selectItem itemLabel="Sélectionnez responsable" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesResponsablesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib1ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib1ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib1ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib2ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib2ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib2ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib3ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib3ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib3ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib4ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib4ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib4ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib5ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib5ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib5ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib6ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib6ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib6ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib7ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib7ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib7ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib8ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib8ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib8ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib9ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib9ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib9ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib10ENTETE!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib10ENTETE}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.optionCaisses.lib10ENTETE!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}" maxlength="100"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="idImput" label="Imputations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_imputation}">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.calculeMontantImputation}" reRender="idImputGlobal"/>
                        <h:panelGrid id="idImputGlobal" width="100%">
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idImputation">
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_site}"><h:outputText value="Site:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_site}">
                                    <h:selectOneMenu id="idSite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortSite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectonnez site" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSitesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_departement}"><h:outputText value="Département:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_departement}">
                                    <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDepartement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez département" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesDepartementsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.chargerService}" reRender="panFiltre,idService" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_service}"><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_service}">
                                    <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez service" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesServicesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_region}"><h:outputText value="Région:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_region}">
                                    <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortRegion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez région" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesRegionsItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_secteur}"><h:outputText value="Secteur:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_secteur}">
                                    <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortSecteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez secteur" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesSecteursItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.chargerPdv}" reRender="panFiltre,idPdv" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_pdv}"><h:outputText value="Point de vente:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_pdv}">
                                    <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortPdv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez point de vente" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.mesPdvItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_activite&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}">
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez activité" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesActivitesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_dossier}"><h:outputText value="Dossier:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_dossier}">
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_codeDossier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez dossier" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesDossiersItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_cle}"><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_cle}">
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortCle1Repartition}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_cle}"><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_cle}">
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortCle2Repartition}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesClesItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_parc}"><h:outputText value="Parc:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_parc}">
                                    <h:panelGrid id="idPanAnal" width="100%">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable id="idTable07" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.dataModelAxe07}" var="axe7" width="100%" height="300px" style="border: solid 1px" >
                                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.selctionAxe07}"/>
                                                <rich:column label="Parc"  width="20%">
                                                    <f:facet name="header"><h:outputText value="Parc"/></f:facet>
                                                    <h:inputText id="idParc1" value="#{axe7.ecranaAnal2}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.modeConsultation}">
                                                        <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un code ou d'un libellé" style="background-color:#FFF8D4;"/>
                                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.rechercherParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  reRender="modAttente,panelRecherche"/>
                                                    </h:inputText>
                                                </rich:column>
                                                <rich:column label="Libelle"  width="20%">
                                                    <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                                    <h:outputText id="idParc2" value="#{axe7.ecranaAnal2Lib}"/>
                                                </rich:column>
                                                <rich:column label="Pourcentage"  width="20%" style="text-align:right;">
                                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                                    <h:inputText value="#{axe7.ecranaPourcentage}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.modeConsultation}">
                                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.calculLigne07}" reRender="idMontant07,idEcar07,idPanAnal,idPanValAnal"/>
                                                    </h:inputText>
                                                </rich:column>
                                                <rich:column label="Montant"  width="20%" style="text-align:right;" >
                                                    <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                                    <h:inputText id="idMontant07" value="#{axe7.ecranaMontantSaisie}" style="text-align:right;width:90%;height:19px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.modeConsultation}">
                                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.calculNouvelleLigne07}" reRender="idEcar07,idPanAnal,idPanValAnal"/>
                                                    </h:inputText>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                        <h:panelGrid columns="2" id="idEcar07" style="text-align:right;color:red" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.util_axe07==0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.modeConsultation}">
                                            <h:outputText value="Ecart Axe:"/>
                                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.ecart07}" style="text-align:right;width:90%;height:19px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.projetActif}"><h:outputText value="Poste/Budget:" style="text-decoration:underline;"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.projetActif}">
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_posteTreso}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez poste" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.lesPostesBudgetaires}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:outputText value="Budget:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBudget}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:outputText value="Disponibilité budget cumulé:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBudgetDispo}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:outputText value="Disponibilité budget mensuel:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBudgetDispoMois}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:outputText value="Disponibilité trésorerie cumulé:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBudgetTreso}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}"><h:outputText value="Disponibilité trésorerie mensuel:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_budget}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortBudgetTresoMois}" size="10" readonly="true" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="idImputActivite" label="Activités" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrImputCai=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_activite}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="300px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.dataModelDecoupageActivtes}" var="saisieAnal">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.selectionAnalytique}"/>
                                <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.laColonne1Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.valideColonne1}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.laColonne2Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.valideColonne2}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.laColonne3Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.valideColonne3}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="pourcentage"  width="8%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.calculPourcentage}" reRender="idRepartitionAnal,idTableAnal" focus="idRepartitionAnal"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column label="Montant"  width="15%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                    <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.controleEcartAnalytique}" reRender="idTableAnal" />
                                    </h:inputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="idHabilitation" label="Habiltation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.habilitation!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortId!=0}">
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser1Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 1:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser1Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser1Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser2Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 2:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser2Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser2Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser3Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 3:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser3Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser3Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser4Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 4:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser4Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser4Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid  style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser5Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 5:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser5Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser5Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                        <h:panelGrid style="width:100%;" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser6Id!=0}">
                            <h:column>
                                <h:outputText value="Signataire N° 6:"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser6Nom}" />
                            </h:column>
                            <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos20,clos80">
                                <h:column><h:outputText value="Réponse:"/> </h:column>
                                <h:column><h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser6Etat}" disabled="true">
                                        <jsp:include flush="true" page="../commun/etatHabilitation.jsp"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Date réponse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                                <h:column><h:outputText value="Explication:"/></h:column>
                                <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="idEtat" label="Etat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortId!=0}">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID du bon:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.nomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortUserCreat}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.nomModificateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortUserModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Validateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.nomValidateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID validateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortUserValidation}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDateValidation}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortDateImpression}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Habilitation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans habilitation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec habilitation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.bonSortieCaiss.sortEtat}" disabled="true">
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
            </h:panelGrid>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.saveBonSortie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel headerClass="headerPanel" id="panelRecherche" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.showModalPanelRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.showModalPanelRecherche}" var="rec">
            <f:facet name="header"><h:outputText value="LISTE DES #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.libelleRecherche}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.annulerRecherche}" image="/images/close.gif" styleClass="hidelink" reRender="panelRecherche,idDossier1,idDossier2,idMission1,idMission2,idChantier1,idChantier2,idParc1,idParc2,idAgent1,idAgent2,idProjet1,idProjet2"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRecherche"  height="400px" width="100%" headerClass="headerTab" selectedClass="active-row" style="border:solid 0px green;cursor:pointer;" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.dataModelRecherche}" var="rec">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.selectionRecherche}" reRender="idValSelectObjet"/>
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
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.valideRecherche}" image="/images/valider_big.png" styleClass="hidelink" reRender="panelRecherche,idTable07,idParc1,idParc2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formBonSortieCaiss.formAnalytique.selectObjet}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
