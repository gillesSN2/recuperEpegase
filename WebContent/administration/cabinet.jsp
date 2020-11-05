<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="listecabinets">

    <a4j:form id="impgen">

        <center> <h2><h:outputText value="LISTE DES ENTITES : (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.libmode})" style="color:green;font-size:16px;"/></h2></center>

        <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
            <h:panelGrid id="pancab" columns="3" width="100%" >
                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.etat}" style="width:200px;" >
                    <f:selectItem itemLabel="Tous Etats" itemValue="9"/>
                    <f:selectItem itemLabel="Mandat En cours" itemValue="0"/>
                    <f:selectItem itemLabel="Mandat Terminé" itemValue="1" />
                    <f:selectItem itemLabel="Mandat En Litige" itemValue="2" />
                    <f:selectItem itemLabel="Mandat Abandonné" itemValue="3" />
                </h:selectOneMenu>
                <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.chargerSociete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tablesociete,pansoc"/>
                <a4j:commandButton value="CONFIGURATION DU GROUPE" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.configurationGroupe}" reRender="panelConfiguration" style="color:red"/>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="pansoc" columns="5" width="250px" style="height:34px">
            <a4j:commandButton image="/images/ajouter.png" title="Ajouter nouveau dossier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.ajouterSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCreationSociete==0}" reRender="panelSociete" />
            <a4j:commandButton image="/images/modifier.png" title="Modifier dossier sélectioné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.modifierSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strId!=0}" reRender="panelSociete"/>
            <a4j:commandButton image="/images/calendrier.png" title="Modifier mandat du dossier" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.modifierMandat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strId!=0}" reRender="panelMandat"/>
            <a4j:commandButton image="/images/tiers.png" title="Utilisateur du dossier sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.utilisateurSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strId!=0}" reRender="panelUsers"/>
            <a4j:commandButton image="/images/supprimer.png" title="Supprimer dossier sélectioné" rendered="false" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.supprimerSociete}" reRender="tablesociete,pansoc"/>
        </h:panelGrid>
        <a4j:region renderRegionOnly="false">
            <rich:extendedDataTable enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.dataModelLesSocietes}"  id="tablesociete" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" border="0" styleClass="bg" style="max-height:100%" rowClasses="rows1,rows2,rowsd" var="soc">
                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.selectionSociete}" reRender="pansoc" />
                <rich:column width="12%" >
                    <f:facet name="header" ><h:outputText value="Id du dossier"/></f:facet>
                    <h:outputText  value="#{soc.strId}"/>
                </rich:column>
                <rich:column width="8%" sortable="true" sortBy="#{soc.strraisonsociale}">
                    <f:facet name="header" ><h:outputText value="Mandat"/></f:facet>
                    <h:outputText  value="#{soc.libmandat}"/>
                </rich:column>
                <rich:column width="50%" >
                    <f:facet name="header" ><h:outputText value="Nom du dossier"/></f:facet>
                    <h:outputText  value="#{soc.strraisonsociale}"/>&nbsp;&nbsp;&nbsp;
                    <h:outputText  value="#{soc.strmod10}"/>
                </rich:column>
                <rich:column width="10%" >
                    <f:facet name="header" ><h:outputText value="Début"/></f:facet>
                    <h:outputText value="#{soc.strdtedebmandat}">
                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                    </h:outputText>
                </rich:column>
                <rich:column width="10%" >
                    <f:facet name="header" ><h:outputText value="Fin"/></f:facet>
                    <h:outputText value="#{soc.strdtefinmandat}">
                        <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                    </h:outputText>
                </rich:column>
                <rich:column width="10%" >
                    <f:facet name="header" ><h:outputText value="Pays"/></f:facet>
                    <h:outputText  value="#{soc.strnompays}"/>
                </rich:column>
            </rich:extendedDataTable>
        </a4j:region>

    </a4j:form>


    <!--------Modal panel societe------------->
    <rich:modalPanel domElementAttachment="parent"  id="panelSociete" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="1200" height="550" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.showModalPanelSociete}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES SOCIETES" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.fermerSociete}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalsociete" >
                <rich:tabPanel switchType="client" immediate="true" width="100%" style="border:0px">

                    <rich:tab  name="identification" label="Identification société">
                        <center>
                            <h:panelGrid  width="100%">
                                <h:panelGrid width="100%">
                                    <h:panelGrid width="100%" styleClass="fichefournisseur">
                                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos85">
                                            <h:column><h:outputText value="Raison Sociale:"/></h:column>
                                            <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strraisonsociale}" readonly="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.creationSociete}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid id="slDv" columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                            <h:column><h:outputText  value="Sigle:" /></h:column>
                                            <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strsigle}" /></h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Forme Juridique:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strformejuridique}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesFormeJuridiqueItem}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Type Entreprise:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strtypeentreprise}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesTypeEntrepriseItem}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Pays:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnompays}" >
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesPaysItem}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Format devise:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strformatdevise}">
                                                    <f:selectItem  itemValue="0" itemLabel="Format Dollar"/>
                                                    <f:selectItem  itemValue="1" itemLabel="Format Euro"/>
                                                    <f:selectItem  itemValue="2" itemLabel="Format CFA"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Devise:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strdevise}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesDevises}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Zone Commerciale:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strzonecommerciale}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesZoneCommercialeItem}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText style="text-decoration:underline;" value="Zone Fiscale:" /></h:column>
                                            <h:column>
                                                <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strzonefiscale}">
                                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.mesZoneFiscaleItem}" />
                                                </h:selectOneMenu>
                                            </h:column>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%">
                                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                            <h:outputText value="Adresse:" />
                                            <h:inputText size="30" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.stradresse}" />
                                            <h:outputText value="Ville:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strville}" />
                                            <h:outputText value="Rue N°:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strrue}" />
                                            <h:outputText value="Lot N°:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strlot}"/>
                                            <h:outputText value="Porte N°:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strporte}"/>
                                            <h:outputText value="Bâtiment:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strbatiment}" />
                                            <h:outputText value="Etage:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.stretage}" />
                                            <h:outputText value="Quartier:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strquartier}" />
                                            <h:outputText value="Commune:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strcommune}" />
                                            <h:outputText value="Zone:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strzone}" />
                                            <h:outputText value="Département:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strdepartement}"/>
                                            <h:outputText value="Boite Postale:"/>
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strbp}" />
                                            <h:outputText value="Cédex:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strcedex}" />
                                        </h:panelGrid>
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" styleClass="fichefournisseur">
                                        <h:panelGrid columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                            <h:outputText value="Téléphone 1:" />
                                            <h:inputText size="30"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strtel1}"/>
                                            <h:outputText value="Téléphone 2:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strtel2}" />
                                            <h:outputText value="Téléphone 3:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strtel3}" />
                                            <h:outputText value="Fax:" />
                                            <h:inputText size="30" maxlength="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strfax}"/>
                                            <h:outputText value="Télex:" />
                                            <h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strtelex}" />
                                            <h:outputText value="" />
                                            <h:outputText value="" />
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                    <rich:tab name="immatriculation" label="Immatriculations société" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.calculImmatriculation}">
                        <center>
                            <h:panelGrid width="90%" columns="2" columnClasses="clos50d,clos50g">
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm01=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm01}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm01=='')==false}"><h:inputText id="num1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum1}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm02=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm02}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm02=='')==false}"><h:inputText id="num2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum2}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm03=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm03}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm03=='')==false}"><h:inputText id="num3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum3}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm04=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm04}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm04=='')==false}"><h:inputText id="num4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum4}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm05=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm05}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm05=='')==false}"><h:inputText id="num5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum5}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm06=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm06}:" /></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm06=='')==false}"><h:inputText id="num6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum6}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm07=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm07}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm07=='')==false}"><h:inputText id="num7" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum7}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm08=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm08}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm08=='')==false}"><h:inputText id="num8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum8}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm09=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm09}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm09=='')==false}"><h:inputText id="num9" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum9}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm10=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm10}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm10=='')==false}"><h:inputText id="num10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum10}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm11=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm11}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm11=='')==false}"><h:inputText id="num11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum11}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm12=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm12}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm12=='')==false}"><h:inputText id="num12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum12}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm13=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm13}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm13=='')==false}"><h:inputText id="num13" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum13}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm14=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm14}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm14=='')==false}"><h:inputText id="num14" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum14}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm15=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm15}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm15=='')==false}"><h:inputText id="num15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum15}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm16=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm16}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm16=='')==false}"><h:inputText id="num16" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum16}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm17=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm17}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm17=='')==false}"><h:inputText id="num17" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum17}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm18=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm18}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm18=='')==false}"><h:inputText id="num18" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum18}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm19=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm19}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm19=='')==false}"><h:inputText id="num19" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum19}"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm20=='')==false}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm20}:"/></h:column>
                                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.objetImmatriculation.impm20=='')==false}"><h:inputText id="num20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strnum20}"/></h:column>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                    <rich:tab  name="module" label="Modules Activés">
                        <center>
                            <h:panelGrid width="90%" columns="2" columnClasses="clos50d,clos50g">
                                <h:column><h:outputText value="Module 1 (Comptabilité):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module01}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Comptabilité"/>
                                        <f:selectItem  itemValue="40100" itemLabel="Comptabilité Libérale" itemDisabled="true"/>
                                        <f:selectItem  itemValue="40200" itemLabel="Comptabilité Société"/>
                                        <f:selectItem  itemValue="40300" itemLabel="Comptabilité Projet"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 2 (Paye):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module02}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Paye"/>
                                        <f:selectItem  itemValue="50000" itemLabel="Paye + RH"/>
                                        <f:selectItem  itemValue="50200" itemLabel="Paye + RH + Gestion des temps"/>
                                        <f:selectItem  itemValue="50300" itemLabel="Roster"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 3 (Achats):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module03}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Achats"/>
                                        <f:selectItem  itemValue="60000" itemLabel="Achats standard"/>
                                        <f:selectItem  itemValue="60010" itemLabel="Achats Papiers"/>
                                        <f:selectItem  itemValue="60020" itemLabel="Achats Avicole"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 4 (Ventes):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module04}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Ventes"/>
                                        <f:selectItem  itemValue="80100" itemLabel="Ventes standard"/>
                                        <f:selectItem  itemValue="80200" itemLabel="Ventes + Comptoir"/>
                                        <f:selectItem  itemValue="80300" itemLabel="Fondation"/>
                                        <f:selectItem  itemValue="80400" itemLabel="Intérim"/>
                                        <f:selectItem  itemValue="80500" itemLabel="Cabinet" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.afficheCabinet}"/>
                                        <f:selectItem  itemValue="80600" itemLabel="Transit/Transport"/>
                                        <f:selectItem  itemValue="80700" itemLabel="Microfinancce" itemDisabled="true"/>
                                        <f:selectItem  itemValue="80800" itemLabel="Change Monaitaire" itemDisabled="true"/>
                                        <f:selectItem  itemValue="80900" itemLabel="Education"/>
                                        <f:selectItem  itemValue="81100" itemLabel="Pêcherie" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81200" itemLabel="Temples et cultes religieux" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81300" itemLabel="Partis politiques" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81400" itemLabel="Forêts" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81500" itemLabel="Médical: Infirmeries"/>
                                        <f:selectItem  itemValue="81510" itemLabel="Médical: Cabinets médicaux"/>
                                        <f:selectItem  itemValue="81520" itemLabel="Médical: Laboratoires"/>
                                        <f:selectItem  itemValue="81530" itemLabel="Médical: Pharmacies"/>
                                        <f:selectItem  itemValue="81540" itemLabel="Médical: Cliniques"/>
                                        <f:selectItem  itemValue="81550" itemLabel="Médical: Hopitaux"/>
                                        <f:selectItem  itemValue="81600" itemLabel="Immobiliers: Location"/>
                                        <f:selectItem  itemValue="81610" itemLabel="Immobiliers: Syndic"/>
                                        <f:selectItem  itemValue="81620" itemLabel="Immobiliers: Négoces" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81630" itemLabel="Immobiliers: BPT" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81700" itemLabel="Restaurants" itemDisabled="true"/>
                                        <f:selectItem  itemValue="81710" itemLabel="Hotelerie" itemDisabled="true"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 5 (Parc):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module05}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Parc"/>
                                        <f:selectItem  itemValue="70000" itemLabel=" Avec Parc"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 6 (Trésorerie):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module06}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Trésoreie"/>
                                        <f:selectItem  itemValue="90000" itemLabel="Avec Trésorerie"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Module 7 (Reporting):" /></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:211px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.module07}">
                                        <f:selectItem  itemValue="" itemLabel="Sans Reporting"/>
                                        <f:selectItem  itemValue="91000" itemLabel="Avec Reporting"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                        </center>
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <h:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.validerSociete}" id="valsoc" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <!--------Modal panel mandat------------->
    <rich:modalPanel domElementAttachment="parent"  id="panelMandat" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="400" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.showModalPanelMandat}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES MANDATS" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.fermerMandat}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalMandat" >
                <h:panelGrid  width="100%">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70d" width="100%">
                        <h:column><h:outputText value="Date début mandat:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strdtedebmandat}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                        </h:column>
                        <h:column><h:outputText value="Date fin mandat:"/></h:column>
                        <h:column>
                            <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strdtefinmandat}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                        </h:column>
                        <h:column><h:outputText value="Etat mandat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.stretatmandat}">
                                <f:selectItem itemLabel="En cours" itemValue="0"/>
                                <f:selectItem itemLabel="Terminé" itemValue="1" />
                                <f:selectItem itemLabel="Litige" itemValue="2" />
                                <f:selectItem itemLabel="Abandonné" itemValue="3" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <h:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.validerMandat}" id="valman"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <!--------Modal panel user------------->
    <rich:modalPanel domElementAttachment="parent"  id="panelUsers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.showModalPanelUsers}">
        <center>
            <f:facet name="header"><h:outputText value="GESTION DES UTILISATEURS DE LA STRUCTURE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.structurePeg.strraisonsociale}" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.fermerUsers}" image="/images/close.gif" styleClass="hidelink"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalUsers" >
                <h:panelGrid  width="100%" columns="2" id="idPanGlob">
                    <h:column>
                        <a4j:commandButton id="userCab" value="Ajouter utilisateur sélectionné ==>" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.ajouterUser}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableuserCabinet,tableuserAutorise"/>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.dataModelUsersCabinet}"  id="tableuserCabinet" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" height="300px" border="0" styleClass="bg" rowClasses="rows1,rows2,rowsd" var="userCab">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.selectionUserCabinet}" reRender="userCab"/>
                                <f:facet name="header" ><h:outputText value="Liste des utilisateurs du cabinet"/></f:facet>
                                <rich:column width="20%" sortBy="#{userCab.usrCivilite}">
                                    <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                    <h:outputText value="#{userCab.usrCivilite}" style="#{userCab.color}"/>
                                </rich:column>
                                <rich:column width="60%" sortBy="#{userCab.usrNom}">
                                    <f:facet name="header" ><h:outputText value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{userCab.usrNom} #{userCab.usrPrenom}" style="#{userCab.color}"/>
                                </rich:column>
                                <rich:column width="20%" sortBy="#{userCab.usrFonction}">
                                    <f:facet name="header" ><h:outputText value="Fonction"/></f:facet>
                                    <h:outputText value="#{userCab.usrFonction}" style="#{userCab.color}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="userEna" value="<== Supprimer utilisateur sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.supprimerUser}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableuserCabinet,tableuserAutorise"/>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable enableContextMenu="false" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.dataModelUsersAutorise}" id="tableuserAutorise" headerClass="headerTab" activeClass="active-row" noDataLabel=" " width="100%" height="300px" border="0" styleClass="bg" rowClasses="rows1,rows2,rowsd" var="userEna">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.selectionUserAutorise}" reRender="userEna"/>
                                <f:facet name="header" ><h:outputText value="Liste des utilisateurs autorisés"/></f:facet>
                                <rich:column width="20%" sortBy="#{userEna.usrCivilite}">
                                    <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                                    <h:outputText value="#{userEna.usrCivilite}" style="#{userEna.color}"/>
                                </rich:column>
                                <rich:column width="60%" sortBy="#{userEna.usrNom}">
                                    <f:facet name="header" ><h:outputText value="Nom et prénom"/></f:facet>
                                    <h:outputText value="#{userEna.usrNom} #{userEna.usrPrenom}" style="#{userEna.color}"/>
                                </rich:column>
                                <rich:column width="20%" sortBy="#{userEna.accesDirect}" id="idAccesDirect">
                                    <f:facet name="header" ><h:outputText value="Accès direct"/></f:facet>
                                    <a4j:commandButton id="idAccesDir1" value="sans" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.accesDirectAjout}" onclick="if (!confirm('Etes-vous sur de vouloir donner un accas direct à #{userEna.usrNom} #{userEna.usrPrenom}?')) return false" reRender="idAccesDirect,idAccesDir1,idAccesDir2" style="width:90%;color:red" rendered="#{userEna.accesDirect=='sans'}"/>
                                    <a4j:commandButton id="idAccesDir2" value="AVEC" immediate="true" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.accesDirectSuppres}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer l`accès direct de #{userEna.usrNom} #{userEna.usrPrenom}?')) return false" reRender="idAccesDirect,idAccesDir1,idAccesDir2" style="width:90%;color:blue" rendered="#{userEna.accesDirect=='AVEC'}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </h:column>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <!--------Modal panel configuration groupe------------->
    <rich:modalPanel domElementAttachment="parent"  id="panelConfiguration" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="300" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.showModalPanelConfiguration}">
        <center>
            <f:facet name="header"><h:outputText value="CONFIGURATION GROUPE" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.fermerConfigurationGroupe}" image="/images/close.gif" styleClass="hidelink" reRender="panelConfiguration"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalConfiguration" >
                <h:panelGrid  width="100%">
                    <h:panelGrid  columns="2" columnClasses="clos30,clos70d" width="100%">
                        <h:column><h:outputText value="Nature Groupe:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.typeGroupe}"/></h:column>
                        <h:column><h:outputText value="ID Groupe:"/></h:column>
                        <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.idGroupe}"/></h:column>
                        <h:column><h:outputText value="Nom Groupe:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.nomGroupe}" style="width:100%"/></h:column>
                        <h:column><h:outputText value="Synchroniser Office:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.synchroOffice}">
                                <f:selectItem itemLabel="Pas de synchronisation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Synchronisation" itemValue="1" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}"><h:outputText value="Synchroniser Tiers:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}">
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.synchroTiers}">
                                <f:selectItem itemLabel="Pas de synchronisation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Synchronisation" itemValue="1" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}"><h:outputText value="Synchroniser Produits:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}">
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.synchroProduits}">
                                <f:selectItem itemLabel="Pas de synchronisation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec Synchronisation" itemValue="1" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}"><h:outputText value="Centralisation comptabilité:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature>=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.cabinetPeg.cabNature<=4}">
                            <h:selectOneMenu style="width:210px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.optionGroupe.centralisationCompta}">
                                <f:selectItem itemLabel="Sans centralisation" itemValue="0"/>
                                <f:selectItem itemLabel="Avec centralisation" itemValue="1" />
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
                <h:panelGrid  width="100%" style="text-align:center;">
                    <a4j:commandButton image="/images/valider_big.png" title="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCabinet.validerConfigurationGroupe}" id="valconf" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelConfiguration"/>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
