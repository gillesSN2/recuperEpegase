<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersConventions">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>
        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="Conventions de : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <rich:tabPanel switchType="client" immediate="true" id="tabPanelConvention" style="border:0px;">

                <rich:tab label="Etat convention">
                    <h:panelGrid width="100%" styleClass="fichefournisseur" id="idEtat" columns="2" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Etat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:50%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieconventiongele}" >
                                <f:selectItem itemLabel="Convention Active" itemValue="false"/>
                                <f:selectItem itemLabel="Convention Gelée" itemValue="true"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idEtat"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieconventiongele}"><h:outputText value="Motif du gel:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieconventiongele}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemotifgele}" style="width:50%" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Lettre de garantie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:50%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielettregarantie}">
                                <f:selectItem itemLabel="Lettre de Garantie Acceptée" itemValue="false"/>
                                <f:selectItem itemLabel="Lettre de Garantie Refusée" itemValue="true"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Coefficient de modération des tarifs:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecoefpvmedical}">
                                <f:selectItem itemValue="0" itemLabel="Sans coefficient" />
                                <f:selectItem itemValue="0.25" itemLabel="-25%" />
                                <f:selectItem itemValue="0.5" itemLabel="-50%" />
                                <f:selectItem itemValue="1.25" itemLabel="+25%" />
                                <f:selectItem itemValue="1.5" itemLabel="+50%" />
                                <f:selectItem itemValue="2" itemLabel="+100%" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Détail convention">
                    <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idConvention">
                        <h:panelGrid  id="btnConvention" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter convention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterConvention}" reRender="panelConvention,btnConvention"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier convention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierConvention}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtConvention}" reRender="panelConvention,btnConvention"/>
                            <a4j:commandButton image="/images/detail.png" title="Consulter convention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterConvention}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtConvention}" reRender="panelConvention,btnConvention"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer convention" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerConvention}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtConvention}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelConvention,btnConvention,tableConvention"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable style="border:solid 0px green;" id="tableConvention" border="0" height="350px" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelConvention}" var="cvn" >
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionConvention}" reRender="btnConvention"/>
                                <rich:column label="Lettre" sortable="true" sortBy="#{cvn.cvnLettre}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Lettre"/></f:facet>
                                    <h:outputText value="#{cvn.cvnLettre}"/>
                                </rich:column>
                                <rich:column label="Produit" sortable="true" sortBy="#{cvn.cvnProduit}" width="10%">
                                    <f:facet name="header" ><h:outputText value="Produit"/></f:facet>
                                    <h:outputText value="#{cvn.cvnProduit}"/>
                                </rich:column>
                                <rich:column label="Libellé" sortable="true" sortBy="#{cvn.cvnLibelle}" width="40%">
                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                    <h:outputText value="#{cvn.cvnLibelle}"/>
                                </rich:column>
                                <rich:column label="Valeur origine" sortable="true" sortBy="#{cvn.cvnValeurOrigine}" width="20%" style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="Valeur origine"/></f:facet>
                                    <h:outputText value="#{cvn.cvnValeurOrigine}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Valeur de la convention" sortable="true" sortBy="#{cvn.cvnValeur}" width="20%" style="text-align:right">
                                    <f:facet name="header" ><h:outputText value="Valeur"/></f:facet>
                                    <h:outputText value="#{cvn.cvnValeur}">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourConventions}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   id="panelConvention" headerClass="headerPanel" width="450" height="250" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelConvention}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelConvention}" var="cvn">
            <f:facet name="header"><h:outputText value="GESTION DES CONVENTIONS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleContact}" image="/images/close.gif" styleClass="hidelink" reRender="panelConvention"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80">
                        <h:column><h:outputText value="Lettre:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="lettreItem" style="width:150px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixLettre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conventionMedical.cvnId!=0}">
                                <f:selectItem itemLabel="Sélectionnez la lettre" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesLettresItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Code produit:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conventionMedical.cvnProduit}" style="width:150px;">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.rechercheProduits}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeProduitVente,formModalListeProduitVente,idpanRemisen"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé produit:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conventionMedical.cvnLibelle}" style="width:100%" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Valeur origine:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conventionMedical.cvnValeurOrigine}" style="width:150px;text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Valeur conventionnée:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conventionMedical.cvnValeur}" style="width:150px;text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valConvention">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanConv" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveConvention}" reRender="panelConvention,idConvention"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
