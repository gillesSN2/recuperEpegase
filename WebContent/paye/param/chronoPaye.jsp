<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="chronocompta">

    <a4j:form>

        <center> <h2><h:outputText value="CHRONOS DE LA PAYE ET R.H." style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="6" width="400px">
                <a4j:commandButton title="Ajouter un nouveau chrono" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.ajouterChrono}" reRender="panelChrono"/>
                <a4j:commandButton title="Mise à jour des chronos" image="/images/ajouterAuto.png" style="height:26px;width:26px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.majChronoAutmatique}" reRender="panelChronoAuto"/>
                <a4j:commandButton title="Modifier le chrono sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.modifierChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.visibiliteBton}" reRender="panelChrono"/>
                <a4j:commandButton title="Supprimer le chrono sélectionné" image="/images/supprimer.png" reRender="table"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.supprimerChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.visibiliteBton}"/>
                <a4j:commandButton title="Imprimer les chronos" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
                <h:selectOneMenu id="idPeriode" style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.periode}">
                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.lesPeriodesItems}"/>
                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chargeChronoPeriode}" reRender="table,pangrpVisbt"/>
                </h:selectOneMenu>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab" enableContextMenu="false" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.datamodelChrono}" var="chr">
                    <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.selectionChrono}" reRender="pangrpVisbt"/>
                    <rich:column label="Nature" sortable="true" width="5%" sortBy="#{chr.chrNature}" sortOrder="ASCENDING">
                        <f:facet name="header"><h:outputText  value="Nat." /></f:facet>
                        <h:outputText value="#{chr.chrNature}" />
                    </rich:column>
                    <rich:column label="Libellé nature" sortable="false" width="10%" >
                        <f:facet name="header"><h:outputText  value="Libellé"  /></f:facet>
                        <h:outputText value="#{chr.libnature}"/>
                    </rich:column>
                    <rich:column label="Nature de l'agent" sortable="false" width="10%" >
                        <f:facet name="header"><h:outputText  value="Agent"  /></f:facet>
                        <h:outputText value="#{chr.chrSerie}"/>
                    </rich:column>
                    <rich:column label="Nombre de caractère" sortable="false" width="5%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Nb car."/></f:facet>
                        <h:outputText value="#{chr.chrNbCar}" />
                    </rich:column>
                    <rich:column label="Préfixe" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Préfixe"  /></f:facet>
                        <h:outputText value="#{chr.chrPrefixe}" />
                    </rich:column>
                    <rich:column label="Numéro(s)" sortable="false" width="10%" style="text-align:right;">
                        <f:facet name="header"><h:outputText  value="Chrono"  /></f:facet>
                        <h:outputText value="#{chr.lib_num}"/>
                    </rich:column>
                    <rich:column label="Suffixe" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Suffixe"  /></f:facet>
                        <h:outputText value="#{chr.chrSufixe}" />
                    </rich:column>
                    <rich:column label="Mode" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Mode"  /></f:facet>
                        <h:outputText value="#{chr.libmode}" />
                    </rich:column>
                    <rich:column label="Format" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Format"  /> </f:facet>
                        <h:outputText value="#{chr.libformat}" />
                    </rich:column>
                    <rich:column label="Journal comptable" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Journal"  /></f:facet>
                        <h:outputText value="#{chr.chrJournal}" />
                    </rich:column>
                    <rich:column label="Période" sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Période" /></f:facet>
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


    <rich:modalPanel domElementAttachment="parent"  id="panelChrono" width="500" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION D'UN CHRONO"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.annuleSaisie}" image="/images/close.gif" styleClass="hidelink" id="hidelink"/>
                <rich:componentControl for="panelChrono" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Nature chrono:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrId!=0}">
                            <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0" />
                            <f:selectItem itemLabel="81:Matricule" itemValue="81" />
                            <f:selectItem itemLabel="82:Contrat" itemValue="82" />
                            <f:selectItem itemLabel="84:Cursus" itemValue="84" />
                            <f:selectItem itemLabel="83:Attestation" itemValue="83" />
                            <f:selectItem itemLabel="85:Certificats" itemValue="85" />
                            <f:selectItem itemLabel="86:Correspondance" itemValue="86" />
                            <f:selectItem itemLabel="87:Prêt (internes/externes/Manuels/Capitalisation)" itemValue="87" />
                            <f:selectItem itemLabel="88:Congés" itemValue="88" />
                            <f:selectItem itemLabel="89:Absence" itemValue="89" />
                            <f:selectItem itemLabel="90:Bulletin" itemValue="90" />
                            <f:selectItem itemLabel="91:Mission" itemValue="91" />
                            <f:selectItem itemLabel="92:Pointage" itemValue="92" />
                            <f:selectItem itemLabel="93:R.H." itemValue="93" />
                            <f:selectItem itemLabel="94:Temps" itemValue="94" />
                            <f:selectItem itemLabel="99:Analyse CV" itemValue="99" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,mode,format,numerotation,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.selectNature}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.testSelectChronoPaye}"><h:outputText value="Nature agent:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.testSelectChronoPaye}">
                        <h:selectOneMenu style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrId!=0}">
                            <f:selectItem itemLabel="Sélectionnez une nature d'agent" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.lesNaturesSalariesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngValide,mode,format" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.doublon}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column>
                        <h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrPeriode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrId!=0}">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,idSerie,pngValide" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.doublon}" />
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Réservé:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                        <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrPrive}"  >
                            <f:selectItem itemLabel="Public" itemValue="0"/>
                            <f:selectItem itemLabel="Privé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNbCar}">
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
                        <h:selectOneMenu style="width:200px" id="mode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,numerotation,format" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.mesFormats}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Journal:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrJournal}"/></h:column>
                </h:panelGrid>

                <h:panelGrid  style="width:100%;" id="numerotation" >
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Préfixe:"/></h:column>
                        <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrPrefixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrMode==0}">
                        <h:column><h:outputText value="Chrono annuel:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNumAn}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrMode==1}">
                        <h:column><h:outputText value="Chrono janvier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum01}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono février:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum02}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono mars:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum03}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono avril:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum04}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono mai:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum05}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono juin:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum06}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono juillet:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum07}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono aout:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum08}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono septembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum09}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono octobre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum10}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono novembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum11}" size="5"/></h:column>
                        <h:column><h:outputText value="Chrono décembre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum12}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrMode==2}">
                        <h:column><h:outputText value="Chrono:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNum}" size="5"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                        <h:column><h:outputText value="Sufixe:"/></h:column>
                        <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrSufixe}" onkeypress="return scanToucheLettre(event)" style="text-transform:uppercase"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="pngValide">
                <center>
                    <br>
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.saveChrono}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.testSelectChrono && bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.testDoubleChrono}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelChrono,pangrpVisbt"/>
                    </h:commandButton>
                    <h:outputText style="color:red;" value="La nature est obligatoire!" rendered="#{!(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.testSelectChrono)}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


     <rich:modalPanel domElementAttachment="parent"  id="panelChronoAuto" width="500" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.showModalPanelAuto}">
        <f:facet name="header"><h:outputText value="MISE A JOUR AUTOMATIQUE DES CHRONOS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.annuleSaisieAutomatique}" image="/images/close.gif" styleClass="hidelink" id="hidelinkAuto"/>
                <rich:componentControl for="panelChronoAuto" attachTo="hidelinkAuto" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGrid  style="width:100%;" id="pngGlob">
                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70d">
                    <h:column><h:outputText value="Période:"/></h:column>
                    <h:column><h:inputText size="5" maxlength="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrPeriode}"/></h:column>
                    <h:column><h:outputText value="Nb caractères:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrNbCar}">
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
                        <h:selectOneMenu style="width:200px" id="mode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrMode}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.mesModes}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="pngGlob,numerotation,format" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.calculeMode}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Format:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  style="width:200px" id="format" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.chrono.chrFormat}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.mesFormats}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br><br>
                <h:panelGrid  style="width:100%;" id="numerotation" border="0">
                    <div style="text-align:justify;color:red">
                                ATTENTION :<br>
                                <b></b> <br>
                                Les chronos dont les natures/matricules n'existent pas déjà, seront créés.<br>
                                Les chronos dont les natures/matricules exitent déjà auront leurs propriétés modifées:<br>
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
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formChronoPaye.saveChronoAuto}">
                        <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelChronoAuto,pangrpVisbt"/>
                    </h:commandButton>
                </center>
            </h:panelGroup>
        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>
