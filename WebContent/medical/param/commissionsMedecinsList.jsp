<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="commedecin">

    <a4j:form>

        <center><h2><h:outputText value="COMMISSIONS DES MEDECINS" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="4" width="300px">
            <a4j:commandButton title="Ajouter une commission" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.ajouterBareme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.visibiliteMedecin}" oncomplete="javascript:Richfaces.showModalPanel('panelAddFormAchats');" reRender="panelBareme"/>
            <a4j:commandButton title="Modifier la commission sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.modifierBareme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.visibiliteBton}" oncomplete="javascript:Richfaces.showModalPanel('panelModifFormAchats');" reRender="panelBareme"/>
            <a4j:commandButton title="Supprimer la commission sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.visibiliteMedecin}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.supprimerBareme}" reRender="panelBouton,tableBareme"/>
            <a4j:commandButton title="Imprimer les commissions du médecin sélectionné" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
        </h:panelGrid>

        <h:panelGrid id="panelListe" columns="2" columnClasses="clos50g,clos50g" width="100%">
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable border="0" id="tableMedecin" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.datamodelMedecins}"  var="med">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.selectionMedecin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton,tableBareme"/>
                        <rich:column  width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité"/></f:facet>
                            <h:outputText  value="#{med.usrCivilite}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="30%">
                            <f:facet name="header"><h:outputText  value="Médecin"/></f:facet>
                            <h:outputText  value="#{med.usrPatronyme}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="20%">
                            <f:facet name="header"><h:outputText  value="Fonction"/></f:facet>
                            <h:outputText  value="#{med.usrFonction}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="20%">
                            <f:facet name="header"><h:outputText  value="Spécialité"/></f:facet>
                            <h:outputText  value="#{med.usrSpecialite}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="20%">
                            <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                            <h:outputText  value="#{med.usrService}">
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
            <h:panelGrid width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable border="0" id="tableBareme" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" style="max-height:100%;border:solid 0px green;cursor:pointer;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.datamodelBaremes}" var="prx">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.selectionBareme}" reRender="panelBouton"/>
                        <rich:column  width="15%">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText  value="#{prx.barCodeProduit}" title="#{prx.barCodeProduit}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="50%">
                            <f:facet name="header"><h:outputText  value="Actes"/></f:facet>
                            <h:outputText  value="#{prx.barLibelleProduit}" title="#{prx.barLibelleProduit}">
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="20%">
                            <f:facet name="header"><h:outputText  value="Prix" style="text-align:right"/></f:facet>
                            <h:outputText  value="#{prx.barPrix}" style="text-align:right" rendered="#{prx.barPrix!=0}">
                                <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column  width="15%">
                            <f:facet name="header"><h:outputText  value="%" style="text-align:right"/></f:facet>
                            <h:outputText  value="#{prx.barRemise}" style="text-align:right" rendered="#{prx.barRemise!=0}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </h:panelGrid>
        <br/>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"   id="panelBareme" headerClass="headerPanel" width="650" height="350" style="border:1px solid black;overflow:auto;background-color:white;cursor:pointer;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.showModalPanelBaremes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.showModalPanelBaremes}" var="bar">
            <f:facet name="header"><h:outputText value="GESTION DES COMMISSIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.annuleBareme}" image="/images/close.gif" styleClass="hidelink" reRender="panelBareme"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  columns="2" width="100%" id="idpanRemisen" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barId!=0}">
                                <f:selectItem itemLabel="Sélection produit" itemValue="2"/>
                                <f:selectItem itemLabel="Sélection famille produit" itemValue="3"/>
                                <f:selectItem itemLabel="Sélection Consultation" itemValue="4"/>
                                <f:selectItem itemLabel="Sélection Pharmacie" itemValue="5"/>
                                <f:selectItem itemLabel="Sélection Laboratoire" itemValue="6"/>
                                <f:selectItem itemLabel="Sélection Hospitalisation" itemValue="7"/>
                                <f:selectItem itemLabel="Sélection tous actes Privés (paiement CASH)" itemValue="8"/>
                                <f:selectItem itemLabel="Sélection tous actes Pris en charge (tiers payeurs)" itemValue="9"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idpanRemisen"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==2}"><h:outputText value="Code produit:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==2}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barCodeProduit}">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idpanRemisen"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==2}"><h:outputText value="Libellé produit:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==2}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barLibelleProduit}" readonly="true" style="width:100%"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==3}"><h:outputText value="Famille produit:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType==3}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.var_famille_produit}">
                                <f:selectItem itemLabel="Sélectionnez la famille" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.mesFamilleVentestems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="% commission:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barRemise}" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType<=2}"><h:outputText value="Prix:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barType<=2}">
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barPrix}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Valable du:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barDateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.baremes.barDateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valRemise">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCommissionsMedecins.saveBareme}" reRender="panelBareme,tableBareme"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
