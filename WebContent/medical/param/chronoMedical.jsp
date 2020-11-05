<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="chronomedical">
    <a4j:form>

        <center> <h2><h:outputText value="CHRONOS DU MEDICAL" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="6" width="400px">
                <a4j:commandButton title="Ajouter un nouveau chrono" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.ajouterChrono}" reRender="panelChrono"/>
                <a4j:commandButton title="Mise à jour des chronos" image="/images/ajouterAuto.png" style="height:26px;width:26px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.majChronoAutmatique}" reRender="panelChronoAuto"/>
                <a4j:commandButton title="Modifier le chrono sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.modifierChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.visibiliteBton}" reRender="panelChrono"/>
                <a4j:commandButton title="Supprimer le chrono sélectionné" image="/images/supprimer.png" reRender="table"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.supprimerChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.visibiliteBton}"/>
                <a4j:commandButton title="Imprimer les chronos" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                <h:selectOneMenu id="idPeriode" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.periode}">
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.lesPeriodesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chargeChronoPeriode}" reRender="table,pangrpVisbt"/>
                </h:selectOneMenu>
            </h:panelGrid>
        </center>

        <br>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.datamodelChrono}" var="chr">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.selectionChrono}" reRender="pangrpVisbt"/>
                    <rich:column label="Nature" sortable="true" width="5%" sortBy="#{chr.chrNature}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Nat."/></f:facet>
                        <h:outputText value="#{chr.chrNature}" />
                    </rich:column>
                    <rich:column label="Libellé nature" sortable="false" width="10%" >
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{chr.libnature}"/>
                    </rich:column>
                    <rich:column label="Série" sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Série"/></f:facet>
                        <h:outputText value="#{chr.chrSerie}" />
                    </rich:column>
                    <rich:column label="Nom de la série" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Nom"/></f:facet>
                        <h:outputText value="#{chr.chrNom}" />
                    </rich:column>
                    <rich:column label="Nombre de caractère" sortable="false" width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Nb car."/></f:facet>
                        <h:outputText value="#{chr.chrNbCar}" />
                    </rich:column>
                    <rich:column label="Préfixe" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Préfixe"/></f:facet>
                        <h:outputText value="#{chr.chrPrefixe}" />
                    </rich:column>
                    <rich:column label="Numéro(s)" sortable="false" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Chrono"/></f:facet>
                        <h:outputText value="#{chr.lib_num}"/>
                    </rich:column>
                    <rich:column label="Suffixe" sortable="false" width="10%">
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
                    <rich:column label="Journal" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Journal"/></f:facet>
                        <h:outputText value="#{chr.chrJournal}" />
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


    <rich:modalPanel domElementAttachment="parent"  id="panelChrono" width="500" height="500" headerClass="headerPanel"style="border:solid 0px black;overflow:auto;background-color:white;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION D'UN CHRONO"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.annuleSaisie}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">

                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Nature:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrId!=0}">
                            <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0" />
                            <f:selectItem itemLabel="70:Patient" itemValue="70" />
                            <f:selectItem itemLabel="71:Consultation Générale" itemValue="71" />
                            <f:selectItem itemLabel="72:Consultation Spécialisée" itemValue="72" />
                            <f:selectItem itemLabel="73:Pharmacie" itemValue="73" />
                            <f:selectItem itemLabel="74:Laboratoire" itemValue="74" />
                            <f:selectItem itemLabel="75:Lettre de garantie" itemValue="75" />
                            <f:selectItem itemLabel="76:Hospitalisation" itemValue="76" />
                            <f:selectItem itemLabel="77:Devis" itemValue="77" />
                            <f:selectItem itemLabel="78:Refacturation" itemValue="78" />
                            <f:selectItem itemLabel="182:Récapitulatif Refacturation" itemValue="182"/>
                            <f:selectItem itemLabel="181:Facturation Externe" itemValue="181" />
                            <f:selectItem itemLabel="79:Bon encaissement" itemValue="79" />
                            <f:selectItem itemLabel="22:Bon de commande (infirmerie)" itemValue="22" />
                            <f:selectItem itemLabel="7:Activités et Commissions" itemValue="7"/>
                            <f:selectItem itemLabel="180:Rapport Médical" itemValue="180"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idMode,idFormat,idNumerotation,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.selectNature}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Série:"/></h:column>
                    <h:column>
                        <h:inputText id="idSerie" size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrSerie}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Nom:"/></h:column>
                    <h:column><h:inputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNom}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase"/></h:column>
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column>
                        <h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrPeriode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Réservé:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                        <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrPrive}"  >
                            <f:selectItem itemLabel="Public" itemValue="0"/>
                            <f:selectItem itemLabel="Privé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNbCar}">
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
                        <h:selectOneMenu style="width:200px" id="idMode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idNumerotation,idFormat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="idFormat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.mesFormats}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid  style="width:100%;" id="idNumerotation" >
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Préfixe:"/></h:column>
                        <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrPrefixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrMode==0}">
                        <h:column><h:outputText value="Chrono annuel:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNumAn}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrMode==1}">
                        <h:column><h:outputText value="Chrono janvier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum01}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono février:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum02}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono mars:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum03}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono avril:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum04}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono mai:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum05}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono juin:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum06}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono juillet:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum07}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono aout:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum08}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono septembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum09}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono octobre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum10}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono novembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum11}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono décembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum12}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrMode==2}">
                        <h:column><h:outputText value="Chrono:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNum}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Sufixe:"/></h:column>
                        <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrSufixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Journal comptable:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrJournal}">
                                <f:selectItem itemLabel="Sans journal" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mesJournauxComptables}"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>

            </h:panelGrid>

            <h:panelGroup id="pngValide">
                <center>
                    <br>
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.saveChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.var_valide}" reRender="panelChrono,table,pangrpVisbt,idPeriode"/>
                    <br>
                    <h:outputText style="color:red;" value="La nature est obligatoire et doit être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.var_valide}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelChronoAuto" width="500" height="450" headerClass="headerPanel"style="border:solid 0px black;overflow:auto;background-color:white;" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.showModalPanelAuto}">
        <f:facet name="header"><h:outputText value="MISE A JOUR AUTOMATIQUE DES CHRONOS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.annuleSaisieAutomatique}" image="/images/close.gif" styleClass="hidelink" id="hidelinkAuto"/>
                <rich:componentControl for="panelChronoAuto" attachTo="hidelinkAuto" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrPeriode}"/></h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrNbCar}">
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
                        <h:inputText id="idSerie" size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrSerie}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Mode:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" id="mode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,numerotation,format" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.mesFormats}"/>
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
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoMed.saveChronoAuto}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelChronoAuto,pangrpVisbt"/>
                    </h:commandButton>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
