<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
<h:panelGrid id="pngTierFact" width="100%" columnClasses="cols">
    <h:panelGrid  id="infdiv" width="100%" headerClass="headerTab" >
        <f:facet name="header"><h:outputText value="Informations générales"/></f:facet>
        <h:column>
            <h:panelGrid id="prest97bis" width="100%" columns="2" columnClasses="clos50,clos50">

                <h:panelGrid id="prest97" width="100%" columns="2" columnClasses="clos50,clos50" border="1">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.decrmtPrsChrStock=='2'}"><h:outputText value="Plafond patente:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.decrmtPrsChrStock=='2'}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieplafpatente}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </c:if>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.decrmtPrsChrStock=='2'}"><h:outputText value="C.A. patente:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.optionVentes.decrmtPrsChrStock=='2'}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecapatente}" style="text-align:right;" readonly="true">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </c:if>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Plafond autorisé:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieplafond}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </c:if>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Compte à surveiller:" style="color:blue"/></h:column>
                    <h:column>
                        <h:selectOneRadio id="idlitigie1" style="color:blue" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesurveille}" disabled="true">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>&nbsp;&nbsp;
                        <a4j:commandButton value="Change" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.changeCompteSurveille}" onclick="if (!confirm('Etes-vous sur de vouloir changer l`état du compte ?')) return false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.genre=='YYY'}" reRender="prest97,idlitigie1"/>
                    </h:column>
                    <h:column><h:outputText value="Compte bloqué:" style="color:red"/></h:column>
                    <h:column>
                        <h:selectOneRadio id="idlitigie2" style="color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecomptebloque}" disabled="true">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>&nbsp;&nbsp;
                        <a4j:commandButton value="Change" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.changeCompteBloque}" onclick="if (!confirm('Etes-vous sur de vouloir changer l`état du compte ?')) return false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.genre=='YYY'}" reRender="prest97,idlitigie2"/>
                    </h:column>
                    <h:column><h:outputText value="Chèque interdit:" style="color:red"/></h:column>
                    <h:column>
                        <h:selectOneRadio id="idlitigie3" style="color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiechequeinterdit}" disabled="true">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>&nbsp;&nbsp;
                        <a4j:commandButton value="Change" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.changeCompteInterdit}" onclick="if (!confirm('Etes-vous sur de vouloir changer l`état du compte ?')) return false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.genre=='YYY'}" reRender="prest97,idlitigie3"/>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <a4j:commandButton value="Affiche Détail" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ouvrirIncident}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelIncidentsPaiement"/>
                </h:panelGrid>

                <h:panelGrid id="prest99" width="100%" columns="2" columnClasses="clos50,clos50" border="1">
                    <h:column><h:outputText value="Dernier réglement:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteRegement}"  inputSize="10"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernier devis:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument1}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernière commande:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument2}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernière livraison:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument3}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernier retour:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument4}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernière facture:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument5}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernière note débit:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument6}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Dernier avoir:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDteDocument7}"  inputSize="10" datePattern="dd/MM/yyyy HH:mm" locale="fr" style=" background-color:white;" disabled="true" readonly="true"/></h:column>
                </h:panelGrid>

            </h:panelGrid>

            <h:panelGrid width="100%" id="prest105" columns="2" styleClass="fichefournisseur1" columnClasses="clos20,clos80">
                <h:column><h:outputText value="Devise:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.devise}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesdevisesItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Famille de tiers:"/></h:column>
                <h:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'}">
                        <h:selectOneMenu  style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienomfamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                            <f:selectItem itemValue="100" itemLabel="Sélectionnez une famille"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesFamilleFournisseursItems}"  />
                            <a4j:support eventsQueue="maQueue" reRender="pngTierFact,prest105" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculFamilleTiers}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!='0'}">
                        <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienomfamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                            <f:selectItem itemValue="100" itemLabel="Sélectionnez une famille"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesFamilleClientsItems}"  />
                            <a4j:support eventsQueue="maQueue" reRender="pngTierFact,prest105" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculFamilleTiers}"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:column>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'}" var="tvafour">
                    <h:column><h:outputText value="TVA/PRECOMPTE:"/></h:column>
                    <h:column>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieexotva}" disabled="true">
                            <f:selectItem itemLabel="AVEC TVA" itemValue="0"/>
                            <f:selectItem itemLabel="EXONERE TVA" itemValue="1"/>
                            <f:selectItem itemLabel="PRECOMPTE" itemValue="2"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Douanes:"/></h:column>
                    <h:column>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieexodouane}" disabled="true">
                            <f:selectItem itemLabel="AVEC DOUANES" itemValue="0"/>
                            <f:selectItem itemLabel="EXONERE DE DOUANES" itemValue="1"/>
                            <f:selectItem itemLabel="TAUX REDUIT" itemValue="2"/>
                        </h:selectOneRadio>
                    </h:column>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!='0'}" var="tvacli">
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}"><h:outputText value="Exonéré de TVA:"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}">
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieexotva}" disabled="true">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}"><h:outputText value="Exonéré de douanes:"/></h:column>
                    <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}">
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieexodouane}" disabled="true">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}"><h:outputText value="Exonéré de CSS:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strcodepays=='0077'}">
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecss}">
                            <f:selectItem itemLabel="Non" itemValue="0"/>
                            <f:selectItem itemLabel="Oui" itemValue="1"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeVente==806}"><h:outputText value="Minimum facturation:"/></h:column>
                    <h:inputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeVente==806}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieMontantMini}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==0}">
                            <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==1}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieFormatDevise==2}">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                        </c:if>
                    </h:inputText>
                </c:if>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}"><h:outputText value="Assujettissement:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}">
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieAssujettissement}">
                        <f:selectItem itemLabel="Aucun" itemValue="0"/>
                        <f:selectItem itemLabel="I.R.P.P." itemValue="1"/>
                        <f:selectItem itemLabel="I.S." itemValue="2"/>
                    </h:selectOneRadio>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}"><h:outputText value="Déclaration TVA:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}">
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDeclarationTva}">
                        <f:selectItem itemLabel="Aucun" itemValue="0"/>
                        <f:selectItem itemLabel="Etablissement Chèque" itemValue="1"/>
                        <f:selectItem itemLabel="Déclaration par l'agence" itemValue="2"/>
                        <f:selectItem itemLabel="Reversement dans son compte" itemValue="3"/>
                    </h:selectOneRadio>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}"><h:outputText value="Zone fiscale de déclaration:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.immobExist}">
                    <h:selectOneMenu style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiefiscal}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="" itemLabel="Sélection zone" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesZonesFiscales}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Série par défaut:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="serie" style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieserie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="" itemLabel="Sans Série"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSeriesItems}"  />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" id="prest106" columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.interimExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0}">
                <h:column><h:outputText value="Dépôt par défaut:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="depot" style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedepot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="" itemLabel="Sans dépôt"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesDepotItems}"  />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Taux d'escompte (%):"/></h:column>
                <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieescompte}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Client Interne'}"><h:outputText value="Mode facturation:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Client Interne'}">
                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiefacpr}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemLabel="Normal" itemValue="0"/>
                        <f:selectItem itemLabel="Facturation au PR avec taxes" itemValue="1"/>
                        <f:selectItem itemLabel="Facturation au PR sans taxes" itemValue="2"/>
                    </h:selectOneRadio>
                </h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}"><h:outputText value="Point de vente:" style="text-decoration:underline"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}">
                    <h:selectOneMenu id="pdv" style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.codeAgence}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="" itemLabel="Sans point de vente"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPdvItems}"  />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}"><h:outputText value="Région:" style="text-decoration:underline"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}">
                    <h:selectOneMenu id="reg" style="width:250px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.codeAgence}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="" itemLabel="Sans région"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesRegionsItems}"  />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" id="prest107" columns="2" styleClass="fichefournisseur" headerClass="headerTab" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.interimExist&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietype!=0}">
                <f:facet name="header"><h:outputText value="Facturation intérim"/></f:facet>
                <h:column><h:outputText value="Base de calcul:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="modeCalcul" style="width:400px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemodecom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="0" itemLabel="Sans calcul"/>
                        <f:selectItem itemValue="1" itemLabel="Calcul sur rubriques sélectionnées"/>
                        <f:selectItem itemValue="2" itemLabel="Calcul sur rubriques Imposables + Non imposables + Charges Patronales"/>
                        <f:selectItem itemValue="11" itemLabel="Calcul sur le salaire brut"/>
                        <f:selectItem itemValue="12" itemLabel="Calcul sur le salaire net"/>
                        <f:selectItem itemValue="13" itemLabel="Calcul sur le net à payer"/>
                        <f:selectItem itemValue="14" itemLabel="Calcul sur le brut + charges patronales"/>
                        <f:selectItem itemValue="15" itemLabel="Calcul sur le brut + charges patronales + provisions CP"/>
                        <f:selectItem itemValue="15" itemLabel="Calcul sur le brut (hors heures supp.) + charges patronales + provisions CP"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Mode commission:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="modeCommission" style="width:400px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieDeclarationTva}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="0" itemLabel="Commission sur %"/>
                        <f:selectItem itemValue="1" itemLabel="Commission sur forfait par salarié"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="% de commission/forfait:" style="text-decoration:underline"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tietauxcom}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column><h:outputText value="Mode présentation:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="modePresentation" style="width:400px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieAssujettissement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="0" itemLabel="Ligne Gain et Ligne Charges et Ligne Provisions"/>
                        <f:selectItem itemValue="1" itemLabel="Ligne Débours"/>
                        <f:selectItem itemValue="2" itemLabel="Ligne Détaillée"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Mode de facturation:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:selectOneMenu id="modeFacturation" style="width:400px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiefacpr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <f:selectItem itemValue="0" itemLabel="Facture globale"/>
                        <f:selectItem itemValue="1" itemLabel="Facture ventilée par agents"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strcodepays=='0202'}"><h:outputText value="Taux de CSS - accident de travail (%):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.structureLog.strcodepays=='0202'}">
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecoefpvmedical}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/>&nbsp;&nbsp;
                    <h:outputText value="(900030)"/>
                </h:column>
                <h:column><h:outputText value="Services du client:" style="text-decoration:underline"/></h:column>
                <h:column>
                    <h:panelGrid columns="3" width="200px" id="btnServiceInterim" style="height:34">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout service interim" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterServiceInterim}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pannelServiceInterim"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier service interim" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierServiceInterim}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheServiceInterim}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pannelServiceInterim"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Suppression service interim" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheServiceInterim}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="btnServiceInterim,tableServiceInterim,modAttente" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerServiceInterim}"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable rows="100" styleClass="bg" id="tableServiceInterim" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0"  width="100%" height="200px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelServiceInterim}" var="srv">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selctionSericeInterim}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,btnServiceInterim"/>
                            <rich:column label="Code service" sortable="true" width="30%" sortBy="#{srv.sitCode}" sortOrder="ASCENDING">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{srv.sitCode}"/>
                            </rich:column>
                            <rich:column label="Libelle service" sortable="true" width="70%" sortBy="#{srv.sitNomFr}">
                                <f:facet name="header"><h:outputText  value="Libellé service"/></f:facet>
                                <h:outputText  value="#{srv.sitNomFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" columns="2" styleClass="fichefournisseur1" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Assureur'}">
                <h:column><h:outputText value="Formule assurance:"/></h:column>
                <h:column>
                    <h:outputText value="A = (FOB + FRET) * T1%"/><br>
                    <h:outputText value="B = A + T2"/><br>
                    <h:outputText value="C = B * T3%"/><br>
                    <h:outputText value="D = B + C"/><br>
                </h:column>
                <h:column><h:outputText value="T1%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieassurt1}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column><h:outputText value="T2:"/></h:column>
                <h:column>
                    <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieassurt2}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="T3%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieassurt3}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" columns="2" styleClass="fichefournisseur1" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Banque'}">
                <h:column><h:outputText value="Formule frais financier:"/></h:column>
                <h:column>
                    <h:outputText value="A = SWIFT + (MONTANT VRT * TAUX BANQUE% ) * TAF%"/><br>
                    <h:outputText value="B = MONTANT VRT * TAXE DE TRANSFERT%"/><br>
                    <h:outputText value="C = FRAIS DE DOSSIER * TAF%"/><br>
                    <h:outputText value="D = FRAIS DIVERS"/><br>
                    <h:outputText value="F = (MONTANT VRT * TAUX COMMISSION DE COUVERTURE ) * TAF%"/><br>
                    <h:outputText value="G = (A * Nb VRT) + B + C + D + F"/><br>
                </h:column>
                <h:column><h:outputText value="SWIFT:"/></h:column>
                <h:column>
                    <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq1}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="TAUX BANQUE%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq2}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column><h:outputText value="FRAIS DOSSIER:"/></h:column>
                <h:column>
                    <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq3}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="TAXE DE TRANSFERT%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq4}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column>
                    <h:outputText value="FRAIS DIVERS:"/></h:column>
                <h:column>
                    <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq5}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="TAUX COMM. COUVERTURE%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq7}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                <h:column><h:outputText value="TAF%:"/></h:column>
                <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiebnq6}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" styleClass="fichefournisseur1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Transporteur'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie=='Transitaire'}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable rows="100" styleClass="bg" id="tableConditionCalcul" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0"  width="100%" height="200px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelConditionCalcul}" var="frs">
                        <rich:column label="Code frais" sortable="true" width="10%" sortBy="#{frs.fstCode}">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{frs.fstCode}"/>
                        </rich:column>
                        <rich:column label="Libelle condition calcul frais" sortable="true" width="20%" sortBy="#{frs.fstNomFr}">
                            <f:facet name="header"><h:outputText  value="Libellé condition calcul frais"/></f:facet>
                            <h:outputText  value="#{frs.fstNomFr}"/>
                        </rich:column>
                        <rich:column label="Formule" sortable="true" width="15%" sortBy="#{frs.fstFormuleA}">
                            <f:facet name="header"><h:outputText  value="Formule"/></f:facet>
                            <h:outputText  value="#{frs.fstFormuleA}"/>
                        </rich:column>
                        <rich:column label="Formule" sortable="true" width="15%" sortBy="#{frs.fstFormuleB}">
                            <f:facet name="header"><h:outputText  value="Formule"/></f:facet>
                            <h:outputText  value="#{frs.fstFormuleB}"/>
                        </rich:column>
                        <rich:column label="Formule" sortable="true" width="15%" sortBy="#{frs.fstFormuleC}">
                            <f:facet name="header"><h:outputText  value="Formule"/></f:facet>
                            <h:outputText  value="#{frs.fstFormuleC}"/>
                        </rich:column>
                        <rich:column label="Formule" sortable="true" width="15%" sortBy="#{frs.fstFormuleD}">
                            <f:facet name="header"><h:outputText  value="Formule"/></f:facet>
                            <h:outputText  value="#{frs.fstFormuleD}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>

        </h:column>
    </h:panelGrid>
</h:panelGrid>



