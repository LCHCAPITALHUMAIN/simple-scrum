

package com.simplescrum.model

class TaskActualController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ taskActualInstanceList: TaskActual.list( params ), taskActualInstanceTotal: TaskActual.count() ]
    }

    def show = {
        def taskActualInstance = TaskActual.get( params.id )

        if(!taskActualInstance) {
            flash.message = "TaskActual not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ taskActualInstance : taskActualInstance ] }
    }

    def delete = {
        def taskActualInstance = TaskActual.get( params.id )
        if(taskActualInstance) {
            try {
                taskActualInstance.delete(flush:true)
                flash.message = "TaskActual ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "TaskActual ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "TaskActual not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def taskActualInstance = TaskActual.get( params.id )

        if(!taskActualInstance) {
            flash.message = "TaskActual not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ taskActualInstance : taskActualInstance ]
        }
    }

    def update = {
        def taskActualInstance = TaskActual.get( params.id )
        if(taskActualInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(taskActualInstance.version > version) {
                    
                    taskActualInstance.errors.rejectValue("version", "taskActual.optimistic.locking.failure", "Another user has updated this TaskActual while you were editing.")
                    render(view:'edit',model:[taskActualInstance:taskActualInstance])
                    return
                }
            }
            taskActualInstance.properties = params
            if(!taskActualInstance.hasErrors() && taskActualInstance.save()) {
                flash.message = "TaskActual ${params.id} updated"
                redirect(action:show,id:taskActualInstance.id)
            }
            else {
                render(view:'edit',model:[taskActualInstance:taskActualInstance])
            }
        }
        else {
            flash.message = "TaskActual not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def taskActualInstance = new TaskActual()
        taskActualInstance.properties = params
        return ['taskActualInstance':taskActualInstance]
    }

    def save = {
        def taskActualInstance = new TaskActual(params)
        if(!taskActualInstance.hasErrors() && taskActualInstance.save()) {
            flash.message = "TaskActual ${taskActualInstance.id} created"
            redirect(action:show,id:taskActualInstance.id)
        }
        else {
            render(view:'create',model:[taskActualInstance:taskActualInstance])
        }
    }
}
