<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="LISTE DES UNITES DE STOCKAGE" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter une nouvelle unité" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.chargerPanAdd}" reRender="panelAddFormAchats,formulaireajt"/>
                <a4j:commandButton title="Modifier l'unité sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.chargerPanAModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.afficheButtModif}" reRender="panelAddFormAchats,formulaireajt"/>
                <a4j:commandButton title="Supprimer l'unité sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.afficheButtModif}"   onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.deleteUnite}" reRender="panelBouton,mytableau"/>
                <a4j:commandButton title="Imprimer les unités" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" id="mytableau" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.madatamodel}"  var="unite">
                    <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.selectionUnite}" reRender="panelBouton"/>
                    <rich:column  width="55%" sortable="true" sortBy="#{unite.uniLibelle}">
                        <f:facet name="header"><h:outputText  value="Symbole unité"  /></f:facet>
                        <h:outputText  value="#{unite.uniLibelle}">
                        </h:outputText>
                    </rich:column>
                    <rich:column  width="40%" sortable="true" sortBy="#{unite.var_lib_echelle}">
                        <f:facet name="header"><h:outputText  value="Echelle"  /></f:facet>
                        <h:outputText  value="#{unite.var_lib_echelle}">
                        </h:outputText>
                    </rich:column>
                    <rich:column width="5%">
                        <f:facet name="header"><h:outputText  value="Eat"  /></f:facet>
                        <h:commandButton image="#{unite.etat}" rendered="#{unite.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élèment ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.reactiverUnite}" title="Supprimer" style="text-align:right;">
                            <a4j:support eventsQueue="maQueue" reRender="panelBouton,mytableau" event="onclick"/>
                        </h:commandButton>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br/>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"  />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelAddFormAchats" width="530" height="250"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.showPanel}">
        <f:facet name="header">
            <h:panelGroup><h:outputText value="GESTION DES UNITES" /></h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelAddFormAchats"/>
                <rich:componentControl for="panelAddFormAchats" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>

        <a4j:form id="formulaireajt">
            <rich:hotKey key="return" handler="return false;"/>
            <h:panelGrid columns="2" columnClasses="clos25,clos75">
                <h:column><h:outputText value="Symbole unité:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.unite.uniLibelle}" style="width:100px;" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.unite.uniId!=0}">
                        <a4j:support eventsQueue="maQueue" event="onchange"  reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.doublonCode}"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Echelle:"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.unite.uniEchelle}" style="width:300px;">
                        <f:selectItem itemLabel="Non spécifié" itemValue="0"/>
                        <f:selectItem itemLabel="-------------- : Quantité * Longueur" itemValue="0"/>
                        <f:selectItem itemLabel="millimètre linéaire" itemValue="150"/>
                        <f:selectItem itemLabel="centimètre linéaire" itemValue="151"/>
                        <f:selectItem itemLabel="décimètre linéaire" itemValue="152"/>
                        <f:selectItem itemLabel="mètre linéaire" itemValue="153"/>
                        <f:selectItem itemLabel="décamètre linéaire" itemValue="154"/>
                        <f:selectItem itemLabel="hectomètre linéaire" itemValue="155"/>
                        <f:selectItem itemLabel="kilomètre linéaire" itemValue="156"/>
                        <f:selectItem itemLabel="-------------- : Quantité * Longueur * largeur" itemValue="0"/>
                        <f:selectItem itemLabel="millimètre carré" itemValue="250"/>
                        <f:selectItem itemLabel="centimètre carré" itemValue="251"/>
                        <f:selectItem itemLabel="décimètre carré" itemValue="252"/>
                        <f:selectItem itemLabel="mètre carré" itemValue="253"/>
                        <f:selectItem itemLabel="décamètre carré" itemValue="254"/>
                        <f:selectItem itemLabel="hectomètre carré" itemValue="255"/>
                        <f:selectItem itemLabel="kilomètre carré" itemValue="256"/>
                        <f:selectItem itemLabel="are" itemValue="257"/>
                        <f:selectItem itemLabel="hectare" itemValue="258"/>
                        <f:selectItem itemLabel="-------------- : Quantité * Longueur * largeur * hauteur" itemValue="0"/>
                        <f:selectItem itemLabel="millimètre cube" itemValue="350"/>
                        <f:selectItem itemLabel="centimètre cube" itemValue="351"/>
                        <f:selectItem itemLabel="décimètre cube" itemValue="352"/>
                        <f:selectItem itemLabel="mètre cube" itemValue="353"/>
                        <f:selectItem itemLabel="décamètre cube" itemValue="354"/>
                        <f:selectItem itemLabel="hectomètre cube" itemValue="355"/>
                        <f:selectItem itemLabel="kilomètre cube" itemValue="356"/>
                        <f:selectItem itemLabel="20 pieds" itemValue="357"/>
                        <f:selectItem itemLabel="40 pieds" itemValue="358"/>
                        <f:selectItem itemLabel="-------------- : Quantité * Longueur * Diamètre" itemValue="0"/>
                        <f:selectItem itemLabel="millimètre cube" itemValue="450"/>
                        <f:selectItem itemLabel="centimètre cube" itemValue="451"/>
                        <f:selectItem itemLabel="décimètre cube" itemValue="452"/>
                        <f:selectItem itemLabel="mètre cube" itemValue="453"/>
                        <f:selectItem itemLabel="décamètre cube" itemValue="454"/>
                        <f:selectItem itemLabel="hectomètre cube" itemValue="455"/>
                        <f:selectItem itemLabel="kilomètre cube" itemValue="'456"/>
                        <f:selectItem itemLabel="-------------- : Quantité" itemValue="0"/>
                        <f:selectItem itemLabel="millilitre" itemValue="550"/>
                        <f:selectItem itemLabel="centilitre" itemValue="551"/>
                        <f:selectItem itemLabel="décilitre" itemValue="552"/>
                        <f:selectItem itemLabel="litre" itemValue="553"/>
                        <f:selectItem itemLabel="décalitre" itemValue="554"/>
                        <f:selectItem itemLabel="hectolitre" itemValue="555"/>
                        <f:selectItem itemLabel="kilolitre" itemValue="556"/>
                        <f:selectItem itemLabel="gallon" itemValue="557"/>
                        <f:selectItem itemLabel="baril" itemValue="558"/>
                        <f:selectItem itemLabel="fut" itemValue="559"/>
                        <f:selectItem itemLabel="-------------- : Quantité" itemValue="0"/>
                        <f:selectItem itemLabel="milligramme" itemValue="650"/>
                        <f:selectItem itemLabel="centigramme" itemValue="651"/>
                        <f:selectItem itemLabel="décigramme" itemValue="652"/>
                        <f:selectItem itemLabel="gramme" itemValue="653"/>
                        <f:selectItem itemLabel="décagramme" itemValue="654"/>
                        <f:selectItem itemLabel="hectogramme" itemValue="655"/>
                        <f:selectItem itemLabel="kilogramme" itemValue="656"/>
                        <f:selectItem itemLabel="quintal" itemValue="657"/>
                        <f:selectItem itemLabel="tonne" itemValue="658"/>
                        <f:selectItem itemLabel="-------------- : Quantité" itemValue="0"/>
                        <f:selectItem itemLabel="unité" itemValue="750"/>
                        <f:selectItem itemLabel="sac" itemValue="751"/>
                        <f:selectItem itemLabel="carat" itemValue="752"/>
                        <f:selectItem itemLabel="-------------- : Quantité * (facteur)" itemValue="0"/>
                        <f:selectItem itemLabel="pièce" itemValue="810"/>
                        <f:selectItem itemLabel="bar" itemValue="860"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <center>
                <br><br>
                <h:panelGroup id="ppgrp">
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.saveUnite}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.doublon}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelAddFormAchats,mytableau"/>
                    </h:commandButton >
                    <center>
                        <h:outputText id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique." rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formUnite.doublon}"/>
                    </center>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
