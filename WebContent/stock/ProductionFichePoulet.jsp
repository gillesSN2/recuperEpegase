<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="receptionfichelot">

    <center>
        <a4j:form>
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES RECEPTIONS D'ACHAT (AVICULTURE)" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab label="Planning" id="tabPlanning">
                        <jsp:include flush="true" page="/stock/ProductionCommunPoulet.jsp" />
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable id="tableauDetail" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="120%" height="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.datamodelIntrants}" var="detail">
                                    <rich:column style="text-align:center;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{detail.recaviDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Poids"/></f:facet>
                                        <h:outputText value="#{detail.recaviPoids}" style="text-align:right;" rendered="#{detail.recaviPoids!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Temp."/></f:facet>
                                        <h:outputText value="#{detail.recaviTemperature}" style="text-align:right;">
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Qte Eau"/></f:facet>
                                        <h:outputText value="#{detail.recaviQteEau}" style="text-align:right;" rendered="#{detail.recaviQteEau!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Qte Alim."/></f:facet>
                                        <h:outputText value="#{detail.recaviQteAliment}" style="text-align:right;" rendered="#{detail.recaviQteAliment!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:right;" width="70px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Qte Mort."/></f:facet>
                                        <h:outputText value="#{detail.recaviNbMortalite}" style="text-align:right;" rendered="#{detail.recaviNbMortalite!=0}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Act.1"/></f:facet>
                                        <h:outputText value="#{detail.recaviAction1}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Act.2"/></f:facet>
                                        <h:outputText value="#{detail.recaviAction2}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Act.3"/></f:facet>
                                        <h:outputText value="#{detail.recaviAction3}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Trait.1"/></f:facet>
                                        <h:outputText value="#{detail.recaviTraitement1}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Trait.2"/></f:facet>
                                        <h:outputText value="#{detail.recaviTraitement2}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Trait.3"/></f:facet>
                                        <h:outputText value="#{detail.recaviTraitement3}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Vaccin 1"/></f:facet>
                                        <h:outputText value="#{detail.recaviVaccin1}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Vaccin 2"/></f:facet>
                                        <h:outputText value="#{detail.recaviVaccin2}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Vaccin 3"/></f:facet>
                                        <h:outputText value="#{detail.recaviVaccin3}"/>
                                    </rich:column>
                                    <rich:column style="text-align:left;" width="90px" sortable="false">
                                        <f:facet name="header"><h:outputText  value="Observation"/></f:facet>
                                        <h:outputText value="#{detail.recaviObservation}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat">
                        <jsp:include flush="true" page="/stock/ProductionCommunPoulet.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idPanEtat">
                            <h:column><h:outputText value="ID RECEPTION:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de relance:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateRelance}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de validité:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateValidite}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recEtat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Annulé" itemValue="3"/>
                                    <f:selectItem itemLabel="Transformé Partiel" itemValue="4"/>
                                    <f:selectItem itemLabel="Transformé Total" itemValue="5"/>
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Réactiver le document" style="color:red"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recEtat==3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.maj}" onclick="if (!confirm('Etes-vous sur de vouloir réactiver ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.reactiverDocument}" reRender="idPanEtat"/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="background-color:#DAEECB;" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Etat validation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recEtatVal}" disabled="true">
                                    <f:selectItem itemLabel="Sans méthode de validation" itemValue="0"/>
                                    <f:selectItem itemLabel="Avec méthode de validation" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Gel d'exception:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recGele}" disabled="true">
                                    <f:selectItem itemLabel="Non gelé" itemValue="0"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date de validation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateValide}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date de transformation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateTransforme}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'annulation:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDateAnnule}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Motif d'annulation:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recMotifAnnule}" size="100" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_aff_action}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le choix du nom du fournisseur sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>

</f:subview>
