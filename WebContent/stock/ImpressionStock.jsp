<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="impressionstock">

    <a4j:form target="_blank">

        <center> <h2><h:outputText value="IMPRESSIONS DES STOCKS" styleClass="titre"/></h2></center>

        <h:panelGrid width="100%" columns="3"  id="panGlob">

            <rich:column  width="300px" style="max-height:100%" >
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableRepertoire" enableContextMenu="false" footerClass="bard" headerClass="headerTab" activeClass="active-row" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.dataModelImpgen}" var="repert">
                        <a4j:support eventsQueue="maQueue" reRender="tableNomEtat,richPFiltre,panPrint,panLigne,panDocument" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.recupererNomrep}" />
                        <rich:column width="100%" sortBy="#{repert}" sortable="true"  sortOrder="ASCENDING">
                            <f:facet name="header" > <h:outputText value="Sélection état"/></f:facet>
                            <h:outputText value="#{repert}"/>
                        </rich:column >
                    </rich:extendedDataTable>
                </a4j:region>
            </rich:column>

            <rich:column width="300px" style="max-height:100%;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="tableNomEtat" enableContextMenu="false" footerClass="bard" headerClass="headerTab" border="0" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:1px solid black;cursor:pointer;border-radius:10px" activeClass="active-row" noDataLabel=" " width="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.dataModelImpgenFichier}" var="rapport">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.recupererNomfich}" reRender="richPFiltre,panPrint,panLigne" />
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
                    <h:panelGrid  columns="2" columnClasses="clos50d,clos50g"  width="100%" id="panFiltre">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><h:outputText value="Période:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}">
                            <h:selectOneMenu id="idPeriode" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.periode}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesPeriodesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.calculeDates}" reRender="idD1,idD2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><h:outputText value="Du:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><rich:calendar id="idD1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.filtreDateDebut}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" style="background-color:white;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><h:outputText value="Au:" /></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><rich:calendar id="idD2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.filtreDateFin}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" style="background-color:white;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.testafficheDocument}"><h:outputText value="Sélection état:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.testafficheDocument}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.etatRec}" >
                                <f:selectItem itemLabel="Tous états" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesEtatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>

                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}"><h:outputText value="Activités:"/></h:column>
                        <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.activite}" >
                                <f:selectItem itemLabel="Toutes les activités" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_colonne1}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.laColonne1Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_colonne2}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.laColonne2Items}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.decoupageActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_activite}">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_colonne3}" >
                                <f:selectItem itemLabel="Tou(te)s #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.laColonne3Items}"/>
                            </h:selectOneMenu>
                        </h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_dossier!=0}"><h:outputText value="Sélection dossier:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_dossier!=0}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.dossier}" >
                                <f:selectItem itemLabel="Tous dossiers" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDossiersItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_parc}"><h:outputText value="Sélection parc:" style="text-decoration:underline;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_parc}">
                            <h:inputText id="idParc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.parc}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeParc" />
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_region}"><h:outputText value="Sélection région:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_region}">
                            <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.region}" >
                                <f:selectItem itemLabel="Toutes régions" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_secteur}"><h:outputText value="Sélection secteurs:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_secteur}">
                            <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.secteur}" >
                                <f:selectItem itemLabel="Tous secteurs" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesSecteursItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.chargerPdv}" reRender="panFiltre,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_pdv}"><h:outputText value="Sélection points de vente:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_pdv}">
                            <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.pdv}" >
                                <f:selectItem itemLabel="Tous points de vente" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdServiceAch==0}" var="srv1">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_site}"><h:outputText value="Sélection site:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_site}">
                                <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.site}" >
                                    <f:selectItem itemLabel="Tous sites" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_departement}"><h:outputText value="Sélection département:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_departement}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.departement}" >
                                    <f:selectItem itemLabel="Tous départements" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_service}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.service}" >
                                    <f:selectItem itemLabel="Tous services" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrProdServiceAch==1}" var="srv2">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_service}"><h:outputText value="Sélection service:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_anal_service}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.service}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}"><h:outputText value="Sélection séries:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire!='catalogue'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.serie}" >
                                <f:selectItem itemLabel="Toutes séries" itemValue="" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==1}"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.mesSeriesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Du produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdDeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.produitDebut}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.rechercheProduitsDebut}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idProdDeb,idProdFin"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Au produit:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:inputText id="idProdFin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.produitFin}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.rechercheProduitsFin}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,idProdFin"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Sélection familles:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.famille}" >
                                <f:selectItem itemLabel="Toutes familles" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamillesAchatsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Sélection dépôts:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.depot}" >
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}"/>
                                <f:selectItem itemLabel="Tous dépots" itemValue="XXXX"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}"><h:outputText value="Intégré qte = 0:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.stocknull}">
                                <f:selectItem itemLabel="Sans les produits à  0" itemValue="0"/>
                                <f:selectItem itemLabel="Avec les produits à  0" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}"><h:outputText value="Mode de calcul:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.stockQteVal}">
                                <f:selectItem itemLabel="Ne prendre que les documents Validés" itemValue="0"/>
                                <f:selectItem itemLabel="Prendre les documents En cours + Validés" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}"><h:outputText value="Antérieurs:"/></h:column>
                        <h:column rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.nomRepertoire=='etat_stock'}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.stockAnterieur}">
                                <f:selectItem itemLabel="Antérieurs cumulés" itemValue="0"/>
                                <f:selectItem itemLabel="Antérieurs détaillés" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50d,clos50g" id="panDocument" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.testafficheDocument}">
                        <h:column><h:outputText value="Inventaire:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_inv}"/></h:column>
                        <h:column><h:outputText value="Bon entrée:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_bin}"/></h:column>
                        <h:column><h:outputText value="Bon sortie:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_bout}"/></h:column>
                        <h:column><h:outputText value="Cession:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_ces}"/></h:column>
                        <h:column><h:outputText value="Production:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_prod}"/></h:column>
                        <h:column><h:outputText value="Réception achat:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_rec}"/></h:column>
                        <h:column><h:outputText value="Retour achat:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_sav}"/></h:column>
                        <h:column><h:outputText value="Commande vente:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_bc}"/></h:column>
                        <h:column><h:outputText value="Livraison vente:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_bl}"/></h:column>
                        <h:column><h:outputText value="Factures vente:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_fac}"/></h:column>
                        <h:column><h:outputText value="Retour vente:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_br}"/></h:column>
                    </h:panelGrid>

                </h:panelGrid>
            </rich:column >

        </h:panelGrid>

        <center>
            <br>
            <h:panelGrid id="panPrint" columns="11" style="height:80px">
                <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" />
                <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <h:commandButton image="/images/imp_csv.png" onmouseover="this.src='images/imp_csv_big.png'" onmouseout="this.src='images/imp_csv.png'" value="CSV" title="Export CSV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerCSV}" onclick="javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}"/>
                <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menustock.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panMail"/>
                <h:panelGrid id="panMail" width="100%">
                    <h:panelGrid  width="100%" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 0px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>
        </center>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.showModalPanelProduits}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.showModalPanelProduits}" var="prd">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.datamodelProduits}" var="prd">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.selectionProduits}"/>
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
                    <rich:column label="Unité" sortable="true" sortBy="#{prd.proCondition1}" width="10%">
                        <f:facet name="header"><h:outputText  value="Cond." /></f:facet>
                        <h:outputText value="#{prd.proCondition1}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton id="idCanProd" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.annuleProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValProd" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.calculeProduits}" reRender="idProdDeb,idProdFin,panelListeProduits"/>
                    </center>
                    <rich:hotKey key="esc"  handler="#{rich:element('idCanProd')}.click()" />
                    <rich:hotKey key="return"  handler="#{rich:element('idValProd')}.click()" />
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeParc" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.showModalPanelParc}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.showModalPanelParc}" var="prc">
            <f:facet name="header"><h:outputText value="Sélection du parc"/></f:facet>
            <a4j:form id="formModalListeParc">
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableParc" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.datamodelParc}"  var="prc">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.selectionParc}"/>
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
                        <a4j:commandButton id="idCanParc" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.annuleParc}" reRender="panelListeParc,idParc"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton id="idValParc" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.calculeParc}" reRender="panelListeParc,idParc"/>
                        <rich:hotKey key="esc" handler="#{rich:element('idCanParc')}.click()" />
                        <rich:hotKey key="return" handler="#{rich:element('idValParc')}.click()" />
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="100" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Calcul du tableau en cours..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeBarProg">
                    <rich:componentControl attachTo="closeBarProg" for="panelBarProg" event="onclick" operation="hide"/>
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="(#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.depot_encours}) #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.produit_encours} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formImpressionStock.var_currentValue} % "/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>