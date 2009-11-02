

package com.simplescrum.model

class FeatureController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ featureInstanceList: Feature.list( params ), featureInstanceTotal: Feature.count() ]
    }

    def show = {
        def featureInstance = Feature.get( params.id )

        if(!featureInstance) {
            flash.message = "Feature not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ featureInstance : featureInstance ] }
    }

    def delete = {
        def featureInstance = Feature.get( params.id )
        if(featureInstance) {
            try {
                featureInstance.delete(flush:true)
                flash.message = "Feature ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Feature ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Feature not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def featureInstance = Feature.get( params.id )

        if(!featureInstance) {
            flash.message = "Feature not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ featureInstance : featureInstance ]
        }
    }

    def update = {
        def featureInstance = Feature.get( params.id )
        if(featureInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(featureInstance.version > version) {
                    
                    featureInstance.errors.rejectValue("version", "feature.optimistic.locking.failure", "Another user has updated this Feature while you were editing.")
                    render(view:'edit',model:[featureInstance:featureInstance])
                    return
                }
            }
            featureInstance.properties = params
            if(!featureInstance.hasErrors() && featureInstance.save()) {
                flash.message = "Feature ${params.id} updated"
                redirect(action:show,id:featureInstance.id)
            }
            else {
                render(view:'edit',model:[featureInstance:featureInstance])
            }
        }
        else {
            flash.message = "Feature not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def featureInstance = new Feature()
        featureInstance.properties = params
        return ['featureInstance':featureInstance]
    }

    def save = {
        def featureInstance = new Feature(params)
        if(!featureInstance.hasErrors() && featureInstance.save()) {
            flash.message = "Feature ${featureInstance.id} created"
            redirect(action:show,id:featureInstance.id)
        }
        else {
            render(view:'create',model:[featureInstance:featureInstance])
        }
    }
}
