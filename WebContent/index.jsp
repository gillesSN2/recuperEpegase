<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/erreurSysteme.jsp"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<f:view>

    <html xmlns="https://www.w3.org/1999/xhtml" xmlns:h="https://java.sun.com/jsf/html" xmlns:f="https://java.sun.com/jsf/core" xml:lang="fr" dir="ltr">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
            <meta name="google-site-verification" content="v_qrqKZgHYxNQP10A1Vn1FRPR4mz7Yy5XdkDLCgGdSc" />
            <link rel="icon" type="image/png" href="favicon.ico" />
            <link href="css/designvert.css" title="Alternatif 1" type="text/css" rel="stylesheet"/>
            <title>HORUS l'Intégrale : Portail universel de gestion d'entreprise</title>

            <script type="text/javascript" language=javascript>
                function myUrl(){
                    var urlDoc = document.location.href;
                    var doc = urlDoc.split("epegase");
                    var valUrl = doc[0];
                    document.getElementById("idValeur:idValUrl").value = valUrl;
                }
                function verifFileApi(){
                    // Check for the various File API support.
                    if (window.File && window.FileReader && window.FileList && window.Blob) {
                        //alert( 'Great success! All the File APIs are supported.');
                    } else {
                        alert('The File APIs are not fully supported in this browser.');
                    }
                }
                function myPlateForme(){
                    var plateforme = 0;// bureau
                    if (navigator.userAgent.match(/(android|iphone|ipad|blackberry|symbian|symbianos|symbos|netfront|model-orange|javaplatform|iemobile|windows phone|samsung|htc|opera mobile|opera mobi|opera mini|presto|huawei|blazer|bolt|doris|fennec|gobrowser|iris|maemo browser|mib|cldc|minimo|semc-browser|skyfire|teashark|teleca|uzard|uzardweb|meego|nokia|bb10|playbook)/gi)) {
                        if ( ((screen.width  >= 480) && (screen.height >= 800)) || ((screen.width  >= 800) && (screen.height >= 480)) || navigator.userAgent.match(/ipad/gi) ) {
                            plateforme = 1;// tablette
                        } else {
                            plateforme = 2;// mobile
                        }
                    }
                    document.getElementById("idValeur:idValPlateForme").value = plateforme;
                }
            </script>

        </head>

        <body onload="myUrl();verifFileApi();myPlateForme()" class="bottomAccueil">

            <%
              try{
              }
              catch (Exception e){
                out.println("An exception occurred: " + e.getMessage());
              }
            %>

            <!-- Matomo -->
            <script type="text/javascript">
                var _paq = window._paq || [];
                /* tracker methods like "setCustomDimension" should be called before "trackPageView" */
                _paq.push(['trackPageView']);
                _paq.push(['enableLinkTracking']);
                (function() {
                    var u="https://epegase.matomo.cloud/";
                    _paq.push(['setTrackerUrl', u+'matomo.php']);
                    _paq.push(['setSiteId', '1']);
                    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
                    g.type='text/javascript'; g.async=true; g.defer=true; g.src='//cdn.matomo.cloud/epegase.matomo.cloud/matomo.js'; s.parentNode.insertBefore(g,s);
                })();
            </script>
            <!-- End Matomo Code -->

            <h:form id="idValeur" style="margin-top:50px;">
                <h:inputHidden id="idValUrl" value="#{bakingbeanepegase.urlDocument}"/>
                <h:inputHidden id="idValPlateForme" value="#{bakingbeanepegase.typePlateforme}"/>

                <center>

                    <jsp:include flush="true" page="informations.jsp"/>

                    <rich:tabPanel rendered="true" switchType="server" immediate="true" id="panelGlobal1" style="margin-top:40px;font-family:Arial;font-size:12px;background-color:#9DDE8F;font-weigh:bold;border:0px;color:black;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800px" styleClass="panneau_accueil" >

                        <rich:tab id="tabDoc1" label="Déjà inscrit" >
                            <jsp:include flush="true" page="index_connexion.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc2" label="Présentation de l'Integrale" action="#{bakingbeanepegase.screenshot}">
                            <jsp:include flush="true" page="/inscription/readme_2.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc3" label="Demande d'informations"  action="#{bakingbeanepegase.nouvelleProspection}">
                            <jsp:include flush="true" page="/inscription/readme_3.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc4" label="Les Versions" >
                            <jsp:include flush="true" page="/inscription/readme_4.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc6" label="Le Groupe HORUS Solutions" >
                            <jsp:include flush="true" page="/inscription/readme_6.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc5" label="Ils nous ont fait confiance" >
                            <jsp:include flush="true" page="/inscription/readme_5.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc7" label="Nos partenaires" >
                            <jsp:include flush="true" page="/inscription/readme_7.jsp"/>
                        </rich:tab>

                        <rich:tab id="tabDoc8" label="Nos produits" rendered="false">
                            <jsp:include flush="true" page="/inscription/readme_8.jsp"/>
                        </rich:tab>

                    </rich:tabPanel>

                </center>

                <h:panelGroup>
                    <center>
                        <h:panelGrid style="text-align:center" width="60%">
                            <p align="center" style="font-family:Arial; font-size:11px;color:white;">
                                <em> (Horus l'Intégrale a été optimisé pour le navigateur FireFox et Chrome avec un écran de 1600 * 900 px et un accès internet avec un débit de 1Mo minimum)</em>
                            </p>
                        </h:panelGrid>
                    </center>
                </h:panelGroup>

                <h:panelGroup rendered="#{bakingbeanepegase.var_aff_inscription&&false}">
                    <!--center-->
                    <!--h:outputLink style="text-decoration:none;color:green;font-weight:bold;font-size:20px;text-align:center" value="inscription/formulaire.faces"-->
                    <!--h:outputText value="Inscrivez-vous maintenant !" /-->
                    <!--/h:outputLink-->
                    <!--/center-->
                </h:panelGroup>

            </h:form>

            <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="idAutoReponse" style="border:solid 0px black;background-color:white"  width="500" height="300" resizeable="false" showWhenRendered="#{bakingbeanepegase.autoReponse}">
                <c:if test="${bakingbeanepegase.autoReponse}" var="selReponse">
                    <f:facet name="header"><h:outputText value="Réponse automatique"/></f:facet>
                    <f:facet name="controls">
                        <a4j:form >
                            <a4j:commandButton action="#{bakingbeanepegase.fermerAutoReponse}" image="/images/close.gif" styleClass="hidelink" reRender="idAutoReponse"/>
                        </a4j:form>
                    </f:facet>
                    <center>
                        <a4j:form >
                            <br>
                            <a4j:outputPanel><h:graphicImage value="/images/message.png" height="150px" width="150px"/></a4j:outputPanel>
                            <a4j:outputPanel><h:outputText value="Votre demande a bien été enregistrée."/></a4j:outputPanel>
                            <br>
                        </a4j:form>
                    </center>
                </c:if>
            </rich:modalPanel>

        </body>
    </html>

</f:view>