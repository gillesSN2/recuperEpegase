<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">
    <a4j:form>

        <center><h2><h:outputText value="LISTE DES PROTOCOLES" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="4" width="200px" style="height:34px">
            <a4j:commandButton image="/images/ajouter.png" title="Ajouter protocole" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.ajouter}" reRender="panelProtocole"/>
            <a4j:commandButton image="/images/modifier.png" title="Modifier protocole" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.modifier}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.protocoleMedical.prtId!=0}" reRender="panelProtocole"/>
            <a4j:commandButton image="/images/supprimer.png"  title="Supprimer protocole"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.protocoleMedical.prtId!=0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.supprimerLogique}" reRender="panelBouton,mytableau"/>
            <a4j:commandButton image="/images/print.png" title="Imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
        </h:panelGrid>

        <br>

        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.madatamodel}" var="prt">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.selectionLigne}" reRender="panelBouton"/>
                <rich:column  width="15%">
                    <f:facet name="header"><h:outputText  value="Code"  /></f:facet>
                    <h:outputText  value="#{prt.prtCode}">
                    </h:outputText>
                </rich:column>
                <rich:column  width="80%">
                    <f:facet name="header"><h:outputText  value="Libellé du protocole"  /></f:facet>
                    <h:outputText  value="#{prt.prtLibelle}">
                    </h:outputText>
                </rich:column>
                <rich:column width="5%">
                    <f:facet name="header"><h:outputText value="Eat" style="text-align:center"/></f:facet>
                    <h:commandButton image="#{prt.etat}" rendered="#{prt.inactif}" onclick="if (!confirm('Voulez-vous supprimer définitivement cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.supprimerPhysique}" title="Supprimer" style="text-align:right;"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>
        <br/>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel id="panelProtocole" width="530" height="250" headerClass="headerPanel" style="border:solid 0px black;background-color:white" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showMoalPanel}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showMoalPanel}" var="prt">
            <f:facet name="header"><h:outputText value="GESTION D'UN PROTOCOLE" /></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.annuleSaisie}" image="/images/close.gif" styleClass="hidelink" reRender="panelProtocole"/>
                </a4j:form>
            </f:facet>

            <a4j:form >
                <h:panelGroup id="panelPage" >
                    <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                        <rich:tab id="tabDoc" label="Définition protocole">
                            <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                                <h:column><h:outputText value="Code:" style="text-decoration:underline;" /></h:column>
                                <h:column>
                                    <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.protocoleMedical.prtCode}" maxlength="4" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.protocoleMedical.prtId!=0}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.testUnicite}" reRender="panelValide"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Libellé:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.protocoleMedical.prtLibelle}" maxlength="100" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                <h:column><h:outputText value="Inactif:"/></h:column>
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.var_inactif}"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabOrdo" label="Ordonnance">
                            <h:panelGrid id="panelBoutonProduit" columns="4" width="200px" style="height:34px">
                                <a4j:commandButton image="/images/ajouter.png" title="Ajouter produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.ajouterMedicament}" reRender="panelProduit"/>
                                <a4j:commandButton image="/images/modifier.png" title="Modifier produit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.modifierMedicament}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.objetTarif.idProduit!=0}" reRender="panelProduit"/>
                                <a4j:commandButton image="/images/supprimer.png"  title="Supprimer produit"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.objetTarif.idProduit!=0}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.supprimerMedicament}" reRender="panelBoutonProduit,tableProduit"/>
                            </h:panelGrid>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable border="0" id="tableProduit" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.dataModelProMed}" var="med">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.selectionLigneMedicament}" reRender="panelBoutonProduit"/>
                                    <rich:column  width="15%">
                                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                        <h:outputText  value="#{med.codeProduit}"/>
                                    </rich:column>
                                    <rich:column  width="75%">
                                        <f:facet name="header"><h:outputText  value="Libellé du produit"/></f:facet>
                                        <h:outputText  value="#{med.nomProduit}"/>
                                    </rich:column>
                                    <rich:column width="10%">
                                        <f:facet name="header"><h:outputText value="Qte" style="text-align:right"/></f:facet>
                                        <h:outputText  value="#{med.qteProduit}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>

                        </rich:tab>

                    </rich:tabPanel>
                </h:panelGroup>
                <center>
                    <br><br>
                    <h:panelGroup id="panelValide">
                        <a4j:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.save}" reRender="panelProtocole,mytableau,panelBouton" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.var_unicite}"/>
                        <br>
                        <h:outputText style="color:red;" value="Le code est obligatoire et doit être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.var_unicite}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelProduit" width="530" height="200" headerClass="headerPanel" style="border:solid 0px black;background-color:white" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showModaPanelProduit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showModaPanelProduit}" var="prd">
            <f:facet name="header"><h:outputText value="GESTION D'UN PRODUIT" /></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.annulerMedicament}" image="/images/close.gif" styleClass="hidelink" reRender="panelProduit"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGroup>
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idProduit">
                        <h:column><h:outputText value="Code:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.objetTarif.codeProduit}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.rechercheProduit}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeMedicamment,formModalListeMedicamment"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.objetTarif.nomProduit}" style="width:100%" disabled="true" readonly="true"/></h:column>
                        <h:column><h:outputText value="Quantité:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.objetTarif.qteProduit}"/></h:column>
                    </h:panelGrid>
                </h:panelGroup>
                <center>
                    <br><br>
                    <h:panelGroup id="panelValidePrd">
                        <a4j:commandButton  image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.saveMedicament}" reRender="panelProduit,tableProduit"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelListeMedicamment" headerClass="headerPanel" style="border:solid 0px black;background-color:white;overflow:auto" width="1000" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showModaPanelMedicament}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.showModaPanelMedicament}" var="med">
            <f:facet name="header"><h:outputText value="Sélection du médicamment (Le Mayité)"/></f:facet>
            <a4j:form id="formModalListeMedicamment">
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20"align="left" for="tableMed"/>
                    <rich:extendedDataTable rows="200" id="tableMed" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.dataModelMedicament}" var="prdmed">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.selectionLigneProduit}" reRender="idValMed"/>
                        <rich:column label="CIP" sortable="true" sortBy="#{prdmed.promdcCodeCip}" width="10%">
                            <f:facet name="header"><h:outputText  value="CIP" /></f:facet>
                            <h:outputText value="#{prdmed.promdcCodeCip}"/>
                        </rich:column>
                        <rich:column label="DCI" sortable="true" sortBy="#{prdmed.promdcCodeDci}" width="20%">
                            <f:facet name="header"><h:outputText  value="DCI" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcCodeDci}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Spécialité" sortable="true" sortBy="#{prdmed.promdcSpecialite}" width="30%">
                            <f:facet name="header"><h:outputText  value="Spécialité" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcSpecialite}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Forme" sortable="true" sortBy="#{prdmed.promdcForme}" width="20%">
                            <f:facet name="header"><h:outputText  value="Forme" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcForme}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                        <rich:column label="Classe" sortable="true" sortBy="#{prdmed.promdcClasse}" width="20%">
                            <f:facet name="header"><h:outputText  value="Classe" /></f:facet>
                            <h:inputTextarea value="#{prdmed.promdcClasse}" readonly="true" rows="2" style="width:100%"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <h:panelGroup id="idValMed">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.annulerProduit}" reRender="panelListeMedicamment,idProduit"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.validerProduit}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formProtocoleMedical.produitsMedicamment.promdcId!=0}" reRender="panelListeMedicamment,idProduit"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
