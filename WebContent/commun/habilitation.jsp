<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="habach">
    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="HABILITATION ET VALIDATION DU MODULE #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.var_libelle}" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panelBouton" columns="4" width="200px">
                <a4j:commandButton title="Ajouter une nouvelle habilitation" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.panalAjt}" reRender="panelHabilitation"/>
                <a4j:commandButton title="Modifier l'habilitation sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.panalModif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.visibiliteBton}" reRender="panelHabilitation"/>
                <a4j:commandButton title="Supprimer l'habilitation sélectionnée" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.supprimerHabilittation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.visibiliteBton}" reRender="table,panelBouton"/>
                <a4j:commandButton title="Imprimer les habilitations" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>

        <br>

        <center>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.datamodelHabilitation}" var="hab">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.selectionHabilitation}" reRender="panelBouton"/>
                    <rich:column  sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                        <h:outputText value="#{hab.habNature}" />
                    </rich:column>
                    <rich:column sortable="false" width="8%">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{hab.libelleHab}" />
                    </rich:column>
                    <rich:column sortable="false" width="5%">
                        <f:facet name="header"><h:outputText  value="Mail"/></f:facet>
                        <h:outputText value="#{hab.libelleMail}" />
                    </rich:column>
                    <rich:column sortable="false" width="10%">
                        <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                        <h:outputText value="#{hab.libelleMode}" />
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°1"/></f:facet>
                        <h:outputText value="#{hab.habUser1Nom}" title="#{hab.habUser1Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace1Nom}" title="#{hab.habRemplace1Nom}"/>
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°2"/></f:facet>
                        <h:outputText value="#{hab.habUser2Nom}" title="#{hab.habUser2Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace2Nom}" title="#{hab.habRemplace2Nom}"/>
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°3"/></f:facet>
                        <h:outputText value="#{hab.habUser3Nom}" title="#{hab.habUser3Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace3Nom}" title="#{hab.habRemplace3Nom}"/>
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°4"/></f:facet>
                        <h:outputText value="#{hab.habUser4Nom}" title="#{hab.habUser4Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace4Nom}" title="#{hab.habRemplace4Nom}"/>
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°5"/></f:facet>
                        <h:outputText value="#{hab.habUser5Nom}" title="#{hab.habUser5Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace5Nom}" title="#{hab.habRemplace5Nom}"/>
                    </rich:column>
                    <rich:column sortable="false" width="12%">
                        <f:facet name="header"><h:outputText  value="Sign./Rempl. N°6"/></f:facet>
                        <h:outputText value="#{hab.habUser6Nom}" title="#{hab.habUser6Nom}"/><br>
                        <h:outputText value="#{hab.habRemplace6Nom}" title="#{hab.habRemplace6Nom}"/>
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


        <rich:modalPanel domElementAttachment="parent"  id="panelHabilitation" width="500" height="530" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.showModalPanel}">
        <f:facet name="header"><h:outputText value="GESTION DES HABILITATIONS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.annule}" image="/images/close.gif" styleClass="hidelink" reRender="panelHabilitation"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <rich:hotKey key="return" handler="return false;"/>

            <h:panelGrid  style="width:100%;" id="idUtilisateur">

                <h:panelGrid  columns="2" style="width:100%;" columnClasses="clos30,clos70">
                    <h:outputText value="Nature:"/>
                    <h:selectOneMenu style="width:200px" id="selectnat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habId!=0}">
                        <f:selectItem itemLabel="Sélectionnez une nature" itemValue="0" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.lesNaturesHabilitations}" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="selectnat,ppgrpAjt,btvaldAjt,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.doublon}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Mode:"/>
                    <h:selectOneMenu  style="width:200px" id="selectmode" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode}">
                        <f:selectItem itemLabel="Mono-signature" itemValue="0" />
                        <f:selectItem itemLabel="Multi-signature" itemValue="1" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idUtilisateur,idNb1,idNb2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignature}"/>
                    </h:selectOneMenu>
                    <h:outputText id="idNb1" value="Nombre signataires:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1}"/>
                    <h:selectOneMenu  id="idNb2" style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1}">
                        <f:selectItem itemLabel="2 signataires" itemValue="2" />
                        <f:selectItem itemLabel="3 signataires" itemValue="3" />
                        <f:selectItem itemLabel="4 signataires" itemValue="4" />
                        <f:selectItem itemLabel="5 signataires" itemValue="5" />
                        <f:selectItem itemLabel="6 signataires" itemValue="6" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idUtilisateur,u1,selectcu1,u2,selectcu2,u3,selectcu3,u4,selectcu4,u5,selectcu5,u6,selectcu6" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.multiSignature}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Mail:"/>
                    <h:selectOneMenu  style="width:200px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMailBloque}">
                        <f:selectItem itemLabel="Mail envoyé (suivant configuration des signataires)" itemValue="0" />
                        <f:selectItem itemLabel="Mail bloqué" itemValue="1" />
                    </h:selectOneMenu>
                </h:panelGrid>
                <br>
                <h:panelGrid  id="u1" style="width:100%;" styleClass="fichefournisseur">
                    <h:column>
                        <h:outputText value="Signataire N° 1:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser1Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser1}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u1,selectcu1,user1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU1}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u1,selectcu1,user1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user1" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser1Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser1Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems1}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user1,selectu1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers1}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user1,selectu1"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace1Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems1}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user1,selectr1" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla1}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user1,selectr1"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="u2" style="width:100%;" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre>=2}">
                    <h:column>
                        <h:outputText value="Signataire N° 2:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser2Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser2}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u2,selectcu2,user2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU2}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u2,selectcu2,user2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user2" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser2Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser2Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems2}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user2,selectu2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers2}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user2,selectu2"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace2Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems2}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user2,selectr2" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla2}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user2,selectr2"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid  id="u3" style="width:100%;" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre>=3}">
                    <h:column>
                        <h:outputText value="Signataire N° 3:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser3Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser3}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u3,selectcu3,user3" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU3}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u3,selectcu3,user3"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user3" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser3Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser3Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems3}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user3,selectu3" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers3}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user3,selectu3"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace3Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems3}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user3,selectr3" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla3}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user3,selectr3"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid  id="u4" style="width:100%;" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre>=4}">
                    <h:column>
                        <h:outputText value="Signataire N° 4:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser4Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser4}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u4,selectcu4,user4" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU4}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u4,selectcu4,user4"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user4" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser4Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser4Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems4}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user4,selectu4" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers4}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user4,selectu4"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace4Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems4}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user4,selectr4" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla4}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user4,selectr4"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid  id="u5" style="width:100%;" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre>=5}">
                    <h:column>
                        <h:outputText value="Signataire N° 5:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser5Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser5}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u5,selectcu5,user5" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU5}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u5,selectcu5,user5"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user5" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser5Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser5Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems5}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user5,selectu5" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers5}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user5,selectu5"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace5Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems5}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user5,selectr5" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla5}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user5,selectr5"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>

                <h:panelGrid id="u6" style="width:100%;" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habMode==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habNombre>=6}">
                    <h:column>
                        <h:outputText value="Signataire N° 6:" style="font-weight:bold;"/>&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu id="selectcu6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser6Cat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.monoSignatureUser6}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItem itemLabel="Actif" itemValue="2" />
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="u6,selectcu6,user6" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.activationU6}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="u6,selectcu6,user6"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:panelGrid  columns="2" id="user6" style="width:100%;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser6Cat!=0}">
                        <h:outputText value="Nom et prénom:"/>
                        <h:selectOneMenu style="width:300px" id="selectu6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habUser6Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems6}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user6,selectu5" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageUsers6}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user6,selectu5"/>
                        </h:selectOneMenu>
                        <h:outputText value="Remplaçant:"/>
                        <h:selectOneMenu style="width:300px" id="selectr6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.habilitation.habRemplace6Id}">
                            <f:selectItem itemLabel="Inactif" itemValue="0" />
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.mesUsersItems6}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="user6,selectr6" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.decoupageRempla6}"/>
                            <a4j:support eventsQueue="maQueue" event="onselect" reRender="user6,selectr6"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="ppgrpAjt">
                <center>
                    <br>
                    <a4j:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.saveHabilatition}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.testDoubleHabilitation}" reRender="panelHabilitation,table"/>
                    <h:outputText  id="outpAjt" style="color:red;" value="La nature et les utilisateurs doivent être uniques!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formHabilitation.testDoubleHabilitation}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


</f:subview>