<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ficheresultat">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DES RESULTATS DES EXAMENS" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab id="tabresultat" label="Résultat">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />

                    <h:panelGrid id="idPanResultat" width="100%" styleClass="fichefournisseur">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==1}" var="varnumerique">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                                <h:column><h:outputText value="Valeur mesurée:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresNumerique}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                <h:column><h:outputText value="Unité usuelle:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresUnite}" readonly="true"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCoef!=0}"><h:outputText value="Coefficient de convertion:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCoef!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCoef}" readonly="true" style="text-align:right"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCoef!=0}"><h:outputText value="Unité convertie:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCoef!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresUniteConvertie}" style="text-align:right"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMin!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMax!=0}"><h:outputText value="Fourchette:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMin!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMax!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchette}" readonly="true" style="text-align:right"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMin!=0}"><h:outputText value="Fourchette nimimale:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMin!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMin}" readonly="true" style="text-align:right">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMax!=0}"><h:outputText value="Fourchette maximale:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMax!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresFourchetteMax}" readonly="true" style="text-align:right">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==2}" var="vardate">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                                <h:column><h:outputText value="Date:"/></h:column>
                                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresDate}" inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==3}" var="varphoto">
                            <h:panelGrid width="100%">
                                <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresImage==null}">
                                        <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedFile}"/>
                                        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}">
                                            <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                                        </h:commandButton>
                                        <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                                    </h:panelGroup>
                                    <br/>
                                    <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresImage!=null}">
                                            <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlphotoProd}" width="300px" height="300px"/>&nbsp;
                                            <h:commandButton image="/images/annuler.gif"title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}"/>
                                        </c:if>
                                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresImage==null}">
                                            <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                        </c:if>
                                    </h:panelGroup>
                                </h:panelGrid>
                                <h:panelGrid id="panPdf" columns="2" style="height:170px" width="100%" styleClass="top" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText value="PDF"/></f:facet>
                                    <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affFicPdf}">
                                        <t:inputFileUpload id="filePdf"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedPDFFile}"/>
                                        <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}">
                                            <a4j:support eventsQueue="maQueue"  immediate="true"/>
                                        </h:commandButton>
                                        <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                                    </h:panelGroup>
                                    <br/>
                                    <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affFicPdf}">
                                        <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresPdf}" />&nbsp;&nbsp;&nbsp;
                                        <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                                        <h:commandButton image="/images/annuler.gif"title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}"/>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==4}" var="vartexte">
                            <h:panelGrid width="100%" >
                                <h:outputText value="Texte:" />
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==5}" var="varrepUnique">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                                <h:outputText value="Choix de la réponse:" />
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresReponseUnique}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesReponsesItems}"/>
                                </h:selectOneMenu>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==6}" var="varrepUniqueAction">
                            <h:panelGrid id="idPanRepAction" width="100%"  columns="2" columnClasses="clos30,clos70">
                                <h:outputText value="Choix de la réponse:" />
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresReponseAction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                    <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesReponsesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculAction}" reRender="idPanRepAction"/>
                                </h:selectOneMenu>
                                <h:outputText value="Choix de l'action:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.listeAction}"/>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresAction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.listeAction}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesActionsItems}"/>
                                </h:selectOneMenu>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepActionNumerique}">
                                    <h:column><h:outputText value="Valeur mesurée:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresNumerique}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                    <h:column><h:outputText value="Unité usuelle:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresUnite}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepActionTexte}">
                                    <h:column><h:outputText value="Réponse:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresTexte}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepTexteModifiable!=null}">
                                    <h:column><h:outputText value="Onservation:"/></h:column>
                                    <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresReponseMultiple}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                </c:if>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==7}" var="varrepMultiple">
                            <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                                <h:outputText value="Choix des réponses:" />
                                <a4j:region renderRegionOnly="false" id="region1">
                                    <rich:extendedDataTable styleClass="bg" id="tableReponse" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelLesReponses}" var="rep">
                                        <rich:column label="Selection" sortable="false" width="5%">
                                            <h:selectBooleanCheckbox value="#{rep.rep_select}" style="text-align:center" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/>
                                        </rich:column>
                                        <rich:column label="Réponse" sortable="false" width="90%">
                                            <h:outputText value="#{rep.prorepReponse}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                                <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                                <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==8}" var="varlisteDetail">
                            <h:panelGrid width="100%">
                                <a4j:region renderRegionOnly="false" id="region2">
                                    <rich:extendedDataTable styleClass="bg" id="tableDetail" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelDetailExamens}" var="exadet">
                                        <a4j:support id="idSellig" eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectLigneDetail}"/>
                                        <rich:column id="idCol00"  label="Ordre" sortable="true" width="5%" sortBy="#{exadet.labresOrdre}">
                                            <f:facet name="header"><h:outputText value="Or."/></f:facet>
                                            <h:outputText value="#{exadet.labresOrdre}" style="#{exadet.espaceFamille}"/>
                                        </rich:column>
                                        <rich:column id="idCol0" label="Modifier" sortable="true" width="5%" style="text-align:center" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action!='3'}">
                                            <f:facet name="header"><h:outputText  value="Ouvert."/></f:facet>
                                            <a4j:commandButton id="idbutcmd" rendered="#{exadet.labresType!='0'}" immediate="true" title="Modifier ligne sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.modifResultatDetail}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelExamenDetail" style="width:18px;height:18px;"/>
                                        </rich:column>
                                        <rich:column id="idCol1" label="Libellé" sortable="true" width="30%">
                                            <f:facet name="header"><h:outputText value="Libellé"/></f:facet>
                                            <h:outputText value="#{exadet.labresLibelle}" style="#{exadet.espaceFamille}"/>
                                        </rich:column>
                                        <rich:column id="idCol2" label="Type" sortable="true" width="10%">
                                            <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                            <h:outputText value="#{exadet.libelle_type}" style="#{exadet.espaceFamille}"/>
                                        </rich:column>
                                        <rich:column id="idCol3" label="Résultat" sortable="true" width="55%">
                                            <f:facet name="header"><h:outputText value="Résultat"/></f:facet>
                                            <h:outputText value="#{exadet.resultat}" style="#{exadet.espaceFamille}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsLaboratoire.prolabType==10}" var="vartexte">
                            <h:panelGrid width="100%" >
                                <h:outputText value="Texte:" />
                                <h:inputText style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireResultat.labresTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/>
                            </h:panelGrid>
                        </c:if>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabcommentaire" label="Commentaires sur l`examen">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:outputText value="Commentaire sur cette analyse:" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligCommentaire}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabhistorique" label="Historique">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />
                    <h:panelGrid width="100%">
                        <rich:extendedDataTable styleClass="bg" id="table" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesResulatsHistoriques}" var="rsh">
                            <rich:column label="Numéro laboratoire" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText value="N°"/></f:facet>
                                <h:outputText value="#{rsh.labresNum}"/>
                            </rich:column>
                            <rich:column label="Date analyse effectuée" sortable="false" width="10%" sortBy="#{rsh.laboratoireLigne.labligDateRealisee}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{rsh.laboratoireLigne.labligDateRealisee}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Appareil" sortable="false" width="10%">
                                <f:facet name="header"><h:outputText value="Appareil"/></f:facet>
                                <h:outputText value="#{rsh.laboratoireLigne.labligAppareil}"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="10%" rendered="#{rsh.labresType==1}" style="text-align:right;">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value="#{rsh.labresNumerique}" style="text-align:right;"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="10%" rendered="#{rsh.labresType==2}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText  value="#{rsh.labresDate}" style="text-align:right;">
                                    <f:convertDateTime pattern="dd/MM/yyyy HH:MM" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="40%" rendered="#{rsh.labresType==3}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value="#{rsh.labresPhoto}"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==4}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:inputTextarea rows="3" value="#{rsh.labresTexte}" style="width:100%" readonly="true"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==5}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value="#{rsh.labresReponseUnique}"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==6}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value="#{rsh.labresReponseUnique} #{rsh.labresAction}"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==7}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value="#{rsh.labresReponseMultiple}"/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==8}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:outputText value=""/>
                            </rich:column>
                            <rich:column label="Résultat" sortable="false" width="70%" rendered="#{rsh.labresType==9||rsh.labresType==10}">
                                <f:facet name="header"><h:outputText value="Résultats historiques"/></f:facet>
                                <h:inputText value="#{rsh.labresTexte}" style="width:100%" readonly="true"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabantecedent" label="Antécédent">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />
                    <h:panelGrid width="100%">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableAntecedent" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelAntecedent}" var="antec" >
                                <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.selectionAntecedent}" reRender="btnAntecedent"/>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantCode}" >
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{antec.patantCode}"/>
                                </rich:column>
                                <rich:column  width="30%" sortable="true" sortBy="#{antec.patantFamille}" >
                                    <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                    <h:outputText value="#{antec.patantFamille}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="true" sortBy="#{antec.patantDate}" >
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{antec.patantDate}"/>
                                </rich:column>
                                <rich:column width="5%" sortable="true" sortBy="#{antec.patantEtat}">
                                    <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                    <h:outputText  value="#{antec.patantEtat}"/>
                                </rich:column>
                                <rich:column width="45%" sortable="true" sortBy="#{antec.patantObservation}">
                                    <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                    <h:outputText  value="#{antec.patantObservation}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabscan" label="Scan Résultat">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="Scan du résultat"/></f:facet>
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligScan==null}">
                                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedFile}"/>
                                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajoutScanResultat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}">
                                    <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                                </h:commandButton>
                                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                            </h:panelGroup>
                            <br/>
                            <h:panelGroup  id="grp3">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligScan!=null}">
                                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlphotoResultat}" width="300px" height="300px"/>&nbsp;
                                    <h:panelGrid columns="2" width="150px">
                                        <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce scan ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reInitScanResultat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}"/>
                                    </h:panelGrid>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireLigne.labligScan==null}">
                                    <img alt="" src="images/no_image.jpeg" width="150px" height="150px" />
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabcloture" label="Conclusion" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEtat==4}">
                    <jsp:include flush="true" page="/medical/PaillasseCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid width="100%">
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labCommentaire}" readonly="true">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                        <h:panelGrid  columns="2" style="width:100%;">
                            <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNomResultat}" style="text-align:right" disabled="true"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annuleResultat}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveResultat}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action!='3'}" />
                </center>              
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent" id="panelExamenDetail" width="1000" height="500" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.showModalPanelDetail}" var="fdt">
            <f:facet name="header"><h:outputText value="GESTION DU DETAIL D'UN EXAMEN"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerResultatDetail}" image="/images/close.gif" styleClass="hidelink" reRender="panelExamenDetail"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%" styleClass="fichefournisseur">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==1}" var="varnumerique">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                            <h:column><h:outputText value="Valeur mesurée:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresNumerique}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            <h:column><h:outputText value="Unité usuelle:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresUnite}" readonly="true"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCoef!=0}"><h:outputText value="Coefficient de convertion:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCoef!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCoef}" readonly="true" style="text-align:right"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCoef!=0}"><h:outputText value="Unité convertie:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCoef!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresUniteConvertie}" style="text-align:right"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMin!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMax!=0}"><h:outputText value="Fourchette:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMin!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMax!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchette}" readonly="true" style="text-align:right"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMin!=0}"><h:outputText value="Fourchette nimimale:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMin!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMin}" readonly="true" style="text-align:right"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMax!=0}"><h:outputText value="Fourchette maximale:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMax!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresFourchetteMax}" readonly="true" style="text-align:right"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==2}" var="vardate">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                            <h:column><h:outputText value="Date:"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresDate}" inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==3}" var="varphoto">
                        <h:panelGrid width="100%">
                            <h:panelGrid id="idDetailpanPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresImage==null}">
                                    <t:inputFileUpload id="idDetailfile" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedFile}"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}">
                                        <a4j:support eventsQueue="maQueue"  immediate="true" reRender="idDetailgrp3"/>
                                    </h:commandButton>
                                    <h:message for="idDetailfile" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup  id="idDetailgrp3" style="width:90px;height:90px;" >
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresImage!=null}">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.urlphotoProd}" width="300px" height="300px"/>&nbsp;
                                        <h:commandButton image="/images/annuler.gif"title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresImage==null}">
                                        <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                    </c:if>
                                </h:panelGroup>
                            </h:panelGrid>
                            <h:panelGrid id="idDetailpanPdf" columns="2" style="height:170px" width="100%" styleClass="top" headerClass="headerTab">
                                <f:facet name="header"><h:outputText value="PDF"/></f:facet>
                                <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affFicPdf}">
                                    <t:inputFileUpload id="idDetailfilePdf"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.uploadedPDFFile}"/>
                                    <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}">
                                        <a4j:support eventsQueue="maQueue"  immediate="true"/>
                                    </h:commandButton>
                                    <h:message for="idDetailfilePdf" infoStyle="color: green;" errorStyle="color: red;" />
                                </h:panelGroup>
                                <br/>
                                <h:panelGroup id="idDetailgrp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affFicPdf}">
                                    <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresPdf}" />&nbsp;&nbsp;&nbsp;
                                    <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                                    <h:commandButton image="/images/annuler.gif"title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action==3}"/>
                                </h:panelGroup>
                            </h:panelGrid>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==4}" var="vartexte">
                        <h:panelGrid width="100%" >
                            <h:outputText value="Texte:" />
                            <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                <jsp:include flush="true" page="../css/tdt.jsp"/>
                            </rich:editor>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==5}" var="varrepUnique">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70">
                            <h:outputText value="Choix de la réponse:" />
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresReponseUnique}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesReponsesItemsDetail}"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==6}" var="varrepUniqueAction">
                        <h:panelGrid id="idPanRepAction" width="100%"  columns="2" columnClasses="clos30,clos70">
                            <h:outputText value="Choix de la réponse:" />
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresReponseAction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}">
                                <f:selectItem itemLabel="Sélection réponse" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesReponsesItemsDetail}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculActionDetail}" reRender="idPanRepAction"/>
                            </h:selectOneMenu>
                            <h:outputText value="Choix de l'action:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.listeAction}"/>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresAction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.listeAction}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.lesActionsItems}"/>
                            </h:selectOneMenu>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepActionNumerique}">
                                <h:column><h:outputText value="Valeur mesurée:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresNumerique}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                                <h:column><h:outputText value="Unité usuelle:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresUnite}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepActionTexte}">
                                <h:column><h:outputText value="Réponse:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresTexte}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.produitsReponse.prorepTexteModifiable!=null}">
                                <h:column><h:outputText value="Onservation:"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresReponseMultiple}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                            </c:if>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==7}" var="varrepMultiple">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:outputText value="Choix des réponses:" />
                            <a4j:region renderRegionOnly="false" id="idDetailregion1">
                                <rich:extendedDataTable styleClass="bg" id="idDetailtableReponse" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelLesReponsesDetail}" var="rep">
                                    <rich:column label="Selection" sortable="false" width="5%">
                                        <h:selectBooleanCheckbox value="#{rep.rep_select}" style="text-align:center" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/>
                                    </rich:column>
                                    <rich:column label="Réponse" sortable="false" width="90%">
                                        <h:outputText value="#{rep.prorepReponse}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:panelGrid>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==9||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresType==10}" var="vartexte">
                        <h:panelGrid width="100%" >
                            <h:outputText value="Texte:" />
                            <h:inputText style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/>
                        </h:panelGrid>
                    </c:if>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="2" columnClasses="clos10,clos90">
                    <h:graphicImage url="/images/Warning.png" height="40px" width="40px" alt="Attention"/>
                    <h:column><h:inputTextarea rows="4" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.examenDetailResultat.labresCommentaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_action=='3'}"/></h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup id="buttGrpDetail">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.saveResultatDetail}" reRender="panelExamenDetail,idCol0,idCol1,idCol2,idCol3,tableDetail"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



</f:subview>
