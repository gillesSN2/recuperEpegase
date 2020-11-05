<%-- 
    Document   : naturesFamillesProduitsMedical
    Created on : 23-déc.-2009, 7:08:11
    Author     : Samb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="natfmprdMF">
    <a4j:form>
        <center><h2>LISTE DES  FAMILLES DES PRODUITS DE MICROS FINANCES</h2></center>
       <h:panelGroup id="pangroupfmPdtsMF">
           <h:commandButton id="btpanelAjtfmPdtsMF" title="Ajouter" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.InitFmPdts}" />
            &nbsp; &nbsp;&nbsp;
            <h:commandButton id="btpanelModiffmPdtsMF" title="Modifier" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formTaxeMicroFinance.taxeMicroFinanceCtrl.lanceModificationTaxe}"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.modifFamillesProduits!=null}">
            </h:commandButton>
            &nbsp; &nbsp;&nbsp;
            <h:commandButton id="btpanelSupfmPdtsMF" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formbakingbeanmedical.taxesMedicalCtrl.afficheButtSupp}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formbakingbeanmedical.taxesMedicalCtrl.deleteTaxesMedical}">
            </h:commandButton>&nbsp;&nbsp;&nbsp;
            <a4j:commandButton id="btpanelImpfmPdtsMF" title="Imprimer" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpTaxemed');">
            </a4j:commandButton>
        </h:panelGroup>&nbsp; &nbsp;&nbsp;
        <center>
            <rich:extendedDataTable  id="panelAjtFMP"footerClass="bard"headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" style="width:60%;border:solid 0px green;margin-top:10px;"
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.tableauxFamillePdtsMicroFinance}"  var="famillePdts">

             <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.ligneTableauxFamillePdtsMicroFinanceActive}"
                              reRender="pangroupfmPdtsMF,btpanelModiffmPdtsMF"/>

            <rich:column style="heigth:20px;text-align:center" sortable="true"  width="20%"sortBy="#{famillePdts.fammcfCode}">
                <f:facet name="header">
                    <h:outputText  value="Code" />
                </f:facet>
                <h:outputText style="size:5px;" value="#{famillePdts.fammcfCode}" id="cod" />
            </rich:column>
            <rich:column style="heigth:20px;text-align:center" width="70%" sortable="true" sortBy="#{famillePdts.fammcfLibelleFr}">
                <f:facet name="header">
                    <h:outputText  value="Libellé"  />
                </f:facet>
                <h:outputText  value="#{famillePdts.fammcfLibelleFr}" id="lib" />
            </rich:column>
            <rich:column style="heigth:20px;text-align:center" width="10%" sortable="true" sortBy="#{famillePdts.fammcfInactif}">
                <f:facet name="header">
                    <h:outputText  value="Etat"  />
                </f:facet>
                <h:outputText  value="#{famillePdts.fammcfInactif}" id="etat"/>
            </rich:column>
        </rich:extendedDataTable>
        </center>
        <br>
        <br>
        <center>

            <h:commandButton value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" />
        </center>
    </a4j:form>


        <rich:modalPanel domElementAttachment="parent"  id="panelAddFamiProdMF" headerClass="headerPanel" style="border:solid 1px white;background-color:white"  width="750" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits!=null}">
        <f:facet name="header">
            <center><h:outputText value="AJOUT DE FAMILLE DE PRODUITS MICROS FINANCES"/></center>
        </f:facet>
        <f:facet name="controls">
            <a4j:form>
                <!--h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink"/-->
                <h:commandButton image="/images/close.gif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.annulerFpdtsMF}"/>
                <!--rich:componentControl for="panelAddFamiProdmed" attachTo="hidelink" operation="hide" event="onclick"/-->
            </a4j:form>
        </f:facet>
        <a4j:form>
            <rich:tabPanel switchType="client" immediate="true"  id="ddd" style="border:0px;">
                <rich:tab label="Général">
                    <h:panelGrid columns="2">
                        <h:outputText value="Nature"/>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfLibNature}" >
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.lectureFluxNaturesFamillesProduitsMF.myListSelectItem}"/>
                        </h:selectOneMenu>
                        <h:outputText value="Code"/>
                        <h:panelGroup id="panExistCodeFamMed" >
                            <h:inputText onkeypress="return scanToucheLettre(event)" style="width:50px;text-transform:uppercase" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfCode}">
                                
                            </h:inputText>
                            <h:panelGroup style="margin-left:20px;">
                                <h:graphicImage url="/images/Warning.png"  style="width:25px;height;"/>
                                <h:outputText value="Ce code est vide ou éxiste déja" style="color:red;size:100;" />
                            </h:panelGroup>
                        </h:panelGroup>
                        <h:outputText value="Libelle"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfLibelleFr}"/>
                        
                    </h:panelGrid>
                </rich:tab>
                <rich:tab label="Comptes">
                    <h:panelGrid columns="2">
                        <h:outputText value="Code TVA"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfTaxe}"/>
                        
                        <h:outputText value="Code Produit local"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfCompteLocal}"/>

                        <h:outputText value="Code Produit Zone"/>
                        <h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfCompteZone}"/>

                        <h:outputText value="Code Produit Hors Zone"/>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.newFamillesProduits.fammcfCompteExterieur}"/>
                       
                    </h:panelGrid>

                </rich:tab>
            </rich:tabPanel>
            <center>
                <h:panelGroup id="buttGrpAddFamMed">
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" reRender="panelAddFamiProdMF,panelAjtFMP"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.formFamilleProduitsMF.familleProduitsMFCtrl.ajouterFpdtsMicroFinance}"/>
                </h:panelGroup>
            </center>
        </a4j:form>

    </rich:modalPanel>


</f:subview>
