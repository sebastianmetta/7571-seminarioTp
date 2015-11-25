package ar.com.campochico

class IndexController {
	
	def operatoriaDiariaService
	
	def index() { 
		[pendingLoadVendedores: operatoriaDiariaService.getTodayPendingLoad()]
	}
}
