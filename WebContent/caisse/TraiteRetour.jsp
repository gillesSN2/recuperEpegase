<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="traiteretour">

    <a4j:form>

        <center> <h2><h:outputText value="RETOUR BANQUE: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_intitule} Période du #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.dte1Affichage} au #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.dte2Affichage}" style="color:green;"/></h2></center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable enableContextMenu="false" id="tableEcheance" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.dataModelDepot}" var="det">
                    <rich:column label="Etat" sortable="false" style="text-align:right;" width="80px">
                        <f:facet name="header"><h:outputText value="N°"/></f:facet>
                        <h:outputText value="#{det.trtligOrdre}"/>
                    </rich:column>
                    <rich:column label="Date échéance" sortable="false">
                        <f:facet name="header"><h:outputText  value="Echéances"/></f:facet>
                        <h:outputText  value="#{det.trtligDateTheorique}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Montant" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                        <h:outputText  value="#{det.trtligMontant}" rendered="#{det.trtligMontant!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date dépôt" sortable="false">
                        <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                        <h:outputText  value="#{det.trtligDateDepot}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="N° bordereau" sortable="false" width="150px">
                        <f:facet name="header"><h:outputText  value="N° Bdx"/></f:facet>
                        <h:outputText  value="#{det.trtligBordereau}"/>
                    </rich:column>
                    <rich:column label="Date retour" sortable="false" width="150px">
                        <f:facet name="header"><h:outputText  value="Retour"/></f:facet>
                        <rich:calendar inputSize="8" value="#{det.trtligDateRetour}"  datePattern="dd-MM-yyyy" locale="fr" style=" background-color:white;" />
                    </rich:column>
                    <rich:column label="Motif de retour" sortable="false" width="150px">
                        <f:facet name="header"><h:outputText  value="Motif"/></f:facet>
                        <h:inputText  value="#{det.trtligMotif}"/>
                    </rich:column>
                    <rich:column label="Date report" sortable="false" width="150px">
                        <f:facet name="header"><h:outputText  value="Report"/></f:facet>
                        <rich:calendar inputSize="8" value="#{det.trtligDateReport}"  datePattern="dd-MM-yyyy" locale="fr" style=" background-color:white;" />
                    </rich:column>
                    <rich:column label="Nom des tiers" sortable="false" width="300px">
                        <f:facet name="header"><h:outputText  value="Tiers"/></f:facet>
                        <h:outputText  value="#{det.traiteEntete.trtNomTiers}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
        <br>
        <h:panelGroup id="prgtpAjt">
            <br><br>
            <center>
                <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.retourRetourMensuel}"  />&nbsp;&nbsp;
                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.validerRetourMensuel}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
            </center>
        </h:panelGroup>

    </a4j:form>

</f:subview>
