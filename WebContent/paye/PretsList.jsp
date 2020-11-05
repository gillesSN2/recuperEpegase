<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="listepret">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES PRETS" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panelRecherche" >
            <h:panelGrid id="panCtrl"  styleClass="recherche"  width="100%">
                <h:panelGrid columns="11" width="100%">
                    <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.moreSearch}" reRender="panCtrl" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}"/>
                    <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.moreSearch}" reRender="panCtrl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}"/>
                    <h:column>
                        <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec}">
                            <f:selectItem itemLabel="Sélectionnez type de prêt" itemValue="0"/>
                            <f:selectItem itemLabel="-------------------------------------------------------" itemValue="0"/>
                            <f:selectItem itemLabel="Prêts internes non soldés" itemValue="1"/>
                            <f:selectItem itemLabel="Prêts externes non soldés" itemValue="2"/>
                            <f:selectItem itemLabel="Prêts manuels non soldés" itemValue="3"/>
                            <f:selectItem itemLabel="Tous Prêts non soldés" itemValue="9"/>
                            <f:selectItem itemLabel="-------------------------------------------------------" itemValue="0"/>
                            <f:selectItem itemLabel="Prêts internes soldés" itemValue="11"/>
                            <f:selectItem itemLabel="Prêts externes soldés" itemValue="12"/>
                            <f:selectItem itemLabel="Prêts manuels soldés" itemValue="13"/>
                            <f:selectItem itemLabel="Tous Prêts soldés" itemValue="19"/>
                            <f:selectItem itemLabel="-------------------------------------------------------" itemValue="0"/>
                            <f:selectItem itemLabel="Prêts internes (Tout état)" itemValue="21"/>
                            <f:selectItem itemLabel="Prêts externes (Tout état)" itemValue="22"/>
                            <f:selectItem itemLabel="Prêts manuels (Tout étt)" itemValue="23"/>
                            <f:selectItem itemLabel="Tous Prêts (Tout état)" itemValue="29"/>
                            <f:selectItem itemLabel="-------------------------------------------------------" itemValue="0"/>
                            <f:selectItem itemLabel="Prêts débités le... (Echéance du)" itemValue="31"/>
                            <f:selectItem itemLabel="Situation des prêts au... (Echéance du)" itemValue="33"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.calculePret}" reRender="panCtrl,tableSalaries,scrollTable,boutonSalaries"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_valide_rec}">
                            <f:selectItem itemLabel="Tout Etat" itemValue="100"/>
                            <f:selectItem itemLabel="En cours" itemValue="0"/>
                            <f:selectItem itemLabel="Validé" itemValue="1"/>
                            <f:selectItem itemLabel="Gelé" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.accesInterim&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_tiers_rec}">
                            <f:selectItem itemLabel="Tous tiers" itemValue="100"/>
                            <f:selectItem itemLabel="Sans tiers" itemValue="101"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesTiersItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_nat_rec}">
                            <f:selectItem itemLabel="Toutes Natures" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNaturesPretsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec==31||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec==33}">
                        <rich:calendar style=" background-color:white;text-align:center" id="idDateMois" locale="FR" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.parMois}"  datePattern="MM/yyyy" inputSize="8" enableManualInput="false"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_etat_rec}">
                            <f:selectItem itemLabel="Tous Etats" itemValue="100"/>
                            <f:selectItem itemLabel="Actif" itemValue="0"/>
                            <f:selectItem itemLabel="En congès" itemValue="1"/>
                            <f:selectItem itemLabel="Licencié" itemValue="2"/>
                            <f:selectItem itemLabel="Démissioné" itemValue="3"/>
                            <f:selectItem itemLabel="Décédé" itemValue="4"/>
                            <f:selectItem itemLabel="Retraité" itemValue="5"/>
                            <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                            <f:selectItem itemLabel="Arret/Suspendu" itemValue="7"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_nature_rec}">
                            <f:selectItem itemLabel="Toutes Natures agents" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu  style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_feuille_rec}">
                            <f:selectItem itemLabel="Toutes Feuilles" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_service_rec}">
                            <f:selectItem itemLabel="Tous Services" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesServiceItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_activite_rec}">
                            <f:selectItem itemLabel="Toutes Activités" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesActiviteItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.rechercherSalariePret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,boutonSalaries,scrollTable1,tableSalaries1,scrollTable2,tableSalaries2"/>
                        <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panSuite" columns="10" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_more_search}">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:outputText value="Salarié:"/>&nbsp;&nbsp;
                        <h:inputText id="idSalarie" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.nomSalarie}">
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="conv" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_convention_rec}">
                            <f:selectItem itemLabel="Toutes Conventions" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesConventionsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="grille" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_grille_rec}">
                            <f:selectItem itemLabel="Toutes Catégories" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesGrillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="sit" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_site_rec}">
                            <f:selectItem itemLabel="Tous Sites" itemValue="100"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="dep" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_departement_rec}">
                            <f:selectItem itemLabel="Tous Départements" itemValue="100"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="niveau" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_niveau_rec}">
                            <f:selectItem itemLabel="Tous Niveaux" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesNiveauxEmploisItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="classement" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_classement_rec}">
                            <f:selectItem itemLabel="Tous Classements" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesClassementsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                        <h:selectOneMenu id="centre" style="width:130px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_centre_rec}">
                            <f:selectItem itemLabel="Tous Centres" itemValue="100"/>
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.mesCentresImpotsItems}"/>
                        </h:selectOneMenu>
                    </h:column>                  
                </h:panelGrid>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid  id="boutonSalaries" columns="12" width="450px" style="height:34px">
            <a4j:commandButton title="Ajouter un nouveau Prêt" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajoutPret}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajouterPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Ajouter un lot de prêt" image="/images/groupes.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajoutPret}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajouterLotPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Modifier le prêt sélectionné" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.modifierPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Consulter le prêt sélectionné" image="/images/detail.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.consulterPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Supprimer le prêt sélectionné" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.supprimerPret}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,boutonSalaries,tableSalaries1,tableSalaries2"/>
            <a4j:commandButton title="Imprimer" image="/images/print.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.imp}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton title="Transférer le prêt interne sélectionné en prêt externe ou prêt externe en prêt interne" image="/images/transferer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.transfererPrets}" onclick="if (!confirm('Etes-vous sur de vouloir le type de ce prêt?')) return false" reRender="boutonSalaries,tableSalaries1,tableSalaries2"/>
            <a4j:commandButton title="Valider le prêt sélectionné" image="/images/valDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.usersChronoPret.usrchrValidation==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.usersChronoPret.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.validePret}" onclick="if (!confirm('Etes-vous sur de vouloir valider ce prêt ?')) return false" reRender="boutonSalaries,idetatPret1,idetatPret2"/>
            <a4j:commandButton title="Dé-Valider le prêt sélectionné" image="/images/deValDoc.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreRmb==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.usersChronoPret.usrchrDeValidation==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.usersChronoPret.usrchrUpdate==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.deValidePret}" onclick="if (!confirm('Etes-vous sur de vouloir dé-valider ce prêt ?')) return false" reRender="boutonSalaries,idetatPret1,idetatPret2"/>
            <a4j:commandButton title="Geler le prêt sélectionné" image="/images/geler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat<=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.gelerPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idEtatCrt,tableSalaries1,tableSalaries2,scrollTable1,scrollTable2,boutonSalaries"/>
            <a4j:commandButton title="Réactiver le prêt sélectionné" image="/images/degeler.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreEtat==2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.degelerPret}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idEtatCrt,tableSalaries1,tableSalaries2,scrollTable1,scrollTable2,boutonSalaries"/>
            <a4j:commandButton title="Réactualiser la liste" image="/images/actualiser.png" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menupaye.maj}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.reactualiserPret}" onclick="if (!confirm('Etes-vous sur de vouloir réactualiser la liste ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,tableSalaries1,tableSalaries2,scrollTable1,scrollTable2,boutonSalaries"/>
            <a4j:commandButton title="Informations sur le prêt" image="/images/info.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.informationPiece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_affiche_prets}" reRender="panelInformation"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.optionPaye.triAgents=='0'}" var="sal1">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.pageIndex}" reRender="tableSalaries1" id="scrollTable1" maxPages="20"align="left" for="tableSalaries1"/>
                    <rich:extendedDataTable groupingColumn="idMat" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries1" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelPrets}" var="pret" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.selectionPret}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.visualisationPret}" reRender="idSubView,boutonSalaries"/>
                        <rich:column id="idMat" label="Matricule agent" sortable="true" width="70px" sortBy="#{pret.salaries.salMatricule}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{pret.salaries.salMatricule}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Nature agent" sortable="true" width="100px" sortBy="#{pret.salaries.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{pret.salaries.lib_nature}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="70px" sortBy="#{pret.salaries.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{pret.salaries.lib_etat}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="200px" sortBy="#{pret.salaries.patronyme}">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{pret.salaries.patronyme}"/>
                        </rich:column>
                        <rich:column label="Nom et prénom" sortable="true" width="100px" sortBy="#{pret.salaries.salNomTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.accesInterim}">
                            <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                            <h:outputText value="#{pret.salaries.salNomTiers}"/>
                        </rich:column>
                        <rich:column label="N° Contrat" sortable="true" width="80px" sortBy="#{pret.salpreContrat}">
                            <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                            <h:outputText value="#{pret.salpreContrat}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Nature du prêt" sortable="false" width="150px">
                            <f:facet name="header"><h:outputText  value="Nature Pret" /></f:facet>
                            <h:outputText value="#{pret.lib_nature}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column id="idetatPret1" label="Etat du prêt" sortable="false" width="60px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{pret.libelleEtat}" id="idEtatPretInterne" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="N° du prêt" sortable="false" width="60px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{pret.salpreNum}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Montant" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:outputText value="#{pret.salpreMontant}" rendered="#{pret.salpreMontant!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début remboursement (JJ/MM/AAAA)" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{pret.salpreDateDebut}" style="#{pret.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nombre d'échéances" sortable="false" width="60px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                            <h:outputText value="#{pret.salpreEcheance}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Déjà remboursé" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Remboursement" /></f:facet>
                            <h:outputText value="#{pret.salpreRmb}" rendered="#{pret.salpreRmb!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Solde" /></f:facet>
                            <h:outputText value="#{pret.solde}" rendered="#{pret.solde!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date échéance (JJ/MM/AAAA)" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec>=31&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=32}">
                            <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                            <h:outputText value="#{pret.date_echeance}" style="#{pret.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant Echéance" sortable="false" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec>=31&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=32}">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:outputText value="#{pret.montant_echeance}" rendered="#{pret.montant_echeance!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Description" sortable="false" width="300px">
                            <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                            <h:outputText value="#{pret.salpreObjet}" style="#{pret.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.optionPaye.triAgents=='1'}" var="sal2">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.pageIndex}" reRender="tableSalaries2" id="scrollTable2" maxPages="20"align="left" for="tableSalaries2"/>
                    <rich:extendedDataTable groupingColumn="idSal" rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_nb_max}" border="0" enableContextMenu="true" id="tableSalaries2" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="130%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelPrets}" var="pret" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.selectionPret}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,boutonSalaries"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.visualisationPret}" reRender="idSubView,boutonSalaries"/>
                        <rich:column label="Matricule agent" sortable="true" width="70px" sortBy="#{pret.salaries.salMatricule}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{pret.salaries.salMatricule}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Nature agent" sortable="true" width="100px" sortBy="#{pret.salaries.lib_nature}">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{pret.salaries.lib_nature}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" width="70px" sortBy="#{pret.salaries.lib_etat}">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{pret.salaries.lib_etat}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column id="idSal" label="Nom et prénom" sortable="true" width="200px" sortBy="#{pret.salaries.patronyme}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{pret.salaries.patronyme}"/>
                        </rich:column>
                        <rich:column label="N° Contrat" sortable="true" width="80px" sortBy="#{pret.salpreContrat}">
                            <f:facet name="header"><h:outputText  value="Contrat" /></f:facet>
                            <h:outputText value="#{pret.salpreContrat}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Nature du prêt" sortable="false" width="150px">
                            <f:facet name="header"><h:outputText  value="Nature Pret" /></f:facet>
                            <h:outputText value="#{pret.lib_nature}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column id="idetatPret2" label="Etat du prêt" sortable="false" width="60px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{pret.libelleEtat}" id="idEtatPretInterne" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="N° du prêt" sortable="false" width="60px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{pret.salpreNum}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Montant" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:outputText value="#{pret.salpreMontant}" rendered="#{pret.salpreMontant!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date début remboursement (JJ/MM/AAAA)" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Début" /></f:facet>
                            <h:outputText value="#{pret.salpreDateDebut}" style="#{pret.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Nombre d'échéances" sortable="false" width="60px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                            <h:outputText value="#{pret.salpreEcheance}" style="#{pret.color}"/>
                        </rich:column>
                        <rich:column label="Déjà remboursé" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Remboursement" /></f:facet>
                            <h:outputText value="#{pret.salpreRmb}" rendered="#{pret.salpreRmb!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Solde" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=30}">
                            <f:facet name="header"><h:outputText  value="Solde" /></f:facet>
                            <h:outputText value="#{pret.solde}" rendered="#{pret.solde!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Date échéance (JJ/MM/AAAA)" sortable="false" width="80px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec>=31&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=33}">
                            <f:facet name="header"><h:outputText  value="Echéance" /></f:facet>
                            <h:outputText value="#{pret.date_echeance}" style="#{pret.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant Echéance" sortable="false" width="100px" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec>=31&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_pret_rec<=33}">
                            <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                            <h:outputText value="#{pret.montant_echeance}" rendered="#{pret.montant_echeance!=0}" style="#{pret.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Description" sortable="false" width="300px">
                            <f:facet name="header"><h:outputText  value="Description" /></f:facet>
                            <h:outputText value="#{pret.salpreObjet}" style="#{pret.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>
        </div>

        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Prêts non soldés" style="color:red;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Prêts non soldés des agents protégés" style="color:purple;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Prêts soldés" style="color:black"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Prêts soldés des agents protégés ou prêts gelés" style="color:grey"/>
            </center>
        </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="650" height="480" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelPrint}" var="prt">
            <jsp:include flush="true" page="/commun/impressionExploitationPaye.jsp"/>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelInformation" width="600" height="160" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelInformation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.showModalPanelInformation}" var="inf">
            <f:facet name="header"><h:outputText value="INFORMATION SUR LE PRET"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.fermerInformationPiece}" image="/images/close.gif" styleClass="hidelink" reRender="panelInformation"/>
                </a4j:form >
            </f:facet>
            <a4j:form id="formLpr">
                <h:panelGrid border="0" columns="2" width="100%" columnClasses="clos30,clos70">
                    <h:outputText value="ID prêt:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreId}"/>
                    <h:outputText value="Date de création:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateCreat}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20" readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.nomCreation} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreUserCreat})"/>
                    <h:outputText value="Modifié le:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreDateModif}" datePattern="dd/MM/yyyy hh:mm:ss"  locale="fr" style=" background-color:white;" inputSize="20"  readonly="true" disabled="true"/>
                    <h:outputText value="Par:"/>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.nomModification} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesPrets.salpreUserModif})"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>
                        
</f:subview>
