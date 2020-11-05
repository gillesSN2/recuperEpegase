<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="cpte">

    <a4j:form id="frmcpte" enctype="multipart/form-data">

        <center><h2><h:outputText styleClass="titre" value="MON COMPTE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrNom}" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="cptesr">

            <h:panelGrid columns="2"  id="cptesrp" columnClasses="colsCpte,colstiersb" width="100%" >

                <h:column>
                    <h:panelGrid width="100%" id="gridTof" >
                        <f:facet name="header"><h:outputText style="color:green;" value="Ma Photo"/></f:facet>
                        <center>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrPhoto!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.urlPhoto}" width="100px" height="100px"/>
                                <h:panelGroup>
                                    <center>
                                        <a4j:commandButton image="/images/annuler.gif" title="Supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.reInitPhoto}" reRender="gridTof" onclick="if (!confirm('Etes-vous sur de vouloir supprimer votre photo?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
                                    </center>
                                </h:panelGroup>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrPhoto==null}">
                                <img alt="" src="images/no_photo.jpeg" width="100px" height="100px" />
                            </c:if>
                        </center>
                    </h:panelGrid>
                    <br/><br/>
                    <h:panelGrid width="100%" id="gridSign" >
                        <f:facet name="header"><h:outputText style="color:green;" value="Ma Signature"/></f:facet>
                        <center>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrSignature!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.urlSign}" width="100px" height="100px"/>
                                <h:panelGroup>
                                    <center>
                                        <a4j:commandButton image="/images/annuler.gif"title="Supprimer signature" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.reInitSign}" reRender="gridSign" onclick="if (!confirm('Etes-vous sur de vouloir supprimer votre signature?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"/>
                                    </center>
                                </h:panelGroup>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrSignature==null}">
                                <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                            </c:if>
                        </center>
                    </h:panelGrid>
                </h:column>

                <h:column>
                    <center>
                        <rich:tabPanel switchType="client" immediate="true"   width="100%" style="border:0px">
                            <rich:tab label="Identification">
                                <h:panelGrid width="100%" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText  value="INFORMATIONS" /></f:facet>
                                    <h:panelGrid  columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                        <h:column><h:outputText value="Nom:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrNom}"/></h:column>
                                        <h:column><h:outputText value="Prénom:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPrenom}"/></h:column>
                                        <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCivilite}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.mesCivilitesItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Né(e) le:"/></h:column>
                                        <h:column>
                                            <a4j:outputPanel layout="block">
                                                <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrDateNaissance}" popup="true"/>
                                            </a4j:outputPanel>
                                        </h:column>
                                    </h:panelGrid>
                                    <h:panelGrid  columns="2" width="100%" columnClasses="clos15,clos85">
                                        <h:column><h:outputText value="Adresse:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrAdresse}"/></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid  columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                        <h:column><h:outputText  value="Boite Postale:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrBp}"/></h:column>
                                        <h:column><h:outputText value="Ville:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrVille}"/></h:column>
                                        <h:column><h:outputText style="text-decoration:underline;" value="Pays:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrNomPays}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.mesPaysItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column></h:column>
                                        <h:column></h:column>
                                        <h:column><h:outputText value="Tél domicile:"/></h:column>
                                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrTelDomicile}"/></h:column>
                                        <h:column><h:outputText value="Tél bureau:"/></h:column>
                                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrTelBureau}"/></h:column>
                                        <h:column><h:outputText value="Cellulaire 1:"/></h:column>
                                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCel1}"/></h:column>
                                        <h:column><h:outputText value="Cellulaire 2:"/></h:column>
                                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCel2}"/></h:column>
                                        <h:column><h:outputText value="Skype:"/></h:column>
                                        <h:column><h:inputText style="width:100%"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrSkype}"/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value="Email:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrMail}" disabled="true"/></h:column>
                                        <h:column><h:outputText value="Groupe:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCollaboration}" disabled="true"/></h:column>
                                        <h:column><h:outputText value="Login:"/></h:column>
                                        <h:column><h:inputText  style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrLogin}" disabled="true"/></h:column>
                                        <h:column><h:outputText style="text-decoration:underline;" value="Changement:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrChange}" >
                                                <f:selectItem itemLabel="Pas de changement" itemValue="0"/>
                                                <f:selectItem itemLabel="Changement tous les mois" itemValue="1"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Langue:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrLangue}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.mesLangueItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Fonction:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrFonction}">
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.mesFonctionsItems}" />
                                            </h:selectOneMenu>
                                        </h:column>
                                    </h:panelGrid>
                                    <br/>
                                    <h:panelGrid columns="3" width="100%" columnClasses="clos20,clo80">
                                        <h:column><h:outputLabel for="file" value="Ma photo:" /></h:column>
                                        <h:column>
                                            <t:inputFileUpload id="file"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.uploadedFile}" accept="image/*"/></h:column>
                                        <h:column>
                                            <h:commandButton  value="Sauvegarder" styleClass="retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.ajoutPhoto}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                        </h:column>
                                        <h:column><h:outputLabel for="fileSig" value="Ma signature:" /></h:column>
                                        <h:column>
                                            <t:inputFileUpload id="fileSig" accept="image/*" storage="fileSig" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.uploadedFileSig}" /></h:column>
                                        <h:column>
                                            <h:commandButton value="Sauvegarder" styleClass="retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.ajoutSign}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <br/>
                                <center>
                                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}"/>&nbsp;&nbsp;&nbsp;
                                    <h:commandButton  image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.modifCompte}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                </center>
                            </rich:tab>

                            <rich:tab label="Mes Mots de passe">
                                <h:panelGrid width="100%" headerClass="headerTab"columnClasses="colsAc,colsAc">
                                    <f:facet name="header"><h:outputText value="SECURITE"/></f:facet>
                                    <h:panelGrid columns="2" width="100%"  id="env">
                                        <h:column>
                                            <h:graphicImage style="cursor:pointer;" alt="Modifier mon mot de passe " title="Modifier mon mot de passe " url="/images/modifier.png">
                                                <a4j:support eventsQueue="maQueue" immediate="true" reRender="cptesrp,env,mdpsse,cptesr" event="onclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.comptaLien}" />
                                            </h:graphicImage>
                                        </h:column>
                                        <h:column><h:outputText styleClass="hcompte" value="Modifier mon de passe:"/></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="mdpsse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.md}" >
                                        <h:column>
                                            <h:outputText style="color:red;font-weight:bold;"value="Mot de passe:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.md}"/>
                                        </h:column>
                                        <h:column><h:inputSecret required="true" redisplay="true" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrPw}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.md}"/></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2"width="100%" >
                                        <h:column>
                                            <h:graphicImage style="cursor:pointer;" alt="Modifier mon code secret " title="Modifier mon code secret " url="/images/modifier.png">
                                                <a4j:support eventsQueue="maQueue" reRender="cptesrp,mdcs,cptesr" immediate="true" event="onclick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.comptaLienCs}" />
                                            </h:graphicImage>
                                        </h:column>
                                        <h:column><h:outputText styleClass="hcompte" value="Modifier mon code secret:"/></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid columns="2" width="100%" columnClasses="clos20,clos80" id="mdcs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.cs}" >
                                        <h:column>
                                            <h:outputText style="color:red;font-weight:bold;" value="Code secret:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.cs}"/>
                                        </h:column>
                                        <h:column><h:inputSecret size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCodeSecret}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.cs}"/></h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                                <br/>
                                <center>
                                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}"/>&nbsp;&nbsp;&nbsp;
                                    <h:commandButton  image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.modifCompte}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                </center>
                            </rich:tab>

                            <rich:tab label="Mes Droits">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.initMesDroits}" reRender="panMesDroits"/>
                                <h:panelGrid width="100%" headerClass="headerTab" id="panMesDroits">
                                    <f:facet name="header"><h:outputText  value="VOS DROITS" /></f:facet>
                                    <h:panelGrid  columns="4" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                                        <h:column><h:outputText value="Groupe:"/></h:column>
                                        <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersLog.usrCollaboration}"/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                    </h:panelGrid>
                                    <br>
                                    <h:panelGrid columns="2">
                                        <h:column id="droits">
                                            <a4j:region renderRegionOnly="false">
                                                <rich:extendedDataTable  styleClass="contour1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.datamodelModules}"  activeClass="active-row" noDataLabel=" "  headerClass="headerTab" height="520px" width="250px" rowClasses="rows1,rows2,rowsd" var="module">
                                                    <a4j:support eventsQueue="maQueue" reRender="tableFonction,tableOnglet" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.selectionModules}" />
                                                    <rich:column  width="25%" sortable="true" sortBy="#{module.code1}" sortOrder="ASCENDING">
                                                        <f:facet name="header"> <h:outputText value="Code"/></f:facet>
                                                        <h:outputText value="#{module.code1}"/>
                                                    </rich:column >
                                                    <rich:column  width="75%" sortable="true" sortBy="#{module.libelle1FR}">
                                                        <f:facet name="header"> <h:outputText value="Modules installés"/></f:facet>
                                                        <h:outputText value="#{module.libelle1FR}"/>
                                                    </rich:column >
                                                </rich:extendedDataTable>
                                            </a4j:region>
                                        </h:column>
                                        <h:column>
                                            <rich:extendedDataTable id="tableFonction" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.datamodelFonctions}"  styleClass="contour1" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="750px"  var="optionmodule" >
                                                <rich:column width="280px" sortable="false" >
                                                    <f:facet name="header" ><h:outputText value="Fonctions" style="border:0px"/></f:facet>
                                                    <h:outputText  value="#{optionmodule.libelle_FR}"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false" >
                                                    <f:facet name="header" ><h:outputText value="Accès"/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.acc}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Ajt."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.add}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Dup."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.dup}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Mod."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.maj}" disabled="true"/>
                                                </rich:column >
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Sup."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.sup}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Imp."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.imp}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Trf."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.trf}" disabled="true"/>
                                                </rich:column>
                                                <rich:column width="50px" sortable="false">
                                                    <f:facet name="header" ><h:outputText value="Clo/Ser."/></f:facet>
                                                    <h:selectBooleanCheckbox rendered="#{optionmodule.libelle_FR!=''}" value="#{optionmodule.clo}" disabled="true"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                            <br>
                                            <a4j:region renderRegionOnly="false">
                                                <rich:extendedDataTable id="tableOnglet" styleClass="contour1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.datamodelOnglets}" activeClass="active-row" noDataLabel=" "  headerClass="headerTab" rowClasses="rows1,rows2,rowsd" height="250px" width="750px" var="optiononglet">
                                                    <rich:column width="50%" sortable="false" >
                                                        <f:facet name="header" ><h:outputText value="Onglets"/></f:facet>
                                                        <h:outputText value="#{optiononglet.libelle}"/>
                                                    </rich:column>
                                                    <rich:column width="10%" sortable="false">
                                                        <f:facet name="header" ><h:outputText value="Acc."/></f:facet>
                                                        <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.acc}" disabled="true"/>
                                                    </rich:column>
                                                    <rich:column width="10%" sortable="false">
                                                        <f:facet name="header" ><h:outputText value="Ajt."/></f:facet>
                                                        <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.add}" disabled="true"/>
                                                    </rich:column>
                                                    <rich:column width="10%" sortable="false">
                                                        <f:facet name="header" ><h:outputText value="Mod."/></f:facet>
                                                        <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.maj}" disabled="true"/>
                                                    </rich:column>
                                                    <rich:column width="10%" sortable="false" >
                                                        <f:facet name="header" ><h:outputText value="Sup."/></f:facet>
                                                        <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.sup}" disabled="true"/>
                                                    </rich:column>
                                                    <rich:column width="10%" sortable="false" >
                                                        <f:facet name="header" ><h:outputText value="Imp."/></f:facet>
                                                        <h:selectBooleanCheckbox rendered="#{optiononglet.libelle!=''}" value="#{optiononglet.imp}" disabled="true"/>
                                                    </rich:column>
                                                </rich:extendedDataTable>
                                            </a4j:region>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Mes B.A.L." reRender="tableBal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.chargerlesBal}" reRender="panMesBal"/>
                                <h:panelGrid id="panMesBal" width="100%">
                                    <h:panelGrid id="boutonBal" columns="3" width="150px">
                                        <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.ajouterBal}" reRender="panelBal,formBal"/>
                                        <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.modifierBal}" reRender="panelBal,formBal"/>
                                        <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleBal}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.supprimerBal}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableBal"/>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable style="max-height:100%;border:1px" styleClass="bg" id="tableBal" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.dataModelBal}" var="bal">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.selectionBal}" reRender="boutonBal"/>
                                            <rich:column width="30%" sortable="true" sortBy="#{bal.balnomcompte}" >
                                                <f:facet name="header">
                                                    <h:outputText value="Nom BAL"/>
                                                </f:facet>
                                                <h:outputText value="#{bal.balnomcompte}" />
                                            </rich:column >
                                            <rich:column width="60%" sortable="true" sortBy="#{bal.baladressemail}">
                                                <f:facet name="header">
                                                    <h:outputText value="Adresse"/>
                                                </f:facet>
                                                <h:outputText  value="#{bal.baladressemail}" />
                                            </rich:column >
                                            <rich:column  width="5%" sortable="true" sortBy="#{bal.usrfavInactif}">
                                                <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                                <h:commandButton image="#{bal.etat}"  rendered="#{bal.afficheImag}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Mes Flux RSS" reRender="tableFlux" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.chargerlesFlux}" reRender="panMesFlux"/>
                                <h:panelGrid id="panMesFlux" width="100%">
                                    <h:panelGrid id="boutonFlux" columns="3" width="150px">
                                        <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.ajouterFlux}" reRender="panelFlux,formFlux"/>
                                        <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleFlux}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.modifierFlux}" reRender="panelFlux,formFlux"/>
                                        <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleFlux}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.supprimerFlux}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableFlux"/>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable style="max-height:100%;border:1px" styleClass="bg" id="tableFlux" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.dataModelFlux}" var="flux">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.selectionFlux}" reRender="boutonFlux"/>
                                            <rich:column width="30%" sortable="true" sortBy="#{flux.usrfavNom}" >
                                                <f:facet name="header">
                                                    <h:outputText value="Nom du flux"/>
                                                </f:facet>
                                                <h:outputText value="#{flux.usrfavNom}" />
                                            </rich:column >
                                            <rich:column width="60%" sortable="true" sortBy="#{flux.usrfavUrl}">
                                                <f:facet name="header">
                                                    <h:outputText value="URL"/>
                                                </f:facet>
                                                <h:outputText  value="#{flux.usrfavUrl}" />
                                            </rich:column >
                                            <rich:column  width="5%" sortable="true" sortBy="#{flux.usrfavInactif}">
                                                <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                                <h:commandButton image="#{flux.etat}"  rendered="#{flux.afficheImag}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Mes Sites" reRender="tableSite" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.chargerlesSites}" reRender="panMesSites"/>
                                <h:panelGrid id="panMesSites" width="100%">
                                    <h:panelGrid id="boutonSite" columns="3" width="150px">
                                        <a4j:commandButton image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.ajouterSite}" reRender="panelSite,formSite"/>
                                        <a4j:commandButton image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleSite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.modifierSite}" reRender="panelSite,formSite"/>
                                        <a4j:commandButton image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.visibleSite}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.supprimerSite}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="tableSite"/>
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable style="max-height:100%;border:1px" styleClass="bg" id="tableSite" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.dataModelSites}" var="site">
                                            <a4j:support eventsQueue="maQueue" event="onRowClick"action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.selectionSite}" reRender="boutonSite"/>
                                            <rich:column width="30%" sortable="true" sortBy="#{site.usrfavNom}" >
                                                <f:facet name="header">
                                                    <h:outputText value="Nom du site"/>
                                                </f:facet>
                                                <h:outputText value="#{site.usrfavNom}" />
                                            </rich:column >
                                            <rich:column width="60%" sortable="true" sortBy="#{site.usrfavUrl}">
                                                <f:facet name="header">
                                                    <h:outputText value="URL"/>
                                                </f:facet>
                                                <h:outputText  value="#{site.usrfavUrl}" />
                                            </rich:column >
                                            <rich:column  width="5%" sortable="true" sortBy="#{flux.usrfavInactif}" >
                                                <f:facet name="header"><h:outputText value="Etat" /></f:facet>
                                                <h:commandButton image="#{flux.etat}"  rendered="#{flux.afficheImag}" />
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </h:panelGrid>
                            </rich:tab>

                            <rich:tab label="Mon Thème">
                                <h:panelGrid width="100%" headerClass="headerTab">
                                    <f:facet name="header"><h:outputText  value="DEFINITION DE MA COULEUR" /></f:facet>
                                    <h:panelGrid  width="100%">
                                        <center>
                                            <br>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 6')"><img src="images/style/planet.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 5')"><img src="images/style/classic.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 4')"><img src="images/style/noir.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 1')"><img src="images/style/style1.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 2')"><img src="images/style/10678f.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 3')"><img src="images/style/faa012.jpg" alt="" style="margin-right:7px;"/></a>
                                            <a href="javascript:setActiveStyleSheet('Alternatif 7')"><img src="images/style/gris.jpg" alt="" style="margin-right:7px;"/></a>
                                            <br>
                                        </center>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </rich:tab>

                        </rich:tabPanel>
                    </center>
                    <center>
                        <br>
                        <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}"/>
                    </center>
                </h:column>
            </h:panelGrid>

        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelBal" width="850" height="700" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.showModalPanelBal}">
        <f:facet name="header"><h:outputText value="GESTION DES BALS DU COMPTE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton id="idCanBal" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.annulerBal}" styleClass="hidelink" reRender="panelBal,boutonBal"/>
                <rich:hotKey key="esc" handler="#{rich:element('idCanBal')}.click()" />
            </a4j:form>
        </f:facet>
        <a4j:form id="formBal">
            <h:panelGrid width="100%" id="pngdCpte">
                <h:panelGrid columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="Identification compte personnel"/></f:facet>
                    <h:column><h:outputText value="Nom du compte:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balnomcompte}"/></h:column>
                    <h:column><h:outputText value="Email du compte:"/></h:column>
                    <h:column>
                        <h:inputText disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balid!=0}" size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.baladressemail}">
                            <a4j:support eventsQueue="maQueue" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.verifExistMail}" event="onchange" reRender="idValBal,pngdCpte"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.var_existMail}"></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.var_existMail}"><h:outputText value="Ce mail existe déjà. Veuillez en saisir un autre!!!" style="color:red;"/></h:column>
                    <h:column><h:outputText value="Répondre à :"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.baladressemailreponse}"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balid==0}"><h:outputText value="Mot de passe:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balid==0}"><h:inputSecret size="30" id="pwpop" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balpw}"/></h:column>
                    <h:column><h:outputText value="Etat du compte:"/></h:column>
                    <h:column>
                        <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balinactif}">
                            <f:selectItem itemValue="0" itemLabel="Actif"/>
                            <f:selectItem itemValue="1" itemLabel="Inactif"/>
                        </h:selectOneRadio>
                    </h:column>
                    <h:column><h:outputText value="Connexion SSL:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balssl}">
                            <f:selectItem itemValue="0" itemLabel="Connexion sans SSL"/>
                            <f:selectItem itemValue="1" itemLabel="Connexion avec SSL"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="POP du compte de l'utilisateur (Courriers entrants)"/></f:facet>
                    <h:column><h:outputText value="Serveur POP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balpopserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" id="portsp" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balpopport}"/></h:column>
                    <h:column><h:outputText value="Exemplaire des mails:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balpopexemplaire}" disabled="true">
                            <f:selectItem itemValue="0" itemLabel="Laisser un exemplaire sur le serveur d'origine"/>
                            <f:selectItem itemValue="1" itemLabel="Enlever du serveur d'origine"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Authentification:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balpopauthentification}">
                            <f:selectItem itemValue="0" itemLabel="Automatique"/>
                            <f:selectItem itemValue="1" itemLabel="AUTHCRAM-MDS"/>
                            <f:selectItem itemValue="2" itemLabel="AUTHLOGIN"/>
                            <f:selectItem itemValue="3" itemLabel="Text plain"/>
                            <f:selectItem itemValue="4" itemLabel="Aucune"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid   columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="IMAP du compte de l'utilisateur (Courriers entrants)"/></f:facet>
                    <h:column><h:outputText value="Serveur IMAP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balimapserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balimapport}"/></h:column>
                </h:panelGrid>
                <h:panelGrid  columnClasses="clos30,clos70" columns="2" headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="SMTP du compte du l'utilisateur (Courriers sortants)"/></f:facet>
                    <h:column><h:outputText value="Serveur SMTP:"/></h:column>
                    <h:column><h:inputText size="30" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balsmtpserveur}"/></h:column>
                    <h:column><h:outputText value="Port:"/></h:column>
                    <h:column><h:inputText size="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balsmtpport}"/></h:column>
                    <h:column><h:outputText value="Authentification:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balsmtauthentification}">
                            <f:selectItem itemValue="0" itemLabel="Sans Authentification:"/>
                            <f:selectItem itemValue="1" itemLabel="Avec Authentification:"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid  headerClass="headerTab" width="100%" >
                    <f:facet name="header"><h:outputText value="Signature automatique"/></f:facet>
                    <h:column>
                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.bal.balSignature}">
                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                        </rich:editor>
                    </h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <br>
                    <center>
                        <a4j:commandButton id="idValBal" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.saveBal}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.var_valide_bal}" reRender="boutonBal,tableBal,panelBal"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValBal')}.click()" />
                </h:panelGroup>
            </h:panelGrid>           
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelFlux" width="800" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.showModalPanelFlux}">
        <f:facet name="header"><h:outputText value="GESTION DES FLUX"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton id="idCanFlux" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.annulerFlux}" styleClass="hidelink" reRender="panelFlux,boutonFlux"/>
                <rich:hotKey key="esc" handler="#{rich:element('idCanFlux')}.click()" />
            </a4j:form>
        </f:facet>
        <a4j:form id="formFlux">
            <h:panelGrid width="100%">
                <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" width="100%" >
                    <h:column><h:outputText value="Nom du flux:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersFlux.usrfavNom}" /></h:column>
                    <h:column><h:outputText value="adresse URL:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersFlux.usrfavUrl}" /></h:column>
                    <h:column><h:outputText value="Inactif:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.var_flux_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <br>
                        <a4j:commandButton id="idValFlux" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.saveFlux}" reRender="boutonFlux,tableFlux,panelFlux"/>
                        <br><br><br>
                        Cliquez  <A target="_blank" HREF="http://news.google.fr/?output=rss/" TITLE="description" style="color:blue;"> ici </A>  pour obtenir les flux RSS de Google.
                        <br><br>
                        Cliquez  <A target="_blank" HREF="http://fr.finance.yahoo.com/actualites/rssindex/" TITLE="description" style="color:blue;"> ici </A>  pour obtenir les flux RSS de YAHOO.
                        <br><br>
                        Cliquez  <A target="_blank" HREF="http://www.actifpub.com/" TITLE="description" style="color:blue;"> ici </A>  pour rechercher des flux RSS comptabiles avec le lecteur.
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValFlux')}.click()" />
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelSite" width="800" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.showModalPanelSite}">
        <f:facet name="header"><h:outputText value="GESTION DES SITES FAVORIS"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton id="idCanSite" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.annulerSite}" styleClass="hidelink" reRender="panelSite,boutonSite"/>
                <rich:hotKey key="esc" handler="#{rich:element('idCanSite')}.click()" />
            </a4j:form>
        </f:facet>
        <a4j:form id="formSite">
            <h:panelGrid width="100%">
                <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" width="100%" >
                    <h:column><h:outputText value="Nom du site:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersSite.usrfavNom}" /></h:column>
                    <h:column><h:outputText value="adresse URL:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersSite.usrfavUrl}" /></h:column>
                    <h:column><h:outputText value="Login:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersSite.usrfavLogin}" /></h:column>
                    <h:column><h:outputText value="Mot de passe:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.usersSite.usrfavPw}" /></h:column>
                    <h:column><h:outputText value="Inactif:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.var_site_inactif}" /></h:column>
                </h:panelGrid>
                <h:panelGroup>
                    <center>
                        <br>
                        <a4j:commandButton id="idValSite" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.formMonCompte.saveSite}" reRender="boutonSite,tableSite,panelSite"/>
                    </center>
                    <rich:hotKey key="return"  handler="#{rich:element('idValSite')}.click()" />
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


</f:subview>
