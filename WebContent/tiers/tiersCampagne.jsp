<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersCampagne">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="CAMPAGNE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}"/></h2></center>

        <h:panelGrid id="pn2" width="100%" border="0">

            <h:panelGrid style="border:solid 0px green;" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableParticipant" maxPages="20" align="left" for="tableParticipant"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" styleClass="bg" id="tableParticipant" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" height="300px"  width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelParticipants}" var="par">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionCampagneTiers}" reRender="panelDetailsParticipant"/>
                        <rich:column label="Date visite" sortable="true" sortBy="#{par.camparDate}" width="15%">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{par.camparDate}">
                                <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Campagne" sortable="true" sortBy="#{par.campagneEnteteVentes.camObjet}" width="20%">
                            <f:facet name="header"><h:outputText  value="Campagne"/></f:facet>
                            <h:outputText value="#{par.campagneEnteteVentes.camObjet}"/>
                        </rich:column>
                        <rich:column label="Nom prénom du participant" sortable="true" sortBy="#{par.contacts.conpatronyme}" width="20%">
                            <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                            <h:outputText value="#{par.contacts.conpatronyme}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{par.contacts.confonction}" width="15%">
                            <f:facet name="header"><h:outputText  value="Fonction"/></f:facet>
                            <h:outputText  value="#{par.contacts.confonction}"/>
                        </rich:column>
                        <rich:column label="Téléphone" sortable="true" sortBy="#{par.contacts.concel1}" width="10%">
                            <f:facet name="header"><h:outputText  value="Téléphne"/></f:facet>
                            <h:outputText  value="#{par.contacts.concel1}"/>
                        </rich:column>
                        <rich:column label="eMail" sortable="true" sortBy="#{par.contacts.mailCumul}" width="20%">
                            <f:facet name="header"><h:outputText  value="eMail"/></f:facet>
                            <h:outputText  value="#{par.contacts.mailCumul}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

            <h:panelGrid id="panelDetailsParticipant" width="100%">
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;">

                    <rich:tab label="Visite">
                        <h:panelGrid  columns="2" style="width:100%;" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Nom contact:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText style="width:90%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.contacts.conpatronyme}" readonly="true"></h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Société:"/></h:column>
                            <h:column><h:inputText style="width:90%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.camparNomTiers}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Date visite:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.camparDate}"  inputSize="8" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" readonly="true"/></h:column>
                            <h:column><h:outputText value="Campagne:"/></h:column>
                            <h:column><h:inputText style="width:90%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.campagneEnteteVentes.camObjet}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Livre d'or">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Livre d'or"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.camparCommentaire}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Actions à faire">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Action à faire"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.camparAction}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Cadeaux">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Cadeaux effectués"/></f:facet>
                            <h:column><h:inputTextarea rows="20" cols="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.campagneParticipantVentes.camparCadeau}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
            </h:panelGrid>

            <h:panelGroup>
                <center>
                    <a4j:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.retourCampagne}" reRender="modAttente,idSubView"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

</f:subview>
