<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="rap">

    <center> <h2><h:outputText value="SAISIE DES RAPPROCHEMENTS BANCAIRE (JOURNALIER)" styleClass="titre"/></h2></center>

    <a4j:form style="width:100%">

        <h:panelGrid columns="3" width="100%"  id="pgrid" >

            <rich:column width="35%" id="g1">
                <rich:panel  style="width:100%;border:0px" id="pan1">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.datamodelJournaux}" var="jounaux" id="tableActif" style="max-height:100%;border:solid 0px green;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " border="0"  footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.simpleSelectionJournaux}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.extDTableJournaux}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJournauxActifs}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g2,table2,g3,table3" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJournauxActifs}" reRender="modAttente,g2,table2,g3,table3" />
                            <rich:column label="Code journal" width="35%" sortable="true" sortBy="#{jounaux.pljCode}" sortOrder="ASCENDING" >
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText style="width:10px;" value="#{jounaux.pljCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Intitulé du journal" width="65%" sortable="true" sortBy="#{jounaux.pljLibelleFr}" >
                                <f:facet name="header"><h:outputText value="Intitulé" /></f:facet>
                                <h:outputText value= "#{jounaux.pljLibelleFr}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

             <rich:column  width="15%" id="g2">
                 <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.afficheTJM}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.dataModelMois}" var="mois" id="table2" style="max-height:100%;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.simpleSelectionPeriode}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.extDTablePeriode}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJournalJour}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,g3,table3" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJournalJour}" reRender="modAttente,g3,table3" />
                            <rich:column width="100%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value= "#{mois.joumenPeriode}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="50%" id="g3">
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.afficheTJJ}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.dataModelJour}" var="jour" id="table3" style="max-height:100%;border:solid 0px black;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.simpleSelectionJour}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.extDTableJour}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJourSaisieLight}" reRender="table3,idOpen"/>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value= "#{jour.joujrDate}">
                                    <f:convertDateTime dateStyle="full" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="8%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Clôt."/></f:facet>
                                <h:graphicImage rendered="#{((jour.joujrEtat==1)||(jour.joujrEtat==2))==true}" value="/images/cadenas_cl.png"/>
                            </rich:column>
                            <rich:column width="40%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Utilisateur en cours" /></f:facet>
                                <h:outputText value= "#{jour.joujrOpenUserJournal}" />
                            </rich:column>
                            <rich:column width="15%" sortable="false">
                                <f:facet name="header"><h:outputText value="Ouverture"/></f:facet>
                                <a4j:commandButton id="idOpen" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionJourSaisie}" rendered="#{(jour.select&&((jour.joujrOpenJournal==0)||((jour.joujrOpenJournal==1)&&(jour.joujrUserIdJournal==bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrid))))==true}" styleClass="ouvrir" value="Ouvrir" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pboardb,journauxcomptablesinit"/>
                            </rich:column>

                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

        </h:panelGrid>

    </a4j:form>

</f:subview>
