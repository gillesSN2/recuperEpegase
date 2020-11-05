<%-- 
    Document   : familleProduitMedical
    Created on : 22-déc.-2009, 8:14:39
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
<f:subview id="fmPrdtMF">
    <a4j:form>
        <center><h2>LISTE DE NATURE FAMILLES DE PRODUITS MICROS FINANCES</h2></center>
        <h:panelGroup id="panGroupfammed">
            
            <a4j:commandButton image="/images/print.png" id="imprimer" oncomplete="javascript:Richfaces.showModalPanel('panelImpFamiProdmed');">
            </a4j:commandButton>
        </h:panelGroup>&nbsp; &nbsp;&nbsp;
        <rich:extendedDataTable border="0" id="mytableauFamiProdMed" footerClass="bard"headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" style="width:60%;border:solid 0px green;margin-top:10px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.lectureFluxNaturesFamillesProduitsMF.tableauxFamilles}"  var="familleProd">
             <rich:column style="heigth:20px;" sortable="true"  width="15%">
                <f:facet name="header">
                    <h:outputText  value="Code" />
                </f:facet>
                <h:outputText value="#{familleProd.code}" id="cod"/>
            </rich:column>
            <rich:column style="heigth:20px;" width="75%">
                <f:facet name="header">
                    <h:outputText  value="Libellé"  />
                </f:facet>
                <h:outputText  value="#{familleProd.nomFR}" id="lib" />
            </rich:column>
            <rich:column >
                <f:facet name="header">
                    <h:outputText  value="Etat"  />
                </f:facet>
                
            </rich:column>
        </rich:extendedDataTable>

        <br>
        <center>
            <h:commandButton value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" />

        </center>
    </a4j:form>

   
</f:subview>
