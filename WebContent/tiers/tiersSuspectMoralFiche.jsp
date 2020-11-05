<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="moralFiche">

    <a4j:form id="formMoralFiche"  enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText styleClass="titre" value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}" /></h2></center>

        <rich:tabPanel switchType="client" immediate="true" id="tabPanelFrniss" style="border:0px;">

            <rich:tab label="Identité">
                <h:panelGrid  width="100%" id="panGlobal">
                    <h:panelGrid width="100%">
                        <h:panelGrid width="100%">
                            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
                                <h:column><h:outputText value="Crée le:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiedatecreat}" readonly="true" disabled="true"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <h:outputText value="Sigle:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chronoActif}" style="color:red"/>&nbsp;&nbsp;
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesigle}" readonly="true" disabled="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chronoActif}" style="color:red"/>
                                </h:column>
                                <h:column><h:outputText value="Par:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomCreateur}" style="width:100%" readonly="true" disabled="true"/></h:column>
                                <h:column><h:outputText value="Raison sociale:" style="color:red"/></h:column>
                                <h:column>
                                    <h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase;color:red" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieraisonsocialenom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="Sigle/Appartenance:"/></h:column>
                                <h:column><h:inputText onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesigle}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Catégorie:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecategorie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCategoriesItems}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculTiersdivers}" reRender="panGlobal"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tielangue}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid  width="100%" styleClass="fichefournisseur1" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos85">
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieadresse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieville}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Google Map" image="/images/googleMap.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.googleMap}" style="width:11px;height:20px;"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalGoogleMap"/>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column id="idpays">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienompays}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionPays}" reRender="idpays"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid styleClass="fichefournisseur" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Téléphone 1:" style="color:red"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%;color:red" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieburtel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Cellulaire:" style="color:red"/></h:column>
                            <h:column>
                                <h:inputText style="width:85%;color:red" maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiecel1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                                </h:inputText>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ1}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText style="width:100%;" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieskype}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Mail:" style="color:red"/></h:column>
                            <h:column>
                                <h:inputText style="width:100%;color:red" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiemail1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid styleClass="fichefournisseur1" width="100%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Origine:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieorigine}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Local" itemValue="0"/>
                                    <f:selectItem itemLabel="Etranger" itemValue="1"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieprofession}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemValue="" itemLabel="Sélection activité" />
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesActivitesPMItems}" />
                                    <f:selectItem itemLabel="Autre" itemValue="99"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Voiture:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tievehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Sans" itemValue="0"/>
                                    <f:selectItem itemLabel="Véhicule personnel" itemValue="1"/>
                                    <f:selectItem itemLabel="Véhicule société" itemValue="2"/>
                                    <f:selectItem itemLabel="Autre" itemValue="99"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Statut occupation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiehabitation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Locataire" itemValue="0"/>
                                    <f:selectItem itemLabel="Propriétaire" itemValue="1"/>
                                    <f:selectItem itemLabel="Autre" itemValue="99"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Situation bancaire:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesitbnq}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Sans compte" itemValue="0"/>
                                    <f:selectItem itemLabel="Compte bancaire traditionnel" itemValue="1"/>
                                    <f:selectItem itemLabel="Compte micro finance " itemValue="2"/>
                                    <f:selectItem itemLabel="Autre " itemValue="99"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Etablissement bancaire:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienombanque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Sans compte" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesBanquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Situation épargne:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesitepg}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItem itemLabel="Sans épargne" itemValue="0"/>
                                    <f:selectItem itemLabel="Epargne bancaire traditionnelle" itemValue="1"/>
                                    <f:selectItem itemLabel="Bien immobilier" itemValue="2"/>
                                    <f:selectItem itemLabel="Action d'entreprise" itemValue="3"/>
                                    <f:selectItem itemLabel="Autre" itemValue="99"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Centre d'intéret:" style="color:red"/></h:column>
                            <h:column>
                                <a4j:commandButton id="idCin" style="width:100%;color:red;text-align:left;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ouvrirCentreInteret}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieinteret}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}" reRender="panelCentreInteret"/>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>

                    <h:panelGrid  width="100%" styleClass="fichefournisseur" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Observation:"/></h:column>
                            <h:column><h:inputTextarea rows="5" cols="200" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieobservations}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/></h:column>
                            <h:column> <h:outputText style="text-decoration:underline;color:red" value="Source:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tiesource}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesSourceItems}" />
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.calculeGenre}" reRender="idGenre"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Appréciation:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tienoteman}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}" />
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Photo" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="tiersPhotos,grp4"/>
                <jsp:include flush="true" page="/tiers/tiersPhotos.jsp" />
            </rich:tab>

            <rich:tab  label="Contacts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_tiersDivers}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid width="100%" styleClass="fichefournisseur1" id="idContact">
                    <h:panelGrid  id="btnContact" columns="4" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutContact}" reRender="panelContact,btnContact" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}" reRender="panelContact,btnContact"/>
                        <a4j:commandButton image="/images/detail.png" title="Consulter contact"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact}" reRender="panelContact,btnContact"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer contact" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteContact}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testContact&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableContact,btnContact"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable style="border:solid 0px green;" styleClass="fichefournisseur1" border="0" id="tableContact" width="100%" height="300px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelContact}" var="contact" >
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulContact}" reRender="btnContact"/>
                            <rich:column sortable="true" sortBy="#{contact.concivilite}" width="5%">
                                <f:facet name="header" ><h:outputText  value="Civil."/></f:facet>
                                <h:outputText  value="#{contact.concivilite}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.connom}" width="20%">
                                <f:facet name="header" ><h:outputText  value="Nom"/></f:facet>
                                <h:outputText  value="#{contact.connom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conprenom}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Prénom"/></f:facet>
                                <h:outputText  value="#{contact.conprenom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.contelbur}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tél.Bur."/></f:facet>
                                <h:outputText  value="#{contact.contelbur}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conteldom}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Tel.Dom."/></f:facet>
                                <h:outputText  value="#{contact.conteldom}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.concel1}" width="10%">
                                <f:facet name="header" ><h:outputText  value="Cel."/></f:facet>
                                <h:outputText  value="#{contact.concel1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.conmail1}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Email"/></f:facet>
                                <h:outputText  value="#{contact.conmail1}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{contact.confonction}" width="15%">
                                <f:facet name="header" ><h:outputText  value="Fonction"/></f:facet>
                                <h:outputText  value="#{contact.confonction}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
            </rich:tab>

            <rich:tab label="Conseillers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action>=2}">
                <jsp:include flush="true" page="/tiers/tiersCommun.jsp" />
                <h:panelGrid  id="rep1" width="100%" columnClasses="cols" styleClass="fichefournisseur1">
                    <h:panelGrid  id="rep11"  headerClass="headerTab" width="100%" >
                        <f:facet name="header"><h:outputText value="Visibilité du tiers"/></f:facet>
                        <h:column>
                            <h:panelGrid  width="100%" columns="1" >
                                <h:column>
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tievisibilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                                        <f:selectItem itemLabel="Public" itemValue="0"/>
                                        <f:selectItem itemLabel="Collaborateur" itemValue="1"/>
                                        <f:selectItem itemLabel="Privé" itemValue="2"/>
                                    </h:selectOneRadio>
                                </h:column>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  id="rep12"  headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                        <f:facet name="header"><h:outputText value="Conseillers du tiers"/></f:facet>
                        <h:column>
                            <h:panelGrid  width="100%" id="responsable" styleClass="fichefournisseur1">
                                <h:panelGrid id="btnReponsable" columns="5" width="150px" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" >
                                    <a4j:commandButton image="/images/ajouter.png" title="Ajout Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterResponsable}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/modifier.png" title="Modification Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/detail.png" title="Consultation Conseiller" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="panelResponsable,btnReponsable"/>
                                    <a4j:commandButton image="/images/chef.png" title="Conseiller par défaut" onclick="if (!confirm('Voulez-vous le définir comme le Conseiller par défaut?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsableDefaut}" reRender="tableResponsable,btnReponsable" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}"/>
                                    <a4j:commandButton image="/images/supprimer.png" title="Suppression Conseiller" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.deleteResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visibiliteBton}" reRender="modAttente,tableResponsable,btnReponsable"/>
                                </h:panelGrid>
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable style="border:solid 0px green;" border="0" id="tableResponsable" width="100%" height="200px" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" styleClass="bg" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.datamodelResponsable}" var="responsable" >
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" id="ajextFourniss" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterResponsable}" reRender="btnReponsable"/>
                                        <rich:column width="5%" >
                                            <f:facet name="header" ><h:outputText value="Déf."/></f:facet>
                                            <h:graphicImage  value="/images/chef.png" rendered="#{responsable.rpbdefaut==1}"/>
                                        </rich:column>
                                        <rich:column width="55%" >
                                            <f:facet name="header" ><h:outputText value="Conseiller"/></f:facet>
                                            <h:outputText value="#{responsable.rpbprenom}  #{responsable.rpbnom}"/>
                                        </rich:column>
                                        <rich:column width="20%" >
                                            <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                                            <h:outputText value="#{responsable.rpbcategorie}"/>
                                        </rich:column>
                                        <rich:column width="10%"  >
                                            <f:facet name="header" ><h:outputText value="Du"/></f:facet>
                                            <h:outputText value="#{responsable.rpbdatedebut}"/>
                                        </rich:column>
                                        <rich:column width="10%" >
                                            <f:facet name="header" ><h:outputText value="Au"/></f:facet>
                                            <h:outputText value="#{responsable.rpbdatefin}"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:panelGrid>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </rich:tab>

        </rich:tabPanel>

        <h:panelGroup id="panelButton">
            <center>
                <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.majTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.valideFiche&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action!=3}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,btnTiers,tableTiers"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"   id="panelResponsable" headerClass="headerPanel" width="650" height="350" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelResponsable}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelResponsable}" var="resp">
            <f:facet name="header"><h:outputText value="GESTION DES CONSEILLERS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annulerResponsable}" image="/images/close.gif" styleClass="hidelink" reRender="panelResponsable"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid style="background-color:#DAEECB;" width="100%">
                    <h:panelGrid  columns="1" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbid==0}">
                        <h:column><h:outputText value="Nom : Prénom"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="userItem" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.choixUsers}">
                                <f:selectItem itemLabel="Sélectionnez votre conseiller" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionResponsable}" reRender="valResponsable,outpAjt,idpanAjt,idpanRespon"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGrid  columns="2" width="100%" id="idpanRespon">
                        <h:column><h:outputText value="Nom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbnom}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Prénom:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbprenom}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Fonction:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbcategorie}" readonly="true" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Date début:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbdatedebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                        <h:column><h:outputText value="Date fin:"/></h:column>
                        <h:column><rich:calendar  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.responsable.rpbdatefin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  inputSize="8"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valResponsable">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveResponsable}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testDoubleResponsable}" reRender="panelResponsable,responsable"/>
                        <h:outputText  id="outpAjt" style="color:red;" value="Votre responsable doit être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.testDoubleResponsable}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="panelContact" headerClass="headerPanel" width="900" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelContact}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelContact}" var="ctc">
            <f:facet name="header"><h:outputText value="GESTION DES CONTACTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleContact}" image="/images/close.gif" styleClass="hidelink" reRender="panelContact"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concivilite}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCivilitesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Né(e) le:"/></h:column>
                    <h:column>
                        <a4j:outputPanel layout="block">
                            <rich:calendar   style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.condatenaissance}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" popup="true"/>
                        </a4j:outputPanel>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Prénom:"/></h:column>
                    <h:column><h:inputText maxlength="50" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conprenom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:capitalize"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confonction}"/></h:column>
                    <h:column><h:outputText style="text-decoration:underline;" value="Langue:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conlangue}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesLangueItems}" />
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <rich:tabPanel switchType="client" immediate="true" id="tabPanelContact" style="border:0px;">
                    <rich:tab label="Identité">
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35" >
                            <h:column><h:outputText value="Service:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conservice}"/></h:column>
                            <h:column><h:outputText value="Adresse:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conadresse}"/></h:column>
                            <h:column><h:outputText value="Rue N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conrue}"/></h:column>
                            <h:column><h:outputText value="Lot N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conlot}"/></h:column>
                            <h:column><h:outputText value="Ilot N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conilot}"/></h:column>
                            <h:column><h:outputText value="Porte N°:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conporte}"/></h:column>
                            <h:column><h:outputText value="Quartier:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conquartier}"/></h:column>
                            <h:column><h:outputText value="Commune:"/></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concommune}"/></h:column>
                            <h:column><h:outputText value="Zone:"/></h:column>
                            <h:column><h:inputText maxlength="30" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conzone}"/></h:column>
                            <h:column><h:outputText value="Départ.:"/></h:column>
                            <h:column><h:inputText maxlength="30" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.condeparte}"/></h:column>
                            <h:column><h:outputText value="Bâtiment:"/></h:column>
                            <h:column><h:inputText maxlength="10" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conbatiment}"/></h:column>
                            <h:column><h:outputText value="Escalier:"/></h:column>
                            <h:column><h:inputText maxlength="10" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conescalier}"/></h:column>
                            <h:column><h:outputText value="B.P.:"/></h:column>
                            <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conbp}"/></h:column>
                            <h:column><h:outputText value="Cédex:"/></h:column>
                            <h:column><h:inputText maxlength="20" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concedex}"/></h:column>
                            <h:column><h:outputText value="Ville:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conville}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.connompays}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPaysItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid styleClass="fichefournisseur" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Tél. bur.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.contelbur}"/></h:column>
                            <h:column><h:outputText value="Tél. dom.:"/></h:column>
                            <h:column><h:inputText maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conteldom}"/></h:column>
                            <h:column><h:outputText value="Cell. 1:"/></h:column>
                            <h:column>
                                <h:inputText maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel1}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ2}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 2:"/></h:column>
                            <h:column>
                                <h:inputText  maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel2}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ3}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Cell. 3:"/></h:column>
                            <h:column>
                                <h:inputText  maxlength="50" style="width:85%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.concel3}"/>&nbsp;&nbsp;
                                <a4j:commandButton title="Envoi SMS" image="/images/sms.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoiSmsZ4}" style="width:28px;height:18px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" reRender="modalSms"/>
                            </h:column>
                            <h:column><h:outputText value="Fax:"/></h:column>
                            <h:column><h:inputText  maxlength="50" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.confax}"/></h:column>
                            <h:column><h:outputText value="Skype:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conskype}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Mail 1:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail1}"/></h:column>
                            <h:column><h:outputText value="Mail 2:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail2}"/></h:column>
                            <h:column><h:outputText value="Mail 3:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail3}"/></h:column>
                            <h:column><h:outputText value="Mail 4:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail4}"/></h:column>
                            <h:column><h:outputText value="Mail 5:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conmail5}"/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="Site Web:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conweb}"/></h:column>
                            <h:column><h:outputText value="Blog:"/></h:column>
                            <h:column><h:inputText maxlength="100" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conblog}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                            <h:column><h:outputText value="Obs.:"/></h:column>
                            <h:column><h:inputText maxlength="80" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conobservation}"/></h:column>
                            <h:column><h:outputText style="text-decoration:underline;" value="Appréc.:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conappreciation}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value="ACCES ESPACE CLIENT:"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contacts.conPwEspaceClient}" style="width:100%;text-align:center;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1}"><h:outputText value=""/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab label="Campagne" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers==3}">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableParticipantContact" maxPages="20" align="left" for="tableParticipantContact"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableParticipantContact" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelParticipantsContact}" var="par">
                                <rich:column label="Date visite" sortable="true" sortBy="#{par.camparDate}" width="15%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{par.camparDate}">
                                        <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Campagne" sortable="true" sortBy="#{par.campagneEnteteVentes.camObjet}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Campagne"/></f:facet>
                                    <h:outputText value="#{par.campagneEnteteVentes.camObjet}"/>
                                </rich:column>
                                <rich:column label="Nom prénom du participant" sortable="true" sortBy="#{par.contacts.conpatronyme}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{par.contacts.conpatronyme}"/>
                                </rich:column>
                                <rich:column label="Fonction" sortable="true" sortBy="#{par.contacts.confonction}" width="15%">
                                    <f:facet name="header"><h:outputText  value="Fonction"/></f:facet>
                                    <h:outputText  value="#{par.contacts.confonction}"/>
                                </rich:column>
                                <rich:column label="Téléphone" sortable="true" sortBy="#{par.contacts.concel1}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Téléphne"/></f:facet>
                                    <h:outputText  value="#{par.contacts.concel1}"/>
                                </rich:column>
                                <rich:column label="eMail" sortable="true" sortBy="#{par.contacts.mailCumul}" width="20%">
                                    <f:facet name="header"><h:outputText  value="eMail"/></f:facet>
                                    <h:outputText  value="#{par.contacts.mailCumul}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab label="Cadeaux">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTableCadeaux" maxPages="20" align="left" for="tableCadeaux"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}" style="max-height:100%;" styleClass="bg" id="tableCadeaux" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelCadeaux}" var="cad">
                                <rich:column label="Date visite" sortable="true" sortBy="#{cad.cadDate}" width="15%">
                                    <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                    <h:outputText value="#{par.camparDate}">
                                        <f:convertDateTime pattern="dd/MM/yy HH:mm" locale="fr"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Campagne" sortable="true" sortBy="#{cad.cadCampagne}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Campagne"/></f:facet>
                                    <h:outputText value="#{cad.cadCampagne}"/>
                                </rich:column>
                                <rich:column label="Code prouit" sortable="true" sortBy="#{cad.cadCode}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                    <h:outputText value="#{cad.cadCode}"/>
                                </rich:column>
                                <rich:column label="Libelle produit" sortable="true" sortBy="#{cad.cadLibelle}" width="35%">
                                    <f:facet name="header"><h:outputText  value="Libellé produit"/></f:facet>
                                    <h:outputText  value="#{cad.cadLibelle}"/>
                                </rich:column>
                                <rich:column label="Dépôt" sortable="true" sortBy="#{cad.cadDepot}" width="20%">
                                    <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                    <h:outputText  value="#{cad.cadDepot}"/>
                                </rich:column>
                                <rich:column label="Quantité" sortable="true" sortBy="#{cad.cadQte}" width="10%">
                                    <f:facet name="header"><h:outputText  value="Qte."/></f:facet>
                                    <h:outputText  value="#{cad.cadQte}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>
                <br/>
                <center>
                    <h:panelGroup id="valContact">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanCont" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.saveContact}" reRender="panelContact,idContact"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="modalGoogleMap" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalGoogleMap}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalGoogleMap}" var="map">
            <f:facet name="header"><h:outputText value="LOCALISATION"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.annuleGoogleMap}" image="/images/close.gif" styleClass="hidelink" reRender="modalGoogleMap"/>
                    <rich:componentControl for="modalGoogleMap" attachTo="hidelink" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <iframe
                        name="affMap" frameborder="0" width="650" height="420" scrolling="yes" style="border:0" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.uri}" align="center" title="Localisation GoogleMap">
                    </iframe>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"   id="modalSms" headerClass="headerPanel" width="500" height="200" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelSms}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelSms}" var="sms">
            <f:facet name="header"><h:outputText value="ENVOI SMS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerSms}" image="/images/close.gif" styleClass="hidelink" reRender="modalSms"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                    <h:column><h:outputText value="Numéro mobile:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.numeroMobile}" readonly="true"/></h:column>
                    <h:column><h:outputText value="Texte message:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.messageSms}" maxlength="160" style="width:95%"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="valSms">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.valideEnvoiSms}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,modalSms"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="panelCentreInteret" headerClass="headerPanel" width="700" height="500" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelCentreInteret}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelCentreInteret}" var="cin">
            <f:facet name="header"><h:outputText value="SELECTION CENTRES D`INTERET"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerCentreInteret}" image="/images/close.gif" styleClass="hidelink" reRender="panelCentreInteret"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable styleClass="bg" id="tableCentreInteret" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelCentreInteret}" var="cin">
                        <rich:column label="Sélection" sortable="true" sortBy="#{cin.select}" width="20%">
                            <f:facet name="header"><h:outputText  value="Sélection"/></f:facet>
                            <h:selectBooleanCheckbox value="#{cin.select}"/>
                        </rich:column>
                        <rich:column label="Libelle produit" sortable="true" sortBy="#{cin.libelle}" width="75%">
                            <f:facet name="header"><h:outputText  value="Centre Intérêt"/></f:facet>
                            <h:outputText  value="#{cin.libelle}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <center>
                    <h:panelGroup id="valCin">
                        <a4j:commandButton image="/images/valider_big.png" id="idpanAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.validerCenterInteret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelCentreInteret,panelButton,idCin"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>