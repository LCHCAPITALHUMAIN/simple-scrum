

package com.simplescrum.model

class ProblemController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ problemInstanceList: Problem.list( params ), problemInstanceTotal: Problem.count() ]
    }

    def show = {
        def problemInstance = Problem.get( params.id )

        if(!problemInstance) {
            flash.message = "Problem not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ problemInstance : problemInstance ] }
    }

    def delete = {
        def problemInstance = Problem.get( params.id )
        if(problemInstance) {
            try {
                problemInstance.delete(flush:true)
                flash.message = "Problem ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Problem ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Problem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def problemInstance = Problem.get( params.id )

        if(!problemInstance) {
            flash.message = "Problem not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ problemInstance : problemInstance ]
        }
    }

    def update = {
        def problemInstance = Problem.get( params.id )
        if(problemInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(problemInstance.version > version) {
                    
                    problemInstance.errors.rejectValue("version", "problem.optimistic.locking.failure", "Another user has updated this Problem while you were editing.")
                    render(view:'edit',model:[problemInstance:problemInstance])
                    return
                }
            }
            problemInstance.properties = params
            if(!problemInstance.hasErrors() && problemInstance.save()) {
                flash.message = "Problem ${params.id} updated"
                redirect(action:show,id:problemInstance.id)
            }
            else {
                render(view:'edit',model:[problemInstance:problemInstance])
            }
        }
        else {
            flash.message = "Problem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def problemInstance = new Problem()
        problemInstance.properties = params
        return ['problemInstance':problemInstance]
    }

    def save = {
        def problemInstance = new Problem(params)
        if(!problemInstance.hasErrors() && problemInstance.save()) {
            flash.message = "Problem ${problemInstance.id} created"
            redirect(action:show,id:problemInstance.id)
        }
        else {
            render(view:'create',model:[problemInstance:problemInstance])
        }
    }
}
