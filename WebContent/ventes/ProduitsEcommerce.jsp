<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="pubproduits">

    <a4j:form id="produitformpub" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="PUBLICATION DES PRODUITS (E-Commerce)" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="9" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Code"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_CodFind}" style="width:60px;"/></h:column>
                <h:column><h:outputText  value="Libellé"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_LibFind}" style="width:100px;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="itemFamille" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_FamilleFind}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Familles" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamillesVentesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemNature" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_NatureFinf}"  style="width:130px;">
                        <f:selectItem itemLabel="Toutes Natures" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesNaturesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemActivite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ActiviteFind}" style="width:130px;">
                        <f:selectItem itemLabel="Toutes Activités" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="itemService" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ServiceFind}" style="width:130px;">
                        <f:selectItem itemLabel="Tous Services" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesServicesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.rechercherProduit}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,grpProd" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  width="100%">

            <h:panelGroup id="grpProd">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable style="margin-top:5px;border:solid 0px green;" id="listeProd"  height="350px" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " sortMode="multi" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelProduit}" var="ecomm">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionProduit}"  />
                        <rich:column width="5%" sortable="true" sortBy="#{ecomm.proVteCode}">
                            <f:facet name="header" ><h:outputText value="Famille" /></f:facet>
                            <h:outputText value="#{ecomm.proVteCode}" />
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{ecomm.proCode}" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{ecomm.proCode}" />
                        </rich:column>
                        <rich:column width="30%" sortable="true" sortBy="#{ecomm.proLibClient}" >
                            <f:facet name="header" ><h:outputText value="Libellé Commercial"  /></f:facet>
                            <h:outputText value="#{ecomm.proLibClient}"/>
                        </rich:column>
                        <rich:column width="15%" sortable="true" sortBy="#{ecomm.proLibTech}" >
                            <f:facet name="header" ><h:outputText value="Libellé technique"  /></f:facet>
                            <h:outputText value="#{ecomm.proLibTech}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="true" sortBy="#{ecomm.proCondition1}" >
                            <f:facet name="header" ><h:outputText value="Condit."  /></f:facet>
                            <h:outputText value="#{ecomm.proCondition1}"/>
                        </rich:column>
                        <rich:column width="20%" sortable="true" sortBy="#{ecomm.publicBool}" style="text-align:center;">
                            <f:facet name="header" ><h:outputText value="Publier"  /></f:facet>
                            <h:selectBooleanCheckbox value="#{ecomm.publicBool}" style="text-align:center;"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <br>
                <center>
                    <h:commandButton value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleSaisie}" />&nbsp;&nbsp;
                    <h:commandButton value="Mise à jour E-commerce"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.publierProduit}" />
                </center>
            </h:panelGroup>

        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="450" height="450">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1Impim"/>
                    <rich:componentControl for="panelImp" attachTo="hidelink1Impim" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.docModele}" >
                            <f:selectItem itemLabel="Produit séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de produits" itemValue="1"/>
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.nomRapport}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.lesmodelesImpressions}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="docSelect"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="6">
                            <h:commandButton id="b1" image="/images/imp_reader.png" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerPDF}" />
                            <h:commandButton id="b2" image="/images/imp_excel.png" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerXLS}"/>
                            <h:commandButton id="b3" image="/images/imp_word.png" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerDOC}"/>
                            <h:commandButton id="b4" image="/images/imp_html.png" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerHTML}"/>
                            <h:commandButton id="b5" image="/images/imp_xml.png" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimerXML}"/>
                            <a4j:commandButton id="b6" reRender="formModalImp" image="/images/imp_mail.png" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.envoieMAIL}" />
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="optionMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:100%"  /></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.imprimer}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.affMail}" id="print">
                                <rich:componentControl for="panelImp" attachTo="print" operation="hide" event="onclick"/>
                            </h:commandButton>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
