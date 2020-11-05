<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=UTF-8" errorPage="/WEB-INF/erreurSysteme.jsp" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>

<f:view>

    <html xmlns="https://www.w3.org/1999/xhtml" xmlns:h="https://java.sun.com/jsf/html" xmlns:f="https://java.sun.com/jsf/core" xml:lang="fr" dir="ltr">

        <%@ page import="java.util.*,
                 java.net.*,
                 java.io.*" %>
        <%
        String url = request.getParameter("url");
        if (url != null) {
          URL noCompress = new URL(url);
          HttpURLConnection huc = (HttpURLConnection)noCompress.openConnection();
          huc.setRequestProperty("user-agent","Mozilla(MSIE)");
          huc.connect();
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          InputStream is = huc.getInputStream();
          while(is.read() != -1) {
            baos.write((byte)is.read());
          }
          byte[] b1 = baos.toByteArray();
          URL compress = new URL(url);
          HttpURLConnection hucCompress = (HttpURLConnection)noCompress.openConnection();
          hucCompress.setRequestProperty("accept-encoding", "gzip");
          hucCompress.setRequestProperty("user-agent","Mozilla(MSIE)");
          hucCompress.connect();
          ByteArrayOutputStream baosCompress = new ByteArrayOutputStream();
          InputStream isCompress =  hucCompress.getInputStream();
          while(isCompress.read() != -1) {
            baosCompress.write((byte)isCompress.read());
          }
          byte[] b2 = baosCompress.toByteArray();
          request.setAttribute("t1", new Integer(b1.length));
          request.setAttribute("t2", new Integer(b2.length));
        }
        request.setAttribute("url", url);
        %>

        <head>
            <meta http-equiv="Pragma" content="cache">
            <meta http-equiv="Cache-Control" content="private">
            <meta http-equiv="Age" content="50">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
            <meta name="google-site-verification" content="v_qrqKZgHYxNQP10A1Vn1FRPR4mz7Yy5XdkDLCgGdSc" />
            <link href="favicon.ico" rel="icon" type="image/png"/>
            <title>HORUS l'Intégrale : ${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}</title>
            <link href="css/designvert.css" title="Alternatif 1" type="text/css" rel="stylesheet"/>
            <link href="css/designbleu.css" title="Alternatif 2" type="text/css" rel="alternate stylesheet"/>
            <link href="css/designorange.css" title="Alternatif 3" type="text/css" rel="alternate stylesheet"/>
            <link href="css/designnoir.css" title="Alternatif 4" type="text/css" rel="alternate stylesheet"/>
            <link href="css/declassic.css" title="Alternatif 5" type="text/css" rel="alternate stylesheet"/>
            <link href="css/designplanet.css" title="Alternatif 6" type="text/css" rel="alternate stylesheet"/>
            <link href="css/designgris.css" title="Alternatif 7" type="text/css" rel="alternate stylesheet"/>
            <script type="text/javascript" src="css/styleswitchercookie.js"></script>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMyLifeChat==true}">
                <script type="text/javascript" src="https://mylivechat.com/chatinline.aspx?hccid=19664719"></script>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                <!--script src='//vws.responsivevoice.com/v/e?key=ZiMeeCXc'></script-->
                <script type="text/javascript" src='https://code.responsivevoice.org/responsivevoice.js'></script>
            </c:if>
            <script type="text/javascript" src="css/webtwain/dynamsoft.webtwain.initiate.js"></script>
            <script type="text/javascript" src="css/webtwain/dynamsoft.webtwain.config.js"></script>
            <script type="text/javascript" language="Javascript">
                function codeTouche(evenement){
                    for (prop in evenement){
                        if(prop == 'which') return(evenement.which);
                    }
                    return(evenement.keyCode);
                }
                function scanToucheChiffre(evenement){
                    var reCarSpeciaux = /[\x00\x08\x2d\x2e]/;//autorise Home, End, supprime, tabulation et les flèches: code décimal 0, Retour arrière: code décimal 8, signe - : 2d le . 2E
                    var reCarValides = /\d/;// autorise les chiffres de 0 à 9
                    var codeDecimal  = codeTouche(evenement);
                    var car = String.fromCharCode(codeDecimal);
                    var autorisation = (reCarValides.test(car) || reCarSpeciaux.test(car));
                    return autorisation;
                }
                function scanToucheLettre(evenement){
                    var reCarSpeciaux = /[\x00\x08\x2b\x2d\x2e\x20\x21\x28\x29\x2c\x3a\x3b\x23\x24\x25\x26\x2c\x2f\x3f\x40\x60\xe0\xe1\xe2\xe3\xe4\xe5\xe6\xe7\xe8\xe9\xea\xeb\xec\xed\xee\xef\x2a\xb0\xd8\xb5\x2018]/;//aut‑autorise Home, End, supprime, tabulation et les flèches: code décimal 0, Retour arrière: code décimal 8, signe +=2B -=2d le .=2E le  =20 !=21 (=28 )=29 :=3A ;=3B #=23 $=24 %=25 &=26 ,=2c /=2f ?=3f @=40 =60 E0=à E1=á E2=â E3=ã E4=ä E5=å E6=æ E7=ç E8=è E9=é EA=ê EB=ë EC=ì ED=í EE=î EF=ï *=2a °=B0 Ø=D8 µ=b5 ‘=2018
                    var reCarValides = /\w/;// autorise les caracteres alpha numeriques
                    var codeDecimal  = codeTouche(evenement);
                    var car = String.fromCharCode(codeDecimal);
                    var autorisation = (reCarValides.test(car) || reCarSpeciaux.test(car));
                    return autorisation;
                }
                function MyLiveChat_OnInit() {
                    MyLiveChat_SetUserName('${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme}');
                    MyLiveChat_SetProductName("ePegase");
                    MyLiveChat_SetProductKey("19664719");
                    MyLiveChat_SetDepartment("Assistance");
                    MyLiveChat_SetContextData("Exploitation");
                    MyLiveChat_SetEmail('${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMail}');
                }
                function changeHashOnLoad() {
                    window.location.href += "#";
                    setTimeout("changeHashAgain()", "50");
                }
                function changeHashAgain() {
                    window.location.href += "1";
                }
                function UR_Start(){
                    UR_Nu = new Date;
                    UR_Indhold = showFilled(UR_Nu.getHours()) + ":" + showFilled(UR_Nu.getMinutes()) + ":" + showFilled(UR_Nu.getSeconds());
                    document.getElementById("ur").innerHTML = UR_Indhold;
                    setTimeout("UR_Start()",1000);
                }
                function showFilled(Value){
                    return (Value > 9) ? "" + Value : "0" + Value;
                }
                var storedHash = window.location.hash;
                window.setInterval(function () {
                    if (window.location.hash != storedHash) {
                        window.location.hash = storedHash;
                    }
                }, 50);
                function messageVocal(){
                    setTimeout(responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.message_vocal}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                }
            </script>
        </head>

        <body onload="changeHashOnLoad();MyLiveChat_OnInit();UR_Start();messageVocal();">
            <!-- Piwik -->
            <script type="text/javascript">
                var _paq = _paq || [];
                /* tracker methods like "setCustomDimension" should be called before "trackPageView" */
                _paq.push(['trackPageView']);
                _paq.push(['enableLinkTracking']);
                (function() {
                    var u="//horus-solutions.synology.me/piwik/";
                    _paq.push(['setTrackerUrl', u+'piwik.php']);
                    _paq.push(['setSiteId', '1']);
                    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
                    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
                })();
            </script>
            <!-- End Piwik Code -->
            <!-- Clear session -->
            <script type="text/javascript">
                window.onload = function () { Clear(); }
                function Clear() {
                    var historyLength=history.length;
                    if (historyLength > 0) history.go(-historyLength);
                }
            </script>
            <!-- End Clear Session -->
            <compress:html enabled="true" removeComments="true" removeMultiSpaces="true" compressJavaScript="true" compressCss="true" jsCompressor="true" removeFormAttributes="true" removeIntertagSpaces="true" removeLinkAttributes="true" removeJavaScriptProtocol="true" preserveLineBreaks="true" removeQuotes="true" removeInputAttributes="true" removeScriptAttributes="true" removeStyleAttributes="true" simpleBooleanAttributes="true" simpleDoctype="true" closureOptLevel="true" removeHttpProtocol="true" removeHttpsProtocol="true">
                <h:panelGrid id="pboard" width="100%" style="margin-top:-10px">
                    <h:panelGrid id="pboardf" width="100%" styleClass="cols">
                        <h:panelGrid id="pheader" border="0" columnClasses="clos25g,clos50,clos25" width="100%" columns="3" styleClass="Topbarre" style="color:#bc0000-weight: bold">
                            <h:panelGroup styleClass="cols">
                                <h:outputText value="HORUS l'Intégrale" style="font-size:14px" /><br>
                                <h:outputText styleClass="identite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_lib_base} (Smart.)"/>
                            </h:panelGroup>
                            <h:panelGroup styleClass="cols">
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_nom_master} #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" style="font-size:20px" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.affiche_nom}"/>
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_nom_master} #{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strdescriptif}" style="font-size:20px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.affiche_nom}"/>
                                <h:column>
                                    <center>
                                        <h:outputText styleClass="identite" style="font-size:10px;" value="Utilisateur   : #{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPrenom} #{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrNom} (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCollaboration})"/>
                                        <h:outputText styleClass="identite" value=" - dernière connexion:"/>&nbsp;
                                        <h:outputText styleClass="identite" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrFirstLog}">
                                            <f:convertDateTime pattern="dd/MM/yyyy:HH.mm.ss" locale="fr"/>
                                        </h:outputText>
                                    </center>
                                </h:column>
                            </h:panelGroup>
                            <h:panelGroup styleClass="cols">
                                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.detadujour}" style="font-size:14px" ><f:convertDateTime dateStyle="full" locale="fr"/></h:outputText><br>
                                <font id="ur" size="2" face="Verdana, Arial, sans-serif" color="#000000" style="font-weight:bold"></font>
                            </h:panelGroup>
                        </h:panelGrid>
                        <h:panelGrid id="pbouton" border="0" width="100%" columnClasses="cols,cols" styleClass="ConteneurUser" columns="2">
                            <h:panelGrid columns="3" border="0" columnClasses="clos,clos,clos" styleClass="menuHaut" style="height:30px;text-align:left;">
                                <a4j:form rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.startupSpecial}">
                                    <a4j:commandButton image="/images/precedent.png" style="width:20px;height:20px;" title="Fermer le menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.fermePanelGauche}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.controlePanLeft}" reRender="pboard"/>
                                    <a4j:commandButton image="/images/suivant.png" style="width:20px;height:20px;" title="Ouvrir le menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.ouvrePanelGauche}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.controlePanLeft}" reRender="pboard"/>
                                </a4j:form>
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strGoogleTraduction==0}">
                                        <div id="google_translate_element"></div><script type="text/javascript">
                                            function googleTranslateElementInit() {
                                                new google.translate.TranslateElement({pageLanguage: 'fr', layout: google.translate.TranslateElement.InlineLayout.SIMPLE, autoDisplay: false}, 'google_translate_element');
                                            }
                                        </script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
                                    </c:if>
                                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0}">
                                        <script type="text/javascript" language="Javascript">
                                            setTimeout(responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.message_vocal}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                                        </script>
                                    </c:if>
                                </c:if>
                                <a4j:status id="planCopmtStatus">
                                    <f:facet name="start">
                                        <h:graphicImage style="width:20px;height:20px;" id="imgstatus" value="/images/attente.gif"/>
                                    </f:facet>
                                </a4j:status>
                            </h:panelGrid>
                            <!-- Gestion de menu haut-->
                            <a4j:form styleClass="menuHaut" id="idVal1">
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrBaseCopie==1}">
                                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.basesCopies}" style="color:red" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseVerrou}">
                                        <f:selectItem itemLabel="Base Principale" itemValue="structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}"/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.lesBasesCopies}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.calculNomBaseCopie}"/>
                                    </h:selectOneMenu>&nbsp;&nbsp;
                                </h:column>
                                <h:commandButton title="Désactiver le Chat HORUS Solutions on-line" image="/images/liveChatActif.png" style="width:100px;height:20px;vertical-align:bottom;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMyLifeChat==true}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.desactiverLifeChat}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <h:commandButton title="Activer le Chat HORUS Solutions on-line" image="/images/liveChatInactif.png" style="width:100px;height:20px;vertical-align:bottom;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrMyLifeChat==false}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.activerLifeChat}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}"><a href="https://horus-solutions.synology.me/osticket/" class="linkhaut" style="margin-right:15px;" target="_blank"><img class="linkhaut" src="/epegase/images/helpdesk.png" height="20px" width="70px" alt="Help-desk HORUS Solutions on-line"> </a></h:column>
                                <h:commandButton styleClass="linkhaut" value="Système  " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid==1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme==3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.systeme}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <a4j:commandButton styleClass="linkhaut" value="CHOISIR UNE SOCIETE...  " action="#{bakingbeanepegase.menuModuleHorizontalCtrl.choixSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_affiche_liste_societe}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelSelectionSociete,pboardf,pboardb"/>
                                <h:commandButton styleClass="linkhaut" value="Espace client  " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPwEspaceClient!=''&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPwEspaceClient!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.espaceClient}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <h:commandButton styleClass="linkhaut" value="Mon compte  " action="#{bakingbeanepegase.menuModuleHorizontalCtrl.compte}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=9&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme!=4}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                <a4j:commandButton styleClass="linkhaut" value="Administration  " rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=3}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.administration}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pGMenu,refreshme"/>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}"><a href="http://www.google.com" class="linkhaut" style="margin-right:15px;" target="_blank">Web    </a></h:column>
                                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&false}"><a href="http://www.e-pegase.info" class="linkhaut" target="_blank"> Aide    </a></h:column>
                                <a4j:commandButton styleClass="linkhaut" value="Deconnexion" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.exit}" reRender="idPpda"/>
                            </a4j:form>
                        </h:panelGrid>
                    </h:panelGrid>
                    <h:panelGrid id="pboardb" width="100%" columnClasses="colsRR,colsVide" columns="2">
                        <!-- Gestion de menu gauche-->
                        <h:panelGrid id="pGMenu" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.controlePanLeft}">
                            <a4j:form id="idVal2">
                                <jsp:include flush="true" page="menuGauche.jsp"/>
                            </a4j:form>
                        </h:panelGrid>
                        <!-- Gestion de la subview -->
                        <h:panelGrid id="refreshme" width="100%" style="margin-top:-5px;">
                            <!-- menu horizontal -->
                            <h:panelGrid id="menuVert" width="100%" columnClasses="cols" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModuleGuest==0&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche!='systeme'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche!='admin'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche!='coadmin'&&bakingbeanepegase.menuModuleHorizontalCtrl.controlePanLeft)==true}">
                                <a4j:form id="boardPrincipal">
                                    <rich:dataDefinitionList id="menuHorizontal" style="margin-top:-20px;" rowClasses="coloHorizontal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.dataModelMenuHorizontal}" var="menuHorizontal">
                                        <a4j:commandButton title="#{menuHorizontal.alert}" styleClass="exp_lienmenu" value="#{menuHorizontal.libelle}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.controleMenuHorizontal}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pGMenu,idSubView,idVal1" rendered="#{menuHorizontal.affiche==true}"/>
                                    </rich:dataDefinitionList>
                                </a4j:form>
                            </h:panelGrid>
                            <!-- Gestion de la subview -->
                            <h:panelGroup id="idSubView">
                                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl!=null}" var="menu">
                                    <jsp:include flush="true" page="gestionSubView.jsp"/>
                                </c:if>
                            </h:panelGroup>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </compress:html>
        </body>

    </html>

    <rich:modalPanel headerClass="headerPanel" id="modAttente" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="350" height="80" resizeable="false">
        <f:facet name="header"><h:outputText value="Traitement en cours, veuillez patienter...Please wait..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage value="/images/ajax-loader(3).gif"/></a4j:outputPanel>
                <br>
            </a4j:form>
        </center>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelBarUtil" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.var_showBarProg}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration!=null}" var="msgUtil">
            <f:facet name="header"><h:outputText value="Traitement en cours (Utilitaires)..."/></f:facet>
            <center>
                <a4j:form>
                    <br>
                    <a4j:outputPanel id="progressPanelUtil">
                        <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" progressVar="progress" reRenderAfterComplete="panelBarUtil,progressPanelUtil">
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.var_info}" id="text"/>
                        </rich:progressBar>
                    </a4j:outputPanel>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="modMessage" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.message_affiche}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.message_affiche}" var="msg">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanMessage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.fermerMessage}" styleClass="hidelink" reRender="modMessage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessage')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form >
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.message_texte}" style="width:100%" readonly="true"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                        <script type="text/javascript" language="Javascript">
                            setTimeout(responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.message_texte}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                        </script>
                        <img src="images/hp.png" alt="Message_parlant" height="30" width="30" onclick='responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.messageTexte}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}");' style="vertical-align: middle"/>
                    </c:if>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="modMessageCommun" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelMessage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.showModalPanelMessage}" var="msgCmm">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton id="idCanMessageCommun" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.fermerMessage}" styleClass="hidelink" reRender="modMessageCommun"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessageCommun')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form id="idFormMessageCommun">
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.messageTexte}" style="width:100%" readonly="true"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                        <script type="text/javascript" language="Javascript">
                            setTimeout(responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.messageTexte}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                        </script>
                        <img src="images/hp.png" alt="Message_parlant" height="30" width="30" onclick='responsiveVoice.speak("${bakingbeanepegase.menuModuleHorizontalCtrl.formRecherche.messageTexte}", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}");' style="vertical-align: middle"/>
                    </c:if>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="idPpda" style="border:solid 10px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.showMoalPanelExit}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.showMoalPanelExit}" var="out">
            <a4j:form >
                <h:panelGrid width="100%" columns="2">
                    <h:column>
                        <center>
                            <a4j:outputPanel><h:graphicImage value="/images/ppda.jpg"/></a4j:outputPanel>
                            <h:inputTextarea rows="3" value="Vous pouvez quitter HORUS l'Intégrale et reprendre une activité normale...(P.P.D.A.)." style="width:100%;text-align:center;" readonly="true"/>
                            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                                <script type="text/javascript" language="Javascript">
                                    setTimeout(responsiveVoice.speak("Vous pouvez quitter HORUS l'Intégrale et reprendre une activité normale.", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                                </script>
                                <img src="images/hp.png" alt="Message_parlant" height="30" width="30" onclick='responsiveVoice.speak("Vous pouvez quitter HORUS l`Intégrale et reprendre une activité normale.", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}");' style="vertical-align: middle"/>
                            </c:if>
                        </center>
                    </h:column>
                    <h:column>
                        <center>
                            <a4j:commandButton styleClass="linkhaut" value="Rester dans HORUS l'Intégrale" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.annulerExit}" reRender="idPpda"/>
                            <br><br><br><br><br>
                            <h:commandButton styleClass="linkhaut" value="Deconnexion" action="#{bakingbeanepegase.deconnection}"/>
                        </center>
                    </h:column>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel headerClass="headerPanel" id="panelSelectionSociete" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1000" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.showModalPanelSelectionSociete}" resizeable="false">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.showModalPanelSelectionSociete}" var="selSociete">
            <center>
                <f:facet name="header"><h:outputText value="Sélection de la société"/></f:facet>
                <a4j:form id="formModalListeSociete">
                    <rich:extendedDataTable id="tableSoc" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="330px" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.dataModelSociete}" var="soc" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.simpleSelectionEntete}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.selectionSociete}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,valsociete"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.validationSociete}" reRender="pboardf,pboardb,panelSelectionSociete"/>
                        <rich:column label="ID" sortable="true" sortBy="#{soc.strId}" width="15%">
                            <f:facet name="header"><h:outputText value="ID"/></f:facet>
                            <h:outputText value="#{soc.strId}" style="#{soc.styleColor}"/>
                        </rich:column>
                        <rich:column label="Raison sociale ou Nom" sortable="true" sortBy="#{soc.strraisonsociale}" width="55%" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Raison sociale"/></f:facet>
                            <h:outputText value="#{soc.strraisonsociale}" rendered="#{soc.strmod10==null}" style="#{soc.styleColor}"/>
                            <h:outputText value="#{soc.strmod10}" rendered="#{soc.strmod10!=null}" style="#{soc.styleColor}"/>
                        </rich:column>
                        <rich:column label="Pays" sortable="true" sortBy="#{soc.strnompays}" width="10%">
                            <f:facet name="header"><h:outputText value="Pays"/></f:facet>
                            <h:outputText value="#{soc.strnompays}" style="#{soc.styleColor}"/>
                        </rich:column>
                        <rich:column label="Date début Mandat" sortable="true" sortBy="#{soc.strdtedebmandat}" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}">
                            <f:facet name="header"><h:outputText value="Mandat du"/></f:facet>
                            <h:outputText value="#{soc.strdtedebmandat}" style="#{soc.styleColor}"/>
                        </rich:column>
                        <rich:column label="Date fin Mandat" sortable="true" sortBy="#{soc.strdtefinmandat}" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==1}">
                            <f:facet name="header"><h:outputText value="au"/></f:facet>
                            <h:outputText value="#{soc.strdtefinmandat}" style="#{soc.styleColor}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                    <br>
                    <center>
                        <h:panelGroup id="valsociete"style="height:34px">
                            <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.femerSociete}"/>&nbsp;&nbsp;&nbsp;
                            <h:commandButton title="Aller dans la société sléectionnée" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.validationSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.strSelec}"/>&nbsp;&nbsp;&nbsp;
                            <h:commandButton title="Revenir à : #{bakingbeanepegase.menuModuleHorizontalCtrl.var_nom_master}" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.masterSociete}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.var_id_master!=0}"/>
                        </h:panelGroup>
                    </center>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>

    <!--rich:modalPanel headerClass="headerPanel" id="sessionExpiredPanel" style="border:solid 0px black;background-color:white;" width="500" height="300"-->
    <!--jsp:include flush="true" page="WEB-INF/erreurExpiration.jsp"/-->
    <!--/rich:modalPanel-->

</f:view>
