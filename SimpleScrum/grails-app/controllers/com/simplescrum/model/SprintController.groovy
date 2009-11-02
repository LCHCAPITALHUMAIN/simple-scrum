

package com.simplescrum.model

class SprintController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ sprintInstanceList: Sprint.list( params ), sprintInstanceTotal: Sprint.count() ]
    }

    def show = {
        def sprintInstance = Sprint.get( params.id )

        if(!sprintInstance) {
            flash.message = "Sprint not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ sprintInstance : sprintInstance ] }
    }

    def delete = {
        def sprintInstance = Sprint.get( params.id )
        if(sprintInstance) {
            try {
                sprintInstance.delete(flush:true)
                flash.message = "Sprint ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Sprint ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Sprint not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def sprintInstance = Sprint.get( params.id )

        if(!sprintInstance) {
            flash.message = "Sprint not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ sprintInstance : sprintInstance ]
        }
    }

    def update = {
        def sprintInstance = Sprint.get( params.id )
        if(sprintInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(sprintInstance.version > version) {
                    
                    sprintInstance.errors.rejectValue("version", "sprint.optimistic.locking.failure", "Another user has updated this Sprint while you were editing.")
                    render(view:'edit',model:[sprintInstance:sprintInstance])
                    return
                }
            }
            sprintInstance.properties = params
            if(!sprintInstance.hasErrors() && sprintInstance.save()) {
                flash.message = "Sprint ${params.id} updated"
                redirect(action:show,id:sprintInstance.id)
            }
            else {
                render(view:'edit',model:[sprintInstance:sprintInstance])
            }
        }
        else {
            flash.message = "Sprint not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def sprintInstance = new Sprint()
        sprintInstance.properties = params
        return ['sprintInstance':sprintInstance]
    }

    def save = {
        def sprintInstance = new Sprint(params)
        if(!sprintInstance.hasErrors() && sprintInstance.save()) {
            flash.message = "Sprint ${sprintInstance.id} created"
            redirect(action:show,id:sprintInstance.id)
        }
        else {
            render(view:'create',model:[sprintInstance:sprintInstance])
        }
    }
}
