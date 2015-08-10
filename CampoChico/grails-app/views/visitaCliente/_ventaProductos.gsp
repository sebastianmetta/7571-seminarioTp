<script type="text/javascript">
    var childCount = ${visitaClienteInstance?.productosVendidos.size()} + 0;
    
    function addVentaProducto(){
      var clone = $("#ventaProducto_clone").clone()
      var htmlId = 'ventaProductosList['+childCount+'].';
      var ventaProductoInput = clone.find("input[id$=number]");

      clone.find("input[id$=id]").attr('id',htmlId + 'id').attr('name',htmlId + 'id');
      clone.find("input[id$=deleted]").attr('id',htmlId + 'deleted').attr('name',htmlId + 'deleted');
      clone.find("input[id$=new]").attr('id',htmlId + 'new').attr('name',htmlId + 'new').attr('value', 'true');

      clone.find("select[id$='producto']").attr('id',htmlId + 'producto').attr('name',htmlId + 'producto');
      clone.find("input[id$='cantidad']").attr('id',htmlId + 'cantidad').attr('name',htmlId + 'cantidad');
      clone.find("input[id$='precioVentaUnitario']").attr('id',htmlId + 'precioVentaUnitario').attr('name',htmlId + 'precioVentaUnitario');

      clone.find('[id^="delete-icon"]').on('click', function(){
          //find the parent div
          var prnt = $(this).parents(".ventaProducto-div");
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
      
      clone.attr('id', 'ventaProducto'+childCount);
      $("#childList").append(clone);
      clone.show();
      ventaProductoInput.focus();
      childCount++;
    }
</script>

<script type="text/javascript">
   $(document).ready(function() {
      $('[id^="delete-icon"]').on('click', function(){
          //find the parent div
          var prnt = $(this).parents(".ventaProducto-div");
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
	<g:each var="ventaProducto" in="${visitaClienteInstance.productosVendidos}" status="i">

		<!-- Render the ventaProducto template (_ventaProducto.gsp) here -->
		<g:render template='ventaProducto' model="['ventaProducto':ventaProducto,'i':i,'hidden':false]" />
		<!-- Render the ventaProducto template (_ventaProducto.gsp) here -->

	</g:each>
</div>

<fieldset class="buttons col-lg-1" >
	<input type="button" class="btn btn-success" value="Agregar venta" onclick="addVentaProducto();" />
</fieldset>


