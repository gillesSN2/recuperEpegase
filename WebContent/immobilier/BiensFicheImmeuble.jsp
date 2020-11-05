<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="ficheImmeuble">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="DESCRIPTION IMMEUBLE" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >

            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.nomOngletActif}">

                <rich:tab id="tabIdentification" label="Identification">
                    <h:panelGrid width="100%" id="idFiche" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Modules concernés:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="border:0px;color:red;width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.categorieReelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Location" itemValue="0"/>
                                <f:selectItem itemLabel="Syndic" itemValue="1"/>
                                <f:selectItem itemLabel="Negoce" itemValue="2"/>
                                <f:selectItem itemLabel="Promoteur" itemValue="3"/>
                                <f:selectItem itemLabel="Location/Negoce" itemValue="4" itemDisabled="true"/>
                                <f:selectItem itemLabel="Location/Syndic/Negoce" itemValue="5" itemDisabled="true"/>
                                <f:selectItem itemLabel="Syndic/Promoteur" itemValue="6" itemDisabled="true"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Gestion:"/></h:column>
                        <h:column>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.categorieReelle!=3}" var="et1">
                                <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieGestion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                    <f:selectItem itemLabel="Géré par l'agence" itemValue="0"/>
                                    <f:selectItem itemLabel="Plus géré par l'agence" itemValue="1"/>
                                </h:selectOneRadio>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.categorieReelle==3}" var="et2">
                                <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                    <f:selectItem itemLabel="En contruction" itemValue="0"/>
                                    <f:selectItem itemLabel="Disponible" itemValue="1"/>
                                    <f:selectItem itemLabel="Vendu" itemValue="2"/>
                                    <f:selectItem itemLabel="Litige" itemValue="3"/>
                                    <f:selectItem itemLabel="Détruit" itemValue="4"/>
                                </h:selectOneRadio>
                            </c:if>
                        </h:column>
                        <h:column><h:outputText value="Publication:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.biePublication}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Non publiée" itemValue="0"/>
                                <f:selectItem itemLabel="Publiée" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Code bien:"/></h:column>
                        <h:column>
                            <h:inputText id="idCode" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNum}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.uniciteCodeBien}" reRender="idCode,panelValide"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé bien:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Adresse:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieAdresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Rue N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieRue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Quartier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieQuartier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Commune:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCommune}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Zone:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieZone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Département:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieDepart}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Ville:"/></h:column>
                        <h:column>
                            <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieVille}"/>&nbsp;&nbsp;
                            <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                        </h:column>
                        <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                        <h:column id="idpays">
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNomPays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.mesPaysItems}" />
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionPays}" reRender="idpays"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idCompte" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Compte charge:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCompteCharge}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Compte gestion:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCompteGestion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDescription" label="Description">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%" id="idDescription1" styleClass="fichefournisseur" columns="2" columnClasses="clos15,clos85">
                        <h:column><h:outputText value="Catégorie"/></h:column>
                        <h:column>
                            <h:selectOneRadio style="border:0px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Economique" itemValue="0"/>
                                <f:selectItem itemLabel="Standard" itemValue="1"/>
                                <f:selectItem itemLabel="Grand Standing" itemValue="2"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Est-il en Copropriété ?"/></h:column>
                        <h:column>
                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.controleSaisie}" reRender="idDescription1,idmillieme1,idmillieme2,idTiers,idCode,panelValide"/>
                            </h:selectBooleanCheckbox>
                        </h:column>
                        <h:column><h:outputText id="idmillieme1" value="Total Millième" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==true}"/></h:column>
                        <h:column><h:inputText id="idmillieme2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieMillieme}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==true}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==false}"><h:outputText value="Nom Propiétaire"  style="text-decoration:underline"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==false}">
                            <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_action}" maxlength="100">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les propriétaires (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.rechercheProprietaire}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,idDescription1,idTiers,panelValide"/>
                            </h:inputText>&nbsp;
                            <a4j:commandButton image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                            <a4j:commandButton image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_detail_tiers&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_aff_action}" reRender="idTiers,idProprietaireSuite"/>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==false}">
                            <h:column><h:outputText value=""/></h:column>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCopropriete==false}">
                            <h:panelGrid width="95%" id="idProprietaireSuite" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers!=null}">
                                <h:column><h:outputText value="Adresse:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tieadresse}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Rue:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tierue}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Tel.1:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tieburtel1}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Tel.2:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tieburtel2}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Fax:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tieburfax}" disabled="true"/></h:column>
                                <h:column><h:outputText value="eMail:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tiemail1}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Ville:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tieville}" disabled="true"/></h:column>
                                <h:column><h:outputText value="Pays:"/></h:column>
                                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.tiers.tienompays}" disabled="true"/></h:column>
                            </h:panelGrid>
                        </h:column>
                        <h:column><h:outputText value="Nombre de bloc(s)"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbLocaux}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Mono bloc" itemValue="0"/>
                                <f:selectItem itemLabel="2 blocs" itemValue="2"/>
                                <f:selectItem itemLabel="3 blocs" itemValue="3"/>
                                <f:selectItem itemLabel="4 blocs" itemValue="4"/>
                                <f:selectItem itemLabel="5 blocs" itemValue="5"/>
                                <f:selectItem itemLabel="6 blocs" itemValue="6"/>
                                <f:selectItem itemLabel="7 blocs" itemValue="7"/>
                                <f:selectItem itemLabel="8 blocs" itemValue="8"/>
                                <f:selectItem itemLabel="9 blocs" itemValue="9"/>
                                <f:selectItem itemLabel="10 blocs" itemValue="10"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.calculeNbBloc}" reRender="idDescription1,idBlocs1,idBlocs2,tableBloc"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idBlocs1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbLocaux!=0}"><h:outputText value="Définition des blocs"/></h:column>
                        <h:column id="idBlocs2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbLocaux!=0}">
                            <a4j:region renderRegionOnly="false">
                                <rich:extendedDataTable styleClass="bg" id="tableBloc" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="300px" height="150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelBlocs}" var="blq">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionnerBloc}" reRender="modAttente,panelBoutonBlocs"/>
                                    <rich:column label="Numéro" sortable="true" width="50px" sortBy="#{blq.indice}">
                                        <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                        <h:outputText value="#{blq.indice}"/>
                                    </rich:column>
                                    <rich:column label="Code du bloc" sortable="true" width="100px" sortBy="#{blq.code}">
                                        <f:facet name="header"><h:outputText  value="Code bloc" /></f:facet>
                                        <h:inputText value="#{blq.code}" maxlength="20" style="width:90%"/>
                                    </rich:column>
                                    <rich:column label="Millième" sortable="true" width="100px" sortBy="#{blq.millieme}" style="text-align:right">
                                        <f:facet name="header"><h:outputText value="Millième"/></f:facet>
                                        <h:outputText value="#{blq.millieme}" rendered="#{blq.millieme!=0}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" id="idDescription2" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Lot N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieLot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Ilot N°:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieIlot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Superficie (m2):"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieSurperficie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Nombre Etage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbEtage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Bâtiment:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbBatiment}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Appartement:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbAppartement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Bureau:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbBureau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Ascenseur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbAscenseur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Garage:"/></h:column>
                        <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbGarage}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Nombre Parking:"/></h:column>
                        <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieNbParking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Jardin:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieJardin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Jardin Nu" itemValue="1"/>
                                <f:selectItem itemLabel="Jardin Planté" itemValue="2"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Piscine:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.biePiscine}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column rendered="false"><h:outputText value="Parking:"/></h:column>
                        <h:column rendered="false">
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieParking}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Groupe Electrogène:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieGroupElectrogene}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                        <h:column><h:outputText value="Gardien:"/></h:column>
                        <h:column>
                            <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieGardien}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <f:selectItem itemLabel="Sans" itemValue="0"/>
                                <f:selectItem itemLabel="Avec" itemValue="1"/>
                            </h:selectOneRadio>
                        </h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabCommentaire" label="Commentaires">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:outputText value="Description libre:" />
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieDescriptif}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabValeur" label="Valeur">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%" id="idChiffre" styleClass="fichefournisseur" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Titre Foncier:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieTitreFoncier}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Parcelle:"/></h:column>
                        <h:column><h:inputText style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieParcelle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                        <h:column><h:outputText value="Base Loyer:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieBaseLoyer}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Charges:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieCharges}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                         <h:column><h:outputText value="Prix vente:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieTmpValeurPv}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Date Achat/Vente:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieDateAchat}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action>=20}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDetailAppar" label="Appartements" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="panelBoutonAppartement" columns="4" width="250px" style="height:34px">
                            <a4j:commandButton title="Ajouter nouvel apartement" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterAppartement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Modifier l'appartement sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifierAppartement}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Supprimer l'appartement sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bien ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerAppartement}" reRender="scrollTableDetailAppartement,tableDetailAppartement,panelBoutonAppartement"/>
                            <a4j:commandButton title="Historique des propriétaires et des ventes" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonAppart&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.historiqueProprietaire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableDetailAppartement" id="scrollTableDetailAppartement" maxPages="20"align="left" for="tableDetailAppartement"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableDetailAppartement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelDetailAppartement}" var="det">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionAppartmeent}" reRender="panelBoutonAppartement"/>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{det.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{det.bieNum}"/>
                                </rich:column>
                                <rich:column label="Type" sortable="true" width="80px" sortBy="#{det.libelleType}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{det.libelleType}"/>
                                </rich:column>
                                <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{det.bieOccupe}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                    <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{det.bieOccupe==1}"/>
                                </rich:column>
                                <rich:column label="Nom du bien" sortable="true" width="100px" sortBy="#{det.bieNom}">
                                    <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                    <h:outputText value="#{det.bieNom}"/>
                                </rich:column>
                                <rich:column label="Type de bien" sortable="true" width="100px" sortBy="#{det.bieModele}">
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText value="#{det.bieModele}"/>
                                </rich:column>
                                <rich:column label="Code du bloc" sortable="true" width="100px" sortBy="#{det.bieCodeBloc}">
                                    <f:facet name="header"><h:outputText  value="Bloc" /></f:facet>
                                    <h:outputText value="#{det.bieCodeBloc}"/>
                                </rich:column>
                                <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{det.bieNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                    <h:outputText value="#{det.bieNomTiers}"/>
                                </rich:column>
                                <rich:column label="Millième" sortable="true" width="80px" sortBy="#{det.bieMillieme}">
                                    <f:facet name="header"><h:outputText  value="Millième" /></f:facet>
                                    <h:outputText value="#{det.bieMillieme}"/>
                                </rich:column>
                                <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{det.bieSurperficie}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                    <h:outputText value="#{det.bieSurperficie}" rendered="#{det.bieSurperficie!=0}" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Etage" sortable="true" width="80px" sortBy="#{det.bieEtage}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                                    <h:outputText value="#{det.bieEtage}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{det.bieNbPiece}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                    <h:outputText value="#{det.bieNbPiece}" rendered="#{det.bieNbPiece!=0}" />
                                </rich:column>
                                <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{det.bieBaseLoyer}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                    <h:outputText value="#{det.bieBaseLoyer}" rendered="#{det.bieBaseLoyer!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Charges" sortable="true" width="100px" sortBy="#{det.bieCharges}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                                    <h:outputText value="#{det.bieCharges}" rendered="#{det.bieCharges!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDetailBur" label="Bureaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="panelBoutonBureau" columns="4" width="250px" style="height:34px">
                            <a4j:commandButton title="Ajouter nouveau bureau" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterBureau}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Modifier le bureau sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifierBureau}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Supprimer le bureau sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bien ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerBureau}" reRender="scrollTableDetailBureau,tableDetailBureau,panelBoutonBureau"/>
                            <a4j:commandButton title="Historique des propriétaires et des ventes" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonBureau&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.historiqueProprietaire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableDetailBureau" id="scrollTableDetailBureau" maxPages="20"align="left" for="tableDetailBureau"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableDetailBureau" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelDetailBureau}" var="det">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionBureau}" reRender="panelBoutonBureau"/>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{det.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{det.bieNum}"/>
                                </rich:column>
                                <rich:column label="Type" sortable="true" width="80px" sortBy="#{det.libelleType}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{det.libelleType}"/>
                                </rich:column>
                                <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{det.bieOccupe}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                    <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{det.bieOccupe==1}"/>
                                </rich:column>
                                <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{det.bieNom}">
                                    <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                    <h:outputText value="#{det.bieNom}"/>
                                </rich:column>
                                <rich:column label="Type de bien" sortable="true" width="100px" sortBy="#{det.bieModele}">
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText value="#{det.bieModele}"/>
                                </rich:column>
                                <rich:column label="Code du bloc" sortable="true" width="100px" sortBy="#{det.bieCodeBloc}">
                                    <f:facet name="header"><h:outputText  value="Bloc" /></f:facet>
                                    <h:outputText value="#{det.bieCodeBloc}"/>
                                </rich:column>
                                <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{det.bieNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                    <h:outputText value="#{det.bieNomTiers}"/>
                                </rich:column>
                                <rich:column label="Millième" sortable="true" width="80px" sortBy="#{det.bieMillieme}">
                                    <f:facet name="header"><h:outputText  value="Millième" /></f:facet>
                                    <h:outputText value="#{det.bieMillieme}"/>
                                </rich:column>
                                <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{det.bieSurperficie}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                    <h:outputText value="#{det.bieSurperficie}" rendered="#{det.bieSurperficie!=0}" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Etage" sortable="true" width="80px" sortBy="#{det.bieEtage}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Etage" /></f:facet>
                                    <h:outputText value="#{det.bieEtage}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Nombre de pièces" sortable="true" width="80px" sortBy="#{det.bieNbPiece}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Nb Pièces" /></f:facet>
                                    <h:outputText value="#{det.bieNbPiece}" rendered="#{det.bieNbPiece!=0}" />
                                </rich:column>
                                <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{det.bieBaseLoyer}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                    <h:outputText value="#{det.bieBaseLoyer}" rendered="#{det.bieBaseLoyer!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Charges" sortable="true" width="100px" sortBy="#{det.bieCharges}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                                    <h:outputText value="#{det.bieCharges}" rendered="#{det.bieCharges!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabDetailGar" label="Garage" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%">
                        <h:panelGrid id="panelBoutonGarage" columns="4" width="250px" style="height:34px">
                            <a4j:commandButton title="Ajouter nouveau garage" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterGarage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Modifier le garage sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.modifierGarage}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                            <a4j:commandButton title="Supprimer le garage sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.usersChrono.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer le bien ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerGarage}" reRender="scrollTableDetailGarage,tableDetailGarage,panelBoutonGarage"/>
                            <a4j:commandButton title="Historique des propriétaires et des ventes" image="/images/extrait.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.visibiliteBtonPrking&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.historiqueProprietaire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.pageIndex}" reRender="tableDetailGarage" id="scrollTableDetailGarage" maxPages="20"align="left" for="tableDetailGarage"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableDetailGarage" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.datamodelDetailParking}" var="det">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionGarage}" reRender="panelBoutonGarage"/>
                                <rich:column label="Numéro du bien" sortable="true" width="70px" sortBy="#{det.bieNum}">
                                    <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                                    <h:outputText value="#{det.bieNum}"/>
                                </rich:column>
                                <rich:column label="Type" sortable="true" width="80px" sortBy="#{det.libelleType}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{det.libelleType}"/>
                                </rich:column>
                                <rich:column label="Occupé" sortable="true" width="30px" sortBy="#{det.bieOccupe}" style="text-align:center">
                                    <f:facet name="header"><h:outputText value="Occ."/></f:facet>
                                    <h:graphicImage value="/images/tiers.png" width="20px" height="20px" alt="pub" rendered="#{det.bieOccupe==1}"/>
                                </rich:column>
                                <rich:column label="Nom du bien" sortable="true" width="200px" sortBy="#{det.bieNom}">
                                    <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                                    <h:outputText value="#{det.bieNom}"/>
                                </rich:column>
                                <rich:column label="Code du bloc" sortable="true" width="100px" sortBy="#{det.bieCodeBloc}">
                                    <f:facet name="header"><h:outputText  value="Bloc" /></f:facet>
                                    <h:outputText value="#{det.bieCodeBloc}"/>
                                </rich:column>
                                <rich:column label="Propriétaire du bien" sortable="true" width="200px" sortBy="#{det.bieNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Propriétaire" /></f:facet>
                                    <h:outputText value="#{det.bieNomTiers}"/>
                                </rich:column>
                                <rich:column label="Millième" sortable="true" width="80px" sortBy="#{det.bieMillieme}">
                                    <f:facet name="header"><h:outputText  value="Millième" /></f:facet>
                                    <h:outputText value="#{det.bieMillieme}"/>
                                </rich:column>
                                <rich:column label="Superficie" sortable="true" width="80px" sortBy="#{det.bieSurperficie}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Superficie" /></f:facet>
                                    <h:outputText value="#{det.bieSurperficie}" rendered="#{det.bieSurperficie!=0}" >
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Loyer" sortable="true" width="100px" sortBy="#{det.bieBaseLoyer}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Loyer" /></f:facet>
                                    <h:outputText value="#{det.bieBaseLoyer}" rendered="#{det.bieBaseLoyer!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Charges" sortable="true" width="100px" sortBy="#{det.bieCharges}" style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Charges" /></f:facet>
                                    <h:outputText value="#{det.bieCharges}" rendered="#{det.bieCharges!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabScan" label="Scan documents" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="100%" id="idPanScan">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action<20}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelDocumnts}" id="listeDoc" var="document" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.lectureDoc}" reRender="panalVisuPj"/>
                                        <br>
                                        <h:outputText value="#{document}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabPhoto" label="Galerie Photos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <h:panelGrid width="150px" id="panelBoutonPhoto" columns="2">
                        <a4j:commandButton title="Ajouter un nouveau bien" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.add}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.ajouterPhoto}" reRender="panelPhoto"/>
                        <a4j:commandButton title="Supprimer le bien sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_affiche_photo&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menuimmobilier.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerPhoto}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo?')) return false" reRender="panelBoutonPhoto,tablePhoto"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable styleClass="bg" id="tablePhoto" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.dataModelPhotos}" var="photos">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.selectionPhoto}" reRender="panelBoutonPhoto"/>
                            <rich:column label="Photo" sortable="true" width="100%" style="text-align:center">
                                <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.urlIpProd}/epegase/imageServlet/#{photos}" alt="pho" height="400px" width="400px" style="text-align:center"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab id="tabBaux" label="Baux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <jsp:include flush="true" page="/immobilier/BiensCommunBaux.jsp" />
                </rich:tab>

                <rich:tab id="tabGerance" label="Gérances" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <jsp:include flush="true" page="/immobilier/BiensCommunGerances.jsp" />
                </rich:tab>

                <rich:tab id="tabTravaux" label="Travaux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.bien.bieId!=0}">
                    <jsp:include flush="true" page="/immobilier/BiensCommun.jsp" />
                    <jsp:include flush="true" page="/immobilier/BiensCommunTravaux.jsp" />
                </rich:tab>

            </rich:tabPanel>


            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.annulerBien}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.validerBien}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_valide_doc}"/>
                </center>
            </h:panelGroup>

        </h:panelGroup>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"   id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelPhoto" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPhoto}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPhoto}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES PHOTOS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fermerPhoto}" image="/images/close.gif" styleClass="hidelink" reRender="panelPhoto"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.uploadedFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.validerPhoto}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER DU BIEN"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.var_action<=20}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.formBiensImmobilier.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
