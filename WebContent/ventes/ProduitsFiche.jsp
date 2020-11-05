<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ficproduits">

    <a4j:form id="produitformvte" enctype="multipart/form-data">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="FICHE PRODUIT (VENTE)" style="color:green;"/></h2></center>

        <h:panelGrid width="100%">
            <rich:tabPanel switchType="client" immediate="true" id="tabProduit"  style="border:0px;">

                <rich:tab label="Descriptif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_descriptif}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationDescription}" reRender="panDescription"/>
                    <h:panelGrid id="panDescription" width="100%">
                        <h:panelGrid columns="2" columnClasses="clos15,clos85" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText  value="Famille vente:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:600px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.inpFamilleVnt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>=2}">
                                    <f:selectItem itemLabel="Sélectionnez une famille" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamillesVentesUtilItems}"/>
                                    <a4j:support eventsQueue="maQueue"  event="onchange" reRender="panelButton,codPrd,nat,idMarque" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.calculeCode}" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Nature vente:"/></h:column>
                            <h:column><h:outputText id="nat" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.inpNatureVnt}" /></h:column>
                            <h:column><h:outputText value="Code produit:"/></h:column>
                            <h:column>
                                <h:inputText id="codPrd" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verouxCod}" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCode}" onkeypress="return scanToucheLettre(event)" style="width:200px;text-transform:uppercase" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>=2}">
                                    <a4j:support eventsQueue="maQueue" event="onblur" reRender="panelButton" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifCode}" />
                                </h:inputText>&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column><h:outputText value="Etat Produit:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column>
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proInactif}" style="color:red">
                                        <f:selectItem itemLabel="ACTIF" itemValue="0"/>
                                        <f:selectItem itemLabel="DESACTIVE" itemValue="1"/>
                                        <f:selectItem itemLabel="A SUPPRIMER" itemValue="2"/>
                                    </h:selectOneMenu>
                                </h:column>
                                <h:column><h:outputText value="Libellé libre dans documents:" style="color:red"/></h:column>&nbsp;&nbsp;
                                <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.libelle_libre}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve=='0'}"><h:outputText value="Série:"/></h:column>&nbsp;&nbsp;
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve=='0'}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proSerie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
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
                            <h:column><h:inputText size="72" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLibClient}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Libellé technique:"/></h:column>
                            <h:column><h:inputText size="72" maxlength="100" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLibTech}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code Option:"/></h:column>
                            <h:column><h:inputText style="width:200px;" maxlength="15" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCodeOption}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Descriptif:"/></h:column>
                            <h:column>
                                <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proDescrip}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <jsp:include flush="true" page="../css/tdt.jsp"/>
                                </rich:editor>
                            </h:column>
                            <h:column><h:outputText value="Marque:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idMarque" style="width:800px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proMarque}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="Sans marque" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesMarquesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Constructeur:"/></h:column>
                            <h:column><h:inputText size="72" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proConstructeur}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="50" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" columnClasses="clos15,clos35,clos25,clos25g" width="100%" styleClass="fichefournisseur">
                            <h:column><h:outputText value="Produit lié:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:inputText tabindex="1" id="inpCodDet" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCodeLie}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <rich:toolTip id="tooladdPrd" followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les produits" style="background-color:#FFF8D4;"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.rechercheProduitsLies}" reRender="panelListeProduits,formModalListeProduits" oncomplete="javascript:Richfaces.showModalPanel('panelListeProduits');"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Quantité liée:"/></h:column>
                            <h:column><h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proQteLie}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Photos" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_photo}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationPhoto}" reRender="panPhoto,panPdf"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Photo"/></f:facet>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPhoto==null}">
                            <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.uploadedFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajoutPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                            </h:commandButton>
                            <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup  id="grp3">
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPhoto!=null}">
                                <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.urlphotoProd}" width="150px" height="150px"/>&nbsp;
                                <h:panelGrid columns="2" width="150px">
                                    <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPhotoTaille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                        <f:selectItem itemLabel="Petit format" itemValue="0"/>
                                        <f:selectItem itemLabel="Grand format" itemValue="1"/>
                                    </h:selectOneRadio>
                                    <h:commandButton image="/images/supprimer.png" title="supprimer photo" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cette photo ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.reInitPhoto}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/>
                                </h:panelGrid>
                            </c:if>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPhoto==null}">
                                <img alt="" src="images/no_image.jpeg" width="150px" height="150px" />
                            </c:if>
                        </h:panelGroup>
                    </h:panelGrid>
                    <h:panelGrid id="panPdf" columns="2" style="height:170px" width="100%" styleClass="top" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="PDF"/></f:facet>
                        <h:panelGroup rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_affFicPdf}">
                            <t:inputFileUpload id="filePdf"  storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.uploadedPDFFile}"/>
                            <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.submitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                <a4j:support eventsQueue="maQueue"  immediate="true"/>
                            </h:commandButton>
                            <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                        </h:panelGroup>
                        <br/>
                        <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_affFicPdf}">
                            <h:outputText value="Nom:"/>&nbsp;&nbsp;&nbsp;
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPdf}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton value="Lire le ficher" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.readPdfFile}" />&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/supprimer.png" title="supprimer PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.reInitPDF}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Caractéristiques " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_caracteristique}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationCaracteristique}" reRender="prodcarteristique"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <h:panelGrid width="100%" id="prodcarteristique" >
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat=='1604'}" >
                            <h:outputText value="Type:"/>
                            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                <f:selectItem itemLabel="N.R." itemValue="0"/>
                                <f:selectItem itemLabel="ESSENCE" itemValue="1"/>
                                <f:selectItem itemLabel="GAZOIL" itemValue="2"/>
                                <f:selectItem itemLabel="GPL" itemValue="3"/>
                                <f:selectItem itemLabel="KEROSENE" itemValue="4"/>
                                <f:selectItem itemLabel="FUEL" itemValue="5"/>
                                <f:selectItem itemLabel="JETA1" itemValue="6"/>
                                <f:selectItem itemLabel="ELECTRIQUE" itemValue="7"/>
                                <f:selectItem itemLabel="HYBRIDE" itemValue="8"/>
                                <f:selectItem itemLabel="SOLAIRE" itemValue="9"/>
                                <f:selectItem itemLabel="CHARBON" itemValue="10"/>
                                <f:selectItem itemLabel="NUCLEAIRE" itemValue="11"/>
                                <f:selectItem itemLabel="AUTRE" itemValue="12"/>
                            </h:selectOneRadio>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat=='1605'}" >
                            <h:outputText value="Type:"/>
                            <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                <f:selectItem itemLabel="N.R." itemValue="0"/>
                                <f:selectItem itemLabel="MOTEUR" itemValue="1"/>
                                <f:selectItem itemLabel="BOITE" itemValue="2"/>
                                <f:selectItem itemLabel="PONT" itemValue="3"/>
                                <f:selectItem itemLabel="SUSPENSION" itemValue="4"/>
                                <f:selectItem itemLabel="AUTRE" itemValue="5"/>
                            </h:selectOneRadio>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat=='1614'}" >
                            <h:panelGrid id="caract" columns="2" columnClasses="clos50d,clos50g">
                                <h:column><h:outputText value="Energie:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proEnergie}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Nb portes:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proNbPorte}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Nb places:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proNbPlace}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Boite vitesse:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proBoiteVitesse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Puissance:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPuissance}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Puissance DIN:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPuissanceDin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Cylindrée:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCylindree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Genre:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proGenre}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Carrosserie:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCarrosserie}" maxlength="10" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                <h:column><h:outputText value="Couleur:"/></h:column>
                                <h:column>
                                    <h:selectOneMenu id="idCouleur1" style="width:800px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCouleur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                        <f:selectItem itemLabel="Sans couleur" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCouleursItems}"/>
                                    </h:selectOneMenu>
                                </h:column>
                            </h:panelGrid>
                            <h:panelGrid id="commission" columns="2" columnClasses="clos50d,clos50g">
                                <h:column><h:outputText value="Commission / Unité:"/></h:column>
                                <h:column>
                                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proComUnite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:inputText>
                                </h:column>
                                <h:column><h:outputText value="% commission / CA:"/></h:column>
                                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proComPourcentage}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            </h:panelGrid>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat!='1604'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat!='1605'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteNat!='1614'}" >
                            <h:panelGrid columns="2" width="100%" style="background-color:#DAEECB;">
                                <h:outputText value="Option du produit:"/>
                                <h:selectOneRadio layout="lineDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proMode}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="Simple" itemValue="0"/>
                                    <f:selectItem itemLabel="Groupe visible" itemValue="1"/>
                                    <f:selectItem itemLabel="Groupe invisible" itemValue="2"/>
                                    <f:selectItem itemLabel="Forfait" itemValue="3"/>
                                    <f:selectItem itemLabel="Calcul automatique" itemValue="4"/>
                                    <f:selectItem itemLabel="Générique" itemValue="5" itemDisabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.optionsVentes.produitGenerique=='0'}"/>
                                    <a4j:support eventsQueue="maQueue" event="onclick" reRender="prodcarteristique,grpButt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.recupererCalc}" />
                                </h:selectOneRadio>
                            </h:panelGrid>
                            <h:panelGrid columns="2" columnClasses="cols20,clos80" width="100%" style="background-color:#DAEECB;" id="grpButt" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheFormule}">
                                <h:outputText value="Formule:"/>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proFormule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}" style="width:100%"/>
                            </h:panelGrid>
                            <br>
                            <h:panelGrid columnClasses="clos50g,clos50g" id="caracteristique" columns="2" width="100%">
                                <h:column>
                                    <h:panelGrid id="caract" columns="2" columnClasses="clos50d,clos50g">
                                        <h:column><h:outputText value="Nb d'unités:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proNbUnite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Etat (Liquide ...):"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                                        <h:column><h:outputText value="Longueur:" /></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLongueur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Largeur:" /></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proLargeur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Epaisseur:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proEpaisseur}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Volume:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVolume}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                                        <h:column><h:outputText value="Couleur:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu id="idCouleur2" style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCouleur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                                <f:selectItem itemLabel="Sans couleur" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCouleursItems}"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                                        <h:column><h:outputText value="Poids brut:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPoidsBrut}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Poids net:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPoidsNet}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <rich:spacer height="10px"/><rich:spacer height="10px"/>
                                        <h:column><h:outputText value="Diamètre interne:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proDiamInt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Diamètre externe:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proDiamExt}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Densité (Kg/L):"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proDensite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Pression (B):"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPression}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Usage:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proUsage}" maxlength="20" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                        <h:column><h:outputText value="Manchon:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proManchon}" maxlength="10" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                    </h:panelGrid>
                                    <h:panelGrid id="commission" columns="2" columnClasses="clos50d,clos50g" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.optionsVentes.modeCommission=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.optionsVentes.modeCommission=='2'}">
                                        <h:column><h:outputText value="Commission / Unité:"/></h:column>
                                        <h:column>
                                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proComUnite}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                            </h:inputText>
                                        </h:column>
                                        <h:column><h:outputText value="% commission / CA:"/></h:column>
                                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proComPourcentage}" style="text-align:right;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                                    </h:panelGrid>
                                </h:column>
                                <h:column>
                                    <h:panelGrid id="pantableauGrp" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.existGrp}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauGrp"footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelGrp}" var="depotgrp">
                                                <rich:column sortable="false" sortBy="#{depotgrp.progrpCode}" sortOrder="ASCENDING" width="20%">
                                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                                    <h:outputText value="#{depotgrp.progrpCode}"/>
                                                </rich:column>
                                                <rich:column sortable="false" sortBy="#{depotgrp.progrpLibelle}"  width="30%">
                                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                                    <h:outputText value="#{depotgrp.progrpLibelle}"/>
                                                </rich:column>
                                                <rich:column sortable="false" sortBy="#{depotgrp.progrpQte}"  width="20%">
                                                    <f:facet name="header" ><h:outputText value="Quantité"/></f:facet>
                                                    <h:outputText value="#{depotgrp.progrpQte}"/>
                                                </rich:column>
                                                <rich:column sortable="false" sortBy="#{depotgrp.progrpUnite}"  width="15%" style="text-align:right;">
                                                    <f:facet name="header" ><h:outputText value="Unité"/></f:facet>
                                                    <h:outputText value="#{depotgrp.progrpUnite}"  />
                                                </rich:column>
                                                <rich:column sortable="false" sortBy="#{depotgrp.progrpDepot}"  width="15%">
                                                    <f:facet name="header" ><h:outputText value="Dépot"/></f:facet>
                                                    <h:outputText value="#{depotgrp.progrpDepot}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                    <h:panelGrid id="pantableauGrpbis" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.existGrpCode}">
                                        <a4j:region renderRegionOnly="false">
                                            <rich:extendedDataTable width="100%" style="border:solid 0px green;" border="0"  height="250px" id="tableauGrpbis" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelCode}" var="depotgrp">
                                                <rich:column sortable="false" sortBy="#{depotgrp.proCode}" sortOrder="ASCENDING" width="30%">
                                                    <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                                    <h:outputText value="#{depotgrp.proCode}"/>
                                                </rich:column>
                                                <rich:column sortable="false" sortBy="#{depotgrp.proLibClient}"  width="70%">
                                                    <f:facet name="header" ><h:outputText value="Libellé"/></f:facet>
                                                    <h:outputText value="#{depotgrp.proLibClient}"/>
                                                </rich:column>
                                            </rich:extendedDataTable>
                                        </a4j:region>
                                    </h:panelGrid>
                                </h:column>
                            </h:panelGrid>
                        </c:if>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Stock" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_stock&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proMode!=5}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationStock}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationStock}" reRender="tableauStock"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0" height="250px" id="tableauStock" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelDepot}" var="depotstock">
                            <rich:column sortable="true" sortBy="#{depotstock.prodepCle}" sortOrder="ASCENDING" width="20%">
                                <f:facet name="header" ><h:outputText value="Code dépôt"  /></f:facet>
                                <h:outputText value="#{depotstock.depot.dpoCode}" />
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{depotstock.prodepCasier}"  width="20%">
                                <f:facet name="header" ><h:outputText value="Casier"  /></f:facet>
                                <h:outputText value="#{depotstock.prodepCasier}"/>
                            </rich:column>
                            <rich:column sortable="true" sortBy="#{depotstock.prodepLocalisation}"  width="15%">
                                <f:facet name="header" ><h:outputText  value="Localisation"  /></f:facet>
                                <h:outputText value="#{depotstock.prodepLocalisation}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte CMD Achat"/></f:facet>
                                <h:outputText value="#{depotstock.prodepQteCmdAch}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte ATT Achat"/></f:facet>
                                <h:outputText value="#{depotstock.prodepQteAttAch}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte CMD vente"/></f:facet>
                                <h:outputText value="#{depotstock.prodepQteCmdVte}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte ATT Vente"/></f:facet>
                                <h:outputText value="#{depotstock.prodepQteAttVte}" />
                            </rich:column>
                            <rich:column  width="9%" sortable="false" style="text-align:right;" >
                                <f:facet name="header" ><h:outputText value="Qte physique"/></f:facet>
                                <h:outputText value="#{depotstock.prodepQteStk}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Option.vente" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_option_vte}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationOptionVte}" reRender="panVente"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <h:panelGrid id="panVente" width="100%">
                        <h:panelGrid columns="2" id="idGrdVente" width="100%" columnClasses="clos15,clos35">
                            <h:column><h:outputText value="Nature vente:" style="text-decoration:underline;" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.inpNatureVnt}" style="width:100%" readonly="true"/></h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Code TVA:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteTva}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesTaxesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Exonéré de TVA:" style="color:red" /></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proExoTva}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            <h:column><h:outputText value="Code Douane:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteDouane}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesDouanesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  id="idGrdVente2" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
                            <h:column><h:outputText value="Compte vente local taxable:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteLoc}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteVteLocItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente local non taxable:" style="text-decoration:underline;" /></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteNTx}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteVteLocItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteZ}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteVteZItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte vente hors zone:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteHz}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteVteHzItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de produit:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCptePr}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteProduitsItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Compte de stock:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteSt}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteStocksItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='4'}"><h:outputText value="Compte de caisse:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strtypeentreprise=='4'}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proVteCpteCa}" style="width:90%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesCompteCaisseItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  id="idGrdVente3" width="100%" columnClasses="clos15,clos35">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proAchCode==''||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proAchCode==null}"><h:outputText value="Mode gestion stock:" style="text-decoration:underline;" /></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proAchCode==''||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proAchCode==null}">
                                <h:selectOneMenu style="width:230px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proStock}" disabled="true">
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
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proDepotVte}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesDepotCodeItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCle1}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCle2}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageActivite}">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proActivite}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageActivite}">
                                <a4j:region renderRegionOnly="false">
                                    <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelDecoupageActivtes}" var="saisieAnal">
                                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionAnalytique}"/>
                                        <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.laColonne1Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.valideColonne1}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.laColonne2Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.valideColonne2}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageActivite}">
                                            <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                            <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                                <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.laColonne3Items}"/>
                                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.valideColonne3}" />
                                            </h:selectOneMenu>
                                        </rich:column>
                                        <rich:column label="%"  width="15%" style="text-align:right;">
                                            <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                            <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.controleEcartAnalytique}" reRender="idTableAnal" />
                                            </h:inputText>
                                        </rich:column>
                                        <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                            <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.supprimerAnalytique}" reRender="idTableAnal"/>
                                        </rich:column>
                                    </rich:extendedDataTable>
                                </a4j:region>
                            </h:column>
                            <h:column><h:outputText  value="Code promotion:" /></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proPromo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}"/></h:column>
                            <h:column><h:outputText  value="Coef. P.V.:" /></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCoefVte}" style="text-align:right" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="2"  id="idGrdVente4" width="100%" columnClasses="clos15,clos35"  style="background-color:#DAEECB;">
                            <h:column><h:outputText value="Conditionnement1:"/></h:column>
                            <h:column id="cdt11">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCondition1}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifConditionnement1}" reRender="cdt11,idGrdVente3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement2:"/></h:column>
                            <h:column id="cdt12">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCondition2}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifConditionnement2}" reRender="cdt12,idGrdVente3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement3:"/></h:column>
                            <h:column id="cdt13">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCondition3}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifConditionnement3}" reRender="cdt13,idGrdVente3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement4:"/></h:column>
                            <h:column id="cdt14">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCondition4}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifConditionnement4}" reRender="cdt14,idGrdVente3"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement5:"/></h:column>
                            <h:column id="cdt15">
                                <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produits.proCondition5}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.verifConditionnement5}" reRender="cdt15,idGrdVente3"/>
                                </h:selectOneMenu>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                            <center>
                                <a4j:commandButton value="Valeur par défaut" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.valeurDefautFamille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action==3}" onclick="if (!confirm('Voulez-vous restaurer les valeurs par défaut de la famille ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,panVente"/>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab label="Tarifications" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_tarification}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationTarification}" reRender="panelBoutonTarif"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonTarif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action!=3}">
                            <a4j:commandButton title="Ajouter tarif" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajouterTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" reRender="panelTarifSt"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="Modifier tarif" image="/images/modifier.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modifierTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtModifProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mod}" reRender="panelTarifSt"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer tarif" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtSuppProdTar&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.supprimerTarif}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonTarif,tableauTarif"/>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauTarif" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelTarif}" var="tarif">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonTarif"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionTarif}"/>
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
                                <f:facet name="header"><h:outputText  value="Prix vente#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.htTtc}"/></f:facet>
                                <h:outputText value="#{tarif.protarPv}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="12%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAffPvMarche!=0}">
                                <f:facet name="header"><h:outputText  value="Prix Marché"/></f:facet>
                                <h:outputText value="#{tarif.protarPvMarche}" rendered="#{tarif.protarPvMarche!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="12%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAffPvMarche!=0}">
                                <f:facet name="header"><h:outputText  value="Prix CC1"/></f:facet>
                                <h:outputText value="#{tarif.protarPvCc1}" rendered="#{tarif.protarPvCc1!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="12%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAffPvMarche!=0}">
                                <f:facet name="header"><h:outputText  value="Prix CC2"/></f:facet>
                                <h:outputText value="#{tarif.protarPvCc2}" rendered="#{tarif.protarPvCc2!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="12%" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAffPvMarche!=0}">
                                <f:facet name="header"><h:outputText  value="Prix CC3"/></f:facet>
                                <h:outputText value="#{tarif.protarPvCc3}" rendered="#{tarif.protarPvCc3!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column sortable="false" width="5%" id="etatProdTar" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:commandButton image="#{tarif.etat}" rendered="#{tarif.inactif}" onclick="if (!confirm('Voulez-vous réactiver ce journal ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.reactiverProdTarif}" title="Supprimer" style="text-align:right;">
                                    <a4j:support eventsQueue="maQueue" reRender="etatProdTar,tableauTarif" event="onclick"/>
                                </h:commandButton>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Mots.cles" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_motcle}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationMotCle}" reRender="panelBoutonProdMCl"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonProdMCl" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action!=3}">
                            <a4j:commandButton title="Ajouter mot clé" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajoutMotCle}" reRender="panelProMotCle"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="Modifier mot clé" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modifMotCle}" reRender="panelProMotCle"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="Supprimer mot clé" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtModifProdMotCle&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}"  onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.deleteProduitMotCle}" reRender="panelBoutonProdMCl,tableauMotCle"/>
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauMotCle" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelMotCle}" var="depotMotCle">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" reRender="panelBoutonProdMCl"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectMotCle}"    />
                            <rich:column sortable="false" sortBy="#{depotMotCle.promclMot}" sortOrder="ASCENDING" width="100%">
                                <f:facet name="header" ><h:outputText value="Mots clés"  /></f:facet>
                                <h:outputText value="#{depotMotCle.promclMot}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

                <rich:tab label="Services" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action>='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_acc_service}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.autorisationService}" reRender="panelBoutonService"/>
                    <jsp:include flush="true" page="/ventes/ProduitsCommun.jsp" />
                    <center>
                        <h:panelGroup id="panelBoutonService" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_action!=3}">
                            <a4j:commandButton title="ajouter" image="/images/ajouter.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajoutProService}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" reRender="panelService"/>&nbsp; &nbsp;&nbsp;
                            <a4j:commandButton title="supprimer"  image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.afficheButtSuppProdServ&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.deleteProduitsServices}" reRender="tableauService,panelBoutonService"/>&nbsp; &nbsp;&nbsp;
                        </h:panelGroup>
                    </center>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable width="100%" style="border:solid 0px green;" styleClass="bg" border="0"  height="250px" id="tableauService" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd"  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelProService}" var="serv">
                            <a4j:support eventsQueue="maQueue" event="onRowClick"  reRender="panelBoutonService,btsup"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.initProduitsServiceSelected}"    />
                            <rich:column sortable="false" sortBy="#{serv.proserCode}" sortOrder="ASCENDING" width="30%">
                                <f:facet name="header" ><h:outputText  value="Code service"  /></f:facet>
                                <h:outputText value="#{serv.proserCode}"/>
                            </rich:column>
                            <rich:column sortable="false" width="70%">
                                <f:facet name="header" ><h:outputText  value="Libellé service"  /></f:facet>
                                <h:outputText value="#{serv.proserNomFr}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelButton">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleSaisie}"  />&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.majProduitRetour}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.existCod}" />
                </center>
            </h:panelGroup>

        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panelTarifSt" width="650" height="350" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalTarifSt}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalTarifSt}" var="tst">
            <f:facet name="header"><h:outputText value="GESTION DES TARIFS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleTarif}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifSt"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true"  id="panelGlobal" style="border:0px;background-color:white;">

                    <rich:tab id="tabDoc" label="Tarif principal">
                        <h:panelGrid columns="2" columnClasses="clos35,clos65g" width="100%">
                            <h:column><h:outputText value="Famille client:"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="depIDord" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tarifOrdClt}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.tarifOrdClt!='100'}">
                                    <f:selectItem itemLabel="Sélectionnez la famille" itemValue="100"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesFamilleClientsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decouperMesTarifItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Conditionnement:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarCondit}">
                                    <f:selectItem itemLabel="" itemValue=""/>
                                    <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesConditionnementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" reRender="depIDord,buttGrpProdFour,bbbbbSaveTar,outpAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decouperMesTarifItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Prix de vente:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarPv}"  style="text-align:right;width:150px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="false"><h:outputText value="Coéfficient P.V.:"/></h:column>
                            <h:column rendered="false"><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarCoef}" style="text-align:right;width:80px"/></h:column>
                            <h:column><h:outputText value="Inactif:"/></h:column>
                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.inpInactifProdTarif}"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                    <rich:tab id="tabDeg" label="Tarif dégressif" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <h:panelGrid id="idBtnTarif" width="200px" columns="3">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter un nouveau tarif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajouterTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" reRender="panelTarifDegressif,idBtnTarif"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier le tarif sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modifierTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mod}" reRender="panelTarifDegressif,idBtnTarif"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer le tarif sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.supprimerTarifDegressif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarif&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}" reRender="idBtnTarif,tableTarifDegressif"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableTarifDegressif" height="150px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelTarifDegressif}" var="tdg">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionTarifDegressif}" reRender="idBtnTarif"/>
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

                    <rich:tab id="tabPromo" label="Tarif promotionnel" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                        <h:panelGrid id="idBtnPromo" width="200px" columns="3">
                            <a4j:commandButton image="/images/ajouter.png" title="Ajouter une nouvelle promotion" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ajouterTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_ajt}" reRender="panelTarifPromotion,idBtnPromo"/>
                            <a4j:commandButton image="/images/modifier.png" title="Modifier la promotion sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.modifierTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarifPromotion&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_mod}" reRender="panelTarifPromotion,idBtnPromo"/>
                            <a4j:commandButton image="/images/supprimer.png" title="Supprimer la promotion sélectionnée" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.supprimerTarifPromotion}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.visibiliteBtonTarifPromotion&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.var_sup}" reRender="idBtnPromo,tableTarifPromotion"/>
                        </h:panelGrid>
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableTarifPromotion" height="150px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelTarifPromotion}" var="tdp">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionTarifPromotion}" reRender="idBtnPromo"/>
                                <rich:column label="Date début promotion" sortable="false" width="20%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Du"/></f:facet>
                                    <h:outputText value="#{tdp.barDateDebut}"  style="text-align:right;">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date fin promotion" sortable="false" width="20%"  style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Au"/></f:facet>
                                    <h:outputText  value="#{tdp.barDateFin}"  style="text-align:right;">
                                        <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Prix remisé" sortable="false" width="30%"  style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Prix"/></f:facet>
                                    <h:outputText  value="#{tdp.barPrix}"  style="text-align:right;">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="% remise" sortable="false" width="20%"  style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%"/></f:facet>
                                    <h:outputText  value="#{tdp.barRemise}"  style="text-align:right;">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>

                    <rich:tab id="tabSpe" label="Tarifs clients">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="tableTarifClients" height="150px" width="100%" enableContextMenu="false" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " styleClass="bg" style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.dataModelTarifClients}" var="bar">
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
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.libelleRabRis}" /></f:facet>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ristourne}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                    <h:outputText value="#{bar.barRabais}" style="text-align:right" rendered="#{bar.barRabais!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.ristourne}">
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

                    <rich:tab id="tabCon" label="Tarif concurrent">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                            <h:column><h:outputText value="Prix du marché:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarPvMarche}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarDateMarche}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 1:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarNomCc1}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarPvCc1}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarDateCc1}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 2:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarNomCc2}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarPvCc2}" style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarDateCc2}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                            <h:column><h:outputText value="Prix concurrent 3:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarNomCc3}" style="text-align:right;width:150px"/>&nbsp;&nbsp;&nbsp;
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarPvCc3}"  style="text-align:right;width:80px">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Maj le:"/>&nbsp;
                                <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsTarif.protarDateCc3}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br/> <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdFour">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveTar" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.saveProduitsTarif}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.testDoubleProduitsTarif}" reRender="panelTarifSt,panelBoutonTarif,tableauTarif"/>
                        <h:outputText  id="outpAjt" style="color:red;" value="La famille et le conditionnement doivent être unique!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.testDoubleProduitsTarif}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTarifDegressif" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifDegressif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifDegressif}" var="tdr">
            <f:facet name="header"><h:outputText value="TARIF DEGRESSIF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.fermerTarifDegressif}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifDegressif"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%">
                    <h:column><h:outputText value="Quantité minimale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.objetTarif.qteDebut}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Quantité maximale:" /></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.objetTarif.qteFin}" style="text-align:right;"/></h:column>
                    <h:column><h:outputText value="Prix:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.objetTarif.prix}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttTarDegres">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.validerTarifDegressif}" reRender="panelTarifDegressif,tableTarifDegressif,idBtnTarif"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelTarifPromotion" width="500" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifPromotion}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalPanelTarifPromotion}" var="tdp">
            <f:facet name="header"><h:outputText value="TARIF PROMOTIONNEL"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.fermerTarifPromotion}" image="/images/close.gif" styleClass="hidelink" reRender="panelTarifPromotion"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" width="100%">
                    <h:column><h:outputText value="Date début promo.:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barDateDebut}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    <h:column><h:outputText value="Date fin promo:" /></h:column>
                    <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barDateFin}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    <h:column><h:outputText value="Prix remisé:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barPrix}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="% promotion:" /></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.baremes.barRemise}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttTarPromo">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.validerTarifPromotion}" reRender="panelTarifPromotion,tableTarifPromotion,idBtnPromo"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelProMotCle" width="400" height="200" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalMotCles}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalMotCles}" var="moc">
            <f:facet name="header"><h:outputText value="GESTION DES MOTS CLES"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleMotCles}" image="/images/close.gif" styleClass="hidelink" reRender="panelProMotCle"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%">
                    <h:outputText value="Mot clé:"/>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.produitsMcles.promclMot}" onkeypress="return scanToucheLettre(event)" style="width:300px;text-transform:uppercase"/>
                </h:panelGrid>
                <br/>  <br/>
                <center>
                    <h:panelGroup  id="buttGrpProdMotCle">
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.majProduitsMotCle}" reRender="panelProMotCle,tableauMotCle,panelBoutonProdMCl"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelService" width="500" height="150" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalService}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.showModalService}" var="ser">
            <f:facet name="header"><h:outputText value="AJOUT DE SERVICE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleService}" image="/images/close.gif" styleClass="hidelink" reRender="panelService"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid columns="2">
                    <h:outputText id="outcodlib" value="Code et libéllé des services" />
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.prodCodeLibService}">
                        <f:selectItem itemLabel="Sélectionner un service" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesServicesItems}"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="outcodlib,buttGrpProdSer,bbbbbSaveSer,outpAjtCodLib" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.decoupageCodLibService}"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <br/><br/>
                <center>
                    <h:panelGroup  id="buttGrpProdSer">
                        <a4j:commandButton image="/images/valider_big.png" id="bbbbbSaveSer" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.saveProduitsServices}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.testCodLibService}" reRender="panelService,tableauService,panelBoutonService"/>
                        <h:outputText  id="outpAjtCodLib" style="color:red;" value="Sélectionner un service qui n'est pas encore pris!" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.testCodLibService}"/>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panelListeProduits" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="850" height="450">
        <center>
            <f:facet name="header"><h:outputText value="Sélection du produit"/></f:facet>
            <a4j:form id="formModalListeProduits">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  width="100%">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="tableProd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.datamodelProduitsLieRecherche}"  var="prd">
                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.selectionProduitsLies}"/>
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
                    </a4j:region>
                </h:panelGrid>
                <br>
                <h:panelGroup id="valprod">
                    <center>
                        <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.annuleProduits}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formProduitsVtes.calculeProduits}"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>
