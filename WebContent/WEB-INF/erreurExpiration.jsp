<!DOCTYPE html>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>epegase : La session a expiré</title>
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
            <script type="text/javascript" src='https://code.responsivevoice.org/responsivevoice.js'></script>
        </c:if>
    </head>

    <body>

        <center>
            <h1>Oups! Votre session a expiré! Veuillez vous reconnecter....</h1>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrAssistant!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}">
                <script type="text/javascript" language="Javascript">
                    setTimeout(responsiveVoice.speak("Votre session a expiré. Veuillez vous reconnecter en cliquant sur le bouton ci-après", "${bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.genreAssistant}"),20);
                </script>
            </c:if>
        </center>

        <br><br>

        <center>
            <br><br>
            Reconnectez vous sur votre plate forme de travail : <a href="../../epegase/" style="text-decoration:none;font-family:sans-serif;color:green;font-weight:bold;">Horus l'Intégrale</a>
        </center>

    </body>
</html>














