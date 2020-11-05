<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersExtraitCompte">

    <a4j:form id="formDoc">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="EXTRAIT DE COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" /></h2></center>

        <h:panelGrid  id="cont1" width="100%" columnClasses="cols">

            <h:panelGrid columns="10" styleClass="recherche" width="100%" >
                <h:column> <h:outputText value="Comptes:"/></h:column>
                <h:column>
                    <h:selectOneMenu  style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.cpteTiers}" >
                        <f:selectItem itemLabel="Choisissez un compte ..." itemValue="0"/>
                        <f:selectItem itemLabel="Compte Principal" itemValue="1" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte0==''}"/>
                        <f:selectItem itemLabel="Compte secondaire(avance, acompte)" itemValue="2" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte1==''}"/>
                        <f:selectItem itemLabel="Compte secondaire(à parvenir)" itemValue="3" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte2==''}"/>
                        <f:selectItem itemLabel="Compte secondaire(douteux, litiges)" itemValue="4" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte3==''}"/>
                        <f:selectItem itemLabel="Compte rattaché" itemValue="5"itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecompte4==''}"/>
                        <f:selectItem itemLabel="Tous les Comptes" itemValue="6"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column> <h:outputText value="Du:"/></h:column>
                <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                <h:column> <h:outputText value="Au:"/></h:column>
                <h:column><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                <h:column> <h:outputText value="Etats:"/></h:column>
                <h:column>
                    <h:selectOneMenu  style="width:210;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.etatEcr}" >
                        <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                        <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                        <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                        <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                        <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                        <f:selectItem itemLabel="Ecritures non lettrées et non pointées" itemValue="5"/>
                        <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value=""/></h:column>
                <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chargerLesEcritures}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="ecrtitures,modAttente,paneltotal"/>
            </h:panelGrid>

            <h:panelGroup>
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="ecrtitures"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" style="max-height:100%" styleClass="bg" id="ecrtitures" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.lesEcritures}" var="ecritures">
                            <rich:column width="80" sortable="true" sortBy="#{ecritures.ecrCompte}">
                                <f:facet name="header" ><h:outputText value="Compte"/></f:facet>
                                <h:outputText value="#{ecritures.ecrCompte}" />
                            </rich:column>
                            <rich:column width="60" sortable="true" sortBy="#{ecritures.ecrCode}">
                                <f:facet name="header"><h:outputText  value="Journal"/></f:facet>
                                <h:outputText value="#{ecritures.ecrCode}" />
                            </rich:column>
                            <rich:column width="70" sortable="true" sortBy="#{ecritures.ecrDateSaisie}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                <h:outputText value="#{ecritures.ecrDateSaisie}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{ecritures.ecrPiece}">
                                <f:facet name="header"><h:outputText value="N° de pièce"/></f:facet>
                                <h:outputText value="#{ecritures.ecrPiece}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{ecritures.ecrReference1}" >
                                <f:facet name="header"><h:outputText value="Référence1"/></f:facet>
                                <h:outputText value="#{ecritures.ecrReference1}"/>
                            </rich:column>
                            <rich:column sortBy="#{ecritures.ecrReference2}" >
                                <f:facet name="header"><h:outputText value="Référence2"/></f:facet>
                                <h:outputText value="#{ecritures.ecrReference2}"/>
                            </rich:column>
                            <rich:column sortable="true" width="40" sortBy="#{ecritures.ecrLettrage}">
                                <f:facet name="header"><h:outputText value="Lettre"/></f:facet>
                                <h:outputText value="#{ecritures.ecrLettrage}" />
                            </rich:column>
                            <rich:column sortable="true" width="40" sortBy="#{ecritures.ecrPointage}" >
                                <f:facet name="header"><h:outputText value="Point."/></f:facet>
                                <h:outputText  value="#{ecritures.ecrPointage}" />
                            </rich:column>
                            <rich:column sortable="true" width="40" sortBy="#{ecritures.ecrDevisePays}"  >
                                <f:facet name="header"><h:outputText value="Dev."/></f:facet>
                                <h:outputText value="#{ecritures.ecrDevisePays}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{ecritures.ecrDebitPays}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Débit" /></f:facet>
                                <h:outputText value="#{ecritures.ecrDebitPays}" rendered="#{ecritures.ecrDebitPays!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{ecritures.ecrCreditPays}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Crédit"/></f:facet>
                                <h:outputText value="#{ecritures.ecrCreditPays}" rendered="#{ecritures.ecrCreditPays!=0}" style="text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="true" width="300px" sortBy="#{ecritures.ecrLibelle}" >
                                <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                <h:outputText value="#{ecritures.ecrLibelle}">
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </div>
            </h:panelGroup>

            <h:panelGrid id="paneltotal" columns="2" columnClasses="clos50d,clos50d" width="50%" border="0">
                <h:column><h:outputText value="Total mouvements Débit:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.totalDeb}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column>
                    <h:outputText value="Total mouvements Crédit:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.totalCred}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
                <h:column><h:outputText value="Solde mouvements:"/></h:column>
                <h:column>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.soldeDebCred}" style="text-align:right;">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:outputText>
                </h:column>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourExtrait}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>