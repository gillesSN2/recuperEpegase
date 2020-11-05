<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionprojet">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS DES PROJETS" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3" id="panGlob">

            <rich:column width="300px" style="max-height:100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="1" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.recupererNomrep}" reRender="tableNomEtat,richPFiltre,panPrint"/>
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="1" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.recupererNomfich}" reRender="richPFiltre,panPrint"/>
                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Sélection modÃ¨le" /></f:facet>
                            <h:outputText  value="#{rapport}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column >

            <rich:column id="richPFiltre" width="100%">
                <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                    <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                    <h:panelGrid  columns="2" columnClasses="clos50d,clos50g"  width="100%" id="panFiltre">

                        <h:column><h:outputText value="Sélection Projet:" /></h:column>
                        <h:column>
                            <h:selectOneMenu id="idProjet" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.projet}">
                                <f:selectItem itemLabel="Tous les projets" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.mesProjetsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Du:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Au:" /></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testaffiche=='balance'}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers=='tiers'}">
                                <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="ducomptebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteDebut}">
                                        <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numero de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,ducomptebalance" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Au Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="aucomptebalance" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteFin}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,aucomptebalance" />
                                    </h:inputText>
                                </h:column>
                            </c:if>

                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers=='balanceExt'}">
                                <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="ducomptebalance"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteDebut}">
                                        <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,ducomptebalance" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Au Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="aucomptebalance"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteFin}">
                                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,aucomptebalance" />
                                    </h:inputText>
                                </h:column>
                            </c:if>
                            <h:column><h:outputText value="Nb car. Sous total:" /></h:column>
                            <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.nbreCaractere}"/></h:column>
                            <h:column><h:outputText value="Type Ecriture:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.typeEcriture}">
                                    <f:selectItem itemLabel="Toutes les écritures" itemValue="0"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées" itemValue="1"/>
                                    <f:selectItem itemLabel="Ecritures lettrées" itemValue="2"/>
                                    <f:selectItem itemLabel="Ecritures non pointées" itemValue="3"/>
                                    <f:selectItem itemLabel="Ecritures pointées" itemValue="4"/>
                                    <f:selectItem itemLabel="Ecritures non lettrées et pointées" itemValue="5"/>
                                    <f:selectItem itemLabel="Ecritures lettrées et pointées" itemValue="6"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection Journal:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.journal}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.touslesjournauxComptablesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Sélection agent:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.createur}" >
                                    <f:selectItem itemLabel="Tous les agents" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.mesUsersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxS}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxR}" /></h:column>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testaffiche=='brouillard'}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers!='treso'}">
                                <h:column><h:outputText value="Du Compte:" style="text-decoration:underline"/></h:column>
                                <h:column>
                                    <h:inputText id="ducomptebrouillard" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteDebut}">
                                        <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,ducomptebrouillard" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Au Compte:" style="text-decoration:underline" /></h:column>
                                <h:column>
                                    <h:inputText id="aucomptebrouillard" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.filtreCompteFin}">
                                        <rich:toolTip  followMouse="true" direction="top-right" showDelay="1000" value="saisissez le debut d'un numero de compte ou d 'un libellé de compte" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.rechercheComptesFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeComptes,aucomptebrouillard" />
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Nb car. Sous total:" /></h:column>
                                <h:column><h:inputText size="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.nbreCaractere}"/></h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers=='treso'}">
                                <h:column><h:outputText value="Sélection Journal:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.journal}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.lesjournauxTresorerieItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers=='tresoExt'}">
                                <h:column><h:outputText value="Sélection Journal:" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.journal}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.touslesjournauxComptablesItem}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testafficheTiers!='treso'}">
                                <h:column><h:outputText value="Sélection agent:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.createur}">
                                        <f:selectItem itemLabel="Tous les agents" itemValue="0"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.mesUsersItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxS}" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxR}"/></h:column>
                            </c:if>
                        </c:if>

                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.testaffiche=='journal'}">
                            <h:column><h:outputText value="Sélection Journal:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.journal}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.touslesjournauxComptablesItem}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Inclure journaux situation:" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxS}" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Inclure journaux privés:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.inclureJournauxR}" /></h:column>
                        </c:if>

                    </h:panelGrid>
                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="AperÃ§u avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie Ã  (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des comptes -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeComptes" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.showModalPanelComptes}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.showModalPanelComptes}" var="cpt">
            <f:facet name="header"><h:outputText value="Sélection du compte"/></f:facet>
            <a4j:form id="formModalListeComptes">
                <rich:extendedDataTable id="tableCompte" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="1" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.datamodelComptes}" var="cpte">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.selectionligneCompte}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="NÂ° Compte" sortable="true" sortBy="#{cpte.plcCompte}" width="15%">
                        <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                        <h:outputText value="#{cpte.plcCompte}"/>
                    </rich:column>
                    <rich:column label="Libellé compte" sortable="true" sortBy="#{cpte.plcLibelleCpteFR}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé compte" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleCpteFR}"/>
                    </rich:column>
                    <rich:column label="Racine" sortable="true" sortBy="#{cpte.plcLibelleRacineFR}" width="30%">
                        <f:facet name="header"><h:outputText  value="Racine" /></f:facet>
                        <h:outputText value="#{cpte.plcLibelleRacineFR}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valcompte">
                    <center>
                        <h:commandButton id="idCanCompte" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.annuleCompte}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton id="idValCompte" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.calculeCompte}"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanCompte')}.click()" />
                    <rich:hotKey key="return" handler="#{rich:element('idValCompte')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formImpressionProjet.var_ctrl_imp}">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>