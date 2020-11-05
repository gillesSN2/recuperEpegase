<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="simulcmd">
    <a4j:form id="cmdsimul">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="SIMULATION DU P.R." style="color:green;"/></h2></center>

        <h:panelGrid  id="idlienMvt" width="100%">
            <f:facet name="header"><h:outputText value="COMMANDE N°: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNum} - Founisseur: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdNomTiers} - Modèle: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.commandeEnteteAchats.cmdModelePr}"></h:outputText></f:facet>
            <br>
            <h:panelGroup>
                <center>
                    <a4j:commandButton image="/images/actualiser.png" title="Ajouter une simulation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.ajouerSimulation}" reRender="panelSimulation"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton image="/images/print.png" title="Imrimer la simulation" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.initImpression}" reRender="panelImp"/><br><br>
                    <a4j:commandButton value="Masquer/Afficher formules" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerAfficherFormules}" reRender="tableDetail"/>&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton value="Masquer/Afficher colonnes inter." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerAfficherColonnes}" reRender="tableDetail"/>
                </center>
            </h:panelGroup>
            <br>
            <h:column>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="max-height:100%;border:solid 0px green;" id="tableDetail" styleClass="bg" width="100%" border="0" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.dataModelDetailFrais}" var="det">
                        <rich:column width="5%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Ref."/></f:facet>
                            <h:outputText value="#{det.profrsCode}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column  width="20%" sortable="false">
                            <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                            <h:outputText value="#{det.profrsLibelle}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerFomrule}">
                            <f:facet name="header"><h:outputText value="Formule A(Base)"/></f:facet>
                            <h:outputText value="#{det.profrsFormuleA}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerFomrule}">
                            <f:facet name="header"><h:outputText value="Formule B(Taux)"/></f:facet>
                            <h:outputText value="#{det.profrsFormuleB}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerFomrule}">
                            <f:facet name="header"><h:outputText value="Formule C(Nb)"/></f:facet>
                            <h:outputText value="#{det.profrsFormuleC}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerFomrule}">
                            <f:facet name="header"><h:outputText value="Formule D(Résultat)"/></f:facet>
                            <h:outputText value="#{det.profrsFormuleD}" style="#{det.stypeNature}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerColonneIntemediaire}">
                            <f:facet name="header"><h:outputText value="Col(A)"/></f:facet>
                            <h:outputText value="#{det.profrsValA}" rendered="#{det.profrsValA!=0&&det.profrsDecimalA==0}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValA}" rendered="#{det.profrsValA!=0&&det.profrsDecimalA==1}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValA}" rendered="#{det.profrsValA!=0&&det.profrsDecimalA==2}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.00"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValA}" rendered="#{det.profrsValA!=0&&det.profrsDecimalA==3}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.000"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="15%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerColonneIntemediaire}">
                            <f:facet name="header"><h:outputText value="Col(B)"/></f:facet>
                            <h:outputText value="#{det.profrsValB}" rendered="#{det.profrsValB!=0&&det.profrsDecimalB==0}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValB}" rendered="#{det.profrsValB!=0&&det.profrsDecimalB==1}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValB}" rendered="#{det.profrsValB!=0&&det.profrsDecimalB==2}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.00"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValB}" rendered="#{det.profrsValB!=0&&det.profrsDecimalB==3}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.000"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="15%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.masquerColonneIntemediaire}">
                            <f:facet name="header"><h:outputText value="Col(C)"/></f:facet>
                            <h:outputText value="#{det.profrsValC}" rendered="#{det.profrsValC!=0&&det.profrsDecimalC==0}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValC}" rendered="#{det.profrsValC!=0&&det.profrsDecimalC==1}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValC}" rendered="#{det.profrsValC!=0&&det.profrsDecimalC==2}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.00"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValC}" rendered="#{det.profrsValC!=0&&det.profrsDecimalC==3}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.000"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="15%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="Résultat"/></f:facet>
                            <h:outputText value="#{det.profrsValD}" rendered="#{det.profrsValD!=0&&det.profrsDecimalD==0}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValD}" rendered="#{det.profrsValD!=0&&det.profrsDecimalD==1}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.0"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValD}" rendered="#{det.profrsValD!=0&&det.profrsDecimalD==2}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.00"/>
                            </h:outputText>
                            <h:outputText value="#{det.profrsValD}" rendered="#{det.profrsValD!=0&&det.profrsDecimalD==3}" style="#{det.stypeNature}">
                                <f:convertNumber type="number" pattern="#,##0.000"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:column>

        </h:panelGrid>

        <h:panelGroup>
            <center>
                <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.annule}" />
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelSimulation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="580" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.showModalPanelSimulation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.showModalPanelSimulation}" var="detrub">
            <center>
                <f:facet name="header"><h:outputText value="Gestion d'une simulation"/></f:facet>
                <f:facet name="controls">
                    <a4j:form>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.closeSimulation}" image="/images/close.gif" styleClass="hidelink" reRender="panelSimulation"/>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalSim" >
                    <rich:hotKey key="return" handler="return false;"/>
                    <h:panelGrid width="100%" id="panInit">
                        <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Modèle:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_modele_simulation}" >
                                    <f:selectItem itemLabel="Sélecionnez un modèle" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.mesSimulationItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.calculInit}" reRender="panInit,tableVariable,idVar1,idVar2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_date_simulation}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                            <h:column><h:outputText value="Devise achat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_devise}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesdevisesItem}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.afficheDevise}" reRender="panInit"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Coefficient devise:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_coef_devise}" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}"><h:outputText value="Prix achat (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_devise}):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_pa}" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.calculInit}" reRender="panInit"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Prix achat (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_pa_local}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}"><h:outputText value="FRET (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_devise}):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_fret}" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.calculInit}" reRender="panInit"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="FRET (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_fret_local}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}"><h:outputText value="ASSURANCE (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_devise}):"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affiche_devise}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_assurance}" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.calculInit}" reRender="panInit"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="ASSURANCE (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_assurance_local}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.calculInit}" reRender="panInit"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Montant C.A.F.(#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_montant_initial}" readonly="true" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Exonéré de douane"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_exo_douane}" readonly="true" style="text-align:right;">
                                    <f:selectItem itemLabel="Douane normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Exonération totale de Douane" itemValue="1"/>
                                    <f:selectItem itemLabel="Exonération partielle de Douane" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Exonéré de TVA"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.var_exo_tva}" readonly="true" style="text-align:right;">
                                    <f:selectItem itemLabel="TVA normale" itemValue="0"/>
                                    <f:selectItem itemLabel="Exonéré de TVA" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" id="idVar1"  headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affichageListeVariable}">
                            <f:facet name="header"><h:outputText value="Saisie des variables"/></f:facet>
                            <h:column id="idVar2">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable style="border:solid 0px green;" id="tableVariable" styleClass="bg" width="100%" height="250px" border="0" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" sortMode="multi" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.dataModelVariables}" var="var">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.selectionLigneVariable}" />
                                        <rich:column width="20%" sortable="false">
                                            <f:facet name="header" ><h:outputText value="Ref."/></f:facet>
                                            <h:outputText value="#{var.column_code}"/>
                                        </rich:column>
                                        <rich:column width="10%" sortable="false">
                                            <f:facet name="header" ><h:outputText value="Col."/></f:facet>
                                            <h:outputText value="#{var.column_type}"/>
                                        </rich:column>
                                        <rich:column  width="40%" sortable="false">
                                            <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                            <h:outputText value="#{var.column_name}"/>
                                        </rich:column>
                                        <rich:column width="30%" sortable="false" style="text-align:right;">
                                            <f:facet name="header"><h:outputText value="Valeur"/></f:facet>
                                            <h:inputText value="#{var.column_pr}" style="text-align:right;width:85%">
                                            </h:inputText>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGroup id="panelValide">
                        <center>
                            <br><br>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.validerSimulation}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                        </center>
                    </h:panelGroup>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="350" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.showModalPanelPrint}" var="prt">
            <center>
                <f:facet name="header"><h:outputText value="Impression"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                            <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                        </a4j:commandButton>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalImp" target="_blank">
                    <rich:hotKey key="return" handler="return false;"/>
                    <center>
                        <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                        <br><br>
                    </center>
                    <h:panelGrid  width="100%">
                        <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                            <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                            <br>
                            <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.nomModeleDocument}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.lesmodelesImpressions}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="9" style="height:80px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                    <center>
                                        <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                        <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                        </h:selectOneMenu>
                                    </center>
                                </h:panelGroup>
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue="" />
                                    </h:selectOneMenu >
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formCommandeAchats.calculPrp.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>
