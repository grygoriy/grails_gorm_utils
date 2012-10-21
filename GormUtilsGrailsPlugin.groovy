class GormUtilsGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Gorm Utils Plugin" // Headline display name of the plugin
    def author = "Grygoriy Mykhalyuno"
    def authorEmail = "email@grygoriy.com"
    def description = '''\
Plugin collects methods and technics for work with GORM
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/gorm-utils"
    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/grygoriy/grails_gorm_utils" ]

    def scm = [ url: "https://github.com/grygoriy/grails_gorm_utils" ]

    def doWithDynamicMethods = { ctx ->
        ctx.domainClasses.each {def domain ->
            domain.metaClass.static.deleteById = {def id ->
                executeUpdate("delete from ${domain.name} where id = :id", [id:id])
            }
        }

    }
}
