

package com.simplescrum.model

class BudgetLineController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ budgetLineInstanceList: BudgetLine.list( params ), budgetLineInstanceTotal: BudgetLine.count() ]
    }

    def show = {
        def budgetLineInstance = BudgetLine.get( params.id )

        if(!budgetLineInstance) {
            flash.message = "BudgetLine not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ budgetLineInstance : budgetLineInstance ] }
    }

    def delete = {
        def budgetLineInstance = BudgetLine.get( params.id )
        if(budgetLineInstance) {
            try {
                budgetLineInstance.delete(flush:true)
                flash.message = "BudgetLine ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "BudgetLine ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "BudgetLine not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def budgetLineInstance = BudgetLine.get( params.id )

        if(!budgetLineInstance) {
            flash.message = "BudgetLine not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ budgetLineInstance : budgetLineInstance ]
        }
    }

    def update = {
        def budgetLineInstance = BudgetLine.get( params.id )
        if(budgetLineInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(budgetLineInstance.version > version) {
                    
                    budgetLineInstance.errors.rejectValue("version", "budgetLine.optimistic.locking.failure", "Another user has updated this BudgetLine while you were editing.")
                    render(view:'edit',model:[budgetLineInstance:budgetLineInstance])
                    return
                }
            }
            budgetLineInstance.properties = params
            if(!budgetLineInstance.hasErrors() && budgetLineInstance.save()) {
                flash.message = "BudgetLine ${params.id} updated"
                redirect(action:show,id:budgetLineInstance.id)
            }
            else {
                render(view:'edit',model:[budgetLineInstance:budgetLineInstance])
            }
        }
        else {
            flash.message = "BudgetLine not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def budgetLineInstance = new BudgetLine()
        budgetLineInstance.properties = params
        return ['budgetLineInstance':budgetLineInstance]
    }

    def save = {
        def budgetLineInstance = new BudgetLine(params)
        if(!budgetLineInstance.hasErrors() && budgetLineInstance.save()) {
            flash.message = "BudgetLine ${budgetLineInstance.id} created"
            redirect(action:show,id:budgetLineInstance.id)
        }
        else {
            render(view:'create',model:[budgetLineInstance:budgetLineInstance])
        }
    }
}
