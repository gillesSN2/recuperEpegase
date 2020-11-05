<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="famprc">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES FAMILLES PARCS" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid columns="3" width="100%">

                <h:panelGrid>
                    <h:panelGrid style="height:34px" width="300px">
                        <a4j:commandButton title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');" reRender="panelImp"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableNature" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.datamodelNature}" var="nature">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.selectionNature}" reRender="tableFamille,tableSousFamille,panBoutonFamille,panBoutonSousFamille" />
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{nature.code}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                <h:outputText value="#{nature.nom_FR}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGrid>
                    <h:panelGrid columns="3"  id="panBoutonFamille" style="height:34px" width="300px">
                        <a4j:commandButton title="Nouvelle famille" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.objetCompte.code!=''}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.ajouterFamille}" oncomplete="javascript:Richfaces.showModalPanel('panelFamille');" reRender="panelFamille,saisieFamille"/>
                        <a4j:commandButton title="Modifier la famille sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.afficheBoutonFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.modifierFamille}" oncomplete="javascript:Richfaces.showModalPanel('panelFamille');" reRender="panelFamille,saisieFamille"/>
                        <a4j:commandButton title="Supprimer la famille sélectionnée" image="/images/supprimer.png" reRender="tableFamille"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.afficheBoutonFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.supprimerFamille}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableFamille" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.datamodelFamille}"  var="famille">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.selectionFamille}" reRender="panBoutonFamille,tableSousFamille,panBoutonSousFamille" />
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{famille.famprc1Code}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                                <h:outputText value="#{famille.famprc1LibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

                <h:panelGrid>
                    <h:panelGrid columns="3"  id="panBoutonSousFamille" style="height:34px" width="300px">
                        <a4j:commandButton title="Nouvelle sous famille" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc1.famprc1Id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.ajouterSousFamille}" oncomplete="javascript:Richfaces.showModalPanel('panelSousFamille');" reRender="panelSousFamille,saisieSousFamille"/>
                        <a4j:commandButton title="Modifier la sous famille sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.afficheBoutonSousFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.modifierSousFamille}" oncomplete="javascript:Richfaces.showModalPanel('panelSousFamille');" reRender="panelSousFamille,saisieSousFamille"/>
                        <a4j:commandButton title="Supprimer la sous famille sélectionnée" image="/images/supprimer.png" reRender="tableSousFamille"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.afficheBoutonSousFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.supprimerSousFamille}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tableSousFamille" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.datamodelSousFamille}"  var="sousFam">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.selectionSousFamille}" reRender="panBoutonSousFamille" />
                            <rich:column sortable="false" width="30%">
                                <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                <h:outputText value="#{sousFam.famprc2Code}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header"><h:outputText  value="Sous famille" /></f:facet>
                                <h:outputText value="#{sousFam.famprc2LibelleFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

            </h:panelGrid>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel"id="panelFamille" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.showModalPanelFamille}">
        <f:facet name="header"><h:outputText value="GESTION DES FAMILLES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif"  id="hideFamille" style="cursor:pointer;margin-left:350px"/>
                <rich:componentControl for="panelFamille" attachTo="hideFamille" operation="hide" event="onclick">
                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.annulerFamille}"  />
                </rich:componentControl>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" id="saisieFamille" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc1.famprc1Code}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc1.famprc1Id!=0}">
                        <a4j:support eventsQueue="maQueue"  event="onblur" reRender="erreurFamille,valFamille" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.verifCodeFamille}"/>
                    </h:inputText>
                    <h:panelGroup id="erreurFamille">
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.existCodeFamille}">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:340px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc1.famprc1LibelleFr}" maxlength="50"/></h:column>

                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc1.etat}"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup id="valFamille">
                    <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.existCodeFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.saveFamille}" style="margin-top:5px;" />
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSousFamille" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.showModalPanelSousFamille}">
        <f:facet name="header"><h:outputText value="GESTION DES SOUS FAMILLES"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif"  id="hideSousFamille" style="cursor:pointer;margin-left:350px"/>
                <rich:componentControl for="panelSousFamille" attachTo="hideSousFamille" operation="hide" event="onclick">
                    <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.annulerSousFamille}"  />
                </rich:componentControl>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid columns="2" id="saisieSousFamille" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Code:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc2.famprc2Code}" maxlength="20" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc2.famprc2Id!=0}">
                        <a4j:support eventsQueue="maQueue"  event="onblur" reRender="erreurSousFamille,valSousFamille" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.verifCodeSousFamille}"/>
                    </h:inputText>
                    <h:panelGroup id="erreurSousFamille">
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.existCodeSousFamille}">
                            <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                            <h:outputText value="Ce code est vide ou existe déja" style="color:red;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:340px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc2.famprc2LibelleFr}" maxlength="50"/></h:column>
                <h:column><h:outputText value="Inactif:"/></h:column>
                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.famillesParc2.etat}"/></h:column>
            </h:panelGrid>
            <center>
                <h:panelGroup id="valSousFamille">
                    <h:commandButton image="/images/valider_big.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.existCodeSousFamille}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFamilleParcs.saveSousFamille}" style="margin-top:5px;" />
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>

        
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>



</f:subview>
