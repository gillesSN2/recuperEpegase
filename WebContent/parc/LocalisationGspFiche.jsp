<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficheconsommation">

    <a4j:form>

        <center> <h2><h:outputText value="FICHE CONSOMMATION : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.libelleConsommation}" style="color:green;"/></h2></center>

        <rich:tabPanel switchType="client" immediate="true"  id="tabPanelparc" style="border:0px;">

            <rich:tab label="Identification" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_acc_descriptif}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.autorisationDescription}">
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Date:"/></h:column>
                        <h:panelGrid width="100%" columns="4">
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_date}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDatePrc==0}"/>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_heure}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}"/>
                            </h:selectOneMenu>
                            <h:column><h:outputText value=":"/></h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_minute}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:45px">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText style="width:95%;text-align:center;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconNum}" readonly="true"/></h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Immatriculation:"/></h:column>
                        <h:column>
                            <h:inputText id="idParc" style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parc.prcImmatriculation}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les parcs (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeParc,formModalListeParc,idProduit,idLibelleParc,idDepot"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText id="idLibelleParc" style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parc.libelleParc}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Produit:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idProduit" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconCode}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:100%">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.lesProdtuisItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.calculdeDepot}" reRender="idDepot"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Relevé compteur:"/></h:column>
                        <h:column>
                            <h:inputText style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconCompteur}"/>&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parc.libCompteur}"/>
                        </h:column>
                        <h:column><h:outputText value="Dépôt:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idDepot" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconDepot}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:100%">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.lesDepotsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.calculPu}" reRender="idPu"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="P.U.:"/></h:column>
                        <h:column>
                            <h:inputText id="idPu" style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconPu}" readonly="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_saisie_pu}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Qte:"/></h:column>
                        <h:column>
                            <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconQte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.calculTotal}" reRender="idTotal"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total:"/></h:column>
                        <h:column>
                            <h:inputText id="idTotal" style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconTotal}" readonly="true">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Affectations/Imputations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_acc_affectation}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.autorisationAffectation}">
                <h:panelGrid  width="100%" style="max-height:100%;">
                    <h:panelGrid style="background-color:#DAEECB;" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconService}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:100%">
                                <f:selectItem itemLabel="Sans service" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesServiceItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.calculDemandeur}" reRender="idDemandeur"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Demandeur:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idDemandeur" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconIdDemandeur}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}" style="width:100%">
                                <f:selectItem itemLabel="Sans demandeur" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesDemandeursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.decoupageActivite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.parcConsommation.prcconActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_aff_action}">
                                <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.mesActivitesItems}" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.decoupageActivite}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.dataModelDecoupageActivtes}" var="saisieAnal">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.selectionAnalytique}"/>
                                    <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.decoupageActivite}">
                                        <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.laColonne1Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.valideColonne1}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.laColonne2Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.valideColonne2}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.decoupageActivite}">
                                        <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                        <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                            <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.laColonne3Items}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.valideColonne3}" />
                                        </h:selectOneMenu>
                                    </rich:column>
                                    <rich:column label="%"  width="15%" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                        <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.controleEcartAnalytique}" reRender="idTableAnal" />
                                        </h:inputText>
                                    </rich:column>
                                    <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                        <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.supprimerAnalytique}" reRender="idTableAnal"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <center>
            <br>
            <h:panelGroup id="valParc">
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.annulerConsommation}" image="/images/annuler_big.png" style="width:30px;height:30px"/>&nbsp;&nbsp;&nbsp;&nbsp;
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.saveConsommation}" image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_valide_parc&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.formConsommation.var_action!=3}"/>
            </h:panelGroup>
        </center>

    </a4j:form>

</f:subview>
