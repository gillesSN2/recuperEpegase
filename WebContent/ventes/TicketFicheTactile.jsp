<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="ticketfiche">

    <a4j:form>

        <h:panelGroup id="panelPage">

            <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20"  styleClass="" id="idCorpsTicket" border="1">

                <h:column>
                    <center>
                        <h:panelGrid width="100%" columns="10" style="border:solid 0px green;vertical-align:super;">
                            <h:column><h:outputText style="text-align:center;font-size:15px" value="Caissier:"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-size:15px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.var_commercial}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-size:15px" value="Equipe:"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-size:15px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.var_equipe}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-size:15px" value="Responsable:"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-size:15px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.var_responsable}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-size:15px" value="Dépot:"/></h:column>
                            <h:column><h:inputText style="width:95%;text-align:center;font-size:15px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.var_depotProd}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-size:15px" value="Caisse:"/></h:column>
                            <h:column><h:inputText style="width:95%;text-align:center;font-size:15px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.var_caisse}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid width="100%" columns="5" style="border:solid 0px green;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==1}">
                            <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="TICKET N°:"/></h:column>
                            <h:column><h:inputText style="width:80%;text-align:center;font-weight:bold;font-size:22px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticNum}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:22px;color:green" value="Total:"/></h:column>
                            <h:column>
                                <h:inputText style="width:80%;text-align:center;font-weight:bold;font-size:22px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticTotalTtc}" readonly="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:24px;color:green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/></h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid width="100%" columns="10" style="border:solid 0px green;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==1}">
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:20px" value="Client:"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticNomTiers}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:20px" value="Tarif:"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticCat}" readonly="true"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:20px" value="Livreur:"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseLivreur=='1'}"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticNomLivreur}" readonly="true"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseLivreur=='1'}"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:20px" value="Table:"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseTable=='1'}"/></h:column>
                            <h:column><h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticTable}" readonly="true"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseTable=='1'}"/></h:column>
                            <h:column><h:outputText style="text-align:center;font-weight:bold;font-size:20px" value="Chambre:"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseChambre=='1'}"/></h:column>
                            <h:column><h:inputText style="width:95%;text-align:center;font-weight:bold;font-size:20px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticChambre}" readonly="true"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseChambre=='1'}"/></h:column>
                        </h:panelGrid>
                    </center>
                    <h:panelGrid width="100%" style="height:370px">
                        <center>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==0}" var="menu">
                                <h:panelGrid width="100%" columnClasses="clos50,clos50" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==0}">
                                    <h:panelGrid width="100%" columns="1" style="line-height:2em;border:solid 0px green;text-align:center;height:470px">
                                        <a4j:commandButton value="Début Session" styleClass="acceuilCaisse" style="color:blue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionDebut}" reRender="panelFondCaisse" onclick="if (!confirm('Etes-vous sur de vouloir effectuer le début de session ?')) return false"/>
                                        <a4j:commandButton value="Liste Ticket" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionListeTicket}" reRender="panelImp"/>
                                        <a4j:commandButton value="CA Produit" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionCaProduit}" reRender="panelImp"/>
                                        <a4j:commandButton value="Etat Stock" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionEtatStock}" reRender="panelImp" />
                                        <a4j:commandButton value="Fin Session" styleClass="acceuilCaisse" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionFin}" reRender="panelFondCaisse" onclick="if (!confirm('Etes-vous sur de vouloir effectuer la fin de session ?')) return false"/>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" columns="1" style="line-height:2em;border:solid 0px green;text-align:center;height:470px">
                                        <a4j:commandButton value="Nouveau ticket" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ajouterTicket}" reRender="idCorpsTicket" />
                                        <a4j:commandButton value="Reprise attente" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionRepriseAttente}" reRender="idCorpsTicket"/>
                                        <a4j:commandButton value="Reprise livré" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionRepriseLivre}" reRender="idCorpsTicket"/>
                                        <a4j:commandButton value="Commande table" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionRepriseLivre}" reRender="idCorpsTicket"/>
                                        <a4j:commandButton value="Reprise table" styleClass="acceuilCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionEtatStock}" reRender="panelImp" />
                                    </h:panelGrid>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==1}" var="vide">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="tableLigne" height="370px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.datamodelLigne}" var="doclig">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionLigneDetail}" reRender="panelLigne,panelBoutonLigne"/>
                                        <rich:column sortable="false" width="100px">
                                            <f:facet name="header"><h:outputText  value="Code" style="font-size:20px"/></f:facet>
                                            <h:outputText  value="#{doclig.ticligCode}" style="font-size:20px"/>
                                        </rich:column>
                                        <rich:column sortable="false" width="200px">
                                            <f:facet name="header"><h:outputText  value="Libellé" style="font-size:20px"/></f:facet>
                                            <h:outputText value="#{doclig.ticligLibelle}" style="font-size:20px"/>
                                        </rich:column>
                                        <rich:column sortable="false" style="text-align:center" width="80px" >
                                            <f:facet name="header"><h:outputText  value="Qté" style="font-size:20px"/></f:facet>
                                            <a4j:commandButton value="#{doclig.ticligQte}" style="font-size:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.qtePaveNumerique}" reRender="panelPaveNumerique"/>
                                        </rich:column>
                                        <rich:column sortable="false" style="text-align:right;" width="100px">
                                            <f:facet name="header"><h:outputText value="P.U.TTC" style="font-size:20px"/></f:facet>
                                            <h:outputText value="#{doclig.ticligPuTtc}" rendered="#{doclig.ticligPuTtc!=0}" style="font-size:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.nbDecPu}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.nbDecPu}"/>
                                            </h:outputText>
                                            <a4j:commandButton value="#{doclig.ticligPuTtc}" rendered="#{doclig.ticligPuTtc==0}" style="font-size:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.prixUnitairePaveNumerique}" reRender="panelPaveNumerique"/>
                                        </rich:column>
                                        <rich:column sortable="false" style="text-align:center;" width="80px" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.verrouRemise}">
                                            <f:facet name="header"><h:outputText  value="Rem.%" style="font-size:20px"/></f:facet>
                                            <a4j:commandButton value="#{doclig.ticligTauxRemise}" style="font-size:20px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.remisePaveNumerique}" reRender="panelPaveNumerique"/>
                                        </rich:column>
                                        <rich:column sortable="false" style="text-align:right;" width="100px">
                                            <f:facet name="header"><h:outputText value="P.T.TTC" style="font-size:20px" /></f:facet>
                                            <h:outputText value="#{doclig.ticligTtc}" rendered="#{doclig.ticligTtc!=0}" style="font-size:20px">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </rich:column>
                                        <rich:column sortable="false" style="text-align:center;" width="50px">
                                            <a4j:commandButton image="/images/supprimer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annulationligne}" reRender="idCorpsTicket" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette ligne ?')) return false"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==2}" var="client">
                                <h:panelGrid width="100%" headerClass="headerCaisse" style="height:370px">
                                    <f:facet name="header"><h:outputText value="Sélection du client"/></f:facet>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid  style="background:transparent;border:0px;" width="100%" columns="3" id="tableTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelTiers}" var="tiers" >
                                            <rich:column style="border:0px;">
                                                <a4j:commandButton value="#{tiers.patronyme}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixTiers}" reRender="idCorpsTicket"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                    <h:panelGroup>
                                        <center>
                                            <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleProduit}" title="Annuler" reRender="idCorpsTicket"/>
                                        </center>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==3}" var="produit">
                                <h:panelGrid width="100%" headerClass="headerCaisse" style="height:370px">
                                    <h:panelGrid width="100%" style="height:500px" >
                                        <a4j:region renderRegionOnly="false">
                                            <rich:dataGrid  style="background:transparent;border:0px;border:solid 0px green;vertical-align:super;" width="100%" columns="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelFamilleProduit}" var="famvte" >
                                                <rich:column style="border:0px;">
                                                    <a4j:commandButton value="#{famvte.famvteLibelleFr}" style="#{famvte.espaceFamille}"  styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.listeProduits}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,listeProduits"/>
                                                </rich:column>
                                            </rich:dataGrid>
                                        </a4j:region>
                                        <a4j:region renderRegionOnly="false">
                                            <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelProduits}" id="listeProduits" var="prdvte" >
                                                <rich:column style="border:0px;" width="20%">
                                                    <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/produits/photo/#{prdvte.proPhoto}" alt="pho" height="80px" width="80px" style="text-align:center" rendered="#{prdvte.proPhoto!=null}">
                                                        <a4j:support  eventsQueue="maQueue" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixProduit}" reRender="idCorpsTicket"/>
                                                    </h:graphicImage>
                                                </rich:column>
                                                <rich:column style="border:0px;" width="80%">
                                                    <a4j:commandButton value="#{prdvte.proLibClient}" styleClass="produitCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixProduit}" reRender="idCorpsTicket"/>
                                                </rich:column>
                                            </rich:dataGrid >
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGroup>
                                        <center>
                                            <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleProduit}" title="Annuler" reRender="idCorpsTicket"/>
                                        </center>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==5}" var="livreur">
                                <h:panelGrid width="100%" headerClass="headerCaisse" style="height:370px">
                                    <f:facet name="header"><h:outputText value="Sélection du livreur"/></f:facet>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid  style="background:transparent;border:0px;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelLivreurs}" var="livreur" >
                                            <rich:column style="border:0px;">
                                                <a4j:commandButton value="#{livreur.usrPatronyme}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixLivreur}" reRender="idCorpsTicket"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                    <h:panelGroup>
                                        <center>
                                            <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleLivreur}" title="Annuler" reRender="idCorpsTicket"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </center>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==9}" var="reprise">
                                <h:panelGrid width="100%" headerClass="headerCaisse" style="height:370px">
                                    <f:facet name="header"><h:outputText value="Sélection du ticket"/></f:facet>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelTicket}" var="reprise" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                                            <rich:column style="border:0px;">
                                                <a4j:commandButton value="#{reprise.ticNum}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixTicket}" reRender="idCorpsTicket"/>
                                            </rich:column>
                                            <rich:column style="border:0px;">
                                                <h:outputText value=" du #{reprise.ticDate}"/>
                                            </rich:column>
                                            <rich:column style="border:0px;">
                                                <h:outputText value=" Total: #{reprise.ticTotalTtc}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column style="border:0px;">
                                                <h:outputText value=" Fait par #{reprise.ticNomCommercial}"/>
                                            </rich:column>
                                            <rich:column style="border:0px;" rendered="#{reprise.ticNomLivreur!=null}">
                                                <h:outputText value=" Livré par #{reprise.ticNomLivreur}"/>
                                            </rich:column>
                                        </rich:dataTable>
                                    </a4j:region>
                                    <h:panelGroup>
                                        <center>
                                            <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleReprise}" title="Annuler" reRender="idCorpsTicket"/>
                                        </center>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==11}" var="tarif">
                                <h:panelGrid width="100%" headerClass="headerCaisse" style="height:370px">
                                    <f:facet name="header"><h:outputText value="Sélection du tarif"/></f:facet>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelFamilleClient}" var="tarif">
                                            <rich:column style="border:0px;">
                                                <a4j:commandButton value="#{tarif.libelle}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.choixTarif}" reRender="idCorpsTicket"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                    <h:panelGroup>
                                        <center>
                                            <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleTarif}" title="Annuler" reRender="idCorpsTicket"/>
                                        </center>
                                    </h:panelGroup>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==13}" var="encaissement">
                                <h:panelGrid width="100%" columns="2" headerClass="headerCaisse" columnClasses="clos20;clos80">
                                    <f:facet name="header"><h:outputText value="Informations client"/></f:facet>
                                    <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Téléphone client:"/></h:column>
                                    <h:column><a4j:commandButton style="width:100%;text-align:center;font-size:22px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticTelephne}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.saisieTelephone}" reRender="panelPaveLettre"/></h:column>
                                    <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Mail client:"/></h:column>
                                    <h:column><a4j:commandButton style="width:100%;text-align:center;font-size:22px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticMail}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.saisieMail}" reRender="panelPaveLettre"/></h:column>
                                    <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Carte fidélité:"/></h:column>
                                    <h:column><a4j:commandButton style="width:100%;text-align:center;font-size:22px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.ticketEnteteVentes.ticFidele}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.fidelitePaveNumerique}" reRender="panelPaveNumerique"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="3" headerClass="headerCaisse">
                                    <f:facet name="header"><h:outputText value="Informations paiement"/></f:facet>
                                    <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Mode Paiement:"/></h:column>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dataModelReglement}" var="modereg" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                                            <rich:column style="border:0px;">
                                                <a4j:commandButton value="#{modereg.rglLibTypReg}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.reglementPaveNumerique}" reRender="panelPaveNumerique"/>
                                            </rich:column>
                                            <rich:column style="border:0px;">
                                                <h:outputText value=" Total: #{modereg.rglRecette}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:dataTable>
                                    </a4j:region>
                                    <h:panelGrid columns="1" style="text-align:center;">
                                        <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Montant encaissé:"/></h:column>
                                        <h:column>
                                            <a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.montantEncaisse}" styleClass="familleCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.reglementEncaisse}" reRender="panelPaveNumerique"/>
                                        </h:column>
                                        <h:column><h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="Montant rendu:"/></h:column>
                                        <h:column>
                                            <h:outputText style="width:300px;font-weight:bold;font-size:22px;color:green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.montantRendu}">
                                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                            </h:outputText>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <h:panelGroup id="idValideEncaissement">
                                    <center>
                                        <a4j:commandButton image="/images/annuler_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annuleEncaissement}" title="Annuler" reRender="idCorpsTicket"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a4j:commandButton image="/images/valider_big.png" style="height:70px;width:70px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.valideEncaissement}" title="Annuler" reRender="idCorpsTicket,panelImp" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.griserValider}"/>
                                    </center>
                                </h:panelGroup>
                            </c:if>
                        </center>
                    </h:panelGrid>
                </h:column>

                <h:column>
                    <center>
                        <h:panelGrid style="line-height:2em;border:solid 0px green;height:540px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typeBouton==1}">
                            <a4j:commandButton value="Client" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionClient}" reRender="idCorpsTicket,panelPaveLettre"/>
                            <a4j:commandButton value="Livreur" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionLivreur}" reRender="idCorpsTicket" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseLivreur=='1'}"/>
                            <a4j:commandButton value="Table" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionTable}" reRender="idCorpsTicket" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseTable=='1'}"/>
                            <a4j:commandButton value="Chambre" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionChambre}" reRender="idCorpsTicket" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionsVentes.caisseChambre=='1'}"/>
                            <a4j:commandButton value="Produit" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionProduit}" reRender="idCorpsTicket"/>
                            <br>
                            <a4j:commandButton value="Mise attente" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionMiseAttente}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idCorpsTicket"/>
                            <a4j:commandButton value="Ticket livré" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionTicketLivre}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idCorpsTicket" />
                            <br>
                            <a4j:commandButton value="Tarif" styleClass="boutonCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionRemise}" reRender="idCorpsTicket" />
                            <br>
                            <a4j:commandButton value="Paiement" styleClass="boutonCaisse" style="color:blue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.selectionEncaissement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idCorpsTicket"/>
                            <a4j:commandButton value="Annulation" styleClass="boutonCaisse" style="color:red" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.annulationTicket}" reRender="idCorpsTicket" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce ticket ?')) return false"/>
                        </h:panelGrid>
                    </center>
                </h:column>

            </h:panelGrid>

        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel id="panelPaveNumerique" width="400" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPaveNumerique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPaveNumerique}" var="pvn">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.libellePaveNumerique}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.fermerPaveNumerique}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaveNumerique,idCorpsTicket,idValideEncaissement"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="idCalculette" width="100%">
                    <h:panelGrid  width="100%" columns="2">
                        <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:40px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.lettreSaisie}" readonly="true"/>
                        <a4j:commandButton value="C" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.effaceChiffre}" reRender="idCalculette"/>
                    </h:panelGrid>
                    <center>
                        <h:panelGrid width="100%" columns="3" styleClass="fichefournisseur" style="text-align:center">
                            <a4j:commandButton value="7" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.sept}" reRender="idCalculette"/>
                            <a4j:commandButton value="8" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.huit}" reRender="idCalculette"/>
                            <a4j:commandButton value="9" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.neuf}" reRender="idCalculette"/>
                            <a4j:commandButton value="4" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.quatre}" reRender="idCalculette"/>
                            <a4j:commandButton value="5" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.cinq}" reRender="idCalculette"/>
                            <a4j:commandButton value="6" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.six}" reRender="idCalculette"/>
                            <a4j:commandButton value="1" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.un}" reRender="idCalculette"/>
                            <a4j:commandButton value="2" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.deux}" reRender="idCalculette"/>
                            <a4j:commandButton value="3" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.trois}" reRender="idCalculette"/>
                            <a4j:commandButton value="." styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.point}" reRender="idCalculette"/>
                            <a4j:commandButton value="0" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.zero}" reRender="idCalculette"/>
                        </h:panelGrid>
                    </center>
                    <br>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.validePaveNumerique}" style="width:70px;height;70px" reRender="panelPaveNumerique,idCorpsTicket,idValideEncaissement,idDebut"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelPaveLettre" width="850" height="410" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPaveLettre}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPaveLettre}" var="pvl">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.libellePaveNumerique}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.fermerPaveLettre}" image="/images/close.gif" styleClass="hidelink" reRender="panelPaveLettre"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <h:panelGrid id="idCalculette" width="100%">
                    <h:panelGrid  width="100%" columns="2">
                        <h:inputText style="width:100%;text-align:center;font-weight:bold;font-size:40px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.lettreSaisie}" readonly="true"/>
                        <a4j:commandButton value="C" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.effaceLettre}" reRender="idCalculette"/>
                    </h:panelGrid>
                    <center>
                        <h:panelGrid width="100%" columns="2">
                            <h:panelGrid width="100%" columns="10" styleClass="fichefournisseur" style="text-align:center">
                                <a4j:commandButton value="A" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.a}" reRender="idCalculette"/>
                                <a4j:commandButton value="Z" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.z}" reRender="idCalculette"/>
                                <a4j:commandButton value="E" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.e}" reRender="idCalculette"/>
                                <a4j:commandButton value="R" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.r}" reRender="idCalculette"/>
                                <a4j:commandButton value="T" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.t}" reRender="idCalculette"/>
                                <a4j:commandButton value="Y" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.y}" reRender="idCalculette"/>
                                <a4j:commandButton value="U" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.u}" reRender="idCalculette"/>
                                <a4j:commandButton value="I" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.i}" reRender="idCalculette"/>
                                <a4j:commandButton value="O" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.o}" reRender="idCalculette"/>
                                <a4j:commandButton value="P" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.p}" reRender="idCalculette"/>
                                <a4j:commandButton value="Q" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.q}" reRender="idCalculette"/>
                                <a4j:commandButton value="S" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.s}" reRender="idCalculette"/>
                                <a4j:commandButton value="D" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.d}" reRender="idCalculette"/>
                                <a4j:commandButton value="F" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.f}" reRender="idCalculette"/>
                                <a4j:commandButton value="G" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.g}" reRender="idCalculette"/>
                                <a4j:commandButton value="H" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.h}" reRender="idCalculette"/>
                                <a4j:commandButton value="J" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.j}" reRender="idCalculette"/>
                                <a4j:commandButton value="K" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.k}" reRender="idCalculette"/>
                                <a4j:commandButton value="L" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.l}" reRender="idCalculette"/>
                                <a4j:commandButton value="M" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.m}" reRender="idCalculette"/>
                                <a4j:commandButton value="W" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.w}" reRender="idCalculette"/>
                                <a4j:commandButton value="X" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.x}" reRender="idCalculette"/>
                                <a4j:commandButton value="C" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.c}" reRender="idCalculette"/>
                                <a4j:commandButton value="V" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.v}" reRender="idCalculette"/>
                                <a4j:commandButton value="B" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.b}" reRender="idCalculette"/>
                                <a4j:commandButton value="N" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.n}" reRender="idCalculette"/>
                                <a4j:commandButton value="" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.espace}" reRender="idCalculette"/>
                                <a4j:commandButton value="*" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.etoile}" reRender="idCalculette"/>
                                <a4j:commandButton value="@" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.arobase}"reRender="idCalculette"/>
                                <a4j:commandButton value="$" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.dollar}"reRender="idCalculette"/>
                                <a4j:commandButton value="-" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.moins}"reRender="idCalculette"/>
                                <a4j:commandButton value="_" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.underscore}"reRender="idCalculette"/>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="3" styleClass="fichefournisseur" style="text-align:center">
                                <a4j:commandButton value="7" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.sept}" reRender="idCalculette"/>
                                <a4j:commandButton value="8" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.huit}" reRender="idCalculette"/>
                                <a4j:commandButton value="9" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.neuf}" reRender="idCalculette"/>
                                <a4j:commandButton value="4" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.quatre}" reRender="idCalculette"/>
                                <a4j:commandButton value="5" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.cinq}" reRender="idCalculette"/>
                                <a4j:commandButton value="6" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.six}" reRender="idCalculette"/>
                                <a4j:commandButton value="1" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.un}" reRender="idCalculette"/>
                                <a4j:commandButton value="2" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.deux}" reRender="idCalculette"/>
                                <a4j:commandButton value="3" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.trois}" reRender="idCalculette"/>
                                <a4j:commandButton value="." styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.point}" reRender="idCalculette"/>
                                <a4j:commandButton value="0" styleClass="paveCaisse" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.zero}" reRender="idCalculette"/>
                            </h:panelGrid>
                        </h:panelGrid>
                    </center>
                    <br>
                    <h:panelGroup>
                        <center>
                            <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.validePaveLettre}" style="width:45px;height;45px" reRender="panelPaveLettre,idCorpsTicket"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.closeImpression}" image="/images/close.gif" style="width:70px;height:70px" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px black;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nomModeleListe}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.lesmodelesImpressions}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" style="width:100px;height:100px" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" style="width:100px;height:100px" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                            <h:commandButton image="/images/imp_mail.png" style="width:100px;height:100px"  value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.envoieMAIL}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue="" />
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel id="panelFondCaisse" width="800" height="540" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPanelFondsCaisse}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.showModalPanelFondsCaisse}" var="pvn">
            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.libellePaveNumerique}"></h:outputText></f:facet>
            <a4j:form >
                <h:panelGrid id="idDebut" width="100%">
                    <h:panelGrid width="100%" columns="2" columnClasses="cols,cols">
                        <h:panelGrid width="100%" columns="3" headerClass="headerTab" styleClass="fichefournisseur">
                            <f:facet name="header"><h:outputText value="Pièces"/></f:facet>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p1}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p1!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp1}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p1!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP1}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p2}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p2!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp2}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p2!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP2}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p3}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p3!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp3}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p3!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP3}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p4}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p4!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP4}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp4}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p4!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP4}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p5}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p5!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP5}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp5}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p5!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP5}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p6}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p6!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP6}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp6}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p6!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP6}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p7}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p7!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP7}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp7}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p7!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP7}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p8}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p8!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP8}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp8}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p8!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP8}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p9}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p9!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP9}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp9}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p9!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP9}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.p10}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p10!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbP10}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pp10}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_p10!=0}">
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totP10}" style="text-align:right" disabled="true" readonly="true">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:column>
                            <h:panelGrid width="100%" columns="3" headerClass="headerTab" styleClass="fichefournisseur" style="text-align:center">
                                <f:facet name="header"><h:outputText value="Billets"/></f:facet>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b1!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b1!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb1}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b1!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB1}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b2!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b2!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb2}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b2!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB2}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b3!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b3}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b3!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb3}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b3!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB3}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b4!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b4}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b4!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB4}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb4}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b4!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB4}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b5!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b5}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b5!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB5}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb5}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b5!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB5}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b6!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b6}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b6!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB6}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb6}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b6!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB6}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b7!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b7}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b7!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB7}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb7}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b7!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB7}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b8!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b8}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b8!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB8}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb8}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b8!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB8}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b9!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b9}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b9!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB9}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb9}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b9!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB9}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b10!=0}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.optionCaisses.b10}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b10!=0}"><a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.nbB10}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.pb10}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.val_b10!=0}">
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totB10}" style="text-align:right" disabled="true" readonly="true">
                                        <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid width="100%" columns="2" headerClass="headerTab" styleClass="fichefournisseur" style="text-align:center" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typePaveNumerique==9}">
                                <f:facet name="header"><h:outputText value="Autres paiements"/></f:facet>
                                <h:column><h:outputText value="Total Chèques:" style="text-align:center"/></h:column>
                                <h:column>
                                    <a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totalCheques}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.cheques}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique">

                                    </a4j:commandButton>
                                </h:column>
                                <h:column><h:outputText value="Total autres Devises:" style="text-align:center"/></h:column>
                                <h:column>
                                    <a4j:commandButton value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totalDevises}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.devises}" style="text-align:center;width:160px;font-size:30px" reRender="panelPaveNumerique">

                                    </a4j:commandButton>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="6">
                        <h:column><h:outputText value="Total Pièces:" style="text-align:center"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totalPiece}" style="text-align:right" disabled="true" readonly="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total Billets:" style="text-align:center"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totalBillet}" style="text-align:right" disabled="true" readonly="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="TOTAL CAISSE:" style="text-align:center"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.totalCaisse}" style="text-align:right" disabled="true" readonly="true">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup>
                        <center>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typePaveNumerique==8}" var="deb">
                                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.validerSession}" style="width:70px;height;70px" reRender="panelFondCaisse"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formTicketVentes.typePaveNumerique==9}" var="fin">
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.quitterTicket}" style="width:70px;height;70px"/>
                            </c:if>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
