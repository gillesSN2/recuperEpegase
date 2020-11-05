<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="chronocaisse">

    <a4j:form>

        <center> <h2><h:outputText value="CHRONOS DES CAISSES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="6" width="400px">
                <a4j:commandButton title="Ajouter un nouveau chrono" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.ajouterChrono}" reRender="panelChrono"/>
                <a4j:commandButton title="Mise à jour des chronos" image="/images/ajouterAuto.png" style="height:26px;width:26px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.majChronoAutmatique}" reRender="panelChronoAuto"/>
                <a4j:commandButton title="Modifier le chrono sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.modifierChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.visibiliteBton}" reRender="panelChrono"/>
                <a4j:commandButton title="Supprimer le chrono sélectionné" image="/images/supprimer.png" reRender="table"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.supprimerChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.visibiliteBton}"/>
                <a4j:commandButton title="Imprimer les chronos" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                <h:selectOneMenu id="idPeriode" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.periode}">
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.lesPeriodesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chargeChronoPeriode}" reRender="table,pangrpVisbt"/>
                </h:selectOneMenu>
            </h:panelGrid>
        </center>

        <br>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.datamodelChrono}" var="chr">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.selectionChrono}" reRender="pangrpVisbt"/>
                    <rich:column label="Nature" sortable="true" width="5%" sortBy="#{chr.chrNature}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Nat."/></f:facet>
                        <h:outputText value="#{chr.chrNature}" />
                    </rich:column>
                    <rich:column label="Libellé nature" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{chr.libnature}"/>
                    </rich:column>
                    <rich:column label="Série" sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                        <h:outputText value="#{chr.chrSerie}" />
                    </rich:column>
                    <rich:column label="Code caisse" sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                        <h:outputText value="#{chr.chrCodeCaisse}" />
                    </rich:column>
                    <rich:column label="Nom de la série" sortable="false" width="18%">
                        <f:facet name="header"><h:outputText  value="Nom"/></f:facet>
                        <h:outputText value="#{chr.chrNom}" />
                    </rich:column>
                    <rich:column label="Nombre de caractère" sortable="false" width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Nb car."/></f:facet>
                        <h:outputText value="#{chr.chrNbCar}" />
                    </rich:column>
                    <rich:column label="Préfixe" sortable="false" width="6%">
                        <f:facet name="header"><h:outputText  value="Préfixe"/></f:facet>
                        <h:outputText value="#{chr.chrPrefixe}" />
                    </rich:column>
                    <rich:column label="Numéro(s)" sortable="false" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Chrono"/></f:facet>
                        <h:outputText value="#{chr.lib_num}"/>
                    </rich:column>
                    <rich:column label="Suffixe" sortable="false" width="6%">
                        <f:facet name="header"><h:outputText  value="Suffixe"/></f:facet>
                        <h:outputText value="#{chr.chrSufixe}" />
                    </rich:column>
                    <rich:column label="Mode" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                        <h:outputText value="#{chr.libmode}" />
                    </rich:column>
                    <rich:column label="Format" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Format"/> </f:facet>
                        <h:outputText value="#{chr.libformat}" />
                    </rich:column>
                    <rich:column label="Période" sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Période"/></f:facet>
                        <h:outputText value="#{chr.chrPeriode}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>

        <br>

        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelChrono" width="500" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION D'UN CHRONO"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.annuleSaisie}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">

                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrId!=0}">
                            <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0" />
                            <f:selectItem itemLabel="60:Caisse" itemValue="60" />
                            <f:selectItem itemLabel="61:Reçu (règlement)" itemValue="61" />
                            <f:selectItem itemLabel="62:Bon de sortie" itemValue="62" />
                            <f:selectItem itemLabel="63:Bon d`entrée" itemValue="63" />
                            <f:selectItem itemLabel="64:Virement interne" itemValue="64" />
                            <f:selectItem itemLabel="65:Traites Domiciliées" itemValue="65" />
                            <f:selectItem itemLabel="66:Traites Simplifiées" itemValue="66" />
                            <f:selectItem itemLabel="67:Traites Entreprise" itemValue="67" />
                            <f:selectItem itemLabel="68:Inventaire caisse" itemValue="68" />
                            <f:selectItem itemLabel="69:Prévisionnel" itemValue="69" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idMode,idFormat,idNumerotation,pngValide,idCaisse1,idCaisse2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.selectNature}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column id="idCaisse1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature==61}"><h:outputText value="Code Caisse:"/></h:column>
                    <h:column id="idCaisse2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature==60||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature==61}">
                        <h:selectOneMenu style="width:200px" id="idCaisse" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.var_caisse}">
                            <f:selectItem itemLabel="Sélectionnez une caisse" itemValue=""/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.mesCaissesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idMode,idFormat,idNumerotation,pngValide,idNom" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.selectCaisse}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:inputText id="idSerie" size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSerie}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText id="idNom" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNom}"/></h:column>
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column>
                        <h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPeriode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNbCar}">
                            <f:selectItem itemLabel="3 c" itemValue="3"/>
                            <f:selectItem itemLabel="4 c" itemValue="4"/>
                            <f:selectItem itemLabel="5 c" itemValue="5"/>
                            <f:selectItem itemLabel="6 c" itemValue="6"/>
                            <f:selectItem itemLabel="7 c" itemValue="7"/>
                            <f:selectItem itemLabel="8 c" itemValue="8"/>
                            <f:selectItem itemLabel="9 c" itemValue="9"/>
                            <f:selectItem itemLabel="10 c" itemValue="10"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idNumerotation,idFormat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="idFormat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.mesFormats}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid  style="width:100%;" id="idNumerotation" >

                    <rich:panel id="tabStandard" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature!='61'}" style="border:1px;background-color:white;width:100%;">
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                            <h:column><h:outputText value="Préfixe:"/></h:column>
                            <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                            <h:column><h:outputText value="Chrono annuel:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn}" size="5"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                            <h:column><h:outputText value="Chrono janvier:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono février:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono mars:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono avril:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono mai:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono juin:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono juillet:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono aout:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono septembre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono octobre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono novembre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11}" size="5"/></h:column>
                            <h:column><h:outputText value="Chrono décembre:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12}" size="5"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                            <h:column><h:outputText value="Chrono:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum}" size="5"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                            <h:column><h:outputText value="Sufixe:"/></h:column>
                            <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                        </h:panelGrid>
                    </rich:panel>

                    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNature=='61'}">

                        <rich:tab id="tabEspeces" label="Global/Espèces">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabCheque" label="Chèque" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_1}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_1}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_1}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_1}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_1}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_1}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabVirement" label="Virement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_2}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_2}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_2}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_2}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_2}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_2}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabTraite" label="Traite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_3}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_3}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_3}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_3}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_3}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_3}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabTpe" label="T.P.E." rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type4&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_4}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_4}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_4}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_4}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_4}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_4}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabTansfert" label="Transfert" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type5&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_5}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_5}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_5}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_5}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_5}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_5}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabePaiement" label="ePaiement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type6&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_6}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_6}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_6}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_6}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_6}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_6}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabCredoc" label="Crédoc" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type7&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_7}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_7}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_7}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_7}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_7}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_7}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabFactor" label="Factor" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type8&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_8}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_8}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_8}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_8}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_8}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_8}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabCompense" label="Compense" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type9&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_9}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_9}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_9}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_9}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_9}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_9}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                        <rich:tab id="tabTerme" label="Terme" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.type10&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.optionCaisses.chronoReglement=='1'}">
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Préfixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPrefixe_A}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==0}">
                                <h:column><h:outputText value="Chrono annuel:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNumAn_A}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==1}">
                                <h:column><h:outputText value="Chrono janvier:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum01_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono février:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum02_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mars:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum03_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono avril:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum04_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono mai:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum05_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juin:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum06_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono juillet:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum07_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono aout:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum08_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono septembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum09_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono octobre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum10_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono novembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum11_A}" size="5"/></h:column>
                                <h:column><h:outputText value="Chrono décembre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum12_A}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode==2}">
                                <h:column><h:outputText value="Chrono:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNum_A}" size="5"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                                <h:column><h:outputText value="Sufixe:"/></h:column>
                                <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSufixe_A}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                            </h:panelGrid>
                        </rich:tab>

                    </rich:tabPanel>

                </h:panelGrid>

            </h:panelGrid>

            <h:panelGroup id="pngValide">
                <center>
                    <br>
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.saveChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.var_valide}" reRender="panelChrono,table,pangrpVisbt,idPeriode"/>
                    <br>
                    <h:outputText style="color:red;" value="La nature est obligatoire et doit être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.var_valide}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoAuto" width="500" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.showModalPanelAuto}">
        <f:facet name="header"><h:outputText value="MISE A JOUR AUTOMATIQUE DES CHRONOS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.annuleSaisieAutomatique}" image="/images/close.gif" styleClass="hidelink" id="hidelinkAuto"/>
                <rich:componentControl for="panelChronoAuto" attachTo="hidelinkAuto" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrPeriode}"/></h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrNbCar}">
                            <f:selectItem itemLabel="3 c" itemValue="3"/>
                            <f:selectItem itemLabel="4 c" itemValue="4"/>
                            <f:selectItem itemLabel="5 c" itemValue="5"/>
                            <f:selectItem itemLabel="6 c" itemValue="6"/>
                            <f:selectItem itemLabel="7 c" itemValue="7"/>
                            <f:selectItem itemLabel="8 c" itemValue="8"/>
                            <f:selectItem itemLabel="9 c" itemValue="9"/>
                            <f:selectItem itemLabel="10 c" itemValue="10"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:inputText id="idSerie" size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrSerie}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" id="mode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,numerotation,format" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.mesFormats}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br><br>
                <h:panelGrid  style="width:100%;" id="numerotation" border="0">
                    <div style="text-align:justify;color:red">
                                ATTENTION :<br>
                                <b></b> <br>
                                Les chronos dont les natures/séries n'existent pas déjà, seront créés.<br>
                                Les chronos dont les natures/séries exitent déjà auront leurs propriétés modifées:<br>
                                       - PERIODE<br>
                                       - MODE DE CALCUL<br>
                                       - FORMAT<br>
                                       - NB DE CARACTERES<br>
                                Mais les numéros de chronos sont conservés.<br><br><br>
                            </div>
                </h:panelGrid>
            </h:panelGrid>
            <h:panelGroup id="pngValide">
                <center>
                    <br>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoCaisses.saveChronoAuto}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelChronoAuto,pangrpVisbt"/>
                    </h:commandButton>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>

    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
