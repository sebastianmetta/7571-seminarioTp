<script type="text/javascript">
    var childCount = ${operatoriaDiariaInstance?.productosOtorgados.size()} + 0;
    
    function addProductoOtorgado(){
      var clone = $("#productoOtorgado_clone").clone()
      var htmlId = 'productoOtorgadosList['+childCount+'].';
      var productoOtorgadoInput = clone.find("input[id$=number]");

      clone.find("input[id$=id]").attr('id',htmlId + 'id').attr('name',htmlId + 'id');
      clone.find("input[id$=deleted]").attr('id',htmlId + 'deleted').attr('name',htmlId + 'deleted');
      clone.find("input[id$=new]").attr('id',htmlId + 'new').attr('name',htmlId + 'new').attr('value', 'true');

      clone.find("select[id$='producto']").attr('id',htmlId + 'producto').attr('name',htmlId + 'producto');
      clone.find("input[id$='cantidad']").attr('id',htmlId + 'cantidad').attr('name',htmlId + 'cantidad');
      
      clone.find('[id^="delete-icon"]').on('click', function(){
          //find the parent div
          var prnt = $(this).parents(".productoOtorgado-div");
          //find the deleted hidden input
          var delInput = prnt.find("input[id$=deleted]");
          //check if this is still not persisted
          var newValue = prnt.find("input[id$=new]").attr('value');
          //if it is new then i can safely remove from dom
          if(newValue == 'true'){
              prnt.remove();
          }else{
              //set the deletedFlag to true
              delInput.attr('value','true');
              //hide the div
              prnt.hide();
          }
      });
      
      clone.attr('id', 'productoOtorgado'+childCount);
      $("#childList").append(clone);
      clone.show();
      productoOtorgadoInput.focus();
      childCount++;
    }
</script>

<script type="text/javascript">
   $(document).ready(function() {
      $('[id^="delete-icon"]').on('click', function(){
          //find the parent div
          var prnt = $(this).parents(".productoOtorgado-div");
          //find the deleted hidden input
          var delInput = prnt.find("input[id$=deleted]");
          //check if this is still not persisted
          var newValue = prnt.find("input[id$=new]").attr('value');
          //if it is new then i can safely remove from dom
          if(newValue == 'true'){
              prnt.remove();
          }else{
              //set the deletedFlag to true
              delInput.attr('value','true');
              //hide the div
              prnt.hide();
          }
      });
   });
</script>

<div id="childList">
	<g:each var="productoOtorgado" in="${operatoriaDiariaInstance.productosOtorgados}" status="i">
		<!-- Render the productoOtorgado template (_productoOtorgado.gsp) here -->
		<g:render template='productoOtorgado' model="['productoOtorgado':productoOtorgado,'i':i,'hidden':false]" />
	</g:each>
</div>

<fieldset class="buttons col-lg-1" >
	<input type="button" class="btn btn-success" value="Agregar producto" onclick="addProductoOtorgado();" />
</fieldset>


