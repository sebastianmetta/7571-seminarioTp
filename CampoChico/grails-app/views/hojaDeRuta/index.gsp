<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Hoja de ruta</title>
<asset:stylesheet src="handsontable.full.css" />
</head>
<body>

<script type="text/javascript">
$(document).ready(function () {

	  var container = document.getElementById('hojaDeRutaTable');
	  var percentRenderer = function (instance, td, row, col, prop, value, cellProperties) {
	    Handsontable.renderers.NumericRenderer.apply(this, arguments);
	    td.style.color = (value < 0) ? 'red' : 'green';
	  };
	  
	  var advancedData = [
	    ["Afghanistan","30.552","1000s","2013","0.0244","27.708","24.019","11.215"],
	    ["Albania","2.774","1000s","2013","-0.0100","2.884","3.015","3.228"],
	    ["Algeria","39.208","1000s","2013","0.0189","36.383","33.461","25.577"],
	    ["Zimbabwe","14.15","1000s","2013","0.0310","12.889","12.693","10.167"]
	  ];

	  var hojaDeRutaData = ${raw(json)};
	  
	  var hot = new Handsontable(container, {
	    data: hojaDeRutaData,
	    height: 396,
	    colHeaders: true,
	    rowHeaders: true,
	    stretchH: 'all',
	    columnSorting: true,
	    contextMenu: true,
	    className: "htCenter htMiddle",
	  });
	  
	});
</script>

	<asset:javascript src="handsontable.full.js" />
	
	<div>Esta es la hoja de ruta.</div>
	<%--
	<g:each in="${todayZone}" var="p">
		<li>
			${p}
		</li>
	</g:each>
	--%>
	
	<div id="hojaDeRutaTable"></div>

</body>
</html>