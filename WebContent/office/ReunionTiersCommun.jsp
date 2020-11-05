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
            <h:column><h:outputText value="Service:" style="text-decoration:underline;color:red;"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuService}" disabled="true">
                    <f:selectItem itemLabel="Sans service spécifique" itemValue=""/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesServicesItems}"/>
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
        <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
            <h:column><h:outputText value="Tiers:" style="text-decoration:underline;"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomTiers}" readonly="true"/></h:column>
            <h:column><h:outputText value="Contact tiers:" style="text-decoration:underline;"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_contact}" readonly="true">
                    <f:selectItem itemLabel="Sans contact" itemValue="0"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.lesContactsItems}" />
                </h:selectOneMenu>
            </h:column>
            <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomPresident}" readonly="true"/></h:column>
            <h:column><h:outputText value="Objet:"/></h:column>
            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuObject}" readonly="true"/></h:column>
            <h:column><h:outputText value="Type:"/></h:column>
            <h:column>
                <h:selectOneMenu style="width:45%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType}" disabled="true">
                    <f:selectItem itemLabel="Normale" itemValue="20"/>
                    <f:selectItem itemLabel="Démarches commerciales" itemValue="21"/>
                    <f:selectItem itemLabel="Démarches administratives" itemValue="22"/>
                    <f:selectItem itemLabel="Démarches financières" itemValue="23"/>
                    <f:selectItem itemLabel="Analyses techniques" itemValue="24"/>
                    <f:selectItem itemLabel="Problèmes adminstratifs" itemValue="25"/>
                    <f:selectItem itemLabel="Problèmes financiers" itemValue="26"/>
                    <f:selectItem itemLabel="Problèmes techniques" itemValue="27"/>
                    <f:selectItem itemLabel="Problèmes relationnels" itemValue="28"/>
                    <f:selectItem itemLabel="Autres types de problèmes" itemValue="29"/>
                    <f:selectItem itemLabel="Autres types de réunion" itemValue="30"/>
                </h:selectOneMenu>&nbsp;&nbsp;
                <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                    <f:selectItem itemLabel="In situ" itemValue="0"/>
                    <f:selectItem itemLabel="En extérieur" itemValue="1"/>
                    <f:selectItem itemLabel="Par téléphone" itemValue="2"/>
                    <f:selectItem itemLabel="Par skype" itemValue="3"/>
                    <f:selectItem itemLabel="En vidéo conférence" itemValue="4"/>
                    <f:selectItem itemLabel="Par internet" itemValue="5"/>
                    <f:selectItem itemLabel="Live Webcast (E-Conferencing)" itemValue="6"/>
                </h:selectOneMenu>
                <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                    <f:selectItem itemLabel="Rév. 1" itemValue="10"/>
                    <f:selectItem itemLabel="Rév. 2" itemValue="11"/>
                    <f:selectItem itemLabel="Rév. 3" itemValue="12"/>
                    <f:selectItem itemLabel="Rév. 4" itemValue="13"/>
                    <f:selectItem itemLabel="Rév. 5" itemValue="14"/>
                    <f:selectItem itemLabel="Rév. 6" itemValue="15"/>
                    <f:selectItem itemLabel="Rév. 7" itemValue="16"/>
                    <f:selectItem itemLabel="Rév. 8" itemValue="17"/>
                    <f:selectItem itemLabel="Rév. 9" itemValue="18"/>
                    <f:selectItem itemLabel="Rév. 10" itemValue="19"/>
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
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}"><h:outputText value="Heure début:" /></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
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
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}"><h:outputText value="Front office:" /></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_frontOffice}" disabled="true">
                    <f:selectItem itemLabel="Sans front office" itemValue="0"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesSecretairesItem}" />
                </h:selectOneMenu>
            </h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}"><h:outputText value="Heure fin:" /></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
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
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}"><h:outputText value="Back office:" /></h:column>
            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_backOffice}" disabled="true">
                    <f:selectItem itemLabel="Sans back office" itemValue="0"/>
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesSecretairesItem}" />
                </h:selectOneMenu>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>
