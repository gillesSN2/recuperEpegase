<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichespret">

    <a4j:form>

        <center> <h2><h:outputText value="DETAIL DU PRET : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_lib_pret}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="idRecherche" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action==1}">
                <h:column><h:outputText value="Rechercher Agent:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.nomSalarie}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,tabPanelsalaries,FichSalarie,panelListeSalaries,formModalListeSalaries,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </h:inputText>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="FichSalarie" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salaries.salId!=0}">
                <jsp:include flush="true" page="/paye/PretCommun.jsp" />
            </h:panelGrid>

            <h:panelGrid id="tabPanelsalaries" width="100%" columns="2" columnClasses="clos50,clos50" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salaries.salId!=0}">
                <h:column>
                    <h:panelGrid columns="2" id="idPrets" columnClasses="clos30,clos70d" width="100%" style="height:350px" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Nature Prêt:"/></h:column>
                        <h:column>
                            <h:selectOneMenu tabindex="5" style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNaturesPretsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° du prêt:"/></h:column>
                        <h:column><h:inputText tabindex="6" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreNum}" disabled="true" /></h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu tabindex="7" style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.lesContratsActifsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date souscription (JJ/MM/AAAA):"/></h:column>
                        <h:column><rich:calendar tabindex="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateSouscription}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Date début Remboursement (JJ/MM/AAAA):"/></h:column>
                        <h:column><rich:calendar tabindex="9" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Montant du prêt:"/></h:column>
                        <h:column>
                            <h:inputText tabindex="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreMontant}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculEcheance}" reRender="tabPanelsalaries,panelBoutonPretsLignes,tablePretsLignes"/>
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise})"/>
                        </h:column>
                        <h:column><h:outputText value="Nombre échéances:"/></h:column>
                        <h:column>
                            <h:inputText tabindex="11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEcheance}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculEcheance}" reRender="tabPanelsalaries,panelBoutonPretsLignes,tablePretsLignes"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreId==0}"><h:outputText value=""/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreId==0}"><h:outputText value="OU"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreId==0}"><h:outputText value="Montant échéance:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreId==0}">
                            <h:inputText tabindex="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_montant_echeance}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculEcheance}" reRender="tabPanelsalaries,panelBoutonPretsLignes,tablePretsLignes"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Arrondi échéances:"/></h:column>
                        <h:column>
                            <h:selectOneMenu tabindex="13" style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreArrondi}" disabled="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreMontant==bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreRmb)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreMontant!=0)||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}">
                                <f:selectItem itemLabel="Sans arrondi" itemValue="0" />
                                <f:selectItem itemLabel="Arrondi à 100" itemValue="1" />
                                <f:selectItem itemLabel="Arrondi à 500" itemValue="2" />
                                <f:selectItem itemLabel="Arrondi à 1000" itemValue="3" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculEcheance}" reRender="tabPanelsalaries,panelBoutonPretsLignes,tablePretsLignes"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Description:"/></h:column>
                        <h:column><h:inputText tabindex="14" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Référence:"/></h:column>
                        <h:column><h:inputText tabindex="15" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreReference}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Journal comptable:"/></h:column>
                        <h:column><h:inputText tabindex="16" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreJournal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Responsable:"/></h:column>
                        <h:column><h:inputText tabindex="17" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="Service:"/></h:column>
                        <h:column><h:inputText tabindex="18" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column><h:outputText value="N° Compte comptable:"/></h:column>
                        <h:column><h:inputText tabindex="19" style="width:90%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreCompte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_prets==3}"/></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                    </h:panelGrid>
                    <h:panelGrid  styleClass="fichefournisseur1" width="100%">
                        <h:column><h:outputText value="Si la date de début de remboursement n'est pas vide, alors les échéances sont calculées automatiquement" style="color:red;"/></h:column>
                        <h:column><h:outputText value="Si la date de début de remboursement est vide, alors les échéances sont saisies manuellement" style="color:red;"/></h:column>
                    </h:panelGrid>
                </h:column>
                <h:column>
                    <h:panelGrid width="150px" id="panelBoutonPretsLignes" columns="4" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton title="Ajouter un nouvelle échéance" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateSouscription!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut==null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajouterPretsLignes}" reRender="panelPretsLignes"/>
                        <a4j:commandButton title="Modifier l'échéance sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligMontantReel==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_lignes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.modifierPretsLignes}" reRender="panelPretsLignes"/>
                        <a4j:commandButton title="Consulter le bulletin généré" image="/images/bulletin.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligDateReel!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_lignes}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.consulterBulletinPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panelBulletin"/>
                        <a4j:commandButton title="Vérifier l'échéance sélectionnée" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_lignes&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action!=3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.verifierPretsLignes}" reRender="tablePretsLignes,idTotalManuel"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsLignes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelPretsLignes}" var="lig">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.selectionPretsLignes}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsLignes"/>
                            <rich:column label="Date théorique" sortable="false" width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Date Théo." /></f:facet>
                                <h:outputText value="#{lig.salpreligDateTheo}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant théorique" sortable="false" width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant Théo." /></f:facet>
                                <h:outputText value="#{lig.salpreligMontantTheo}" rendered="#{lig.salpreligMontantTheo!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date Réelle" sortable="false" width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Date Réel." /></f:facet>
                                <h:outputText value="#{lig.salpreligDateReel}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Montant réel" sortable="false" width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant Réel." /></f:facet>
                                <h:outputText value="#{lig.salpreligMontantReel}" rendered="#{lig.salpreligMontantReel!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Référence" sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Référence" /></f:facet>
                                <h:outputText value="#{lig.salpreligReference}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                        <h:panelGrid columns="6" width="100%" id="idTotalManuel">
                            <h:column><h:outputText value="Total prêt:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_pret}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total remboursé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_rmb}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reste dû:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.solde_pret}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </a4j:region>
                </h:column>
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.annulerPret}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.savePret}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action!=3}"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelPretsLignes" width="700" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelPretsLignes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelPretsLignes}" var="moe">
            <f:facet name="header"><h:outputText value="DETAIL D'UNE ECHEANCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanPretsLigne" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.annulerPretsLignes}" styleClass="hidelink" reRender="panelPretsLignes,panelBoutonPretsInternesLignes,panelBoutonPretsExternesLignes,panelBoutonPretsManuelsLignes"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanPretsLignes')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="width:100%;" id="panLigneGlob">
                    <h:panelGrid style="width:100%;" columns="2" columnClasses="clos30,clos70">
                        <h:column><h:outputText value="Date Remboursement (JJ/MM/AAAA):"/></h:column>
                        <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligDateTheo}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut!=null}"/></h:column>
                        <h:column><h:outputText value="Montant échéance:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligMontantTheo}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligMontantReel!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_ligne==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.changeEcheance}" reRender="panLigneGlob,idChoix,idValPretsLignes" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Référence:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligReference}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligMontantReel!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_ligne==3}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut!=null}"><h:outputText value="Date Paiement (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut!=null}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligDatePaiement}" popup="true" disabled="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut!=null}"><h:outputText value="Caisse Paiement:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut!=null}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligCaisse}" disabled="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreType==2}"><h:outputText value="Montant à payer:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreType==2}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPretsLignes.salpreligMontantTheo}" style="text-align:right;width:100px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_ligne==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.changeEcheance}" reRender="panLigneGlob,idChoix,idValPretsLignes" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Action:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idChoix" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_choix_ligne}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_action_ligne==3||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateDebut==null}">
                                <f:selectItem itemLabel="Ne pas modifier l'échéance" itemValue="0" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_change_echeance}"/>
                                <f:selectItem itemLabel="Recalculer les échéances suivantes" itemValue="1"/>
                                <f:selectItem itemLabel="Ajouter une nouvelle échéance" itemValue="2" />
                                <f:selectItem itemLabel="Forcer le montant du prêt" itemValue="3" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.valideEcheance}" reRender="panLigneGlob,idValPretsLignes" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValPretsLignes" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.savePretsLignes}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_change_echeance}" reRender="panelPretsLignes,tablePretsLignes,idTotalManuel,idPrets"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValPretsLignes')}.click()" />
                        </center>
                    </h:panelGroup>

                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBulletin" width="900" height="550" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelBulletin}" var="bul">
            <f:facet name="header"><h:outputText value="BULLETIN DU : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalPeriode} POUR #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salMatricule} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.salaries.salNom}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanBulletin" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.fermerConsulterBulletin}" styleClass="hidelink" reRender="panelBulletin"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <jsp:include flush="true" page="/paye/FicheSalarieBulletins.jsp" />
        </c:if>
    </rich:modalPanel>

</f:subview>
