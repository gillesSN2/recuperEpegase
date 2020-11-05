<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview  id="listequinzaine">

    <center> <h2><h:outputText value="GESTION DES QUINZAINES" styleClass="titre"/></h2></center>

    <a4j:form>

        <h:panelGrid columns="2" width="100%" id="pgrid">

            <rich:column width="50%" id="g1">
                <rich:panel  style="width:100%;border:0px" id="pan1">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelFeuilles}" var="jounaux" id="tableActif" style="max-height:100%;border:solid 0px green;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" " border="0"  footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.simpleSelectionFeuille}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.extDTableFeuille}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionFeuille}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="g2,table2,modAttente" />
                            <a4j:support eventsQueue="maQueue" event="onRowDblClick" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionFeuille}" reRender="g2,table2,modAttente" />
                            <rich:column label="Code feuille" width="20%" sortable="true" sortBy="#{jounaux.feuCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText style="width:10px;" value="#{jounaux.feuCode}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Intitulé de la feuille de calcul" width="60%" sortable="true" sortBy="#{jounaux.feuLibelleFr}" >
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.libelleRepartition}"/></f:facet>
                                <h:outputText value= "#{jounaux.feuLibelleFr}">
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Nature de la feuille" width="20%" sortable="true" sortBy="#{jounaux.libelleNature}" >
                                <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                                <h:outputText value= "#{jounaux.libelleNature}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

            <rich:column  width="50%" id="g2">
                <rich:panel style="max-height:100%;border:0px;width:100%;" id="pan2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.afficheTJM}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  border="0" footerClass="bard" headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.dataModelPeriodes}" var="mois" id="table2" style="max-height:100%;border:solid 0px black;cursor:pointer;" width="100%" activeClass="active-row" noDataLabel=" "  activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.simpleSelectionPeriode}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.extDTablePeriode}">
                            <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionPeriodeLight}" reRender="table2,idOpen"/>
                            <rich:column width="30%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                                <h:outputText value= "#{mois.bulmenPeriode}" rendered="#{mois.bulmenJour==null}"/>
                                <h:outputText value= "#{mois.bulmenJour}" rendered="#{mois.bulmenJour!=null}">
                                    <f:convertDateTime locale="fr" dateStyle="full" type="date"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column width="20%" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:outputText value= "#{mois.libEtat}"/>&nbsp;&nbsp;
                                <h:graphicImage rendered="#{((mois.bulmenEtat==3)||(mois.bulmenEtat==4))==true}" value="/images/cadenas_cl.png"/>
                            </rich:column>
                            <rich:column width="33%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Utilisateur en cours" /></f:facet>
                                <h:outputText value= "#{mois.bulmenOpenUserJournal}" />
                            </rich:column>
                            <rich:column width="17%" sortable="false">
                                <f:facet name="header"><h:outputText  value="Ouverture"/></f:facet>
                                <a4j:commandButton id="idOpen" eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPreparation.selectionPeriodeQuinzaine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&(mois.select&&((mois.bulmenOpenJournal==0)||((mois.bulmenOpenJournal==1)&&(mois.bulmenUserIdJournal==bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrid))))==true}" styleClass="ouvrir" value="Ouvrir" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pboardb,journauxcomptablesinit"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:panel>
            </rich:column>

        </h:panelGrid>

    </a4j:form>

</f:subview>