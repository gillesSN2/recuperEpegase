<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="jc">

    <a4j:form id="form">

        <center><h2><h:outputText value="LISTE DES FEUILLES DE FRAIS THEORIQUES" style="color:green;"/></h2></center>

        <h:panelGrid id="panelBouton" columns="6" width="250px">
            <a4j:commandButton title="Ajouter une nouvelle feuille" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.ajouterFeuille}" reRender="panelFeuille"/>
            <a4j:commandButton title="Duppliquer la feuille sélectionnée" image="/images/duplicate.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.duppliquerFeuille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_affiche_bouton}" reRender="panelFeuille"/>
            <a4j:commandButton title="Modfier la feuille sélectionnée" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.modifierFeuille}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_affiche_bouton}" reRender="panelFeuille"/>
            <a4j:commandButton title="Supprimer la feuille sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_affiche_bouton}"  onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.supprimerFeuille}" reRender="panelBouton,tableFeuille"/>
            <a4j:commandButton title="Imprimer la liste des feuilles" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"></a4j:commandButton>
            <a4j:commandButton title="Imprimer le detail de la feuille sélectionnée" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImpStructure');"></a4j:commandButton>
        </h:panelGrid>
        <br>
        <h:panelGrid id="tableau" border="0" width="100%" style="text-align:center;">
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="tableFeuille" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelFraisEntete}" var="feuille">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.selectionFeuille}" reRender="panelBouton"/>
                    <rich:column style="text-align:left;" width="20%">
                        <f:facet name="header"><h:outputText  value="Type feuille"/></f:facet>
                        <h:outputText  value="#{feuille.libelle_type}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="40%">
                        <f:facet name="header"><h:outputText  value="Libellé feuille"/></f:facet>
                        <h:outputText  value="#{feuille.fstFeuille}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="20%">
                        <f:facet name="header"><h:outputText  value="Mode feuille"/></f:facet>
                        <h:outputText  value="#{feuille.fstMode}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="20%">
                        <f:facet name="header"><h:outputText  value="Nature feuille"/></f:facet>
                        <h:outputText  value="#{feuille.libelle_nature}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGrid>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelFeuille" width="1200" height="590" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelFeuille}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelFeuille}" var="feu">
            <f:facet name="header"><h:outputText value="DETAIL D'UNE FEUILLE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.annulerFeuille}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelFeuille"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid columns="4" width="100%" id="idPropriete">
                    <h:column><h:outputText value="Type de la feuille"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille}">
                            <f:selectItem itemLabel="Calcul sur Fiche Produit" itemValue="0"/>
                            <f:selectItem itemLabel="Calcul sur Cotation achat" itemValue="1"/>
                            <f:selectItem itemLabel="Calcul sur Commande achat" itemValue="2"/>
                            <f:selectItem itemLabel="Calcul sur Transporteur et Transitaire" itemValue="3"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="idPropriete"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille!='3'}"><h:outputText value="Nom de la feuille"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille!='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_nom_feuille}" maxlength="50"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}"><h:outputText value="Nom Fournisseur"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_id_fournisseur}" style="width:100%">
                            <f:selectItem itemLabel="Sélection transporteur ou transitaire" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.listTiersItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}"><h:outputText value="Mode:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_mode}" maxlength="50" style="width:100%"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}"><h:outputText value="Nature:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille=='3'}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_nature}">
                            <f:selectItem itemLabel="Avion" itemValue="0"/>
                            <f:selectItem itemLabel="Bateau" itemValue="1"/>
                            <f:selectItem itemLabel="Express" itemValue="2"/>
                            <f:selectItem itemLabel="Route" itemValue="3"/>
                            <f:selectItem itemLabel="Train" itemValue="4"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <br>
                <h:panelGrid id="panFonction" width="200px" columns="3">
                    <a4j:commandButton title="Ajouter un nouveau frais" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.ajouterDetail}" reRender="panelDetail"/>
                    <a4j:commandButton title="Modfier le frais sélectionné" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.modifierDetail}" reRender="panelDetail"/>
                    <a4j:commandButton title="Supprimer le frais sélectionné" image="/images/supprimer.png" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet element?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.supprimerDetail}" reRender="tableauDetail"/>
                </h:panelGrid>
                <rich:extendedDataTable id="tableauDetail" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" "  rowClasses="rows1,rows2,rowsd" width="100%" height="400px" styleClass="bg" style="border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelFraisLigne}" var="detail">
                    <a4j:support eventsQueue="maQueue" event="onRowClick"oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.selectionDetail}"/>
                    <rich:column style="height:20px;text-align:center;" width="4%" sortable="false">
                        <f:facet name="header"><h:outputText  value="T.C." /></f:facet>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.descendre}" image="/images/downarrow.png" id="decroissant" rendered="#{((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelFraisLigne.rowIndex+1)<bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelFraisLigne.rowCount)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableauDetail"/>
                    </rich:column>
                    <rich:column style="height:20px;text-align:center;" width="4%" sortable="false" >
                        <f:facet name="header"><h:outputText  value="T.D." /></f:facet>
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.monter}" image="/images/uparrow.png" id="croissant" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelFraisLigne.rowIndex>=1)==true}" limitToList="tableLigne" ajaxSingle="true" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,tableauDetail"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="8%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Cat."/></f:facet>
                        <h:outputText  value="#{detail.libelle_cat}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="5%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Réf."/></f:facet>
                        <h:outputText  value="#{detail.fstCode}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="18%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{detail.fstNomFr}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="4%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Dev."/></f:facet>
                        <h:outputText value="#{detail.fstDevise}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Base Col(A)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleA}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Taux Col(B)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleB}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Nombre Col(C)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleC}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Résultat Col(D)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleD}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Min. Col(E)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleE}" style="#{detail.stypeNature}"/>
                    </rich:column>
                    <rich:column style="text-align:left;" width="10%" sortable="false">
                        <f:facet name="header"><h:outputText  value="Max. Col(F)"/></f:facet>
                        <h:outputText value="#{detail.fstFormuleF}" style="#{detail.stypeNature}"/>
                    </rich:column>
                </rich:extendedDataTable>
                <center>
                    <br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.saveFeuille}" reRender="tableau,panelFeuille,panelBouton"/>
                    </h:panelGroup>
                    <br>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panelDetail" width="800" height="490" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelDetail}" var="det">
            <f:facet name="header"><h:outputText value="DETAIL D'UNE FEUILLE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.annulerDetail}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelDetail"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid width="100%" id="panelGlobal">
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Type ligne:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:400px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType}">
                                <f:selectItem itemLabel="Ligne Configuration" itemValue="3"/>
                                <f:selectItem itemLabel="Ligne Calcul" itemValue="0"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="panelGlobal"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Référence:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstCode}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Libelle:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstNomFr}" maxlength="100" style="width:95%"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}"><h:outputText value="Catégorie:"/></h:column>
                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstCategorie}">
                            <f:selectItem itemLabel="Frais non spécifié" itemValue="0"/>
                            <f:selectItem itemLabel="Frais sur douanes" itemValue="1"/>
                            <f:selectItem itemLabel="Frais sur débours" itemValue="2"/>
                            <f:selectItem itemLabel="Frais sur prestations" itemValue="3"/>
                            <f:selectItem itemLabel="Autres frais" itemValue="4"/>
                        </h:selectOneMenu>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}"><h:outputText value="Rubrique:"/></h:column>
                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstRubrique}">
                            <f:selectItem itemLabel="Sans rubrique" itemValue=""/>
                            <f:selectItem itemLabel="Total FOB" itemValue="profrsFob"/>
                            <f:selectItem itemLabel="Total Fret" itemValue="profrsFret"/>
                            <f:selectItem itemLabel="Total Assurance" itemValue="profrsAssurance"/>
                        </h:selectOneMenu>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}"><h:outputText value="Devise:"/></h:column>
                        <h:selectOneMenu rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDevise}">
                            <f:selectItem itemLabel="Devise locale" itemValue="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise}"/>
                            <f:selectItem itemLabel="Devise Document" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.mesDevisesItems}"/>
                        </h:selectOneMenu>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstColType==0}"><h:outputText value="Réponse:"/></h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstReponse}">
                            <f:selectItem itemLabel="Oui Obligatoire" itemValue="0"/>
                            <f:selectItem itemLabel="Non" itemValue="1"/>
                            <f:selectItem itemLabel="Oui" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" styleClass="fichefournisseur" id="idRubrique">
                        <h:column><h:outputText value="Base col(A):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleA}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneA}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalA}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Taux col(B):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleB}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneB}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalB}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Nombre col(C):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleC}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneC}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalC}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Résultat col(D):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleD}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneD}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalD}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valeur minimale col(E):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleE}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneE}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalE}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Valeur maximale col(F):"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstFormuleF}" style="width:85%">
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.colonneF}" reRender="idRubrique,idTranche1,idTranche2"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:selectOneMenu style="width:50px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fraisTheoAchats.fstDecimalF}">
                                <f:selectItem itemLabel="0 décimale" itemValue="0"/>
                                <f:selectItem itemLabel="1 décimale" itemValue="1"/>
                                <f:selectItem itemLabel="2 décimales" itemValue="2"/>
                                <f:selectItem itemLabel="3 décimales" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column id="idTranche1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.affichageTranche}"><h:outputText value="Définition des tranches:" style="color:red"/></h:column>
                        <h:column id="idTranche2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.affichageTranche}">
                            <a4j:commandButton style="color:red;width:400px" value="Réglage des tranches" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.ouvrirTranche}" reRender="panelTranche"/>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <rich:tabPanel switchType="client" immediate="true" id="panelOnglet" style="border:0px;background-color:white;">
                        <rich:tab id="tab1" label="Opérateur et manipulation de cellules">
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50g" styleClass="fichefournisseur1" style="text-align:left">
                                <h:column><a4j:commandButton style="width:70px" value="VAL()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleVal}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="Val(valeur) = Affectation valeur"/></h:column>
                                <h:column><a4j:commandButton style="width:70px" value="VAR()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleVar}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="VAR() = Saisie valeur "/></h:column>
                                <h:column><a4j:commandButton style="width:70px" value="RUB()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleRub}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="RUB(ref.ligne:ref.colonne) = Accès rubrique ou RUB(ref.ligne:ref.colonne)+RUB(ref.ligne:ref.colonne) = Addition colonne"/></h:column>
                                <h:column><a4j:commandButton style="width:70px" value="TOT()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleTot}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TOT(ref.colonne:ref.ligne debut:ref.ligne fin) = Somme colonne "/></h:column>
                                <h:column><a4j:commandButton style="width:70px" value="SI()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleSi}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="SI(RUB(ref.ligne:ref.colonne)=VAL(valeur):VAL(valeur vrai)|VAL(valeur faux)) = Choix conditionnel (=,>,<)"/></h:column>
                                <h:column><a4j:commandButton style="width:70px" value="TRANCHE()" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleTranche}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TRANCHE(ref.colonne) = Tableau conditionnel par tranche par rapport à la colonne spécifiée"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="TOT(DEBOURS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc32}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TOT(DEBOURS) = Total des frais dedébours"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="TOT(DOUANES)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc33}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TOT(DOUANES) = Total des frais douanes"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="TOT(PRESTATIONS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc34}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TOT(PRESTATIONS) = Total des frais de prestations"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="TOT(AUTRES_FRAIS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc35}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="TOT(AUTRES_FRAIS) = Total des autres frais"/></h:column>
                            </h:panelGrid>
                        </rich:tab>
                        <rich:tab id="tab2" label="Elements du document">
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50g" styleClass="fichefournisseur1" style="text-align:left" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille==1}">
                                <h:column><a4j:commandButton style="width:100px" value="COT(DEVISE_TAUX)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCot1}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="COT(DEVISE_TAUX) = Taux Devise cotation "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="PRP(DEVISE_TAUX)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCot4}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="COT(PRP_DEVISE_TAUX) = Taux Devise PRP"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="COT(POIDS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCot2}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="COT(POIDS) = Poids total"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="COT(QUANTITE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCot3}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="COT(QUANTITE) = Quantité totale"/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50g" styleClass="fichefournisseur1" style="text-align:left" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille==2}">
                                <h:column><a4j:commandButton style="width:100px" value="CMD(TOTAL_DEVISE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd1}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(TOTAL_DEVISE) = Total CMD en devise "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(TOTAL_LOCAL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd2}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(TOTAL_LOCAL) = Total CMD en #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise} "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(DEVISE_TAUX)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd3}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(DEVISE_TAUX) = Taux Devise comande "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="PRP(TOTAL_DEVISE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd9}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(PRP_DEVISE-TAUX) = Taux devise PRP "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(POIDS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd4}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(POIDS) = Poids total"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(QUANTITE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd5}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(QUANTITE) = Quantité totale"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(FRET_LOCAL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd6}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(FRET_LOCAL) = Total FRET en #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise} "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(ASSURANCE_LOCAL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd7}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(ASSURANCE_LOCAL) = Total ASSURANCE en #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise} "/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="CMD(CAF_LOCAL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleCmd8}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="CMD(CAF_LOCAL) = Total CAF en #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdevise} "/></h:column>
                            </h:panelGrid>
                            <h:panelGrid columns="2" width="100%" columnClasses="clos50g,clos50g" styleClass="fichefournisseur1" style="text-align:left" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.var_type_feuille==3}">
                                <h:column><a4j:commandButton style="width:100px" value="DOC(HT)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc1}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(HT) = H.T. document"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(DEVISE_TAUX)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc2}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(DEVISE_TAUX) = Taux Devise document"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(POIDS_KG)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc5}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(POIDS_KG) = Poids total du document converti en Kilos"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(POIDS_T)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc29}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(POIDS_T) = Poids total du document en tonne"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(VOLUME)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc6}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(VOLUME) = Volume total du document"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(QUANTITE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc3}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(QUANTITE) = Quantité totale du document"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(NB_BL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc20}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(NB_BL) = Nb de BL"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(NB_DECLARATION)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc22}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(NB_DECLARATION) = Nb de Déclaration"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(NB_EXPEDITION)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc23}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(NB_EXPEDITION) = Nb d'expédition"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(NB_DOSSIER)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc24}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(NB_DOSSIER) = Nb de Dossier"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T1-DDI)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc9}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T1-DDI) = Taux douanes"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T3-TCI)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc10}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T3-TCI) = Taxe complémentaire d`intégration"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T10-CCI)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc11}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T10-CCI) = Contribution communautaire d`intégration"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T30-OAD)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc12}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T30-OAD) = Prélèvement OHADA"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T5-TVA)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc13}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T5-TVA) = Taxe à valeur ajoutée"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(T31-CSS)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc14}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(T31-CSS) = Contribution spéciale de solidarité"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(DOUANES)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc15}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(DOUANES) = Montant Douanes"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(FOB)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc16}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FOB) = Montant FOB"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(FRET_DHL)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc36}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FRET_DHL) = Montant FRET lié au tarif de DHL"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(FRET)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc17}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FRET) = Montant FRET"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(ASSURANCE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc18}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(ASSURANCE) = Montant ASSURANCE"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(ZONE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc21}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(ZONE) = Code Zone"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(CAF)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc25}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(CAF) = Cout Assurance et Fret"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.frsPrp1}"><a4j:commandButton style="width:100px" value="DOC(FRS1)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc26}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FRS1) = #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.optionAchats.fraisPrp1}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.frsPrp2}"><a4j:commandButton style="width:100px" value="DOC(FRS2)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc27}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FRS2) = #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.optionAchats.fraisPrp2}"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.frsPrp3}"><a4j:commandButton style="width:100px" value="DOC(FRS3)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc28}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(FRS3) = #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.optionAchats.fraisPrp3}"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(UNITE_PAYANTE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc30}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(UNITE_PAYANTE) = Rapport poids/volume"/></h:column>
                                <h:column><a4j:commandButton style="width:100px" value="DOC(SORTIE_USINE)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fourmuleDoc31}" reRender="panelGlobal"/>&nbsp;&nbsp;<h:outputText value="DOC(SORTIE_USINE) = PA. + emballage + certificats + transport + complement"/></h:column>
                            </h:panelGrid>
                        </rich:tab>
                    </rich:tabPanel>
                </h:panelGrid>
                <center>
                    <br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.saveDetail}" reRender="tableauDetail,panelDetail"/>
                    </h:panelGroup>
                    <br/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelTranche" width="800" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelTranche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelTranche}" var="trc">
            <f:facet name="header"><h:outputText value="DEFINITION DES TRANCHES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fermerTranche}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelTranche"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <h:panelGrid  width="100%" columns="1" styleClass="fichefournisseur">
                    <h:panelGrid id="idBtnTranche" width="200px" columns="3">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle tranche" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.ajouterCalculTranche}" reRender="panelCalculTranche,idBtnTranche"/>
                        <a4j:commandButton image="/images/modifier.png" title="Modifier la tranche sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.modifierCalculTranche}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.visibiliteBtonTranche}" reRender="panelCalculTranche,idBtnTranche"/>
                        <a4j:commandButton image="/images/supprimer.png" title="Supprimer la tranche sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.supprimerCalculTranche}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.visibiliteBtonTranche}" reRender="idBtnTranche,tableTranche"/>
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTranche" height="250px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.datamodelTranche}" var="tdg">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.selectionTranche}" reRender="idBtnTranche"/>
                            <rich:column label="Quantité plancher" sortable="false" width="30%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Qte. plancher"/></f:facet>
                                <h:outputText  value="#{tdg.qteDebut}"  style="text-align:right;"/>
                            </rich:column>
                            <rich:column label="Quantité plafond" sortable="false" width="30%"  style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Qte. plafond"/></f:facet>
                                <h:outputText  value="#{tdg.qteFin}"  style="text-align:right;"/>
                            </rich:column>
                            <rich:column label="Code produit" sortable="false" width="30%"  style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Prix"/></f:facet>
                                <h:outputText  value="#{tdg.prix}"  style="text-align:right;">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <center>
                    <br>
                    <h:panelGroup id="buttGrp">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.validerTranche}" reRender="panelTranche"/>
                    </h:panelGroup>
                    <br/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelCalculTranche" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelCalculTranche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.showModalPanelCalculTranche}" var="tdr">
            <f:facet name="header"><h:outputText value="TRANCHE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.fermerCalculTranche}" image="/images/close.gif" styleClass="hidelink" reRender="panelCalculTranche"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%">
                    <h:column><h:outputText value="Quantité minimale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.objetTarif.qteDebut}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Quantité maximale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.objetTarif.qteFin}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Prix:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.objetTarif.prix}" style="text-align:right;">
                          <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttTarDegres">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.validerCalculTranche}" reRender="panelCalculTranche,tableTranche,idBtnTranche"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <!-- debut Modal panel pour impression -->
    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImpStructure" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="550" height="200">
        <center>
            <f:facet name="header"><h:outputText value="Impression de la structure de la feuille"/></f:facet>
            <f:facet name="controls">
                <h:panelGroup>
                    <h:graphicImage value="/images/close.gif" id="hideImpStructure"/>
                    <rich:componentControl for="panelImpStructure" attachTo="hideImpStructure" operation="hide" event="onclick"/>
                </h:panelGroup>
            </f:facet>
            <a4j:form id="formModalImpStructure" target="_blank">
                <h:panelGrid width="100%" >
                    <h:panelGrid width="100%" style="border:solid 0px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="8" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerJRV}" onclick="javascript:Richfaces.hideModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formFraisTheoAchats.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menuadministration.imp}"/>
                        </h:panelGrid>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>



</f:subview>
