<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionimmobilier">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSION #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.libelleImmobilier}" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3"  id="panGlob">

            <rich:column width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.recupererNomrep}" reRender="tableNomEtat,richPFiltre,panPrint,panLigne,panDocument"/>
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne"/>
                        <rich:column  width="100%" sortBy="#{rapport}" sortable="true" sortOrder="ASCENDING">
                            <f:facet name="header" ><h:outputText value="Sélection modèle" /></f:facet>
                            <h:outputText  value="#{rapport}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column >

            <rich:column id="richPFiltre"  width="100%" >
                <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur1" style="height:505px;display:block;overflow-y:scroll;width:400px;border-radius:10px">
                    <f:facet name="header" ><h:outputText value="Filtres"/></f:facet>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panFiltre">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='bien'}" var="fac1">
                            <h:column><h:outputText value="Période:" /></h:column>
                            <h:column>
                                <h:selectOneMenu id="idPeriode" style="width:300px"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.periode}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.mesPeriodesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.calculeDates}" reRender="idD1,idD2"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:" /></h:column>
                            <h:column><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Au:" /></h:column>
                            <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac20">
                            <h:column><h:outputText value="Propriétaire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText id="idProprietaire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomProprietaire}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.rechercheTiersProprietaire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiersProprietaire" />
                                </h:inputText>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='bien'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='gerance'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac2">
                            <h:column><h:outputText value="Locataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText id="idLocataire" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomLocataire}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.rechercheTiersLocataire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiersLocataire" />
                                </h:inputText>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.typeImmobilier==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac5">
                            <h:column><h:outputText value="Code bien:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText id="idBiens" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.codeBien}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.rechercheBiens}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeBiens" />
                                </h:inputText>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.typeImmobilier==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac5">
                            <h:column><h:outputText value="Code bien:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.codeBien}" >
                                    <f:selectItem itemLabel="Tous biens" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.mesBiensRecItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire=='bien'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="bien">
                            <h:column><h:outputText value="Sélection état:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.etatBien}" >
                                    <f:selectItem itemLabel="Biens gérés par l'agence (Biens libres)" itemValue="0"/>
                                    <f:selectItem itemLabel="Biens gérés par l'agence (Biens occupés)" itemValue="1"/>
                                    <f:selectItem itemLabel="Biens gérés par l'agence (Tous les Biens)" itemValue="2"/>
                                    <f:selectItem itemLabel="Biens plus gérés par l'agence" itemValue="8"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='bien'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac3">
                            <h:column><h:outputText value="Sélection état:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.etat}" >
                                    <f:selectItem itemLabel="Tous états" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.mesEtatsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire=='facture'}" var="fac4">
                                <h:column><h:outputText value="Sélection catégorie:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.categorie}" >
                                        <f:selectItem itemLabel="Toutes catégories" itemValue="100"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesFamilleClientsItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </c:if>
                            <h:column><h:outputText value="Sélection séries:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.serie}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.mesSeriesItems}"/>
                                    <f:selectItem itemLabel="Toutes séries" itemValue="100" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==1}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}"><h:outputText value="Sélection responsable:"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.responsable}" >
                                    <f:selectItem itemLabel="Tous responsables" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesResponsablesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.optionVentes.responsable==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}"><h:outputText value="Sélection commercial:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.optionVentes.responsable==1&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.commercial}" >
                                    <f:selectItem itemLabel="Tous commerciaux" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesCommerciauxItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire=='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac5">
                            <h:column><h:outputText value="Sélection séries:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.serie}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.mesSeriesItems}"/>
                                    <f:selectItem itemLabel="Toutes séries" itemValue="100" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==1}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac7">
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}"><h:outputText value="Sélection créateur:"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.testafficheDocument}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.createur}" >
                                    <f:selectItem itemLabel="Tous créateurs" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesCreateursItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire=='declaration'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.nomRepertoire!='encaissement_location'}" var="fac7">
                            <h:column><h:outputText value="Numéro bordereau:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.var_num_bordereau}"/>
                            </h:column>
                        </c:if>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des tiers locataire -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiersLocataire" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelTiersLocataire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelTiersLocataire}" var="til">
            <f:facet name="header"><h:outputText value="Sélection du tiers locataire"/></f:facet>
            <a4j:form id="formModalListeTiersLocataire">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.pageIndex}" reRender="tableTiersLocataire" id="scrollTable1" maxPages="20"align="left" for="tableTiersLocataire"/>
                <rich:extendedDataTable rows="100" id="tableTiersLocataire" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.selectionligneTiersLocataire}"/>
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
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiersLocataire" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.annuleTiersLocataire}" reRender="idLocataire,panelListeTiersLocataire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiersLocataire" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.calculeTiersLocataire}" reRender="idLocataire,panelListeTiersLocataire"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiersLocataire')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiersLocataire')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des tiers proprietaire -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiersProprietaire" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelTiersProprietaire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelTiersProprietaire}" var="tip">
            <f:facet name="header"><h:outputText value="Sélection du tiers propriétaire"/></f:facet>
            <a4j:form id="formModalListeTiersProprietaire">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.pageIndex}" reRender="tableTiersProprietaire" id="scrollTable2" maxPages="20"align="left" for="tableTiersProprietaire"/>
                <rich:extendedDataTable rows="100" id="tableTiersProprietaire" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.selectionligneTiersProprietaire}"/>
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
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanTiersProprietaire" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.annuleTiersProprietaire}" reRender="idProprietaire,panelListeTiersProprietaire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiersProprietaire" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.calculeTiersProprietaire}" reRender="idProprietaire,panelListeTiersProprietaire"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiersProprietaire')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiersProprietaire')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des biens -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeBiens" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelBiens}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.showModalPanelBiens}" var="bie">
            <f:facet name="header"><h:outputText value="Sélection du bien"/></f:facet>
            <a4j:form id="formModalListeBiens">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.pageIndex}" reRender="tableBiens" id="scrollTable2" maxPages="20"align="left" for="tableBiens"/>
                <rich:extendedDataTable rows="100" id="tableBiens" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.dataModelBiens}" var="biens">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.selectionligneBiens}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Code bien" sortable="true" sortBy="#{biens.bieNum}" width="15%">
                        <f:facet name="header"><h:outputText  value="Biens" /></f:facet>
                        <h:outputText value="#{biens.bieNum}"/>
                    </rich:column>
                    <rich:column label="Descriptif" sortable="true" sortBy="#{biens.bieNom}" width="55%">
                        <f:facet name="header"><h:outputText  value="Descriptif" /></f:facet>
                        <h:outputText value="#{biens.bieNom}"/>
                    </rich:column>
                    <rich:column label="Propriétaire" sortable="true" sortBy="#{biens.bieNomTiers}" width="40%">
                        <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                        <h:outputText value="#{biens.bieNomTiers}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup>
                    <center>
                        <a4j:commandButton id="idCanBiens" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.annuleBiens}" reRender="idBiens,panelListeBiens"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValBiens" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formImpressionImmobilier.calculeBiens}" reRender="idBiens,panelListeBiens"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanBiens')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValBiens')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false">
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