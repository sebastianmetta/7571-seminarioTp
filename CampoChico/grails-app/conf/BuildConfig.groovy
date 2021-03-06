grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.8
grails.project.source.level = 1.8
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    compile: [maxMemory: 256, minMemory: 64, debug: false, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, daemon:true],
    // configure settings for the run-app JVM
	//run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	run: [maxMemory: 2048, minMemory: 64, debug: false, forkReserve:false],
	// configure settings for the run-war JVM
    //war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
	war: [maxMemory: 2048, minMemory: 64, debug: false, forkReserve:false],
    // configure settings for the Console UI JVM
    //console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
	console: [maxMemory: 2048, minMemory: 64, debug: false]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
		
		mavenRepo "http://repo.grails.org/grails/core"
		
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.29'
        // runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
		
        test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
		compile 'joda-time:joda-time:2.8'
		compile 'org.apache.commons:commons-collections4:4.0'
		
		compile 'commons-beanutils:commons-beanutils:1.8.3'
		
    }

    plugins {
        build ":tomcat:7.0.55.2"

        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:2.1.5"
        compile ":export:1.6"
		
		compile ":calendar:1.2.1"
		
		compile ":shiro:1.2.1"
		
		compile ":mail:1.0.7"
		
        runtime ":hibernate4:4.3.8.1"
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
		
		compile ":create-domain-uml:0.5"
		
    }
}
