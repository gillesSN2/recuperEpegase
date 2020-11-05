<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<f:subview id="erreurIdentification" >

    <center> <h2 style="color:green;font-size:18px;">Erreur d'identification ou de connexion</h2></center>

    <h:panelGrid width="100%" border="0">

        <h:panelGrid id="p1" width="100%" >

            <center>
                <br/><br/>
                <br/><br/><br/><br/>
                <c:if test="${bakingbeanepegase.reponseFinale=='home'||bakingbeanepegase.reponseFinale==''}" var="cas1">
                    Vous avez une erreur d'identification. Vérifiez la saisie des 3 informations: Société, Login et Mot de passe...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='non actif'}" var="cas2">
                    Le login et le mot de passe correspondent à un utilisateur désactivé. Veuillez saisir un autre login et un autre mot de passe...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='société bloquée'}" var="cas3">
                    La société que vous avez saisie est une société bloquée par HORUS SOLUTIONS. Veuillez contacter l'administration d'HORUS SOLUTIONS pour de plus amples explications...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='société cloturée'}" var="cas4">
                    La société que vous avez saisie est une société cloturée par HORUS SOLUTIONS. Veuillez contacter l'administration d'HORUS SOLUTIONS pour de plus amples explications...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='bloqué sur erreur mot de passe'}" var="cas5">
                    Le login et le mot de passe correspondent à un utilisateur qui a été bloqué à cause de 3 erreurs de connexions successifs. Veuillez contacter votre administrateur pour de plus amples informations...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='bloqué sur erreur code secret'}" var="cas6">
                    Le login et le mot de passe correspondent à un utilisateur qui a été bloqué à cause de 3 erreurs de connexions successifs. Veuillez contacter votre administrateur pour de plus amples informations...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='réactivé par admistrateur, mais doit changer de mot de passe'}" var="cas7">
                    Le login et le mot de passe correspondent à un utilisateur qui a été réactivé par l'administrateur. Veuillez changer votre mot de passe à votre première connexion...
                </c:if>
                <c:if test="${bakingbeanepegase.reponseFinale=='suspension pour non paiement'}" var="cas8">
                    L'accès à ePegase est suspendu pour cause de non paiement des factures dues. Envoyez nous le bordereau de paiement pour réactiver l'accès...
                </c:if>
                <br/><br/><br/><br/>
                Reconnectez vous sur votre plate forme de travail : <a href="index.faces" style="text-decoration:none;font-family:sans-serif;color:green;font-weight:bold;">e-Pégase</a>
            </center>

        </h:panelGrid>

    </h:panelGrid>

</f:subview>