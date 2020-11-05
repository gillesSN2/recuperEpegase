<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ptp">

    <a4j:form id="form">

        <center><h2><h:outputText value="PLANNING THEORIQUE AVICULTURE" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="4" width="200px">
            <a4j:commandButton title="Ajouter une nouveau planning" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.ajouterPlanning}" reRender="panelPlanning"/>
            <a4j:commandButton title="Modfier le planning sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.modifierPlanning}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_affiche_bouton}" reRender="panelPlanning"/>
            <a4j:commandButton title="Supprimer le plannong sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_affiche_bouton}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.supprimerPlanning}" reRender="panelBouton,tablePlanning"/>
            <a4j:commandButton title="Imprimer la liste des plannings" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
        </h:panelGrid>
        <br>
        <h:panelGrid id="tableau" border="0" width="100%" style="text-align:center;">
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tablePlanning" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.datamodelPlanningEntete}" var="feuille">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.selectionPlanning}" reRender="panelBouton"/>
                    <rich:column style="text-align:left;" width="30%">
                        <f:facet name="header"><h:outputText  value="Code Planning"/></f:facet>
                        <h:outputText  value="#{feuille.ppaCode}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="60%">
                        <f:facet name="header"><h:outputText  value="Libellé Planning"/></f:facet>
                        <h:outputText  value="#{feuille.ppaFeuille}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%">
                        <f:facet name="header"><h:outputText  value="Nb jour"/></f:facet>
                        <h:outputText  value="#{feuille.ppaNbJour}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelPlanning" width="1200" height="590" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.showModalPanelPlanning}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.showModalPanelPlanning}" var="feu">
            <f:facet name="header"><h:outputText value="DETAIL D'UN PLANNING"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.annulerPlanning}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelPlanning"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="6" width="100%">
                    <h:column><h:outputText value="Code du planning:"/></h:column>
                    <h:column><h:inputText size="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_code_feuille}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_mode_feuille}"/></h:column>
                    <h:column><h:outputText value="Nom du planning:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_nom_feuille}" maxlength="50"/></h:column>
                    <h:column><h:outputText value="Nb jours:"/></h:column>
                    <h:column>
                        <h:inputText size="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_nb_jour}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.var_mode_feuille}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.calculeNbSemaine}" reRender="tableauDetail"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid id="panFonction" width="200px" columns="3">
                    <a4j:commandButton title="Ajouter un nouvel élément" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.ajouterDetail}" reRender="panelDetail" rendered="false"/>
                    <a4j:commandButton title="Modfier l'élément sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.modifierDetail}" reRender="panelDetail"/>
                    <a4j:commandButton title="Supprimer l'élément sélectionné" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.supprimerDetail}" reRender="tableauDetail" rendered="false"/>
                </h:panelGrid>
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableauDetail" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="120%" height="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.datamodelPlanningLigne}" var="detail">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.selectionDetail}"/>
                            <rich:column style="text-align:center;" width="60px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Jours"/></f:facet>
                                <h:outputText  value="#{detail.ppaJour}" style="text-align:center;"/>
                            </rich:column>
                            <rich:column style="text-align:right;" width="70px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Poids"/></f:facet>
                                <h:outputText value="#{detail.ppaPoids}" style="text-align:right;" rendered="#{detail.ppaPoids!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column style="text-align:right;" width="70px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Temp."/></f:facet>
                                <h:outputText value="#{detail.ppaTemperature}" style="text-align:right;">
                                </h:outputText>
                            </rich:column>
                            <rich:column style="text-align:right;" width="70px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Qte Eau"/></f:facet>
                                <h:outputText value="#{detail.ppaQteEau}" style="text-align:right;" rendered="#{detail.ppaQteEau!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column style="text-align:right;" width="70px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Qte Alim."/></f:facet>
                                <h:outputText value="#{detail.ppaQteAliment}" style="text-align:right;" rendered="#{detail.ppaQteAliment!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column style="text-align:right;" width="70px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Qte Mort."/></f:facet>
                                <h:outputText value="#{detail.ppaNbMortalite}" style="text-align:right;" rendered="#{detail.ppaNbMortalite!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Act.1"/></f:facet>
                                <h:outputText value="#{detail.ppaAction1}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Act.2"/></f:facet>
                                <h:outputText value="#{detail.ppaAction2}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Act.3"/></f:facet>
                                <h:outputText value="#{detail.ppaAction3}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Trait.1"/></f:facet>
                                <h:outputText value="#{detail.ppaTraitement1}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Trait.2"/></f:facet>
                                <h:outputText value="#{detail.ppaTraitement2}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Trait.3"/></f:facet>
                                <h:outputText value="#{detail.ppaTraitement3}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Vaccin 1"/></f:facet>
                                <h:outputText value="#{detail.ppaVaccin1}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Vaccin 2"/></f:facet>
                                <h:outputText value="#{detail.ppaVaccin2}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Vaccin 3"/></f:facet>
                                <h:outputText value="#{detail.ppaVaccin3}"/>
                            </rich:column>
                            <rich:column style="text-align:left;" width="90px" sortable="false">
                                <f:facet name="header"><h:outputText  value="Observation"/></f:facet>
                                <h:outputText value="#{detail.ppaObservation}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </div>
                <center>
                    <br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.savePlanning}" reRender="tableau,panelPlanning"/>
                    </h:panelGroup>
                    <br>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panelDetail" width="800" height="490" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.showModalPanelDetail}" var="det">
            <f:facet name="header"><h:outputText value="DESCRIPTIF DES ELEMENTS D'UN JOUR"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.annulerDetail}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelDetail"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="panelGlobal">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Jour:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaJour}" disabled="true"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Poids (gr):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaPoids}" size="5" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Température (C°):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaTemperature}" size="5" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Quantité d'eau (ml):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaQteEau}" size="5" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Quantité d'aliment (gr):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaQteAliment}" size="5" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Nombre mortalité:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaNbMortalite}" size="5" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Action 1:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaAction1}" style="width:90%">
                            <f:selectItem itemLabel="Sélection action 1" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesActionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Action 2:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaAction2}" style="width:90%">
                            <f:selectItem itemLabel="Sélection action 2" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesActionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Action 3:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaAction3}" style="width:90%">
                            <f:selectItem itemLabel="Sélection action 3" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesActionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Traitement 1:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaTraitement1}" style="width:90%">
                            <f:selectItem itemLabel="Sélection traitement 1" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesTraitementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Traitement 2:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaTraitement2}" style="width:90%">
                            <f:selectItem itemLabel="Sélection traitement 2" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesTraitementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Traitement 3:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaTraitement3}" style="width:90%">
                            <f:selectItem itemLabel="Sélection traitement 3" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesTraitementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Vaccin 1:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaVaccin1}" style="width:90%">
                            <f:selectItem itemLabel="Sélection vaccin 1" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesVaccinsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Vaccin 2:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaVaccin2}" style="width:90%">
                            <f:selectItem itemLabel="Sélection vaccin 2" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesVaccinsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Vaccin 3:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaVaccin3}" style="width:90%">
                            <f:selectItem itemLabel="Sélection vaccin 3" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.mesVaccinsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.planningAvicultureAchats.ppaObservation}">
                        <jsp:include flush="true" page="../../css/tdt.jsp"/>
                    </rich:editor>
                </h:panelGrid>
                <center>
                    <br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formPlanningAvicultureAchats.saveDetail}" reRender="tableauDetail,panelDetail"/>
                    </h:panelGroup>
                    <br/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>



</f:subview>
