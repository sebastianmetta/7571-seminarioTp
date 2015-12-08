package ar.com.campochico

class AvisoNoVisitaController {

    def index() { 
		[defaultBody: message(code: 'advice.mail.body.noVisit.default')]	
	}
	
    //TODO: Revisar GSP para que muestre correctamente el resultado del envío.
	def sendNoVisitAdvice() {
		ZonaVenta zonaVenta = ZonaVenta.findById(params.zonaVentaId)
		String mensajeError = ""
		if (zonaVenta!=null) {	
			try {
				zonaVenta.enviarAvisoNoVisitaClientes(params.bodyUserInput)
			} catch (Exception e) {
				mensajeError = "Lo sentimos, el aviso no pudo ser enviado debido al siguiente error: " + e.getMessage()
			}		
		} else {
			mensajeError = "Error: zona inexistente."
		}
		redirect(action: "index", params: [mensajeError: mensajeError])
	}

}
