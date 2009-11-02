

package com.simplescrum.model

class ProductBacklogItemController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ productBacklogItemInstanceList: ProductBacklogItem.list( params ), productBacklogItemInstanceTotal: ProductBacklogItem.count() ]
    }

    def show = {
        def productBacklogItemInstance = ProductBacklogItem.get( params.id )

        if(!productBacklogItemInstance) {
            flash.message = "ProductBacklogItem not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ productBacklogItemInstance : productBacklogItemInstance ] }
    }

    def delete = {
        def productBacklogItemInstance = ProductBacklogItem.get( params.id )
        if(productBacklogItemInstance) {
            try {
                productBacklogItemInstance.delete(flush:true)
                flash.message = "ProductBacklogItem ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "ProductBacklogItem ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "ProductBacklogItem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def productBacklogItemInstance = ProductBacklogItem.get( params.id )

        if(!productBacklogItemInstance) {
            flash.message = "ProductBacklogItem not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ productBacklogItemInstance : productBacklogItemInstance ]
        }
    }

    def update = {
        def productBacklogItemInstance = ProductBacklogItem.get( params.id )
        if(productBacklogItemInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(productBacklogItemInstance.version > version) {
                    
                    productBacklogItemInstance.errors.rejectValue("version", "productBacklogItem.optimistic.locking.failure", "Another user has updated this ProductBacklogItem while you were editing.")
                    render(view:'edit',model:[productBacklogItemInstance:productBacklogItemInstance])
                    return
                }
            }
            productBacklogItemInstance.properties = params
            if(!productBacklogItemInstance.hasErrors() && productBacklogItemInstance.save()) {
                flash.message = "ProductBacklogItem ${params.id} updated"
                redirect(action:show,id:productBacklogItemInstance.id)
            }
            else {
                render(view:'edit',model:[productBacklogItemInstance:productBacklogItemInstance])
            }
        }
        else {
            flash.message = "ProductBacklogItem not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def productBacklogItemInstance = new ProductBacklogItem()
        productBacklogItemInstance.properties = params
        return ['productBacklogItemInstance':productBacklogItemInstance]
    }

    def save = {
        def productBacklogItemInstance = new ProductBacklogItem(params)
        if(!productBacklogItemInstance.hasErrors() && productBacklogItemInstance.save()) {
            flash.message = "ProductBacklogItem ${productBacklogItemInstance.id} created"
            redirect(action:show,id:productBacklogItemInstance.id)
        }
        else {
            render(view:'create',model:[productBacklogItemInstance:productBacklogItemInstance])
        }
    }
}
