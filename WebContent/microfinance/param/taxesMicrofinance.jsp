<%--
    Document   : taxesmedical
    Created on : 14-déc.-2009, 9:28:00
    Author     : Samb
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="taxmicroFinance">
    <a4j:form>

        <center><h2>LISTE DES TAXES MICROS FINANCES</h2></center>
        <h:panelGroup id="pangrouptaxemed">
            <h:commandButton id="btpanelAjt" title="Ajouter" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.InitTaxe}" />
            &nbsp; &nbsp;&nbsp;
            <h:commandButton id="btpanelModif" title="Modifier" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.lanceModificationTaxe}"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.modifTaxesmicrofinance!=null}">
            </h:commandButton>
            &nbsp; &nbsp;&nbsp;
            <h:commandButton id="btpanelSup" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formbakingbeanmedical.taxesMedicalCtrl.afficheButtSupp}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formbakingbeanmedical.taxesMedicalCtrl.deleteTaxesMedical}">
            </h:commandButton>&nbsp;&nbsp;&nbsp;
            <a4j:commandButton id="btpanelImp" title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpTaxemed');">
            </a4j:commandButton>
        </h:panelGroup>&nbsp; &nbsp;&nbsp;

        <center>
            <rich:extendedDataTable id="tabTaxeMF"border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" style="width:60%;border:solid 0px green;margin-top:10px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.tableauxTaxeMicroFinance}" var="taxMicroFinance" >
                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.ligneTableauxTaxeMicroFinanceActive}"
                              reRender="pangrouptaxemed,btpanelModif"/>
                <rich:column    width="15%">
                    <f:facet name="header">
                        <h:outputText  value="Code" />
                    </f:facet>
                    <h:outputText value="#{taxMicroFinance.tacmcfCode}" id="cod"/>

                </rich:column>
                <rich:column  width="75%" >
                    <f:facet name="header">
                        <h:outputText  value="Libellé"  />
                    </f:facet>
                    <h:outputText  value="#{taxMicroFinance.taxmcfLibelleFr}" id="lib"/>
                </rich:column>
                <rich:column >
                    <f:facet name="header">
                        <h:outputText  value="Etat"  />
                    </f:facet>
                    
                </rich:column>
            </rich:extendedDataTable>
        </center>
        <br>
        <center>

            <h:commandButton value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" />
        </center>
    </a4j:form>
        <rich:modalPanel domElementAttachment="parent"  id="panelAjt" headerClass="headerPanel" width="530" height="500" style="border:0px;overflow:auto;background-color:white;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance!=null}">
        <f:facet name="header">
            <center><h:outputText value="AJOUT DE TAXE MICROS FINANCES"></h:outputText></center>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.annulerTaxe}" image="/images/close.gif"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  columns="2" >
                <h:outputText value="Code"/>
                <h:panelGroup id="panExistCodeTaxeMed" >
                    <h:inputText onkeypress="return scanToucheLettre(event)" style="width:50px;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.tacmcfCode}">
                        
                    </h:inputText>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formbakingbeanmedical.taxesMedicalCtrl.existCod}" style="margin-left:20px;">
                        <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                        <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;size:100;" />
                    </h:panelGroup>
                </h:panelGroup>
                <h:outputText value="Libelle"/>
                <h:inputText id="inptlibAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfLibelleFr}" style="width:400px;"/>
                <h:outputText value="Taux"/>
                <h:inputText id="inpttauAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfTaux}" style="width:50px;"/>
                <h:outputText value="Compte"/>
                <h:inputText id="inptcmptAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfCompte}" style="width:100px;"/>

                <h:outputText value="Type"/>
                <h:selectOneRadio id="sltoradtypAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfType}" layout="pageDirection">
                    <f:selectItem itemLabel="TVA sur biens" itemValue="0"/>
                    <f:selectItem itemLabel="TVA sur prestation" itemValue="1"/>
                    <f:selectItem itemLabel="BRS" itemValue="2"/>
                </h:selectOneRadio>

                <h:outputText value="Timbre"/>
                <h:selectOneRadio id="sltoradtimAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfTimbre}" layout="pageDirection">
                    <f:selectItem itemLabel="Sans timbre" itemValue="0"/>
                    <f:selectItem itemLabel="Timbre payé par le client" itemValue="1"/>
                    <f:selectItem itemLabel="Timbre non payé" itemValue="2"/>
                </h:selectOneRadio>

                <h:outputText value="Complémentaires"/>
                <h:selectOneRadio id="sltoradComplAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.newTaxesmicrofinance.taxmcfTc}" layout="pageDirection">
                    <f:selectItem itemLabel="Sans taxes complémentaires" itemValue="0"/>
                    <f:selectItem itemLabel="Centimes additionnels" itemValue="1"/>
                    <f:selectItem itemLabel="Taxe d'égalisation" itemValue="2"/>
                </h:selectOneRadio>

            </h:panelGrid>

            <center>
                <h:panelGroup id="buttGrpAddTaxeMed">
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" reRender="panelAjt,tabTaxeMF"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.ajouterTaxeMicroFinance}"/>
                </h:panelGroup>
            </center>
        </a4j:form>

        <br/>

    </rich:modalPanel>


    <!--**********************   Modal panel pour la modification **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelMod" headerClass="headerPanel" width="530" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance!=null}" height="500" style="border:0px;overflow:auto;background-color:white;">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="MODIFICATION DE TAXE MICROS FINANCES"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
       
           <a4j:form>
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.annulerTaxe}" image="/images/close.gif"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  columns="2">
                <h:outputText value="Code"/>
                <h:inputText id="inptcodMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.tacmcfCode}" readonly="true"/>
                <h:outputText value="Libelle"/>
                <h:inputText id="inptlibMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfLibelleFr}" />
                <h:outputText value="Taux"/>
                <h:inputText id="inpttauMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfTaux}" />
                <h:outputText value="Compte"/>
                <h:inputText id="inptcmptMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfCompte}"/>
                <h:outputText value="Type"/>
                <h:selectOneRadio id="sltoradtypMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfType}" layout="pageDirection">
                    <f:selectItem itemLabel="TVA sur biens" itemValue="0"/>
                    <f:selectItem itemLabel="TVA sur prestation" itemValue="1"/>
                    <f:selectItem itemLabel="BRS" itemValue="2"/>
                </h:selectOneRadio>
                <h:outputText value="Timbre"/>
                <h:selectOneRadio id="sltoradtimMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfTimbre}" layout="pageDirection">
                    <f:selectItem itemLabel="Sans timbre" itemValue="0"/>
                    <f:selectItem itemLabel="Timbre payé par le client" itemValue="1"/>
                    <f:selectItem itemLabel="Timbre non payé" itemValue="2"/>
                </h:selectOneRadio>
                <h:outputText value="Complémentaires"/>
                <h:selectOneRadio id="sltoradComplMod" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.mdifTaxesmicrofinance.taxmcfTc}" layout="pageDirection">
                    <f:selectItem itemLabel="Sans taxes complémentaires" itemValue="0"/>
                    <f:selectItem itemLabel="Centimes additionnels" itemValue="1"/>
                    <f:selectItem itemLabel="Taxe d'égalisation" itemValue="2"/>
                </h:selectOneRadio>
            </h:panelGrid>
            <h:panelGroup>
                <h:outputText value="Inactif"/>
                
            </h:panelGroup>
            <center>
                <h:panelGroup>
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" reRender="tabTaxeMF,panelMod"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.validerModifierTaxeMicroFinance}"/>
                </h:panelGroup>
            </center>
        </a4j:form>

        <br/>
    </rich:modalPanel>
    <!--**********************   Modal panel pour la impression **************************/-->
    <rich:modalPanel domElementAttachment="parent"  id="panelImpTaxemed" headerClass="headerPanel" style="border:solid 1px black;background-color:white"   width="300" height="200">
        <f:facet name="header">
            <center><h:outputText value="Impression"/></center>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1Impim"/>
                <rich:componentControl for="panelImpTaxemed" attachTo="hidelink1Impim" operation="hide" event="onclick"/>
            </a4j:form>>
        </f:facet>
        <rich:panel>
            <a4j:form id="formModalImprimMed" target="_blank">
                <center>
                    <h:outputText value="Choisissez un format"  style="color:green;"/>
                </center>
                <h:panelGrid  width="60px">
                    <h:selectOneListbox value="test" id="format">
                        <f:selectItem itemLabel="PDF" itemValue="PDF"/>
                        <f:selectItem itemLabel="EXEL" itemValue="XLS"/>
                        <f:selectItem itemLabel="WORD" itemValue="DOC"/>
                        <f:selectItem itemLabel="HTML" itemValue="HTML"/>
                    </h:selectOneListbox>
                </h:panelGrid>
                <center>
                    <h:commandButton image="/images/valider_big.png" action="test"title="Imprimer" style="margin-top:10px;cursor:pointer;"  id="bbbbbprint">
                        <rich:componentControl for="panelImpFamiProdmed" attachTo="bbbbbprint" operation="hide" event="onclick"/>
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelImpFamiProdmed" action="test"/>
                    </h:commandButton>
                </center>
            </a4j:form>
        </rich:panel>
    </rich:modalPanel>

</f:subview>
