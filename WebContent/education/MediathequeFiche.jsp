<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>


<f:subview id="mediathequeFiche">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="DESCRIPTION D'UN ELEMENT DE LA MEDIATHEQUE" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab id="tabDoc" label="Desciption document">
                    <h:panelGrid id="idPanel1" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Numéro:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedNum}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Code Classement:"/></h:column>
                        <h:column><h:inputText id="idClassement" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedCode}" maxlength="20" readonly="true"/></h:column>
                        <h:column><h:outputText value="Titre:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedTitre}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Sujet:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedCommentaire}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Auteur:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedAuteur}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Editeur:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedEditeur}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Classe:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedClasse}" style="width:100%;">
                                <f:selectItem itemLabel="Sans Classe" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesClasseItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.chargeDivision}" reRender="idPanel1,idClassement,idDivision"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Division:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idDivision" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedDivision}" style="width:100%;">
                                <f:selectItem itemLabel="Sans Division" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesDivisionItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.calculeClassement}" reRender="idPanel1,idClassement"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Support:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport}" style="width:100%;">
                                <f:selectItem itemLabel="Sans Support" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesSupportItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.chargeContenant}" reRender="idPanel1,idContenant,idVisuel,tabExemplaire,panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contenant:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idContenant" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedContenant}" style="width:100%;">
                                <f:selectItem itemLabel="Sans Contenant" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesContenantItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.calculeContenant}" reRender="idVisuel"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedType}" style="width:100%;">
                                <f:selectItem itemLabel="Sans Type" itemValue=""/>
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.mesTypeItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Collection.:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedCollection}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Code I.S.S.N.:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedIssn}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Code I.S.B.N.:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedIsbn}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Genre:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedGenre}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Langue:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedLangue}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDetail" label="Détail document">
                    <h:panelGrid width="100%" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Résumé du document"/></f:facet>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedResume}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                        <h:column>
                            <h:outputText value="Mots clés:"/>&nbsp;&nbsp;
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedMotsCles}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Public visé:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedPublic}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Origine/Source:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedOrigine}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Pays:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedPays}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Informations 1:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedInfo1}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Informations 2:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedInfo2}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Informations 3:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedInfo3}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Informations 4:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedInfo4}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Lieu edition:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedLieuEdition}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Distributeur:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedDistributeur}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Année parution:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedAnneeEdition}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Année Edition:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedAnneeEdition}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Année Promotion:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedAnneePromotion}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Année Soutenance:"/></h:column>
                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedAnneeSoutenance}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabvisu" label="Visualisation document">
                    <h:panelGrid width="100%" id="idVisuel">
                        <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport=='LOC:Local'}">
                            <h:column><h:outputText value="Salle:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSalle}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Casier:"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedCasier}" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        </h:panelGrid>

                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedScan==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.uploadedFile}" accept="application/pdf,image/*"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}">
                                <a4j:support eventsQueue="maQueue" immediate="true" reRender="idVisuel,idAffichage,grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>

                        <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport=='WEB:Internet'}">
                            <h:column><h:outputText value="URL du site:"/></h:column>
                            <h:column>
                                <h:inputText style="width:90%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedadresseInternet}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/>&nbsp;&nbsp;
                                <h:outputLink id="lien" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedadresseInternet}" target="blank" onclick="true" style="text-decoration:none;">
                                    <h:graphicImage url="/images/actualiser.png" style="text-decoration:none;"/>
                                </h:outputLink>
                            </h:column>
                        </h:panelGrid>

                        <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport=='YTB:Youtube'}">
                            <h:column><h:outputText value="URL Youtube:"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedadresseYoutube}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/>
                            </h:column>
                            <a4j:commandButton image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.calculeYoutube}" reRender="idVisuel,idAffichage,idVideoYoutube"/>
                        </h:panelGrid>

                        <h:panelGrid id="idAffichage" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier!=99}">
                            <h:panelGrid id="grp3" width="100%"  style="tex-align:center" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==1}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedScan!=null}">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==0}" var="sc1">
                                        <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.urlphotoProd}" width="100%" height="800px"/>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==1}" var="sc0">
                                        <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.fichierMine}" width="100%" height="550">
                                            <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.fichierUrl}"></a>
                                        </object>
                                    </c:if>
                                    <h:commandButton image="/images/supprimer.png" title="supprimer scan" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.reInitPhoto}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action<3}"/>
                                </c:if>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedScan==null}">
                                    <img alt="" src="images/no_image.jpeg" width="300px" height="300px" />
                                </c:if>
                            </h:panelGrid>

                            <h:panelGrid width="100% "id="idVideoYoutube" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.typeFichier==3}">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.adresseYoutube!=null}" var="video">
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.adresseYoutube}"/>
                                    <iframe width="640" height="360" src="https://www.youtube.com/embed/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.adresseYoutube}" frameborder="0" allowfullscreen></iframe>
                                </c:if>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabExemplaire" label="Exemplaires" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport=='LOC:Local'}">
                    <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedSupport=='LOC:Local'}">
                        <h:column><h:outputText value="Nombre exemplaires:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedNbExemplaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nombre de pages:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedNbPage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Nombre de volumes:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedNbVolume}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                        <h:column><h:outputText value="Durée (si vidéo):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.documentMediatheque.docmedDuree}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.var_action==3}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.annuleDocument}"/>&nbsp;&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.formDocumentMediatheque.saveDocument}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>

</f:subview>
