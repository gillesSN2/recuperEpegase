<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionmedical">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS DU MEDICAL" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3"  id="panGlob">

            <rich:column width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.recupererNomrep}" reRender="tableNomEtat,richPFiltre,panPrint,panLigne,panDocument"/>
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne"/>
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
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='comparatif'}"><h:outputText value="Période:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='comparatif'}">
                            <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.periode}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.mesPeriodesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.calculeDates}" reRender="idD1,idD2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='comparatif'}"><h:outputText value="Du:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_bcagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='entete_echeancier'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomRepertoire!='comparatif'}"><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Au:" /></h:column>
                        <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}"><h:outputText value="Tiers payeurs:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}">
                            <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.nomTiers}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Type de tiers:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idTypeTiers" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.typeTiers}" >
                                <f:selectItem itemLabel="Tous les tiers" itemValue="100"/>
                                <f:selectItem itemLabel="Assurances" itemValue="1"/>
                                <f:selectItem itemLabel="Sociétés" itemValue="2"/>
                                <f:selectItem itemLabel="Complémentaires" itemValue="3"/>
                                <f:selectItem itemLabel="CNAMGS" itemValue="4"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection séries:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idSerie" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.mesSeriesItems}"/>
                                <f:selectItem itemLabel="Toutes séries" itemValue="100" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==1}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection état:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idEtat" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.etat}" >
                                <f:selectItem itemLabel="Tous états" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.mesEtatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}"><h:outputText value="Sélection service:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}">
                            <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.service}" >
                                <f:selectItem itemLabel="Tous services" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}"><h:outputText value="Sélection médecin:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}">
                            <h:selectOneMenu id="idMedcin" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.medecin}" >
                                <f:selectItem itemLabel="Tous médecins" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.mesMedecinsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}"><h:outputText value="Sélection créateur:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheDocument}">
                            <h:selectOneMenu id="idCreateur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.createur}" >
                                <f:selectItem itemLabel="Tous créateurs" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesCreateursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.infirmerie}"><h:outputText value="Sélection site:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.infirmerie}">
                            <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==null||bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite==''}">
                                <f:selectItem itemLabel="Tous les sites" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesSitesItems}"/>
                            </h:selectOneMenu>
                             <h:inputText style="width:100;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.site}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSite!=''}" readonly="true" disabled="true"/>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid id="panLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.testafficheLigne}" columns="2" columnClasses="clos50d,clos50g"  width="100%">
                        <h:column><h:outputText value="Du produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdDeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.produitDebut}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.rechercheProduitsDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Au produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdFin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.produitFin}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.rechercheProduitsFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Sélection familles:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idFamilles" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.famille}" >
                                <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesFamillesVentesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection dépôts:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idDepot" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.depot}" >
                                <f:selectItem itemLabel="Tous dépôts" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesDepotItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection services:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.service}" >
                                <f:selectItem itemLabel="Tous services" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection laboratoires:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idLabo" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.laboratoire}" >
                                <f:selectItem itemLabel="Tous laboratoires" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLaboratoiresItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection pharmacies:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idPharmacie" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.pharmacie}" >
                                <f:selectItem itemLabel="Toutes pharmacies" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPharmaciesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menumedical.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des tiers -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.selectionligneTiers}"/>
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
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.annuleTiers}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.calculeTiers}" reRender="idTiers,panelListeTiers"/>
                        <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                        <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des destinataires -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeDestinataire" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelDestinataire}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelDestinataire}" var="dst">
            <f:facet name="header"><h:outputText value="Sélection du destinataire"/></f:facet>
            <a4j:form id="formModalListeDestinataire">
                <rich:extendedDataTable id="tableDest" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.datamodelDestinataire}"  var="dest">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.selectionligneDestinataire}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Nom" sortable="true" sortBy="#{dest.anaNomFr}" width="50%">
                        <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                        <h:outputText value="#{dest.anaNomFr}"/>
                    </rich:column>
                    <rich:column label="Téléphone" sortable="true" sortBy="#{dest.anaTiersTelephone}" width="20%">
                        <f:facet name="header"><h:outputText  value="Téléphone" /></f:facet>
                        <h:outputText value="#{dest.anaTiersTelephone}"/>
                    </rich:column>
                    <rich:column label="Adresse" sortable="true" sortBy="#{dest.anaTiersAdresse}" width="30%">
                        <f:facet name="header"><h:outputText  value="Adresse" /></f:facet>
                        <h:outputText value="#{dest.anaTiersAdresse}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valdest">
                    <center>
                        <a4j:commandButton id="idCanDest" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.annuleDestinataire}" reRender="panelListeDestinataire,idDestinataire"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValDest" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.calculeDestinataire}" reRender="panelListeDestinataire,idDestinataire"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanDest')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValDest')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des produits -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.datamodelProduits}" var="prd">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.selectionProduits}"/>
                    <f:facet name="header"></f:facet>
                    <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                        <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                        <h:outputText value="#{prd.proCode}"/>
                    </rich:column>
                    <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="55%">
                        <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                        <h:outputText value="#{prd.proLibClient}"/>
                    </rich:column>
                    <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                        <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                        <h:outputText value="#{prd.proVteLib}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton id="idCanProd" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.annuleProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProd" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formImpressionMedicales.calculeProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanProd')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValProd')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="350" height="80" resizeable="false">
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