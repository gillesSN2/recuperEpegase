<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="reunioncommercialefiche">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="GESTION DE LA REUNION COMMERCIALE" style="color:green;"/></h2></center>

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
                                    <h:column><h:outputText value="Responsable de séance:" style="text-decoration:underline;"/></h:column>
                                    <h:column id="idPresident">
                                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_president}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <f:selectItem itemLabel="Sans responsable" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.mesPresidentsItem}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Période du:"/></h:column>
                                    <h:column>
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateDebut}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}"/>&nbsp;&nbsp;
                                        <h:outputText value="au:"/>&nbsp;
                                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuDateFin}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}"/>
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
                                            <f:selectItem itemLabel="Compte rendu Commercial" itemValue="10"/>
                                            <f:selectItem itemLabel="Réunion production" itemValue="11"/>
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

                    <rich:tab label="Agents commerciaux" id="tabPresence" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp" />
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
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectPresence}"/>
                                    <rich:column sortable="true" sortBy="#{present.reupreNomUser} #{present.reuprePrenomUser}" sortOrder="ASCENDING" width="40%">
                                        <f:facet name="header" ><h:outputText value="Utilisateur"/></f:facet>
                                        <h:outputText value="#{present.reupreNomUser} #{present.reuprePrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="false"  width="10%" style="text-align:center">
                                        <f:facet name="header" ><h:outputText value="Présent"/></f:facet>
                                        <h:selectBooleanCheckbox id="p5" value="#{present.reuprePresent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                            <a4j:support eventsQueue="maQeue2" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectionAgent}" reRender="tableauAnalyse"/>
                                        </h:selectBooleanCheckbox>
                                    </rich:column>
                                    <rich:column sortable="true" sortBy="#{present.reupreMotif}"  width="50%">
                                        <f:facet name="header" ><h:outputText value="Observations"/></f:facet>
                                        <h:inputText value="#{present.reupreMotif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}" style="width:90%"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Analyses" id="tabAnalyse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp" />
                        <h:panelGroup id="tableAnalyse">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauAnalyse" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelActifs}" var="analyse">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectActif}"/>
                                    <rich:column sortable="true" sortBy="#{analyse.reupreNomUser} #{analyse.reuprePrenomUser}" sortOrder="ASCENDING" width="30%">
                                        <f:facet name="header" ><h:outputText value="Utilisateur"/></f:facet>
                                        <h:outputText value="#{analyse.reupreNomUser} #{analyse.reuprePrenomUser}"/>
                                    </rich:column>
                                    <rich:column sortable="true" width="8%">
                                        <f:facet name="header"><h:outputText value="Ventes"/></f:facet>
                                        <a4j:commandButton value="Ventes" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.analyseVente}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelVentes"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Ca Dvs."/></f:facet>
                                        <h:outputText value="#{analyse.reupreCaDevis}" rendered="#{analyse.reupreCaDevis!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Ca BC."/></f:facet>
                                        <h:outputText value="#{analyse.reupreCaBc}" rendered="#{analyse.reupreCaBc!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Ca BL."/></f:facet>
                                        <h:outputText value="#{analyse.reupreCaBl}" rendered="#{analyse.reupreCaBl!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Ca Fac."/></f:facet>
                                        <h:outputText value="#{analyse.reupreCaFa}" rendered="#{analyse.reupreCaFa!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="false" width="10%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Ca Ndb."/></f:facet>
                                        <h:outputText value="#{analyse.reupreCaNd}" rendered="#{analyse.reupreCaNd!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column sortable="true" width="5%">
                                        <f:facet name="header"><h:outputText value="Rdv"/></f:facet>
                                        <a4j:commandButton value="RDV." action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.analyseRdv}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelRdv"/>
                                    </rich:column>
                                    <rich:column sortable="false" width="7%" style="text-align:right;">
                                        <f:facet name="header" ><h:outputText value="Nb."/></f:facet>
                                        <h:outputText value="#{analyse.reupreNbRdv}" rendered="#{analyse.reupreNbRdv!=0}" style="text-align:right;">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGroup>
                    </rich:tab>

                    <rich:tab label="Actions antérieures" style="color:red;" id="tabActionsLast" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp"/>
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

                    <rich:tab label="Nouvelles actions" id="tabActionsNew" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp" />
                        <center>
                            <h:panelGroup id="boutonActionNew" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.var_aff_action}">
                                <a4j:commandButton title="Ajouter action" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.ajoutAction}" reRender="panelActionNew" />&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Modifier action" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.modifAction}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.afficheButtonActionNew}" reRender="panelActionNew"/>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Supprimer action" image="/images/supprimer.png"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.afficheButtonActionNew}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.deleteAction}" reRender="boutonActionNew,tableauActionNew"/>
                            </h:panelGroup>
                        </center>
                        <h:panelGroup id="tableActionNew">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable width="100%" border="0"  height="300px" id="tableauActionNew" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelActionNew}" var="actNew">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.selectActionNew}" reRender="boutonActionNew"/>
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

                    <rich:tab label="Conclusion" id="tabConclusion" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.reunionEntete.reuId!=0}">
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp" />
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
                        <jsp:include flush="true" page="/office/ReunionCommercialeCommun.jsp" />
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


                
    <rich:modalPanel domElementAttachment="parent"  id="panelVentes" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="700" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelVente}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelVente}">
            <f:facet name="header"><h:outputText value="ANALYSE DES VENTES : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nomAgentAnalyse}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.fermerVente}" image="/images/close.gif" styleClass="hidelink" reRender="panelVentes"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalVentes">
                <rich:tabPanel switchType="client" immediate="true" style="border:0px;background-color:white;">

                    <rich:tab label="Devis">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueDevis}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="tableDevis"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableDevis" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesDevis}" var="dvs">
                                    <rich:column label="N° devis" sortable="true" sortBy="#{dvs.dvsNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{dvs.dvsNum}"/>
                                    </rich:column>
                                    <rich:column label="Date devis" sortable="true" sortBy="#{dvs.dvsDate} #{dvs.dvsNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{dvs.dvsDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{dvs.dvsSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{dvs.dvsSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{dvs.dvsCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{dvs.dvsCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{dvs.dvsEtat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{dvs.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{dvs.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{dvs.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{dvs.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{dvs.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{dvs.dvsTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{dvs.dvsTotHt}" rendered="#{dvs.dvsTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{dvs.dvsTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsTotTva}" rendered="#{dvs.dvsTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{dvs.dvsTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsTotTtc}" rendered="#{dvs.dvsTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{dvs.dvsActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{dvs.dvsActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet du devis" sortable="true" sortBy="#{dvs.dvsObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{dvs.dvsSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsSource}"/>
                                    </rich:column>
                                    <rich:column label="Echéance" sortable="true" sortBy="#{dvs.dvsDateEcheReg}" width="70px" >
                                        <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                                        <h:outputText  value="#{dvs.dvsDateEcheReg}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{dvs.dvsNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{dvs.dvsNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{dvs.dvsNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Commandes">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueCommande}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20"align="left" for="tableCommande"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableCommande" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesCommandes}" var="bcm">
                                    <rich:column label="N° commande" sortable="true" sortBy="#{bcm.bcmNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{bcm.bcmNum}"/>
                                    </rich:column>
                                    <rich:column label="Date commande" sortable="true" sortBy="#{bcm.bcmDate} #{bcm.bcmNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{bcm.bcmDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{bcm.bcmSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{bcm.bcmSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{bcm.bcmCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{bcm.bcmCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{bcm.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{bcm.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{bcm.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{bcm.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{bcm.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{bcm.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{bcm.bcmTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{bcm.bcmTotHt}" rendered="#{bcm.bcmTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{bcm.bcmTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmTotTva}" rendered="#{bcm.bcmTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{bcm.bcmTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmTotTtc}" rendered="#{bcm.bcmTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{bcm.bcmActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{bcm.bcmActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet du commande" sortable="true" sortBy="#{bcm.bcmObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{bcm.bcmSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmSource}"/>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{bcm.bcmNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{bcm.bcmNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{bcm.bcmNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Livraisons">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueLivraison}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20"align="left" for="tableLivraison"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableLivraison" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesLivraison}" var="blv">
                                    <rich:column label="N° livraison" sortable="true" sortBy="#{blv.blvNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{blv.blvNum}"/>
                                    </rich:column>
                                    <rich:column label="Date BL" sortable="true" sortBy="#{blv.blvDate} #{blv.blvNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{blv.blvDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{blv.blvSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{blv.blvSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{blv.blvCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{blv.blvCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{blv.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{blv.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{blv.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{blv.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{blv.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{blv.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{blv.blvTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{blv.blvTotHt}" rendered="#{blv.blvTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{blv.blvTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{blv.blvTotTva}" rendered="#{blv.blvTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{blv.blvTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{blv.blvTotTtc}" rendered="#{blv.blvTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{blv.blvActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{blv.blvActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet livraison" sortable="true" sortBy="#{blv.blvObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{blv.blvObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{blv.blvSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{blv.blvSource}"/>
                                    </rich:column>
                                    <rich:column label="Echéance" sortable="true" sortBy="#{blv.blvDateEcheReg}" width="70px" >
                                        <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                                        <h:outputText  value="#{blv.blvDateEcheReg}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{blv.blvNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{blv.blvNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{blv.blvNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{blv.blvNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Retours">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueRetour}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable4" maxPages="20"align="left" for="tableRetour"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableRetour" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesRetours}" var="brt">
                                    <rich:column label="N° retour" sortable="true" sortBy="#{brt.brtNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{brt.brtNum}"/>
                                    </rich:column>
                                    <rich:column label="Date Retour" sortable="true" sortBy="#{brt.facDate} #{brt.facNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{brt.brtDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{brt.brtSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{brt.brtSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{brt.facCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{brt.brtCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{brt.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{brt.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{brt.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{brt.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{brt.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{brt.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{brt.brtTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{brt.brtTotHt}" rendered="#{brt.brtTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{brt.brtTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{brt.brtTotTva}" rendered="#{brt.brtTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{brt.brtTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{brt.brtTotTtc}" rendered="#{brt.brtTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{brt.brtActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{brt.brtActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet retour" sortable="true" sortBy="#{brt.brtObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{brt.brtObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{brt.brtSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{brt.brtSource}"/>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{brt.brtNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{brt.brtNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{brt.brtNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{brt.brtNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Factures">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueFacture}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable5" maxPages="20"align="left" for="tableFacture"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableFacture" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesFactures}" var="fac">
                                    <rich:column label="N° facture" sortable="true" sortBy="#{fac.facNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{fac.facNum}"/>
                                    </rich:column>
                                    <rich:column label="Date Facture" sortable="true" sortBy="#{fac.facDate} #{fac.facNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{fac.facDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{fac.facSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{fac.facSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{fac.facCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{fac.facCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{fac.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{fac.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{fac.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{fac.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{fac.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{fac.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{fac.facTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{fac.facTotHt}" rendered="#{fac.facTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{fac.facTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{fac.facTotTva}" rendered="#{fac.facTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{fac.facTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{fac.facTotTtc}" rendered="#{fac.facTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{fac.facActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{fac.facActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet facture" sortable="true" sortBy="#{fac.facObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{fac.facObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{fac.facSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{fac.facSource}"/>
                                    </rich:column>
                                    <rich:column label="Echéance" sortable="true" sortBy="#{fac.facDateEcheReg}" width="70px" >
                                        <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                                        <h:outputText  value="#{fac.facDateEcheReg}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{fac.facNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{fac.facNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{fac.facNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{fac.facNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Notes Débit">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueNoteDebit}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable6" maxPages="20"align="left" for="tableNdb"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableNdb" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelLesNdb}" var="ndb">
                                    <rich:column label="N° Note de débit" sortable="true" sortBy="#{ndb.ndbNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{ndb.ndbNum}"/>
                                    </rich:column>
                                    <rich:column label="Date Note de débit" sortable="true" sortBy="#{ndb.ndbDate} #{ndb.ndbNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{ndb.ndbDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{ndb.ndbSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{ndb.ndbSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{ndb.ndbCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{ndb.ndbCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{ndb.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{ndb.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{ndb.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{ndb.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{ndb.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{ndb.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{ndb.ndbTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotHt}" rendered="#{ndb.ndbTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{ndb.ndbTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotTva}" rendered="#{ndb.ndbTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{ndb.ndbTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotTtc}" rendered="#{ndb.ndbTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{ndb.ndbActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{ndb.ndbActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet note debit" sortable="true" sortBy="#{ndb.ndbObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{ndb.ndbSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbSource}"/>
                                    </rich:column>
                                    <rich:column label="Echéance" sortable="true" sortBy="#{ndb.ndbDateEcheReg}" width="70px" >
                                        <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                                        <h:outputText  value="#{ndb.ndbDateEcheReg}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{ndb.ndbNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{ndb.ndbNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{ndb.ndbNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                    <rich:tab label="Avoirs">
                        <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.statistiqueAvoir}" reRender="idTotal"/>
                        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable7" maxPages="20"align="left" for="tableAvoir"/>
                                <rich:extendedDataTable rows="100" width="170%" border="0"  height="450px" id="tableAvoir" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelesAvoirs}" var="avr">
                                    <rich:column label="N° avoir" sortable="true" sortBy="#{avr.avrNum}">
                                        <f:facet name="header"><h:outputText  value="N°"/></f:facet>
                                        <h:outputText value="#{avr.avrNum}"/>
                                    </rich:column>
                                    <rich:column label="Date Avoir" sortable="true" sortBy="#{avr.avrDate} #{avr.avrNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{avr.avrDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{avr.avrSerie}" width="40px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{avr.avrSerie}"/>
                                    </rich:column>
                                    <rich:column label="Catégorie client" sortable="true" sortBy="#{avr.avrCat}" width="70px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                                        <h:outputText value="#{avr.avrCat}"/>
                                    </rich:column>
                                    <rich:column id="idEtat" title="Etat" sortable="true" sortBy="#{avr.Etat}" width="50px" style="text-align:center;">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{avr.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Client" sortable="true" sortBy="#{avr.var_nom_tiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Client"/></f:facet>
                                        <h:outputText  value="#{avr.var_nom_tiers}"/>
                                    </rich:column>
                                    <rich:column label="Contact ou Destinataire" sortable="true" sortBy="#{avr.var_nomContact}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Cont./Destin."/></f:facet>
                                        <h:outputText  value="#{avr.var_nomContact}"/>
                                    </rich:column>
                                    <rich:column label="Montant H.T." sortable="true" sortBy="#{avr.avrTotHt}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="H.T."/></f:facet>
                                        <h:outputText  value="#{avr.avrTotHt}" rendered="#{avr.avrTotHt!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant des taxes" sortable="true" sortBy="#{avr.avrTotTva}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="Taxes"/></f:facet>
                                        <h:outputText  value="#{avr.avrTotTva}" rendered="#{avr.avrTotTva!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{avr.avrTotTtc}" style="text-align:right;">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{avr.avrTotTtc}" rendered="#{avr.avrTotTtc!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Activité commerciale" sortable="true" sortBy="#{avr.avrActivite}" >
                                        <f:facet name="header"><h:outputText value="Act."/></f:facet>
                                        <h:outputText  value="#{avr.avrActivite}"/>
                                    </rich:column>
                                    <rich:column label="Objet avoir" sortable="true" sortBy="#{avr.avrObject}" width="200px">
                                        <f:facet name="header"><h:outputText value="Objet"/></f:facet>
                                        <h:outputText  value="#{avr.avrObject}"/>
                                    </rich:column>
                                    <rich:column label="Source" sortable="true" sortBy="#{avr.avrSource}" width="150px">
                                        <f:facet name="header"><h:outputText value="Source"/></f:facet>
                                        <h:outputText  value="#{avr.avrSource}"/>
                                    </rich:column>
                                    <rich:column label="Echéance" sortable="true" sortBy="#{avr.avrDateEcheReg}" width="70px" >
                                        <f:facet name="header"><h:outputText value="Eché."/></f:facet>
                                        <h:outputText  value="#{avr.avrDateEcheReg}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Responsable" sortable="true" sortBy="#{avr.avrNomResponsable}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Respponsable"  /></f:facet>
                                        <h:outputText  value="#{avr.avrNomResponsable}"/>
                                    </rich:column>
                                    <rich:column label="Commercial" sortable="true" sortBy="#{avr.avrNomCommercial}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Commercial"/></f:facet>
                                        <h:outputText  value="#{avr.avrNomCommercial}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <h:panelGrid id="idTotal" width="100%" columns="6" style="text-align:right;" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Total C.A. H.T."/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.caHt}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Objectifs"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.objectifHt}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Ecart"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.ecartHt}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nb document(s)"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nbDoc}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="C.A. Moyen"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.caMoyen}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Sans source"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.sansSources}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Total C.A. Transformé"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.caTrf}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nb document(s) transformé(s)"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nbTrf}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Taux transformation"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.tauxTrf}" readonly="true" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Total Nb jour(s)"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nbJour}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Total C.A. jour"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.caJour}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Taux jour"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.tauxJour}" readonly="true" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Total nb client(s)"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nbClients}" readonly="true" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Total C.A. client"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.clientMoyen}" readonly="true" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Taux client"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.tauxClient}" readonly="true" style="text-align:right;">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelRdv" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="700" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.showModalPanelRdv}">
            <f:facet name="header"><h:outputText value="ANALYSE DES RDV : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.nomAgentAnalyse}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.fermerRdv}" image="/images/close.gif" styleClass="hidelink" reRender="panelRdv"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalRdv">
                <h:panelGrid width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable10" maxPages="20"align="left" for="tableRdv4"/>
                        <rich:extendedDataTable rows="100" enableContextMenu="false" styleClass="bg" id="tableRdv4" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="450px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModeLesRdv}" var="rdv" >
                            <rich:column width="6%" sortable="true" sortBy="#{rdv.libNature}">
                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                <h:outputText value="#{rdv.libNature}"/>
                            </rich:column>
                            <rich:column width="2%" sortable="true" sortBy="#{rdv.libNature}">
                                <f:facet name="header" ><h:outputText value="Et."/></f:facet>
                                <h:graphicImage alt="Traité" height="10" width="10" value="/images/valider.png" rendered="#{rdv.rdvEtat==1}" style="text-align:center"/>
                                <h:graphicImage alt="Reporté" height="13" width="13" value="/images/transferer.png" rendered="#{rdv.rdvEtat==2}" style="text-align:center"/>
                                <h:graphicImage alt="Annulé" height="10" width="10" value="/images/annuler.gif" rendered="#{rdv.rdvEtat==3}" style="text-align:center"/>
                            </rich:column>
                            <rich:column id="idDate" width="7%" sortable="true" sortBy="#{rdv.rdvDteDe}">
                                <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                <h:outputText value="#{rdv.rdvDteDe}" style="#{rdv.color}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column width="5%" sortable="true" sortBy="#{rdv.rdvHrDe} #{rdv.rdvMnDe}">
                                <f:facet name="header" ><h:outputText value="HH:MM"/></f:facet>
                                <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column width="20%" sortable="true" sortBy="#{rdv.nomTiers}" >
                                <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                                <h:outputText value="#{rdv.nomTiers}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column width="10%" sortable="true" sortBy="#{rdv.rdvTache}" >
                                <f:facet name="header" ><h:outputText value="Tache"/></f:facet>
                                <h:outputText value="#{rdv.rdvTache}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column width="30%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                                <f:facet name="header" ><h:outputText value="Sujet"/></f:facet>
                                <h:outputText value="#{rdv.rdvSujet}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column width="20%" sortable="true"  sortBy="#{rdv.rdvSujet}">
                                <f:facet name="header" ><h:outputText value="Statut"/></f:facet>
                                <h:outputText value="#{rdv.libEtat}  #{rdv.rdvCr}" style="#{rdv.color}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGrid width="100%" styleClass="fichefournisseur">
                    <rich:extendedDataTable  enableContextMenu="false" styleClass="bg" id="tableRapportRdv" footerClass="bard" headerClass="headerTab" noDataLabel=" " border="0" width="100%" height="150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formReunion.dataModelRaportRdv}" var="rap" >
                        <rich:column width="40%" sortable="false">
                            <f:facet name="header" ><h:outputText value="Nature des éléments"/></f:facet>
                            <h:outputText value="#{rap.rdvLibNature}" style="#{rap.color}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Non fait"/></f:facet>
                            <h:outputText value="#{rap.nbNonFait}" style="text-align:right;#{rap.color}" rendered="#{rap.nbNonFait!=0}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Traité"/></f:facet>
                            <h:outputText value="#{rap.nbFait}" style="text-align:right;#{rap.color}" rendered="#{rap.nbFait!=0}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Reporté"/></f:facet>
                            <h:outputText value="#{rap.nbReporte}" style="text-align:right;#{rap.color}" rendered="#{rap.nbReporte!=0}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Annulé"/></f:facet>
                            <h:outputText value="#{rap.nbAnnule}" style="text-align:right;#{rap.color}" rendered="#{rap.nbAnnule!=0}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="Total"/></f:facet>
                            <h:outputText value="#{rap.nbRdv}" style="text-align:right;#{rap.color}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header" ><h:outputText value="%Réussite"/></f:facet>
                            <h:outputText value="#{rap.tauxSucces}" style="text-align:right;#{rap.color}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>

            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
