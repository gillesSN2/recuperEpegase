<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="tiersacceuil">

    <center>
        <a4j:form>
            <h2>
                <h:outputText value="Bonjour #{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPrenom}, bienvenue dans votre espace de travail !  " styleClass="entete_accueil"/>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                    <h:commandButton image="/images/hp.png" style="width:20px;height:20px;" title="Relire dernier message" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.lectureDernierMessage}"/>
                </c:if>
            </h2>
        </a4j:form>
    </center>

    <a4j:form id="accl" >

        <h:inputHidden id="valUrl4" value="#{bakingbeanepegase.urlDocument}"/>

        <h:panelGrid style="height:500px;" width="100%">
            <h:panelGrid id="pn2" style="height:250px;" columns="3" width="100%">
                <rich:column id="coltodo" style="width:30%;background:white;" styleClass="panneau_accueil">
                    <h:panelGrid id="btnTodo" columns="4" width="150px" style="height:34px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/ajouter.png" title="Créer un nouveau Rappel ou TODO ou Post-it"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.ajouterTodo}" reRender="panelEventTodo,idFormEventTodo"/>
                        <a4j:commandButton image="/images/detail.png" title="Consulter un Rappel ou TODO ou Post-it" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.consulterTodo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.afficheTodo}" reRender="panelEventTodo"/>
                        <a4j:commandButton image="/images/valider_big.png" title="Marquer un Rappel ou TODO ou Post-itcomme fait" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.markTodo}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.afficheTodo}" onclick="if (!confirm('Etes-vous sur de vouloir marquer le TODO ou Post-it comme fait?')) return false" reRender="tableTodo,btnTodo"/>
                        <a4j:commandButton image="/images/print.png" title="Imprimer les Rappels ou TODO ou Post-it" rendered="false" />
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTodo" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelTdo}" var="todo">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.selectionTodo}" reRender="btnTodo" />
                            <rich:column  width="20%" sortable="true" sortBy="#{todo.rdvDteDe}" sortOrder="DESCENDING">
                                <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                <h:outputText value="#{todo.rdvDteDe}" style="#{todo.color}">
                                    <f:convertDateTime locale="fr" pattern="dd/MM/yy"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="80%" sortable="true" sortBy="#{todo.rdvSujet}">
                                <f:facet name="header" ><h:outputText value="Mes Rappels / To do / Mes Post-it !" /></f:facet>
                                <h:outputText value="#{todo.rdvNomTiers}" style="#{todo.color}" rendered="#{todo.rdvTieIdDe!=0}"/>
                                <h:outputText value="#{todo.rdvNomPat}" style="#{todo.color}" rendered="#{todo.rdvPatIdDe!=0}"/>
                                <h:outputText value="#{todo.rdvNomSal}" style="#{todo.color}" rendered="#{todo.rdvSalIdDe!=0}"/>
                                <h:outputText value="#{todo.rdvSujet}" style="#{todo.color}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column>
                <rich:column id="colrdv" style="width:30%;background:white;" styleClass="panneau_accueil">
                    <h:panelGrid id="btnRdv" columns="3" width="100px" style="height:34px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton image="/images/detail.png" title="Consulter un élément" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.consulterRdv}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.afficheRdv}" reRender="panelEvent"/>
                        <a4j:commandButton image="/images/print.png" title="Imprimer le planning" rendered="false" />
                        <h:outputText value="" />
                    </h:panelGrid>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableRdv" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelRdv}" var="rdv">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.selectionRdv}" reRender="btnRdv"/>
                            <rich:column  width="15%" sortable="false" sortOrder="ASCENDING" sortBy="#{rdv.rdvHrDe}#{rdv.rdvMnDe}">
                                <f:facet name="header" ><h:outputText value="H:M"/></f:facet>
                                <h:outputText value="#{rdv.rdvHrDe}:#{rdv.rdvMnDe}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column  width="35%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Tiers"/></f:facet>
                                <h:outputText value="#{rdv.rdvNomTiers}#{rdv.rdvNomPat}" style="#{rdv.color}"/>
                            </rich:column>
                            <rich:column  width="50%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Mes Rendez-vous"/></f:facet>
                                <h:outputText value="#{rdv.rdvSujet}" style="#{rdv.color}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:column>
                <rich:column id="colrep" style="width:40%;background:white;" styleClass="panneau_accueil">
                    <h:panelGrid id="btnRep" columns="4" width="20%" style="height:34px;width:200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.niveau!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.objetMessageSysteme.ajout}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.ajouterDocument}" reRender="panalAjoutFile"/>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.objetMessageSysteme.modif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichier}">
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.nomFichier}" title="Télécharger document"><img src="images/download.png" alt="télécharger"></a>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.objetMessageSysteme.modif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichier&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.viewerPdf}">
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                            </h:column>
                            <a4j:commandButton title="Supprimer document" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.objetMessageSysteme.supp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.fichier}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;" reRender="colrep" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.supprimerDocument}"/>
                            <h:outputText value="" />
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableRep" enableContextMenu="false" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.dataModelRepertoire}" var="repertoire" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" oncomplete="changeColor(this)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.selectionRepertoire}" reRender="colrep,btnRep,tableRep,pn2"/>
                                <rich:column width="35px" sortable="false" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value=""/></f:facet>
                                    <h:graphicImage value="#{repertoire.type}"/>
                                </rich:column>
                                <rich:column width="90%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Documents #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.nomRepertoire} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.nomFichier}"/></f:facet>
                                    <h:outputText value="#{repertoire.texte}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:column>
                </h:panelGrid>
                <h:panelGrid id="pn3" style="margin-top:-2px;height:230px;" columns="2" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                    <rich:column id="colsite" style="width:50%;background:white;" styleClass="panneau_accueil" >
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="site" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelFavoris}" var="site" >
                                <rich:column  width="20%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Sites" /></f:facet>
                                    <h:outputText value="#{site.usrfavNom}"/>
                                </rich:column>
                                <rich:column  width="60%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Mes Sites favoris" /></f:facet>
                                    <h:outputLink id="lien" value="#{site.accesSite}" target="blank" onclick="true" style="text-decoration:none;">
                                        <h:outputText value="#{site.usrfavUrl}" style="text-decoration:none;"/>
                                    </h:outputLink>
                                </rich:column>
                                <rich:column  width="20%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Login" /></f:facet>
                                    <h:outputText value="#{site.usrfavLogin}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:column>
                    <rich:column id="colanniv" style="width:50%;background:white;" styleClass="panneau_accueil">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="anv1" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelAnniv}" var="tiersAnniv">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"/>
                                <rich:column width="35px" sortable="false" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value=""/></f:facet>
                                    <h:graphicImage value="#{tiersAnniv.anniv}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.cat}" title="#{tiersAnniv.cat}"/>
                                </rich:column>
                                <rich:column  width="70%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Les Anniversaires du jour / ALERTES"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.texte}" title="#{tiersAnniv.texte}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Contact"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.actif}" title="#{tiersAnniv.actif}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:column>
                </h:panelGrid>
                <h:panelGrid id="pn3bis" style="margin-top:-2px;height:230px;" columns="1" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif==0}">
                    <rich:column id="colannivbis" style="width:100%;background:white;" styleClass="panneau_accueil">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="anv1bis" height="200px" width="100%" rowClasses="rows1,rows2,rowsd" activeClass="active-row" noDataLabel=" " headerClass="headerTab"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelAnniv}" var="tiersAnniv">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"/>
                                <rich:column width="35px" sortable="false" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value=""/></f:facet>
                                    <h:graphicImage value="#{tiersAnniv.anniv}"/>
                                </rich:column>
                                <rich:column  width="10%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.cat}" title="#{tiersAnniv.cat}"/>
                                </rich:column>
                                <rich:column  width="70%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Les Anniversaires du jour / ALERTES"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.texte}" title="#{tiersAnniv.texte}"/>
                                </rich:column>
                                <rich:column  width="20%" sortable="false">
                                    <f:facet name="header" ><h:outputText value="Contact"/></f:facet>
                                    <h:outputText value="#{tiersAnniv.actif}" title="#{tiersAnniv.actif}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:column>
                </h:panelGrid>
            </h:panelGrid>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelEvent" width="750" height="520" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelRdv}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelRdv}" var="event" >
            <f:facet name="header"><h:outputText value="GESTION DES EVENEMENTS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.annule}" image="/images/close.gif" styleClass="hidelink" reRender="panelEvent"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormEvent">
                <h:panelGrid  width="100%" id="panelRdvGrid" headerClass="headerTab" styleClass="panneau_accueil" >
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80"  columns="2">
                            <h:column><h:outputText value="Nature:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeSaisie==1}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formAccueil.mesNaturesRdvItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.choixTypeRdv}" reRender="panelRdvGrid"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="tiers" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=8}" >
                            <h:panelGrid  style="width:100%;" id="idTierC" columnClasses="clos20,clos80" columns="2">
                                <h:column><h:outputText style="text-decoration:underline" value="Collaborateur:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.refCollaborateur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesCollaborateurItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid style="width:100%;" id="idTierTier" columnClasses="clos20,clos80" columns="2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=9}">
                                <h:column><h:outputText style="text-decoration:underline"  value="Tiers:"/></h:column>
                                <h:column>
                                    <h:inputText id="cltajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rechercheTiers}" reRender="cltajt,panelListeTiers,formModalListeTiers,idTierTier"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversTiers==99}"><h:outputText value="Nom Divers:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversTiers==99}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeyup="javascript:this.value=this.value.toUpperCase();"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.gestionPatient}"><h:outputText style="text-decoration:underline"  value="Patient:" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.gestionPatient}">
                                    <h:inputText id="idPatient" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNomPat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                                        <rich:toolTip id="tooladdPat" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les patients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.recherchePatients}" reRender="idPatient,panelListePatients,formModalListePatients"/>
                                    </h:inputText>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid width="100%" columnClasses="clos20,clos20g,clos60g" columns="3" style="margin-top:-10px">
                            <h:column><h:outputText value="Date début:"/></h:column>
                            <h:column><rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDteDe}" locale="FR"  enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"  inputSize="8"/></h:column>
                            <h:column>
                                <h:panelGrid id="heure" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=8&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=9}">
                                    <h:panelGrid width="100%" columns="2">
                                        <h:column><h:outputText value="Heure:" /></h:column>
                                        <h:column>
                                            <h:panelGrid columns="4">
                                                <h:column>
                                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvHrDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>h</h:column>
                                                <h:column>
                                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvMnDe}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>mn</h:column>
                                            </h:panelGrid>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="date" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}">
                            <h:panelGrid width="100%" columnClasses="clos20,clos20g,clos60g" columns="3" style="margin-top:-20px">
                                <h:column><h:outputText value="Date fin" /></h:column>
                                <h:column><rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDteFi}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"  inputSize="8"/></h:column>
                                <h:column>
                                    <h:panelGrid columns="2">
                                        <h:column><h:outputText value="Heure:"/></h:column>
                                        <h:column>
                                            <h:panelGrid columns="4">
                                                <h:column>
                                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvHrFi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesHeuresGlobalItems}" />
                                                    </h:selectOneMenu></h:column>
                                                <h:column>h</h:column>
                                                <h:column>
                                                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvMnFi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesMinutesGlobalItems}" />
                                                    </h:selectOneMenu>
                                                </h:column>
                                                <h:column>mn</h:column>
                                            </h:panelGrid>
                                        </h:column>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid columnClasses="clos20,clos80" columns="2" style="width:100%;margin-top:-10px">
                            <h:column><h:outputText value="Sujet:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvSujet}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"/></h:column>
                            <h:column><h:outputText value="Description:" /></h:column>
                            <h:column><h:inputTextarea id="idTexte" cols="50" rows="5" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}"><h:outputText style="text-decoration:underline"  value="Tache à faire:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}">
                                <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.choixTache}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                    <f:selectItem itemValue="pas de tache" itemLabel="Pas de tache"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesTachesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}"> <h:outputText value="Lieu concerné:" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvLieu}" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}"><h:outputText value="Mode:" /></h:column>
                            <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvMode}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv==0}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                <f:selectItem itemLabel="Non renseigné" itemValue="Non renseigné"/>
                                <f:selectItem itemLabel="Téléphone" itemValue="Téléphone"/>
                                <f:selectItem itemLabel="Vidéo-conférence" itemValue="Vidéo-conférence"/>
                                <f:selectItem itemLabel="Télé-maintenance" itemValue="Télé-maintenance"/>
                                <f:selectItem itemLabel="Mailing" itemValue="Mail"/>
                                <f:selectItem itemLabel="Démarchage" itemValue="Déplacement"/>
                            </h:selectOneMenu>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttEvent">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.saveEvent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" reRender="panelEvent,pn2"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelEventTodo" width="750" height="400" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelTodo}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelTodo}" var="eventTodo" >
            <f:facet name="header"><h:outputText value="GESTION DES Rappels, TODO et des Post-it"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.annule}" image="/images/close.gif" styleClass="hidelink" reRender="panelEventTodo"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="idFormEventTodo">
                <script type="text/javascript" language="Javascript">
                    function dayEnabledStart(day){
                        if (new Date() > day.date) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                    function disabledStyle(day){
                        if (!dayEnabledStart(day)) return 'rich-calendar-boundary-dates disabledDay';
                    }
                </script>
                <h:panelGrid  width="100%" id="panelRdvGridTodo" headerClass="headerTab" styleClass="panneau_accueil" >
                    <h:panelGrid style="width:100%;">
                        <h:panelGrid  style="width:100%;" columnClasses="clos20,clos80" columns="2">
                            <h:column><h:outputText value="Nature:" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%;"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNature}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeSaisie==1}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.mesNaturesTodoItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.choixTypeRdv}" reRender="panelRdvGridTodo"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup id="tiers" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.typeRdv!=8)||(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvTieIdDe!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvPatIdDe!=0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvSalIdDe!=0)}" >
                            <h:panelGrid  style="width:100%;" id="idTierC" columnClasses="clos20,clos80" columns="2">
                                <h:column><h:outputText style="text-decoration:underline" value="Collaborateur:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.refCollaborateur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.mesCollaborateurItems}" />
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid style="width:100%;" id="idTierTier" columnClasses="clos20,clos80" columns="2">
                                <h:column><h:outputText style="text-decoration:underline"  value="Tiers:"/></h:column>
                                <h:column>
                                    <h:inputText style="width:100%" id="cltajt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNomTiers}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeyup="javascript:this.value=this.value.toUpperCase();">
                                        <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rechercheTiers}" reRender="cltajt,panelListeTiers,formModalListeTiers,idTierTier"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversTiers==99}"><h:outputText value="Nom Divers:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversTiers==99}"><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDiversNom}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeyup="javascript:this.value=this.value.toUpperCase();"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.gestionPatient}"><h:outputText style="text-decoration:underline"  value="Patient:" /></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.gestionPatient}">
                                    <h:inputText style="width:100%" id="idPatient" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNomPat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" onkeyup="javascript:this.value=this.value.toUpperCase();">
                                        <rich:toolTip id="tooladdPat" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les patients" style="background-color:#FFF8D4;"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.recherchePatients}" reRender="idPatient,panelListePatients,formModalListePatients"/>
                                    </h:inputText>
                                </h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvId!=0}"><h:outputText value="Adresse Mail:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvId!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.mailTiers}" style="width:100%" readonly="true" disabled="true"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvId!=0}"><h:outputText value="Téléphone:"/></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvId!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.telTiers}" style="width:100%" readonly="true" disabled="true"/></h:column>
                            </h:panelGrid>
                        </h:panelGroup>
                        <h:panelGrid width="100%" columnClasses="clos20,clos80" columns="2" style="margin-top:-10px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvNature!=10}">
                            <h:column><h:outputText value="Date début:"/></h:column>
                            <h:column><rich:calendar style="background-color:green;color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDteDe}" locale="FR" datePattern="dd/MM/yyyy"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"  inputSize="8" enableManualInput="false" immediate="true"isDayEnabled="dayEnabledStart" dayStyleClass="disabledStyle"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columnClasses="clos20,clos80" columns="2" style="width:100%;margin-top:-10px">
                            <h:column><h:outputText value="Sujet:" /></h:column>
                            <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvSujet}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"/></h:column>
                            <h:column><h:outputText value="Description:" /></h:column>
                            <h:column><h:inputTextarea id="idTexte" cols="50" rows="5" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdv.rdvDescript}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
                <br/>
                <center>
                    <h:panelGroup  id="buttEvent">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.saveEvent}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.rdvdetails}" reRender="panelEventTodo,tableTodo"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelTiers}" var="tiers" >
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelTiers}"  var="tiers">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.selectionTiers}"/>
                            <rich:column label="Catégorie" sortable="true" sortBy="#{tiers.tiecategorie}" width="15%">
                                <f:facet name="header"><h:outputText  value="Catégorie" /></f:facet>
                                <h:outputText value="#{tiers.tiecategorie}"/>
                            </rich:column>
                            <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{tiers.tieraisonsocialenom}" width="55%">
                                <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                                <h:outputText value="#{tiers.tieraisonsocialenom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{tiers.tieprenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{tiers.tieprenom}"/>
                            </rich:column>
                            <rich:column label="Civilité" sortable="true" sortBy="#{tiers.tiecivilite}" width="10%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{tiers.tiecivilite}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valtiers">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.annuleTiers}" reRender="panelListeTiers,idTierTier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.calculeTiers}" reRender="panelListeTiers,idTierTier"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelListePatients" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelPatients}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelPatients}" var="patients" >
            <f:facet name="header"><h:outputText value="Sélection du patient"/></f:facet>
            <a4j:form id="formModalListePatients">
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tablePatients" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.datamodelPatients}"  var="pat">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.selectionPatients}"/>
                            <rich:column label="Civilité" sortable="true" sortBy="#{pat.patCivilite}" width="15%">
                                <f:facet name="header"><h:outputText  value="Civilité" /></f:facet>
                                <h:outputText value="#{pat.patCivilite}"/>
                            </rich:column>
                            <rich:column label="Nom" sortable="true" sortBy="#{pat.patNom}" width="55%">
                                <f:facet name="header"><h:outputText  value="Raison sociale" /></f:facet>
                                <h:outputText value="#{pat.patNom}"/>
                            </rich:column>
                            <rich:column label="Prénom" sortable="true" sortBy="#{pat.patPrenom}" width="20%">
                                <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                                <h:outputText value="#{pat.patPrenom}"/>
                            </rich:column>
                            <rich:column label="Né(e)" sortable="true" sortBy="#{pat.patDateNaissance}" width="10%">
                                <f:facet name="header"><h:outputText  value="Né(e)" /></f:facet>
                                <h:outputText value="#{pat.patDateNaissance}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valpatients">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.annulePatients}" reRender="panelListePatients,idTierTier"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.calculePatients}" reRender="panelListePatients,idTierTier"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS VERS : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.nomRepertoire}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.annulerDocument}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.uploadedFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formAccueil.validerDocument}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>