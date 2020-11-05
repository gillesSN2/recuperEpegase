<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="reunioninternefiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DE LA REUNION INTERNE" style="color:green;"/></h2></center>

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
                                    <h:column><h:outputText value="Etat:"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Convocation" itemValue="0"/>
                                            <f:selectItem itemLabel="Compte rendu" itemValue="1"/>
                                            <f:selectItem itemLabel="Cloturé" itemValue="2"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelPage,tabDescription,tabActionsLast,tabActionsNew,tabConclusion,tabConclusion"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Service:" style="text-decoration:underline;color:red;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sélectionnez le service" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesServicesItems}"/>
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.chargerUserService}" reRender="panelContact"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Président de séance:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idPresident">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_president}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans président" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesPresidentsItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Secrétaire:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idSecretaire">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_secretaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans secrétaire" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesSecretairesItem}" />
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
                                            <f:selectItem itemLabel="Normale" itemValue="0"/>
                                            <f:selectItem itemLabel="Journalière" itemValue="1"/>
                                            <f:selectItem itemLabel="Hebdomadaire" itemValue="2"/>
                                            <f:selectItem itemLabel="Mensuelle" itemValue="3"/>
                                            <f:selectItem itemLabel="Trimestrielle" itemValue="4"/>
                                            <f:selectItem itemLabel="Semestrielle" itemValue="5"/>
                                            <f:selectItem itemLabel="Annuelle" itemValue="6"/>
                                            <f:selectItem itemLabel="Exceptionnelle" itemValue="7"/>
                                        </h:selectOneMenu>&nbsp;&nbsp;
                                        <h:selectOneMenu style="width:45%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuMethode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
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
                                        <h:selectOneMenu style="width:100%;color:red;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuActivite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans activité spécifique" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.mesActivitesItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Lieu:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuLieu}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" maxlength="100"/></h:column>
                                    <h:column><h:outputText value="Heure début:" /></h:column>
                                    <h:column>
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
                                    <h:column><h:outputText value="Heure fin:" /></h:column>
                                    <h:column>
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
                                </h:panelGrid>
                            </h:panelGrid>
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuIntroduction}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Convocations/Présences/Absences" id="tabPresence" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp" />
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.verifPresenceConvocation}" reRender="tablePresence"/>
                        <h:panelGroup id="tablePresence">
                            <h:column><h:outputText value="Modèle impression convocation:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuModeleImp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.documentConvocationImpressionItems}" />
                                </h:selectOneMenu>
                            </h:column>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauPresence" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelPresence}" var="present">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick"   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectPresence}"/>
                                    <rich:column sortable="true" sortBy="#{present.reupreNomUser} #{present.reuprePrenomUser}" sortOrder="ASCENDING" width="30%">
                                        <f:facet name="header" ><h:outputText value="Utilisateur"/></f:facet>
                                        <h:outputText value="#{present.reupreNomUser} #{present.reuprePrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Sans statut"/></f:facet>
                                        <h:selectBooleanCheckbox id="p1" value="#{present.reupreSansStatut}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.presenceNonStatut}" reRender="p1,p2,p3,p4,p5"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Convoquer"/></f:facet>
                                        <h:selectBooleanCheckbox id="p2" value="#{present.reupreConvoquer}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.presenceConvoquer}" reRender="p1,p2,p3,p4,p5"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Absent autorisé"/></f:facet>
                                        <h:selectBooleanCheckbox id="p3" value="#{present.reupreAbsentAutorise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.presenceAbsentAuto}" reRender="p1,p2,p3,p4,p5"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Absent interdit"/></f:facet>
                                        <h:selectBooleanCheckbox id="p4" value="#{present.reupreAbsentInterdit}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.presenceAbsentInter}" reRender="p1,p2,p3,p4,p5"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Présent"/></f:facet>
                                        <h:selectBooleanCheckbox id="p5" value="#{present.reuprePresent}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.presencePresent}" reRender="p1,p2,p3,p4,p5"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{present.reupreMotif}"  width="30%">
                                        <f:facet name="header" ><h:outputText value="Motif"/></f:facet>
                                        <h:inputText value="#{present.reupreMotif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="P.V. Assemblée" id="tabDescription" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuContenu}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </rich:tab>

                    <rich:tab label="Actions antérieures" style="color:red;" id="tabActionsLast" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp"/>
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

                    <rich:tab label="Nouvelles actions" id="tabActionsNew" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp" />
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

                    <rich:tab label="Conclusion" id="tabConclusion" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp" />
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

                    <rich:tab label="Etat" id="tabEtat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuEtat!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommun.jsp" />
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
                        <h:outputText  id="outptpanelTiers" style="color:red;" value="la date et l'objet sont obligatoires" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_valide_doc}"/>
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


</f:subview>
