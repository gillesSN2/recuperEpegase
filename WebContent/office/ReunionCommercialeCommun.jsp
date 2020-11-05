<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid width="100%" styleClass="fichefournisseur">
        <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Date:"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDate}" readonly="true"/></h:column>
            <h:column><h:outputText value="N°:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNum}" readonly="true"/></h:column>
            <h:column><h:outputText value="Etat:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat}" disabled="true">
                    <f:selectItem itemLabel="Convocation" itemValue="0"/>
                    <f:selectItem itemLabel="Compte rendu" itemValue="1"/>
                    <f:selectItem itemLabel="Cloturé" itemValue="2"/>
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
        <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Service:" style="text-decoration:underline;color:red;"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuService}" disabled="true">
                    <f:selectItem itemLabel="Sans service spécifique" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesServicesItems}"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Responsable de séance:" style="text-decoration:underline;"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomPresident}" readonly="true"/></h:column>
            <h:column><h:outputText value="Période du:"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateDebut}" readonly="true" size="4"/>&nbsp;&nbsp;
                <h:outputText value="au:"/>&nbsp;
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateFin}" readonly="true"  size="4"/>
            </h:column>
            <h:column><h:outputText value="Objet:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuObject}" readonly="true"/></h:column>
            <h:column><h:outputText value="Type:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:45%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType}" disabled="true">
                    <f:selectItem itemLabel="Compte rendu Commercial" itemValue="10"/>
                    <f:selectItem itemLabel="Réunion Production" itemValue="11"/>
                </h:selectOneMenu>&nbsp;&nbsp;
                <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="true">
                    <f:selectItem itemLabel="In situ" itemValue="0"/>
                    <f:selectItem itemLabel="En extérieur" itemValue="1"/>
                    <f:selectItem itemLabel="Par téléphone" itemValue="2"/>
                    <f:selectItem itemLabel="Par skype" itemValue="3"/>
                    <f:selectItem itemLabel="En vidéo conférence" itemValue="4"/>
                    <f:selectItem itemLabel="Par internet" itemValue="5"/>
                    <f:selectItem itemLabel="Live Webcast (E-Conferencing)" itemValue="6"/>
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Activité:" style="text-decoration:underline;color:red;"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuActivite}" disabled="true">
                    <f:selectItem itemLabel="Sans activité spécifique" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesActivitesItems}" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Lieu:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuLieu}" readonly="true" disabled="true"/></h:column>
            <h:column><h:outputText value="Heure début:" /></h:column>
            <h:column>
                <h:panelGrid  columns="4">
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuHeureDeb}" disabled="true">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesHeuresDebItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>h</h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMinuteDeb}" disabled="true">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesMinutesDebItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>mn</h:column>
                </h:panelGrid>
            </h:column>
            <h:column><h:outputText value="Heure fin:" /></h:column>
            <h:column>
                <h:panelGrid  columns="4">
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuHeureFin}" disabled="true">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesHeuresFinItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>h</h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMinuteFin}" disabled="true">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesMinutesFinItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>mn</h:column>
                </h:panelGrid>
            </h:column>

        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>
