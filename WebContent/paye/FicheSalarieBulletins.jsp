<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid style="width:100%;" id="panBulletin">

    <a4j:form >
        <h:panelGrid style="width:100%;" id="idBulletin">
            <h:panelGroup>
                <center>
                    <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impressionBulletin}" reRender="panelImpBulletin,formModalImp,panchoixdoc,panelMail"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Modifier bulletin" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinSalaire.bulsalEtatBulletin==false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinMois.bulmenEtat<=2&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPayeBulletin==0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.modificationBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idBulletin,table,idValideModif"/>
                </center>
            </h:panelGroup>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.dataModelBulletinsLigne}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 0px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.selectionLigneBulletin}"/>
                    <rich:column  width="10%" sortable="false">
                        <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                        <h:outputText value= "#{plan.bulligNature} : #{plan.libNature}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="8%" sortable="true" sortBy="#{plan.bulligRubrique}" sortOrder="ASCENDING" >
                        <f:facet name="header"><h:outputText value="Code" /></f:facet>
                        <h:outputText value="#{plan.bulligRubrique}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="24%" sortable="false" >
                        <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                        <h:outputText value="#{plan.bulligLibelle}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                        <h:inputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                        <h:outputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                        <h:inputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="8%" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                        <h:inputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                        <h:outputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="8%" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                        <h:inputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}"/>
                        <h:outputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}"/>
                    </rich:column>
                    <rich:column width="10%" sortable="false" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                        <h:inputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE&&plan.bulligNature!=59&&plan.bulligNature!=69&&plan.bulligNature!=89&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}" style="#{plan.espaceFamille}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                        <h:outputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==false}" style="#{plan.espaceFamille}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column width="12%" sortable="false" >
                        <f:facet name="header"><h:outputText value="Commentaire"/></f:facet>
                        <h:inputText value="#{plan.bulligObservation}" style="#{plan.espaceFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinMois.bulmenEtat>=3}">
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.modificationLigne}"/>
                        </h:inputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <h:panelGroup id="idValideModif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.var_correction==true}">
                <center>
                    <a4j:commandButton id="idValVariable" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.validationModificationBulletin}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idBulletin,table,idValideModif"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValVariable')}.click()" />
                </center>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" id="panelImpBulletin" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelPrintBulletin}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.showModalPanelPrintBulletin}" var="prtbul">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanPrintBulletin" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImpBulletin,tableBulletins"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanPrintBulletin')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="formModalImp" target="_blank">
                    <center>
                        <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                        <br><br>
                    </center>
                    <h:panelGrid  width="100%">
                        <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                            <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                            <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.nomModeleDocument}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.bulletinImpressionItems}"/>
                            </h:selectOneMenu>
                            <br>
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.etat_init}" >
                                <f:selectItem itemLabel="Sans les charges patronales" itemValue="0"/>
                                <f:selectItem itemLabel="Avec les charges patronales" itemValue="1"/>
                                <f:selectItem itemLabel="Modèle Archive" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                        <h:panelGrid id="panCertification" width="100%" columns="2" style="border:solid 1px green;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif!=0}">
                            <f:facet name="header"><h:outputText value="Certification document"/></f:facet>
                            <h:outputText value="La certification des doucments permet de générer un cachet électronique, certifié par l'Agence UniverSign. Ce cachet életronique est reconnu par tous les tribunaux."/>
                            <h:graphicImage value="/images/logo_universign.png"title="UniverSign"/>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.afficheUniverSign}">
                                <h:outputText value="Voulez-vous activer la certification pour le document en cours?"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:selectBooleanCheckbox title="Activer la certification" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.certification}"/>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.afficheUniverSign}">
                                <h:outputText value="Votre certification n'est pas active. Pour l'activer, veuillez vous rapprocher des équipes d'HORUS SOLUTIONS ou de SENTRUST."/>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="border:solid 0px green;background-color:white;">
                            <f:facet name="header"><h:outputText value="Format"/></f:facet>
                            <br>
                            <h:panelGrid  width="100%" columns="9" style="height:80px">
                                <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.imprimanteReseau}">
                                    <center>
                                        <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes du serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                        <h:selectOneMenu id="impSelect1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.monImprimante}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.mesImprimantesServeurItems}"/>
                                        </h:selectOneMenu>
                                    </center>
                                </h:panelGroup>
                                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerBulletinXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}"/>
                                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.envoieBulletinMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                            </h:panelGrid>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.affMail}">
                            <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impEmetteur}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.lesbalEmetteursItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataire}" >
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.utilPrint.lesbalDestinatairesItems}"/>
                                        <f:selectItem itemLabel="" itemValue="" />
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column></h:column>
                                <h:column></h:column>
                                <h:column><h:outputText value="Copie à (CC):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataireCC}"/></h:column>
                                <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.impDestinataireCCI}"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid  width="100%" style="text-align:center;">
                                <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

</h:panelGrid>

