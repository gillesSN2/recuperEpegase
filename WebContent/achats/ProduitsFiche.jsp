1<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficproduitsach">

    <a4j:form id="produitformach" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="FICHE PRODUIT (ACHAT/VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">

            <rich:tabPanel switchType="client" immediate="true" id="tabProduit" style="border:0px;">

                <rich:tab label="Descriptif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_descriptif}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationDescription}" reRender="panDescription"/>
                    <h:panelGrid id="panDescription" width="100%">
                        <h:panelGrid  columns="2" columnClasses="clos15,clos85" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText  value="Famille Achat:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFamilleAchat" style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpFamilleAch}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.changeFamilleAch}">
                                    <f:selectItem itemLabel="Sélectionnez une famille" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamillesAchatsUtilItems}"/>
                                    <a4j:support eventsQueue="maQueue"  event="onchange" reRender="panelButton,codPrd,natAch,idMarque,tabProduit" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculeCodeAch}" />
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Change famille achat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.changeFamilleAch}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleAch}" reRender="idFamilleAchat"/>
                            </h:column>
                            <h:column><h:outputText value="Nature achat:"/></h:column>
                            <h:column><h:outputText id="natAch" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpNatureAch}" /></h:column>
                            <h:column><h:outputText  value="Famille vente:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idFamilleVente" style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpFamilleVnt}" disabled="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.changeFamilleVte}">
                                    <f:selectItem itemLabel="Sélectionnez une famille" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamillesVentesUtilItems}"/>
                                    <a4j:support eventsQueue="maQueue"  event="onchange" reRender="panelButton,codPrd,natVte,idMarque" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculeCodeVte}" />
                                </h:selectOneMenu>&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton value="Change famille vente" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.changeFamilleVte}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleVte}" reRender="idFamilleVente"/>
                            </h:column>
                            <h:column><h:outputText value="Nature vente:"/></h:column>
                            <h:column><h:outputText id="natVte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpNatureVnt}" /></h:column>
                            <h:column><h:outputText value="Code produit:"/></h:column>
                            <h:column>
                                <h:inputText id="codPrd" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verouxCod}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCode}" onkeypress="return scanToucheLettre(event)" style="width:200px;text-transform:uppercase" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>=2}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifCode}" reRender="panelButton" />
                                </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column><h:outputText value="Etat Produit:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proInactif}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                        <f:selectItem itemLabel="ACTIF" itemValue="0"/>
                                        <f:selectItem itemLabel="DESACTIVE" itemValue="1"/>
                                        <f:selectItem itemLabel="A SUPPRIMER" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column><h:outputText value="Libellé libre dans documents:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.libelle_libre}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve=='0'}"><h:outputText value="Série:"/></h:column>&nbsp;&nbsp;
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve=='0'}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                        <f:selectItem itemLabel="N.R." itemValue=""/>
                                        <f:selectItem itemLabel="A" itemValue="A"/>
                                        <f:selectItem itemLabel="B" itemValue="B"/>
                                        <f:selectItem itemLabel="C" itemValue="C"/>
                                        <f:selectItem itemLabel="D" itemValue="D"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"columnClasses="clos15,clos85" width="100%">
                            <h:column><h:outputText value="Libellé client:"/></h:column>
                            <h:column><h:inputText size="72" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proLibClient}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Libellé technique:"/></h:column>
                            <h:column><h:inputText size="72" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proLibTech}" maxlength="100" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code Option:"/></h:column>
                            <h:column><h:inputText style="width:200px;" maxlength="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCodeOption}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Descriptif:"/></h:column>
                            <h:column>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDescrip}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:column>
                            <h:column><h:outputText value="Marque:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMarque" style="width:800px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proMarque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="Sans marque" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesMarquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Constructeur:"/></h:column>
                            <h:column><h:inputText size="72" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proConstructeur}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" columnClasses="clos15,clos35,clos25,clos25g" width="100%" styleClass="fichefournisseur" id="idProduitLie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proMode==0}">
                            <h:column><h:outputText value="Produit lié:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCodeLie}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.rechercheProduitsLies}" reRender="panelListeProduits,formModalListeProduits" oncomplete="javascript:Richfaces.showModalPanel('panelListeProduits');"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Quantité liée:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proQteLie}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Photos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_photo}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationPhoto}" reRender="panPhoto,panPdf"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPhoto==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.uploadedFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3" >
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPhoto!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.urlphotoProd}" width="150px" height="150px"/>&nbsp;
                                <h:panelGrid columns="2" width="150px">
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPhotoTaille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                        <f:selectItem itemLabel="Petit format" itemValue="0"/>
                                        <f:selectItem itemLabel="Grand format" itemValue="1"/>
                                    </h:selectOneRadio>
                                    <h:commandButton image="/images/supprimer.png" title="supprimer photo" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPhoto==null}">
                                <img alt="" src="images/no_image.jpeg" width="150px" height="150px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGrid id="panPdf" columns="2" style="height:170px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="PDF"/></f:facet>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_affFicPdf}">
                            <t:inputFileUpload id="filePdf"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.uploadedPDFFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true"/>
                            </h:commandButton>
                            <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_affFicPdf}">
                            <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPdf}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/supprimer.png" title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Caractéristiques " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_caracteristique}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationCaracteristique}" reRender="prodcarteristique"/>
                    <h:panelGrid width="100%" id="idDefinitionCarac">
                        <jsp:include flush="true" page="/achats/ProduitsCaractStandard.jsp"/>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Fournisseurs" reRender="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existAchat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleAch&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_fournisseur&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proMode!=5}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationFournisseur}" reRender="panelBoutonFour"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonFour" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter fournisseur" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargerModalAddFour}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" reRender="panelProFour"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Modifier fournisseur" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdFour&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargerModalModFour}" reRender="panelProFour"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer supprimer" image="/images/supprimer.png" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppProdFour&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.suppressionProFour}" reRender="panelBoutonFour,tableProdFour"/>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableProdFour"footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelProduitFournisseur}" var="produitsFour">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonFour"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitFournisseur}"/>
                            <rich:column  width="20%" sortable="false" sortOrder="ASCENDING" sortBy="#{produitsFour.tiers.tieraisonsocialenom}">
                                <f:facet name="header" ><h:outputText  value="Nom du fournisseur"  /></f:facet>
                                <h:outputText value="#{produitsFour.tiers.tieraisonsocialenom}" />
                            </rich:column>
                            <rich:column  width="20%" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Référence"  /></f:facet>
                                <h:outputText value="#{produitsFour.profouRef}"  />
                            </rich:column>
                            <rich:column  width="20%" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Libellé"  /></f:facet>
                                <h:outputText value="#{produitsFour.profouLib}"  />
                            </rich:column>
                            <rich:column  width="10%"  style="text-align:right;" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Prix d'achat"  /></f:facet>
                                <h:outputText  value="#{produitsFour.profouPa}">
                                    <c:if test="${produitsFour.profouFormat==0}">
                                        <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                                    </c:if>
                                    <c:if test="${produitsFour.profouFormat==1}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </c:if>
                                    <c:if test="${produitsFour.profouFormat==2}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                                    </c:if>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="10%" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Devise"/></f:facet>
                                <h:outputText value="#{produitsFour.profouDevise}"/>
                            </rich:column>
                            <rich:column  width="7%" sortable="false" style="text-align:center;">
                                <f:facet name="header" ><h:outputText  value="Taux Devise"  /></f:facet>
                                <h:outputText value="#{produitsFour.profouTauxDevise}"/>
                            </rich:column>
                            <rich:column  width="8%" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Date achat"/></f:facet>
                                <h:outputText value="#{produitsFour.profouDate}">
                                    <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="5%" id="etatProdFour" sortable="false" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                <h:commandButton image="#{produitsFour.etat}" rendered="#{produitsFour.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reactiverProdFour}" title="Réactiver fournisseur" style="text-align:center;">
                                    <a4j:support eventsQueue="maQueue" reRender="etatProdFour,tableProdFour" event="onclick"/>
                                </h:commandButton>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>              

                <rich:tab label="Option.achat" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleAch&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_option_ach}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationOptionAch}" reRender="panAchat"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <h:panelGrid id="panAchat" width="100%">
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35">
                            <h:column><h:outputText value="Nature achat:" style="text-decoration:underline;" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpNatureAch}" style="width:100%" readonly="true"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchTva}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesTaxesAchItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Exonéré de TVA:" style="color:red" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proExoTva}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code Douane:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchDouane}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDouanesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
                            <h:column><h:outputText value="Compte achat local:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteLoc}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteAchLocItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte achat zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteZ}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteAchZItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte achat hors zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteHz}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteAchHzItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de variation" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteCh}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteChargeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de stock:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteSt}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteStocksAchItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.trfCompta=='1'}"><h:outputText value="Compte en cours:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.trfCompta=='1'}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCpteEc}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteStocksAchItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  width="100%" columnClasses="clos15,clos35">
                            <h:column><h:outputText value="Mode gestion stock:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proStock}">
                                    <f:selectItem itemLabel="Sans stock" itemValue="0"/>
                                    <f:selectItem itemLabel="Stock simple" itemValue="1"/>
                                    <f:selectItem itemLabel="LIFO (lot)" itemValue="2"/>
                                    <f:selectItem itemLabel="FIFO (lot)" itemValue="3"/>
                                    <f:selectItem itemLabel="Péremption (lot)" itemValue="4"/>
                                    <f:selectItem itemLabel="Sérialisé" itemValue="5"/>
                                    <f:selectItem itemLabel="Consigne" itemValue="6" itemDisabled="true"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="tabProduit,tabStock"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépot achat:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDepotAch}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchCodeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépot production:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDepotPrd}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotPrdCodeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCle1}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCle2}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proActivite}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <center>
                                <a4j:commandButton value="Valeur par défaut" onclick="if (!confirm('Voulez-vous restaurer les valeurs par défaut de la famille ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.valeurDefautFamilleAch}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}" reRender="modAttente,panAchat"/>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Stock" id="tabStock" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proStock!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_stock}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationStock}" reRender="panelBoutonDep"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonDep" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter dépôt" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargerModalAddDepot}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" reRender="panelProDep"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Modifier dépôt" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.chargerModalModDepot}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifDepProd&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" reRender="panelProDep"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer dépôt" image="/images/supprimer.png"rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppDepProd&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.suppressionProDepot}" reRender="panelBoutonDep,tableauDepot"/>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauDepot" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelDepot}" var="depotProd">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonDep"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitDepot}"/>
                            <rich:column  width="8%" sortable="false" sortOrder="ASCENDING" sortBy="#{depotProd.prodepGroupe} #{depotProd.depot.dpoCode}">
                                <f:facet name="header" > <h:outputText value="Dépot"/></f:facet>
                                <h:outputText value="#{depotProd.depot.dpoCode}"  />
                            </rich:column>
                            <rich:column  width="5%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Group."  /></f:facet>
                                <h:outputText value="#{depotProd.prodepGroupe}" />
                            </rich:column>
                            <rich:column  width="8%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Localisation / Casier"  /></f:facet>
                                <h:outputText value="#{depotProd.prodepLocalisation} #{depotProd.prodepCasier}" />
                            </rich:column>
                            <rich:column  width="8%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                                <f:facet name="header" ><h:outputText value="Coef PR"/></f:facet>
                                <h:outputText value="#{depotProd.prodepCoefPr}"  />
                            </rich:column>
                            <rich:column  width="8%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                                <f:facet name="header" ><h:outputText value="P.R."/></f:facet>
                                <h:outputText value="#{depotProd.prodepPr}"  />
                            </rich:column>
                            <rich:column  width="8%" sortable="false" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}">
                                <f:facet name="header" ><h:outputText value="PUMP"/></f:facet>
                                <h:outputText value="#{depotProd.prodepPump}"  />
                            </rich:column>
                            <rich:column  width="6%" sortable="false" >
                                <f:facet name="header" ><h:outputText value="Unité"/></f:facet>
                                <h:outputText value="#{depotProd.prodepUnite}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte CMD Achat"/></f:facet>
                                <h:outputText value="#{depotProd.prodepQteCmdAch}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte ATT réception"/></f:facet>
                                <h:outputText value="#{depotProd.prodepQteAttAch}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte CMD vente"/></f:facet>
                                <h:outputText value="#{depotProd.prodepQteCmdVte}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte ATT livraison"/></f:facet>
                                <h:outputText value="#{depotProd.prodepQteAttVte}" />
                            </rich:column>
                            <rich:column  width="10%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte physique"/></f:facet>
                                <h:outputText value="#{depotProd.prodepQteStk}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}" maxFractionDigits="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.optionAchats.nbDecQte}"/>
                                </h:outputText>
                                <h:outputText value=" soit " rendered="#{depotProd.qteConditionne!=0}"/>
                                <h:outputText value="#{depotProd.qteConditionne}" rendered="#{depotProd.qteConditionne!=0}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column  width="4%" id="etatProdDep" sortable="false" style="text-align:center;" >
                                <f:facet name="header"><h:outputText  value="Etat"  /></f:facet>
                                <h:commandButton image="#{depotProd.etat}" rendered="#{depotProd.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reactiverProdDep}" title="Supprimer" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" reRender="etatProdDep,tableauDepot" event="onclick"/>
                                </h:commandButton>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                    <br/>
                    <center>
                        <a4j:commandButton rendered="false" value="Recalcul des stocks" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recalculStock}" onclick="if (!confirm('Voulez-vous recalculer les stocks de ce produit ?')) return false" title="Recalcul des stocks" reRender="tableauDepot"/>
                    </center>
                </rich:tab>

                <rich:tab label="Option.vente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleVte&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_option_vte}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationOptionVte}" reRender="panVente"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <h:panelGrid id="panVente" width="100%">
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35">
                            <h:column><h:outputText value="Nature vente:" style="text-decoration:underline;" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpNatureVnt}" style="width:100%" readonly="true"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteTva}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesTaxesVteItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Exonéré de TVA:" style="color:red" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proExoTva}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code Douane:"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteDouane}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDouanesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
                            <h:column><h:outputText value="Compte vente local taxable:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCpteLoc}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteVteLocItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente local non taxable:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCpteNTx}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteVteLocItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCpteZ}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteVteZItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente hors zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCpteHz}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteVteHzItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de produit:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCptePr}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteProduitsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de stock:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proVteCpteSt}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesCompteStocksVteItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  id="idGrdVente3" width="100%" columnClasses="clos15,clos35">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCode==''||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCode==null}"><h:outputText value="Mode gestion stock:" style="text-decoration:underline;" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCode==''||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proAchCode==null}">
                                <h:selectOneMenu style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proStock}">
                                    <f:selectItem itemLabel="Sans stock" itemValue="0"/>
                                    <f:selectItem itemLabel="Stock simple" itemValue="1"/>
                                    <f:selectItem itemLabel="LIFO (lot)" itemValue="2"/>
                                    <f:selectItem itemLabel="FIFO (lot)" itemValue="3"/>
                                    <f:selectItem itemLabel="Péremption (lot)" itemValue="4"/>
                                    <f:selectItem itemLabel="Sérialisé" itemValue="5"/>
                                    <f:selectItem itemLabel="Consigne" itemValue="6" itemDisabled="true"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="tabProduit,tabStock"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Dépot vente:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proDepotVte}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotVteCodeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText  value="Code promotion:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proPromo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}"/></h:column>
                            <h:column><h:outputText  value="Coef. P.V.:" /></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proCoefVte}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <center>
                                <a4j:commandButton value="Valeur par défaut" onclick="if (!confirm('Voulez-vous restaurer les valeurs par défaut de la famille ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.valeurDefautFamilleVte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}" reRender="modAttente,panVente"/>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Tarifs" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.familleVte&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_tarification}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationTarification}" reRender="panelBoutonTarifSt,panelBoutonTarif"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.typeTarif}">
                    </c:if>
                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.typeTarif}">
                        <center>
                            <h:panelGroup id="panelBoutonTarifSt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action!=3}">
                                <a4j:commandButton title="Ajouter tarif" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajouterTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}"reRender="panelTarifSt"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Modifier tarif" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modifierTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" reRender="panelTarifSt"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a4j:commandButton title="Supprimer tarif"  image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deleteProduitTarif}" reRender="tableauTarifSt,panelBoutonTarifSt"/>
                            </h:panelGroup>
                        </center>
                        <br>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauTarifSt" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelTarif}" var="tarif">
                                <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonTarifSt"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitTarif}"    />
                                <rich:column sortable="false" sortBy="#{tarif.protarOrdre}" sortOrder="ASCENDING" width="5%" style="text-align:center;">
                                    <f:facet name="header" ><h:outputText value="Ord."  /></f:facet>
                                    <h:outputText value="#{tarif.protarOrdre}" />
                                </rich:column>
                                <rich:column sortable="false" width="20%">
                                    <f:facet name="header" ><h:outputText value="Famille client"/></f:facet>
                                    <h:outputText value="#{tarif.protarClient}"/>
                                </rich:column>
                                <rich:column sortable="false" width="10%">
                                    <f:facet name="header" ><h:outputText value="Condit."/></f:facet>
                                    <h:outputText value="#{tarif.var_lib_uni_condit}"/>
                                </rich:column>
                                <rich:column sortable="false" width="12%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix vente#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.htTtc}"/></f:facet>
                                    <h:outputText value="#{tarif.protarPv}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="12%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix Marché"/></f:facet>
                                    <h:outputText value="#{tarif.protarPvMarche}" rendered="#{tarif.protarPvMarche!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="12%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix CC1"/></f:facet>
                                    <h:outputText value="#{tarif.protarPvCc1}" rendered="#{tarif.protarPvCc1!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="12%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix CC2"/></f:facet>
                                    <h:outputText value="#{tarif.protarPvCc2}" rendered="#{tarif.protarPvCc2!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="12%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix CC3"/></f:facet>
                                    <h:outputText value="#{tarif.protarPvCc3}" rendered="#{tarif.protarPvCc3!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column sortable="false" width="5%" id="etatProdTar" style="text-align:center;">
                                    <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                    <h:commandButton image="#{tarif.etat}" rendered="#{tarif.inactif}" onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.reactiverProdTarif}" title="Supprimer" style="text-align:right;">
                                        <a4j:support eventsQueue="maQueue" reRender="etatProdTar,tableauTarifSt" event="onclick"/>
                                    </h:commandButton>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                        <center>
                            <a4j:commandButton value="Recalcul des PV" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.recalculPv}" onclick="if (!confirm('Voulez-vous recalculer les prix de vente de ce produit ?')) return false" title="Recalcul des stocks" reRender="tableauDepot"/>
                        </center>
                    </c:if>
                </rich:tab>

                <rich:tab label="Mots.cles" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_motcle}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationMotCle}" reRender="panelBoutonProdMCl"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonProdMCl" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action!=3}">
                            <a4j:commandButton title="Ajouter mot clé" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajoutMotCle}" reRender="panelProMotCle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Modifier mot clé"  image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modifMotCle}" reRender="panelProMotCle"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer mot clé"  image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deleteProduitMotCle}" reRender="panelBoutonProdMCl,tableauMotCle"/>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauMotCle" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelMotCle}" var="depotMotCle">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonProdMCl"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectMotCle}"    />
                            <rich:column sortable="false" sortBy="#{depotMotCle.promclMot}" sortOrder="ASCENDING" width="100%">
                                <f:facet name="header" ><h:outputText value="Mots clés"  /></f:facet>
                                <h:outputText value="#{depotMotCle.promclMot}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Ref.Historique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_ref_historique}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationRefHistorique}" reRender="boutonRefHist"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="boutonRefHist" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <a4j:commandButton title="Ajouter historique" image="/images/ajouter.png"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajoutHistoRef}" reRender="panelHistoRef"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Modifier historique" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtModifProdHistoRef&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" reRender="panelHistoRef"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer historique" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppProdHistoRef&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deleteProduitHistoRef}" reRender="boutonRefHist,tableauHistoref"></a4j:commandButton>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauHistoref" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelRefHisto}" var="histoRef">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="boutonRefHist"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectHistoRef}"    />
                            <rich:column  width="30%" sortable="false">
                                <f:facet name="header" ><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{histoRef.prohrfReference}" />
                            </rich:column>
                            <rich:column  width="20%" sortable="false">
                                <f:facet name="header" ><h:outputText value="Date de début"/></f:facet>
                                <h:outputText value="#{histoRef.prohrfDateDebut}"/>
                            </rich:column>
                            <rich:column  width="20%" sortable="false">
                                <f:facet name="header" ><h:outputText   value="Date de fin"/></f:facet>
                                <h:outputText value="#{histoRef.prohrfDateFin}"/>
                            </rich:column>
                            <rich:column  width="30%" sortable="false">
                                <f:facet name="header" ><h:outputText   value="Observations"/></f:facet>
                                <h:outputText value="#{histoRef.prohrfObs}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Services" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_acc_service}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.autorisationService}" reRender="panelBoutonService"/>
                    <jsp:include flush="true" page="/achats/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonService" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action!=3}">
                            <a4j:commandButton title="Ajouter service" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajoutProService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" reRender="panelService"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer service" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.afficheButtSuppProdServ&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.deleteProduitsServices}" reRender="panelBoutonService,tableauService"/>&nbsp; &nbsp;&nbsp;
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauService" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelProService}" var="serv">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonService,btsup"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectProduitsService}"    />
                            <rich:column sortable="false" sortBy="#{serv.proserCode}" sortOrder="ASCENDING" width="30%">
                                <f:facet name="header" ><h:outputText  value="Code service"/></f:facet>
                                <h:outputText value="#{serv.proserCode}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header" ><h:outputText  value="Libellé service"/></f:facet>
                                <h:outputText value="#{serv.proserNomFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleSaisie}" reRender="idSubView"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.majProduitRetour}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existCod}"/>
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>


    <rich:modalPanel id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitRecherche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitRecherche}" var="prdgrp">
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelProduitsLieRecherche}"  var="prd">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectionProduits}"/>
                        <f:facet name="header"></f:facet>
                        <rich:column label="Code" sortable="true" sortBy="#{prd.proCode}" width="15%">
                            <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                            <h:outputText value="#{prd.proCode}"/>
                        </rich:column>
                        <rich:column label="Libellé produit" sortable="true" sortBy="#{prd.proLibClient}" width="55%">
                            <f:facet name="header"><h:outputText  value="Libellé produit" /></f:facet>
                            <h:outputText value="#{prd.proLibClient}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{prd.proVteLib}" width="20%">
                            <f:facet name="header"><h:outputText  value="Famille" /></f:facet>
                            <h:outputText value="#{prd.proVteLib}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleProduits}" reRender="panelListeProduits"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculeProduits}" reRender="panelListeProduits,panelGrp,idProduitLie"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelProFour" width="700" height="470" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitFournisseur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitFournisseur}" var="frt">
            <f:facet name="header"><h:outputText value="GESTION DES FOURNISSEURS DES PRODUITS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleFournisseur}" image="/images/close.gif" styleClass="hidelink" reRender="panelProFour"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  id="four" columns="2" columnClasses="clos25,clos75" width="100%" >
                    <h:column><h:outputText  value="Nom du fournisseur:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText id="nomFour" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpTiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouId!=0}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase">
                            <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.rechercheTiers}" reRender="panelListeTiers,formModalListeTiers,nomFour" oncomplete="javascript:Richfaces.showModalPanel('panelListeTiers');"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Devise:"/></h:column>
                    <h:column><h:inputText id="inputDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouDevise}"  style="width:60px" readonly="true"/></h:column>
                    <h:column><h:outputText value="Taux Devise:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouTauxDevise}"  style="width:60px"/></h:column>
                    <h:column><h:outputText value="Date Devise:"/></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouDate}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                    <h:column><h:outputText value="Libellé fournisseur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouLib}" style="width:100%" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Référence fournisseur:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouRef}" maxlength="20"/></h:column>
                    <h:column><h:outputText value="Prix d'achat:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouPa}" style="text-align:right;">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.formatdeviseFournisseur==0}">
                                <f:convertNumber groupingUsed="true" locale="US" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.formatdeviseFournisseur==1}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.formatdeviseFournisseur==2}">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                            </c:if>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculEuro}" reRender="outputDevise" />
                        </h:inputText>&nbsp;&nbsp;
                        <h:outputText id="inputDevise2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouDevise}"/>
                    </h:column>
                    <h:column><h:outputText value="Prix en euro:"/></h:column>
                    <h:column>
                        <h:inputText id="outputDevise" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_prix_euro}" style="text-align:right;" readonly="true">
                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                        </h:inputText>&nbsp;&nbsp;
                        <h:outputText value="XEU"/>
                    </h:column>
                    <h:column><h:outputText value="Conditionnement1:"/></h:column>
                    <h:column id="cdt1">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouCondition1}" style="width:230px">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifFouConditionnement1}" reRender="cdt1,four"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Conditionnement2:"/></h:column>
                    <h:column id="cdt2">
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouCondition2}" style="width:230px">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifFouConditionnement2}" reRender="cdt2,four"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Conditionnement3:"/></h:column>
                    <h:column id="cdt3">
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouCondition3}" style="width:230px">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifFouConditionnement3}" reRender="cdt3,four"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Conditionnement4:"/></h:column>
                    <h:column id="cdt4">
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouCondition4}" style="width:230px">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifFouConditionnement4}" reRender="cdt4,four"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Conditionnement5:"/></h:column>
                    <h:column id="cdt5">
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsFournisseur.profouCondition5}" style="width:230px">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesConditionnementsItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifFouConditionnement5}" reRender="cdt5,four"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Désactivé:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpInactifProdFour}"/></h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="buttGrpProdFour">
                        <a4j:commandButton image="/images/valider_big.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existCodTiers}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.saveProduitsFournisseur}" reRender="tableProdFour,panelProFour,panelBoutonFour,tableauHistoref"/>
                        <h:panelGroup id="warning"rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existCodTiers}">
                            <h:graphicImage url="/images/Warning.png"  style="width:15px;height:15px;"/>&nbsp;&nbsp;
                            <h:outputText value="Ce fournisseur n'est pas valide ou existe déja" style="color:red;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelListeTiers" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalTiers}" var="tie">
            <f:facet name="header"><h:outputText value="Sélection du tiers"/></f:facet>
            <a4j:form id="formModalListeTiers">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <rich:extendedDataTable id="tableTiers" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.datamodelTiers}"  var="tiers">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectionTiers}"/>
                        <f:facet name="header"></f:facet>
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
                </h:panelGrid>
                <br>
                <h:panelGroup id="valtiers">
                    <center>
                        <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleTiers}" reRender="panelListeTiers,four,buttGrpProdFour"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculeTiers}" reRender="panelListeTiers,four,buttGrpProdFour"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelProDep" width="1200" height="330" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitDepot}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitDepot}" var="dep">
            <f:facet name="header"><h:outputText value="GESTION DES DEPOTS DES PRODUITS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleProduitsDepot}" image="/images/close.gif" styleClass="hidelink" reRender="panelProDep"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="3" columnClasses="clos33g,clos33g,clos33g" width="100%">
                    <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
                        <h:column><h:outputText  value="Dépôt:" style="text-decoration:underline;"/></h:column>
                        <h:column id="depCod" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepId==0}">
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpDepot}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepId!=0}">
                                <f:selectItem itemValue="0"  itemLabel="Sélectionner un dépôt"/>
                                <f:selectItems  id="depID" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.verifDepot}" reRender="buttDep"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepId!=0}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpDepot}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Groupage:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepGroupe}" maxlength="10"/></h:column>
                        <h:column><h:outputText value="Localisation:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepLocalisation}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Casier:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepCasier}" maxlength="20"/></h:column>
                        <h:column><h:outputText value="Quantité minimale:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteMini}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité maximale:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteMaxi}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité théo. Conso:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteConso}" style="text-align:right;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proStock<=4}"><h:outputText value="Unité de stockage:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produits.proStock<=4}">
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepUnite}" style="width:230px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesUnitesItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Quantité CMD achat:"/></h:column>
                        <h:column><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteCmdAch}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité CMD vente:"/></h:column>
                        <h:column><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteCmdVte}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité ATT achat:"/></h:column>
                        <h:column><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteAttAch}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité ATT vente"/></h:column>
                        <h:column><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteAttVte}" style="text-align:right;"/></h:column>
                        <h:column><h:outputText value="Quantité physique:"/></h:column>
                        <h:column><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepQteStk}" style="text-align:right;"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid columns="2" columnClasses="clos50d,clos50g" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:outputText value="Dernier PA:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepPa}" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:outputText value="Dernier PR:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepPr}" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:outputText value="PUMP:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:inputText readonly="true"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepPump}" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:outputText value="Valorisation au PUMP:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump>=1}"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepPump}" style="text-align:right;" readonly="true"/></h:column>
                        <h:column><h:outputText value="Dernier inventaire:"/></h:column>
                        <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepDateInv}" /></h:column>
                        <h:column><h:outputText value="Dernière entrée:"/></h:column>
                        <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepDateEntree}"/></h:column>
                        <h:column><h:outputText value="Dernière sortie:"/></h:column>
                        <h:column><h:inputText readonly="true" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsDepot.prodepDateSortie}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup  id="buttDep">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSave" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existCodDepot}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.saveProduitsDepot}" reRender="tableauDepot,panelProDep"/>
                        <h:panelGroup id="warning"rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.existCodDepot}">
                            <h:graphicImage url="/images/Warning.png"  style="width:15px;height:15px;"/>&nbsp;&nbsp;
                            <h:outputText value="Ce dépôt n'est pas valide ou existe déja" style="color:red;" />
                        </h:panelGroup>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelProMotCle" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalMotCles}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalMotCles}" var="moc">
            <f:facet name="header"><h:outputText value="GESTION DES MOTS CLES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleMotCles}" image="/images/close.gif" styleClass="hidelink" reRender="panelProMotCle"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:outputText value="Mot clé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsMcles.promclMot}" onkeypress="return scanToucheLettre(event)" style="width:300px;text-transform:uppercase"/>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdMotCle">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.majProduitsMotCle}" reRender="panelProMotCle,tableauMotCle,panelBoutonProdMCl"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelHistoRef" width="500" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalHistorique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalHistorique}" var="his">
            <f:facet name="header"><h:outputText value="HISTORIQUE DES CODES FOURNISSEURS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleHistoRef}" image="/images/close.gif" styleClass="hidelink" reRender="panelHistoRef"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:outputText value="Référence:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsHistoRef.prohrfReference}" onkeypress="return scanToucheLettre(event)" style="width:300px;text-transform:uppercase"/>
                    <h:outputText value="Date début:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsHistoRef.prohrfDateDebut}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    <h:outputText value="Date fin:"/>
                    <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsHistoRef.prohrfDateFin}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                    <h:outputText value="Observations:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsHistoRef.prohrfObs}" />
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup >
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.majProduitsHistoRef}" reRender="panelHistoRef,tableauHistoref,boutonRefHist"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelService" width="500" height="150" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalService}" var="ser">
            <f:facet name="header"><h:outputText value="AJOUT DE SERVICE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleService}" image="/images/close.gif" styleClass="hidelink" reRender="panelService"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2">
                    <h:outputText id="outcodlib" value="Code et libéllé des services" />
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.prodCodeLibService}">
                        <f:selectItem itemLabel="Sélectionner un service" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesServicesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="outcodlib,buttGrpProdSer,bbbbbSaveSer,outpAjtCodLib" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decoupageCodLibService}"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttGrpProdSer">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.saveProduitsServices}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testCodLibService}" reRender="panelService,tableauService,panelBoutonService"/>
                        <h:outputText  id="outpAjtCodLib" style="color:red;" value="Sélectionner un service qui n'est pas encore pris!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testCodLibService}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelTarifSt" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalTarifSt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalTarifSt}" var="tst">
            <f:facet name="header"><h:outputText value="GESTION DES TARIFS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.annuleTarif}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifSt"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">
                    <rich:tab id="tabDoc" label="Tarif principal">
                        <h:panelGrid columns="2" columnClasses="clos35,clos65g" width="100%">
                            <h:column><h:outputText value="Famille client:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="depIDord" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.tarifOrdClt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.tarifOrdClt!='100'}">
                                    <f:selectItem itemLabel="Sélectionnez la famille" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesFamilleClientsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decouperMesTarifItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarCondit}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.mesConditionnementsProduits}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.decouperMesTarifItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Prix de vente:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPv}"  style="text-align:right;width:150px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="false"><h:outputText value="Coéfficient P.V.:"/></h:column>
                            <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarCoef}" style="text-align:right;width:80px"/></h:column>
                            <h:column><h:outputText value="Inactif:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.inpInactifProdTarif}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabDeg" label="Tarif dégressif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <h:panelGrid id="idBtnTarif" width="200px" columns="3">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau tarif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ajouterTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_ajt}" reRender="panelTarifDegressif,idBtnTarif"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la tarif sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.modifierTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.visibiliteBtonTarif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_mod}" reRender="panelTarifDegressif,idBtnTarif"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer le tarif sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.supprimerTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.visibiliteBtonTarif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_sup}" reRender="idBtnTarif,tableTarifDegressif"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableTarifDegressif" height="150px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.dataModelTarifDegressif}" var="tdg">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.selectionTarifDegressif}" reRender="idBtnTarif"/>
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
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabCon" label="Tarif concurrent">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Prix du marché:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPvMarche}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarDateMarche}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" />
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarNomCc1}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPvCc1}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarDateCc1}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarNomCc2}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPvCc2}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarDateCc2}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarNomCc3}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarPvCc3}"  style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsTarif.protarDateCc3}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabSpe" label="Tarifs clients">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableTarifClients" height="150px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.dataModelTarifClients}" var="bar">
                                <rich:column  width="20%" sortBy="#{bar.barCategorieTiers}">
                                    <f:facet name="header"><h:outputText  value="Famille tiers"/></f:facet>
                                    <h:outputText value="#{bar.barCategorieTiers}"/>
                                </rich:column>
                                <rich:column  width="30%" sortBy="#{bar.barNomTiers}">
                                    <f:facet name="header"><h:outputText  value="Nom tiers"/></f:facet>
                                    <h:outputText value="#{bar.barNomTiers}"/>
                                </rich:column>
                                <rich:column  width="15%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Remise" /></f:facet>
                                    <h:outputText value="#{bar.barRemise}" rendered="#{bar.barRemise!=0}" style="text-align:right"/>
                                </rich:column>
                                <rich:column  width="15%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.libelleRabRis}" /></f:facet>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ristourne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.ristourne}">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column  width="20%"  style="text-align:right">
                                    <f:facet name="header"><h:outputText  value="Prix" /></f:facet>
                                    <h:outputText value="#{bar.barPrix}" rendered="#{bar.barPrix!=0}" style="text-align:right">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                </rich:tabPanel>

                <br/> <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdFour">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveTar" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.saveProduitsTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testDoubleProduitsTarif}" reRender="panelTarifSt,tableauTarifSt,panelBoutonTarifSt"/>
                        <h:outputText  id="outpAjt" style="color:red;" value="La famille et le conditionnement doivent être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.testDoubleProduitsTarif}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelTarifDegressif" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalPanelTarifDegressif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalPanelTarifDegressif}" var="tdr">
            <f:facet name="header"><h:outputText value="TARIF DEGRESSIF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.fermerTarifDegressif}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifDegressif"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%">
                    <h:column><h:outputText value="Quantité minimale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.objetTarif.qteDebut}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Quantité maximale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.objetTarif.qteFin}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Prix:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.objetTarif.prix}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttTarDegres">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.validerTarifDegressif}" reRender="panelTarifDegressif,tableTarifDegressif,idBtnTarif"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel id="panelGrp" width="700" height="300" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitGroupe}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.showModalProduitGroupe}" var="frt">
            <f:facet name="header"><h:outputText value="GESTION DES PRODUITS DU GROUPE"></h:outputText></f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  id="idProduitGrp" columns="2" columnClasses="clos25,clos75" width="100%" styleClass="fichefournisseur">
                    <h:column><h:outputText  value="Code:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:inputText id="nomProduit" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpCode}" style="width:150px" >
                            <rich:toolTip id="tooladdClt" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits" style="background-color:#FFF8D4;"/>
                            <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.rechercheProduitsGroupe}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelListeProduits,formModalListeProduits,idProduitGrp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpLibelle}" style="width:95%" readonly="true"/></h:column>
                    <h:column><h:outputText value="Quantité:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpQte}" style="width:150px;text-align:right"/></h:column>
                    <h:column><h:outputText value="Dépot:"/></h:column>
                    <h:column>
                        <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpDepot}" style="width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.var_action==3}">
                            <f:selectItem itemLabel="" itemValue=""/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.mesDepotProduitGroupeItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.calculeDepotGroupe}" reRender="idUnite,idPump"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Unité:"/></h:column>
                    <h:column><h:inputText id="idUnite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpUnite}" style="width:150px"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump!=0}"><h:outputText value="Pump:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAchPump!=0}">
                        <h:inputText id="idPump" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.produitsGrp.progrpPump}" style="width:150px;text-align:right" readonly="true">
                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/> <br/>
                <center>
                    <h:panelGroup id="buttGrpProdgrp">
                        <a4j:commandButton image="/images/annuler_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.fermerProduitGroupe}" reRender="panelGrp"/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduitsAchs.validerProduitGroupe}" reRender="tableauGrp,panelGrp,pantableauGrp"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>
