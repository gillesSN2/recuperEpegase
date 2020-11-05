<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="cm">

    <center> <h2><h:outputText value="CAISSES MENSUELLES" styleClass="titre"/></h2></center>

    <a4j:form style="width:100%" id="form">

        <h:panelGrid columns="2" width="100%"  id="pgrid" >

            <rich:column width="50%" id="g1">
                <rich:panel  style="width:100%;border:0px" id="pan1">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.datamodelJournaux}" var="jounaux" id="tableActif" style="max-height:100%;border:solid 0px green;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " border="0"  footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.simpleSelectionJournaux}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.extDTableJournaux}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalMensuel}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g2,table2" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionJournalMensuel}" reRender="modAttente,g2,table2" />
                            <rich:column label="Code journal" width="30%" sortable="true" sortBy="#{jounaux.caiCode}" sortOrder="ASCENDING" >
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText style="width:10px;" value="#{jounaux.caiCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Intitulé du journal" width="70%" sortable="true" sortBy="#{jounaux.caiNom}" >
                                <f:facet name="header"><h:outputText value="Intitulé" /></f:facet>
                                <h:outputText value= "#{jounaux.caiNom}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="50%" id="g2">
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.afficheTJM}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.dataModelMois}" var="mois" id="table2" style="max-height:100%;border:solid 0px black;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.simpleSelectionMois}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.extDTableMois}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionMoisSaisieLight}" reRender="table2,idOpen"/>
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value= "#{mois.caimenPeriode}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Clôt."/></f:facet>
                                <h:graphicImage rendered="#{((mois.caimenEtat==1)||(mois.caimenEtat==2))==true}" value="/images/cadenas_cl.png"/>
                            </rich:column>
                            <rich:column width="40%" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Solde fin mois" /></f:facet>
                                <h:outputText value= "#{mois.soldeFinal}" rendered="#{mois.soldeFinal!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Ouverture"/></f:facet>
                                <a4j:commandButton id="idOpen" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.selectionMoisSaisie}" rendered="#{mois.select&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formJournauxCaisse.sansChrono}" styleClass="ouvrir" value="Ouvrir" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pboardb,journauxcomptablesinit"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

        </h:panelGrid>

    </a4j:form>

</f:subview>
