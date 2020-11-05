<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h:panelGrid style="width:100%;" id="panMesAbsences">

    <a4j:form>

        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MES ABSENCES ET MES RETARDS (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme})" style="color:green;" /></h2></center>
        </h:column>

        <h:panelGrid id="panAbsences" width="100%">
            <jsp:include flush="true" page="/paye/CongesPayesCommun.jsp"/>
            <h:panelGrid width="250px" id="panelBoutonAbsences2" columns="5"  style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <a4j:commandButton title="Ajouter une nouvelle demande" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.ajouterDemandeAbsences}" reRender="panelDemandeAbsences"/>
                <a4j:commandButton title="Supprimer l'absence sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_affiche_absences&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==10}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.supprimerAbsences}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonAbsences2,tableAbsences"/>
            </h:panelGrid>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable border="0" enableContextMenu="false" id="tableAbsences" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.dataModelAbsences}" var="abs">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.selectionAbsences}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonAbsences,panelBoutonAbsences2"/>
                    <rich:column label="Nature de l'absence" sortable="true" width="20%" sortOrder="#{abs.lib_nature}">
                        <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                        <h:outputText value="#{abs.lib_nature}"/>
                    </rich:column>
                    <rich:column label="Etat de l'absence" sortable="true" width="10%" sortOrder="#{abs.salgrhEtat}">
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{abs.libelleEtat}" id="idEtatAbsence"/>
                    </rich:column>
                    <rich:column label="Date de l'absence (JJ/MM/AAAA)" sortable="true" width="10%" sortOrder="#{abs.salcngDateDebut}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{abs.salcngDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Date retour de l'absence (JJ/MM/AAAA)" sortable="true" width="10%" sortOrder="#{abs.salcngDateFin}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Retour" /></f:facet>
                        <h:outputText value="#{abs.salcngDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Durée" sortable="true" width="10%" sortOrder="#{abs.salcngDuree}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                        <h:outputText value="#{abs.salcngDuree}"/>
                    </rich:column>
                    <rich:column label="Description" sortable="true" width="30%" sortOrder="#{abs.salcngObjet}">
                        <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                        <h:outputText value="#{abs.salcngObjet}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelDemandeAbsences" width="800" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelDemandeAbsences}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.showModalPanelDemandeAbsences}" var="abr">
            <f:facet name="header"><h:outputText value="DEMANDE D'ABSENCE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanAbsences" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annulerAbsences}" styleClass="hidelink" reRender="panelDemandeAbsences"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanAbsences')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid style="width:100%;" id="panAbsences">
                    <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Nature Absence:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}">
                                <f:selectItem itemLabel="Demande d'absence" itemValue="10" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" id="idAbsences" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" >
                        <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                        <h:column>
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngAm}"/>&nbsp;&nbsp;
                            <h:outputText value="Absent à partir du matin"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}"><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=14&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature!=15}">
                            <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/>&nbsp;&nbsp;&nbsp;
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngPm}"/>&nbsp;&nbsp;
                            <h:outputText value="Absent jusqu'au soir"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==15}"><h:outputText value="Nombre heures retard:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==14||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNature==15}"><h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngNbHeure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/></h:column>
                        <h:column><h:outputText value="Motif/objet:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesAbsences.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_absences==3}"/></h:column>
                    </h:panelGrid>
                    <h:panelGroup>
                        <br>
                        <center>
                            <a4j:commandButton id="idValAbsences" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.saveAbsences}" reRender="panelBoutonAbsences2,tableAbsences,panelDemandeAbsences"/>
                        </center>
                        <rich:hotKey key="return"  handler="#{rich:element('idValAbsences')}.click()" />
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</h:panelGrid>

