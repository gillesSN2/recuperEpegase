<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="reuniontiersfiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DE LA REUNION TIERS" style="color:green;"/></h2></center>

            <h:panelGroup id="panelPage" >
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Réunion" >
                        <h:panelGrid width="100%">
                            <h:panelGrid width="100%" styleClass="fichefournisseur">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Date:"/></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDate}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelValide,outptpanelTiers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.controleSaisie}"/>
                                        </rich:calendar>
                                    </h:column>
                                    <h:column><h:outputText value="N°:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNum}" readonly="true"/></h:column>
                                    <h:column><h:outputText value="Service:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesServicesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.chargerUserService}" reRender="panelContact"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Tiers:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomTiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" maxlength="100">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers,panelContact"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Contact tiers:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idContact">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans contact" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.lesContactsItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idPresident">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_president}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans respponsable" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesPresidentsItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Objet:"/></h:column>
                                    <h:column>
                                        <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuObject}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" maxlength="100">
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.controleSaisie}" reRender="panelValide,outptpanelTiers"/>
                                        </h:inputText>
                                    </h:column>
                                    <h:column><h:outputText value="Type:" style="color:red;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:45%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
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
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal,tabBesoin,tabProbleme,tabActionsLast,tabActionsNew,tabCdc,tabConclusion"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                                            <f:selectItem itemLabel="In situ" itemValue="0"/>
                                            <f:selectItem itemLabel="En extérieur" itemValue="1"/>
                                            <f:selectItem itemLabel="Par téléphone" itemValue="2"/>
                                            <f:selectItem itemLabel="Par skype" itemValue="3"/>
                                            <f:selectItem itemLabel="En vidéo conférence" itemValue="4"/>
                                            <f:selectItem itemLabel="Par internet" itemValue="5"/>
                                            <f:selectItem itemLabel="Live Webcast (E-Conferencing)" itemValue="6"/>
                                        </h:selectOneMenu>
                                        <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
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
                                            <f:selectItem itemLabel="Rév. 11" itemValue="20"/>
                                            <f:selectItem itemLabel="Rév. 12" itemValue="21"/>
                                            <f:selectItem itemLabel="Rév. 13" itemValue="22"/>
                                            <f:selectItem itemLabel="Rév. 14" itemValue="23"/>
                                            <f:selectItem itemLabel="Rév. 15" itemValue="24"/>
                                            <f:selectItem itemLabel="Rév. 16" itemValue="25"/>
                                            <f:selectItem itemLabel="Rév. 17" itemValue="26"/>
                                            <f:selectItem itemLabel="Rév. 18" itemValue="27"/>
                                            <f:selectItem itemLabel="Rév. 19" itemValue="28"/>
                                            <f:selectItem itemLabel="Rév. 20" itemValue="29"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Activité:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans activité spécifique" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesActivitesItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}"><h:outputText value="Heure début:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                                        <h:panelGrid  columns="4">
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuHeureDeb}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesHeuresDebItems}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>h</h:column>
                                            <h:column>
                                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMinuteDeb}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesMinutesDebItems}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>mn</h:column>
                                        </h:panelGrid>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}"><h:outputText value="Front office:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_frontOffice}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans front office" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesSecretairesItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}"><h:outputText value="Heure fin:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                                        <h:panelGrid  columns="4">
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuHeureFin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesHeuresFinItems}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>h</h:column>
                                            <h:column>
                                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMinuteFin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesMinutesFinItems}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column>mn</h:column>
                                        </h:panelGrid>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}"><h:outputText value="Back office:" /></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_backOffice}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans back office" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesSecretairesItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                            </h:panelGrid>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuIntroduction}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Présents" id="tabPresence" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <h:panelGroup id="tablePresence">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauPresence" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelPresence}" var="present">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectPresence}"/>
                                    <rich:column sortable="true" sortBy="#{present.reupreNomUser} #{present.reuprePrenomUser}" sortOrder="ASCENDING" width="40%">
                                        <f:facet name="header" ><h:outputText value="Utilisateur"/></f:facet>
                                        <h:outputText value="#{present.reupreNomUser} #{present.reuprePrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Présent"/></f:facet>
                                        <h:selectBooleanCheckbox  value="#{present.reuprePresent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{present.reupreMotif}"  width="50%">
                                        <f:facet name="header" ><h:outputText value="Observations"/></f:facet>
                                        <h:inputText value="#{present.reupreMotif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" style="width:90%"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Définition des besoins" id="tabBesoin" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuContenu}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab label="Liste des problèmes" id="tabProbleme" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType>=25&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType<=28}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuContenu}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab label="Actions antérieures" style="color:red;" id="tabActionsLast" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp"/>
                        <center>
                            <h:panelGroup id="boutonActionOld" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                <a4j:commandButton title="Modifier action" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.modifActionOld}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.afficheButtonActionOld}" reRender="panelActionOld"/>&nbsp;&nbsp;&nbsp;
                            </h:panelGroup>
                        </center>
                        <h:panelGroup id="tableActionOld" style="color:black;">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauActionOld" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelActionOld}" var="actOld">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectActionOld}" reRender="boutonActionOld"/>
                                    <rich:column label="N° réunion" sortable="true" width="7%" sortBy="#{actOld.reunionEntete.reuNum}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{actOld.reunionEntete.reuNum}"/>
                                    </rich:column>
                                    <rich:column label="Date réunion" sortable="true" sortBy="#{actOld.reunionEntete.reuDate}" width="7%" sortOrder="DESCENDING">
                                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                        <h:outputText value="#{actOld.reunionEntete.reuDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactNomUser}"  width="15%">
                                        <f:facet name="header" ><h:outputText value="Qui"/></f:facet>
                                        <h:outputText value="#{actOld.reuactNomUser} #{actOld.reuactPrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactQuoi}"  width="15%">
                                        <f:facet name="header" ><h:outputText value="Quoi"/></f:facet>
                                        <h:outputText value="#{actOld.reuactQuoi}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactQuand}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Quand"/></f:facet>
                                        <h:outputText value="#{actOld.reuactQuand}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactDate}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="Deadline"/></f:facet>
                                        <h:outputText value="#{actOld.reuactDate}"  style="text-align:right;">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactOu}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Ou"/></f:facet>
                                        <h:outputText value="#{actOld.reuactOu}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.libelleEtat}"  width="5%">
                                        <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                                        <h:outputText value="#{actOld.libelleEtat}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactDateExecution}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="Exécuté le"/></f:facet>
                                        <h:outputText value="#{actOld.reuactDateExecution}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactNumExecution}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                        <h:outputText value="#{actOld.reuactNumExecution}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.reuactObsExecution}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Observation"/></f:facet>
                                        <h:outputText value="#{actOld.reuactObsExecution}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Nouvelles actions" id="tabActionsNew" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <center>
                            <h:panelGroup id="boutonActionNew" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                <a4j:commandButton title="Ajouter action" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.ajoutAction}" reRender="panelActionNew," />&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Modifier action" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.modifAction}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.afficheButtonActionNew}" reRender="panelActionNew"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Supprimer action" image="/images/supprimer.png"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.afficheButtonActionNew}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.deleteAction}" reRender="boutonActionNew,tableauActionNew"/>
                            </h:panelGroup>
                        </center>
                        <h:panelGroup id="tableActionNew">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauActionNew" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelActionNew}" var="actNew">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick"   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectActionNew}" reRender="boutonActionNew"/>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactNomUser}"  width="20%">
                                        <f:facet name="header" ><h:outputText value="Qui"/></f:facet>
                                        <h:outputText value="#{actNew.reuactNomUser} #{actNew.reuactPrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactQuoi}"  width="14%">
                                        <f:facet name="header" ><h:outputText value="Quoi"/></f:facet>
                                        <h:outputText value="#{actNew.reuactQuoi}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactQuand}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Quand"/></f:facet>
                                        <h:outputText value="#{actNew.reuactQuand}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactDate}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="Deadline"/></f:facet>
                                        <h:outputText value="#{actNew.reuactDate}"  style="text-align:right;"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactOu}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Ou"/></f:facet>
                                        <h:outputText value="#{actNew.reuactOu}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actOld.libelleEtat}"  width="5%">
                                        <f:facet name="header" ><h:outputText value="Etat"/></f:facet>
                                        <h:outputText value="#{actNew.libelleEtat}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactDateExecution}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="Exécuté le"/></f:facet>
                                        <h:outputText value="#{actNew.reuactDateExecution}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactNumExecution}"  width="7%">
                                        <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                        <h:outputText value="#{actNew.reuactNumExecution}"/>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{actNew.reuactObsExecution}"  width="10%">
                                        <f:facet name="header" ><h:outputText value="Observation"/></f:facet>
                                        <h:outputText value="#{actNew.reuactObsExecution}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Cahier des charges" id="tabCdc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType==24}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Modèle impression compte rendu" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuModeleCRImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.documentResultatImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuConclusion}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab label="Conclusion" id="tabConclusion" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuType!=24}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <h:panelGrid columns="2" style="background-color:white;" columnClasses="clos20,clos80" width="100%">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib1!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo1}" size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib2!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo2}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib3!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo3}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib4!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo4}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib5!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo5}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib6!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo6}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib7!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo7}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib8!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo8}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib9!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo9}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10!=''}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10}:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.optionTiers.lib10!=''}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuInfo10}"  size="100" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAvoirVentes.var_aff_action}" maxlength="100"/></h:column>
                            <h:column><h:outputText value="Modèle impression compte rendu" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuModeleCRImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.documentResultatImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuConclusion}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionTiersCommun.jsp" />
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="ID REUNION:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomCreateur}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID créateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuIdCreateur}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de création:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateCreat}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuNomModif}" size="100" readonly="true"/></h:column>
                            <h:column><h:outputText value="ID modificateur:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuIdModif}" size="20" readonly="true"/></h:column>
                            <h:column><h:outputText value="Date de modification:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateModif}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Date d'impression:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateImp}" readonly="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr" />
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Etat:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:180px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat}" disabled="true">
                                    <f:selectItem itemLabel="Préparation" itemValue="0"/>
                                    <f:selectItem itemLabel="En cours" itemValue="1"/>
                                    <f:selectItem itemLabel="Valider" itemValue="2"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>

                <h:panelGroup id="panelValide">
                    <center>
                        <br><br>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.annule}"  />&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" />
                    </center>
                    <center>
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et le tiers sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_valide_doc}"/>
                    </center>
                </h:panelGroup>
            </h:panelGroup>
        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelActionNew" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="350" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelActionNew}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelActionNew}">
            <f:facet name="header"><h:outputText value="GESTION DES NOUVELLES ACTIONS"/></f:facet>
            <a4j:form id="formModalActionNew">
                <h:panelGrid  width="100%">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" >
                        <h:column><h:outputText value="Qui:" /></h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_qui}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesAgentsPresentsItem}" />
                        </h:selectOneMenu>
                        <h:column><h:outputText value="Quoi:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactQuoi}" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Quand:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactQuand}" maxlength="50"/></h:column>
                        <h:column><h:outputText value="Date deadline:" /></h:column>
                        <h:column>
                            <rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactDate}" >
                                <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Ou:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactOu}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanActionNew" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.annuleAction}" reRender="panelActionNew,boutonActionNew,tableauActionNew"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValActionNew" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.saveAction}" reRender="panelActionNew,boutonActionNew,tableauActionNew"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanActionNew')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValActionNew')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelActionOld" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="350" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelActionOld}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelActionOld}">
            <f:facet name="header"><h:outputText value="MODIFICATIONS ANCIENNES ACTIONS"/></f:facet>
            <a4j:form id="formModalActionOld">
                <h:panelGrid  width="100%">
                    <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" >
                        <h:column><h:outputText value="Qui:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_qui}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Quoi:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactQuoi}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Quand:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactQuand}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date deadline:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactDate}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Ou:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactOu}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Etat:" /></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactEtat}">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Traité avec succès" itemValue="1"/>
                                <f:selectItem itemLabel="Traité avec échec" itemValue="2"/>
                                <f:selectItem itemLabel="Non Traité/annulée" itemValue="3"/>
                                <f:selectItem itemLabel="Reporté" itemValue="4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° exécution:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactNumExecution}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Observation:" /></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionAction.reuactObsExecution}" maxlength="50"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanActionOld" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.annuleActionOld}" reRender="panelActionOld,boutonActionOld,tableauActionOld"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValActionOld" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.saveActionOld}" reRender="panelActionOld,boutonActionOld,tableauActionOld"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanActionOld')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValActionOld')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelTiers}" var="tiers" >
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableTiers" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.datamodelTiers}"  var="tiers">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectionTiers}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                            <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                            <h:outputText value="#{tiers.tiecategorie}"/>
                        </rich:column>
                        <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
                            <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                            <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{tiers.tieprenom}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                            <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                            <h:outputText value="#{tiers.tiecivilite}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valtiers">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.annuleTiers}" reRender="panelListeTiers,panelContact"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.calculeTiers}" reRender="panelListeTiers,panelContact"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
