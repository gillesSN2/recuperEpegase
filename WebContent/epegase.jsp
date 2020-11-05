<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${bakingbeanepegase!=null}" var="aiguillage">
    
    <c:if test="${bakingbeanepegase.connexion.userslog.usrid!=0&&bakingbeanepegase.typePlateforme=='0'}" var="aiguillage0">
        <jsp:include flush="true" page="/epegase0.jsp" />
    </c:if>

    <c:if test="${bakingbeanepegase.connexion.userslog.usrid!=0&&bakingbeanepegase.typePlateforme=='1'}" var="aiguillage1">
        <jsp:include flush="true" page="/epegase1.jsp" />
    </c:if>

    <c:if test="${bakingbeanepegase.connexion.userslog.usrid!=0&&bakingbeanepegase.typePlateforme=='2'}" var="aiguillage2">
        <jsp:include flush="true" page="/epegase2.jsp" />
    </c:if>

    <c:if test="${bakingbeanepegase.connexion.userslog.usrid==0}" var="aiguillage3">
        <jsp:include flush="true" page="/retour.jsp" />
    </c:if>

</c:if>

<c:if test="${bakingbeanepegase==null}" var="aiguillage4">
    <jsp:include flush="true" page="/retour.jsp" />
</c:if>
