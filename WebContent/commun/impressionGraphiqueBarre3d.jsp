<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Grapheur HORUS L'INTEGRALE</title>

        <script type="text/javascript" src="../css/highCharts/js/jquery.min.js"></script>
        <style type="text/css">
            #container, #sliders {
                min-width: 310px;
                max-width: 800px;
                margin: 0 auto;
            }
            #container {
                height: 500px;
            }
        </style>
        <script type="text/javascript">
            $(function () {

                Highcharts.setOptions({
                    lang: {
                        decimalPoint: ',',
                        thousandsSep: ' '
                    },
                    global: {
                        useUTC: true
                    }
                });

                var listeDatas = document.getElementById('idListedatas').value;
                //alert('datas= ' + listeDatas);
                var timeDecoupage = document.getElementById('idTimeDecoupage').value;
                //alert('decoupage' + timeDecoupage);
                var decoupage = "1";
                if (timeDecoupage==0){
                    decoupage = ['01', '02', '03', '04', '05', '06','07', '08', '09', '10', '11', '12','13', '14', '15', '16', '17', '18','19', '20', '21', '22', '23', '24','25', '26', '27', '28', '29', '30','31']
                } else if (timeDecoupage==1){
                    decoupage = ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin','Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre']
                } else if (timeDecoupage==2){
                    decoupage = ['1er trimestre', '2eme trimestre', '3eme trimestre', '4eme trimestre']
                } else if (timeDecoupage==3){
                    decoupage = ['1er semestre', '2eme semestre']
                } else if (timeDecoupage==4){
                    decoupage = ['Annee']
                } else if (timeDecoupage==5){
                    decoupage = ['01', '02', '03', '04', '05', '06','07', '08', '09', '10', '11', '12','13', '14', '15', '16', '17', '18','19', '20', '21', '22', '23', '24']
                } else if (timeDecoupage==6){
                    decoupage = ['2009', '2010', '2011', '2012', '2013', '2014','2015', '2016', '2017', '2018', '2019', '2020']
                }
                var titre = document.getElementById('idTitre').value;
                var sousTitre = document.getElementById('idSousTitre').value;
                var unite = document.getElementById('idUnite').value;
                var devise = document.getElementById('idDevise').value;
                var nbDec = document.getElementById('idNbDec').value;
                var datas = eval('('+ listeDatas +')');
                //alert('datas ' + datas);

                // Create the chart
                var chart = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container',
                        type: 'column',
                        margin: 75,
                        options3d: {
                            enabled: true,
                            alpha: 15,
                            beta: 15,
                            depth: 50,
                            viewDistance: 25
                        },
                        height: '500'
                    },
                    title : {
                        text : titre,
                        x: -20 //center
                    },
                    subtitle : {
                        text : sousTitre,
                        x: -20 //center
                    },
                    exporting: {
                        enabled: true
                    },
                    xAxis: {
                        categories: decoupage
                    },
                    yAxis: {
                        title: {
                            text: unite
                        },
                        plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    },
                    tooltip : {
                        valueDecimals : nbDec,
                        valueSuffix: devise
                    },
                    plotOptions: {
                        column: {
                            depth: 25
                        }
                    },
                    series : datas
                });

                // Activate the sliders
                $('#R0').on('change', function(){
                    chart.options.chart.options3d.alpha = this.value;
                    showValues();
                    chart.redraw(false);
                });
                $('#R1').on('change', function(){
                    chart.options.chart.options3d.beta = this.value;
                    showValues();
                    chart.redraw(true);
                });

                function showValues() {
                    $('#R0-value').html(chart.options.chart.options3d.alpha);
                    $('#R1-value').html(chart.options.chart.options3d.beta);
                }
                showValues();

            });
        </script>
    </head>
    <body>
        <script type="text/javascript" src="../css/highCharts/js/highcharts.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/highcharts-3d.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/modules/exporting.js"></script>

        <input id='idTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteTitre}"/>
        <input id='idSousTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteSousTitre}"/>
        <input id='idUnite' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.unite}"/>
        <input id='idDevise' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.devise}"/>
        <input id='idNbDec' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.nbDec}"/>
        <input id='idTimeDecoupage' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.timeDecoupage}"/>
        <input id='idListedatas' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.listeDatas}"/>

        <div id="container"></div>
        <div id="sliders">
            <table>
                <tr><td>Angle horizontal </td><td><input id="R0" type="range" min="0" max="45" value="15"/> <span id="R0-value" class="value"></span></td></tr>
                <tr><td>Angle vertical</td><td><input id="R1" type="range" min="0" max="45" value="15"/> <span id="R1-value" class="value"></span></td></tr>
            </table>
        </div>

    </body>
</html>