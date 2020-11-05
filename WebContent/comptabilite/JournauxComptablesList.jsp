<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="sc">

    <center> <h2><h:outputText value="SAISIE DES JOURNAUX COMPTABLES" styleClass="titre"/></h2></center>

    <a4j:form style="width:100%">

        <h:panelGrid columns="2" width="100%"  id="pgrid" >

            <rich:column width="50%" id="g1">
                <rich:panel  style="width:100%;border:0px" id="pan1">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.datamodelJournaux}" var="jounaux" id="tableActif" style="max-height:100%;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.simpleSelectionJournaux}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.extDTableJournaux}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionJournauxActifs}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g2,table2" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionJournauxActifs}" reRender="modAttente,g2,table2" />
                            <rich:column label="Devise du journal" width="10%" sortable="true" sortBy="#{jounaux.pljChoixDevise}">
                                <f:facet name="header"><h:outputText value="Dev." /></f:facet>
                                <h:outputText value="#{jounaux.pljChoixDevise}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Code journal" width="20%" sortable="true" sortBy="#{jounaux.pljCode}" sortOrder="ASCENDING" >
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText style="width:10px;" value="#{jounaux.pljCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Intitulé du journal" width="50%" sortable="true" sortBy="#{jounaux.pljLibelleFr}" >
                                <f:facet name="header"><h:outputText value="Intitulé" /></f:facet>
                                <h:outputText value= "#{jounaux.pljLibelleFr}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Nature du journal" width="20%" sortable="true" sortBy="#{jounaux.libNature}" >
                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                <h:outputText value= "#{jounaux.libNature}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="50%" id="g2">
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.afficheTJM}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable footerClass="bard" border="0" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.dataModelMois}" var="mois" id="table2" style="max-height:100%;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.simpleSelectionPeriode}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.extDTablePeriode}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionMoisSaisieLight}" reRender="table2,idOpen"/>
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value= "#{mois.joumenPeriode}" >
                                </h:outputText>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Clôt."/></f:facet>
                                <h:graphicImage rendered="#{((mois.joumenEtat==1)||(mois.joumenEtat==2))==true}" value="/images/cadenas_cl.png"/>
                            </rich:column>
                            <rich:column width="10%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Sais."/></f:facet>
                                <h:graphicImage rendered="#{(mois.joumenSaisie==1)==true}" value="/images/journal_saisie.gif"/>
                            </rich:column>
                            <rich:column width="40%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Utilisateur en cours" /></f:facet>
                                <h:outputText value= "#{mois.joumenOpenUserJournal}" />
                            </rich:column>
                            <rich:column width="20%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Ouverture"/></f:facet>
                                <a4j:commandButton id="idOpen" eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.selectionMoisSaisie}" rendered="#{(mois.select&&((mois.joumenOpenJournal==0)||((mois.joumenOpenJournal==1)&&(mois.joumenUserIdJournal==bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrid)))&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formJournauxComptables.sansChrono)==true}" styleClass="ouvrir" value="Ouvrir" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

        </h:panelGrid>

    </a4j:form>

</f:subview>
