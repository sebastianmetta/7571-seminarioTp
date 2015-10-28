class UrlMappings {

	static mappings = {
		"/user"(controller: "user", action: "index")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/index")
        "500"(view:'/error')
		"403"(view: '/forbidden403')
	}
}
