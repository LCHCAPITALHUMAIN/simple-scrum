

package com.simplescrum.model

class ReleaseController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ releaseInstanceList: Release.list( params ), releaseInstanceTotal: Release.count() ]
    }

    def show = {
        def releaseInstance = Release.get( params.id )

        if(!releaseInstance) {
            flash.message = "Release not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ releaseInstance : releaseInstance ] }
    }

    def delete = {
        def releaseInstance = Release.get( params.id )
        if(releaseInstance) {
            try {
                releaseInstance.delete(flush:true)
                flash.message = "Release ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Release ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Release not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def releaseInstance = Release.get( params.id )

        if(!releaseInstance) {
            flash.message = "Release not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ releaseInstance : releaseInstance ]
        }
    }

    def update = {
        def releaseInstance = Release.get( params.id )
        if(releaseInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(releaseInstance.version > version) {
                    
                    releaseInstance.errors.rejectValue("version", "release.optimistic.locking.failure", "Another user has updated this Release while you were editing.")
                    render(view:'edit',model:[releaseInstance:releaseInstance])
                    return
                }
            }
            releaseInstance.properties = params
            if(!releaseInstance.hasErrors() && releaseInstance.save()) {
                flash.message = "Release ${params.id} updated"
                redirect(action:show,id:releaseInstance.id)
            }
            else {
                render(view:'edit',model:[releaseInstance:releaseInstance])
            }
        }
        else {
            flash.message = "Release not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def releaseInstance = new Release()
        releaseInstance.properties = params
        return ['releaseInstance':releaseInstance]
    }

    def save = {
        def releaseInstance = new Release(params)
        if(!releaseInstance.hasErrors() && releaseInstance.save()) {
            flash.message = "Release ${releaseInstance.id} created"
            redirect(action:show,id:releaseInstance.id)
        }
        else {
            render(view:'create',model:[releaseInstance:releaseInstance])
        }
    }
}
