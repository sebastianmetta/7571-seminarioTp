package ar.com.campochico

class AvisoDeudaController {

    def index() { 
		def clienteId = params.clienteId
		[defaultBody: message(code: 'advice.mail.body.debt.default'), clienteIdToSelect: clienteId]	
	}
	
    //TODO: Revisar GSP para que muestre correctamente el resultado del envío.
	def sendDebtAdvice() {
		Cliente cliente = Cliente.findById(params.clienteId)
		String mensajeError = ""
		if (cliente!=null) {	
			try {
				cliente.enviarRecordatorioDeuda(params.bodyUserInput)
			} catch (Exception e) {
				mensajeError = "Lo sentimos, el aviso no pudo ser enviado debido al siguiente error: " + e.getMessage()
			}		
		} else {
			mensajeError = "Error: cliente inexistente."
		}
		def clienteId
		if (cliente!=null) {
			clienteId=cliente.id
		} else {
			clienteId = params.clienteId
		}
		
		redirect(action: "index", params: [mensajeError: mensajeError], clienteId: clienteId)
		
	}
}
