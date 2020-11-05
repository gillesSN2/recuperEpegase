<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye!=null&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage!=null}" var="poipay">

    <c:choose>

        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.pointage=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action<=8}" >
            <jsp:include flush="true" page="/paye/PointageFiche0.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='0'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.pointage=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action<=8}" >
            <jsp:include flush="true" page="/paye/PointageFiche1.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action<=8}" >
            <jsp:include flush="true" page="/paye/PointageFiche2.jsp" />
        </c:when>
        <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.var_action==9}" >
            <jsp:include flush="true" page="/commun/listeTiers.jsp" />
        </c:when>

        <c:otherwise>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='0'}" var="mSal">
                <jsp:include flush="true" page="/paye/PointageListSalarie.jsp" />
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPointage.optionPaye.temps=='1'}" var="mCab">
                <jsp:include flush="true" page="/paye/PointageListCabinet.jsp" />
            </c:if>
        </c:otherwise>

    </c:choose>

</c:if>
