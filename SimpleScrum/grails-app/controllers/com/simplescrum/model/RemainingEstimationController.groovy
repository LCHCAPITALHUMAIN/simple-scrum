

package com.simplescrum.model

class RemainingEstimationController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ remainingEstimationInstanceList: RemainingEstimation.list( params ), remainingEstimationInstanceTotal: RemainingEstimation.count() ]
    }

    def show = {
        def remainingEstimationInstance = RemainingEstimation.get( params.id )

        if(!remainingEstimationInstance) {
            flash.message = "RemainingEstimation not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ remainingEstimationInstance : remainingEstimationInstance ] }
    }

    def delete = {
        def remainingEstimationInstance = RemainingEstimation.get( params.id )
        if(remainingEstimationInstance) {
            try {
                remainingEstimationInstance.delete(flush:true)
                flash.message = "RemainingEstimation ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "RemainingEstimation ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "RemainingEstimation not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def remainingEstimationInstance = RemainingEstimation.get( params.id )

        if(!remainingEstimationInstance) {
            flash.message = "RemainingEstimation not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ remainingEstimationInstance : remainingEstimationInstance ]
        }
    }

    def update = {
        def remainingEstimationInstance = RemainingEstimation.get( params.id )
        if(remainingEstimationInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(remainingEstimationInstance.version > version) {
                    
                    remainingEstimationInstance.errors.rejectValue("version", "remainingEstimation.optimistic.locking.failure", "Another user has updated this RemainingEstimation while you were editing.")
                    render(view:'edit',model:[remainingEstimationInstance:remainingEstimationInstance])
                    return
                }
            }
            remainingEstimationInstance.properties = params
            if(!remainingEstimationInstance.hasErrors() && remainingEstimationInstance.save()) {
                flash.message = "RemainingEstimation ${params.id} updated"
                redirect(action:show,id:remainingEstimationInstance.id)
            }
            else {
                render(view:'edit',model:[remainingEstimationInstance:remainingEstimationInstance])
            }
        }
        else {
            flash.message = "RemainingEstimation not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def remainingEstimationInstance = new RemainingEstimation()
        remainingEstimationInstance.properties = params
        return ['remainingEstimationInstance':remainingEstimationInstance]
    }

    def save = {
        def remainingEstimationInstance = new RemainingEstimation(params)
        if(!remainingEstimationInstance.hasErrors() && remainingEstimationInstance.save()) {
            flash.message = "RemainingEstimation ${remainingEstimationInstance.id} created"
            redirect(action:show,id:remainingEstimationInstance.id)
        }
        else {
            render(view:'create',model:[remainingEstimationInstance:remainingEstimationInstance])
        }
    }
}
