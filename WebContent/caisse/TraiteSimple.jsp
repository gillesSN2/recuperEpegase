<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="traitesimple">

    <a4j:form>

        <center><h2><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_intitule}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="firstGrid" styleClass="fichefournisseur" width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Date opération:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDateCreat}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateCai==0}"/></h:column>
                <h:column><h:outputText value="N° traite:"/></h:column>
                <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtNum}" disabled="true"/></h:column>
                <h:column><h:outputText value="Date début:"/></h:column>
                <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDateDebut}"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}"/></h:column>
                <h:column><h:outputText value="Nombre d'échéances:"/></h:column>
                <h:column>
                    <h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDuree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}">
                        <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.calculNbTraite}" reRender="idMontant,tableEcheance"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Périodicité:"/></h:column>
                <h:column>
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtPeriodicite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}">
                        <f:selectItem itemLabel="Hebdomadaire" itemValue="0"/>
                        <f:selectItem itemLabel="Mensuel" itemValue="1"/>
                        <f:selectItem itemLabel="Trimestriel" itemValue="2"/>
                        <f:selectItem itemLabel="Semestriel" itemValue="3"/>
                        <f:selectItem itemLabel="Annuel" itemValue="4"/>
                    </h:selectOneRadio>
                </h:column>
                
                <h:column><h:outputText value="Bénéficiaire:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idBene2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les éléments" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idBene2,prgtpAjt"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Référence Facture:"/></h:column>
                <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtFacture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}"/></h:column>
                <h:column><h:outputText value="Banque:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idBanque" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_banque}">
                        <f:selectItem itemLabel="Sélectionnez banque" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesBanquesItems}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <br>
            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                <rich:tab label="Montant">
                    <h:panelGrid id="panelDevise" width="100%">
                        <h:panelGrid id="idMontant" columns="6">
                            <h:column><h:outputText value="Devise:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idDevise" style="width:200px;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesdevisesItem}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.calculDevise}" reRender="panelDevise,idDeviseDevise,idDeviselocale,idDevise" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Coefficient:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtCoef}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="4" maxFractionDigits="4"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idDeviseDevise" columns="6" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.deviseLocale}" styleClass="fichefournisseur">
                            <h:column ><h:outputText value="Total facture (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtMontant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.calculMontant}" reRender="panelDevise,tableEcheance"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Nb déjà payé (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.nbDejaPaye}" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Cumul payé (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.montantPaye}" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reste du (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.montantReste}" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid id="idDeviselocale" columns="6" styleClass="fichefournisseur1">
                            <h:column><h:outputText value="Total facture (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtMontantLocal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_action==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.calculMontant}" reRender="panelDevise,tableEcheance"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Nb déjà payé (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.nbDejaPaye}" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Cumul payé (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.montantPayeLocal}" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reste du (#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}):"/></h:column>
                            <h:column>
                                <h:inputText style="width:95%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.montantResteLocal}" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Tableau">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable enableContextMenu="false" id="tableEcheance" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" height="300px" styleClass="bg" style="border:solid 0px green;text-align:left;" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.dataModelEcheance}" var="det">
                            <rich:column label="Etat" sortable="false" style="text-align:right;" width="80px">
                                <f:facet name="header"><h:outputText value="N°"/></f:facet>
                                <h:outputText value="#{det.trtligOrdre}"/>
                            </rich:column>
                            <rich:column label="Date échéance" sortable="false">
                                <f:facet name="header"><h:outputText  value="Echéances"/></f:facet>
                                <h:inputText  value="#{det.trtligDateTheorique}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant" sortable="false" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Montant #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/></f:facet>
                                <h:inputText  value="#{det.trtligMontantLocal}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Montant" sortable="false" style="text-align:right;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.deviseLocale}">
                                <f:facet name="header"><h:outputText  value="Montant #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDevise}"/></f:facet>
                                <h:outputText  value="#{det.trtligMontant}" rendered="#{det.trtligMontant!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Date dépôt" sortable="false">
                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                <h:outputText  value="#{det.trtligDateDepot}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="N° bordereau" sortable="false" width="150px">
                                <f:facet name="header"><h:outputText  value="N° Bdx"/></f:facet>
                                <h:outputText  value="#{det.trtligBordereau}"/>
                            </rich:column>
                            <rich:column label="Date retour" sortable="false">
                                <f:facet name="header"><h:outputText  value="Retour"/></f:facet>
                                <h:outputText  value="#{det.trtligDateRetour}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Motif de retour" sortable="false" width="150px">
                                <f:facet name="header"><h:outputText  value="Motif"/></f:facet>
                                <h:outputText  value="#{det.trtligMotif}"/>
                            </rich:column>
                            <rich:column label="Date report" sortable="false">
                                <f:facet name="header"><h:outputText  value="Report"/></f:facet>
                                <h:outputText  value="#{det.trtligDateReport}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Imputations">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_site}"><h:outputText value="Site:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_site}">
                            <h:selectOneMenu id="idSite" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtSite}" >
                                <f:selectItem itemLabel="Sélectonnez site" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesSitesItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_departement}"><h:outputText value="Département:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_departement}">
                            <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDepartement}" >
                                <f:selectItem itemLabel="Sélectionnez département" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.mesDepartementsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.chargerService}" reRender="panFiltre,idService" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_service}"><h:outputText value="Service:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_service}">
                            <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtService}" >
                                <f:selectItem itemLabel="Sélectionnez service" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.mesServicesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_region}"><h:outputText value="Région:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_region}">
                            <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtRegion}" >
                                <f:selectItem itemLabel="Sélectionnez région" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesRegionsItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_secteur}"><h:outputText value="Secteur:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_secteur}">
                            <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtSecteur}" >
                                <f:selectItem itemLabel="Sélectionnez secteur" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.mesSecteursItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.chargerPdv}" reRender="panFiltre,idPdv" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_pdv}"><h:outputText value="Point de vente:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_pdv}">
                            <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtPdv}" >
                                <f:selectItem itemLabel="Sélectionnez point de vente" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.mesPdvItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column></h:column>
                        <h:column></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_activite}"><h:outputText value="Activité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_activite}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtActivite}" >
                                <f:selectItem itemLabel="Sélectionnez activité" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesActivitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_dossier}"><h:outputText value="Dossier:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_dossier}">
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.traiteEntete.trtDossier}" >
                                <f:selectItem itemLabel="Sélectionnez dossier" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesDossiersItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Responsable">
                    <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                        <h:column><h:outputText value="User créateur:"/></h:column>
                        <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.userCreateur}" disabled="true"/></h:column>
                        <h:column><h:outputText value="User Modificateur:"/></h:column>
                        <h:column><h:inputText style="width:95%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.userModification}" disabled="true"/></h:column>
                        <h:column><h:outputText value="Responsable signataire:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.userResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRespCaissier==1}">
                                <f:selectItem itemLabel="Sélectionnez responsable" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesResponsablesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="prgtpAjt">
                <br><br>
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.saveTraite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formTraite.var_affiche_valide}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>
