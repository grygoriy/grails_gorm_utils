grails_gorm_utils
=================

Plugin collects methods and technics for work with GORM

##Dependencies
Plugin depends on
* [hibernate plugin] (http://grails.org/plugin/hibernate)

##Delete domain entity by its id whithout loading this entity
All domain classes can use static method `deleteById(id)` whitch executes HQL that will delete entity without loading.