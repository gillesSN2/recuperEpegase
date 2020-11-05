<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="gestLot">

    <a4j:form>
        <rich:hotKey key="return" handler="return true;"/>

        <center> <h2><h:outputText value="GESTION DES LOTS" styleClass="titre"/></h2></center>

        <h:panelGroup id="grid">
            <center>

            </center>
        </h:panelGroup>
        <br>
        <h:panelGrid id="panCtrl" styleClass="recherche" width="100%">
            <h:panelGrid columns="7" width="100%">
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_more_search}"/>
                <h:column><h:outputText value="N°Lot"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpNum}" size="5"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpEtat}" style="width:150px;">
                        <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                        <f:selectItem itemLabel="En Cours" itemValue="0"/>
                        <f:selectItem itemLabel="Terminé" itemValue="1"/>
                        <f:selectItem itemLabel="Gelé" itemValue="2"/>
                        <f:selectItem itemLabel="Abandonné" itemValue="3"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.periode}" style="width:150px;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_more_search}">
                        <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesPeriodesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.inpService}" style="width:150px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panCtrl,tableSerieGlobal,scrollTable"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
            <h:panelGrid id="panDest" columns="7" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.var_more_search}">
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20" align="left" for="tableSerieGlobal"/>
                <rich:extendedDataTable rows="100" id="tableSerieGlobal" enableContextMenu="true" footerClass="bard" headerClass="headerTab" activeClass="active-row" rowClasses="rows1,rows2,rowsd" noDataLabel=" " styleClass="bg" border="0" width="200%" style="max-height:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formSerialisation.dataModelLot}" var="lot">
                    <rich:column label="Libellé du lot" sortable="true" sortBy="#{lot.anaCode}" width="150px">
                        <f:facet name="header"><h:outputText value="N° LOT"/></f:facet>
                        <h:outputText value="#{lot.anaCode}"/>
                    </rich:column>
                    <rich:column label="Libellé" sortable="true" width="300px" sortBy="#{lot.anaNomFr}">
                        <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                        <h:outputText value="#{lot.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Service" sortable="true" width="200px" sortBy="#{lot.anaAffaireService}">
                        <f:facet name="header"><h:outputText value="Service"/></f:facet>
                        <h:outputText value="#{lot.anaAffaireService}"/>
                    </rich:column>
                    <rich:column label="Date début" sortable="true" sortBy="#{lot.anaMissionDebut}">
                        <f:facet name="header"><h:outputText value="Début"/></f:facet>
                        <h:outputText value="#{lot.anaMissionDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date Fin" sortable="true" sortBy="#{lot.anaMissionFin}">
                        <f:facet name="header"><h:outputText value="Fn"/></f:facet>
                        <h:outputText value="#{lot.anaMissionFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Etat" sortable="true" sortBy="">
                        <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                        <h:outputText value="#{lot.etatLot}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </div>

    </a4j:form>

</f:subview>
