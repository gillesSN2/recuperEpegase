<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="subdevajout">

    <center>
        <a4j:form>

            <center> <h2><h:outputText value="RECU BON D'ENCAISSEMENT MULTIPLE" style="color:green;"/></h2></center>

            <h:panelGrid styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Nature:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.var_lib_nat} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonSerie})" disabled="true"/></h:column>
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><rich:calendar  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonDate}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                <h:column> <h:outputText value="N° reçu:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonNum}" disabled="true" style="width:40%"/></h:column>
                <h:column><h:outputText value="Devise:"/></h:column>
                <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonDevise}" disabled="true" size="3"/></h:column>
                <h:column><h:outputText value="Nom client:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonNomTiers}" disabled="true"/></h:column>
                <h:column><h:outputText value="Libellé:"/></h:column>
                <h:column><h:inputText style="width:100%"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonLibelle}" disabled="true"/></h:column>
            </h:panelGrid>

            <h:panelGrid id="idReg" style="background-color:white;" width="100%" columns="2" columnClasses="clos50g,clos50g">
                <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos35">
                    <h:column><h:outputText value="Montant à encaisser:"/></h:column>
                    <h:column>
                        <h:inputText id="totht" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_aPayer}" style="width:100%;text-align:center;font-weight:bold;font-size:50px"  disabled="true" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText><br>
                        <h:inputText value="(dont timbre : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_timbre})" style="width:100%;text-align:center;"  disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_timbre!=0}"/>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos35" id="idCaisseSelect">
                    <h:column><h:outputText value="Caisse:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_caisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_verrou_caisse}">
                            <f:selectItem itemLabel="Sélectionner une caisse" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixCaisse}" reRender="prgtpAjt,idReg,imp,imp1,idCaisseSelect,idTypeReg,idEncais,idEncais1,idEncais2,idBanqueSelect"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Type de Règlement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idTypeReg" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_modeReglement}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesModesReglementsItem}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixTypeReglement}" reRender="prgtpAjt,idReg,imp,imp1,idEncais,idEncais1,idEncais2,idBanqueSelect,idCaisseSelect"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Banque:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idBanqueSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inputBanq}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}" style="width:100%;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesBanquesCaissesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.choixBanq}" reRender="idReg"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
            </h:panelGrid>
            <h:panelGrid id="idEncais" style="background-color:white;" width="100%">
                <h:panelGrid id="idEncais1" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Montant reçu:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonEncaisse}" style="width:100%;text-align:center;font-weight:bold;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.calculRendu}" reRender="idEncais1,idRendu" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Montant rendu:"/></h:column>
                    <h:column>
                        <h:inputText id="idRendu" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonRendu}" style="width:100%;text-align:center;font-weight:bold;" disabled="true" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column></h:column>
                    <h:column></h:column>
                    <h:column><h:outputText value="Déposit d'argent ?:" style="color:red"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonGarde}"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="idEncais2" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_affiche_banque}">
                    <h:column><h:outputText value="Banque tireur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonBanqueTireur}" maxlength="50"/></h:column>
                    <h:column><h:outputText value="N° chèque ou bordereau:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonNumChqBdx}" maxlength="50"/></h:column>
                </h:panelGrid>
            </h:panelGrid>

            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.datamodelTransfert}" var="var">
                    <rich:column label="N° facture" sortable="true" sortBy="#{var.facNum}">
                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                        <h:outputText value="#{var.facNum}"/>
                    </rich:column>
                    <rich:column label="Date facture" sortable="true" sortBy="#{var.facDate} #{var.facNum}" width="70px">
                        <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                        <h:outputText value="#{var.facDate}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Série" sortable="true" sortBy="#{var.facSerie}" style="text-align:center;" width="40px">
                        <f:facet name="header"><h:outputText  value="S." /></f:facet>
                        <h:outputText value="#{var.facSerie}"/>
                    </rich:column>
                    <rich:column label="Catégorie client" sortable="true" sortBy="#{var.facCat}" width="70px">
                        <f:facet name="header"><h:outputText  value="Cat." /></f:facet>
                        <h:outputText value="#{var.facCat}"/>
                    </rich:column>
                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{var.varTotTtcGlob}" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                        <h:outputText  value="#{var.varTotTtcGlob}" rendered="#{var.varTotTtcGlob!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Règlements" sortable="true" sortBy="#{var.facTotReglement}" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="Régl."  /></f:facet>
                        <h:outputText  value="#{var.facTotReglement}" rendered="#{var.facTotReglement!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Solde" sortable="true" sortBy="#{var.var_reliquat}" style="text-align:right;color:red">
                        <f:facet name="header"> <h:outputText value="Solde"  /></f:facet>
                        <h:outputText  value="#{var.var_reliquat}" rendered="#{var.var_reliquat!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column label="Objet de la facture" sortable="true" sortBy="#{var.facObject}" width="200px">
                        <f:facet name="header"><h:outputText value="Objet"  /></f:facet>
                        <h:outputText  value="#{var.facObject}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>

            <h:panelGrid id="imp" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35"  >
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column><h:inputText id="idUser" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonEncaissementVente.bonNomResponsable}" disabled="true"/></h:column>
                <h:column id="imp1"><h:outputText value="Impression: (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomRepMod})" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_modele}" >
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annule}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validationExecution}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </center>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelPrint}">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur :" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire :" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
