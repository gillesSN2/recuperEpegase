<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionachats">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS DES ACHATS" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3" id="panGlob">

            <rich:column width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" reRender="tableNomEtat,richPFiltre,panPrint,panLigne" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.recupererNomrep}" />
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne"/>
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
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}"><h:outputText value="Période:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}">
                            <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.periode}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesPeriodesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.calculeDates}" reRender="idD1,idD2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}"><h:outputText value="Du:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}"><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.filtreDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;"/></h:column>
                        <h:column><h:outputText value="Au:" /></h:column>
                        <h:column><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.filtreDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  style="background-color:white;" /></h:column>
                        <h:column><h:outputText value="Sociétés:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomTiers}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeTiers" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="N° document:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.document}"/></h:column>
                        <h:column><h:outputText value="Contact:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomDestinataire}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}"><h:outputText value="Sélection état:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_balanceagee'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.nomRepertoire!='entete_echeancier'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.etat}" >
                                <f:selectItem itemLabel="Tous états" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesEtatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_activite}"><h:outputText value="Sélection activité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.activite}" >
                                <f:selectItem itemLabel="Toutes activités" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection dossier:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.dossier}" >
                                <f:selectItem itemLabel="Tous dossiers" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDossiersItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_parc}"><h:outputText value="Sélection parc:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_parc}">
                            <h:inputText id="idParc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.parc}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeParc" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_region}"><h:outputText value="Sélection région:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_region}">
                            <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.region}" >
                                <f:selectItem itemLabel="Toutes régions" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_secteur}"><h:outputText value="Sélection secteurs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_secteur}">
                            <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.secteur}" >
                                <f:selectItem itemLabel="Tous secteurs" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesSecteursItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.chargerPdv}" reRender="panFiltre,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_pdv}"><h:outputText value="Sélection points de vente:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_pdv}">
                            <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.pdv}" >
                                <f:selectItem itemLabel="Tous points de vente" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdServiceAch==0}" var="srv1">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_site}"><h:outputText value="Sélection site:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_site}">
                                <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.site}" >
                                    <f:selectItem itemLabel="Tous sites" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_departement}"><h:outputText value="Sélection département:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_departement}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.departement}" >
                                    <f:selectItem itemLabel="Tous départements" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_service}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.service}" >
                                    <f:selectItem itemLabel="Tous services" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdServiceAch==1}" var="srv2">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_service}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.var_anal_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.service}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <h:column><h:outputText value="Sélection catégorie:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.categorie}" >
                                <f:selectItem itemLabel="Toutes catégories" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleFournisseursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection séries:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.serie}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.mesSeriesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection commercial:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.commercial}" >
                                <f:selectItem itemLabel="Tous commerciaux" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCommerciauxItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection créateur:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.createur}" >
                                <f:selectItem itemLabel="Tous créateurs" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCreateursItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                    <h:panelGrid id="panLigne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.testafficheLigne}" columns="2" columnClasses="clos50d,clos50g"  width="100%">
                        <h:column><h:outputText value="Du produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdDeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.produitDebut}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.rechercheProduitsDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Au produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdFin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.produitFin}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.rechercheProduitsFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits" />
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Sélection familles:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.famille}" >
                                <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamillesAchatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection dépôts:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.depot}" >
                                <f:selectItem itemLabel="Tous dépôts" itemValue="100"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>

                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menuachat.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>


    <!-- modalPanel de selection des tiers -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.datamodelTiers}" var="tiers">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.selectionligneTiers}"/>
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
                        <a4j:commandButton id="idCanTiers" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.annuleTiers}" reRender="idTiers,panelListeTiers"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValTiers" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.calculeTiers}" reRender="idTiers,panelListeTiers"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanTiers')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValTiers')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



    <!-- modalPanel de selection des produits -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.datamodelProduits}" var="prd">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.selectionProduits}"/>
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
                        <a4j:commandButton id="idCanProd" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.annuleProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProd" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.calculeProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanProd')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValProd')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- modalPanel de selection des parcs -->
    <rich:modalPanel domElementAttachment="parent"  id="panelListeParc" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelParc}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.showModalPanelParc}" var="prc">
            <f:facet name="header"><h:outputText value="Sélection du parc"/></f:facet>
            <a4j:form id="formModalListeParc">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableParc" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.datamodelParc}"  var="prc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.selectionParc}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Immatriculation" sortable="true" sortBy="#{prc.prcImmatriculation}" width="20%">
                            <f:facet name="header"><h:outputText  value="Immatriculation" /></f:facet>
                            <h:outputText value="#{prc.prcImmatriculation}"/>
                        </rich:column>
                        <rich:column label="Nature" sortable="true" sortBy="#{prc.prcLibNature}" width="20%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{prc.prcLibNature}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prc.prcLibFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibFamille}"/>
                        </rich:column>
                        <rich:column label="Sous Famille" sortable="true" sortBy="#{prc.prcLibSousFamille}" width="20%">
                            <f:facet name="header"><h:outputText  value="Sous Famille" /></f:facet>
                            <h:outputText value="#{prc.prcLibSousFamille}"/>
                        </rich:column>
                        <rich:column label="Marque" sortable="true" sortBy="#{prc.prcMarque}" width="20%">
                            <f:facet name="header"><h:outputText  value="Marque" /></f:facet>
                            <h:outputText value="#{prc.prcMarque}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprc">
                    <center>
                        <a4j:commandButton id="idCanParc" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.annuleParc}" reRender="panelListeParc,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValParc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionAchats.calculeParc}" reRender="panelListeParc,idParc"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanParc')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValParc')}.click()" />
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